package com.xzj.jpa.test;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xzj.jpa.entity.Clazz;
import com.xzj.jpa.entity.Student;

public class JpaTest {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	@Before
	public void init() {
		/**
		 * 通过Persistence获取EntityManagerFactory， 传入参数对应配置文件中持久化单元persistence-unit的name
		 * 通过EntityManagerFactory创建EntityManager 获取EntityTransaction 开启事务
		 */
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
	}

	@After
	public void distory() {
		/**
		 * 提交事务 关闭entityManager 关闭entityManagerFactory
		 */
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void test() {

	}

	/**
	 * 添加操作 在设置学生班级的时候这个班级必须是被jpa管理的持久化对象才能被设置成功 需要先保存班级再保存学生
	 */
	@Test
	public void testAdd() {
		Clazz clz1 = new Clazz();
		clz1.setName("计科1605");
		clz1.setDate(new Date());

		Student stu1 = new Student();
		stu1.setName("mary");
		stu1.setTel("18866005544");
		stu1.setDate(new Date());
		stu1.setClazz(clz1);

		entityManager.persist(clz1);
		entityManager.persist(stu1);
	}

	/**
	 * 被删除的对象也必须是被jpa管理的持久化对象
	 */
	@Test
	public void testDeleteStu() {
		Student stu = entityManager.find(Student.class, 3);
		entityManager.remove(stu);
	}

	@Test
	public void testDeleteClz() {
		Clazz clz = entityManager.find(Clazz.class, 4);
		Set<Student> stus = clz.getStus();
		stus.forEach((stu) -> stu.setClazz(null));
		entityManager.remove(clz);
	}

	@Test
	public void testM() {
		Clazz clz = entityManager.find(Clazz.class, 5);

		Student student = new Student();
		student.setId(5);
		student.setName("徐植君");
		student.setDate(new Date());
		student.setTel("1885656565");
		student.setClazz(clz);
		entityManager.merge(student);
	}

	@Test
	public void testChange() {
		Clazz clz = entityManager.find(Clazz.class, 5);
		Student student = entityManager.find(Student.class, 4);
		student.setClazz(clz);
	}

	@Test
	public void testQuery() {
		Clazz clazz = entityManager.find(Clazz.class, 5);
		Set<Student> stus = clazz.getStus();
		System.out.println(stus);
	}

	@Test
	public void testJpql() {
		String sql = "select c from Clazz c";
		Query query = entityManager.createQuery(sql);
		List res = query.getResultList();
		System.out.println("条数：" + res.size());
	}

	@Test
	public void testDQuery() {
		// 用来构建查询条件
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// 合成最终的查询语句
		CriteriaQuery<Clazz> query = cb.createQuery(Clazz.class);
		// 通过Root可以获取当前被查询的实体类中的属性，在和CriteriaBuilder创建查询条件
		Root<Clazz> root = query.from(Clazz.class);
		// 通过CriteriaBuilder构建的一个等于的查询条件
		Predicate predicate = cb.equal(root.get("id"), 5);
		// where接收的是一个可变参数，合成所有的查询条件
		query.where(predicate);
		// 传入CriteriaQuery，查询结果
		Clazz clz = entityManager.createQuery(query).getSingleResult();

		System.out.println(clz.getName());
	}
}

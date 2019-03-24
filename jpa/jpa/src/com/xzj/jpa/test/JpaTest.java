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
		 * ͨ��Persistence��ȡEntityManagerFactory�� ���������Ӧ�����ļ��г־û���Ԫpersistence-unit��name
		 * ͨ��EntityManagerFactory����EntityManager ��ȡEntityTransaction ��������
		 */
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
	}

	@After
	public void distory() {
		/**
		 * �ύ���� �ر�entityManager �ر�entityManagerFactory
		 */
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void test() {

	}

	/**
	 * ��Ӳ��� ������ѧ���༶��ʱ������༶�����Ǳ�jpa����ĳ־û�������ܱ����óɹ� ��Ҫ�ȱ���༶�ٱ���ѧ��
	 */
	@Test
	public void testAdd() {
		Clazz clz1 = new Clazz();
		clz1.setName("�ƿ�1605");
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
	 * ��ɾ���Ķ���Ҳ�����Ǳ�jpa����ĳ־û�����
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
		student.setName("��ֲ��");
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
		System.out.println("������" + res.size());
	}

	@Test
	public void testDQuery() {
		// ����������ѯ����
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// �ϳ����յĲ�ѯ���
		CriteriaQuery<Clazz> query = cb.createQuery(Clazz.class);
		// ͨ��Root���Ի�ȡ��ǰ����ѯ��ʵ�����е����ԣ��ں�CriteriaBuilder������ѯ����
		Root<Clazz> root = query.from(Clazz.class);
		// ͨ��CriteriaBuilder������һ�����ڵĲ�ѯ����
		Predicate predicate = cb.equal(root.get("id"), 5);
		// where���յ���һ���ɱ�������ϳ����еĲ�ѯ����
		query.where(predicate);
		// ����CriteriaQuery����ѯ���
		Clazz clz = entityManager.createQuery(query).getSingleResult();

		System.out.println(clz.getName());
	}
}

package com.xzj.jpa.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 学生的实体类
 * @author xuzhijun.online
 * 常用注解解释：
 * @Entity 用来标示这个类是实体类
 * @Table  实体类与数据表的映射，通过name确定在表名（默认类名为表名）
 * @Id         主键注解，表示该字段为主键
 * @GeneratedValue 定义主键规则，默认AUTO
 * @Column 类属性与表字段映射注解，其中可以设置在字段名，长度等信息
 * @ManyToOne  多对一，可以设置数据加载方式等 默认加载方式是EAGER 就是使用left join
 * @OneToMany  一对多 默认加载方式是 LAZY 懒加载
 * @JoinColumn 与*对*配合使用，用来设置外键名等信息
 * @Basic  实体类中会默认为每一个属性加上这个注解，表示与数据表存在关联，
 *              没有使用Column注解的类属性会以属性名作为字段名，驼峰命名需要转为_
 * @Temporal 对于Date属性的格式化注解，有 TIME，DATE，TIMESTAMP 几个选择
 * @Transient 若存在不想与数据表映射的属性，则需要加上该注解
 */
@Entity
@Table(name = "t_student")
public class Student {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    private String  tel;
    private Date    date;
    
    @JoinColumn(name = "clz_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Clazz clazz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
    
}
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
 * ѧ����ʵ����
 * @author xuzhijun.online
 * ����ע����ͣ�
 * @Entity ������ʾ�������ʵ����
 * @Table  ʵ���������ݱ��ӳ�䣬ͨ��nameȷ���ڱ�����Ĭ������Ϊ������
 * @Id         ����ע�⣬��ʾ���ֶ�Ϊ����
 * @GeneratedValue ������������Ĭ��AUTO
 * @Column ����������ֶ�ӳ��ע�⣬���п����������ֶ��������ȵ���Ϣ
 * @ManyToOne  ���һ�������������ݼ��ط�ʽ�� Ĭ�ϼ��ط�ʽ��EAGER ����ʹ��left join
 * @OneToMany  һ�Զ� Ĭ�ϼ��ط�ʽ�� LAZY ������
 * @JoinColumn ��*��*���ʹ�ã������������������Ϣ
 * @Basic  ʵ�����л�Ĭ��Ϊÿһ�����Լ������ע�⣬��ʾ�����ݱ���ڹ�����
 *              û��ʹ��Columnע��������Ի�����������Ϊ�ֶ������շ�������ҪתΪ_
 * @Temporal ����Date���Եĸ�ʽ��ע�⣬�� TIME��DATE��TIMESTAMP ����ѡ��
 * @Transient �����ڲ��������ݱ�ӳ������ԣ�����Ҫ���ϸ�ע��
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
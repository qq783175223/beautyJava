package com.xzj.field;

import java.util.Date;

/**
 *
 * @author xuzhijun.online
 * @author 2019年4月23日
 *
 */

public class Student {
	private Long id;
	private String name;
	private Date createdate;
	private String no;
	public String nickname;

	public Long getId() {
		return id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public Date getCreatedate() {
		return createdate;
	}

//	public void setCreatedate(Date createdate) {
//		this.createdate = createdate;
//	}

	public String getNo() {
		return no;
	}

//	public void setNo(String no) {
//		this.no = no;
//	}

	public String getNickname() {
		return nickname;
	}

//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name;
		}

}
package com.tm.system.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "t_user")
public class User implements Serializable {
	private static final long serialVersionUID = -4852732617765810959L;
	/**
	 * 账户状态
	 */
	public static final String STATUS_VALID = "1";

	public static final String STATUS_LOCK = "0";

	public static final String DEFAULT_THEME = "green";

	public static final String DEFAULT_AVATAR = "default.jpg";

	/**
	 * 性别
	 */
	public static final String SEX_MALE = "0";

	public static final String SEX_FEMALE = "1";

	public static final String SEX_UNKNOW = "2";

	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "DEPT_ID")
	private Long deptId;

	@Transient
	private String deptName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "STATUS")
	private String status = STATUS_VALID;

	@Column(name = "CRATE_TIME")
	private Date crateTime;

	@Transient
	private String roleName;
}

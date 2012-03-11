package entities;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID=-7690120389175426L;
	/**
	 * 账户名,在系统中要求账户名必须以英文大小写字母开头，
	 * 只能包含英文字母和数字字符。账户名是唯一标示字段。
	 */
	private String name;
	/**
	 * 密码，密码只能是英文大小写字母和数字字符组成，
	 * 密码最少4个字符，最多128个字符。
	 */
	private String password;
	/**
	 * 用户的电子邮件地址，该地址中必须包含‘@’符号，
	 * 并且‘@’符号不能为开头或结尾字符。
	 * 电子邮件地址在系统中唯一，不重复。
	 */
	private String email;
	/**
	 * 用户在系统中的积分，注册成功后默认送100积分，
	 * 每成功登录一次，赠送5个积分。
	 */
	private int score;
	
	
	public User() {
		super();
	}

	public User(String name, String passwrod, String email, int score) {
		super();
		this.name = name;
		this.password = passwrod;
		this.email = email;
		this.score = score;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswrod() {
		return password;
	}

	public void setPasswrod(String passwrod) {
		this.password = passwrod;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}

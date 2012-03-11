package entities;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID=-7690120389175426L;
	/**
	 * �˻���,��ϵͳ��Ҫ���˻���������Ӣ�Ĵ�Сд��ĸ��ͷ��
	 * ֻ�ܰ���Ӣ����ĸ�������ַ����˻�����Ψһ��ʾ�ֶΡ�
	 */
	private String name;
	/**
	 * ���룬����ֻ����Ӣ�Ĵ�Сд��ĸ�������ַ���ɣ�
	 * ��������4���ַ������128���ַ���
	 */
	private String password;
	/**
	 * �û��ĵ����ʼ���ַ���õ�ַ�б��������@�����ţ�
	 * ���ҡ�@�����Ų���Ϊ��ͷ���β�ַ���
	 * �����ʼ���ַ��ϵͳ��Ψһ�����ظ���
	 */
	private String email;
	/**
	 * �û���ϵͳ�еĻ��֣�ע��ɹ���Ĭ����100���֣�
	 * ÿ�ɹ���¼һ�Σ�����5�����֡�
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

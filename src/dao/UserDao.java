package dao;
import entities.User;

public interface UserDao {
	/**
	 * ���ݸ������˻��������룬��ѯ�û���
	 * @param name �˻���
	 * @param password ����
	 * @return �����ڸ��˻��򷵻سɹ���ѯ�����û������򷵻�null
	 */
	public User getUser(String name,String password);
	
	/**
	 * ��ָ�����û�������ӵ��ײ����ݴ洢�ṹ�С�
	 * @param user ����ӵ��û�����
	 * @return ��ӳɹ�����״̬��
	 *    0--��ӳɹ�
	 *    1--���ʧ�ܣ��˻����ظ�
	 *    2--���ʧ�ܣ�email�ظ�
	 *    3--���ʧ�ܣ�ϵͳ�����쳣
	 */
	public int addUser(User user);
}

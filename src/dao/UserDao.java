package dao;
import entities.User;

public interface UserDao {
	/**
	 * 根据给定的账户名和密码，查询用户。
	 * @param name 账户名
	 * @param password 密码
	 * @return 若存在该账户则返回成功查询出的用户，否则返回null
	 */
	public User getUser(String name,String password);
	
	/**
	 * 将指定的用户对象添加到底层数据存储结构中。
	 * @param user 待添加的用户对象
	 * @return 添加成功与否的状态。
	 *    0--添加成功
	 *    1--添加失败，账户名重复
	 *    2--添加失败，email重复
	 *    3--添加失败，系统访问异常
	 */
	public int addUser(User user);
}

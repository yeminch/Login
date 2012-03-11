package server;

import dao.UserDao;
import dao.UserDaoImplA;
import entities.Request;
import entities.Response;
import entities.User;

public class Controller {
	UserDao dao;// 定义用户接口

	public Controller() {
		dao = new UserDaoImplA();
	}

	public Response login(Request req) {
		String name=(String)req.getParameter("userName");
		String passwd=(String)req.getParameter("userPasswd");
		
		User u = dao.getUser(name, passwd);

		Response res = new Response(Response.LOGIN_RES);
		res.addParameter("back", u);
		return res;
	}

	public Response registe(Request req) {
		User u = (User) req.getParameter("newUser");
		int i = dao.addUser(u);
		
		Response res=new Response(Response.REGISTE_RES);
		res.addParameter("result",i);
		return res;
	}
}

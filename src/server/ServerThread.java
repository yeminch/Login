package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import entities.Request;
import entities.Response;

public class ServerThread extends Thread{
	private Socket s;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Controller con;
	
	public ServerThread(Socket s){
		con=new Controller();//生成一个新的控制器处理请求和回复问题
		this.s=s;
		try {
			ois=new ObjectInputStream(s.getInputStream());
			oos=new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		Request req=null;
		try {
			//可以把两种请求合并一起写
			
			req=(Request)ois.readObject();//服务器一直在读数据
			
			if(req.getType()==Request.LOGIN_REQ){//处理登陆请求
				Response res=con.login(req);//代码移到专门的执行器里面去执行
				oos.writeObject(res);//服务器把数据发回客户端
				oos.flush();
			}else if (req.getType()==Request.REGISTE_REQ){//处理注册请求
				Response res=con.registe(req);
				oos.writeObject(res);
				oos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

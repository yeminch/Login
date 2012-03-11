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
		con=new Controller();//����һ���µĿ�������������ͻظ�����
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
			//���԰���������ϲ�һ��д
			
			req=(Request)ois.readObject();//������һֱ�ڶ�����
			
			if(req.getType()==Request.LOGIN_REQ){//�����½����
				Response res=con.login(req);//�����Ƶ�ר�ŵ�ִ��������ȥִ��
				oos.writeObject(res);//�����������ݷ��ؿͻ���
				oos.flush();
			}else if (req.getType()==Request.REGISTE_REQ){//����ע������
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

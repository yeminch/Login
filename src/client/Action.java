package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import entities.Request;
import entities.Response;

public class Action {
	Socket s;
	
	public Response doAction(Request req) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Response res = null;
			try {
				s = new Socket("127.0.0.1",12345);
				//�Ȱ����ݷ���ȥ�����������
				oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(req);
				oos.flush();
				
				//������������Ϣ
				ois = new ObjectInputStream(s.getInputStream());
				res = (Response) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally{
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
		return res;
	}

}

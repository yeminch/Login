package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveServer {
	ServerSocket ss;

	public ReceiveServer() {
		try {
			//����һ��ServerSocket
			ss = new ServerSocket(12345);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startServer() {
		Socket s;
		while (true) {
			try {
				s = ss.accept();
				System.out.println("----------------�Ѿ���������--------------");
				new ServerThread(s).start();//���뵽���߳������N���ͻ�����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ReceiveServer().startServer();
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.Action;
import dao.UserDaoImplA;
import entities.Request;
import entities.Response;
import entities.User;

public class LoginFrame {
	// ����Ϊ�ͻ��˵ĵ�¼ͼ�λ����棭������������������������������������������������������
	private JFrame frame;
	private JLabel title;
	private JLabel label1, label2;
	private JTextField jtf;
	private JPasswordField jpf;
	private JButton button1, button2, button3;
	private Action action;

	public LoginFrame() {
		action=new Action();
		frame = new JFrame("�û���¼");
		title = new JLabel("�û���¼");
		title.setFont(new Font("����", Font.BOLD, 24));
		title.setForeground(Color.BLUE);

		label1 = new JLabel("�˺ţ�");
		label2 = new JLabel("���룺");
		jtf = new JTextField(20);
		jpf = new JPasswordField(20);
		button1 = new JButton("��¼");
		button2 = new JButton("ȡ��");
		button3 = new JButton("ע�����û�");

		init();
		addEventHandler();
	}

	private void init() {
		JPanel n_panel = new JPanel();
		n_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		n_panel.add(title);
		
		JPanel c_panel = new JPanel();
		c_panel.setLayout(new FlowLayout());
		c_panel.add(label1);
		c_panel.add(jtf);
		c_panel.add(label2);
		c_panel.add(jpf);

		JPanel s_panel = new JPanel();
		s_panel.setLayout(new FlowLayout());
		s_panel.add(button1);
		s_panel.add(button2);
		s_panel.add(button3);

		frame.setLayout(new BorderLayout(30, 30));
		frame.add(n_panel, BorderLayout.NORTH);
		frame.add(c_panel, BorderLayout.CENTER);
		frame.add(s_panel, BorderLayout.SOUTH);
	}

	public void showMe() {
		frame.setSize(300, 250);
		frame.setLocation(400, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ��ť����-------------------------------------------------------------------------
	private void addEventHandler() {
		button1.addActionListener(new ActionListener() {// ��½
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		button2.addActionListener(new ActionListener() {// ȡ��
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		button3.addActionListener(new ActionListener() {// ע�����û�
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new RegisteFrame().showMe();
			}
		});
	}

	public void login() {
		if(jtf.getText().equals("") || jpf.getText().equals("")){
			JOptionPane.showMessageDialog(frame,"ID �����벻��Ϊ�գ�");
			return;
		}
		String name=jtf.getText();
//		String passwd=jpf.getText();
		String passwd=new String(jpf.getPassword());
		
	    //��װ��һ���������
		Request req=new Request(Request.LOGIN_REQ);
		req.addParameter("userName",name);
		req.addParameter("userPasswd",passwd);
//		User u=new User();
//		u.setName(name);
//		u.setPasswrod(passwd);
//		req.addParameter("user",u);
		
		//�ӷ������û�����
		Response res=action.doAction(req);//����������󣬵ȴ��ظ�
		User u=(User)res.getParameter("back");
		
		if(u==null){
			JOptionPane.showMessageDialog(frame,"�˻����������");
		}else{
			new MainFrame(u).showMe();
			frame.dispose();
		}
		
//		System.out.println(res.getParameter("c"));
	}
	

	public static void main(String[] args) {
		new LoginFrame().showMe();
	}

}
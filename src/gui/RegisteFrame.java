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
import entities.Request;
import entities.Response;
import entities.User;

public class RegisteFrame implements ActionListener {
	private JFrame frame;
	private JLabel title;
	private JLabel label1, label2, label3, label4;
	private JTextField jtf1, jtf2;
	private JPasswordField jpf1, jpf2;
	private JButton button1, button2;
	private Action action;

	public RegisteFrame() {
		action = new Action();
		frame = new JFrame("�û�ע��");
		title = new JLabel("ע�����û�");
		title.setFont(new Font("����", Font.BOLD, 24));
		title.setForeground(Color.BLUE);

		label1 = new JLabel("        �˺ţ�");
		label2 = new JLabel("        ���룺");
		label3 = new JLabel("ȷ�����룺");
		label4 = new JLabel("       Email��");

		jtf1 = new JTextField(20);
		jtf2 = new JTextField(20);

		jpf1 = new JPasswordField(20);
		jpf2 = new JPasswordField(20);

		button1 = new JButton("ע��");
		button2 = new JButton("ȡ��");

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
		c_panel.add(jtf1);
		c_panel.add(label2);
		c_panel.add(jpf1);
		c_panel.add(label3);
		c_panel.add(jpf2);
		c_panel.add(label4);
		c_panel.add(jtf2);

		JPanel s_panel = new JPanel();
		s_panel.setLayout(new FlowLayout());
		s_panel.add(button1);
		s_panel.add(button2);

		frame.setLayout(new BorderLayout(30, 30));
		frame.add(n_panel, BorderLayout.NORTH);
		frame.add(c_panel, BorderLayout.CENTER);
		frame.add(s_panel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();// ����Ϊ���м��
		if (str.equals("ע��")) {
			registe();
		} else if (str.equals("ȡ��")) {
			System.exit(0);
		}
	}

	private void addEventHandler() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	private void registe() {
		String name = jtf1.getText();// �˻�
		String passwd = jpf1.getText();// ����
		String passwdTwo = new String(jpf2.getPassword());
		String email = jtf2.getText();// email

		if (name.equals("")|| passwd.equals("")|| email.equals("")) {
			JOptionPane.showMessageDialog(frame, "��д����Ϣ������");
		} else {
			if (!passwd.equals(passwdTwo)) {
				JOptionPane.showMessageDialog(frame, "�������벻һ��");
				jpf1.setText("");
				jpf2.setText("");
			} else {
				User u = new User(name, passwd, email, 100);
				Request req = new Request(Request.REGISTE_REQ);
				req.addParameter("newUser", u);

				Response res = action.doAction(req);
				Integer i = (Integer) res.getParameter("result");
				if (i == 0) {
					new LoginFrame().showMe();
					frame.dispose();
				} else if (i == 1) {
					JOptionPane.showMessageDialog(frame, "�û����ظ�");
					jtf1.setText("");
				} else if (i == 2) {
					JOptionPane.showMessageDialog(frame, "�����ظ�");
					jtf2.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "ϵͳ����");
				}
			}
		}
	}

	public void showMe() {
		frame.setSize(315, 280);
		frame.setLocation(400, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new RegisteFrame().showMe();
	}

}

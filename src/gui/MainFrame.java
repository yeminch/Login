package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import entities.User;

public class MainFrame {
		private JFrame frame;
		private JLabel content;
		private User currentUser;
		
		
		public MainFrame(User user){
			this.currentUser=user;
			frame=new JFrame("主界面");
			content=new JLabel(user.getName()+"，欢迎登录，您当前的积分是："+user.getScore());
			frame.add(content,BorderLayout.CENTER);
		}
		
		public void showMe(){
			frame.setSize(800,600);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		public User getCurrentUser() {
			return currentUser;
		}

		public void setCurrentUser(User currentUser) {
			this.currentUser = currentUser;
		}

	}



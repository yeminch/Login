package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;

import entities.User;

public class UserDaoImplA implements UserDao {


	public UserDaoImplA() {
	}

	public int addUser(User user) {// 增加用户
		FileInputStream fis=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		try {
			fis=new FileInputStream("user.txt");
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			
			String str=null;
			while((str=br.readLine())!=null){
				String s[]=str.split(":");
				if(s[0].equals(user.getName())){
					return 1;
				}if(s[2].equals(user.getEmail())){
					return 2;
				}
			}
			fw=new FileWriter("user.txt",true);
			bw=new BufferedWriter(fw);
			String s=user.getName()+":"+user.getPasswrod()+":"+user.getEmail()+":"+user.getScore();
			bw.write(s);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			return 3;
		}
		return 0;
	}


	public User getUser(String name, String password) {// 依据账户和密码，查找该用户资料
		FileInputStream fis=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		
		try {
			fis=new FileInputStream("user.txt");
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			
			String str=null;
			while((str=br.readLine())!=null){
				String s[]=str.split(":");
				String n=s[0];
				String p=s[1];
				if(n.equals(name)&&p.equals(password)){
					User u=new User(s[0],s[1],s[2],Integer.parseInt(s[3]));
					return u;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

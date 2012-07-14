package com.py.test.hibernate;



import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Client {

	public static void main(String[] args) {
		  // test merge on the windows client V5
		
           //读取hibernate.cfg.xml文件
		  Configuration cfg = new Configuration().configure();
		  
		  // 创建SessionFactory
		  SessionFactory fac = cfg.buildSessionFactory();
		  
		  Session session = null;
		  try {
			  	session  = fac.openSession();
			  	
			  	// 开启事务
			  	session.beginTransaction();
			  	
			  	
			  	User user = new User();
			  	user.setName("张三");
			  	user.setPassword("123");
			  	user.setCreateTime(new Date());
			  	user.setCreateTime(new Date());
			  	
			  	//保存数据
			  	session.save(user);
			  	
			  	//事务提交
			  	session.getTransaction().commit();
		} catch (Exception e) {
			  e.printStackTrace();
			  
			  //事务回滚
			  session.getTransaction().rollback();
		}finally{
			if (session != null){
				if (session.isOpen()){
					//关闭session
					session.close();
				}
			}
		}
		  
		  // 关闭factory 这个是Github.com网页端更新的
		  fac.close();
	}

}

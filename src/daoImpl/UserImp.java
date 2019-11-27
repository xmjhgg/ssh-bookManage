package daoImpl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.User;
import util.HibernateUtil;
import dao.UserDao;

public class UserImp implements UserDao{

	@Override
	public boolean addNewUser(User user) {
		Transaction t=null;
		Session ss=null;
		try {
			ss=HibernateUtil.getSession();
			t=ss.beginTransaction();
			ss.save(user);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}finally{
			if(t!=null){
				t=null;
			}
			ss.close();
		}
	}

	@Override
	public boolean updateUser(User user) {
		Transaction t=null;
		Session ss=null;
		try {
			ss=HibernateUtil.getSession();
			t=ss.beginTransaction();
			ss.update(user);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally{
			if(t!=null){
				t=null;
			}
			ss.close();
		}
	}

	@Override
	public User login(String username,String password) {
		Session ss=HibernateUtil.getSession();
		String hql="from User u where u.username=? and u.password=?";
		Query query=ss.createQuery(hql).setString(0, username).setString(1, password);
		User user=(User) query.uniqueResult();
		ss.beginTransaction().commit();
		ss.close();
		return user;
	}

		
	

}

package daoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Book;
import pojo.Log;
import pojo.User;
import util.HibernateUtil;
import dao.BookDao;

public class BookImp implements BookDao{
	@Override
	public String getDate() {
		Date d=new Date();
		SimpleDateFormat sft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sft.format(d);
		return date;
	}
	User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");


	@Override
	public boolean Book_add(Book book) {
		Transaction t=null;
		Session ss=null;
		try {
			ss=HibernateUtil.getSession();
			t=ss.beginTransaction();
			book.setDate(getDate());
			book.setUser(user);
			ss.save(book);
			Log log=new Log(user.getUsername(),book.getBname(),"添加书籍",getDate());
			ss.save(log);
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
	public boolean Book_delete(Book book) {
		Transaction t=null;
		Session ss=null;
		try {
			ss=HibernateUtil.getSession();
			t=ss.beginTransaction();
			Log log=new Log(user.getUsername(),book.getBname(),"删除书籍",getDate());
			ss.save(log);
			ss.delete(book);
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
			if(ss!=null){
				ss=null;
			}
		}
	}

	@Override
	public boolean Book_update(Book book) {
		Transaction t=null;
		Session ss=null;
		try {
			ss=HibernateUtil.getSession();
			t=ss.beginTransaction();
			ss.update(book);
			Log log=new Log(user.getUsername(),book.getBname(),"更改书籍",getDate());
			ss.save(log);
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
			if(ss!=null){
				ss=null;
			}
		}
	}

	@Override
	public Book Book_find(String bname) {
		String hql="from Book where bname=?";
		Session ss=HibernateUtil.getSession();
		Query query=ss.createQuery(hql).setString(0, bname);
		Book book=(Book) query.uniqueResult();
		ss.close();
		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> allBook() {
		Session ss=HibernateUtil.getSession();
		String hql="from Book";
		List<Book> books=new ArrayList<Book>();
		Query query=ss.createQuery(hql);
		books=query.list();
		ss.close();
		return books;
	}



}

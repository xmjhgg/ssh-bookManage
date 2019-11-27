package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final Configuration cfg;
	private static final SessionFactory ssf;
	
	static{
		cfg=new Configuration().configure();
		ssf=cfg.buildSessionFactory();
	}
	public static Session getSession(){
		return ssf.openSession();
	}
}

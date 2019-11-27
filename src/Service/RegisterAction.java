package Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import pojo.User;
import util.HibernateUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDao;
import daoImpl.UserImp;



public class RegisterAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = -1868185617896965937L;
	private User user=new User();
	UserDao usd=new UserImp();
	@Override
	public User getModel() {
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public String execute(){
		if("".equals(user.getUsername())
				||"".equals(user.getPassword())
				||"".equals(user.getName())
				||"".equals(user.getPhone())){
			addFieldError("register", "资料不全，请认真填写");
			return ERROR;
		}else if(user.getPassword().equals(user.getPassword2())==false){
			addFieldError("register", "两次输入密码不一致，请重新输入");
			return ERROR;
		}
			else{
			Session ss=HibernateUtil.getSession();
			String hql="select username from User where username=?";
			Query query=ss.createQuery(hql).setString(0, user.getUsername());
			List<String> allUsername=query.list();
			System.out.println(allUsername.size());
			if(allUsername.size()>0){
				addFieldError("register", "用户名已存在，请更换");
				return ERROR;
			}
			ss.close();
			
			if(usd.addNewUser(user)) 
				System.out.println("注册成功");
			
			return SUCCESS;
		}
		
	}
}

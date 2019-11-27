package Service;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import pojo.Book;
import pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.BookDao;
import dao.UserDao;
import daoImpl.BookImp;
import daoImpl.UserImp;


public class LoginAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 6364820292104638608L;
	UserDao usd=new UserImp();
	BookDao bod=new BookImp();
	User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	public String execute(){
		User a=usd.login(user.getUsername(), user.getPassword());
		if(a!=null){
			ServletActionContext.getRequest().getSession().setAttribute("user", a);
			List<Book> books=bod.allBook();
			ServletActionContext.getRequest().getSession().setAttribute("books", books);
			return SUCCESS;
		}else{
			addFieldError("login", "用户名或密码错误！");
			return ERROR;
		}
		
		
		
		
	}

}

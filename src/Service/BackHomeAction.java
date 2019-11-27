package Service;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import pojo.Book;

import com.opensymphony.xwork2.ActionSupport;

import dao.BookDao;
import daoImpl.BookImp;

public class BackHomeAction extends ActionSupport{
	private static final long serialVersionUID = -4606753713317156171L;
	BookDao bod=new BookImp();
	public String execute(){
		List<Book> books=bod.allBook();
		ServletActionContext.getRequest().getSession().setAttribute("books", books);
		return SUCCESS;
	}

}

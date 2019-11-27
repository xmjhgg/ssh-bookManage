package Service;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ExitAction extends ActionSupport{
	private static final long serialVersionUID = -6798600852774682979L;
	
	public String execute(){
		ServletActionContext.getRequest().getSession().setAttribute("user", null);
		System.out.println("ÍË³öÏµÍ³");
		return SUCCESS;
	}
	
}

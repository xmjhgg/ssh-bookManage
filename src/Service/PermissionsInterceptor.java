package Service;

import org.apache.struts2.ServletActionContext;

import pojo.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PermissionsInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 3806945011730421552L;

	@Override
	public String intercept(ActionInvocation action) throws Exception {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user!=null){
			return action.invoke();
		}else{
			ServletActionContext.getRequest().setAttribute("login", "您没有权限操作，请先登录！");
			return Action.LOGIN;
		}
		
	}
	
}

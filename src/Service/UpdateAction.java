package Service;

import org.apache.struts2.ServletActionContext;

import pojo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDao;
import daoImpl.UserImp;


public class UpdateAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = -7732757580273531911L;
	private UserDao usd=new UserImp();
	private User nUser=new User();
	private User oUser=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
	
	@Override
	public User getModel() {
		return nUser;
	}
	
	public String mima(){
		if("".equals(nUser.getPassword())||"".equals(nUser.getPassword2())){
			addFieldError("updateUser", "���ϲ�ȫ����������д");
			return ERROR;
			}
		else if(nUser.getPassword().equals(nUser.getPassword2())==false){
			addFieldError("updateUser", "�������벻һ�£���������д");
			return ERROR;
		}else{
			oUser.setPassword(nUser.getPassword());
			if(usd.updateUser(oUser)){
				System.out.println("������ĳɹ�");
				return SUCCESS;
			}
			System.out.println("δ֪����ʧ��");
			return ERROR;
		}
	}
	
	public String info(){
			if("".equals(nUser.getName())||"".equals(nUser.getPhone())){
			addFieldError("updateUser", "���ϲ�ȫ����������д");
			return ERROR;
			}else{
			oUser.setName(nUser.getName());
			oUser.setPhone(nUser.getPhone());
			if(usd.updateUser(oUser)){
				System.out.println("������ĳɹ�");
				return SUCCESS;
			}
			System.out.println("δ֪����ʧ��");
			return ERROR;
		}
	}

}

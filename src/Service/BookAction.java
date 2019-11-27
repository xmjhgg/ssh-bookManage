package Service;

import org.apache.struts2.ServletActionContext;

import pojo.Book;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.BookDao;
import daoImpl.BookImp;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport implements ModelDriven<Book>{
	private BookDao bod=new BookImp();
	private Book book=new Book();
	
	@Override
	public Book getModel() {
		return book;
	}

	public String Book_add(){
		if("".equals(book.getBname())||"".equals(book.getClassify())){
			addFieldError("Book_add", "�鼮���ϲ�ȫ��������");
			return "Book_add_error";
		}else{
			Book nowBook=bod.Book_find(book.getBname());
			if(nowBook!=null){
				addFieldError("Book_add", "����ͬ���鼮���������");
				return "Book_add_error";
			}
			
			Book newBook=new Book(book.getBname(),book.getClassify());
			
			if(bod.Book_add(newBook)){
				addFieldError("Book_add", "����鼮�ɹ���");
				return "Book_add_success";
			}else{
				System.out.println("δ֪����");
				return "Book_add_error";
			}
		}	
	}
	
	public String Book_delete(){
		if("".equals(book.getBname())){
			addFieldError("Book_delete", "������������");
			return "Book_delete_error";
		}else{
			
			Book nbook=bod.Book_find(book.getBname());
			if(nbook!=null){
				if(bod.Book_delete(nbook)){
					addFieldError("Book_delete", "ɾ���鼮�ɹ���");
					return "Book_delete_success";
				}else{
					System.out.println("δ֪����");
					return "Book_delete_error";
				}
			}else{
				addFieldError("Book_delete", "δ��ѯ����ͼ��,���������Ƿ�������ȷ��");
				return "Book_delete_error";
			}
		}
		
	}
	
	public String Book_update1(){
		Book nowBook=bod.Book_find(book.getBname());
		if(nowBook==null){
			addFieldError("Book_update", "δ��ѯ�����鼮����ȷ����������");
			return "Book_update1_error";
		}else{
			ServletActionContext.getRequest().setAttribute("book", nowBook);
			ServletActionContext.getRequest().getSession().setAttribute("book", nowBook);
			System.out.println("��ѯ�ɹ�");
			return "Book_update1_success";
		}
	}
	
	public String Book_update2(){
		Book newBook=(Book) ServletActionContext.getRequest().getSession().getAttribute("book");
		Book testBook=bod.Book_find(book.getBname());
		if("".equals(book.getBname())||"".equals(book.getClassify())){
			addFieldError("Book_update2", "���ϲ�ȫ����������д��");
			return "Book_update2_error";
		}else{
			if(testBook!=null){
				addFieldError("Book_update2", "����ͬ���鼮�������������");
				return "Book_update2_error";
			}
			newBook.setBname(book.getBname());
			newBook.setClassify(book.getClassify());
			System.out.println(newBook);
			if(bod.Book_update(newBook)){
				ServletActionContext.getRequest().getSession().setAttribute("book",newBook);
				addFieldError("Book_update2", "�޸��鼮�ɹ���");
				return "Book_update2_success";
			}else{
				return "Book_update2_error";
			}
		}
		
	}
	
	public String Book_find(){
		Book nowBook=bod.Book_find(book.getBname());
		if(nowBook==null){
			addFieldError("Book_find1", "δ��ѯ����ͼ�飬���������Ƿ�����");
			return "Book_find_error";
		}else{
			ServletActionContext.getRequest().setAttribute("book", nowBook);
			return "Book_find_success";
		}
		
		
		
	}
}

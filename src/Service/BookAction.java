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
			addFieldError("Book_add", "书籍资料不全，请重填");
			return "Book_add_error";
		}else{
			Book nowBook=bod.Book_find(book.getBname());
			if(nowBook!=null){
				addFieldError("Book_add", "存在同名书籍，无需添加");
				return "Book_add_error";
			}
			
			Book newBook=new Book(book.getBname(),book.getClassify());
			
			if(bod.Book_add(newBook)){
				addFieldError("Book_add", "添加书籍成功！");
				return "Book_add_success";
			}else{
				System.out.println("未知错误");
				return "Book_add_error";
			}
		}	
	}
	
	public String Book_delete(){
		if("".equals(book.getBname())){
			addFieldError("Book_delete", "请输入书名！");
			return "Book_delete_error";
		}else{
			
			Book nbook=bod.Book_find(book.getBname());
			if(nbook!=null){
				if(bod.Book_delete(nbook)){
					addFieldError("Book_delete", "删除书籍成功！");
					return "Book_delete_success";
				}else{
					System.out.println("未知错误");
					return "Book_delete_error";
				}
			}else{
				addFieldError("Book_delete", "未查询到此图书,请检查书名是否输入正确！");
				return "Book_delete_error";
			}
		}
		
	}
	
	public String Book_update1(){
		Book nowBook=bod.Book_find(book.getBname());
		if(nowBook==null){
			addFieldError("Book_update", "未查询到该书籍，请确认书名无误！");
			return "Book_update1_error";
		}else{
			ServletActionContext.getRequest().setAttribute("book", nowBook);
			ServletActionContext.getRequest().getSession().setAttribute("book", nowBook);
			System.out.println("查询成功");
			return "Book_update1_success";
		}
	}
	
	public String Book_update2(){
		Book newBook=(Book) ServletActionContext.getRequest().getSession().getAttribute("book");
		Book testBook=bod.Book_find(book.getBname());
		if("".equals(book.getBname())||"".equals(book.getClassify())){
			addFieldError("Book_update2", "资料不全，请认真填写！");
			return "Book_update2_error";
		}else{
			if(testBook!=null){
				addFieldError("Book_update2", "存在同名书籍，请更改书名！");
				return "Book_update2_error";
			}
			newBook.setBname(book.getBname());
			newBook.setClassify(book.getClassify());
			System.out.println(newBook);
			if(bod.Book_update(newBook)){
				ServletActionContext.getRequest().getSession().setAttribute("book",newBook);
				addFieldError("Book_update2", "修改书籍成功！");
				return "Book_update2_success";
			}else{
				return "Book_update2_error";
			}
		}
		
	}
	
	public String Book_find(){
		Book nowBook=bod.Book_find(book.getBname());
		if(nowBook==null){
			addFieldError("Book_find1", "未查询到此图书，请检查书名是否有误！");
			return "Book_find_error";
		}else{
			ServletActionContext.getRequest().setAttribute("book", nowBook);
			return "Book_find_success";
		}
		
		
		
	}
}

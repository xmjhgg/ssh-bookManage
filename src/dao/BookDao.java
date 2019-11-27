package dao;

import java.util.List;

import pojo.Book;

public interface BookDao {
	public String getDate();
	public boolean Book_add(Book book);
	public boolean Book_delete(Book book);
	public boolean Book_update(Book book);
	public Book Book_find(String bname);
	public List<Book> allBook();
}

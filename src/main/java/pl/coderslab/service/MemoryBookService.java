package pl.coderslab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.coderslab.model.Book;

@Service
public class MemoryBookService {
	private List<Book> list;

	public MemoryBookService() {
		list = new ArrayList<>();
		list.add(new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming"));
		list.add(new Book(2L, "9788324627738", "Rusz	glowa,	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
				"programming"));
		list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
				"programming"));
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public Book getBookById(int id) {
		for (Book book : list) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}
	
	public void addBook(Book book) {
		list.add(book);
	}

	public Book getBookById(long id) {
		for (Book book : list) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}
	
	public void modifyBookById(long id, Book book) {
		list.set((int) id, book);
	}
}

package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	MemoryBookService memoryBookService;

	@Autowired
	public BookController(MemoryBookService memoryBookService) {
		this.memoryBookService = memoryBookService;
	}

	@RequestMapping("/helloBook")
	public Book helloBook() {

		return new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming");
	}

	@RequestMapping("/hello")
	public String hello() {
		return "{hello:	World}";
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return memoryBookService.getList();
	}

	@GetMapping("/{id}")
	public Book bookById(@PathVariable long id) {
		return memoryBookService.getBookById(id);
	}

	@PostMapping
	public Book addBook(@RequestBody Book book) {
		memoryBookService.addBook(book);
		return book;
	}
	
	@PutMapping("/{id}")
	public Book modifyBook(@RequestBody Book book, @PathVariable long id) {
		memoryBookService.modifyBookById(id, book);
		return book;
	}

}

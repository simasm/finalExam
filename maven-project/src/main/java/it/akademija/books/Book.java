package it.akademija.books;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import it.akademija.category.Category;

@Entity
public class Book {
	
	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="book_name")
 	private String name;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	
	@Column(name="book_description")
	private String description;
	
	@Column(name="book_pages")
	private int pages;
	
	@Column(name="book_isbn")
	private String isbn;
	
	@Lob
	@Column(name="book_photo")
	private Byte[] photo;
	
	
	public Book () {}


	public Book(String name, Category category, String description, int pages, String isbn, Byte[] photo) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.pages = pages;
		this.isbn = isbn;
		this.photo = photo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}
	
	
	
	

}

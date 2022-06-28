package it.akademija.books;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.akademija.category.Category;

public class BookDTO {

	 
	private Long id;
	private String name;
	private String categoryName;
	private String description;
	private int pages;
	private String isbn;
	@JsonIgnore
	private Byte[] photo;
	
	public BookDTO() {}
	public BookDTO(String name, String categoryName, String description, int pages, String isbn) {
		super();
		this.name = name;
		this.categoryName = categoryName;
		this.description = description;
		this.pages = pages;
		this.isbn = isbn;
	
	}
	public BookDTO(String name, String categoryName, String description, int pages, String isbn, Byte[] photo) {
		super();
		this.name = name;
		this.categoryName = categoryName;
		this.description = description;
		this.pages = pages;
		this.isbn = isbn;
		this.photo = photo;
	}
	public BookDTO(Long id, String name, String categoryName, String description, int pages, String isbn, Byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.categoryName = categoryName;
		this.description = description;
		this.pages = pages;
		this.isbn = isbn;
		this.photo = photo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}

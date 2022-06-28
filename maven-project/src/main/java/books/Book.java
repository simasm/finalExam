package books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import category.Category;

@Entity
public class Book {
	
	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="book_name")
 	private String name;
	
	@Column(name="book_category")
	@OneToOne
	@JoinColumn(name = "category_id")
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
	
	
	
	
	
	

}

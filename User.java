package com.codingdojo.bookbroker.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, message="Username must be atleast 3 characters.")
	private String userName;
	
	@Size(min=3, message="Email must be atleast 3 characters.")
	@Email(message="Enter a valid email.")
	private String email;
	
	@Size(min=8, message="Password must be atleast 8 characters.")
	private String password;
	
	@Transient
	@Size(min=8, message="Password must be atleast 8 characters.")
	private String confirm;
	
	@Column(updatable = false)
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List <Book> books;
	
	@Column(updatable = false)
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List <Book> borrowedBooks;
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
}

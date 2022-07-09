package com.anz.bookstore.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="TBL_BOOKS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Book implements Serializable{
    
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="book_name")
    private String bookName;
	@Column(name="author_name")
    private String authorName;
	@Column(name="published_date")
    private LocalDate publishedDate;
	@Column(name="price")
    private double price;
	@Column(name="in_stock")
    private String inStock;
	
}
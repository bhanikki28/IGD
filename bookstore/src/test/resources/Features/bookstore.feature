Feature: Book Store

  @GetAllBooks
  Scenario Outline: Get All Books
  Given I send a request to the URL "/bookstore/v1/books" to get list of books
  Then the response will return status 200
  
  @GetBookById
  Scenario Outline: Get Book By Id
  Given I send a request to the URL "/bookstore/v1/books/" to get book by "id"
  Then get book by id will return status 200
  
  @SearchBook
  Scenario Outline: Search Book By Name
  Given I send a request to the URL "/bookstore/v1/books/" to search book
  | name |
  | GCP  |        
  Then the response will return book with status 200
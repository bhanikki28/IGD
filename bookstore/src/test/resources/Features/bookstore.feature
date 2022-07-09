Feature: Get All Books

  @GetAllBooks
  Scenario: Find Book By Id
    Given I need to get list of books in bookstore
    When I submit GET request at /bookstore/v1/books
    Then I should receive HTTP response in JSON format with complete book details.

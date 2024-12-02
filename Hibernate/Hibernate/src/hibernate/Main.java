package com.example.main;

import com.example.dao.AuthorDAO;
import com.example.entity.Author;
import com.example.entity.Book;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        AuthorDAO authorDAO = new AuthorDAO();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a new author along with their books");
            System.out.println("2. Retrieve an author by ID along with their associated books");
            System.out.println("3. Update an author's details and their books");
            System.out.println("4. Delete an author and their associated books");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a new author along with their books
                    Author author = new Author();
                    System.out.print("Enter author's name: ");
                    author.setName(scanner.next());
                    System.out.print("Enter author's date of birth (YYYY-MM-DD): ");
                    author.setDob(LocalDate.parse(scanner.next()));
                    System.out.print("Enter author's country: ");
                    author.setCountry(scanner.next());

                    System.out.print("How many books does this author have? ");
                    int numberOfBooks = scanner.nextInt();

                    for (int i = 0; i < numberOfBooks; i++) {
                        Book book = new Book();
                        System.out.print("Enter book title: ");
                        book.setTitle(scanner.next());
                        System.out.print("Enter publication year: ");
                        book.setPublicationYear(scanner.nextInt());
                        System.out.print("Enter book price: ");
                        book.setPrice(scanner.nextDouble());

                        author.addBook(book);
                    }

                    authorDAO.saveAuthor(author);
                    break;

                case 2:
                    // Retrieve an author by ID along with their associated books
                    System.out.print("Enter author's ID to retrieve: ");
                    int idToRetrieve = scanner.nextInt();
                    Author retrievedAuthor = authorDAO.getAuthorById(idToRetrieve);
                    if (retrievedAuthor != null) {
                        System.out.println(retrievedAuthor); // Implement toString() in Author class to display info.
                        retrievedAuthor.getBooks().forEach(System.out::println); // Implement toString() in Book class.
                    } else {
                        System.out.println("No author found with ID " + idToRetrieve);
                    }
                    break;

                case 3:
                    // Update an author's details and their books
                    // Implementation omitted for brevity; similar to adding but updating fields.
                    break;

                case 4:
                    // Delete an author and their associated books
                    System.out.print("Enter author's ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    authorDAO.deleteAuthor(idToDelete);
                    break;

                case 5:
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
            
         }

     }
}

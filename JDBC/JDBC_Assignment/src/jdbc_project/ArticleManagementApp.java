package jdbc_project;

import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class ArticleManagementApp {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArticleDAO articleDAO = new ArticleDAOImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Article Management Menu ---");
            System.out.println("1. Add Article");
            System.out.println("2. View Article by ID");
            System.out.println("3. View All Articles");
            System.out.println("4. Update Article");
            System.out.println("5. Delete Article");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addArticle();
                    break;
                case 2:
                    viewArticleById();
                    break;
                case 3:
                    viewAllArticles();
                    break;
                case 4:
                    updateArticle();
                    break;
                case 5:
                    deleteArticle();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addArticle() {
        System.out.print("Enter article name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter category (PAINTING/SCULPTURE/ARTIFACT): ");
        String categoryInput = scanner.nextLine().toUpperCase();
        
        Article.Category category = Article.Category.valueOf(categoryInput);
        
        Date dateCreated = new Date(); // Current date
        
        System.out.print("Enter creator name: ");
        String creatorName = scanner.nextLine();

        Article article = new Article(0, name, category, dateCreated, creatorName);
        articleDAO.createArticle(article);
    }

    private static void viewArticleById() {
        System.out.print("Enter article ID: ");
        int id = scanner.nextInt();
        
        Article article = articleDAO.getArticleById(id);
        
        if (article != null) {
            System.out.println(article);
        } else {
            System.out.println("No article found with ID: " + id);
        }
    }

    private static void viewAllArticles() {
        Collection<Article> articles = articleDAO.getAllArticles();
        
        if (articles.isEmpty()) {
            System.out.println("No articles available.");
            return;
        }

        for (Article article : articles) {
            System.out.println(article);
        }
    }

    private static void updateArticle() {
        System.out.print("Enter article ID to update: ");
        int id = scanner.nextInt();
        
        scanner.nextLine(); // Consume newline
        
        Article existingArticle = articleDAO.getArticleById(id);
        
        if (existingArticle == null) {
            System.out.println("No article found with ID: " + id);
            return;
        }

        System.out.print("Enter new name (current: " + existingArticle.getName() + "): ");
        String name = scanner.nextLine();

        System.out.print("Enter new category (current: " + existingArticle.getCategory() + "): ");
        String categoryInput = scanner.nextLine().toUpperCase();
        
        Article.Category category = Article.Category.valueOf(categoryInput);

        Date dateCreated = existingArticle.getDateCreated(); // Keep existing date

        System.out.print("Enter new creator name (current: " + existingArticle.getCreatorName() + "): ");
        String creatorName = scanner.nextLine();

        Article updatedArticle = new Article(id, name, category, dateCreated, creatorName);
        
        articleDAO.updateArticle(updatedArticle);
    }

    private static void deleteArticle() {
        System.out.print("Enter article ID to delete: ");
        int id = scanner.nextInt();
        
        articleDAO.deleteArticle(id);
    }
}
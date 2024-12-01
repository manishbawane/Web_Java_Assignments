package jdbc_project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArticleDAOImpl implements ArticleDAO {
    private final Collection<Article> articles = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void createArticle(Article article) {
        article.setId(currentId++);
        articles.add(article);
        System.out.println("Article added: " + article);
    }

    @Override
    public Article getArticleById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null; // Article not found
    }

    @Override
    public Collection<Article> getAllArticles() {
        return articles;
    }

    @Override
    public void updateArticle(Article updatedArticle) {
        for (Article article : articles) {
            if (article.getId() == updatedArticle.getId()) {
                article.setName(updatedArticle.getName());
                article.setCategory(updatedArticle.getCategory());
                article.setDateCreated(updatedArticle.getDateCreated());
                article.setCreatorName(updatedArticle.getCreatorName());
                System.out.println("Updated article: " + article);
                return;
            }
        }
        System.out.println("Article not found for update.");
    }

    @Override
    public void deleteArticle(int id) {
        Iterator<Article> iterator = articles.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Deleted article with ID: " + id);
                return;
            }
        }
        System.out.println("Article not found for deletion.");
    }
}
    

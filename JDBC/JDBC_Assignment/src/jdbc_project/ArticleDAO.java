package jdbc_project;

import java.util.Collection;

public interface ArticleDAO {
    void createArticle(Article article);
    
    Article getArticleById(int id);
    
    Collection<Article> getAllArticles();
    
    void updateArticle(Article article);
    
    void deleteArticle(int id);
}
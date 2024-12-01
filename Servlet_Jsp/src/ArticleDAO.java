
public interface ArticleDAO {
    void addArticle(Article article);
    List<Article> getAllArticles();
    Article getArticleById(int id);
    void updateArticle(Article article);
    void deleteArticle(int id);
}


public class ArticleDAOImpl implements ArticleDAO {
    
    

    @Override
    public void addArticle(Article article) {
        
    }

    @Override
    public List<Article> getAllArticles() {
        
        return new ArrayList<>();
    }

    @Override
    public Article getArticleById(int id) {
        
        return new Article();
    }

    @Override
    public void updateArticle(Article article) {
        
    }

    @Override
    public void deleteArticle(int id) {
        
    }
}



@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ArticleDAO articleDAO = new ArticleDAO();
        articleDAO.deleteArticle(id);
        
        response.sendRedirect("view_articles.jsp");
    }
}

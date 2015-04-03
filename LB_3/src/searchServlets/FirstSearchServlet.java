package searchServlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Пользователь on 30.03.2015.
 */
public class FirstSearchServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String selectTable = req.getParameter("selectTable");
        req.setAttribute("table", selectTable);

        HttpSession session = req.getSession();
        session.setAttribute("table", selectTable);

        req.getRequestDispatcher("searchPages/secondSearchPage.jsp").forward(req, resp);
    }
}

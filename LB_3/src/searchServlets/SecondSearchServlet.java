package searchServlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Пользователь on 02.04.2015.
 */
public class SecondSearchServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String atribute = req.getParameter("selectAtributs");
        req.setAttribute("atribute", atribute);

        HttpSession session = req.getSession();
        session.setAttribute("atribute", atribute);

        req.getRequestDispatcher("searchPages/threeSearchPage.jsp").forward(req, resp);
    }
}

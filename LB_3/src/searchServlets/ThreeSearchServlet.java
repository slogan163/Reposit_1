package searchServlets;

import servlestDB.ConnectDB;
import servlestDB.Group;
import servlestDB.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Пользователь on 02.04.2015.
 */
public class ThreeSearchServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        String table = (String) session.getAttribute("table");
        String atribute = (String) session.getAttribute("atribute");
        String atributeValue = req.getParameter("text");

        if(table.equals("Группа"))
        {
            List<Group> groups = ConnectDB.instance().searchInGroup(atribute, atributeValue);
            req.setAttribute("table", "Группа");
            req.setAttribute("groups", groups);

            req.getRequestDispatcher("/searchPages/resultSearchPage.jsp").forward(req,resp);
        }
        else if(table.equals("Студент"))
        {
            List<Student> students = ConnectDB.instance().searchInStudent(atribute,atributeValue);
            req.setAttribute("table", "Студент");
            req.setAttribute("students", students);

            req.getRequestDispatcher("/searchPages/resultSearchPage.jsp").forward(req,resp);
        }
    }
}

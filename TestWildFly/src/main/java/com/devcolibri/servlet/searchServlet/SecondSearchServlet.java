package com.devcolibri.servlet.searchServlet;

import com.devcolibri.bean.GroupBean;
import com.devcolibri.bean.StudentBean;
import com.devcolibri.entity.Group;
import com.devcolibri.entity.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/secondSearchServlet")
public class SecondSearchServlet extends HttpServlet
{
    @EJB
    GroupBean groupBean;
    @EJB
    StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String submitGroup = req.getParameter("submit_group");
        String submitStudent = req.getParameter("submit_student");

        if(submitGroup != null)
        {
            searchGroup(req, resp);
        }
        else if(submitStudent != null)
        {
           searchStudent(req, resp);
        }
    }

    private void searchGroup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String groupName = req.getParameter("group_name");
        String course = req.getParameter("course");

        List<Group> groups = groupBean.getAll(groupName, course);
        req.setAttribute("groups", groups);
        req.setAttribute("message", "Найденные группы");
        req.getRequestDispatcher("/entryPage/groupPage.jsp").forward(req,resp);
    }

    private void searchStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String groupName = req.getParameter("group_name");

        List<Student> students = studentBean.getAll(fname, lname, groupName);
        req.setAttribute("students", students);
        req.setAttribute("message", "Найденные студенты");
        req.getRequestDispatcher("/entryPage/studentPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

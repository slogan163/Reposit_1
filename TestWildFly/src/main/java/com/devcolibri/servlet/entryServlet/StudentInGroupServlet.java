package com.devcolibri.servlet.entryServlet;

import com.devcolibri.bean.StudentBean;
import com.devcolibri.entity.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentInGroupServlet")
public class StudentInGroupServlet extends HttpServlet
{
    @EJB
    StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int groupID = Integer.valueOf(req.getParameter("group_id"));
        List<Student> students = studentBean.getGroup(groupID);
        req.getSession().setAttribute("students", students);
        req.setAttribute("students", students);
        req.setAttribute("message", "Студенты в группе");
        req.getRequestDispatcher("/entryPage/studentPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

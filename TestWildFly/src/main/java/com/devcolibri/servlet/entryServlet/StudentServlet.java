package com.devcolibri.servlet.entryServlet;

import com.devcolibri.bean.GroupBean;
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

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet
{
    @EJB
    StudentBean studentBean;
    @EJB
    GroupBean groupBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Student> students = studentBean.getAll();
        req.getSession().setAttribute("students", students);
        req.setAttribute("students", students);
        req.setAttribute("message", "Все студенты");
        req.getRequestDispatcher("/entryPage/studentPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}

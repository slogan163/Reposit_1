package com.devcolibri.servlet.createServlet;

import com.devcolibri.bean.StudentBean;
import com.devcolibri.entity.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createSecondStudentServlet")
public class CreateSecondStudentServlet extends HttpServlet
{
    @EJB
    StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        int groupID = Integer.valueOf(req.getParameter("group"));

        studentBean.add(new Student(fname, lname, groupID));
        req.getRequestDispatcher("/studentServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

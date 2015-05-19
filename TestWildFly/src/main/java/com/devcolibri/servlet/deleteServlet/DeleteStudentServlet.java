package com.devcolibri.servlet.deleteServlet;

import com.devcolibri.bean.StudentBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet
{
    @EJB
    StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int studentID = Integer.valueOf(req.getParameter("stud_id"));
        studentBean.delete(studentID);
        req.getRequestDispatcher("/studentServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

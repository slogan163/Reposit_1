package com.devcolibri.servlet.updateServlet;

import com.devcolibri.bean.StudentBean;
import com.devcolibri.entity.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateFinishStudentServlet")
public class UpdateFinishStudentServlet extends HttpServlet
{
    @EJB
    StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int studentID = Integer.valueOf(req.getParameter("stud_id"));
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        int groupID = Integer.valueOf(req.getParameter("group"));

        Student student = new Student(fname, lname, groupID);
        student.setId(studentID);
        studentBean.update(student);

        req.getRequestDispatcher("/studentServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

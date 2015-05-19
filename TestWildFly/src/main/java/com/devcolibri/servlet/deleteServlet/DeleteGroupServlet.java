package com.devcolibri.servlet.deleteServlet;

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

@WebServlet("/deleteGroupServlet")
public class DeleteGroupServlet extends HttpServlet
{
    @EJB
    GroupBean groupBean;
    @EJB
    StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int groupID = Integer.valueOf(req.getParameter("group_id"));

        //удалаем группу
        groupBean.delete(groupID);

        //удалаяем всех студентов в группе
        List<Student> studentsGroup = studentBean.getGroup(groupID);
        for(Student s : studentsGroup)
        {
            studentBean.delete(s.getId());
        }

        req.getRequestDispatcher("/groupServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

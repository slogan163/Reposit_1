package com.devcolibri.servlet.updateServlet;

import com.devcolibri.bean.GroupBean;
import com.devcolibri.entity.Group;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateStudentServlet")
public class UpdateStudentServlet extends HttpServlet
{
    @EJB
    GroupBean groupBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String studentID = req.getParameter("stud_id");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        int groupID = Integer.valueOf(req.getParameter("st_group_id"));

        req.setAttribute("stud_id", studentID);
        req.setAttribute("fname", fname);
        req.setAttribute("lname", lname);
        req.setAttribute("st_group_id", groupID);
        List<Group> groups = groupBean.getAll();
        req.setAttribute("groups", groups);

        req.getRequestDispatcher("/updatePage/updateStudentPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

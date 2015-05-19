package com.devcolibri.servlet.createServlet;

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

@WebServlet("/createGroupServlet")
public class CreateGroupServlet extends HttpServlet
{
    @EJB
    GroupBean groupBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("group_name");
        int course = Integer.valueOf(req.getParameter("course"));
        Group group = new Group(name, course);
        groupBean.add(group);
        req.getRequestDispatcher("/groupServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

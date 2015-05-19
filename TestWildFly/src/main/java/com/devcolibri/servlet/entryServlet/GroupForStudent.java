package com.devcolibri.servlet.entryServlet;

import com.devcolibri.bean.GroupBean;
import com.devcolibri.entity.Group;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/groupForStudent")
public class GroupForStudent extends HttpServlet
{
    @EJB
    GroupBean groupBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int groupID = Integer.valueOf(req.getParameter("group_id"));
        Group group = groupBean.get(groupID);
        List<Group> groups = new ArrayList<Group>();
        groups.add(group);
        req.setAttribute("groups", groups);
        req.setAttribute("message", "Группа студента");
        req.getRequestDispatcher("/entryPage/groupPage.jsp").forward(req,resp);
    }
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

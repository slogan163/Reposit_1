package com.devcolibri.servlet.entryServlet;

import com.devcolibri.bean.GroupBean;
import com.devcolibri.entity.Group;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/groupServlet")
public class GroupServlet extends HttpServlet
{
    @EJB
    GroupBean groupBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        List<Group> groups = groupBean.getAll();
        req.getSession().setAttribute("groups", groups);

        req.setAttribute("groups", groups);
        req.setAttribute("message", "Все группы");
        req.getRequestDispatcher("/entryPage/groupPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}

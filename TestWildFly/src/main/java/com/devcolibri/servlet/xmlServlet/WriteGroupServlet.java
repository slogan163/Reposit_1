package com.devcolibri.servlet.xmlServlet;

import com.devcolibri.bean.GroupBean;
import com.devcolibri.entity.Group;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@WebServlet("/writeGroupServlet")
public class WriteGroupServlet extends HttpServlet
{
    @EJB
    GroupBean groupBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //создание файла xml
        List<Group> groups = (List<Group>) req.getSession().getAttribute("groups");
        String fileName = req.getParameter("file_name") + ".xml";
        String filePath = "C:\\Users\\Пользователь\\IdeaProjects\\TestWildFly\\" + fileName;
        File xmlFile = new File(filePath);
        groupBean.writeXML(groups, xmlFile);

        //загрузка файла из сервера и его удаление
        //изменияем контекст
       /* String header = "attachment;filename=" + fileName;
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", header);

        FileInputStream fileIn = new FileInputStream(xmlFile);
        ServletOutputStream out = resp.getOutputStream();

        //пишем файл
        byte[] outputByte = new byte[4096];
        //copy binary contect to output stream
        while(fileIn.read(outputByte, 0, 4096) != -1)
        {
            out.write(outputByte, 0, 4096);
        }
        fileIn.close();
        out.flush();
        out.close();

        //удаляем файл на сервере
        if(xmlFile.exists())
             xmlFile.delete();
        //и возвращаем кодировку
        response.setContentType("text/html; charset=windows-1251");*/

        req.getRequestDispatcher("/entryPage/groupPage.jsp").forward(req,resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }
}

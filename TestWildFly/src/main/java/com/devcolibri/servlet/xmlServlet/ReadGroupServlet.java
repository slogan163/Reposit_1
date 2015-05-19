package com.devcolibri.servlet.xmlServlet;

import com.devcolibri.bean.GroupBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet("/readGroupServlet")
public class ReadGroupServlet extends HttpServlet
{
    @EJB
    GroupBean groupBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<File> uploadFiles = uploadFiles(req, resp);

        for(File file : uploadFiles)
        {
            groupBean.readXML(file);
        }

        req.getRequestDispatcher("/groupServlet").forward(req,resp);
    }

    private List<File> uploadFiles(HttpServletRequest req, HttpServletResponse resp)
    {
        List<File> uploadedFiles = new ArrayList<File>();
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);

        if (isMultipart)
        {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try
            {
                List items = upload.parseRequest(req);
                Iterator iterator = items.iterator();

                while (iterator.hasNext())
                {
                    FileItem item = (FileItem) iterator.next();

                    if (!item.isFormField())
                    {
                        String fileName = item.getName();
                        String root = "C:\\Users\\Пользователь\\IdeaProjects\\TestWildFly\\uploads";
                        File uploadedFile = new File(root + "\\" + fileName);
                        item.write(uploadedFile);
                        uploadedFiles.add(uploadedFile);
                    }
                }
            }
            catch (FileUploadException e)
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return uploadedFiles;
    }

}

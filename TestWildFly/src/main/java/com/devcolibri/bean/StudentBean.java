package com.devcolibri.bean;

import com.devcolibri.entity.Student;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class StudentBean
{
    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    //добавить студента
    public Student add(Student student){
        return em.merge(student);
    }

    //Получить студента по ИД
    public Student get(int id){
        return em.find(Student.class, id);
    }

    // если Student которого мыпытаемся обновить нет,
    // то запишется он как новый
    public void update(Student student){
        add(student);
    }

    // удаляем студента по id
    public void delete(int id){
        em.remove(get(id));
    }

    // Получаем всех студентов с БД
    public List<Student> getAll(){
        TypedQuery<Student> namedQuery = (TypedQuery<Student>) em.createQuery("select s from student s");
        return namedQuery.getResultList();
    }

    public List<Student> getAll(String fname, String lname, String groupName)
    {
        String sql = getSQL(fname, lname, groupName);
        System.err.println(sql);
        return em.createQuery(sql).getResultList();
    }

    public List<Student> getGroup(int groupID)
    {
        return em.createQuery("select s from student s where s.groupID = :custGroupID").setParameter("custGroupID", groupID).getResultList();
    }

    private String getSQL(String fname, String lname, String groupName)
    {
        StringBuilder sql = new StringBuilder("select s from student s");
        List<String> attributes = new ArrayList<String>();

        if(!fname.equals(""))
            attributes.add("first_name = '" + fname +"'");
        if(!lname.equals(""))
            attributes.add("last_name = '" + lname +"'");
        if(!groupName.equals(""))
            attributes.add("st_group_id IN (SELECT g FROM group_students g WHERE group_name = '" + groupName + "')");

        for(int i = 0; i < attributes.size(); i++)
        {
            if(i == 0)
            {
                sql.append(" where " + attributes.get(i));
            }
            else
            {
                sql.append(" AND " + attributes.get(i));
            }
        }

        return sql.toString();

    }

    public boolean writeXML(List<Student> students, File file)
    {
        boolean success = false;
        XMLEncoder encoder = null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
            encoder.writeObject(students);
            success = true;
        }
        catch(IOException e)
        {
            success = false;
        }
        finally
        {
            if(encoder != null)
            {
                encoder.flush();
                encoder.close();
            }
            return success;
        }
    }

    public void readXML(File file)
    {
        List<Student> students = new ArrayList<Student>();
        XMLDecoder decoder = null;

        try
        {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
            students = (List<Student>) decoder.readObject();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            decoder.close();
        }

        for(Student student : students)
        {
            update(student);
        }
    }
}

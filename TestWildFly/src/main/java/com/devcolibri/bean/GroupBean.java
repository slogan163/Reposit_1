package com.devcolibri.bean;

import com.devcolibri.entity.Group;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Stateless
@Local
public class GroupBean
{
    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    public Group add(Group group)
    {
        return em.merge(group);
    }

    public Group get(int id)
    {
        return em.find(Group.class, id);
    }

    public void update(Group group){
        add(group);
    }

    public void delete(int id){
        em.remove(get(id));
    }

    public List<Group> getAll(){
        TypedQuery<Group> namedQuery = (TypedQuery<Group>) em.createQuery("select g from group_students g");
        return namedQuery.getResultList();
    }

    public List<Group> getAll(String name, String course)
    {
        String sql = getSQL(name, course);
        System.out.println(sql);
        return em.createQuery(sql).getResultList();

    }

    private String getSQL(String groupName, String course)
    {
        StringBuilder sql = new StringBuilder("Select g from group_students g");
        List<String> attributes = new ArrayList<String>();

        if(!groupName.equals(""))
            attributes.add("group_name = '" + groupName+"'");
        if(!course.equals(""))
            attributes.add("course = " + course);

        for(int i = 0; i < attributes.size(); i++)
        {
            if(i == 0)
            {
                sql.append(" where ").append(attributes.get(i));
            }
            else
            {
                sql.append(" AND ").append(attributes.get(i));
            }
        }

        return sql.toString();
    }

    public boolean writeXML(List<Group> groups, File file)
    {
        boolean success = false;
        XMLEncoder encoder = null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
            encoder.writeObject(groups);
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
        List<Group> groups = new ArrayList<Group>();
        XMLDecoder decoder = null;

        try
        {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
            groups = (List<Group>) decoder.readObject();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            decoder.close();
        }

        for(Group group : groups)
        {
            update(group);
        }
    }

}

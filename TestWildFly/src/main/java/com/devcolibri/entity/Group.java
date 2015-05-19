package com.devcolibri.entity;

import javax.persistence.*;

@Entity(name = "group_students")
public class Group
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private int id;

    @Column(name = "group_name")
    private String name;

    private int course;

    public Group()
    {
    }

    public Group(String name, int course)
    {
        this.name = name;
        this.course = course;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCourse()
    {
        return course;
    }

    public void setCourse(int course)
    {
        this.course = course;
    }
}

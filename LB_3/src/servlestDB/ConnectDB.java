package servlestDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Пользователь on 26.03.2015.
 */
public class ConnectDB
{
    private static volatile ConnectDB instance;
    private Connection connection;

    public static ConnectDB instance()
    {
        ConnectDB localInstance = instance;
        if (localInstance == null)
        {
            synchronized (ConnectDB.class)
            {
                localInstance = instance;
                if (localInstance == null)
                {
                    instance = localInstance = new ConnectDB();
                }
            }
        }
        return localInstance;
    }

    public void init(String login, String password) throws SQLException
    {
        String driverName = "oracle.jdbc.driver.OracleDriver";
        String urlDB = "jdbc:oracle:thin:@//localhost:1521/xe";
        Locale.setDefault(Locale.US);

        try
        {
            Class.forName(driverName);
            connection = DriverManager.getConnection(urlDB, login, password);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Group> searchInGroup(String atribute, String value)
    {
        String sql = "Select * From GROUP_STUDENTS " +
                        "Where " + atribute + " = " + value;

        List<Group> groups = null;

        try
        {
            Statement statement = connection.createStatement();
            System.out.println("SQL: " + sql);

            ResultSet resultSet = statement.executeQuery(sql);

            groups = new ArrayList<Group>();

            while (resultSet.next())
            {
                int group_id = resultSet.getInt("group_id");
                String group_name = resultSet.getString("group_name");
                int head_id = resultSet.getInt("head_id");

                Group group = new Group(group_id,group_name,head_id);
                groups.add(group);

                System.out.println("Result DB: " + group_id + " " + group_name + " " + head_id);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return groups;
        }
    }

    public List<Student> searchInStudent(String atribute, String value)
    {
        String sql = "Select * From STUDENTS " +
                "Where " + atribute + " = " + value;

        List<Student> students = null;

        try
        {
            Statement statement = connection.createStatement();
            System.out.println("SQL: " + sql);

            ResultSet resultSet = statement.executeQuery(sql);

            students = new ArrayList<Student>();

            while (resultSet.next())
            {
                int stud_id = resultSet.getInt("stud_id");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                int st_group_id = resultSet.getInt("st_group_id");

                Student student = new Student(stud_id, fname, lname, st_group_id);
                students.add(student);

                System.out.println("Result DB: " + stud_id + " "+ fname +" "+ lname +" "+ st_group_id);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return students;
        }
    }
}

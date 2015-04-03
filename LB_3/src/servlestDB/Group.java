package servlestDB;

/**
 * Created by Пользователь on 02.04.2015.
 */
public class Group
{
    private int group_id;
    private String group_name;
    private int head_id;

    public Group(int group_id, String group_name, int head_id)
    {
        this.group_id = group_id;
        this.group_name = group_name;
        this.head_id = head_id;
    }

    public Group()
    {
    }

    public int getGroup_id()
    {
        return group_id;
    }

    public void setGroup_id(int group_id)
    {
        this.group_id = group_id;
    }

    public String getGroup_name()
    {
        return group_name;
    }

    public void setGroup_name(String group_name)
    {
        this.group_name = group_name;
    }

    public int getHead_id()
    {
        return head_id;
    }

    public void setHead_id(int head_id)
    {
        this.head_id = head_id;
    }
}

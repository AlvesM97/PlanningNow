package models;

public class User {

    private int user_ra;
    private String user_password;
    private int user_type;
    private String user_name;
    private String user_cursor;

    public User() {
        this.user_ra = 0;
        this.user_password = null;
        this.user_type = 0;
        this.user_name = null;
        this.user_cursor = null;
    }

    public User(int user_ra, String user_password, int user_type, String user_name, String user_cursor) {
        this.user_ra = user_ra;
        this.user_password = user_password;
        this.user_type = user_type;
        this.user_name = user_name;
        this.user_cursor = user_cursor;
    }

    public int getUser_ra() {
        return user_ra;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_cursor() {
        return user_cursor;
    }

    public int getUser_type() {
        return user_type;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_cursor(String user_cursor) {
        this.user_cursor = user_cursor;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public void setUser_ra(int user_ra) {
        this.user_ra = user_ra;
    }

}

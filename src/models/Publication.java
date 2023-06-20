package models;

public class Publication {
    
    private int idPublication;
    private String description;
    private String userName;
    private String date;
    private int user;

    public Publication(int idPublication, String description, String userName, String date, int user) {
        this.idPublication = idPublication;
        this.description = description;
        this.userName = userName;
        this.date = date;
        this.user = user;
    }

    public Publication() {
        this.idPublication = 0;
        this.description = null;
        this.userName = null;
        this.date = null;
        this.user = 0;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

}
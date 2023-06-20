package models;

public class Monitoring {

    private String discipline;
    private int monitoring;
    private String date;
    private String hour;
    private String room;
    private int user;
    private int quantity;

    public Monitoring(int monitoring, int user, String date, String hour, String discipline, String room,
            int quantity) {
        this.discipline = discipline;
        this.monitoring = monitoring;
        this.date = date;
        this.hour = hour;
        this.room = room;
        this.user = user;
        this.quantity = quantity;
    }

    public Monitoring() {
        this.discipline = null;
        this.monitoring = 0;
        this.date = null;
        this.hour = null;
        this.room = null;
        this.user = 0;
        this.quantity = 0;

    }

    public String getSubject() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getDescription() {
        return monitoring;
    }

    public int getMonitoring(){
        return monitoring;
    }

    public void setMonitoring(int monitoring) {
        this.monitoring = monitoring;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
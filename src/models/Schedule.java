package models;

public class Schedule {

    private int idSchedule;
    private int user;
    private int idMonitoring;

    public Schedule(int idSchedule, int user, int idMonitoring) {
        this.idSchedule = idSchedule;
        this.user = user;
        this.idMonitoring = idMonitoring;
    }

    public Schedule() {
        this.idSchedule = 0;
        this.user = 0;
        this.idMonitoring = 0;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getMonitoring() {
        return idMonitoring;
    }

    public void setMonitoring(int idMonitoring) {
        this.idMonitoring = idMonitoring;
    }
}
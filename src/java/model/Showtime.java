package model;

import java.util.Date;

public class Showtime {
    private int showtimeID;
    private int movieID;
    private int screenID;
    private Date startTime;
    private Date endTime;
    private int adminID;

    public Showtime() {}

    public Showtime(int showtimeID, int movieID, int screenID, Date startTime, Date endTime, Integer adminID) {
        this.showtimeID = showtimeID;
        this.movieID = movieID;
        this.screenID = screenID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.adminID = adminID;
    }

    public int getShowtimeID() {
        return showtimeID;
    }

    public void setShowtimeID(int showtimeID) {
        this.showtimeID = showtimeID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    
}

    
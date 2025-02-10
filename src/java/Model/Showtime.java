/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Showtime {
    private int ShowtimeID;
    private int MovieID;
    private int ScreenID;
    private Date StartTime;
    private Date EndTime;
    private int AdminID;

    public Showtime() {
    }

    public Showtime(int ShowtimeID, int MovieID, int ScreenID, Date StartTime, Date EndTime, int AdminID) {
        this.ShowtimeID = ShowtimeID;
        this.MovieID = MovieID;
        this.ScreenID = ScreenID;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.AdminID = AdminID;
    }
    
    
    public int getShowtimeID() {
        return ShowtimeID;
    }

    public void setShowtimeID(int ShowtimeID) {
        this.ShowtimeID = ShowtimeID;
    }

    public int getMovieID() {
        return MovieID;
    }

    public void setMovieID(int MovieID) {
        this.MovieID = MovieID;
    }

    public int getScreenID() {
        return ScreenID;
    }

    public void setScreenID(int ScreenID) {
        this.ScreenID = ScreenID;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date StartTime) {
        this.StartTime = StartTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date EndTime) {
        this.EndTime = EndTime;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }
    
    
}

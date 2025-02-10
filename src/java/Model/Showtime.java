/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class Showtime {
    private int ShowtimeID;
    private int MovieID;
    private int ScreenID;
    private Timestamp StartTime;
    private Timestamp EndTime;
    private int AdminID;

    public Showtime() {
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

    public Timestamp getStartTime() {
        return StartTime;
    }

    public void setStartTime(Timestamp StartTime) {
        this.StartTime = StartTime;
    }

    public Timestamp getEndTime() {
        return EndTime;
    }

    public void setEndTime(Timestamp EndTime) {
        this.EndTime = EndTime;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

    
}

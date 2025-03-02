package model;

public class Screen {
    private int screenID;
    private int cinemaID;
    private String screenName;
    private int totalSeat;

    public Screen() {}

    public Screen(int screenID, int cinemaID, String screenName, int totalSeat) {
        this.screenID = screenID;
        this.cinemaID = cinemaID;
        this.screenName = screenName;
        this.totalSeat = totalSeat;
    }

    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }
}
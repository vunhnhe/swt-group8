package Model;

public class Screen {
    private int ScreenID;
    private int CinemaID;
    private String ScreenName;
    private int TotalSeat;

    public int getScreenID() {
        return ScreenID;
    }

    public void setScreenID(int ScreenID) {
        this.ScreenID = ScreenID;
    }

    public int getCinemaID() {
        return CinemaID;
    }

    public void setCinemaID(int CinemaID) {
        this.CinemaID = CinemaID;
    }

    public String getScreenName() {
        return ScreenName;
    }

    public void setScreenName(String ScreenName) {
        this.ScreenName = ScreenName;
    }

    public int getTotalSeat() {
        return TotalSeat;
    }

    public void setTotalSeat(int TotalSeat) {
        this.TotalSeat = TotalSeat;
    }

    
}

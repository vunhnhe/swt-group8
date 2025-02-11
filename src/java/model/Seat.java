package model;

public class Seat {
    private int seatID;
    private int screenID;
    private String seatNumber;
    private String seatType;
    private double price;

    public Seat() {}

    public Seat(int seatID, int screenID, String seatNumber, String seatType, double price) {
        this.seatID = seatID;
        this.screenID = screenID;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Cinema {

    private int CinemaID;
    private String CinemaName;
    private String Location;
    private int NumberOfScreen;
    private int AdminID;

    public int getCinemaID() {
        return CinemaID;
    }

    public void setCinemaID(int CinemaID) {
        this.CinemaID = CinemaID;
    }

    public String getCinemaName() {
        return CinemaName;
    }

    public void setCinemaName(String CinemaName) {
        this.CinemaName = CinemaName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getNumberOfScreen() {
        return NumberOfScreen;
    }

    public void setNumberOfScreen(int NumberOfScreen) {
        this.NumberOfScreen = NumberOfScreen;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }
    
    
}

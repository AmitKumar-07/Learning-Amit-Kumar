package systemDesign.lowLevelDesign.problems.DesignBookMyShow;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.City;

import java.util.List;

public class Theatre {

    String theatreId;
    String name;
    String address;
    City city;
    List<Screen> screens;
    List<Show> shows;

    public Theatre(String theatreId, String name, String address, City city, List<Screen> screens) {
        this.theatreId = theatreId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.screens = screens;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}


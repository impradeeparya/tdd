package in.helloroomie.dto.ad;

import java.util.Date;

/**
 * Created by Pradeep Arya on 7/7/2015.
 */
public class AdDto {

    String title;
    String description;
    String localityName;
    String zoneName;
    String cityName;
    Date postedOn;
    String allowedTo;
    String rent;
    String room;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public String getAllowedTo() {
        return allowedTo;
    }

    public void setAllowedTo(String allowedTo) {
        this.allowedTo = allowedTo;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}

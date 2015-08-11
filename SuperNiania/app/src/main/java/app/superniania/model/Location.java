package app.superniania.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Łukasz on 2015-05-26.
 */
public class Location implements Serializable{
      private Double longitude;
      private Double latitude;
      private List<String> listOfDays;
      private String dateFrom;
      private String dateTo;
      private String type;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getListOfDays() {
        return listOfDays;
    }

    public void setListOfDays(List<String> listOfDays) {
        this.listOfDays = listOfDays;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}

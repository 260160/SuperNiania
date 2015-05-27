package com.mkyong.common.controller;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location implements Serializable{
	@Id
	 private Double longitude;
    private Double latitude;

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
}

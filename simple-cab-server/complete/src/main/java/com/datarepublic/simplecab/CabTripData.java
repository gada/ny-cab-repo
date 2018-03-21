package com.datarepublic.simplecab;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "cab_trip_data")
@Entity
@IdClass(EmbeddableTableWithoutId.class)
public class CabTripData {

	// TODO - Change all names to proper java
	@Id
	private String medallion;

	@Id
	@Column(name = "pickup_datetime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pickup_datetime;

	@Column(name = "dropoff_datetime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dropoff_datetime;

	private String hack_license;
	private String vendor_id;
	private Integer rate_code;
	private String store_and_fwd_flag;
	private Integer passenger_count;
	private Integer trip_time_in_secs;
	private Double trip_distance;
	private Double pickup_longitude;
	private Double pickup_latitude;
	private Double dropoff_longitude;
	private Double dropoff_latitude;

	public String getMedallion() {
		return medallion;
	}

	public void setMedallion(String medallion) {
		this.medallion = medallion;
	}

	public String getHack_license() {
		return hack_license;
	}

	public void setHack_license(String hack_license) {
		this.hack_license = hack_license;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}

	public int getRate_code() {
		return rate_code;
	}

	public void setRate_code(int rate_code) {
		this.rate_code = rate_code;
	}

	public String getStore_and_fwd_flag() {
		return store_and_fwd_flag;
	}

	public void setStore_and_fwd_flag(String store_and_fwd_flag) {
		this.store_and_fwd_flag = store_and_fwd_flag;
	}

	public Date getPickup_datetime() {
		return pickup_datetime;
	}

	public void setPickup_datetime(Date pickup_datetime) {
		this.pickup_datetime = pickup_datetime;
	}

	public Date getDropoff_datetime() {
		return dropoff_datetime;
	}

	public void setDropoff_datetime(Date dropoff_datetime) {
		this.dropoff_datetime = dropoff_datetime;
	}

	public int getPassenger_count() {
		return passenger_count;
	}

	public void setPassenger_count(int passenger_count) {
		this.passenger_count = passenger_count;
	}

	public int getTrip_time_in_secs() {
		return trip_time_in_secs;
	}

	public void setTrip_time_in_secs(int trip_time_in_secs) {
		this.trip_time_in_secs = trip_time_in_secs;
	}

	public double getTrip_distance() {
		return trip_distance;
	}

	public void setTrip_distance(double trip_distance) {
		this.trip_distance = trip_distance;
	}

	public double getPickup_longitude() {
		return pickup_longitude;
	}

	public void setPickup_longitude(double pickup_longitude) {
		this.pickup_longitude = pickup_longitude;
	}

	public double getPickup_latitude() {
		return pickup_latitude;
	}

	public void setPickup_latitude(double pickup_latitude) {
		this.pickup_latitude = pickup_latitude;
	}

	public double getDropoff_longitude() {
		return dropoff_longitude;
	}

	public void setDropoff_longitude(double dropoff_longitude) {
		this.dropoff_longitude = dropoff_longitude;
	}

	public double getDropoff_latitude() {
		return dropoff_latitude;
	}

	public void setDropoff_latitude(double dropoff_latitude) {
		this.dropoff_latitude = dropoff_latitude;
	}

}

/**
 * 
 * @author Gady
 *
 */
class EmbeddableTableWithoutId implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	String medallion;
	Date pickup_datetime;

}

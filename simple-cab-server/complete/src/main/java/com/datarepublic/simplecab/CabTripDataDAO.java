package com.datarepublic.simplecab;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Gady
 *
 */
public interface CabTripDataDAO extends JpaRepository<CabTripData, Long> {

	@Query("select count(*) from CabTripData ctd where ctd.pickup_datetime >= :pickupFromDate and ctd.pickup_datetime < :pickupToDate and ctd.medallion = :medallion")
	Integer getMedallionsSummary(@Param("pickupFromDate") Date pickupDate, @Param("pickupToDate") Date pickupToDate,
			@Param("medallion") String medallion);

}

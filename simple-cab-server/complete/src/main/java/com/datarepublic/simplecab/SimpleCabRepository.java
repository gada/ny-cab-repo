package com.datarepublic.simplecab;

import java.util.Date;

/**
 * 
 * @author Gady
 *
 */
public interface SimpleCabRepository {

	void deleteCache();

	Integer getCountByMedallionAndPickupDatetime(Date pickupDate, String medallion, boolean isIgnoreCache);

}

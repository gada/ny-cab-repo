package com.datarepublic.simplecab;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Gady
 *
 */
@Service
public class SimpleCabRepositoryImpl implements SimpleCabRepository {

	@Autowired
	private CabTripDataDAO cabTripDataDAO;

	@Override
	@CacheEvict(value = "medalion-summary-cache", allEntries = true)
	public void deleteCache() {
		// Intentionally blank
	}

	/**
	 * 
	 */
	@Cacheable(value = "medalion-summary-cache", key = "#medallionId", condition = "#isIgnoreCache==false")
	@Override
	public Integer getCountByMedallionAndPickupDatetime(Date pickupDate, String medallionId, boolean isIgnoreCache) {
		Calendar pickupToDate = getPickupToDate(pickupDate);
		Integer tripCount = cabTripDataDAO.getMedallionsSummary(pickupDate, pickupToDate.getTime(), medallionId);
		return tripCount;
	}

	/**
	 * 
	 * @param pickupDate
	 * @return We need to ignore time so have a date range: from - to.
	 */
	private Calendar getPickupToDate(Date pickupDate) {
		Calendar pickupToDate = Calendar.getInstance();
		pickupToDate.setTime(pickupDate);
		pickupToDate.add(Calendar.DATE, 1);
		return pickupToDate;
	}

}

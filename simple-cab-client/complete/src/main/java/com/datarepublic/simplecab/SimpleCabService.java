package com.datarepublic.simplecab;

/**
 * 
 * @author Gady
 *
 */
public interface SimpleCabService {

	void deleteCache();

	MedalionSummery[] getMedallionsSummary(String pickupDate, String... medallions);

	MedalionSummery[] getMedallionsSummary(String pickupDate, boolean ignoreCache, String... medallions);

}

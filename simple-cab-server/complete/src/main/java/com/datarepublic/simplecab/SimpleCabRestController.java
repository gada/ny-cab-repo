package com.datarepublic.simplecab;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Gady
 *
 */
@Controller
@RequestMapping(path = "/nycab")
public class SimpleCabRestController {

	@Autowired
	private SimpleCabRepository cabTripDataRepository;

	@GetMapping(path = "/getCountByMedallionAndPickupDatetime")
	public @ResponseBody MedalionSummery[] getCountByMedallionAndPickupDatetime(
			@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("ignoreCache") boolean ignoreCache, @RequestParam("medallions") String... medallions) {

		MedalionSummery[] medalionSummeries = new MedalionSummery[medallions.length];

		int counter = 0;
		for (String medallion : medallions) {
			Integer tripCount = cabTripDataRepository.getCountByMedallionAndPickupDatetime(fromDate, medallion,
					ignoreCache);
			MedalionSummery medalionSummery = new MedalionSummery();
			medalionSummery.name = medallions[counter];
			medalionSummery.tripCount = tripCount;
			medalionSummeries[counter] = medalionSummery;
			counter++;
		}
		return medalionSummeries;

	}

	@GetMapping(path = "/emptyCache")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void empty() {
		cabTripDataRepository.deleteCache();
	}

}

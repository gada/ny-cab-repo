package com.datarepublic.simplecab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * @author Gady
 *
 */
@Service
public class SimpleCabServiceImpl implements SimpleCabService {
	private static final Logger log = LoggerFactory.getLogger(SimpleCabServiceImpl.class);

	private static final String BASE_URL_PATH = "http://localhost:8080/nycab/";
	private static final String GET_BY_MEDALLION_URL_CONST = BASE_URL_PATH + "getCountByMedallionAndPickupDatetime";
	private static final String EMPTY_CACHE_REQUEST = BASE_URL_PATH + "emptyCache";
	private static final String MEDALLIONS_CONST = "medallions";
	private static final String FROM_CONST = "from";
	private static final String IGNORE_CASHE_MODE = "ignoreCache";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void deleteCache() {
		emptyCache();
	}

	@Override
	public MedalionSummery[] getMedallionsSummary(String pickupDate, String... medallions) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(GET_BY_MEDALLION_URL_CONST)
				.queryParam(FROM_CONST, pickupDate).queryParam(MEDALLIONS_CONST, medallions)
				.queryParam(IGNORE_CASHE_MODE, false);

		long startExecutionTime = System.currentTimeMillis();

		MedalionSummery[] medalionSummeryies = restTemplate.getForObject(builder.toUriString(),
				MedalionSummery[].class);

		for (MedalionSummery currMedSum : medalionSummeryies) {
			System.out.println("Medallion trip summary:" + currMedSum.toString());
		}
		System.out.println("Execution time :" + (System.currentTimeMillis() - startExecutionTime) + "(ms).");
		return medalionSummeryies;

	}

	@Override
	public MedalionSummery[] getMedallionsSummary(String pickupDate, boolean ignoreCache, String... medallions) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(GET_BY_MEDALLION_URL_CONST)
				.queryParam(FROM_CONST, pickupDate).queryParam(MEDALLIONS_CONST, medallions)
				.queryParam(IGNORE_CASHE_MODE, ignoreCache);

		long startExecutionTime = System.currentTimeMillis();

		MedalionSummery[] medalionSummeryies = restTemplate.getForObject(builder.toUriString(),
				MedalionSummery[].class);

		for (MedalionSummery currMedSum : medalionSummeryies) {
			System.out.println("Medallion trip summary:" + currMedSum.toString());
		}
		System.out.println("Execution time :" + (System.currentTimeMillis() - startExecutionTime) + "(ms).");
		return medalionSummeryies;

	}

	/**
	 * 
	 * @param restTemplate
	 * @return
	 */
	private CommandLineRunner emptyCache() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(EMPTY_CACHE_REQUEST);
		return args -> {
			MedalionSummery[] medalionSummeryies = restTemplate.getForObject(builder.toUriString(),
					MedalionSummery[].class);
			long startExecutionTime = System.currentTimeMillis();
			for (MedalionSummery currMedSum : medalionSummeryies) {
				log.info("Medallion trip summary:" + currMedSum.toString());
			}
			log.info("Execution time :" + (System.currentTimeMillis() - startExecutionTime) + "(ms).");
		};
	}

}

package com.datarepublic.simplecab;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Gady
 *
 */
@SpringBootApplication
public class Application implements ApplicationRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private SimpleCabService simpleCabService;
	private Scanner scanner;

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Command-line arguments: {}", Arrays.toString(args.getSourceArgs()));

		while (true) {

			scanner = new Scanner(System.in);

			// prompt for the user's name
			System.out.print("Choose option:\n" + "(1)-Empty Cache\n" + "(2)-Get number of trips\n" + "(3)-Quit\n");

			// get their input as a String
			String mainOption = scanner.next();

			System.out.println("Option chosen:" + mainOption);

			if (mainOption.equals("3")) {
				System.exit(0);
			}
			else if (mainOption.equals("1")) {
				// Deal with empty cache requests
				simpleCabService.deleteCache();
			} else {
				// Deal with ignore cache option
				boolean isIgnoreCache = false;
				scanner = new Scanner(System.in);
				// prompt for the user's name
				System.out.print("Ignore cache ? yes/no\n");
				// get their input as a String
				String isIgnoreCacheInput = scanner.next();
				if (isIgnoreCacheInput.equals("yes")) {
					isIgnoreCache = true;
				} else {
					isIgnoreCache = false;
				}
				System.out.println("Ignore cache option chosen:" + isIgnoreCacheInput);

				// Deal with Pick up date
				scanner = new Scanner(System.in);
				// prompt for the user's name
				System.out.print("Enter pick up date:(Format:YYYY-MM-DD)\n");
				// get their input as a String
				String pickUpDate = scanner.next();
				if (pickUpDate == null || pickUpDate.isEmpty()) {
					throw new RuntimeException("Please enter pick up date.");
				} else {
					try {
						new SimpleDateFormat("YYYY-MM-DD");
					} catch (Exception e) {
						throw new RuntimeException("Wrong date format.(Format:YYYY-MM-DD)");
					}
				}
				System.out.println("Pick up date chosen:" + pickUpDate);

				// Deal with medallion list
				scanner = new Scanner(System.in);
				// prompt for the user's name
				System.out.print("Enter medallions list (comma separated)\n");
				// get their input as a String
				String medallionsInput = scanner.next();
				if (medallionsInput == null || medallionsInput.isEmpty()) {
					throw new RuntimeException("Please enter medallion list.");
				}
				System.out.println("Medallion list chosen:" + medallionsInput);
				// Deal with medallions summary requests

				simpleCabService.getMedallionsSummary(pickUpDate, isIgnoreCache, getMedallionsArr(medallionsInput));
			}
		}
	}

	/**
	 * 
	 * @param medallionsInput
	 * @return
	 */
	private String[] getMedallionsArr(String medallionsInput) {
		String[] medallionsArr = medallionsInput.split(",");
		return medallionsArr;
	}

}
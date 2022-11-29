package com.basics.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class DateTime {

	public static void main(String[] args) {
//	   Date today = new Date();
		LocalDate today = LocalDate.of(2022, Month.AUGUST, 15);
		System.out.println(today);

		LocalDateTime rightNow = LocalDateTime.of(2022, 5, 12, 5, 9, 6);
		System.out.println(rightNow);
		
		LocalTime timeNow = LocalTime.now(ZoneId.of("UTC"));
		System.out.println(timeNow);
	}

}

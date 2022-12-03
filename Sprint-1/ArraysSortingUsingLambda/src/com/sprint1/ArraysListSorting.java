package com.sprint1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysListSorting {

	public static void main(String[] args) {

		// course list by totalFees ascending
		List<CompetitiveExCourse> courseListPriceAsc = comExCourseArrayListData().stream()
				.sorted((a, b) -> a.getTotalFees().compareTo(b.getTotalFees())).collect(Collectors.toList());

		// course list by totalFees descending - method reference
//		List<CompetitiveExCourse> courseListPriceDesc = comExCourseArrayListData().stream()
//				.sorted(Comparator.comparing(CompetitiveExCourse::getTotalFees).reversed())
//				.collect(Collectors.toList());

		// course list by totalFees descending
		List<CompetitiveExCourse> courseListPriceDesc = comExCourseArrayListData().stream()
				.sorted((a, b) -> b.getTotalFees().compareTo(a.getTotalFees())).collect(Collectors.toList());

		// course list by duration ascending
		List<CompetitiveExCourse> courseListDurationAsc = comExCourseArrayListData().stream()
				.sorted(Comparator.comparing(CompetitiveExCourse::getCourseDurationInHours))
				.collect(Collectors.toList());

		System.out.println("Print course list by totalFees ascending:");
		courseListPriceAsc.forEach(System.out::println);
		System.out.println("Print course list by totalFees descending:");
		courseListPriceDesc.forEach(System.out::println);
		System.out.println("Print course list by duration ascending:");
		courseListDurationAsc.forEach(System.out::println);
	}

	public static List<CompetitiveExCourse> comExCourseArrayListData() {
		List<CompetitiveExCourse> courseList = new ArrayList<>();
		CompetitiveExCourse c1 = new CompetitiveExCourse(101, "CAT", "Sam", 53L, 50000L);
		CompetitiveExCourse c2 = new CompetitiveExCourse(102, "NEET", "Raju", 10L, 15000L);
		CompetitiveExCourse c3 = new CompetitiveExCourse(103, "JEE", "Kabil", 55L, 55000L);
		CompetitiveExCourse c4 = new CompetitiveExCourse(104, "UPSC", "Krishna", 150L, 150000L);
		CompetitiveExCourse c5 = new CompetitiveExCourse(105, "XAT", "Somu", 50L, 45000L);
		CompetitiveExCourse c6 = new CompetitiveExCourse(106, "IES", "Ram", 140L, 160000L);
		CompetitiveExCourse c7 = new CompetitiveExCourse(107, "SSC", "Siva", 24L, 20000L);
		CompetitiveExCourse c8 = new CompetitiveExCourse(108, "CLAD", "Ricky", 30L, 40000L);
		CompetitiveExCourse c9 = new CompetitiveExCourse(109, "CDS", "Rocky", 70L, 80000L);
		CompetitiveExCourse c10 = new CompetitiveExCourse(110, "LSAT", "Davyd", 50L, 25000L);
		CompetitiveExCourse c11 = new CompetitiveExCourse(111, "NDA", "Hafiz", 59L, 66000L);
		CompetitiveExCourse c12 = new CompetitiveExCourse(112, "FCI", "Andy", 40L, 48000L);
		CompetitiveExCourse c13 = new CompetitiveExCourse(113, "CEED", "Subash", 14L, 15000L);
		CompetitiveExCourse c14 = new CompetitiveExCourse(114, "GATE", "Santhosh", 25L, 30000L);
		CompetitiveExCourse c15 = new CompetitiveExCourse(115, "NID", "Rio", 120L, 130000L);

		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);
		courseList.add(c4);
		courseList.add(c5);
		courseList.add(c6);
		courseList.add(c7);
		courseList.add(c8);
		courseList.add(c9);
		courseList.add(c10);
		courseList.add(c11);
		courseList.add(c12);
		courseList.add(c13);
		courseList.add(c14);
		courseList.add(c15);
		return courseList;
	}

}

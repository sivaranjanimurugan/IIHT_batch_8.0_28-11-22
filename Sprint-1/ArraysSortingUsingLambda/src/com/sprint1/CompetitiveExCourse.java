package com.sprint1;

public class CompetitiveExCourse {

	private Integer courseId;

	private String courseName;

	private String courseTeacher;

	private Long courseDurationInHours;

	private Long totalFees;

	public CompetitiveExCourse(Integer courseId, String courseName, String courseTeacher, Long courseDurationInHours,
			Long totalFees) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
		this.courseDurationInHours = courseDurationInHours;
		this.totalFees = totalFees;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public Long getCourseDurationInHours() {
		return courseDurationInHours;
	}

	public void setCourseDurationInHours(Long courseDurationInHours) {
		this.courseDurationInHours = courseDurationInHours;
	}

	public Long getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(Long totalFees) {
		this.totalFees = totalFees;
	}

	@Override
	public String toString() {
		return "CompetitiveExCourse [courseId=" + courseId + ", courseName=" + courseName + ", courseTeacher="
				+ courseTeacher + ", courseDurationInHours=" + courseDurationInHours + ", totalFees=" + totalFees + "]";
	}
}
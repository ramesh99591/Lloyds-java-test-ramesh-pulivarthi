package com.lloyds.meeting.model;

import org.joda.time.Interval;
import org.joda.time.LocalTime;

public class Meeting implements Comparable<Meeting> {

	private String employeeId;
	private LocalTime meetingStartTime;
	private LocalTime meetingFinishTime;
	
	public Meeting(String employeeId, LocalTime meetingStartTime,LocalTime meetingFinishTime) {
		this.employeeId =employeeId;
		this.meetingStartTime =meetingStartTime;
		this.meetingFinishTime =meetingFinishTime;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public LocalTime getMeetingStartTime() {
		return meetingStartTime;
	}
	public void setMeetingStartTime(LocalTime meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}
	public LocalTime getMeetingFinishTime() {
		return meetingFinishTime;
	}
	public void setMeetingFinishTime(LocalTime meetingFinishTime) {
		this.meetingFinishTime = meetingFinishTime;
	}
	
	public int compareTo(Meeting that) {
		Interval meetingInterval = new Interval(meetingStartTime.toDateTimeToday(),
				meetingFinishTime.toDateTimeToday());
		Interval toCompareMeetingInterval = new Interval(that.getMeetingStartTime()
				.toDateTimeToday(), that.getMeetingFinishTime().toDateTimeToday());

		if (meetingInterval.overlaps(toCompareMeetingInterval)) {
			return 0;
		} else {
			return this.getMeetingStartTime().compareTo(that.getMeetingStartTime());
		}

	}
	
	
}

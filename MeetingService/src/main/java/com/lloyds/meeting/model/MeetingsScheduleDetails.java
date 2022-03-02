package com.lloyds.meeting.model;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.Map;
import java.util.Set;

public class MeetingsScheduleDetails {

	private LocalTime officeStartTime;

	private LocalTime officeFinishTime;

	private Map<LocalDate, Set<Meeting>> meetings;

	public MeetingsScheduleDetails(LocalTime officeStartTime,
			LocalTime officeFinishTime, Map<LocalDate, Set<Meeting>> meetings) {
		this.officeStartTime = officeStartTime;
		this.officeFinishTime = officeFinishTime;
		this.meetings = meetings;
	}

	public LocalTime getOfficeStartTime() {
		return officeStartTime;
	}

	public LocalTime getOfficeFinishTime() {
		return officeFinishTime;
	}

	public Map<LocalDate, Set<Meeting>> getMeetings() {
		return meetings;
	}

}
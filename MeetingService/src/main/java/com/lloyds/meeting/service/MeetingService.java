package com.lloyds.meeting.service;

import java.time.LocalDate;

import com.lloyds.meeting.model.MeetingsScheduleDetails;

public interface MeetingService {
	
	/**
	 * this method is used to get Meetings details
	 * @param inputData
	 * @return
	 */
	
	MeetingsScheduleDetails bookMeetingDetails(String inputData);


	
	

}

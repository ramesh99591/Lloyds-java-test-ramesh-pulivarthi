package com.lloyds.meeting.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lloyds.meeting.model.MeetingsScheduleDetails;
import com.lloyds.meeting.service.MeetingService;

@RestController
@RequestMapping("/meetings/v1")
public class MeetingController { 
	
	@Autowired
	MeetingService meetingService;
	
	
	/**
	 * will add swagger for documentation
	 * used to save Meetings
	 * @return
	 */
	@PostMapping(path="/bookMeeting",produces= {MediaType.APPLICATION_JSON_VALUE})
	public MeetingsScheduleDetails bookMeetingDetails(String inputData) {
		return meetingService.bookMeetingDetails(inputData);
				
	}
	
	

		
}

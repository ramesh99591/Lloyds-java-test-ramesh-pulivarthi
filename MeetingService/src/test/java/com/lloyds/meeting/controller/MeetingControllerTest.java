package com.lloyds.meeting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.lloyds.meeting.model.MeetingsScheduleDetails;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class MeetingControllerTest {

	@InjectMocks
	MeetingController MeetingController;
	
	@Test
	public void testBookMeetingDetails() {
		try {
		MeetingsScheduleDetails meetingsScheduleDetails = MeetingController.bookMeetingDetails("0900 1730\r\n"
				+ "2016-07-18 10:17:06 EMP001");
		Assert.assertNotNull(meetingsScheduleDetails);
		}catch (Exception e) {
			Assert.assertFalse("Exception occurred in testBookMeetingDetails", false);
		}
		
	}
}

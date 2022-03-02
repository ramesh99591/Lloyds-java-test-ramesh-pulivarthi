package com.lloyds.meeting.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.lloyds.meeting.model.MeetingsScheduleDetails;


@RunWith(MockitoJUnitRunner.class)
public class MeetingServiceImplTest {

	@InjectMocks
	MeetingServiceImpl meetingServiceImpl;
	
	@Test
	public void testBookMeetingDetailsForNoData() {
		try {
		MeetingsScheduleDetails meetingsScheduleDetails = meetingServiceImpl.bookMeetingDetails(null);
		Assert.assertNull(meetingsScheduleDetails);
		}catch (Exception e) {
			Assert.assertFalse("Exception occurred in testBookMeetingDetails", false);
		}
		
	}
	
	
	@Test
	public void testBookMeetingDetails() {
		try {
		MeetingsScheduleDetails meetingsScheduleDetails = meetingServiceImpl.bookMeetingDetails("0900 1730\r\n"
				+ "2016-07-18 10:17:06 EMP001\r\n"
				+ "2016-07-21 09:00 2");
		Assert.assertNotNull(meetingsScheduleDetails);
		}catch (Exception e) {
			Assert.assertFalse("Exception occurred in testBookMeetingDetails", false);
		}
		
	}

}

package com.lloyds.meeting.service.impl;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lloyds.meeting.model.Meeting;
import com.lloyds.meeting.model.MeetingsScheduleDetails;
import com.lloyds.meeting.repository.MeetingRepository;
import com.lloyds.meeting.service.MeetingService;
import com.lloyds.meeting.service.utils.IConstants;

public class MeetingServiceImpl implements MeetingService{
	
	@Autowired
	MeetingRepository meetingRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public MeetingsScheduleDetails bookMeetingDetails(String meetingRequest) {
		try {
			if (meetingRequest == null || meetingRequest.isEmpty()) {
				System.out.println("Employee requested booking is not a valid input");//will add loggers
				return null;
			}

			String[] requestLines = meetingRequest.split(IConstants.NEW_LINE);

			String[] officeHoursTokens = requestLines[0].split(IConstants.SPACE);
			LocalTime officeStartTime = new LocalTime(Integer.parseInt(officeHoursTokens[0].substring(0, 2)),Integer.parseInt(officeHoursTokens[0].substring(2, 4)));
			LocalTime officeFinishTime = new LocalTime(Integer.parseInt(officeHoursTokens[1].substring(0, 2)),Integer.parseInt(officeHoursTokens[1].substring(2, 4)));

			Map<LocalDate, Set<Meeting>> meetings = new HashMap<LocalDate, Set<Meeting>>();

			for (int i = 1; i < requestLines.length; i = i + 2) {

				String[] meetingSlotRequest = requestLines[i + 1].split(IConstants.SPACE);
				LocalDate meetingDate = IConstants.DATE_FORMATTER.parseLocalDate(meetingSlotRequest[0]);

				Meeting meeting = extractMeeting(requestLines[i],officeStartTime, officeFinishTime, meetingSlotRequest);
				if (meeting != null) {
					if (meetings.containsKey(meetingDate)) {
						meetings.get(meetingDate).remove(meeting);
						meetings.get(meetingDate).add(meeting);
					} else {
						Set<Meeting> meetingsForDay = new TreeSet<Meeting>();
						meetingsForDay.add(meeting);
						meetings.put(meetingDate, meetingsForDay);
					}
				}
			}

			return new MeetingsScheduleDetails(officeStartTime, officeFinishTime,
					meetings);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	private Meeting extractMeeting(String requestLine,
			LocalTime officeStartTime, LocalTime officeFinishTime,
			String[] meetingSlotRequest) {
		String[] employeeRequest = requestLine.split(" ");
		String employeeId = employeeRequest[2];

		LocalTime meetingStartTime = IConstants.SEPARATED_TIME_FORMAT.parseLocalTime(meetingSlotRequest[1]);
		LocalTime meetingFinishTime = new LocalTime(meetingStartTime.getHourOfDay(),meetingStartTime.getMinuteOfHour()).plusHours(Integer.parseInt(meetingSlotRequest[2]));

		if (meetingTimeOutsideOfficeHours(officeStartTime, officeFinishTime,
				meetingStartTime, meetingFinishTime)) {
			System.out.println("Employee :: " + employeeId+ " has requested booking which is outside office hour.");
			return null;
		} else {
			return new Meeting(employeeId, meetingStartTime, meetingFinishTime);

		}
	}
	
	private boolean meetingTimeOutsideOfficeHours(LocalTime officeStartTime,
			LocalTime officeFinishTime, LocalTime meetingStartTime,
			LocalTime meetingFinishTime) {
		return meetingStartTime.isBefore(officeStartTime)
				|| meetingStartTime.isAfter(officeFinishTime)
				|| meetingFinishTime.isAfter(officeFinishTime)
				|| meetingFinishTime.isBefore(officeStartTime);
	}



}

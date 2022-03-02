package com.lloyds.meeting.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEETING")
public class MeetingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="TB_MEETING_ID_SEQ")
	@SequenceGenerator(sequenceName ="TB_MEETING_ID_SEQ", name = "TB_MEETING_ID_SEQ" )
	private Long meetingID;
	private String userId;
	private Date meetingStartTime;
	private Date meetingEndTime;
	private Date userRequestedTime;
	

}

package com.lloyds.meeting.service.utils;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public interface IConstants {
	
	DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");
	DateTimeFormatter SEPARATED_TIME_FORMAT = DateTimeFormat.forPattern("HH:mm");
	String NEW_LINE="\n";
	String SPACE=" ";

}

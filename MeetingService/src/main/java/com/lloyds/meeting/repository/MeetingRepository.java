package com.lloyds.meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lloyds.meeting.entity.MeetingEntity;

public interface MeetingRepository extends JpaRepository<MeetingEntity, Long> { 
	

}

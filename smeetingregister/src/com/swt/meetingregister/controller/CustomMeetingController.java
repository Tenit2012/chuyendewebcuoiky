/**
 * 
 */
package com.swt.meetingregister.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.swt.meeting.domain.Meeting;
import com.swt.meeting.domain.MeetingInvitation;
import com.swt.meeting.domain.OrganizationMeeting;
import com.swt.meeting.impls.MeetingController;
import com.swt.meeting.impls.MeetingInvitationController;
import com.swt.meeting.impls.OrganizationMeetingController;
import com.swt.meetingregister.customobject.CustomMeeting;

/**
 * @author Tenit
 *
 */
public class CustomMeetingController {

	public static final CustomMeetingController Instance = new CustomMeetingController();

	@SuppressWarnings("deprecation")
	public CustomMeeting getCustomMeeting(String barcode){
		CustomMeeting customMeeting = new CustomMeeting();
		MeetingInvitation meetingInvitation = MeetingInvitationController.Instance
				.getMeetingInvitationByBarcode(barcode);
		if(null != meetingInvitation){
		Meeting meeting = MeetingController.Instance.getMeetingById(meetingInvitation.getMeetingid());
		OrganizationMeeting organizationMeeting = OrganizationMeetingController.Instance
				.getOrganizationMeetingById(meetingInvitation.getOrganizationAttendId());
		customMeeting.setBarcode(barcode);
		customMeeting.setOrgMeetingName(meeting.getOrganizationMeetingName());
		customMeeting.setPartaker(organizationMeeting.getName());
		customMeeting.setDetailMeeting(meeting.getName());
		customMeeting.setOrgattendId(meetingInvitation.getOrganizationAttendId());
		Date date = meeting.getStartTime();
		customMeeting.setHour(date.getHours());
		customMeeting.setMinute(date.getMinutes());
		}
		return customMeeting;
		
	}

}

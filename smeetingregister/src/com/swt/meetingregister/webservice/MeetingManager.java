/**
 * 
 */
package com.swt.meetingregister.webservice;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sworld.common.ResultObject;
import com.sworld.common.Status;
import com.swt.meeting.domain.Meeting;
import com.swt.meeting.impls.MeetingController;
import com.swt.meetingregister.common.Define;
import com.swt.meetingregister.controller.CustomMeetingController;
import com.swt.meetingregister.customobject.CustomMeeting;

/**
 * @author Tenit
 *
 */
@Path(Define.MEETING_REGISTER)
@Produces(Define.APPLICATION_JSON)
public class MeetingManager {
	
	@GET
	@Path(Define.GET_LIST_MEETING_BY_DATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultObject getListMeetingByDate(){
		ResultObject result = new ResultObject(Status.FAILED);
		Date paraDate = new Date();
		
		List<Meeting> account = MeetingController.Instance.getMeetingByDateTime(paraDate);

		if (account != null) {
			result.setStatus(Status.SUCCESS);
		} else {
			result.setStatus(Status.FAILED);
		}
		result.setObj(account);

		return result;
	}
	

	
	@GET
	@Path(Define.GET_DETAIL_MEETING_BY_BARCODE + "/{barcode}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultObject getDetailMeetingByBarCode(@PathParam("barcode") String barcode){
		ResultObject result = new ResultObject(Status.FAILED);
		CustomMeeting customMeeting = CustomMeetingController.Instance.getCustomMeeting(barcode);
		if (customMeeting != null) {
			result.setStatus(Status.SUCCESS);
		} else {
			result.setStatus(Status.FAILED);
		}
		result.setObj(customMeeting);

		
		return result;
	}
}

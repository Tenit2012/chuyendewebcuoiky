/**
 * 
 */
package com.swt.meetingregister.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.RandomStringUtils;

import com.sworld.common.ResultObject;
import com.sworld.common.Status;
import com.swt.meeting.domain.Partaker;
import com.swt.meeting.impls.PartakerController;
import com.swt.meetingregister.common.Define;
import com.swt.meetingregister.controller.RegisterAccountController;
import com.swt.meetingregister.doman.Account;
import com.swt.sworld.common.errors.ErrorCode;

/**
 * @author Tenit
 *
 */
@Path(Define.PARTAKER)
@Produces(MediaType.APPLICATION_JSON)
public class PartakerMangager {
	
	@POST
	@Path(Define.INSERT_PARTAKER)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultObject InsertPartaker(Partaker partaker) {
		String barcode =RandomStringUtils.randomNumeric(13); 
		partaker.setBarcode(Long.parseLong(barcode));
		ResultObject result = new ResultObject(Status.FAILED);
		Partaker partakerResult = PartakerController.Instance.insert(partaker);
		if (partakerResult != null) {
			result.setStatus(Status.SUCCESS);
		} else {
			result.setStatus(Status.FAILED);
		}
		result.setObj(partakerResult);
		return result;
	}
	@POST
	@Path(Define.UPDATE_PARTAKER)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultObject updatePartaker(Partaker partaker) {
		ResultObject result = new ResultObject(Status.FAILED);
		Partaker partakerResult = PartakerController.Instance.update(partaker);
		if (partakerResult != null) {
			result.setStatus(Status.SUCCESS);
		} else {
			result.setStatus(Status.FAILED);
		}
		result.setObj(partakerResult);
		return result;
	}
	@GET
	@Path(Define.DELETE_PARTAKER+"/{idPartaker}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultObject deletePartaker(@PathParam("idPartaker") long idPartaker) {
		ResultObject result = new ResultObject(Status.FAILED);
		int partakerResult = PartakerController.Instance.delete(idPartaker);
		if (partakerResult == ErrorCode.SUCCESS) {
			result.setStatus(Status.SUCCESS);
		} else {
			result.setStatus(Status.FAILED);
		}
		return result;
	}
	@GET
	@Path(Define.GET_LIST_PARTAKER_BY_ORGID + "/{orgPartakerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultObject getPartakerByOrgPartakerId(@PathParam("orgPartakerId") long orgPartakerId) {
		ResultObject result = new ResultObject(Status.FAILED);
		List<Partaker> partakerResult = PartakerController.Instance.getPartakerByOrgPartakerId(orgPartakerId);
		if (partakerResult != null) {
			result.setStatus(Status.SUCCESS);
		} else {
			result.setStatus(Status.FAILED);
		}
		result.setObj(partakerResult);
		return result;
	}
}

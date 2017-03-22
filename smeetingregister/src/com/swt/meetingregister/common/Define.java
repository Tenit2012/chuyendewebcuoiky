/**
 * 
 */
package com.swt.meetingregister.common;

import javax.ws.rs.core.MediaType;

/**
 * @author Tenit
 *
 */
public class Define {
	public static final String APPLICATION_JSON = MediaType.APPLICATION_JSON + "; charset=utf-8";

	public static final String ACCOUNT = "/acount";
	public static final String PARTAKER = "/partaker";
	public static final String MEETING_REGISTER = "/meetingregister";
	public static final String LOGIN = "/login";
	public static final String INSERT = "/insert";
	public static final String UPDATE = "/update";
	public static final String DELETE = "/delete";
	public static final String GETALL = "/getall";
	public static final String GET_LIST_MEETING_BY_DATE = "/getlistmeetingbydate";
	public static final String GET_DETAIL_MEETING_BY_BARCODE = "/getdetailmeetingbybarcode";
	public static final String INSERT_PARTAKER = "/insertpartaker";
	public static final String UPDATE_PARTAKER = "/updatepartaker";
	public static final String DELETE_PARTAKER = "/deletepartaker";
	public static final String GET_ALL_PARTAKER = "/getallpartaker";
	public static final String GET_LIST_PARTAKER_BY_ORGID = "/getlistpartakerbyorgid";
	

}

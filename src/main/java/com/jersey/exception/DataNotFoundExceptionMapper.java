package com.jersey.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.jersey.model.*;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException de) {
		
		ErrorMessage me=new ErrorMessage("Content Not Found...!!",404,"www.sanjaybankar.co.in");
		
		return Response.status(Status.NOT_FOUND)
				.entity(me)
				.build();
	}

}

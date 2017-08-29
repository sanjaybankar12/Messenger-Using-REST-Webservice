package com.jersey.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/injectdemo")
public class InjectDemoResource {

	@GET
	@Path("/annotation")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamUsingAnnotation(@MatrixParam("matrix1") String matrix,@CookieParam("cookie") String cookie,@HeaderParam("myheader") String header)
	{
		return "Param Annotation, \n Matrix Param ="+matrix+"\n header =>"+header+",\n cookie=>"+cookie;
	}
	
	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders headers)
	{
		String path=uriInfo.getAbsolutePath().toString();
		
		return "Path=>"+path+",\nCookie=>"+headers.getCookies()+",\nHeaders=>"+headers.getRequestHeaders();
	}
}

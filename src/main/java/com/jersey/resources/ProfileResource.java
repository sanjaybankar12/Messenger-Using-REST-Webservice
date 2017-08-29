package com.jersey.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.jersey.model.Profile;
import com.jersey.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	@GET
	public List<Profile> getProfiles()
	{
		return new ProfileService().getProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile)
	{
		return new ProfileService().addProfile(profile);
	}	
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName)
	{
		return new ProfileService().getProfileByName(profileName);
	}	
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile)
	{
		profile.setProfileName(profileName);
		return new ProfileService().updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteProfile(@PathParam("profileName") String profileName)
	{
		return new ProfileService().deleteProfile(profileName);
	}
	
}

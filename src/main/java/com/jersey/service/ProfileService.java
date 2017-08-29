package com.jersey.service;

import java.util.*;

import com.jersey.database.DatabaseClass;
import com.jersey.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles=DatabaseClass.getProfiles();
	
	public ProfileService()
	{
		Profile p=new Profile(1,"Sanjay","Bnakar","sanjaybankar12");
		
		profiles.put(p.getProfileName(), p);
	}
	
	public List<Profile> getProfiles()
	{
		List<Profile> list=new ArrayList<>(profiles.values());
		
		return list;
	}
	
	public Profile getProfileByName(String profileName)
	{
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile)
	{
		if(profile.getProfileName().isEmpty())
			return null;
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile)
	{		
		profiles.put(profile.getProfileName(), profile);
		
		return profile;
	}
	
	public Profile deleteProfile(String profileName)
	{				
		return profiles.remove(profileName);
	}
	
}

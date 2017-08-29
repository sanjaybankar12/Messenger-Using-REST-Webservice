package com.jersey.database;

import com.jersey.model.*;
import java.util.*;

public class DatabaseClass {

	public static Map<Integer,Message> messages=new HashMap<>();
	public static Map<String,Profile> profiles=new HashMap<>();
	
	public static Map<Integer, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Integer, Message> messages) {
		DatabaseClass.messages = messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<String, Profile> profiles) {
		DatabaseClass.profiles = profiles;
	}
	
	
}

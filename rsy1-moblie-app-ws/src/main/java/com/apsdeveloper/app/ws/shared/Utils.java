package com.apsdeveloper.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
	public String generateUserID() {
		return UUID.randomUUID().toString();
	}
}

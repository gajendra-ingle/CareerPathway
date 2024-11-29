package com.jbk.enums;

public enum UserRole {
	ADMIN("Admin"), 
	COLLEGE("College"),
	COMPANY("Company");

	private final String description;

	UserRole(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

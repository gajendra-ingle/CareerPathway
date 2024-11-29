package com.jbk.enums;

public enum ApplicationStatus {

	APPLIED("APPLIED"), APPROVED("APPROVED"), REJECTED("REJECTED");

	private final String description;

	ApplicationStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

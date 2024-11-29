package com.jbk.enums;

public enum InterviewStatus {

	SCHEDULED("Scheduled"),
	COMPLETED("Completed"),
	CANCELLED("Cancelled");

	private final String description;

	InterviewStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

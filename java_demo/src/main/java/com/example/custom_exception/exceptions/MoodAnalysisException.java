package com.example.custom_exception.exceptions;

public class MoodAnalysisException extends Exception {

	private static final long serialVersionUID = 1L;

	public MoodAnalysisException(String msg) {
		super(msg);
	}

}

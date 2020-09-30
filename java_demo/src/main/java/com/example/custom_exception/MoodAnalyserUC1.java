package com.example.custom_exception;

public class MoodAnalyserUC1 {

	private class MoodAnalyser {

		private void analyseMood(String msg) {
			if (msg.toLowerCase().contains("sad"))
				System.out.println("SAD");
			else
				System.out.println("HAPPY");
		}

	}
	
	
	public static void main(String[] args) {
		MoodAnalyserUC1 moodAnalyser = new MoodAnalyserUC1();
		MoodAnalyser mood = moodAnalyser.new MoodAnalyser();
		
		mood.analyseMood("I am in Sad Mood");
		mood.analyseMood("I am in Any Mood");
	}
}

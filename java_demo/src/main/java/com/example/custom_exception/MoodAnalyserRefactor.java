package com.example.custom_exception;

public class MoodAnalyserRefactor {

	private class MoodAnalyser {
		private String mood;

		public MoodAnalyser() {
			// TODO Auto-generated constructor stub
		}

		public MoodAnalyser(final String mood) {
			this.mood = mood;
		}

		private void analyseMood() {
			if (this.mood.toLowerCase().contains("sad"))
				System.out.println("SAD");
			else
				System.out.println("HAPPY");
		}
	}

	public static void main(String[] args) {

		MoodAnalyserRefactor moodAnalyser = new MoodAnalyserRefactor();
		MoodAnalyser mood = moodAnalyser.new MoodAnalyser("I am in Any Mood");
		mood.analyseMood();
	}
}

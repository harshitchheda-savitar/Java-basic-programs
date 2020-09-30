package com.example.custom_exception;

public class MoodAnalyserUC2 {
	private class MoodAnalyser {
		private String mood;

		public MoodAnalyser() {
			// TODO Auto-generated constructor stub
		}

		public MoodAnalyser(final String mood) {
			this.mood = mood;
		}

		private void analyseMood() {
			try {
				if (this.mood == null)
					throw new Exception();
				if (this.mood.toLowerCase().contains("sad"))
					System.out.println("SAD");
				else
					System.out.println("HAPPY");
			} catch (Exception e) {
				System.out.println("HAPPY");
			}
		}
	}

	public static void main(String[] args) {

		MoodAnalyserUC2 moodAnalyser = new MoodAnalyserUC2();
		MoodAnalyser mood = moodAnalyser.new MoodAnalyser();
		mood.analyseMood();
	}
}

package com.example.custom_exception;

import com.example.custom_exception.exceptions.MoodAnalysisException;

public class MoodAnalyserUC3 {
	private class MoodAnalyser {
		private String mood;

		public MoodAnalyser() {
			// TODO Auto-generated constructor stub
		}

		public MoodAnalyser(final String mood) {
			this.mood = mood;
		}

		private void analyseMood() throws MoodAnalysisException {
			if (this.mood == null)
				throw new MoodAnalysisException("NULL MOOD");
			else if (this.mood.equals(""))
				throw new MoodAnalysisException("Empty Mood");
			else if (this.mood.toLowerCase().contains("sad"))
				throw new MoodAnalysisException("SAD Mood");
			else
				throw new MoodAnalysisException("Happy Mood");
		}
	}

	public static void main(String[] args) throws MoodAnalysisException {

		try {
			MoodAnalyserUC3 moodAnalyser = new MoodAnalyserUC3();
			MoodAnalyser mood = moodAnalyser.new MoodAnalyser("I am in SAd Mood");
			mood.analyseMood();
		} catch (MoodAnalysisException e) {
			System.out.println(e.getClass() + ":" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getClass() + ":" + e.getMessage());
		}
	}
}

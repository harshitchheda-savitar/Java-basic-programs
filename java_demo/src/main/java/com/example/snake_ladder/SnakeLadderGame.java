package com.example.snake_ladder;

import java.util.Random;

public class SnakeLadderGame {
	public static void main(String[] args) {
		
		Random diceValue = new Random();
		Random optionValue = new Random();
		final int WIN_STEP = 100;
		final int START_POSITION = 0;
		final int LADDER = 1;
		final int SNAKE = 2;
		int currentPosition = START_POSITION;
		int optionFlag;
		int diceCount;
		
		System.out.println("currentPosition : " + currentPosition);
		System.out.println("-------------------------------------------------");

		
		while(currentPosition >=START_POSITION && currentPosition < WIN_STEP) {
			diceCount = diceValue.nextInt(6) + 1;
			optionFlag = optionValue.nextInt(3);
			
			System.out.println("dice value: "+ diceCount);
			
			switch(optionFlag) {
			case LADDER:
				currentPosition += ((currentPosition + diceCount) <= WIN_STEP) ? diceCount : 0;
				System.out.println("Found a ladder.... currentPosition : " + currentPosition);
				break;
			case SNAKE:
				currentPosition -= ((currentPosition - diceCount) >= START_POSITION) ? diceCount : currentPosition;
				System.out.println("Bitten by a snake.... currentPosition : " + currentPosition);
				break;
			default:
				System.out.println("No movement.... currentPosition : " + currentPosition);
				break;
				
			}
			System.out.println("-------------------------------------------------");
		}
		
		//System.out.println("Dice count: " + count);
		
	}
}

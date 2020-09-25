package com.example.snake_ladder;

import java.util.Random;

public class SnakeLadderGame {
	
	final static int START_POSITION = 0;
	final static int WIN_STEP = 100;
	final static int LADDER = 1;
	final static int SNAKE = 2;
	
	public static void main(String[] args) {
		
		int[] currentPosition = {START_POSITION,START_POSITION};
		SnakeLadderGame.gamePlay(currentPosition);
		System.out.println("Player "  + (currentPosition[0] > currentPosition[1] ? 1 : 2) + " won!!!");
	}
	
	public static void gamePlay(int[] currentPosition) {
		Random diceValue = new Random();
		Random optionValue = new Random();
		
		int optionFlag;
		int diceCount;
		
		int playerChance = 0;
		
		while(true) {
			System.out.println("player : " + (playerChance + 1));
			diceCount = diceValue.nextInt(6) + 1;
			optionFlag = optionValue.nextInt(3);
			
			System.out.println("dice value: "+ diceCount);
			
			switch(optionFlag) {
			case LADDER:
				currentPosition[playerChance] += ((currentPosition[playerChance] + diceCount) <= WIN_STEP) ? diceCount : 0;
				System.out.println("Found a ladder.... currentPosition : " + currentPosition[playerChance]);
				break;
			case SNAKE:
				currentPosition[playerChance] -= ((currentPosition[playerChance] - diceCount) >= START_POSITION) ? diceCount : currentPosition[playerChance];
				System.out.println("Bitten by a snake.... currentPosition : " + currentPosition[playerChance]);
				break;
			default:
				System.out.println("No movement.... currentPosition : " + currentPosition[playerChance]);
				break;
			}
			
			System.out.println("-------------------------------------------------");
			
			
			if(!(currentPosition[playerChance] >=START_POSITION && currentPosition[playerChance] < WIN_STEP && currentPosition[(playerChance+1)%2] >=START_POSITION && currentPosition[(playerChance+1)%2] < WIN_STEP)) 
				break;
			playerChance = optionFlag == LADDER ? playerChance : (playerChance + 1) % 2;
		}
	
	}
}

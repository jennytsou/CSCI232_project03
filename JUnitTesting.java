package Project03;

import java.util.Arrays;

/*
 * CSCI232: Project03 part2, 
 * Yueh-Chen Tsou
 * 5/28/2019
 * The change-making problem, aka minimum coin change problem, addresses the question of finding
 * the minimum number of coins that add up to a given amount of money.
 * .MakingChaningTest class hold JUnit tests with five test cases.
 * .One test case expect on Exception when an empty array of coins is sent in as a parameter.
 * .coinChange method hands on throw an Exception if the array of coins sent in as a parameter is empty.
 *   
 */

public class JUnitTesting {
	static int[] myCoins = new int[100];
	public int coinChange(int[] coins, int amount) {
		
		if (coins == null) 
			throw new NullPointerException("Can't handle null arrays");
		if (coins.length == 0)
			throw new IllegalArgumentException("Can't handle null arrays");	
	
		Arrays.sort(coins);		// arrange the coins in ascending order of value
		int numcoins = coinchange(coins, amount, coins.length-1, 0);
		System.out.print("\n\nThe change-making of " + amount +" to ");	
		System.out.print(Arrays.toString(coins));
		
		if (numcoins == -1)	{
			System.out.println("\nThe amount: " + amount + " can't make changing.");
			return numcoins;
		}
		
		System.out.print("\nis [");
		int i=0;
		while(i<numcoins-1) {
			System.out.print(myCoins[i] + ", ");
			i++;
		}
		System.out.print(myCoins[i] + "]");
		return numcoins;		// return the number of coins would be changed
	}
	
	public static int coinchange(int[] coins, int amount, int index, int numCoins ) {
		
		if(amount == 0)
			return numCoins;
		if(amount < coins[0])		// return -1 if the amount less than smallest value of coin 
			return -1;				
		if (amount >= coins[index]) {	// change-making from the largest value to smaller value
			int tempCoins = (int) amount/coins[index];			// make a change
			int tempAmount = amount - tempCoins*coins[index];	// decrease the amount after change-making
			
			for(int i=numCoins; i<numCoins + tempCoins; i++) 	// store the coins of change-making into an array 
				myCoins[i] = coins[index];
			
			amount =tempAmount;
			numCoins += tempCoins;
		}
		index--;
		return coinchange(coins, amount, index, numCoins);
	}
}

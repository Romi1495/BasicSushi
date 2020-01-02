package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code here.
		int numIng = scan.nextInt();
		String[] ingredients = new String[numIng];
		double[] prices = new double[numIng];
		int[] calories = new int[numIng];
		boolean[] vegetarian = new boolean[numIng];
		for (int i = 0; i < numIng; i++) {
			String ingName = scan.next(); 
			double ingPrice = scan.nextDouble();
			boolean isVeg = scan.nextBoolean();
			int ingCals = scan.nextInt();
			ingredients[i] = ingName;
			prices[i] = ingPrice;
			calories[i] = ingCals;
			vegetarian[i] = isVeg;
		}
		int numDishes = scan.nextInt();
		for (int j = 0; j < numDishes; j++) {
			boolean dishVeg = true;
			double dishPrice = 0.00;
			double calsDish = 0.00;
			String dishName = scan.next();
			int numIngs = scan.nextInt();
			for (int k = 0; k < numIngs; k++) {
				String ing = scan.next();
				double ingOunces = scan.nextDouble();
				int ingIndex = findIndex(ing, ingredients);
				double priceIng = prices[ingIndex];
				int calsOunce = calories[ingIndex];
				dishPrice += priceIng * ingOunces;
				calsDish += calsOunce * ingOunces;
				if (!vegetarian[ingIndex]) {
					dishVeg = false;
				}
			}
			System.out.println(dishName + ": ");
			System.out.println(((int) (calsDish + 0.5)) + " calories");
			System.out.println('$' + String.format("%.2f", dishPrice));
			if (dishVeg) {
				System.out.println("Vegetarian");
			} 
			if (!dishVeg){
				System.out.println("Non-Vegetarian");
			}
		}
		scan.close();
	}
	
	// You can define helper methods here if needed.
	// This method takes in a string (The name of the item whose index we want to retrieve) and an array (The array of products)
	public static int findIndex(String ing, String[] ingredients) {
		// Loop through the array of products and test if the name matches one of the items in the array
		for (int k = 0; k < ingredients.length; k++) {
			// If there is a match, return the current index
			if (ingredients[k].equals(ing)) {
				return k;
			}
		}
		return 0;
	}
}

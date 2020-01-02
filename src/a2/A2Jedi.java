package a2;
import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Your code here.
		int numIng = scan.nextInt();
		String[] ingredients = new String[numIng];
		double[] prices = new double[numIng];
		int[] calories = new int[numIng];
		double[] amountIng = new double[numIng];
		for (int i = 0; i < numIng; i++) {
			String ingName = scan.next(); 
			double ingPrice = scan.nextDouble();
			boolean isVeg = scan.nextBoolean();
			int ingCals = scan.nextInt();
			ingredients[i] = ingName;
			prices[i] = ingPrice;
			calories[i] = ingCals;
			amountIng[i] = 0;
		}
		int numDishes = scan.nextInt();
		String[] dishNames = new String[numDishes];
		double[][] dishAmounts = new double[numDishes][numIng];
		for (int j = 0; j < numDishes; j++) {
			String dishName = scan.next();
			int numIngs = scan.nextInt();
			dishNames[j] = dishName;
			double[] currentAmounts = new double[numIng];
			for (int k = 0; k < numIngs; k++) {
				String ing = scan.next();
				double ingOunces = scan.nextDouble();
				int ingIndex = findIndex(ing, ingredients);
				currentAmounts[ingIndex] = ingOunces;
			}
			dishAmounts[j] = currentAmounts;
			
		}
		boolean moreDishes = true;
		while (moreDishes) {
			String nextDish = scan.next(); 
			if (nextDish.equals("EndOrder")) {
				moreDishes = false;
			} 
			else {
				int currentDish = findIndex(nextDish, dishNames);
				for (int k = 0; k < numIng; k++) {
					amountIng[k] += dishAmounts[currentDish][k];
				}
			}
		}
		scan.close();
		System.out.println("The order will require:");
		for (int k = 0; k < numIng; k++) {
			System.out.println(String.format("%.2f", amountIng[k]) + " ounces of " + ingredients[k]);
		}
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
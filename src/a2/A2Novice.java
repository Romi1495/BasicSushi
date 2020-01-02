package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code here.
		int numIng = scan.nextInt();
		int numVeg = 0; 
		String maxCals = "";
		String minCals = ""; 
		double maxCalsDollar = 0.00;
		double minCalsDollar = 0.00;
		for (int i = 0; i < numIng; i++) {
			String ingName = scan.next(); 
			double ingPrice = scan.nextDouble();
			boolean isVeg = scan.nextBoolean(); 
			int ingCals = scan.nextInt();
			if (isVeg) {
				numVeg += 1;
			}
			double calsDollar = ingCals / ingPrice;
			if (i == 0) {
				minCals = ingName;
				minCalsDollar = calsDollar;
			}
			if (calsDollar < minCalsDollar) {
				minCals = ingName; 
				minCalsDollar = calsDollar;
			}
			if (calsDollar > maxCalsDollar) {
				maxCals = ingName;
				maxCalsDollar = calsDollar;
			}
		}
		scan.close();
		System.out.println("Number of vegetarian ingredients: " + numVeg);
		System.out.println("Highest cals/$: " + maxCals);
		System.out.println("Lowest cals/$: " + minCals);
	}
	
	// You can define helper methods here if needed.
	
}

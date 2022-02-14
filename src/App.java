import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		
		ArrayList<int[]> testCases = new ArrayList<int[]>();
		
		int[] test0 = {15};
		int[] test1 = {1, 2, 3, 4, 5, 6};
		int[] test2 = {5, 8, 2, 8, 9, 0};
		int[] test3 = {-9, 10, 16, 20, -4};
		
		int[] targets = {15, 7, 17, 7};
		
		testCases.add(test0);
		testCases.add(test1);
		testCases.add(test2);
		testCases.add(test3);
		
		System.out.println("test");
		
		System.out.println("testCases using brute force: ");
		for(int i = 0; i < testCases.size(); i++) {
			
			int[] result = twoNumSumBruteForce(testCases.get(i), targets[i]);
			
			if(result.length == 0) {
				System.out.println("test" + i + ": has no solution.");
			}
			else {
				System.out.print("test" + i + ": " + result[0] + ", " + result[1] + ". target = " + targets[i] + "\n");
			}	
			
		}
		
		System.out.println("\ntestCases using linear time method: ");
		for(int i = 0; i < testCases.size(); i++) {
			
			int[] result = twoNumSum(testCases.get(i), targets[i]);
			
			if(result.length == 0) {
				System.out.println("test" + i + ": has no solution.");
			}
			else {
				System.out.print("test" + i + ": " + result[0] + ", " + result[1] + ". target = " + targets[i] + "\n");
			}	
			
		}

	}
	
	// Function takes an unordered array of discrete integers and returns an array of two numbers that sum up to target
	// Returns an empty array if no such elements were found
	// Time: O(n^2) where n is the length of the array
	// Space:O(1) since we do not create new data structures and simply use information from array
	public static int[] twoNumSumBruteForce(int[] array, int target) {
		// For each element on array test summing against all other elements of array
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if(array[i] + array[j] == target) {
					return new int[] {array[i], array[j]};
				}
			}
		}
		
		return new int[0];
	}
	
	// Function takes an unordered array of discrete integers and returns an array of two numbers that sum up to target
	// Returns an empty array if no such elements were found
	// Time: O(n) where n is the length of the array
	// Space: O(n) because we create a new element each iteration of the array
	public static int[] twoNumSum(int[] array, int target) {
		
		Set<Integer> mySet = new HashSet<Integer>();
		
		// For each element in array search to see if diference exists in the array by adding them to a HashSet
		// If the HashSet contains the diference somewhere in the array then it is a match for our sum
		for(int current : array) {
			int difference = target - current;
			
			if(mySet.contains(difference)) {
				return new int[] {current, difference};
			}
			else {
				mySet.add(current);
			}

		}
			
		return new int [0];
	}
	
	public static void printTestCases(ArrayList<int[]> testCases, int[] targets) {
		
	}
}

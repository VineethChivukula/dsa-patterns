/*
 * Problem Statement:
 * Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * 
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * 
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * 
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * 
 * Constraints:
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * 
 * Thought Process::
 * Approach 1:
 * We will use two for loops to find the two numbers that add up to the target.
 * The outer loop will iterate over the array and the inner loop will iterate from the next element to the end of the array.
 * If the sum of the two numbers is equal to the target, we will return the indices of the two numbers.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n^2) since we are using two for loops.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) as we are not using any extra space.
 * 
 * Drawback of this approach:
 * This approach takes a lot of time to find the two numbers because of the nested loops.
 * 
 * Approach 2:
 * We will be using a HashMap to store the elements of the array along with their indices.
 * We will iterate over the array and check if the difference between the target and the current element is present in the HashMap.
 * If it is present, we will return the indices of the two numbers.
 * If it is not present, we will add the current element to the HashMap.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) since we are iterating over the array only once.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) since we are using a HashMap to store the elements of the array.
 * 
 * Drawback of this approach:
 * This approach uses extra space to store the elements of the array.
 * 
 * Efficient Approach:
 * We will use two pointers i and j, where i will be pointing to the first element and j will be pointing to the last element.
 * We will calculate the sum of the elements at i and j.
 * If the sum is equal to the target, we will return the indices of the two numbers.
 * If the sum is less than the target, we will increment i.
 * If the sum is greater than the target, we will decrement j.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) since we are iterating over the array only once.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) as we are not using any extra space.
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIInputArrayIsSorted {
	public static int[] approach1(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target)
					return new int[] { i + 1, j + 1 };
			}
		}
		return new int[] {};
	}

	public static int[] approach2(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i]))
				return new int[] { map.get(target - numbers[i]) + 1, i + 1 };
			map.put(numbers[i], i);
		}
		return new int[] {};
	}

	public static int[] efficient(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target)
				return new int[] { i + 1, j + 1 };
			else if (sum < target)
				i++;
			else
				j--;
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;

		for (int i : approach1(numbers, target))
			System.out.print(i + " ");
		System.out.println();

		for (int i : approach2(numbers, target))
			System.out.print(i + " ");
		System.out.println();

		for (int i : efficient(numbers, target))
			System.out.print(i + " ");
		System.out.println();
	}
}
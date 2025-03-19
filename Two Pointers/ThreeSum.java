/*
 * Problem Statement:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * The order of the triplets and the order of the elements within a triplet do not matter.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Example 2:
 * Input: nums = []
 * Output: []
 * 
 * Example 3:
 * Input: nums = [0]
 * Output: []
 * 
 * Constraints:
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 
 * Thought Process::
 * Approach 1:
 * We will use three for loops to find the three numbers that add up to 0.
 * The outer loop will iterate over the array and the two inner loops will iterate from the next element to the end of the array.
 * If the sum of the three numbers is equal to 0, we will add the three numbers to a temporary list.
 * We then have to sort the temporary list and check if it is already present in the result list.
 * If it is not present, we will add it to the result list.
 * Sorting the temporary list is necessary because we cannot have two lists with the same elements in a different order.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n^3) since we are using three for loops.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) as we are using a temporary list to store the three numbers.
 * 
 * Drawback of this approach:
 * This approach takes a lot of time to find the three numbers because of the nested loops.
 * 
 * Approach 2:
 * We will use a HashMap to store the elements of the array along with their indices.
 * We will iterate over the array and check if the difference between the target and the current element is present in the HashMap.
 * If it is present, we will return the indices of the two numbers.
 * If it is not present, we will add the current element to the HashMap.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n^2) since we are iterating over the array only once and using a HashMap to store the elements.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) since we are using a HashMap to store the elements of the array.
 * 
 * Drawback of this approach:
 * This approach uses extra space to store the elements of the array.
 * 
 * Efficient Approach:
 * We first sort the array.
 * we will use three pointers i, j, and k, where i will be pointing to the first element, j will be pointing to the next element, and k will be pointing to the last element.
 * We will calculate the sum of the elements at i, j, and k.
 * If the sum is equal to 0, we will add the three numbers to a temporary list and then add the temporary list to the result list.
 * Next we have to increment j and decrement k because we have to find all the triplets that add up to 0.
 * Remember to skip the duplicates by incrementing j and decrementing k if the elements are the same as the previous elements.
 * If the sum is less than 0, we will increment j.
 * If the sum is greater than 0, we will decrement k.
 * Also make sure to increment i if the elements are the same as the previous elements.
 * 
 * Time Complexity Analysis:
 * The time complexity for sorting the array is O(nlogn).
 * The time complexity for finding the three numbers is O(n^2).
 * The total time complexity is O(n^2). 
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) as we are not using any extra space. 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class ThreeSum {
	public static List<List<Integer>> approach1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						Collections.sort(temp);
						if (!result.contains(temp)) {
							result.add(temp);
						}
					}
				}
			}
		}
		return result;
	}

	public static List<List<Integer>> approach2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int j = i + 1; j < nums.length; j++) {
				if (map.containsKey(-nums[i] - nums[j])) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(-nums[i] - nums[j]);
					Collections.sort(temp);
					if (!result.contains(temp)) {
						result.add(temp);
					}
				}
				map.put(nums[j], j);
			}
		}
		return result;
	}

	public static List<List<Integer>> efficient(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1, k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
				} else if (sum < 0)
					j++;
				else
					k--;
			}
		}
		return result;
	}
}
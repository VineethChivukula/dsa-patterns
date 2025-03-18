/*
 * Problem Statement:
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * 
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * 
 * Thought Process::
 * Approach 1:
 * We will first square all the elements of the array.
 * Then we will sort the array.
 * 
 * Time Complexity Analysis:
 * The time complexity for traversing the array and squaring the elements is O(n).
 * The time complexity for sorting the array is O(nlogn).
 * So, the overall time complexity is O(nlogn).
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) because we are not using any extra space.
 * 
 * Drawback of this approach:
 * We are sorting the array after squaring the elements using Arrays.sort() which is not efficient.
 * 
 * Approach 2:
 * We will use maxHeap to solve this problem.
 * We will first square all the elements of the array.
 * Then we will add all the elements to the maxHeap.
 * Then we will poll the elements from the maxHeap and put them back into the array.
 * 
 * Time Complexity Analysis:
 * The time complexity for traversing the array and squaring the elements is O(n).
 * The time complexity for adding all the elements to the maxHeap is O(nlogn).
 * The time complexity for polling the elements from the maxHeap and putting them back into the array is O(nlogn).
 * So, the overall time complexity is O(nlogn).
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) because we are using a maxHeap to store the elements.
 * 
 * Drawback of this approach:
 * This approach makes use of a maxHeap in addition to the array.
 * 
 * Efficient Approach:
 * We will use two pointers i and j, where i will be pointing to the first element and j will be pointing to the last element.
 * We also create a result array of the same size as the input array.
 * We will compare the absolute values of the elements at i and j.
 * We will put the square of the greater element at the end of the result array.
 * We will increment i if the square of the element at i is greater than the square of the element at j.
 * We will decrement j if the square of the element at j is greater than the square of the element at i.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) because we are iterating through the array only once.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) because we are using a result array to store the elements.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class SquaresOfASortedArray {
	public static int[] approach1(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] * nums[i];
		}
		Arrays.sort(nums);
		return nums;
	}

	public static int[] approach2(int[] nums) {
		int n = nums.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < n; i++) {
			maxHeap.add(nums[i] * nums[i]);
		}
		for (int i = n - 1; i >= 0; i--) {
			nums[i] = maxHeap.poll();
		}
		return nums;
	}

	public static int[] efficient(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int i = 0;
		int j = n - 1;
		for (int k = n - 1; k >= 0; k--) {
			if (Math.abs(nums[i]) > Math.abs(nums[j])) {
				result[k] = nums[i] * nums[i];
				i++;
			} else {
				result[k] = nums[j] * nums[j];
				j--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -4, -1, 0, 3, 10 };
		System.out.println(Arrays.toString(approach1(nums)));

		int[] nums1 = { -7, -3, 2, 3, 11 };
		System.out.println(Arrays.toString(approach2(nums1)));

		int[] nums2 = { -5, -3, -2, -1 };
		System.out.println(Arrays.toString(efficient(nums2)));
	}
}
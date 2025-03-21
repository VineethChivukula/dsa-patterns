/*
 * Problem Statement:
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
 * the x-axis forms a container, such that the container contains the most
 * water. Notice that you may not slant the container. Return the maximum area
 * of water can contain.
 * 
 * Example 1: 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * 
 * Example 3:
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * 
 * Example 4:
 * Input: height = [1,2,1]
 * Output: 2
 * 
 * Constraints:
 * n == height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 * 
 * Thought Process::
 * Approach 1:
 * We will find out the area of all the possible containers and return the maximum area.
 * We will use two for loops to find the two lines that form the container.
 * The outer loop will iterate over the array and the inner loop will iterate from the next element to the end of the array.
 * To calculate the area, we will multiply the minimum of the two heights with the difference between the two indices.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n^2) since we are using two for loops.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) as we are not using any extra space.
 * 
 * Drawback of this approach:
 * This approach takes a lot of time to find the two lines that form the container because of the nested loops.
 * 
 * Efficient Approach:
 * The logic behind this approach is that we are trying to maximize the area by moving the pointer pointing to the smaller height.
 * area = min(height[i], height[j]) * (j - i)
 * Here width is (j - i) and height is min(height[i], height[j]).
 * Width will always decrease as we move the pointers i and j towards each other.
 * So, to maximize the area, we need to maximize the height. So that means, we have to find a greater height.
 * To find a greater height, we will move the pointer pointing to the smaller height because the area will be limited by the smaller height.
 * We will use two pointers i and j, where i will be pointing to the first element and j will be pointing to the last element.
 * We will calculate the area using the formula min(height[i], height[j]) * (j - i).
 * We will then compare the area with the maximum area and update the maximum area if the current area is greater.
 * If height[i] is less than height[j], we will increment i, else we will decrement j.
 * We will continue this process until i is less than j.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) since we are using two pointers to find the maximum area.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) as we are not using any extra space.
 */

public class ContainerWithMostWater {
	public static int approach1(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = Math.min(height[i], height[j]) * (j - i);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}

	public static int efficient(int[] height) {
		int maxArea = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			int area = Math.min(height[i], height[j]) * (j - i);
			maxArea = Math.max(maxArea, area);
			if (height[i] < height[j])
				i++;
			else
				j--;
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(approach1(height));
		System.out.println(efficient(height));
	}
}
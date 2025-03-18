/*
 * Problem Statement:
 * Write a function that reverses a string. 
 * The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 * 
 * Thought Process::
 * Approach 1:
 * We will use a stack to reverse the string. 
 * We will push all the characters of the string into the stack.
 * Then we will pop the characters from the stack and put them back into the array.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) because we are iterating through the array twice.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) because we are using a stack to store the characters.
 * 
 * Drawback of this approach:
 * This approach makes use of extra space.
 * 
 * Approach 2:
 * We will use one pointer to iterate through the array.
 * We will swap the elements at the current pointer i and n-i-1.
 * We will increment the pointer until half of the array is traversed because we are swapping the elements.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) because we are iterating through the array only once.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) because we are not using any extra space.
 * 
 * Drawback of this approach:
 * This approach is not efficient because the number of operations and iterations are more.
 * 
 * Efficient Approach:
 * This approach is simple. We will use two pointers i and j. 
 * i will be pointing to the first element and j will be pointing to the last element.
 * We will swap the elements at i and j and increment i and decrement j.
 * We will do this until i is less than j.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) because we are iterating through the array only once.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) because we are not using any extra space.
 */

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {
	public static void approach1(char[] s) {
		int n = s.length;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.push(s[i]);
		}
		for (int i = 0; i < n; i++) {
			s[i] = stack.pop();
		}
	}

	public static void approach2(char[] s) {
		int n = s.length;
		for (int i = 0; i < n / 2; i++) {
			char temp = s[i];
			s[i] = s[n - i - 1];
			s[n - i - 1] = temp;
		}
	}

	public static void efficient(char[] s) {
		int i = 0, j = s.length - 1;
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		approach1(s);
		System.out.println(Arrays.toString(s));

		char[] s1 = { 'H', 'a', 'n', 'n', 'a', 'h' };
		approach2(s1);
		System.out.println(Arrays.toString(s1));

		char[] s2 = { 'h', 'e', 'l', 'l', 'o' };
		efficient(s2);
		System.out.println(Arrays.toString(s2));
	}
}
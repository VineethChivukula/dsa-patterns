/*
 * Problem Statement:
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * 
 * Example 3:
 * Input: s = " "
 * Output: true
 * 
 * Constraints:
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 * 
 * Thought Process::
 * Approach 1:
 * We will first remove all the non-alphanumeric characters from the string.
 * Then we will convert the string to lowercase.
 * Then we will use two pointers i and j, where i will be pointing to the first element and j will be pointing to the last element.
 * We will compare the characters at i and j.
 * If the characters are not equal, we will return false.
 * If the characters are equal, we will increment i and decrement j.
 * 
 * Time Complexity Analysis:
 * The time complexity for removing all the non-alphanumeric characters from the string is O(n).
 * The time complexity for converting the string to lowercase is O(n).
 * The time complexity for traversing the string using two pointers is O(n).
 * So, the overall time complexity is O(n).
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) because we are using a new string to store the alphanumeric characters.
 * 
 * Drawback of this approach:
 * This approach makes use of an extra string to store the alphanumeric characters.
 * 
 * Efficient Approach:
 * We will use two pointers i and j, where i will be pointing to the first element and j will be pointing to the last element.
 * We will compare the characters at i and j.
 * If the character at i is not alphanumeric, we will increment i and if the character at j is not alphanumeric, we will decrement j.
 * If the characters are alphanumeric, we will compare the characters.
 * If the characters are not equal, we will return false.
 * If the characters are equal, we will increment i and decrement j.
 * 
 * Time Complexity Analysis:
 * The time complexity for traversing the string using two pointers is O(n).
 * So, the overall time complexity is O(n).
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) because we are not using any extra space.
 */

public class ValidPalindrome {
	public static boolean approach1(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static boolean efficient(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			} else if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			} else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(approach1(s));
		System.out.println(efficient(s));
	}
}
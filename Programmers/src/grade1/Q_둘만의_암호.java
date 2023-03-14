import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public String solution(String s, String skip, int index) {
		String answer = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < skip.length(); i++) {
			String str = skip.split("")[i];
			alphabet = alphabet.replaceAll(str, "");
		}
		String[] arr = alphabet.split("");
		String temp = arr[arr.length - 1];
		for (int i = arr.length - 1; i >= 1; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
		System.out.println(Arrays.toString(arr));
		int size = arr.length;
		for (int i = 0; i < s.length(); i++) {
			int ix = Arrays.asList(arr).indexOf(String.valueOf(s.charAt(i)));
			answer += arr[(ix + index) % size];
		}
		return answer;
	}
}

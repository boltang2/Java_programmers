import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
        	list.add(numbers[i]);
        }
        for(int i = 0; i < 10; i++) {
        	if(!list.contains(i))
        		answer += i;
        }
        return answer;
    }
}
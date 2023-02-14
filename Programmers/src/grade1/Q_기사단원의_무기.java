class Solution {
	public int solution(int number, int limit, int power) {
		int answer = 0;
		int[] weapon = new int[number];

		for (int i = 0; i < number; i++) {
			int count = 0;
			for (int j = 1; j <= Math.sqrt(i + 1); j++) {
				if (i + 1 == 1) {
                    count++;
					weapon[i] = count;
				} else if ((i + 1) % j == 0) {
					if (j == Math.sqrt(i + 1)) {
						count++;
					} else {
						count += 2;
					}
				}
			}
			if(count > limit) {
					weapon[i] = power;
					
				} else {
                weapon[i] = count;
            }
		}
        for(int tmp : weapon){
            //System.out.print(tmp + " ");
            answer += tmp;
        }
		return answer;

	}
}
class Solution {
	public int solution(String[] babbling) {
		String[] bab = { "aya", "ye", "woo", "ma" };
		String[] babbab = { "ayaaya", "yeye", "woowoo", "mama" };
		int answer = 0;

		for (String list : babbling) {
			for (String babbabList : babbab) {
				list = list.replace(babbabList, "X");
			}
			for (String babList : bab) {
				list = list.replace(babList, "O");
			}
			System.out.println(list);
			//String "00000"
			boolean isTrue = true;
			for(int i = 0; i < list.length();i++) {
				if(list.charAt(i) != 'O') {
					isTrue = false;
					break;
				}
			}
			if(isTrue) {
				answer++;
			}
			
//			String[] listArr = list.split("");
//			boolean isTrue = true;
//			for(String xo : listArr) {
//                System.out.println("xo = " + xo);
//				if( !xo.equals("O") ) {
//					isTrue = false;
//					break;
//				}
//			}
//			if(isTrue) {
//				answer++;
//			}

		}
		return answer;
	}
}

package level1;

public class 자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		/*
		 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
		 * 예를들어 n이 12345이면 [5,4,3,2,1]을
		 * 리턴합니다. 
		 * 
		 * 제한 조건 
		 * 
		 * n은 10,000,000,000이하인 자연수입니다.
		 */
	}

	public int[] solution(long n) {
		
		// 자연수를 받아온다.
		// 문자열로 바꾼 후 배열에 담는다.
		// 배열에서 자리 바꾸는 반복문 사용.
		// 이후 정수형 배열에 다시 담는다.
		
		String str = String.valueOf(n);
		String[] str2 = str.split("");
		int[] answer = new int[str2.length];
		
		int store = 0;
		for(int i = 0; i < str2.length; i++) {
			store = Integer.valueOf(str2[i]);
			answer[i] = Integer.valueOf(str2[str2.length-i-1]);
			answer[str2.length-i-1] = store;
		}
		
		return answer;
	}
	
}

class 자연수뒤집어배열로만들기_다른사람_고수냄새 {
    public int[] solution(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}

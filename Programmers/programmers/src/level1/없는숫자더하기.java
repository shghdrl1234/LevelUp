package level1;

public class 없는숫자더하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. 
		 * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 
		 * 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * 1 ≤ numbers의 길이 ≤ 9 
		 * 0 ≤ numbers의 모든 원소 ≤ 9 
		 * numbers의 모든 원소는 서로 다릅니다.
		 */
		
		System.out.println(solution(new int[] {1,2,3,4,5,6,7,9}));

	}
	
    public static int solution(int[] numbers) {
       
    	/*
    	 * 내가 생각한 풀이
    	 * 1. 0~9 까지의 합을 구하고, numbes의 인덱스의 값들을 모두 뺀다.
    	 * 
    	 */
    	
    	int answer = 45;
    	
    	for(int i = 0; i < numbers.length; i++) {
    		answer -= numbers[i];
    	}
    	
        return answer;
    }

}

	class 없는숫자더하기_다른사람 {
	    public int solution(int[] numbers) {
	        int sum = 45;
	        for (int i : numbers) {
	            sum -= i;
	        }
	        return sum;
	    }
	    // 향상된 for문 사용함.
	}
	
	/*
	 * 
	 * 이 문제는 전반적으로 다들 쉬워했고, 이 때 까지 푼 문제들 중에
	 * 많은 사람들의 추천을 받은 코드와 가장 유사했음.
	 * 
	 */
	
	
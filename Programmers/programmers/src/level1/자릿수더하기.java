package level1;

public class 자릿수더하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 자연수 N이 주어지면, 
		 * N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요. 
		 * 예를들어 N =
		 * 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
		 * 
		 * 제한사항 
		 * N의 범위 : 100,000,000 이하의 자연수
		 * 
		 */
		Solution s = new Solution();
		
		
//		System.out.println(s.solution(133));
		
		
		자릿수더하기_다른사람 ss = new 자릿수더하기_다른사람();
		ss.solution(12345343);
	}
	
	public static class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        
	        // 100,000,000 부터 10까지 차례대로 나누는 방법 => 쉽다
	        // 어떤 자연수가 와도 해결 할 수 있는 식을 찾아보자.
	        // 숫자를 문자열로 만든다음, 문자열 하나씩 잘라서 더하는건?
	        
	        String numStr = String.valueOf(n);
	        
	        String[] index = numStr.split("");
	        
	        for(int i = 0; i< index.length; i++ ) {
	        	
	        	answer += Integer.valueOf(index[i]);
	        	
	        }
	        
	        System.out.println("Hello Java");

	        return answer;
	    }
	}

}

	class 자릿수더하기_다른사람 {
    public int solution(int n) {
        int answer = 0;

        while (n != 0) { // 0이 아닐때를 먼저 가정한다.
            answer += n % 10; // 나머지를 더해가고, 
            n /= 10; // 나머지 없는 값으로  저장한다.
            
            System.out.println(answer);
        }

        return answer;
    }
}
package level1;

import java.util.ArrayList;

public class X만큼간격이있는n개의숫자 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 함수 solution은 정수 x와 자연수 n을 입력 받아, 
		 * x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야합니다. 
		 * 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
		 * 
		 * 제한 조건 
		 * x는 -10000000 이상, 10000000 이하인 정수입니다. n은 1000 이하인 자연수입니다.
		 * 
		 */

		solution(2,2);
		
	}
	
	static public long[] solution(int x, int n) {
        
		long[] answer = new long[n];
		
		// 0. 배열을 만들기 위해서 갯 수를 알아야겠지..
        // 1. x부터 시작해서 x씩 증가. 언제까지? 리스트의 길이가 n개가 될 때 까지.
        // 2. 일단 반복문을 사용해야한다. 
        
		int i = 0;
		long num = x;
	
		while( i < answer.length) {
			System.out.println(num);
        	answer[i] = num;
        	num += x;
        	i++;
        }
        
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        
        return answer;
    }
}


	class X만큼간격이있는n개의숫자_다른사람 {
	    public static long[] solution(int x, int n) {
	        long[] answer = new long[n];
	        answer[0] = x;
	
	        for (int i = 1; i < n; i++) {
	            answer[i] = answer[i - 1] + x;
	        }
	
	        return answer;
	        // 전체적으로 나와 비슷한 방법을 사용하였지만.
	        // 이 분은 코드가 훨씬 간결하고, 변수 선언이 더 적다.
	    }
	}
	
	/*
	 * 현재 까지 풀어본 문제 중에 가장 쉬웠다고 느꼈음.
	 * 
	 * 배열과 반복문만 잘 활용하면됨.
	 * 
	 * 만약 n의 개수가 아닌 n의 약수의 개수 등이었다면
	 * 
	 * 소스가 복잡해졌겠지..
	 */
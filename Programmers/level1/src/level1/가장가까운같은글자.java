package level1;

import java.util.HashMap;

public class 가장가까운같은글자 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 
		 * 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다. 
		 * 예를 들어, s="banana"라고 할 때, 각 글자들을 왼쪽부터 오른쪽으로 
		 * 읽어 나가면서 다음과 같이 진행할 수있습니다.
		 * 
		 * b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다. 
		 * a는 처음 나왔기 때문에 자신의 앞에 같은 글자가없습니다. 이는 -1로 표현합니다. 
		 * n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다. 
		 * a는 자신보다 두칸 앞에 a가 있습니다. 이는 2로 표현합니다. 
		 * n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다. 
		 * a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 
		 * 
		 * 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다. 
		 * 따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
		 * 
		 * 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요. 
		 * 
		 * 제한사항 1 ≤ s의 길이 ≤ 10,000
		 * s은 영어 소문자로만 이루어져 있습니다.
		 * 
		 */

	}
    public int[] solution(String s) {
        
        /*
         * 내가 문제 푸는 방법
         * 
         * 1. 반복문을 중첩한다. i는 문자열 순서대로 지정. 
         * 2. i를 기준으로, j는 i보다 작은 길이 동안만 순회함.
         * 3. 순회하면서 같은게 하나도 없으면 -1 리턴,
         * 4. 순회하면서 같은게 나왔을때, 가장 가까운 곳으로 부터의 i거리 리턴
         * 
         * 
         */
        
    	int[] answer = new int[s.length()];
    	
    	for(int i = 0; i < answer.length; i++) {
    		answer[i] = -1;
    	}
        
        
        for(int i = 1; i < s.length(); i++) {
        	int idx = 0;
        	
        	for(int j = 0; j < i; j++ ) {
        		
        		if(s.charAt(j) == s.charAt(i)) {
        			idx = i-j;

        			answer[i] = idx;
        		}
        		
        	}
        	
        }
        
        return answer;
    }
}
	class 가장가까운같은글자_다른사람 {
	    public int[] solution(String s) {
	        int[] answer = new int[s.length()];
	
	        HashMap<Character, Integer> map = new HashMap<>();
	        for(int i=0; i<s.length(); i++) {
	            if(!map.containsKey(s.charAt(i))) {
	                answer[i] = -1;
	                map.put(s.charAt(i), i);
	            }else {
	                int before = map.get(s.charAt(i));
	                answer[i] = i - before;
	                map.put(s.charAt(i), i);
	            }
	        }
	        return answer;
	    }
}
	
	/*
	 * 
	 * hashMap을 활용한 분의 코드를 보니 조금은 이해를하지 못하겠다.
	 * 
	 * hashMap을 공부해보자.
	 * 
	 */
	
	
	
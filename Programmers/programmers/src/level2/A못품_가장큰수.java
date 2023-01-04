package level2;

import java.util.ArrayList;
import java.util.List;

public class A못품_가장큰수 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
		 * 
		 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 
		 * [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
		 * 이중 가장 큰 수는 6210입니다.
		 * 
		 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
		 * 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
		 * return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한 사항 
		 * numbers의 길이는 1 이상 100,000 이하입니다. 
		 * numbers의 원소는 0 이상 1,000 이하입니다. 
		 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
		 * 
		 */

		
	}
	
    public String solution(int[] numbers) {
    	
    	/*
    	 * 내가 푸는 방법
    	 * 1. number의 요소를 확인해서 요소의 가장 앞에 있는 수가 크면, 제일 앞으로 오도록 한다.
    	 * 
    	 * 2. 가장 앞에 있는 수가 크면, 그 다음 수를 비교한다.
    	 * 
    	 * 3. 비교 후 출력 
    	 * 
    	 */
    	
    	List<String> l = new ArrayList<String>();
    	
    	for(int s : numbers) {
    		l.add(String.valueOf(s));
    	}
    	
    	for(int i = 0; i < l.size(); i++) {
    		
    		for(int j = 0; j < l.size()-1; j++) {
    			String store = "";
    			if((l.get(j)).charAt(0) < l.get(j+1).charAt(0)) {
    				store = l.get(j);
    				l.set(j, l.get(j+1));
    				l.set(j+1, store);
    			} else if((l.get(j)).charAt(1) < l.get(j+1).charAt(1)) {
    				
    			}
    		}
    		
    	}
    	
        String answer = "";
        return answer;
    }

}

package level2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

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

		solution(new int[]{3,30,34,5,9});
	}
	
    public static String solution(int[] numbers) {
    	
    	/*
    	 * 내가 푸는 방법
    	 * 1. number의 요소를 확인해서 요소의 가장 앞에 있는 수가 크면, 제일 앞으로 오도록 한다.
    	 * => 가장 앞의 수를 기준으로 내림차순으로 정렬
    	 * 
    	 * 2. 두 자리 수 이상일 경우, 앞자리가 같다면 다음 자리 수로 비교
    	 * => 1+a 자리 수를 기준으로 내림차순으로 정렬
    	 * 
    	 * 3. 자리 수는 다른데, 자리 수가 작은 것을 기준으로 하였을 때, 같은 수가 나오면
    	 * 작은 자리수를 먼저 넣는다.
    	 * 993 9 99 992
    	 * => 9 99 993 992, 대소 관계는 지키되, 자리 수가 적은 것은 앞으로 이동
    	 * 
    	 * 993 9 99 8 
    	 * => 9 99 993 8, 다른 수가 나오면 컷.
    	 * 
    	 * 999 98 9999
    	 * => 999 9999 98
    	 * 
    	 */
    	
    	LinkedList<String> l = new LinkedList<String>();
    	
    	for(int s : numbers) {
    		// 전달 받은 각 숫자들을 LinkedList 객체에 저장
    		l.add(String.valueOf(s));
    	}
    	
    	// LinkedList를 내림차순으로 정렬
    	Collections.sort(l, Comparator.reverseOrder());
    	
    	for(int i = 0; i < l.size(); i++) {
    		
    		for(int j = 0; j < l.size()-1; j++) {
    			
				String store = "";
				if(l.get(j).charAt(0) == l.get(j+1).charAt(0)) {	
					if(Integer.valueOf(l.get(j).substring(0,l.get(j+1).length())) < Integer.valueOf(l.get(j+1).substring(0,l.get(j+1).length()))) {
						// 9998 999 996 998 98 80
						store = l.get(j+1);
						l.set(j+1, l.get(j));
						l.set(j, store);
					}
				}
    		}
    		
    	}
    	
    	
    	String answer = "";
    	
    	for(String s : l) {
    		answer += s;
    		System.out.print(s);
    	}

    	return answer;
    }

}

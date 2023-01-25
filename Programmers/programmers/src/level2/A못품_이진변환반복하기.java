package level2;

import java.util.ArrayList;
import java.util.LinkedList;

public class A못품_이진변환반복하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
		 * 
		 * x의 모든 0을 제거합니다. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다. 
		 * 예를 들어, x = "0111010"이라면, 
		 * x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
		 * 
		 * 0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. 
		 * s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 
		 * 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 
		 * 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * s의 길이는 1 이상 150,000 이하입니다. 
		 * s에는 '1'이 최소 하나 이상 포함되어 있습니다.
		 * 
		 */
		solution("01110");
	}
	   public static int[] solution(String s) {
	    	/*
	    	 * 내가 문제 푸는 방법
	    	 * 1. s에서 0을 제거 한다. => 0의 개수만큼 카운트
	    	 * 2. s를 s의 길이의 2진법으로 나타낸다. 
	    	 * 3. s가 1이 될 때까지 반복.
	    	 * 
	    	 * 문자열의 삭제, 변경이 주로 발생함 => linkedList?
	    	 */
	        int[] answer = {0, 0};
	        
	        int zero = 0;
	        
	        String[] arr = s.split("");
	        
	        ArrayList ll = new ArrayList();
	        
	        for(String a : arr) {
	        	// linkedList 컬렉션에 문자 추가.
	        	ll.add(a);
	        }
	        
	        int k =0;
	        while(ll.size() > 1) {
		        
	        	
		        while(ll.contains("0")) {
		        	// 문자 0이 없어질 때 까지 반복
		        	ll.remove("0");
		        	zero ++;
		        }
		        
		        // ll 컬렉션 객체의 길이를 이진법으로 나타내고,
		        String[] lb = Integer.toBinaryString(ll.size()).split("");
		        ll.clear();
		        
		        int i = 0;
		        for(String a : lb) {
		        	// 그 이진법을 ll 컬렉션에 저장
		        	ll.add(i, a);
		        	i++;
		        }
		        
	        k++;
	        }
	        answer[0] = k;
	        answer[1] = zero;
	        return answer;
	    }

	}
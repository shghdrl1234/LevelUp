package level2;

import java.util.ArrayList;
import java.util.LinkedList;

public class 이진변환반복하기 {

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
	    	 * 1. s의 각 숫자를 나타내는 문자를 split 하여 문자열 배열로 만든다.
	    	 * 2. 문자열 배열을 순회하면서 그 값이 0이 아니면, 리스트에 추가한다.
	    	 * 3. 그 리스트 값의 길이를 다시 이진법으로 바꾸고, 1번의 과정을 반복한다. 리스트의 값이 1만 남을 때 까지.
	    	 * 
	    	 * 문자열의 삭제, 변경이 주로 발생함 => linkedList?
	    	 */
	        int[] answer = {0, 0};
	        
	        String[] strA = s.split("");
	        int k = 1;
	        int zero = 0;
	        ArrayList<String> arr = new ArrayList<String>();
	     
	        for(int i = 0; i < strA.length; i++) {
	        	if(Integer.valueOf(strA[i]) != 0) {
	        		arr.add(strA[i]);
	        	} else {
	        		zero ++;
	        	}
	        }
	        
	        while(arr.size() > 1) {
		        String[] leng = Integer.toBinaryString(arr.size()).split("");
		        arr.clear(); k++;
		        for(int i = 0; i < leng.length; i++) {
		        	if(Integer.valueOf(leng[i]) != 0) {
		        		arr.add(leng[i]);
		        		System.out.println(leng[i]);
		        	} else {
		        		zero++;
		        	}
		        }
	        }
	        
	        answer[0] = k;
	        answer[1] = zero;
	        
	        return answer;
	    }

	   public static int[] solution2(String s) {
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

/*
 * solution2 메서드로 제출했을 때에는 시간초과가 떴었다.
 * 
 * 이후 코드를 조금 변경하여 solution메서드로 제출하여 통과되었다.
 * 
 */

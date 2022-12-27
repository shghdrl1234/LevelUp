package level2;

import java.util.Arrays;
import java.util.LinkedList;

public class JadenCase문자열만들기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 
		 * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. 
		 * (첫 번째 입출력 예 참고) 문자열 s가 주어졌을 때, 
		 * s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
		 * 
		 * 제한 조건 
		 * s는 길이 1 이상 200 이하인 문자열입니다. 
		 * s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다. 
		 * 숫자는 단어의 첫 문자로만 나옵니다. 
		 * 숫자로만 이루어진 단어는 없습니다. 
		 * 공백문자가 연속해서 나올 수 있습니다.
		 */
		
		
		
		String s = "abB23 C CCC CC1C aaC aCaa  1a a22c a   ";
		String[] arr = s.split("");
		System.out.println("주어진 s의 길이 : " + arr.length);
		System.out.println("===============");
		System.out.println(solution3(s));
	}
	
	public static String solution3(String s) {
	     /*
	        * 내가 문제 푸는 방법
			* 1. 주어진 s를 공백문자를 기준으로 LinkedList로 변환
			* => 요소의 추가 삭제할 때 해당 요소만 변경하면 되어 작업시간 단축.
			* => 주어진 배열에서 마지막에 공백만 연속되면 자동적으로 trim이 되어 누락된다.
			* => 한 글자씩 뽑아서, i가 소문자이고, i-1이 공백이면 i를 대문자로 바꾼다. (i = 1부터 해당)
			* => (i = 0) 일때는 i가 소문자이고, i+1이 공백이면 대문자로 바꾼다.
			* 
			* 2. 각 LinkedList에서 첫문자가 소문자이면 대문자로 변경.
			* 
			* 3. 이후 LinkedList를 하나씩 출력하여 String으로 반환
	        * 
	        */
		
			String answer = "";
		
			String[] arr = s.split("");
			
			LinkedList<String> ll = new LinkedList<String>();
			
			for(String sr : arr) {
				// linkedList에 arr과 같은 값을 넣어준다.
				ll.add(sr);
			}
			
			// 첫번째 요소가 소문자이고, 다음 요소가 공백이면 첫번째 요소는 대문자로 바꾼다.
			if(arr[0].charAt(0) >= 97 && arr[0].charAt(0) <= 122) {
				ll.set(0, (char)(arr[0].charAt(0)-(char)32)+"");
			}
			
			for(int i = 1; i < ll.size(); i++) {
				// 현재 요소가 대문자이고, 이전 문자가 공백이면
				if(arr[i].charAt(0) >= 65 && arr[i].charAt(0) <= 90 && arr[i-1].equals(" ")) { 
					// 그냥 놔두기
				}
				// 현재 요소가 소문자이고, 이전 요소가 공백이면, 현재 요소를 대문자로 바꾼다.
				else if(arr[i].charAt(0) >= 97 && arr[i].charAt(0) <= 122 && arr[i-1].equals(" ")) {
					ll.set(i, (char)(arr[i].charAt(0)-(char)32)+"");
				} else {
					// 그렇지 않으면 소문자로 바꾼다.
					ll.set(i, ll.get(i).toLowerCase());
				}
				
			}
			
			for(String str : ll) {
				answer += str;
			}
			
			System.out.println(answer.length());
			return answer;
		}
	
	
	public static String solution2(String s) {
       /*
        * 내가 문제 푸는 방법
		* 1. 주어진 s를 공백문자를 기준으로 LinkedList로 변환
		* => 요소의 추가 삭제할 때 해당 요소만 변경하면 되어 작업시간 단축.
		* 
		* 2. 각 LinkedList에서 첫문자가 소문자이면 대문자로 변경.
		* 
		* 3. 이후 LinkedList를 하나씩 출력하여 String으로 반환
        * 
        */
		String answer = "";
		
		String[] arr = s.split(" ");
		
		LinkedList<String> ll = new LinkedList<String>();
		
		for(String sr : arr) {
			// linkedList에 arr과 같은 값을 넣어준다.
			ll.add(sr);
		}
		
		for(int i = 0; i < arr.length; i++) {
		
			// arr의 요소(해당 문자열)의 길이가 2글자 이상이고, 첫번째 문자가 소문자일 때,
			if(arr[i].length() > 1 && arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122 ) {
				
				// LinkedList 객체의 값을 바꿔준다 => 추가, 삭제에 용이함.
				// 첫 글자는 대문자로, 나머지는 소문자로 변경
				ll.set(i, (char)(arr[i].charAt(0)-(char)32)+""+ arr[i].substring(1).toLowerCase());
				
			}
			
			// arr의 요소(해당 문자열)의 길이가 1글자이고, 그 문자가 소문자일 때,
			if(arr[i].length() == 1 && arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122 ) {
				
				// LinkedList 객체의 값을 바꿔준다 => 추가, 삭제에 용이함.
				// 첫 글자는 대문자로, 나머지는 소문자로 변경
				ll.set(i,(char)(arr[i].charAt(0)-(char)32)+""); 
			}
		
    	}
    	
    	for(int i = 0; i < ll.size(); i++) {
    		
    		if(!ll.get(i).isBlank()) {
    			
    			if(i == ll.size()-1) {
    				answer += ll.get(i);
    			} else {
    				answer += ll.get(i) + " ";
    			}
    			
    		} else {
    			answer += " ";
    		}
    		
    	}
		System.out.println(answer.length());
		return answer;
	}
	
    public static String solution(String s) {
       /*
        * 내가 문제 푸는 방법
        * 1. split으로 배열 만들기
        * 2. 만들어진 배열의 요소 첫 글자가 소문자일 경우 (char 활용) => 대문자로 변경
        * 3. split배열에 다시 저장.
        * 
        * -> 단어중에 대문자, 소문자가 섞인게 있다. 중간에 나오는 대문자는 소문자로 바꿔줘야함
        */
    	String answer = "";
        
    	String[] arr = s.split(" ");
    	
    	for(int i = 0; i < arr.length; i++) {
    		
    		if(arr[i].length() > 1 && arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122 ) {
    			arr[i] = (char)(arr[i].charAt(0)-(char)32)+""+ arr[i].substring(1).toLowerCase();
    		}
    		
    		if(arr[i].length() == 1 && arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122 ) {
    			arr[i] = (char)(arr[i].charAt(0)-(char)32)+"";
    		}
    		
    	}
    	
    	for(int i = 0; i < arr.length; i++) {
    		
    		if(!arr[i].isBlank()) {
    			
    			if(i == arr.length-1) {
    				answer += arr[i];
    			} else {
    				answer += arr[i] + " ";
    			}
    			
    		} else {
    			answer += " ";
    		}
    		
    	}
    	
        return answer;
    }
	
}

class JadenCase문자열만들기_다른사람 {
	  public String solution(String s) {
	        String answer = "";
	        String[] sp = s.toLowerCase().split("");
	        boolean flag = true;

	        for(String ss : sp) {
	            answer += flag ? ss.toUpperCase() : ss;
	            flag = ss.equals(" ") ? true : false;
	        }

	        return answer;
	  }
	  // split 전부터 모두 소문자로 바꾼 다음. 이전 요소가 공백이면 true를, 아니면 false를 저장한
	  // 변수를 활용하여 대문자를 만듦.
	}


class JadenCase문자열만들기_다른사람2 {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<sArr.length; i++){
            if(i==0) sArr[i] = sArr[i].toUpperCase();

            if(" ".equals(sArr[i])){
                if(!(i == sArr.length-1))
                    sArr[i+1] = sArr[i+1].toUpperCase();   
            }
            sb.append(sArr[i]);
        }

        answer = sb.toString();

        return answer;
    }

    // 이 분은 스트링버퍼를 활용하였다.
}

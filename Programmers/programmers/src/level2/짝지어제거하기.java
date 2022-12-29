package level2;

import java.util.Stack;


public class 짝지어제거하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다. 
		 * 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 
		 * 
		 * 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 
		 * 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다. 
		 * 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 
		 * 
		 * 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
		 * 
		 * 예를 들어, 문자열 S = baabaa 라면
		 * 
		 * b aa baa → bb aa → aa → 의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
		 * 
		 * 제한사항 
		 * 문자열의 길이 : 1,000,000이하의 자연수 
		 * 문자열은 모두 소문자로 이루어져 있습니다.
		 * 
		 */

		solution1("abbabb");
		
	}
	
	public static int solution1(String s){
		/*
		 * 내가 푸는 방법
		 * 1. stack을 활용하여 연속적인 문자가 나오면 pop
		 */
		
		int answer = 0;
		
		Stack<String> st = new Stack<String>();
		
		String[] arr = s.split("");

		st.push(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			if(st.size() >0  && st.peek().equals(arr[i])) {
				st.pop();
			} else {
				st.push(arr[i]);
			}
		}

		if(st.size() == 0) {
			answer = 1;
		}
		
		return answer;
	}
	
    public static int solution(String s){
    	
    	/*
    	 * 내가 푸는 방법
    	 * 1. 각 문자열의 인덱스를 비교하고, 같은 문자면 제거.
    	 * 2. 제거시, 원래 길이가 2 줄었으니, 증감연산자에 의한 변수의 값도 -1 해준다.
    	 * 3. 그리고 그 위치를 기준으로 인덱스 비교.
    	 * 
    	 * 효율성 테스트 실패
    	 */
        int answer = 0;
        
       StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < sb.length()-1; i++) {
        	System.out.println("변경 전 : "  + i);
        	System.out.println("변경 전 : "+ sb);
        	if(i < 0) {
        		i = 0;
        	}
        	if(sb.length() > 1 && sb.charAt(i) == sb.charAt(i+1)) {
        		sb.replace(i, i+2, "");
        		i -= 2;
        		System.out.println("변경 후 : "  + i);
        		System.out.println("변경 후 : "+ sb);
        	}
        }
        
        if(sb.length() == 0) {
        	answer = 1;
        }
        
        return answer;
    }

}

/*
 * 처음에는 스트링빌더를 사용하여 접근을 해보았다.
 * => 스트링빌더 또한 배열 구조를 사용한 것이라, 배열 중간에서 수정, 삭제를 하게되면
 * 작업시간이 길어짐.
 * => linkedList를 활용하려 했으나, 배열에 접근하는 시간이 길어짐
 * => 접근은 arrayList로, 수정은 linkedList로 하려고 시도하였는데
 * 같은 문자가 삭제되면 변수가 가지는 값이 서로 달라져서 실패
 * 
 * => 최종적으로 Stack을 생각함.
 * 배열의 끝부분을 수정,삭제할 때는 작업시간 상관이 없다. 그 이유는 JDI 레포지토리에 나옴.
 * push되는 값만 보고 수정, 삭제를 할 수 있으니
 * 접근시간과, 작업시간 모두 양호함.
 * 
 * 
 * 
 * 
 */



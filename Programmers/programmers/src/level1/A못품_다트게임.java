package level1;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;

public class A못품_다트게임 {

	public static void main(String[] args) {
		/*
		 * 카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 
		 * 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다. 
		 * 갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다.
		 * 다트 게임의 점수 계산 로직은 아래와 같다.
		 * 
		 * 다트 게임은 총 3번의 기회로 구성된다. 
		 * 
		 * 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다. 
		 * 
		 * 점수와 함께 Single(S),Double(D), Triple(T) 영역이 존재하고
		 * 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3)으로 계산된다. 
		 * 
		 * 옵션으로 스타상(*), 아차상(#)이 존재하며 
		 * 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 
		 * 아차상(#) 당첨 시 해당 점수는 마이너스된다. 
		 * 
		 * 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 
		 * 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고) 
		 * 
		 * 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 
		 * 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고) 
		 * 
		 * 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는
		 * -2배가 된다. (예제 5번 참고) 
		 * 
		 * Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다. 
		 * 
		 * 스타상(*),아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다. 
		 * 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
		 * 
		 * 입력 형식 
		 * "점수|보너스|[옵션]"으로 이루어진 문자열 3세트. 예) 1S2D*3T
		 * 
		 * 점수는 0에서 10 사이의 정수이다.
		 * 
		 * 보너스는 S, D, T 중 하나이다. 옵선은 *이나 # 중 하나이며, 없을 수도 있다. 
		 * 
		 * 출력 형식
		 * 3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다. 예) 37
		 * 
		 */

		solution("1S2D*3T");
		
	}
    
	public static int solution(String dartResult) {
		
		/*
		 * 내가 문제 푸는 방법
		 * 
		 * 1.영문자를 기준으로 그 앞까지 리스트로 저장, 영문자 판독 후, 리스트 값에 곱해줌.
		 * 이후 다음 글자 파악해서 *또는 #이면 그만큼 또 점수를 추가함.
		 * 이 때, 리스트가 첫번째면, *의 효과는 혼자 받는다.
		 * 
		 * 2. 이후 문자열을 소비된 문자열 만큼 자른다.
		 * 
		 * 3. 언제까지? 문자열 길이가 0이 될 때까지.
		 * 
		 * 4. 이후 리스트 값을 다 더한다.
		 * 
		 */
        int answer = 0;
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String dart = dartResult;
        
        int zero = 0;
        	for(int i = 0; i < dart.length(); i++) {
//        		System.out.println("현재 i까지 자른 문자 : "+ dart.substring(zero, i));
        	
        		if(isStr(""+(dart.charAt(i)))) {
        		
        			arr.add(Integer.valueOf(dart.substring(zero, i)));
//        			System.out.println("알파벳");
        			switch(dart.charAt(i)) {
        			
        			case 'D': arr.set(arr.size()-1,(int)Math.pow((arr.get(arr.size()-1)),(2))); 
        			case 'T': arr.set(arr.size()-1,(int)Math.pow((arr.get(arr.size()-1)),(3)));
	        		
        			}
	        	
        		}
        		
        		if(isSc(""+dart.charAt(i)) && arr.size() == 1) {
        			switch(dart.charAt(i)) {
        			case '*': arr.set(arr.size()-1,(arr.get(arr.size()-1))*2); 
        			case '#': arr.set(arr.size()-1,-(arr.get(arr.size()-1))); 
        			}
        			
        		} else if(isSc(""+dart.charAt(i))){
        			switch(dart.charAt(i)) {
        			case '*': arr.set(arr.size()-2,(arr.get(arr.size()-2))*2); arr.set(arr.size()-1,(arr.size()-1)*2); 
        			case '#': arr.set(arr.size()-1,-(arr.get(arr.size()-1))); 
        			}
        		}
	        	
        		if(i != 0) {
        			zero += 1;
        		}
        		
//        		System.out.println("i = "+ i +", zero = " + zero);
        		System.out.println(arr);
        	}
        
        	
        	for(int i : arr) {
        		answer += i;
        	}
        
        	return answer;
        }
	
	public static boolean isStr(String str) {
		
		return str.matches("[A-Z]{1}");
	}
	
	public static boolean isSc(String str) {
		
		return str.matches("[*#]{1}");
	}
}

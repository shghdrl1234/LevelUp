package level1;

public class 문자열내P와y의개수 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. 
		 * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면
		 * False를 return 하는 solution를 완성하세요. 
		 * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단,
		 * 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
		 * 
		 * 예를 들어 s가 "pPoooyY"면 true를 return하고 
		 * "Pyy"라면 false를 return합니다.
		 * 
		 * 제한사항 문자열 
		 * s의 길이 : 50 이하의 자연수 
		 * 문자열 s는 알파벳으로만 이루어져 있습니다.
		 * 
		 */
		
		System.out.println(solution("as"));

	}
	// 1. 스플릿을 통해 배열에 저장.
	// 2. 각 인덱스를 조건문으로 비교하여 P,p,Y,y 개수를 switch-case문으로 작성.
	
    static boolean solution(String s) {
        boolean answer = true;
        
        String[] str = s.split("");
        
        int total_P = 0;
        int total_Y = 0;
        
        for(int i = 0; i < str.length; i++) {
        
        	switch(str[i]) {
        	
	        	case "P" : total_P++; break;
	        	
	        	case "p" : total_P++; break;
	        	
	        	case "Y" : total_Y++; break;
	        	
	        	case "y" : total_Y++; break;
	        	
	        	default : System.out.println(i+"번째 시도, 일치하는 문자값이 없습니다.");
        	}
        	
        }
        	if(total_P != total_Y) {
        		answer = false;
        	} 

        return answer;
    }
	
}



class 문자열내P와y의개수_다른사람 {
    boolean solution(String s) {
        s = s.toUpperCase(); //전체 대문자로 만들어줌

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
}

package level2;

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
	}
    public String solution(String s) {
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
    		
    		if(arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122) {
    			arr[i] = (char)(arr[i].charAt(0)-(char)32)+""+ arr[i].substring(1);
    		}
    		
    	}
    	
    	for(int i = 0; i < arr.length; i++) {
    		answer += arr[i];
    		
    		if(i < arr.length-1) {
    			answer += " ";
    		}
    	}
    	
        return answer;
    }
	
}

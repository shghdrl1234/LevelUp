package level1;

public class 가운데글자가져오기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
		 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면
		 * 됩니다.
		 * 
		 * 재한사항 
		 * s는 길이가 1 이상, 100이하인 스트링입니다.
		 * 
		 */
		System.out.println(solution("a"));
	}
	
	public static String solution(String s) {
				
		/*
		 * 내가 푸는 방법
		 * 1. 홀수 일 경우, s 전체 길이에서 2나누고 +1
		 * 2. 짝수 일 경우, s 전체 길이에서 2나눈 순서와, 그 다음 순서를 합침. 
		 *  
		 */

		if(s.length() == 1) {
			return s;
		}
		
		String answer = (s.length()%2==0) ? ""+s.charAt(s.length()/2-1) + s.charAt(s.length()/2) : ""+s.charAt(s.length()/2);
		
		System.out.println("charAt : "+s.charAt(s.length()/2-1));
		System.out.println("charAt2 : "+s.charAt(s.length()/2));
		return answer;

		//	return s.substring((s.length()-1) / 2, s.length()/2 + 1);
		// 다른 분은 리턴값으로만 해결 했음.
		// 나도 subString으로 했는데, 인자로 줘야하는 값을 1개 밖에 없다고 생각하여 사용하지 않음.
		// 여기서 s.length가 짝수라면 2개의 범위가 형성되고, 홀수라면 1개의 범위가 형성됨.
	}

}



  
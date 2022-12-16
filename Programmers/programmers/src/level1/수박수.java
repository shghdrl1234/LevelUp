package level1;

public class 수박수 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 
		 * 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어
		 * 
		 * n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
		 * 
		 * 제한 조건 
		 * n은 길이 10,000이하인 자연수입니다.
		 */
		System.out.println(solution(12));

	}
    public static String solution(int n) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. 문자열의 길이 n을 활용
    	 * 2. 인덱스의 숫자가 홀수 => "수"
    	 * 3. 인덱스의 숫자가 짝수 => "박"
    	 * 
    	 */
    	
    	String answer = "";
    	for(int i = 0; i < n; i++) {

    		answer = (i%2==0) ? answer+"수" : answer+"박";
//    		result += i % 2 == 0 ? "수" : "박";
    		// 다른 분 코드에서 참고하였음.
    		// 내 코드에서 중복되는 것을 줄임.
    		
    	}
    	
    	
        return answer;
    }
}

	class 수박수_다른사람 {
		public String watermelon(int n){
    		
			return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
			// 알고리즘 이라고 하는 댓글과 
			// 빈 char 배열을 생성하면 \0으로 먼저 생성된다는 댓글.
			// 많이 배워야겠다.
    }
}
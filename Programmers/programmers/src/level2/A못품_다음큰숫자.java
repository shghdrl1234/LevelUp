package level2;

public class A못품_다음큰숫자 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
		 * 
		 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다. 
		 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다. 
		 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다. 
		 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
		 * 
		 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
		 * 
		 * 제한 사항 
		 * n은 1,000,000 이하의 자연수 입니다.
		 * 
		 */

		solution(1000000);
		
	}
	
	public static int solution2(int n) {
		/*
		 * 1 - 1
		 * 2 - 10
		 * 3 - 11
		 * 4 - 100
		 * 5 - 101
		 * 6 - 110
		 * 7 - 111
		 * 8 - 1000
		 * 
		 */
		
		return 0;
	}
	
    public static int solution(int n) {
    	
    	/*
    	 * 내가 푸는 방법
    	 * 
    	 * 1. n을 2진법으로 바꾸고
    	 * 2. 반복문을 통하여 2진법의 1의 개수를 구한다. num
    	 * 3. 1씩 더하면서 1의 개수가 num과 같아질 때 까지 반복.
    	 * 4. num이 같아지면 10진법으로 변경 
    	 * 
    	 * => 효율성 테스트 실패
    	 */
    	
    	
        int answer = 0;

        String binaNum = Integer.toBinaryString(n);
        System.out.println("binaNum : " + binaNum);
        int num = 0;
        for(int i = 0; i < binaNum.length(); i++) {
        	if(binaNum.charAt(i) == '1') {
        		num += 1;
        	}
        }
        

        int a = n+1;
        while(true) {
        	String binaNum2 = Integer.toBinaryString(a);
        
        	if(binaNum2.length()-binaNum2.replace(String.valueOf("1"),"").length() == num) {
        		break;
        	}
        	a++;
        }
        
        return a;
    }

}

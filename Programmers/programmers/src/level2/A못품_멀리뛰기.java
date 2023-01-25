package level2;

public class A못품_멀리뛰기 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 효진이는 멀리 뛰기를 연습하고 있습니다. 
		 * 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
		 * 칸이 총 4개 있을 때, 효진이는(1칸, 1칸, 1칸, 1칸) (1칸, 2칸, 1칸) 
		 * (1칸, 1칸, 2칸) (2칸, 1칸, 1칸) (2칸, 2칸) 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 
		 * 
		 * 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 
		 * 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 
		 * 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
		 * 
		 * 제한 사항 
		 * n은 1 이상, 2000 이하인 정수입니다.
		 */

	}
	
    public long solution(int n) {
    	/*
    	 * 내가 푸는 방법
    	 * 1. n을 1로 나누었을 때
    	 * 2. n을 2로 나누었을 때
    	 * 
    	 * ex) n이 10이면, 1로 나누면 10, 2로 나누면 5
    	 * 그러면 최소로 가능한 값은 5(2,2,2,2,2) =>1 가지
    	 * 다음 (2,2,2,2,1,1) => 15가지 (6자리 중, 1이 들어갈 수 있는 경우의 수)
    	 * 다음 (2,2,2,1,1,1,1) => 35가지 (7자리 중,1 이 들어갈 수 있는 경우의 수)
    	 * 다음 (2,2,1,1,1,1,1,1) => 28가지 (8자리 중, 2가 들어갈 수 있는 경우의 수)
    	 * 다음 (2,1,1,1,1,1,1,1,1) => 9가지
    	 * 다음 (1,1,1,1,1,1,1,1,1,1) => 1가지
    	 * 
    	 * 최소 이동 => 1가지
    	 * (n/2)(n/2-1)
    	 * 
    	 * (n-3)(n-4)(n-5)가지
    	 * (n-2)(n-3) 가지
    	 * n-1 가지
    	 * 최대 이동 => 1가지
    	 */
    	
    	long answer = 0;
        return answer;
    }

}

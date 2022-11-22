package level1;

import java.util.stream.IntStream;

public class 내적 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. 
		 * a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. 
		 * (n은 a, b의 길이)
		 * 
		 * 제한사항 
		 * a, b의 길이는 1 이상 1,000 이하입니다. 
		 * a, b의 모든 수는 -1,000 이상 1,000 이하입니다.
		 */

		System.out.println(solution(new int[] {1,2,3,4,6}, new int[] {15,57,98,99,10} ));
	}
	
    public static int solution(int[] a, int[] b) {
    	
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. 배열의 길이를 활용한다.
    	 * 2. 반복문 사용.
    	 * 3. 반복문 외부에 순회하면서 더할 변수 사용
    	 */
    	
        int answer = 0;
        
        for(int i = 0; i < a.length; i++) {
        	answer += a[i]*b[i];
        }
        return answer;
    }
	

}

class 내적_다른사람 {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }
}

/*
 * 문제에서 작성할 코드를 유추할 수 있도록 해놨음.
 * 다른 사람들 중에 효율까지는 모르겠으나 한 줄로 된 것을 가져와봄. 
 */


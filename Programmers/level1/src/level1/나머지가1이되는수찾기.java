package level1;

import java.util.stream.IntStream;

public class 나머지가1이되는수찾기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 자연수 n이 매개변수로 주어집니다. 
		 * n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록
		 * solution 함수를 완성해주세요. 
		 * 답이 항상 존재함은 증명될 수 있습니다.
		 * 
		 * 제한사항 
		 * 
		 * 3 ≤ n ≤ 1,000,000
		 * 
		 * 
		 */
		
		solution(5);

	}

    public static int solution(int n) {
        int answer = 0;
        
        // 1. n을x로 나눠야함. x라는 변수가 필요하다.
        // 2. 반복 + 조건(n%x != 1)의 조합. // 나머지가 1이 아니면 계속 반복.
        // 3. x의 가장 작은수.. x를 변수로 두고 1씩 증가 시키자.
        
        int x = 1;
        while(n%x != 1) {
        	x++;
        	answer = x;
        	// 다음 반복때 나머지가 1이 나오게되면 반복문 실행이 안됨.
        	// 그러므로 변수 x를 1증가 시킨 것을 저장함.
        }
        
        return answer;
    }
}


class 나머지가1이되는수찾기_다른사람 {
    public int solution(int n) {
        return IntStream.range(2, n).filter(i -> n % i == 1).findFirst().orElse(0);
    }
    // 이 분은 스트림을 사용하셨다.
    // 댓글에 함수가 적은 곳에서 스트림을 사용하는 것은 비효율적이며
    // 단순 반복에는 좋지 못한 사용이라고 한다.
    // 한 번 알아봐야 겠다.
}



/*
 * 대부분의 답은 나와 비슷하였다.
 * 
 * 이 코드의 스트림은 비록 비효율적(?)이라고 하지만, 어떤 기능인지 명확하게 공부 해보자.
 * 
 * 
 * 
 * 
 * 
 * 
 */
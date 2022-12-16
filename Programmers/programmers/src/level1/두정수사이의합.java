package level1;

public class 두정수사이의합 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 두 정수 a, b가 주어졌을 때 
		 * a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요. 
		 * 예를 들어
		 * a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
		 * 
		 * 제한 조건 
		 * a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요. 
		 * a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
		 *  a와 b의 대소관계는 정해져있지 않습니다.
		 * 
		 */

	}

	public static long solution(int a, int b) {
		long answer = 0;
		
		
		if(Math.abs(a-b)==0) {
			// 절대값을 기준으로 나눔.
			
			return a;
			// 수가 같으므로 a 반환하는 것으로 지정.
		}
		
		for(int i = 0; i < Math.abs(a-b)+1; i++) {
			// a와 b 사이의(a,b 포함)의 길이를 설정하고 반복문 진행
			
			if(a>b) {
				answer += (b+i);
				
			} else {
				answer += (a+i);
			}
			
		}
		
		return answer;
	}
}


class 두정수사이의합_다른사람 {

    public long solution(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
    // 수학 공식인 등차수열을 사용..
}


/*
 * 
 * 
 * 수학 공부도 어느정도 필요하구나 느낌.
 * 
 * 
 * 
 * /
 */
package level2;

public class 숫자의표현 {
	public static void main(String[] args) {
		/*
		 * Finn은 요즘 수학공부에 빠져 있습니다. 
		 * 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 
		 * 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 
		 * 
		 * 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
		 * 1 + 2 + 3 + 4 + 5 = 15 
		 * 4 + 5 + 6 = 15 
		 * 7 + 8 = 15 
		 * 15 = 15 
		 * 자연수 n이 매개변수로 주어질 때,
		 * 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
		 * 
		 * 제한사항 
		 * n은 10,000 이하의 자연수 입니다.
		 * 
		 */
		solution(15);

	}

    public static int solution(int n) {
    	/* 
    	 * 내가 문제 푸는 방법
		 * 
		 * 1부터 n까지 순차적으로 더하고 n과 같아지만, 그 이후의 숫자들에서도 
		 * 순차적으로 더했을 때, n과 같아지는지 확인해야한다.
		 * 
		 * 완전탐색을 떠올렸다.
		 * 
    	 */ 
        int answer = 0;
        int total;
        
        for(int i = 1; i <= n; i++ ) {
        	total = 0;
        	
        	for(int j = i; j <=n; j++) {
        		total += j;
        		if(total == n) {
        			answer++;
        			break;
        		} else if(total > n) {
        			break;
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }
    	
}

/*
 * 쉬운 문제인데 복잡하게 생각하여 점화식을 많은 변수와 점화식을 사용하였을 때는
 * 결과 차이가 엄청났다.
 * 
 * 그래서 간단하게 생각 해본 뒤 풀었고, 간결한 코드가 나왔다.
 * 
 * 다만 주의할 점이 첫번째 반복문에서 total = 0;를 
 * total=1;로 바꾸고 내부 반복문 조건에서 int j = i+1;를 주었더니
 * 1씩 감소된 결과가 나왔다.
 * 
 * 생각해보니 i가 n일때, j는 n+1이 되는 꼴이기 때문에 마지막 자기 자신에 대한 합산을 하지 못한다.
 * => 자기 자신은 무조건 카운트 되므로 중요함.
 * 
 */


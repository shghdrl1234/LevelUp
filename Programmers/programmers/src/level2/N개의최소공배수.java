package level2;

public class N개의최소공배수 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를
		 * 의미합니다. 
		 * 예를 들어 2와 7의 최소공배수는 14가 됩니다. 
		 * 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
		 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을
		 * 완성해 주세요.
		 * 
		 * 제한 사항 
		 * arr은 길이 1이상, 15이하인 배열입니다. 
		 * arr의 원소는 100 이하인 자연수입니다.
		 * 
		 */
	}
	
    public int solution(int[] arr) {
    	/*
    	 * 내가 푸는 방법
    	 * - 최소공배수는 해당 수 2개를 곱하고 두 수의 최대공약수를 나누면된다.
    	 * 
    	 * 1. 각 원소 끼리의 최대공약수를 구한다.
    	 * 2. 이후 최소공배수를 구한다.
    	 * 
    	 * => 0번 1번 인덱스의 최대공약수를 구했으면 최소공배수를 구하고, 
    	 * 구해진 최대공약수와 2번 인덱스의 최대공약수를 구한다.
    	 * 
    	 * 3. 원소룰 순회하면서 끝까지 진행한다.
    	 */
    	
    	if(arr.length == 1) {
    		return arr[0];
    	}

    	int answer = 0;
    	
    	//최초의 최대공약수
    	int gcd = GCD(arr[0],arr[1]);
    	int lmc = (arr[0] * arr[1]) / gcd;
    	
    	for( int i = 2; i < arr.length; i++ ) {
    		// 앞의 원소들과 현재 원소의 공약수를 찾기 위함.
    		gcd = GCD(lmc,arr[i]); 
    		lmc = (lmc * arr[i]) / gcd;
    	}

    	answer = lmc;
    	
        return answer;
    }
    // 최대공약수 구하는 메서드 (재귀 호출)
	private int GCD(int num1, int num2) {
		
		if(num1 % num2 == 0 ) {
			return num2;
		}
		
		return GCD(num2, num1 % num2);
	}
    
}

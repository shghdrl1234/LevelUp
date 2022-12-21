package level2;

public class 행렬의곱셈 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
		 * 
		 * 제한 조건 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다. 
		 * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다. 곱할 수 있는 배열만 주어집니다.
		 * 
		 */
	}
    
	
	public int[][] solution(int[][] arr1, int[][] arr2) {
        /*
         * 내가 푸는 방법
		 * 1. 배열이 아닌 행렬의 합이다. 행렬!
		 * 2. answer행렬의 1행 1열의 값은 a의 1행1열 * b의 1행 1열 + a의 1행2열 * b의 2행 1열 + ... + a의 1행 n열 + b의 n행 1열 이다. 
         * 3. answer행렬의 1행 1열의 값을 구할 때, a의 열과 b의 행이 같이 변하고, 같은 길이를 가진다. 
         * 4. answer배열의 1차 배열의 수는 arr1배열의 1차배열 수와 같다. 
         */
		
		int[][] answer = new int[arr1.length][arr2[0].length];

		for(int i = 0; i < arr1.length; i++) {
		// answer행열 행의 개수 = arr1의 행의 개수
			
			for(int j = 0; j < arr2[0].length; j++) {
				// answer행열 열의 개수 = arr2의 열의 개수
				// ========= 여기 까지의 for문은 배열을 담기 위한 위치 선정 ==========

				for(int l = 0; l < arr2.length; l++) {
					
					answer[i][j] += (arr1[i][l] * arr2[l][j]);
				}
				
			}
			
		}
		
        return answer;
    }
}

/*
 * 
 * 이 문제는 행렬을 다루는 문제로 공식을 알고 있으면
 * 풀기 쉽다.
 * 
 * 다만 for 반복문과 어떤 부분들을 합, 곱을 해줘야 하는지 명확하게 파악해야한다.
 * for 변수를 지정 잘못 해줘서 시간이 많이 걸렸다.
 * 
 */

package level1;

public class 행렬의덧셈 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 
		 * 같은 열의 값을 서로 더한 결과가 됩니다.
		 *  
		 * 2개의 행렬 arr1과 arr2를 입력받아, 
		 * 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
		 * 
		 * 제한 조건 
		 * 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
		 */

	}
    public int[][] solution(int[][] arr1, int[][] arr2) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. 반복문 속의 반복문
    	 * 2.
    	 */
    	
    	int[][] answer = arr1;
    	// 문제 자체에서는 딱히 고려할 게 없어서
    	// 크기를 그대로 복사해오는 것으로 판단함.
    	
    	for(int i = 0; i < arr1.length; i++) {
    		
    		for(int j = 0; j <arr1[i].length; j++) {
    			answer[i][j] = arr1[i][j] + arr2[i][j];
    		}
    		
    	}
        return answer;
    }
}

/*
 * 이차원 배열치고는 쉽게 나온 문제라고 생각함.
 * 가장 추천을 많이 받은 코드와 거의 일치함.
 */

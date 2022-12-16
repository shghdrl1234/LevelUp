package level1;

import java.util.Arrays;

public class 제일작은수제거하기 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, 
		 * solution을 완성해주세요. 
		 * 
		 * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
		 * 
		 * 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고,
		 * [10]면 [-1]을 리턴 합니다.
		 * 
		 * 제한 조건 
		 * arr은 길이 1 이상인 배열입니다. 
		 * 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
		 */
		
		System.err.println(Arrays.toString(solution(new int[] {4,3,2,1})));
	}
	
	public static int[] solution(int[] arr) {

		/*
		 * 내가 생각하는 풀이
		 * 1. 배열 받아와서
		 * 2-1. 오름차 순으로 정렬 => 다시 조건을 보니 오름차 순으로 정렬하라는 말이 없음.
		 * 3-1. 첫번째 인덱스 삭제
		 * 
		 * 2-2. 반복문을 사용하여, 인덱스 끼리 값을 비교하여 작은 수는 저장
		 * 3-2. 저장하기 위해서 반복문 밖에 변수 필요.
		 * 
		 * 4. 변수에 저장된 수와 일치하는 인덱스 삭제.
		 * 
		 */
		
		if(arr.length==1) {
			// 배열에 인덱스가 1개만 있으면, 최소값이 본인이 되어버려,
			// 삭제하면 빈 배열이 됨.
			
			return new int[]{-1};
		}
		
		int num = arr[0];
		// 반복문 내에서 비교대상이 필요하여 arr의 첫번째 인덱스를 저장
		
		for(int i = 1; i < arr.length; i++) {
			
			if(arr[i] < num) {
				num = arr[i];
				// 순차적으로 반복하면서, index 값이 이전에 등장한 최소값 보다 작으면
				// 변수 num에 저장된다.
			}
			
		}
		
		int[] answer = new int[arr.length-1];
//		for(int i = 0; i < answer.length; i++) {
//			if(arr[i] != num) {
//				// 받아온 배열의 인덱스 값이 최소값이 아닐때
//				
//				answer[i] = arr[i];
//				// 값을 저장
//			}
//		}
			int j = 0;
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[j] == num) {
				j++;
			}
			answer[i] = arr[j];
			j++;
		}
		
		
		return answer;
	}

}

// 이 문제는 다른 분들의 솔루션 코드와 비슷하여 첨부하지 않겠다.
// 여기서 내가 헤맨이유가, answer[]에 인덱스 값을 주입할 때 였다.
// 그 이유는 받아온 배열에서 인덱스를 하나 지우면 반복문에서 answer 배열과 arr 배열의 증가하는
// 값이 1 차이가 나야하는데 그 것을 고려하지 못하였던 것이다.

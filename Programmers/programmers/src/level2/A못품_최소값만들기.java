package level2;

import java.util.ArrayList;
import java.util.Collections;

public class A못품_최소값만들기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 길이가 같은 배열 A, B 두개가 있습니다. 
		 * 각 배열은 자연수로 이루어져 있습니다. 
		 * 배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 
		 * 
		 * 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다. 
		 * 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. 
		 * (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
		 * 
		 * 예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면
		 * 
		 * A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. 
		 * (누적된 값 : 0 + 5(1x5) = 5) 
		 * 
		 * A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. 
		 * (누적된 값 : 5 + 16(4x4) = 21) 
		 * 
		 * A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. 
		 * (누적된 값 : 21 + 8(2x4) = 29) 즉, 이 경우가 최소가 되므로 29를 return 합니다.
		 * 
		 * 배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
		 * 
		 * 제한사항 
		 * 배열 A, B의 크기 : 1,000 이하의 자연수
		 * 배열 A, B의 원소의 크기 : 1,000 이하의 자연수
		 * 
		 */
		
		solution(new int[] {1,4,2}, new int[] {5,4,4});

	}
	
    public static int solution(int []A, int []B) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. 가장 큰 값과 가장 작은 값을 곱해준다. 
    	 * 2. 곱을 위해 각 배열들을 오름차순, 내림차순으로 정렬해준다.
    	 * 3. 이후 반복문을 통하여 곱 누적합의 최소값을 찾는다.
    	 *
    	 */
    	ArrayList<Integer> arr1 = new ArrayList<Integer>();
    	ArrayList<Integer> arr2 = new ArrayList<Integer>();
    	
        /*
         * 배열 길이는 같으니, 동시에 리스트 저장.
         */
        for(int i = 0; i < A.length; i++) {
        	arr1.add(A[i]);
        	arr2.add(B[i]);
        }
        
        // 오름차순, 내림차순 각각 해주기.
	     Collections.sort(arr1);
	     Collections.sort(arr2, Collections.reverseOrder());

	     int comp = 0;
	     // 이후 최소값은 찾아 계산하기.
	     for(int i = 0; i < A.length; i++) {
	    	 comp += arr1.get(i)*arr2.get(i);
	     }
        System.out.println(comp);
        return comp;
    }

}

/*
 * 이 정도 난이도는 대부분의 사람들이 같은 방법으로 문제를 푸는 것 같다.
 * 특출난 것은 없어 보이는 문제였고, 특이한 풀이로는 합병정렬로 푼 정도..
 * 
 */


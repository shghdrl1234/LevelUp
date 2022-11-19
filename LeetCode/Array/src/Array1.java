import java.util.Arrays;

public class Array1 {

	public static void main(String[] args) {

		/*
		 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
		 * order, and two integers m and n, representing the number of elements in nums1
		 * and nums2 respectively.
		 * 
		 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
		 * 
		 * The final sorted array should not be returned by the function, but instead be
		 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
		 * n, where the first m elements denote the elements that should be merged, and
		 * the last n elements are set to 0 and should be ignored. nums2 has a length of
		 * n.
		 * 
		 * 
		 * 정수형 배열 nums1, nums2가 오름차 순으로 정렬되어있다.
		 * 각각의 정수 m과 n은 nums1과 nums2의 수를 나타낸다.
		 * 
		 * nums1과 nums2를 병합하고 오름차 순으로 정렬하라.
		 * 
		 * 반환값은 없어도 되고, nums1배열에 모든 값들을 저장해라, nums1의 배열의 길이는 m+n이고
		 * m은 병합되어야하는 수를 나타내고, n은 0의 개수이자, num2의 길이이다.
		 *
		 *
		 *
		 *  나의 문제 풀이 
		 * 1. nums1의 길이 m+n 에서 0(숫자로 취급안하는)의 개수인 n값을 뺀 값인 m번째 이후의 인덱스 부터 
		 *    nums2의 값을 넣어준다.
		 * 2. nums1[m+i] = nums2[i]
		 * 3. 두 개의 배열을 동시에 반복문에 넣어야함.
		 * 
		 * 가장 간단했던 풀이
		 * while(n>0) A[m+n-1] = (m==0||B[n-1] > A[m-1]) ? B[--n] : A[--m];
		 * 
		 */
		
		int[] a = {2,4,5,0,0,0};
		int[] b = {2,5,3};
		int a_1 = 3;
		int b_1 = 3;

		int[] a2 = {2,4,0};
		int[] b2 = {3};
		int a2_1 = 2;
		int b2_1 = 1;
		
		int[] a3 = {2,0,5,0,0};
		int[] b3 = {6,3};
		int a3_1 = 3;
		int b3_1 = 2;
 		
		solution s = new solution();
		
		s.merge(a, a_1, b, b_1);
		s.merge(a2, a2_1, b2, b2_1);
		s.merge(a3, a3_1, b3, b3_1);
	}

}


class solution {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// m과 n을 받아옴.
		// nums1[m+i] = nums2[i]을 해야함.
		// 언제? nums1[m] 이후에.
		// 그러면 while 문에 들어갈 때, nums1[i]는 nums1[m+1]로 지정되어 있어야함.
		int i = 0;
			System.out.println("호출");
		while( i < m+n && i < n  ) {
			// 조건식이 참이면 반복.
			// 조건식이 참이면 nums1[m+i] = nums2[i];
			nums1[m+i] = nums2[i];
			i++;
		}
		
		int store = 0;
		for(int k=0; k < nums1.length-1; k++) {
			for(int j = 0; j < nums1.length-1; j++) {
				if(nums1[j]>nums1[j+1]) {
					store = nums1[j];
					nums1[j] = nums1[j+1];
					nums1[j+1] = store;
				}
			}
		
		}
		System.out.println(Arrays.toString(nums1));
	}
	
}
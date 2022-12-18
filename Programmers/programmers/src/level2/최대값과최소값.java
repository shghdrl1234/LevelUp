package level2;

import java.util.Arrays;

public class 최대값과최소값 {

	public static void main(String[] args) {

		/*
		 * 문제 설명 
		 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
		 * str에 나타나는 숫자 중 최소값과 최대값을 찾아 
		 * 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요. 
		 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
		 * 
		 * 제한 조건 
		 * s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
		 * 
		 */

		solution("-1 2 3 -4 -5 -6");
	}
	
	public static String solution(String s) {
	    /*
	     * 내가 푸는 방법
	     * 1. split으로 배열화
	     * 2. sort
	     * 
	     */

		String answer = "";
        String[] arr = s.split(" ");
        int[] arr2 = new int[arr.length];
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++) {
        	arr2[i] = Integer.valueOf(arr[i]);
        }
        
        Arrays.sort(arr2);
        // 오름차순으로 정렬
        
        
        answer = arr2[0] + " " + arr2[arr2.length-1];
        System.out.println(answer);
        return answer;
    }
	
}

class 최대값과최소값_다른사람 {
    public String getMinMaxString(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
                n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;

    }

}


/*
 * 
 * 레벨 2치고는 쉬운문제라고 생각.
 * 레벨 1로 가도 될 듯.
 * 
 * 
 * 
 */



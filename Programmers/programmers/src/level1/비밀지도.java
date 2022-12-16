package level1;

import java.util.Arrays;

public class 비밀지도 {

	public static void main(String[] args) {
		/*
		 * 네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 
		 * 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기
		 * 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
		 * 
		 * 1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 
		 *    각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다. 
		 * 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 
		 *    지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 
		 *    지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다. 
		 * 3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다. 
		 * 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 
		 * 	  얻어지는 이진수에 해당하는 값의 배열이다.
		 * 
		 * 네오가 프로도의 비상금을 손에 넣을 수 있도록, 
		 * 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
		 * 
		 * 
		 * 입력 형식
		 * 입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
		 *	
		 * 1 <= n <= 16
		 * arr1, arr2는 길이 n인 정수 배열로 주어진다.
		 * 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 <= x <= 2n - 1을 만족한다.
		 *	 
		 */
		int n = 3;
		int[] arr1 = {1,7,6};
		int[] arr2 = {7,2,6};
		solution(n, arr1, arr2);

	}
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        /*
         * 내가 문제 푸는 방법
         * 1. arr1과 arr2의 요소를 이진법으로 변경한다.
         * 
         * 2. 그 이후 이차배열로 변경한다.
         * ex) arr1이 [9,10,3]로 주어지면   
         * [0] [100] 
         * [1] [101]
         * [2] [010]
         * 를 생성.
         * 
         * 3. 이 때, arr1의 각 인덱스의 요소의 길이는 n 이다. arr1[i].length가 n이 아니면
         * n-length 개의 0을 추가한다.
         * "00" + 100 
         * => 문자열로 만들어줘야함.
         * 
         * 2. arr1[i], arr2[i] 요소의 각 인덱스별로 비교하여 1이 하나라도 있으면
         * # 그렇지 않고 둘 다 0이라면  " "으로 반환 
         * => char 값으로 비교
         * 
         * 3. i = 0 ~ n 까지 순회.
         * 
         */
    	
    	String[] answer = new String[n];
    	String[][] bin_arr1 = new String[n][1];
    	String[][] bin_arr2 = new String[n][1];
    	
    	int i = 0;
    	while(i < arr1.length) {
    		bin_arr1[i][0] = Integer.toBinaryString(arr1[i]);
    		bin_arr2[i][0] = Integer.toBinaryString(arr2[i]);
    		
    		// arr1과 arr2의 i번째 줄의 벽과 공간을
    		// 이차배열 [i] 인덱스에 저장함.
    		
    		System.out.println("i 크기 : " + i);
    		System.out.println("bin_arr1["+i+"][0] : " + bin_arr1[i][0]);
    		System.out.println("bin_arr2["+i+"][0] : " + bin_arr2[i][0]);   		

    		System.out.println("n-bin_arr1[i][0].length() = "+ (n-bin_arr1[i][0].length()));
    		System.out.println("n-bin_arr2[i][0].length() = "+ (n-bin_arr2[i][0].length()));

    		if(bin_arr1[i][0].length() <= n) {
    			// 요소의 길이가 n보다 작다면, 그 차이만큼 요소의 앞에 0을 더해라
    			for(int j = 0; j < n-Integer.toBinaryString(arr1[i]).length(); j++) {
    				bin_arr1[i][0] = "" + "0"+ "" +bin_arr1[i][0];
					System.out.println("j = "+ 0);
					System.out.println(bin_arr1[i][0].length());
    			}
    		}
    			
			if(bin_arr2[i][0].length() <= n) {
				// 요소의 길이가 n보다 작다면, 그 차이만큼 요소의 앞에 0을 더해라
				for(int k = 0; k < n-Integer.toBinaryString(arr2[i]).length(); k++) {
					bin_arr2[i][0] = "" +"0" +""+ bin_arr2[i][0];
				}	
    		}
			System.out.println("if 끝 / bin_arr1["+i+"][0] : " + bin_arr1[i][0]);
			System.out.println("if 끝 / bin_arr2["+i+"][0] : " + bin_arr2[i][0]);			
			
			for(int l = 0; l <= n-1; l++) {
				// arr1[i], arr2[i]의 각 요소별 문자열에서, 하나의 배열에서 문자열의 인덱스가 1의 값을 가지면
				// 다른 배열도 1로 만든다.
				if(bin_arr1[i][0].charAt(l) == '1' || bin_arr2[i][0].charAt(l) == '1') {
					bin_arr1[i][0] = bin_arr1[i][0].substring(0, l) + "#" + bin_arr1[i][0].substring(l+1) ;
					bin_arr2[i][0] = bin_arr2[i][0].substring(0, l) + "#" + bin_arr2[i][0].substring(l+1);
				} else {
					bin_arr1[i][0] = bin_arr1[i][0].substring(0, l) + " " + bin_arr1[i][0].substring(l+1);
					bin_arr2[i][0] = bin_arr2[i][0].substring(0, l) + " " + bin_arr2[i][0].substring(l+1);
				}
				System.out.println("bin_arr1["+i+"][0] : " + bin_arr1[i][0]);
				System.out.println("bin_arr2["+i+"][0] : " + bin_arr2[i][0]);
			}

			i++;
    	}
    	
    	for(int m = 0 ; m < answer.length; m++) {
    		answer[m] = bin_arr1[m][0];
    	}
    	
        return answer;
    }

}

class 비밀지도_다른사람 {
	  public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] result = new String[n];
	       
	        for (int i = 0; i < n; i++) {
	            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
	            // or 연산자, 두 값중 하나라도 1 이면, 1이 온다.
	            // => 주어진 조건중 하나라도 true면 true.
	            // true => 1이라는 값.
	        }

	        for (int i = 0; i < n; i++) {
	            result[i] = String.format("%" + n + "s", result[i]);
	            result[i] = result[i].replaceAll("1", "#");
	            result[i] = result[i].replaceAll("0", " ");
	        }

	        return result;
	    }
	}

/*
 * 이차 배열로 푼 사람은 거의 없었다.
 * 재귀함수 등 다양한 것들을 사용하여 풀었다.
 * 
 *  이 부분에 대해서는 공부 하도록 하고, 일단 내가 풀 때 주의해야할 점은,
 *  배열 인덱스의 길이로 반복문을 실행할 때, 반복문 내용에 배열 길이가 바뀌게 되면
 *  반복때마다 조건부의 값이 고정되지 않았다. 이를 대비하기 위해
 *  고정시킬 수 있는 배열을 찾아서 지정해줘야한다. 
 * 
 */
package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class A못품_숫자짝꿍 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 
		 * 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다.
		 * (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). 
		 * X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
		 * 
		 * 예를 들어, X = 3403이고 Y = 13203이라면, 
		 * X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 
		 * 
		 * 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 
		 * 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다.
		 * (X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.) 
		 * 
		 * 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
		 * 
		 * 제한사항
		 *  3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다. 
		 *  X, Y는 0으로 시작하지 않습니다. X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.
		 * 
		 * 
		 * 
		 */
		String x ="5525";
		String y ="1255";
		
		System.out.println(solution2(x,y));
		
		
		
	}
	
	
	
	public static String solution2(String X, String Y) {
        
		/*
		 * 시간 복잡도 면에서 중첩 for문을 사용하지말라고 한다.
		 * 
		 * 1. 숫자를 이용하여 문제를 푼다.
		 * 2. 각 숫자별로 출현한 횟수를 구한 다음
		 * 3. 작게 나온 쪽을 최대 값으로 잡는다. 
		 * 
		 * 
		 * 
		 */
		ArrayList<Integer> xArr = new ArrayList<Integer>();
		ArrayList<Integer> yArr = new ArrayList<Integer>();
	 
		ArrayList<Integer> sumArr = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++) {
			xArr.add(0);
			yArr.add(0);
		} // 각 리스트에 0을 넣음.
		
		for(int i = 0; i < X.length(); i++) {
			
			for(int j = 0; j < 10; j++) {
				
				if(X.charAt(i) == j+48 ) {
					xArr.set(j, xArr.get(j)+1);
				}
				
			}
			
		}
		
		for(int i = 0; i < Y.length(); i++) {
			
			for(int j = 0; j < 10; j++) {
				
				if(Y.charAt(i) == j+48 ) {
					yArr.set(j, yArr.get(j)+1);
				}
				
			}
			
		}
		
		for(int i = 0; i < 10; i++) {
			if(xArr.get(i) <= yArr.get(i)) {
				sumArr.add(xArr.get(i));
			} else {
				sumArr.add(yArr.get(i));
			}
		}
		
		
		
		System.out.println("xArr : " + xArr);
		System.out.println("yArr : " + yArr);
		System.out.println("sumArr : " + sumArr);
		
		String answer = "";
		
		for(int i = 0; i < sumArr.size(); i++) {
			
			for(int j = 0; j < sumArr.get(i); j++) {
				answer += ("" + i);
			}
			
		}

		StringBuffer sb = new StringBuffer(answer);
		String reverse = sb.reverse().toString();
		
		System.out.println(answer);
		System.out.println(reverse);
		
	
		if(reverse.length() == 0) {
			reverse = "-1";
		}
			
		int cnt = 0;
		
		for(int i = 0; i < reverse.length(); i++) {
			if(reverse.charAt(i) != 48) {
				cnt++;
				break;
			}
		}
		
		if(cnt == 0) {
			reverse = "0";
		}
		
		return reverse;
    }

	
	 public static String solution1(String X, String Y) {
	        /*
	         * 내가 문제 푸는 방법
	         * 1. 두 문자열을 비교하여 같은 수를 가지는 위치에서 각각 지운다.
	         * 2. 지운 요소는 다른 배열을 만들어서 저장해둔다.
	         * 3. 이후 내림차순으로 정렬하여 반환
	         */
		 
			ArrayList<String> xArr = new ArrayList<String>();
			ArrayList<String> yArr = new ArrayList<String>();
		 
			ArrayList<String> sumArr = new ArrayList<String>();
			
			for(String i : X.split("")) {
				xArr.add(i);
			}
			
			for(String i : Y.split("")) {
				yArr.add(i);
			}
			
			for(int i = 0; i < xArr.size(); i++) {
				
				for(int j = 0; j < yArr.size(); j++) {
					
					if(xArr.get(i).equals(yArr.get(j))) {
						sumArr.add(xArr.get(i));
						
						xArr.remove(i); i--;
						yArr.remove(j); j--;
						break;
					}
				}
			}
			
			System.out.println(sumArr);
			Collections.sort(sumArr, Collections.reverseOrder());
			System.out.println(sumArr);
			
			String answer = "";
			
			for(String s : sumArr) {
				answer += s;
			}
			
			if(answer.length() == 0) {
				answer = "-1";
			}
			
			int cnt = 0;
			
			for(int i = 0; i < answer.length(); i++) {
				if(answer.charAt(i) != '0') {
					cnt++;
				}
			}
			
			if(cnt == 0) {
				answer = "0";
			}
			
			
			System.out.println(answer);
	    	return answer;
	    }
	
	
	
    public static String solution(String X, String Y) {
        /*
         * 내가 문제 푸는 방법
         * 1. 두 문자열에서 같은 수를 가지는 값을 찾아서 문자열에서 지운다.
         * 2. 같은 수는 다른 곳에 배치하여 내림차순으로 리턴.
         * 
         */

		ArrayList<String> xArr = new ArrayList<String>();
		ArrayList<String> yArr = new ArrayList<String>();
    	String answer = "";
    	String store ="";
		for(String i : X.split("")) {
    		xArr.add(i);
    	}

		for(String j : Y.split("")) {
			yArr.add(j);
		}
		
		for(int i = 0; i < xArr.size(); i++) {
			
			for(int j = 0; j < yArr.size(); j++) {
				if(xArr.size()==1) {
					i=0;
				}
				
				if(xArr.get(i).equals(yArr.get(j))) {
					store += xArr.get(i);
					xArr.remove(xArr.get(i));
					yArr.remove(yArr.get(j));
					j--;
				}
			}
		}
		
		String[] hi = store.split("");
    	Arrays.sort(hi);
    	System.out.println();
    	answer = Arrays.toString(hi);
    	
    	if(String.valueOf(store) == "") {
    		answer = "-1";
    	} else if(Integer.valueOf(store) == 0) {
    		answer = "0";
    	}
    	
		 System.out.println(answer);
    	return answer;
    }

}

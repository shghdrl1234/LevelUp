package level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 숫자짝꿍 {

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
		String x ="100";
		String y ="203045";
		solution(x,y);
	}
	
    public static String solution(String X, String Y) {
        /*
         * 내가 문제 푸는 방법
         * 1. 두 문자열에서 같은 수를 가지는 값을 찾는다.
         * 2. 같은 수가 나타나면 각 문자열에서 지운다.
         * 3. 지운 문자들은 다른 곳에 따로 저장한다. => answer에 넣고 sort?
         * 
         */
    	
    	Set<String> xSet = new HashSet<String>();
        ArrayList<String> xArr = new ArrayList<String>();
    	
    	String answer = "";
    	
//    	String[] x1 = X.split("");
//    	String[] y1 = Y.split("");
    	
    	StringBuilder x = new StringBuilder(X);
    	StringBuilder y = new StringBuilder(Y);
//    	String x = X;
//    	String y = Y;
    	
    	for(int i = 0; i < x.length(); i++) {
    		
    		int j=0;
    		while(j < y.length() && x.length() != 0) {
    			    			
    			if(x.charAt(i) == (y.charAt(j))) {

    				if(xSet.contains(x.charAt(i)+"")) {
    					xArr.add(x.charAt(i)+"");
    				} else {
    					xSet.add(x.charAt(i)+"");
    				}
	    				x = x.deleteCharAt(i);
	    				y = y.deleteCharAt(j);
	    				j--;
	    				System.out.println("x.length() = "+x.length());
	    				System.out.println("y.length() = "+y.length());
    			}
    			j++;
    		}
    	}
    	
    	System.out.println("xArr = "+xArr);
    	System.out.println("xSet = "+xSet);
    	System.out.println("xArr.size() = "+xArr.size());

    	for(String i : xSet) {
    		xArr.add(i);
    	}

    	for(String i : xArr) {
    		answer += i;
    	}
    	
    	if(xArr.size() == 0) {
    		answer = "-1";
    	}
    	
    	
    	System.out.println("answer = "+answer);
    	return answer = (Integer.valueOf(answer) == 0) ? "0" : answer ;
    }

}

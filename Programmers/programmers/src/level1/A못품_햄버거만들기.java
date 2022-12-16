package level1;

import java.util.ArrayList;

public class A못품_햄버거만들기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 
		 * 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해주면 
		 * 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 
		 * 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다.
		 * 
		 * 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 - 야채 - 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 
		 * 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 
		 * 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
		 * 
		 * 예를 들어, 
		 * 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 
		 * 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 
		 * 
		 * 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 
		 * 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
		 * 
		 * 상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 
		 * 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
		 * 
		 * 제한사항
		 * 1 ≤ ingredient의 길이 ≤ 1,000,000 ingredient의 원소는 1, 2, 3 중 하나의 값이며, 
		 * 순서대로 빵, 야채, 고기를 의미합니다.
		 * 
		 */
		System.out.println(solution(new int[] {1,2,1,2,3,1,3,1,2,3}));

	}
	
    public static int solution(int[] ingredient) {
    	
    	/*
    	 * 내가 문제 푸는 방법
    	 * 빵 = 1, 야채 = 2, 고기 = 3
    	 * 
    	 * ! 순서대로 1 2 3 1 이라는 것이 만들어지면 해결.
    	 * ! 배열의 길이는 최소 4여야 한다.
    	 * ! 1 2 3 1이 순서대로 나오면, 그 인덱스 값은 지워지면서, 리턴 값은 1 추가.
    	 * 
    	 * 
    	 */
  
        int answer = 0;
    	
    	String buger = "";
    	
//    	for(int i : ingredient) {
//    		buger += i;
//    	}
//    	System.out.println(buger);
    	// 문자열로 변환.
    	
    	ArrayList<String> str = new ArrayList<String>(buger.length());
    	
    	for(int j : ingredient) {
    		
    		str.add(String.valueOf(j));
    		buger += j;
    		// ArrayList에 저장
    	}
    	System.out.println("str : " + str);
    	System.out.println("buger : "+ buger);
    	
    	while(buger.indexOf("1231") != -1) {
    		// 1231이 연속된다면
    		
    		int indexNum = buger.indexOf("1231");
    		// 그 인덱스의 위치를 찾고
    		
    		
    			str.remove(indexNum);
    			str.remove(indexNum);
    			str.remove(indexNum);
    			str.remove(indexNum);
    			// str의 arrayList에서 삭제한다. => 햄버거 하나 완료.
    		
    		answer += 1;
    		
    		buger = "";
        	
        	for(String i : str) {
        		buger += i;
        	}
    		// 문자열을 다시 재지정 해준다.
    	}
    	
    	buger.indexOf("1231");
    	
        return answer;
    }
	
}

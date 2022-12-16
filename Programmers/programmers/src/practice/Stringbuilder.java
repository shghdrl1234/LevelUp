package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Stringbuilder {

	 public String[] solution(String[] orders) {
	        String[] answer = {};

	        Set<String>[] set = new HashSet[orders.length];     
	     // 각 유저별로 hashmep을 만든다.
	     //  hashmap에 음식을 저장한다.
	     // 각 hash의 크기를 비교하여 유저를 반환한다.

	     // 배열의 요소로 유저이름을 만든다.
	     // 각 유저이름에 해당하는 주문들을 hashmap으로 구성한다.
	     
	    // 반복문을 통해, 인덱스별 " "로 split 하여 첫번째 인덱스가 같으면?

	    // 반복문을 통해, hashset 2차배열로 만들어준다
	       for(int i = 0; i < orders.length; i++) {
	           set[i] = new HashSet<String>();
	       }
	         set[0].add(orders[0].split(" ")[0]);
	       for(int i = 0; i < orders.length; i++) {

	       }

	       System.out.println(set[0].toString());
	        
	        


	        return answer;
	    }

}

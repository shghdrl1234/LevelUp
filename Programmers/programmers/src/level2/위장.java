package level2;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;

public class 위장 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
		 * 
		 * 예를 들어 스파이가 가진 옷이 아래와 같고 
		 * 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 
		 * 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
		 * 
		 * 종류 이름 
		 * 얼굴 동그란 안경, 검정 선글라스 
		 * 상의 파란색 티셔츠 
		 * 하의 청바지 
		 * 겉옷 긴 코트 
		 * 
		 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 
		 * 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한사항 
		 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다. 
		 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다. 
		 * 같은 이름을 가진 의상은 존재하지 않습니다. 
		 * clothes의 모든 원소는 문자열로 이루어져 있습니다. 
		 * 모든 문자열의 길이는 1이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
		 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
		 * 
		 */

	}
	
    public int solution(String[][] clothes) {
    	/*
    	 * 내가 문제 푸는 방법
		 *
		 * - 주어진 의상중 하나는 무조건 착용해야한다.
		 * - 같은 종류의 의상은 동시에 착용할 수 없다.
		 * - 무조건 하나 이상의 의상은 입어야한다.
		 * 
		 * => 의상을 입지 않는 것도 "하나의 의상"이라고  간주하고 풀어본다.
		 * 
		 * ex) 상의,하의,장갑,모자 4가지 종류가 주어지고, 각 종류별로 4가지의 의류가 있다면.
		 * 상의를 입는 경우의 수 : 5가지 (4 + 입지 않는 방법 1)
		 * 하의를 입는 경우의 수 : 5가지 (4 + 입지 않는 방법 1)
		 * 장갑을 입는 경우의 수 : 5가지 (4 + 입지 않는 방법 1)
		 * 모자를 입는 경우의 수 : 5가지 (4 + 입지 않는 방법 1)
		 * 
		 * 5*5*5*5 => 625 - 1(전체를 안입었을 경우) 가 된다.
		 * 
    	 * 1. 종류 - 의상을 구분 지을 수 있는 컬렉션을 사용한다.
    	 * => map을 사용한다.
    	 * 
    	 * 2. 컬렉션을 사용하면서 중복되지 않도록 반복문을 만든다.
    	 * 
    	 */
    	
    	HashMap<String, Integer> hm = new HashMap<String, Integer>();
    	
    	// 주어진 의상 종류를 확인 및 저장하는 코드
    	// str은 clothes의 하나의 열을 알려주는 것임.
    	for(String[] str : clothes) {
    		
    		// key 값 : str[1] => 의상의 종류 
    		// value 값 : str[1] => 헤당 의상의 개수
    		
    		// 즉, 키 값(의상의 종류)이 중복되면, 1의 값을 올림으로써 개수가 늘어났다는 것을 코드로 만듦.
    		hm.put(str[1], hm.getOrDefault(str[1], 0)+1);
    	}
    	
    	// 이터레이터를 인터페이스를 통하여 반복문을 진행하기위한 객체생성 
    	Iterator<Integer> it = hm.values().iterator();
    	
    	// 곱 연산을 위한 최초의 값, 0으로 시작하여 곱을 하면 0만 나온다.
    	int answer = 1; 

    	// it 객체의 현재 위치에서 다음 값이 존재한다면 연산 진행.
    	while(it.hasNext()) {
    		
    		// 연산 후미에 +1이 있는 경우는 아무것도 안입는 경우를 추가한 것임. 
    		answer *= it.next().intValue() + 1;
    	}
    	
    	// 1을 빼준 것은 모든 의상을 입지 않았을때의 경우를 빼줌.
        return answer-1;
    }

}

//class 위장_다른사람 {
//    public int solution(String[][] clothes) {
//        return Arrays.stream(clothes)
//                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
//                .values()
//                .stream()
//                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
//    }
//}

/*
 * 다른사람의 코드 중에 countion과 reducing이 나의 IDE에서는 확인되지 않는다.
 * 아마 java 버전 차이일 것으로 판단된다.
 * 
 * 이렇게 코드를 간결하게 쓸 수 있는것이.. 부럽다.
 */ 

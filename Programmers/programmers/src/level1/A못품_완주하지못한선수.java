package level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A못품_완주하지못한선수 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
		 * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
		 * 
		 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
		 * 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
		 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한사항 
		 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. 
		 * completion의 길이는 participant의 길이보다 1 작습니다. 
		 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. 
		 * 참가자 중에는 동명이인이 있을 수 있습니다.
		 * 
		 * 
		 * 
		 * 
		 */
		String[] arr1 = {"leo", "kiki", "eden"};
		String[] arr2 = {"eden", "kiki"};
		
		solution2(arr1,arr2);
	}
	
	public static String solution2(String[] participant, String[] completion) {
		/*
		 * 내가 문제 푸는 방법
		 * 1. 완주 못한 1명을 찾는다.
		 * 2. participant와 completion을 비교하여 같은 이름의 선수를 지운다.
		 * 3. 마지막 남은 1명의 이름을 반환한다.
		 * 
		 */

		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		
		for(int i = 0; i < participant.length; i++) {
			// 순회하면서 참가자 명단을 저장.
			arr1.add(participant[i]);
			System.out.println(arr1);
			
			// 순회하면서 완주자 명단 저장.
			if(i < participant.length-1) {
				arr2.add(completion[i]);
				System.out.println("arr2 : "+arr2);
				
//				 현재 보고있는 완주자의 이름이, 참가자 명단에 있으면
//				 참가자 명단에서 그 이름 하나만 삭제.
//				 완주자 명단에서도 삭제.
				// 참가자 명단이 늘어나서 지워질 수가 있고,
				// 완주자 명단이 늘ㅇ
				if(arr1.contains(completion[i])) {
					arr1.remove(completion[i]);
					arr2.remove(completion[i]);
				}
			}
			System.out.println("arr2 - 1 : "+arr2);
		}

		String answer = arr1.get(0);
		System.out.println(answer);
		return answer;
	}
	
	public static String solution1(String[] participant, String[] completion) {
		/*
		 * 내가 문제 푸는 방법
		 * 1. 완주 못한 1명을 찾는다.
		 * 2. participant와 completion을 비교하여 같은 이름의 선수를 지운다.
		 * 3. 마지막 남은 1명의 이름을 반환한다.
		 * 
		 */

		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		
		for(String s : participant) {
			arr1.add(s);
		}
		
		for(String s : completion) {
			arr2.add(s);
		}
		
		for(int i = 0; i < arr2.size(); i++) {
			
			for(int j = 0; j < arr1.size(); j++) {
				if(arr2.get(i).equals(arr1.get(j))) {
					arr1.remove(j);
					j--;
					break;
				}
			}
			
		}
		
		String answer = arr1.get(0);
		System.out.println(answer);
		return answer;
	}
	
    public static String solution(String[] participant, String[] completion) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * 
    	 * 1. participant 배열 => hash로 변경
    	 * 2. participant에 completion 원소를 대입하여 일치하면 제거
    	 * => 단, participant에 동명이인이 있으면, 해당 원소는 따로 저장해두고, 제거.
    	 * => 이 문제에서는 completeion 길이가 participant 보다 1작기 때문에 1명만 완주 못한 상태라
    	 * 동명이인을 answer로 넣으면됨.
    	 * 
    	 * 3. 동명이인이 있다면 participant를 hash로 만들면 중복이 먼저 제거됨. 
    	 * => 제대로 된 비교를 할 수 없다.
    	 * => 하지만 이걸 역이용 할 수 있는 방법이 있을까?
    	 * 
    	 * 3-1) participant, completion 두 배열 중복제거 후 남아있는 원소들을 
    	 * 추출하여 participant 에서 remove 진행 ??
    	 * => 동명이인일 경우 정확히 누군지는 모르지만, "이름"은 뽑을 수 있음.
    	 * 
    	 */
    	
    	Set<String> part = new HashSet<String>();
    	Set<String> com = new HashSet<String>();
    	
    	
    	for(int i = 0; i < participant.length; i++) {
    		part.add(participant[i]);
    		// part에 중복제거한 participant 배열의 원소 주입
    	}

    	for(int i = 0; i < completion.length; i++) {
    		com.add(completion[i]);
    		// com에 중복제거한 completion 배열의 원소 주입
    	}
    	
    	Iterator<String> itr = com.iterator();
    	for(int i = 0; i < part.size(); i++) {
    		// part.size만큼 순회
    		while(itr.hasNext()) {
    			String name = itr.next();
    			// com.sizw 만큼 순회하면서, part에서 원소가 같은 것은 제거
    			if(part.contains(name)) {
    				part.remove(name);
    				i--;
    				// 원소가 제거되면 전체 size가 줄어들기때문에 반복해주는 i 변수도 -1 해준다
    			}
    		}
    	}
    	// 중복 제거를 하고 진행하면
    	// 참가자 중복이 지워져서 
    	
    	
    	String answer = part.toString();
    	// 브라켓이 같이 나옴
    	
    	System.out.println(answer);
        return answer;
    }

}

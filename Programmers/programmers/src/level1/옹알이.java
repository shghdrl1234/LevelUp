package level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 옹알이 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 
		 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 
		 * 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고
		 * 연속해서 같은 발음을 하는 것을 어려워합니다. 
		 * 문자열 배열 babbling이 매개변수로 주어질 때, 
		 * 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를완성해주세요.
		 * 
		 * 제한사항 
		 * 1 ≤ babbling의 길이 ≤ 100 
		 * 1 ≤ babbling[i]의 길이 ≤ 30 
		 * 문자열은 알파벳 소문자로만 이루어져 있습니다.
		 * 
		 */
		String[] arr = {"aya", "yee", "u", "maa"};
		String[] arr2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		String[] arr3 = {"wooyemawooye", "mayaa", "ymaeaya"};
		String[] arr4 = {"ayaye","yeaya","yeayaya","wooaya","ayaayaaya","ayawoo","woo","yeyewoo"};
		solution(arr4);

	}
	
	 public static int solution(String[] babbling) {
	     
		 
		 /*
		  * 내가 문제 푸는 방법
		  * 
		  * 1. babbling을 순회하여, 각 단어들을 포함하고 있으면 단어들을 특정 단어로 변환.
		  * 
		  * 2. 최종 babbling의 원소들이 특정 단어만 포함되어 있으면 카운드한다.
		  * 
		  * => 예로들어 babbling의 원소들이 {"zye", "yewoo", "ayea"} 일 때,
		  * "ye"는 1로, "woo"는 2로 변환한다고 하면, {"z1","12","a1a"} 가 된다.
		  * 
		  * 3. 여기서 특정 단어들로만 이루어진 원소를 카운트 하면 1이된다.
		  * 
		  * 4. 하지만, 원소값이 같으면 1개만 카운트한다.
		  * => 중복 제거
		  * 
		  * 
		  */
		 
		 String[] arr = babbling.clone();
		 
		 Set<String> set = new HashSet();
		 ArrayList<String> arr2 = new ArrayList<String>();
		 
		 for(int i = 0; i < arr.length; i++) {
			 System.out.print("arr["+i+"] = " + arr[i] + ", ");
			 arr[i] = arr[i].replaceAll("aya", "0");
			 arr[i] = arr[i].replaceAll("ye", "1");
			 arr[i] = arr[i].replaceAll("woo", "2");
			 arr[i] = arr[i].replaceAll("ma", "3");
			 System.out.println("arr["+i+"] = " + arr[i]);
			 
			 if(isNum(arr[i])) {
				 
				 for(int j = 0 ; j <arr[i].length()-1; j++) {
					System.out.println("arr["+i+"].charAt("+j+") = " + arr[i].charAt(j));
					 
					 if(arr[i].charAt(j) == arr[i].charAt(j+1)) {
						 arr[i] = "dup";
						 break;
					 }
				 
				 }
			 }
			 System.out.println("==========");
			 
		 }
		 
		 for(String i : arr) {
			 if(isNum(i)) {
				 set.add(String.valueOf(i));
				 arr2.add(String.valueOf(i));
			 }
		 }
		 
		 System.out.println("set.size() = "+set.size() );
		 System.out.println("set = "+set );
		 System.out.println("arr2.size() = "+arr2.size() );
		 System.out.println("arr2 = "+arr2 );
		 return set.size();
	    }
	 
	 public static boolean isNum(String str) {
		 return str.matches("[0-3]{1,15}");
	 }

}

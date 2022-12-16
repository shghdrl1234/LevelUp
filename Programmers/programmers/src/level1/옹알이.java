package level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class �˾��� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �Ӿ��̴� �¾ �� 11���� �� ��ī�� ������ �ֽ��ϴ�. 
		 * ��ī�� ���� "aya", "ye", "woo", "ma" �� ���� ������ 
		 * �� ���� ������ �����ؼ� ���� �� �ִ� �����ۿ� ���� ���ϰ�
		 * �����ؼ� ���� ������ �ϴ� ���� ������մϴ�. 
		 * ���ڿ� �迭 babbling�� �Ű������� �־��� ��, 
		 * �Ӿ����� ��ī�� ������ �� �ִ� �ܾ��� ������ return�ϵ��� solution �Լ����ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * 1 �� babbling�� ���� �� 100 
		 * 1 �� babbling[i]�� ���� �� 30 
		 * ���ڿ��� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
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
		  * ���� ���� Ǫ�� ���
		  * 
		  * 1. babbling�� ��ȸ�Ͽ�, �� �ܾ���� �����ϰ� ������ �ܾ���� Ư�� �ܾ�� ��ȯ.
		  * 
		  * 2. ���� babbling�� ���ҵ��� Ư�� �ܾ ���ԵǾ� ������ ī����Ѵ�.
		  * 
		  * => ���ε�� babbling�� ���ҵ��� {"zye", "yewoo", "ayea"} �� ��,
		  * "ye"�� 1��, "woo"�� 2�� ��ȯ�Ѵٰ� �ϸ�, {"z1","12","a1a"} �� �ȴ�.
		  * 
		  * 3. ���⼭ Ư�� �ܾ��θ� �̷���� ���Ҹ� ī��Ʈ �ϸ� 1�̵ȴ�.
		  * 
		  * 4. ������, ���Ұ��� ������ 1���� ī��Ʈ�Ѵ�.
		  * => �ߺ� ����
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

package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Stringbuilder {

	 public String[] solution(String[] orders) {
	        String[] answer = {};

	        Set<String>[] set = new HashSet[orders.length];     
	     // �� �������� hashmep�� �����.
	     //  hashmap�� ������ �����Ѵ�.
	     // �� hash�� ũ�⸦ ���Ͽ� ������ ��ȯ�Ѵ�.

	     // �迭�� ��ҷ� �����̸��� �����.
	     // �� �����̸��� �ش��ϴ� �ֹ����� hashmap���� �����Ѵ�.
	     
	    // �ݺ����� ����, �ε����� " "�� split �Ͽ� ù��° �ε����� ������?

	    // �ݺ����� ����, hashset 2���迭�� ������ش�
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

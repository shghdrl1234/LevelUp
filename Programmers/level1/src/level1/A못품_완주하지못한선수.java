package level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A��ǰ_�����������Ѽ��� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ������ ������ �������� �����濡 �����Ͽ����ϴ�. 
		 * �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
		 * 
		 * �����濡 ������ �������� �̸��� ��� �迭 participant�� 
		 * ������ �������� �̸��� ��� �迭 completion�� �־��� ��,
		 * �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�. 
		 * completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�. 
		 * �������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�. 
		 * ������ �߿��� ���������� ���� �� �ֽ��ϴ�.
		 * 
		 * 
		 * 
		 * 
		 */
		String[] arr1 = {"leo", "kiki", "eden","leo"};
		String[] arr2 = {"eden", "kiki", "leo"};
		
		solution1(arr1,arr2);
	}
	
	public static String solution1(String[] participant, String[] completion) {
		/*
		 * ���� ���� Ǫ�� ���
		 * 1. ���� ���� 1���� ã�´�.
		 * 2. participant�� completion�� ���Ͽ� ���� �̸��� ������ �����.
		 * 3. ������ ���� 1���� �̸��� ��ȯ�Ѵ�.
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
    	 * ���� ���� Ǫ�� ���
    	 * 
    	 * 1. participant �迭 => hash�� ����
    	 * 2. participant�� completion ���Ҹ� �����Ͽ� ��ġ�ϸ� ����
    	 * => ��, participant�� ���������� ������, �ش� ���Ҵ� ���� �����صΰ�, ����.
    	 * => �� ���������� completeion ���̰� participant ���� 1�۱� ������ 1�� ���� ���� ���¶�
    	 * ���������� answer�� �������.
    	 * 
    	 * 3. ���������� �ִٸ� participant�� hash�� ����� �ߺ��� ���� ���ŵ�. 
    	 * => ����� �� �񱳸� �� �� ����.
    	 * => ������ �̰� ���̿� �� �� �ִ� ����� ������?
    	 * 
    	 * 3-1) participant, completion �� �迭 �ߺ����� �� �����ִ� ���ҵ��� 
    	 * �����Ͽ� participant ���� remove ���� ??
    	 * => ���������� ��� ��Ȯ�� �������� ������, "�̸�"�� ���� �� ����.
    	 * 
    	 */
    	
    	Set<String> part = new HashSet<String>();
    	Set<String> com = new HashSet<String>();
    	
    	
    	for(int i = 0; i < participant.length; i++) {
    		part.add(participant[i]);
    		// part�� �ߺ������� participant �迭�� ���� ����
    	}

    	for(int i = 0; i < completion.length; i++) {
    		com.add(completion[i]);
    		// com�� �ߺ������� completion �迭�� ���� ����
    	}
    	
    	Iterator<String> itr = com.iterator();
    	for(int i = 0; i < part.size(); i++) {
    		// part.size��ŭ ��ȸ
    		while(itr.hasNext()) {
    			String name = itr.next();
    			// com.sizw ��ŭ ��ȸ�ϸ鼭, part���� ���Ұ� ���� ���� ����
    			if(part.contains(name)) {
    				part.remove(name);
    				i--;
    				// ���Ұ� ���ŵǸ� ��ü size�� �پ��⶧���� �ݺ����ִ� i ������ -1 ���ش�
    			}
    		}
    	}
    	// �ߺ� ���Ÿ� �ϰ� �����ϸ�
    	// ������ �ߺ��� �������� 
    	
    	
    	String answer = part.toString();
    	// ������� ���� ����
    	
    	System.out.println(answer);
        return answer;
    }

}

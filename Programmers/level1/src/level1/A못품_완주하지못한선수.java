package level1;

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
		String[] arr1 = {"leo", "kiki", "eden"};
		String[] arr2 = {"eden", "kiki"};
		
		solution(arr1,arr2);
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

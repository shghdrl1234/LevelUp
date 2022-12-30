package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class H_index {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. 
		 * ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ����մϴ�. 
		 * ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.
		 * 
		 * � �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰�
		 * ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �ִ��� �� �������� H-Index�Դϴ�.
		 * 
		 * � �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, 
		 * �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * �����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�. 
		 * ���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.
		 * 
		 * 
		 */
		
		solution(new int[]{3,0,6,1,5});

	}

	public static int solution(int[] citations) {
		
		/*
		 * ���� ���� Ǫ�� ���
		 * 
		 * 
		 * 1. "Ư�� ��" �̶�� ������ �����Ͽ�, citations�� ��ҵ�� ���Ѵ�.
		 * => Ư�� ��Ҹ� �������� ū ���� Ư�� ����� �������� ���ƾ��ϰ�,
		 * => Ư�� ��Ҹ� �������� ������ ����� ������ Ư����Һ��� �۾ƾ��Ѵ�.
		 * 
		 * 2. �׷��ٸ� Ư����Ҵ� �������� ��ƾ� �ϳ�?
		 * => �ݺ����� ���������ڸ� ���Ͽ� citations�� �����Ѵ�. ���������� Ư����Ҹ� �����ϴ� ���̴�.
		 * => ���� if���� ���Ͽ� Ư�� ��Ҹ� �������� ū ������ ������, Ư�� ����� ������ ������ Ȯ��,
		 * => if���� ���Ͽ� �̿� ������ ��ҵ��� Ư�� ����� ������ ������ Ȯ��.
		 * => ��� �����ϸ� h�� ���� �����ϴ� ������ ����.
		 * => �ݺ����� ���� �ݺ�, ���� ū h ���� ã�´�.
		 * 
		 * => ������? �̸� ������ ������ ������ �Ѵٸ�?, �� �� �� true�� �߻��ϸ� ������ �ʴ°�?
		 * 
		 */
		
		// ������ ������ �ϱ� ���� LinkedList ��ü ���
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		for(int i : citations) {
			ll.add(i);
		}
		
		// ������������ ����
		Collections.sort(ll, new Desc());
		System.out.println(ll);
		
		// ���� �ð��� ������ �ϱ� ���� ArrayList ��ü ���
		ArrayList<Integer> arr = new ArrayList<Integer>(ll);
		
		int answer = 0;
		int large = 0; // Ư�� ��Һ��� ū ���� ������ ����� ����
		for(int i = 1; i <= 10000; i++) {
			
			for(int j = 0; j < arr.size(); j++) {
				// Ư�� ����� �� �̻��̸� large ī��Ʈ, �׷��� ������ ���� �ݺ��� ����
				// => ���� �� �ܺ� �ݺ��� ��� ����, ���������� ������ Ư�� ����� ������ ������ Ȯ��.
				if(i <= arr.get(j)) {
					large ++;
					System.out.println("���� �� i : " + i + ", ���� �� ��� : " + arr.get(j) + ",large : " + large  );
				} else {
					break;
				}
			}
			
			if(i <= large) {
				answer = i;
				break;
			} else {
				large = 0;
			}
			
			
		}
		
		System.out.println(answer);
		
		return answer;
	}
}

class Desc implements Comparator<Integer>{
	
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			return c1.compareTo(c2) * -1;
		
		}
		return -1;
	}
	
}


class H_index_�ٸ���� {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}

/*
 * 
 * ������ ���� LinkedList�� ����ߴµ� �۾� �ð��� �ٸ�������� �ҽ��ڵ庸�� �ξ� Ŀ����.
 * �ε����� ���Ƽ� �׷��� �; �˻��� �غ��Ҵµ�,
 * 
 * ù ��°�� �ε����� ������ ���� �߰� �ε����� ���� ����, ������ ���� �۾��ð��� ArrayList�� ��������
 * ���� �ӵ��� ����, ��ü���� �۾��ð��� ������ �� �ִٴ� ������ �������,
 * 
 * �� ��°��, �յڸ� ���ϴ� �Ϳ��� LinkedList�� ����ϴ� ���� �� ȿ�����̶�� ���嵵 �־���.
 * 
 * ���� ������ ���� LinkedList�� ����Ͽ���.
 * �ε��� �����ؼ��� LinkedList�� �������� �ʾҴ�.
 * 
 * ����� ������������ ������ �ϰ� i=10000���� 0���� ������ �Ϳ� ����
 * �۾��ð��� ����� ������ �Ǵܵȴ�.
 * 
 * 
 * 
 * 
 * 
 */



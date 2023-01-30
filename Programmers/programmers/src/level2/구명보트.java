package level2;

import java.util.Arrays;

public class ����Ʈ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���ε��� ���� ������� ����Ʈ�� �̿��Ͽ� �����Ϸ��� �մϴ�. 
		 * ����Ʈ�� �۾Ƽ� �� ���� �ִ� 2�� �ۿ� Ż �� ����, ���� ���ѵ� �ֽ��ϴ�.
		 * 
		 * ���� ���, ������� �����԰� [70kg, 50kg, 80kg, 50kg]�̰� ����Ʈ�� ���� ������ 100kg�̶�� 
		 * 2��° ����� 4��° ����� ���� Ż �� ������ 1��° ����� 3��° ����� ������ ���� 150kg�̹Ƿ� 
		 * ����Ʈ�� ���� ������ �ʰ��Ͽ� ���� Ż �� �����ϴ�.
		 * 
		 * ����Ʈ�� �ִ��� ���� ����Ͽ� ��� ����� �����Ϸ��� �մϴ�.
		 * 
		 * ������� �����Ը� ���� �迭 people�� ����Ʈ�� ���� ���� limit�� �Ű������� �־��� ��, 
		 * ��� ����� �����ϱ� ���� �ʿ��� ����Ʈ ������ �ּڰ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * ���ε��� ���� ����� 1�� �̻� 50,000�� �����Դϴ�. 
		 * �� ����� �����Դ� 40kg �̻� 240kg �����Դϴ�. 
		 * ����Ʈ�� ���� ������ 40kg �̻� 240kg �����Դϴ�. 
		 * ����Ʈ�� ���� ������ �׻� ������� ������ �� �ִ񰪺��� ũ�� �־����Ƿ� ������� ������ �� ���� ���� �����ϴ�.
		 */
		solution(new int[] {70,50,80,50,51,52,54,115,54,79,65},150);
		
	}
	public static int solution(int[] people, int limit) {
		/*
		 * ���� ���� Ǫ�� ���
		 * 1. ���� ������� ������ �Ѵ�.
		 * 2. ���ĵ� �迭���� �ּ� ���Կ� �ִ� ������ ���� limit���� ũ��, �ִ� ���Դ� ȥ�� ����Ʈ�� ž���ؾ��Ѵ�.
		 * => �¿�������, ������ ������ max���� �� ĭ ������ ��ܿ´�.
		 * 3. limit���� ũ�� �ʴٸ�, �� ���Ҹ� �¿� ������.
		 */

		int answer = 0; 
		Arrays.sort(people);
		int min_index = 0;
		int max_index = people.length-1;
		
		while(max_index >= min_index) {
			if(people[max_index] + people[min_index] <= limit) {
				answer++;
				max_index--;
				min_index++;
			}
			else {
				answer++;
				max_index--;
			}
		}
        
        return answer;
    }
	
    public static int solution2(int[] people, int limit) {
        /*
         * ���� ���� Ǫ�� ���
         * 1. people�� ��ȸ�ϸ鼭 �� ������ ���� limit�� �Ǹ� �ش� ���ҵ��� ����, ī��Ʈ ���� 1����.
         * 2. ��ȸ �ߴµ� 100�� �Ǵ� ���ҵ��� ���ٸ�, �� ������ ���� 100 ���ϰ� �� �� ���ҵ� ����, ī��Ʈ ���� 1����.
         * 3. �� �ܴ̿� ���� ������ŭ ī��Ʈ
         */
    	int answer = 0;
    	for(int i = 0; i < people.length; i++) {
    		if(people[i] < 40) {
    			continue;
    		}
    		
    		for(int j = i+1; j < people.length; j++) {

    			if(people[j] < 40) {
    				continue;
    			}
    			
    			if(people[i] + people[j] == limit) {
    				answer ++;
    				people[i] = 0;
    				people[j] = 0;
    				break;
    			}
    		}
    	}
    	
    	for(int i = 0; i < people.length; i++) {
			if(people[i] < 40) {
    			continue;
    		}
    		
    		for(int j = i+1; j < people.length; j++) {

    			if(people[j] < 40) {
    				continue;
    			}
    			
    			if(people[i] + people[j] < limit) {
    				answer ++;
    				people[i] = 0;
    				people[j] = 0;
    				break;
    			}
    		}
    	}
    	
    	for(int i : people) {
    		if(i > 0) {
    			answer ++;
    		}
    	}
    	
    	return answer;
    }
}

class ����Ʈ_�ٸ���� {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }
    /*
     * �� ���� 1������ �¿�� ������� - 2���� �¿�� ��츦 ���־���.
     */
}

/*
 * ó�� �õ��Ͽ��� ���� limit�� �� �°� �����Ը� ���ϱ� ����
 * ���� �ݺ����� ��ȸ�Ǿ���.
 * 
 * Ž����� ���� �������� ���� ������ �ظ� ���ϴ� ������,
 * ���� ��ȸ����, ���� ���ÿ��� ���� ȿ������ ����� ������ �� �ֵ��� �ϴ� ���̴�.
 * 
 * �ݷʴ� ã�� ���Ͽ�����, ���ʷ� �õ��� �ڵ忡���� 100�� ���� �� �Ҹ�Ǵ� ����� 
 * ȿ�������� ���Ͽ���.
 * 
 */


package level1;

import java.util.ArrayList;

public class ���ѻ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �ѱ����б��� �ٴϴ� �л����� ���� ���� ��ȣ�� ���� �ֽ��ϴ�.
		 * �� �б� �л� 3���� ���� ��ȣ�� ������ �� 0�� �Ǹ� 3���� �л��� ���ѻ��� �մϴ�.
		 * 
		 * ���� ���, 5���� �л��� �ְ�, ������ ���� ��ȣ�� ������� -2, 3, 0, 2, -5�� ��,
		 * ù ��°, �� ��°, �� ��° �л��� ���� ��ȣ�� ���ϸ� 0�̹Ƿ� �� �л��� ���ѻ��Դϴ�.
		 * 
		 * ����, �� ��°, �� ��°, �ټ� ��° �л��� ���� ��ȣ�� ���ص� 0�̹Ƿ� �� �л��� ���ѻ��Դϴ�. 
		 * ���� �� ��� �ѱ����б������� �� ���� ������� ���ѻ縦 ���� �� �ֽ��ϴ�.
		 * 
		 * �ѱ����б� �л����� ��ȣ�� ��Ÿ���� ���� �迭 number�� �Ű������� �־��� ��, 
		 * �л��� �� ���ѻ縦 ���� �� �ִ� ����� ����return �ϵ��� solution �Լ��� �ϼ��ϼ���.
		 *
		 * ���ѻ��� 
		 * 3 �� number�� ���� �� 13 
		 * -1,000 �� number�� �� ���� �� 1,000 
		 * 
		 * ���� �ٸ� �л��� ���� ��ȣ�� ���� �� �ֽ��ϴ�.
		 */
		solution(new int[]{1,2,3,-2,-1,0,0});
	}

    public static int solution(int[] number) {
    	
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 1. ���ѻ��� �ִ��� ���� �ƴ�, ���ѻ簡 ����� �� �� �ִ� ����� ���� ���϶�.
    	 * => �� ���࿡�� a��� ���Ҵ� 1���� ���Ǿ����. ������ ���� Ƚ���� 1���� ������ ���� �������.
    	 * => ���������̶�� ��?
    	 * 
    	 * 2. �� ���� ���� 0
    	 * 2-1. 0�� ������ ���, ������ ������.
    	 * 2-2. ������� ���� �ٸ� 2�� �̰�, �������� 1�� �̴� ���. => ���� 0
    	 * 2-3. �������� ���� �ٸ� 2�� �̰�, ������� 1�� �̴� ���. => ���� 0
    	 * 2-4. 0�� 3�� �̻��� ���, 0�� ���� �� �ִ� ����� ��. 
    	 * 
    	 */
    	
    	int answer = 0;
    	int answer1 = 0;
    	int answer2 = 0;


    	ArrayList<Integer> poNum = new ArrayList<Integer>();
    	ArrayList<Integer> neNum = new ArrayList<Integer>();
    	
    	for(int i = 0;  i < number.length; i++) {
    		if(number[i] >= 0) {
    			poNum.add(number[i]);
    		} else {
    			neNum.add(number[i]);
    		}
    	}
    	
    	int total = 0;
    	int zero = 0;
    	for(int i = 0; i < poNum.size(); i++) {
    		// ������� ���� 1�� �����Ѵ�.

    		if(poNum.get(i) == 0) {
    			zero ++;
    			// 0 �� ������ zero ī��Ʈ
    		}
    		
    		for(int j = 0; j < poNum.size(); j++) {
    			total = poNum.get(i);
//    			System.out.println("��� �ϳ� �̾����� : "+total);
    			// total ���� ��� 1���� ������ �����Ѵ�.
    			// �ݺ����̴�, j���� ���� ������ total ���� �ٽ� i������ �����
    			if(j != i) {
    				total += poNum.get(j);
//    				System.out.println("��� �� �� �̾����� : "+total);
    				// ���� �ε����� �ƴ� ����� ������
    				// total ���� �����ְ�
					for(int k = 0; k < neNum.size(); k++) {
						// �������� �ϳ� �����Ѵ�.
						if((total + neNum.get(k)) == 0) {
							// �� ��, total + ���� ���� 0�� �Ǹ�
							answer1 += 1;
							// ���ѻ� 1����
							System.out.println("poNum.get("+i+") : " +poNum.get(i));
							System.out.println("poNum.get("+j+") : " +poNum.get(j));
							System.out.println("neNum.get("+k+") : " +neNum.get(k));
						}
    				}
    			}
    		}
    	}
    	answer1 /= 2;
    	// i = 0, j = 1 �� ���� i = i, j = 0 �� ���� ���ٰ� ������.
    	// => ������ �ٸ�����, �Ҽӵ� �ο��� ������.
    	
    	//���� �İ� ���� ������� ����.
    	for(int i = 0; i < neNum.size(); i++) {
    		total = 0;
    		
    		for(int j = 0; j < neNum.size(); j++) {
    			total = neNum.get(i);
    			
    			if(j != i) {
    				total += neNum.get(j);
    				
    				for(int k = 0; k < poNum.size(); k++) {
    					
    					if((total + poNum.get(k)) == 0) {
    						
    						answer2 += 1;
    					}
    				}
    			}
    		}
    	}
    
    	answer2 /= 2;
    	
    	answer = answer1 + answer2;
    	
    	if(zero >= 3) {
    	answer += (zero * (zero-1) * (zero-2) / 6);
    	}
    	
        return answer;
    }
	
}

class ���ѻ�_�ٸ���� {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

/*
 * 
 * ������ Ǯ�� �������� ������� �׷���..
 * ���� ������ �����ؼ� �����ϰ� Ǯ�� ���ߴ� �� ����.
 *  
 * 
 */

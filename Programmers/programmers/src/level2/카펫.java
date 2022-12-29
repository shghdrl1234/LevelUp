package level2;

public class ī�� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * Leo�� ī���� �緯 ���ٰ� �Ʒ� �׸��� ���� �߾ӿ��� ��������� ĥ���� �ְ� 
		 * �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.
		 * 
		 * Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, 
		 * ��ü ī���� ũ��� ������� ���߽��ϴ�.
		 * 
		 * Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� 
		 * ī���� ����, ���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * ���� ������ �� brown�� 8 �̻� 5,000 ������ �ڿ����Դϴ�. 
		 * ����� ������ �� yellow�� 1 �̻� 2,000,000 ������ �ڿ����Դϴ�. 
		 * 
		 * ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.
		 * 
		 */
		solution(24,24);
	}
	
    public static int[] solution(int brown, int yellow) {
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * y�� + 2 => b��
    	 * y�� + 2 => b��
    	 * 
    	 * brown = b�� x b�� - (y�� - y��)
    	 * yellow = y�� x y��
    	 * 
    	 * brown = (yellow�� ����+2) x (yellow�� ����+2) - yellow
    	 * brown = 2(yellow�ǰ��� + yellow�Ǽ���) +4
    	 *
    	 * 
    	 * 
    	 * 
    	 */
    	
    	int[] answer = new int[2];	
    	
    	// b��
    	z :
    	for(int i = 3; i <= 2499; i++ ) {
    		
    		// b�� 
    		for(int j = 3; j <= (brown+yellow)/i; j++) {
    			System.out.println("���� : " + j + ", ���� : " + i);
    			
    			if(j > i ) {
    				break;
    			}
    			
    			if(brown == 2*(i+j)-4) {
    				answer[0] = i;
    				answer[1] = j;
    				break z;
    			}
    			
    		}
    	}
    	

        return answer;
    }
}

class ī��_�ٸ���� {
    public int[] solution(int brown, int yellow) {
        int a = (brown+4)/2;
        int b = yellow+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
        // ���ǰ��� �̿�
    }
}

/*
 * ���� ������� ��� ���� ����ϰ� Ǯ����.
 * ���ο� ���θ� ��� ǥ���� ��, �� ������ �ּҰ��� �������� �����ϸ�
 * ���� Ǯ����. 
 *
 */

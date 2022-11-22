package level1;

public class ����ǰ����͵��� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �� ���� left�� right�� �Ű������� �־����ϴ�. 
		 * left���� right������ ��� ���� �߿���, ����� ������ ¦���� ���� ���ϰ�, 
		 * ����� ������ Ȧ���� ���� �� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ���
		 * 1 �� left �� right �� 1,000
		 * 
		 */
		System.out.println(solution(24,27));
	}
	
	public static int solution(int left, int right) {
		/*
		 * ���� ���� Ǫ�� ���
		 * 1. �迭�� �ݺ������� ������ Ǯ���. 
		 * 2. right - left +1 = �迭�� ���� 
		 * 3. ����� ������ ¦�� :
		 * 4. ����� ������ Ȧ�� :
		 *
		 * 2-1. �ݺ����� ���Ͽ� ����� ������ ������
		 */
		
		int[] value = new int[right-left+1];
		int[] numsOf��� = new int[right-left+1];
		
		for(int i = 0; i < right-left+1; i++) {
			// �Ű������� �Ѿ�� ������ ���� ���� ��ȸ�ϴ� �ݺ���
			value[i] = left + i;
			
			for(int j = 1; j <= left+i; j++) {
				
				if((left+i)%(j) == 0) {
						numsOf���[i] += 1;
				}
			}
		}

		int answer = 0;
		int i = 0;
		
		for(int k : numsOf���) {
			
			if(k%2 == 0) {
				answer += value[i];
			} else {
				answer -= value[i];
			}
			i++;
		}
		
        return answer;
    }
}

	class ����ǰ����͵���_�ٸ���� {
	    public int solution(int left, int right) {
	        int answer = 0;
	        for(int i=left; i<=right; i++){
	            int cnt = 0;
	            for(int j=1; j<=i; j++){
	                if(i%j==0) cnt++;
	            }
	            if(cnt%2==0) answer += i;
	            else answer -= i;
	        }
	        return answer;
	    }
	}
/*
 * 
 * �ĵ� ����ѵ�, 
 * ���� �ڵ�� �迭�� Ȱ���Ͽ���, for�� ���� ������ �� �����ϰ� ���� ���Ͽ���.
 * 
 */
	
	
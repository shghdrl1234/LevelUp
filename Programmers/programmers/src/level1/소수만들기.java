package level1;

import java.util.HashSet;

public class �Ҽ������ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �־��� ���� �� 3���� ���� ������ �� �Ҽ��� �Ǵ� ����� ������ ���Ϸ��� �մϴ�.
		 * ���ڵ��� ����ִ� �迭 nums�� �Ű������� �־��� ��, nums�� �ִ� ���ڵ� �� 
		 * ���� �ٸ� 3���� ��� ������ �� �Ҽ��� �Ǵ� ����� ������ return �ϵ��� solution
		 * �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * nums�� ����ִ� ������ ������ 3�� �̻� 50�� �����Դϴ�. 
		 * nums�� �� ���Ҵ� 1 �̻� 1,000 ������ �ڿ����̸�, �ߺ��� ���ڰ� ������� �ʽ��ϴ�.
		 * 
		 */
		
		solution(new int[] {1,2,3,4});
	}
    public static int solution(int[] nums) {
        /*
         * ���� ���� Ǫ�� ���
         * 1. ���� 3���� �����Ͽ� ���Ѵ�.
         * 2. �Ҽ� �Ǻ��Ѵ�.
         * 3. �Ҽ��� ī��Ʈ
         * 
         * 4. ���⼭ ���ߴµ� ���ڰ� ���� => �Ҽ��Ǻ� ����. 
         */
    	HashSet<Integer> hs = new HashSet<Integer>();
    	
    	int count = 0; // ���� �Ҽ��� ī��Ʈ.
    	for(int i = 0; i < nums.length-2; i++) {
    		
    		for(int j = i+1; j < nums.length-1; j++) {
    			for(int k = j+1; k < nums.length; k++) {
    				int total = nums[i]+nums[j]+nums[k];
    					count += is_prime(total);
    			}
    		}
    	}
        return count;
    }
    
	public static int is_prime(int num) {
		if(num < 2) {
			return 0;
		}
		// 2�� �Ҽ���.
		if(num == 2) {
			return 1;
		}

		for(int i = 2; i < num; i++) {
			// �Ҽ��� �ƴҰ��
			if(num % i == 0) {
				return 0;
			}
		}
		
		return 1;
	}
}

/*
 * �Ҽ� �˰����� �������� �ʾҴٸ� ���� Ǯ �� ���� ������.
 * ������ �Ҽ� �˰����� �˰� �ִٸ�, ��Ÿ �ٸ� �������� �ξ� ���� Ǯ �� �ִ�.
 */ 

package level1;

public class �����ѱݾװ���ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���� ���� ���̱ⱸ�� �αⰡ �ſ� ���� ���� ������ �ʽ��ϴ�. 
		 * �� ���̱ⱸ�� ���� �̿��� price�� �ε�, 
		 * ���̱ⱸ�� N �� ° �̿��Ѵٸ� ���� �̿���� N�踦 �ޱ�� �Ͽ����ϴ�. 
		 * 
		 * ��, ó�� �̿�ᰡ 100�̾��ٸ� 2��°���� 200, 
		 * 3��°���� 300���� ����� �λ�˴ϴ�. 
		 * ���̱ⱸ�� count�� Ÿ�� �Ǹ� ���� �ڽ��� ������ �ִ� �ݾ׿��� 
		 * �󸶰� ���ڶ������ return �ϵ��� solution �Լ��� �ϼ��ϼ���. 
		 * ��, �ݾ��� �������� ������ 0�� return �ϼ���.
		 * 
		 * ���ѻ��� 
		 * ���̱ⱸ�� �̿�� price : 1 �� price �� 2,500, price�� �ڿ��� 
		 * ó�� ������ �ִ� �ݾ� money : 1 �� money �� 1,000,000,000, money�� �ڿ��� 
		 * ���̱ⱸ�� �̿� Ƚ�� count : 1 �� count �� 2,500, count�� �ڿ���
		 */

	}

    public long solution(int price, int money, int count) {
        /*
         * ���� ���� Ǫ�� ���
         * 1. n��° �̿��� => n * price
         * 2. count�� �̿� �ݾ� =>  count = price * (1+2+...+count)  
         * 3. �� ������ �� money, => money - count���� ����, ��� �Ǵ��Ͽ� ����
         * 
         */

    	long myMoney = money;
    	
    	long countOfPrice = 0;

    	long answer = 0;
    	
    	for(int i = 1; i<=count; i++) {
    		countOfPrice += i*price;
    	}
    	
    	if(myMoney - countOfPrice < 0) {
    		answer = Math.abs(myMoney - countOfPrice);
    	}
    
        return answer;
    }

}


	class �����ѱݾװ���ϱ�_�ٸ���� {
	    public long solution(long price, long money, long count) {
	        return Math.max(price * (count * (count + 1) / 2) - money, 0);
	        // �� ���� ���������� ������ ������ ǰ.
	        // Math.max ��??
	    }
	}
	
	/*
	 * 1�������� 20���� �̻��� Ǯ��� ������� ���̿ͼ� ���� Ǯ���� �� ����.
	 * �ٸ� �е��� �ڵ带 �����ؼ� ������ ���̳�, �ٸ� ��ĵ��� �����غ���. 
	 *
	 * 
	 */
	
	
package level1;

public class A��ǰ_������������ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �ڿ��� n�� �Ű������� �־����ϴ�. 
		 * n�� 3���� �󿡼� �յڷ� ������ ��, 
		 * �̸� �ٽ� 10�������� ǥ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * n�� 1 �̻� 100,000,000 ������ �ڿ����Դϴ�.
		 */
		
		solution(99999998);
	}

    public static int solution(int n) {
    	
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 1. n�� num�� ����, num�� 3���� ������ ��
    	 * 1-1. 1���� ������ => �� ���� total ���� ����
    	 *   
    	 * 1-2. 1���� ũ�� => num%3�� �����Ͽ� �������� total���� ����.(10�� cnt���� ������)
    	 * 1-3. num/3�� ���� num���� ����. cnt++
    	 * 1-3-1. num�� ���� 3���� ������, total ���� ���� (���� �Ʒ��κ�)
    	 * 
    	 * 2. �迭�� �ݺ����� �̿��Ͽ� �� �ڸ� ������.
    	 * 3. �ٽ� �ݺ����� ����Ͽ� 10������ ���� �����.
    	 * 
    	 */
    	long total =0;
    	int num = n;
    	int cnt = 0;
    	
    	if(num/3 < 1) {
    		// num�� 3���� �۴�, �׷��Ƿ� �������� ���Եȴ�.
    		total += num;
    	}
    	
    	while(num/3 >= 1) {
    		// num�� 1���� ũ�ų� ����, �׷��Ƿ� "��"�� "������"�� ���ÿ� �߻��ȴ�.
    		if(num%3 < 3) {
    			// ���� ���� �����, �������� ���� ���ؼ� total���� �����Ѵ�. �������� 3���� Ŭ �� ����.
    			total += Math.pow(10, cnt)*(num%3);
    			// ������ ���� �ݺ��� Ƚ���� ����Ͽ� �ڸ��� ������ �ȴ�.
    			
    			num /= 3; cnt++;
    			// ���� �ֱ⶧���� �ٽ� 3�� ���� �ش�. ��, while �ݺ����� ���ǿ� ���Ǵ� �����̴�.
    			// �׸��� ī��Ʈ�� �Ѵ�.
    			
    			if(num/3 <1) {
    				// �� ��ġ���� num/3�� 1���� ������ �ݺ����� ��ȸ�� �� ����.
    				// �� ������ ��� �ϳ��� �����ȴ�.
    				total += Math.pow(10, cnt)*(num);
    			}
    			
    		}
    		
    	}

    	
    	System.out.println("total : " + total + "(3)");
    	
    	// 222111212000121 => 121000212111222 �� �ٲ۴�.
    	// �迭�� Ȱ���� ���ΰ�?
    	
    	String totalStr = String.valueOf(total);
    	String[] arr = totalStr.split("");
    	
//    	String[] arr2 = arr;
    	String[] arr2 = new String[arr.length];
    	// �� �ڸ� ���� �迭�� �ε��� ������ ������.

//    	for(int i = 0; i < arr.length; i++) {
//    		arr2[i] = arr[arr.length-i-1];
//    		System.out.println("arr2["+i+"] : "+arr2[i]);
//    	}
    	
    	
    	 int answer = 0;
    	for(int j = 0; j < arr.length; j++ ) {
    		answer += Integer.valueOf(arr[j])*(Math.pow(3, j));
    		System.out.println("arr["+j+"] : "+arr[j]);
    	}
    		System.out.println("10���� �� : " + answer);
        return 134335209;
    }
}

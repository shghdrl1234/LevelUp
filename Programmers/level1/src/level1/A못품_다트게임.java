package level1;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;

public class A��ǰ_��Ʈ���� {

	public static void main(String[] args) {
		/*
		 * īī���� ���Ӻ��� �Ϲݱ� �ű� ���񽺷� ��Ʈ ������ ����ϱ�� �ߴ�. 
		 * ��Ʈ ������ ��Ʈ�ǿ� ��Ʈ�� �� ���� ���� �� ������ �հ�� �Ƿ��� �ܷ�� ��������, ��ΰ� ������ ��� �� �ִ�. 
		 * �� �Ի��� ������ �ڵ� �Ƿ��� �����޾� ������ �ٽ� �κ��� ���� ��� ������ �ð� �Ǿ���.
		 * ��Ʈ ������ ���� ��� ������ �Ʒ��� ����.
		 * 
		 * ��Ʈ ������ �� 3���� ��ȸ�� �����ȴ�. 
		 * 
		 * �� ��ȸ���� ���� �� �ִ� ������ 0������ 10�������̴�. 
		 * 
		 * ������ �Բ� Single(S),Double(D), Triple(T) ������ �����ϰ�
		 * �� ���� ��÷ �� �������� 1����, 2����, 3���� (����1 , ����2 , ����3)���� ���ȴ�. 
		 * 
		 * �ɼ����� ��Ÿ��(*), ������(#)�� �����ϸ� 
		 * ��Ÿ��(*) ��÷ �� �ش� ������ �ٷ� ���� ���� ������ �� 2��� �����. 
		 * ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�. 
		 * 
		 * ��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�. 
		 * �� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. (���� 4�� ����) 
		 * 
		 * ��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ���� ��ø�� �� �ִ�. 
		 * �� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����) 
		 * 
		 * ��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ������(#)�� ������
		 * -2�谡 �ȴ�. (���� 5�� ����) 
		 * 
		 * Single(S), Double(D), Triple(T)�� �������� �ϳ��� �����Ѵ�. 
		 * 
		 * ��Ÿ��(*),������(#)�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� �ִ�. 
		 * 0~10�� ������ ���� S, D, T, *, #�� ������ ���ڿ��� �Էµ� �� �������� ��ȯ�ϴ� �Լ��� �ۼ��϶�.
		 * 
		 * �Է� ���� 
		 * "����|���ʽ�|[�ɼ�]"���� �̷���� ���ڿ� 3��Ʈ. ��) 1S2D*3T
		 * 
		 * ������ 0���� 10 ������ �����̴�.
		 * 
		 * ���ʽ��� S, D, T �� �ϳ��̴�. �ɼ��� *�̳� # �� �ϳ��̸�, ���� ���� �ִ�. 
		 * 
		 * ��� ����
		 * 3���� ��ȸ���� ���� ���� �հ迡 �ش��ϴ� �������� ����Ѵ�. ��) 37
		 * 
		 */

		solution("1S2D*3T");
		
	}
    
	public static int solution(String dartResult) {
		
		/*
		 * ���� ���� Ǫ�� ���
		 * 
		 * 1.�����ڸ� �������� �� �ձ��� ����Ʈ�� ����, ������ �ǵ� ��, ����Ʈ ���� ������.
		 * ���� ���� ���� �ľ��ؼ� *�Ǵ� #�̸� �׸�ŭ �� ������ �߰���.
		 * �� ��, ����Ʈ�� ù��°��, *�� ȿ���� ȥ�� �޴´�.
		 * 
		 * 2. ���� ���ڿ��� �Һ�� ���ڿ� ��ŭ �ڸ���.
		 * 
		 * 3. ��������? ���ڿ� ���̰� 0�� �� ������.
		 * 
		 * 4. ���� ����Ʈ ���� �� ���Ѵ�.
		 * 
		 */
        int answer = 0;
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String dart = dartResult;
        
        int zero = 0;
        	for(int i = 0; i < dart.length(); i++) {
//        		System.out.println("���� i���� �ڸ� ���� : "+ dart.substring(zero, i));
        	
        		if(isStr(""+(dart.charAt(i)))) {
        		
        			arr.add(Integer.valueOf(dart.substring(zero, i)));
//        			System.out.println("���ĺ�");
        			switch(dart.charAt(i)) {
        			
        			case 'D': arr.set(arr.size()-1,(int)Math.pow((arr.get(arr.size()-1)),(2))); 
        			case 'T': arr.set(arr.size()-1,(int)Math.pow((arr.get(arr.size()-1)),(3)));
	        		
        			}
	        	
        		}
        		
        		if(isSc(""+dart.charAt(i)) && arr.size() == 1) {
        			switch(dart.charAt(i)) {
        			case '*': arr.set(arr.size()-1,(arr.get(arr.size()-1))*2); 
        			case '#': arr.set(arr.size()-1,-(arr.get(arr.size()-1))); 
        			}
        			
        		} else if(isSc(""+dart.charAt(i))){
        			switch(dart.charAt(i)) {
        			case '*': arr.set(arr.size()-2,(arr.get(arr.size()-2))*2); arr.set(arr.size()-1,(arr.size()-1)*2); 
        			case '#': arr.set(arr.size()-1,-(arr.get(arr.size()-1))); 
        			}
        		}
	        	
        		if(i != 0) {
        			zero += 1;
        		}
        		
//        		System.out.println("i = "+ i +", zero = " + zero);
        		System.out.println(arr);
        	}
        
        	
        	for(int i : arr) {
        		answer += i;
        	}
        
        	return answer;
        }
	
	public static boolean isStr(String str) {
		
		return str.matches("[A-Z]{1}");
	}
	
	public static boolean isSc(String str) {
		
		return str.matches("[*#]{1}");
	}
}

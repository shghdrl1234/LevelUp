package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A��ǰ_������ {

	public static void main(String[] args) {
		/*
		 * ���� ���� ������ �������� ū ��ο� ������. 
		 * �׳డ ���� ������ ��õ���� �뼺���� �ŵ�����, ���� �ű� ������� ���� �ް��� ���̴�.
		 * ������ �ű� ����ڿ� ���� ����� ���̿� �������� ���̰� �ʹ� ū ���� ��������.
		 * 
		 * �� ������ ��� �ұ� ��� �� �׳�� �������� ���� �ð��� �÷��� ���̵��� �����ϱ�� �ߴ�. 
		 * ���� ���� �����ڶ� ��κ��� ������ ����
		 * ����������, �������� ���ϴ� �κп��� ���⿡ ������ ���Ҵ�.
		 *  �������� ���� �������� ���ϴ� �ڵ带 �ϼ��϶�.
		 * 
		 * �������� ������ ���� �����Ѵ�. 
		 * ���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
		 * 
		 * ��ü ���������� ���� N, ������ �̿��ϴ� ����ڰ� ���� �����ִ� 
		 * ���������� ��ȣ�� ��� �迭 stages�� �Ű������� �־��� ��, 
		 * �������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� 
		 * �迭�� return �ϵ��� solution �Լ��� �ϼ��϶�.
		 * 
		 * ���ѻ��� 
		 * ���������� ���� N�� 1 �̻� 500 ������ �ڿ����̴�. 
		 * stages�� ���̴� 1 �̻� 200,000 �����̴�. 
		 * stages���� 1 �̻� N + 1 ������ �ڿ����� ����ִ�. 
		 * �� �ڿ����� ����ڰ� ���� ���� ���� ���������� ��ȣ�� ��Ÿ����. 
		 * ��, N + 1 �� ������ ��������(N ��° ��������) ���� Ŭ���� �� ����ڸ� ��Ÿ����. 
		 * ���� �������� ���� ���������� �ִٸ� ���� ��ȣ�� ���������� ���� ������ �ϸ� �ȴ�. 
		 * ���������� ������ ������ ���� ��� �ش� ���������� �������� 0 ���� �����Ѵ�.
		 * 
		 * 
		 */
		
		solution(5,new int[]{2,1,2,6,2,4,3,3});

	}
	
    public static double[] solution(int N, int[] stages) {
        /*
         * ���� ���� Ǫ�� ���
         * 
         * - a: ������ ��� 
         * - b: �������� ���� ���
         * - c: ��ü ��
         * 
         * 1. ��ȸ�� �� i�� statges�� ���Ҹ� ���ؼ�, i���� �۰ų� ���� ���� ������ ����. (�������� Ŭ���� ����) 
         * => ������ : c - i ������ ���� - b / a
         * 
         * 
         *
         */
    	double[] answer = new double[N];
    	
    	double challange = 0;
    	double ingOrClear = stages.length;

    	Map<Integer,Double> failure = new HashMap<Integer, Double>();
    	
    	for(int i = 1 ; i < N+1; i++) {
    		// 1~N �������� ���� ��ȸ
    		
    		for(int j = 0; j < stages.length; j++) {
    			// �� ��������(i) ���� ��ȸ�Ͽ� ������ ����� Ž��.
    			
    			if(i == stages[j]) {
    				challange += 1;
    				// ���� i ���������� �ӹ��� �ִٸ� ī��Ʈ.
    			}
    			
    		}
    		System.out.println(challange +", " + ingOrClear);
    		failure.put(i-1, (double) (challange/(ingOrClear)));
    		ingOrClear = ingOrClear-challange;
    		challange = 0;
    	}
    	System.out.println(failure);

    	List<Double> valueSet = new ArrayList<Double>(failure.values());
    	valueSet.sort(Double :: compareTo);
    	for(int i = 0; i < failure.size(); i++) {
    		answer[i] = valueSet.get(i);
    	}
    	System.out.println(Arrays.toString(answer));
        return  answer ;
    }

}

package level1;

import java.util.Arrays;

public class A��ǰ_�������ڴ½Ⱦ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �迭 arr�� �־����ϴ�. 
		 * �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�. 
		 * �̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�. 
		 * ��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�. 
		 * 
		 * ���� ���,
		 * arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�. 
		 * arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�. 
		 * �迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.
		 * 
		 * ���ѻ��� 
		 * �迭 arr�� ũ�� : 1,000,000 ������ �ڿ��� 
		 * �迭 arr�� ������ ũ�� : 0���� ũ�ų� ���� 9���� �۰ų� ���� ����
		 * 
		 */
		solution(new int[] {1,2,3,4,5,4,5,5,2});

	}
	
	public static int[] solution(int []arr) {
		
		/*
		 * ���� ���� Ǫ�� ���
		 * 
		 * 1. �ݺ����� ���Ͽ�, 
		 * 
		 */
		
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] == arr[i+1]) {
				arr[i+1] = arr[i];
			}			
		}
		
       int[] answer = arr;
        
        // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
        System.out.println(Arrays.toString(arr));

        return answer;
    }

}

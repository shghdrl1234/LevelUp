package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class �������ڴ½Ⱦ� {

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
		solution2(new int[] {2,1,2,1,1,2,3,4,5,4,5,5,2});

	}
	
	public static int[] solution(int []arr) {
		
		/*
		 * ���� ���� Ǫ�� ���
		 * 
		 * 1. StringBuilder ����ؼ� Ǯ��.
		 * (�ֳ��ϸ� ���� �����ؼ� �͵��߱� ����.)
		 */
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		System.out.println(sb.charAt(0));
		
		for(int i = 0; i < sb.length()-1; i++) {
			if(sb.charAt(i) == sb.charAt(i+1)) {
				sb.delete(i, i+1);
				i--;
			}
		}

		int[] answer = new int[sb.length()];
		
		for(int i = 0 ; i < sb.length(); i++) {
		 answer[i] = Integer.valueOf(String.valueOf(sb.charAt(i)));
		}
		
        return answer;
    }
	
	public static int[] solution2(int []arr) {
		
		Stack<Integer> st = new Stack();
		st.push(arr[0]);
		// �ݺ��� ������ peek() �޼��带 ������ֱ� ����.
		
		for(int i = 1; i < arr.length; i++) {
			if(st.peek() != arr[i]) {
				// ���� ���� ���� �ִ� �Ͱ� �ߺ� ���� �ʴ´ٸ� push.
				st.push(arr[i]);
			}
		}
		
		int[] answer = new int[st.size()];
		
		int j = 0;
		for(int i : st) {
			answer[j] = i;
			j++;
		}
		// ���� �������(push, pop ������� �ʰ�)
		// �迭�� ����
		

		return answer;
	}
}


	class Solution_�ٸ���� {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }
    /*
     *  �� �ڵ�� ���������� ���� ���������, arraylist�� �����.
     */
}
	
	/*
	* ��ü������ ����ϴ�.
	* ���� ó�� Ǭ ����� stringBuild�� ����ߴµ� ȿ�����鿡���� ���� ������ �޾Ҵ�.
	* 
	* ���� stack Ŭ������ ����Ͽ� Ǯ����.
	* 
	* �ٸ� �е鵵 stack Ŭ������ ����ϰų�, linkedList, arraylist�� ����Ͽ�
	* Ǯ����.	
	*/
	
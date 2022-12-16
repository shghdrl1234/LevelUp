package level1;

import java.util.Arrays;

public class ����������¼��ڹ迭 {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * array�� �� element �� divisor�� ������ �������� ���� 
		 * ������������ ������ �迭�� ��ȯ�ϴ� �Լ� solution�� �ۼ����ּ���. 
		 * divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ��� ��ȯ�ϼ���.
		 * 
		 * ���ѻ��� 
		 * arr�� �ڿ����� ���� �迭�Դϴ�. 
		 * ���� i, j�� ���� i �� j �̸� arr[i] �� arr[j] �Դϴ�. 
		 * divisor�� �ڿ����Դϴ�. 
		 * array�� ���� 1 �̻��� �迭�Դϴ�.
		 */
		int[] abc = {11,3,42,53,263,6,23,1};
		
		solution(abc,3);
	}
	  public static int[] solution(int[] arr, int divisor) {

		  // ���� �����ϴ� Ǯ��
		  
		  // 1. �� �ε��� ���� ������ �Ű������� ������.
		  // 2. �� ���߿� �������� ���� ����θ� ������ �迭�� �����Ѵ�.
		  // 3. �������� �����Ͽ� ��ȯ�ϱ�. => ���ڿ��� �ƴϴ� sort ���.
		  // 4. ��, �迭�� ������������ �ε��� ���� �ϳ��� ������ �ε����� -1�� ���� �迭 ��ȯ
		  
		  int j = 0;
		  String num = "";
		  for(int i = 0; i < arr.length; i++) {
			  
			  if(arr[i]%divisor == 0) {
				  j++;
				  num += arr[i] + "/";
			  }
		  }
		  
		  
		  if(j == 0) {
			  int[] answer = {-1};
			  return answer;
		  }

		  int[] answer = new int[j];
		  
		  String[] num2 = num.split("/");
		  
		  for(int i = 0; i < answer.length; i++) {
			  
			  answer[i] = Integer.valueOf(num2[i]);
		  }
		  
		  Arrays.sort(answer);
		  
		  System.out.println(answer.toString());
		  return answer;
	    }
}


class ����������¼��ڹ迭_�ٸ���� {
	  public int[] solution(int[] arr, int divisor) {
	          int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
	          if(answer.length == 0) answer = new int[] {-1};
	          Arrays.sort(answer);
	          return answer;
	  }
	}

// �ٸ� ���� ����� �ڵ�� �ۼ���.
// �� ������ ȿ������ �鿡���� for���� �� ���ٰ� �Ѵ�.
// �߰������� ���� Ǭ ����� String Ÿ�� �迭�� ����Ͽ��µ�,
// ��κ��� ������� int Ÿ�� �迭�� ���� �ִ� ����� ����Ͽ���.
// ���� 53�� �ڵ� for���� ���ǹ��� arr.length�� ����Ͽ� ���� answer�� ���� �־���.
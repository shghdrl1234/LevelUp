package level1;

import java.util.Arrays;

public class ü���� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. 
		 * ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. 
		 * 
		 * �л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳�
		 * �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. 
		 * ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. 
		 * ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.
		 * 
		 * ��ü �л��� �� n, 
		 * ü������ �������� �л����� ��ȣ�� ��� �迭 lost, 
		 * ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, 
		 * ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * ��ü �л��� ���� 2�� �̻� 30�� �����Դϴ�. 
		 * ü������ �������� �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
		 * ������ ü������ ������ �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�. 
		 * ���� ü������ �ִ� �л��� �ٸ� �л����� ü������ ������ �� �ֽ��ϴ�. 
		 * ���� ü������ ������ �л��� ü������ ���������� �� �ֽ��ϴ�. 
		 * �̶� �� �л��� ü������ �ϳ��� �������ߴٰ� �����ϸ�.
		 * ���� ü������ �ϳ��̱⿡ �ٸ� �л����Դ� ü������ ������ �� �����ϴ�.
		 * 
		 */
		int a  = 5;
		int[] b = {2,4};
		int[] c = {1,3,5};
		System.out.println();
		ü����_�ٸ���� bb = new ü����_�ٸ����();
		bb.solution(a, b, c);
		solution(a,b,c);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		/*
		 * ���� ���� Ǫ�� ���
		 * 0. n - lost.length
		 * 1. lost�� reserve�� ���ؼ� ���� ���� ������ n - length ���� �� ��ŭ �����ش�.
		 * 2. ���� ���� lost ���Ҵ� 0, reserve ���Ҵ� 99�� �ٲ۴�. (�ߺ� ����)
		 * 3. ���� ������� Ŭ��, ������ �����ش�.
		 * 
		 */
		
		int answer = n-lost.length;
		int[] lostStudent = lost.clone();
		int[] reserveStudent = reserve.clone();
				
		
        Arrays.sort(lostStudent);
        Arrays.sort(reserveStudent);
		
		for(int i = 0; i < reserveStudent.length; i++) {
			
			for(int j = 0; j < lostStudent.length; j++) {
				
				if(reserveStudent[i] == lostStudent[j] ) {
					answer += 1;
					reserveStudent[i] = 77;
					lostStudent[j] = 99;
					break;
				}
				
				if(reserveStudent[i]-1 == lostStudent[j]) {
					answer += 1;
					reserveStudent[i] = 77;
					lostStudent[j] = 99;
					break;
				}
				
				if(reserveStudent[i]+1 == lostStudent[j]) {
					answer += 1;
					reserveStudent[i] = 77;
					lostStudent[j] = 99;
					break;
				}
			}
			
		}

		System.out.println(answer);
		return answer;
	}
	/*
	 * Ǯ���� ��Ǯ���� �ٸ� �ڵ带 �����Ͽ���. ���� �� �ڵ��� ��Ȯ���� 88%�� ������.
	 * 
	 */
	

}

class ü����_�����ѻ�� {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // ���� ü������ ������ �л��� �������� ���
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        // �������� �л����� ü���� �����ִ� ���
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        return answer;
    }
}
/*
 * �� �ڵ�� ����غ��̴µ� �ٸ����� �ݺ��� ��ȸ�ϴ� ������ �� ����.
 * �� �ڵ带 �� �ڵ��� ����ó�� ��ȯ �Ƚ�Ű�� ���� ã�� ����� ������
 * 
 */
    
    

class ü����_�ٸ���� {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
        	System.out.println( "gd"+Arrays.toString(people));
            people[l-1]--;
        	System.out.println( "bd"+Arrays.toString(people));
        }
        
        for (int r : reserve) {
        	System.out.println( "gd"+Arrays.toString(people));
            people[r-1]++;
            System.out.println( "bd"+Arrays.toString(people));
        }

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}

/*
 * �� �ڵ�� ���� ���� ��õ�� ���� �ڵ��̴�.
 * ��� ������ ���� ������ �ڵ�� ����ѵ�..
 * �� �� �ڵ�� �۵��� �ȵǴ��� �ñ��ϴ�.
 *
 */


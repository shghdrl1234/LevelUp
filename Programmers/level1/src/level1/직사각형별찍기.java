package level1;

import java.util.Scanner;

public class ���簢������� {
	
	/*
	 * ���� ���� 
	 * �� �������� ǥ�� �Է����� �� ���� ���� n�� m�� �־����ϴ�. 
	 * ��(*) ���ڸ� �̿��� ������ ���̰� n, 
	 * ������ ���̰� m�� ���簢�� ���¸� ����غ�����.
	 * 
	 * ���� ���� 
	 * n�� m�� ���� 1000 ������ �ڿ����Դϴ�.
	 * 
	 */

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i = 0; i < b; i++) {
        	for(int j = 0; j < a; j++) {
        		System.out.print("*");
        	}
        	System.out.println("");
        }

	}		


}

class ���簢�������_�ٸ���� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a; i++){
            sb.append("*");
        }
        for(int i=0; i<b; i++){
            System.out.println(sb.toString());
        }
        // stringBuilder�� �����..
    }
}

/*
 * 2000���� �Ѵ� ������� ���� �ۼ��� �ڵ�� �����ϰ� �������.
 * 
 * ���� �̰� �����̶�� �Ҽ��� �ְ�����, �� ���� Ǯ�̹��� �����غ��߰ڴ�.
 * 
 */


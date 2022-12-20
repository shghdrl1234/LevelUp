package level2;

import java.util.Arrays;

public class A��ǰ_JadenCase���ڿ������ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * JadenCase�� ��� �ܾ��� ù ���ڰ� �빮���̰�, �� ���� ���ĺ��� �ҹ����� ���ڿ��Դϴ�. 
		 * ��, ù ���ڰ� ���ĺ��� �ƴ� ������ �̾����� ���ĺ��� �ҹ��ڷ� ���� �˴ϴ�. 
		 * (ù ��° ����� �� ����) ���ڿ� s�� �־����� ��, 
		 * s�� JadenCase�� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
		 * 
		 * ���� ���� 
		 * s�� ���� 1 �̻� 200 ������ ���ڿ��Դϴ�. 
		 * s�� ���ĺ��� ����, ���鹮��(" ")�� �̷���� �ֽ��ϴ�. 
		 * ���ڴ� �ܾ��� ù ���ڷθ� ���ɴϴ�. 
		 * ���ڷθ� �̷���� �ܾ�� �����ϴ�. 
		 * ���鹮�ڰ� �����ؼ� ���� �� �ֽ��ϴ�.
		 */
		
		String s = "3  2   1   a  dd s         ";
		String[] arr = s.split(" ");
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
		System.out.println("===============");
		System.out.println(solution(s));
	}
    public static String solution(String s) {
       /*
        * ���� ���� Ǫ�� ���
        * 1. split���� �迭 �����
        * 2. ������� �迭�� ��� ù ���ڰ� �ҹ����� ��� (char Ȱ��) => �빮�ڷ� ����
        * 3. split�迭�� �ٽ� ����.
        * 
        * -> �ܾ��߿� �빮��, �ҹ��ڰ� ���ΰ� �ִ�. �߰��� ������ �빮�ڴ� �ҹ��ڷ� �ٲ������
        */
    	String answer = "";
        
    	String[] arr = s.split(" ");
    	
    	for(int i = 0; i < arr.length; i++) {
    		
    		if(arr[i].length() > 1 && arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122 ) {
    			arr[i] = (char)(arr[i].charAt(0)-(char)32)+""+ arr[i].substring(1).toLowerCase();
    		}
    		
    		if(arr[i].length() == 1 && arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122 ) {
    			arr[i] = (char)(arr[i].charAt(0)-(char)32)+"";
    		}
    		
    	}
    	
    	for(int i = 0; i < arr.length; i++) {
    		
    		if(!arr[i].isBlank()) {
    			
    			if(i == arr.length-1) {
    				answer += arr[i];
    			} else {
    				answer += arr[i] + " ";
    			}
    			
    		} else {
    			answer += " ";
    		}
    		
    	}
    	
        return answer;
    }
	
}

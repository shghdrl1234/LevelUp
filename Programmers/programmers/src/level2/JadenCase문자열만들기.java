package level2;

import java.util.Arrays;
import java.util.LinkedList;

public class JadenCase���ڿ������ {

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
		
		
		
		String s = "abB23 C CCC CC1C aaC aCaa  1a a22c a   ";
		String[] arr = s.split("");
		System.out.println("�־��� s�� ���� : " + arr.length);
		System.out.println("===============");
		System.out.println(solution3(s));
	}
	
	public static String solution3(String s) {
	     /*
	        * ���� ���� Ǫ�� ���
			* 1. �־��� s�� ���鹮�ڸ� �������� LinkedList�� ��ȯ
			* => ����� �߰� ������ �� �ش� ��Ҹ� �����ϸ� �Ǿ� �۾��ð� ����.
			* => �־��� �迭���� �������� ���鸸 ���ӵǸ� �ڵ������� trim�� �Ǿ� �����ȴ�.
			* => �� ���ھ� �̾Ƽ�, i�� �ҹ����̰�, i-1�� �����̸� i�� �빮�ڷ� �ٲ۴�. (i = 1���� �ش�)
			* => (i = 0) �϶��� i�� �ҹ����̰�, i+1�� �����̸� �빮�ڷ� �ٲ۴�.
			* 
			* 2. �� LinkedList���� ù���ڰ� �ҹ����̸� �빮�ڷ� ����.
			* 
			* 3. ���� LinkedList�� �ϳ��� ����Ͽ� String���� ��ȯ
	        * 
	        */
		
			String answer = "";
		
			String[] arr = s.split("");
			
			LinkedList<String> ll = new LinkedList<String>();
			
			for(String sr : arr) {
				// linkedList�� arr�� ���� ���� �־��ش�.
				ll.add(sr);
			}
			
			// ù��° ��Ұ� �ҹ����̰�, ���� ��Ұ� �����̸� ù��° ��Ҵ� �빮�ڷ� �ٲ۴�.
			if(arr[0].charAt(0) >= 97 && arr[0].charAt(0) <= 122) {
				ll.set(0, (char)(arr[0].charAt(0)-(char)32)+"");
			}
			
			for(int i = 1; i < ll.size(); i++) {
				// ���� ��Ұ� �빮���̰�, ���� ���ڰ� �����̸�
				if(arr[i].charAt(0) >= 65 && arr[i].charAt(0) <= 90 && arr[i-1].equals(" ")) { 
					// �׳� ���α�
				}
				// ���� ��Ұ� �ҹ����̰�, ���� ��Ұ� �����̸�, ���� ��Ҹ� �빮�ڷ� �ٲ۴�.
				else if(arr[i].charAt(0) >= 97 && arr[i].charAt(0) <= 122 && arr[i-1].equals(" ")) {
					ll.set(i, (char)(arr[i].charAt(0)-(char)32)+"");
				} else {
					// �׷��� ������ �ҹ��ڷ� �ٲ۴�.
					ll.set(i, ll.get(i).toLowerCase());
				}
				
			}
			
			for(String str : ll) {
				answer += str;
			}
			
			System.out.println(answer.length());
			return answer;
		}
	
	
	public static String solution2(String s) {
       /*
        * ���� ���� Ǫ�� ���
		* 1. �־��� s�� ���鹮�ڸ� �������� LinkedList�� ��ȯ
		* => ����� �߰� ������ �� �ش� ��Ҹ� �����ϸ� �Ǿ� �۾��ð� ����.
		* 
		* 2. �� LinkedList���� ù���ڰ� �ҹ����̸� �빮�ڷ� ����.
		* 
		* 3. ���� LinkedList�� �ϳ��� ����Ͽ� String���� ��ȯ
        * 
        */
		String answer = "";
		
		String[] arr = s.split(" ");
		
		LinkedList<String> ll = new LinkedList<String>();
		
		for(String sr : arr) {
			// linkedList�� arr�� ���� ���� �־��ش�.
			ll.add(sr);
		}
		
		for(int i = 0; i < arr.length; i++) {
		
			// arr�� ���(�ش� ���ڿ�)�� ���̰� 2���� �̻��̰�, ù��° ���ڰ� �ҹ����� ��,
			if(arr[i].length() > 1 && arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122 ) {
				
				// LinkedList ��ü�� ���� �ٲ��ش� => �߰�, ������ ������.
				// ù ���ڴ� �빮�ڷ�, �������� �ҹ��ڷ� ����
				ll.set(i, (char)(arr[i].charAt(0)-(char)32)+""+ arr[i].substring(1).toLowerCase());
				
			}
			
			// arr�� ���(�ش� ���ڿ�)�� ���̰� 1�����̰�, �� ���ڰ� �ҹ����� ��,
			if(arr[i].length() == 1 && arr[i].charAt(0) >= 97 && arr[i].charAt(0) < 122 ) {
				
				// LinkedList ��ü�� ���� �ٲ��ش� => �߰�, ������ ������.
				// ù ���ڴ� �빮�ڷ�, �������� �ҹ��ڷ� ����
				ll.set(i,(char)(arr[i].charAt(0)-(char)32)+""); 
			}
		
    	}
    	
    	for(int i = 0; i < ll.size(); i++) {
    		
    		if(!ll.get(i).isBlank()) {
    			
    			if(i == ll.size()-1) {
    				answer += ll.get(i);
    			} else {
    				answer += ll.get(i) + " ";
    			}
    			
    		} else {
    			answer += " ";
    		}
    		
    	}
		System.out.println(answer.length());
		return answer;
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

class JadenCase���ڿ������_�ٸ���� {
	  public String solution(String s) {
	        String answer = "";
	        String[] sp = s.toLowerCase().split("");
	        boolean flag = true;

	        for(String ss : sp) {
	            answer += flag ? ss.toUpperCase() : ss;
	            flag = ss.equals(" ") ? true : false;
	        }

	        return answer;
	  }
	  // split ������ ��� �ҹ��ڷ� �ٲ� ����. ���� ��Ұ� �����̸� true��, �ƴϸ� false�� ������
	  // ������ Ȱ���Ͽ� �빮�ڸ� ����.
	}


class JadenCase���ڿ������_�ٸ����2 {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<sArr.length; i++){
            if(i==0) sArr[i] = sArr[i].toUpperCase();

            if(" ".equals(sArr[i])){
                if(!(i == sArr.length-1))
                    sArr[i+1] = sArr[i+1].toUpperCase();   
            }
            sb.append(sArr[i]);
        }

        answer = sb.toString();

        return answer;
    }

    // �� ���� ��Ʈ�����۸� Ȱ���Ͽ���.
}

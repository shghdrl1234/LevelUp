package level1;

public class �̻��ѹ��ڸ���� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���ڿ� s�� �� �� �̻��� �ܾ�� �����Ǿ� �ֽ��ϴ�. 
		 * �� �ܾ�� �ϳ� �̻��� ���鹮�ڷ� ���еǾ� �ֽ��ϴ�. 
		 * �� �ܾ��� ¦����° ���ĺ��� �빮�ڷ�, 
		 * Ȧ����° ���ĺ��� �ҹ��ڷ� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
		 * 
		 * ���� ���� 
		 * ���ڿ� ��ü�� ¦/Ȧ�� �ε����� �ƴ϶�, �ܾ�(������ ����)���� ¦/Ȧ�� �ε����� �Ǵ��ؾ��մϴ�. 
		 * ù ��° ���ڴ� 0��° �ε����� ���� ¦����° ���ĺ����� ó���ؾ� �մϴ�.
		 * 
		 */
		System.out.println(solution("   tRy hello   dd WORLD  sdf asdf abc cde "));

	}
	
    public static String solution(String s) {
    	
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 1. ���ڿ� ���� �ܾ�� ���̿��� ������ ���� => split Ȱ���Ͽ� �迭�� ����.
    	 * 2. �迭�� �� �ε��� ��(���ڿ�)���� ���ڿ��� ����, ���ڿ��� ������ Ȱ���Ͽ� �ݺ��� ���.
    	 * 
    	 * 2-1. ���ڿ� s �� �� �� �̻��� �ܾ�� �Ǿ��ִ�. => ���ø����� �ڸ���
    	 * 2-2. ���ڿ� ������ �� �ܾ�� �ϳ� �̻��� ���鹮�ڷ� ���еǾ��ִ�. => ���� ������ �����ض�.
    	 * 2-3. �ܾ��� ¦����° ���ڴ� �빮��, Ȧ��°�� �ҹ��ڷ� �������Ѵ�. => �ּ� �ҹ��ڷ� ����, ���� ������ ���� �빮�ڷ� ��ȯ.
    	 * 
    	 */
    	String answer = "";
    	String[] word = s.split(" ",-1);
    	// ���ڿ� " "�� �б������� �� �ܾ���� �迭�� �����.
    	for(int i = 0; i < word.length; i++) {
    		
    		word[i] = word[i].toLowerCase();
    		// ���� �ܾ���� ����� �迭 ����, �ҹ��ڸ� �����ش�. ���ʿ� �Ϻΰ� �빮�� �� ���� �ִ�.
    		System.out.println("============word " + i +  "��============");
    		
    		String[] wordStr = word[i].split("");
    		// �ܾ��� ���ڿ� �ϳ� �ϳ��� �ε����� �����.
    		
				for(int k = 0; k < wordStr.length; k+=2) {
					// �ܾ��� ���� �ϳ��ϳ� �ε����� �ľ��Ͽ� ¦�� �ε����� �빮�ڷ� �ٲ�.
					wordStr[k] = wordStr[k].toUpperCase();
					System.out.println("word["+i+"]�� �� : "+word[i]+", wordStr["+(k)+"]�� �� : " + wordStr[k]);
				}
				
				word[i] = "";
				for(int y = 0; y < wordStr.length; y++) {
					// �� �ε������� ���θ������ �ܾ ����.
						word[i] += wordStr[y];
				}

    	}
    	System.out.println("====================");

    	int num = 0;
    	while(word[num].equals("")) {
    		// ó������ ������ �ȳ����� �ܾ ã�´�.
    		num++;
    	}
    	
    	for(int i = num; i < word.length; i++ ) {
    		// ó���� ������ �ƴ� �ܾ���� ����.
    		if(i != word.length-1) {
    			answer += word[i] + " ";
    			System.out.println("word[" + i + "]�� �� : " + word[i]);
    		} else if(!word[i].equals("")){
    			answer += word[i];
    			System.out.println("word[" + i + "]�� �� : " + word[i]);
    		}
    	}
        return answer;
    }

}

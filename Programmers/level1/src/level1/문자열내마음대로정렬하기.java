package level1;

import java.util.ArrayList;
import java.util.Arrays;




public class ���ڿ���������������ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, 
		 * �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ��մϴ�. 
		 * 
		 * ���� ��� strings�� ["sun", "bed", "car"]�̰� 
		 * n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� "u", "e", "a"�� strings�� �����մϴ�.
		 * 
		 * ���� ����
		 * strings�� ���� 1 �̻�, 50������ �迭�Դϴ�. 
		 * strings�� ���Ҵ� �ҹ��� ���ĺ����� �̷���� �ֽ��ϴ�.
		 * strings�� ���Ҵ� ���� 1 �̻�, 100������ ���ڿ��Դϴ�. 
		 * ��� strings�� ������ ���̴� n���� Ů�ϴ�. 
		 * �ε��� 1�� ���ڰ� ���� ���ڿ��� ���� �� ���, ���������� �ռ� ���ڿ��� ���ʿ� ��ġ�մϴ�.
		 * 
		 */
		String[] a = {"absd", "fdfs", "ssdf", "goep", "zzmd", "abcd", "bbde", "cbde","jbde","tbde", "aaaa"}; 
		int b = 0;
		solution(a,b);
	}
    public static String[] solution(String[] strings, int n) {
    	/*
    	 *
    	 * ���� ���� Ǫ�� ���
    	 * 
    	 * 1. Strings �迭�� ���̸� ���� string ������ Ÿ�� �迭�� �ϳ� �����.
    	 * 
    	 * 2. �ݺ����� ���Ͽ� Strings �迭 ����� ���ڿ��� n��°�� �����Ͽ�. ������������ �����Ѵ�.
    	 * => �ҹ��� �ۿ� ������ sort ����ϰ�, n��° ���ڰ� a�϶� ~ z �϶��� ������ [0][x]~[25][x] �� ���� ����
    	 * => if(strings.[i].indexOf(3) ) ���÷� char Ÿ�� ���
    	 *   
    	 * 3. n��° ���� �������� ���������� ���ĵǾ���. ���� �迭������ ���������� �ٽ� �������� �������.
    	 * 
    	 *  
    	 * 4.  
    	 * 
    	 */
    	
    	
//    	String[][] str = new String[25][]; �ܼ��� �̷� �迭�� �ϸ� ���� �����ϱⰡ �����.
    	ArrayList<String>[] str2 = new ArrayList[26];
    	
    	for(int i = 0; i < 26; i++) {
    		str2[i] = new ArrayList();
    		// ������ �迭 ������ �ϴ� ArrayList ����
    		//str2[0] ~ str2[25] chd 26�� ����
    		
    	}

    	for(int i = 0; i < strings.length; i++) {
    		char x = strings[i].charAt(n);
			str2[x-97].add(strings[i]);
			
//			System.out.println(x + " index of :" + (x-97));
			
			// x-97 : char 97�� �ҹ��� ���ĺ� a��. x�� a�� ���� str2[0]�� ���� ��ҷ� ������� �����.
			// x�� b�� ���� str2[1]�� ���� ��ҷ� �����.
			// ��, a��� ���ڵ��� index 0��, b��� ���ڴ� index 1�� ... z�� 25�� �̴�.

			// �ϴ� �̷��� n��° ���ڿ� ���� ���������� ���ĵǾ���.
			// ���� str2�� ���� ��ŭ �� 1�� ��ҵ� �� ���� ����, �� ������ ������ �ʿ���.
    	}
    	
    	for(int i = 0; i < str2.length; i++) {
    		System.out.println("���� : str2["+i+"] :"+str2[i].toString());
    		// str2�� �� ����� ���� ��ҵ� ������, 
    		// 1��° ~ n��° �ε��� ���� ���Ѵ�.
    		String store = "";
    		
			for(int j = 0; j < str2[i].size()-1; j++) {
			
				for(int c = 0; c < str2[i].get(j).length(); c++) {
					System.out.println("c ���� ���� c : " + c);
					
					for(int h = 0; h < str2[i].get(j).length(); h++) {
					System.out.println("h ���� ���� h : " + h);
					
						if((str2[i].get(j)).charAt(h) > (str2[i].get(j+1).charAt(h))) {
							System.out.println("if ���� ����");
							// �� ��ҵ��� ù��° ���ڸ� ���Ͽ�, �ε����� ���� ���� ũ��(���ĺ��� ������)
							// ������ �ٲ۴�.
							store = str2[i].get(j);
							
							str2[i].set(j,str2[i].get(j+1));
							
							str2[i].set(j+1,store);
							System.out.println("store : " + c + store);
							System.out.println("str2["+i+"].get("+(j)+") : " + c + str2[i].get(j));
							System.out.println("str2["+i+"].get("+(j+1)+") : " + c + str2[i].get(j+1));
			    				
						}
					
					// ���� for���� 1��° ���� �� �� ����, 2��° ~ str2[i].size -1 ��° ���� �񱳸� �������.
    			// �׷��� ����� �� �� ���� for���� �� �� �� �ݺ����� ���� ���� ��ȸ ��������?
    			// 1. str[i] => i���� �������� ���������
    			// 2. str[i]get(j) => i���� �������ٸ�, j ���� ���������
    			// => ��� ������? ���� for������ �ߴٸ�..
    			// 3. j���� ���ϱ� ���ؼ� �־��� ���ڿ��� ���θ� ��ȸ�ϴ� ����� �ִ�.
    			// 4. str[i].get(j) => j���� ��ȸ�Ѵ�. ���? j�� ���� ���ڿ��� �ε����� �� �� �� ������.
    			// 5. �׷��� str2[i].get(j).chatAt(h)�̸�, i ��ȸ(h��ȸ(j��ȸ))�� ��Ÿ�����Ѵ�.
    			// 6. �� ������ h��ȸ�� ���� ���ʿ��� �ع�����, 1ȸ����, [0]�� �ε����� ���ĵ� �� 
    			// 2ȸ������ [1] �������� �ٽ� ���� �Ǳ� �����̴�.
    			}
				}
				System.out.println("str2["+i+"] :"+str2[i].toString());
    		}
    	}
    	
    	
        String[] answer = {};
        return answer;
    }
}

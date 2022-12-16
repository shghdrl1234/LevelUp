package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ���ڿ���������������ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, 
		 * �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ��մϴ�.
		 * 
		 * ���� ��� strings�� ["sun", "bed", "car"]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� "u", "e", "a"��
		 * strings�� �����մϴ�.
		 * 
		 * ���� ���� 
		 * strings�� ���� 1 �̻�, 50������ �迭�Դϴ�. 
		 * strings�� ���Ҵ� �ҹ��� ���ĺ����� �̷���� �ֽ��ϴ�.
		 * strings�� ���Ҵ� ���� 1 �̻�, 100������ ���ڿ��Դϴ�. 
		 * ��� strings�� ������ ���̴� n���� Ů�ϴ�. 
		 * �ε��� 1�� ���ڰ� ���� ���ڿ��� ���� �� ���, ���������� �ռ� ���ڿ��� ���ʿ� ��ġ�մϴ�.
		 * 
		 */
		String[] a = { "ba","acc","bbc","bb","ca","aab", "aa","bbr", "aac","ac","va","ka","bakka","bbd"};
		int b = 1;
		System.out.println(Arrays.toString(solution1(a, b)));
	}
	
	public static String[] solution1(String[] strings, int n) {
		/*
		 * ���� Ǫ�� ���.
		 * 
		 * 1. n��° �ε��� �������� ������ �� ���� ����.
		 * 
		 * 2. ���� n ��° �ε��� ����, ���� ���ڵ��� ������ ������ ����
		 * 
		 * 3. 2���� a~z���� �ݺ�
		 * 
		 * 
		 */
		
		ArrayList<String>[] str2 = new ArrayList[26];


		for (int i = 0; i < 26; i++) {
			str2[i] = new ArrayList();
			// ������ �迭 ������ �ϴ� ArrayList ����
			// str2[0] ~ str2[25] chd 26�� ����.

		}

		for (int i = 0; i < strings.length; i++) {
			char x = strings[i].charAt(n);
			str2[x - 97].add(strings[i]);
		}
		
		String[] arr = strings.clone();
		String store = "";
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr.length-1; j++) {
				
				if(arr[j].charAt(n) > arr[j+1].charAt(n)) {
					store = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = store;
				}
			}
			
		}
		
		System.out.println(n+"��° �ε��� �������� ������������ ���� : "+ Arrays.toString(arr));
		// ������ ������ ����
		
		
		int cnt = 0;
			
			for(int j = 0; j < arr.length-1; j++) {
					
					for(int k = 0; k < arr.length-1 ; k++) {
						if(arr[k].compareTo(arr[k+1]) > 0 && arr[k].charAt(n) == arr[k+1].charAt(n)) {
							store = arr[k];
							arr[k] = arr[k+1];
							arr[k+1] = store;
					}
						
				
					
				}
			
		}
		
		return arr;
	}

	public static String[] solution(String[] strings, int n) {
		/*
		 *
		 * ���� ���� Ǫ�� ���
		 * 
		 * 1. Strings �迭�� ���̸� ���� string ������ Ÿ�� �迭�� �ϳ� �����.
		 * 
		 * 2. �ݺ����� ���Ͽ� Strings �迭 ����� ���ڿ��� n��°�� �����Ͽ�. ������������ �����Ѵ�. => �ҹ��� �ۿ� ������ sort
		 * ����ϰ�, n��° ���ڰ� a�϶� ~ z �϶��� ������ [0][x]~[25][x] �� ���� ���� =>
		 * if(strings.[i].indexOf(3) ) ���÷� char Ÿ�� ���
		 * 
		 * 3. n��° ���� �������� ���������� ���ĵǾ���. ���� �迭������ ���������� �ٽ� �������� �������.
		 * 
		 * 
		 * 4.
		 * 
		 */

//    	String[][] str = new String[25][]; �ܼ��� �̷� �迭�� �ϸ� ���� �����ϱⰡ �����.
		ArrayList<String>[] str2 = new ArrayList[26];

		String[] answer = new String[strings.length];

		for (int i = 0; i < 26; i++) {
			str2[i] = new ArrayList();
			// ������ �迭 ������ �ϴ� ArrayList ����
			// str2[0] ~ str2[25] chd 26�� ����

		}

		for (int i = 0; i < strings.length; i++) {
			char x = strings[i].charAt(n);
			str2[x - 97].add(strings[i]);
			// n��° ���ĺ��� [0]�� ��ġ�� �� �ֵ���
			// �� n��

//			System.out.println(x + " index of :" + (x-97));

			// x-97 : char 97�� �ҹ��� ���ĺ� a��. x�� a�� ���� str2[0]�� ���� ��ҷ� ������� �����.
			// x�� b�� ���� str2[1]�� ���� ��ҷ� �����.
			// ��, a��� ���ڵ��� index 0��, b��� ���ڴ� index 1�� ... z�� 25�� �̴�.

			// �ϴ� �̷��� n��° ���ڿ� ���� ���������� ���ĵǾ���.
			// ���� str2�� ���� ��ŭ �� 1�� ��ҵ� �� ���� ����, �� ������ ������ �ʿ���.
		}
//		System.out.println(Arrays.toString(str2));

		for (int i = 0; i < str2.length; i++) {
			// str2�� �� ����� ���� ��ҵ� ������,
			// 1��° ~ n��° �ε��� ���� ���Ѵ�.
			String store = "";
			System.out.println("i = " + i + " �� �� ũ��� : " + str2[i].size());
			System.out.println("i = " + i + " �� ��, ��� : " + str2[i].toString());

			for (int k = 0; k < str2[i].size() - 1; k++) {

				for (int h = 1; h <= 101; h++) {
					// ����� ���� ���̸�ŭ ��ȸ

					for (int j = 1; j < str2[i].size(); j++) {
						// �� ��ҵ��� h��° ���ڸ� ���Ͽ�, �ε����� ���� ���� ũ��(���ĺ��� ������)
						// ������ �ٲ۴�.

						if(str2[i].get(j - 1).length() < h && j > 2) {
							// str[i]�� ��� ���̰� h���� �������
							if(str2[i].get(j-2).length() >= str2[i].get(j - 1).length() && str2[i].get(j - 1).substring(str2[i].get(j - 1).length()-1,str2[i].get(j - 1).length()).equals(str2[i].get(j -2).substring(str2[i].get(j - 1).length()-1,str2[i].get(j - 1).length())) ) {
								// ���� ����� h-1��° ���ڿ� ���ؼ� ���ٸ� �����ض�.
								store = str2[i].get(j - 2);

								str2[i].set(j - 2, str2[i].get(j-1));

								str2[i].set(j - 1, store);
							}
						
							
							
						}
						
						if (str2[i].get(j - 1).length() >= h && str2[i].get(j).length() >= h) {
							// str2[i]�� ��ҵ��� ���� ���̰� h���� Ŭ �� ����

							if (str2[i].get(j - 1).charAt(h - 1) > str2[i].get(j).charAt(h - 1)) {
								// str2[i]�� ��ҵ��� h-1 ��° char�� �������� �Ǿ��ִٸ� ����

								store = str2[i].get(j - 1);

								str2[i].set(j - 1, str2[i].get(j));

								str2[i].set(j, store);
								System.out.println(
										"k = " + k + ", h = " + h + ", j = " + (j) + "�� ��  : " + str2[i].toString());
								System.out.println("j = " + (j) + " �� �� store : " + store);
								System.out.println("j = " + (j) + " �� �� str2[i].get(j) : " + str2[i].get(j));
								System.out.println("j = " + (j) + " �� �� str2[i].get(j) : " + str2[i].get(+1));

							}
						}

//						System.out.println("str2["+1+"].get("+(0)+") : "  + str2[0].get(0));
//						System.out.println("str2["+1+"].get("+(1)+") : "  + str2[0].get(1));
//						System.out.println("str2["+1+"].get("+(2)+") : "  + str2[0].get(2));
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
			}
//				System.out.println("str2["+i+"] :"+str2[i].toString());
		}

		int t = 0;
		for (int i = 0; i < 26; i++) {

			for (int y = 0; y < str2[i].size(); y++) {

				answer[t] = str2[i].get(y);

				t++;
//    		 System.out.println(t+""+i+""+y);
			}

		}

		return answer;
	}

}	
	class ���ڿ���������������ϱ�_�ٸ���� {
	    public String[] solution(String[] strings, int n) {
	        String[] answer = {};
	        ArrayList<String> arr = new ArrayList<>();
	        for (int i = 0; i < strings.length; i++) {
	            arr.add("" + strings[i].charAt(n) + strings[i]);
	        }
	        Collections.sort(arr);
	        answer = new String[arr.size()];
	        for (int i = 0; i < arr.size(); i++) {
	            answer[i] = arr.get(i).substring(1, arr.get(i).length());
	        }
	        return answer;
	    }
	}
	// �� �ڵ�� n�� �� ������ ���ͼ� ������ �����Ͽ���.
	// ���� �� �ڵ庸�� �� �����ϰ� ���� �� �־��� ����.
	
	


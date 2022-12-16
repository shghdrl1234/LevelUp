package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 문자열내마음대로정렬하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 
		 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려합니다.
		 * 
		 * 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로
		 * strings를 정렬합니다.
		 * 
		 * 제한 조건 
		 * strings는 길이 1 이상, 50이하인 배열입니다. 
		 * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
		 * strings의 원소는 길이 1 이상, 100이하인 문자열입니다. 
		 * 모든 strings의 원소의 길이는 n보다 큽니다. 
		 * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
		 * 
		 */
		String[] a = { "ba","acc","bbc","bb","ca","aab", "aa","bbr", "aac","ac","va","ka","bakka","bbd"};
		int b = 1;
		System.out.println(Arrays.toString(solution1(a, b)));
	}
	
	public static String[] solution1(String[] strings, int n) {
		/*
		 * 문제 푸는 방법.
		 * 
		 * 1. n번째 인덱스 기준으로 오름차 순 정렬 진행.
		 * 
		 * 2. 이후 n 번째 인덱스 기준, 같은 문자들을 오름차 순으로 정렬
		 * 
		 * 3. 2번을 a~z까지 반복
		 * 
		 * 
		 */
		
		ArrayList<String>[] str2 = new ArrayList[26];


		for (int i = 0; i < 26; i++) {
			str2[i] = new ArrayList();
			// 이차원 배열 역할을 하는 ArrayList 생성
			// str2[0] ~ str2[25] chd 26개 생성.

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
		
		System.out.println(n+"번째 인덱스 기준으로 오름차순으로 정렬 : "+ Arrays.toString(arr));
		// 오름차 순으로 정렬
		
		
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
		 * 내가 문제 푸는 방법
		 * 
		 * 1. Strings 배열의 길이를 가진 string 이차원 타입 배열을 하나 만든다.
		 * 
		 * 2. 반복문을 통하여 Strings 배열 요소인 문자열의 n번째를 추출하여. 오름차순으로 정렬한다. => 소문자 밖에 없으니 sort
		 * 사용하고, n번째 문자가 a일때 ~ z 일때를 나눠서 [0][x]~[25][x] 로 각각 저장 =>
		 * if(strings.[i].indexOf(3) ) 예시로 char 타입 사용
		 * 
		 * 3. n번째 문자 기준으로 오름차순이 정렬되었다. 이차 배열에서도 사전순으로 다시 오름차순 진행시켜.
		 * 
		 * 
		 * 4.
		 * 
		 */

//    	String[][] str = new String[25][]; 단순히 이런 배열로 하면 길이 설정하기가 힘들다.
		ArrayList<String>[] str2 = new ArrayList[26];

		String[] answer = new String[strings.length];

		for (int i = 0; i < 26; i++) {
			str2[i] = new ArrayList();
			// 이차원 배열 역할을 하는 ArrayList 생성
			// str2[0] ~ str2[25] chd 26개 생성

		}

		for (int i = 0; i < strings.length; i++) {
			char x = strings[i].charAt(n);
			str2[x - 97].add(strings[i]);
			// n번째 알파벳이 [0]에 위치할 수 있도록
			// 즉 n이

//			System.out.println(x + " index of :" + (x-97));

			// x-97 : char 97은 소문자 알파벳 a임. x에 a가 들어가면 str2[0]의 하위 요소로 순서대로 저장됨.
			// x에 b가 들어가면 str2[1]의 하위 요소로 저장됨.
			// 즉, a라는 문자들은 index 0번, b라는 문자는 index 1번 ... z는 25번 이다.

			// 일단 이렇게 n번째 문자에 대해 오름차순이 정렬되었음.
			// 이후 str2의 길이 만큼 각 1차 요소들 간 사전 정리, 즉 오름차 정렬이 필요함.
		}
//		System.out.println(Arrays.toString(str2));

		for (int i = 0; i < str2.length; i++) {
			// str2의 각 요소의 하위 요소들 꺼내서,
			// 1번째 ~ n번째 인덱스 값을 비교한다.
			String store = "";
			System.out.println("i = " + i + " 일 때 크기는 : " + str2[i].size());
			System.out.println("i = " + i + " 일 때, 요소 : " + str2[i].toString());

			for (int k = 0; k < str2[i].size() - 1; k++) {

				for (int h = 1; h <= 101; h++) {
					// 요소의 글자 길이만큼 순회

					for (int j = 1; j < str2[i].size(); j++) {
						// 각 요소들의 h번째 문자를 비교하여, 인덱스가 낮은 쪽이 크면(알파벳이 높으면)
						// 순서를 바꾼다.

						if(str2[i].get(j - 1).length() < h && j > 2) {
							// str[i]의 요소 길이가 h보다 작을경우
							if(str2[i].get(j-2).length() >= str2[i].get(j - 1).length() && str2[i].get(j - 1).substring(str2[i].get(j - 1).length()-1,str2[i].get(j - 1).length()).equals(str2[i].get(j -2).substring(str2[i].get(j - 1).length()-1,str2[i].get(j - 1).length())) ) {
								// 이전 요소의 h-1번째 글자와 비교해서 같다면 진행해라.
								store = str2[i].get(j - 2);

								str2[i].set(j - 2, str2[i].get(j-1));

								str2[i].set(j - 1, store);
							}
						
							
							
						}
						
						if (str2[i].get(j - 1).length() >= h && str2[i].get(j).length() >= h) {
							// str2[i]의 요소들의 글자 길이가 h보다 클 때 진행

							if (str2[i].get(j - 1).charAt(h - 1) > str2[i].get(j).charAt(h - 1)) {
								// str2[i]의 요소들의 h-1 번째 char가 역순으로 되어있다면 진행

								store = str2[i].get(j - 1);

								str2[i].set(j - 1, str2[i].get(j));

								str2[i].set(j, store);
								System.out.println(
										"k = " + k + ", h = " + h + ", j = " + (j) + "일 때  : " + str2[i].toString());
								System.out.println("j = " + (j) + " 일 때 store : " + store);
								System.out.println("j = " + (j) + " 일 때 str2[i].get(j) : " + str2[i].get(j));
								System.out.println("j = " + (j) + " 일 때 str2[i].get(j) : " + str2[i].get(+1));

							}
						}

//						System.out.println("str2["+1+"].get("+(0)+") : "  + str2[0].get(0));
//						System.out.println("str2["+1+"].get("+(1)+") : "  + str2[0].get(1));
//						System.out.println("str2["+1+"].get("+(2)+") : "  + str2[0].get(2));
						// 위의 for문은 1번째 값을 비교 한 것임, 2번째 ~ str2[i].size -1 번째 까지 비교를 해줘야함.
						// 그래서 해줘야 할 게 위의 for문을 한 번 더 반복문을 통해 전부 순회 가능한지?
						// 1. str[i] => i값을 마지막에 돌아줘야함
						// 2. str[i]get(j) => i값이 정해졌다면, j 값을 비교해줘야함
						// => 어떻게 비교하지? 위의 for문으로 했다만..
						// 3. j값을 비교하기 위해선 주어진 문자열의 전부를 순회하는 방법이 있다.
						// 4. str[i].get(j) => j값을 순회한다. 어떻게? j의 값인 문자열의 인덱스로 한 번 더 나눈다.
						// 5. 그런데 str2[i].get(j).chatAt(h)이면, i 순회(h순회(j순회))로 나타내야한다.
						// 6. 그 이유는 h순회를 가장 안쪽에서 해버리면, 1회차때, [0]번 인덱스로 정렬된 후
						// 2회차때는 [1] 기준으로 다시 정렬 되기 때문이다.
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
	class 문자열내마음대로정렬하기_다른사람 {
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
	// 이 코드는 n을 맨 앞으로 빼와서 정렬을 진행하였다.
	// 내가 한 코드보다 더 간결하게 만들 수 있었던 이유.
	
	


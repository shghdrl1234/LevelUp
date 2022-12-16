package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 최소직사각형 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 
		 * 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 
		 * 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
		 * 
		 * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다. 
		 *
		 *번호 가로 세로
		 * 1 - 60 50 
		 * 2 - 30 70
		 * 3 - 60 30 
		 * 4 - 80 40
		 * 
		 * 
		 * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 
		 * 모든 명함들을 수납할 수 있습니다. 
		 * 
		 * 하지만 2번 명함을 가로로 눕혀 수납한다면 
		 * 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 
		 * 이때의 지갑 크기는 4000(=80 x 50)입니다.
		 * 
		 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 
		 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
		 *
		 * 
		 * 제한사항 
		 * sizes의 길이는 1 이상 10,000 이하입니다. 
		 * sizes의 원소는 [w, h] 형식입니다. w는 명함의 가로 길이를 나타냅니다. 
		 * h는 명함의 세로 길이를 나타냅니다. 
		 * w와 h는 1 이상 1,000 이하인 자연수입니다.
		 */
		int[][] aa = new int[2][2];
		aa[0][0] = 12;
		aa[0][1] = 42;
		aa[1][0] = 62;
		aa[1][1] = 2;
		System.out.println(solution1(aa));
		
	}
	
	public static int solution1(int[][] sizes) {
		System.out.println(sizes.length);
		System.out.println(sizes[0].length);
		/*
		 * 1. 가장 명함의 큰 가로 or 세로의 크기와
		 * 2. 그 명함을 제외한 명함 전체에서, 가로 or 세로 중 큰 값들을 각각 지운다.
		 * 3. 남아 있는 명함들의 한 쪽 길이 중에 가장 큰 값을 구한다.
		 */
		int[][] arr = sizes.clone();
		int large = 0;
		for(int i = 0 ; i < arr.length; i++) {
			
			for(int j = 0 ; j < arr[i].length; j++) {
				if(arr[i][j] > large) {
					large = arr[i][j];
				}
			}
		}
		
		for(int i = 0 ; i < arr.length; i++) {
				
				for(int j = 0 ; j < arr[i].length-1; j++) {
					if(arr[i][j] > arr[i][j+1]) {
						arr[i][j] = 0;
					} else {
						arr[i][j+1] = 0;
					}
				}
			}
		
		int large2 = 0;
		
		for(int i = 0 ; i < arr.length; i++) {
			
			for(int j = 0 ; j < arr[i].length; j++) {
				if(arr[i][j] > large2) {
					large2 = arr[i][j];
				}
			}
		}
		
		return large*large2;
	}



	public static int solution(int[][] sizes) {
		
		/*
		 * 내가 문제 푸는 방법
		 * 1. 가로(c),세로(r) 통틀어서 가장 큰 값(a)을 먼저 찾는다.
		 * 2. 그 후 다른 방향에서 그 다음 큰 값(b)을 찾는다.
		 * 
		 * ! a x b 의 지갑은 모든 명함 수납이 가능하다.
		 * 
		 * 3. c또는 r 중 하나에서 b의 값을 가진 인덱스의 r또는 c(반대 방향) 값을 확인한다. 
		 * 4. 그 값이 c또는 r에서 두번째 큰 b값보다 작으면,
		 *
		 * 
		 * 5. 2번을 반복한다.
		 * =================================================
		 * 1. 순서대로 큰 값 2개를 찾는다. => 순회 완료.
		 * 2. 그 값들 중에서 한 인덱스에서 가로, 세로가 가장 큰 값을 가지고 있으면 반환.
		 * 
		 * 
		 * 3. 인덱스 번호가 다르면 두 번 째 값의 다른 방향의 값이 3번째 보다 크거나 같으면 1x 3 반환
		 * 3. 그렇지 않으면 3번 째 큰 값의 반대 방향과 비교..   
		 * 
		 */
		int answer = 0;
		
		ArrayList<Integer>[] arr = new ArrayList[sizes.length];
		
		int standard = 0; // 가장 큰 값. // 하나가 아닐 수도
		int opposite = 0; // 그 다음에 큰 값. // 하나가 아닐 수도.
		int repeat = 0;

		int standard_i = 0;
		int standard_l = 0;
		int standard_s = 0;
		
		int opposite_i = 0;
		int opposite_l = 0;
		int opposite_s = 0;
		
		int repeat_i = 0;
		
		for(int i = 0; i < sizes.length; i++) {
			arr[i] = new ArrayList<Integer>();
			
			for(int j = 0; j < sizes[i].length; j++) {
				arr[i].add(sizes[i][j]);
				
				if(sizes[i][j] > standard) {
					// 가장 큰 값이 속해있으면
				
					standard = sizes[i][j];
					// 가장 큰 값은 변수에 저장
					
					standard_i = i;
					// 가장 큰 값이 포함된 인덱스의 번호도 저장

					if(sizes[i][0] <= sizes[i][j] || j == 0) {
						
						standard_l = j;
						standard_s = 1;
						
					} else if(sizes[i][0] <= sizes[i][j] || j == 1) {
						
						standard_l = j;
						standard_s = 0;
					}

				} else if(sizes[i][j] < standard && sizes[i][j] > opposite) {
					// 두번째 큰 값이 속해있으면
					
					opposite = sizes[i][j];
					// 두번째 큰 값은 변수에 저장
					
					opposite_i = i;
					// 두번째 큰 값이 포함된 인덱스의 번호도 저장
					
					if(sizes[i][0] <= sizes[i][j] || j == 0) {
						
						opposite_l = j;
						opposite_s = 1;
						// j의 값도 저장
					} else if(sizes[i][0] <= sizes[i][j] || j == 1) {
						
						opposite_l = j;
						opposite_s = 0;
					}
					
				}
			}
			
			
		}
		
		
		while(true) {
			
			if(arr[standard_i].get(0) == arr[standard_i].get(1)) {
				// 가장 큰 값의 가로 세로 길이가 같으면, 그 값의 곱을 반환
				return standard*standard;
				
			} else if(arr[standard_i].get(standard_s) >= arr[opposite_i].get(opposite_l)) {
				// 그렇지 않고, 반대 방향이 두번 째 값과 같거나 크면 반환
				return standard*arr[standard_i].get(standard_s);
				
			} else if(arr[opposite_i].get(opposite_l) == arr[opposite_i].get(opposite_s)) {
				return standard*opposite;
				
			} else {
				arr[opposite_i].set(opposite_l,0);
				opposite = 0;
				opposite_i = 0;
				opposite_l = 0;
				opposite_s = 0;
				
				for(int i = 0; i < sizes.length; i++) {
					for(int j = 0; j < sizes[i].length; j++) {
					// 이 반복문에서는 opposite 값을 다시 구해준다.
					// 이전 코드에서는 2번째 값으로 썼지만, 이제부터는 3번째, 4번째, n번째 값으로 쓴다.
						if(sizes[i][j] > opposite) {
							opposite = sizes[i][j];
							opposite_i = i;
							if(sizes[i][0] <= sizes[i][j] || j == 0) {
								opposite_l = j;
								opposite_s = 1;
							} else if(sizes[i][0] <= sizes[i][j] || j == 1) {
								opposite_l = j;
								opposite_s = 0;
							}
						}
					}
				}
				return standard*arr[opposite_i].get(standard_s); 
			}
		}
			
	}
}

	class 최소직사각형_다른사람 {
	    public int solution(int[][] sizes) {
	        int small = 0;
	        int large = 0;
	
	        for(int[] card : sizes){
	            if(card[0] < card[1]){
	                small = Math.max(small, card[0]);
	                large = Math.max(large, card[1]);
	                continue;
	            }
	            small = Math.max(small, card[1]);
	            large = Math.max(large, card[0]);
	
	        }
	
	        return small * large;
	    }
	}
	
	class 최소직사각형_다른사람2 {
	    public int solution(int[][] sizes) {
	        return Arrays.stream(sizes).reduce((a, b) -> new int[]{
	                Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
	        }).map(it -> it[0] * it[1]).get();
	    }
	}
	
	/*
	 * 내가 처음 풀 때는 어려웠는데 생각을 바꾸니 바로 풀렸다.
	 * 
	 * 다른 분들의 코드를 보면 Math.max, Math.min을 많이 활용 하였다.
	 * 
	 * 
	 */ 

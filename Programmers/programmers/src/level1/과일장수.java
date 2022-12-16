package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 과일장수 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 과일 장수가 사과 상자를 포장하고 있습니다. 
		 * 사과는 상태에 따라 1점부터 k점까지의 점수로 분류하며, k점이 최상품의 사과이고 1점이 최하품의 사과입니다. 
		 * 사과 한 상자의 가격은 다음과 같이 결정됩니다.
		 * 
		 * 한 상자에 사과를 m개씩 담아 포장합니다.
		 *  
		 * 상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다. 
		 * 
		 * 과일 장수가 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산하고자 합니다.
		 * (사과는 상자 단위로만 판매하며, 남는 사과는 버립니다)
		 * 
		 * 예를 들어, k = 3, m = 4, 사과 7개의 점수가 [1, 2, 3, 1, 2, 3, 1]이라면, 
		 * 다음과 같이 [2, 3, 2, 3]으로 구성된 사과 상자 1개를 만들어 판매하여 최대 이익을 얻을 수 있습니다.
		 * 
		 * (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) = 2 x 4 x 1 = 8 
		 * 
		 * 사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때, 
		 * 과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * 3 ≤ k ≤ 9 3 ≤ m ≤ 10 
		 * 7 ≤ score의 길이 ≤ 1,000,000 
		 * 1 ≤ score[i] ≤ k 
		 * 이익이 발생하지 않는 경우에는 0을 return 해주세요.
		 * 
		 * 
		 */
		
//		solution1(3,4,new int[] {1, 2, 3, 1, 2, 3, 1});
		solution1(4,3,new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
		
	}
	public static int solution1(int k, int m, int[] score) {
		/*
		 * 1. 박스안에 있는 최저 품질을 기준으로 잡자.
		 * 2. 최저 품질 먼저 다 담고 최고 품질을 넣는다.
		 * 
		 */
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i : score) {
			arr.add(i);
		}
		
		arr.sort(Comparator.reverseOrder());
		
		int answer = 0;
		int num = score.length;
		int box=9;
		
		for(int j = 0; j < score.length; j+=m) {
			System.out.println(m);
			if(num >= m ) {
				for(int i = 0; i < m; i++) {
					if(arr.get(score.length-num+i) < box) {
						box = arr.get(score.length-num+i);
					}
				}
				num -= m;
				answer += box*m;
				box=9;
				
			}
		}
		
		System.out.println(answer);
		return answer;
	}
	
		
    public static int solution(int k, int m, int[] score) {
    	/*
    	 * 내가 푸는 방법
    	 * 
    	 * - 최고점 k와 박스에 들어가는 개수 m을, score의 인덱스 값을 활용하여 문제를 푼다.
    	 * - 최고점 k와 일치하는 score[i]의 개수를 찾는다.
    	 * - 가장 높은 점수끼리 붙어있게 만들어야함.
    	 * - [4, 4, 4, 3] [3, 3, 3, 1] => 총합 4
    	 * - [4, 4, 4, 1] [3, 3, 3, 3] => 총합 4
    	 *
    	 * 1. 내림차순으로 정렬
    	 * 2. 0부터 score.length/까지, m++ 반복
    	 * 3. 0~3 인덱스 합이, K*4와 같다면 k, 작거나 (k-1)과 같다면 k-1 .. answer에 더함.
    	 * 3-1. 주어진 k 값을 모르기 때문에 조건문도 반복문으로 지정해줘야함
    	 * 3-2. switch - case 문을 일단 사용해보자
    	 * 4. 그 중에 가장 작은 값의 크기를 answer에 더함.
    	 * 
    	 */
    	
    	int[] arr = score.clone();
    	Arrays.sort(arr); // 오름차순으로 정렬
    	int answer = 0;
    	
    	for(int i = arr.length-1; i >= 0;) {
    		
    		if(i>2) {
    		
    			for(int j = i; j > i-4; j--) {
    			
    			if(arr[j-m+1] < arr[j-m+2] ) {
    				answer += arr[j-m+1]*4;
    			}
    		}
    		
    		}
    		
    		System.out.println("i = "+ i+", answer = " + answer);
		
    		
    		i -= m;
    	}
    	
        return answer;
    }

}


class 과일장수_다른사람 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }
    /*
     * for문에서 모든 작업을 한 번에 진행시켜서 코드를 최소화 시켰다.
     */
}




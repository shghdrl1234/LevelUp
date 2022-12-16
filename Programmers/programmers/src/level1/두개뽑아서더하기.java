package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두개뽑아서더하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 정수 배열 numbers가 주어집니다.
		 * numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 
		 * 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * numbers의 길이는 2 이상 100 이하입니다. 
		 * numbers의 모든 수는 0 이상 100 이하입니다.
		 * 
		 * 
		 */

		solution(new int[] {0,1,2,3,4,5,6,7,8});
	}

    public static int[] solution(int[] numbers) {
    	
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더하는 것
    	 * => 인덱스는 다르지만 같은 정수가 있을 수 있다.
    	 * => 즉, 합으로 중복된 값이 나올 수 있다.
    	 * => 중복을 없애 줘야함.
    	 * 
    	 * 2. 배열에 차곡차곡 넣어야함.
    	 * => 합이 어떻게 나올 지 모르니까 ArrayList 활용 
    	 * 
    	 * 3. 오름차순 정렬 => sort 활용
    	 * 
    	 * 
    	 * 1-2. 중복을 없애는게 관건.
    	 * => 반복문을 통해 비교해서 있으면 넣고 없으면 넣지 않는다.
    	 */
  
        
        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        
        
        for(int i = 0 ; i < numbers.length-1; i++) {
    			// i를 1개 선택함, numbers.leght-1을 한 이유는 i다음 값으로 j 값을 주기 위함.
        	
        	for(int j = i+1; j < numbers.length; j++) {
        		// j는 i 이후의 인덱스로 나오게 하자
        		
        		int k = 0;
        		while(k < arr.size() && (numbers[i] + numbers[j] != arr.get(k))) {
        		// 두 값의 합이 arr(k) 값이 아니면 k를 더해라
        			System.out.println("i = " + i + ", j = " +j +", k = " + k);
        			System.out.println("arr.size() = " + arr.size());
        			k++;
        			// 중요한 것은 반복문이 끝날때, k의 값은 arr.size()와 같아짐.
        		}
        		
        		if(k == arr.size()) {
        			//k가 일치하는 것이 없다면 k는 arr.size() 값이 되어버림
        			arr.add(k, numbers[i] + numbers[j]);
        		}
        	}
        }
        
        int[] answer = new int[arr.size()];
        System.out.println("gd");
        int i = 0;
        while(i < arr.size()) {
        	answer[i] = arr.get(i);
        	i++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
	
}

class 두개뽑아서더하기_다른사람 {
    public int[] solution(int[] numbers) {
       Set<Integer> set = new HashSet<>();

       for(int i=0; i<numbers.length; i++) {
           for(int j=i+1; j<numbers.length; j++) {
               set.add(numbers[i] + numbers[j]);
           }
       }

       return set.stream().sorted().mapToInt(Integer::intValue).toArray();
   }
}

/*
 * 
 * 대부분의 사람들이 hashSet 또는 treeSet을 사용하였다.
 * => 공부 요망.
 * 
 * 
 * /
 */
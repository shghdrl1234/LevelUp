package level1;

import java.util.Arrays;

public class K번째수 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
		 * 
		 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
		 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다. 
		 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다. 
		 * 2에서 나온 배열의 3번째 숫자는 5입니다. 
		 * 
		 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, c
		 * ommands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 
		 * return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한사항 
		 * array의 길이는 1 이상 100 이하입니다. 
		 * array의 각 원소는 1 이상 100 이하입니다. 
		 * commands의 길이는 1 이상 50 이하입니다. commands의 각 원소는 길이가 3입니다.
		 * 
		 */
		int[] a = {1, 5, 2, 6, 3, 7, 4};
		int[][] b = {{2,5,3},{4,4,1},{1,7,3}};
		solution(a,b);
	}
    public static int[] solution(int[] array, int[][] commands) {
        
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. array를 i부터 j까지 자른다.
    	 * 1-2. commands가 2차 배열이다. 반복문을 쓰려면 한 번에 진행해야함.
    	 * 
    	 * 2. sort 사용하여 오름차 순 진행
    	 * 3. 만들어진 배열에서 k 번째 추출
    	 * 
    	 */
    	
    	int[][] com = commands.clone();
    	int[] array_for = new int[array.length];
    	int[] answer = new int[com.length];
    	
    	int i =0;
    	int j =0;
    	int k =0;
    	
    	int cnt = 0;
    	while(cnt < com.length ) {
    		
    		i = com[cnt][0];
    		j = com[cnt][1];
    		k = com[cnt][2];
    		array_for = new int[j-i+1];
    		
    		System.out.println("========== cnt : " + cnt + " =============");
    		for(int t = i-1; t < j; t++ ) {
    			// 여기서 array를 잘라야함.
    			array_for[t-i+1] = array[t];
    			// 인덱스 번호 0부터 순차적으로 넣기.
    			System.out.println("array_for["+(t-i+1)+"] : " + array_for[t-i+1]);
    		}
    		Arrays.sort(array_for);
    		// 오름차 순으로 정렬
    		System.out.println(Arrays.toString(array_for));
    		
    		answer[cnt] = array_for[k-1];

    		System.out.println("array_for["+k+"] : " + array_for[k-1]);
    		
    		System.out.println("answer["+cnt+"] : " + answer[cnt]);
    		System.out.println();
    		
    		cnt++;
    	}
    	
    	
        return answer;
    }
}

class K번째수_다른사람 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}


/*
 * 내가 코드를 작성하면서 느낀것은
 * 작성하는 나 마저도 헷갈리면 안된다는 것이다.
 * 
 * 비록 지금은 코드가 길고 복잡하더라고, 주석을 더 세세하게 써야겠다.
 * 코드의 틀은 제대로 잡았는데 변수들을 대입하는 과정에서 오류가 나, 시간이 지체되었다.
 * int[] answer = new int[com.length]; 이 부분에서 com.lenght가 아닌 com[0].length를 사용함.
 * 일부는 정답처리가 되었지만.. 우연일 뿐, 전체적인 길이를 구하려면 com.legnth를 사용했어야 했다.
 * 
 * 그리고 라이브러리를 사용한 다른 분의 코드도 가져왔다.
 * 코드가 간결해지므로 가독성이 좋다. copyOfRange를 알아보자.
 * 
 * 물론 댓글들에서는 라이브러리도 좋지만 원초적인 구조를 작성하는 것도 큰 도움이 된다고 한다.
 * 
 * 얼른 두 가지 다 잡아보고 싶다.
 * 
 * 
 */



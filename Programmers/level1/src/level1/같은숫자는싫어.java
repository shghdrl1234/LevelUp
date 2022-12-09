package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 배열 arr가 주어집니다. 
		 * 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
		 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
		 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 
		 * 
		 * 예를 들면,
		 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다. 
		 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다. 
		 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
		 * 
		 * 제한사항 
		 * 배열 arr의 크기 : 1,000,000 이하의 자연수 
		 * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
		 * 
		 */
		solution2(new int[] {2,1,2,1,1,2,3,4,5,4,5,5,2});

	}
	
	public static int[] solution(int []arr) {
		
		/*
		 * 내가 문제 푸는 방법
		 * 
		 * 1. StringBuilder 사용해서 풀자.
		 * (왜냐하면 오늘 공부해서 터득했기 때문.)
		 */
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		System.out.println(sb.charAt(0));
		
		for(int i = 0; i < sb.length()-1; i++) {
			if(sb.charAt(i) == sb.charAt(i+1)) {
				sb.delete(i, i+1);
				i--;
			}
		}

		int[] answer = new int[sb.length()];
		
		for(int i = 0 ; i < sb.length(); i++) {
		 answer[i] = Integer.valueOf(String.valueOf(sb.charAt(i)));
		}
		
        return answer;
    }
	
	public static int[] solution2(int []arr) {
		
		Stack<Integer> st = new Stack();
		st.push(arr[0]);
		// 반복문 내에서 peek() 메서드를 사용해주기 위함.
		
		for(int i = 1; i < arr.length; i++) {
			if(st.peek() != arr[i]) {
				// 스택 가장 위에 있는 것과 중복 되지 않는다면 push.
				st.push(arr[i]);
			}
		}
		
		int[] answer = new int[st.size()];
		
		int j = 0;
		for(int i : st) {
			answer[j] = i;
			j++;
		}
		// 스택 순서대로(push, pop 사용하지 않고)
		// 배열에 저장
		

		return answer;
	}
}


	class Solution_다른사람 {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }
    /*
     *  이 코드는 전반적으로 나와 비슷하지만, arraylist를 사용함.
     */
}
	
	/*
	* 전체적으로 비슷하다.
	* 내가 처음 푼 방법은 stringBuild를 사용했는데 효율성면에서는 낮은 점수를 받았다.
	* 
	* 이후 stack 클래스를 사용하여 풀었다.
	* 
	* 다른 분들도 stack 클래스를 사용하거나, linkedList, arraylist를 사용하여
	* 풀었다.	
	*/
	
package level1;

import java.util.Arrays;

public class 체육복 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
		 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
		 * 
		 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나
		 * 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
		 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
		 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
		 * 
		 * 전체 학생의 수 n, 
		 * 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
		 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
		 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한사항 
		 * 전체 학생의 수는 2명 이상 30명 이하입니다. 
		 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
		 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다. 
		 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다. 
		 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
		 * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며.
		 * 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
		 * 
		 */
		int a  = 5;
		int[] b = {2,4};
		int[] c = {1,3,5};
		System.out.println();
		체육복_다른사람 bb = new 체육복_다른사람();
		bb.solution(a, b, c);
		solution(a,b,c);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		/*
		 * 내가 문제 푸는 방법
		 * 0. n - lost.length
		 * 1. lost와 reserve를 비교해서 같은 값이 있으면 n - length 값을 그 만큼 더해준다.
		 * 2. 이후 같은 lost 원소는 0, reserve 원소는 99로 바꾼다. (중복 방지)
		 * 3. 같은 방식으로 클때, 작을때 비교해준다.
		 * 
		 */
		
		int answer = n-lost.length;
		int[] lostStudent = lost.clone();
		int[] reserveStudent = reserve.clone();
				
		
        Arrays.sort(lostStudent);
        Arrays.sort(reserveStudent);
		
		for(int i = 0; i < reserveStudent.length; i++) {
			
			for(int j = 0; j < lostStudent.length; j++) {
				
				if(reserveStudent[i] == lostStudent[j] ) {
					answer += 1;
					reserveStudent[i] = 77;
					lostStudent[j] = 99;
					break;
				}
				
				if(reserveStudent[i]-1 == lostStudent[j]) {
					answer += 1;
					reserveStudent[i] = 77;
					lostStudent[j] = 99;
					break;
				}
				
				if(reserveStudent[i]+1 == lostStudent[j]) {
					answer += 1;
					reserveStudent[i] = 77;
					lostStudent[j] = 99;
					break;
				}
			}
			
		}

		System.out.println(answer);
		return answer;
	}
	/*
	 * 풀릴듯 안풀려서 다른 코드를 참고하였다. 현재 내 코드의 정확도는 88%로 추정됨.
	 * 
	 */
	

}

class 체육복_참고한사람 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        return answer;
    }
}
/*
 * 내 코드와 비슷해보이는데 다른점은 반복문 순회하는 순서인 것 같다.
 * 내 코드를 이 코드의 순서처럼 변환 안시키고 답을 찾는 방법은 없을까
 * 
 */
    
    

class 체육복_다른사람 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
        	System.out.println( "gd"+Arrays.toString(people));
            people[l-1]--;
        	System.out.println( "bd"+Arrays.toString(people));
        }
        
        for (int r : reserve) {
        	System.out.println( "gd"+Arrays.toString(people));
            people[r-1]++;
            System.out.println( "bd"+Arrays.toString(people));
        }

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}

/*
 * 이 코드는 가장 많은 추천을 받은 코드이다.
 * 결론 적으로 내가 생각한 코드와 비슷한데..
 * 왜 내 코드는 작동이 안되는지 궁금하다.
 *
 */


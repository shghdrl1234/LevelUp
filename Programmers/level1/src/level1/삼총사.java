package level1;

import java.util.ArrayList;

public class 삼총사 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다.
		 * 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다.
		 * 
		 * 예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때,
		 * 첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다.
		 * 
		 * 또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다. 
		 * 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.
		 * 
		 * 한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때, 
		 * 학생들 중 삼총사를 만들 수 있는 방법의 수를return 하도록 solution 함수를 완성하세요.
		 *
		 * 제한사항 
		 * 3 ≤ number의 길이 ≤ 13 
		 * -1,000 ≤ number의 각 원소 ≤ 1,000 
		 * 
		 * 서로 다른 학생의 정수 번호가 같을 수 있습니다.
		 */
		solution(new int[]{1,2,3,-2,-1,0,0});
	}

    public static int solution(int[] number) {
    	
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. 삼총사의 최대의 수가 아닌, 삼총사가 만들어 질 수 있는 방법의 수를 구하라.
    	 * => 한 시행에서 a라는 원소는 1번만 사용되어야함. 하지만 시행 횟수에 1번씩 무조건 들어가도 상관없음.
    	 * => 독립시행이라는 말?
    	 * 
    	 * 2. 세 명의 합이 0
    	 * 2-1. 0을 포함한 양수, 음수로 나눈다.
    	 * 2-2. 양수에서 서로 다른 2개 뽑고, 음수에서 1개 뽑는 경우. => 합이 0
    	 * 2-3. 음수에서 서로 다른 2개 뽑고, 양수에서 1개 뽑는 경우. => 합이 0
    	 * 2-4. 0이 3개 이상일 경우, 0만 뽑을 수 있는 경우의 수. 
    	 * 
    	 */
    	
    	int answer = 0;
    	int answer1 = 0;
    	int answer2 = 0;


    	ArrayList<Integer> poNum = new ArrayList<Integer>();
    	ArrayList<Integer> neNum = new ArrayList<Integer>();
    	
    	for(int i = 0;  i < number.length; i++) {
    		if(number[i] >= 0) {
    			poNum.add(number[i]);
    		} else {
    			neNum.add(number[i]);
    		}
    	}
    	
    	int total = 0;
    	int zero = 0;
    	for(int i = 0; i < poNum.size(); i++) {
    		// 양수에서 값을 1개 선택한다.

    		if(poNum.get(i) == 0) {
    			zero ++;
    			// 0 이 나오면 zero 카운트
    		}
    		
    		for(int j = 0; j < poNum.size(); j++) {
    			total = poNum.get(i);
//    			System.out.println("양수 하나 뽑았을때 : "+total);
    			// total 값에 양수 1개의 값으로 설정한다.
    			// 반복문이니, j값이 변할 때마다 total 값은 다시 i값으로 변경됨
    			if(j != i) {
    				total += poNum.get(j);
//    				System.out.println("양수 두 개 뽑았을때 : "+total);
    				// 같은 인덱스가 아닌 양수가 나오면
    				// total 값에 더해주고
					for(int k = 0; k < neNum.size(); k++) {
						// 음수에서 하나 선택한다.
						if((total + neNum.get(k)) == 0) {
							// 이 때, total + 음수 값이 0이 되면
							answer1 += 1;
							// 삼총사 1증가
							System.out.println("poNum.get("+i+") : " +poNum.get(i));
							System.out.println("poNum.get("+j+") : " +poNum.get(j));
							System.out.println("neNum.get("+k+") : " +neNum.get(k));
						}
    				}
    			}
    		}
    	}
    	answer1 /= 2;
    	// i = 0, j = 1 인 경우와 i = i, j = 0 인 경우는 같다고 봐야함.
    	// => 순서는 다를지라도, 소속된 인원이 같아짐.
    	
    	//위의 식과 같은 방법으로 진행.
    	for(int i = 0; i < neNum.size(); i++) {
    		total = 0;
    		
    		for(int j = 0; j < neNum.size(); j++) {
    			total = neNum.get(i);
    			
    			if(j != i) {
    				total += neNum.get(j);
    				
    				for(int k = 0; k < poNum.size(); k++) {
    					
    					if((total + poNum.get(k)) == 0) {
    						
    						answer2 += 1;
    					}
    				}
    			}
    		}
    	}
    
    	answer2 /= 2;
    	
    	answer = answer1 + answer2;
    	
    	if(zero >= 3) {
    	answer += (zero * (zero-1) * (zero-2) / 6);
    	}
    	
        return answer;
    }
	
}

class 삼총사_다른사람 {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

/*
 * 
 * 이전에 풀던 문제들이 어려워서 그런지..
 * 조금 생각을 많이해서 간단하게 풀지 못했던 것 같다.
 *  
 * 
 */

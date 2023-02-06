package level2;

public class 조이스틱 {

	public static void main(String[] args) {
		
		
		/*
		 * 문제 설명 
		 * 조이스틱으로 알파벳 이름을 완성하세요. 
		 * 맨 처음엔 A로만 이루어져 있습니다. 
		 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
		 * 
		 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
		 * 
		 * ▲ - 다음 알파벳 
		 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로) 
		 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
		 * ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서) 
		 * 
		 * 예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
		 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다. 
		 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다. 
		 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다. 
		 * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다. 
		 * 
		 * 만들고자 하는 이름 name이 매개변수로 주어질 때, 
		 * 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
		 * 
		 * 제한 사항 
		 * name은 알파벳 대문자로만 이루어져 있습니다. 
		 * name의 길이는 1 이상 20 이하입니다.
		 * 
		 */
		
		System.out.println('J' - 'A' + 'N' - 'A' +1);
		System.out.println('N' - 'Z');
		System.out.println('Z' - 'O');
		
	}
	public static int solution1(String name) {
	        int answer = 0;
	        int move = name.length() - 1; // 정방향으로 이동하였을 경우.
	        
	        /*
	         * 정방향으로 이동할 때의 반복문
	         */
	        for(int i = 0; i < name.length(); i++) {
	        	
	        	// 현재 위치(인덱스)가 요구하는 알파벳으로 바꾸기 위한 상하 조작.
	        	// 알파벳이 N보다 작으면, 앞의 파라미터가, N보다 크면 뒤의 파라미터가 최소값이 된다. 
	            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); //상,하 알파벳 맞추기.
	            
	            // 현재 인덱스가 마지막 인덱스보다 작고, 다음 위치의 알파벳이 A가 등장하면
	            // 다음 위치의 A부터 연속된 A의 개수를 찾아준다.
	            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
	                int endA = i + 1;
	                
	                // endA 인덱스가 마지막 인덱스보다 작고, endA 위치의 인덱스가 A를 가르키면 계속 반복.
	                while(endA < name.length() && name.charAt(endA) == 'A')
	                    // 반복문이 진행되면 다음 반복문 진행 여부를 위해 endA의 값에 1 추가.
	                	endA++;
	                
	                // 이 식은 순회하면서 계속 실행된다. 그리고 상위 for문은 상하 조작의 횟수만 기여하므로
	                // move에 대해서 상관 할 필요가 없다.
	                
	                // while문과 for문 순회중에는 고려안해도 되며, 
	                // while의 마지막 순회일 때 최종적인 move의 값만 구하면 된다. 
	                move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기.
	                move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기.
	            }
	        }
	        return answer + move;
	}
	
    public static int solution2(String name) {
        /*
         * 내가 문제 푸는 방법
         * 1. 모든 이름은 A부터 시작된다. 
         * => 요구되는 알파벳이 A일 경우 안움직여도 됨.
         * 
         * 2. Z다음은 A가 나온다. 즉, A 이전은 Z가 된다. 원형으로 생각해보자. 
         * => 모든 이름은 A부터 시작이다. N 이전의 알파벳은 A부터 순서대로, N 이후의 알파벳은 A부터 역순으로 이동하는 것이 빠르다.
         * => B~N 까지는 정방향, M~Z까지는 역방향, (N은 정방향, 역방향 상관없지만 헷갈리지 않도록 한 쪽에 넣음.)
         * 0A 1B 2C 3D 4E 5F 6G 7H 8I 9J 10K 11L 12M 13N 14O 15P 16Q 17R 18S 19T 20U 21V 22W 23X 24Y 25Z
         * 12O 11P 10Q 9R 8S 7T 6U 5V 4W 3X 2Y 1Z 0A 1B 2C 3D 4E 5F 6G 7H 8I 9J 10K 11L 12M // 13N
         *  
         * 3. 이름의 첫번째를 기준으로 요구되는 A의 거리를 비교해야함.
         * ex) BCCCCAACCA => B 다음에 오는 C가 있기 때문에 정방향이 유리함.
         * => 왜냐하면, 역방향으로 가게되면 결국엔 두번째 C까지 9번 이동해야함.
         * => 정방향으로 이동하면 마지막에 위치한 A로 인하여, 마지막 C 까지 8번만 이동하면됨.
         * ex) BACCCAACCA => 정방향의 끝과, 역방향의 끝이 A가 있으면 어느쪽으로 이동해도 유리하다.
         * ex) BAACCAACCA => 역방향이 유리하다 => 역뱡향의 끝부분에 A가 연속이됨. 
         * ex) BACCAACCA => 정방향, 역방향 똑같음.
         * 
         * 3의 결론 : 정방향이든, 역방향이든 끝부분까지 연속적인 A가 많을수록 그 방향이 유리함.
         * 1) name의 2번째가 A인지, name의 끝이 A인지 확인.
         * 2) 둘다 A이면, 그 다음 A가 나오는지 확인. => 나오지 않는 쪽의 반대방향으로 진행.
         * 
         * 첫번째 name의 위치를 기준으로 역방향, 정방향을 기준으로 끝부분에서 연속적인 A가 많은 방향으로 진행.
         * 이후, n번째 name으로 이동하면서, 요구되는 알파벳을 확인한다. A~N이면 정방향으로, M~Z면 역방향으로 진행.
         * 
         */
    	int answer = 0;
    	
    	int i = 1; // 정방향으로 증가
    	int j = name.length()-1; // 역방향으로 증가
    	
    	int forward = 0;
    	int reverse = 0; 
    	
    	while(i < name.length()) {
    		
    		// 역방향의 끝부분 부터 이어지는 A의 개수
    		if(name.charAt(i) == 'A') {
    			reverse++;
    		}

    		if(name.charAt(i) != 'A') {
    			break;
    		}
    	     i++;
    	}
    	
    	while(j > 1) {
    		
    		// 정방향의 끝부분 부터 이어지는 A의 개수
    		if(name.charAt(j) == 'A') {
    			forward++;
    		}
    		
    		if(name.charAt(j) != 'A') {
    			break;
    		}
    	     j--;
    	}
    	
    	// 정방향으로 이동(같은 경우는 어디로 가도 상관없음.) 
    	if(forward >= reverse) {
    		for(int k = 0; k < name.length()-forward; k++) {

//    			if(name.charAt(k) == 'A') {
//    				answer++; continue; 
//    			}
    			
    			// 요구되는 앞파벳이 N보다 작으면 위로(정방향으로 이동)
    			if(name.charAt(k) <= 'N') {
    				answer += name.charAt(k) - 'A';
    			} else {
    				answer += 'Z' - name.charAt(k) +1;
    			}
    			answer++;
    		}
    		
    	// 역방향으로 이동
    	} else {
    		// k가 문자열 마지막부터 반복되므로 처음 위치한 문자열에 대해 계산.
    		if(name.charAt(0) <= 'N') {
    			answer += name.charAt(0) - 'A';
    		} else {
				answer += 'Z' - name.charAt(0) +1;
			}
    		answer++;
    		
    		for(int k = name.length()-1; k >= reverse; k--) {
    			
//    			if(name.charAt(k) == 'A') {
//    				answer++; continue; 
//    			}
    			
    			// 요구되는 앞파벳이 N보다 작으면 위로(정방향으로 이동)
    			if(name.charAt(k) <= 'N') {
    				answer += name.charAt(k) - 'A';
    			} else {
    				answer += 'Z' - name.charAt(k) +1;
    			}
    			answer++;
    		}
    		
    	}
        return answer-1; // 마지막으로 문자열 때 옆으로 이동하는 코드가 계산됨. 빼줘야함
    }
}

/*
 * solution2가 내가 풀었던 코드이다. 59점으로 나왔다.
 * 내가 고려한 것은 주어진 문자열을 선택할 떄의 방향을 정방향 또는 역방향으로만 생각하여 풀었다.
 * 
 * 하지만 정방향에서 역방향으로, 역방향에서 정방향으로 이동하는 것도 고려하였어야 했다.
 * 
 * 복잡한 방법으로 구현하려 하였으나, 다른 사람의 코드를 참고하여 하나의 for문 내부에서 해결할 수 있다는 것을
 * 확인 하였다.
 * 
 */ 

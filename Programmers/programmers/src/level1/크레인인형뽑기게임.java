package level1;

import java.util.ArrayList;
import java.util.Stack;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		/*
		 * 게임 화면은 "1 x 1" 크기의 칸들로 이루어진 "N x N" 크기의 정사각 격자이며 
		 * 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다. 
		 * 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다. 
		 * 모든 인형은 "1 x 1" 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다. 
		 * 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 
		 * 집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다. 
		 * 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.
		 * 
		 * 
		 * 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다. 위 상태에서 이어서
		 * [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 두 개가 없어집니다.
		 * 
		 * 
		 * 크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는
		 * 아무런 일도 일어나지 않습니다.
		 * 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. 
		 * 
		 * 
		 * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴
		 * 배열 moves가 매개변수로 주어질 때, 크레인을 모두 작동시킨 후 터트려져 
		 * 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * [제한사항] 
		 * board 배열은 2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하입니다. 
		 * board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다. 0은 빈 칸을 나타냅니다. 
		 * 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다. 
		 * moves 배열의 크기는 1 이상 1,000 이하입니다. 
		 * moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
		 * 
		 */
		int[][] a = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] b = {1,5,3,5,1,2,1,4} ;
		solution(a,b);
	}

    public static int solution(int[][] board, int[] moves) {
  
    	/* 
    	 * 내가 문제 푸는 방법
    	 * 
    	 * -stack 구조로 활용.
    	 * 1. move의 원소 => board의 2차원 index를 나타냄.
    	 * 2. board의 배열을 순회하여 2차원 index 값이 0이 아닐때 까지 순회. 그 인덱스의 값은 0으로 변경.
    	 * 3. 만약 인덱스 값을 순회해서 0이 나오면 아무 변경 없음.
    	 * 4. 인덱스 값을 0으로 변경했다면, 바구니(int[]배열 또는 list)에 저장
    	 * 5. 연속해서 같은 값이 나오면 바구니에서 삭제, 점수 카운트.
    	 *  
    	 * 
    	 */
    	
    	ArrayList<Integer> basket = new ArrayList<Integer>();
    	
    	int answer = 0;
    	
    	int[][] boardArr = board.clone();

    	for(int i = 0; i < moves.length; i++) {
    		
    		for(int j = 0; j < boardArr.length; j++) {
	    		
    			if(boardArr[j][moves[i]-1] != 0) {
    				basket.add(boardArr[j][moves[i]-1]);
    				boardArr[j][moves[i]-1] = 0;
    				
    				for(int k = 0; k < basket.size(); k++) {
    					
    					if(basket.size() > 1 && (basket.get(basket.size()-1) == basket.get(basket.size()-2))) {
    						basket.remove(basket.size()-1);
    						basket.remove(basket.size()-1);
    						answer += 2;
    						break;
    					}
    					
    				}
    				break;
	    		}
    		}
    		
    	}
    	
        return answer;
    }
}

	class 크레인인형뽑기게임_다른사람 {
	    public int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer> stack = new Stack<>();
	        for (int move : moves) {
	            for (int j = 0; j < board.length; j++) {
	                if (board[j][move - 1] != 0) {
	                    if (stack.isEmpty()) {
	                        stack.push(board[j][move - 1]);
	                        board[j][move - 1] = 0;
	                        break;
	                    }
	                    if (board[j][move - 1] == stack.peek()) {
	                        stack.pop();
	                        answer += 2;
	                    } else
	                        stack.push(board[j][move - 1]);
	                    board[j][move - 1] = 0;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
	}

	
	/*
	 * 생각보다 쉬웠던 문제.
	 * 
	 * 문제를 어떻게 풀어나가야할까 생각만 잘하면
	 * 
	 * 코드 작성은 간단했다.
	 * 
	 * 다른분께서 풀었던 것과 유사했고,
	 * 
	 * 차이점은 순회 하는 방법과, 데이터 저장방식이었다.
	 * 
	 * 
	 * 
	 */
	
	
	
	
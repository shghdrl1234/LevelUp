package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class �ζ����ְ�������������� {

	public static void main(String[] args) {
		/*
		 * 
		 * �ζǸ� ������ �ο�� ��÷ ��ȣ ��ǥ���� �м�����ϰ� �־����ϴ�. 
		 * ������, �ο��� ������ �ζǿ� ������ �Ͽ�, �Ϻ� ��ȣ�� �˾ƺ� �� ���� �Ǿ����ϴ�. 
		 * ��÷ ��ȣ ��ǥ ��, �ο�� �ڽ��� �����ߴ� �ζǷ� ��÷�� �����ߴ� �ְ� ������ ���� ������ �˾ƺ��� �;� �����ϴ�. 
		 * �˾ƺ� �� ���� ��ȣ�� 0���� ǥ���ϱ�� �ϰ�, 
		 * �ο찡 ������ �ζ� ��ȣ 6���� 44, 1, 0, 0, 31 25��� �����غ��ڽ��ϴ�. 
		 * ��÷ ��ȣ 6���� 31, 10, 45, 1, 6, 19���, 
		 * ��÷ ������ �ְ� ������ ���� ������ �� ���� �Ʒ��� �����ϴ�.
		 * 
		 * ��÷ ��ȣ 31 10 45 1 6 19 ��� 
		 * �ְ� ���� ��ȣ 31 0��10 44 1 0��6 25 4�� ��ȣ ��ġ, 3�� 
		 * ���� ���� ��ȣ 31 0��11 44 1 0��7 25 2�� ��ȣ ��ġ, 5�� 
		 * 
		 * ������ �������, ������ �ζǿ� ��÷ ��ȣ�� ��ġ�ϴ� ��ȣ�� ������ ���� �ɷ� �����˴ϴ�. 
		 * �˾ƺ� �� ���� �� ���� ��ȣ�� ���� 10, 6�̶�� �����ϸ� 3� ��÷�� �� �ֽ��ϴ�. 
		 * 3���� ����� �ٸ� ����鵵 �����մϴ�. 
		 * 
		 * ������, 2�� �̻����� ����� ���� �Ұ����մϴ�. 
		 * �˾ƺ� �� ���� �� ���� ��ȣ�� ���� 11, 7�̶�� �����ϸ� 5� ��÷�� �� �ֽ��ϴ�. 
		 * 5���� ����� �ٸ� ����鵵 �����մϴ�. ������, 6��(��÷)���� ����� ���� �Ұ����մϴ�. 
		 * �ο찡 ������ �ζ� ��ȣ�� ���� �迭 lottos, ��÷ ��ȣ�� ���� �迭 win_nums�� �Ű������� �־����ϴ�. 
		 * �̶�, ��÷ ������ �ְ� ������ ���� ������ ���ʴ�� �迭�� ��Ƽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 *  ���ѻ���
		 *	lottos�� ���� 6�� ���� �迭�Դϴ�.
		 *	lottos�� ��� ���Ҵ� 0 �̻� 45 ������ �����Դϴ�.
	 	 *	0�� �˾ƺ� �� ���� ���ڸ� �ǹ��մϴ�.
	     *	0�� ������ �ٸ� ���ڵ��� lottos�� 2�� �̻� ������� �ʽ��ϴ�.
		 *	lottos�� ���ҵ��� ���ĵǾ� ���� ���� ���� �ֽ��ϴ�.
		 *	win_nums�� ���� 6�� ���� �迭�Դϴ�.
		 *	win_nums�� ��� ���Ҵ� 1 �̻� 45 ������ �����Դϴ�.
		 *	win_nums���� ���� ���ڰ� 2�� �̻� ������� �ʽ��ϴ�.
		 *	win_nums�� ���ҵ��� ���ĵǾ� ���� ���� ���� �ֽ��ϴ�.
		 */

	}
	
    public int[] solution(int[] lottos, int[] win_nums) {
        /*
         * ���� ���� Ǫ�� ���
         * 1. lottos�� win_nums �� ��ȸ�Ͽ� ��ġ�ϴ� �͵��� ���� �����Ѵ�.
         * 2. ���� ����� ���� => ����
         * 2. lottos�� 0�� ������ŭ �ø� ���� => �ִ�
         * 
         */
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	int[] answer = new int[2];
    	
    	for(int i = 0 ; i < lottos.length; i++) {
    		for(int j = 0; j < win_nums.length; j++) {
    			
    			if(lottos[i] == win_nums[j]) {
    				arr.add(lottos[i]);
    			}
    		}
    		
    	}
    	
    	switch(arr.size()) {
    	case 6 : answer[1] = 1; break;
    	case 5 : answer[1] = 2; break;
    	case 4 : answer[1] = 3; break;
    	case 3 : answer[1] = 4; break;
    	case 2 : answer[1] = 5; break;
    	default : answer[1] = 6; break;
    	}
    	
    	for (int i : lottos) {
    		if(i == 0) {
    			arr.add(i);
    		}
    	}
    	switch(arr.size()) {
    	case 6 : answer[0] = 1; break;
    	case 5 : answer[0] = 2; break;
    	case 4 : answer[0] = 3; break;
    	case 3 : answer[0] = 4; break;
    	case 2 : answer[0] = 5; break;
    	default : answer[0] = 6; break;
    	}
    	
        return answer;
    }

}

class �ζ����ְ��������������_�ٸ���� {
    public int[] solution(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }
}
/*
 * �ڵ�� ª���� �������� ������ �������ٴ� �ǰ��� ���� �ڵ忴��.
 * ȿ������ �鿡���� ���� ������.. ���߿� �̷� �ڵ� �� �� �ۼ��غ��� �͵� ���� �� �ϴ�.
 * 
 */

class �ζ����ְ��������������_�ٸ����2  {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true);
        }


        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++;
        }

        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
}

/*
 * ���� ����� �ڵ�, ���� ���̸� ���� ���ϰ�, switch case ������ �����Ͽ���
 * �� �ڵ�� ��ȸ �� �ٷ� ����� �ع����� �ڵ���
 * 
 * 
 */


package level1;

import java.util.ArrayList;

public class �ּ����簢��_��ǰ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���� ������ ����� ȸ�翡�� ������ ũ�⸦ ���Ϸ��� �մϴ�. 
		 * �پ��� ���� ũ���� ���Ե��� ��� ������ �� �����鼭, �۾Ƽ� ��� �ٴϱ� ���� ������ ������ �մϴ�. 
		 * �̷��� ����� �����ϴ� ������ ����� ���� ���������� ��� ������ ���� ���̿� ���� ���̸� �����߽��ϴ�.
		 * 
		 * �Ʒ� ǥ�� 4���� ������ ���� ���̿� ���� ���̸� ��Ÿ���ϴ�. 
		 *
		 *��ȣ ���� ����
		 * 1 - 60 50 
		 * 2 - 30 70
		 * 3 - 60 30 
		 * 4 - 80 40
		 * 
		 * 
		 * ���� �� ���� ���̿� ���� ���̰� ���� 80, 70�̱� ������ 80(����) x 70(����) ũ���� ������ ����� 
		 * ��� ���Ե��� ������ �� �ֽ��ϴ�. 
		 * 
		 * ������ 2�� ������ ���η� ���� �����Ѵٸ� 
		 * 80(����) x 50(����) ũ���� �������� ��� ���Ե��� ������ �� �ֽ��ϴ�. 
		 * �̶��� ���� ũ��� 4000(=80 x 50)�Դϴ�.
		 * 
		 * ��� ������ ���� ���̿� ���� ���̸� ��Ÿ���� 2���� �迭 sizes�� �Ű������� �־����ϴ�. 
		 * ��� ������ ������ �� �ִ� ���� ���� ������ ���� ��, ������ ũ�⸦ return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 *
		 * 
		 * ���ѻ��� 
		 * sizes�� ���̴� 1 �̻� 10,000 �����Դϴ�. 
		 * sizes�� ���Ҵ� [w, h] �����Դϴ�. w�� ������ ���� ���̸� ��Ÿ���ϴ�. 
		 * h�� ������ ���� ���̸� ��Ÿ���ϴ�. 
		 * w�� h�� 1 �̻� 1,000 ������ �ڿ����Դϴ�.
		 */
		int[][] aa = new int[2][2];
		aa[0][0] = 12;
		aa[0][1] = 42;
		aa[1][0] = 62;
		aa[1][1] = 2;
		System.out.println(solution(aa));
		
	}



	public static int solution(int[][] sizes) {
		
		/*
		 * ���� ���� Ǫ�� ���
		 * 1. ����(c),����(r) ��Ʋ� ���� ū ��(a)�� ���� ã�´�.
		 * 2. �� �� �ٸ� ���⿡�� �� ���� ū ��(b)�� ã�´�.
		 * 
		 * ! a x b �� ������ ��� ���� ������ �����ϴ�.
		 * 
		 * 3. c�Ǵ� r �� �ϳ����� b�� ���� ���� �ε����� r�Ǵ� c(�ݴ� ����) ���� Ȯ���Ѵ�. 
		 * 4. �� ���� c�Ǵ� r���� �ι�° ū b������ ������,
		 *
		 * 
		 * 5. 2���� �ݺ��Ѵ�.
		 * =================================================
		 * 1. ������� ū �� 2���� ã�´�. => ��ȸ �Ϸ�.
		 * 2. �� ���� �߿��� �� �ε������� ����, ���ΰ� ���� ū ���� ������ ������ ��ȯ.
		 * 
		 * 
		 * 3. �ε��� ��ȣ�� �ٸ��� �� �� ° ���� �ٸ� ������ ���� 3��° ���� ũ�ų� ������ 1x 3 ��ȯ
		 * 3. �׷��� ������ 3�� ° ū ���� �ݴ� ����� ��..   
		 * 
		 */
		int answer = 0;
		
		ArrayList<Integer>[] arr = new ArrayList[sizes.length];
		
		int standard = 0; // ���� ū ��. // �ϳ��� �ƴ� ����
		int opposite = 0; // �� ������ ū ��. // �ϳ��� �ƴ� ����.
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
					// ���� ū ���� ����������
				
					standard = sizes[i][j];
					// ���� ū ���� ������ ����
					
					standard_i = i;
					// ���� ū ���� ���Ե� �ε����� ��ȣ�� ����

					if(sizes[i][0] <= sizes[i][j] || j == 0) {
						
						standard_l = j;
						standard_s = 1;
						
					} else if(sizes[i][0] <= sizes[i][j] || j == 1) {
						
						standard_l = j;
						standard_s = 0;
					}

				} else if(sizes[i][j] < standard && sizes[i][j] > opposite) {
					// �ι�° ū ���� ����������
					
					opposite = sizes[i][j];
					// �ι�° ū ���� ������ ����
					
					opposite_i = i;
					// �ι�° ū ���� ���Ե� �ε����� ��ȣ�� ����
					
					if(sizes[i][0] <= sizes[i][j] || j == 0) {
						
						opposite_l = j;
						opposite_s = 1;
						// j�� ���� ����
					} else if(sizes[i][0] <= sizes[i][j] || j == 1) {
						
						opposite_l = j;
						opposite_s = 0;
					}
					
				}
			}
			
			
		}
		
		
		while(true) {
			
			if(arr[standard_i].get(0) == arr[standard_i].get(1)) {
				// ���� ū ���� ���� ���� ���̰� ������, �� ���� ���� ��ȯ
				return standard*standard;
				
			} else if(arr[standard_i].get(standard_s) >= arr[opposite_i].get(opposite_l)) {
				// �׷��� �ʰ�, �ݴ� ������ �ι� ° ���� ���ų� ũ�� ��ȯ
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
					// �� �ݺ��������� opposite ���� �ٽ� �����ش�.
					// ���� �ڵ忡���� 2��° ������ ������, �������ʹ� 3��°, 4��°, n��° ������ ����.
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

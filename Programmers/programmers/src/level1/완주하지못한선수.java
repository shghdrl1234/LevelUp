package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class �����������Ѽ��� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ������ ������ �������� �����濡 �����Ͽ����ϴ�. 
		 * �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
		 * 
		 * �����濡 ������ �������� �̸��� ��� �迭 participant�� 
		 * ������ �������� �̸��� ��� �迭 completion�� �־��� ��,
		 * �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�. 
		 * completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�. 
		 * �������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�. 
		 * ������ �߿��� ���������� ���� �� �ֽ��ϴ�.
		 * 
		 * 
		 * 
		 * 
		 */
		String[] arr1 = {"leo", "kiki", "eden"};
		String[] arr2 = {"eden", "kiki"};
		
		solution2(arr1,arr2);
	}
	
	public static String solution4(String[] participant, String[] completion) {
		
		String answer = "";
		Map<String, Integer> partMap = new HashMap<String, Integer>();
		
		for(String s : participant) {
			partMap.put(s, partMap.getOrDefault(s, 1)+1);
		}
		
		for(String s : completion) {
			partMap.put(s, partMap.get(s)-1);
		}
		
		for(String s : partMap.keySet()) {
			if(partMap.get(s) != 1) {
				answer = s;
				break;
			}
		}
		return answer;
		
	}
	
	public static String solution3(String[] participant, String[] completion) {
		/*
		 * ���� ���� Ǫ�� ���
		 * 
		 * �� ���� �����ϰ� ��� ������ �����Ͽ���.
		 * ������ ��⿡ ������ ���� �߿� ���������� ������ ���� �ִ�.
		 * 
		 * participant�� completion�� HashMap���� �����Ѵ�.
		 * => Key�� ������ �̸�, value�� key�� �̸��� ���� ������ ��.
		 * 
		 * ���� ���� Ű�� ã�� ���ϸ�, ���� �ٸ��� �� ������ ���� ���� ��.
		 * 
		 */
		String answer = "";
		Map<String, Integer> partMap = new HashMap<String, Integer>();
		Map<String, Integer> compMap = new HashMap<String, Integer>();
		
		for(String s : participant) {
			partMap.put(s, partMap.getOrDefault(s, 1)+1);
		}
		
		for(String s : completion) {
			compMap.put(s, compMap.getOrDefault(s, 1)+1);
		}
		
		for(int i = 0; i < participant.length; i++) {
			
			if(!compMap.containsKey(participant[i])) {
				answer = participant[i];
				break;
			}
			
			if(compMap.get(participant[i]) == null) {
				answer = participant[i];
				break;
			}
			
			if(partMap.get(participant[i]) != compMap.get(participant[i])) {
				answer = participant[i];
			}
			
		}
		
		return answer;
		
	}
		
	
	public static String solution2(String[] participant, String[] completion) {
		/*
		 * ���� ���� Ǫ�� ���
		 * 1. ���� ���� 1���� ã�´�.
		 * 2. participant�� completion�� ���Ͽ� ���� �̸��� ������ �����.
		 * 3. ������ ���� 1���� �̸��� ��ȯ�Ѵ�.
		 * 
		 */

		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		
		for(int i = 0; i < participant.length; i++) {
			// ��ȸ�ϸ鼭 ������ ����� ����.
			arr1.add(participant[i]);
			System.out.println(arr1);
			
			// ��ȸ�ϸ鼭 ������ ��� ����.
			if(i < participant.length-1) {
				arr2.add(completion[i]);
				System.out.println("arr2 : "+arr2);
				
//				 ���� �����ִ� �������� �̸���, ������ ��ܿ� ������
//				 ������ ��ܿ��� �� �̸� �ϳ��� ����.
//				 ������ ��ܿ����� ����.
				// ������ ����� �þ�� ������ ���� �ְ�,
				// ������ ����� �ä�
				if(arr1.contains(completion[i])) {
					arr1.remove(completion[i]);
					arr2.remove(completion[i]);
				}
			}
			System.out.println("arr2 - 1 : "+arr2);
		}

		String answer = arr1.get(0);
		System.out.println(answer);
		return answer;
	}
	
	public static String solution1(String[] participant, String[] completion) {
		/*
		 * ���� ���� Ǫ�� ���
		 * 1. ���� ���� 1���� ã�´�.
		 * 2. participant�� completion�� ���Ͽ� ���� �̸��� ������ �����.
		 * 3. ������ ���� 1���� �̸��� ��ȯ�Ѵ�.
		 * 
		 */

		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		
		for(String s : participant) {
			arr1.add(s);
		}
		
		for(String s : completion) {
			arr2.add(s);
		}
		
		for(int i = 0; i < arr2.size(); i++) {
			
			for(int j = 0; j < arr1.size(); j++) {
				if(arr2.get(i).equals(arr1.get(j))) {
					arr1.remove(j);
					j--;
					break;
				}
			}
			
		}
		
		String answer = arr1.get(0);
		System.out.println(answer);
		return answer;
	}
	
    public static String solution(String[] participant, String[] completion) {
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 
    	 * 1. participant �迭 => hash�� ����
    	 * 2. participant�� completion ���Ҹ� �����Ͽ� ��ġ�ϸ� ����
    	 * => ��, participant�� ���������� ������, �ش� ���Ҵ� ���� �����صΰ�, ����.
    	 * => �� ���������� completeion ���̰� participant ���� 1�۱� ������ 1�� ���� ���� ���¶�
    	 * ���������� answer�� �������.
    	 * 
    	 * 3. ���������� �ִٸ� participant�� hash�� ����� �ߺ��� ���� ���ŵ�. 
    	 * => ����� �� �񱳸� �� �� ����.
    	 * => ������ �̰� ���̿� �� �� �ִ� ����� ������?
    	 * 
    	 * 3-1) participant, completion �� �迭 �ߺ����� �� �����ִ� ���ҵ��� 
    	 * �����Ͽ� participant ���� remove ���� ??
    	 * => ���������� ��� ��Ȯ�� �������� ������, "�̸�"�� ���� �� ����.
    	 * 
    	 */
    	
    	Set<String> part = new HashSet<String>();
    	Set<String> com = new HashSet<String>();
    	
    	
    	for(int i = 0; i < participant.length; i++) {
    		part.add(participant[i]);
    		// part�� �ߺ������� participant �迭�� ���� ����
    	}

    	for(int i = 0; i < completion.length; i++) {
    		com.add(completion[i]);
    		// com�� �ߺ������� completion �迭�� ���� ����
    	}
    	
    	Iterator<String> itr = com.iterator();
    	for(int i = 0; i < part.size(); i++) {
    		// part.size��ŭ ��ȸ
    		while(itr.hasNext()) {
    			String name = itr.next();
    			// com.sizw ��ŭ ��ȸ�ϸ鼭, part���� ���Ұ� ���� ���� ����
    			if(part.contains(name)) {
    				part.remove(name);
    				i--;
    				// ���Ұ� ���ŵǸ� ��ü size�� �پ��⶧���� �ݺ����ִ� i ������ -1 ���ش�
    			}
    		}
    	}
    	// �ߺ� ���Ÿ� �ϰ� �����ϸ�
    	// ������ �ߺ��� �������� 
    	
    	
    	String answer = part.toString();
    	// ������� ���� ����
    	
    	System.out.println(answer);
        return answer;
    }

}

/*
 * �������� �õ� ���� ������ Ǯ����.
 * hash�� ���� �־��µ� �������� �� ��Ǯ�� ����.
 * ������ ������� ������ hashMap�� �����Ͽ� �ϳ��� hashMap�� ���� �����ϴ� ������,
 * �ش� hashMap�� values�� �ٸ� �͸� ã�Ƴ��� �ȴ�. 
 */


 class �����������Ѽ���_�ٸ���� {

    int bucketSize;
    List<Entry>[] bucket;

    public String solution(String[] participant, String[] completion) {
        bucketSize = (completion.length / 5)+1;
        bucket = new List[bucketSize];

        for (int i = 0; i < completion.length; i++) {
            Entry entry = get(completion[i]);
            entry.value += 1;
        }

        for (int i = 0; i < participant.length; i++) {
            Entry entry = get(participant[i]);
            if (entry != null && entry.value > 0) {
                entry.value -= 1;
            } else {
                return entry.key;
            }
        }
        throw new RuntimeException("error");
    }

    private Entry get(String s) {
        int idx = hash(s);
        List<Entry> list = bucket[idx];
        if (list == null) {
            list = new List<Entry>();
            Entry entry = new Entry(s, 0);
            list.add(entry);
            bucket[idx] = list;
            return entry;
        } else {
            Entry entry = list.get(s);
            if (entry == null) {
                entry = new Entry(s, 0);
                list.add(entry);
            }
            return entry;
        }
    }


    private int hash(String s) {
        int num = 0;
        for(int i=0; i<s.length(); i++) {
            num += s.codePointAt(i) * 31 + s.codePointAt(i);
        }
        return num % bucketSize;
    }

    class Entry {
        String key;
        int value;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class List<T extends Entry> {
        Node head;

        public void add(T entry) {
            Node nn = new Node(entry, null);

            if (head == null) {
                head = nn;
            } else {
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = nn;
            }
        }

        public <T extends Entry> T get(String s) {
            Node node = head;
            while (node != null) {
                if (node.data.key.equals(s)) {
                    return (T) node.data;
                }
                node = node.next;
            }

            return null;
        }

        class Node<T extends Entry> {
            T data;
            Node next;

            public Node(T data, Node next) {
                this.data = data;
                this.next = next;
            }
        }
    }
/*
 * hashMap�� ���� ������ ���� �ڵ�..
 
 * 
 */

}
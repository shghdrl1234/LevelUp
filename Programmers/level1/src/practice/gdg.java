package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class gdg {

	public static void main(String[] args) {

		String[] str = {"alex pizza pasta", "alex pizza", "alex noddle","bob pasta", "bob noddle", "bob noddle sanswith pasta", "bob steak noodle"};
		solution(str);

	}
	
    public static String[] solution(String[] orders) {
       

        String[][] arr = new String[orders.length][7];
        //각 배열로 만들고, 빈칸 추가될 것 염려하여 크기 7개 줌 공백 + 유저 + 음식5
        
        for(int i = 0; i < orders.length; i++) { 
        	
        	for(int j = 0; j < orders[i].split(" ").length; j++) {
        		
        		arr[i][j] = orders[i].split(" ")[j];
        		// 각 크기별로 저장
        	}
        }
        
        Set<String> namecnt = new HashSet();
        
        for(int i = 0; i < orders.length; i++) {
        	
        	namecnt.add(arr[i][0]);
        }
     
        Set<String>[] name = new HashSet[namecnt.size()];
        
       for(int i = 0; i < name.length; i++) {
    	   name[i] = new HashSet();
       }
        
        
        String[] namecntarr = (namecnt.toString().substring(1,namecnt.toString().length()-1).split(","));
        
        
        System.out.println(namecnt.size());
        System.out.println(Arrays.toString(namecntarr));
        System.out.println(namecntarr[0]);
        
        for(int a = 0; a < namecnt.size(); a++ ) {
        	name[a].add(namecntarr[a]);
        }
        
        for(int j = 0; j < orders.length; j++ ) {
        	
        	for(int k = 0; k < namecnt.size(); k++) {
        
        		if(name[k].contains(arr[j][0])) {
        			
        			for(int h = 0; h < arr[j].length; h++) {
        				name[k].add(arr[j][h]);
        			}
        		}
        		
        	}
        }
        
        int abc = 0;
        int dup = 0;
        
        for(int l = 0; l < namecnt.size()-1; l++ ) {
        	if(name[l].size() >= name[l+1].size()) {
        		abc = name[l].size();
        	} else {
        		abc = name[l+1].size();
        	}
        }
        
        for(int m = 0; m < namecnt.size(); m++ ) {
        	if(name[m].size() == abc) {
        		dup++;
        	}
        }
        
        String[] answer = new String[dup];
        ArrayList<String> nameList = new ArrayList<String>();
        
        System.out.println(name[0]);
        
        for(int n = 0; n < namecnt.size(); n++ ) {
        	if(name[n].size() == dup) {
        		nameList.add(name.toString());
        	}
        }


        return answer;
    }
    

}

package misc;



public class main_misc {

	public static void main(String[] args) {
		
	int[]v = {1,2,3,1,2,3,3,3};
	System.out.println(min_moves(v));
		
	}
	private static void swap(int[] v,int i,int j){
		//
		int d = v[i];
		v[i] = v[j];
		v[j] = d;
	}
	
	private static void quickSort(int[]v,int strt,int end) {
		if(strt >= end) {
			return;
		}
		int l = strt;
		int r = end;
		int p = v[end];
		
		while(l < r){
			while(v[l] <= p && l < r) {
				l++;
			}
			while(v[r] >= p && l < r) {
				r--;
			}
			swap(v,l,r);
		}
		
		if(v[l] > v[end]) {
			swap(v,l,end);
		}
		else {
			l = end;
		}
		quickSort(v,strt,l-1);
		quickSort(v,l+1,end);
	}
	
	private static int min_moves(int[]v) {
		quickSort(v,0,v.length-1);
		
		int last = 0;
		int curr = 1;
		int max = 0;
		for(int i = 0;i < v.length;i++){
			if(i == 0) {
				last = v[i];												
				continue;
			}
			last = v[i-1];
			if(i == v.length-1) {
				if(v[i] == last) {
					curr++;
				}
				if(max <= curr) {
					max = curr;
				}
				break;
			}
			
			if(v[i] != last) {
				if(max <= curr) {
					max = curr;
					//System.out.println("-"+max);
				}
				curr = 1;
			}
			if(v[i] == last){
				//System.out.println("->"+v[i]);
				curr++;
			}
		}
		return v.length - max;
	}
	
	}
	
	
	
	

	


	
	

	
		
	
	


	

	
	


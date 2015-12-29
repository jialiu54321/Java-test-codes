package CountingSort;

/**
 * Implementation of counting sort. 
 * @author jialiu
 *
 */

public class CountingSorter {
	
	int[] a;//to store result
	int[] b;//to store result
	int[] c;//temp storage
	int maxI;//max of int[] a
	
	public CountingSorter(int[] a){
		this.a = a;
		b = new int[a.length]; 
		maxI = findMax(a);
		c = new int[maxI + 1];
		for(int i = 0; i < c.length; i++){
			c[i] = 0;
		}
	}
	
	public int[] countingSort(){
		for(int i = 0; i < a.length; i++){
			c[a[i]]++;
		}
		
		for(int i = 1; i < c.length; i++){
			c[i] += c[i - 1];
		}
		
		for(int i = 0; i < a.length; i++){
			b[c[a[i]] - 1] = a[i]; //c[a[i]]-1 就代表小于等于元素A[i]的元素个数
			c[a[i]]--;//以防发生再次出现相同的a[i]
		}
		
		return b;
	}
	
	
	private static int findMax(int[] a){
		int tempMax = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++){
			if(a[i] > tempMax){
				tempMax = a[i];
			}
		}
		return tempMax;
	}
}

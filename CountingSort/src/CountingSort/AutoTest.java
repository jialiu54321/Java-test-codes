package CountingSort;

public class AutoTest {

	public static void main(String[] args){
		int[] a = new int[] { 2, 5, 3, 0, 2, 3, 0, 3 };
		System.out.println("Before Sorting：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		CountingSorter sorter = new CountingSorter(a); 
		int[] b = sorter.countingSort();
		
		System.out.println("After Sorting：");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}
	
}

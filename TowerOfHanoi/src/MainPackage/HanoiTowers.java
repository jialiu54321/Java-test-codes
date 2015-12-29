package MainPackage;

import java.util.Stack;

/**
 * Implementation of Hanoi Towers. 
 * @author jialiu
 *
 */

public class HanoiTowers {
	
	int n;
	
	Stack<Integer> ori; 
	Stack<Integer> buff; 
	Stack<Integer> des; 
	
	
	public HanoiTowers(int n) {
		super();
		this.n = n;
		ori = new Stack<Integer>();	
		for (int i = n; i > 0; i--) {
			ori.push(i);
		}
		buff = new Stack<Integer>();
		des = new Stack<Integer>();
	}
	
	public void printTowers(){
		System.out.println("ori Tower :");
		while (!ori.empty()) {
			System.out.println(ori.pop());
		}
		System.out.println("buff Tower :");
		while (!buff.empty()) {
			System.out.println(buff.pop());
		}
		System.out.println("des Tower :");
		while (!des.empty()) {
			System.out.println(des.pop());
		}
	}
	
	public void hanoiMove(){
		hanoiMoveRecurse(n, ori, buff, des);
	}
	
	private void hanoiMoveRecurse(int n, Stack<Integer> ori, Stack<Integer> buff, Stack<Integer> des){
		if (n <= 0) {
			return;
		} else if (n == 1) {
			moveOne(ori, des);
			return;
		} else if (n == 2) {
			moveOne(ori, buff);
			moveOne(ori, des);
			moveOne(buff, des);
			return;
		} else if (n == 3) {
			moveOne(ori, des);
			moveOne(ori, buff);
			moveOne(des, buff);
			moveOne(ori, des);
			moveOne(buff, ori);
			moveOne(buff, des);
			moveOne(ori, des);
			return;
		}

		for(int i = n; i > 0; i--){
			hanoiMoveRecurse(i - 1, ori, des, buff);
			boolean moveResult = moveOne(ori, des);
			if (!moveResult) {
				System.out.println("disk moving error, n is " + i);
			}
			hanoiMoveRecurse(i - 1, buff, des, ori);
		}
	}
	
	private boolean moveOne(Stack<Integer> from, Stack<Integer> to){
		if (from.isEmpty()) {
			return false;
		} else if (!to.isEmpty() && from.peek() > to.peek()){
			return false;
		} else {
			int v = from.pop();
			to.push(v);
			return true; 
		}
			
	}
	
}

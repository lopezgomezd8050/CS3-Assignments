import java.util.Stack;

public class Stacky {
	public static boolean validStatement(String statement) {
		char[] expr = statement.toCharArray();
		Stack<Character> stacky = new Stack<Character>();
		for(char c: expr) {
			if(c == '(' || c == '{' || c == ')' || c == '}') {
				stacky.push(c);
			}
			if(stacky.size()>=2) {
				char elem1 = stacky.pop();
				char elem2 = stacky.pop();
				if(!(elem1 == '}' && elem2 == '{') && !(elem1 == ')' && elem2 == '(')) {
					stacky.push(elem2);
					stacky.push(elem1);
				}
			}
		}
		if(stacky.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static int postyfixy(String expression) {
		//TODO: make it work
		Stack<Integer> stacky = new Stack<Integer>();
		char[] expr = expression.toCharArray();
		for(char c: expr) {
			if(Character.isDigit(c)) {
				stacky.push(Integer.parseInt(Character.toString(c)));
			} 
			else {
				int elem1 = stacky.pop();
				int elem2 = stacky.pop();
				switch(c) {
					case '+':
						stacky.push((elem2+elem1));
						break;
					case '-':
						stacky.push((elem2-elem1));
						break;
					case '*':
						stacky.push((elem2*elem1));
						break;
					case '/':
						stacky.push((elem2/elem1));
						break;
				}
			}
		}
		
		return stacky.pop();
	}
	
	public static void main(String[] args) {
//		System.out.println(validStatement("()()"));
//		System.out.println(validStatement("({(}"));
//		System.out.println(validStatement("(2+5)*{3+(5-3)}"));
//		System.out.println(validStatement("(())"));
//		System.out.println(validStatement("(()))"));
		System.out.println(postyfixy("45/12++"));
	}
}

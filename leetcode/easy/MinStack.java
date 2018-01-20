import java.util.*;
public class MinStack {
	Stack<Long> stack;
	long min; //min에 int가 아닌 long을 쓰는 이유는 산술연산 과정에서 int범위를 넘어가 오답이 나오기 때문
	public MinStack() {
		stack=new Stack<>();
	}

	public void push(int x) {
		if(stack.isEmpty()){
			stack.push(0L);
			min=x;
		}else{
			//해당위치의 값과 min의 차를 stack에 push
			//해당 위치 값이 min보다 크면 양수가, 작으면 음수가 입력되고 min이 갱신된다. 
			stack.push(x-min);
			min=x<min?x:min;
		}
	}

	public void pop() {
		if(stack.isEmpty())return;
		
		long pop=stack.pop();
		//pop<0이라는 것은 해당위치의 원래 값이 min값보다 작았고, min값의 갱신이 일어났을것
		//min에 pop값(음수!!)을 더해주면 이전의 min을 구할 수 있다.
		if(pop<0)min=min-pop;
	}

	public int top() {
		if(stack.size()<1) return 0;

		//현재 min이 아닌 스택에는 원값-min값이 들어가있다. 
		//원값을 구하기 위해서는 stack에 있는 값+min값을 해주어야 한다.
		if(stack.peek()>0)return (int) (stack.peek()+min);
		else return (int)min;
	}

	public int getMin() {
		return (int)min;
	}
}

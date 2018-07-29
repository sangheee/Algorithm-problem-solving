# Weekly Contest 95
## 876. Middle of the Linked List 
## 877. Stone Game
## 878. Nth Magical Number  
### 문제 설명  
입력으로 세 숫자 A, B, N이 주어진다.
A, B 로 만들 수 있는 숫자 중 N번째 수를 찾아 리턴한다.  

ex)
> input: N=1, A=2, B=3  
> output: 2

> input: N=4, A=2, B=3  
> output: 6  
> 만들 수 있는 수가 [2,3,4,6,8,...] 이기 때문에 4번째인 6을 리턴

처음엔 작은 순서대로 구해서 N번째까지 구하려고했다.  
입력 제한이 10^9, 즉 1억 까지이기 때문에 O(N)이 걸리는 이 방법은 time limit이 난다..--;

모두 구하면 안된다.  
A와 B의 최소 공배수까지 구해서 list(또는 array 등의 collection)에 넣어놓자. 

N번째 수까지 **N/list.size()번 collection에 있는 숫자들에 증가하는 수를 곱한만큼 반복**할 것이다.  

무슨말인지 글로만 써놓고 보면 모르겠는데 이런거다.  
lcm까지의 수를 담아놓은 collection을 list라고 할 때,
~~~
1*(list[0],list[1],...,list[list.size()]),
2*(list[0],list[1],...,list[list.size()]),...,
(N/list.size())*(list[0],list[1],...,list[list.size()])
~~~

(N/list.size())만큼 사이클을 돈다는 것이다.
즉,
~~~~
(N/list.size())*(list.getLast())+list.get(N%list.size-1)
~~~~

을 구하면 되는데, N%list.size==0일 때에 더한 처리와 modulo 연산이 추가적으로 필요하겠다.  
시간복잡도는 O(A*B), 공간복잡도는 O(A*B)가 소요된다.

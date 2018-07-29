# Weekly Contest 95
## 876. Middle of the Linked List 
### 문제 설명  
input으로 LinkedNode의 head 가 주어지며, 그 LinkedNode의 중간 node를 반환한다.  

### 풀이  
그냥 풀면 풀린다.

여기서 말하는 그냥 풀면이란....  
리스트 한번 순회해서 전체 길이 구하고, 다시 그의 반만큼을 가서 그때의 노드를 반환하는것을 말한다.
~~~
TreeNode tmp=head;
int cnt=0;
while(tmp!=null){
  cnt++;
  tmp=tmp.next;
}
for(int i=0;i<cnt/2;i++){
  head=head.next;
}
return head;
~~~

위와 같이 풀 수도 있지만,  
속도 차이가 두 배가 나는 노드(싸이클 찾는데도 쓰이는 [토끼와 거북이](https://en.wikipedia.org/wiki/Cycle_detection))로도 구할 수 있다.

~~~
TreeNode a=head,b=head;
while(b!=null && b.next!=null){
  a=a.next;
  b=b.next.next;
}
return a;
~~~

둘 다 시간복잡도 `O(N)`, 공갑복잡도 `O(1)`이 소요된다.

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

### 풀이   
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
시간복잡도는 `O(A*B)`, 공간복잡도는 `O(A*B)`가 소요된다.

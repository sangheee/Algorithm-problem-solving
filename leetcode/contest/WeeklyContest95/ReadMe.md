# Weekly Contest 95
## [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/description/)
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

## [877. Stone Game](https://leetcode.com/problems/stone-game/description/)
### 문제 설명
Alex와 Lee가 돌을 많이 가져간 사람이 승리하는 돌 가져가기 게임을 한다.  
- 돌은 하나의 row인 piles에 있으며, piles\[i\]는 i번째 열에 있는 돌의 개수를 의미한다.  
- 한 번에 양쪽 끝 중 한 쪽의 돌만 가져갈 수 있다.  
- 한 행에 짝수 개의 열이 있으며, 돌의 총 합은 홀수이기 때문에 반드시 승판이 난다.  
- Alex와 Lee는 항상 최선을 다한다.  

Alex가 먼저 게임을 시작할 때, Alex가 이기는 수가 있으면 true를 리턴한다.  

ex)
> input: \[5, 3, 4, 5\]  
> output: true  
> Alex는 처음에 오른쪽 끝 혹은 왼쪽 끝의 5만 가져갈 수 있다.  
> Lee는 Alex가 가져가지 않은 5를 선택할 것이다.  
> Alex는 최선을 다하기 때문에 남은 \[3, 4\] 중 더 큰 4를 가져가고 승리한다.  

이 문제를 보고 가장 먼저 떠오른 생각은 예전에 종만북 스터디에서 푼 [blockgame](https://algospot.com/judge/problem/read/BLOCKGAME)문제  
이길 수 있는 지 없는지만 확인하면 되는데...저 문제도 dp 카테고리인데 왠지 dfs였던것같은...잘못된 기억으로...삽질을...

### 풀이
처음 접근은 dfs로 했다...그래서 모든 경우 다구해보고 Alex가 이길 수 있는 경우가 하나라도 있으면 승리하도록 했다..  
piles.length가 500까지여서 되긴 한다.
~~~
boolean isWinAlex(int Alex, int Lee, int l, int r, int[] piles) {
  if (l >= r) return Alex > Lee;
  if(isWinAlex(Alex + piles[l], Lee + piles[l], l + 2, r, piles) || isWinAlex(Alex + piles[l], Lee + piles[r], l + 1, r - 1, piles)) return true;
  if (isWinAlex(Alex + piles[r], Lee + piles[l], l + 1, r - 1, piles) || isWinAlex(Alex + piles[r], Lee + piles[r], l, r - 2, piles)) return true;
  return false;
}
~~~
piles.length를 N이라 할 때,  
이렇게 풀면 시간복잡도가......한번 isWinAlex들어갈 때 마다 N^2이고 이걸 한번에 4번 하니까...4\*N^2?`O(N^2)`  
N 제한이 500이 아니라 1000만 됐으면...^^...  

**dp로 풀어보자🙃**  
dp\[i\]\[j\]는 piles\[i]부터 piles\[j]까지 최선을 다해 플레이했을 때 Alex와 Lee의 점수 차이다. 

~~~
dp[i][j]=Mahh.max(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1])
~~~
위와 같은 점화식은   
현재 player가 piles\[i]를 선택할 수도 있고 piles\[j]를 선택할 수도 있지만,  
그걸 선택했을 때 다른 player와의 점수차이는 다른 player가 i+1부터 j까지(혹은 i부터 j-1까지) 최선을 다해 게임한 점수의 차이 중 작은 값임을 의미한다.  

~~~
int n=piles.length;
int[][] dp= new int[n][n];
for(int i=0;i<n;i++)dp[i][i]=piles[i];

for(int j=1; j<n; j++){
  for(int i=0;i<n-j;i++){
    dp[i][i+j]=Math.max(piles[i]-dp[i+1][i+j], piles[i+j]-dp[i][i+j-1]);
  }
}
return dp[0][n-1]>0;
~~~
Alex가 먼저 시작하기 때문에 0부터 n-1까지 최선을 다한 점수차이가 양수이면 Alex가 이긴 것이다.  
이렇게 풀면...이것도 시간복잡도가 `O(N)`이고,,,공간복잡도는 `O(N^2)` 돼버리네...☠️   

위의 점화식을 잘보면.... 
 
```
| 1 | 2 | 3 | 4 |
|   | 1 | 2 | 3 |
|   |   | 1 | 2 |
|   |   |   | 1 |  
```

이런식으로 연산이 대각선으로 진행된다.  
이를 이용해 공간복잡도 `O(N)`으로 풀 수도 있다..
~~~
int n=piles.length;
int[]dp= Arrays.copyOf(piles,n);
for(int j=1;j<n;j++){
  for (int i=0; i<n-j;i++){
    dp[i]=Math.max(piles[i]-dp[i+1],piles[i+j]-dp[i]);
  }
}   
return dp[0]>0;
~~~
이 때 각 dp\[i]는 (몇번째 stage(?)냐에 따라 다르겠지만) 위의 dp\[i]\[j]와 같은 의미를 가진다.  

그런데...Alex가 항상 먼저 시작하고 주어진 배열의 원소 수는 짝수이기 때문에...  
Alex는 항상 이길 수 밖에 없다는데... 그 이유인 즉슨 이거다.  

Alex는 처음에 0(짝수)번째, 또는 n-1(홀수)번째 만을 선택할 수 있는데  
0번째를 선택하면 그 다음에는 **항상 짝수번째 인덱스에 있는 돌**을 가져가게 되고,  
n-1번째를 선택하면 그 다음에는 **항상 홀수번째 인덱스에 있는 돌**을 가져가게 된다.  

즉,  
`sum(piles[even]) > sum(piles[odd])` 일 때 Alex가 짝수번째를 선택하면 이긴다.  
`sum(piles[odd]) > sum(piles[even])` 일 때 Alex가 홀수번째를 선택하면 이긴다.    
따라서, **Alex는 항상 이길 수 있다.**

~~~
return true;
~~~

## [878. Nth Magical Number](https://leetcode.com/problems/nth-magical-number/description/)
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

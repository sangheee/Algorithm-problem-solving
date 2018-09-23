## Weekly Contest 102

### 904. Fruit Into Baskets
문제 설명
- random한 integer array가 주어지며, array의 각 원소는 tree[i] 나무를 의미한다.  
그러니까...tree[n]==tree[m]이면 같은 나무이다.
- 바구니가 두 개이고, 한 바구니에 하나의 나무의 열매만 담을 수 있을 때, 가장 많은 열매를 담으면 몇개인지를 리턴한다.
- 조건은
    - 어느 나무의 열매부터 딸지 선택할 수 있으며, 선택한 나무의 오른쪽으로 이동하면서 열매를 딴다.
    - 열매를 딸 수 없을때(다른 나무를 만났을 때?)는 멈춘다.
- example:
    - input: [1,2,3,2,2]
    - output: 4
    - 1에서 시작하여 2번 나무 3개, 3번 나무 1개를 따면 최대 4개를 딸 수 있다.  
    만약 0에서 시작하면 1번 1개, 2번 1개 총 2개밖에 딸 수 없다.   

**solution**

현재까지의 열매 개수와 어떤 나무(2개)의 열매를 땄는 지 기억하며,  
기억하고 있는 나무 2개 외의 다른 나무를 만나면 그 시점부터 새로이 시작한다.
(여기서 max=Math.max(sum,max)를 해서 max를 계산, 마지막에 이 max를 리턴한다.)

다만 나무의 출현이 반복됐을 수 있기 때문에 이전에 반복된 갯수를 저장하기 위해 투포인터를 사용한다.
~~~
for (int i=0;i<tree.length;i++){
    int t=tree[i];
    if (t==last){
        sum++;
        r++;
    }else if(t==prelast){
        sum++;
        prelast=last;
        last=t;
        l=r=i;
    }else{
        max=Math.max(max,sum);
        sum=r-l+2;
        l=r=i;
        prelast=last;
        last=t;
    }
}
~~~

O(n) time complexity,
O(1) space complexity

### 905. Sort Array By Parity
문제 설명
- random한 양수 integer array가 주어졌을 때, 짝수 뒤에 홀수가 오는 array를 리턴
- example:
    - input: [3,1,2,4]
    - output: [2,4,3,1]
    - output은 [4,2,3,1], [2,4,1,3], [4,2,1,3] 도 될 수 있다. 
    즉 짝수 뒤에 홀수이기만 하면 순서는 상관 없다.
   
**solution**
~~~
for(int l=0,r=A.length-1; l<r;){
    if(A[l]%2!=0){
        int tmp=A[r];
        A[r--]=A[l];
        A[l]=tmp;
    }else{l++;}
}
~~~ 
투포인터 사용,  
array를 순회하며 짝수면 l을 1 증가, 홀수이면 r위치로 스왑하고 r을 1 감소

O(n) time complexity    


### 907. Sum of Subarray Minimums
문제 설명
- random한 양수 integer array가 주어졌을 때, 가능한 연속된 subarray에서 min값의 합을 구한다.
- example:
    - input: [3,1,2,4]
    - output: 17
    - explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
                   Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.


**solution**
1. stack   
   O(n^2) time complexity  
   O(n) space complexity
   ~~~
   for (int i = 0; i < n; i++) {
               int cur=1;
               while (!stack.isEmpty() && stack.peek()[0]>=A[i]){
                   int[] last=stack.pop();
                   cur+=last[1];
                   stacksum-=(last[0]*last[1]);
               }
               stack.push(new int[]{A[i],cur});
               stacksum+=(cur*A[i]);
               ret+=stacksum;
               ret%=mod;
    }
   ~~~
  
2. stack  
   O(n) time complexity  
   O(n) space complexity  
   
   prev -> 자기 앞에 자기보다 작은 원소의 인덱스  
   next -> 자기 뒤에 자기보다 작은 원소의 인덱스
   
   인덱스를 i,  
   자기 앞에 자기보다 작은 원소의 인덱스를 p,  
   자기 뒤에 자기보다 작은 원소의 인덱스를 n 이라고 할 때,  
   전체 subarray에서 a[i]가 min인 subarray의 수는 (i-p)*(n-i)개이다.
   ~~~
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
               while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                   stack.pop();
               }
               prev[i] = stack.isEmpty() ? -1 : stack.peek();
               stack.push(i);
    }
   
    stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
               while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
                   stack.pop();
               }
               next[i] = stack.isEmpty() ? n : stack.peek();
               stack.push(i);
    }
   
    for (int i = 0; i < n; i++) {
               ret += (i - prev[i]) * (next[i] - i) % mod * A[i] % mod;
               ret %= mod;
    }
   ~~~

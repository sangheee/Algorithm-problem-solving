# Weekly Contest 99

### 892. Surface Area of 3D Shapes

생각한 그대로 풀면 되는데 문제 이해가 좀 어려운 문제.
처음엔 상하좌우 각 방향에서 보이는 것만 세면 되는 줄 알았는데 아니였음.
노출되는 면적? 이렇게 이해하는게 나을 것 같음.

O(N*N) time complexity

### 893. Groups of Special-Equivalent Strings

Counting appearance
O(N) space complexity
O(A.length * A[i].length) time complexity

### 894. All Possible Full Binary Trees

HashMap에 각각의 node의 수일때 가능한 list를 저장해둔다.
일종의 dp 솔루션으로, 다음 node의 list를 구할 때는
이전의 list들로 모든 가능한 조합을 구한다.

시간 복잡도는
N까지, N/2번 모든 조합을 구하는(2^N) O(N^2*2^N)이다.
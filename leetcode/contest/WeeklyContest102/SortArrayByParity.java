package contest.WeeklyContest102;

public class SortArrayByParity {
    //without extra space
    public int[] sortArrayByParity(int[] A) {
        for(int l=0,r=A.length-1; l<r;){
            if(A[l]%2!=0){
                int tmp=A[r];
                A[r--]=A[l];
                A[l]=tmp;
            }else{l++;}
        }
        return A;
    }
}

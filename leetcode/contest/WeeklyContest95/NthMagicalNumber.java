package contest.WeeklyContest95;

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class NthMagicalNumber {
    private static final int modulo= 1000000007;
    public int nthMagicalNumber(int N, int A, int B) {
        LinkedList<Integer> list=new LinkedList<>();
        int a=A,b=B;
        while (a!=b){
            if(a<b){
                list.add(a);
                a+=A;
            }else{
                list.add(b);
                b+=B;
            }
        }
        list.add(a);
        int res=(N%list.size());
        res=res>0?list.get(res-1):0;
        return (int) (((long)(N/list.size())*(list.getLast())+res)%modulo);
    }
    @Test
    public void test(){
        assertEquals(2,nthMagicalNumber(1,2,3));
        assertEquals(6,nthMagicalNumber(4,2,3));
        assertEquals(10,nthMagicalNumber(5,2,4));
        assertEquals(8,nthMagicalNumber(3,6,4));
    }
}

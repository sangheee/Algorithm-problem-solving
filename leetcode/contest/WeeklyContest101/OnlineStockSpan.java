package contest.WeeklyContest101;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan {
    public class StockSpanner {
        List<int[]> stock;

        public StockSpanner() {
            stock = new ArrayList<>();
        }

        public int next(int price) {
            int ret = 0;
            for (int i = stock.size() - 1; i >= 0; ) {
                int key = stock.get(i)[0];
                int val = stock.get(i)[1];
                if (key > price) break;
                ret += val + 1;
                i -= val + 1;
            }
            stock.add(new int[]{price, ret});
            return ret + 1;
        }
    }

    @Test
    public void test() {
        StockSpanner ss = new StockSpanner();
        ss.next(100);
        ss.next(80);
        ss.next(60);
        ss.next(70);
        ss.next(60);
        ss.next(75);
        ss.next(85);
    }
}

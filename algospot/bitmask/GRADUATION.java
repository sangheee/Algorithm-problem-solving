package bitmask;

import java.io.*;
import java.util.*;

public class GRADUATION {
    private static int N = 0, K = 0, M = 0, L = 0;
    private static final int MAX_VAL = 15;

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input.txt");
        //InputStreamReader fr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int C = Integer.valueOf(tokenizer.nextToken());

        for (int i = 0; i < C; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            N = Integer.valueOf(tokenizer.nextToken()); //전공과목의 수
            K = Integer.valueOf(tokenizer.nextToken()); //들어야 할 과목의 수
            M = Integer.valueOf(tokenizer.nextToken()); //학기의 수
            L = Integer.valueOf(tokenizer.nextToken()); //한 학기에 최대로 들을 수 있는 과목의 수

            //각 과목 정보
            int[] subjects = new int[N];
            for (int j = 0; j < N; j++) {
                tokenizer = new StringTokenizer(br.readLine());
                int R = Integer.valueOf(tokenizer.nextToken());
                while (tokenizer.hasMoreTokens()) {
                    int n = Integer.valueOf(tokenizer.nextToken());
                    subjects[j] |= (1 << n);
                }
            }

            //해당 학기, 들은 과목에 대해 남은 학기
            int[][] cache = new int[M][1 << (N + 1)];

            //학기별 개설 과목
            int[][] term = new int[M][];
            for (int j = 0; j < M; j++) {
                Arrays.fill(cache[j], MAX_VAL);
                tokenizer = new StringTokenizer(br.readLine());
                int n = Integer.valueOf(tokenizer.nextToken());

                term[j] = new int[n];
                for (int t = 0; t < n; t++) {
                    term[j][t] = Integer.valueOf(tokenizer.nextToken());
                }
            }

            int ret = graduate(cache, subjects, term, 0, 0);
            System.out.println(ret >= MAX_VAL ? "IMPOSSIBLE" : ret);

        }
    }

    private static int graduate(int[][] cache, int[] subjects, int[][] term, int thisTerm, int curTaken) {
        if (Integer.bitCount(curTaken) >= K) return 0;
        if (thisTerm == M) return MAX_VAL;
        if (cache[thisTerm][curTaken] != MAX_VAL) return cache[thisTerm][curTaken];

        int canListen = 0;
        for (int i = 0; i < term[thisTerm].length; i++) {
            //현재 상태에서 아직 듣지 않았고, 들을 수 있는 과목을 추출한다.
            int subject=term[thisTerm][i];
            if ((curTaken & (1 << subject)) == 0 && (curTaken & subjects[subject]) == subjects[subject]) {
                canListen |= (1 << subject);
            }
        }

        for (int take = canListen; take > 0; take = ((take - 1) & canListen)) {
            if (Integer.bitCount(take) > L) continue;
            cache[thisTerm][curTaken] = Math.min(cache[thisTerm][curTaken], graduate(cache, subjects, term, thisTerm + 1, curTaken | take) + 1);
        }
        cache[thisTerm][curTaken] = Math.min(cache[thisTerm][curTaken], graduate(cache, subjects, term, thisTerm + 1, curTaken));
        return cache[thisTerm][curTaken];
    }
}

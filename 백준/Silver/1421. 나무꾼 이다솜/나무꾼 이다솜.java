import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,C,W;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        tree = new int[N];
        int startLen = 1;
        int lastLen = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(br.readLine());
            lastLen = Math.max(lastLen, tree[i]);
        }

        long ans = Long.MIN_VALUE;
        for(int i=startLen;i<=lastLen;i++) {
            ans = Math.max(ans, earn(i));
        }

        System.out.println(ans);
    }

    static Long earn(int len){
        Long ret = Integer.toUnsignedLong(0);

        for(int i=0;i<N;i++){
            if(tree[i] < len) continue;

            long tmp = Integer.toUnsignedLong(0);

            tmp += (long) (tree[i] / len) * W * len;
            tmp -= (long) (tree[i] / len) * C;

            if(tree[i]%len==0){
                tmp += C;
            }

            if(tmp>0) ret+=tmp;
        }

        return ret;
    }
}
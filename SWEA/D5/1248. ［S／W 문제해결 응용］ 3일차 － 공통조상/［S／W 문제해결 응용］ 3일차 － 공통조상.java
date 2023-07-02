import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static int T, V, E, A, B, commonAncestor, sizeOfSubTree;
    private static Set<Integer> aSet, bSet;
    private static int[][] link;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            link = new int[10001][2];
            aSet = new HashSet<>();
            bSet = new HashSet<>();

            //입력
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < E; j++) {
                int parent = Integer.parseInt(st.nextToken());
                if (link[parent][0] == 0) {
                    link[parent][0] = Integer.parseInt(st.nextToken());
                } else {
                    link[parent][1] = Integer.parseInt(st.nextToken());
                }
            }

            boolean iter = true;
            while (iter) {
                int aParent = findParent(A);
                aSet.add(aParent);
                A = aParent;

                int bParent = findParent(B);
                bSet.add(bParent);
                B = bParent;

                Set<Integer> newASet = aSet.stream()
                        .map(Integer::new)
                        .collect(Collectors.toSet());
                newASet.retainAll(bSet);
                if (newASet.size() > 0) {
                    List<Integer> collect = newASet.stream()
                            .map(Integer::new)
                            .collect(Collectors.toList());
                    commonAncestor = collect.get(0);
                    iter = false;
                }
            }

            sizeOfSubTree = 0;
            countSizeOfSubTree(commonAncestor);
            sizeOfSubTree += 1;

            sb.append("#").append(i).append(" ").append(commonAncestor).append(" ").append(sizeOfSubTree).append("\n");
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int findParent(int child) {
        for (int i = 1; i <= V; i++) {
            if (link[i][0] == child) {
                return i;
            } else if (link[i][1] == child) {
                return i;
            }
        }

        return 0;
    }

    private static void countSizeOfSubTree(int parent) {
        int[] children = link[parent];
        for (int i = 0; i < children.length; i++) {
            if (children[i] != 0) {
                sizeOfSubTree += 1;
                countSizeOfSubTree(children[i]);
            }
        }
    }
}
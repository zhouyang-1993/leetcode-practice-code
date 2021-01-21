package leetcode.editor.cn;

import java.util.*;

public class SmallestStringWithSwaps{

    public static void main(String[]args){
        Solution solution= new SmallestStringWithSwaps().new Solution();

        List<Integer> a1 = new ArrayList<>();
        a1.add(0);
        a1.add(3);
        List<Integer> a2 = new ArrayList<>();
        a2.add(1);
        a2.add(2);
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(a1);
        pairs.add(a2);
        solution.smallestStringWithSwaps("dcab",pairs);
    }
    
    //NO.1202
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            DisjointSetUnion dsu = new DisjointSetUnion(s.length());
            for (List<Integer> pair : pairs) {
                dsu.unionSet(pair.get(0), pair.get(1));
            }
            Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
            for (int i = 0; i < s.length(); i++) {
                int parent = dsu.find(i);
                if (!map.containsKey(parent)) {
                    map.put(parent, new ArrayList<Character>());
                }
                map.get(parent).add(s.charAt(i));
            }
            for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
                Collections.sort(entry.getValue(), new Comparator<Character>() {
                    public int compare(Character c1, Character c2) {
                        return c2 - c1;
                    }
                });
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                int x = dsu.find(i);
                List<Character> list = map.get(x);
                sb.append(list.remove(list.size() - 1));
            }
            return sb.toString();
        }
    }

    class DisjointSetUnion {
        int[] f;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            rank = new int[n];
            Arrays.fill(rank, 1);
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public void unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 并查集 数组 
// 👍 199 👎 0

}
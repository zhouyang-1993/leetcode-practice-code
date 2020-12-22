package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams{

    public static void main(String[]args){
        Solution solution= new GroupAnagrams().new Solution();
    }
    
    //NO.49
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /*
         * The key to solving this problem is how to make sure that two words have the same element.
         */
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<Long,List<String>> map = new HashMap<>(16);

            for(int i = 0; i < strs.length; i ++){
                String s = strs[i];
                long key = makeKey2(s);

                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(s);

                map.put(key, list);
            }
            List<List<String>> listList = new ArrayList<>();
            for(List<String> stringList : map.values()){
                listList.add(stringList);
            }
            return listList;
        }

        private String makeKey(String s){

            if(s.length() <= 0){
                return "";
            }
            char[] chars = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            int elementCount = 0;
            for(char c = 'a'; c < 'z' + 1; c++){
                int countC = 0;
                for(int i = 0; i < s.length(); i++){
                    if(chars[i] == c){
                        countC ++;
                    }
                }
                if(countC > 0){
                    stringBuilder.append(c).append(countC);
                    elementCount ++;
                }
                if(elementCount >= s.length()){
                    break;
                }
            }
            return stringBuilder.toString();
        }

        int[] weight = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41
                , 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

        private long makeKey2(String s){
            long hashcode = 1;
            for(char c : s.toCharArray()){
                hashcode *= weight[c - 'a'];
            }
            return hashcode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 595 👎 0

}
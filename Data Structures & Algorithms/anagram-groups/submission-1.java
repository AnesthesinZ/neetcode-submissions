class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return List.of();
        }

        Map<String, List<String>> resultMap = new HashMap<>();

        for (String str: strs) {
            int[] freqMap = new int[26];

            // build the freq map
            for (int i = 0; i < str.length(); i++) {
                freqMap[str.charAt(i) - 'a'] ++;
            }

            // construct a key for anagram
            StringBuilder sb = new StringBuilder();
            for (int freq : freqMap) {
                sb.append("#");
                sb.append(freq);
            }
            List<String> group = resultMap.computeIfAbsent(sb.toString(), t-> new ArrayList<>());
            group.add(str);
        }

        return new ArrayList<>(resultMap.values());
    }
}

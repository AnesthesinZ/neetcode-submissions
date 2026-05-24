class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        //hello, world
        //5#hello5#world

        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int strLen = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + strLen + 1));
            i = j + strLen + 1;
        }

        return result;

    }
}

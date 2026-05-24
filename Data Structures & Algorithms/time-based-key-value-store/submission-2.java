class TimeMap {

    class Entry {
        String value;
        int timestamp;

        public Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Entry>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<Entry> lst = map.computeIfAbsent(key, v-> new ArrayList<>());
        lst.add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> lst = map.get(key);

        if (lst.isEmpty()) {
            return "";
        }
        int l = 0;
        int r = lst.size() - 1;
        String res = "";

        while (l <= r) {
            int mid = (l + r) / 2;

            Entry midEntry = lst.get(mid);
            if (midEntry.timestamp > timestamp) {
                r = mid - 1;
            } else {
                res = midEntry.value;
                l = mid + 1;
            }
        }

        return res;
    }
}

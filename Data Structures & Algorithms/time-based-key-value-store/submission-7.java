class TimeMap {
    // We use two parallel lists to save memory 🧠
    // map.get(key).get(0) returns the List of Timestamps
    // map.get(key).get(1) returns the List of Values
    Map<String, List<Object>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<Object> pair = new ArrayList<>();
            pair.add(new ArrayList<Integer>()); // Index 0: Timestamps ⏱️
            pair.add(new ArrayList<String>());  // Index 1: Values 💬
            map.put(key, pair);
        }
        
        ((List<Integer>) map.get(key).get(0)).add(timestamp);
        ((List<String>) map.get(key).get(1)).add(value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Integer> times = (List<Integer>) map.get(key).get(0);
        List<String> values = (List<String>) map.get(key).get(1);

        // Quick check: if the target is earlier than our first record
        if (times.get(0) > timestamp) return "";

        // Binary Search 🔍
        int l = 0, r = times.size() - 1;
        int ans = -1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (times.get(mid) <= timestamp) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans == -1 ? "" : values.get(ans);
    }
}
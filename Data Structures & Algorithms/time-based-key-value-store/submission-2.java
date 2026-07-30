class Pair{
    String val;
    int time;
    public Pair(String val, int time){
        this.val = val;
        this.time = time;
    }
}
class TimeMap {
    Map<String, List<Pair>> map;
    int time;
    public TimeMap() {
        map = new HashMap<>();
        time = 0;
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<Pair> list = map.get(key);
            list.add(new Pair(value, timestamp));
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(value, timestamp));
            map.put(key, list);
        }
        time = Math.max(time,timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int ans = -1;
        int low = 0, high = list.size()-1;
        while(low <=high){
            int mid = low+(high-low)/2;
            if(list.get(mid).time <= timestamp){
                ans = Math.max(ans, mid);
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans == -1 ? "" : list.get(ans).val;
    }
}

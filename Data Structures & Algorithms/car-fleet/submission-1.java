class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i<position.length; i++){
            map.put(position[i], (double)(target-position[i])/speed[i]);
        }

        double currSlowest = 0;
        int ans = 0;
        for(int i: map.keySet()){
            double time = map.get(i);
            if(time > currSlowest){
                currSlowest = time;
                ans++;
            }
        }
        return ans;
    }
}

class CountSquares {
    Map<List<Integer>, Integer> count;
    List<List<Integer>> points;
    public CountSquares() {
        count = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> list = Arrays.asList(point[0], point[1]);
        count.put(list, count.getOrDefault(list,0) +1);
        points.add(list);
    }
    
    public int count(int[] point) {
        int ans = 0;
        int px = point[0], py = point[1];
        for(List<Integer> p : points){
            int x = p.get(0), y = p.get(1);
            if(Math.abs(py-y) != Math.abs(px-x) || (x == px || y == py)){
                continue;
            } 
            ans+= count.getOrDefault(Arrays.asList(x, py), 0) * count.getOrDefault(Arrays.asList(px, y),0);
        }
        return ans;
    }
}

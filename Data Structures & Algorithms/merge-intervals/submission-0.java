class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int[] curr : intervals){
            int start = curr[0];
            int end = curr[1];
            int listEnd = list.get(list.size()-1)[1];

            if(start <= listEnd){
                list.get(list.size()-1)[1] = Math.max(listEnd, end);
            } else {
                list.add(new int[]{start, end});
            }
        }
        return list.toArray(new int[list.size()][]);
        
    }
}

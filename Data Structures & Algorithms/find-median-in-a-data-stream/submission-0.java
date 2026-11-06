class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        if(small.size() - large.size() >1 || (!large.isEmpty() && small.peek() > large.peek())){
            large.offer(small.poll());
        }
        if(large.size() - small.size() >1){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        int len = small.size()+large.size();
        if(len %2 == 0) return (double)(small.peek()+large.peek()) /2;
        else if (small.size() > large.size()) return (double)small.peek();
        else return (double)large.peek();
    }
}

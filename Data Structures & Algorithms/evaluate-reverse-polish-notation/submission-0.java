class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<tokens.length; i++){
            String curr = tokens[i];
            if(isNum(curr)){
                stack.push(Integer.parseInt(curr));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int res = 0;
                switch(curr){
                    case("+"):
                        res = b+a;
                        stack.push(res);
                        break;
                    
                    case("-"):
                        res = b-a;
                        stack.push(res);
                        break;
                    
                    case("*"):
                        res = b*a;
                        stack.push(res);
                        break;
                    
                    case("/"):
                        res = b/a;
                        stack.push(res);
                        break;
                    
                }
            }
        }
        return stack.peek();
    }
    public boolean isNum(String s){
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/");
    }
}

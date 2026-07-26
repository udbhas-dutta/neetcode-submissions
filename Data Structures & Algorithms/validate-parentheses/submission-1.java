class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isOpening(c)) stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                else if(isMatching(stack.peek(), c)) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
    public boolean isOpening(char c){
        return c == '[' || c == '{' || c == '(';
    }
    public boolean isMatching(char a, char b){
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}

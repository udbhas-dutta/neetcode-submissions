class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int[] ans = new int[num1.length() + num2.length()];

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for(int i = 0; i<num1.length(); i++){
            for(int j = 0; j<num2.length(); j++){
                int digit = (num1.charAt(i) -'0') * (num2.charAt(j) -'0');
                ans[i+j] += digit;
                ans[i+j+1] += ans[i+j] /10;
                ans[i+j]%=10;
            }
        }
        StringBuilder res = new StringBuilder();
        int i = ans.length-1;
        while(i>=0 && ans[i] == 0){
            i--;
        }
        while(i >=0){
            res.append(ans[i]);
            i--;
        }
        return res.toString();
    }
}

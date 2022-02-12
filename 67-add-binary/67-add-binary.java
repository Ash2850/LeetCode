class Solution {
    public String addBinary(String a, String b) {
        
        if(a.length() < b.length()){
          return addBinary(b, a);
        }
        Helper helper = new Helper();
        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        char[] o = new char[c.length+1];
        char carry = '0';
        char[] res = new char[2];
        int i;
        for(i = 0; i < d.length; i++){
            res = helper.sum(c[c.length-1-i], d[d.length-1-i], carry);
            carry = res[0];
            o[o.length-1-i] = res[1];
        }
        
        for(int j = i; j < c.length; j++){
            res = helper.sum(c[c.length-1-j], '0', carry);
            carry = res[0];
            o[o.length-1-j] = res[1];
        }
        o[0] = carry;
        if(carry == '1') return new String(o);
        else {
            return new String(o).substring(1);
        }
    }
}

class Helper {
    public char[] sum(char n1, char n2, char carry){
        String r1;
        if(n1 == '1' && n2 == '1'){
            if(carry == '0'){
                r1 = "10";
            }
            else r1 = "11";
        }
        else if(n1 == '0' && n2 == '0'){
            if(carry == '0'){
                r1 = "00";
            }
            else r1 = "01";
        }
        else{
            if(carry == '0'){
                r1 = "01";
            }
            else r1 = "10";
        }
        return r1.toCharArray();
    }
}
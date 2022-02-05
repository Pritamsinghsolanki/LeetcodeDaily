class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) == '1' ? 1 : 0;
            if (j >= 0)
                sum += b.charAt(j--) == '1' ? 1 : 0;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}

class Solution {
    public String addBinary(String a, String b) {
        return new java.math.BigInteger(a, 2) // parse from string a
                .add(new java.math.BigInteger(b, 2)) // parse from string b
                .toString(2);
    }
}
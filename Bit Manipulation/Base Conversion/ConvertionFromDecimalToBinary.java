/*
Given a (decimal - e.g. 3.72) number that is passed in as a string, 
return the binary representation that is passed in as a string. 
If the fractional part of the number can not be represented accurately 
in binary with at most 32 characters, return ERROR.
*/

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // split into two halves
        String[] split = n.split("\\.");
        //deal with first half;
        int first = Integer.parseInt(split[0]);
        String result = "";
        while (first > 0) {
            int temp = first;
            if (((first >> 1) << 1) == temp) {
                result = "0" + result;
            } else {
                result = "1" + result;
            }
            first = first >> 1;
        }
        //deal with the second half
        int bit = 2;
        String secondStr = "0."+split[1];
        double second = Double.parseDouble(secondStr);
        String secondRes = "";
        
        while (second > 0) {
            if (secondRes.length() > 32) {
                return "ERROR";
            }
            double diff = Double.parseDouble(secondStr) - ((double)1/bit);
            if (diff >= 0) {
                secondRes += "1";
                secondStr = Double.toString(diff);
            } else {
                secondRes += "0";
            }
            bit = bit << 1;
            second = Double.parseDouble(secondStr);
        }
        
        if (secondRes.equals("") && result.equals("")){
            return "0";
        } else if (result.equals("")){
            return "0."+secondRes;
        } else if (secondRes.equals("")) {
            return result;
        }
        return result + "." + secondRes;
    }
}
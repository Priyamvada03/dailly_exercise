// class Solution {
//    public int rever(int x){
// 		long r = 0;
// 		while(x != 0){
// 			r = r*10 + x%10;
// 			x /= 10;
// 		}
// 		if(r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE)
// 			return (int)r;
// 		else
// 			return 0;
// 	}
// }


class Solution {
    public int reverse(int x) {
        double ans =  0;
        while(x!=0) {
            double rem = x%10;
            ans = ans*10+rem;
            if(ans>=Integer.MAX_VALUE || ans<=Integer.MIN_VALUE ) 
                return 0;
            x =x/10;
        }
        return (int)ans;
    }
}
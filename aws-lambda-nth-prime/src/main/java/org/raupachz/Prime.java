package org.raupachz;

public class Prime {
    
    public int nth(int n) {
        int p = 2;
        
        for (int i = 0; i < n; ) {
            if (prime(p++)) {
                i++;
            }
        }
        
        return --p;
    }

    boolean prime(int p) {
        int n = (p / 2 + 1);
        for (int i = 2; i < n; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

}

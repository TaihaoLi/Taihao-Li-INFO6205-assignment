package edu.neu.coe.info6205.sort.par;

public class TEST {
    public static void main(String[] args) {
        int[] s={10,20,5,8,7,1,35,84,31,0,98};
        ParSort.sort(s, 0, s.length);
        for (Integer i:s
             ) {
            System.out.println(i);
        }

    }
}

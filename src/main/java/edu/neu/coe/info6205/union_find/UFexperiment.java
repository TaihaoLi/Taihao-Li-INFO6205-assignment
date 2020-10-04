package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFexperiment {
    public static int count(int n){
        int connections =0;
        UF h = new UF_HWQUPC(n);
        Random ran = new Random();
        while(h.components()!=1){
            int random1 = ran.nextInt(n);
            int random2 = ran.nextInt(n);
            if(h.isConnected(random1,random2)){}
            else{
                h.connect(random1,random2);
                connections++;
            }
        }


        return connections;

    }

    public static void main(String[] args) {
        int [] object={20,40,80,160,320,640,1280,2560,5120};
        int connections = 0;
        for (int k:object
             ) {
            connections=count(k);
            System.out.println("when n="+k+",making all sites connected generate "+connections+" pairs");

        }



    }

}

package edu.neu.coe.info6205.union_find;


import java.util.*;
import edu.neu.coe.info6205.util.*;

public class Uexperiment_time {
    private static int N =100;//size


    //get valid list and connect them
    public static void counttwoloops(List<Integer[]> list) {

        WQUPC wqupc=new WQUPC(N);
        for (Integer[] x : list) {
            if (wqupc.count()== 1) {
                break;
            }
            int random1 = x[0];
            int random2 = x[1];
            if (wqupc.connected(random1, random2)) {

            } else {
                wqupc.union(random1, random2);
            }


        }

    }


    public static void countgrandpa(List<Integer[]> list){

        WQUPC_grandparent wqupcgp=new WQUPC_grandparent(N);
        for (Integer[] x : list) {
            if (wqupcgp.count()== 1) {
                break;
            }
            int random1 = x[0];
            int random2 = x[1];
            if (wqupcgp.connected(random1, random2)) {

            } else {
                wqupcgp.union(random1, random2);
            }


        }



        return;

    }
    public static void WQU_Sizetimer(List<Integer[]> list){
        WQU_Size wqusize=new WQU_Size(N);
        for (Integer[] x : list) {
            if (wqusize.count()== 1) {
                break;
            }
            int random1 = x[0];
            int random2 = x[1];
            if (wqusize.connected(random1, random2)) {

            } else {
                wqusize.union(random1, random2);
            }


        }
    }
    public static void WQU_Highttimer(List<Integer[]> list){
        WQU_Hight wquhight=new WQU_Hight(N);
        for (Integer[] x : list) {
            if (wquhight.count()== 1) {
                break;
            }
            int random1 = x[0];
            int random2 = x[1];
            if (wquhight.connected(random1, random2)) {

            } else {
                wquhight.union(random1, random2);
            }


        }
    }
    //generate random pair number
    public static Integer[] randompair(){
        Random ran = new Random();

        int random1 = ran.nextInt(N);
        int random2 = ran.nextInt(N);
        Integer[] I={random1,random2};
        return I;


    }
    //generate random list
    public static List<Integer[]> pairset(int n){
        UF wo = new UF_HWQUPC(n,false);

        List<Integer[]> list=new ArrayList<>();
        while(wo.components()!=1){
            Integer[] preNumber=randompair();
            int random1=preNumber[0];
            int random2=preNumber[1];
            if(wo.isConnected(random1,random2)){
                list.add(preNumber);
            }else{
                wo.connect(random1,random2);
                list.add(preNumber);
            }


        }


        return list;
    }

    public static void main(String[] args) {
        int[] object={1600,3200,6400,12800,25600};





        for (int n:object
             ) {
            N=n;


            List<Integer[]> reallist = pairset(N);
            int x = reallist.size();

/* for question1
            Benchmark< List > bmSize = new Benchmark_Timer<>(
                    "",
                    null
                    ,
                    t -> {
                        WQU_Sizetimer(t);
                    }, null);

            Benchmark< List > bmHight = new Benchmark_Timer<>(
                    "",
                    null
                    ,
                    t -> {
                        WQU_Highttimer(t);
                    }, null);

            double timesize = bmSize.run(reallist, 1000);
            double timehight = bmHight.run(reallist, 1000);
             System.out.println("WQU with size:"+x+" union-find operations on a set of "+N+" objects,average time:"+timesize);
            System.out.println("WQU with height:"+x+" union-find operations on a set of "+N+" objects,average time:"+timehight);
            System.out.println("");
         */

        Benchmark< List > bmtwo = new Benchmark_Timer<>(
                "",
                null
                ,
                t -> {
                    counttwoloops(t);
                }, null);


            //test weighted quick union without path compression

            Benchmark<List> bmgp = new Benchmark_Timer<>(
                    "",
                    null
                    ,
                    t -> {
                        countgrandpa(t);
                    }, null);
            double timetwo = bmtwo.run(reallist, 1000);
            double timegp = bmgp.run(reallist, 1000);






            System.out.println("WQUPC with Twoloops:"+x+" union-find operations on a set of "+N+" objects,average time:"+timetwo);
            System.out.println("WQUPC with Grandparent:"+x+" union-find operations on a set of "+N+" objects,average time:"+timegp);
            System.out.println("");








    }}

}

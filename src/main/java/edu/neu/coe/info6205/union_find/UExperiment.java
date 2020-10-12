package edu.neu.coe.info6205.union_find;

import java.security.PrivateKey;
import java.util.*;

import edu.neu.coe.info6205.util.*;

public class UExperiment {
    private static int N =100;//size


    //get valid list and connect them （weighted quick union with path compression)
    public static void countt(List<Integer[]> list) {

        UF pc = new UF_HWQUPC(N,true);
        for (Integer[] x : list) {
            if (pc.components() == 1) {
                break;
            }
            int random1 = x[0];
            int random2 = x[1];
            if (pc.isConnected(random1, random2)) {

            } else {
                pc.connect(random1, random2);
            }

        }

    }
    //get valid list and connect them （weighted quick union without path compression)

    public static void countf(List<Integer[]> list){

        UF wo = new UF_HWQUPC(N,false);
        for (Integer[] x : list) {
            if (wo.components() == 1) {
                break;
            }
            int random1 = x[0];
            int random2 = x[1];
            if (wo.isConnected(random1, random2)) {

            } else {
                wo.connect(random1, random2);
            }
        }



        return;

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

        for (int n:object) {
            N=n;


        List<Integer[]> reallist = pairset(N);
        int listsize= reallist.size();

/*for question 1
        WQU_Hight wquhight=new WQU_Hight(N);
        for (Integer[] x : reallist) {
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
        double wquhightdepth= wquhight.countdepth();

            WQU_Size wqusize=new WQU_Size(N);
            for (Integer[] x : reallist) {
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
            double sizedepth= wqusize.countdepth();




        System.out.println("WQU with size:"+listsize+" union-find operations on a set of "+N+" objects,average depth:"+sizedepth);
        System.out.println("WQU with Hight:"+listsize+" union-find operations on a set of "+N+" objects,average depth:"+wquhightdepth);
            System.out.println("");
*/
//for question2
            WQUPC wqupc=new WQUPC(N);
            for (Integer[] x : reallist) {
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
            double wqupcdepth= wqupc.countdepth();

            WQUPC_grandparent wqupcgp=new WQUPC_grandparent(N);
            for (Integer[] x : reallist) {
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
            double wqupcgpdepth= wqupcgp.countdepth();




            System.out.println("WQUPC with Twoloops:"+listsize+" union-find operations on a set of "+N+" objects,average depth:"+wqupcdepth);
            System.out.println("WQUPC with Grandparent:"+listsize+" union-find operations on a set of "+N+" objects,average depth:"+wqupcgpdepth);
            System.out.println("");


        }




    }

}

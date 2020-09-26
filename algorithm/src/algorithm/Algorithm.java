/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import edu.neu.coe.info6205.sort.simple.*;
import edu.neu.coe.info6205.sort.*;
import edu.neu.coe.info6205.util.*;
import java.util.Arrays;
/**
 *
 * @author Homecomputer1
 */
public class Algorithm {
    
 /**
 *
 * copy the target array(preFunction)
 */
   public static Integer[] Copy(Integer[] xs){
       
       return Arrays.copyOf(xs, xs.length);   
}
 /**
 *
 * Generate random array
 */
   
   public static Integer[]  gennerateArray(int len,int max){
			Integer[] arr=new Integer[len];
			for(int i=0;i<arr.length;i++){
				arr[i]=(int)(Math.random()*max);
			}
                       return arr;
   }
   
   /**
 *
 * reverse array
 */
   
    public static void reverse(Integer[] integer) {
        int head=0;
        int tail = integer.length-1;
        int temp;
        while (head<tail) {
            temp = integer[head];
            integer[head] = integer[tail];
            integer[tail] = temp;
            head++;
            tail--;
        }
    }
   
   
    public static void main(String[] args) {
        
         InsertionSort insertsort = new InsertionSort();
         // Initialize random array
         int n =3200;//change n value to control the array
         int from =1;
       Integer[]arr=gennerateArray(n,10000);
	int to = arr.length;
        //warmed up for 10 times by copy array of target;
         Integer [] copyarray = Copy(arr);
         //for (int k=0;k<copyarray.length;k++){
       // System.out.print(copyarray[k]+" ");}
         for(int i=0;i<10;i++){
              insertsort.sort(copyarray,from,to);     
         }
        //timer
        int nRuns = 50;

        Benchmark<Integer []> bm = new Benchmark_Timer<>(
                "",t -> {
                    return Copy(t);
                },
                t -> {
                    insertsort.sort(t, from, to);
                },null);
        double x = bm.run(arr, nRuns);
        System.out.println("n= "+n);
        System.out.println("The target is random array");
        System.out.println("mean running time "+x);
        System.out.println(" ");
        
        
        
        
        //partially-ordered array
        insertsort.sort(arr,from,to/2);
         //warmed up for 10 times by copy array of target;
         for(int i=0;i<10;i++){
              insertsort.sort(copyarray,from,to);     
         }
        //timer

        Benchmark<Integer []> bm2 = new Benchmark_Timer<>(
                "",t -> {
                    return Copy(t);
                },
                t -> {
                    insertsort.sort(t, from, to);
                },null);
        double x2 = bm2.run(arr, nRuns);
        System.out.println("n= "+n);
        System.out.println("The target is partially-ordered array");
        System.out.println("mean running time "+x2);
        System.out.println(" ");
          
        
        
        
        
        //ordered array
        insertsort.sort(arr,from,to);
       //warmed up for 10 times by copy array of target;
         for(int i=0;i<10;i++){
              insertsort.sort(copyarray,from,to);     
         }
        //timer

        Benchmark<Integer []> bm3 = new Benchmark_Timer<>(
                "",t -> {
                    return Copy(t);
                },
                t -> {
                    insertsort.sort(t, from, to);
                },null);
        double x3 = bm3.run(arr, nRuns);
        System.out.println("n= "+n);
        System.out.println("The target is ordered array");
        System.out.println("mean running time "+x3);
        System.out.println(" ");        
                
        
       //reverse-ordered array
       reverse(arr);
       //warmed up for 10 times by copy array of target;
         for(int i=0;i<10;i++){
              insertsort.sort(copyarray,from,to);     
         }
        //timer

        Benchmark<Integer []> bm4 = new Benchmark_Timer<>(
                "",t -> {
                    return Copy(t);
                },
                t -> {
                    insertsort.sort(t, from, to);
                },null);
        double x4 = bm4.run(arr, nRuns);
        System.out.println("n= "+n);
        System.out.println("The target is reverse-ordered array");
        System.out.println("mean running time "+x4);
        System.out.println(" ");        
         
        
        
        
      
      
      
     
      
       
    
}}


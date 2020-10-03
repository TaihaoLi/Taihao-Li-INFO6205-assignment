package edu.neu.coe.info6205.union_find;

public class UFexperiment {
    public static int count(int n){
        int connections =0;
        UF h = new UF_HWQUPC(n);

        for (int i = 0; i < n; i++) {
            if(h.components()==1){
                break;
            }
            for (int j = i+1; j <n; j++) {
                if(h.components()==1){
                    break;
                }
                if(h.isConnected(i,j)){}
                    else{
                        h.connect(i,j);
                        connections++;
                }



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

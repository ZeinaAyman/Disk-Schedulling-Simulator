/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskschedullingsimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Functions {
    
    //Globals
    
    Scanner sq = new Scanner(System.in);
   public int total;
     
    public void requests(int[] req,int size,int bound){

        for(int iq=0; iq<size; iq++){
            do{
                req[iq] = sq.nextInt();
                if(req[iq] >= bound || req[iq] < 0){
                     System.out.println("Invalid input, request must be within the boundary limit");
                }
            }while(req[iq] >= bound || req[iq] < 0);
        }
    }
     
        public int FCFS(int[] req,int initial,int size){
        total = 0;
        ArrayList<Integer> sequence = new ArrayList<Integer>(size);
        total = Math.abs(initial - req[0]);
        sequence.add(req[0]);
        for(int it=1;it< size;it++){
            total += Math.abs(req[it] - req[it-1]);
            sequence.add(req[it]);
        }
        
       System.out.println("Sequence: ");
       System.out.println(sequence.toString());
       return total;
    }
      
      
      
   public int SCAN(int[] scn,int initial,int size,int direction,int bound){
        total = 0;
        int brk = 0;
        int g = 0;
        ArrayList<Integer> sequence = new ArrayList<Integer>(size);
        Arrays.sort(scn);
        if(direction == 1){
            //left
            for(int ib=0; ib<= size-1; ib++){
                if(initial <= scn[ib] && brk == 0){
                    total += Math.abs(initial - scn[ib-1]);
                    sequence.add(scn[ib-1]);
                    for(int jt=ib-1; jt >= 0; jt--){
                        if(jt == 0){
                            total += Math.abs(scn[jt] - 0);
                            sequence.add(0);
                            total += Math.abs(scn[ib] - 0);
                            sequence.add(scn[ib]);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(scn[jt] - scn[jt-1]);
                        sequence.add(scn[jt-1]);
                    }
                }else if(initial < scn[ib] && total != 0){
                    total += Math.abs(scn[ib-1] - scn[ib]);
                    sequence.add(scn[ib]);
                }
            }
            System.out.println("Sequence: ");
            System.out.print(sequence.toString());
          return total;
        }
        else{
            //right
            total = 0;
            brk = 0;
            for(int im=size-2; im>=0;im--){
                 if(initial >= scn[im] && brk == 0){ //i = 1
                    total += Math.abs(initial - scn[im+1]);
                    sequence.add(scn[im+1]);
                    for(int jo=im+1; jo<=size-1;jo++){ //j = 2
                        if(jo == size-1){
                            total += Math.abs(scn[jo] - bound);
                            sequence.add(bound);
                            total += Math.abs(scn[im] - bound);
                            sequence.add(scn[im]);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(scn[jo] - scn[jo+1]);
                        sequence.add(scn[jo+1]);
                    }
                }else if(initial > scn[im+1]){
                    total += Math.abs(scn[im+1] - scn[im]);
                    sequence.add(scn[im]);
                }
            }
            System.out.println("Sequence: ");
            System.out.print(sequence.toString());
            return total;          
        }
    }
}

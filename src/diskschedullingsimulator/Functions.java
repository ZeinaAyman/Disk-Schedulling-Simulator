/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskschedullingsimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

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
   
   public int CSCAN(int[] cscn,int initial,int size,int direction,int bound){
        total = 0;
        int brk = 0;
        ArrayList<Integer> sequence = new ArrayList<Integer>(size);
        Arrays.sort(cscn);
        if(direction == 1){
            //left
            for(int ib=0; ib<= size-1; ib++){
                if(initial <= cscn[ib] && brk == 0){
                    total += Math.abs(initial - cscn[ib-1]);
                    sequence.add(cscn[ib-1]);
                    for(int jt=ib-1; jt >= 0; jt--){
                        if(jt == 0){
                            total += Math.abs(cscn[jt] - 0);
                            sequence.add(0);
                            total += Math.abs(bound - 0);
                            sequence.add(bound);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(cscn[jt] - cscn[jt-1]);
                        sequence.add(cscn[jt-1]);
                    }
                }else if(cscn[size-1] == cscn[ib] && total != 0){
                        total += Math.abs(cscn[ib] - bound);
                        sequence.add(cscn[ib]);
                         for(int i=ib-1; i > 0; i--)
                         {
                             if(cscn[i] <= initial)
                             {
                                 break;
                             }
                             else
                             {
                                 total += Math.abs(cscn[i] - cscn[i+1]);
                                 sequence.add(cscn[i]);
                             }
                         }

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
                 if(initial >= cscn[im] && brk == 0){ //i = 1
                    total += Math.abs(initial - cscn[im+1]);
                    sequence.add(cscn[im+1]);
                    for(int jo=im+1; jo<=size-1;jo++){ //j = 2
                        if(jo == size-1){
                            total += Math.abs(cscn[jo] - bound);
                            sequence.add(bound);
                            total += Math.abs(0 - bound);
                            sequence.add(0);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(cscn[jo] - cscn[jo+1]);
                        sequence.add(cscn[jo+1]);
                    }
                }else if(initial > cscn[im+1] && brk == 1){
                    
                    total += Math.abs(cscn[0]-0);
                    sequence.add(cscn[0]);
                    
                    for(int i=0; i < im+1; i++)
                    {
                        total+= Math.abs(cscn[i]-cscn[i+1]);
                        sequence.add(cscn[i+1]);
                    }
                    brk = 2;
                }
                }
         }
            System.out.println("Sequence: ");
            System.out.print(sequence.toString());
            return total;      
   } 
   
    public int LOOK(int[] look,int initial,int size,int direction,int bound){
        
        total = 0;
        int brk = 0;
        ArrayList<Integer> sequence = new ArrayList<Integer>(size);
        Arrays.sort(look);
        if(direction == 1){
            //left
             for(int ib=0; ib<= size-1; ib++){
                if(initial <= look[ib] && brk == 0){
                    total += Math.abs(initial - look[ib-1]);
                    sequence.add(look[ib-1]);
                    for(int jt=ib-1; jt >= 0; jt--){
                        if(jt == 0){
                            total += Math.abs(look[jt] - look[ib]);
                            sequence.add(look[ib]);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(look[jt] - look[jt-1]);
                        sequence.add(look[jt-1]);
                    }
                }else if(initial < look[ib] && total != 0){
                    total += Math.abs(look[ib-1] - look[ib]);
                    sequence.add(look[ib]);
                }
            }
            
            
        }
        
         else{
            //right
            total = 0;
            brk = 0;
            
             for(int im=size-2; im>=0;im--){
                 if(initial >= look[im] && brk == 0){ //i = 1
                    total += Math.abs(initial - look[im+1]);
                    sequence.add(look[im+1]);
                    for(int jo=im+1; jo<=size-1;jo++){ //j = 2
                        if(jo == size-1){
                           total += Math.abs(look[jo] - look[im]); //im = 1, index 2 = 42
                           sequence.add(look[im]);
                           brk = 1;
                            break;
                        }

                        total += Math.abs(look[jo] - look[jo+1]);
                        sequence.add(look[jo+1]);
                    }
                }else if(initial > look[im+1]){
                    total += Math.abs(look[im+1] - look[im]);
                    sequence.add(look[im]);
                }
            }
        }
        
            System.out.println("Sequence: ");
            System.out.print(sequence.toString());
        return total;
}

    public int CLOOK(int[] clook,int initial,int size,int direction,int bound){
        total = 0;
        int brk = 0;
        ArrayList<Integer> sequence = new ArrayList<Integer>(size);
        Arrays.sort(clook);
        if(direction == 1){
            //left
            for(int ib=0; ib<= size-1; ib++){
                if(initial <= clook[ib] && brk == 0){
                    total += Math.abs(initial - clook[ib-1]);
                    sequence.add(clook[ib-1]);
                    for(int jt=ib-1; jt >= 0; jt--){
                        if(jt == 0){
                            total += Math.abs(clook[jt] - clook[size-1]); // jt = 0 // ib = 2
                            sequence.add(clook[size-1]);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(clook[jt] - clook[jt-1]);
                        sequence.add(clook[jt-1]);
                    }
                }else if(clook[size-1] == clook[ib] && total != 0){
                         for(int i=ib-1; i > 0; i--)
                         {
                             if(clook[i] <= initial)
                             {
                                 break;
                             }
                             else
                             {
                                 total += Math.abs(clook[i] - clook[i+1]);
                                 sequence.add(clook[i]);
                             }
                         }

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
                 if(initial >= clook[im] && brk == 0){ //i = 1
                    total += Math.abs(initial - clook[im+1]);
                    sequence.add(clook[im+1]);
                    for(int jo=im+1; jo<=size-1;jo++){ //j = 2
                        if(jo == size-1){
                            total += Math.abs(clook[jo] - clook[0]);
                            sequence.add(clook[0]);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(clook[jo] - clook[jo+1]);
                        sequence.add(clook[jo+1]);
                    }
                }else if(initial > clook[im+1] && brk == 1){
                    
                    for(int i=0; i < im+1; i++)
                    {
                        total+= Math.abs(clook[i]-clook[i+1]);
                        sequence.add(clook[i+1]);
                    }
                    brk = 2;
                }
                }
         }
            System.out.println("Sequence: ");
            System.out.print(sequence.toString());
            return total;      
   } 





public int SSTF(ArrayList<Integer> sstf,int initial,int size,int direction,int bound){
        total = 0;
        int curr = initial;
        int max = 0;
        int min = 0;
        ArrayList<Integer> sequence = new ArrayList<Integer>(size);
        Collections.sort(sstf);
        int first = sstf.get(0);
        int last = sstf.get(size-1);
        for(int i=0; i<=size-1; i++)
        {
            if(curr < sstf.get(i+1))
            {
                if((curr - sstf.get(i)) < (sstf.get(i+1) - curr))
                {
                    total += curr - sstf.get(i);
                    sequence.add(sstf.get(i));
                    curr = sstf.get(i);
                    min  = i-1;
                    max = i;
                    sstf.remove(sstf.get(i));
                    break;
                    
                }
                else
                {
                    total += sstf.get(i+1) - curr;
                    sequence.add(sstf.get(i+1));
                    curr = sstf.get(i+1);
                    min  = i;
                    max = i + 1;
                    sstf.remove(sstf.get(i+1));
                    break;
                }
                //total += Math.min((initial - sstf.indexOf(i)),(sstf.indexOf(i+1) - initial));
            }
        }
        
        for(int j=0; j<=size-1;j++)
        {
            if(curr == first){
                total += sstf.get(0) - first;
                sequence.add(sstf.get(0));
                for(int u = 0; u<sstf.size()- 1; u++)
                {
                    total += sstf.get(u+1) - sstf.get(u);
                    sequence.add(sstf.get(u+1));
                    
                }
                break;
            }
            else if(curr == last){
                total += last - sstf.get(sstf.size()-1);
                sequence.add(sstf.get(sstf.size()-1));
                for(int u = sstf.size()- 1; u>0; u--)
                {
                    total += sstf.get(u) - sstf.get(u-1);
                    sequence.add(sstf.get(u-1));
                }
                break;
            }
            else if((curr - sstf.get(min)) < (sstf.get(max) - curr))
                {
                    total += curr - sstf.get(min);
                    sequence.add(sstf.get(min));
                    curr = sstf.get(min);
                    sstf.remove(sstf.get(min));
                    max = min;
                    min  = min-1;
                }
                else
                {
                    total += sstf.get(max) - curr;
                    sequence.add(sstf.get(max));
                    curr = sstf.get(max);
                    sstf.remove(sstf.get(max));
                    min  = max - 1;
                    //max = max;
                }
                //total += Math.min((initial - sstf.indexOf(i)),(sstf.indexOf(i+1) - initial));
            }
 
           
        
            System.out.println("Sequence: ");
            System.out.print(sequence.toString());
            return total; 
    }
}



//VALIDATION LAW EL INITIAL MAWGOOD MA3ANA FIL REQUESTS
//LAW EL INITIAL BE 0
// LWA EL INITIAL BEL BOUND
//OPTIMIZE REPITITIONS: SEQUENCE, SORT, ETC.
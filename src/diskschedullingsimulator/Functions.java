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
    
    Scanner s = new Scanner(System.in);
   public int total;
     
    public void requests(int[] req,int size,int bound){
        
        for(int i=0; i<size; i++){
            do{
                req[i] = s.nextInt();
                if(req[i] >= bound){
                     System.out.println("You can't exceed the limit");
                }
            }while(req[i] >= bound);
        }
    }
     
        public int FCFS(int[] req,int initial,int size){
        int total = 0;
        ArrayList<Integer> sequence = new ArrayList<Integer>(size);
        total = Math.abs(initial - req[0]);
        sequence.add(req[0]);
        for(int i=1;i< size;i++){
            total += Math.abs(req[i] - req[i-1]);
            sequence.add(req[i]);
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
            for(int i=0; i<= size-1; i++){
                if(initial <= scn[i] && brk == 0){
                    total += Math.abs(initial - scn[i-1]);
                    sequence.add(scn[i-1]);// i = 3
                    for(int j=i-1; j >= 0; j--){
                        if(j == 0){
                            total += Math.abs(scn[j] - 0);
                            sequence.add(0);
                            total += Math.abs(scn[i] - 0);
                            sequence.add(scn[i]);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(scn[j] - scn[j-1]);
                        sequence.add(scn[j-1]);
                    }
                }else if(initial < scn[i] && total != 0){
                    total += Math.abs(scn[i-1] - scn[i]);
                    sequence.add(scn[i]);
                }
            }
            System.out.println("Sequence: ");
            System.out.println(sequence.toString());
          return total;
        }
        else{
            //right
            total = 0;
            brk = 0;
            for(int i=size-2; i>=0;i--){ //law size-1 hayeb2a fi index out of bounds 3shan else if condition
                 if(initial >= scn[i] && brk == 0){ //i = 1
                    total += Math.abs(initial - scn[i+1]);
                    sequence.add(scn[i+1]);
                    for(int j=i+1; j<=size-1;j++){ //j = 2
                        if(j == size-1){
                            total += Math.abs(scn[j] - bound);
                            sequence.add(bound);
                            total += Math.abs(scn[i] - bound);
                            sequence.add(scn[i]);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(scn[j] - scn[j+1]);
                        sequence.add(scn[j+1]);
                    }
                }else if(initial > scn[i+1]){ //i = 0 we take the sum of the values < initial before executing the right section
                    total += Math.abs(scn[i+1] - scn[i]);
                    sequence.add(scn[i]);
                }
            }
            System.out.println("Sequence: ");
            System.out.println(sequence.toString());
            return total;          
        }
    }
}

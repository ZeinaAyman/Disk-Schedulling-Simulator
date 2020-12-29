/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskschedullingsimulator;
import java.util.*;
/**
 *
 * @author Zeina Ayman
 */
public class DiskSchedullingSimulator {

    /**
     * @param args the command line arguments
     */
    
     public static void main(String[] args) {
        Functions p = new Functions();
        Scanner sq = new Scanner(System.in);
        int size12;
        System.out.println("--Enter Array size:--");
        do{
            size12 = sq.nextInt();
            if(size12 < 0){
                System.out.println("Array Size can't be negative. Please try again.");
            }
         }while(size12 < 0);
        
        int [] req = new int[size12];
        int bound;
        System.out.println("--Enter boundary:--");
        bound = sq.nextInt();
        
        System.out.println("--Enter the requests of the cylinder:--");
        p.requests(req,size12,bound);
   
        System.out.println("--Requests are:-- ");
        for(int iw=0; iw<size12; iw++){
            System.out.println(req[iw]); 
        }
     
        int initial;
        System.out.println("--Enter the initial position of the head:--");
        do{
            initial = sq.nextInt();
            if(initial >= bound){
                System.out.println("--You can't exceed the limit.--");
            }
         }while(initial >= bound);
        
        System.out.println("--Enter seek time per cylinder in seconds:--");
        double seek = sq.nextDouble();
        double totalSeek;
        int algo;
        int c;
        OUTER:
        do{
        
        System.out.println("Choose an algorithm: \n 1)FCFS \n 2)SCAN \n 3)C-SCAN \n 4)LOOK \n 5)C-LOOK \n 6)SSTF \n 7)Exit");
        do {
            while (!sq.hasNextInt())
            {
                String in = sq.next();
                System.out.println("Invalid input. Please try again.");
            }
            algo = sq.nextInt();
            
            //FCFS
            if(algo == 1) {
                
                    System.out.println("\n --Total Num of head movements-- = " + p.FCFS(req,initial,size12));
                    totalSeek = p.total * seek;
                    System.out.println("Total seek time = " + totalSeek);
                    
            }
            
            //SCAN
            else if (algo == 2)
            {
                int scn[];
                scn = req;
                System.out.println("Choose Direction: \n 1)Left \n 2)Right");
                    do{
                        c = sq.nextInt();
                        if (c == 1){
                            System.out.println("\n Total Num of head movements = " + p.SCAN(scn,initial,size12,1, bound));
                            totalSeek = p.total * seek;
                            System.out.println("Total seek time = " + totalSeek);
                        }
                        else if (c == 2){
                            System.out.println("\n Total Num of head movements = " + p.SCAN(scn,initial,size12,2, bound));
                            totalSeek = p.total * seek;
                             System.out.println("Total seek time = " + totalSeek);
                        }
                        else{
                            System.out.println("Invalid input. Please choose one of the following options.");
                              
                            }
                    }while(c != 1 && c != 2);
            }
            
            
            //C-SCAN
              else if (algo == 3)
            {
                int cscn[];
                cscn = req;
                System.out.println("Choose Direction: \n 1)Left \n 2)Right");
                 do{
                        c = sq.nextInt();
                        if (c == 1){
                            System.out.println("\n Total Num of head movements = " + p.CSCAN(cscn,initial,size12,1, bound));
                            totalSeek = p.total * seek;
                            System.out.println("Total seek time = " + totalSeek);
                        }
                        else if (c == 2){
                            System.out.println("\n Total Num of head movements = " + p.CSCAN(cscn,initial,size12,2, bound));
                            totalSeek = p.total * seek;
                             System.out.println("Total seek time = " + totalSeek);
                        }
                        else{
                            System.out.println("Invalid input. Please choose one of the following options.");
                              
                            }
                    }while(c != 1 && c != 2);
            }
            
              else if (algo == 4)
              {
                    int look[];
                look = req;
                System.out.println("Choose Direction: \n 1)Left \n 2)Right");
                 do{
                        c = sq.nextInt();
                        if (c == 1){
                            System.out.println("\n Total Num of head movements = " + p.LOOK(look,initial,size12,1, bound));
                            totalSeek = p.total * seek;
                            System.out.println("Total seek time = " + totalSeek);
                        }
                        else if (c == 2){
                            System.out.println("\n Total Num of head movements = " + p.LOOK(look,initial,size12,2, bound));
                            totalSeek = p.total * seek;
                             System.out.println("Total seek time = " + totalSeek);
                        }
                        else{
                            System.out.println("Invalid input. Please choose one of the following options.");
                              
                            }
                    }while(c != 1 && c != 2);
              }
            //EXIT
            else if (algo == 7)
                break OUTER;
            
            else{
                System.out.println("Invalid input. Please choose one of the following options.");
            }
            
        } while (algo != 1 && algo != 2 && algo != 3  && algo != 4  && algo != 5  && algo != 6);
        
     }while(algo != 7);
    }
}

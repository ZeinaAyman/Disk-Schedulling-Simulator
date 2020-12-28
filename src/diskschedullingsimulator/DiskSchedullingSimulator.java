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
        Scanner s = new Scanner(System.in);
        int size;
        System.out.println("Enter size of array:");
        do{
            size = s.nextInt();
            if(size < 0){
                System.out.println("Size of array can't be negative. Please try again.");
            }
         }while(size < 0);
        
        int [] req = new int[size];
        int bound;
        System.out.println("Enter the boundary:");
        bound = s.nextInt();
        
        System.out.println("Enter the requests of the cylinder:");
        p.requests(req,size,bound);
   
        System.out.println("The requests are: ");
        for(int i=0; i<size; i++){
            System.out.println(req[i]); 
        }
     
        int initial;
        System.out.println("Enter the initial position of the head:");
        do{
            initial = s.nextInt();
            if(initial >= bound){
                System.out.println("You can't exceed the limit.");
            }
         }while(initial >= bound);
        
        System.out.println("Enter seek time per cylinder in seconds:");
        double seek = s.nextDouble();
        double totalSeek;
        int algo;
        int c;
        OUTER:
        do{
        
        System.out.println("Choose an algorithm: \n 1)FCFS \n 2)SCAN \n 3)Exit");
        do {
            while (!s.hasNextInt())
            {
                String in = s.next();
                System.out.println("Invalid input. Please try again.");
            }
            algo = s.nextInt();
            if(algo == 1) {
                
                    System.out.println("Total number of head movements = " + p.FCFS(req,initial,size));
                    totalSeek = p.total * seek;
                    System.out.println("Total seek time = " + totalSeek);
                    
            }
            else if (algo == 2)
            {
                int scn[];
                scn = req;
                System.out.println("Choose Direction: \n 1)Left \n 2)Right");
                    do{
                        c = s.nextInt();
                        if (c == 1){
                            System.out.println("Total number of head movements = " + p.SCAN(scn,initial,size,1, bound));
                            totalSeek = p.total * seek;
                            System.out.println("Total seek time = " + totalSeek);
                        }
                        else if (c == 2){
                            System.out.println("Total number of head movements = " + p.SCAN(scn,initial,size,2, bound));
                            totalSeek = p.total * seek;
                             System.out.println("Total seek time = " + totalSeek);
                        }
                        else{
                            System.out.println("Invalid input. Please choose one of the following options.");
                              
                            }
                    }while(c != 1 && c != 2);
            }
            
            else if (algo == 3)
                break OUTER;
            
            else{
                System.out.println("Invalid input. Please choose one of the following options.");
            }
            
        } while (algo != 1 && algo != 2);
        
     }while(algo != 3);
    }
}


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
    
    static void requests(int[] req,int size,int bound){
        Scanner s = new Scanner(System.in);
        for(int i=0; i<size; i++){
            do{
                req[i] = s.nextInt();
                if(req[i] >= bound){
                     System.out.println("You can't exceed the limit");
                }
            }while(req[i] >= bound);
        }
    }
    
    static void FCFS(int[] req,int initial,double seek,int size){
        int total = 0;
       // if(initial > req[0])
      //  {
            total = Math.abs(initial - req[0]);
      //  }
       // else
         //   total = req[0] - initial;
        
        for(int i=1;i< size;i++){
           // if(req[i] > req[i-1])
          //  {
                total += Math.abs(req[i] - req[i-1]);
         //   }
          //  else
               // total += req[i-1] - req[i];
        }
        System.out.println(total);
    }
    
    static void SCAN(int[] scn,int initial,double seek,int size,int direction){
        int total = 0;
        Arrays.sort(scn);
        if(direction == 1){
            //left
            for(int i=0; i<size-1; i++){
                if(initial <= scn[i]){
                    total += Math.abs(initial - scn[i-1]);
                    for(int j=i-1; j >= 0; j--){
                        if(j == 0){
                            total += Math.abs(scn[j] - 0);
                            total += Math.abs(scn[i] - 0);
                            break;
                        }
                        total += Math.abs(scn[j] - scn[j-1]);
                    }
                }else if(initial >= scn[i]){
                    total += Math.abs(scn[i] - scn[i+1]);
                }
            }
            System.out.println(total);
        }
        else{
            //right
        }
    }
    
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = s.nextInt();
        int[] req = new int[size];
        //List<int[]> req = new ArrayList<int[]>(size);
        int bound;
        System.out.println("Enter the boundary");
        bound = s.nextInt();
        
        
        System.out.println("Enter the requests of the cylinder");
        requests(req,size,bound);
   
        System.out.println("the requests are: ");
        for(int i=0; i<size; i++){
            System.out.println(req[i]); 
        }
        
     
        
        System.out.println("Enter initial position of the head");
      //  int initial;
      //  int in = s.nextInt();
        int initial;
        do{
                 initial = s.nextInt();
                if(initial >= bound){
                     System.out.println("You can't exceed the limit");
                }
          }while(initial >= bound);
        
        System.out.println("Enter seek time per cylinder in millisecond");
        double seek = s.nextDouble();
        
        int c;
        int scn[] = req;
        //List<Integer> scn = new ArrayList<Integer>(size);
        scn = req;
        
         System.out.println("Choose Direction ");
         System.out.println("1)Left");
         System.out.println("2)Right");
        do{
            c = s.nextInt();
            switch (c) {
                case 1:
                    SCAN(scn,initial,seek,size,1);
                    break;
                case 2:
                    SCAN(scn,initial,seek,size,2);
                    break;
                default:
                    System.out.println("Invalid Input. Please choose one of the folowing options.");
                    System.out.println("Choose Direction ");
                    System.out.println("1)Left");
                    System.out.println("2)Right");
                    break;
            }
              
          }while(c != 1 && c != 2);

   
        
      // FCFS(req,initial,seek,size,direction);
       
         
                 
        System.out.println("Choose a scheduling Algorithm: ");
        System.out.println("1)FCFS: ");
        System.out.println("2)SCAN: ");
        System.out.println("3)Exit: ");
        
    }
    
}

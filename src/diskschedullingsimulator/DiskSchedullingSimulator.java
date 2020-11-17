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
    
    static int FCFS(int[] req,int initial,double seek,int size){
        int total = 0;
        total = Math.abs(initial - req[0]);
        
        for(int i=1;i< size;i++){
            total += Math.abs(req[i] - req[i-1]);
        }
       // System.out.println(total);
       return total;
    }
    
    static double SCAN(int[] scn,int initial,double seek,int size,int direction,int bound){
        int total = 0;
        int brk = 0;
        int g = 0;
        Arrays.sort(scn);
        if(direction == 1){
            //left
            for(int i=0; i<= size-1; i++){
                if(initial <= scn[i] && brk == 0){
                    total += Math.abs(initial - scn[i-1]); // i = 3
                    for(int j=i-1; j >= 0; j--){
                        if(j == 0){
                            total += Math.abs(scn[j] - 0);
                            total += Math.abs(scn[i] - 0);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(scn[j] - scn[j-1]);
                    }
                }else if(initial < scn[i] && total != 0){
                    total += Math.abs(scn[i-1] - scn[i]);
                }
            }
            //System.out.println(total);
           // System.out.print("Total number of head movemets: ");
            //System.out.println(size+1); // head movements
           // System.out.println("Total seek time in seconds: ");
          //  double see = total * seek;
          //  System.out.println(see);
          return total;
        }
        else{
            //right
            total = 0;
            brk = 0;
            for(int i=0; i<=size-2;i++){ //law size-1 hayeb2a fi index out of bounds 3shan else if condition
                 if(initial <= scn[i] && brk == 0){ //i = 2
                    total += Math.abs(initial - scn[i]);
                    for(int j=i; j<=size-1;j++){
                        if(j == size-1){
                            total += Math.abs(scn[j] - bound);
                            total += Math.abs(scn[i-1] - bound);
                            brk = 1;
                            break;
                        }
                        total += Math.abs(scn[j] - scn[j+1]);
                    }
                }else if(initial > scn[i+1]){ //i = 0 we take the sum of the values < initial before executing the right section
                    total += Math.abs(scn[i+1] - scn[i]);
                }
            }
            // System.out.println(total);
            return total;          
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
                    System.out.println(SCAN(scn,initial,seek,size,1,bound));
                    break;
                case 2:
                    System.out.println(SCAN(scn,initial,seek,size,2,bound));
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
        
        //yeS in here
        
    }
    
}

//Author: Alexis Navarro
//Lab 4
//Last modification: 10/11/18

//Purpose Of The Program: The purpose of this program is to be able to understand how linked lists work 
//In this program we have to read a text file and assign each line of the file into a Node of the linked list.
//Additionally we have to use the Box class that contains the contructors to allow our linked list to function,
//We also have our setters and getters that are used to accomplish certain tasks within the Runner file.
import java.util.Scanner;
import java.io.*;

 public class Runner{

//READ FILE TO LINKED LIST METHOD
    public static Box readFile(String file){
        Scanner s = null;
        try{
            s=new Scanner(new File(file));
            String line = s.nextLine();
            String[] aSplit = line.split(" ");

            Box head= new Box(Double.parseDouble(aSplit[0]),Double.parseDouble(aSplit[1]),Double.parseDouble(aSplit[2]));//create head and takes first line of txt file
            Box temp = head;//make a temp variable to not affect the head
            while(s.hasNextLine()){
               line=s.nextLine();
               aSplit =line.split(" ");
               temp.next = new Box(Double.parseDouble(aSplit[0]),Double.parseDouble(aSplit[1]),Double.parseDouble(aSplit[2]));//temp stores the 2nd line of the txt file
               temp = temp.next;//temp will then keep going onto the text file and store each line onto its own part of the list
            }//end while
            return head; 
        }catch(Exception e){
            e.printStackTrace();

        }//END CATCH
        return null;
    }//END READFILE


//FIND THE SMALLEST NUMBER IN THE LINKED LIST
    public static void smallestLL(Box head){
        if(head == null){ 
        }
        System.out.println("\nSmallest package");
        int i=0;//counter to find the position
        int k=1;//had to start at 1 to be able to get the position
        Box min = head;//starts at the head
            while(head!=null){//traverse through the list
                if(head.getVolume()<min.getVolume()){   //using head.getVolume() to compare which is the smallest package in the linked list
                    min = head;
                    i++; 
                }
                head = head.next;//proceed to the next nodes in the list 
                  k++;             
            }
            int pos = k-i;//had to do k-i because i would give me a position that is one less than where the node is
            System.out.println("position: " +pos);
            System.out.println("Dimensions of the smallest package: "+min.getWidth()+" "+min.getLength()+" "+ min.getHeight());
            System.out.println("Volume of the smallest package: "+min.getVolume());
            
    }//END SMALLESTLL


//FIND THE LARGEST NUMBER IN THE LINKED LIST
    public static void largestLL(Box head){
        if(head == null){ 
        }
        System.out.println("\nLargest Package");
        int i=0;//counter to find the position of the largest
        Box max= head;//starts at the head
        head = head.next;
            while(head!=null){
                if(head.getVolume()>max.getVolume()){
                    max = head;//the max becomes the greater head after being compared with the volume of each node
                    i++;//gets the position
                }
                head = head.next;//proceeds to the next node
                
            }
            System.out.println("position:" + i);
            System.out.println("Dimensions of the largest package: "+max.getWidth()+" "+max.getLength()+" "+ max.getHeight());
            System.out.println("Volume of the largest Package: "+max.getVolume());
        }//END SMALLESTLL


//FIND THE AMOUNT OF CUBIC PACKAGES
    public static void amountOfCubic(Box head){
        if(head == null){ 
        }
        int num=0;
        while(head!=null){
            if(head.getCubic()==true){//using head.getCubic() to be able to find a cubic node in the linked list
                num++;
                System.out.println("\nNumber of cubic packages: "+num);
            }
            head = head.next;
        }
    }//END AMOUNT OF CUBIC


//FIND THE SMALLLEST CUBIC PACKAGE
    public static void smallestCubic(Box head){
        if(head == null){ 
        }
        System.out.println("\nSmallest Cubic");
        int i=0;
        Box min = head;

        while(head!=null){
            if(head.getCubic()==true && head.getVolume()<min.getVolume()){
                min = head;
               

                System.out.println("position: " + i);
                System.out.println("Dimensions of smallest cubic package: "+ min.getWidth()+" "+min.getLength()+" "+ min.getHeight());
                System.out.println("Smallest Cubic Volume: "+min.getVolume());
            }
            head = head.next;
            i++;
        }
    }//END SMALLEST CUBIC


    //FIND THE LARGEST CUBIC PACKAGE
    public static void largestCubic(Box head){
        if(head == null){ 
        }
        System.out.println("\nLargest Cubic");
        int i=0;
        Box max = new Box();

        while(head!=null){
            if(head.getCubic()==true){
                if(head.getVolume()>=max.getVolume()){
                   // System.out.println("iffff"+max.getVolume() + "" + head.getVolume());
                max = head;
               
                System.out.println("position: " + i);
                System.out.println("Dimensions of largest cubic package: "+ max.getWidth()+" "+max.getLength()+" "+ max.getHeight());
                System.out.println("Largest Cubic Volume: "+max.getVolume());
             }
            }
            head = head.next;
            i++;
        }
    }//END LARGEST CUBIC


//PRINT PACKAGE AVERAGE VOLUME  
     public static void packageAvgVolume(Box head){
        if(head == null){ 
        }
        int i=0;
        double sum=0.0;

        while(head!=null){
           //System.out.println(i+" Avg Volume "+head.getAvgVolume()); 
            sum+=head.getVolume(); 
            head = head.next;
            i++;
        }   
        //System.out.println(sum);
        double total = sum/i;
        System.out.println("\nPackage Average Volume: "+total);
     }//END PACKAGE VOLUME


//PRINT CUBICS VOLUMES 
    public static void cubicAvgVolume(Box head){
        if(head == null){ 
        }
        int i=0;
        double sum=0.0;
        while(head!=null){
            if(head.getCubic()==true){
                sum+=head.getVolume(); 
                head = head.next;
                i++;
    
            }
            head = head.next;
        }   
        double total = sum/i;
        System.out.println("\nCubic Average Volume: "+total);
    }//END PACKAGE VOLUME

    public static void main(String[] args)throws FileNotFoundException{
        Box h = readFile("input.txt");
        //calls the methods with the input of the text file
        smallestLL(h);
        largestLL(h);
        amountOfCubic(h);
        smallestCubic(h);
        largestCubic(h);
        packageAvgVolume(h);
        cubicAvgVolume(h);     
    }//END MAIN
}//END RUNNER
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        //define low and high Bounds.
        int lower = 1;
        int upper = 100;

        //Genrate the target number.
        Random randomData =new Random();
        int target = randomData.nextInt(lower, upper+1);


        //Ask user for First input.
        System.out.printf("Guess anumber between %d and %d ",lower,upper);
        Scanner userInput = new Scanner(System.in);

        int guess; 
        int counter =0;
        do {
           guess = userInput.nextInt();
           counter++;

           if(guess > target){
              System.out.println("Guess lower");
              }
             else if (guess < target){
                    System.out.println(" Guess higher!");
                }
            } while (guess != target);

        System.out.println("Corret! It took you"+ counter+"Tries");
 
    }
}
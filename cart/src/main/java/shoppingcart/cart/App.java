package shoppingcart.cart;


import java.util.*;
import java.io.*;


/**
 * Descriptions:
 * Able to read inputs: list , add apple , delete 2
 * 3 functions -> list,add,delete
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        LinkedList<String> cart = new LinkedList<String>();

        String function = "";
        // To read the inputs
        Console cons = System.console();
        // While the user havent end the session
        while(!function.equalsIgnoreCase("end")){
            String input = cons.readLine("> ");
            String [] inputArray = input.split(" ", 2);
            function = inputArray[0].toLowerCase().trim();

            switch(function){ 
                case "add":
                    inputArray[1] = inputArray[1].replaceAll(",","");   
                    String [] addFruits = inputArray[1].split(" ");
                    for(String fruit:addFruits){
                        boolean found = false;
                        // Check the cart to check if the fruit is found in the cart
                        for(String inCart:cart){                               
                            if(fruit.equals(inCart)){
                                found = true;
                                System.out.printf("You have %s in your cart\n", fruit);
                            }
                        } 
                        //After the check, if not found add the fruit into the cart
                        if(!found){
                            cart.add(fruit);
                            System.out.printf("%s added to cart\n", fruit);
                        }
                    }
                break;

                case "list":
                    if(cart.size()<1){
                    System.out.printf("Your cart is empty\n");
                    }else {
                        int i = 1;
                        for(String fruit: cart){ 
                            System.out.printf("%d. %s\n",i++,fruit);
                            }  
                    }
                break;

                case "delete":
                int index = Integer.parseInt(inputArray[1]);
                if(0<index && index<(cart.size()+1)){
                    System.out.printf("%s removed from cart\n", cart.get(index-1));
                    cart.remove(index-1);
                }else{
                    System.out.println("Incorrect item index");
                }
                break; 
            }
        }
        System.out.println("Thank you for shopping with us");
    }
}


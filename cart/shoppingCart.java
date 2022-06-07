package cart;

import java.util.*;
import java.io.Console;

public class shoppingCart {
    public static void main(String args[]){
        System.out.println("Welcome to your Shopping Cart ");
        boolean stop = false; 
        Console cons = System.console();
        List<String> cart = new LinkedList<String>();
        int delIndex;
        String input;

        //main loop
        while(!stop){
            input = cons.readLine("> ");
            System.out.printf("READ: %s\n", input);
            String[] terms = input.split(" ");                              // to detect the space ?
            String cmd = terms[0];
            
            switch(cmd){
                case "add" :
                String fruitsStr = terms[1];
                String fruitsReplaced = fruitsStr.replace("," , " ");
                String[] fruits = fruitsReplaced.split(" ");

                    for(int i = 0; i<fruits.length; i++){                       //loop through all the items that need to be added 
                        boolean found = false;
                        for (int j = 0 ; j < cart.size(); j++){                //looping though all the items in the cart to check 
                            if((fruits[i]).toUpperCase().equals(cart.get(j).toUpperCase())){
                                found = true;
                               //System.out.printf("%s is inside the cart", terms[i]);
                                break;
                            }
                        }
                        if(!found){
                            cart.add(fruits[i]);
                            System.out.printf("Added %s to cart", fruits[i]);
                        }
                    }
                        break;
                case "list" :
                    if(cart.size()>0){
                        for(int i = 0; i< cart.size();i++){                      // loop to list out all the items 
                            System.out.printf("%d. %s\n", (i+1),cart.get(i));
                        }
                    }
                        else{
                            System.out.printf("Your cart is empty!");
                        }
                        break;
                case "del" :
                        if(terms.length<2){
                            System.out.println("Please provide an index in order to delete");

                        }else{
                            delIndex= Integer.parseInt(terms[1])-1;
                            System.out.println(delIndex);
                            if(delIndex>= 0 && delIndex<cart.size()){
                                System.out.printf("Deleted %s from cart\n", cart.get(delIndex));
                                cart.remove(delIndex);
                            }else{
                                System.out.println("No such item");
                            }
                        }
                        break;
                case "end" :
                        stop = true;
                        break;
                default:
                    }
                }
                System.out.println("Thank you for shopping with us");
        }   
        public static void displayError(){
            System.out.println("No such item to delete");
        }
           
     }
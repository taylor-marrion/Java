/* FileName: StatesDataEntry.java
 * Author: Taylor Marrion
 * Date: 10/4/2019
 * Purpose: This class will create instances of StatesDataEntry.
 */

package StatesDataEntry;

// import classes
import java.util.*;

public class StatesDataEntry {
    
    // declare fields
    private String stateName;
    private String stateBird;
    private String stateFlower;
    private int stateIndex;
    private static ArrayList<StatesDataEntry> stateList = new ArrayList<>();
    
    // 2D array of states, birds, flowers
    private final String[][] statesData = {
        {"Alabama", "Yellowhammer", "Camelia"},
        {"Alaska", "Willow Ptarmigan", "Forget Me Not"},
        {"Arizona", "Cactus Wren", "Saguaro Cactus Blossom"},
        {"Arkansas", "Mockingbird", "Apple Blossom"},
        {"California", "California Valley Quail", "Golden Poppy"},
        {"Colorado", "Lark Bunting", "Rocky Mountain Columbine"},
        {"Connecticut", "American Robin", "Mountain Laurel"},
        {"Delaware", "Blue Hen Chicken", "Peach Blossom"},
        {"Florida", "Mockingbird", "Orange Blossom"},
        {"Georgia", "Brown Thrasher", "Cherokee Rose"},
        {"Hawaii", "Nene", "Yellow Hibiscus"},
        {"Idaho", "Mountain Bluebird", "Syringa"},
        {"Illinois", "Cardinal", "Native Violet"},
        {"Indiana", "Cardinal", "Peony"},
        {"Iowa", "Eastern Goldfinch", "Wild Rose"},
        {"Kansas", "Western Meadowlark", "Native Sunflower"},
        {"Kentucky", "Cardinal", "Goldenrod"},
        {"Louisiana", "Eastern Brown Pelican", "Magnolia"},
        {"Maine", "Chickadee", "White Pine Cone"},
        {"Maryland", "Baltimore Oriole", "Black-Eyed Susan"},
        {"Massachusetts", "Chickadee", "Mayflower"},
        {"Michigan", "American Robin", "Apple Blossom"},
        {"Minnesota", "Common Loon", "Pink and White Lady's Slippper"},
        {"Mississippi", "Mockingbird", "Magnolia"},
        {"Missouri", "Bluebird", "Hawthorn"},
        {"Montana", "Western Meadowlark", "Bitterroot"},
        {"Nebraska", "Western Meadowlark", "Goldenrod"},
        {"Nevada", "Mountain Bluebird", "Sagebrush"},
        {"New Hampshire", "Purple Finch", "Purple Lilac"},
        {"New Jersey", "Eastern Goldfinch", "Purple Violet"},
        {"New Mexico", "Great Roadrunner", "Yucca"},
        {"New York", "Eastern Bluebird", "Rose"},
        {"North Carolina", "Cardinal", "Dogwood"},
        {"North Dakota", "Western Meadowlark", "Wild Praire Rose"},
        {"Ohio", "Cardinal", "Scarlet Carnation"},
        {"Oklahoma", "Scissor-tailed Flycatcher", "Mistletoe"},
        {"Oregon", "Western Meadowlark", "Oregon Grape"},
        {"Pennsylvania", "Ruffed Grouse", "Mountain Laurel"},
        {"Rhode Island", "Rhode Island Red", "Violet"},
        {"South Carolina", "Carolina Wren", "Yellow Jessamine"},
        {"South Dakota", "Ring-necked Pheasant", "Pasqueflower"},
        {"Tennessee", "Mockingbird", "Iris"},
        {"Texas", "Mockingbird", "Bluebonnet"},
        {"Utah", "California Gull", "Sego Lily"},
        {"Vermont", "Hermit Thrush", "Red Clover"},
        {"Virginia", "Cardinal", "Flowering Dogwood"},
        {"Washington", "Willow Goldfinch", "Western Rhododendron"},
        {"West Virginia", "Cardinal", "Big Rhododendron"},
        {"Wisconsin", "American Robin", "Wood Violet"},
        {"Wyoming", "Western Meadowlark", "Indian Paintbrush"}
    };
    
    // constructor
    public StatesDataEntry(String state) {
        
        this.stateIndex = getStateIndex(state, statesData); // find index of state in statesData
        if (stateIndex>=0){
            this.stateName = state;
            this.stateBird = statesData[stateIndex][1];
            this.stateFlower = statesData[stateIndex][2];
        } // end if-else statement
    } // end StateBirdFlower constructor
    
    // getter methods
    public String getStateName(){
        return this.stateName;
    }
    public String getStateBird(){
        return this.stateBird;
    }
    public String getStateFlower(){
        return this.stateBird;
    }    
    public int getStateIndex(String state, String[][] arr){ // find index of state in 2d array
        int index = -1; // initialize at -1 to signify state not found in 2d array
        
        for (int i = 0; i<statesData.length; i++) {
            if (statesData[i][0].equals(state)){ // .equalsIgnoreCase not needed due to upperCaseFirstLetters method
                index = i;
                break;
            } // end if statement
        } // end for loop
        
        return index;
    } // end getStateIndex method
    // end getter methods
    
    // get states from user
    public static void enterStates(Scanner in){
        String stateName; // String to hold state name, case/whitespace insensitive
        
        do{ 
            System.out.print("Enter a State or None to exit: ");
            stateName = in.nextLine(); // takes user input
            stateName = upperCaseFirstLetters(stateName); // capitalize first letters in each word and removes leading/trailing whitespace
            StatesDataEntry state = new StatesDataEntry(stateName); // create object
            if(!(stateName.equals("None"))){ // if user entered anything other than "None"
                // string.equalsIgnoreCase() not needed due to upperCaseFirstLetters method
                if(state.stateIndex<0) { // stateName is not found in index
                    System.out.println("Invalid input. Please enter a U.S. State.");
                }else{
                    stateList.add(state); // add state to ArrayList
                    System.out.println("Bird: " + state.stateBird);
                    System.out.println("Flower: " + state.stateFlower);
                } // end if-else statement
            } // end if statement
        }while(!(stateName.equalsIgnoreCase("None"))); // exit do-while when user enters "None"
        
    } // end enterStates method
    
    // format String to match statesData
    private static String upperCaseFirstLetters(String str){
        str = str.trim(); // removes leading and trailing whitespace
        str = str.toLowerCase(); // convert to all lowercase
        if (str.length()>0){ // following line only works for non-empty strings
        str = (str.substring(0,1)).toUpperCase() + str.substring(1); // capitalizes first letter only
        } // end if statement
        int i = str.indexOf(" "); // check for 2 word state names
        if (i>0){
            str = str.substring(0,i) + str.substring(i,i+2).toUpperCase() + str.substring(i+2); // capitalizes second word of state name
        } // end if statement
        
        return str;
    } // end upperCaseFirstLetters method
    
    // print summary of results
    public static void printSummary (){
        //ArrayList<StateBirdFlower> stateList
        System.out.println("**** Thank you ****");
        System.out.println("A summary report for each State, Bird, and Flower is:");
        // loop through ArrayList
        for (int i = 0; i<stateList.size(); i++){
            System.out.println(stateList.get(i).stateName + ", " + stateList.get(i).stateBird + ", " + stateList.get(i).stateFlower);
        } // end for loop
        System.out.println("Please visit our site again!");
    } // end getSummary method
    
} // end class

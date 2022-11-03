import java.util.*;
import java.io.*;

public class RealEstateAnalysis{
    public static void main(String[] args) throws FileNotFoundException{
        question2();
    }



//QUESTION 1: WHAT IMPACT DOES A HOUSES LOCATION HAVE ON ITS LIST PRICE?
    //hard code a list of small and large cities as a way to make rural and urban categories
    //grab first line of data set and make a header array
    //make ruralHomePrices AL and urbanHomePrices AL 
    //go through header array and find locationIndex and priceIndex
    //use a while loop to go through each entry and look at its location
        //if it is a small city, add its price to the ruralHomePrices AL
        //if it is a large city, add its price to the urbanHomePrices AL
        //if its location doesn't fall in my hard coded list, ignore that enry
    //once the ArrayLists are completed with all the rural home prices and urban home prices, use average method to find the average of each AL
    //compare the two

    public static ArrayList<String> convertToArrayList(String[] arr){
        ArrayList<String> arrList = new ArrayList<>();
        for(int i =0; i< arr.length; i++){
            arrList.add(arr[i]);
        }
        return arrList;
    }

    public static void question1() throws FileNotFoundException{
        File homeData = new File("Metro_Data_Baby.csv");
        Scanner fileScanner = new Scanner(homeData);

        String[] largeCities = {"New York-Newark-Jersey City", "Boston-Cambridge-Newton", "Chicago-Naperville_Elgin", "Los Angeles-Long Beach-Anaheim", "Atlanta-Sandy Springs-Alpharetta", "Philadelphia-Camden-Wilmington", "Miami-Fort Lauderdale-Pompano Beach", "New Orleans", "Indianapolis", "Minneapolis", "Denver", "San Francisco-Oakland-Berkeley", "San Diego", "Phoenix-Mesa-Chandler", "Dallas-Fort Worth-Arlington", "Houston-The Woodlands-Sugar Land", "Nashville", "Las Vegas", "Detroit-Warren-Dearborn"};
        String[] smallCities = {"Worcester", "New Haven-Milford", "Winston-Salem", "Bloomington", "Raleigh-Cary", "Lancaster", "Asheville", "Ann Arbor", "Greenville", "Falmouth", "Ithaca", "Naples-Marco Island", "Richmond", "Santa Fe", "Sioux City", "Pueblo", "Yuma", "Tupelo", "Missoula", "Beckley"};
        ArrayList<String> largeCitiesAL = convertToArrayList(largeCities);
        ArrayList<String> smallCitiesAL = convertToArrayList(smallCities);//fix this to originally be AL
        ArrayList<Integer> ruralHomePrices = new ArrayList<>();
        ArrayList<Integer> urbanHomePrices = new ArrayList<>(); 
        String headerLine = fileScanner.nextLine();
        ArrayList<String> headerArr = convertToArrayList(headerLine.split(","));
        int priceIndex = headerArr.indexOf("median_listing_price")+1;
        System.out.println(priceIndex);
        int locationIndex = headerArr.indexOf("cbsa_title");
        System.out.println(locationIndex);

        while(fileScanner.hasNextLine()){
            System.out.println("Start of loop");
            String currentLine = fileScanner.nextLine();
            ArrayList<String> currentLineAL = convertToArrayList(currentLine.split(","));
            System.out.println(currentLineAL.size());
            
            int currentPrice =Integer.parseInt(currentLineAL.get(priceIndex));
            
            
            System.out.println("current price: " + currentPrice);

            String currentLocation = currentLineAL.get(locationIndex).substring(1);
            System.out.println("currentLocation is:  " +currentLocation);
            System.out.println(largeCitiesAL.indexOf(currentLocation));

            if(largeCitiesAL.indexOf(currentLocation) != -1){
                urbanHomePrices.add(currentPrice);
             }
            else if(smallCitiesAL.indexOf(currentLocation) != -1){
                ruralHomePrices.add(currentPrice);
            }
            
            
            

            
        }
        
        System.out.println("urban home prices length:" + urbanHomePrices.size());

        for(int i =0; i< urbanHomePrices.size(); i++){
            System.out.println(urbanHomePrices.get(i));
        }

        System.out.println("rural home prices size:" + ruralHomePrices.size());

        for(int i =0; i< ruralHomePrices.size();i++){
            System.out.println(ruralHomePrices.get(i));
        }

        System.out.println("The average list price in larger cities is: " + averageAL(urbanHomePrices));
        System.out.println("The average list price in smaller/rural cities is: " + averageAL(ruralHomePrices));

    }



//QUESTION 2: WHAT IMPACT DOES THE AMOUNT OF INVENTORY HAVE ON LIST PRICE?
    //randomly select 5 cities
    //make inventoryIndex variagble
    //for each city, use invnetortyIndex to find amount of homes for sale
    //make cityHomePrices AL
    //use while loop to go through data and add for that particular city, add the price of each home to the AL
    //find average of home prices, and display it alongside inventory
    //repeat for each city, and then look at the results and see if any conclusions can be made
    //using county metrics
    //randomly pick 5 states
    //find priceIndex and inventoryIndex
    //make 3 AL: state, price, inventory
    //display results 

    //WHICH STATE HAS HIGHEST LIST PRICE, AND WHICH STATE AHS LOWEST LIST PRICE 
    public static void question2() throws FileNotFoundException{
        File q2Data = new File("RDC_Inventory_Core_Metrics_State.csv");
        Scanner fileScanner = new Scanner(q2Data);
        String header = fileScanner.nextLine();
        ArrayList<String> headerAL = convertToArrayList(header.split(","));
        int stateIndex = headerAL.indexOf("state");
        int priceIndex = headerAL.indexOf("median_listing_price");
        System.out.println("state index: " + stateIndex);
        ArrayList<String> stateAL = new ArrayList<>();
        ArrayList<Integer> priceAL = new ArrayList<>();
        
        //make an array list of all the states 
        //make an al of the average price for each state, they correspond
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            ArrayList<String> currentLineAL = convertToArrayList(line.split(","));
            
            stateAL.add(currentLineAL.get(stateIndex));
            priceAL.add(Integer.parseInt(currentLineAL.get(priceIndex)));
        }
        System.out.println("while loop done");
        int lowestPrice =100000000;
        int lowestPriceIndex =0;
        for(int i =0; i< priceAL.size(); i++){
            if(priceAL.get(i) < lowestPrice){
                lowestPrice = priceAL.get(i);
                lowestPriceIndex =i; 
            }
        }

        int highestPrice =0;
        int highestPriceIndex =0;
        for(int i =0; i< priceAL.size(); i++){
            if(priceAL.get(i) > highestPrice){
                highestPrice = priceAL.get(i);
                highestPriceIndex = i;
            }
        }

        System.out.println("The state with the lowest avereage list price is " + stateAL.get(lowestPriceIndex) + ", with a price of $" +lowestPrice);

        System.out.println("The state with the highest average list price is " + stateAL.get(highestPriceIndex) + ", with a price of $" +highestPrice);

        

    }


//QUESTION 3: IS THERE A CORRELATION BETWEEN HOME PRICE AND THE AMOUNT OF TIME THE HOUSE TAKES TO SELL?
    //randomly select 5 houses
    //create two parallel ArrayLists, homePrice and sellingTime
    //for each house, use a while loop to go through the data and add its price and selling time to the corresponding AL
    //compare prices and selling time and see if there are any trends 
    //waht coast ahs a higher listing price, east or west*/

    public static void question3() throws FileNotFoundException{
        File q3Data = new File("RDC_Inventory_Core_Metrics_State.csv");
        Scanner fileScanner = new Scanner(q3Data);
        ArrayList<String> headerAL = convertToArrayList(fileScanner.nextLine().split(","));
        int stateIndex = headerAL.indexOf("state");
        int priceIndex = headerAL.indexOf("median_listing_price");
        ArrayList<String> westCoastStates = new ArrayList<>(Arrays.asList("Washington", "Oregon", "California"));
        ArrayList<String> eastCoastStates = new ArrayList<>(Arrays.asList("Maine", "New Hampshire", "Massachusetts", "Rhode Island", "Connecticut", "New York", "New Jersey", "Delaware", "Maryland", "Virginia", "North Carolina", "South Carolina", "Georgia", "Florida"));
        ArrayList<Integer> westCoastPrices = new ArrayList<>();
        ArrayList<Integer> eastCoastPrices = new ArrayList<>();

        while(fileScanner.hasNextLine()){
            ArrayList<String> currentLineAL = convertToArrayList(fileScanner.nextLine().split(","));
            String currentState = currentLineAL.get(stateIndex);
            int currentPrice = Integer.parseInt(currentLineAL.get(priceIndex));
            System.out.print("state =" + currentState);
            System.out.print(" price =" + currentPrice);
            System.out.print(" wci= " + westCoastStates.indexOf(currentState));
            System.out.print(" eci = " + eastCoastStates.indexOf(currentState));
            System.out.println("");
            if(westCoastStates.indexOf(currentState) != -1){
                westCoastPrices.add(currentPrice);
            }
            else if(eastCoastStates.indexOf(currentState) != -1){
                eastCoastPrices.add(currentPrice);
            }
            System.out.println("past if else");
        }
        System.out.println("while loop done");
        int westCoastAvg = averageAL(westCoastPrices);
        int eastCoastAvg = averageAL(eastCoastPrices);

        System.out.println("The average price for west coast homes is: " + westCoastAvg);
        System.out.println("The average price for east coast home is: " + eastCoastAvg);

        
    }

    public static int averageAL(ArrayList<Integer> list){
        int sum =0;
        for(int i =0; i< list.size(); i++){
            sum += list.get(i);
        }
        return sum/list.size();
    }
}


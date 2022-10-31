import java.util.*;
import java.io.*;

public class RealEstateAnalysis{
    public static void main(String[] args) throws FileNotFoundException{
        question1();
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
        File homeData = new File("RDC_Inventory_Core_Metrics_Metro.csv");
        Scanner fileScanner = new Scanner(homeData);

        String[] largeCities = {"New York", "Boston", "Chicago", "Los Angeles", "Atlanta", "Philadelphia", "Miami", "New Orleans", "Indianapolis", "Minneapolis", "Denver", "San Francisco", "San Diego", "Phoenix", "Dallas", "Houston", "Nashville", "Las Vegas", "Detroit"};
        String[] smallCities = {"Worchester", "Stamford", "Winston-Salem", "Carmel", "Cary", "Lancaster", "Asheville", "Ann Arbor", "Greenville", "Falmouth", "Ithaca", "Naples", "Richmond", "Santa Fe", "Sioux Falls", "Sedona", "Kennebunkport", "Whitefish", "Kohler", "Fair Lawn"};
        ArrayList<String> largeCitiesAL = convertToArrayList(largeCities);
        ArrayList<String> smallCitiesAL = convertToArrayList(smallCities);//fix this to originally be AL
        ArrayList<Integer> ruralHomePrices = new ArrayList<>();
        ArrayList<Integer> urbanHomePrices = new ArrayList<>(); 
        String headerLine = fileScanner.nextLine();
        ArrayList<String> headerArr = convertToArrayList(headerLine.split(","));
        int priceIndex = headerArr.indexOf("median_listing_price");
        int locationIndex = headerArr.indexOf("cbsa_title");

        while(fileScanner.hasNext()){
            String currentLine = fileScanner.next();
            String[] currentLineArr = currentLine.split(",");
            int currentPrice = Integer.parseInt(currentLineArr[priceIndex]);
            String currentLocation = currentLineArr[locationIndex];
            if(largeCitiesAL.indexOf(currentLocation) != -1){
                urbanHomePrices.add(currentPrice);
             }
            else if(smallCitiesAL.indexOf(currentLocation) != -1){
                ruralHomePrices.add(currentPrice);
            }
        }

        System.out.println("urban home prices:");

        for(int i =0; i< urbanHomePrices.size(); i++){
            System.out.println(urbanHomePrices.get(i));
        }

        System.out.println("rural home prices:");

        for(int i =0; i< ruralHomePrices.size();i++){
            System.out.println(ruralHomePrices.get(i));
        }

    }



//QUESTION 2: WHAT IMPACT DOES THE AMOUNT OF INVENTORY HAVE ON LIST PRICE?
    //randomly select 5 cities
    //make inventoryIndex variagble
    //for each city, use invnetortyIndex to find amount of homes for sale
    //make cityHomePrices AL
    //use while loop to go through data and add for that particular city, add the price of each home to the AL
    //find average of home prices, and display it alongside inventory
    //repeat for each city, and then look at the results and see if any conclusions can be made


//QUESTION 3: IS THERE A CORRELATION BETWEEN HOME PRICE AND THE AMOUNT OF TIME THE HOUSE TAKES TO SELL?
    //randomly select 5 houses
    //create two parallel ArrayLists, homePrice and sellingTime
    //for each house, use a while loop to go through the data and add its price and selling time to the corresponding AL
    //compare prices and selling time and see if there are any trends 
}


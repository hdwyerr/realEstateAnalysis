import java.util.*;
import java.io.*;

public class RealEstateAnalysis{
    public static void main(String[] args) throws FileNotFoundException{
        citiesVsRuralPrices();
        mostAndLeastExpensiveStates();
        mostExpensiveCoast();
    }



    //helper method to make an array an AL
    public static ArrayList<String> convertToArrayList(String[] arr){
        ArrayList<String> arrList = new ArrayList<>();
        for(int i =0; i< arr.length; i++){
            arrList.add(arr[i]);
        }
        return arrList;
    }

    //QUESTION 1: IS IT MORE EXPENSIVE TO LIVE IN URBAN OR RURAL AREAS?
    public static void citiesVsRuralPrices() throws FileNotFoundException{
        //make data file
        File homeData = new File("Metro_Data_Good.csv");
        Scanner fileScanner = new Scanner(homeData);
        //set up necessary variables
        String[] largeCities = {"New York-Newark-Jersey City", "Boston-Cambridge-Newton", "Chicago-Naperville_Elgin", "Los Angeles-Long Beach-Anaheim", "Atlanta-Sandy Springs-Alpharetta", "Philadelphia-Camden-Wilmington", "Miami-Fort Lauderdale-Pompano Beach", "New Orleans", "Indianapolis", "Minneapolis", "Denver", "San Francisco-Oakland-Berkeley", "San Diego", "Phoenix-Mesa-Chandler", "Dallas-Fort Worth-Arlington", "Houston-The Woodlands-Sugar Land", "Nashville", "Las Vegas", "Detroit-Warren-Dearborn"};
        String[] smallCities = {"Worcester", "New Haven-Milford", "Winston-Salem", "Bloomington", "Raleigh-Cary", "Lancaster", "Asheville", "Ann Arbor", "Greenville", "Falmouth", "Ithaca", "Naples-Marco Island", "Richmond", "Santa Fe", "Sioux City", "Pueblo", "Yuma", "Tupelo", "Missoula", "Beckley"};
        ArrayList<String> largeCitiesAL = convertToArrayList(largeCities);
        ArrayList<String> smallCitiesAL = convertToArrayList(smallCities);//fix this to originally be AL
        ArrayList<Integer> ruralHomePrices = new ArrayList<>();
        ArrayList<Integer> urbanHomePrices = new ArrayList<>(); 
        String headerLine = fileScanner.nextLine();
        ArrayList<String> headerArr = convertToArrayList(headerLine.split(","));
        int priceIndex = headerArr.indexOf("median_listing_price")+1;
        int locationIndex = headerArr.indexOf("cbsa_title");
        //go through the file
        while(fileScanner.hasNextLine()){
            
            String currentLine = fileScanner.nextLine();
            ArrayList<String> currentLineAL = convertToArrayList(currentLine.split(","));
            int currentPrice =Integer.parseInt(currentLineAL.get(priceIndex));
            String currentLocation = currentLineAL.get(locationIndex).substring(1);
            //check which list the currentLocation appears on, and add its price to the corresponding AL
            if(largeCitiesAL.indexOf(currentLocation) != -1){
                urbanHomePrices.add(currentPrice);
             }
            else if(smallCitiesAL.indexOf(currentLocation) != -1){
                ruralHomePrices.add(currentPrice);
            }  
        }

        System.out.println("The average list price in larger/urban cities is: $" + averageAL(urbanHomePrices));
        System.out.println("The average list price in smaller/rural cities is: $" + averageAL(ruralHomePrices));//helper method to average the values of the list

    }



//QUESTION 2: WHICH STATES HAVE THE LOWEST AND HIGHEST AVERAGE LISTING PRICE?
    
    public static void mostAndLeastExpensiveStates() throws FileNotFoundException{
        //make data file
        File q2Data = new File("RDC_Inventory_Core_Metrics_State.csv");
        Scanner fileScanner = new Scanner(q2Data);
        //create necessary variables
        String header = fileScanner.nextLine();
        ArrayList<String> headerAL = convertToArrayList(header.split(","));
        int stateIndex = headerAL.indexOf("state");
        int priceIndex = headerAL.indexOf("median_listing_price");
        ArrayList<String> stateAL = new ArrayList<>();
        ArrayList<Integer> priceAL = new ArrayList<>();
        
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            ArrayList<String> currentLineAL = convertToArrayList(line.split(","));
            //add the state and its average list price to corresponding indicies in the AL
            stateAL.add(currentLineAL.get(stateIndex));
            priceAL.add(Integer.parseInt(currentLineAL.get(priceIndex)));
        }
        //find the lowest price
        int lowestPrice =100000000;
        int lowestPriceIndex =0;
        for(int i =0; i< priceAL.size(); i++){
            if(priceAL.get(i) < lowestPrice){
                lowestPrice = priceAL.get(i);
                lowestPriceIndex =i; 
            }
        }
        //find the highest price
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


//QUESTION 3: WHICH COAST HAS A HIGHER AVERAGE LIST PRICE?

    public static void mostExpensiveCoast() throws FileNotFoundException{
        //get data file
        File q3Data = new File("RDC_Inventory_Core_Metrics_State.csv");
        Scanner fileScanner = new Scanner(q3Data);
        //make necessary variables
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
            //check if the currentState is on the east or west coast, and then add its price to the corresponding AL
            if(westCoastStates.indexOf(currentState) != -1){
                westCoastPrices.add(currentPrice);
            }
            else if(eastCoastStates.indexOf(currentState) != -1){
                eastCoastPrices.add(currentPrice);
            }  
        }
        //average price for each coast
        int westCoastAvg = averageAL(westCoastPrices);
        int eastCoastAvg = averageAL(eastCoastPrices);

        System.out.println("The average price for west coast homes is: $" + westCoastAvg);
        System.out.println("The average price for east coast home is: $" + eastCoastAvg); 
    }

    //helper method to find the average of the values in an AL
    public static int averageAL(ArrayList<Integer> list){
        int sum =0;
        for(int i =0; i< list.size(); i++){
            sum += list.get(i);
        }
        return sum/list.size();
    }
}


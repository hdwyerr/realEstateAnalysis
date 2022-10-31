public class RealEstateAnalysis{
    public static void main(String[] args){

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

    //file will be called homeData

    String[] largeCities = {"New York", "Boston", "Chicago", "Los Angeles", "Atlanta", "Philadelphia", "Miami", "New Orleans", "Indianapolis", "Minneapolis", "Denver", "San Francisco", "San Diego", "Phoenix", "Dallas", "Houston", "Nashville", "Las Vegas", "Detroit"};
    String[] smallCities = {"Worchester", "Stamford", "Winston-Salem", "Carmel", "Cary", "Lancaster", "Asheville", "Ann Arbor", "Greenville", "Falmouth", "Ithaca", "Naples", "Richmond", "Santa Fe", "Sioux Falls", "Sedona", "Kennebunkport", "Whitefish", "Kohler", "Fair Lawn"};

    ArrayList<Double> ruralHomePrices;
    ArrayList<Double> urbanHomePrices; 
    String headerLine = fileScanner.nextLine();
    String[] headerArr = headerLine.split(",");
    int priceIndex = headerArr.indexOf("median_listing_price");
    int locationIndex = headerArr.indexOf("cbsa_title");

    while(fileScanner.hasNext()){
        Stirng currentLine = fileScanner.next();
        String currentLineArr = currentLine.split(",");
        double currentPrice = currentLineArr[priceIndex];
        Stirng currentLocation = currentLineArr[locationIndex];
        if(largeCites.indexOf[currentLocation] != -1){
            urbanHomePrices.add(currentPrice);
        }
        else if{smallCities.indexOf[currentLocation] != -1}{
            ruralHomePrices.add(currentPrice);
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


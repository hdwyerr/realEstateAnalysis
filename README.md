# Real Estate Inventories 
My data set is a compilation of real estate metrics from realtor.com. This data set contains information about house location, price, days on market, and the amount of listings in a given city. I chose questions that I felt would be both interesting to answer and relevant to the broader public.
What impact does a house's location have on its list price?
What impact does the amount of inventory have on list price?
Which coast of the country has a higher average list price?

## Introduction 
I chose this data set because I thought it would be interesting to analyze since it has practical applications. Most people in America buy a house at some point, and the questions I answered should provide useful information that can assist them when they are looking for homes. In addition, I think it is interesting how home metrics vary across the country, so I was excited to have a chance to analyze the data more closely. 
`code`

### Data Set
This data was generated by realtor.com, and it is   . Realtor.com also owns this data set, and on thier website they allow people to use it as long as they cite the company in their project. 
### Process
To answer my questions, I frist utilized top down design and wrote my program setps in pseudocode. I found this to be very helpful as it gave me a clear outline of what I needed to accomplish in my code. For certian questions, I decided that it would be beneficial to simplify my data set, like in question 1, where I hard coded a list of small vs. large metro areas. I tried to pick a variety of metro areas around the country so I could have a varied data set and still get the most accurate results possible. 
    For all of my quesions, I need the indicies of important elements in the header of the data set. For instance, priceIndex was a variable I used in every question, as it was an easy way to access the price of each house when parsing the file. In addition, the use of ArrayLists was helpful because their methods such as get(), add(), and indexOf() were useful when I was trying to either create a new ArrayList or compare the current line of the file with an ArrayList I had already made. Another part of my process was creating helper methods such as convertToArrayList and averageAL. I quickly realized that these were tasks I needed to do frequently in my code, so having a method to do it for me was very helpful, as it streamlined my code and made the program more general and adaptable. 
### Challenges 

## Conclusion
should be at same level as introduction 


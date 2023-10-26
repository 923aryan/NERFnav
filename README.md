There are several houses in a straight line. N courier delivery executives have been assigned their routes. They deliver parcels to various houses. There is a warehouse at the start of the route. The distances from the houses to the warehouse are pre-calculated. The courier company wants to utilize its staff for another project. Hence, if any delivery executive is found to have an overlapping route with another executive, then they will be replaced by a single executive. The company wishes to determine how many executives will remain after the executives with overlapping routes have been assigned to the other project.
Write an algorithm to find how many executives will remain after the executives with overlapping routes have been assigned to the other project.
Input
The first line of the input consists of two space-separated integers - deliveryExecutive & houseDescription, representing the number of courier delivery executives working on the route (N) and the number of houses for each delivery executive, showing the starting and ending houses (houseDescription (M) is always equals to 2).
The next N lines consist of M space-separated integers - startinghouse & endingHouse representing the starting and ending houses of N delivery executives.
Output
Print an integer representing how many executives will remain after the executives with overlapping routes have been assigned to the other project.
Constraints
O <= deliveryExecutive, houseDescriptions <=10^5
O <= startingHouse < endingHouse <= 10^6
Example
Input:
4 2
2 8
6 10
12 14
12 20
Output:
2
Explanation:
    ________         ___
   |        |       |   |
0--2--4--6--8--10--12--14--16--18--20
         |_____|    |______________|

The delivery executives whose routes are between house [2, 8] and [6, 10] are combined into one.
Similarly, the delivery executives whose routes are between house [12, 14] and [12, 20] are combined into one.
So, the total number of delivery executives working is 2.
//
Question
In a gift shop, wrist watches are sold in pairs (for couples). There are N watches, and each watch has a numeric code
imprinted at its base which represents the ID of each watch, ranging from 0 to N-1. On New ear's Eve, the store owner
decided to give lifetime discount coupons to couples. The store owner picks a number K, which represents the absolute
difference in price of watches in a pair To win, a couple has to pick the pair of watches with the eract absolute difference in
price equal to K.
Write an algorithm to find the total number of such combinations that can be considered for lifetime discount cougons.
Input
The first line of the input consists of an integer- noOfatches, representing the total number of watches (N).
The second line consists of N space-separated integers - price[0), price[1], .....price[N-1, representing the price of N watches
The last line consists of an integer K input representing the given value K
Output
Print an integer representing the total number of combinations that can be considered for
tme discount cou
Constraints
1 < noofWatches <10^6
0 <= K input <= 10^9
0 <+ price[0], price[1],
price[N-1]<10^9
Example
Input:
6
10 15 23 14 2 15
13
Output
3
Explanation:
There are 3 pairs with absolute difference of 13; the pairs are (10, 23), (15, 2) and (2, 15) i.e. | 10-23= 13|, | 15-2- 13 |, |2-15=13|
So, the output is 3.
//

The current selected programming language is Python. We emphasize the submission of a fully working code over partially correct but efficient code. Use of certain header files are restricted. Once submitted, you cannot review this problem again. You can use print to debug your code. The print may not work in case of syntax/runtime error. The version of Python being used is
3.5.2
CDs are kept on a rack at Andys shop. Customers come to the shop to buy these CDs. When a customer wants a CD but it is not available and the rack is full, then the CD that has been kept on the rack for the longest time is removed to make room for the requested CD. If the rack is not full, then the requested CD can simply be added on the rack. There should be, at most, only one copy of a given CD on the rack. Initially the rack is empty.
Given the maximum size of the rack and a list of CD demands, calculate the number of times a CD was demanded but was not found on the rack.
Input
The first line of the input consists of an integer - CD_size, representing the total number of CDs (N) that are demanded.
The second line contains N space-separated integers - CD_demand 0], CD_demand[1]. ... CD_demand[N-1], representing the demanded N CDs.
The last line consists of an integer - size, representing the size of the rack.
Output
Print an integer representing the number of times a CD was demanded but was not found on the rack.
Note
Assume that the list CD_demandcontains CDs numbered in the range 1-50. A CD with the index l'in CD_demand is requested before a CD with the indexi+1
Example
Input:
6
1 2 1 3 1 2
2
Output:
5
Explanation:

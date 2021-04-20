# Q4 : Food Delivery Booking

----
A food delivery company has 'n' number of delivery executives. For simplicity take the count as 5 but the program
should work for any number of delivery executives (Let their names be identified as DE1, DE2....DE-n)
There are only 5 restaurants in the city for pick-up and 5 drop locations (Each location can have multiple customers)
After delivering a food package , the delivery executive waits there for devlivery allotment.
Each customer is identified uniquely by a Customer-ID
Write a program that does the following :
Constraints :
* Delivery charge for every single order is Rs 50 for the delivery executive.
*  If multiple orders (say n) are from the same delivery location within 15 mins period, combine orders to a maximum
of 5 per delivery executive.
    In such case, the delivery charge will be base rate Rs.50 + Rs.5 for every other order (50+5 * (n-1)).
*  An allowance of Rs.10 will be given for every trip made. Combined orders will be counted as a single trip.
*  Assign the subsequent bookings giving preference to the executive who has earned the least delivery chamge
among the other available delivery executives excluding trip allowance.
*  Every trip will take 30 mins to reach the destination.
Questions :
*  Write a function to handle booking.
*  Write a function to assign delivery executive
*  Write a function that can display delivery executive's activity thus far.
This should contain commision earned , allowance earned(calculated based on criteria 2 and 3).
----
Input 1
* Customer ID: 1
* Restaurant: A
* Destionation Point : D
* Time : 9.00 AM
* Output
    * Booking ID : 1
    * Available Executives :
    * Executive     Delivery Charge Earned    
        * DE1                      0
        * DE2                      0
        * DE3                      0
        * DE4                      0
        * DE5                      0
        * Allotted Delivery Executive: DE1

----

Input 2
* Customer ID: 2
* Restaurant : B
* Destination Point : A
* Time : 10.00 AM
* Output
    * Booking ID : 2
    * Available Executives :
    * Executive     Delivery Charge Earned    
        * DE1                      50
        * DE2                      0
        * DE3                      0
        * DE4                      0
        * DE5                      0
        * Allotted Delivery Executive: DE2

----
Input 3
* Customer ID: 3
* Restaurant : B
* Destionation Point : A
* Time : 10.10 AM
* Output
    * Booking ID : 3
    * Available Executives :
    * Executive     Delivery Charge Earned
        * DE1                      50
        * DE2                      50
        * DE3                      0
        * DE4                      0
        * DE5                      0
        * Allotted Delivery Executive: DE2 (because same location within 15mins)

----
Input 4
* Customer ID: 3
* Restaurant : D
* Destionation Point : C
* Time : 10.35 AM
* Output
    * Booking ID : 3
    * Available Executives :
    * Executive     Delivery Charge Earned
        * DE1                      50
        * DE2                      55
        * DE3                      0
        * DE4                      0
        * DE5                      0
        * Allotted Delivery Executive: DE3


# MaxSumOfPyramidTriangleOddEven
Maximum Sum of triangle hierarchy  as evens and odds subsequently
Maven Project , implementation to find the maximum sum of the triangle hierarchy with as evens and odds subsequently.
# Building Command
mvn clean install
# Steps to execute Test cases 
Junit consits 4 test cases , 

4 x 4 triangle,
4 x 4 triangle with Negative values,
15 x 15 triangle,
30 x 30 triangle. 

Import project in eclipse , select as maven project 
run Junit test cases
to verify other triangles , prepare the required triangle and call logic function by passing it
# Logic  
1.Prerequisite 
	Function will receive regular matrix i.e
	
	1                 1 0 0 0
	8 9       =====>> 8 9 0 0
	1 5 9             1 5 9 0
	4 5 2 3           4 5 2 3

2.Provided triangle will be cloned to Result 2D array, 
	inputTriangle is for identifying the evens and odds subsequently
	result is for identifying the sum 

3.At first Last row child nodes and last but one row Parent Node will be compared for evens and odds subsequently
	if Comparison is success , result 2D array will be updated with the sum of the parent Node and child node        
	  
		input Triangle		result triangle
		  1 0 0 0		   1 0 0  0 
		  8 9 0 0		   8 9 0  0
		  1 5 9 0		   5 7 11 0
		  4 5 2 3  		   4 5 2  3

4.Like wise , from Bottom to Top the result array will be updated with the sum of parent and child node by comparing even and odd .
	
	      first loop					   Last loop
		1 0 0 0		1 0 0  0	 1  0 0  0	    16 0 0  0
		8 9 0 0	 ==>>	8 9 0  0  ==>>	 15 9 0  0    ==>>  15 9 0  0
		1 5 9 0		5 7 11 0	 5  7 11 0	    5  7 11 0
		4 5 2 3		4 5 2  3	 4  5 2  3	    4  5 2  3
		maximum sum will be stored at [0][0] of result 2D array at end .

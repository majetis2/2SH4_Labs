
#include "Questions.h"



int Q1_for(){
	int sum = 0; //initializing sum to zero

	// calculate your sum below..this has to use for loop
	int num;    //initializing counter
	for(num=30; num<=1000; num++)
	{
		if (num%4==0)
			sum+=num;
	}

	// here, we return the calculated sum:
	return sum;
}
int Q1_while(){
	int sum = 0; //initializing sum to zero

	// calculate your sum below..this has to use while loop
	int num = 30; //initializing counter loop
	while(num<=1000){         //Checks whether number is less than 1000
		if (num%4==0)		  //Checks whether the num is divisible by four
			sum+=num;         //Adds num to sum each time the while condition is true
		num++;                //Increases num by one
	}

	// here, we return the calculated sum:
	return sum;
}
int Q1_do(){
	int sum = 0;     //initializes sum to zero
	
	// calculate your sum below..this has to use do-while loop
	int num = 30;        //initializes num to 30
	do{                  //Do statement does one iteration before checking the condition
		if (num%4==0)
			sum+=num;
		num++;
	}
	while(num<=1000);
	  
	// here, we return the calculated sum:
	return sum;
}
//===============================================================================================
int Q2(int Q2_input){
	
	// this is the flag that is holding whether the input number is 5-digit or not
	int IsFiveDigit = 0;
	
	// Do your coding below to check
	int count = 0;
	//int num_five = Q2_input;
	while (Q2_input != 0){   //The while loop stops when the Q2_input is zero
		Q2_input /= 10;
		count ++;			//Count increased by 1
	}

	if (count == 5){         //Checks whether count is five and assigns value one for IsFiveDigit
		IsFiveDigit = 1;
	}
	
	
	//finally, we must return IsFiveDigit, which must be 1 is the number is five digits and 0 otherwise
	return IsFiveDigit;
}
//===============================================================================================
int Q3(float Q3_input){
	
	/* Question 3: 
	Write a program that takes a student's Q3_input as an input, which is a floating point value,
	and prints:
	4 if the Q3_input is in the range 90-100,
	3 if it is in the range 80-89, 
	2 if it is in the range 70-79,
	1 if it is in the range 60-69 and
	0 if the Q3_input is between 0 and 59.
	If the Q3_input is not in the range 0-100, the program should print a message to signal an invalid input.
*/	
	// this is the variable that holds the out value to return
	float GPA;
	
	
	// Do your coding below to calculate the GPA variable value
	//if and else if statements to check the range of Q3_input
	if (Q3_input>=90 && Q3_input<=100)
		GPA = 4;

	else if (Q3_input>=80 && Q3_input<=89)
		GPA = 3;

	else if (Q3_input>=70 && Q3_input<=79)
		GPA = 2;
	
	else if (Q3_input>=60 && Q3_input<=69)
		GPA = 1;

	else if (Q3_input>=0 && Q3_input<=59)
		GPA = 0;
	
	else
		GPA = -1;
	
	// finally, we return the GPA
	return GPA;	
}
//===============================================================================================
double Q4(int Q4_input){
	
	// this is the variable that holds the pi value to return
	double pi=0;
	
	// Do your coding below to calculate the pi value
	int pi_term;
	for(pi_term=0; pi_term<Q4_input; pi_term++){
		double numerator_pi;
		numerator_pi = (pi_term%2==0?1.0:-1.0);      //Alternates the sign of the numerator
		pi = (numerator_pi/((2.0*pi_term)+1.0)) + pi;    //Adds pi to the last value
	}
	pi  = 4*pi;

	// finally, we return the pi value
	return (pi);

}
//===============================================================================================
int Q5(){
	
	// this is the variable that holds and the total number of triples to return at the end of the function
	int totNumTribles = 0;
	
	
	/* Do your coding below
		Use a triple-nested for loop that simply tries all possibilities
		print each triple on a separate line, 
		and update the total number of triples if needed
	*/
	
	int hypo_side, side_1, side_2;
	for(hypo_side = 1;hypo_side <=400;hypo_side++)      //Three nested for loops to check values of all sides
	{
		for(side_1 = 1;side_1 <=400;side_1++)
		{
			for(side_2 = 1;side_2 <=400;side_2++)
			{
				if(side_1 <= side_2){                          //Checks whether side_1 is less than or equal to side_2
					if ((side_1*side_1)+(side_2*side_2) == (hypo_side*hypo_side)) //Checks whether a*a+b*b = c*c
					{
						totNumTribles +=1;      //totNumTribles increases by one
					}
				}

			}
		}
	}

	//this is the format that you MUST print the found tribles..uncomment this line and fill in the missings to get it working correctly
	//printf("A trible found: side1=%d, side2=%d, side3=%d\n", ...)
	
	//finally you should return the total number of tribles.
	//return x;
	return totNumTribles;
}
//===============================================================================================
int Q6(int Q6_input, int perfect[]){
	
	
	
		//counts is the variable that should hold the total number of found perfect numbers
		//you should update it within your code and return it at the end

		/*

		 perfect is an array that you need to add into it any perfect number you find
		 which means at the end of this function, the perfect[] array should hold all the found perfect numbers in the range
		 you do not need to return perfect because as stated in lectures arrays are already passed by reference. so, modifying them will
		 Automatically reflect in the main calling function.

		*/

	    int counts=0;
	    int num,factor_check,item;

	    for(item=0;item<100;item++){           //Initializing all items of perfect to zero
	    	perfect[item]=0;
	    }

	    for (num=1;num<=Q6_input;num++){
	    	int sum = 0;
	    	for (factor_check=1; factor_check<num; factor_check++){            //Checks whether the number is a factor of num
	    		if(num%factor_check==0){
	    			sum = sum+factor_check;                        //Adds the factors of the number except the number itself
	    		}
	    	}
	    	if(sum==num){                              //Checks if sum is equal to the number
	    		perfect[counts] = num;                //The element num is added to the array
				counts +=1;                           //Increases counts by one
	    	}

	    }

	   return counts;

	
}
//===============================================================================================
int Q7a(int Q7_input){
	
	//this is the variable that holds the reversed int.
	int reversedInt=0;
	
	
	// Do your coding logic here
	//Hint: Use the division and remainder operators to separate the number into its individual digits.
	//in this part you can assume the knowledge of the number of digits: seven-digit positive integer
	
	int remain_num,digit;
	for(digit=1; digit<=7; digit++){
		if (Q7_input!=0){                         //checks condition
			remain_num = Q7_input%10;
			reversedInt = reversedInt*10+remain_num;    //Reverses the seven digit integer
			Q7_input/=10;                               //Divides the input by 10 each time in for loop
		}
	}

	return reversedInt;
	
}
int Q7b(int Q7b_input){
	
	//this is the variable that holds the reversed int.
	int reversedInt=0;

	// Do your coding logic here
	//Hint: Use the division and remainder operators to separate the number into its individual digits.
	//this part should be generalized for any number of allowed digits
	
	int remain_num, digit;
		for(digit=Q7b_input;digit!=0;digit/=10){                   //for loop that goes over each digit
				remain_num = digit%10;
				reversedInt = reversedInt*10+remain_num;   //Reverses the integer
		}
	return reversedInt;
}

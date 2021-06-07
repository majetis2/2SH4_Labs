#include <stdio.h>
#include <stdlib.h>

#include<math.h>
#include "Questions.h"



void add_vectors(double vector1[],double vector2[],double vector3[],int size)
{
    /*vector3 should store the sum of vector1 and vector2. 
	You may assume that all three arrays have the size equal to n
	*/
	//write your code below
	
	int pos;   //position of element in vector
	for (pos=0; pos<size; pos++){
		vector3[pos] = vector1[pos] + vector2[pos]; //Adding vectors by position
	}
	


}

double scalar_prod(double vector1[],double vector2[],int size)
{
	// this is the variable holding the scalar product of the two vectors
    double prod = 0;

	//write your code below to calculate the prod value
	
    double vector3[size];
    int pos;   // position of element in vector
    for (pos=0;pos<size;pos++){
    	vector3[pos] = vector1[pos] * vector2[pos]; //Multiplying vectors by position
    	prod += vector3[pos];
    }
	
	// return the result
    return prod;
    //return vector3[0];
}

double norm2(double vector1[], int size)
{
	//this is the variable holding the L2 norm of the passed vector
    double L2;
    
	//write your code here
	// you should call function scalar_prod().
    double norm_prod;
    norm_prod = scalar_prod(vector1, vector1, size); //Calculating the scalar product of two identical matrices
	L2 = sqrt(norm_prod); //Calculating the norm of the vector

	//finally, return the L2 norm 
    return L2;
}

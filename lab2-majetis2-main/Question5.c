#include <stdio.h>
#include <stdlib.h>
#include "Questions.h"

void string_copy(const char source[], char destination[], int n){

	int pos;                               //Initiating position
	for(pos=0;pos<(n-1);pos++){
		destination[pos] = source[pos];    //Copying the elements of source into destination
	}
    destination[n] = '\0';                 //Declaring the last element of destination to have a null character
	
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Questions.h"



char *my_strcat(const char * const str1, const char * const str2){

	/* this is the pointer holding the string to return */
	char *z = NULL;
	
	/*write your implementation here*/
	int size_str1 = strlen(str1);
	int size_str2 = strlen(str2);
	int size_strcat = size_str1 + size_str2 + 1;      //length of strcat
	z = malloc(size_strcat*sizeof(char));             //Dynamically allocating memory for strcat sing size_strcat and malloc

	int pos=0;

	for(int s1=0;s1<=(size_str1+1);s1++){             //Adding elements of str1 and the first element of str2 to strcat
		if(str1[s1]!=0){
			z[pos] = str1[s1];
			pos++;
		}

		else{
			z[pos] = str2[0];
			pos++;
			break;
 		}
	}

	for(int s2=1;str2[s2]!=0;s2++){           //Adding all the other elements in strcat from s2
		z[pos] = str2[s2];
		pos++;
	}

	z[pos] = '\0';                              //Putting the null character at the last position

	/* finally, return the string*/
	return z;
}


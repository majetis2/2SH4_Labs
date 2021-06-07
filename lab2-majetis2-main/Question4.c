#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Questions.h"

void letter_freq(const char word[], int freq[]){

	int pos;                                                  //Initiating position

	for(pos=0;word[pos]!='\0';pos++){                         //For loop to go over each element in the string word
		if(word[pos]>='a' && word[pos]<='z'){                 //Checks the frequency of lower case letters in the string word
			int lower_freq = word[pos]-'a';
			freq[lower_freq]++;
		}

		if(word[pos]>='A' && word[pos]<='Z'){                //Checks the frequency of upper case letters in the string word
			int upper_freq = word[pos]-'A';
			freq[upper_freq]++;
		}
	}
   
}

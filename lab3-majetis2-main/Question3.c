#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Questions.h"




char **read_words(const char *input_filename, int *nPtr){

	
    char **word_list;

    /*write your implementation here*/

    FILE *words_file = fopen(input_filename,"r");
    fscanf(words_file,"%d",nPtr);                           //Scanning the first line and storing the number in nPtr

    word_list = malloc(*(nPtr)*sizeof(*word_list));		    //Using malloc to create an array of strings, which is word_list here

    for(int i=0;i<*(nPtr);i++){
    	char word[30];                                     //Using word and scanning the string into the file
    	fscanf(words_file,"%s",word);
    	word_list[i] = malloc(strlen(word)*sizeof(char));   //Using strlen() function allocating memory for strings in word_list
    	strcpy(word_list[i], word);                         //Using strcpy() copying the word into the word_list[i]
    }

    return word_list;

}

int compare_str(const char *str1,const char *str2){

	/*this is a helper function that you can implement and use to facilitate your development*/
   	/*compare_str alphabetically compares two strings.
    	If str2 is alphabetically smaller than str1 (comes before str1),
    	the function returns a 1, else if str1 is smaller than str2, the
    	function returns a 0.*/

	/*write your implementation here and update the return accordingly*/
	int i;

	int size_str1 = strlen(str1);
	int size_str2 = strlen(str2);

	int sort = 0;

	//Comparing strings when size of string one is greater than size of string two
	if(size_str1>size_str2){
		sort = 1;
		for(i=0;i<strlen(str2);i++){
			int str1_val = str1[i];
			int str2_val = str2[i];
			if(str1_val!= str2_val ){
				if(str1_val>str2_val){
					sort = 1;
					break;
				}
				else{
					sort = 0;
					break;
				}

			}
		}
	}


	//Comparing strings when both sizes are same
	else if(size_str1==size_str2){
		for(i=0;i<strlen(str2);i++){
			int str1_val = str1[i];
			int str2_val = str2[i];
			if(str1_val!= str2_val ){
				if(str1_val>str2_val){
					sort = 1;
					break;
				}
				else{
					sort = 0;
					break;
				}

			}
		}

	}


	//Comparing strings when size of string two is greater than size of string one
	else{
		for(i=0;i<strlen(str1);i++){
		int str1_val = str1[i];
		int str2_val = str2[i];
		if(str1_val!= str2_val ){
			if(str1_val>str2_val){
				sort = 1;
				break;
			}
			else{
				sort = 0;
				break;
			}

		  }
		}
	}

	return sort;					//returns 0 if str2 is not alphabetically smaller than str1
 }

void sort_words(char **words, int size){
   
	/*Insertion sort is an algorithm that splits the array into sorted and unsorted subset.
	  There is only one element in the sorted  initially and it is the first element with index zero.
	  The elements from unsorted subset are placed correctly into the sorted subset by comparing it to the elements
	  present in the sorted subset.
	  The algorithm is completed when there are no elements left in the unsorted subset.
	*/
	/*write your implementation here*/
	int pos;

	for(pos=1;pos<size;pos++){
		char*current;                             //the element we want to move from sorted to unsorted
		current = words[pos];
		int psort;
		for(psort=pos-1; psort>=0;psort--){
			if(compare_str(words[psort],current)==0){            //checking which position to place the element through using compare_str function
				break;
			}
			words[psort+1] = words[psort];
		}
		words[psort+1] = current;
	}
}

void swap(char **str1, char **str2){
 
	/*this is a helper function that you can implement and use to facilitate your development*/
	//swaps two string using a temporary pointer
	char *temp;
	temp = *str1;
	*str1 = *str2;
	*str2 = temp;

}

void sort2_words(char **words, int size){
	/*Selection sort is an algorithm that finds the minimum element repeatedly and puts that in the beginning of the
	  array of strings.
	  Same like Insertion sort selection sort divides the array into two subsets sorted and unsorted.
	  The process stops until there are no elements in unsorted list.
	*/

	/*write your implementation here*/
    int pos_1,pos_2,min_index;
    char first_str[100];       //String to store the first string
    for(pos_1=0;pos_1<(size)-1;pos_1++){
    	min_index = pos_1;               //Initializing minimum index to i
    	strcpy(first_str,words[pos_1]);
    	for(pos_2=pos_1+1;pos_2<size;pos_2++){
    		if(compare_str(first_str,words[pos_2])==1){            //Figuring out the minimum index
    			strcpy(first_str,words[pos_2]);
    			min_index = pos_2;
    		}
    	}

    	if(min_index!=pos_1){                                    //If minimum index is not equal to i
    		swap(&words[pos_1],&words[min_index]);               //Swapping the first word in array with the new minimum string
    	}
    }
}


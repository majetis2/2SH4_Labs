#include <stdio.h>
#include <stdlib.h>
#include "Questions.h"


void efficient(const int source[], int val[], int pos[], int size){
	int pos_nzero=0;                                   //Initializing position of non zero numbers to zero
	int pos_s;
	for(pos_s=0;pos_s<size;pos_s++){
		if(source[pos_s]!=0){
			val[pos_nzero] = source[pos_s];           //Adding the value of nonzero numbers to val array
			pos[pos_nzero] = pos_s;                   //Adding the position of nonzero numbers to pos array
			pos_nzero+=1;
		}
	}
}

void reconstruct(int source[], int m, const int val[], const int pos[], int n){
	int pos_s;                                                   //Initiating position of the sparse vector

    for(pos_s=0;pos_s<n;pos_s++){
    	source[pos[pos_s]] = val[pos_s];                        //Adding the nonzero value numbers to their corresponding position
    }
	

}

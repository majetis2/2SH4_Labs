#include <stdio.h>
#include <stdlib.h>

#include "Questions.h"

void diag_scan(int mat [][N3], int arr []){

	int row;
	int col;
	int pos=0;                                 //Initializing position to zero

	for (row=0;row<N3;row++){                  //adding row diagonals to the array arr
		for (col=0;col<=row;col++){
			arr[pos]= mat[row-col][col];
			pos += 1 ;
		}
	}

	for(col=(N3-1);col>=1;col--){                        //adding column-1 diagonals to array arr
		for(row=1;row<=col;row++){
				arr[pos]= mat[N3-row][(N3-1)-col+row] ;
				pos += 1 ;
			}
	}
}



	


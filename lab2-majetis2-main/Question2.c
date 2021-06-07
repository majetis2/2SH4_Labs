#include <stdio.h>
#include <stdlib.h>

#include "Questions.h"
#include "math.h"


int is_diag_dom(int mat[][N2]){

    //this is the flag that is returned to tell whether the mat is diagonally
	int isDiag=0;
	
	//write your code below
	//Return 1 if the matrix is diagonally dominant and 0 otherwise
	int diag_dom = 0;                                //Initializing diag_dom to zero
	int pos_row,pos_col;

	for (pos_row=0;pos_row<N2;pos_row++){            //for loop to go over each row
		int diag_num, row_sum = 0;				     //Initializing diagonal number and row sum to zero
		for(pos_col=0;pos_col<N2;pos_col++){
			if(pos_row==pos_col){
				diag_num = fabs(mat[pos_row][pos_col]);
			}
			else{
				row_sum += fabs(mat[pos_row][pos_col]);
			}
		}
		if (diag_num>row_sum){                    //Checking if the diagonal number is greater than the sum of the row
			diag_dom++;
		}
	}
	
	if (diag_dom == 3){                         //Checking if all rows are diagonally dominant
		isDiag = 1;                             //If the matrix is diagonally dominant changing isDiag to 1
	}

    return isDiag;
}

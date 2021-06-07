#include <stdio.h>
#include <stdlib.h>
#include "Questions.h"


void addEff(int val1[], int val2[], int val3[], int pos1[], int pos2[], int pos3[], int k1, int k2){

	int count = 0 ;
	int counter = 0 ;
	int search = 0 ;

	//Initializing all elements of pos3 and val3 to zero
	for (int k=0;k<k1+k2;k++)
	{
		val3[k] = 0 ;
	    pos3[k] = 0 ;
	}

	//Searching for common elements in both pos1 and pos2 arrays and adding them
	for (int i=0;i<k1;i++)
	{
		for (int j=0;j<k2;j++)
	    {

			if (pos1[i] == pos2[j])
			{
				if (val1[i]+val2[j] != 0)             //The position and value is added pos3[] and val3[] only if the sum is not zero
				{
					pos3[count] = pos1[i] ;
					val3[count] = val1[i] + val2[j] ;
					count += 1 ;
					break ;
				}
			}
	    }
	}

	counter=count ;

	//Adding non-common elements from pos1[] and val1[] to pos3[] and val3[]
	for (int i=0; i<k1; i++)
	{
		search = 0 ;

		for (int k=0;k<=count;k++)
	    {
			if (pos1[i] == pos3[k])
	        {
				search=1;
	            break ;
	        }
	    }

	    if (search == 0)
	    {
	    	for (int j=0;j<k2;j++)
	        {
	    		if (pos1[i] != pos2[j])
	    		{
	    			continue ;
	            }
	    		if (pos1[i] == pos2[j])
	            {
	                    if (val1[i]+ val2[j] == 0)
	                    {
	                    	search = 1;
	                    	break ;
	                    }
	            }

	        }
			if (search == 0)
			{

				pos3[counter] = pos1[i] ;
				val3[counter] = val1[i] ;
				counter += 1 ;
			}
		 }
	}


	count = counter ;

	//Adding non-common elements from pos2[] and val2[] to pos3[] and val3[]
	for (int i=0; i<k2; i++)
	{

		search = 0 ;
	    for (int k=0;k<=count;k++)
	    {
	    	if (pos2[i] == pos3[k])
	        {
	    		search = 1;
	            break ;
	        }
	    }
	    if (search == 0)
	    {
	    	for (int j=0;j<k1;j++)
	        {
	    		if (pos2[i] != pos1[j])
	    		{
	    			continue ;
	            }
	            if (pos2[i] == pos1[j])
	            {
	            	if (val2[i]+ val1[j] == 0)
	            	{
	            		search = 1;
	                	break ;
	            	}
	            }

	         }
	         if (search == 0)
	         {
	        	 pos3[counter] = pos2[i] ;
	             val3[counter] = val2[i] ;
	             if ((counter < k1+k2))
	             {
	            	 counter += 1 ;
	             }

	         }
	     }
	 }


	int temp_size=counter;

	//Sorting the arrays pos3[] and val3[]
	for(int i=0;i<temp_size-1;i++)
	{
		if(pos3[i]!=0){                       //Makes all the zero values go to the end of the arrays pos3[] and val3[]
			for (int j=i+1;j<temp_size;j++)
			{
				if (pos3[i]>pos3[j]){
					int temp_pos;             //Switching elements in pos3[] using temp_pos
					temp_pos = pos3[i];
					pos3[i] = pos3[j];
					pos3[j] = temp_pos;		 //Switching elements in val3[] using temp_val
					int temp_val;
					temp_val = val3[i];
					val3[i] = val3[j];
					val3[j] = temp_val;

				}
			}
		}
	}
}

#include <stdio.h>
#include <stdlib.h>
#include "Questions.h"



student **create_class_list(char *filename, int *sizePtr){
	
	student **class_list;


	/*write your implementation here*/
	FILE *student_file = fopen(filename,"r");
	fscanf(student_file,"%d",sizePtr);

	class_list = calloc(*(sizePtr),sizeof(student*));      //Allocating memory for class list

	int i;
	for(i=0;i<*(sizePtr);i++){
		class_list[i] = calloc(1,sizeof(student));          //Allocating memory for all students in class list

		//Scanning the information for all students into class list
		fscanf(student_file, "%d%s%s",&(class_list[i]->student_id),class_list[i]->first_name,class_list[i]->last_name);
	}

	fclose(student_file);

	/* finally return the created class list*/
	return class_list;
}

int find(int idNo, student **list, int size)
{
	
	/*write your implementation here and update the return accordingly*/
	int i;
	for(i=0;i<size;i++){
		if(idNo==list[i]->student_id){          //Checking if there is a student with the given idNo
			return i;                           //Returning the position if there is a student with given idNo
			break;
		}
	}

	return -1;                                 //Returning -1 if there is no such student  found
}

void input_grades(char *filename, student **list, int size)
{

	/*write your implementation here*/
	int find_id[size]; int grade_1[size]; int grade_2[size];
	FILE *grades_file = fopen(filename,"r");
	int i;
	for(i=0;i<size;i++){
		fscanf(grades_file, "%d%d%d",find_id+i,grade_1+i,grade_2+i);
	}

	fclose(grades_file);

	for(i=0;i<size;i++){
		int pos = find(find_id[i],list,size);
		list[pos]->project1_grade = grade_1[i];     //Adding all the project 1 grades into project1_grade
		list[pos]->project2_grade = grade_2[i];		//Adding all the project 2 grades into project2_grade
	}
}

void compute_final_course_grades(student **list, int size)
{
	
	/*write your implementation here*/
	int i;
	for (i=0;i<size;i++){
		list[i]->final_grade = (list[i]->project1_grade + list[i]->project2_grade)/2.0;     //Computing the final grade
	}

}

void output_final_course_grades(char *filename, student **list, int size)
{
	
	/*write your implementation here*/
	FILE *output_file = fopen(filename,"w");
	fprintf(output_file, "%d \n", size);    //Writing the size on the first line of output_file

	int i;
	for (i=0;i<size;i++){
		fprintf(output_file, "%d %g \n", list[i]->student_id, list[i]->final_grade);      //Writing the final grades in output_file
	}

	fclose(output_file);


}


void withdraw(int idNo, student **list, int* sizePtr)
{
	/*write your implementation here*/
	int pos = find(idNo,list,*sizePtr);
	int student_remove = 0;
	if(pos==-1){
		printf("The student is not in the list");
	}

	else{
		student_remove = 1;
		for(int i = pos; i<*(sizePtr)-1;i++){
			list[i]->student_id = list[i+1] ->student_id;
			int str;
			for(str=0; list[i+1]->first_name[str]!='\0';str++){
				list[i]->first_name[str] = list[i+1] ->first_name[str];
			}
			for(str=0; list[i+1]->last_name[str]!='\0';str++){
				list[i]->last_name[str] = list[i+1] ->last_name[str];
			}
			list[i]->project1_grade = list[i+1] ->project1_grade;
			list[i]->project2_grade = list[i+1] ->project2_grade;
			list[i]->final_grade = list[i+1] ->final_grade;
		}
	}

	free(list[*(sizePtr)-1]);           //Deallocating the memory for the withdrawn student information
	*(sizePtr) -= student_remove;       //Changing the size of sizePtr - number of students
}

void destroy_list(student **list, int *sizePtr)
{
	/*write your implementation here*/
	//Freeing all the students first
	for(int i=0;i<*(sizePtr);i++){
		free(list[i]);
	}

	//Freeing the list
	free(list);
	*sizePtr = 0;

}

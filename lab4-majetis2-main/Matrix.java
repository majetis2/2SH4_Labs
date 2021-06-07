public class Matrix {
	
	//comment
    
	private int[][]  matrixData;
	private int    rowsNum;	
	private int    colsNum;	
	
	public Matrix( int row, int col) 
	{   
		/*
		* constructs a row-by-col matrix with
		* all elements equal to 0; if row <= 0, the number of rows of the matrix is set to
		* 3; likewise, if col <= 0 the number of columns of the matrix is set to 3.		
		*/
		
		if (row<=0) {     //Setting row and col to three if row and col is less than or equal to zero
			row=3;
		}
		
		if (col<=0) {
			col=3;
		}
		
		
		rowsNum = row;       //Initializing rowsnum to row
		colsNum = col;       //Initializing colsnum to col
		
		matrixData = new int[rowsNum][colsNum];  //Initializing matrixData
		
	}

	public Matrix( int[][] table) 
	{	

		/*
		* constructs a matrix out of the two dimensional array table, with the same number of rows, columns, and the same
		* element in each position as array table.
		*/ 
		
		rowsNum = table.length;     //Setting rowsnum to array table length
		colsNum = table[0].length;  //Setting colsnum to table[0].length
		
		matrixData = new int[rowsNum][colsNum];
		
		for(int r=0; r<rowsNum; r++) {
			for(int c=0; c<colsNum; c++) {
				matrixData[r][c] = table[r][c];   //Loading the elements of table into matrixData
			}
		}
				
	}
	
	public int getElement(int i, int j) throws IndexOutOfBoundsException
	{ 	
		/*
		* returns the element on row i and column j of this matrix; 
		* it throws an exception (IndexOutOfBoundsException) if any of indexes i and j is not in the required range 
		* (rows and columns indexing starts with 0)
		*  the detail message of the exception should read: "Invalid indexes".
		*/
		
		if((i<rowsNum && i>=0) && (j<colsNum && j>=0)) {   //Checking if the index is valid
			return matrixData[i][j];                       //Returning the element of index [i][j]
		}
		
		else {
			throw new IndexOutOfBoundsException("Invalid indexes.");  //Printing the error message
		}
		
	}
        
    public boolean setElement(int x, int i, int j){ 
            
        /* the detail message of the exception should read: "Invalid indexes" */
    	if((i<rowsNum && i>=0) && (j<colsNum && j>=0)) {  //Checking if the indices are valid
			matrixData[i][j] = x;          //setting the element of index [i][j] to x
			return true;
		}
    	
    	return false;
    } 

    public Matrix copy(){ 
        
    	/* fix the code and write your implementation below */
		Matrix copy = new Matrix (rowsNum,colsNum);
		
		for(int r=0;r<rowsNum;r++) {
			for(int c=0;c<colsNum;c++) {
				copy.matrixData[r][c] = matrixData[r][c];  //Loading all elements of this matrixData into object copy matrixData
			}
		}
        return copy; 
    }    
                
	public void addTo( Matrix m ) throws ArithmeticException
	{
		
		/* the detail message of the exception should read: "Invalid operation". */
		
		if(rowsNum == m.rowsNum && colsNum==m.colsNum) {
			for (int r=0;r<rowsNum;r++) {
				for(int c=0;c<colsNum;c++) {
					matrixData[r][c] += m.matrixData[r][c]; //Adds the elements of matrix m.matrixData to this.matrixData
				}
			}
		}
		
		else {
			throw new ArithmeticException("Invalid operation");
		}
		
	
	}
	
    public Matrix subMatrix(int i, int j) throws ArithmeticException{ 
        
		/* The exception detail message should read: "Submatrix not defined"*/
    	
    	/* fix the code and write your implementation below */
    	Matrix subM = new Matrix(i+1,j+1); //Creates a matrix i+1 * j+1
    	
    	if(i<rowsNum && j<colsNum) {  //Checks if i an j are valid indices
    		for(int r=0;r<i+1;r++) {
    			for(int c=0;c<j+1;c++) {
    				subM.matrixData[r][c]= matrixData[r][c];  //Loading elements from 0 to i and 0 to j into subM.matrixData
    			}
    		}
    		
    	}
		
    	else {
    		throw new ArithmeticException("Submatrix not defined");
    	}
		
        return  subM; 
        
    }
        
    public int getsizeofrows(){ 
           
		/* update below return */
		return rowsNum;    //returns the number of rows of this.matrix
    }
        
    public int getsizeofcols(){
		
		/* update below return */
        return colsNum;  //returns the number of columns of this.matrix
    }
        
    public boolean isUpperTr(){
            
		/* write your implementation here and update return accordingly */
    	boolean isUpper_Tr = true;
    	
    	for(int r=0;r<rowsNum;r++) {
    		for(int c=0;c!=r;c++) {
    			if (matrixData[r][c]!=0){ //Checks whether the elements below diagonal are zero
    				isUpper_Tr = false;   //Returns false if any element below diagonal is not zero
    				break;
    			}
    		}
    	}
    	
        return isUpper_Tr;  //Returns true if this.matrixData is upper triangular matrix
	}
        
    public static Matrix sum(Matrix[] matArray) throws ArithmeticException{
             
        
        int count = 1;
        int rows = matArray[0].getsizeofrows();
        int cols = matArray[0].getsizeofcols();
        
        Matrix superMatrix = new Matrix (rows,cols);
        
        for(int i=1; i<matArray.length; i++) {
        	if(matArray[i].getsizeofrows()==rows && matArray[i].getsizeofcols()==cols) {  
        		count+=1;
        	}
        }
        
        if(count==matArray.length) {     //Checks the dimensions of all matrices
        	for(int pos=0; pos<matArray.length;pos++) {
        		superMatrix.addTo(matArray[pos]); //Adds the matrices elements to superMatrix
        	}
        	
        }
        
        else {
        	throw new ArithmeticException("Invalid operation"); //Throws an error message if dimensions do not match
        }
            
        return superMatrix; 
    }
        
	public String toString(  )
	{
		String output = new String();      
		for(int i=0;i<rowsNum;i++){
			for(int j=0;j<colsNum;j++){
				output = output + String.valueOf(matrixData[i][j]) + " ";   
			}
			output = output + "\n";   
		}
        	
		return output; //Returns the string representation of this.matrixData
	}
    
}
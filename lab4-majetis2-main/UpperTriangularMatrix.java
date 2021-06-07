public class UpperTriangularMatrix {
    private int n;
    private int[] array; //Array that would have efficient representation of the matrix
    public Matrix UpperTriangularMatrix;  //Creates an object UpperTriangularMatrix of Matrix class
    
    public UpperTriangularMatrix(int n){
        if (n<=0) {
        	n=1;
        }
        
        this.n = n;  //Initializes n to number of rows
        
        UpperTriangularMatrix = new Matrix(this.n,this.n); //Initializes object UpperTriangularMatrix
        array = new int[n*(n+1)/2]; //Initializes array 
    }
    
    public UpperTriangularMatrix(Matrix upTrim) throws IllegalArgumentException{
    	if(upTrim.isUpperTr() == true) {
    		UpperTriangularMatrix = upTrim.copy();
    		n = UpperTriangularMatrix.getsizeofrows(); //Initializing n to the number of rows of UpperTriangularMatrix
    		array = new int[n*(n+1)/2];  
            int pos=0;
            for(int r=0;r<n;r++) {
            	for(int c=r;c<n;c++) {
            		array[pos] = UpperTriangularMatrix.getElement(r, c); //Storing all elements that are above diagonal
            		pos++;
            	}
            }
    		
    	}
    	
    	
    	else {
    		throw new IllegalArgumentException("Not an upper triangular Matrix");
    	}
   
    }    
        
    public int getDim(){
        
		
		/* write your implementation here and update return accordingly */
        return UpperTriangularMatrix.getsizeofrows();  //Returns the number of rows of this matrix
    }
    
    public int getElement(int i, int j) throws IndexOutOfBoundsException{
    	
    	if((i<UpperTriangularMatrix.getsizeofrows() && i>=0) && (j<UpperTriangularMatrix.getsizeofcols() && j>=0)) //Checks whether the indices are valid
    	{
    		/* write your implementation here and update return accordingly */
    		return UpperTriangularMatrix.getElement(i, j); //Returns the element of index [i][j] of this matrix
    	}
    	
    	else {
    		throw new IndexOutOfBoundsException("Invalid indexes");
    	}
		
    }
    
    public void setElement(int x, int i, int j) throws IndexOutOfBoundsException,IllegalArgumentException{
    	
    	if((i<UpperTriangularMatrix.getsizeofrows() && i>=0) && (j<UpperTriangularMatrix.getsizeofcols() && j>=0)) //Checks if indices are valid
    	{
    		int flag=0;
    		for(int r=0;r<UpperTriangularMatrix.getsizeofrows();r++) {
    			for(int c=0;c!=r;c++) {
    				if(r==i && c==j) { //Checking if the indices are below diagonal
    					flag = 1; 
    				}
    			}
    		}
    		
    		if(flag==0) {  //If the indices are above diagonal and valid setting the element in that index to x
    			UpperTriangularMatrix.setElement(x, i, j);
    		}
    		
    		else {
    			if(x==0) {   //if the indices are below diagonal and x=0
					UpperTriangularMatrix.setElement(x, i, j); //Setting the element in that index to 0
				}
				
				else {
					throw new IllegalArgumentException("Incorrect Argument"); //If the element is not zero prints an error message
				}
    		}
    		
    		
    		
        }
    	
    	else {
    		throw new IndexOutOfBoundsException("Invalid indexes"); //Returning invalid indexes message
    	}
    
    
    }
    
    public Matrix fullMatrix(){

        Matrix full= new Matrix(n,n);
        full = UpperTriangularMatrix.copy(); //Loading all elements of this matrix into full matrix
        return full; //returns the matrix full
    }
    
   
      
    public String toString(){
       String output= "";
       output = UpperTriangularMatrix.toString(); 
       return output; //returns the matrix representation of this matrix
    }
    
    public int getDet(){
        int det = 1;
        
        for(int pos=0;pos<UpperTriangularMatrix.getsizeofrows();pos++) 
        {
        	det = det * UpperTriangularMatrix.getElement(pos, pos);
        }
        
       return det; //returns the determinant of this matrix
    }

    
    public double[] effSolve(double[] b) throws IllegalArgumentException{

        /* fix the following and write your implementation */
    	
    	if(this.getDet()!=0) {  //checking if the determinant is not equal to zero
    		if(b.length==this.n) {  //checks if n of this matrix matches the b.length
    			double[] sol = new double[n]; //creating a solution array of size n
    			for(int r=0;r<n;r++) {
    				double sol_item = 0;
    				for(int c=n-1;c>(n-1)-r;c--) {
    					sol_item = sol_item - (this.getElement((n-1)-r,c)*sol[c]);
    				}
    			    sol[(n-1)-r] = (b[(n-1)-r]+sol_item)/this.getElement((n-1)-r, (n-1)-r); //Loading the elements into the solution
    		}
    		return sol;
    		
    	 }
    		
    	else {
    		throw new IllegalArgumentException("The dimension of the matrix is not defined for operation");
    	}
    		 
    	}
     else {
    	 throw new IllegalArgumentException("The determinant of the matrix is 0");
		}
    }   
}
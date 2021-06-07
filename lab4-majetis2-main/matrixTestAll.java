import static org.junit.Assert.*;

import org.junit.Test;



public class matrixTestAll {

	@Test
	public void testConstructor1Invalid1() {
		// for constructor1
		int invalid_row1 = -1, invalid_col1 = -2;
   
		String expected="0 0 0 \n"+"0 0 0 \n"+"0 0 0 \n";
    // test constructor1; invalid inputs
		Matrix a = new Matrix(invalid_row1,invalid_col1);
    
    assertEquals(expected,a.toString()); 
	}
	
	
	@Test
	public void testConstructor1Invalid2() {
		// for constructor1
		int invalid_row2 = 1, invalid_col2 = 0; 
		String expected="0 0 0 \n";
		Matrix b = new Matrix(invalid_row2,invalid_col2);
	
    assertEquals(expected,b.toString());   
 
	}
	

	@Test
	public void testConstructor1Valid() {
    int valid_row = 3, valid_col = 4;
		// test constructor1; valid inputs
		String expected="0 0 0 0 \n"+"0 0 0 0 \n"+"0 0 0 0 \n";
		Matrix d = new Matrix(valid_row,valid_col);
		
    assertEquals(expected,d.toString());  
 
	}
	
	@Test
	public void testConstructor1Valid2() {
    int valid_row = 4, valid_col = 4;
		// test constructor1; valid inputs
		String expected="0 0 0 0 \n"+"0 0 0 0 \n"+"0 0 0 0 \n"+"0 0 0 0 \n";
		Matrix d = new Matrix(valid_row,valid_col);
		
    assertEquals(expected,d.toString());  
 
	}
	
	@Test
	public void testConstructor2() {
	  // for constructor2
    int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		
		String expected= "1 2 3 4 5 \n"+"6 7 8 9 0 \n"+"0 0 1 2 3 \n"+"0 0 0 4 5 \n";
    assertEquals(expected,f.toString());   
 
    }
	
	@Test
	public void testConstructor2_1() {
	  // for constructor2
    int[][] data = {{1,2,3,4,5},{6,7,8,9,10},{0,0,1,2,3},{1,2,6,4,5}};
		Matrix f = new Matrix(data);
		
		String expected= "1 2 3 4 5 \n"+"6 7 8 9 10 \n"+"0 0 1 2 3 \n"+"1 2 6 4 5 \n";
    assertEquals(expected,f.toString());   
 
    }
	
	@Test
	public void testGetElementValid() {
	  // for constructor2
    int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		
		int expected= 9;
    assertEquals(expected,f.getElement(1, 3));   
 
	}
	
	@Test
	public void testGetElementValid_2() {
	  // for constructor2
    int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		
		int expected= 2;
    assertEquals(expected,f.getElement(2, 3));   
 
	}
	
	@Test
	public void testGetElementInvalid() {
	  // for constructor2
    int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		String actual ="Empty for Now";
		try {
			int output = f.getElement(10, 2);	// invalid indexes
		}
		catch (IndexOutOfBoundsException e){
			 actual = e.getMessage();
		}
		
		String expected= "Invalid indexes.";
    assertEquals(expected,actual);   
 
	}
	
	
	@Test
	public void testSetElementValid() {
	  int value = 100;
	  int setvalid_row = 0, setvalid_col = 0;
    int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		boolean check = f.setElement(value,setvalid_row,setvalid_col);
		String expected= "100 2 3 4 5 \n"+"6 7 8 9 0 \n"+"0 0 1 2 3 \n"+"0 0 0 4 5 \n";
    assertEquals(expected,f.toString()); 
    assertEquals(true,check);
 
	}
	
	@Test
	public void testSetElementValid_2() {
	  int value = 120;
	  int setvalid_row = 1, setvalid_col = 0;
    int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		boolean check = f.setElement(value,setvalid_row,setvalid_col);
		String expected= "1 2 3 4 5 \n"+"120 7 8 9 0 \n"+"0 0 1 2 3 \n"+"0 0 0 4 5 \n";
    assertEquals(expected,f.toString()); 
    assertEquals(true,check);
 
	}
	
	
	@Test
	public void testSetElementInvalid() {
	  int value = 100;
	  int setinvalid_row = 10, setinvalid_col = 10;
    int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		boolean check = f.setElement(value,setinvalid_row,setinvalid_col);
		String expected= "1 2 3 4 5 \n"+"6 7 8 9 0 \n"+"0 0 1 2 3 \n"+"0 0 0 4 5 \n";
    assertEquals(expected,f.toString()); 
    assertEquals(false,check);
 
	}		
  	
	@Test
	public void testCopy() {

    int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix origin = new Matrix(data);
    Matrix copied = origin.copy(); // make a copy
    String expected= "1 2 3 4 5 \n"+"6 7 8 9 0 \n"+"0 0 1 2 3 \n"+"0 0 0 4 5 \n";
    assertEquals(expected,copied.toString()); 
	}
	
	@Test
	public void testCopy_2() {

    int[][] data = {{1,2,3,4,5},{6,7,8,9,11},{1,7,1,2,3},{6,7,34,4,5}};
		Matrix origin = new Matrix(data);
    Matrix copied = origin.copy(); // make a copy
    String expected= "1 2 3 4 5 \n"+"6 7 8 9 11 \n"+"1 7 1 2 3 \n"+"6 7 34 4 5 \n";
    assertEquals(expected,copied.toString()); 
	}

	
	@Test
	public void testAddToInvalid() {
		 int[][] add_to_data = {{3,4,5}, {1,2,3}, {0,0,0},{1,2,1}}; // add to 'data' matrix, dimension not match
	   
	    
	   int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		 Matrix f = new Matrix(data);
		 String actual ="Empty for Now";
		 String expected = "Invalid operation";
     Matrix m = new Matrix(add_to_data);


    try{
      m.addTo(f);
      System.out.println(m);
    }
    catch (ArithmeticException e){
    	 actual = e.getMessage();
    }
    assertEquals(expected,actual);
	}
	
	@Test
	public void testAddToValid() {
		 int[][] add_to_data = {{3,4,5}, {1,2,3}, {0,0,0},{1,2,1}}; // add to 'data' matrix, dimension not match
	   int[][] add_to_above = {{1,0,-1}, {2,1,0}, {2,2,2},{0,-1,0}}; // add to 'add_to_data' matrix
	    

     Matrix m = new Matrix(add_to_data);
     Matrix m1 = new Matrix(add_to_above);
     
     String expected = "4 4 4 \n"+"3 3 3 \n"+"2 2 2 \n"+"1 1 1 \n";


    try{
      m.addTo(m1);
      assertEquals(expected,m.toString());
      
    }
    catch (ArithmeticException e){
  	  System.out.println(e);
  	  System.out.println("");
		  fail("supposed to be a valid input");
    }
    
	}
	
	@Test
	public void testAddToValid_2() {
		 int[][] add_to_data = {{3,4,5}, {1,2,4}, {0,-2,0},{1,2,1}}; // add to 'data' matrix, dimension not match
	   int[][] add_to_above = {{4,0,-1}, {2,1,0}, {2,2,2},{-1,-1,0}}; // add to 'add_to_data' matrix
	    

     Matrix m = new Matrix(add_to_data);
     Matrix m1 = new Matrix(add_to_above);
     
     String expected = "7 4 4 \n"+"3 3 4 \n"+"2 0 2 \n"+"0 1 1 \n";


    try{
      m.addTo(m1);
      assertEquals(expected,m.toString());
      
    }
    catch (ArithmeticException e){
  	  System.out.println(e);
  	  System.out.println("");
		  fail("supposed to be a valid input");
    }
    
	}
    

	
	@Test
	public void testSubMatrixValid() {
    int subvalid_row = 3, subvalid_col = 3;

    
	  int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		String expected= "1 2 3 4 \n"+"6 7 8 9 \n"+"0 0 1 2 \n"+"0 0 0 4 \n";
    
		try{
			Matrix y = f.subMatrix(subvalid_row,subvalid_col);
			assertEquals(expected,y.toString());
		}
		catch (ArithmeticException e){
			 System.out.println(e);
			 System.out.println("");
			 fail("supposed to be a valid input");
		}	
		
	}
	
	@Test
	public void testSubMatrixValid_2() {
    int subvalid_row = 2, subvalid_col = 3;

    
	  int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,6,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		String expected= "1 2 3 4 \n"+"6 7 8 9 \n"+"0 0 1 6 \n";
    
		try{
			Matrix y = f.subMatrix(subvalid_row,subvalid_col);
			assertEquals(expected,y.toString());
		}
		catch (ArithmeticException e){
			 System.out.println(e);
			 System.out.println("");
			 fail("supposed to be a valid input");
		}	
		
	}

	
	@Test
	public void testSubMatrixInvalid() {

    int subinvalid_row = 3, subinvalid_col = 6;
    
	  int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
		Matrix f = new Matrix(data);
		String actual ="Empty for Now";
		String expected = "Submatrix not defined";
    
		try{
			Matrix y = f.subMatrix(subinvalid_row,subinvalid_col);
		}
		catch (ArithmeticException e){
			
			actual = e.getMessage();
		}
		assertEquals(expected,actual);
			
		
	}

	
	@Test
	public void testIsUpperTrTrue() {
		//test isUpperTr()	 
    int[][] Upper1 = {{1,4,5},{0,9,8},{0,0,7},{0,0,0}};
    
     	
    Matrix v = new Matrix(Upper1);
    boolean expected = true;
    assertEquals(expected,v.isUpperTr());
    
	}
	
	@Test
	public void testIsUpperTrTrueSquare() {
		//test isUpperTr()	 
    int[][] Upper1 = {{1,4,5},{0,9,10},{0,0,12}};
    
     	
    Matrix v = new Matrix(Upper1);
    boolean expected = true;
    assertEquals(expected,v.isUpperTr());
    
	}

	@Test
	public void testIsUpperTrFalse() {

    int[][] notUpper1 = {{1,4,1,4},{0,7,6,5},{0,1,4,9}};    
     	
    Matrix v = new Matrix(notUpper1);
    boolean expected = false;
    assertEquals(expected,v.isUpperTr());
    
	}
	
	@Test
	public void testIsUpperTrFalseNotSquare() {


    int[][] notUpper2 = {{1,4,1},{1,9,1},{0,2,4}}; // not a square matrix
    
     	
    Matrix v = new Matrix(notUpper2);
    boolean expected = false;
    assertEquals(expected,v.isUpperTr());
    
	}
	
	
	@Test
	public void testSumInvalid() {
    int size=4;
    Matrix[] arr = new Matrix[size];
    for(int i=0; i<size; i++)
      arr[i]=new Matrix(2,3);
    arr[2]= new Matrix(3,3);   // invalid, due to dimension do not match
    
		 String actual ="Empty for Now";
		 String expected = "Invalid operation";
      
    
    
    try{
    	Matrix sum = Matrix.sum(arr);
    }
    
    catch (ArithmeticException e){
    	actual = e.getMessage();
    }
    assertEquals(expected,actual);

	}

	
	@Test
	public void testSumValid() {
		 Matrix[] arr2 = new Matrix[3]; // valid, can change the matrices here
		  int[][] temp1={{1,-1,2}, {1,0,-2}};
		  int[][] temp2={{1,0,1}, {0,1,2}};
		  int[][] temp3={{0,3,-1}, {0,0,1}};
		  arr2[0] = new Matrix(temp1);
		  arr2[1] = new Matrix(temp2);
		  arr2[2] = new Matrix(temp3);
    
		 String expected ="2 2 2 \n"+"1 1 1 \n";
  
    
    
    try{
    	Matrix sum = Matrix.sum(arr2);
			assertEquals(expected,sum.toString());
		}
		catch (ArithmeticException e){
			 System.out.println(e);
			 System.out.println("");
			 fail("supposed to be a valid input");
		}	

	}
	
	
	@Test
	public void testSumValid_2() {
		 Matrix[] arr2 = new Matrix[3]; // valid, can change the matrices here
		  int[][] temp1={{1,-1,2}, {1,0,-2}, {1,-1,2}};
		  int[][] temp2={{1,0,1}, {0,1,2}, {1,0,1}};
		  int[][] temp3={{0,3,-1}, {0,0,1}, {0,3,-1}};
		  arr2[0] = new Matrix(temp1);
		  arr2[1] = new Matrix(temp2);
		  arr2[2] = new Matrix(temp3);
    
		 String expected ="2 2 2 \n"+"1 1 1 \n"+"2 2 2 \n";
  
    
    
    try{
    	Matrix sum = Matrix.sum(arr2);
			assertEquals(expected,sum.toString());
		}
		catch (ArithmeticException e){
			 System.out.println(e);
			 System.out.println("");
			 fail("supposed to be a valid input");
		}	

	}
	
	
	// Now, test UpperTriangularMatrix
	
	@Test
	public void testUpperConstructor1Invalid() {
		
		// test constructor1; invalid input
		// for constructor1  
	  int size_invalid = -5;
		UpperTriangularMatrix m11 = new UpperTriangularMatrix(size_invalid);
    String expected="0 \n";
    assertEquals(expected,m11.toString()); 
	}
	
	
	@Test
	public void testUpperConstructor1Valid() {
		int size_valid = 4;
		UpperTriangularMatrix m11 = new UpperTriangularMatrix(size_valid);
		String expected="0 0 0 0 \n"+ "0 0 0 0 \n"+"0 0 0 0 \n"+"0 0 0 0 \n";
		assertEquals(expected,m11.toString());   
	}
	
	@Test
	public void testUpperConstructor1Valid_2() {
		int size_valid = 3;
		UpperTriangularMatrix m11 = new UpperTriangularMatrix(size_valid);
		String expected="0 0 0 \n"+ "0 0 0 \n"+"0 0 0 \n";
		assertEquals(expected,m11.toString());   
	}
	
	
	@Test
	public void testUpperConstructor2Valid() {
		int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
		Matrix con2_1 = new Matrix(con2_11);
		UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
		String expected="1 2 3 4 5 \n"+ "0 6 7 8 9 \n"+"0 0 10 11 12 \n"+"0 0 0 13 14 \n"+"0 0 0 0 15 \n";
		assertEquals(expected,m3.toString());   
	}
	
	@Test
	public void testUpperConstructor2Valid_2() {
		int[][] con2_11 = {{1,2,3,4,15},{0,6,7,8,9},{0,0,18,11,22},{0,0,0,13,14},{0,0,0,0,15}};
		Matrix con2_1 = new Matrix(con2_11);
		UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
		String expected="1 2 3 4 15 \n"+ "0 6 7 8 9 \n"+"0 0 18 11 22 \n"+"0 0 0 13 14 \n"+"0 0 0 0 15 \n";
		assertEquals(expected,m3.toString());   
	}

	@Test
	public void testUpperConstructor2Invalid() {
		int[][] notupp = {{1,0,0},{2,2,0},{3,3,3}};
		Matrix not = new Matrix(notupp);
		
		String expected="Not an upper triangular Matrix";
		String actual = "Empty for Now";
		 
		
		 try{
             UpperTriangularMatrix m5 = new UpperTriangularMatrix(not);		
         }
		 catch (IllegalArgumentException e){
			 actual = e.getMessage();
		 }
		 assertEquals(expected,actual);
	}
 
	
	@Test
	public void testUpperGetDim() {
		int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
		Matrix con2_1 = new Matrix(con2_11);
		UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
		int expected=5;
		assertEquals(expected,m3.getDim());   
	}
	
	@Test
	public void testUpperGetDim_2() {
		int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14}};
		Matrix con2_1 = new Matrix(con2_11);
		UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
		int expected=4;
		assertEquals(expected,m3.getDim());   
	}

	
	//test getElement()
    
		
		
	@Test
	public void testUpperGetElementValid() {
	  // for constructor2
		int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
		Matrix con2_1 = new Matrix(con2_11);
		UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);

		
		int expected= 8;
		assertEquals(expected,m3.getElement(1, 3));   
 
	}
	
	@Test
	public void testUpperGetElementValid_2() {
	  // for constructor2
		int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
		Matrix con2_1 = new Matrix(con2_11);
		UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);

		
		int expected=11;
		assertEquals(expected,m3.getElement(2, 3));   
 
	}
	
	@Test
	public void testUpperGetElementInvalid() {
	  // for constructor2
		int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
		Matrix con2_1 = new Matrix(con2_11);
		UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
		String actual ="Empty for Now";
		try {
			int output = m3.getElement(10, 2);	// invalid indexes
		}
		catch (IndexOutOfBoundsException e){
			 actual = e.getMessage();
		}
		
		String expected= "Invalid indexes";
		assertEquals(expected,actual);   
 
	}
	
	
	@Test
	public void testUpperSetElementValid() {
	  int value = 100;
	  int setvalid_row = 0, setvalid_col = 0;
	  int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
	  Matrix con2_1 = new Matrix(con2_11);
	  UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
	  
	  try{
		  m3.setElement(value,setvalid_row,setvalid_col);
	  }
	  catch (IndexOutOfBoundsException e){
			 System.out.println(e);
			 System.out.println("");
			 fail("supposed to be a valid input");
	  }
	  String expected="100 2 3 4 5 \n"+ "0 6 7 8 9 \n"+"0 0 10 11 12 \n"+"0 0 0 13 14 \n"+"0 0 0 0 15 \n";
	  assertEquals(expected,m3.toString()); 
	 
 
	}
	
	@Test
	public void testUpperSetElementValid_2() {
	  int value = 150;
	  int setvalid_row = 1, setvalid_col = 2;
	  int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
	  Matrix con2_1 = new Matrix(con2_11);
	  UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
	  
	  try{
		  m3.setElement(value,setvalid_row,setvalid_col);
	  }
	  catch (IndexOutOfBoundsException e){
			 System.out.println(e);
			 System.out.println("");
			 fail("supposed to be a valid input");
	  }
	  String expected="1 2 3 4 5 \n"+ "0 6 150 8 9 \n"+"0 0 10 11 12 \n"+"0 0 0 13 14 \n"+"0 0 0 0 15 \n";
	  assertEquals(expected,m3.toString()); 
	 
 
	}
	
	
	public void testUpperSetElementInvalid() {
		  int value = 100;
		  int setinvalid_row = 10, setvalid_col = 0;
		  int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
		  Matrix con2_1 = new Matrix(con2_11);
		  String actual ="Empty for Now";
		  UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
		  
		  try{
			  m3.setElement(value,setinvalid_row,setvalid_col);
		  }
		  catch (IndexOutOfBoundsException e){
				 actual = e.getMessage();
			}
			
		  String expected= "Invalid index";
		  assertEquals(expected,actual);  
		  
		 
	 
	}
	
	
	@Test
	public void FullMatrix() {

	  int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
	  Matrix con2_1 = new Matrix(con2_11);
	  UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
	  Matrix test_full = m3.fullMatrix();
	  
	  String expected="1 2 3 4 5 \n"+ "0 6 7 8 9 \n"+"0 0 10 11 12 \n"+"0 0 0 13 14 \n"+"0 0 0 0 15 \n";
	  assertEquals(expected,test_full.toString()); 
	 
 
	}
	
	
	@Test
	public void testUpperFullMatrix() {

	  int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
	  Matrix con2_1 = new Matrix(con2_11);
	  UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
	  
	  int expected=1*6*10*13*15;
	  assertEquals(expected,m3.getDet()); 
	 
 
	}
	
	@Test
	public void testUpperFullMatrix_2() {

	  int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,11,11,12},{0,0,0,13,14},{0,0,0,0,15}};
	  Matrix con2_1 = new Matrix(con2_11);
	  UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
	  
	  int expected=1*6*11*13*15;
	  assertEquals(expected,m3.getDet()); 
	 
 
	}

	
	@Test
	public void testUpperEffSolveValid1() {

		 // for effSolve
        double []eff1 = {11,11,3};
        int [][]test1 = {{1,4,2},{0,9,2},{0,0,3}};                
        Matrix mtest1 = new Matrix(test1); // gives x=[5,1,1]
        
        
        
		UpperTriangularMatrix m12 = new UpperTriangularMatrix(mtest1);
		double []actual = m12.effSolve(eff1);
		for(int i=0;i<eff1.length;i++)
            System.out.print(actual[i]+",");
        System.out.println("");
		double []expected={5,1,1};
		for (int indx=0;indx<3;indx++)
			assertEquals(expected[indx],actual[indx],0.001);
	 
 
	}	
	
	@Test
	public void testUpperEffSolveValid2() {

		 // for effSolve
       double []eff1 = {11,11,3};
       int [][]test1 = {{1,4,2},{0,9,2},{0,0,3}};                
       Matrix mtest1 = new Matrix(test1); // gives x=[5,1,1]
       
       double []eff2 = {5,0,5.5,1};
       int [][]test2 = {{1,1,1,1},{0,2,1,1},{0,0,3,2},{0,0,0,2}};                
       Matrix mtest2 = new Matrix(test2); // gives x=[4,-1,1.5,0.5]  
       
       
		UpperTriangularMatrix m12 = new UpperTriangularMatrix(mtest2);
		double []actual = m12.effSolve(eff2);
		double []expected={4,-1,1.5,0.5};
		for (int indx=0;indx<4;indx++)
			assertEquals(expected[indx],actual[indx],0.001);
	 

	}	
	
	@Test
	public void testUpperEffSolveInvalid1() {

		int size_valid = 4;
		UpperTriangularMatrix m2 = new UpperTriangularMatrix(size_valid);
		
      
		double []eff2 = {5,0,5.5,1};
		String expected="The determinant of the matrix is 0";
		String actual="Empty for now";
      
		try{
			double []x3 = m2.effSolve(eff2);		
		}
		catch (IllegalArgumentException e){
			actual = e.getMessage();
		} 
      
		assertEquals(expected,actual);
	 

	}
	
	@Test
	public void testUpperEffSolveInvalid2() {

		double []eff1 = {11,11,3};
             

		int [][]test2 = {{1,1,1,1},{0,2,1,1},{0,0,3,2},{0,0,0,2}};                
		Matrix mtest2 = new Matrix(test2); // gives x=[4,-1,1.5,0.5]  
		String expected="The dimension of the matrix is not defined for operation";
		String actual="Empty for now";   
	       
		UpperTriangularMatrix m12 = new UpperTriangularMatrix(mtest2);
		try{
			double []x3 = m12.effSolve(eff1);		
		}
		catch (IllegalArgumentException e){
			actual = e.getMessage();
		} 
      
		assertEquals(expected,actual);
	 

	}
	
	@Test
	public void testUpperEffSolveInvalid3() {

		int size_valid = 3;
		UpperTriangularMatrix m2 = new UpperTriangularMatrix(size_valid);
		
      
		double []eff2 = {5,0.7,5.5,1};
		String expected="The determinant of the matrix is 0";
		String actual="Empty for now";
      
		try{
			double []x3 = m2.effSolve(eff2);		
		}
		catch (IllegalArgumentException e){
			actual = e.getMessage();
		} 
      
		assertEquals(expected,actual);
	 

	}
	
}


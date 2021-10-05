
package arrays_calculator;
import java.util.*;
import java.io.*;
public class arrays_calculator {
 public static void main(String args[])
 {
	int ch;//variable to store the choice
	PrintStream ps =System.out;
	Scanner sc= new Scanner(System.in);
	boolean stat=true; // option that will allow user to exit the calculator 
	while(stat)//loop will keep running as long as stat variable is true
	{
		ps.print("MATRIX CALCULATOR PROGRAM\n"+"1. To Create new Matrix\n"+"2.to exit calculator\n");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:stat=CreateProblem(ch);// invokes the CreateProblem method 
		       // the boolean value (stat) will indicate whether the calculator should stop or keep running 
		break;
		case 2: stat= false; // if user type 2 then calculaor will exit 
		break;
		default: stat=false ;// if any other input is entered the calculator will close
		break;
		}
		
	}
	ps.println("Calcultor now terminated");
 }
 /* this method starts the matrix calculator
   and invokes method that allows user to enter  matrices values
  */
 public static boolean CreateProblem(int i)
 {
	 PrintStream ps =System.out;
	 Scanner sc =new Scanner(System.in);
	 boolean stat=true,condition=true;
	 int  ch;
	 int frows,fcoloumns,srows,scoloumns; //variables to set the dimensions of two matrices
	 int matrix1[][];
	 int matrix2[][];
	 int matrix1values[][];
	 int matrix2values[][];
	 // set the dimensions of matrix
	 ps.println("Enter the rows of Matrix1:");
	 frows=sc.nextInt();
	 ps.println("Enter the coloumns of Matrix1:");
	 fcoloumns=sc.nextInt();
	 ps.println("Enter the rows of Matrix2:"); 
	 srows=sc.nextInt();
	 ps.println("Enter the coloumns of Matrix2:");
	 scoloumns=sc.nextInt();
	 //invoking method to create the matrix with given dimension and allocate the memory according to it
	 matrix1=CreateMatrix(frows,fcoloumns);
	 //set the values in the matrices
	 matrix1values=SetValues(matrix1,"first");
	 
	 matrix2=CreateMatrix(srows,scoloumns);
	 matrix2values=SetValues(matrix2,"second");
	 while (stat)//as long as stat is true this loop will run
	 {
		 ps.println("Enter the operator");
		 ps.println("1.Addition");
		 ps.println("2.Subtraction");
		 ps.println("3.Multiplication");
		  ch=sc.nextInt();//variable to store the value of operator
		 stat=Matrixoperation(ch,matrix1values,matrix2values);//invoking method Matixoperation to operate on two matrices
	 }
	 //allows user to go to main menu
	 ps.println("1. to continue the calulator");
	 ps.println("2. to exit the calculator");
	 int option=sc.nextInt();//variable to store the value 
	 switch(option)
	 {
	 case 1: condition =true ;
	 break;
	 case 2: condition= false;
	 break;
	 }
	
	 return condition;
	 }
     // method to invoke the method that will perform matrix operation
 public static boolean Matrixoperation(int operator,int matrix1[][],int matrix2[][])
 {
	 PrintStream ps1=System.out;
	 Scanner sc1 =new Scanner(System.in);
	 boolean condition=false;
	 switch(operator)
	 {
	 case 1: AddMatrices(matrix1,matrix2);
	 break;
	 case 2: SubtractMatrices(matrix1,matrix2);
	 break;
	 case 3: MultiplyMatrices(matrix1,matrix2);
	 break;
	 default: ps1.println("invalid operator");
	 break;
	 }
	 ps1.println("1. if you  would like to perform additional operation on same matrix");
	 ps1.println("2.if you would like to use different set of matirces ");
	 ps1.println("3.if you want to exit the calculator");
	 int opt=sc1.nextInt();
	 switch(opt)
	 {
	 case 1: condition =true;
	 break;
	 case 2: condition= false;
	 break;
	 case 3: condition =false;
	 break;
	 }
	 
	 return condition;
  }
 public static int[][] CreateMatrix(int rows,int coloumns)
 {
	 int matrix[][]=new int[rows][coloumns];
	 return matrix;
 }
 public static int[][] SetValues(int matrix[][], String label)
 {
	
	 Scanner sc2 =new Scanner(System.in);
	 int i,j;
	 int rows=matrix.length;
	 int coloumns=matrix[0].length;
	 for(i=0;i<rows;i++)
	 {
		 for(j=0;j<coloumns;j++)
		 {
			 System.out.println("Enter the values of matrix"+label+"of rows"+i+"and coloumns"+j+":");
			 int data= sc2.nextInt();
			 matrix[i][j]=data;
		 }
	 }
	 
	 return matrix;
 }
 public static void AddMatrices(int matrix1[][], int matrix2[][])
 {
	 int numRows1 = matrix1.length;
		int numColumns1 = matrix1[0].length;
		int numRows2 = matrix2.length;
		int numColumns2 = matrix2[0].length;
		if(numRows1 == numRows2 && numColumns1 == numColumns2){
			for(int i = 0; i < matrix1.length; i++){
				for(int j = 0; j < matrix1[0].length; j++){
					int charM1 = matrix1[i][j];
					int charM2 = matrix2[i][j];
					int resultant = charM1 + charM2;
					System.out.print(resultant+" ");
				}
				System.out.print("\n");
			}
		}
		else{
			System.out.println("In order to add or subtract matrices they both must have the same number of rows \n and the same number of columns");
			
		}
 }
 public static void SubtractMatrices (int matrix1[][], int matrix2[][])
 {
	 int numRows1 = matrix1.length;
		int numColumns1 = matrix1[0].length;
		int numRows2 = matrix2.length;
		int numColumns2 = matrix2[0].length;
		if(numRows1 == numRows2 && numColumns1 == numColumns2){
			for(int i = 0; i < matrix1.length; i++){
				for(int j = 0; j < matrix1[0].length; j++){
					int charM1 = matrix1[i][j];
					int charM2 = matrix2[i][j];
					int resultant = charM1 - charM2;
					System.out.print(resultant+" ");
				}
				System.out.print("\n");
			}
		}
		else{
			System.out.println("In order to add or subtract matrices they both must have the same number of rows \n and the same number of columns");
			
		}
 }
 public static void MultiplyMatrices(int matrix1[][], int matrix2[][])
 {
	 int columns = matrix1[0].length;
		int rows = matrix2.length;
		if( columns == rows){
			
			for(int i=0; i<matrix1.length; i++){
				int total = 0;
				for(int j = 0; j<matrix2[0].length; j++){
					int fnum = matrix1[i][j];
					int snum = matrix2[j][i];
					int product = fnum*snum;
					total += product;
				}
				System.out.print(total+" ");
				
			}
		}else{
			System.out.println("Invalid Input");
		}
		
 }

}

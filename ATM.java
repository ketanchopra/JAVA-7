import java.util.* ;
import java.io.* ;

class InvalidPinException extends Exception //User defined Exception 
{ 
   
} 
class InsufficientBalanceExcpetion extends Exception //User defined Exception  
{ 
   
}
class CashShortageException extends Exception //User defined Exception 
{
	
}
class NotMultipleException extends Exception //User defined Exception 
{
	
}
class Inter_bank extends Exception
{

	
	
	
}
class Invalid_Option extends Exception
{
	
}



public class ATM {
	public static void main(String []args)
	{
		String name ; //user account name
		double AC_bal ; // user initial account balance
		int pass, user_pass; 
		int count=0;
		double Machine_bal=100000; //amount in machine
		int choice = 0;
		double depositAmt , withdrawAmt = 0;
		
		Scanner in = new Scanner(System.in);
		
		//Taking User Input
		System.out.println("\nPlease enter the account details to create an account\n");
		System.out.println("Enter your name\n");
		name=in.nextLine();
		System.out.println("Enter your account balance\n");
		AC_bal=in.nextDouble();
		System.out.println("Enter your 4 digit password\n");
		pass=in.nextInt();
		while(true)
		{
			try
			{
			count++;
			if(count==4)
			{
				throw new Inter_bank();
				//break;
			}
			}
			catch(Inter_bank ib)
			{
				System.out.println("The transaction limit exceeded!Thanks for using My Atm");
				System.exit(0);
			}
			//Home screen of ATM
		System.out.println("\n******************Welcome*********************\n");
		System.out.println("Please choose the desired option\n");
		 System.out.print("Please Choose From the Following Options:"
                 + "\n 1. Display Balance \n 2. Deposit"
                 + "\n 3. Withdraw\n 4.Log Out\n\n");
		
		
			choice=in.nextInt();
		switch(choice)
		 {
		 case 1:
                
			 //Case for Displaying the balance
             try {


			 System.out.println("Please enter your password");
             
             user_pass = in.nextInt();
             if (user_pass!=pass) // Matching of entered password with Original Password
            	 throw new InvalidPinException();
             }
             catch(InvalidPinException ipe)
             {
            	 System.out.println("Invalid Pin!Please reenter your password");
            	 user_pass = in.nextInt();
             }
             
             
			 displayBalance(AC_bal); //Displaying account balance
             break;
         case 2:
        	 //Case for Depositing money in the bank account
        	
             System.out.print("\nEnter Amount You Wish to Deposit: $ ");
             depositAmt = in.nextDouble();
             AC_bal=deposit(depositAmt, AC_bal);//function invoked to add the deposited amount to balance
             
             break;
         case 3:
        	 
        	 
        	 //Case for Withdrwal of money
             try {
            	 
            	 
            	 System.out.print("\nEnter Amount You Wish to Withdrawl: $ ");
             withdrawAmt = in.nextDouble();
             if(withdrawAmt>AC_bal)//checking  of Withdrawl amount with Current Balance in Account
            	 throw new InsufficientBalanceExcpetion();
             if(withdrawAmt>Machine_bal) //Checking of withdrawl amount with Cash present in the machine
            	 throw new CashShortageException();
             if(withdrawAmt%200!=0||withdrawAmt%2000!=0||withdrawAmt%500!=0)
            	 throw new NotMultipleException();
             }
             catch(InsufficientBalanceExcpetion ibe)
             {
            	System.out.println("Insufficient Balance!Please reenter the amout to be withdrawn");
            	withdrawAmt = in.nextDouble();
             }
             catch(CashShortageException cse)
             {
            	 System.out.println("Cash Shortage!Please reenter the amout to be withdrawn");
             	withdrawAmt = in.nextDouble();
             }
             catch(NotMultipleException nme)
             {
            	 System.out.println("Error! Please enter the amount in the multiple of 200,500 or 2000");
             	withdrawAmt = in.nextDouble();
             }
             
             
             
            AC_bal = withdraw(AC_bal, withdrawAmt); //Function invoked to deduct the withdrawl amount and display new balance
             break;
         case 4:
        	 // Case for Exit
             System.out.print("\nThank For Using My ATM.  Have a Nice Day.  Good-Bye!");
             System.exit(0);
             break;
         default:
        	 try {
				throw new Invalid_Option();
        	 }
        	 catch(Invalid_Option io)
        	 {
        		 System.out.println("It is an invalid option ! Please reenter ");
        		 choice=in.nextInt();
        	 }
		 }
		 
		}
		
		
	}

	public static void displayBalance(double AC_bal) //Displaying the current balance
	{
		System.out.printf("\nYour Current Balance is $%.2f\n", AC_bal);
		
	}
	public static double deposit(double x, double y) //Depositing the amount in the account
    {
        double depositAmt = y, AC_bal = x;
        double newBalance = depositAmt + AC_bal; // Adding deposited amount to current account

        System.out.printf("Your New Balance is $%.2f\n",  newBalance);

        return newBalance;
    }
	public static double withdraw(double x, double y) //Withdrawing  the amount from the account
    {
        double withdrawAmt = y, AC_bal = x, newBalance;

        newBalance = AC_bal - withdrawAmt; //Updating the current balance
        System.out.printf("Your New Balance is %.2f\n",newBalance);

        return newBalance;  
    }
	

}


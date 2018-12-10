import java.util.*;
public class Lottery_Application {

	int lotteryNumbers[]=new int[5];
	
	Lottery_Application()
	{
		Random rad= new Random();
		for(int i=0;i<5;i++)
		{
			lotteryNumbers[i]=rad.nextInt(10)+0;
			
		}
	}
	void lottery_pick(int arr[])
	{
		System.out.println("Enter 5 numbers");
		Scanner input = new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
			System.out.println("enter "+(i+1)+"th number");
			arr[i]=input.nextInt();
		}
	}
	void compare(int arr[])
	{
		int count=0;
		for(int i=0;i<5;i++)
		{
			if(arr[i]==lotteryNumbers[i])
				count++;
		}
		System.out.println("The number of digits matching are: "+count);
		if(count==5)
			System.out.println("Congrats! you are a grand prize winner");
	}
	
	int[] copy()
	{
		// Function to copy the array made using random numbers
		int cp[]= new int[5];
		for(int i=0;i<5;i++)
		{
			cp[i]=lotteryNumbers[i];
		}
		return cp;
	}
	public static void main(String[] args)
	{
		//Creating an object of the class
		Lottery_Application l=new Lottery_Application();
        //Creating an array of ints 
		int arr[]=new int[5];
		//Taking entries from user
		l.lottery_pick(arr);
		//passing to a function to compare the user array and the array generated
		//using random numbers
		l.compare(arr);
		//Copying 
		int cpy[]=new int[5];
		cpy=l.copy();
	}
}

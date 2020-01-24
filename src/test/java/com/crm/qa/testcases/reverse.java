package com.crm.qa.testcases;

public class reverse {

	public static void main(String[] args) {
		
		int n=14;boolean flag=true;
		
		int m=n/2;
		
		if(n==0 || n==1)
			System.out.println("Not prime");
		else
		{	
			for(int i=2;i<=m;i++)
			{
				if(n%i==0)
				{
					flag=false;
					System.out.println("not prime");
					break;
				}
			}
			
		if(flag)
			System.out.println("Prime");
		}
			
	}

}

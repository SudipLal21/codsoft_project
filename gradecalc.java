import java.util.Scanner;
class gradecalc
{
	public static void main(String args[])
	{
	   Scanner in = new Scanner(System.in);//let number of subjects be 6
       System.out.println("enter marks of subject 1");
       double m1 = in.nextDouble();
       System.out.println("enter marks of subject 2");
       double m2 = in.nextDouble();
       System.out.println("enter marks of subject 3");
       double m3 = in.nextDouble();
       System.out.println("enter marks of subject 4");
       double m4 = in.nextDouble();
       System.out.println("enter marks of subject 5");
       double m5 = in.nextDouble();
       System.out.println("enter marks of subject 6");
       double m6 = in.nextDouble();
         /* if Avg marks>=80, grade='A'
            if Avg marks<80 and >=60, grade='B'
            if Avg marks<60 and >=40, grade='C'*/
        
           double sum = m1+m2+m3+m4+m5+m6;
           System.out.println("Sum of marks = "+sum);
           double avg = sum/6;
           System.out.println("Average percentage = "+avg);
            if(avg>=80)
          {
        	System.out.println("Grade is A");
          }
            else if(avg<80 && avg>=60)
          {
            System.out.println("Grade is B");
          }
            else
          {
        	System.out.println("Grade is C");
          }
    }
}

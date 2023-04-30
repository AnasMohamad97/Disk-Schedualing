import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Compare {
  
	public static int start , total_time ;
	public static ArrayList<Integer> queue = new ArrayList<>();
    public static int Size = queue.size();
    public static boolean vis[]  ;
    public static ArrayList<Integer> Seq = new ArrayList<>();
    public static  int START ;

    
    
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
    
    public static void intialize()
    {
        Size =  queue.size();
        vis = new boolean [Size];
        for(int i = 0 ; i < Size ; ++i)
        {
        	vis[i] = false;
        }
        total_time = 0;
        start =START;
        Seq.clear();
    }
    
    public static boolean  check()
    {
    	int cnt = 0;
    	boolean state = true;
		for(int i = 0 ; i < Size ; ++i)
		{
			if(vis[i] == true)cnt++;
		}
		if(cnt != vis.length )state = false;
		
		return state;
		
    }
    
    
	public static void FCFS() 
	{
    	intialize();
		int total_time = Math.abs(start-queue.get(0));
		
       for(int i = 0 ; i < queue.size()-1 ; ++i)
       {
    	   total_time+=Math.abs(queue.get(i) - queue.get(i+1));
       }
       System.out.println("the sequence of head movement : ");
       
       for (Integer num : queue) { 		      
           System.out.print(num+" "); 		
      }
		 System.out.print("\n");
       System.out.println("the total head movement : " + total_time);

	}
	
	
	public static void SSTF() 
	{
		intialize();

		int curr = start,prev =start;
		int pos = 0;
		
		while( true )
		{
		int mn = 999999999;
		boolean ok = check();
		
		if(ok)
			break;
		
		
		for(int i = 0 ; i < queue.size() ; ++i)
		{
			if( (Math.abs( curr - queue.get(i) ) < mn) && vis[i] == false )
			{
				mn = Math.abs( curr - queue.get(i) );
				pos = i;
			}
		}
		curr = queue.get(pos);
		vis[pos] = true;
		total_time+=mn;
		Seq.add(queue.get(pos));
		}
		
		System.out.println("the sequence of head movement : ");
		 for (Integer num : Seq) { 		      
	           System.out.print(num+" "); 		
	      }
		 System.out.print("\n\n");
	    System.out.println("the total head movement : " + total_time);
			
	}
	
	
	public static void SCAN() 
	{
		intialize();
		queue.add(start);
		queue.add(0);
		Collections.sort(queue);
		Size +=2;
		
		int pos = queue.indexOf(start);
		Seq.add(start);
		for(int i = pos ; i > 0 ; --i)
		{
			total_time += Math.abs( queue.get(i)-queue.get(i-1) );
			Seq.add(queue.get(i-1));
		}
		start = 0;
		
		for(int i = pos+1 ; i < Size ; ++i)
		{
			total_time += Math.abs(start - queue.get(i));
			Seq.add(queue.get(i));
			start = queue.get(i);
		}
		
		System.out.println("the sequence of head movement : ");
		 for (Integer num : Seq) { 		      
	           System.out.print(num+" "); 		
	      }
		 System.out.print("\n");
		    System.out.println("the total head movement : " + total_time);
				

		
	}
	public static void C_SCAN() 
	{
		intialize();
		queue.add(start);
		queue.add(0);
		Collections.sort(queue);
		
		Size+=2;
		
		Seq.add(start);
		int pos = queue.indexOf(start);
		
		total_time += Math.abs(queue.get(pos) - queue.get(pos-1));
		Seq.add(queue.get(pos-1));
		
        // System.out.println(queue.size() + " " +Size);
        int li = 0,ri= 0;
		for(int i = pos-1;  ; --i)
		{
			
			
			if(i < 0)
			{
				li = ((i%Size)+Size);
			}
			else {
				li = i%Size;
			}
			if(i-1 < 0)
			{
				ri = (( (i-1)%Size )+Size);
			}
			else 
			{
			  ri = (i-1)%Size;
			}

		if(li == pos || ri == pos )break;

		total_time += Math.abs( queue.get(li) - queue.get(ri));
		Seq.add(queue.get(ri));
		
		}
		//Seq.remove(Seq.size()-1);
		System.out.println("the sequence of head movement : ");
		 for (Integer num : Seq) { 		      
	           System.out.print(num+" "); 		
	      }
		 System.out.print("\n");
	    System.out.println("the total head movement : " + total_time);
			
		
		
	}
	
	
	public static void C_LOOK() 
	{
		intialize();
		queue.add(start);
		Collections.sort(queue);
		Size+=1;
		
		int pos = queue.indexOf(start);
		Seq.add(start);
		
		total_time =Math.abs(queue.get(pos) - queue.get(pos-1));
		Seq.add(queue.get(pos-1));
		
	       int li = 0,ri= 0;
		
	for(int i = pos-1 ;  ; --i)
	{
			
			
			
			if(i < 0)
			{
				li = ((i%Size)+Size);
			}
			else {
				li = i%Size;
			}
			if(i-1 < 0)
			{
				ri = (( (i-1)%Size )+Size);
			}
			else 
			{
			  ri = (i-1)%Size;
			}
	        if(li == pos || ri == pos )break;

			total_time += Math.abs( queue.get(li) - queue.get(ri));
			Seq.add(queue.get(ri));
		}
		
	  //  Seq.remove(Seq.size()-1);
		System.out.println("the sequence of head movement : ");
		 for (Integer num : Seq) { 		      
	           System.out.print(num+" "); 		
	      }
		 System.out.print("\n");
	    System.out.println("the total head movement : " + total_time);
			
		
	}
	
	
	public static void NOA() {
		intialize();
		Collections.sort(queue);
		start = 0;
		Seq.add(0);
		
		for(int i = 0; i < Size ; ++i)
		{
			total_time += queue.get(i)-start;
			start = queue.get(i);
			Seq.add(queue.get(i));
		}
		
		System.out.println("the sequence of head movement of the NOA : ");
		 for (Integer num : Seq) { 		      
	           System.out.print(num+" "); 		
	      }
		 System.out.print("\n");
	    System.out.println("the total head movement OF the NOA : " + total_time);
			
		
	} //newly optimized algorithm
	
	




	//38 180 130 10 50 15 190 90 150	
	
	//98 137 122 183 14 133 65 78
	//50
	
	public static void main(String[] args) throws IOException {
		 
		while(true)
		{
			int c;

			
			Scanner scan = new Scanner(System.in);
			System.out.println("1-Enter\n2-Exit \n\n");
			System.out.println("1-Enter : ");

            c = scan.nextInt();
            if(c==1) {
            	
            
			System.out.println("Enter the I/O Queue Size : ");
			int s = scan.nextInt();
			
			System.out.println("Enter the I/O Queue : ");
			queue.clear();
			for(int i = 0 ; i < s ; ++i)
			{
				int v ; 
				v  = scan.nextInt();
				queue.add(v);
			}
			
			 
			
			System.out.print("Enter the Start : " );
			start = scan.nextInt();
			System.out.print("\n");
			
		
			START = start;
			
			while(true)
			{
				
			System.out.println("choose the Algorithm to compare with the (Newly Optimized Algorithm) \n ");
           	System.out.println("");

			System.out.println("1-FCFS \n2-SSTF\n3-SCAN\n4-C_SCAN\n5-C_LOOK\n6-EXIT or reenter the data\n");
			System.out.print(" Enter your choice : ");
			int choice ; choice = scan.nextInt();
				
			System.out.println("");

			
			if(choice == 1)
			{
				System.out.println("FCFS ALGORITHM :  \n");
				FCFS();
				System.out.println("\n");
				System.out.println("-----------------------------------------------------------");
				NOA();
				System.out.println("\n");

			}
			else if(choice  == 2)
			{
				System.out.println("SSTF ALOGRITHM :  \n");
				SSTF();
				System.out.println("\n");
				System.out.println("-----------------------------------------------------------");
				NOA();
				System.out.println("\n");

			}
			else if(choice ==  3)
			{
				System.out.println("SCAN ALGORITHM :  \n");
				SCAN();
				System.out.println("\n");
				System.out.println("-----------------------------------------------------------");
				NOA();
				System.out.println("\n");

				
			}
			else if(choice ==  4)
			{
				System.out.println("C_SCAN ALGORITHM :  \n");
				C_SCAN();
				System.out.println("\n");
				System.out.println("-----------------------------------------------------------");
				NOA();
				System.out.println("\n");

				
			}
			else if(choice == 5)
			{
				System.out.println("C_LOOK ALGORITHM :  \n");
				C_LOOK();
				System.out.println("\n");
				System.out.println("-----------------------------------------------------------");
				NOA();
				System.out.println("\n");

			}
			else if( choice == 6)
			{
				break;
			}
			
		}
	  }
            else break;
	}

}
	
}

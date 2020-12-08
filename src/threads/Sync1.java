package threads;


class SumArray1 
{  
	  private int sum;  
	  
	  int sumArray(int nums[]) 
	  {  
	    sum = 0; // reset sum  
	  
	    for(int i=0; i<nums.length; i++) {  
	      sum += nums[i];  
	      System.out.println("Running total for " +  
	             Thread.currentThread().getName() +  
	             " is " + sum);  
	      try {  
	        Thread.sleep(10); // allow task-switch  
	      }  
	      catch(InterruptedException exc) {  
	        System.out.println("Thread interrupted.");  
	      }  
	    }  
	    return sum; 
	  } 
	  
}   
	  
	class MyThread10 implements Runnable 
	{  
	  Thread thrd;  
	  static SumArray sa = new SumArray();  
	  int a[];  
	  int answer; 
	 
	  // Construct a new thread.  
	  MyThread10(String name, int nums[]) 
	  {  
	    thrd = new Thread(this, name);  
	    a = nums;  
	  }  
	  
	  // A factory method that creates and starts a thread.
	  public static MyThread10 createAndStart(String name, int nums[]) 
	  {
	    MyThread10 myThrd = new MyThread10(name, nums);	    
	    myThrd.thrd.start(); // start the thread
	    return myThrd;
	  }

	  // Entry point of thread.  
	  public void run() 
	  {  
	    int sum;  	  
	    System.out.println(thrd.getName() + " starting."); 	  
	    // synchronize calls to sumArray()  
	    synchronized(sa) {  
	      answer = sa.sumArray(a);           
	    }  
	    System.out.println("Sum for " + thrd.getName() +    " is " + answer); 	  
	    System.out.println(thrd.getName() + " terminating.");  
	  }  
	}  
	  
	class Sync1 {  
	  public static void main(String args[]) {  
	    int a[] = {1, 2, 3, 4, 5};  
	  
	    MyThread10 mt1 = MyThread10.createAndStart("Child #1", a); 
	    MyThread10 mt2 = MyThread10.createAndStart("Child #2", a); 
	  
	    try 
	    {  
	      mt1.thrd.join();  
	      mt2.thrd.join();  
	    } catch(InterruptedException exc) {  
	      System.out.println("Main thread interrupted.");  
	    }  
	  }  
	} 

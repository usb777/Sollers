package threads;


class MyThreadJoined implements Runnable 
{
	  Thread thrd;

	  // Construct a new thread.
	  MyThreadJoined(String name) {
	    thrd = new Thread(this, name);
	  }

	  // A factory method that creates and starts a thread.
	  public static MyThreadJoined createAndStart(String name) {
	    MyThreadJoined myThrd = new MyThreadJoined(name);
	    
	    myThrd.thrd.start(); // start the thread
	    return myThrd;
	  }

	  // Entry point of thread.
	  public void run() {
	    System.out.println(thrd.getName() + " starting.");
	    try {
	      for(int count=0; count < 10; count++) {
	        Thread.sleep(400);
	        System.out.println("In " + thrd.getName() +
	                           ", count is " + count);
	      }
	    }
	    catch(InterruptedException exc) {
	      System.out.println(thrd.getName() + " interrupted.");
	    }
	    System.out.println(thrd.getName() + " terminating.");
	  }
	}

	class JoinThreads {
	  public static void main(String args[]) {
	    System.out.println("Main thread starting.");

	    MyThreadJoined mt1 = MyThreadJoined.createAndStart("Child #1");
	    MyThreadJoined mt2 = MyThreadJoined.createAndStart("Child #2");
	   

	    try {
	      mt1.thrd.join();
	      System.out.println("Child #1 joined.");
	      mt2.thrd.join();
	      System.out.println("Child #2 joined.");
	     
	    }
	    catch(InterruptedException exc) {
	      System.out.println("Main thread interrupted.");
	    }
	    
	    
	    MyThreadJoined mt3 = MyThreadJoined.createAndStart("Child #3");
	    try 
	    {
	    	 mt3.thrd.join();
		      System.out.println("Child #3 joined.");
	    	
	    } catch(InterruptedException exc) {
		      System.out.println("Main thread interrupted.");
		    }
	    
	    
	    
	    
	    System.out.println("Main thread ending.");
	  }
	}

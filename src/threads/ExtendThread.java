package threads;



class MyThread3 extends Thread 
{

	  // Construct a new thread.
	  MyThread3(String name) {
	    super(name); // name thread
	  }

	  // Entry point of thread.
	  public void run() {
	    System.out.println(getName() + " starting.");
	    try {
	      for(int count=0; count < 10; count++) {
	        Thread.sleep(400);
	        System.out.println("In " + getName() +  ", count is " + count);
	      }
	    }
	    catch(InterruptedException exc) {
	      System.out.println(getName() + " interrupted.");
	    }

	    System.out.println(getName() + " terminating.");
	  }
	}

	class ExtendThread 
	{
	  public static void main(String args[]) 
	  {
	    System.out.println("Main thread starting.");

	    MyThread3 mt = new MyThread3("Child #1");

	    mt.start();    

	    for(int i=0; i < 50; i++) {
	      System.out.print(".");
	      try {
	        Thread.sleep(100);
	      }
	      catch(InterruptedException exc) {
	        System.out.println("Main thread interrupted.");
	      }
	    } 

	    System.out.println("Main thread ending.");
	  }
	}
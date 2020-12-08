package threads;

class TickTock1 
{ 

	  String state; // contains the state of the clock
	 
	  synchronized void tick(boolean running) 
	  { 
	    if(!running) { // stop the clock 
	      state = "ticked";
	      return; 
	    } 
	 
	    System.out.print("Tick "); 

	    state = "ticked"; // set the current state to ticked
	  } 
	 
	  synchronized void tock(boolean running) 
	  { 
	    if(!running) { // stop the clock 
	      state = "tocked";
	      return; 
	    } 
	 
	    System.out.println("Tock"); 

	    state = "tocked"; // set the current state to tocked
	  } 
	} 
	
class MyThread12 implements Runnable 
{ 
  Thread thrd; 
  TickTock1 ttOb; 
 
  // Construct a new thread. 
  MyThread12(String name, TickTock1 tt) 
  { 
    thrd = new Thread(this, name); 
    ttOb = tt; 
  }
 
  // A factory method that creates and starts a thread.
  public static MyThread12 createAndStart(String name, TickTock1 tt) {
    MyThread12 myThrd = new MyThread12(name, tt);
    
    myThrd.thrd.start(); // start the thread
    return myThrd;
  } 

  // Entry point of thread. 
  public void run() { 
 
    if(thrd.getName().compareTo("Tick") == 0) { 
      for(int i=0; i<5; i++) ttOb.tick(true); 
      ttOb.tick(false); 
    } 
    else { 
      for(int i=0; i<5; i++) ttOb.tock(true); 
      ttOb.tock(false); 
    } 
  } 
} 
 
	 
	class ThreadCom2 { 
	  public static void main(String args[]) { 
	    TickTock1 tt = new TickTock1(); 
	    MyThread12 mt1 = MyThread12.createAndStart("Tick", tt); 
	    MyThread12 mt2 = MyThread12.createAndStart("Tock", tt); 
	 
	    try { 
	      mt1.thrd.join(); 
	      mt2.thrd.join(); 
	    } catch(InterruptedException exc) { 
	      System.out.println("Main thread interrupted."); 
	    } 
	  } 
	}

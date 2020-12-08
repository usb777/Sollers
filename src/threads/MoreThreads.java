package threads;


//Create multiple threads.
class MyThread4 implements Runnable {
Thread thrd;

// Construct a new thread.
MyThread4(String name) 
{
 thrd = new Thread(this, name);
}

// A factory method that creates and starts a thread.
public static MyThread4 createAndStart(String name) 
{
 MyThread4 myThrd = new MyThread4(name); 
 myThrd.thrd.start(); // start the thread
 return myThrd;
}

// Entry point of thread.
public void run() 
{
 System.out.println(thrd.getName() + " starting.");
 try {
   for(int count=0; count < 10; count++) {
     Thread.sleep(400);
     System.out.println("In " + thrd.getName() +
                        ", count is " + count);
   }
 }
 catch(InterruptedException exc) 
 {   System.out.println(thrd.getName() + " interrupted."); }
 System.out.println(thrd.getName() + " terminating.");
}
}

class MoreThreads 
{
	public static void main(String args[]) {
		System.out.println("Main thread starting.");

 MyThread4 mt1 = MyThread4.createAndStart("Child #1");
 MyThread4 mt2 = MyThread4.createAndStart("Child #2");
 MyThread4 mt3 = MyThread4.createAndStart("Child #3");

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


package threads;

//MyThread variations. This version of MyThread
//creates a Thread when its constructor is called and
//stores it in an instance variable called thrd.
//It also sets the name of the thread and provides
//a factory method to create and start a thread.

class MyThread1 implements Runnable {
Thread thrd;

// Construct a new thread using this Runnable and give
// it a name.
MyThread1(String name) {
 thrd = new Thread(this, name);
}

// A factory method that creates and starts a thread.
public static MyThread1 createAndStart(String name)
{
 MyThread1 myThrd = new MyThread1(name);
 
 myThrd.thrd.start(); // start the thread
 return myThrd;
}

// Entry point of thread.
public void run() {
 System.out.println(thrd.getName() + " starting.");
 try {
   for(int count=0; count<10; count++) {
     Thread.sleep(400);
     System.out.println("In " + thrd.getName() +      ", count is " + count);
   }
 }
 catch(InterruptedException exc) {
   System.out.println(thrd.getName() + " interrupted.");
 }
 System.out.println(thrd.getName() + " terminating.");
}
}

class ThreadVariations {
public static void main(String args[]) 
{
 System.out.println("Main thread starting.");

 MyThread1 mt = MyThread1.createAndStart("Child #1");

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


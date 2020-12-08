package threads;

public class JoinExp  extends Thread { 
    public void run() 
    { int i=0;
        System.out.println("geeks "); 
        try { i++;
            Thread.sleep(300); 
        } 
        catch (InterruptedException ie) { 
        } 
        System.out.println("forgeeks "+i); 
    } 
    public static void main(String[] args) 
    { 
    	JoinExp c1 = new JoinExp(); 
    	JoinExp c2 = new JoinExp(); 
        c1.start(); 
  
        try { 
            c1.join(); // Waiting for c1 to finish 
        } 
        catch (InterruptedException ie) { 
        } 
  
        c2.start(); 
        
        try { 
        c2.join();
        } 
        catch (InterruptedException ie) { 
        } 
    } 
} 

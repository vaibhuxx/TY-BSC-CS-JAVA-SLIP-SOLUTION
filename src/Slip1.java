public class Slip1 extends Thread

{

char c;

public void run()

{

for(c = 'A'; c<='Z';c++)

{

System.out.println(""+c);

try

{

Thread.sleep(2000);

}

catch(Exception e)

{

e.printStackTrace();

}

}

}

public static void main(String args[])

{

Slip1 t = new Slip1();

t.start();

}

}
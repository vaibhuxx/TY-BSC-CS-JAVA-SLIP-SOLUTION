class TextPrinter implements Runnable {

    private String text;

    private int numTimes;

   

    public TextPrinter(String text, int numTimes) {

        this.text = text;

        this.numTimes = numTimes;

    }

   

    public void run() {

        for (int i = 0; i < numTimes; i++) {

            System.out.println(text);

        }

    }

}

 

public class Slip8a {

    public static void main(String[] args) {

        Thread t1 = new Thread(new TextPrinter("COVID19", 10));

        Thread t2 = new Thread(new TextPrinter("LOCKDOWN2020", 20));

        Thread t3 = new Thread(new TextPrinter("VACCINATED2021", 30));

       

        t1.start();

        t2.start();

        t3.start();

    }

}

 
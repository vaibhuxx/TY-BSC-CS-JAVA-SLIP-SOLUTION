import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class Slip17b extends JFrame implements ActionListener

{

 Container cc;

 JButton b1,b2;

 JTextField t1;

 Slip17b()

 {

 setVisible(true);

 setSize(1024,768);

 cc=getContentPane();

 setLayout(null);

 t1=new JTextField(500);

 cc.add(t1);

 t1.setBounds(10,10,1000,30);

 b1=new JButton("start");

 cc.add(b1);

 b1.setBounds(20,50,100,40);

 b1.addActionListener(this);

 setDefaultCloseOperation(EXIT_ON_CLOSE);

 }

 public void actionPerformed(ActionEvent e)

 {

 if(e.getSource()==b1)

 {

 new Mythread();

 }

 }

 class Mythread extends Thread

 {

 Mythread()

 {

 start();

 }

 public void run()

 {

 for(int i=1;i<=100;i++)

 {

 try {

 Thread.sleep(1000);

 }

 catch (InterruptedException e) {

 }

 t1.setText(t1.getText()+""+i+"\n");

//System.out.println() }

 }

 }

 public static void main(String arg[])

 {

 new Slip17b().show();

 }

}
}
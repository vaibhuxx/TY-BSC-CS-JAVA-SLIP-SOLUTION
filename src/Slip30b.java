import java.io.*;
import java.sql.*;
import java.util.*;
class Slip30b
{
public static void main(String args[])
{
Connection conn= null;
Statement stmt = null;
ResultSet rs = null;
int ch;
Scanner s=new Scanner(System.in);
try
{
// load a driver
Class.forName("org.postgresql.Driver");

conn = DriverManager.getConnection("jdbc:postgresql://localhost/stud","postgres","vai123");
stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
ResultSet.CONCUR_UPDATABLE);
rs = stmt.executeQuery("select * from teacher");
int count=0;
while(rs.next()){
count++;
System.out.println("Which Record u want");
System.out.println("Records are = "+count);}
do
{ System.out.println("1 First \n2 last \n3 next \n4 prev \n0 Exit");
ch=s.nextInt();
switch(ch)
{
case 1: rs.first();
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2)); break;
case 2: rs.last();
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2)); break;
case 3 : rs.next();
if(rs.isAfterLast()){
System.out.println("can't move forword");}
else{
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2));
break;}
case 4 : rs.previous();
       // NR CLASSES PUNE (8796064387/90);
if(rs.isBeforeFirst()){
System.out.println("can't move backword");}
else{
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2));}
break;
case 0 : break;
default:System.out.println("Enter valid operation");
}//switch
}while(ch!=0);
}//end of try
catch(Exception e)
{
System.out.println(e);
}
}//main
}//class
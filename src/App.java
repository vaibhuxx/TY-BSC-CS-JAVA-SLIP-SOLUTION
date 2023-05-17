import java.sql.*;
import java.io.*;
class App
{
  public static void main(String[] args) throws Exception
  {
     
    Statement stmt =  null;
    ResultSet rs = null;
    PreparedStatement ps1 = null, ps2=null;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String Ename;
    int ENo,choice;
    float Salary;
    Class.forName("org.postgresql.Driver");
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/stud","postgres","vai123");
    stmt = conn.createStatement();
         
    if(conn!=null)
    {
        System.out.println("Connection successful..");}
    do
    {
    System.out.println("1: View Records");
    System.out.println("2: Insert Record");
    System.out.println("3: Delete Record");
    System.out.println("4: Modify Record");
    System.out.println("5: Search Record");
    System.out.println("6: Exit");
    System.out.println("\nEnter your choice : ");
    choice = Integer.parseInt(br.readLine());
    switch(choice)
    {
        case 1: 
        rs = stmt.executeQuery("select * from Employe;");
        while(rs.next())  
 {
                System.out.print("ENo = " + rs.getInt(1));
                System.out.println("EName = " + rs.getString(2));
            }
        break;
    case 2: 
        System.out.println("Enter the Employee number");
        ENo = Integer.parseInt(br.readLine());
        System.out.println("Enter Employee Name:");
        Ename = br.readLine();
                System.out.println("Enter Salary:");
        Salary = Float.parseFloat(br.readLine());
        ps1 = conn.prepareStatement("Insert into Employe values(?,?,?)");
        ps1.setInt(1,ENo); 
                ps1.setString(2,Ename);
                ps1.setFloat(3, Salary);
                ps1.executeUpdate();
                System.out.println("record inserted successfully");
        break;  
    case 3: 
        System.out.println("Enter the Emp number to be deleted ");
        ENo = Integer.parseInt(br.readLine());
        stmt.executeUpdate("Delete from Employe where ENo = " + ENo);
                System.out.println("record deleted successfully");
        break;
    case 4: 
        System.out.println("Enter the Emp number to be modified ");
        ENo = Integer.parseInt(br.readLine());
        System.out.println("Enter new name");
        Ename = br.readLine();
                System.out.println("Enter new salary");
        Salary = Float.parseFloat(br.readLine());
    ps2 = conn.prepareStatement("Update Employe set Ename = ?,Salary=? where ENo = ?");
                ps2.setString(1,Ename);
                ps2.setFloat(2,Salary);
                ps2.setInt(3,ENo);                
        ps2.executeUpdate();
                 System.out.println("record modified successfully");
        break;
    case 5: 
        System.out.println("Enter the Emp number to be searched ");
        ENo = Integer.parseInt(br.readLine());
        rs = stmt.executeQuery("Select * from Employe where ENo = " + ENo);
        if(rs.next())
        {
            System.out.print("Emp Number = " + rs.getInt(1));
                System.out.println("Emp Name = " + rs.getString(2));
                        System.out.println("Salary = " + rs.getFloat(3));
        }
        else{
            System.out.println("Employee not found"); }   
        break;  
        
     }
   } while(choice != 6);
   }                    
 }  


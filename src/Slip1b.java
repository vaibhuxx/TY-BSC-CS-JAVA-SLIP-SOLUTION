import java.awt.EventQueue;

import java.awt.GridLayout;

import java.sql.Connection;

/*import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

 

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextField;*/

import java.sql.*;
import javax.swing.*;

 

public class Slip1b {

 

    private JFrame frame;

    private JTextField txtEno;

    private JTextField txtEName;

    private JTextField txtDesignation;

    private JTextField txtSalary;

 

    /**

     * Launch the application.

     */

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Slip1b window = new Slip1b();

                    window.frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }

 

    public Slip1b() {

        initialize();

    }

 

    private void initialize() {

        frame = new JFrame("Employee Details Entry");

        frame.setBounds(100, 100, 450, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new GridLayout(5, 2, 10, 10));

 

        JLabel lblEno = new JLabel("Employee Number:");

        frame.getContentPane().add(lblEno);

 

        txtEno = new JTextField();

        frame.getContentPane().add(txtEno);

        txtEno.setColumns(10);

 

        JLabel lblEName = new JLabel("Employee Name:");

        frame.getContentPane().add(lblEName);

 

        txtEName = new JTextField();

        frame.getContentPane().add(txtEName);

        txtEName.setColumns(10);

 

        JLabel lblDesignation = new JLabel("Designation:");

        frame.getContentPane().add(lblDesignation);

 

        txtDesignation = new JTextField();

        frame.getContentPane().add(txtDesignation);

        txtDesignation.setColumns(10);

 

        JLabel lblSalary = new JLabel("Salary:");

        frame.getContentPane().add(lblSalary);

 

        txtSalary = new JTextField();

        frame.getContentPane().add(txtSalary);

        txtSalary.setColumns(10);

 

        JButton btnSave = new JButton("Save");

        btnSave.addActionListener(e -> {

            saveToDatabase();

        });

        frame.getContentPane().add(btnSave);

    }

 

    private void saveToDatabase() {

        String eno = txtEno.getText();

        String ename = txtEName.getText();

        String designation = txtDesignation.getText();

        String salary = txtSalary.getText();

 

        try {

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/stud","postgres","vai123");

 

            PreparedStatement pstmt = connection

                    .prepareStatement("INSERT INTO emp (eno, ename, designation, salary) VALUES (?, ?, ?, ?)");

            pstmt.setString(1, eno);

            pstmt.setString(2, ename);

            pstmt.setString(3, designation);

            pstmt.setString(4, salary);

            pstmt.executeUpdate();

 

            connection.close();

 

            txtEno.setText("");

            txtEName.setText("");

            txtDesignation.setText("");

            txtSalary.setText("");

 

            System.out.println("Employee details saved successfully!");

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

    }

}

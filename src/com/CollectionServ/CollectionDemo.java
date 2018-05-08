package com.CollectionServ;

import Collection.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/hello")
public class CollectionDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pt=response.getWriter();

        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Computer_lab","bup_lab");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select*from computer_student");
            Collection cl=new Collection();
            String sec;
            int id;

            while(rs.next())
            {
                 sec=rs.getString(2);
                 id=rs.getInt(1);
                pt.println(cl.retStudent(id,sec));

            }


            con.close();



        }
        catch (Exception e)
        {
            pt.println(e);

        }



    }
}

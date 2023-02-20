package com.mvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*IRFAN AFIFI*/

/*servlet class to get pdf/blob from database to web page*/
public class RetrievePdf extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int BUFFER_SIZE = 4096;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		String username = request.getParameter("username");
		String stuusername = request.getParameter("stuusername");
		String coursename = request.getParameter("coursename");


        // Obtain a database connection
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CoursePortal", "root", "Halaldanharam06*");

            // Create a prepared statement
            PreparedStatement stmt = con.prepareStatement("SELECT academic_Credentials FROM appliedCourse WHERE faculty_id = ? AND coursename = ? AND stu_username = ?");
            stmt.setString(1, username);
            stmt.setString(2, coursename);
            stmt.setString(3, stuusername);
            
            System.out.println(stmt);

            // Execute the query
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Retrieve the pdf file as a Blob object
                Blob blob = rs.getBlob("academic_Credentials");

                // Get the input stream of the blob
                InputStream inputStream = blob.getBinaryStream();

                // Set the content type and the content disposition of the response
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=" + stuusername +"_academicCedentials" + ".pdf");

                
                
                request.setAttribute("pdf", inputStream);
                
                
                
                // Get the output stream of the response
                ServletOutputStream outputStream = response.getOutputStream();

                // Write the pdf file to the output stream
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                // Close the input stream
                inputStream.close();

                // Flush the output stream
                outputStream.flush();
                outputStream.close();
            } else {
                // If no pdf file was found, send a 404 error
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }

		    } catch (Exception e) {
		        // If an error occurred, send a 500 error
		        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    } finally {
		        try {
		            if (con != null) {
		                con.close();
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}
    }




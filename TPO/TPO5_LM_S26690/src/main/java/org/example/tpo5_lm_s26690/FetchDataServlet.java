package org.example.tpo5_lm_s26690;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;

import java.sql.*;

public class FetchDataServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String kind = request.getParameter("Kind");
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/michallejza/Desktop/TPO5_LM_S26690/src/main/resources/Cars.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Cars WHERE Kind='" + kind + "'");

            request.setAttribute("carResultSet", resultSet);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ResponseServlet");
            dispatcher.forward(request, response);

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}


package org.example.tpo5_lm_s26690;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

public class ResponseServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Cars List</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Car Brand</th><th>Sub Brand</th><th>Year of Production</th><th>Kind of Car</th><th>Fuel Consumption</th></tr>");

        try
        {
            ResultSet resultSet = (ResultSet) request.getAttribute("carResultSet");
            while (resultSet != null && resultSet.next())
            {
                String model = resultSet.getString("Brand");
                String year = resultSet.getString("ProductionYear");
                String category = resultSet.getString("Kind");
                String fuel = resultSet.getString("FuelConsumption");
                String subBrand = resultSet.getString("SubBrand");

                out.println("<tr>");
                out.println("<td>" + model + "</td>");
                out.println("<td>" + subBrand + "</td>");
                out.println("<td>" + year + "</td>");
                out.println("<td>" + category + "</td>");
                out.println("<td>" + fuel + "l/100 km</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        }
        catch (Exception e)
        {
            e.printStackTrace(out);
        }

        out.println("</body></html>");
    }
}

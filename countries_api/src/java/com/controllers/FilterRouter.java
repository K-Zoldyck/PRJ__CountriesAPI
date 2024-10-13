
package com.controllers;
import com.DTO.RequestConfig;
import com.models.DBconnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "routers", urlPatterns = {"/filter"})
public class FilterRouter extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        RequestConfig request_config;
        String name = request.getParameter("name");
        String region = request.getParameter("region");
        String patt = request.getParameter("pattern");
        String langs = request.getParameter("langs");
        int limit = 10;
        
        try {
            limit = Integer.parseInt(request.getParameter("limit"));
        }catch(NumberFormatException e){}

        request_config = new RequestConfig(name,region,patt,langs,limit);
        System.out.println(request_config.toString());
        response.setContentType("text/json");
        String payload = DBconnection.getConnection().getFilteredCountries(request_config);
        response.getWriter().print(payload);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

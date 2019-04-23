package com.uetcodecamp.js;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet",
        urlPatterns = {"/"}
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("product")) {
            response.setHeader("Content-Type", "text/html");
            PrintWriter out = response.getWriter();
            for (int i = 0; i< 10; i++) {
                out.write("<h1 style='color:red;'>Product! " + i + " </h1>");
            }
            out.write("<input placeholder='Enter here...'>");
            out.flush();
            out.close();
        } else if (uri.contains("category")) {
            response.setHeader("Content-Type", "text/html");
            PrintWriter out = response.getWriter();
            out.write("<h1 style='color:red;'>Category!</h1>");
            out.write("<input placeholder='Enter here...'>");
            out.flush();
            out.close();
        }
    }

}

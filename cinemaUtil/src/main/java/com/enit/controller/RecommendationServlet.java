import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RecommendationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String genre = request.getParameter("genre");

        // Call the FastAPI microservice
        URL url = new URL("http://localhost:8000/recommend?genre=" + genre);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder apiResponse = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            apiResponse.append(inputLine);
        }
        in.close();
        conn.disconnect();

        // Send the recommendations to the JSP page
        request.setAttribute("recommendations", apiResponse.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("recommendations.jsp");
        dispatcher.forward(request, response);
    }
}

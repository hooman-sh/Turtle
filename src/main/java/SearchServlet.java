import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String minArea = request.getParameter("minArea");
        String dealType = request.getParameter("dealType");
        String buildingType = request.getParameter("buildingType");
        String maxPrice = request.getParameter("maxPrice");
        RequestDispatcher rd = null;

        Search search = new Search();
        ArrayList<House> result = search.filterHouses(Double.parseDouble(minArea), Integer.parseInt(dealType), buildingType, Integer.parseInt(maxPrice));
        if (result.size() != 0) {
            rd = request.getRequestDispatcher("/searchResult.jsp");
            request.setAttribute("houses", result);
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }

}
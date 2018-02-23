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
        ArrayList<House> user_houses = new ArrayList<>();
        String minArea = request.getParameter("minArea");
        String dealType = request.getParameter("dealType");
        String buildingType = request.getParameter("buildingType");
        String maxPrice = request.getParameter("maxPrice");
        RequestDispatcher rd = null;
        Search search = new Search();
        RSEndPoint api = new RSEndPoint();
        ArrayList<House> apiResult = api.getHousesList();
        if(this.getServletConfig().getServletContext().getAttribute("houses") != null){
            user_houses = (ArrayList<House>) this.getServletConfig().getServletContext().getAttribute("houses");
        }
        Individual curr_user = new Individual();
        if(this.getServletConfig().getServletContext().getAttribute("user") != null){
            curr_user = (Individual) this.getServletConfig().getServletContext().getAttribute("user");
        }
        if(user_houses.size() != 0){
            apiResult.addAll(user_houses);
        }
        search.setHouses(apiResult);
        ArrayList<House> result = search.filterHouses(minArea,dealType,buildingType,maxPrice);

        rd = request.getRequestDispatcher("/searchResult.jsp");
        request.setAttribute("houses", result);
        request.setAttribute("user", curr_user);

        rd.forward(request, response);
    }

}
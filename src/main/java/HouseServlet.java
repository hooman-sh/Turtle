import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class HouseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HouseServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        ArrayList<House> houses = new ArrayList<>();
        if(this.getServletConfig().getServletContext().getAttribute("houses") != null){
            houses = (ArrayList<House>) this.getServletConfig().getServletContext().getAttribute("houses");
        }
        String area = request.getParameter("area");
        String dealType = request.getParameter("dealType");
        String buildingType = request.getParameter("buildingType");
        String price = request.getParameter("price");
        String address = request.getParameter("address");
        String description = request.getParameter("description");
        String phone = request.getParameter("phone");
        RequestDispatcher rd = null;
        House house = new House();
        House result = house.createHouse(buildingType,Integer.parseInt(dealType),Integer.parseInt(price),address,description,Double.parseDouble(area),phone);

        if (result.getId().length() != 0) {
            houses.add(result);
            this.getServletConfig().getServletContext().setAttribute("houses", houses); // add to application context
            rd = request.getRequestDispatcher("/success.jsp");
            request.setAttribute("houses", houses);
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }

}
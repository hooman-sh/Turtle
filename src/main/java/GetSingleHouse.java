import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class GetSingleHouse extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetSingleHouse() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ArrayList<House> user_houses = new ArrayList<>();

        if(this.getServletConfig().getServletContext().getAttribute("houses") != null){
            user_houses = (ArrayList<House>) this.getServletConfig().getServletContext().getAttribute("houses");
        }
        Individual curr_user = new Individual();
        if(this.getServletConfig().getServletContext().getAttribute("user") != null){
            curr_user = (Individual) this.getServletConfig().getServletContext().getAttribute("user");
        }
        House result = new House();
        RequestDispatcher rd = null;

        boolean flag = false;
        for(int i=0;i<user_houses.size();i++){
            if(user_houses.get(i).getId().equals(id)){
                result = user_houses.get(i);
                flag = true;
            }
        }
        if(!flag){
            RSEndPoint api = new RSEndPoint();
            result = api.getHouseDetail(id);
        }
        this.getServletConfig().getServletContext().setAttribute("curr_house", result); // add to application context
        rd = request.getRequestDispatcher("/houseDetail.jsp");
        request.setAttribute("house", result);
        request.setAttribute("user", curr_user);


        rd.forward(request, response);
    }

}
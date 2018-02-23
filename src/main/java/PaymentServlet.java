import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PaymentServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Individual curr_user = new Individual();
        if(this.getServletConfig().getServletContext().getAttribute("user") != null){
            curr_user = (Individual) this.getServletConfig().getServletContext().getAttribute("user");
        }
        House curr_house = new House();
        if(this.getServletConfig().getServletContext().getAttribute("curr_house") != null){
            curr_house = (House) this.getServletConfig().getServletContext().getAttribute("curr_house");
        }

        String id = request.getParameter("id");

        String text = "";
        RequestDispatcher rd = null;

        boolean flag = false;
        for(int i=0;i<curr_user.getHouses().size();i++){
            if(curr_user.getHouses().get(i).equals(id)){
                flag = true;
                text="-";
            }
        }
        if(!flag){
            if(curr_user.getBalance() < 1000){
                text = "اعتبار شما کافی نیست";
            }
            else {
                curr_user.setBalance(curr_user.getBalance() - 1000);
                curr_user.setHouses(id);
                text="-";
            }
        }
        this.getServletConfig().getServletContext().setAttribute("user", curr_user); // add to application context
        rd = request.getRequestDispatcher("/houseDetail.jsp");
        request.setAttribute("text", text);
        request.setAttribute("user", curr_user);
        request.setAttribute("house", curr_house);

        rd.forward(request, response);
    }

}
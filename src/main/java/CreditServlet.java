import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CreditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreditServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Individual curr_user = new Individual();
        if(this.getServletConfig().getServletContext().getAttribute("user") != null){
            curr_user = (Individual) this.getServletConfig().getServletContext().getAttribute("user");
        }
        String value = request.getParameter("value");
        String userId = curr_user.getUserId();
        RequestDispatcher rd = null;
        RSEndPoint api = new RSEndPoint();
        String result = api.increaseCredit(userId,Integer.parseInt(value));
        if(result.equals("success")){
            curr_user.setBalance(curr_user.getBalance() + Integer.parseInt(value));
            this.getServletConfig().getServletContext().setAttribute("user", curr_user); // add to application context
            rd = request.getRequestDispatcher("/success.jsp");
            request.setAttribute("creditResult", result);
        }else{
            rd = request.getRequestDispatcher("/error.jsp");

        }
        rd.forward(request, response);
    }

}
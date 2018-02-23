import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class Turtle extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Turtle() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Individual curr_user = new Individual();
        if(this.getServletConfig().getServletContext().getAttribute("user") != null){
            curr_user = (Individual) this.getServletConfig().getServletContext().getAttribute("user");
        } else{
            curr_user.setName("بهنام همایون");
            curr_user.setBalance(0);
            curr_user.setUserId("123");
        }

        RequestDispatcher rd = null;
        this.getServletConfig().getServletContext().setAttribute("user", curr_user); // add to application context
        request.setAttribute("user", curr_user);
        rd = request.getRequestDispatcher("/main.jsp");

        rd.forward(request, response);
    }

}
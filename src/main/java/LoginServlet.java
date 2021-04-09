import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        String navn = request.getParameter("navn");
        String password = request.getParameter("password");

        List<Bruger> brugerList = (List<Bruger>) context.getAttribute("brugerliste");

        if (brugerList == null){

            brugerList = new ArrayList<>();
        }

        for (Bruger bruger:brugerList) {
            if (bruger.getName().equals(navn) && bruger.getPassword().equals(password)){

                session.setAttribute("bruger", bruger);
                session.setAttribute("emneListe", bruger.getHuskeliste());

                String sessionid = session.getId();
                session.setAttribute("brugernavn", navn);
                session.setAttribute("sessionid", sessionid);

                request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request, response);





            }



        }

    }
}

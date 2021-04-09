import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "FjernEmne", value = "/FjernEmne")
public class FjernEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/Oversigt.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String s = request.getParameter("fEmne");


        HttpSession session = request.getSession();

        Set<String> emneListe = (Set<String>) session.getAttribute("emneListe");

        ServletContext context = request.getServletContext();


        if (emneListe.contains(s)) {
            emneListe.remove(s);
        }

        Bruger bruger = (Bruger) session.getAttribute("bruger");
        bruger.setHuskeliste(emneListe);
        //emneListe.remove(s);


        int emneListeSize = emneListe.size();

        //context.setAttribute("emneListeContext", emneListeContext);
        //context.setAttribute("contextSize", contextSize);

        session.setAttribute("emneListe", emneListe);
        session.setAttribute("emneListeSize", emneListeSize);

        request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request, response);


    }
}

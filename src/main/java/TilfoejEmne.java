import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "TilfoejEmne", value = "/TilfoejEmne")
public class TilfoejEmne extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/Oversigt.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                    PrintWriter out = response.getWriter();


                    String emne = request.getParameter("emne");

                    HttpSession session = request.getSession();

                    ServletContext context = request.getServletContext();

                    List<String> emneListeContext = (List<String>) context.getAttribute("emneListeContext");

                    if (emneListeContext == null) {

                         emneListeContext = new ArrayList<>();

                    }

                    emneListeContext.add(emne);
                    int contextSize = emneListeContext.size();


//

        Set<String> emneListe = (Set<String>) session.getAttribute("emneListe");

        if (emneListe == null ) {    // der her sker kun første gang vi forbi

            emneListe = new HashSet<>();

        }

        if (!emneListe.contains(emne)){
            emneListe.add(emne);
        }

        Bruger bruger = (Bruger) session.getAttribute("bruger");
        bruger.setHuskeliste(emneListe);







        int emneListeSize = emneListe.size();

        context.setAttribute("emneListeContext", emneListeContext);
        context.setAttribute("contextSize", contextSize);

        session.setAttribute("emneListe", emneListe);
        session.setAttribute("emneListeSize", emneListeSize);

        request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request,response);


    }
}

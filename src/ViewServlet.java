import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Reservation;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
    private final HotelManagementSystemDAO dao = new HotelManagementSystemDAO();

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Reservation> reservations = dao.viewReservations();
            request.setAttribute("reservations", reservations);
//            request.getRequestDispatcher("WEB-INF/views/viewJsp.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

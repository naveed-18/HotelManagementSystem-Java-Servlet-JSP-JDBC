import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reserve")
public class ReserveServlet extends HttpServlet {
    private final HotelManagementSystemDAO dao = new HotelManagementSystemDAO();

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String guestName = request.getParameter("guestName");
        int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
        String phoneNumber = request.getParameter("phoneNumber");

        boolean success = dao.reserveRoom(guestName, roomNumber, phoneNumber);

        request.setAttribute("message", success? "Reservation Successful" : "Reservation Failed");

//        request.getRequestDispatcher("WEB-INF/views/reserveJsp.jsp").forward(request, response);
    }
}

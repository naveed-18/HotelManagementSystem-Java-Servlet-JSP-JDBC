import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private final HotelManagementSystemDAO dao = new HotelManagementSystemDAO();
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        String guestName = request.getParameter("guestName");
        int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
        String phoneNumber = request.getParameter("phoneNumber");

        boolean success = dao.updateReservation(reservationId, guestName, roomNumber, phoneNumber);

        request.setAttribute("message", success ? "Updated Successful!" : "Updation Failed");

//        request.getRequestDispatcher("/WEB-INF/views/updateJsp.jsp").forward(request, response);
    }
}

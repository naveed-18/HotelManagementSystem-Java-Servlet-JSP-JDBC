import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get-room")
public class GetRoomNumberServlet extends HttpServlet {
    private final HotelManagementSystemDAO dao = new HotelManagementSystemDAO();

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        String guestName = request.getParameter("guestName");

        Integer roomNumber = dao.getRoomNumber(reservationId, guestName);

        request.setAttribute("roomNumber", roomNumber);

//        request.getRequestDispatcher("WEB-INF/views/getRoomNumberJsp.jsp").forward(request, response);
    }
}

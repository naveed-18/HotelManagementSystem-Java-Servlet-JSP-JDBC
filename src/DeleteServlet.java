import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private final HotelManagementSystemDAO dao = new HotelManagementSystemDAO();

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        boolean success = dao.deleteReservation(reservationId);

        request.setAttribute("message", success ? "Deleted Successful!" : "Deletion Failed!");

//        request.getRequestDispatcher("/WEB-INF/views/deleteJsp.jsp").forward(request, response);
    }
}

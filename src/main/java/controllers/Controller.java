package controllers;

import helpers.ControllerHelper;
import login.elements.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "Controller", urlPatterns = "/Controller")
public class Controller extends HttpServlet {
    ControllerHelper controllerHelper = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        controllerHelper = new ControllerHelper(request, response);
        System.out.println("n:" + request.getParameter("n"));
        User user = (User) request.getSession().getAttribute("user");
        int status;
        long status1;
        if (request.getParameter("n") == null) {
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            switch (Integer.valueOf(request.getParameter("n"))) {
                case (1):
                    controllerHelper.login();
                    break;
                case (2):
                    controllerHelper.logout();
                    break;

                case (3):
                    status = controllerHelper.changePassword();
                    response.getWriter().println(status);
                    break;
                case (4):
                    status = controllerHelper.addLocation();
                    response.getWriter().println(status);
                    break;
                case (5):
                    status = controllerHelper.addDepartment();
                    response.getWriter().println(status);
                    break;
                case (6):
                    status = controllerHelper.addDeviceType();
                    response.getWriter().println(status);
                    break;
                case (7):
                    status = controllerHelper.addDevice();
                    response.getWriter().println(status);
                    break;
                case (8):
                    status = controllerHelper.addCategory();
                    response.getWriter().println(status);
                    break;
                case (9):
                    status = controllerHelper.addSubCategory();
                    response.getWriter().println(status);
                    break;
                case (10):
                    try {
                        status1 = controllerHelper.addTicket();
                        response.getWriter().println(status1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    break;
                case (11):
                    status1 = controllerHelper.editTicket();
                    response.getWriter().println(status1);
                    break;
                case (12):
                    response.getWriter().println(controllerHelper.getTicketAssignToCount(user));
                    break;
                case (13):
                    response.getWriter().println(controllerHelper.getTicketAssignedToUserCount(user));
                    break;
                case (14):
                    response.getWriter().println(controllerHelper.getTicketInProgressByUserCount(user));
                    break;
                case (15):
                    response.getWriter().println(controllerHelper.getTicketPendingByUserCount(user));
                    break;
                case (16):
                    response.getWriter().println(controllerHelper.getTicketSolvedByUserCount(user));
                    break;
                case (17):
                    try {
                        response.getWriter().println(controllerHelper.savePC());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case (18):
                    try {
                        response.getWriter().println(controllerHelper.savePrinter());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case (19):
                    try {
                        response.getWriter().println(controllerHelper.saveAttendance());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case (20):
                    try {
                        response.getWriter().println(controllerHelper.savePBX());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case (21):
                    try {
                        response.getWriter().println(controllerHelper.saveDevice());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case (22):
                    try {
                        response.getWriter().println(controllerHelper.saveVideoRecorder());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case (23):
                    response.getWriter().println(controllerHelper.addRegion());
                    break;
                case (24):
                    response.getWriter().println(controllerHelper.addEmployee());
                    break;
                case (25):
                    response.getWriter().println(controllerHelper.addUser());
                    break;
                case (26):
                    response.getWriter().println(controllerHelper.editUser());
                    break;
                case (27):
                    controllerHelper.createPassword();
                    break;
                case (28):
                    response.getWriter().println(controllerHelper.addOS());
                    break;
                case (29):
                    response.getWriter().println(controllerHelper.getTicketAssignToRegionCount());
                    break;
                case (30):
                    response.getWriter().println(controllerHelper.getTicketInProgressRegionCount());
                    break;
                case (31):
                    response.getWriter().println(controllerHelper.getTicketPendingRegionCount());
                    break;
                case (32):
                    response.getWriter().println(controllerHelper.getTicketSolvedRegionCount());
                    break;
                case (33):
                    response.getWriter().println(controllerHelper.addPrivilege());
                    break;
                case (34):
                    response.getWriter().println(controllerHelper.getTicketClosedByUserCount(user));
                    break;
                case (35):
                    response.getWriter().println(controllerHelper.getTicketNeedToCloseCount(user));
                    break;
                case (36):
                    response.getWriter().println(controllerHelper.getRegionChartData());
                    break;
                case (37):
                    response.getWriter().println(controllerHelper.getTicketChartData());
                    break;
                case (38):
                    response.getWriter().println(controllerHelper.getDeviceChartData());
                    break;
                case (39):
                    controllerHelper.getDailyRegionTickets();
                    break;
                case (40):
                    response.getWriter().println(controllerHelper.getDailyTicketPerTimeData());
                    break;
                case (41):
                    response.getWriter().println(controllerHelper.getTicketBarChartData());
                    break;
                case (42):
                    response.getWriter().println(controllerHelper.recodingDevices());
                    break;
                case (43):
                    response.getWriter().println(controllerHelper.resetPassword());
                    break;
                case (44):
                    response.getWriter().println(controllerHelper.addAccessory());
                    break;
                case (45):
                    response.getWriter().println(controllerHelper.addAccount());
                    break;
                case (46):
                    try {
                        response.getWriter().println(controllerHelper.saveMobile());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case (47):
                    response.getWriter().println(controllerHelper.suspenseAccount());
                    break;
                case (48):
                    response.getWriter().println(controllerHelper.addEmployeeTicket());
                    break;

            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signIn.html").forward(request, response);

    }
}

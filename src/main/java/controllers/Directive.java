package controllers;

import helpers.ControllerHelper;
import helpers.DirectiveHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Directive", urlPatterns = "/Directive")
public class Directive extends HttpServlet {
    DirectiveHelper directiveHelper = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        directiveHelper = new DirectiveHelper(request, response);
        System.out.println("d:" + request.getParameter("d"));
        if (request.getParameter("d") == null) {
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            switch (Integer.valueOf(request.getParameter("d"))) {
                case (1):
                    directiveHelper.goToNewTicketSection();
                    break;
                case (2):
                    directiveHelper.goToDepartmentSection();
                    break;
                case (3):
                    directiveHelper.goToDeviceTypeSection();
                    break;
                case (4):
                    directiveHelper.goToLocationOptions();
                    break;
                case (5):
                    directiveHelper.goToDepartmentOptions();
                    break;
                case (6):
                    directiveHelper.goToDeviceSection();
                    break;
                case (7):
                    directiveHelper.goToDeviceInfo();
                    break;
                case (8):
                    directiveHelper.goToDeviceTypeOptions();
                    break;
                case (9):
                    directiveHelper.goToDeviceOptions();
                    break;
                case (10):
                    directiveHelper.goToProblemCommentSection();
                    break;
                case (11):
                    directiveHelper.goToCategoryOptions();
                    break;
                case (12):
                    directiveHelper.goToSubCategorySection();
                    break;
                case (13):
                    directiveHelper.goToSubCategoryOptions();
                    break;
                case (14):
                    directiveHelper.goToAssignToSection();
                    break;
                case (15):
                    directiveHelper.goToTicketReport();
                    break;
                case (16):
                    directiveHelper.goToAssignedToTab();
                    break;
                case (17):
                    directiveHelper.goToSolvedTab();
                    break;
                case (18):
                    directiveHelper.goToInProgressTab();
                    break;
                case (19):
                    directiveHelper.goToPendingTab();
                    break;
                case (20):
                    directiveHelper.goToTicketEdit();
                    break;
                case (21):
                    directiveHelper.goToNeedToSolveTab();
                    break;
                case (22):
                    directiveHelper.goToTicketChart();
                    break;
                case (23):
                    directiveHelper.goToAssignedToDetailsTab();
                    break;
                case (24):
                    directiveHelper.goToInProgressDetailsTab();
                    break;
                case (25):
                    directiveHelper.goToPendingDetailsTab();
                    break;
                case (26):
                    directiveHelper.goToSolvedDetailsTab();
                    break;
                case (27):
                    directiveHelper.goToNeedToSolveDetailsTab();
                    break;
                case (28):
                    directiveHelper.goToDevices();
                    break;
                case (29):
                    directiveHelper.goToPCTypeOptions();
                    break;
                case (30):
                    directiveHelper.goToPCData();
                    break;
                case (31):
                    directiveHelper.goToAddDevice();
                    break;
                case (32):
                    directiveHelper.goToPrinterData();
                    break;
                case (33):
                    directiveHelper.goToPBXData();
                    break;
                case (34):
                    directiveHelper.goToEditDevice();
                    break;
                case (35):
                    directiveHelper.goToEmployeeOptions();
                    break;
                case (36):
                    directiveHelper.goToLocationSection();
                    break;
                case (37):
                    directiveHelper.goToRegionOptions();
                    break;
                case (38):
                    directiveHelper.goToAddUser();
                    break;
                case (39):
                    directiveHelper.goToDashboard();
                    break;
                case (40):
                    directiveHelper.goToUsers();
                    break;
                case (41):
                    directiveHelper.goToEditUser();
                    break;
                case (42):
                    directiveHelper.goToOSOptions();
                    break;
                case (43):
                    directiveHelper.goToDashboardDetails();
                    break;
                case (44):
                    directiveHelper.goToRegionChart();
                    break;
                case (45):
                    directiveHelper.goToDeviceChart();
                    break;
                case (46):
                    directiveHelper.goToEmployees();
                    break;
                case (47):
                    directiveHelper.goToEditEmployee();
                    break;
                case (48):
                    directiveHelper.goToPrivileges();
                    break;
                case (49):
                    directiveHelper.goToAddPrivilege();
                    break;
                case (50):
                    directiveHelper.goToEditPrivilege();
                    break;
                case (51):
                    directiveHelper.goToClosedTab();
                    break;
                case (52):
                    directiveHelper.goToClosedDetailsTab();
                    break;
                case (53):
                    directiveHelper.goToNeedToCloseTab();
                    break;
                case (54):
                    directiveHelper.goToL2EngineersTicketRatioSection();
                    break;
                case (55):
                    directiveHelper.goToRegionDevicesRatioSection();
                    break;
                case (56):
                    directiveHelper.goToRegionTicketRatioSection();
                    break;
                case (57):
                    directiveHelper.goToNeedToCloseDetailsTab();
                    break;
                case (58):
                    directiveHelper.goToActionSection();
                    break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package helpers;

import elements.*;
import login.elements.Role;
import login.elements.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectiveHelper extends HelperBase {
    private HibernateHelper hibernateHelper;
    private ControllerHelper controllerHelper;
    User user = (User) request.getSession().getAttribute("user");

    public DirectiveHelper(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        hibernateHelper = new HibernateHelper(request, response);
        controllerHelper = new ControllerHelper(request, response);
    }

    public void goToNewTicketSection() throws ServletException, IOException {
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId() + " order by region");
        request = getUserPrivilege(user, request);
        /*if (tsUserRegionList.size() == 1) {
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + tsUserRegionList.get(0).getRegion().getId() + " order by location");
            request.setAttribute("locationList", locationList);
            List<Category> categoryList = hibernateHelper.retreiveData("from Category order by category");
            request.setAttribute("categoryList", categoryList);
            request.getRequestDispatcher("new_ticket.jsp").forward(request, response);
        } else if (tsUserRegionList.size() > 1) {


        }*/
        request.setAttribute("regionList", tsUserRegionList);
        List<Department> departmentList = hibernateHelper.retreiveData("from Department order by department");
        List<Category> categoryList = hibernateHelper.retreiveData("from Category order by category");
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("departmentList", departmentList);

        request.getRequestDispatcher("new_ticket.jsp").forward(request, response);
    }

    public void goToLocationSection() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId() + " order by location");
        request.setAttribute("locationList", locationList);
        request.getRequestDispatcher("location_section.jsp").forward(request, response);
    }

    public void goToDepartmentSection() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        //List<Department> departmentList = hibernateHelper.retreiveData("from Department order by department");
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());

        List<Department> departmentList = new ArrayList<>();
        for (LocationDepartment locationDepartment : locationDepartmentList) {
            departmentList.add(locationDepartment.getDepartment());
        }
        request.setAttribute("departmentList", departmentList);
        request.getRequestDispatcher("department_section.jsp").forward(request, response);
    }

    public void goToDeviceTypeSection() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<DeviceType> deviceTypeList = hibernateHelper.retreiveData("from DeviceType order by deviceType");
        request.setAttribute("deviceTypeList", deviceTypeList);
        request.getRequestDispatcher("device_type_section.jsp").forward(request, response);
    }

    public void goToDeviceSection() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location =" + location.getId() + " and department = " + department.getId());
        List<Device> deviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartmentList.get(0).getId() + " and deviceType = " + deviceType.getId());
        request.setAttribute("deviceList", deviceList);
        request.getRequestDispatcher("device_section.jsp").forward(request, response);
    }

    public void goToDeviceInfo() throws ServletException, IOException {
        Device device = (Device) hibernateHelper.retreiveData(Device.class, Long.valueOf(request.getParameter("device")));
        request.setAttribute("device", device);
        request.getRequestDispatcher("device_info.jsp").forward(request, response);
    }

    public void goToRegionOptions() throws ServletException, IOException {
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId());
        request.setAttribute("regionList", tsUserRegionList);
        request.getRequestDispatcher("region_options.jsp").forward(request, response);
    }


    public void goToOSOptions() throws ServletException, IOException {
        List<OS> osList = hibernateHelper.retreiveData("from OS order by OS");
        request.setAttribute("osList", osList);
        request.getRequestDispatcher("os_options.jsp").forward(request, response);
    }

    public void goToLocationOptions() throws ServletException, IOException {

        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId() + " order by location");
        request.setAttribute("locationList", locationList);
        request.getRequestDispatcher("location_options.jsp").forward(request, response);
    }

    public void goToDepartmentOptions() throws ServletException, IOException {
        System.out.println("location : " + request.getParameter("location"));
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());

        List<Department> departmentList = new ArrayList<>();
        for (LocationDepartment locationDepartment : locationDepartmentList) {
            departmentList.add(locationDepartment.getDepartment());
        }
        request.setAttribute("departmentList", departmentList);
        //response.sendRedirect(");
        request.getRequestDispatcher("department_options.jsp").forward(request, response);
    }

    public void goToDeviceTypeOptions() throws ServletException, IOException {
        List<DeviceType> deviceTypeList = hibernateHelper.retreiveData("from DeviceType order by deviceType");
        request.setAttribute("deviceTypeList", deviceTypeList);
        request.getRequestDispatcher("device_type_options.jsp").forward(request, response);
    }

    public void goToDeviceOptions() throws ServletException, IOException {
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        List<Device> deviceList = hibernateHelper.retreiveData("from Device where department = " + department.getId() + " and deviceType = " + deviceType.getId());
        request.setAttribute("deviceList", deviceList);
        request.getRequestDispatcher("device_options.jsp").forward(request, response);
    }

    public void goToProblemCommentSection() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<Category> categoryList = hibernateHelper.retreiveData("from Category order by category");
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("problem_comment_section.jsp").forward(request, response);
    }

    public void goToCategoryOptions() throws ServletException, IOException {
        List<Category> categoryList = hibernateHelper.retreiveData("from Category order by category");
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("category_options.jsp").forward(request, response);
    }

    public void goToSubCategorySection() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<SubCategory> subCategoryList = hibernateHelper.retreiveData("from SubCategory where category = " + request.getParameter("category") + " order by sub_category");
        request.setAttribute("subCategoryList", subCategoryList);
        request.getRequestDispatcher("sub_category_section.jsp").forward(request, response);
    }

    public void goToSubCategoryOptions() throws ServletException, IOException {
        List<SubCategory> subCategoryList = hibernateHelper.retreiveData("from SubCategory where category = " + request.getParameter("category") + " order by sub_category");
        request.setAttribute("subCategoryList", subCategoryList);
        request.getRequestDispatcher("sub_category_options.jsp").forward(request, response);
    }

    public void goToAssignToSection() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        Device device = (Device) hibernateHelper.retreiveData(Device.class, Long.valueOf(request.getParameter("device_")));
        Region region = device.getLocationDepartment().getLocation().getRegion();
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and region = " + region.getId() + " order by region");
        request.setAttribute("tsUserRegionList", tsUserRegionList);
        request.setAttribute("currentUser", user);
        request.getRequestDispatcher("assign_to_section.jsp").forward(request, response);
    }

    public void goToTicketReport() throws ServletException, IOException {
        Ticket ticket = (Ticket) hibernateHelper.retreiveData(Ticket.class, Long.valueOf(request.getParameter("ticket")));
        List<TicketStatus> ticketStatusList = hibernateHelper.retreiveData("from TicketStatus where done = false and ticket = " + ticket.getId());
        if (ticket.getCurrentStatus().getId() == 1) {
            List<TicketAssignedTo> ticketAssignedToList = hibernateHelper.retreiveData("from TicketAssignedTo where done = false and ticket =" + ticket.getId());
            request.setAttribute("ticketAssignedToList", ticketAssignedToList);
        }
        List<TicketStatus> allTicketStatusList = hibernateHelper.retreiveData("from TicketStatus where ticket = " + ticket.getId());
        request.setAttribute("ticket", ticket);
        request.setAttribute("device", ticket.getDevice());
        request.setAttribute("ticketStatusList", ticketStatusList);
        request.setAttribute("allTicketStatusList", allTicketStatusList);
        request.setAttribute("ticketStatus", getTicketStatus(ticket));
        request.setAttribute("status", getStatusStyle(ticket.getCurrentStatus()));
        request.getRequestDispatcher("ticket_report.jsp").forward(request, response);
    }

    public void goToTicketEdit() throws ServletException, IOException {
        Ticket ticket = (Ticket) hibernateHelper.retreiveData(Ticket.class, Long.valueOf(request.getParameter("ticket")));
        List<TicketStatus> ticketStatusList = hibernateHelper.retreiveData("from TicketStatus where done = false and ticket = " + ticket.getId());
        if (ticket.getCurrentStatus().getId() == 1) {
            List<TicketAssignedTo> ticketAssignedToList = hibernateHelper.retreiveData("from TicketAssignedTo where done = false and ticket =" + ticket.getId());
            request.setAttribute("ticketAssignedToList", ticketAssignedToList);
        }
        List<TicketStatus> allTicketStatusList = hibernateHelper.retreiveData("from TicketStatus where ticket = " + ticket.getId());
        request.setAttribute("ticket", ticket);
        request.setAttribute("device", ticket.getDevice());
        request.setAttribute("ticketStatusList", ticketStatusList);
        request.setAttribute("allTicketStatusList", allTicketStatusList);
        request.setAttribute("ticketStatus", getTicketStatus(ticket));
        request.setAttribute("status", getStatusStyle(ticket.getCurrentStatus()));
        request.getRequestDispatcher("edit_ticket.jsp").forward(request, response);
    }

    private String getStatusStyle(Status status) {
        String statusStyle = "";
        if (status.getId() == 1) {
            statusStyle = "card-outline-primary";
        } else if (status.getId() == 2) {
            statusStyle = "card-outline-warning";
        } else if (status.getId() == 3) {
            statusStyle = "card-outline-secondary";
        } else if (status.getId() == 4) {
            statusStyle = "card-outline-success";
        }
        return statusStyle;
    }

    private List getTickets() {
        return hibernateHelper.retreiveData("from Ticket");
    }

    private List getTicketsAssignedByUser(User user) {
        return hibernateHelper.retreiveData("from TicketAssignedTo where assignedBy = " + user.getId());
    }

    private List getTicketsAssignedToUser(User user) {
        return hibernateHelper.retreiveData("from TicketAssignedTo where done = false and assignedTo = " + user.getId());
    }

    private List getTicketsSolvedByUser(User user) {
        return hibernateHelper.retreiveData("from Ticket where done = false and solvedBy = " + user.getId());
    }

    private List getTicketNeedToClose(Region region) {
        Status solvedStatus = (Status) hibernateHelper.retreiveData(Status.class, (long) 4);
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where region = " + region.getId());
        List<TicketStatus> ticketSolvedList = new ArrayList<>();
        for (TSUserRegion tsUserRegion : tsUserRegionList) {
            ticketSolvedList.addAll(hibernateHelper.retreiveData("from TicketStatus where done = false and status = " + solvedStatus.getId() + " and TSUser = " + tsUserRegion.getTSUser().getId()));

        }
        return ticketSolvedList;
    }

    private List getTicketsClosedByUser(User user) {
        return hibernateHelper.retreiveData("from Ticket where done = true and (solvedBy = " + user.getId() + " or closedBy = " + user.getId() + ")");
    }

    private List getTicketStatus(Ticket ticket) {
        return hibernateHelper.retreiveData("from TicketStatus where ticket = " + ticket.getId());
    }

    private List getTicketsInProgressByUser(User user) {
        Status inProgressStatus = (Status) hibernateHelper.retreiveData(Status.class, (long) 2);
        return hibernateHelper.retreiveData("from TicketStatus where done =false and status = " + inProgressStatus.getId() + " and TSUser = " + user.getId());
    }

    private List getTicketsPendingByUser(User user) {
        Status pendingStatus = (Status) hibernateHelper.retreiveData(Status.class, (long) 3);
        return hibernateHelper.retreiveData("from TicketStatus where done =false and status = " + pendingStatus.getId() + " and TSUser = " + user.getId());
    }

    public void goToAssignedToTab() throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        request.setAttribute("tickets", getTickets());
        request.setAttribute("ticketsAssignedByList", getTicketsAssignedByUser(user));
        request.getRequestDispatcher("assigned_to_tab.jsp").forward(request, response);
    }

    public void goToAssignedToDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("tickets", getTickets());
        request.setAttribute("ticketsAssignedByList", getTicketsAssignedByUser(user));
        request.getRequestDispatcher("assigned_to_details_tab.jsp").forward(request, response);
    }

    public void goToNeedToSolveTab() throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        request.setAttribute("tickets", getTickets());
        request.setAttribute("ticketsAssignedToList", getTicketsAssignedToUser(user));
        request.getRequestDispatcher("need_to_solve_tab.jsp").forward(request, response);
    }

    public void goToNeedToSolveDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("tickets", getTickets());
        request.setAttribute("ticketsAssignedToList", getTicketsAssignedToUser(user));
        request.getRequestDispatcher("need_to_solve_details_tab.jsp").forward(request, response);
    }


    public void goToNeedToCloseTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getRole().getId() == 2) {
            //User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
            List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("From TSUserRegion where TSUser = " + user.getId());
            request.setAttribute("tickets", getTickets());
            System.out.println("Close region : " + tsUserRegionList.get(0).getRegion().getRegion());
            request.setAttribute("ticketsSolvedList", getTicketNeedToClose(tsUserRegionList.get(0).getRegion()));

        } else {
            request.setAttribute("ticketsSolvedList", null);
        }
        request.getRequestDispatcher("need_to_close_tab.jsp").forward(request, response);
    }

    public void goToNeedToCloseDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getRole().getId() == 2) {
            //User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
            List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("From TSUserRegion where TSUser = " + user.getId());
            request.setAttribute("tickets", getTickets());
            System.out.println("Close region : " + tsUserRegionList.get(0).getRegion().getRegion());
            request.setAttribute("ticketsSolvedList", getTicketNeedToClose(tsUserRegionList.get(0).getRegion()));

        } else {
            request.setAttribute("ticketsSolvedList", null);
        }
        request.getRequestDispatcher("need_to_close_details_tab.jsp").forward(request, response);
    }

    /*public void goToNeedToCloseDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("From TSUserRegion where TSUser = "+user.getId());
        request.setAttribute("tickets", getTickets());
        request.setAttribute("ticketsAssignedToList", getTicketNeedToClose(tsUserRegionList.get(0).getRegion()));
        request.getRequestDispatcher("need_to_solve_details_tab.jsp").forward(request, response);
    }*/

    public void goToSolvedTab() throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        request.setAttribute("ticketsSolvedList", getTicketsSolvedByUser(user));
        request.setAttribute("user", user);
        request.getRequestDispatcher("solved_tab.jsp").forward(request, response);
    }

    public void goToSolvedDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsSolvedList", getTicketsSolvedByUser(user));
        request.setAttribute("user", user);
        request.getRequestDispatcher("solved_details_tab.jsp").forward(request, response);
    }

    public void goToClosedTab() throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        request.setAttribute("ticketsClosedList", getTicketsClosedByUser(user));
        request.getRequestDispatcher("closed_tab.jsp").forward(request, response);
    }

    public void goToClosedDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsClosedList", getTicketsClosedByUser(user));
        request.getRequestDispatcher("closed_details_tab.jsp").forward(request, response);
    }

    public void goToInProgressTab() throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        request.setAttribute("ticketsInProgressList", getTicketsInProgressByUser(user));
        request.getRequestDispatcher("in_progress_tab.jsp").forward(request, response);
    }

    public void goToInProgressDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsInProgressList", getTicketsInProgressByUser(user));
        request.getRequestDispatcher("in_progress_details_tab.jsp").forward(request, response);
    }

    public void goToPendingTab() throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        request.setAttribute("ticketsPendingList", getTicketsPendingByUser(user));
        request.getRequestDispatcher("pending_tab.jsp").forward(request, response);
    }

    public void goToPendingDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsPendingList", getTicketsPendingByUser(user));
        request.getRequestDispatcher("pending_details_tab.jsp").forward(request, response);
    }

    public void goToTicketChart() throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        System.out.println(user.getName());
        request.setAttribute("user", user);
        request.setAttribute("assignToUserCount", controllerHelper.getTicketAssignedToUserCount(user));
        request.setAttribute("assignToCount", controllerHelper.getTicketAssignToCount(user));
        request.setAttribute("inProgressCount", controllerHelper.getTicketInProgressByUserCount(user));
        request.setAttribute("pendingCount", controllerHelper.getTicketPendingByUserCount(user));
        request.setAttribute("solvedCount", controllerHelper.getTicketSolvedByUserCount(user));
        request.setAttribute("closedCount", controllerHelper.getTicketClosedByUserCount(user));
        request.setAttribute("needToCloseCount", controllerHelper.getTicketNeedToCloseCount(user));
        request.getRequestDispatcher("ticket_chart.jsp").forward(request, response);
    }

    public void goToRegionChart() throws ServletException, IOException {
        if (request.getParameter("region").equals("ALL")) {
            request.setAttribute("region", "ALL");
            request.setAttribute("assignToRegionCount", controllerHelper.getTicketAssignToAllRegionsCount());
            //request.setAttribute("needToSolveRegionCount", controllerHelper.getTicketAssignToCount());
            request.setAttribute("inProgressRegionCount", controllerHelper.getTicketAInProgressAllRegionsCount());
            request.setAttribute("closedRegionCount", controllerHelper.getTicketSolvedAllRegionsCount());
            request.setAttribute("pendingRegionCount", controllerHelper.getTicketPendingAllRegionsCount());
            request.setAttribute("solvedRegionCount", controllerHelper.getTicketSolvedAllRegionsCount());
        } else {
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
            System.out.println("region : " + region.getRegion());
            request.setAttribute("region", region);
            request.setAttribute("assignToRegionCount", controllerHelper.getTicketAssignToRegionCount());
            //request.setAttribute("needToSolveRegionCount", controllerHelper.getTicketAssignToCount());
            request.setAttribute("inProgressRegionCount", controllerHelper.getTicketInProgressRegionCount());
            request.setAttribute("closedRegionCount", controllerHelper.getTicketClosedRegionCount());
            request.setAttribute("pendingRegionCount", controllerHelper.getTicketPendingRegionCount());
            request.setAttribute("solvedRegionCount", controllerHelper.getTicketSolvedRegionCount());
        }
        request.getRequestDispatcher("region_chart.jsp").forward(request, response);
    }


    public void goToDeviceChart() throws ServletException, IOException {
        if (request.getParameter("region").equals("ALL")) {
            request.setAttribute("region", "ALL");
        } else {
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
            request.setAttribute("region", region);
        }
        request.setAttribute("PC_count", controllerHelper.getRegionPCCount(request.getParameter("region")));
        request.setAttribute("Printer_count", controllerHelper.getRegionPrinterCount(request.getParameter("region")));
        request.setAttribute("PBX_count", controllerHelper.getRegionIPPhoneCount(request.getParameter("region")));
        request.setAttribute("FP_count", controllerHelper.getRegionFPCount(request.getParameter("region")));
        request.setAttribute("SW_count", controllerHelper.getRegionSWCount(request.getParameter("region")));
        request.setAttribute("RO_count", controllerHelper.getRegionROCount(request.getParameter("region")));
        request.setAttribute("CAM_count", controllerHelper.getRegionCameraCount(request.getParameter("region")));
        request.setAttribute("DVR_count", controllerHelper.getRegionDVRCount(request.getParameter("region")));
        request.setAttribute("NVR_count", controllerHelper.getRegionNVRCount(request.getParameter("region")));
        request.setAttribute("UPS_count", controllerHelper.getRegionUPSCount(request.getParameter("region")));
        request.setAttribute("FW_count", controllerHelper.getRegionFWCount(request.getParameter("region")));

        request.getRequestDispatcher("device_chart.jsp").forward(request, response);
        return;
    }

    public void goToDevices() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId() + " order by region");
        List<Location> locationList = hibernateHelper.retreiveData("from Location order by location");
        DeviceType switchType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 5);
        DeviceType routerType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 6);
        DeviceType UPSType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 10);
        DeviceType firewallType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 11);
        DeviceType cameraType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 4);
        DeviceType NVRType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 7);
        DeviceType DVRType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 3);
        List<PC> deviceList = new ArrayList<>();
        List<Printer> printerList = new ArrayList<>();
        List<PBX> pbxList = new ArrayList<>();
        List<Attendance> attendanceList = new ArrayList<>();
        List<VideoRecorder> NVRList = new ArrayList<>();
        List<VideoRecorder> DVRList = new ArrayList<>();
        List<Device> switchList = new ArrayList<>();
        List<Device> routerList = new ArrayList<>();
        List<Device> UPSList = new ArrayList<>();
        List<Device> firewallList = new ArrayList<>();
        List<Device> cameraList = new ArrayList<>();
        for (TSUserRegion tsUserRegion : tsUserRegionList) {
            System.out.println(tsUserRegion.getRegion().getRegion());
            for (Location location : locationList) {
                System.out.println(location.getRegion().getId() == tsUserRegion.getRegion().getId());
                List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
                if (location.getRegion().getId() == tsUserRegion.getRegion().getId()) {
                    for (LocationDepartment locationDepartment : locationDepartmentList) {
                        deviceList.addAll(hibernateHelper.retreiveData("from PC where locationDepartment = " + locationDepartment.getId()));
                        printerList.addAll(hibernateHelper.retreiveData("from Printer where locationDepartment = " + locationDepartment.getId()));
                        pbxList.addAll(hibernateHelper.retreiveData("from PBX where locationDepartment = " + locationDepartment.getId()));
                        attendanceList.addAll(hibernateHelper.retreiveData("from Attendance where locationDepartment = " + locationDepartment.getId()));
                        NVRList.addAll(hibernateHelper.retreiveData("from VideoRecorder where locationDepartment = " + locationDepartment.getId() + " and deviceType = " + NVRType.getId()));
                        DVRList.addAll(hibernateHelper.retreiveData("from VideoRecorder where locationDepartment = " + locationDepartment.getId() + " and deviceType = " + DVRType.getId()));
                        switchList.addAll(hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId() + " and deviceType =" + switchType.getId()));
                        routerList.addAll(hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId() + " and deviceType =" + routerType.getId()));
                        UPSList.addAll(hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId() + " and deviceType =" + UPSType.getId()));
                        firewallList.addAll(hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId() + " and deviceType =" + firewallType.getId()));
                        cameraList.addAll(hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId() + " and deviceType =" + cameraType.getId()));
                    }
                }
            }
        }

        //List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + tsUserRegionList.get(0).getRegion().getId() + " order by location");
        //List<PC> deviceList = hibernateHelper.retreiveData("from PC where location order by location");
        //List<PC> deviceList = hibernateHelper.retreiveData("from PC,Location,Region where PC.location = Location.id and Location.region = Region.id and ")
        /*List<Printer> printerList = hibernateHelper.retreiveData("from Printer order by location");
        List<Attendance> attendanceList = hibernateHelper.retreiveData("from Attendance order by location");
        List<PBX> pbxList = hibernateHelper.retreiveData("from PBX order by location");
        List<VideoRecorder> NVRList = hibernateHelper.retreiveData("from VideoRecorder where deviceType = " + NVRType.getId() + " order by location");
        List<VideoRecorder> DVRList = hibernateHelper.retreiveData("from VideoRecorder where deviceType = " + DVRType.getId() + " order by location");
        List<Device> switchList = hibernateHelper.retreiveData("from Device where deviceType =" + switchType.getId() + " order by location");
        List<Device> routerList = hibernateHelper.retreiveData("from Device where deviceType =" + routerType.getId() + " order by location");
        List<Device> UPSList = hibernateHelper.retreiveData("from Device where deviceType =" + UPSType.getId() + " order by location");
        List<Device> firewallList = hibernateHelper.retreiveData("from Device where deviceType =" + firewallType.getId() + " order by location");
        List<Device> cameraList = hibernateHelper.retreiveData("from Device where deviceType =" + cameraType.getId() + " order by location");

         */
        request.setAttribute("regionList", tsUserRegionList);
        request.setAttribute("attendanceList", attendanceList);
        //request.setAttribute("locationList", locationList);
        request.setAttribute("deviceList", deviceList);
        request.setAttribute("printerList", printerList);
        request.setAttribute("pbxList", pbxList);
        request.setAttribute("switchList", switchList);
        request.setAttribute("routerList", routerList);
        request.setAttribute("UPSList", UPSList);
        request.setAttribute("firewallList", firewallList);
        request.setAttribute("cameraList", cameraList);
        request.setAttribute("NVRList", NVRList);
        request.setAttribute("DVRList", DVRList);
        request.getRequestDispatcher("devices.jsp").forward(request, response);
    }

    public void goToPCTypeOptions() throws ServletException, IOException {
        List<PCType> pcTypeList = hibernateHelper.retreiveData("from PCType order by pcType");
        request.setAttribute("pcTypeList", pcTypeList);
        request.getRequestDispatcher("pc_type_options.jsp").forward(request, response);
    }

    public void goToPCData() throws ServletException, IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
        List<PCType> pcTypeList = hibernateHelper.retreiveData("from PCType order by pcType");
        List<OS> osList = hibernateHelper.retreiveData("from OS order by OS");
        List<Employee> employeeList = hibernateHelper.retreiveData("from Employee where locationDepartment = " + locationDepartmentList.get(0).getId() + " order by name");
        request.setAttribute("osList", osList);
        request.setAttribute("pcTypeList", pcTypeList);
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("pc_data.jsp").forward(request, response);
    }

    public void goToPrinterData() throws ServletException, IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
        List<PrinterConnection> printerConnectionList = hibernateHelper.retreiveData("from PrinterConnection order by connection");
        List<Employee> employeeList = hibernateHelper.retreiveData("from Employee where locationDepartment = " + locationDepartmentList.get(0).getId() + " order by name");
        request.setAttribute("printerConnectionList", printerConnectionList);
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("printer_data.jsp").forward(request, response);
    }

    public void goToPBXData() throws ServletException, IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
        List<Employee> employeeList = hibernateHelper.retreiveData("from Employee where locationDepartment = " + locationDepartmentList.get(0).getId() + " order by name");
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("PBX_data.jsp").forward(request, response);
    }

    public void goToAddDevice() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId() + " order by region");
        /*if (tsUserRegionList.size() == 1) {
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + tsUserRegionList.get(0).getRegion().getId() + " order by location");
            request.setAttribute("locationList", locationList);
            request.getRequestDispatcher("add_device.jsp").forward(request, response);
        } else if (tsUserRegionList.size() > 1) {

        }*/
        List<Category> categoryList = hibernateHelper.retreiveData("from Category order by category");
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("regionList", tsUserRegionList);
        request.getRequestDispatcher("add_device.jsp").forward(request, response);
    }

    public void goToEditDevice() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId() + " order by region");
        Device device = (Device) hibernateHelper.retreiveData(Device.class, Long.valueOf(request.getParameter("device")));
        List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + tsUserRegionList.get(0).getRegion().getId() + " order by location");
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + device.getLocationDepartment().getLocation().getId());

        List<Department> departmentList = new ArrayList<>();
        for (LocationDepartment locationDepartment : locationDepartmentList) {
            departmentList.add(locationDepartment.getDepartment());
        }
        List<DeviceType> deviceTypeList = hibernateHelper.retreiveData("from DeviceType order by deviceType");
        Department department = device.getLocationDepartment().getDepartment();
        List<PCType> pcTypeList = hibernateHelper.retreiveData("from PCType order by pcType");
        List<OS> osList = hibernateHelper.retreiveData("from OS order by OS");
        List<Employee> employeeList = hibernateHelper.retreiveData("from Employee where department = " + department.getId() + " order by name");
        List<PrinterConnection> printerConnectionList = hibernateHelper.retreiveData("from PrinterConnection order by connection");
        request.setAttribute("printerConnectionList", printerConnectionList);
        request.setAttribute("osList", osList);
        request.setAttribute("pcTypeList", pcTypeList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("departmentList", departmentList);
        request.setAttribute("device", device);
        request.setAttribute("locationList", locationList);
        request.setAttribute("regionList", tsUserRegionList);
        request.setAttribute("deviceTypeList", deviceTypeList);
        request.getRequestDispatcher("edit_device.jsp").forward(request, response);
    }

    public void goToEmployeeOptions() throws ServletException, IOException {
        List<Employee> employeeList;
        if (request.getParameter("department") != null) {
            Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
            Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
            employeeList = hibernateHelper.retreiveData("from Employee where locationDepartment = " + locationDepartmentList.get(0).getId() + " order by name");
        } else {
            employeeList = new ArrayList<>();
        }
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee_options.jsp").forward(request, response);
    }

    public void goToAddUser() throws ServletException, IOException {
        List<Role> roleList = hibernateHelper.retreiveData("from Role");
        List<Region> regionList = hibernateHelper.retreiveData("from Region order by region");
        List<Privilege> privilegeList = hibernateHelper.retreiveData("from Privilege");
        request.setAttribute("roleList", roleList);
        request.setAttribute("privilegeList", privilegeList);
        request.setAttribute("regionList", regionList);
        request.getRequestDispatcher("add_user.jsp").forward(request, response);
    }

    private HttpServletRequest getUserPrivilege(User user, HttpServletRequest request) {
        List<UserPrivilege> userPrivilegeList = hibernateHelper.retreiveData("from UserPrivilege where valid = true and user = " + user.getId());
        List<Privilege> privilegeList = hibernateHelper.retreiveData("from Privilege");

        for (Privilege privilege : privilegeList) {
            if (userPrivilegeList.size() > 0) {
                for (UserPrivilege userPrivilege : userPrivilegeList) {
                    if (privilege.getId() == userPrivilege.getPrivilege().getId()) {
                        request.setAttribute("P_" + privilege.getId(), true);
                        System.out.println(privilege.getPrivilege() + " : true");
                        break;
                    } else if (privilege.getId() != userPrivilege.getPrivilege().getId() && userPrivilegeList.get(userPrivilegeList.size() - 1).getPrivilege().getId() == userPrivilege.getPrivilege().getId()) {
                        request.setAttribute("P_" + privilege.getId(), false);
                        System.out.println(privilege.getPrivilege() + " : false");
                    }

                }
            } else {
                request.setAttribute("P_" + privilege.getId(), false);
                System.out.println(privilege.getPrivilege() + " : false");
            }
        }

        return request;
    }

    public void goToDashboard() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId());
        String region = "";
        if (tsUserRegionList.size() == 1) {
            region = tsUserRegionList.get(0).getRegion().getRegion();
        } else if (tsUserRegionList.size() > 1) {
            region = "Technology Sector";
        }
        List<TSUserRegion> userRegions = new ArrayList<>();
        List<TSUserRegion> userRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser != " + user.getId());
        for (TSUserRegion tsUserRegion : tsUserRegionList) {
            for (TSUserRegion userRegion : userRegionList) {
                if (userRegion.getRegion().getId() == tsUserRegion.getRegion().getId() && tsUserRegion.getTSUser().getId() != userRegion.getTSUser().getId() && userRegion.getTSUser().getRole().getId() == 5) {
                    userRegions.add(userRegion);

                }
            }
        }
        System.out.println("size: " + userRegions.size());
        List<Department> departmentList = hibernateHelper.retreiveData("from Department order by department");
        request = getUserPrivilege(user, request);
        request.setAttribute("current_user", user);
        request.setAttribute("userRegionList", tsUserRegionList);
        request.setAttribute("userRegions", userRegions);
        request.setAttribute("departmentList", departmentList);
        request.setAttribute("region", region);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    public void goToDashboardDetails() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Department> departmentList = hibernateHelper.retreiveData("from Department order by department");
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId());
        System.out.println("yysize" + tsUserRegionList.size());
        List<TSUserRegion> userRegions = new ArrayList<>();
        List<TSUserRegion> userRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser != " + user.getId());
        for (TSUserRegion tsUserRegion : tsUserRegionList) {
            for (TSUserRegion userRegion : userRegionList) {
                if (userRegion.getRegion().getId() == tsUserRegion.getRegion().getId() && tsUserRegion.getTSUser().getId() != userRegion.getTSUser().getId() && userRegion.getTSUser().getRole().getId() == 5) {
                    userRegions.add(userRegion);

                }
            }
        }
        //List<>
        request.setAttribute("current_user", user);
        request.setAttribute("userRegionList", tsUserRegionList);
        request.setAttribute("userRegions", userRegions);
        request.setAttribute("departmentList", departmentList);
        request.getRequestDispatcher("dashboard_details.jsp").forward(request, response);
    }

    public void goToRegionTicketRatioSection() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId());
        request.setAttribute("userRegionList", tsUserRegionList);
        request.setAttribute("current_user", user);
        request.getRequestDispatcher("dashboard_section/region_ticket_ratio_section.jsp").forward(request, response);
    }

    public void goToRegionDevicesRatioSection() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId());
        request.setAttribute("userRegionList", tsUserRegionList);
        request.setAttribute("current_user", user);
        request.getRequestDispatcher("dashboard_section/region_devices_ratio_section.jsp").forward(request, response);
    }

    public void goToL2EngineersTicketRatioSection() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId());
        List<TSUserRegion> userRegions = new ArrayList<>();
        List<TSUserRegion> userRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser != " + user.getId());
        for (TSUserRegion tsUserRegion : tsUserRegionList) {
            for (TSUserRegion userRegion : userRegionList) {
                if (userRegion.getRegion().getId() == tsUserRegion.getRegion().getId() && tsUserRegion.getTSUser().getId() != userRegion.getTSUser().getId() && userRegion.getTSUser().getRole().getId() == 5) {
                    userRegions.add(userRegion);

                }
            }
        }
        request.setAttribute("userRegions", userRegions);
        request.getRequestDispatcher("dashboard_section/L2_engineers_ticket_ratio_section.jsp").forward(request, response);
    }

    public void goToUsers() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<User> userList = hibernateHelper.retreiveData("from User order by role");
        List<UserPrivilege> userPrivilegeList = hibernateHelper.retreiveData("from UserPrivilege where valid = true");
        List<Privilege> privilegeList = hibernateHelper.retreiveData("from Privilege");
        request.setAttribute("userPrivilegeList", userPrivilegeList);
        request.setAttribute("privilegeList", privilegeList);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

    public void goToEmployees() throws ServletException, IOException {
        request = getUserPrivilege(user, request);

        List<Employee> regionEmployeeList = new ArrayList<>();
        List<Employee> employeeList = hibernateHelper.retreiveData("from Employee order by name");
        if (user.getRole().getId() == 1 || user.getRole().getId() == 3 || user.getRole().getId() == 6) {
            request.setAttribute("employeeList", employeeList);
            request.setAttribute("isRegional", true);
        } else {
            List<TSUserRegion> userRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId());
            for (Employee employee : employeeList) {
                for (TSUserRegion tsUserRegion : userRegionList) {
                    if (employee.getLocationDepartment().getLocation().getRegion().getId() == tsUserRegion.getRegion().getId()) {
                        regionEmployeeList.add(employee);
                    }
                }
            }
            if (userRegionList.size() == 1)
                request.setAttribute("isRegional", false);
            else if (userRegionList.size() > 1) {
                request.setAttribute("isRegional", true);
            }
            request.setAttribute("employeeList", regionEmployeeList);
        }
        request.getRequestDispatcher("employees.jsp").forward(request, response);
    }

    public void goToEditUser() throws ServletException, IOException {

        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        List<UserPrivilege> userPrivilegeList = hibernateHelper.retreiveData("from UserPrivilege where valid = true and user = " + user.getId());
        List<TSUserRegion> userRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId() + " order by region");
        List<Role> roleList = hibernateHelper.retreiveData("from Role");
        List<Region> regionList = hibernateHelper.retreiveData("from Region order by region");
        List<Privilege> privilegeList = hibernateHelper.retreiveData("from Privilege");
        request.setAttribute("user", user);
        request.setAttribute("roleList", roleList);
        request.setAttribute("privilegeList", privilegeList);
        request.setAttribute("regionList", regionList);
        request.setAttribute("userRegionList", userRegionList);
        request.setAttribute("userPrivilegeList", userPrivilegeList);
        request.getRequestDispatcher("edit_user.jsp").forward(request, response);

    }

    public void goToEditEmployee() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        Employee employee = (Employee) hibernateHelper.retreiveData(Employee.class, Long.valueOf(request.getParameter("employee")));
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where valid = true and TSUser = " + user.getId() + " order by region");
        List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + employee.getLocationDepartment().getLocation().getRegion().getId() + " order by location");
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + employee.getLocationDepartment().getLocation().getId());

        List<Department> departmentList = new ArrayList<>();
        for (LocationDepartment locationDepartment : locationDepartmentList) {
            departmentList.add(locationDepartment.getDepartment());
        }
        request.setAttribute("regionList", tsUserRegionList);
        request.setAttribute("departmentList", departmentList);
        request.setAttribute("locationList", locationList);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("edit_employee.jsp").forward(request, response);
    }

    public void goToPrivileges() throws ServletException, IOException {
        List<Privilege> privilegeList = hibernateHelper.retreiveData("from Privilege");
        request.setAttribute("privilegeList", privilegeList);
        request.getRequestDispatcher("privileges.jsp").forward(request, response);
    }

    public void goToAddPrivilege() throws ServletException, IOException {
        request.getRequestDispatcher("add_privilege.jsp").forward(request, response);
    }

    public void goToEditPrivilege() throws ServletException, IOException {
        Privilege privilege = (Privilege) hibernateHelper.retreiveData(Privilege.class, Long.valueOf(request.getParameter("privilege")));
        request.setAttribute("privilege", privilege);
        request.getRequestDispatcher("edit_privilege.jsp").forward(request, response);
    }


}

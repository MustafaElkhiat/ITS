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
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where edited = false and TSUser = " + user.getId() + " order by region");
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
        List<Category> categoryList = hibernateHelper.retreiveData("from Category order by category");
        request.setAttribute("categoryList", categoryList);

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
        List<Department> departmentList = hibernateHelper.retreiveData("from Department where location = " + location.getId() + " order by department");
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
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        List<Device> deviceList = hibernateHelper.retreiveData("from Device where department = " + department.getId() + " and deviceType = " + deviceType.getId());
        request.setAttribute("deviceList", deviceList);
        request.getRequestDispatcher("device_section.jsp").forward(request, response);
    }

    public void goToDeviceInfo() throws ServletException, IOException {
        Device device = (Device) hibernateHelper.retreiveData(Device.class, Long.valueOf(request.getParameter("device")));
        request.setAttribute("device", device);
        request.getRequestDispatcher("device_info.jsp").forward(request, response);
    }

    public void goToRegionOptions() throws ServletException, IOException {
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where edited = false and TSUser = " + user.getId());
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
        List<Department> departmentList = hibernateHelper.retreiveData("from Department where location = " + location.getId() + " order by department");
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
        Region region = device.getDepartment().getLocation().getRegion();
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where edited = false and region = " + region.getId() + " order by region");
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
        request.setAttribute("ticket", ticket);
        request.setAttribute("device", ticket.getDevice());
        request.setAttribute("ticketStatusList", ticketStatusList);
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
        request.setAttribute("ticket", ticket);
        request.setAttribute("device", ticket.getDevice());
        request.setAttribute("ticketStatusList", ticketStatusList);
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
        return hibernateHelper.retreiveData("from Ticket where done = true and solvedBy = " + user.getId());
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
        User user = (User) request.getSession().getAttribute("user");
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
        User user = (User) request.getSession().getAttribute("user");
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

    public void goToSolvedTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsSolvedList", getTicketsSolvedByUser(user));
        request.getRequestDispatcher("solved_tab.jsp").forward(request, response);
    }

    public void goToSolvedDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsSolvedList", getTicketsSolvedByUser(user));
        request.getRequestDispatcher("solved_details_tab.jsp").forward(request, response);
    }

    public void goToInProgressTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsInProgressList", getTicketsInProgressByUser(user));
        request.getRequestDispatcher("in_progress_tab.jsp").forward(request, response);
    }

    public void goToInProgressDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsInProgressList", getTicketsInProgressByUser(user));
        request.getRequestDispatcher("in_progress_details_tab.jsp").forward(request, response);
    }

    public void goToPendingTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsPendingList", getTicketsPendingByUser(user));
        request.getRequestDispatcher("pending_tab.jsp").forward(request, response);
    }

    public void goToPendingDetailsTab() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ticketsPendingList", getTicketsPendingByUser(user));
        request.getRequestDispatcher("pending_details_tab.jsp").forward(request, response);
    }

    public void goToTicketChart() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getName());
        request.setAttribute("assignToUserCount", controllerHelper.getTicketAssignedToUserSum(user));
        request.setAttribute("assignToCount", controllerHelper.getTicketAssignToSum(user));
        request.setAttribute("inProgressCount", controllerHelper.getTicketInProgressByUserSum(user));
        request.setAttribute("pendingCount", controllerHelper.getTicketPendingByUserSum(user));
        request.setAttribute("solvedCount", controllerHelper.getTicketSolvedByUserSum(user));
        request.getRequestDispatcher("ticket_chart.jsp").forward(request, response);
    }

    public void goToDevices() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where edited = false and TSUser = " + user.getId() + " order by region");
        List<Location> locationList = hibernateHelper.retreiveData("from Location");
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
                if (location.getRegion().getId() == tsUserRegion.getRegion().getId()) {
                    deviceList.addAll(hibernateHelper.retreiveData("from PC where location = " + location.getId() + " order by location"));
                    printerList.addAll(hibernateHelper.retreiveData("from Printer where location = " + location.getId() + " order by location"));
                    pbxList.addAll(hibernateHelper.retreiveData("from PBX where location = " + location.getId() + " order by location"));
                    attendanceList.addAll(hibernateHelper.retreiveData("from Attendance where location = " + location.getId() + " order by location"));
                    NVRList.addAll(hibernateHelper.retreiveData("from VideoRecorder where location = " + location.getId() + " and deviceType = " + NVRType.getId() + " order by location"));
                    DVRList.addAll(hibernateHelper.retreiveData("from VideoRecorder where location = " + location.getId() + " and deviceType = " + DVRType.getId() + " order by location"));
                    switchList.addAll(hibernateHelper.retreiveData("from Device where location = " + location.getId() + " and deviceType =" + switchType.getId() + " order by location"));
                    routerList.addAll(hibernateHelper.retreiveData("from Device where location = " + location.getId() + " and deviceType =" + routerType.getId() + " order by location"));
                    UPSList.addAll(hibernateHelper.retreiveData("from Device where location = " + location.getId() + " and deviceType =" + UPSType.getId() + " order by location"));
                    firewallList.addAll(hibernateHelper.retreiveData("from Device where location = " + location.getId() + " and deviceType =" + firewallType.getId() + " order by location"));
                    cameraList.addAll(hibernateHelper.retreiveData("from Device where location = " + location.getId() + " and deviceType =" + cameraType.getId() + " order by location"));
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
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<PCType> pcTypeList = hibernateHelper.retreiveData("from PCType order by pcType");
        List<OS> osList = hibernateHelper.retreiveData("from OS order by OS");
        List<Employee> employeeList = hibernateHelper.retreiveData("from Employee where department = " + department.getId() + " order by name");
        request.setAttribute("osList", osList);
        request.setAttribute("pcTypeList", pcTypeList);
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("pc_data.jsp").forward(request, response);
    }

    public void goToPrinterData() throws ServletException, IOException {
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<PrinterConnection> printerConnectionList = hibernateHelper.retreiveData("from PrinterConnection order by connection");
        List<Employee> employeeList = hibernateHelper.retreiveData("from Employee where department = " + department.getId() + " order by name");
        request.setAttribute("printerConnectionList", printerConnectionList);
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("printer_data.jsp").forward(request, response);
    }

    public void goToPBXData() throws ServletException, IOException {
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<Employee> employeeList = hibernateHelper.retreiveData("from Employee where department = " + department.getId() + " order by name");
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("PBX_data.jsp").forward(request, response);
    }

    public void goToAddDevice() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where edited = false and TSUser = " + user.getId() + " order by region");
        /*if (tsUserRegionList.size() == 1) {
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + tsUserRegionList.get(0).getRegion().getId() + " order by location");
            request.setAttribute("locationList", locationList);
            request.getRequestDispatcher("add_device.jsp").forward(request, response);
        } else if (tsUserRegionList.size() > 1) {

        }*/
        request.setAttribute("regionList", tsUserRegionList);
        request.getRequestDispatcher("add_device.jsp").forward(request, response);
    }

    public void goToEditDevice() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where edited = false and TSUser = " + user.getId() + " order by region");
        Device device = (Device) hibernateHelper.retreiveData(Device.class, Long.valueOf(request.getParameter("device")));
        List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + tsUserRegionList.get(0).getRegion().getId() + " order by location");
        List<Department> departmentList = hibernateHelper.retreiveData("from Department where location = " + device.getLocation().getId() + " order by department");
        List<DeviceType> deviceTypeList = hibernateHelper.retreiveData("from DeviceType order by deviceType");
        Department department = device.getDepartment();
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
            employeeList = hibernateHelper.retreiveData("from Employee where department = " + department.getId() + " order by name");
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
        List<UserPrivilege> userPrivilegeList = hibernateHelper.retreiveData("from UserPrivilege where edited = false and user = " + user.getId());
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
        request = getUserPrivilege(user, request);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    public void goToUsers() throws ServletException, IOException {
        request = getUserPrivilege(user, request);
        List<User> userList = hibernateHelper.retreiveData("from User order by role");
        List<UserPrivilege> userPrivilegeList = hibernateHelper.retreiveData("from UserPrivilege where edited = false");
        List<Privilege> privilegeList = hibernateHelper.retreiveData("from Privilege");
        request.setAttribute("userPrivilegeList", userPrivilegeList);
        request.setAttribute("privilegeList", privilegeList);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

    public void goToEditUser() throws ServletException, IOException {

        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        List<UserPrivilege> userPrivilegeList = hibernateHelper.retreiveData("from UserPrivilege where edited = false and user = " + user.getId());
        List<TSUserRegion> userRegionList = hibernateHelper.retreiveData("from TSUserRegion where edited = false and TSUser = " + user.getId() + " order by region");
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
}

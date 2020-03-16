package helpers;

import com.google.gson.JsonObject;
import elements.*;
import login.elements.Role;
import login.elements.User;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerHelper extends HelperBase {
    HibernateHelper hibernateHelper;

    public ControllerHelper(HttpServletRequest request, HttpServletResponse response) {

        super(request, response);
        hibernateHelper = new HibernateHelper(request, response);
        // init shiro - place this e.g. in the constructor
        //Factory<SecurityManager> factory = new IniSecurityManagerFactory();
        //org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        //SecurityUtils.setSecurityManager(securityManager);

    }


    public void login() throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> users = hibernateHelper.retreiveData("from User where username = '" + username + "' and password = '" + password + "'");
        if (users.size() == 1) {
            HttpSession session = request.getSession(true);
            //session.setMaxInactiveInterval(1800);
            /*for (User user : users) {
                session.setAttribute("user", user);

            }*/
            session.setAttribute("user", users.get(0));
            if (users.get(0).isActivated()) {
                DirectiveHelper directiveHelper = new DirectiveHelper(request, response);
                if (users.get(0).getRole().getId() == 7) {
                    directiveHelper.goToRegionDashboard(Long.valueOf(users.get(0).getUserName()));
                } else {
                    directiveHelper.goToDashboard();
                }
            } else {
                request.getRequestDispatcher("create_password.html").forward(request, response);
            }
            //request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("signIn.html").forward(request, response);
        }

    }


    public void logout() throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            System.out.println(user.getName() + " Logging out");
            session.removeAttribute("user");
            session.invalidate();
            request.getRequestDispatcher("signIn.html").forward(request, response);
            System.out.println(user.getName() + " logout");
        }
        request.getRequestDispatcher("signIn.html").forward(request, response);
    }

    /*

              public void createOperation() throws IOException {
                  User user = (User) request.getSession().getAttribute("user");
                  System.out.println(request.getParameter("first_weight"));
                  int first_weight = Integer.valueOf(request.getParameter("first_weight"));
                  String vechile_num = request.getParameter("vechile_num");
                  String maqtura_num = request.getParameter("maqtura_num");

                  //Ship ship = (Ship) hibernateHelper.retreiveData(Ship.class, Long.valueOf(request.getParameter("ship")));
                  boolean firstWeightAutomatic = Boolean.parseBoolean(request.getParameter("auto"));
                  Client client = (Client) hibernateHelper.retreiveData(Client.class, Long.valueOf(request.getParameter("client")));
                  //OperationType operationType = session1.get(OperationType.class, Long.valueOf(request.getParameter("operation_type")));
                  Goods goods = (Goods) hibernateHelper.retreiveData(Goods.class, Long.valueOf(request.getParameter("goods")));
                  Operation operation = new Operation(vechile_num, maqtura_num, first_weight, firstWeightAutomatic, client, goods, null, user);
                  hibernateHelper.saveData(operation);

                  response.getWriter().println(operation.getId());
              }

              public long recordSecondWeight() throws IOException {
                  User user = (User) request.getSession().getAttribute("user");
                  int second_weight = Integer.valueOf(request.getParameter("second_weight"));



                  Operation operation = (Operation) hibernateHelper.retreiveData(Operation.class, Long.valueOf(request.getParameter("operation")));
                  ClientGoods clientGoods = getClientGoods(operation.getClient(),operation.getGoods());

                  operation.setSecondWeight(Integer.valueOf(request.getParameter("second_weight")));
                  operation.setSecondWeightAutomatic(Boolean.parseBoolean(request.getParameter("auto")));
                  operation.setUser2(user);
                  OperationType operationType = (OperationType) hibernateHelper.retreiveData(OperationType.class, Long.valueOf(getOperationType(operation.getFirstWeight(), operation.getSecondWeight())));
                  operation.setOperationType(operationType);
                  if (operation.getOperationType().getId() == 1) {
                      operation.setNetWeight(operation.getFirstWeight() - Integer.valueOf(request.getParameter("second_weight")));
                      clientGoods.setInBalance(clientGoods.getInBalance() + operation.getNetWeight());
                  } else if (operation.getOperationType().getId() == 2) {
                      operation.setNetWeight(Integer.valueOf(request.getParameter("second_weight")) - operation.getFirstWeight());
                      clientGoods.setOutBalance(clientGoods.getOutBalance() + operation.getNetWeight());
                  }

                  operation.setEndDate(new Date());
                  operation.setEndTime(new Date());
                  operation.setDone(true);
                  hibernateHelper.updateData(operation);
                  hibernateHelper.updateData(clientGoods);
                  response.getWriter().println(operation.getId());
                  return operation.getId();

              }

              private int getOperationType(int firstWeight, int secondWeight) {
                  if (firstWeight > secondWeight) {
                      return 1;
                  } else if (firstWeight < secondWeight) {
                      return 2;
                  } else {
                      return 0;
                  }
              }

              public void goTo(String page) throws ServletException, IOException {
                  request.getRequestDispatcher(page).forward(request, response);
              }


              public void saveUser() throws IOException, ServletException {
                  User user = null;
                  String name = request.getParameter("name");
                  String username = request.getParameter("username");
                  String password = request.getParameter("password");
                  Role role = (Role) hibernateHelper.retreiveData(Role.class, Long.valueOf(request.getParameter("role")));
                  List<User> users = hibernateHelper.retreiveData("from User where userName = '" + username + "'");
                  if (users.size() == 0) {
                      user = new User(username, name, password, role);
                      hibernateHelper.saveData(user);
                  }

              }

              public void saveClient() throws IOException {
                  Client client = new Client(request.getParameter("client"));
                  hibernateHelper.saveData(client);
              }

              public void saveShip() throws IOException {
                  Ship ship = new Ship(request.getParameter("ship"));
                  hibernateHelper.saveData(ship);
              }

              public void saveGoods() throws IOException {
                  Goods goods = new Goods(request.getParameter("goods"));
                  hibernateHelper.saveData(goods);
              }
              private ClientGoods getClientGoods(Client client, Goods goods) throws IOException {
                  ClientGoods clientGoods;
                  List<ClientGoods> clientGoodsList = hibernateHelper.retreiveData("from ClientGoods where client = " + client.getId() + " and goods = " + goods.getId());
                  if (clientGoodsList.size() == 0) {
                      clientGoods = new ClientGoods(client, goods);
                      hibernateHelper.saveData(clientGoods);
                  } else {
                      clientGoods = clientGoodsList.get(0);
                  }
                  return clientGoods;
              }

              public void openClientGoodsBalance() throws IOException {
                  Client client = (Client) hibernateHelper.retreiveData(Client.class, Long.valueOf(request.getParameter("client")));
                  Goods goods = (Goods) hibernateHelper.retreiveData(Goods.class, Long.valueOf(request.getParameter("goods")));

                  ClientGoods clientGoods = getClientGoods(client, goods);
                  int opening_balance = Integer.parseInt(request.getParameter("opening_balance"));
                  clientGoods.setOpeningBalance(opening_balance);
                  hibernateHelper.updateData(clientGoods);
              }

           */
    public int changePassword() throws IOException {
        //User user = (User) this.hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user_id")));
        User user = (User) request.getSession().getAttribute("user");
        String currentPassword = request.getParameter("current_password");
        String newPassword = request.getParameter("new_password");
        String reNewPassword = request.getParameter("re_new_password");
        if (user.getPassword().equals(currentPassword) && newPassword.equals(reNewPassword)) {
            user.setPassword(newPassword);
            hibernateHelper.updateData(user);
            return (1);
        } else {
            return (0);
        }

    }

    public void createPassword() throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        String password = request.getParameter("password");
        String conPassword = request.getParameter("con_password");
        if (password.equals(conPassword)) {
            user.setPassword(password);
            user.setActivated(true);
            hibernateHelper.updateData(user);
            DirectiveHelper directiveHelper = new DirectiveHelper(request, response);
            directiveHelper.goToDashboard();
        }

    }

    public int addLocation() throws IOException {
        /*User user = (User) request.getSession().getAttribute("user");
        List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where TSUser = " + user.getId());
        if (tsUserRegionList.size() == 1) {

            return (1);
        } else {
            return (0);
        }*/
        String added_location = request.getParameter("added_location");
        String abb = request.getParameter("location_abb");
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        Location location = new Location(added_location, abb, region);
        hibernateHelper.saveData(location);
        return (1);

    }

    public int addRegion() throws IOException {

        String added_region = request.getParameter("added_region");
        String abb = request.getParameter("region_abb");
        Region region = new Region(added_region, abb);
        hibernateHelper.saveData(region);
        return (1);

    }

    public int addEmployee() throws IOException {
        String name = request.getParameter("name");
        String position = request.getParameter("position");
        String staffID = request.getParameter("staff_id");
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        LocationDepartment locationDepartment = null;
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department =" + department.getId());
        if (locationDepartmentList.size() == 0) {
            locationDepartment = new LocationDepartment(location, department);
            hibernateHelper.saveData(locationDepartment);
        } else {
            locationDepartment = locationDepartmentList.get(0);
        }
        if (request.getParameter("employee") != null) {
            Employee employee = (Employee) hibernateHelper.retreiveData(Employee.class, Long.valueOf(request.getParameter("employee")));
            employee.setName(name);
            employee.setPosition(position);
            employee.setStaffID(staffID);
            employee.setLocationDepartment(locationDepartment);
            hibernateHelper.updateData(employee);
            return (0);
        } else {
            Employee employee = new Employee(name, position, staffID, locationDepartment);
            hibernateHelper.saveData(employee);
            return (1);
        }
    }


    public long addPrivilege() throws IOException {
        if (request.getParameter("privilege_id") != null) {
            Privilege privilege = (Privilege) hibernateHelper.retreiveData(Privilege.class, Long.valueOf(request.getParameter("privilege_id")));
            privilege.setPrivilege(request.getParameter("privilege"));
            hibernateHelper.updateData(privilege);
            return 0;
        } else {
            List<User> userList = hibernateHelper.retreiveData("from User");
            Privilege privilege = new Privilege(request.getParameter("privilege"));
            hibernateHelper.saveData(privilege);
            boolean valid = false;
            for (User user : userList) {
                UserPrivilege userPrivilege = new UserPrivilege(user, privilege);
                if (user.getRole().getId() == 1 || user.getRole().getId() == 6) {
                    userPrivilege.setValid(true);
                }
                hibernateHelper.saveData(userPrivilege);
            }
            return (privilege.getId());
        }
    }

    public int addDepartment() throws IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("select_location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("added_department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department =" + department.getId());
        if (locationDepartmentList.size() == 0) {
            LocationDepartment locationDepartment = new LocationDepartment(location, department);
            hibernateHelper.saveData(locationDepartment);
            return (1);
        } else {
            return (0);
        }

    }

    public int addDeviceType() throws IOException {
        String added_deviceType = request.getParameter("added_device_type");
        String abb = request.getParameter("device_type_abb");
        DeviceType deviceType = new DeviceType(added_deviceType, abb);
        hibernateHelper.saveData(deviceType);
        return (1);
    }

    public int addDevice() throws IOException {
        //Device(String device, String any_desk_id, String mac_address, String ip_address, Department department , DeviceType deviceType)
        String added_device = request.getParameter("added_device");
        String any_desk_id = request.getParameter("any_desk_id");
        String mac_address = request.getParameter("mac_address");
        String ip_address = request.getParameter("ip_address");
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        //List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = "+lo)
        //Device device = new Device(added_device, mac_address, ip_address, department, deviceType);
        //hibernateHelper.saveData(device);
        return (1);
    }

    public int addCategory() throws IOException {
        Category category = new Category(request.getParameter("added_category"));
        hibernateHelper.saveData(category);
        return (1);
    }

    public int addSubCategory() throws IOException {
        String subCategroy = request.getParameter("added_sub_category");
        Category category = (Category) hibernateHelper.retreiveData(Category.class, Long.valueOf(request.getParameter("category")));
        SubCategory subCategory = new SubCategory(subCategroy, category);
        hibernateHelper.saveData(subCategory);
        return (1);
    }

    private Ticket saveTicket() throws IOException, ParseException {
        String problem = request.getParameter("problem");
        String comment = request.getParameter("comment");
        String reporterName = request.getParameter("caller_name");
        String reporterNum = request.getParameter("caller_num");
        Date actual_date = null;
        if (!request.getParameter("actual_date").equals("")) {
            actual_date = convert12TO24(request.getParameter("actual_date"));
        }
        System.out.println("Date : " + actual_date);
        Device device = (Device) hibernateHelper.retreiveData(Device.class, Long.valueOf(request.getParameter("device_")));
        User l1_user = (User) request.getSession().getAttribute("user");
        SubCategory subCategory = (SubCategory) hibernateHelper.retreiveData(SubCategory.class, Long.valueOf(request.getParameter("sub_category_")));
        Status status = (Status) hibernateHelper.retreiveData(Status.class, Long.valueOf(request.getParameter("status")));
        //Ticket(String problem, String comment, String reporterName,String reporterNum, Device device, User l1_user, SubCategory subCategory, Status currentStatus)
        Ticket ticket = new Ticket(problem, comment, reporterName, reporterNum, device, l1_user, subCategory, status, actual_date, actual_date);
        hibernateHelper.saveData(ticket);
        return ticket;
    }

    private Date convert12TO24(String date12) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd hh:mm aa").parse(date12)));
    }

    private long assignTo(Ticket ticket) throws IOException {
        User assignedBy = (User) request.getSession().getAttribute("user");
        User assignedTo = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("action")));
        List<TicketAssignedTo> ticketAssignedToList = hibernateHelper.retreiveData("from TicketAssignedTo where ticket = " + ticket.getId());
        for (TicketAssignedTo ticketAssignedTo : ticketAssignedToList) {
            ticketAssignedTo.setDone(true);
            hibernateHelper.updateData(ticketAssignedTo);
        }
        TicketAssignedTo ticketAssignedTo = new TicketAssignedTo(ticket, assignedTo, assignedBy);
        hibernateHelper.saveData(ticketAssignedTo);

        Status assignTo_status = (Status) hibernateHelper.retreiveData(Status.class, (long) 1);
        List<TicketStatus> ticketStatusList = hibernateHelper.retreiveData("from TicketStatus where ticket = " + ticket.getId());
        for (TicketStatus ticketStatus : ticketStatusList) {
            if (!ticketStatus.isDone()) {
                ticketStatus.setDone(true);
                ticketStatus.setDoneDate(new Date());
                ticketStatus.setDoneTime(new Date());
                hibernateHelper.updateData(ticketStatus);
            }
        }
        ticket.setCurrentStatus(assignTo_status);
        hibernateHelper.updateData(ticket);
        //TicketStatus(String reason, Ticket ticket, Status status, User TSUser)
        TicketStatus ticketStatus = new TicketStatus(null, ticket, assignTo_status, assignedBy);
        hibernateHelper.saveData(ticketStatus);
        return ticket.getId();
    }

    private long inProgress(Ticket ticket) throws IOException {
        Status inProgress_status = (Status) hibernateHelper.retreiveData(Status.class, (long) 2);
        ticket.setCurrentStatus(inProgress_status);
        hibernateHelper.updateData(ticket);
        List<TicketAssignedTo> ticketAssignedToList = hibernateHelper.retreiveData("from TicketAssignedTo where ticket = " + ticket.getId());
        for (TicketAssignedTo ticketAssignedTo : ticketAssignedToList) {
            ticketAssignedTo.setDone(true);
            hibernateHelper.updateData(ticketAssignedTo);
        }
        User user = (User) request.getSession().getAttribute("user");
        String notes = request.getParameter("action");
        List<TicketStatus> ticketStatusList = hibernateHelper.retreiveData("from TicketStatus where ticket = " + ticket.getId());
        System.out.println("size:" + ticketStatusList.size());

        for (TicketStatus ticketStatus : ticketStatusList) {
            if (!ticketStatus.isDone()) {
                ticketStatus.setDone(true);
                ticketStatus.setDoneDate(new Date());
                ticketStatus.setDoneTime(new Date());
                hibernateHelper.updateData(ticketStatus);
            }
        }
        TicketStatus ticketStatus = new TicketStatus(notes, ticket, inProgress_status, user);
        hibernateHelper.saveData(ticketStatus);
        return ticket.getId();
    }

    private long pending(Ticket ticket) throws IOException {
        Status pending_status = (Status) hibernateHelper.retreiveData(Status.class, (long) 3);
        ticket.setCurrentStatus(pending_status);
        hibernateHelper.updateData(ticket);
        List<TicketAssignedTo> ticketAssignedToList = hibernateHelper.retreiveData("from TicketAssignedTo where ticket = " + ticket.getId());
        for (TicketAssignedTo ticketAssignedTo : ticketAssignedToList) {
            ticketAssignedTo.setDone(true);
            hibernateHelper.updateData(ticketAssignedTo);
        }
        User user = (User) request.getSession().getAttribute("user");
        String reason = request.getParameter("action");
        List<TicketStatus> ticketStatusList = hibernateHelper.retreiveData("from TicketStatus where ticket = " + ticket.getId());
        for (TicketStatus ticketStatus : ticketStatusList) {
            if (!ticketStatus.isDone()) {
                ticketStatus.setDone(true);
                ticketStatus.setDoneDate(new Date());
                ticketStatus.setDoneTime(new Date());
                hibernateHelper.updateData(ticketStatus);
            }
        }
        TicketStatus ticketStatus = new TicketStatus(reason, ticket, pending_status, user);
        hibernateHelper.saveData(ticketStatus);
        return ticket.getId();
    }

    private long solved(Ticket ticket) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        Status solved_status = (Status) hibernateHelper.retreiveData(Status.class, (long) 4);
        ticket.setCurrentStatus(solved_status);

        ticket.setSolvedBy(user);
        hibernateHelper.updateData(ticket);
        List<TicketAssignedTo> ticketAssignedToList = hibernateHelper.retreiveData("from TicketAssignedTo where ticket = " + ticket.getId());
        for (TicketAssignedTo ticketAssignedTo : ticketAssignedToList) {
            ticketAssignedTo.setDone(true);
            hibernateHelper.updateData(ticketAssignedTo);
        }
        String steps = request.getParameter("action");
        List<TicketStatus> ticketStatusList = hibernateHelper.retreiveData("from TicketStatus where ticket = " + ticket.getId());
        for (TicketStatus ticketStatus : ticketStatusList) {
            if (!ticketStatus.isDone()) {
                ticketStatus.setDone(true);
                ticketStatus.setDoneDate(new Date());
                ticketStatus.setDoneTime(new Date());
                hibernateHelper.updateData(ticketStatus);
            }
        }
        TicketStatus ticketStatus = new TicketStatus(steps, ticket, solved_status, user);
        hibernateHelper.saveData(ticketStatus);
        return ticket.getId();
    }

    private long closed(Ticket ticket) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        Status closed_status = (Status) hibernateHelper.retreiveData(Status.class, (long) 5);
        ticket.setCurrentStatus(closed_status);
        ticket.setDone(true);
        ticket.setEndDate(new Date());
        ticket.setEndTime(new Date());
        ticket.setClosedBy(user);
        hibernateHelper.updateData(ticket);
        List<TicketAssignedTo> ticketAssignedToList = hibernateHelper.retreiveData("from TicketAssignedTo where ticket = " + ticket.getId());
        for (TicketAssignedTo ticketAssignedTo : ticketAssignedToList) {
            ticketAssignedTo.setDone(true);
            hibernateHelper.updateData(ticketAssignedTo);
        }
        String steps = request.getParameter("action");
        List<TicketStatus> ticketStatusList = hibernateHelper.retreiveData("from TicketStatus where ticket = " + ticket.getId());
        for (TicketStatus ticketStatus : ticketStatusList) {
            if (!ticketStatus.isDone()) {
                ticketStatus.setDone(true);
                ticketStatus.setDoneDate(new Date());
                ticketStatus.setDoneTime(new Date());
                hibernateHelper.updateData(ticketStatus);
            }
        }
        TicketStatus ticketStatus = new TicketStatus(steps, ticket, closed_status, user);
        ticketStatus.setDone(true);
        ticketStatus.setDoneDate(new Date());
        ticketStatus.setDoneTime(new Date());
        hibernateHelper.saveData(ticketStatus);
        return ticket.getId();
    }

    public long addTicket() throws IOException, ParseException {
        Status status = (Status) hibernateHelper.retreiveData(Status.class, Long.valueOf(request.getParameter("status")));
        Ticket ticket = saveTicket();
        return checkTicketStatus(status, ticket);
    }

    public long editTicket() throws IOException {
        Ticket ticket = (Ticket) hibernateHelper.retreiveData(Ticket.class, Long.valueOf(request.getParameter("ticket")));
        Status status = (Status) hibernateHelper.retreiveData(Status.class, Long.valueOf(request.getParameter("status")));
        return checkTicketStatus(status, ticket);
    }

    private long checkTicketStatus(Status status, Ticket ticket) throws IOException {
        if (status.getId() == 1) {
            return assignTo(ticket);
        } else if (status.getId() == 2) {
            return inProgress(ticket);
        } else if (status.getId() == 3) {
            return pending(ticket);
        } else if (status.getId() == 4) {
            return solved(ticket);
        } else if (status.getId() == 5) {
            return closed(ticket);
        } else {
            return 0;
        }
    }


    public int getRegionPCCount(String regionID) {
        if (regionID.equals("ALL")) {
            List<PC> pcList = hibernateHelper.retreiveData("from PC");
            return pcList.size();
        } else {
            int count = 0;
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<PC> pcList = hibernateHelper.retreiveData("from PC");
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (PC pc : pcList) {
                    if (pc.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionPrinterCount(String regionID) {
        if (regionID.equals("ALL")) {
            List<Printer> printerList = hibernateHelper.retreiveData("from Printer");
            return printerList.size();
        } else {
            int count = 0;
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<Printer> printerList = hibernateHelper.retreiveData("from Printer");
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (Printer printer : printerList) {
                    if (printer.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionIPPhoneCount(String regionID) {
        if (regionID.equals("ALL")) {
            List<PBX> pbxList = hibernateHelper.retreiveData("from PBX");
            return pbxList.size();
        } else {
            int count = 0;
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<PBX> pbxList = hibernateHelper.retreiveData("from PBX");
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (PBX pbx : pbxList) {
                    if (pbx.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionFPCount(String regionID) {
        if (regionID.equals("ALL")) {
            List<Attendance> attendanceList = hibernateHelper.retreiveData("from Attendance");
            return attendanceList.size();
        } else {
            int count = 0;
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<Attendance> attendanceList = hibernateHelper.retreiveData("from Attendance");
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (Attendance attendance : attendanceList) {
                    if (attendance.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionSWCount(String regionID) {
        DeviceType switchType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 5);
        if (regionID.equals("ALL")) {
            List<Device> swList = hibernateHelper.retreiveData("from Device where deviceType =" + switchType.getId());
            return swList.size();
        } else {
            int count = 0;
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<Device> swList = hibernateHelper.retreiveData("from Device where deviceType =" + switchType.getId());
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (Device sw : swList) {
                    if (sw.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionUPSCount(String regionID) {
        DeviceType UPSType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 10);
        if (regionID.equals("ALL")) {
            List<Device> upsList = hibernateHelper.retreiveData("from Device where deviceType =" + UPSType.getId());
            return upsList.size();
        } else {
            int count = 0;
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<Device> upsList = hibernateHelper.retreiveData("from Device where deviceType =" + UPSType.getId());
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (Device ups : upsList) {
                    if (ups.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionROCount(String regionID) {
        DeviceType routerType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 6);
        if (regionID.equals("ALL")) {
            List<Device> roList = hibernateHelper.retreiveData("from Device where deviceType =" + routerType.getId());
            return roList.size();
        } else {
            int count = 0;

            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<Device> roList = hibernateHelper.retreiveData("from Device where deviceType =" + routerType.getId());
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (Device ro : roList) {
                    if (ro.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionFWCount(String regionID) {
        DeviceType firewallType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 11);
        if (regionID.equals("ALL")) {
            List<Device> fwList = hibernateHelper.retreiveData("from Device where deviceType =" + firewallType.getId());
            return fwList.size();
        } else {
            int count = 0;

            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<Device> fwList = hibernateHelper.retreiveData("from Device where deviceType =" + firewallType.getId());
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (Device fw : fwList) {
                    if (fw.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionDVRCount(String regionID) {
        DeviceType DVRType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 3);
        if (regionID.equals("ALL")) {
            List<VideoRecorder> DVRList = hibernateHelper.retreiveData("from VideoRecorder where deviceType =" + DVRType.getId());
            return DVRList.size();
        } else {
            int count = 0;

            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<VideoRecorder> DVRList = hibernateHelper.retreiveData("from VideoRecorder where deviceType =" + DVRType.getId());
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (VideoRecorder DVR : DVRList) {
                    if (DVR.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionCameraCount(String regionID) {
        DeviceType cameraType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 4);
        if (regionID.equals("ALL")) {
            List<Device> cameraList = hibernateHelper.retreiveData("from Device where deviceType =" + cameraType.getId());
            return cameraList.size();
        } else {
            int count = 0;

            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<Device> cameraList = hibernateHelper.retreiveData("from Device where deviceType =" + cameraType.getId());
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (Device camera : cameraList) {
                    if (camera.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getRegionNVRCount(String regionID) {
        DeviceType NVRType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 7);
        if (regionID.equals("ALL")) {
            List<VideoRecorder> NVRList = hibernateHelper.retreiveData("from VideoRecorder where deviceType =" + NVRType.getId());
            return NVRList.size();
        } else {
            int count = 0;
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regionID));
            List<VideoRecorder> NVRList = hibernateHelper.retreiveData("from VideoRecorder where deviceType =" + NVRType.getId());
            List<Location> locationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
            List<LocationDepartment> locationDepartmentList = new ArrayList<>();
            for (Location location : locationList) {
                locationDepartmentList.addAll(hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId()));
            }
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                for (VideoRecorder NVR : NVRList) {
                    if (NVR.getLocationDepartment().getId() == locationDepartment.getId()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int getTicketAssignToAllRegionsCount() {
        return hibernateHelper.retreiveData("from Ticket where currentStatus = 1").size();
    }

    public int getTicketAInProgressAllRegionsCount() {
        return hibernateHelper.retreiveData("from Ticket where currentStatus = 2").size();
    }

    public int getTicketPendingAllRegionsCount() {
        return hibernateHelper.retreiveData("from Ticket where currentStatus = 3").size();
    }

    public int getTicketSolvedAllRegionsCount() {
        return hibernateHelper.retreiveData("from Ticket where currentStatus = 4").size();
    }

    public int getTicketClosedAllRegionsCount() {
        return hibernateHelper.retreiveData("from Ticket where currentStatus = 5").size();
    }

    public List getDailyRegionTickets() {
        List<Ticket> ticketList = hibernateHelper.retreiveData("from Ticket where startDate = " + new Date());
        List<Ticket> tickets = new ArrayList<>();
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : ticketList) {
                        if (device.getId() == ticket.getDevice().getId()) {
                            tickets.add(ticket);
                        }
                    }
                }
            }
        }
        return tickets;
    }

    public int getPCTicketRegionCount(String time) {
        int count = 0;
        DeviceType PCdeviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 1); // 1-PC

        //List<Ticket> ticketList = hibernateHelper.retreiveData("from Ticket");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date= formatter.format(new Date());
        System.out.println("from Ticket where startDate = '" + date + "' and startTime <= '" + time + "'");
        List<Ticket> ticketList = hibernateHelper.retreiveData("from Ticket where startDate = '" + date + "' and startTime <= '" + time + "'");
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : ticketList) {
                        if (device.getId() == ticket.getDevice().getId() && device.getDeviceType().getId() == PCdeviceType.getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    public int getPrinterTicketRegionCount(String time) {
        int count = 0;
        DeviceType printerDeviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 2); // 2-Printer

        //List<Ticket> ticketList = hibernateHelper.retreiveData("from Ticket");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date= formatter.format(new Date());
        System.out.println("from Ticket where startDate = '" + date + "' and startTime <= '" + time + "'");
        List<Ticket> ticketList = hibernateHelper.retreiveData("from Ticket where startDate = '" + date + "' and startTime <= '" + time + "'");
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : ticketList) {
                        if (device.getId() == ticket.getDevice().getId() && device.getDeviceType().getId() == printerDeviceType.getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    public int getCameraTicketRegionCount(String time) {
        int count = 0;
        DeviceType cameraDeviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, (long) 4); // 4-camera

        //List<Ticket> ticketList = hibernateHelper.retreiveData("from Ticket");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date= formatter.format(new Date());
        System.out.println("from Ticket where startDate = '" + date + "' and startTime <= '" + time + "'");
        List<Ticket> ticketList = hibernateHelper.retreiveData("from Ticket where startDate = '" + date + "' and startTime <= '" + time + "'");
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : ticketList) {
                        if (device.getId() == ticket.getDevice().getId() && device.getDeviceType().getId() == cameraDeviceType.getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public JsonObject getDailyTicketPerTimeData() {
        JsonObject data = new JsonObject();

        data.addProperty("PC_8", getPCTicketRegionCount("8:30"));
        data.addProperty("PC_9", getPCTicketRegionCount("9:30"));
        data.addProperty("PC_10", getPCTicketRegionCount("10:30"));
        data.addProperty("PC_11", getPCTicketRegionCount("11:30"));
        data.addProperty("PC_12", getPCTicketRegionCount("12:30"));
        data.addProperty("PC_13", getPCTicketRegionCount("13:30"));
        data.addProperty("PC_14", getPCTicketRegionCount("14:30"));
        data.addProperty("PC_15", getPCTicketRegionCount("15:30"));
        data.addProperty("PC_16", getPCTicketRegionCount("16:30"));
        data.addProperty("PC_17", getPCTicketRegionCount("17:30"));
        data.addProperty("PR_8", getPrinterTicketRegionCount("8:30"));
        data.addProperty("PR_9", getPrinterTicketRegionCount("9:30"));
        data.addProperty("PR_10", getPrinterTicketRegionCount("10:30"));
        data.addProperty("PR_11", getPrinterTicketRegionCount("11:30"));
        data.addProperty("PR_12", getPrinterTicketRegionCount("12:30"));
        data.addProperty("PR_13", getPrinterTicketRegionCount("13:30"));
        data.addProperty("PR_14", getPrinterTicketRegionCount("14:30"));
        data.addProperty("PR_15", getPrinterTicketRegionCount("15:30"));
        data.addProperty("PR_16", getPrinterTicketRegionCount("16:30"));
        data.addProperty("PR_17", getPrinterTicketRegionCount("17:30"));
        data.addProperty("CAM_8", getCameraTicketRegionCount("8:30"));
        data.addProperty("CAM_9", getCameraTicketRegionCount("9:30"));
        data.addProperty("CAM_10", getCameraTicketRegionCount("10:30"));
        data.addProperty("CAM_11", getCameraTicketRegionCount("11:30"));
        data.addProperty("CAM_12", getCameraTicketRegionCount("12:30"));
        data.addProperty("CAM_13", getCameraTicketRegionCount("13:30"));
        data.addProperty("CAM_14", getCameraTicketRegionCount("14:30"));
        data.addProperty("CAM_15", getCameraTicketRegionCount("15:30"));
        data.addProperty("CAM_16", getCameraTicketRegionCount("16:30"));
        data.addProperty("CAM_17", getCameraTicketRegionCount("17:30"));

        return data;
    }

    public int getTicketAssignToRegionCount() {
        int count = 0;
        List<Ticket> inProgressTicketList = hibernateHelper.retreiveData("from Ticket where currentStatus = 1"); // 1 Assign-To
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : inProgressTicketList) {
                        if (device.getId() == ticket.getDevice().getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int getTicketInProgressRegionCount() {
        int count = 0;
        List<Ticket> inProgressTicketList = hibernateHelper.retreiveData("from Ticket where currentStatus = 2"); // 2 In-Progress
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : inProgressTicketList) {
                        if (device.getId() == ticket.getDevice().getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int getTicketPendingRegionCount() {
        int count = 0;
        List<Ticket> pendingTicketList = hibernateHelper.retreiveData("from Ticket where currentStatus = 3"); // 3 Pending
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : pendingTicketList) {
                        if (device.getId() == ticket.getDevice().getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int getTicketSolvedRegionCount() {
        int count = 0;
        List<Ticket> solvedTicketList = hibernateHelper.retreiveData("from Ticket where currentStatus = 4"); // 4 solved
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : solvedTicketList) {
                        if (device.getId() == ticket.getDevice().getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int getTicketClosedRegionCount() {
        int count = 0;
        List<Ticket> solvedTicketList = hibernateHelper.retreiveData("from Ticket where currentStatus = 5"); // 5 closed
        Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
        List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + region.getId());
        for (Location location : regionLocationList) {
            List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
            for (LocationDepartment locationDepartment : locationDepartmentList) {
                List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                for (Device device : regionDeviceList) {
                    for (Ticket ticket : solvedTicketList) {
                        if (device.getId() == ticket.getDevice().getId()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public Object getTicketAssignToCount(User user) {
        //User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        return hibernateHelper.retreiveData("select count(assignedBy) from TicketAssignedTo where assignedBy = " + user.getId()).get(0);
    }

    public Object getTicketAssignedToUserCount(User user) {
        //User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        return hibernateHelper.retreiveData("select count(assignedTo) from TicketAssignedTo where done = false and assignedTo = " + user.getId()).get(0);
    }

    public Object getTicketSolvedByUserCount(User user) {
        //User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        return hibernateHelper.retreiveData("select count(solvedBy) from Ticket where done = false and solvedBy = " + user.getId()).get(0);
    }

    public Object getTicketClosedByUserCount(User user) {
        //User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        return hibernateHelper.retreiveData("select count(closedBy) from Ticket where done = true and (solvedBy = " + user.getId() + " or closedBy = " + user.getId() + ")").get(0);
    }

    public JsonObject getRegionChartData() {

        JsonObject data = new JsonObject();
        if (request.getParameter("region").equals("ALL")) {
            data.addProperty("region", "ALL");
            data.addProperty("regionAbb", "ALL");
            data.addProperty("regionT", "All Regions");
            data.addProperty("assignToRegionCount", getTicketAssignToAllRegionsCount());
            data.addProperty("inProgressRegionCount", getTicketAInProgressAllRegionsCount());
            data.addProperty("solvedRegionCount", getTicketSolvedAllRegionsCount());
            data.addProperty("pendingRegionCount", getTicketPendingAllRegionsCount());
            data.addProperty("closedRegionCount", getTicketClosedAllRegionsCount());
        } else {
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
            data.addProperty("region", region.getRegion());
            data.addProperty("regionAbb", region.getAbbreviation());
            data.addProperty("regionT", region.getRegion());
            data.addProperty("assignToRegionCount", getTicketAssignToRegionCount());
            data.addProperty("inProgressRegionCount", getTicketInProgressRegionCount());
            data.addProperty("closedRegionCount", getTicketClosedRegionCount());
            data.addProperty("pendingRegionCount", getTicketPendingRegionCount());
            data.addProperty("solvedRegionCount", getTicketSolvedRegionCount());
        }
        return data;
    }

    public JsonObject getTicketChartData() {
        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        JsonObject data = new JsonObject();

        data.addProperty("user_name", user.getName());
        data.addProperty("user_id", user.getId());
        data.addProperty("assignToUserCount", (long) getTicketAssignedToUserCount(user));
        data.addProperty("assignToCount", (long) getTicketAssignToCount(user));
        data.addProperty("inProgressCount", (long) getTicketInProgressByUserCount(user));
        data.addProperty("pendingCount", (long) getTicketPendingByUserCount(user));
        data.addProperty("solvedCount", (long) getTicketSolvedByUserCount(user));
        data.addProperty("closedCount", (long) getTicketClosedByUserCount(user));
        data.addProperty("needToCloseCount", (int) getTicketNeedToCloseCount(user));
        return data;
    }

    public JsonObject getDeviceChartData() {
        System.out.println("region Para : " + request.getParameter("region"));
        JsonObject data = new JsonObject();
        if (request.getParameter("region").equals("ALL")) {
            data.addProperty("region", "ALL");
            data.addProperty("regionAbb", "ALL");
            data.addProperty("regionT", "All Regions");
        } else {
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
            data.addProperty("region", region.getRegion());
            data.addProperty("regionAbb", region.getAbbreviation());
            data.addProperty("regionT", region.getRegion());
        }
        data.addProperty("PC_count", getRegionPCCount(request.getParameter("region")));
        data.addProperty("Printer_count", getRegionPrinterCount(request.getParameter("region")));
        data.addProperty("PBX_count", getRegionIPPhoneCount(request.getParameter("region")));
        data.addProperty("FP_count", getRegionFPCount(request.getParameter("region")));
        data.addProperty("SW_count", getRegionSWCount(request.getParameter("region")));
        data.addProperty("RO_count", getRegionROCount(request.getParameter("region")));
        data.addProperty("CAM_count", getRegionCameraCount(request.getParameter("region")));
        data.addProperty("DVR_count", getRegionDVRCount(request.getParameter("region")));
        data.addProperty("NVR_count", getRegionNVRCount(request.getParameter("region")));
        data.addProperty("UPS_count", getRegionUPSCount(request.getParameter("region")));
        data.addProperty("FW_count", getRegionFWCount(request.getParameter("region")));
        return data;
    }

    public Object getTicketNeedToCloseCount(User user) {
        int count = 0;
        List<Ticket> needToCloseTicketList = new ArrayList<>();
        //User user  = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));

        //User user = (User) request.getSession().getAttribute("user");
        if (user.getRole().getId() == 2) {
            List<TSUserRegion> tsUserRegionList = hibernateHelper.retreiveData("from TSUserRegion where TSUser = " + user.getId());
            List<Ticket> solvedTicketList = hibernateHelper.retreiveData("from Ticket where currentStatus = 4"); // 4 solved
            //Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(request.getParameter("region")));
            List<Location> regionLocationList = hibernateHelper.retreiveData("from Location where region = " + tsUserRegionList.get(0).getRegion().getId());
            for (Location location : regionLocationList) {
                List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId());
                for (LocationDepartment locationDepartment : locationDepartmentList) {
                    List<Device> regionDeviceList = hibernateHelper.retreiveData("from Device where locationDepartment = " + locationDepartment.getId());
                    for (Device device : regionDeviceList) {
                        for (Ticket ticket : solvedTicketList) {
                            if (device.getId() == ticket.getDevice().getId()) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public Object getTicketInProgressByUserCount(User user) {
        //User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        Status inProgressStatus = (Status) hibernateHelper.retreiveData(Status.class, (long) 2);
        return hibernateHelper.retreiveData("select count(TSUser) from TicketStatus where done = false and status = " + inProgressStatus.getId() + " and TSUser = " + user.getId()).get(0);
    }

    public Object getTicketPendingByUserCount(User user) {
        //User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        Status pendingStatus = (Status) hibernateHelper.retreiveData(Status.class, (long) 3);
        return hibernateHelper.retreiveData("select count(TSUser) from TicketStatus where done = false and status = " + pendingStatus.getId() + " and TSUser = " + user.getId()).get(0);
    }

    public long savePC() throws ParseException, IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        PCType pcType = (PCType) hibernateHelper.retreiveData(PCType.class, Long.valueOf(request.getParameter("pc_type")));
        Employee employee = (Employee) hibernateHelper.retreiveData(Employee.class, Long.valueOf(request.getParameter("employee")));
        OS os = (OS) hibernateHelper.retreiveData(OS.class, Long.valueOf(request.getParameter("os")));
        String device = request.getParameter("device");
        String vendor = request.getParameter("vendor");
        String model = request.getParameter("model");
        String mac_address = request.getParameter("mac_address");
        String serial_num = request.getParameter("serial_num");
        String ip_address = request.getParameter("ip_address");
        String office = request.getParameter("office");
        String login_name = request.getParameter("login_name");
        String computer_name = request.getParameter("computer_name");
        String hd = request.getParameter("HD");
        String ram = request.getParameter("ram");
        String cpu = request.getParameter("cpu");
        String monitor = request.getParameter("monitor");
        String monitor_serial = request.getParameter("monitor_serial");
        String purchase_date_string = request.getParameter("purchase_date");
        Date purchase_date = null;
        if (!purchase_date_string.equals("")) {
            purchase_date = new SimpleDateFormat("yyyy-MM-dd").parse(purchase_date_string);
        }
        boolean need_to_upgrade = Boolean.valueOf(request.getParameter("need_to_upgrade"));
        boolean internet = Boolean.valueOf(request.getParameter("internet"));
        System.out.println("device_id : " + request.getParameter("device_id"));
        PC pc = null;
        if (request.getParameter("device_id") == null) {
            pc = new PC(device, mac_address, ip_address, locationDepartmentList.get(0), deviceType, login_name, computer_name, hd, ram, cpu, monitor, monitor_serial, internet, employee, os, pcType);
        } else {
            pc = (PC) hibernateHelper.retreiveData(PC.class, Long.valueOf(request.getParameter("device_id")));
        }
        pc.setVendor(vendor);
        pc.setModel(model);
        pc.setSerialNum(serial_num);
        pc.setOffice(office);
        pc.setPurchaseDate(purchase_date);
        pc.setNeedToUpgrade(need_to_upgrade);

        if (request.getParameter("device_id") == null) {
            hibernateHelper.saveData(pc);
            return pc.getId();
        } else {
            pc.setLocationDepartment(locationDepartmentList.get(0));
            pc.setDevice(device);
            pc.setMac_address(mac_address);
            pc.setIp_address(ip_address);
            pc.setDeviceType(deviceType);
            pc.setLoginName(login_name);
            pc.setComputerName(computer_name);
            pc.setHD(hd);
            pc.setRAM(ram);
            pc.setCPU(cpu);
            pc.setMonitor(monitor);
            pc.setMonitorSerialNum(monitor_serial);
            pc.setInternet(internet);
            pc.setEmployee(employee);
            pc.setOs(os);
            pc.setPcType(pcType);
            hibernateHelper.updateData(pc);
            return 0;
        }


    }

    public long savePrinter() throws ParseException, IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        Employee employee = null;
        if (!request.getParameter("employee").equals("")) {
            employee = (Employee) hibernateHelper.retreiveData(Employee.class, Long.valueOf(request.getParameter("employee")));
        }

        PrinterConnection connection = (PrinterConnection) hibernateHelper.retreiveData(PrinterConnection.class, Long.valueOf(request.getParameter("printer_connection")));
        String device = request.getParameter("device");
        String vendor = request.getParameter("vendor");
        String model = request.getParameter("model");
        String mac_address = request.getParameter("mac_address");
        String serial_num = request.getParameter("serial_num");
        String ip_address = request.getParameter("ip_address");
        String office = request.getParameter("office");
        String toner_num = request.getParameter("toner_num");
        String purchase_date_string = request.getParameter("purchase_date");
        Date purchase_date = null;
        if (!purchase_date_string.equals("")) {
            purchase_date = new SimpleDateFormat("yyyy-MM-dd").parse(purchase_date_string);
        }
        boolean need_to_upgrade = Boolean.valueOf(request.getParameter("need_to_upgrade"));
        Printer printer = null;
        if (request.getParameter("device_id") == null) {
            printer = new Printer(device, mac_address, ip_address, locationDepartmentList.get(0), deviceType, toner_num, connection, employee);
        } else {
            printer = (Printer) hibernateHelper.retreiveData(Printer.class, Long.valueOf(request.getParameter("device_id")));
        }
        printer.setVendor(vendor);
        printer.setModel(model);
        printer.setSerialNum(serial_num);
        printer.setOffice(office);
        printer.setPurchaseDate(purchase_date);
        printer.setNeedToUpgrade(need_to_upgrade);
        if (request.getParameter("device_id") == null) {
            hibernateHelper.saveData(printer);
            return printer.getId();
        } else {

            printer.setDevice(device);
            printer.setMac_address(mac_address);
            printer.setIp_address(ip_address);
            printer.setLocationDepartment(locationDepartmentList.get(0));
            printer.setDeviceType(deviceType);
            printer.setTonerNumber(toner_num);
            printer.setPrinterConnection(connection);
            printer.setEmployee(employee);
            hibernateHelper.updateData(printer);
            return 0;
        }

    }

    public long saveAttendance() throws ParseException, IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        String device = request.getParameter("device");
        String vendor = request.getParameter("vendor");
        String model = request.getParameter("model");
        String mac_address = request.getParameter("mac_address");
        String serial_num = request.getParameter("serial_num");
        String ip_address = request.getParameter("ip_address");
        String office = request.getParameter("office");
        String purchase_date_string = request.getParameter("purchase_date");
        Date purchase_date = null;
        if (!purchase_date_string.equals("")) {
            purchase_date = new SimpleDateFormat("yyyy-MM-dd").parse(purchase_date_string);
        }
        boolean need_to_upgrade = Boolean.valueOf(request.getParameter("need_to_upgrade"));
        String subnet = request.getParameter("subnet");
        String gateway = request.getParameter("gateway");
        Attendance attendance = null;
        if (request.getParameter("device_id") == null) {
            attendance = new Attendance(device, mac_address, ip_address, locationDepartmentList.get(0), deviceType, subnet, gateway);
        } else {
            attendance = (Attendance) hibernateHelper.retreiveData(Attendance.class, Long.valueOf(request.getParameter("device_id")));
        }
        attendance.setVendor(vendor);
        attendance.setModel(model);
        attendance.setSerialNum(serial_num);
        attendance.setOffice(office);
        attendance.setPurchaseDate(purchase_date);
        attendance.setNeedToUpgrade(need_to_upgrade);
        if (request.getParameter("device_id") == null) {
            hibernateHelper.saveData(attendance);
            return attendance.getId();
        } else {
            attendance.setDevice(device);
            attendance.setMac_address(mac_address);
            attendance.setIp_address(ip_address);
            attendance.setLocationDepartment(locationDepartmentList.get(0));
            attendance.setDeviceType(deviceType);
            attendance.setSubnet(subnet);
            attendance.setGateway(gateway);
            hibernateHelper.updateData(attendance);
            return 0;
        }

    }

    public long savePBX() throws ParseException, IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        Employee employee = null;
        if (!request.getParameter("employee").equals("")) {
            employee = (Employee) hibernateHelper.retreiveData(Employee.class, Long.valueOf(request.getParameter("employee")));
        }
        String device = request.getParameter("device");
        String vendor = request.getParameter("vendor");
        String model = request.getParameter("model");
        String mac_address = request.getParameter("mac_address");
        String serial_num = request.getParameter("serial_num");
        String ip_address = request.getParameter("ip_address");
        String office = request.getParameter("office");
        String device_num = request.getParameter("device_num");
        String purchase_date_string = request.getParameter("purchase_date");
        Date purchase_date = null;
        if (!purchase_date_string.equals("")) {
            purchase_date = new SimpleDateFormat("yyyy-MM-dd").parse(purchase_date_string);
        }
        boolean need_to_upgrade = Boolean.valueOf(request.getParameter("need_to_upgrade"));
        PBX pbx = null;
        if (request.getParameter("device_id") == null) {
            pbx = new PBX(device, mac_address, ip_address, locationDepartmentList.get(0), deviceType, device_num, employee);
        } else {
            pbx = (PBX) hibernateHelper.retreiveData(PBX.class, Long.valueOf(request.getParameter("device_id")));
        }
        pbx.setVendor(vendor);

        pbx.setModel(model);
        pbx.setSerialNum(serial_num);
        pbx.setOffice(office);
        pbx.setPurchaseDate(purchase_date);
        pbx.setNeedToUpgrade(need_to_upgrade);
        if (request.getParameter("device_id") == null) {
            hibernateHelper.saveData(pbx);
            return pbx.getId();
        } else {
            pbx.setDevice(device);
            pbx.setMac_address(mac_address);
            pbx.setIp_address(ip_address);
            pbx.setLocationDepartment(locationDepartmentList.get(0));

            pbx.setDeviceType(deviceType);
            pbx.setDeviceNum(device_num);
            pbx.setEmployee(employee);
            hibernateHelper.updateData(pbx);
            return 0;
        }
    }

    public long saveDevice() throws ParseException, IOException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());

        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        String device = request.getParameter("device");
        String vendor = request.getParameter("vendor");
        String model = request.getParameter("model");
        String mac_address = request.getParameter("mac_address");
        String serial_num = request.getParameter("serial_num");
        String ip_address = request.getParameter("ip_address");
        String office = request.getParameter("office");
        String purchase_date_string = request.getParameter("purchase_date");
        Date purchase_date = null;
        if (!purchase_date_string.equals("")) {
            purchase_date = new SimpleDateFormat("yyyy-MM-dd").parse(purchase_date_string);
        }
        boolean need_to_upgrade = Boolean.valueOf(request.getParameter("need_to_upgrade"));
        Device device1 = null;
        if (request.getParameter("device_id") == null) {
            device1 = new Device(device, mac_address, ip_address, locationDepartmentList.get(0), deviceType);
        } else {
            device1 = (Device) hibernateHelper.retreiveData(Device.class, Long.valueOf(request.getParameter("device_id")));
        }
        device1.setModel(model);
        device1.setSerialNum(serial_num);
        device1.setOffice(office);
        device1.setPurchaseDate(purchase_date);
        device1.setNeedToUpgrade(need_to_upgrade);
        device1.setVendor(vendor);
        if (request.getParameter("device_id") == null) {
            hibernateHelper.saveData(device1);
            return device1.getId();
        } else {
            device1.setDevice(device);
            device1.setMac_address(mac_address);
            device1.setIp_address(ip_address);
            device1.setLocationDepartment(locationDepartmentList.get(0));
            device1.setDeviceType(deviceType);
            hibernateHelper.updateData(device1);
            return 0;
        }

    }

    public long saveVideoRecorder() throws IOException, ParseException {
        Location location = (Location) hibernateHelper.retreiveData(Location.class, Long.valueOf(request.getParameter("location")));
        Department department = (Department) hibernateHelper.retreiveData(Department.class, Long.valueOf(request.getParameter("department")));
        List<LocationDepartment> locationDepartmentList = hibernateHelper.retreiveData("from LocationDepartment where location = " + location.getId() + " and department = " + department.getId());
        DeviceType deviceType = (DeviceType) hibernateHelper.retreiveData(DeviceType.class, Long.valueOf(request.getParameter("device_type")));
        String device = request.getParameter("device");
        String vendor = request.getParameter("vendor");
        String model = request.getParameter("model");
        String mac_address = request.getParameter("mac_address");
        String serial_num = request.getParameter("serial_num");
        String ip_address = request.getParameter("ip_address");
        String office = request.getParameter("office");
        int portNum = Integer.valueOf(request.getParameter("port_num"));
        String purchase_date_string = request.getParameter("purchase_date");
        Date purchase_date = null;
        if (!purchase_date_string.equals("")) {
            purchase_date = new SimpleDateFormat("yyyy-MM-dd").parse(purchase_date_string);
        }
        boolean need_to_upgrade = Boolean.valueOf(request.getParameter("need_to_upgrade"));
        VideoRecorder videoRecorder = null;
        if (request.getParameter("device_id") == null) {
            videoRecorder = new VideoRecorder(device, mac_address, ip_address, locationDepartmentList.get(0), deviceType, portNum);
        } else {
            videoRecorder = (VideoRecorder) hibernateHelper.retreiveData(VideoRecorder.class, Long.valueOf(request.getParameter("device_id")));
        }
        videoRecorder.setModel(model);
        videoRecorder.setVendor(vendor);
        videoRecorder.setSerialNum(serial_num);
        videoRecorder.setOffice(office);
        videoRecorder.setPurchaseDate(purchase_date);
        videoRecorder.setNeedToUpgrade(need_to_upgrade);
        if (request.getParameter("device_id") == null) {
            hibernateHelper.saveData(videoRecorder);
            return videoRecorder.getId();
        } else {
            videoRecorder.setDevice(device);
            videoRecorder.setMac_address(mac_address);
            videoRecorder.setIp_address(ip_address);
            videoRecorder.setLocationDepartment(locationDepartmentList.get(0));
            videoRecorder.setDeviceType(deviceType);
            videoRecorder.setPortNum(portNum);
            hibernateHelper.updateData(videoRecorder);
            return 0;
        }


    }

    public long addUser() throws IOException {
        List<Privilege> privilegeList = hibernateHelper.retreiveData("from Privilege");
        List<Region> regionList = hibernateHelper.retreiveData("from Region");
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String phoneNum = request.getParameter("phone_num");
        List<User> usernameList = hibernateHelper.retreiveData("from User where username = '" + username + "'");
        List<User> phoneNumList = hibernateHelper.retreiveData("from User where phoneNum = '" + phoneNum + "'");
        if (usernameList.size() == 0 && phoneNumList.size() == 0) {
            Role role = (Role) hibernateHelper.retreiveData(Role.class, Long.valueOf(request.getParameter("role")));
            User user = new User(username, name, phoneNum, role);
            hibernateHelper.saveData(user);
            String privileges = request.getParameter("privileges");
            System.out.println("privileges : " + privileges.length());
            String regions = request.getParameter("regions");
            for (Privilege privilege : privilegeList) {
                UserPrivilege userPrivilege = new UserPrivilege(user, privilege);
                if (privileges.length() > 0) {
                    for (int i = 0; i < privileges.split(",").length; i++) {
                        Privilege pri = (Privilege) hibernateHelper.retreiveData(Privilege.class, Long.valueOf(privileges.split(",")[i]));
                        if (pri.getId() == privilege.getId()) {
                            userPrivilege.setValid(true);
                            break;
                        }
                    }
                }
                hibernateHelper.saveData(userPrivilege);
            }

            for (Region region : regionList) {
                TSUserRegion tsUserRegion = new TSUserRegion(user, region);
                for (int i = 0; i < regions.split(",").length; i++) {
                    Region reg = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regions.split(",")[i]));
                    if (reg.getId() == region.getId()) {
                        tsUserRegion.setValid(true);
                        break;
                    }
                }
                hibernateHelper.saveData(tsUserRegion);
            }

        /*for (int i = 0; i < privileges.split(",").length; i++) {

            UserPrivilege userPrivilege = new UserPrivilege(user, privilege);
            hibernateHelper.saveData(userPrivilege);
        }
        for (int i = 0; i < regions.split(",").length; i++) {
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regions.split(",")[i]));
            TSUserRegion tsUserRegion = new TSUserRegion(user, region);
            hibernateHelper.saveData(tsUserRegion);
        }*/
            return user.getId();
        } else if (usernameList.size() > 0 && phoneNumList.size() > 0) {
            return -3;
        } else if (usernameList.size() > 0) {
            return -1;
        } else if (phoneNumList.size() > 0) {
            return -2;
        }
        return 0;
    }

    private void editUserDetails(User user) throws IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String phoneNum = request.getParameter("phone_num");
        Role role = (Role) hibernateHelper.retreiveData(Role.class, Long.valueOf(request.getParameter("role")));
        List<Privilege> privilegeList = hibernateHelper.retreiveData("from Privilege");
        List<Region> regionList = hibernateHelper.retreiveData("from Region");
        user.setName(name);
        user.setUserName(username);
        user.setPhoneNum(phoneNum);
        user.setRole(role);
        hibernateHelper.updateData(user);
        String privileges = request.getParameter("privileges");
        String regions = request.getParameter("regions");
        List<UserPrivilege> userPrivilegeList = hibernateHelper.retreiveData("from UserPrivilege where user = " + user.getId());
        List<TSUserRegion> userRegionList = hibernateHelper.retreiveData("from TSUserRegion where TSUser = " + user.getId());
        for (Privilege privilege : privilegeList) {
            for (UserPrivilege userPrivilege : userPrivilegeList) {
                if (userPrivilege.getPrivilege().getId() == privilege.getId()) {
                    for (int i = 0; i < privileges.split(",").length; i++) {
                        Privilege pri = (Privilege) hibernateHelper.retreiveData(Privilege.class, Long.valueOf(privileges.split(",")[i]));
                        if (pri.getId() == privilege.getId()) {
                            userPrivilege.setValid(true);
                            break;
                        } else if (pri.getId() != privilege.getId() && privileges.split(",")[privileges.split(",").length - 1].equals(privileges.split(",")[i])) {
                            userPrivilege.setValid(false);
                        }
                    }
                    hibernateHelper.updateData(userPrivilege);
                }
            }
        }

        for (Region region : regionList) {
            for (TSUserRegion userRegion : userRegionList) {
                if (userRegion.getRegion().getId() == region.getId()) {
                    for (int i = 0; i < regions.split(",").length; i++) {
                        Region reg = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regions.split(",")[i]));
                        if (reg.getId() == region.getId()) {
                            userRegion.setValid(true);
                            break;
                        } else if (reg.getId() != region.getId() && regions.split(",")[regions.split(",").length - 1].equals(regions.split(",")[i])) {
                            userRegion.setValid(false);
                        }
                    }
                    hibernateHelper.updateData(userRegion);
                }
            }

        }
    }

    public long editUser() throws IOException {


        User user = (User) hibernateHelper.retreiveData(User.class, Long.valueOf(request.getParameter("user")));
        String username = request.getParameter("username");
        String phoneNum = request.getParameter("phone_num");
        List<User> usernameList = hibernateHelper.retreiveData("from User where username = '" + username + "'");
        List<User> phoneNumList = hibernateHelper.retreiveData("from User where phoneNum = '" + phoneNum + "'");
        System.out.println(user.getUserName() + "  " + username);
        if (user.getUserName().equals(username) && user.getPhoneNum().equals(phoneNum)) {
            editUserDetails(user);
            return user.getId();
        } else if (user.getUserName().equals(username) && !user.getPhoneNum().equals(phoneNum)) {
            if (phoneNumList.size() > 0) {
                return -2;
            } else {
                editUserDetails(user);
                return user.getId();
            }
        } else if (!user.getUserName().equals(username) && user.getPhoneNum().equals(phoneNum)) {
            if (usernameList.size() > 0) {
                return -1;
            } else {
                editUserDetails(user);
                return user.getId();
            }
        } else if (!user.getUserName().equals(username) && !user.getPhoneNum().equals(phoneNum)) {
            if (usernameList.size() > 0 && phoneNumList.size() > 0) {
                return -3;
            } else if (usernameList.size() > 0) {
                return -1;
            } else if (phoneNumList.size() > 0) {
                return -2;
            } else {
                editUserDetails(user);
                return user.getId();
            }
        }

        /*else {
            if ((usernameList.size() == 0 && phoneNumList.size() == 0) || (usernameList.size() == 1 && phoneNumList.size() == 0) || (usernameList.size() == 0 && phoneNumList.size() == 1)) {
                editUserDetails(user);
                return user.getId();
            } else if (usernameList.size() > 0 && phoneNumList.size() > 0) {
                return -3;
            } else if (usernameList.size() > 0) {
                return -1;
            } else if (phoneNumList.size() > 0) {
                return -2;
            }
        }*/

        return 0;

/*
        if (userPrivilegeList.size() > 0) {
            for (UserPrivilege userPrivilege : userPrivilegeList) {
                userPrivilege.setValid(true);
                hibernateHelper.updateData(userPrivilege);
            }
        }
        for (int i = 0; i < privileges.split(",").length; i++) {
            Privilege privilege = (Privilege) hibernateHelper.retreiveData(Privilege.class, Long.valueOf(privileges.split(",")[i]));
            UserPrivilege userPrivilege = new UserPrivilege(user, privilege);
            hibernateHelper.saveData(userPrivilege);
        }
        List<TSUserRegion> userRegionList = hibernateHelper.retreiveData("from TSUserRegion where edited = false and TSUser = " + user.getId());
        if (userRegionList.size() > 0) {
            for (TSUserRegion userRegion : userRegionList) {
                userRegion.setValid(true);
                hibernateHelper.updateData(userRegion);
            }
        }
        for (int i = 0; i < regions.split(",").length; i++) {
            Region region = (Region) hibernateHelper.retreiveData(Region.class, Long.valueOf(regions.split(",")[i]));
            TSUserRegion tsUserRegion = new TSUserRegion(user, region);
            hibernateHelper.saveData(tsUserRegion);
        }

 */

    }

    public int addOS() throws IOException {
        String added_os = request.getParameter("added_os");
        OS os = new OS(added_os);
        hibernateHelper.saveData(os);
        return (1);
    }
}
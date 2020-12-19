package utilites;

import elements.Privilege;
import elements.Region;

import javax.mail.MessagingException;
import java.util.List;

public class Emails {
    static String ip = "http://10.0.170.50", port = ":9999";

    public static void addAccountEmail(String emailAddress, String name, String username, String role, List<Region> regionList, List<Privilege> privilegeList) {
        String subject = "User Login Details at ITS";
        String text = "<div dir=\"ltr\">" +
                "Dear Mr. " + name + "," +
                "<div>" +
                "<div>After Greetings.&nbsp;</div>" +
                "</div>" +
                "<div><br></div>" +
                "<div>This is the details of your user login at ITS&nbsp;&nbsp;<br></div>" +
                "<div>" +
                "<ul>" +
                "<li style=\"margin-left:15px\">&nbsp;<b>URL :</b>&nbsp;&nbsp;&nbsp;<a href=\"" + ip + port + "/ITS\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=" + ip + port + "/ITS&amp;source=gmail&amp;ust=1608036904886000&amp;usg=AFQjCNHA5nESt08lsnFGG_TRA8nJKM3_EA\">" + ip + port + "/<wbr>ITS</a></li>" +
                "<li style=\"margin-left:15px\">&nbsp;<b>UserName :&nbsp;</b>" + username + "<br></li>" +
                "<li style=\"margin-left:15px\"><b>&nbsp;Role</b>&nbsp;: " + role + "</li>" +
                "<li style=\"margin-left:15px\">&nbsp;<b>Default Password :</b>&nbsp;0000</li>" +
                "<li style=\"margin-left:15px\">&nbsp;<b>Regions :</b></li>" +
                "<ol>" + getRegions(regionList) + "</ol>" +
                "<li style=\"margin-left:15px\">&nbsp;<b>Privileges :&nbsp;</b></li>" +
                "<ol>" + getPrivileges(privilegeList) + "</ol>" +
                "</ul>" +
                "<div>After signing in for the first time with default password create your own password to activate your user .&nbsp;&nbsp;<br></div></div><div><br></div>" +
                "<div>Best Regards.&nbsp;</div><div><br></div>-- " +
                "</div>" +
                "</div>" +
                "</div>";

        try {
            MailUtil.sendMail(emailAddress, subject, text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void resetPasswordEmail(String emailAddress, String name) {
        String subject = "Reset Your Password";
        String text = "<div dir=\"ltr\">" +
                "Dear Mr. " + name + "," +
                "<div>" +
                "<div>After Greetings.&nbsp;</div>" +
                "</div>" +
                "<div><br></div>" +
                "<div>Your password has been reset successfully.&nbsp;&nbsp;<br></div>" +
                "<div>Please sign in with default password (<span style=\"color:red;font-weight: bold;\">0000</span>) and create your own new password.&nbsp;&nbsp;<br></div>" +
                "<div><br></div>" +
                "<div>Best Regards.&nbsp;</div><div><br></div>-- " +
                "<div>";
        try {
            MailUtil.sendMail(emailAddress, subject, text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public static void assignToEmail(String emailAddress, String name, String engineer, long ticket_no) {
        String subject = "Ticket No. " + ticket_no;
        String text = "<div dir=\"ltr\">" +
                "Dear Mr. " + name + "," +
                "<div>" +
                "<div>After Greetings.&nbsp;</div>" +
                "</div>" +
                "<div><br></div>" +
                "<div>Please be aware that eng. " + engineer + " assigned to you ticket no. " + ticket_no + ".&nbsp;&nbsp;<br></div>" +
                "<div>Please do your best to solve it.&nbsp;&nbsp;<br></div>" +
                "<div><br></div>" +
                "<div>Best Regards.&nbsp;</div><div><br></div>-- " +
                "<div>";
        try {
            MailUtil.sendMail(emailAddress, subject, text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void solvedEmail(String emailAddress, String name, String engineer, long ticket_no) {
        String subject = "Ticket No. " + ticket_no;
        String text = "<div dir=\"ltr\">" +
                "Dear Mr. " + name + "," +
                "<div>" +
                "<div>After Greetings.&nbsp;</div>" +
                "</div>" +
                "<div><br></div>" +
                "<div>We inform you that eng. " + engineer + " has solved ticket no. " + ticket_no + ".&nbsp;&nbsp;<br></div>" +
                "<div>Kindly take the necessary action accordingly.&nbsp;&nbsp;<br></div>" +
                "<div><br></div>" +
                "<div>Best Regards.&nbsp;</div><div><br></div>-- " +
                "<div>";
        try {
            MailUtil.sendMail(emailAddress, subject, text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void closedEmail(String emailAddress, String name, String engineer, long ticket_no) {
        String subject = "Ticket No. " + ticket_no;
        String text = "<div dir=\"ltr\">" +
                "Dear Mr. " + name + "," +
                "<div>" +
                "<div>After Greetings.&nbsp;</div>" +
                "</div>" +
                "<div><br></div>" +
                "<div>We inform you that eng. " + engineer + " has closed ticket no. " + ticket_no + ".&nbsp;&nbsp;<br></div>" +
                "<div>Thanks for your efforts.&nbsp;&nbsp;<br></div>" +
                "<div><br></div>" +
                "<div>Best Regards.&nbsp;</div><div><br></div>-- " +
                "<div>";
        try {
            MailUtil.sendMail(emailAddress, subject, text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static String getRegions(List<Region> regionList) {
        String regions = "";
        for (Region region : regionList) {
            regions += "<li style=\"margin-left:15px\">" + region.getRegion() + "</li>";
        }
        return regions;
    }

    private static String getPrivileges(List<Privilege> privilegeList) {
        String privileges = "";
        for (Privilege privilege : privilegeList) {
            privileges += "<li style=\"margin-left:15px\">" + privilege.getPrivilege() + "<br></li>";
        }
        return privileges;
    }
}

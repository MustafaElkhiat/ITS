package utilites;

import elements.Privilege;
import elements.Region;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Region> regionList = new ArrayList<>();
        regionList.add(new Region("Alex", null));
        regionList.add(new Region("Dom", null));
        regionList.add(new Region("Suez", null));
        List<Privilege> privilegeList = new ArrayList<>();
        privilegeList.add(new Privilege("privilege 1"));
        privilegeList.add(new Privilege("privilege 2"));
        privilegeList.add(new Privilege("privilege 3"));
        privilegeList.add(new Privilege("privilege 4"));
        privilegeList.add(new Privilege("privilege 5"));
        privilegeList.add(new Privilege("privilege 6"));
        //Emails.addAccountEmail("melkhiat@gmail.com", "Mustafa Elkhiat", "m", "role", regionList, privilegeList);
        Emails.assignToEmail("melkhiat@gmail.com","Mustafa Elkhiat","Ahmed Imbaby",12);
    }
}

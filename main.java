// /**
//  * @author staff 20441
//  * @version 2024a 17/10/2023
//  */
// public class main {
//     public static void main(String[] args) {
//         System.out.println("********** Test Apartment - Started **********");
//         System.out.println("\n1. Testing Constructors and toString:");
//         Person p1 = new Person("Israel Israeli","123456789",new Date(22, 10, 1993));        
//         Apartment a1 = new Apartment(4, 81, 6500, p1, new Date(1, 7, 2022), new Date(1, 7, 2024));
//         System.out.println("a1:\n" + a1);
//         Apartment a2 = new Apartment(a1);
//         System.out.println("a2:\n" + a2);

//         System.out.println("\n2. Testing accessors and mutators:");
//         System.out.println("a1:\n" + a1);
//         int rooms = a1.getNoOfRooms();
//         double area = a1.getArea();
//         double price = a1.getPrice();
//         Person tenant = a1.getTenant();
//         Date start = a1.getRentalStartDate();
//         Date end = a1.getRentalEndDate();

//         System.out.println("\tNumber of rooms of a1 = " + rooms);
//         System.out.println("\tArea of a1 = " + area);
//         System.out.println("\tPrice of a1 = " + price);
//         System.out.println("\tTenant name of a1 = " + tenant.getName());
//         System.out.println("\tRental start date of a1 = " + start);
//         System.out.println("\tRental end date of a1 = " + end);

//         Person p2 = new Person("David Levi",  "987654321",new Date(11, 12, 2001));  
//         a1.setTenant(p2);
//         a1.setNoOfRooms(5);
//         a1.setArea(110);
//         a1.setPrice(9900);
//         a1.setRentalStartDate(new Date(1, 8, 2023));
//         a1.setRentalEndDate(new Date(1, 8, 2025));
//         System.out.println("a1 after change:\n" + a1);
//         // System.out.println("Number of rooms = " + a1.getNoOfRooms());
//         // System.out.println("Area of a1 = " + a1.getArea());
//         // System.out.println("Price of a1 = " + a1.getPrice());
//         // System.out.println("Rental end date of a1 = " + a1.getRentalEndDate());

//         System.out.println("\n3. Testing equals method:");        
//         Apartment a3 = new Apartment(4, 81, 6500, p1, new Date(1, 7, 2022), new Date(1, 7, 2024));
//         Apartment a4 = new Apartment(4, 81, 6500, p1, new Date(1, 7, 2022), new Date(1, 7, 2024));
//         System.out.println("a3:\n" + a3);
//         System.out.println("a4:\n" + a4);
//         if(a3.equals(a4))
//              System.out.println("\ta3 is the same apartment as a4");
//         else 
//              System.out.println("\ta3 isn't the same apartment as a4");

//         System.out.println("\n4. Testing extendRentalPeriod method:");
//         System.out.println("a1 before:\n" + a1);
//         a1.extendRentalPeriod(1);
//         System.out.println("a1 after:\n" + a1);

//         System.out.println("\n5. Testing daysLeft method:");
//         Date d = new Date(1, 6, 2024);
//         int left = a2.daysLeft(d);
//         System.out.println("a2:\n" + a2);
//         System.out.println("\tNumber of days left to rent from " + d + " to end of rent is " + left + " days");

//         System.out.println("\n6. Testing changeTenant method:");
//         System.out.println("a4:\n" + a4);
//         Person p3 = new Person("Miriam Levi", "123123123",new Date(19, 9, 2001));
//         Date startDate = new Date(1, 6, 2024);
//         if (a4.changeTenant(startDate, p3, 7000))
//             System.out.println("\tApartment's tenant changed");
//         else
//             System.out.println("\tApartment's tenant cannot be changed");
//         System.out.println("a4:\n" + a4);
//         System.out.println("********** Test Apartment - Ended **********");

//     }
// }

// /**
//  * @author staff 20441
//  * @version 2024a 17/10/2023
//  */
// public class main {
//   public static void main(String[] args) {
//     // Person p1 = new Person("ido", "211655410", new Date(16, 4, 2000));

//     // Person p2 = new Person("ido", "211655410", new Date(15, 4, 2000));

//     // System.out.println(p1.compareTo(p2));

    
//   }
// }

/**
 * 
 * @author course 20441 staff
 * @version 17/10/2023 (2024a)
 */
public class main {
    public static void main(String[] args) {
        System.out.println("********** Test Person - Started **********");
        System.out.println("\n1. Testing Constructors and toString:");
        Person p1 = new Person("Israel Israeli", "123456789",new Date(22, 10, 1993));
        System.out.println("p1 :\n" + p1);
        Person p2 = new Person(p1);
        System.out.println("p2 :\n" + p2);

        System.out.println("\n2. Testing accessors and mutators:");
        String name = p1.getName();
        Date date = p1.getDateOfBirth();
        String id = p1.getId();
        System.out.println("\tName of p1 = " + name);
        System.out.println("\tId of p1 = " + id);
        System.out.println("\tDate of birth of p1 = " + date);
       
        p1.setName("Miriam Levi");
        p1.setId("121212");
        p1.setDateOfBirth(new Date(19, 9, 1981));
        System.out.println("p1 :\n" + p1);
 
        System.out.println("\n3. Testing equals method:");
        Person p3 = new Person("Yossef Ben Avrham" , "123123123",new Date(5, 3, 1998));
        Person p4 = new Person("Yossef Ben Avrham", "321321321", new Date(5, 3, 1998));
        System.out.println("p3 :\n" + p3);
        System.out.println("p4 :\n" + p4);
        if(p3.equals(p4))
             System.out.println("\tp3 is the same person as p4");
        else 
             System.out.println("\tp3 isn't the same person as p4");

        System.out.println("\n4. Testing compare method:");
        System.out.println("p1 :\n" + p1);
        System.out.println("p3 :\n" + p3);
        if(p1.compareTo(p3) > 0)
            System.out.println("\tp1 is older than p3");
        else if (p1.compareTo(p3) < 0)
            System.out.println("\tp1 is younger than p3");
        else
            System.out.println("\tp1 as the same age as p3");
        System.out.println("********** Test Person - Ended **********");
    }
}


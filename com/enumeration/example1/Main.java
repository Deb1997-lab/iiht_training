package enumeration.example1;

public class Main {
	
    public static void main(String[] args) {
        DaysofWeek today = DaysofWeek.MONDAY;
        System.out.println("Today is: " + today);

        // Iterate over all days of the week
        System.out.println("All days of the week:");
        for (DaysofWeek day : DaysofWeek.values()) {
            System.out.println(day);
        }
    }
}








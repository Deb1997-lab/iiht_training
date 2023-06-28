package enumeration.example2;

public class Weekend {
	public enum DaysofWeekend{
		SUNDAY,
		SATURDAY
	}

	public static void main(String[] args) {
		DaysofWeekend day1 = DaysofWeekend.SATURDAY;
		DaysofWeekend day2 = DaysofWeekend.SUNDAY;
		
		System.out.println("The days of weekend are: "+day1+" and "+day2);

	}

}

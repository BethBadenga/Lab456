import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class MyTravelPlannerTest {

	@Test
	void testWeekendWeatherSnowing() {
		MyTravelPlanner planner = new MyTravelPlanner() ;
		LocalDate dayofPlan = LocalDate.of(2024, 03, 31); 
		String weather = "Snowy";
		LocalTime timeOfFirstApptStart= LocalTime.of(12,10);
		LocalTime timeOfLastApptEnd= LocalTime.of(07+12, 20);
		String expectedPlan ="Please cancel or reschedule your appointments on 2024-Mar-31.";
		String actualPlan =planner.getPlan(dayofPlan, weather, timeOfFirstApptStart, timeOfLastApptEnd);
		assertEquals(expectedPlan, actualPlan);
	}
	 
	 @Test
		void testWeekendWeatherCloudy() {
			MyTravelPlanner planner = new MyTravelPlanner() ;
			String decision = planner.getPlan(LocalDate.of(2024, 03, 30), 
				"Cloudy", LocalTime.of(12,10), LocalTime.of (07+12,20)	);
              assertEquals( decision,"Please drive on 2024-Mar-30, and leave the house at 11:10 AM." );
	 }
			 @Test
				void testWeekendWeatherSunnyTrain001() {
					MyTravelPlanner planner = new MyTravelPlanner() ;
					String decision = planner.getPlan(LocalDate.of(2024, 03, 29), 
						"Sunny", LocalTime.of(12,10), LocalTime.of (07+12,20)	);
					assertEquals( decision,"Please take the 10:00 AM train to go to the city, and 8:00 PM train to get back home on 2024-Mar-29.");
			 }
			 
			@Test
				void testWeekendSunnyCar() {
					MyTravelPlanner planner = new MyTravelPlanner() ;
					String decision = planner.getPlan(LocalDate.of(2024, 03, 30), 
						"Sunny", LocalTime.of(8,45), LocalTime.of (10+12,20)	);
					assertEquals( decision,"Please drive on 2024-Mar-30, and leave the house at 07:45 AM." );
			 }
			 

@Test
void testWeekendSunnyTrain002() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 30), 
		"Sunny", LocalTime.of(1+12,45), LocalTime.of (11+12,20)	); // 1:45PM and 11:20PM
	assertEquals( decision,"Please drive on 2024-Mar-30, and leave the house at 1:45 PM." );
}
@Test
void testWeekendSunnyTrain003() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 30), 
		"Sunny", LocalTime.of(8,45), LocalTime.of (11+12,20)	); // 8:45AM and 11:20PM
	assertEquals( decision,"Please drive on 2024-Mar-30, and leave the house at 7:45 AM." );
}
@Test
void testWeekdaySnowy() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 27), 
		"Snowy", LocalTime.of(9,55), LocalTime.of (8+12,20)	); 
	assertEquals( decision,"Please cancel or reschedule your appointments on 2024-Mar-27." );
}
@Test
void testWeekdayRainy() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 26), 
		"Rainy", LocalTime.of(10,45), LocalTime.of (6+12,20)	); 
	assertEquals( decision,"Please cancel or reschedule your appointments on 2024-Mar-26." );
}
@Test
void testWeekdayCloudy() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 25), 
		"Cloudy", LocalTime.of(7,45), LocalTime.of (9+12,20)	); 
	assertEquals( decision,"Please cancel or reschedule your appointments on 2024-Mar-25." );
}
@Test
void testWeekdaySunyTrain() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 25), 
		"Sunny", LocalTime.of(7,35), LocalTime.of (3+12,20)	);  
	assertEquals( decision,"Please take the 6:30 AM train to go to the city, and 3:30 PM train to get back home on 2024-Mar-25" );
}
@Test
void testWeekendRainyTrain() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 21), 
		"Rainy", LocalTime.of(9,20), LocalTime.of (4+12,20)	);  
	assertEquals( decision,"Please cancel or reschedule your appointments on 2024-Mar-21." );
}
@Test
void testWeekenappintmentbefore11RainyTrain() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 3, 30), 
		"Rainy", LocalTime.of(7,20), LocalTime.of (9+12,20)	);  
	assertEquals( decision,"Please cancel or reschedule your appointments on 2024-Mar-30." );
}
@Test
void testWeekendSnowybefore11Train() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 31), 
		"Snowy", LocalTime.of(7,20), LocalTime.of (4+12,20)	);  
	assertEquals( decision,"Please cancel or reschedule your appointments on 2024-Mar-31." );
}
@Test
void testWeekendCloudyafter11Train() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 21), 
		"Cloudy", LocalTime.of(12,20), LocalTime.of (4+12,20)	);  
	assertEquals( decision,"Please take the 10:00 AM train to go to the city, and 6:00 PM train to get back home on 2024-Mar-21" );
}
@Test
void testWeekendSunnyafter11Train() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 22), 
		"Sunny", LocalTime.of(1,20), LocalTime.of (5+12,20)	);  
	assertEquals( decision,"Please take the 10:00 AM train to go to the city, and 6:00 PM train to get back home on 2024-Mar-22" );
}
@Test
void testMondaySnowy() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 25), 
		"Snowy", LocalTime.of(9,55), LocalTime.of (8+12,20)	); 
	assertEquals( decision,"Please cancel or reschedule your appointments on 2024-Mar-25." );
}
@Test
void testTuesdaySnowy() {
	MyTravelPlanner planner = new MyTravelPlanner() ;
	String decision = planner.getPlan(LocalDate.of(2024, 03, 26), 
		"Snowy", LocalTime.of(9,55), LocalTime.of (8+12,20)	); 
	assertEquals( decision,"Please cancel or reschedule your appointments on 2024-Mar-26." );
}
}



import java.util.Scanner;
/**
 * This class prints out the appointment menu and accepts user input 
 * @author Naren Kolli
 *
 */
public class AppointmentMenu {
 private AppointmentCalendar calendar;

 public AppointmentMenu() { //default constructor
 calendar = new AppointmentCalendar();
 }
 /**
 * Reads the user input and runs a command
 *
 */
 public void run() {
 Scanner scan = new Scanner(System.in);
 String reply = "";

 while(!(reply.equals("Q") && reply.equals("q"))) {
 System.out.println("A)dd C)ancel S)how Q)uit");

 reply = scan.nextLine();

 if(reply.equals("A") || reply.equals("a")) {
 add();
 }

 if(reply.equals("S") || reply.equals("s")) {
 show();
 }

 if(reply.equals("C") || reply.equals("c")) {
 cancel();
 }
 return; // If Q or q is pressed, the program terminates
 }
 }
 /**
 * Adds the user's appointment, but does not if that appointment already exists
 */
 public void add() {
 Scanner scan = new Scanner(System.in);
 System.out.println("Appointment: Description, Date, Start Time, End Time");
 String tempDescription = scan.nextLine();
 String tempDate = scan.nextLine();
 String tempStartTime = scan.nextLine();
 String tempEndTime = scan.nextLine();

 Appointments tempAppt = new Appointments(tempDescription,tempDate,tempStartTime,tempEndTime);

 if (calendar.isSameAppt(tempAppt)) { //isSameAppt method defined in AppointmentCalendar class
 System.out.println("This appointment already exists.");
 }

 else {
 calendar.add(tempAppt);
 }

 System.out.println();
 }
 /**
 * Displays all appointments for a user's given day
 * Does not return if no appointments have been made for that day
 */
 public void show() {
 Scanner scan = new Scanner(System.in);
 System.out.println("Which date's appointements should I give you?");
 String tempDate1 = scan.nextLine();
 String tempString = calendar.returnDate(tempDate1);
 if (tempString.length() > 0) {
 System.out.println("Here are today's appointments:");
 System.out.println(calendar.returnDate(tempDate1));
 }

 else
 System.out.println("You have not inputted any appointments for today, Sorry!");

 System.out.println();
 }
 /**
 * Cancels a specific appointment, given user input
 * If there are no appointments for a given date, displays an error message to the user
 */
 public void cancel() {
 Scanner scan = new Scanner(System.in);
 
 System.out.println("Which date's appointments should I cancel?");
 String tempDate2 = scan.nextLine();
 if(calendar.cancelsAppt(tempDate2).length() > 0) {
 System.out.println(calendar.cancelsAppt(tempDate2));
 System.out.println("Pick an Appointment to Cancel");
 int removedAppt = Integer.parseInt(scan.nextLine());
 int removedNum = removedAppt;

 int currentIndex = calendar.searchIndex(tempDate2); //searchIndex method defined in AppointmentCalendar class
 
 while(removedNum > 1) {
 currentIndex = calendar.findNextIndex(tempDate2, currentIndex);
 removedNum--;
 }

 calendar.delete(currentIndex); //delete method defined in AppointmentCalendar class
 }

 else
 System.out.println("You have not inputted any appointments for today, Sorry!");

 System.out.println();
 }

 public AppointmentCalendar getCalendar() { //returns an appointment object.
 return calendar;
 }
}


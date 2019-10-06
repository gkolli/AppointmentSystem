import java.util.ArrayList;
/**
 * AppointmentCalendar will include an arrayList of Appointments:
 * a method to add Appointments
 * a method to cancel Appointments
 * and return the Appointments for a selected day. 
 * @author Naren Kolli
 */
public class AppointmentCalendar {
 private ArrayList<Appointments> userAppointments;

 public AppointmentCalendar() { //default constructor
 userAppointments = new ArrayList<Appointments>();
 }
 /**
 * Reads the user input and adds an appointment to the ArrayList 
 */
 public void add(Appointments newAppointment) {
 userAppointments.add(newAppointment);
 }
 /**
 * Checks if there is already a same appointment, and returns true
 *
 */
 public boolean isSameAppt(Appointments tempAppointment) {
 for(int i = 0; i < userAppointments.size(); i++) {
 if(tempAppointment.equals(userAppointments.get(i))) {
 return true;
 }
 }

 return false;
 }
 /**
 * Deletes a given appointment from the ArrayList
 */
 public void delete(int removeIndex) {
 userAppointments.remove(removeIndex);
 }
 /**
 * Gives available appointments to cancel
 */
 public String cancelsAppt(String date) {
 String resultString = "";
 int matchCount = 0;
 int count = 1;

 for(int i = 0; i < userAppointments.size(); i ++) {
 if (userAppointments.get(i).verifyDate(date).length() > 0)
 matchCount++;
 }

 for(int i = 0; i < userAppointments.size(); i ++) {
 if (userAppointments.get(i).verifyDate(date).length() > 0)
 {
 resultString += count + ")" + userAppointments.get(i).verifyDate(date);
 count++;
 
 if (matchCount > 1) {
 resultString += "\n";
 matchCount--;
 }
 }
 }
 return resultString;
 }
 /**
 * Outputs appointments with a user's given date.
 */
 public String returnDate(String date) {
 String stringReply = "";
 int matchCount = 0;

 for(int i = 0; i < userAppointments.size(); i ++)
 {
 if (userAppointments.get(i).verifyDate(date).length() > 0)
 matchCount++;
 }

 for(int i = 0; i < userAppointments.size(); i ++) {
 if (userAppointments.get(i).verifyDate(date).length() > 0) {
 stringReply += userAppointments.get(i).verifyDate(date);
 
 if (matchCount > 1) {
 stringReply += "\n";
 matchCount--;
 }
 }
 }
 return stringReply;
 }
 /**
 * The searchIndex method returns the first appointment of a user's given date
 */
 public int searchIndex(String date) {
 int index = -1;

 for(int i = 0; i < userAppointments.size(); i++) {
 if (userAppointments.get(i).verifyDate(date).length() > 0) {
 index = i; 
 i = userAppointments.size() + 1;
 }
 }

 return index;
 }
 /**
 * The findNextIndex searches for appointment with same starting time
 */
 public int findNextIndex(String date, int startIndex) {
 int index = -1;

 for(int i = startIndex + 1; i < userAppointments.size(); i++) {
 if (userAppointments.get(i).verifyDate(date).length() > 0) {
 index = i; 
 i = userAppointments.size() + 1;
 }
 }

 return index;
 }

 public ArrayList<Appointments> getAppointmentList() { //returns an ArrayList of the appointments
 return userAppointments;
 }
}

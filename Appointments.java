/**
 * This class holds the parameters of the appointment:
 * (holds the input of description, date, and time) 
 * @author Naren Kolli
 *
 */
public class Appointments {
 private String apptDescription;
 private String apptDate;
 private String apptStartTime;
 private String apptEndTime;

 public Appointments(String userDescription, String userDate, String userStartTime, String userEndTime) { //Constructs an Appointment object
 apptDescription = userDescription;
 apptDate = userDate;
 apptStartTime = userStartTime;
 apptEndTime = userEndTime;
 }
 /**
 * The equals method checks to see whether or not two appointment objects equals
 * @return true if two appointment objects equal
 */
 public boolean equals(Appointments tempAppt)
 {
 boolean equalAppt = apptDescription.equals(tempAppt.apptDescription) 
 && apptDate.equals(tempAppt.apptDate) 
 && apptStartTime.equals(tempAppt.apptStartTime) 
 && apptEndTime.equals(tempAppt.apptEndTime);
 return equalAppt;
 }
 /**
 * The toString method converts to String 
 */
 public String toString() {
 String resultString = apptDescription + "\n" + apptDate + "\n" + apptStartTime + "\n" + apptEndTime + "\n";
 return resultString;
 }
 /**
 * The verifyDate returns appointment if dates match,
 * so appointment for a given date and time is not duplicated
 * @return appointment that matches
 */
 public String verifyDate(String tempDate) {
 String stringMatch = "";
 if (tempDate.equals(apptDate)) {
 stringMatch = apptDescription + " " + apptDate + " " + apptStartTime + " " + apptEndTime + " ";
 }
 return stringMatch;
 }
 /**
 * @Return description of appointment
 */
 public String getApptDescription() {
 return apptDescription;
 }
 /**
 * @return date of appointment
 */
 public String getApptDate()
 {
 return apptDate;
 }
 /**
 * @return starting time of appointment
 */
 public String getApptStartTime() {
 return apptStartTime;
 }
 /**
 * @return ending time of appointment
 */
 public String getApptEndTime() {
 return apptEndTime;
 }
}
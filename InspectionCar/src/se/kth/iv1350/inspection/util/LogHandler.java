package se.kth.iv1350.inspection.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 * This class is responisble for the logging information when a exception was triggered. 
 *
 */

public class LogHandler {
	
	private static final String LOG_FILE_NAME = "logfile.txt";
	private PrintWriter logFile;
	
	/**
	 * This constructor creates a new instance of the imported class Printwriter whitch takes in an instance of the imported class FileWriter as a parameter.
	 * @throws IOException
	 */
	
	 public LogHandler() throws IOException { 
		 logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
	 } 
	 
	 /**
	  * This method logs information about the parameter exception, it saves time, why the exception was thrown. 
	  * @param exception. The exception that is to be logged. 
	  */
	 public void logException(Exception exception) {
		 StringBuilder logMsgBuilder = new StringBuilder(); 
		 logMsgBuilder.append(createTime());
		 logMsgBuilder.append(", Exception was thrown: ");
		 logMsgBuilder.append(exception.getMessage());
		 logFile.println(logMsgBuilder);
		 exception.printStackTrace(logFile);
	 }
	 
	 /**
	  * This method saves the current time as a string.
	  * @return. Returns the current time as a string. 
	  */
	 private String createTime() {
		 LocalDateTime now = LocalDateTime.now(); 
		 DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		 return now.format(formatter);
	 }
}

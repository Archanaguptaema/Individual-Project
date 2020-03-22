import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main {
	static String input;
	
	static List<Task> taskList = new ArrayList<Task>();
	public static void main(String[] args){
	        //System.out.print("Enter something : ");
        	printWelcome();
        	//call method to initialize task list (read from file)
        	populateTaskListFromFile();     	
        	optionList();
           //System.out.println("User Input : " + input);
            //WriteToFile();
            //ShowTaskList();
}
	
	
	//Method to print welcome message
	public static void printWelcome()
	{
	    System.out.println("Welcome To-Do list application");
	}
	
	//Method to show option list
	public static void optionList(){
	    System.out.println("Pick an option.");
	    System.out.println("(1) Show Task list");
	    System.out.println("(2) Add new task");
	    System.out.println("(3) Edit task (update,mark as done , remove) ");
	    System.out.println("(4) Save and quit");
	    System.out.println("(5) Exit");
	    UserInput();
	}
	
	// method to populate the task list from file.
	public static void populateTaskListFromFile(){
		try {
            File fil = new File("Testproject.txt");
            BufferedReader b = new BufferedReader(new FileReader(fil));
            String readLine = "";
            while ((readLine = b.readLine()) != null) { 
            	// General;Call;2020-03-30;False
            	String[] taskDetails = readLine.split(";");
            	//[General,Call,2020-03-03,False]
            	List<String> taskDetailsList = Arrays.asList(taskDetails);
            	Boolean taskStatus;
            	if(taskDetailsList.get(3).equalsIgnoreCase("false")){
            		 taskStatus = false; 
            	}
            	else {
            		 taskStatus = true;
            	}
            	
				Task currentTaskInLoop = new Task(taskDetailsList.get(1), LocalDate.parse(taskDetailsList.get(2)), taskStatus, taskDetailsList.get(0));
            	taskList.add(currentTaskInLoop);
            }
        } catch (IOException e) {
            e.printStackTrace();         
        }
	}
							
// method to print tasks in task list
	public static void ShowTaskList() { 
		System.out.println("Project   Task titel   Due Date   Status");
		for (Task printTasks :taskList ){
			String taskStatus = "";
			if(printTasks.getStatus() == false){
				taskStatus = "Not done";
			}
			else{
				taskStatus = "Done";
			}
			System.out.println(printTasks.getProjectName()+"   "+printTasks.getTitle()+"       "+printTasks.getEndDate()+"    "+taskStatus);
		}
		UserInput();
	}
		
// Handling user input method
	public  static void UserInput(){
		System.out.println("Please enter your option");
		try (Scanner scanner = new Scanner(System.in)) {		
			input = scanner.nextLine();  // Read user input	
			handleUserInput(input);
		}		
	}
	
	public static void handleUserInput(String userInput) {
		if (input.equalsIgnoreCase("1")){
			ShowTaskList();
		}
			else if(input.equalsIgnoreCase("help")){
				System.out.println("You can choose among the following options");
				optionList();	
			}
			else if(input.equalsIgnoreCase("2")){
				System.out.println("Add new task");
			}
			else if(input.equalsIgnoreCase("3")){
				System.out.println("Edit task");
				ShowTaskList();
			}
			else if(input.equalsIgnoreCase("4")){
				System.out.println("Task list is saved");
			}
			else if(input.equalsIgnoreCase("5")){
				exitApplication();
			}
			else {
					System.out.println("Incorrect Option");
					System.out.println("Choose from the given option");
					optionList();
					UserInput();
			}
	}
	
 public static void exitApplication(){
	 System.out.println("Thank you for using To-Do List");
 }
}



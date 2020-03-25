


import java.time.LocalDate;

public class Task {
private String title;
private LocalDate endDate;
private Boolean status;
private String projectName;

// constructor

public Task(String taskTitle, LocalDate dueDate, Boolean status, String project){
	title = taskTitle;
	endDate = dueDate;
	projectName= project;
	this.status = status;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public LocalDate getEndDate() {
	return endDate;
}

public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}

public Boolean getStatus() {
	return status;
}

public void setStatus(Boolean status) {
	this.status = status;
}

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}


	
}


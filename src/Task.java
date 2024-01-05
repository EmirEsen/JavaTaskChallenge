import java.util.Objects;

enum Status{ASSIGNED, IN_PROGRESS, NOT_YET_ASSIGNED}

enum Priority{HIGH, MEDIUM, LOW}

public class Task implements Comparable<Task> {

    private String projectName;
    private String description;
    private String assignee;
    private Status status;
    private Priority priority;

    public Task(String projectName, String description, String assignee, Status status, Priority priority) {
        this.projectName = projectName;
        this.description = description;
        this.assignee = assignee;
        this.status = status;
        this.priority = priority;
    }

    public Task(String projectName, String description, String assignee, Priority priority) {
        this(projectName, description, assignee, assignee == null ? Status.NOT_YET_ASSIGNED : Status.ASSIGNED,
                priority);
    }

    public Task(String projectName, String description, Priority priority) {
        this(projectName, description, null, priority);
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignee() {
        return assignee;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(projectName, description, priority, assignee, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(getProjectName(), task.getProjectName()) && Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectName(), getDescription());
    }

    @Override
    public int compareTo(Task o) {
        int result = projectName.compareTo(o.projectName);
        if(result == 0) {
            result = description.compareTo(o.description);
        }
        return result;
    }
}

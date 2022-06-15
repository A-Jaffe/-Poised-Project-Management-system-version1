public class Project {
    // Create attributes for Project objects
    String projName;
    int projNumber;
    int deadLine;
    String buildType;
    int erf;
    double totalFee;
    double paidSoFar;
    boolean finalised;
    Person architect;
    Person contractor;
    Person customer;

    // Project class constructor
    public Project(String projName, int projNumber, int deadline, String buildType,
                   int erf, double totalFee, double paidSoFar, boolean finalised,
                   Person architect, Person contractor, Person customer) {
        this.projName = projName;
        this.projNumber = projNumber;
        this.deadLine = deadline;
        this.buildType = buildType;
        this.erf = erf;
        this.totalFee = totalFee;
        this.paidSoFar = paidSoFar;
        this.finalised = finalised;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;

    }

    // Define projectToString method to view projects
    public String projectToString() {
        System.out.println("\nPROJECT DETAILS: ");
        String projectDetails = "Project Name: " + projName;
        projectDetails += "\nProject Number: " + projNumber;
        projectDetails += "\nProject Deadline: " + deadLine;
        projectDetails += "\nBuilding Type: " + buildType;
        projectDetails += "\nERF Number: " + erf;
        projectDetails += "\nTotal Fee of project: R" + totalFee;
        projectDetails += "\nAmount Paid so far: R" + paidSoFar;

        return projectDetails;
    }

    // Deefine displayPersonOnProject method to display people associated to a project
    public String displayPersonOnProject() {
        String peopleOnProject = "\nPEOPLE ON PROJECT: ";
        peopleOnProject += "\n" + architect.personToString() + "\n\n" +
                contractor.personToString()  + "\n\n" + customer.personToString() ;

        return peopleOnProject;
    }

// Create subclass for Project objects that have been finalised and are complete
static class CompletedProject extends Project {
    int completedDate;
    String status;

    // Subclass constructor to add completed date and finalised status to completed projects
    public CompletedProject(String projName, int projNumber, int deadline, String buildType,
                            int erf, double totalFee, double paidSoFar, boolean finalised,
                            Person architect, Person contractor, Person customer, int completedDate, String status) {
        super(projName, projNumber, deadline, buildType, erf, totalFee, paidSoFar, finalised, architect, contractor, customer);
        this.completedDate = completedDate;
        this.status = status;

    }

    // Define completeToString method to display completed projects
    public String completeToString() {
        System.out.println("\nCOMPLETED PROJECT DETAILS: ");
        String projectDetails = "Project Name: " + projName;
        projectDetails += "\nProject Number: " + projNumber;
        projectDetails += "\nProject Deadline: " + deadLine;
        projectDetails += "\nBuilding Type: " + buildType;
        projectDetails += "\nERF Number: " + erf;
        projectDetails += "\nTotal Fee of project: R" + totalFee;
        projectDetails += "\nAmount Paid so far: R" + paidSoFar;
        projectDetails += "\nCompletion Date: " + completedDate;
        projectDetails += "\nProject Status: " + status;


        return projectDetails;

    }
    }
}
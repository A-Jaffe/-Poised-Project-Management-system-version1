import java.util.*;

public class PoisedMain {
    // Main method used to create Project and Person objects and run user menu
    public static void main(String[] args) {
        System.out.println("Welcome to the Poised project manager!");

        // Request new project details from user
        System.out.println("You will now be prompted to create a new project.");

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a name for the project: ");
        String projName = input.nextLine();

        System.out.print("Please enter the project number: ");
        int projNumber = Integer.parseInt(input.nextLine());

        System.out.print("Please enter a deadline for the project (in the format ddmmyy): ");
        int deadLine = Integer.parseInt(input.nextLine());

        System.out.print("Please enter the type of building for project: ");
        String buildType = input.nextLine();

        System.out.print("Please enter the ERF number of the building: ");
        int erf = Integer.parseInt(input.nextLine());

        System.out.print("Please enter the total fee for the project: ");
        double totalFee = Double.parseDouble(input.nextLine());

        System.out.print("Please enter the amount paid so far: ");
        double paidSoFar = Double.parseDouble(input.nextLine());

        // Set project status to NOT finalised
        boolean finalised = false;

        // Request project Architect details from user
        System.out.println("\nPlease enter the details for the Architect on the project: ");
        String archPosition = "Architect";

        System.out.print("Architect name: ");
        String archName = input.nextLine();

        System.out.print("Architect email address: ");
        String archEmail = input.nextLine();

        System.out.print("Architect telephone number: ");
        String archTelephone = input.nextLine();

        System.out.print("Architect physical address: ");
        String archPhysAddress = input.nextLine();

        // Create architect Person object with user input
        Person architect = new Person(archPosition, archName, archEmail,
                archTelephone, archPhysAddress);

        // Request project Contractor details from user
        System.out.println("\nPlease enter the details for the Contractor on the project: ");
        String contPosition = "Contractor";

        System.out.print("Contractor name: ");
        String contName = input.nextLine();

        System.out.print("Contractor email address: ");
        String contEmail = input.nextLine();

        System.out.print("Contractor telephone number: ");
        String contTelephone = input.nextLine();

        System.out.print("Contractor physical address: ");
        String contPhysAddress = input.nextLine();

        // Create contractor Person object with user input
        Person contractor = new Person(contPosition, contName, contEmail,
                contTelephone, contPhysAddress);

        // Request project Customer details from user
        System.out.println("\nPlease enter the details for the Customer on the project: ");
        String custPosition = "Customer";

        System.out.print("Customer name: ");
        String custName = input.nextLine();

        System.out.print("Customer email address: ");
        String custEmail = input.nextLine();

        System.out.print("Customer telephone number: ");
        String custTelephone = input.nextLine();

        System.out.print("Customer physical address: ");
        String custPhysAddress = input.nextLine();

        // Create customer Person object with user input
        Person customer = new Person(custPosition, custName, custEmail,
                custTelephone, custPhysAddress);

        // If no project name has been entered, create one using building type and customer name
        if (projName.equals("")) {
            projName = buildType + custName;
        }

        // Create Project object with user's initial project input and ADD Person objects
        Project project = new Project(projName, projNumber, deadLine, buildType, erf, totalFee,
                paidSoFar, finalised, architect, contractor, customer);

        // Display new project has been created message and all project details
        System.out.println("\nNew project has been created!");
        System.out.println(project.projectToString());
        System.out.println(project.displayPersonOnProject());

        /* Request menu choice from user, use loop to ensure valid input
        and to keep looping until user inputs 4 to log out */
        boolean loop = true;
        while (loop) {
            // Request menu choice input from user
            System.out.println("""
                    \nWould you like to:
                    1) Update the details of a project
                    2) Update a contractors details
                    3) Finalise a project
                    4) Log Out""");
            int menuChoice = Integer.parseInt(input.nextLine());

            // Menu choice 1, request type of project edit and update Project object details
            if (menuChoice == 1) {
                System.out.print("Would you like to update the due-date (d) or the " +
                        "amount paid so far (a) of the project?");
                String editChoice = input.nextLine();

                // Request new deadline for the project from user
                if (editChoice.equals("d")) {
                    System.out.print("Please enter new deadline of the project (in the format ddmmyy): ");
                    deadLine = Integer.parseInt(input.nextLine());

                    // Update Project object with new deadline for project
                    project = new Project(projName, projNumber, deadLine, buildType, erf, totalFee,
                            paidSoFar, finalised, architect, contractor, customer);

                // Request new amounut paid so far from user
                } if (editChoice.equals("a")) {
                    System.out.print("Please enter amount paid to date for the project: ");
                    paidSoFar = Integer.parseInt(input.nextLine());

                    // Update Project object with new amount paid so far for project
                    project = new Project(projName, projNumber, deadLine, buildType, erf, totalFee,
                            paidSoFar, finalised, architect, contractor, customer);
                }

                // Display updated Project details
                System.out.println(project.projectToString());

            // Menu choice 2, request new Contractor details and update Project object
            } else if (menuChoice == 2) {
                System.out.println("Please enter new details for the contractor on the project: ");
                System.out.print("New name: ");
                String name = input.nextLine();

                System.out.print("New email address: ");
                String email = input.nextLine();

                System.out.print("New telephone number: ");
                String telephone = input.nextLine();

                System.out.print("New physical address: ");
                String physAddress = input.nextLine();

                // Update contractor object with new details
                contractor = new Person(custPosition, name, email, telephone, physAddress);

                // Update project object with new contractor Person
                project = new Project(projName, projNumber, deadLine, buildType,
                        erf, totalFee, paidSoFar, finalised, architect, contractor, customer);

                // Display updated contractor details
                System.out.println("\nNew Contractor details: ");
                System.out.println(contractor.personToString());

            // Menu choice 3, finalise the project
            } else if (menuChoice == 3) {
                // If there is an outstanding amount to be paid generate an invoice
                if ((totalFee - paidSoFar) > 0) {

                    // Display invoice with customer details outstanding balance
                    System.out.println("Invoice generated below: \n");
                    System.out.println("CUSTOMER INFORMATION: ");
                    System.out.println(customer.personToString());
                    System.out.println("Outstanding balance: R" + (totalFee - paidSoFar));

                // If the total fee has been paid in full.
                } else {
                    // No invoice generated
                    System.out.println("The project has been paid in full, no invoice generated.");

                    // Add completed date and mark as finalised
                    System.out.println("Please enter a completion date (ddmmyy) for this project: ");
                    int completeDate = Integer.parseInt(input.nextLine());
                    String complete = "**FINALISED**";

                   /* Create CompletedProject subclass object with completion date,
                   mark as finalised and set finalised bollean to true */
                   Project.CompletedProject projectComplete = new Project.CompletedProject(projName,
                           projNumber, deadLine, buildType, erf, totalFee, paidSoFar, true,
                           architect, contractor, customer, completeDate, complete);

                    // Display CompletedProject details with completed date and marked finalised
                    System.out.println(projectComplete.completeToString());
                }

            // Menu choice 4, log, out, exit loop
            } else if (menuChoice == 4) {
                System.out.println("You have successfully logged out.");
                loop = false;

            // Menu Choice error catcher and loop restarter
            } else {
                System.out.println("You have entered and invalid option, please try again");
            }
        }
    }
}
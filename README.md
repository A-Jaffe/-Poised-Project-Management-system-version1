# Poised Project Management System (version1)
This program is written in java and was designed for the purpose of managing construction jobs
for a small and ficticious architecture business. It allows the user to *add new projects, 
update existing projects and finalise projects that have been completed*. It is the first Capstone 
project on level 2 of my Hyperion Developement course.

## Functionality
The program uses object orientated programing in order to complete tasks decided by the user. A project
object is created which contains all the attrtibutes a project can have *(i.e. name, number, deadline...etc)*
as well as containing 3 Person objects namely for the architect, contractor and customer on the job.
The Person objects contain attributes pertaining to the people involved, namely their *position, name, telephone,
email and physical address.*

When the program is run, the user is prompted to fill in information about a new project, then they
are prompted for information about the 3 people on the project. This information is stored as a new object.
Next the user is provided with a menu of options to: *update the details of a project, update
the details of a contractor on the project, finalise a project or log-out of the program.*

When the user chooses to update either the project details or the details of the contractor on the project,
they are prompted for the new details and these are saved (re-written) to the objecet previously created.

If the user decides to finalise a project, the program will determine if the total fee of the project has been paid.
If it has, no invoice will be generated and the user is asked to add a completion date to the project.
The project will then be marked as **finalised**.

However, if there is still an outstanding amount to be paid,  an invoice will be generated with 
the customers details and the outstanding balancce of the projecet.

## Contributors
I worked on this program alone and it was reviewed by the codde reviewers from HyperionDev.

# Library Management
Basic Library management System Build on Spring Boot




Features Developed:

Admin
-----------
Add Book to Library
Update Book details
Delete Book
Fetch all Books
Fetch Book by ISBN
Fetch Book by ID
Add user
Update UserDetails
Update User Role
Add New Library Location
Update Library Location
List of Book under Library
Issue Book
Return Book

End User
--------------------
Making a borrow request
Make a cancellation request


How to Start:
----------------
1. Install STS
2.1 Download the latest version on Lombak and add plugin to STS
	https://search.maven.org/search?q=g:org.projectlombok%20AND%20a:lombok&core=gav
2.2 execute command java -jar command and an installer UI will open
2.3 select the location where STS is installed. 
2.4 Restart the STS
3.1 Download this project
3.2  Import as a maven project in STS


Run it as Spring Boot app
URL
http://localhost:9082/library-mgmt



for Testing API at browser use Swagger

Run it as Spring Boot app
URL
http://localhost:8085/library-mgmt/swagger-ui.html


# Test case Execute

Select below class in STS in run as JUnit Test
    1. BookControllerTest
    2. LibraryControllerTest
    3. UserControllerTest



The Name of the Branch is DTO.

DTO stands for Data Transfer Object.

Here we will be using the DTO class to transfer the
information between the client and the server using
the DTO object instead of the JPA entity.

Implementation:
The DTO will have same fields as the JPA entity and 
will map fields from DTO class to the JPA entity class
and vice versa. For example DTO to JPA happens for inward 
Journey of the request (i.e when a request is received)
and then from JPA to DTO during its outward journey
or while sending the response to the client.


The DTO design patterns are used for:
1. To decide what data the client should see and send
   only the client is supposed to see.
2. To reduce the number of remote calls from client to
    the server.

Say we have an University, University has lot of colleges
associated or managed by it, each college has teachers/lecturers
and students.

If we need the details of students in a particular college,
we will make an API call to say:
a. Find if the university exists and functional.
b. Find if the collage we are interested in managed by the University.
c. We may find the department or the course the student is studying.
d. We may find if the student with given details is enrolled to the course.


Now this requires 4 calls to the API's exposed by the University, College,
Course/Department and the student. With DTO these can be achieved in a single 
call and all that it requires is the data mapper (that Collects data from 
multiple objects, collates as needed and returns to the client.)

This will ensure we are making lesser calls to the server and are sending
only the details that we intend to send and not everything blindly. This 
ensures that we control what we share and sensitive information is not 
shared to the client. 
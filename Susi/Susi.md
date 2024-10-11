
## Records

Person
- firstName
- middleName
- lastName
- egn
- birthdate

Student : Person
- faculty number
- yearEnrolled
- major

Teacher : Person
- academicTitle

Semester
- courses

Course
- year
- name
- students
- credits
- required
- exams
    - grades
      - student
      - grade


## TODO

Use:
1. Presentation Layer - console app
2. Service Layer - logic for inquiries and other features
3. Data Layer - store data and do "SQL" operations

For data layer:
- Each data transfer object will only have it's own members (no references, 0 coupling).
- Data Access Objects will handle joins(examples: courses by student, courses by semester etc), filters - standin for a database

For buisness layer:
- ????


For presentation layer:
- Get data from console, send it to service layer


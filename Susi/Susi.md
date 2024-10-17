
## Records

Can't have record inheritance so sadge

Person
- firstName
- middleName
- lastName
- egn
- birthdate

Student 
- faculty number
- yearEnrolled
- major

Teacher
- academicTitle

Semester
- year
- season (WINTER / SUMMER)

Course
- year
- name
- credits
- required

Exam
- date

## Data Access Objects

One for each record.
Interface for accessing the fields.
Implementation for storage in memory.


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

Assignment from discord

добавяне на администратор
- new Account.Role ADMINISTRATOR
- new ConsoleAdministratorUI
- features:
    - създай курс
    - създай предподавател
    - създай студент
    - запиши студент в курс (админ/преподавател)
    - отпиши студент от курс (админ/предподавател)

писане на оценки
минаване на курс




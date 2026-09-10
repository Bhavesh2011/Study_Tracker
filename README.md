# Study Tracker

A Java-based Study Tracker application that helps users record, manage, review, and export their daily study activities.

## Features

* Add a new study log
* View all study logs
* Generate study summaries by date
* Generate study summaries by subject
* Export study records to a CSV file
* Store study date, subject, duration, and description
* Menu-driven console interface

## Technologies Used

* Java
* Java Collections Framework
* ArrayList
* TreeMap
* LocalDate
* File Handling
* CSV File Handling
* Object-Oriented Programming

## Data Structures Used

### ArrayList

`ArrayList<StudyLog>` is used to store all study records in the application.

### TreeMap

`TreeMap` is used to organize study information based on dates and calculate the total study duration.

## Project Structure

```text
StudyTracker/
│
├── StudyLog.java
├── StudyTracker.java
├── program557.java
└── README.md
```

## Study Log Information

Each study record contains:

```text
Date
Subject
Duration
Description
```

## Application Menu

```text
1 : Insert new Log Into database
2 : View All Study Logs
3 : Summary of study log by Date
4 : Summary Of study log by Subject
5 : Export Study Log to CSV file
6 : Exit The Application
```

## How It Works

1. Start the application.
2. Select an option from the menu.
3. Enter the subject, study duration, and description.
4. The study log is stored in the application.
5. View all stored study logs whenever required.
6. Generate summaries to analyze study time.
7. Export the study records to a CSV file for future reference.

## CSV Export

The application generates a CSV file named:

```text
MarvellousStudy.csv
```

The exported file contains:

```text
Date,Subject,Duration,Description
```

## Key Concepts

* Classes and Objects
* Constructors
* Encapsulation
* ArrayList
* TreeMap
* Iteration
* Method Overriding
* Java Time API
* Exception Handling
* File Handling
* CSV Generation

## Future Improvements

* Add update and delete study logs
* Fix and implement subject-wise summary
* Add persistent database storage
* Add weekly and monthly reports
* Add graphical user interface
* Add user authentication
* Add study goals and progress tracking

## Author

**Bhavesh Gaikwad**

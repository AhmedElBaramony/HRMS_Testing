# Human Resource Management System (HRMS)


## Project Description
Our HRMS is designed to provide essential tools for modern businesses to manage their human resources effectively. It supports key HR functions such as managing employee details, payroll processing, leave requests, and performance evaluations, all through an intuitive interface. With a focus on functionality and user experience, our system helps ensure that your HR tasks are handled efficiently and accurately. Trust our HRMS to support your HR department in their daily operations, making it easier to focus on strategic goals.

## Core Features
- **Robust Authentication System**: Secure multi-tier access controls for different user roles, including administrators and employees.
- **Dynamic Employee Management**: Effortlessly add, update, and manage employee profiles with intuitive interface controls.
- **Advanced Payroll System**: Configure and retrieve payroll setups with detailed record-keeping and reporting capabilities.
- **Comprehensive Leave Management**: Simplify the leave application process with an integrated system that handles requests and approvals efficiently.
- **Detailed Performance Evaluations**: Facilitate detailed assessments with customizable evaluation forms to enhance employee performance insights.

## Getting Started
Follow these steps to set up and run the HRMS in your local environment:

### Prerequisites
- Java JDK 11 or later
- Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse

### Installation
1. Clone the GitHub repository:
```bash
git clone https://github.com/AhmedElBaramony/HRMS_Testing.git
```
2. Navigate to the project directory:
```bash
cd path/to/hrms
```
### Run the Application
- Compile the source code:
```bash
javac -d bin src/main/java/org/example/*.java
```
- Start the application:
```bash
java -cp bin src/main/java/LoginPage.java
```

## Testing
Run the JUnit tests to verify the functionality and reliability of the application components:
```bash
javac -d bin -cp path/to/junit.jar src/test/java/org/example/*.java
java -cp bin:path/to/junit.jar org.example.TestSuite
```

## Project Structure
- `src/main/java`: Contains all the primary application code, including business logic and user interface components.
- `src/test/java`: Houses the JUnit tests for validating the functionalities of the application.

# Banking Application

A Java-based desktop banking application with a graphical user interface built using Swing. This application provides basic banking functionalities including user authentication, account management, and financial transactions.

## Features

- **User Authentication**
  - Secure login system
  - New user registration
  - Password protection

- **Account Management**
  - View current balance
  - Deposit funds
  - Withdraw funds
  - View transaction history
  - Transfer funds between accounts

- **User Interface**
  - Clean and intuitive design
  - Responsive layout
  - Easy navigation between features

## Technologies Used

- **Core**: Java 8+
- **GUI**: Java Swing
- **Database**: MySQL (using JDBC)
- **Environment Variables**: Dotenv for configuration

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- MySQL Connector/J (JDBC driver)
- (Optional) Maven or Gradle for dependency management

## Setup Instructions

1. **Database Setup**
   - Create a new MySQL database for the application
   - Create a `.env` file in the project root with the following variables:
     ```
     DB_URL=jdbc:mysql://localhost:3306/your_database_name
     DB_USERNAME=your_username
     DB_PASSWORD=your_password
     ```
   - Import the database schema (if available)

2. **Running the Application**
   - Compile the Java source files
   - Run `AppLauncher.java` as the main class
   - Or use your IDE's run configuration

## Usage

1. **Login**
   - Launch the application
   - Enter your username and password
   - Click "Login" to access your account

2. **Registration**
   - Click on "Register" link on the login screen
   - Fill in the required details
   - Submit the form to create a new account

3. **Banking Operations**
   - View your current balance on the dashboard
   - Use the buttons to perform transactions:
     - Deposit money
     - Withdraw money
     - View past transactions
     - Transfer money to another account
   - Logout when finished

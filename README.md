# 📞 Phonebook App

A simple Java console application that allows users to perform name-based and reverse phone number lookups from a local text file.

## 🧠 Features

- 🔍 **Lookup**: Search for a person's phone number using their first and last name.
- 🔁 **Reverse Lookup**: Find a person's name using their phone number.
- 🧾 Reads entries from a local `phonebook.text` file.
- 🧪 Detects duplicate names and phone numbers.

## 📂 Project Structure
📁 PhonebookApp/
├── src/
│ ├── PhonebookApp.java # Main class with user interface
│ ├── Phonebook.java # Handles reading entries and lookup logic
│ ├── PhonebookEntry.java # Represents a phonebook entry
│ ├── Name.java # Name data class
│ └── PhoneNumber.java # Phone number data class
├── phonebook.text # Data file with phonebook entries
├── .gitignore
└── README.md


## 📝 File Format

`phonebook.text` should contain entries in the format:

LastName FirstName 123-456-7890
Doe John 800-555-1234
Smith Jane 212-333-4444


Each line represents one entry with a name and a phone number.

## 🚀 How to Run

1. Make sure you have **Java 11+** installed.
2. Clone the repository:
   ```bash
   git clone https://github.com/your-username/phonebook-app.git
   cd phonebook-app
3. Open the project in IntelliJ (or another IDE).
4. Run the PhonebookApp.java file.

## 🛠️ Technologies Used

Java
IntelliJ IDEA

## 📚 What I Learned

- Working with file I/O in Java
- Object-oriented design (multiple classes with encapsulated logic)
- Handling exceptions and user input
- Simulating real-world use cases like phonebook lookups

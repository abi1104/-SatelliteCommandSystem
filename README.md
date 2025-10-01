## 🛰️ Satellite Command System
A mini-project simulating a Satellite Command System
## 📚 Exercise 1: Design Patterns – Problem Statement
## ✨ Overview
Demonstration of six different use cases understanding of Software Design Patterns.
Two use cases for each pattern type (Behavioural,Creational,Structural)

## 📝 Design Patterns Summary
| **Category**    | **Pattern**   | **Use Case**                        | **Description**                                                          |
| --------------- | ------------- | ----------------------------------- | ------------------------------------------------------------------------ |
| **Behavioural** | **State**     | *Traffic Light System*              | Manages traffic light states (Red, Green, Yellow) by changing behavior dynamically.|
| **Behavioural** | **Strategy**  | *Payment Gateway Selection*         | Allows dynamic selection of payment methods (Credit Card, UPI, Wallet).  |
| **Creational**  | **Factory**   | *Vending Machine Item Selection*    | Dynamically creates different vending machine items (like drinks and chocolates) by centralizing the creation process. |
| **Creational**  | **Builder**   | *Computer Configuration System*     | Builds customizable computers with optional parts.                       |
| **Structural**  | **Adapter**   | *Legacy Payment System Integration* | Integrates old payment system into new apps without changing code.       |
| **Structural**  | **Composite** | *File System*                       | Represents files and folders in a tree structure where both can be treated uniformly. |

---
## 🛰️Experiment 2: Mini Project - Satellite Command System
## 📌 Overview
The **Satellite Command System** is a Java-based mini-project that simulates satellite operations such as:
- Rotating (North, South, East, West)
- Activating/Deactivating solar panels
- Collecting data (*only if panels are active*)
- Maintaining correct satellite state
The project also includes enhancements like **Undo/Redo, Command History, Logging, and Custom Exceptions** to make it more realistic and extensible.


## 🎯 Features
- ✅ Rotate Satellite (N/S/E/W)
- ✅ Activate/Deactivate Solar Panels
- ✅ Collect Data (panels must be active)
- ✅ Show Current Status
- ✅ Undo/Redo previous commands
- ✅ Command History viewer
- ✅ Logger (Observer Pattern) for state changes
- ✅ Custom Exception handling


## 🏗️ Design Patterns Used
| Pattern       | Type       | Where Used                                            | Why                                            |
| ------------- | ---------- | ----------------------------------------------------- | ---------------------------------------------- |
| **Command**   | Behavioral | Rotate, ActivatePanels, DeactivatePanels, CollectData | Encapsulates each action, supports Undo/Redo   |
| **Singleton** | Creational | `SatelliteController`                                 | Ensures only one central controller instance   |
| **Proxy**     | Structural | `SatelliteProxy`                                      | Validates and controls access to the Satellite |
| **Observer**  | Behavioral | `Logger`                                              | Logs/monitors state changes automatically      |


## 📂 Project Structure
Exp2/  
└── **SatelliteSystem/**  
     ├── **controller/**  
     │    └── SatelliteController.java  
     ├── **core/**  
     │    ├── Satellite.java  
     │    └── SatelliteProxy.java  
     ├── **command/**  
     │    ├── ICommand.java  
     │    ├── RotateCommand.java  
     │    ├── ActivatePanelsCommand.java  
     │    ├── DeactivatePanelsCommand.java  
     │    └── CollectDataCommand.java  
     ├── **observer/**  
     │    ├── ISatelliteObserver.java  
     │    └── Logger.java  
     ├──**exceptions/**  
     |     ├── InvalidCommandException.java  
     |     ├── InvalidDirectionException.java  
     |     └── PanelInactiveException.java  
     └── Main.java  

## ⚡ How to Compile
From project root :
   javac -d Exp2/bin Exp2/SatelliteSystem/exceptions/*.java Exp2/SatelliteSystem/observer/*.java Exp2/SatelliteSystem/core/*.java Exp2/SatelliteSystem/command/*.java Exp2/SatelliteSystem/controller/*.java     Exp2/SatelliteSystem/*.java

## How to Run
From project root :
  java -cp Exp2/bin SatelliteSystem.Main
## Compile and Run
In simpler manner : start Debug and Run (VSCode)

## 💻 Sample Usage
# Initial Setup
 <img width="940" height="88" alt="image" src="https://github.com/user-attachments/assets/1ec80a15-efd0-4f52-b5ad-00776f727f54" />
# Basic Requirements 
<img width="940" height="209" alt="image" src="https://github.com/user-attachments/assets/ebd4b614-cf2b-4f45-a0b3-f5c53e14a700" />
# Additional Features
<img width="940" height="379" alt="image" src="https://github.com/user-attachments/assets/cca512d0-a96b-4fc9-b790-cdee93eb8181" />
# Exception Handling
<img width="940" height="219" alt="image" src="https://github.com/user-attachments/assets/8faf9cfe-2186-4758-9822-f7691d949aaf" />

---






🚀 EcoTech — Smart E-Waste Management Desktop System

EcoTech is an advanced desktop application designed to modernize and digitize the process of electronic-waste management.
The system enables organizations to collect, evaluate, categorize, and track e-waste devices efficiently, ensuring smarter recycling operations and supporting sustainability goals.

Built using Java Swing + MVC Architecture, EcoTech focuses on clean design, strong modularity, and a scalable backend structure ready for further expansion.

✨ Key Features
🔧 Device Registration & Intake

Add devices with full specifications

Record condition, storage, RAM, battery health & age

Attach pickup info & customer details

🧠 Automated Evaluation Engine

Calculates recycling value

Determines recyclability/refurbishability

Detects hazardous materials

Assigns final device category:

♻️ Recycle

🛠️ Refurbish

🗑️ Dispose

📊 Data Management

Structured tables

Full CRUD (Create, Read, Update, Delete)

MySQL / SQLite support

Search & filtering

🖥️ Professional Desktop UI (Java Swing)

Table views

Popup dialogs

Sidebar navigation

Clean color theme inspired by modern admin dashboards

🏢 Modules Included

Customers

Pickups

Devices

Employees

Transactions

Partners

Settings

🎯 Mission Statement

EcoTech’s mission is to empower organizations with a smarter, sustainable, and data-driven approach to electronic waste management — helping them reduce environmental impact and optimize recycling workflows.

🏗️ Architecture Overview

EcoTech is built using MVC (Model–View–Controller) for scalability and maintainability.

Model      → Business logic + Data classes + Evaluation engine  
View       → Swing UI (Frames, Panels, Forms)  
Controller → Interaction layer between UI & database

📁 Project Folder Structure
EcoTech/
│
├── src/
│   ├── model/
│   │   ├── Device.java
│   │   ├── Customer.java
│   │   ├── Pickup.java
│   │   ├── Employee.java
│   │   ├── Transaction.java
│   │   ├── Partner.java
│   │   └── EvaluationEngine.java
│   │
│   ├── controller/
│   │   ├── DeviceController.java
│   │   ├── CustomerController.java
│   │   ├── PickupController.java
│   │   └── AuthController.java
│   │
│   ├── view/
│   │   ├── LoginFrame.java
│   │   ├── DashboardFrame.java
│   │   ├── CustomersPanel.java
│   │   ├── DevicesPanel.java
│   │   ├── EmployeesPanel.java
│   │   ├── TransactionsPanel.java
│   │   └── PartnersPanel.java
│   │
│   ├── database/
│   │   ├── DatabaseConnection.java
│   │   ├── DeviceDAO.java
│   │   └── CustomerDAO.java
│   │
│   └── util/
│       ├── Validator.java
│       └── UIStyling.java
│
├── assets/
│   ├── icons/
│   └── logo.png
│
└── README.md

🧩 UML Diagrams (Mermaid – GitHub Rendered)
📘 Class Diagram
classDiagram
    class Device {
        +String id
        +String type
        +String condition
        +String brand
        +String model
        +int ageMonths
        +double recyclingValue
        +boolean refurbishable
    }

    class EvaluationEngine {
        +double calculateValue(Device)
        +boolean checkRefurbish(Device)
        +double checkHazard(Device)
    }

    class DeviceDAO {
        +add(Device)
        +update(Device)
        +delete(String)
        +getAll()
    }

    class DeviceController {
        +registerDevice()
        +evaluateDevice()
        +loadDevices()
    }

    class DashboardFrame
    class DevicesPanel
    
    DeviceController --> Device
    DeviceController --> DeviceDAO
    DeviceController --> EvaluationEngine
    DashboardFrame --> DevicesPanel

📙 Use Case Diagram
flowchart TD
    User((Operator)) --> UC1[Add Device]
    User --> UC2[View Device List]
    User --> UC3[Edit Device]
    User --> UC4[Manage Pickups]
    User --> UC5[Record Transactions]

    UC1 --> UC6[Evaluate Device]
    UC6 --> UC7[Assign Category]

📗 Sequence Diagram (Device Registration)
sequenceDiagram
    participant User
    participant UI as AddDeviceForm
    participant Controller as DeviceController
    participant Engine as EvaluationEngine
    participant DAO as DeviceDAO

    User ->> UI: Enter device data
    UI ->> Controller: submit()
    Controller ->> Engine: evaluate(device)
    Engine -->> Controller: evaluation results
    Controller ->> DAO: save(device)
    DAO -->> Controller: success
    Controller -->> UI: show confirmation

🔧 Installation & Setup
1️⃣ Clone Repository
git clone https://github.com/yourusername/EcoTech.git

2️⃣ Configure Database

Import database.sql

Add credentials in DatabaseConnection.java

3️⃣ Run the Application

Open in IntelliJ / NetBeans and run Main.java.

🚧 Future Enhancements

AI-based valuation model

Cloud synchronization

QR-based device tracking

Admin analytics dashboard

Automated report generation

📄 License

MIT License — free to use, modify, and distribute.

🤝 Contributing

Pull requests are welcome.
Please open an issue for major changes.

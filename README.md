# EmployeeDepartment-API
A Spring Boot REST API to manage **Employees** and **Departments** with CRUD operations, validations, and exception handling.

# Images Uploaded
All the api end-point result images are inside the resources -> static folder

# **Project Structure**
employee-department-api/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.employee.employeeDepartment/
│ │ │ ├── controller/
│ │ │ ├── entity/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── exception/
│ │ └── resources/
│ │ ├── application.properties
│ │ ├── application-dev.properties
│ │ ├── application-prod.properties
│ │ └── static/
│ │ └── images/
│ └── test/
│ └── java/
│ └── com.employee.employeeDepartment/
├── .gitignore
└── README.md

## **Database**
- PostgreSQL
- Tables: `department`, `employee`
- Relationships: One department can have many employees.

## **API Endpoints**

### **Departments**
| Method | Endpoint               | Description                |
|--------|-----------------------|----------------------------|
| POST   | /departments          | Add a new department       |
| GET    | /departments          | Get all departments        |
| GET    | /departments/{id}     | Get department by ID       |
| PUT    | /departments/{id}     | Update department          |
| DELETE | /departments/{id}     | Delete department          |

### **Employees**
| Method | Endpoint               | Description                |
|--------|-----------------------|----------------------------|
| POST   | /employees            | Add a new employee         |
| GET    | /employees            | Get all employees          |
| GET    | /employees/{id}       | Get employee by ID         |
| PUT    | /employees/{id}       | Update employee            |
| DELETE | /employees/{id}       | Delete employee            |


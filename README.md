# 🏦 **Online Banking System**

**Objective:**

To provide a secure and user-friendly online platform for customers and bank employees to manage banking operations digitally. The system supports essential banking tasks such as transactions, account management, and employee-level operations in a role-based secure environment.

📝 **Project Overview**

The Online Banking System is a Java application that allows customers and bank employees to perform banking operations through a centralized dashboard.

### 👤 Customer Features
- Login using customer credentials.
- Transfer money by entering recipient details, amount, and a secure PIN.
- Add and manage bank accounts.
- Check current account balances.

### 👨‍💼 Employee Features
- Login using employee credentials.
- Credit money directly into any customer's bank account.
- Use the system as a customer (if they have their own account).
- Perform standard customer operations as well.

### ⭐ Key Highlights
- Role-based access control (Customer and Employee separation).
- PIN-based transaction security.
- Clean UI and simple flow for ease of use.
- Real-time updates and confirmations.


🧰 **Technologies Used**

 Frontend             : AWT and Swing                        
 Backend              : Java                                 
 Database             : SQL                                  
 Database Access      : JDBC (Java Database Connectivity)    
 Development Tools    : Eclipse        

--

⚙️ **How It Works**

1. **Authentication:**
   - Users log in as either a customer or an employee.
   - Employee credentials provide access to additional features.

2. **Dashboard:**
   - After login, users are directed to a dashboard based on their role.
   - Customers can initiate transactions, add accounts, and check balances.
   - Employees can credit customer accounts and access their own accounts.

3. **Transaction Logic:**
   - Users input recipient, amount, and PIN.
   - PIN validation is done before executing the transaction.
   - Successful operations generate confirmation messages.

4. **Database Interaction:**
   - All data (accounts, transactions, users) is stored in a SQL database.
   - JDBC is used for database connectivity.

---

🚀 **Future Improvements**

- Add mini-statements and transaction history.
- Integrate email/SMS notifications.
- Implement password recovery/reset functionality.
- Improve UI with modern frontend frameworks.

---

🙋‍♂️ **About the Developer**

**Waddepally Varun**  
Java Full Stack Developer | Passionate about building secure and scalable applications.



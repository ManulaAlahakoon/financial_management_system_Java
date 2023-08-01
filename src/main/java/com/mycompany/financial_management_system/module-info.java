module com.mycompany.financial_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.financial_management_system to javafx.fxml;
    exports com.mycompany.financial_management_system;
    opens com.mycompany.financial_management_system.MySQL_Connection;
}

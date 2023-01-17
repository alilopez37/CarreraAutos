module com.example.carreraautos {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.carreraautos to javafx.fxml;
    exports com.example.carreraautos;
}
module com.example.havadurumuveriyapilari {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.havadurumuveriyapilari to javafx.fxml;
    exports com.example.havadurumuveriyapilari;
}
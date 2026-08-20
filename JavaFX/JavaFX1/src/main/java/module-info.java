module com.example.application {
    // 1. Informa ao Java que este projeto necessita do toolkit JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    // 2. Abre o seu pacote para que o Scene Builder (FXMLLoader) consiga ler suas telas
    opens com.example.application to javafx.fxml;

    // 3. Exporta o seu pacote para que a JVM consiga rodar a interface gráfica
    exports com.example.application;
    exports com.example.gui;
    opens com.example.gui to javafx.fxml;
}

module com.example.petrescue {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.net.http;
    requires java.sql;
    requires jackson.core.asl;
    requires jackson.mapper.asl;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires annotations;
    requires org.postgresql.jdbc;
    requires hibernate.entitymanager;
    requires java.naming;


    opens com.example.petrescue to javafx.fxml;
    exports com.example.petrescue;
    exports com.example.petrescue.scene;
    opens com.example.petrescue.scene to javafx.fxml;
    exports com.example.petrescue.controller;
    opens com.example.petrescue.controller to javafx.fxml;
    exports com.example.petrescue.dto;
    exports com.example.petrescue.event;
    opens com.example.petrescue.event to javafx.fxml;
    opens com.example.petrescue.models to org.hibernate.orm.core;
}
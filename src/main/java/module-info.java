module sunat.gob.pe.airbnfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens sunat.gob.pe.airbnfx;
    opens sunat.gob.pe.airbnfx.controller;
    exports sunat.gob.pe.airbnfx;
}

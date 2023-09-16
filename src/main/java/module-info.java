module sunat.gob.pe.airbnfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    opens sunat.gob.pe.airbnfx;
    opens sunat.gob.pe.airbnfx.controller;
    exports sunat.gob.pe.airbnfx;
}

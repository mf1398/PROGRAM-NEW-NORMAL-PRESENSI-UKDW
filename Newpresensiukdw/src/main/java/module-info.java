module Newpresensiukdw.local.local {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires sqlite.jdbc;
    requires jasperreports;
    
    opens Newpresensiukdw.local to javafx.fxml;
    exports Newpresensiukdw.local;
}

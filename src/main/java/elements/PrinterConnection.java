package elements;

import javax.persistence.*;

@Entity
@Table(name = "printer_connection")
public class PrinterConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="connection")
    private String connection;

    public PrinterConnection() {
    }

    public PrinterConnection(String connection) {
        this.connection = connection;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }
}

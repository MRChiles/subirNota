package controlador;



import modelo.dao.AccountDAO;
import modelo.dao.AccountDAOSQL;
import modelo.dto.Account;
import org.bson.types.ObjectId;
import vista.AccountVista;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


public class Controlador {
    private ModeloTabla modeloTabla;
    private AccountVista accountVista;
    private AccountDAO accountDAO = new AccountDAOSQL();

    public Controlador(ModeloTabla modeloTabla, AccountVista accountVista) throws IOException, SQLException {
        this.modeloTabla = modeloTabla;
        this.accountVista = accountVista;
        generarTabla();
        registrarEventos();

    }
    private void generarTabla() { accountVista.getTable1().setModel(modeloTabla);
    }
    private void registrarEventos() {
        accountVista.getBorrarButton().addActionListener(e -> {
            try {
                borrarFila();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            accountVista.getCancelarButton().addActionListener(i -> hideAdd());
            accountVista.getAceptarButton().addActionListener(i -> guardarCuenta());
            accountVista.getAnnadirButton().addActionListener(i -> addRow());

        });
    }

    private void addRow() {
        accountVista.getPanelDerecho().setVisible(true);
    }

    private void guardarCuenta() {
        ObjectId id = new ObjectId();
        String iban = accountVista.getIban().getText();
        String cCard = accountVista.getCreditCard().getText();
        Double balance = Double.valueOf(accountVista.getBalance().getText());
        String name = accountVista.getFullName().getText();
        String date = LocalDate.now().toString();

        //añadimos la cuenta a la lista
        Account cuenta = new Account(id,iban,cCard,balance,name,date);
        modeloTabla.addRow(cuenta);
        hideAdd();
    }

    private void hideAdd() {
        accountVista.getPanelDerecho().setVisible(false);
        accountVista.getIban().setText("");
        accountVista.getCreditCard().setText("");
        accountVista.getBalance().setText("");
        accountVista.getFullName().setText("");
    }

    private void borrarFila() throws SQLException {
        int selectedRow = accountVista.getTable1().getSelectedRow();
        int r = accountVista.getTable1().convertRowIndexToModel(selectedRow);
        modeloTabla.removeRow(r);
    }


}

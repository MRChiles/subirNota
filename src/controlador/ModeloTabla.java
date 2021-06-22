package controlador;

import modelo.dao.AccountDAO;
import modelo.dao.AccountDAOSQL;
import modelo.dto.Account;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

public class ModeloTabla extends AbstractTableModel {

    private AccountDAO dao = new AccountDAOSQL();
    private List<Account> listarCuenta;
    private String[] cabecera = {"ID", "IBAN", "CREDITCAR", "BALANCE", "NOMBRECOMPLETO","FECHA"};


    public ModeloTabla() throws IOException, SQLException {
        this.listarCuenta = dao.obtenerTodasCuentas();
    }




    @Override
    public int getRowCount() { return listarCuenta.size(); }

    @Override
    public int getColumnCount() {return cabecera.length; }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return listarCuenta.get(row).getId();
            case 1:
                return listarCuenta.get(row).getIban();
            case 2:
                return listarCuenta.get(row).getCreditCar();
            case 3:
                return listarCuenta.get(row).getBalance();
            case 4:
                return listarCuenta.get(row).getFullName();
            case 5:
                return listarCuenta.get(row).getDate();
        }
        return "Error";
    }

    @Override
    public String getColumnName(int column) {
        return cabecera[column];
    }


    public void removeRow(int r) throws SQLException {
    dao.obtenerTodasCuentas();
    if (r < 0)
        dao.borrarCuenta(listarCuenta.get(r).getId().toString());
    listarCuenta.remove(r);
    fireTableDataChanged();
    }

    public void addRow(Account cuenta) {
        dao.insertarCuenta(cuenta);
        listarCuenta.add(cuenta);
        fireTableDataChanged();
    }
}

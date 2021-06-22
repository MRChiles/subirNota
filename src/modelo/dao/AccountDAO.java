package modelo.dao;

import modelo.dto.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {
    List<Account> obtenerTodasCuentas() throws SQLException;
    boolean borrarCuenta (String idCuenta);
    boolean insertarCuenta(Account cuentaSinID);
    void actualizarCuentaPorID(Account cuentaConID);
}

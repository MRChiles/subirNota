import controlador.Controlador;
import controlador.ModeloTabla;
import vista.AccountVista;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    ModeloTabla modeloTabla = new ModeloTabla();
                    AccountVista accountVista = new AccountVista();
                    new Controlador(modeloTabla,accountVista);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                //invocamos al modelo, vista y controlador
            }
        });
    }
}

package modelo.dao;

import Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import modelo.dto.Account;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import static com.mongodb.client.model.Filters.eq;

public class AccountDAOSQL implements AccountDAO{
    private MongoDatabase conexion = Conexion.getInstance().getDataBase();
    private MongoCollection collection = conexion.getCollection("accounts");

    public AccountDAOSQL() throws IOException, SQLException {
    }

    @Override
    public List<Account> obtenerTodasCuentas() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        conexion.getCollection("accounts").find().forEach((Consumer<Document>) (Document d) -> {
                accounts.add(new Account(
                        d.getObjectId("_id"),
                        d.getString("iban"),
                        d.getString("creditCar"),
                        d.getDouble("balance"),
                        d.getString("fullName"),
                        d.getString("date")
                ));


        });

        return accounts;
    }

    @Override
    public boolean borrarCuenta(String idCuenta) {

        //Borrar
        Document document = new Document();
        collection.deleteOne(document.append("_id", new ObjectId(idCuenta)));
        return collection.deleteOne(document).getDeletedCount()!= 0;
    }

    @Override
    public boolean insertarCuenta(Account cuentaSinID) {
        long numInicial = collection.countDocuments();
        Document document = new Document();
        document.append("iban",cuentaSinID.getIban());
        document.append("creditCard", cuentaSinID.getCreditCar());
        document.append("balance", cuentaSinID.getBalance());
        document.append("fullName", cuentaSinID.getFullName());
        document.append("date", cuentaSinID.getDate());
        collection.insertOne(document);
        long numFinal = collection.countDocuments();
        return (numFinal - numInicial) != 0;

    }

    @Override
    public void actualizarCuentaPorID(Account cuentaConID) {
        collection.updateOne(Filters.eq("_id", cuentaConID.getId()),Updates.combine(
                Updates.set("iban",cuentaConID.getIban()),
                Updates.set("creditCard",cuentaConID.getCreditCar()),
                Updates.set("balance",cuentaConID.getBalance()),
                Updates.set("fullName",cuentaConID.getFullName())
        ));
    }

    public static void main(String[] args) throws IOException, SQLException {
        AccountDAO accountDAO = new AccountDAOSQL();
        System.out.println(accountDAO.obtenerTodasCuentas());
    }
}

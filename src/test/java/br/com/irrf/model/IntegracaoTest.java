/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrf.model;

import br.com.irrfweb.dao.CalculoDAO;
import br.com.irrfweb.model.Calculo;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.util.List;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Renan
 */
public class IntegracaoTest {

    @Before
    public void init() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    private IDataSet getDataSetDB(IDatabaseConnection connection, String nomeDataSet) throws Exception {

        IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream(nomeDataSet));
        return fullDataSet;
    }

    private IDataSet getDataSetFile(String nomeDataSet) throws Exception {
        return new FlatXmlDataSetBuilder().build(new File(nomeDataSet));
    }

    private IDatabaseConnection getConnection() throws Exception {
        // Realiza a conexão com o banco de dados
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/irrf", "root", "");
        IDatabaseConnection connection = new DatabaseConnection(conexao);

        return connection;
    }

    public void testeGetAllCalculos() throws Exception {

        String nomeDataSet = "Calculo.xml";

        //Insere dados de um dataSet no banco de dados
        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSetFile(nomeDataSet));

        //Armazena todos os itens do banco de dados
        CalculoDAO dao = new CalculoDAO();
        List<Calculo> dadosDoBanco = dao.getAllCalculos();

        //Transforma um dataSet em um ITable para contabilizar cada linha como uma entrada
        ITable expectedTable = getDataSetFile(nomeDataSet).getTable("calculo");

        //Verifica se o mesmo numero de entradas no dataSet estão presentes no Banco
        assertEquals(expectedTable.getRowCount(), dadosDoBanco.size());
    }
}

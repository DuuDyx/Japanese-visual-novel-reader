package com.jpvnreader.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
private Connection connection = null;

    public Database(){
        String url =  "jdbc:sqlite:Dictionary.db";

        try {
            connection = DriverManager.getConnection(url);
            var stmt = connection.createStatement();
            stmt.execute("PRAGMA foreign_keys = ON;");

            String sqlPalavras = "CREATE TABLE IF NOT EXISTS palavras (" +
                    "id INTEGER PRIMARY KEY," +
                    "forma_kana_principal TEXT" +
                    ");";

            String sqlSentidos = "CREATE TABLE IF NOT EXISTS sentidos (" +
                    "id INTEGER PRIMARY KEY," +
                    "id_palavras INTEGER," +
                    " FOREIGN KEY (id_palavras) references palavras(id)" +
                    ");";

            String sqlFormasKanji = "CREATE TABLE IF NOT EXISTS formas_kanji (" +
                    "id INTEGER PRIMARY KEY," +
                    "texto TEXT," +
                    "id_palavras INTEGER," +
                    "Foreign key (id_palavras) references palavras(id)" +
                    ");";

            String sqlLeituras = "CREATE TABLE IF NOT EXISTS leituras (" +
                    "id INTEGER PRIMARY KEY," +
                    "id_palavras INTEGER," +
                    "leitura TEXT," +
                    "Foreign key (id_palavras) references palavras(id)" +
                    ");";

            String sqlClasses = "CREATE TABLE IF NOT EXISTS classes_gramaticais (" +
                    "id INTEGER PRIMARY KEY," +
                    "id_sentidos INTEGER," +
                    "classe TEXT," +
                    "Foreign key (id_sentidos) references sentidos(id)" +
                    ");";

            String sqlTraducoes = "CREATE TABLE IF NOT EXISTS traducoes (" +
                    "id INTEGER PRIMARY KEY," +
                    "traducao TEXT," +
                    "id_sentidos INTEGER," +
                    "Foreign key (id_sentidos) references sentidos(id)" +
                    ");";


            stmt.addBatch(sqlPalavras);
            stmt.addBatch(sqlSentidos);
            stmt.addBatch(sqlTraducoes);
            stmt.addBatch(sqlFormasKanji);
            stmt.addBatch(sqlLeituras);
            stmt.addBatch(sqlClasses);
            stmt.executeBatch();
            System.out.println("DB RAN SUCESSFULLY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

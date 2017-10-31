package com.Tunes_Developers;

import com.Tunes_Developers.Models.ColumnType;
import com.Tunes_Developers.Models.FakerItem;
import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Utils.DecodeFakerItem;
import com.Tunes_Developers.Utils.EngineDecoder;
import com.sun.javafx.tk.Toolkit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

/**
 * Created by Geoffrey-Kimani on 10/16/2017.
 */
public class InsertBackground extends Thread{

    private int nbRows;
    private String clmFormart;
    ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
    ObservableList<ColumnType> columns = FXCollections.observableArrayList();
    ObservableList<FakerItem> fakerItems = FXCollections.observableArrayList();
    Table table;

    public InsertBackground(ObservableList<ColumnType> columns,ObservableList<ObservableList<String>> data,
                            ObservableList<FakerItem> fakerItems,Table table, String clmFormart,int nbRows) {
        this.columns = columns;
        this.data = data;
        this.fakerItems = fakerItems;
        this.clmFormart = clmFormart;
        this.table = table;
        this.nbRows = nbRows;
    }

    public void setNbRows(int nbRows) {
        this.nbRows = nbRows;
    }

    private void insertRows(String columns, String data) throws Exception {
        //Find the specified create statement
        String query = table.getEngineModel().getInsertMultipleFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {table.getTableName(),columns,data};
        query = EngineDecoder.replace(details,parameters,query);

        table.getDatabase().getStatement().execute(query);
    }

    private String generateData(int nbRows) {
        String dataFormat = "";
        DecodeFakerItem decoder = new DecodeFakerItem(fakerItems);
        data = decoder.generateData(nbRows);

        for (int i=0;i<nbRows;i++) {
            ObservableList<String> row = data.get(i);
            String rowData = "";

            for (int j=0;j<row.size();j++) {
                if (columns.get(j).isString()) {
                    rowData += "'"+row.get(j)+"'";
                } else {
                    rowData += row.get(j);
                }

                if (j < row.size() - 1) {
                    rowData += ", ";
                }
            }

            rowData = "("+rowData+")";

            if (i < nbRows - 1) {
                rowData += ", ";
            }else{
                rowData += " ";
            }

            dataFormat += rowData;
        }

        return dataFormat;
    }

    @Override
    public void run() {
        try {
            if (nbRows > 5000) {
                int iterations = (int) nbRows / 5000;
                int remainder = nbRows % 5000;

                for (int i = 0; i < iterations; i++) {
                    insertRows(clmFormart, generateData(5000));
                }

                if (remainder > 0) {
                    insertRows(clmFormart, generateData(remainder));
                }
            } else {
                    insertRows(clmFormart, generateData(nbRows));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

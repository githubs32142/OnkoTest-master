/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Class;

import projekt.Interface.Operation;
import projekt.Interface.ReadData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Admin
 */
public class TList implements ReadData, Operation {

    private List<TObject> listRiskFactor = new ArrayList<>();

    public TList() {
    }

    public TList(String path) {
        readData(path);
    }

    @Override
    public String readInput(String path) {
        StringBuilder buffer = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            try (Reader in = new BufferedReader(isr)) {
                int ch;
                while ((ch = in.read()) > -1) {
                    buffer.append((char) ch);
                }
            }
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void readData(String path) {
        listRiskFactor.clear();
        String line = readInput(path);
        StringTokenizer st = new StringTokenizer(line, "-;");
        boolean count = true;
        while (st.hasMoreElements()) {
            if (count) {
                listRiskFactor.add(new TObject());
                listRiskFactor.get(listRiskFactor.size() - 1).setFactor(st.nextElement().toString());
            } else {
                listRiskFactor.get(listRiskFactor.size() - 1).setAlias(st.nextElement().toString());
                // System.out.println(listRiskFactor.get(listRiskFactor.size() - 1).getAlias());
                //  System.out.println(st.nextElement().toString());
            }
            count = !count;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < listRiskFactor.size(); i++) {
            str.append(listRiskFactor.get(i).getAlias()).append("\n");
        }
        return str.toString();

    }

    @Override
    public boolean contains(String s) {
        for (int i = 0; i < listRiskFactor.size(); i++) {
            if (listRiskFactor.get(i).getFactor().equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String makeAssert(String s) {

        StringBuilder str = new StringBuilder();
        str.append("( assert ( ").append(s);
        for (int i = 0; i < listRiskFactor.size(); i++) {
            str.append("( ").append(listRiskFactor.get(i).getAlias()).append(" ").append(listRiskFactor.get(i).getAddedString()).append(" ) ");
        }
        str.append(") )");
        return str.toString();
    }

    @Override
    public void makeOperation(List<String> list) {
        for (int i = 0; i < listRiskFactor.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (EqualString.equals(listRiskFactor.get(i).getFactor(), list.get(j))) {
                    listRiskFactor.get(i).setIsAdded(true);
                }
            }
        }
    }

}

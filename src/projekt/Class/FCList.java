/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Class;

import projekt.Interface.ReadData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Admin
 */
public class FCList implements ReadData {

    List<FCObject> list = new ArrayList<>();

    public FCList(String path) {
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
        list.clear();
        String line = readInput(path);
        StringTokenizer st = new StringTokenizer(line, "-;:");
        int count = 0;
        while (st.hasMoreElements()) {
            switch (count % 3) {
                case 0: {
                    list.add(new FCObject());
                    list.get(list.size() - 1).setFamily(st.nextElement().toString());
                }
                break;
                case 1: {
                    list.get(list.size() - 1).setCancer(st.nextElement().toString());
                }
                break;
                case 2: {
                    list.get(list.size() - 1).setAlians(st.nextElement().toString());
                }
                break;
            }
            count++;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            //  str.append(list.get(i).getFamily()).append(" ").append(list.get(i).getCancer()).append(" ").append(list.get(i).getAlians());
            str.append("(slot ").append(list.get(i).getAlians()).append(")\n");
        }
        return str.toString();
    }

    public boolean contains(CancerFamilly cf) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCancer().equals(cf.getCancer()) && list.get(i).getFamily().equals(cf.getFamilly())) {
                return true;
            }
        }
        return false;
    }

    public String makeAssert(String s) {
        StringBuilder str = new StringBuilder();
        str.append("( assert ( ").append(s);
        for (int i = 0; i < list.size(); i++) {
            str.append("( ").append(list.get(i).getAlians()).append(" ").append(list.get(i).getAddedString()).append(" ) ");
        }
        str.append(") )");
        return str.toString();
    }

    public void makeOperation(List<CancerFamilly> list) {
        int tmp = 0;
        for (int i = 0; i < this.list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (EqualString.equals(this.list.get(i).getCancer(), list.get(j).getCancer()) && EqualString.equals(this.list.get(i).getFamily(), list.get(j).getFamilly())) {
                    this.list.get(i).setAdded(true);
                }
                tmp++;
            }
        }
        System.out.println("ilość operacji " + tmp);
    }

    public int size() {
        return this.list.size();
    }

    public String getAlias(int i) {
        return list.get(i).getAlians();
    }

}

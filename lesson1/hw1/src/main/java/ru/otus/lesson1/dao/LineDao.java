package ru.otus.lesson1.dao;

import java.util.Map;
import java.util.Set;

public class LineDao implements LineI {
    private Map<String, Set<String>> list;

//    File file = new File("q.csv");

  /*  public LineDao(File file) {
        this.file = file;
    }*/

    @Override
    public String nextLine() {
        return null;
    }

    public void setList(Map list) {
        this.list = list;
    }

    public Map getList() {
        return list;
    }
}

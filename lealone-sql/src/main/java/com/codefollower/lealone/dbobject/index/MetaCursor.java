/*
 * Copyright 2004-2011 H2 Group. Multiple-Licensed under the H2 License,
 * Version 1.0, and under the Eclipse Public License, Version 1.0
 * (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package com.codefollower.lealone.dbobject.index;

import java.util.ArrayList;

import com.codefollower.lealone.message.DbException;
import com.codefollower.lealone.result.Row;
import com.codefollower.lealone.result.SearchRow;

/**
 * An index for a meta data table.
 * This index can only scan through all rows, search is not supported.
 */
public class MetaCursor implements Cursor {

    private Row current;
    private final ArrayList<Row> rows;
    private int index;

    MetaCursor(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public Row get() {
        return current;
    }

    public SearchRow getSearchRow() {
        return current;
    }

    public boolean next() {
        current = index >= rows.size() ? null : rows.get(index++);
        return current != null;
    }

    public boolean previous() {
        throw DbException.throwInternalError();
    }

}

package org.jooq.impl;

import org.jooq.*;

public class AbstractTableImplMod<R extends Record> extends org.jooq.impl.TableImpl<R> {
    public AbstractTableImplMod(String name, Schema schema, Table<R> aliased) {
        super(name, schema, aliased);
    }


    protected <R extends Record, T> TableField<R, T> createFieldScala(String name, DataType<T> type, Table<R> table) {
        final TableFieldImpl<R, T> tableField = new TableFieldImpl<R, T>(name, type, table);

        // [#1199] The public API of Table returns immutable field lists
        if (table instanceof TableImpl) {
            ((TableImpl<?>) table).fields0().add(tableField);
        }

        return tableField;
    }

}
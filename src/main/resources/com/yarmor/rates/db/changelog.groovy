package com.yarmor.rates.db

databaseChangeLog {

    changeSet(id: '1', author: 'yarki95@gmail.com') {
        createTable(name: 'systems') {
            column(name: 'id', type: 'uuid') {
                constraints(primaryKey: true)
            }
            column(name: 'name', type: 'varchar(128)')
            column(name: 'url', type: 'text')
        }

        createTable(name: 'currencies') {
            column(name: 'id', type: 'varchar(3)') {
                constraints(primaryKey: true)
            }
            column(name: 'name', type: 'text')
            column(name: 'number', type: 'int(3)')
        }

        createTable(name: 'rates') {
            column(name: 'base_currency_id', type: 'varchar(3)') {
                constraints(referencedTableName: 'currencies', referencedColumnNames: 'id')
            }
            column(name: 'foreign_currency_id', type: 'varchar(3)') {
                constraints(referencedTableName: 'currencies', referencedColumnNames: 'id')
            }
            column(name: 'value', type: 'numeric(5,11)')
            column(name: 'inverse_value', type: 'numeric(5,11)')
            column(name: 'retrieved_at', type: 'timestampz')
            column(name: 'system_id', type: 'uuid') {
                constraints(referencedTableName: 'systems', referencedColumnNames: 'id')
            }
        }

        //how to check that table consists exchange rate for either UAH/USD or USD/UAH
        addPrimaryKeyConstraint(tableName: 'rate', columnNames: 'base_currency_id, foreign_currency_id')

        createTable(name: 'archived_rates') {
            column(name: 'id', type: 'uuid')
            column(name: 'base_currency_id', type: 'varchar(3)') {
                constraints(referencedTableName: 'currencies', referencedColumnNames: 'id')
            }
            column(name: 'foreign_currency_id', type: 'varchar(3)') {
                constraints(referencedTableName: 'currencies', referencedColumnNames: 'id')
            }
            column(name: 'value', type: 'numeric(5,11)')
            column(name: 'inverse_value', type: 'numeric(5,11)')
            column(name: 'retrieved_at', type: 'timestampz')
            column(name: 'system_id', type: 'uuid') {
                constraints(referencedTableName: 'systems', referencedColumnNames: 'id')
            }
        }

    }
}
CREATE KEYSPACE financial_poc WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

use financial_poc;

CREATE TABLE financial_poc.financialtransaction (
    id uuid PRIMARY KEY,
    accountname text,
    accountnumber text,
    amount decimal,
    cardnumber text,
    createddate timestamp,
    transactiontype text
);

CREATE INDEX financialtransaction_accountnumber_idx ON financialtransaction (accountnumber);
CREATE INDEX financialtransaction_amount_idx ON financialtransaction (amount);
CREATE INDEX financialtransaction_transactiontype_idx ON financialtransaction (transactiontype);




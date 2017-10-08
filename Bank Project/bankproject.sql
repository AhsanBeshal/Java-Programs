-- Author @Ahsan Beshal
-- This is a database for the customers in the bank project.

-- Side note/ We have a customers table which has a primary key that returns a row of 
-- acctid, firstname, lastname. In the balance table we have balance for each
-- of those customers in the customers table. That is why a unique primary key was
-- chosen in customers which was acctid. It was used in balances table as primary key 
-- so we can get a row of acctid, balance for a customer in the customers table. Foreign
-- because it belongs to another table and we are using it in a different table. 

-- Side note/ Primary key a unique attribute that returns a row in a table. 
-- Side note/ Foreign key is used if a primary key is used in another table.
 

drop table if exists balances;
drop table if exists customers;

create table customers (

	acctid int primary key,
	firstname text,
	lastname text
	
);

create table balances (

	acctid int references customers(acctid),
	balance numeric(10,2),
	primary key(acctid)
	
);

insert into customers(acctid, firstname, lastname) values (1563, 'Jorge', 'Polo');
insert into customers(acctid, firstname, lastname) values (1843, 'Leno', 'Sutte');
insert into customers(acctid, firstname, lastname) values (1465, 'Shah', 'Ali');
insert into customers(acctid, firstname, lastname) values (1353, 'George', 'Lopez');
insert into customers(acctid, firstname, lastname) values (1498, 'Leo', 'Minaj');

insert into balances(acctid, balance) values (1563, 0);
insert into balances(acctid, balance) values (1843, -56);
insert into balances(acctid, balance) values (1465, 7890);
insert into balances(acctid, balance) values (1353, 10000);
insert into balances(acctid, balance) values (1498, 897);

-- Find the firstname, lastname, acctid and balance for account 1843
select firstname, lastname, balances.acctid, balances.balance from customers, balances 
	where customers.acctid = balances.acctid and balances.acctid = 1498
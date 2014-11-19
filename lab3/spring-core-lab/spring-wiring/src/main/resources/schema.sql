create table transactions(
	id int IDENTITY,
	accountNumber varchar(255) NOT NULL,
	date timestamp NOT NULL,
	amount decimal NOT NULL
);
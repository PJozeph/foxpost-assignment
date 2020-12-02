create table clients (
   id integer not null AUTO_INCREMENT,
   client_name varchar(255) not null, 
   address varchar(255) not null,
   zip_code varchar(255) not null,
   city varchar(255) not null,
   phone varchar(255) not null,
   email varchar(255) not null,
   PRIMARY KEY(id)
);

CREATE TABLE parcels (
    id integer NOT NULL AUTO_INCREMENT,
	parcel_no varchar(255) not null,
	sender_id integer NOT NULL,
	reciver_id integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (sender_id) REFERENCES clients(id),
	FOREIGN KEY (reciver_id) REFERENCES clients(id)
);

CREATE TABLE events (
    id integer NOT NULL AUTO_INCREMENT,
	event_name varchar(255) not null,
    PRIMARY KEY (id)
);

CREATE TABLE trackings (
    id integer NOT NULL AUTO_INCREMENT,
	parcel_id integer NOT NULL,
	event_id integer NOT NULL,
	event_date TIMESTAMP not null,
	PRIMARY KEY (id),
    FOREIGN KEY (parcel_id) REFERENCES parcels(id),
	FOREIGN KEY (event_id) REFERENCES events(id)
);


INSERT INTO CLIENTS (id,client_name, address, zip_code, city, phone, email) VALUES (1, 'Nagy Eszter', 'Hegedüs Gyula utca 44', '1098', 'Budapest', '06301234567', 'eszti@gmail.com');
INSERT INTO CLIENTS (id,client_name, address, zip_code, city, phone, email) VALUES (2, 'Molnár Bianka', 'Mester utca 33', '1098', 'Budapest', '06301234567', 'bia@gmail.com');
INSERT INTO CLIENTS (id,client_name, address, zip_code, city, phone, email) VALUES (3, 'Nagy Zoltán', 'Nyilas utca 102', '1098', 'Budapest', '06301234567', 'zoltan@gmail.com');
INSERT INTO CLIENTS (id,client_name, address, zip_code, city, phone, email) VALUES (4, 'Kasza Anna', 'Nyíri utca 56', '1098', 'Budapest', '06301234567', 'anna@gmail.com');

INSERT INTO PARCELS (id, parcel_no, sender_id, reciver_id) VALUES (1, 'fp01', 1, 2);
INSERT INTO PARCELS (id, parcel_no, sender_id, reciver_id) VALUES (2, 'fp02', 2, 3);
INSERT INTO PARCELS (id, parcel_no, sender_id, reciver_id) VALUES (3, 'fp03', 1, 4);
INSERT INTO PARCELS (id, parcel_no, sender_id, reciver_id) VALUES (4, 'fp04', 3, 2);


INSERT INTO EVENTS (id, event_name) VALUES (1, 'CANCEL');
INSERT INTO EVENTS (id, event_name) VALUES (2, 'PAY');
INSERT INTO EVENTS (id, event_name) VALUES (3, 'PLACE_BOX');
INSERT INTO EVENTS (id, event_name) VALUES (4, 'ARRIVED');

INSERT INTO TRACKINGS (id, parcel_id, event_id, event_date) VALUES (1, 1, 4, '2020-11-26 10:14:12.0');
INSERT INTO TRACKINGS (id, parcel_id, event_id, event_date) VALUES (2, 2, 1, '2020-10-26 10:14:12.0');
INSERT INTO TRACKINGS (id, parcel_id, event_id, event_date) VALUES (3, 3, 1, '2020-09-26 10:14:12.0');
INSERT INTO TRACKINGS (id, parcel_id, event_id, event_date) VALUES (4, 2, 2, '2020-05-26 10:14:12.0');

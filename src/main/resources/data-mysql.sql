insert into departments(department_id, name, head_count) values('1048b354-c18f-4109-8282-2a85485bfa5a', 'human resources', 2);

insert into department_positions(department_id, title, code) values('1048b354-c18f-4109-8282-2a85485bfa5a', 'manager', 'hrm1');
insert into department_positions(department_id, title, code) values('2048b354-c18f-4109-8282-2a85485bfa5a', 'associate', 'hra1');


INSERT INTO employees (employee_id, first_name, last_name, email_address, salary, currency, commission_rate, street_address, city, province, country, postal_code, department_id, position_title)
VALUES
    ('EMP001', 'John', 'Doe', 'john.doe@example.com', 50000.00, 'USD', 0.05, '123 Main St', 'Anytown', 'Anyprovince', 'USA', '12345', 'DEPT001', 'Manager'),
    ('EMP002', 'Jane', 'Smith', 'jane.smith@example.com', 60000.00, 'USD', 0.07, '456 Elm St', 'Othertown', 'Otherprovince', 'USA', '67890', 'DEPT002', 'Sales Associate'),
    ('EMP003', 'Alice', 'Johnson', 'alice.johnson@example.com', 45000.00, 'USD', 0.03, '789 Oak St', 'Smalltown', 'Smallprovince', 'USA', '54321', 'DEPT001', 'Administrator');

insert into employee_phonenumbers(employee_id, type, number) values(1, 'WORK', '515-555-5555');
insert into employee_phonenumbers(employee_id, type, number) values(1, 'MOBILE', '514-555-4444');


insert into inventories (inventory_id, type) values ('d846a5a7-2e1c-4c79-809c-4f3f471e826d', 'VEHICLE');
insert into inventories (inventory_id, type) values ('3fe5c169-c1ef-42ea-9e5e-870f30ba9dd0', 'VEHICLE');


insert into vehicles (vehicle_id, inventory_id, status, type, year, manufacturer, make, model, body_class, msrp, cost, total_options_cost) values
      ('JN8AS5MTXDW375966', 'd846a5a7-2e1c-4c79-809c-4f3f471e826d', 'AVAILABLE', 'NEW', 2013, 'NISSAN MOTOR COMPANY, LTD', 'NISSAN', 'Rogue', 'Crossover Utility Vehicle (CUV)', 73536.64, 64330.65, 15470.82);

INSERT INTO vehicle_options (vehicle_id, name, description, cost)
VALUES
    ('JN8AS5MTXDW375966', 'Option 1', 'Description of Option 1', 1000.00),
    ('JN8AS5MTXDW375967', 'Option 2', 'Description of Option 2', 1500.00);


insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('c3540a89-cb47-4c96-888e-ff96708db4d8', 'Alick', 'Ucceli', 'aucceli0@dot.gov', '73 Shoshone Road', 'Barraute', 'Québec', 'Canada', 'P0M 2T6');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('dd1ab8b0-ab17-4e03-b70a-84caa3871606', 'Ricky', 'Presslie', 'rpresslie1@domainmarket.com', '24 Dorton Circle', 'Notre-Dame-des-Prairies', 'Québec', 'Canada', 'K6V 3J2');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('ba6c3e76-366e-44bb-8279-b41dc32dc456', 'Allx', 'Cholmondeley', 'acholmondeley2@weibo.com', '61 Farragut Street', 'Senneterre', 'Québec', 'Canada', 'L0P 1J8');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('45772446-62f4-4ccb-b3f4-9393c186fa43', 'Gaspar', 'Russi', 'grussi3@un.org', '3612 Del Mar Terrace', 'Sainte-Marthe-sur-le-Lac', 'Québec', 'Canada', 'H9K 0W3');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('30a4e2e3-fe9d-4903-bd23-b0a72b6c4ced', 'Hillard', 'Heamus', 'hheamus4@va.gov', '809 Blue Bill Park Park', 'Cowansville', 'Québec', 'Canada', 'J2K P4X');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('2bec7ec2-fe40-474f-a8cd-612f7790d24f', 'Darrin', 'Cadd', 'dcadd5@ning.com', '9 Cambridge Road', 'Havre-Saint-Pierre', 'Québec', 'Canada', 'H4R 1R9');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('6b2214d8-8d17-42f3-82bd-1b9264f19c64', 'Susana', 'Maxfield', 'smaxfield6@themeforest.net', '4509 Mifflin Road', 'Acton Vale', 'Québec', 'Canada', 'G0E N6E');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('a11014c8-85bc-4f8a-b627-7dfd645764ce', 'Elias', 'Plaxton', 'eplaxton7@house.gov', '382 Dorton Terrace', 'London', 'Ontario', 'Canada', 'N6C 2E4');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('13526a90-506f-4981-a9da-06ba21fc610b', 'Ralina', 'Sussex', 'rsussex8@nymag.com', '624 Gale Alley', 'Waterloo', 'Ontario', 'Canada', 'N2L 7K8');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('cc9c2c7f-afc9-46fb-8119-17158e54d02f', 'Pen', 'Carruthers', 'pcarruthers9@gov.uk', '3 4th Terrace', 'Hearst', 'Ontario', 'Canada', 'S4A 8Y2');

insert into customer_phonenumbers(customer_id, type, number) values('c3540a89-cb47-4c96-888e-ff96708db4d8', 'WORK', '515-555-1234');
insert into customer_phonenumbers(customer_id, type, number) values('dd1ab8b0-ab17-4e03-b70a-84caa3871606', 'MOBILE', '416-555-1234');
insert into customer_phonenumbers(customer_id, type, number) values('ba6c3e76-366e-44bb-8279-b41dc32dc456', 'WORK', '515-555-9999');
insert into customer_phonenumbers(customer_id, type, number) values('30a4e2e3-fe9d-4903-bd23-b0a72b6c4ced', 'MOBILE', '416-555-3333');

insert into sales (sale_id, inventory_id, vehicle_id, customer_id, employee_id, amount, currency, sale_status, number_of_monthly_payments, monthly_payment_amount, down_payment_amount, payment_currency, sale_offer_date, warranty_end_date, warranty_terms)
values('05c8ab76-4f75-45c1-b6e2-aa8e914ea08f', 'd846a5a7-2e1c-4c79-809c-4f3f471e826d', 'JN8AS5MTXDW375966', 'c3540a89-cb47-4c96-888e-ff96708db4d8', 'e5913a79-9b1e-4516-9ffd-06578e7af261', 75000.00, 'CAD', 'PURCHASE_OFFER', 36, 1805.56, 10000.00, 'CAN', '2024-2-13', '2027-2-13', 'Basic Warranty: The basic warranty covers the vehicle against defects in materials or workmanship for a specific period, typically around 3 to 5 years.' );

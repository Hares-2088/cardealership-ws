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


insert into inventories (inventory_id, type) values ('JN8AS5MTXDW375966', 'VEHICLE');
insert into inventories (inventory_id, type) values ('3fe5c169-c1ef-42ea-9e5e-870f30ba9dd0', 'VEHICLE');


INSERT INTO vehicle (vehicle_id, make, model, year, status, type, amount, currency, name, price, description, inventory_id)
VALUES ('JN8AS5MTXDW375966', 'Toyota', 'Camry', 2023, 'Available', 'New', 25000.00, 'USD', 'leather seats', 45.5, 'hamidus','e5913a79-9b1e-4516-9ffd-06578e7af261');


INSERT INTO vehicle_options (vehicle_id, name, description, cost)
VALUES
    ('JN8AS5MTXDW375966', 'Option 1', 'Description of Option 1', 1000.00),
    ('JN8AS5MTXDW375967', 'Option 2', 'Description of Option 2', 1500.00);

-- Inserting data into the customers table
INSERT INTO customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code)
VALUES ('001', 'John', 'Doe', 'john.doe@example.com', '123 Main St', 'Anytown', 'Anyprovince', 'USA', '12345');

INSERT INTO customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code)
VALUES ('002', 'Jane', 'Smith', 'jane.smith@example.com', '456 Elm St', 'Othertown', 'Otherprovince', 'USA', '67890');

INSERT INTO customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code)
VALUES ('003', 'Alice', 'Johnson', 'alice.johnson@example.com', '789 Oak St', 'Smalltown', 'Smallprovince', 'USA', '54321');

-- Inserting data into the customer_phoneNumbers table
INSERT INTO customer_phonenumbers (customer_id, type, number)
VALUES ('001', 'HOME', '123-456-7890');

INSERT INTO customer_phonenumbers (customer_id, type, number)
VALUES ('002', 'MOBILE', '987-654-3210');

INSERT INTO customer_phonenumbers (customer_id, type, number)
VALUES ('003', 'WORK', '555-555-5555');

INSERT INTO customer_phonenumbers (customer_id, type, number)
VALUES ('004', 'MOBILE', '111-222-3333');


insert into sales (sale_id, inventory_id, vehicle_id, customer_id, employee_id, amount, currency, sale_status, number_of_monthly_payments, monthly_payment_amount, down_payment_amount, payment_currency, sale_offer_date, warranty_end_date, warranty_terms)
values('05c8ab76-4f75-45c1-b6e2-aa8e914ea08f', 'd846a5a7-2e1c-4c79-809c-4f3f471e826d', 'JN8AS5MTXDW375966', 'c3540a89-cb47-4c96-888e-ff96708db4d8', 'e5913a79-9b1e-4516-9ffd-06578e7af261', 75000.00, 'CAD', 'PURCHASE_OFFER', 36, 1805.56, 10000.00, 'CAD', '2024-2-13', '2027-2-13', 'Basic Warranty: The basic warranty covers the vehicle against defects in materials or workmanship for a specific period, typically around 3 to 5 years.' );

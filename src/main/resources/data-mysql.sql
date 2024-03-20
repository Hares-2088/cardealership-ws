-- Department Positions
insert into department_positions (department_id, title, code)
values
    ('dep01', 'Manager', 'hrm1'),
    ('dep02', 'Associate', 'hra1'),
    ('dep03', 'Director', 'fin1'),
    ('dep04', 'Supervisor', 'op1'),
    ('dep05', 'Executive', 'sal1'),
    ('dep06', 'Engineer', 'it1'),
    ('dep07', 'Representative', 'cs1'),
    ('dep08', 'Researcher', 'rd1'),
    ('dep09', 'Counsel', 'leg1'),
    ('dep10', 'Analyst', 'sc1');

-- Employees
INSERT INTO employees (employee_id, first_name, last_name, email_address, salary, currency, commission_rate, street_address, city, province, country, postal_code, department_id, position_title)
VALUES
    ('emp01', 'John', 'Doe', 'john.doe@example.com', 50000.00, 'USD', 0.05, '123 Main St', 'Anytown', 'Anyprovince', 'USA', '12345', 'dep01', 'Manager'),
    ('emp02', 'Jane', 'Smith', 'jane.smith@example.com', 60000.00, 'USD', 0.07, '456 Elm St', 'Othertown', 'Otherprovince', 'USA', '67890', 'dep02', 'Sales Associate'),
    ('emp03', 'Alice', 'Johnson', 'alice.johnson@example.com', 45000.00, 'USD', 0.03, '789 Oak St', 'Smalltown', 'Smallprovince', 'USA', '54321', 'dep01', 'Administrator'),
    ('emp04', 'Michael', 'Brown', 'michael.brown@example.com', 55000.00, 'USD', 0.06, '101 Elm St', 'Bigtown', 'Bigprovince', 'USA', '10101', 'dep02', 'Sales Associate'),
    ('emp05', 'Emily', 'Wilson', 'emily.wilson@example.com', 52000.00, 'USD', 0.04, '222 Maple St', 'Largetown', 'Largeprovince', 'USA', '20202', 'dep03', 'Analyst'),
    ('emp06', 'David', 'Miller', 'david.miller@example.com', 58000.00, 'USD', 0.08, '333 Oak St', 'Smallville', 'Smallprovince', 'USA', '30303', 'dep04', 'Supervisor'),
    ('emp07', 'Olivia', 'Martinez', 'olivia.martinez@example.com', 53000.00, 'USD', 0.05, '444 Cedar St', 'Mediumtown', 'Mediumprovince', 'USA', '40404', 'dep05', 'Executive'),
    ('emp08', 'Daniel', 'Garcia', 'daniel.garcia@example.com', 56000.00, 'USD', 0.07, '555 Pine St', 'Hometown', 'Homeprovince', 'USA', '50505', 'dep06', 'Engineer'),
    ('emp09', 'Sophia', 'Lopez', 'sophia.lopez@example.com', 54000.00, 'USD', 0.06, '666 Birch St', 'Countrytown', 'Countryprovince', 'USA', '60606', 'dep07', 'Representative'),
    ('emp10', 'Matthew', 'Hernandez', 'matthew.hernandez@example.com', 57000.00, 'USD', 0.05, '777 Walnut St', 'Villagetown', 'Villageprovince', 'USA', '70707', 'dep08', 'Researcher');

-- Employee Phone Numbers
insert into employee_phonenumbers (employee_id, type, number)
values
    ('emp01', 'WORK', '515-555-5555'),
    ('emp01', 'MOBILE', '514-555-4444'),
    ('emp02', 'WORK', '616-555-5555'),
    ('emp02', 'MOBILE', '616-555-4444'),
    ('emp03', 'WORK', '727-555-5555'),
    ('emp03', 'MOBILE', '727-555-4444'),
    ('emp04', 'WORK', '838-555-5555'),
    ('emp04', 'MOBILE', '838-555-4444'),
    ('emp05', 'WORK', '949-555-5555'),
    ('emp05', 'MOBILE', '949-555-4444');


-- Inventories
insert into inventories (inventory_id, type)
values
    ('inv01', 'VEHICLE'),
    ('inv02', 'VEHICLE'),
    ('inv03', 'PART'),
    ('inv04', 'ACCESSORY'),
    ('inv05', 'PART'),
    ('inv06', 'VEHICLE'),
    ('inv07', 'ACCESSORY'),
    ('inv08', 'VEHICLE'),
    ('inv09', 'VEHICLE'),
    ('inv10', 'PART');

-- Vehicles
INSERT INTO vehicles (vehicle_id, make, model, year, status, usage_type, currency, price, inventory_id)
VALUES
    ('veh01', 'Toyota', 'Camry', 2023, 'Available', 'NEW', 'USD', 45.5, 'inv01'),
    ('veh02', 'Honda', 'Civic', 2024, 'Available', 'NEW', 'USD', 50.0, 'inv02'),
    ('veh03', 'Ford', 'Fusion', 2023, 'Available', 'NEW', 'USD', 48.75, 'inv06'),
    ('veh04', 'Chevrolet', 'Malibu', 2022, 'Available', 'NEW', 'USD', 47.25, 'inv08'),
    ('veh05', 'Toyota', 'Corolla', 2024, 'Available', 'NEW', 'USD', 49.0, 'inv09'),
    ('veh06', 'Nissan', 'Altima', 2023, 'Available', 'NEW', 'USD', 46.0, 'inv01'),
    ('veh07', 'Hyundai', 'Elantra', 2024, 'Available', 'NEW', 'USD', 51.0, 'inv02'),
    ('veh08', 'Kia', 'Forte', 2022, 'Available', 'NEW', 'USD', 47.5, 'inv06'),
    ('veh09', 'Mazda', 'Mazda3', 2023, 'Available', 'NEW', 'USD', 46.5, 'inv08'),
    ('veh10', 'Subaru', 'Impreza', 2024, 'Available', 'NEW', 'USD', 48.0, 'inv09');

-- Vehicle Options
INSERT INTO vehicles_options (vehicle_id, option_name, description, option_price)
VALUES
    ('veh01', 'Option 1', 'Description of Option 1', 1000.00),
    ('veh02', 'Option 2', 'Description of Option 2', 1100.00),
    ('veh03', 'Option 3', 'Description of Option 3', 1200.00),
    ('veh04', 'Option 4', 'Description of Option 4', 1300.00),
    ('veh05', 'Option 5', 'Description of Option 5', 1400.00),
    ('veh06', 'Option 6', 'Description of Option 6', 1500.00),
    ('veh07', 'Option 7', 'Description of Option 7', 1600.00),
    ('veh08', 'Option 8', 'Description of Option 8', 1700.00),
    ('veh09', 'Option 9', 'Description of Option 9', 1800.00),
    ('veh10', 'Option 10', 'Description of Option 10', 1900.00);

-- Customers
INSERT INTO customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code)
VALUES
    ('cus01', 'John', 'Doe', 'john.doe@example.com', '123 Main St', 'Anytown', 'Anyprovince', 'USA', '12345'),
    ('cus02', 'Jane', 'Smith', 'jane.smith@example.com', '456 Elm St', 'Othertown', 'Otherprovince', 'USA', '67890'),
    ('cus03', 'Alice', 'Johnson', 'alice.johnson@example.com', '789 Oak St', 'Smalltown', 'Smallprovince', 'USA', '54321'),
    ('cus04', 'Michael', 'Brown', 'michael.brown@example.com', '101 Elm St', 'Bigtown', 'Bigprovince', 'USA', '10101'),
    ('cus05', 'Emily', 'Wilson', 'emily.wilson@example.com', '222 Maple St', 'Largetown', 'Largeprovince', 'USA', '20202'),
    ('cus06', 'David', 'Miller', 'david.miller@example.com', '333 Oak St', 'Smallville', 'Smallprovince', 'USA', '30303'),
    ('cus07', 'Olivia', 'Martinez', 'olivia.martinez@example.com', '444 Cedar St', 'Mediumtown', 'Mediumprovince', 'USA', '40404'),
    ('cus08', 'Daniel', 'Garcia', 'daniel.garcia@example.com', '555 Pine St', 'Hometown', 'Homeprovince', 'USA', '50505'),
    ('cus09', 'Sophia', 'Lopez', 'sophia.lopez@example.com', '666 Birch St', 'Countrytown', 'Countryprovince', 'USA', '60606'),
    ('cus10', 'Matthew', 'Hernandez', 'matthew.hernandez@example.com', '777 Walnut St', 'Villagetown', 'Villageprovince', 'USA', '70707');

-- Customer Phone Numbers
insert into customer_phonenumbers (customer_id, type, number)
values
    ('cus01', 'HOME', '123-456-7890'),
    ('cus01', 'MOBILE', '234-567-8901'),
    ('cus02', 'WORK', '345-678-9012'),
    ('cus02', 'MOBILE', '456-789-0123'),
    ('cus03', 'HOME', '567-890-1234'),
    ('cus03', 'MOBILE', '678-901-2345'),
    ('cus04', 'WORK', '789-012-3456'),
    ('cus04', 'MOBILE', '890-123-4567'),
    ('cus05', 'HOME', '901-234-5678'),
    ('cus05', 'MOBILE', '012-345-6789');

-- Sales
insert into sales (sale_id, inventory_id, vehicle_id, customer_id, employee_id, amount, currency, sale_status, number_of_monthly_payments, monthly_payment_amount, down_payment_amount, payment_currency, sale_offer_date, warranty_end_date, warranty_terms)
values
    ('sale01', 'inv01', 'veh01', 'cus01', 'emp01', 75000.00, 'USD', 'PURCHASE_OFFER', 36, 1805.56, 10000.00, 'USD', '2024-02-13', '2027-02-13', 'Basic Warranty: The basic warranty covers the vehicle against defects in materials or workmanship for a specific period, typically around 3 to 5 years.'),
    ('sale02', 'inv02', 'veh02', 'cus02', 'emp02', 76000.00, 'USD', 'PURCHASE_OFFER', 36, 1850.56, 11000.00, 'USD', '2024-02-14', '2027-02-14', 'Extended Warranty: The extended warranty offers additional coverage beyond the basic warranty period, typically including more comprehensive repairs and maintenance.'),
    ('sale03', 'inv03', 'veh03', 'cus03', 'emp03', 77000.00, 'USD', 'PURCHASE_OFFER', 36, 1895.56, 12000.00, 'USD', '2024-02-15', '2027-02-15', 'Comprehensive Warranty: The comprehensive warranty covers nearly all repairs and maintenance for a specified period, typically offering peace of mind to the buyer.'),
    ('sale04', 'inv04', 'veh04', 'cus04', 'emp04', 78000.00, 'USD', 'PURCHASE_OFFER', 36, 1940.56, 13000.00, 'USD', '2024-02-16', '2027-02-16', 'Powertrain Warranty: The powertrain warranty specifically covers repairs and maintenance related to the vehicles engine, transmission, and other major components, ensuring long-term reliability.'),
    ('sale05', 'inv05', 'veh05', 'cus05', 'emp05', 79000.00, 'USD', 'PURCHASE_OFFER', 36, 1985.56, 14000.00, 'USD', '2024-02-17', '2027-02-17', 'Limited Warranty: The limited warranty provides coverage for specific components or systems of the vehicle, typically excluding wear and tear items.'),
    ('sale06', 'inv06', 'veh06', 'cus06', 'emp06', 80000.00, 'USD', 'PURCHASE_OFFER', 36, 2030.56, 15000.00, 'USD', '2024-02-18', '2027-02-18', 'Factory Warranty: The factory warranty is provided by the manufacturer and covers defects in materials or workmanship for a specified period, often including free repairs or replacements.'),
    ('sale07', 'inv07', 'veh07', 'cus07', 'emp07', 81000.00, 'USD', 'PURCHASE_OFFER', 36, 2075.56, 16000.00, 'USD', '2024-02-19', '2027-02-19', 'Dealer Warranty: The dealer warranty is provided by the dealership and covers repairs and maintenance for a specific period, typically offering added value to the buyer.'),
    ('sale08', 'inv08', 'veh08', 'cus08', 'emp08', 82000.00, 'USD', 'PURCHASE_OFFER', 36, 2120.56, 17000.00, 'USD', '2024-02-20', '2027-02-20', 'Extended Warranty: The extended warranty offers additional coverage beyond the basic warranty period, typically including more comprehensive repairs and maintenance.'),
    ('sale09', 'inv09', 'veh09', 'cus09', 'emp09', 83000.00, 'USD', 'PURCHASE_OFFER', 36, 2165.56, 18000.00, 'USD', '2024-02-21', '2027-02-21', 'Comprehensive Warranty: The comprehensive warranty covers nearly all repairs and maintenance for a specified period, typically offering peace of mind to the buyer.'),
    ('sale10', 'inv10', 'veh10', 'cus10', 'emp10', 84000.00, 'USD', 'PURCHASE_OFFER', 36, 2210.56, 19000.00, 'USD', '2024-02-22', '2027-02-22', 'Powertrain Warranty: The powertrain warranty specifically covers repairs and maintenance related to the vehicles engine, transmission, and other major components, ensuring long-term reliability.');
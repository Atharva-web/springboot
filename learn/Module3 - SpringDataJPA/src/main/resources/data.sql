INSERT INTO patient (id, name, email, blood_group, created_at, insurance_entity_id) VALUES
(1, 'Rahul Sharma', 'rahul@gmail.com', 'O_POSITIVE', '2026-04-01 10:15:30', NULL),
(2, 'Priya Verma', 'priya@gmail.com', 'A_POSITIVE', '2026-04-01 11:20:10', NULL),
(3, 'Amit Patel', 'amit@gmail.com', 'B_POSITIVE', '2026-04-01 12:05:45', NULL),
(4, 'Sneha Reddy', 'sneha@gmail.com', 'AB_POSITIVE', '2026-04-02 09:40:00', NULL),
(5, 'Karan Mehta', 'karan@gmail.com', 'O_NEGATIVE', '2026-04-02 14:10:25', NULL);

--INSERT INTO insurance (id, policy_number, provider, valid_until, created_at, patient_id) VALUES
--(1, 'POL1001', 'HDFC Ergo', '2027-04-01', '2026-04-01 10:16:00', 1),
--(2, 'POL1002', 'ICICI Lombard', '2027-06-15', '2026-04-01 11:21:00', 2),
--(3, 'POL1003', 'Star Health', '2028-01-10', '2026-04-01 12:06:30', 3),
--(4, 'POL1004', 'Max Bupa', '2027-09-25', '2026-04-02 09:41:10', 4),
--(5, 'POL1005', 'Aditya Birla', '2028-03-05', '2026-04-02 14:11:00', 5);

--UPDATE patient SET insurance_id = 1 WHERE id = 1;
--UPDATE patient SET insurance_id = 2 WHERE id = 2;
--UPDATE patient SET insurance_id = 3 WHERE id = 3;
--UPDATE patient SET insurance_id = 4 WHERE id = 4;
--UPDATE patient SET insurance_id = 5 WHERE id = 5;


--INSERT INTO products (sku, title_x, price, quantity) VALUES
--('maggi101', 'Maggi Noodles', 15, 200),
--('lays102', 'Lays Classic Chips', 20, 150),
--('kurkure103', 'Kurkure Masala Munch', 20, 180),
--('goodday104', 'Britannia Good Day Biscuit', 30, 140),
--('hide105', 'Hide & Seek Biscuit', 35, 120),
--('dairy106', 'Dairy Milk Chocolate', 50, 90),
--('perk107', 'Cadbury Perk', 10, 250),
--('5star108', 'Cadbury 5 Star', 20, 160),
--('oreo109', 'Oreo Cookies', 40, 130),
--('tango110', 'Tango Wafer Rolls', 25, 110),
--('bourbon111', 'Bourbon Biscuit', 30, 170),
--('treat112', 'Little Hearts Biscuit', 25, 140),
--('mamee113', 'Mamee Noodles', 15, 100),
--('pringles114', 'Pringles Chips', 100, 60),
--('cheetos115', 'Cheetos Crunchy', 20, 150),
--('haldiram116', 'Haldiram Bhujia', 50, 90),
--('balaji117', 'Balaji Wafers', 20, 130),
--('kitkat118', 'Nestle KitKat', 20, 180),
--('snickers119', 'Snickers Bar', 50, 95),
--('mars120', 'Mars Chocolate', 60, 85);
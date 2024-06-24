-- Inserciones en clients
INSERT INTO clients (documentid, name, phone) VALUES ('12345678', 'John Doe', 12345678901);
INSERT INTO clients (documentid, name, phone) VALUES ('87654321', 'Jane Smith', 10987654321);
INSERT INTO clients (documentid, name, phone) VALUES ('11223344', 'Alice Johnson', 11223344556);
INSERT INTO clients (documentid, name, phone) VALUES ('11235344', 'Serviestaciones', 11453344556);
INSERT INTO clients (documentid, name, phone) VALUES ('90122334', 'Jhon Bastidas', 11212325622);

-- Inserciones en products
INSERT INTO products (name, description, price) VALUES ('Laptop', 'High-performance laptop', 500);
INSERT INTO products (name, description, price) VALUES ('Smartphone', 'Latest model smartphone',500);
INSERT INTO products (name, description, price) VALUES ('Tablet', '10-inch screen tablet',300);
INSERT INTO products (name, description, price) VALUES ('Diafragma tokheim', 'Caucho nitrilo 60',50);
INSERT INTO products (name, description, price) VALUES ('Pasamuros electrico', 'De una pulgada',100);
INSERT INTO products (name, description, price) VALUES ('Pasamuros hidraulico', '2 pulgadas',150);
INSERT INTO products (name, price) VALUES ('Dispensador',80);

-- Inserciones en invoices
INSERT INTO invoices (date_invoice, clients_documentid) VALUES (TO_DATE('2022-01-15', 'YYYY-MM-DD'), '12345678');
INSERT INTO invoices (date_invoice, clients_documentid) VALUES (TO_DATE('2023-05-20', 'YYYY-MM-DD'), '87654321');
INSERT INTO invoices (date_invoice, clients_documentid) VALUES (TO_DATE('2023-03-10', 'YYYY-MM-DD'), '11223344');
INSERT INTO invoices (date_invoice, clients_documentid) VALUES (TO_DATE('2024-06-22', 'YYYY-MM-DD'), '11235344');
INSERT INTO invoices (date_invoice, clients_documentid) VALUES (TO_DATE('2024-06-22', 'YYYY-MM-DD'), '11235344');


SELECT invoice_id FROM invoices WHERE clients_documentid = '12345678'; 
SELECT invoice_id FROM invoices WHERE clients_documentid = '87654321'; 
SELECT invoice_id FROM invoices WHERE clients_documentid = '11223344';

SELECT documentid FROM clients WHERE name = 'Serviestaciones'; 

SELECT product_id FROM products WHERE name = 'Laptop'; 
SELECT product_id FROM products WHERE name = 'Smartphone';
SELECT product_id FROM products WHERE name = 'Tablet';

-- Inserciones en invoices_productd
INSERT INTO invoices_products (invoices_invoice_id, products_product_id) VALUES (1, 1);
INSERT INTO invoices_products (invoices_invoice_id, products_product_id) VALUES (1, 2);
INSERT INTO invoices_products (invoices_invoice_id, products_product_id) VALUES (1, 3);
INSERT INTO invoices_products (invoices_invoice_id, products_product_id) VALUES (4, 4);
INSERT INTO invoices_products (invoices_invoice_id, products_product_id) VALUES (4, 5);
INSERT INTO invoices_products (invoices_invoice_id, products_product_id) VALUES (5, 5);
INSERT INTO invoices_products (invoices_invoice_id, products_product_id) VALUES (5, 6);



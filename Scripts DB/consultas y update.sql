SELECT c.name, e.invoice_id, e.date_invoice
FROM clients c
INNER JOIN invoices e ON c.documentid = e.clients_documentid;


SELECT i.invoice_id, ip.products_product_id
FROM invoices i
INNER JOIN invoices_products ip ON i.invoice_id = ip.invoices_invoice_id;

SELECT clients.documentid, clients.name, invoices.invoice_id
FROM clients
LEFT JOIN invoices
ON clients.documentid = invoices.clients_documentid;

COLUMN documentid FORMAT A20


SELECT p.name, ip.invoices_invoice_id
FROM products p
LEFT JOIN invoices_products ip
ON p.product_id = ip.products_product_id;

SELECT c.name clientes_productos FROM clients c
UNION
SELECT p.name FROM products p;

COLUMN cliente FORMAT A20


update invoices set total_amount = 250  where invoice_id = 1;
update invoices set total_amount = 100  where invoice_id = 2;
update invoices set total_amount = 45  where invoice_id = 3;

SELECT invoices.invoice_id,
CASE
  WHEN total_amount >= 200 THEN '10%'
  WHEN total_amount < 200 and total_amount > 50 THEN '5%'
  ELSE 'Sin descuento'
END AS descuento
FROM invoices;

INSERT INTO clients (documentid, name, phone) VALUES ('80345678', 'Cesar Gaitan', 3134567898);
DELETE from clients where clients.documentid = 80345678;

select p.name from products p, invoices_products ip where ip.invoices_invoice_id = 1 and ip.products_product_id=p.product_id;


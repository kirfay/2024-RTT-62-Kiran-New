select customer_name, phone, address_line1 from customers;
select * from customers;
select * 
from customers
where contact_firstname Like'%gmail.com';
select * 
from customers
where contact_firstname Like'%tt%';
select * 
from customers
where customer_name Like'%Inc';
select *
from customers
where phone like '%212%';
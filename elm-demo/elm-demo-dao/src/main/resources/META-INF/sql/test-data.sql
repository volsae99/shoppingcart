INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, CATEGORY, PRICE) VALUES
(1, 'Java: A Beginner Guide', 'Essential Java Programming Skills--Made Easy', 'book', 24.93),
(2, 'Java: The Complete Reference', 'Essential Java Programming Skills--Made Easy', 'book', 45.35),
(3, 'iphone 5', 'apple iphone 5', 'phone', 450.00),
(4, 'galaxy 6', 'samsung galaxy 6', 'phone', 250.00);

INSERT INTO ORDERS(ID, NAME, STREET, CITY, STATE, ZIP, COUNTRY) VALUES 
(1, 'John', '1 Main Street', 'Toronto', 'Ontario', 'M1M1M1', 'Canada');

INSERT INTO ORDER_DETAIL(ID, ORDER_ID, NAME, PRICE, QUANTITY) VALUES 
(1, 1, 'Java: A Beginner Guide', 24.93, 1),
(2, 1, 'iphone 5', 450.00, 2);


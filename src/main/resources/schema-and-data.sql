-- Create table for users with a phone number column without a constraint
CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL,
                                     email VARCHAR(100) NOT NULL UNIQUE,
                                     phone_number VARCHAR(15) NOT NULL
);

-- Create table for restaurants with timestamps for created_at and updated_at
CREATE TABLE IF NOT EXISTS restaurants (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           name VARCHAR(100) NOT NULL,
                                           address VARCHAR(255),
                                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create table for menu items with a foreign key reference to restaurants
CREATE TABLE IF NOT EXISTS menu_items (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          name VARCHAR(100) NOT NULL,
                                          price DECIMAL(10, 2) NOT NULL,
                                          restaurant_id INT NOT NULL,
                                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                          FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

-- Create table for orders with foreign key references to users and menu items
CREATE TABLE IF NOT EXISTS orders (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      user_id INT NOT NULL,
                                      menu_item_id INT NOT NULL,
                                      order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      status VARCHAR(20) DEFAULT 'pending',
                                      FOREIGN KEY (user_id) REFERENCES users(id),
                                      FOREIGN KEY (menu_item_id) REFERENCES menu_items(id)
);

-- Indexes for faster lookups on foreign keys
CREATE INDEX idx_user_id ON orders(user_id);
CREATE INDEX idx_menu_item_id ON orders(menu_item_id);
CREATE INDEX idx_restaurant_id ON menu_items(restaurant_id);

-- Insert sample users (8 rows)
INSERT INTO users (name, email, phone_number) VALUES
                                                  ('Alice Johnson', 'alice@example.com', '1234567890'),
                                                  ('Bob Smith', 'bob@example.com', '0987654321'),
                                                  ('Charlie Brown', 'charlie@example.com', '1112233445'),
                                                  ('David Williams', 'david@example.com', '2233445566'),
                                                  ('Eve Davis', 'eve@example.com', '3344556677'),
                                                  ('Frank Harris', 'frank@example.com', '4455667788'),
                                                  ('Grace Lee', 'grace@example.com', '5566778899'),
                                                  ('Helen Young', 'helen@example.com', '6677889900');

-- Insert sample restaurants (5 rows)
INSERT INTO restaurants (name, address) VALUES
                                            ('Pizza Palace', '123 Pizza Lane'),
                                            ('Burger Barn', '456 Burger Ave'),
                                            ('Sushi Spot', '789 Sushi Rd'),
                                            ('Taco Town', '101 Taco Blvd'),
                                            ('Pasta Place', '202 Pasta St');

-- Insert sample menu items (10 rows)
INSERT INTO menu_items (name, price, restaurant_id) VALUES
                                                        ('Margherita Pizza', 9.99, 1),
                                                        ('Pepperoni Pizza', 12.99, 1),
                                                        ('Cheeseburger', 8.99, 2),
                                                        ('Veggie Burger', 7.99, 2),
                                                        ('California Roll', 14.99, 3),
                                                        ('Salmon Sushi', 18.99, 3),
                                                        ('Tacos', 6.99, 4),
                                                        ('Burrito', 8.99, 4),
                                                        ('Spaghetti Bolognese', 10.99, 5),
                                                        ('Fettuccine Alfredo', 12.99, 5);

-- Insert sample orders (8 rows, ensuring each user orders from a menu item)
INSERT INTO orders (user_id, menu_item_id, status) VALUES
                                                       (1, 1, 'Completed'),  -- Alice ordered Margherita Pizza
                                                       (1, 3, 'Pending'),    -- Alice ordered Cheeseburger
                                                       (2, 2, 'Completed'),  -- Bob ordered Pepperoni Pizza
                                                       (3, 5, 'Pending'),    -- Charlie ordered California Roll
                                                       (4, 8, 'Completed'),  -- David ordered Burrito
                                                       (5, 7, 'Completed'),  -- Eve ordered Tacos
                                                       (6, 10, 'Pending'),   -- Frank ordered Fettuccine Alfredo
                                                       (7, 6, 'Completed');  -- Grace ordered Salmon Sushi

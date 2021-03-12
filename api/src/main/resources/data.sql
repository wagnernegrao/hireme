INSERT INTO user(email, password, photo, contractor, service_provider)
VALUES ('wagner@gmail.com', '$2a$10$udRPN4P08e18Mrh.a5mWQOLff.Yyjh7xrIq14J48Q.jARx7sN091y', NULL, true, false);

INSERT INTO contractor(user_id, name, address, cnpj)
VALUES (1, 'wagner', 'localhost', 123456789);
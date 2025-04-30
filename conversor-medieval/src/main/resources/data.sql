INSERT INTO product (product_name, nature, origin_kingdom, origin_coin, specific_conversion, unitary_value) VALUES
                                                                                                       ('Peles de Urso', 'Animal', 'Reino do Norte', 'OURO_REAL', 2.5, 150.00),
                                                                                                       ('Madeira de Carvalho', 'Vegetal', 'Floresta Antiga', 'TIBAR', 0.4, 75.00);

INSERT INTO conversion (from_coin, to_coin, currency_value, last_updated_date) VALUES
                                                                                   ('OURO_REAL', 'TIBAR', 2.50, '2025-04-29 14:30:00'),
                                                                                   ('TIBAR', 'OURO_REAL', 0.40, '2025-04-15 09:00:00'),
                                                                                   ('OURO_REAL', 'TIBAR', 3.00, '2025-02-20 17:45:00');
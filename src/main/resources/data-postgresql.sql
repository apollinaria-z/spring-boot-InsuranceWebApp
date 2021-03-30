INSERT INTO client (name, surname, passportId)
             VALUES('Joe','Black','MP1234567'),
                   ('Tom','White','MP3334455'),
                   ('Jerry','Green','MP1119900'),
                   ('Peter','Brown','MP4536819');
INSERT INTO policy (clientId, property, coverage, price)
            VALUES (
                (SELECT id FROM client WHERE id = 1),
                'car', 'COLLISION', 5500
            ),
            (
                (SELECT id FROM client WHERE id = 2),
                'flat','COLLISION', 20100
            ),
            (
                (SELECT id FROM client WHERE id = 3),
                'car','COMPREHENSIVE', 15000
            ),
            (
                (SELECT id FROM client WHERE id = 4),
                'flat','COMPREHENSIVE', 46000
            );
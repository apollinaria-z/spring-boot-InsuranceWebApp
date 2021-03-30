CREATE TABLE IF NOT EXISTS client(
            id SERIAL PRIMARY KEY,
            name VARCHAR(50) NOT NULL,
            surname VARCHAR(50) NOT NULL,
            passportid VARCHAR(50) NOT NULL
         );

CREATE SEQUENCE client_id_seq START WITH 4 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS policy (
            policyid SERIAL PRIMARY KEY,
            clientid INTEGER,
            property VARCHAR(50) NOT NULL,
            coverage VARCHAR(50) NOT NULL,
            price INTEGER NOT NULL,
            FOREIGN KEY (clientid) REFERENCES client (id) ON DELETE SET NULL
            );
CREATE SEQUENCE policy_id_seq START WITH 4 INCREMENT BY 1;

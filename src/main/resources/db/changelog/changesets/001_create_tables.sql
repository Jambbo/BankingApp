CREATE TABLE accounts
(
    id      VARCHAR(36) PRIMARY KEY,
    number  VARCHAR NOT NULL UNIQUE,
    balance NUMERIC NOT NULL default 0
);

CREATE TABLE clients
(
    id         VARCHAR(36) PRIMARY KEY,
    name       VARCHAR     NOT NULL,
    username   VARCHAR     NOT NULL unique,
    password   VARCHAR     NOT NULL,
    account_id VARCHAR(36) NOT NULL,
    CONSTRAINT client_accounts FOREIGN KEY (account_id) REFERENCES accounts (id)
);

CREATE TABLE cards
(
    id         VARCHAR(36) PRIMARY KEY,
    number     VARCHAR(16) NOT NULL,
    date       VARCHAR(5)  NOT NULL,
    cvv        VARCHAR(3)  NOT NULL,
    account_id VARCHAR(36) NOT NULL,
    CONSTRAINT cards_unique UNIQUE (number, date),
    CONSTRAINT cards_accounts FOREIGN KEY (account_id) REFERENCES accounts (id)
);

CREATE TABLE clients_cards
(
    client_id VARCHAR(36) NOT NULL,
    card_id   VARCHAR(36) NOT NULL,
    CONSTRAINT clients_cards_unique UNIQUE (client_id, card_id),
    CONSTRAINT clients_cards_clients FOREIGN KEY (client_id) REFERENCES clients (id),
    CONSTRAINT clients_cards_cards FOREIGN KEY (card_id) REFERENCES cards (id)
);

CREATE TABLE transactions
(
    id      VARCHAR(36) PRIMARY KEY,
    from_id VARCHAR(36) NOT NULL,
    to_id   VARCHAR(36) NOT NULL,
    amount  NUMERIC     NOT NULL,
    CONSTRAINT transactions_cards_from FOREIGN KEY (from_id) REFERENCES cards (id),
    CONSTRAINT transactions_cards_to FOREIGN KEY (to_id) REFERENCES cards (id)
);

CREATE TABLE cards_transactions
(
    card_id        VARCHAR(36) NOT NULL,
    transaction_id VARCHAR(36) NOT NULL,
    CONSTRAINT cards_transactions_unique UNIQUE (card_id, transaction_id),
    CONSTRAINT cards_transactions_cards FOREIGN KEY (card_id) REFERENCES cards (id),
    CONSTRAINT cards_transactions_transactions FOREIGN KEY (transaction_id) REFERENCES transactions (id)
)
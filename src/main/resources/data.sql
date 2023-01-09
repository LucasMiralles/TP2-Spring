-- Initialisation des tables
INSERT INTO Country(code, name) VALUES
    ('FR', 'France'), -- Les clés sont auto-générées
    ('UK', 'United Kingdom'),
    ('US', 'United States of America');

INSERT INTO City(name, population, country_id) VALUES
    ('Paris', 12, SELECT id FROM Country WHERE code = 'FR'), -- Les clés sont auto-générées
    ('Londres', 10, SELECT id FROM Country WHERE code = 'UK'),
    ('Dallas', 5, SELECT id FROM Country WHERE code = 'US'),
    ('Toulouse', 8, SELECT id FROM Country WHERE code = 'FR');

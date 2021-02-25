CREATE TABLE symbols_audit AS
    TABLE symbols
    WITH NO DATA;

ALTER TABLE symbols_audit
ADD COLUMN stamp timestamp;

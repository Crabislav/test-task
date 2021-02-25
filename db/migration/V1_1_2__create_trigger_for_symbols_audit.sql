CREATE OR REPLACE FUNCTION process_symbols_audit() RETURNS TRIGGER AS
$emp_audit$
BEGIN
    IF (TG_OP = 'UPDATE') THEN
        INSERT INTO symbols_audit SELECT NEW.*, now() FROM old_table;
    END IF;
    RETURN NULL; -- result is ignored since this is an AFTER trigger
END;
$emp_audit$ LANGUAGE plpgsql;

CREATE TRIGGER emp_audit_upd
    AFTER UPDATE
    ON symbols
    REFERENCING OLD TABLE AS old_table
    FOR EACH ROW
EXECUTE PROCEDURE process_symbols_audit();
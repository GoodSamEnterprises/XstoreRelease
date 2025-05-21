
    
DELETE FROM ctl_version_history WHERE 
    organization_id = 1000 AND 
    base_schema_version = '16.0.5.0.38' AND 
    customer_schema_version = '7.0.36 - 1.53';

INSERT INTO ctl_version_history (
    organization_id, customer, base_schema_version, customer_schema_version, 
    base_schema_date, customer_schema_date, create_user_id, create_date, update_user_id, update_date)
VALUES (
    1000, 'CAW', '16.0.5.0.38', '7.0.36 - 1.53', 
    SYSDATE, SYSDATE, 'INSTALLX', SYSDATE, 'INSTALLX', SYSDATE);

EXIT;


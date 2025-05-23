--------------------------------------------------------------------------------
-- This script will create the synonyms for DBAUser.
--
-- Product:         XStore
-- Version:         16.0.0
-- DB platform:     Oracle 10g/11g/12c
--------------------------------------------------------------------------------
BEGIN
  if upper('$(DbSchema)') not like '%TRAINING%' then
	EXECUTE IMMEDIATE 'CREATE OR REPLACE SYNONYM DBAUSER.SP_EXPORT_DATABASE FOR $(DbSchema).SP_EXPORT_DATABASE';
	EXECUTE IMMEDIATE 'CREATE OR REPLACE SYNONYM DBAUSER.SP_IMPORT_DATABASE FOR $(DbSchema).SP_IMPORT_DATABASE';
  end if;
END;
/
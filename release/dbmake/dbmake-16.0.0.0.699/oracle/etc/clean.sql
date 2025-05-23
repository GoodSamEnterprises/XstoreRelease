--------------------------------------------------------------------------------
-- This script will drop all of the users, roles and the profile created for 
-- XStore.  The script will drop all tables and synonyms in the xstore schema
--
-- Product:         XStore
-- Version:         16.0.0
-- DB platform:     Oracle 10g/11g/12c
-- $Name$
--------------------------------------------------------------------------------
SET SERVEROUTPUT ON;
SPOOL clean.log;

--------------------------------------------------------------------------------
-- Drop all of the XStore Users
--------------------------------------------------------------------------------
--drop user dtv cascade;
--drop user pos cascade;
--drop user training cascade;
drop user $(DbSchema) cascade;

BEGIN
if upper('$(DbUser)') <> upper('$(DbSchema)') then
	EXECUTE IMMEDIATE 'drop user $(DbUser) cascade';
end if;
END;
/

SET SERVEROUTPUT ON;
DECLARE
  CURSOR Drop_Syn_Cur IS
    SELECT 'DROP SYNONYM ' || owner || '.' || table_name
      from dba_synonyms
      where table_owner = upper('$(DbSchema)');
	  
  ls_sqlcmd			VARCHAR(128);
  
BEGIN
  OPEN Drop_Syn_Cur;
  LOOP
    FETCH Drop_Syn_Cur INTO ls_sqlcmd;
	EXIT WHEN DROP_SYN_CUR%NOTFOUND;
	
	DBMS_OUTPUT.PUT_LINE(ls_sqlcmd);
    EXECUTE IMMEDIATE ls_sqlcmd;
	
  END LOOP;
END;
/
--------------------------------------------------------------------------------
-- Drop the tablespaces
--------------------------------------------------------------------------------

CREATE OR REPLACE DIRECTORY EXT_DATA_FILES AS '$(DbDataFilePath)';

DROP TABLESPACE $(DbTblspace)_data INCLUDING CONTENTS AND DATAFILES;

DECLARE
  l_exists     boolean;
  l_size       integer;
  l_block_size integer;
BEGIN
  utl_file.fgetattr( 'EXT_DATA_FILES', 
                     '$(DbTblspace)_data.dbf', 
                     l_exists, 
                     l_size, 
                     l_block_size );
   if( l_exists )
   then
     dbms_lock.sleep(30);
     utl_file.fremove('EXT_DATA_FILES', '$(DbTblspace)_data.dbf');
   end if;
END;
/

DROP TABLESPACE $(DbTblspace)_index INCLUDING CONTENTS AND DATAFILES;

DECLARE
  l_exists     boolean;
  l_size       integer;
  l_block_size integer;
BEGIN
  utl_file.fgetattr( 'EXT_DATA_FILES', 
                     '$(DbTblspace)_index.dbf', 
                     l_exists, 
                     l_size, 
                     l_block_size );
   if( l_exists )
   then
     dbms_lock.sleep(30);
     utl_file.fremove('EXT_DATA_FILES', '$(DbTblspace)_index.dbf');
   end if;
END;
/

SPOOL OFF;


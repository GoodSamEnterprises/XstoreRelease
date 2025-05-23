SET SERVEROUTPUT ON SIZE 10000
SET VERIFY OFF

SPOOL dbcreate.log;

-------------------------------------------------------------------------------------------------------------------
--                                                                                                              
-- Script           : pdb-create.sql                                                                    
-- Description      : Creates the Pluggable Database, Tablespaces, Roles, Profiles and Users for a new Oracle container database.               
-- Author           : Brett C. White
-- DB platform:     : Oracle 12c
-- Version          : 16.0.0                                                                                     
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                    
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                    
-------------------------------------------------------------------------------------------------------------------
-- ... .....     Initial Version
-------------------------------------------------------------------------------------------------------------------

--
-- Variables
--
DEFINE dbName = '$(DbName)';-- this PDB's name
DEFINE dbSeedFilePath = '$(DbSeedFilePath)';-- the location of the PDB seed
DEFINE dbAdmin = '$(DbAdmin)';-- The username for this PDB's admin user
DEFINE dbAdminPwd = '$(DbAdmpwd)';-- The password for this PDB's admin user
DEFINE dbDataFilePath = '$(DbDataFilePath)';-- Location of data files
DEFINE dbIndexFilePath = '$(DbIndexFilePath)';-- Location of index files
DEFINE dbTableSpace = '$(DbTblspace)';-- Database Type (i.e. XSTORE or TRAINING)
DEFINE dbSchema = '$(DbSchema)';-- Schema the objects reside (i.e. DTV, TRAINING, or REPQUEUE)
DEFINE dbUser = '$(DbUser)';-- User using the objects (i.e. POS, TRAINING, or REPQUEUE) 

--
-- Create Xstore PDB
--
alter session set container = cdb$root;

BEGIN
	EXECUTE IMMEDIATE'create pluggable database &dbName.
	admin user &dbAdmin. identified by "&dbAdminPwd."
	roles = (DBA)
	FILE_NAME_CONVERT =(''&dbSeedFilePath.'',''&dbDataFilePath.'')';


	EXECUTE IMMEDIATE'alter pluggable database &dbName. open';

	EXECUTE IMMEDIATE'alter pluggable database &dbName. save state instances=all';

	EXECUTE IMMEDIATE'alter session set container = &dbName.';

--
-- Create the Tablespaces: Data and Index
--

	EXECUTE IMMEDIATE'CREATE TABLESPACE &dbTableSpace._DATA DATAFILE
   ''&dbDataFilePath./&dbTableSpace._data.dbf'' SIZE 512M AUTOEXTEND ON NEXT 512M MAXSIZE UNLIMITED';

	EXECUTE IMMEDIATE'CREATE TABLESPACE &dbTableSpace._INDEX DATAFILE
   ''&dbIndexFilePath./&dbTableSpace._index.dbf'' SIZE 256M AUTOEXTEND ON NEXT 256M MAXSIZE UNLIMITED';

    EXCEPTION WHEN OTHERS THEN
	RAISE_APPLICATION_ERROR(-20100, SQLERRM);
END;
/

--
-- Create Roles
--

-- pos user Role
declare
li_rowcnt int;
begin
select count(*) into li_rowcnt from dba_roles where ROLE = 'POSUSERS';

if li_rowcnt = 0 then
EXECUTE IMMEDIATE 'CREATE ROLE posusers';
end if;
end;
/

-- dba user Role
declare
li_rowcnt int;
begin
select count(*) into li_rowcnt from dba_roles where ROLE = 'DBAUSERS';

if li_rowcnt = 0 then
EXECUTE IMMEDIATE 'CREATE ROLE dbausers';
end if;
end;
/

--
-- Create User Profiles
--

-- xstore user role
declare
li_rowcnt int;
begin
select count(*) into li_rowcnt from dba_profiles where profile = 'XSTORE';

if li_rowcnt = 0 then
EXECUTE IMMEDIATE 'CREATE PROFILE xstore
LIMIT
    CONNECT_TIME 180
    FAILED_LOGIN_ATTEMPTS 5
    IDLE_TIME 30
    SESSIONS_PER_USER unlimited
    PASSWORD_LIFE_TIME unlimited';
end if;
end;
/

--
-- Create Schema Owner Users
--

-- schema owner user
BEGIN
EXECUTE IMMEDIATE 'CREATE USER &dbSchema.
  IDENTIFIED BY ' || lower('&dbSchema.') || '
  DEFAULT TABLESPACE &dbTableSpace._DATA
  TEMPORARY TABLESPACE TEMP
  PROFILE xstore
  ACCOUNT UNLOCK';
END;
/

GRANT CREATE SESSION TO &dbSchema.;
GRANT UNLIMITED TABLESPACE TO &dbSchema.;
GRANT CREATE TRIGGER TO &dbSchema.;
GRANT CREATE VIEW TO &dbSchema.;
GRANT CREATE SEQUENCE TO &dbSchema.;
GRANT CREATE PROCEDURE TO &dbSchema.;
GRANT CREATE TABLE TO &dbSchema.;
GRANT CREATE TYPE TO &dbSchema.;
GRANT CREATE JOB TO &dbSchema.;
GRANT EXP_FULL_DATABASE TO &dbSchema.;
GRANT IMP_FULL_DATABASE TO &dbSchema.;
GRANT SELECT_CATALOG_ROLE TO &dbSchema.;
GRANT dbausers TO &dbSchema.;

--
-- Create Non-Schema-Owner Users
--

-- Xstore application user
declare
li_rowcnt int;
begin
select count(*) into li_rowcnt from dba_users where USERNAME = upper('&dbUser.');

if li_rowcnt = 0 then
EXECUTE IMMEDIATE 'CREATE USER &dbUser. 
  IDENTIFIED BY ' || lower('&dbUser.') || '
  DEFAULT TABLESPACE &dbTableSpace._DATA
  TEMPORARY TABLESPACE TEMP
  PROFILE xstore
  ACCOUNT UNLOCK';

EXECUTE IMMEDIATE 'GRANT CREATE SESSION TO &dbUser.';
EXECUTE IMMEDIATE 'GRANT UNLIMITED TABLESPACE TO &dbUser.';
EXECUTE IMMEDIATE 'GRANT CREATE SYNONYM TO &dbUser.';
EXECUTE IMMEDIATE 'GRANT posusers to &dbUser.';  
end if;
end;
/

-- database backup/restore user
declare
li_rowcnt int;
begin
select count(*) into li_rowcnt from dba_users where USERNAME = 'DBAUSER';

if li_rowcnt = 0 then
EXECUTE IMMEDIATE 'CREATE USER dbauser 
  IDENTIFIED BY dbauser
  DEFAULT TABLESPACE &dbTableSpace._DATA
  TEMPORARY TABLESPACE TEMP
  PROFILE xstore
  ACCOUNT UNLOCK';

EXECUTE IMMEDIATE 'GRANT UNLIMITED TABLESPACE TO dbauser';
EXECUTE IMMEDIATE 'GRANT CREATE SESSION TO dbauser';
EXECUTE IMMEDIATE 'GRANT EXP_FULL_DATABASE TO dbauser';
EXECUTE IMMEDIATE 'GRANT IMP_FULL_DATABASE TO dbauser';
EXECUTE IMMEDIATE 'GRANT dbausers TO dbauser';
end if;
end;
/

create or replace DIRECTORY EXP_DIR AS 'xstoredb/backup';
grant read, write on DIRECTORY EXP_DIR to dbauser,&dbSchema.;

UNDEFINE dbName;
UNDEFINE dbSeedFilePath;
UNDEFINE dbAdmin;
UNDEFINE dbAdminPwd;
UNDEFINE dbDataFilePath;
UNDEFINE dbIndexFilePath;
UNDEFINE dbTableSpace;
UNDEFINE dbSchema;
UNDEFINE dbUser;

--SPOOL OFF;

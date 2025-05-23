SET SERVEROUTPUT ON SIZE 10000

SPOOL dbupdate.log;

-- ***************************************************************************
-- This script will upgrade a database from version <source> of the Xadmin base schema to version
-- <target>.  If upgrading from a schema version earlier than <source>, multiple upgrade scripts may
-- have to be applied in ascending order by <target>.
--
-- This script should only be run against a database previously created and defined by platform-
-- and version-compatible "create" and "define" scripts.
--
-- For certain supported platforms, this script may be run repeatedly against a target compatible
-- database, including an already upgraded one, without error or data loss.  Please consult the 
-- Xstore R&D group for a listing of officially supported platforms for which this convenience is
-- provided.
--
-- Source version:  15.0.x
-- Target version:  16.0.0
-- DB platform:     Oracle 10g/11g/12c
-- ***************************************************************************
-- ***************************************************************************
-- ***************************************************************************
-- 15.0.x -> 16.0.0
-- ***************************************************************************
-- ***************************************************************************

--[RXPS-16187]
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE TABLE_NAME = upper('DAT_ITEM_OPTIONS_CHANGE') AND COLUMN_NAME=upper('RESTRICTION_CATEGORY');

  IF li_rowcnt > 0 THEN
    EXECUTE IMMEDIATE 'ALTER TABLE dat_item_options_change DROP COLUMN RESTRICTION_CATEGORY';
    dbms_output.put_line('     dat_item_options_change.RESTRICTION_CATEGORY dropped');
  END IF;
END;
/
--[/RXPS-16187]

--[RXPS-18039]
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE TABLE_NAME = upper('cfg_sequence_part');

  IF li_rowcnt > 0 THEN
    UPDATE cfg_sequence_part
    SET max_value = '99999999'
    WHERE sequence_id = 'DEPLOYMENT_ID';
    dbms_output.put_line('     cfg_sequence_part.max_value updated');
  END IF;
END;
/
--[/RXPS-18039]

--[RXPS-21905]
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE TABLE_NAME = upper('CFG_TENDER_OPTIONS_CHANGE') AND COLUMN_NAME=upper('ASSIGN_CASH_DRAWER_REQ_FLAG');
    
    if li_rowcnt = 0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE cfg_tender_options_change ADD assign_cash_drawer_req_flag NUMBER(1, 0) DEFAULT 0';
      EXECUTE IMMEDIATE 'UPDATE cfg_tender_options_change SET assign_cash_drawer_req_flag = 0';
    END IF;
END;
/
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE TABLE_NAME = upper('CFG_TENDER_OPTIONS_CHANGE') AND COLUMN_NAME=upper('POST_VOID_ASSIGN_DRAWER_FLAG');
    
    if li_rowcnt = 0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE cfg_tender_options_change ADD post_void_assign_drawer_flag NUMBER(1, 0) DEFAULT 0';
      EXECUTE IMMEDIATE 'UPDATE cfg_tender_options_change SET post_void_assign_drawer_flag = 0';
    END IF;
END;
/
--[/RXPS-21905]

--[RXPS-17468]
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE TABLE_NAME = upper('DPL_DEPLOYMENT') AND COLUMN_NAME=upper('XSTORE_VERSION');

  IF li_rowcnt = 0 THEN
    EXECUTE IMMEDIATE 'ALTER TABLE dpl_deployment ADD xstore_version VARCHAR2(40 char)';
    dbms_output.put_line('     dpl_deployment.xstore_version added');
  END IF;
END;
/
--[/RXPS-17468]

commit;
--SPOOL OFF;
-- LEAVE BLANK LINE BELOW

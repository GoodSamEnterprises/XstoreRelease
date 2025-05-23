-- ***************************************************************************
-- This script is a "staging area" for database schema changes proposed by development and subject
-- to review and acceptance/rejection/modification by the DBA.
-- 
-- Developers should manually apply this script to their local environments to enable them to run 
-- Xadmin against recently implemented changes while the schema modification review process is 
-- pending/underway.  Published builds, however, must always incorporate the approved schema changes
-- represented in the companion script db-upgrade.sql.
-- 
-- For any SQL statement X included here, the following must be true:
-- 
-- *** X converts one or more schema artifacts from a <source>-compatible form to a <target>-
--     compatible form, where <source> and <target> represent a legacy Xadmin release version and a 
--     more modern release version, respectively.
--
-- *** If X is modified or rejected by the DBA, the developer adding X to this script is responsible
--     for updating the relevant programmatic artifacts and pre-defined data depending on the 
--     modified/rejected changes.
--
-- *** If X is associated with a new or enhanced Xadmin feature, it should be annotated with its 
--     corresponding JIRA story as follows:
--          <SQL statement>     -- [<JIRA story>]
--     e.g. ALTER TABLE some_table ADD some_col varchar2(30);      -- [XSTORE-278754]
--
--     Multiple SQL statements can be associated with a single activity using a start/end notation:
--          -- [<JIRA story>]
--          <SQL Statement 1>
--          <SQL Statement n>
--          -- [/<JIRA story>]
--
--     e.g. -- [XSTORE-278754]
--          ALTER TABLE some_table ADD some_col varchar2(30);
--          ALTER TABLE some_table ADD some_other_col varchar2(30);
--          -- [/XSTORE-278754]
--
--     The word "General" may be substituted for a JIRA story for schema changes that do not
--     correspond to a new/enhanced feature (e.g. dropping obsolete tables/columns).
-- 
-- *** To facilitate ongoing review and incorporation of the contents of this script into its 
--     production-caliber counterpart, X should always be added to the end of this script, even 
--     if it pertains to an activity with related schema changes represented earlier.
--
-- *** Unlike the case with the production db-upgrade.sql script, developers don't need to make any
--     accommodation to ensure that X may be executed repeatedly without error.  This applies 
--     primarily to "not exists" checks wrapping statements creating tables and adding columns; it 
--     is not necessary to add them here.
--
--     X, however, must successfully run at least once, meaning that some clerical boilerplate might 
--     be needed for certain operations (e.g. changing a primary key, dropping a column with a 
--     default constraint).  A failure to run X must also not prevent the execution of subsequent
--     statements in this script.
--
-- Source version:  15.0.x
-- Target version:  16.0.0
-- DB platform:     Oracle 10g/11g/12c
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

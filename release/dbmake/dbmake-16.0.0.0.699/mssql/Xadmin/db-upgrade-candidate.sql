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
--     corresponding PTS activity as follows:
--          <SQL statement>     -- [<Jira Story>]
--     e.g. ALTER TABLE some_table ADD some_col varchar(30);      -- [XSTORE-8754]
--
--     Multiple SQL statements can be associated with a single activity using a start/end notation:
--          -- [<Jira Story>]
--          <SQL Statement 1>
--          <SQL Statement n>
--          -- [/<Jira Story>]
--
--     e.g. -- [XSTORE-8754]
--          ALTER TABLE some_table ADD some_col varchar(30);
--          ALTER TABLE some_table ADD some_other_col varchar(30);
--          -- [/XSTORE-8754]
--
--     The word "General" may be substituted for a PTS activity ID for schema changes that do not
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
-- DB platform:     Microsoft SQL Server 2008/2012
-- ***************************************************************************

--[RXPS-16187]
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'restriction_category' AND object_id = OBJECT_ID('dat_item_options_change'))
BEGIN
  ALTER TABLE dat_item_options_change DROP COLUMN restriction_category;
  PRINT 'dat_item_options_change.restriction_category dropped'
END
GO
--[/RXPS-16187]

--[RXPS-18039]
IF EXISTS (SELECT * FROM sys.tables WHERE object_id = OBJECT_ID('cfg_sequence_part'))
  UPDATE cfg_sequence_part
  SET max_value = '99999999'
  WHERE sequence_id = 'DEPLOYMENT_ID';
GO
--[/RXPS-18039]

--[RXPS-21905]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'assign_cash_drawer_req_flag' AND object_id = OBJECT_ID('cfg_tender_options_change'))
BEGIN
  EXEC('ALTER TABLE cfg_tender_options_change ADD assign_cash_drawer_req_flag bit default ((0)) null');
  EXEC('UPDATE cfg_tender_options_change SET assign_cash_drawer_req_flag = 0');
  PRINT 'cfg_tender_options_change.assign_cash_drawer_req_flag added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'post_void_assign_drawer_flag' AND object_id = OBJECT_ID('cfg_tender_options_change'))
BEGIN
  EXEC('ALTER TABLE cfg_tender_options_change ADD post_void_assign_drawer_flag bit default ((0)) null');
  EXEC('UPDATE cfg_tender_options_change SET post_void_assign_drawer_flag = 0');
  PRINT 'cfg_tender_options_change.post_void_assign_drawer_flag added'
END
GO
--[/RXPS-21905]


--[RXPS-17468]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'xstore_version' AND object_id = OBJECT_ID('dpl_deployment'))
BEGIN
  EXEC('ALTER TABLE dpl_deployment ADD xstore_version varchar(40)');
  PRINT 'dpl_deployment.xstore_version added'
END
GO
--[/RXPS-17468]
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
-- DB platform:     Microsoft SQL Server 2008/2012
-- ***************************************************************************

-- ***************************************************************************
-- ***************************************************************************
-- 15.0.x -> 16.0.0
-- ***************************************************************************
-- ***************************************************************************
-- ***************************************************************************
PRINT '**************************************';
PRINT '* UPGRADE to release 16.0';
PRINT '**************************************';

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

-- LEAVE BLANK LINE BELOW

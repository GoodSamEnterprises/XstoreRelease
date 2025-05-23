-- ***************************************************************************
-- This script "de-hybridizes" a previously "hybridized" script, discarding only those schema 
-- structure which were added during the hybridization process.  It is generally invoked once 
-- against any databases which, at one point, needed to simultaneously accommodate clients running 
-- on two versions of Xstore.
--
-- NOTE: This script only "undoes" any changes made explicitly and exclusively by a corresponding
-- "hybridize" script.  It does not perform any schema changes included in the standard "upgrade" 
-- script but excluded from the corresponding "hybridize" script.  To affect those conversion 
-- changes excluded from this script, run the full "upgrade" script after running this one.

-- If, for example, the A-to-B "upgrade" script drops table T but the A-and-B "hybridize" script 
-- retains T for cross-version compatibility, the A-and-B "unhybridize" script will not drop T.
-- To drop T from the A-and-B database, the A-to-B "upgrade" script will have to be invoked after 
-- the A-and-B "unhybridize" script.
--
-- Source version:  15.0.*
-- Target version:  16.0.0
-- DB platform:     Microsoft SQL Server 2008/2012
-- ***************************************************************************
PRINT '**************************************';
PRINT '*****       UNHYBRIDIZING        *****';
PRINT '***** From:  15.0.*              *****';
PRINT '*****   To:  16.0.0		        *****';
PRINT '**************************************';
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'restriction_category' AND object_id = OBJECT_ID('itm_item_options'))
BEGIN
  ALTER TABLE itm_item_options DROP COLUMN restriction_category;
  PRINT 'itm_item_options.restriction_category dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'dependent_flag' AND object_id = OBJECT_ID('itm_item_restriction'))
BEGIN
  ALTER TABLE itm_item_restriction DROP COLUMN dependent_flag;
  PRINT 'itm_item_restriction.dependent_flag dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_country' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN destination_country;
  PRINT 'com_flight_info.destination_country dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN destination_eu_code;
  PRINT 'com_flight_info.destination_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_1_country' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_1_country;
  PRINT 'com_flight_info.via_1_country dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_1_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_1_eu_code;
  PRINT 'com_flight_info.via_1_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_2_country' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_2_country;
  PRINT 'com_flight_info.via_2_country dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_2_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_2_eu_code;
  PRINT 'com_flight_info.via_2_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_3_country' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_3_country;
  PRINT 'com_flight_info.via_3_country dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_3_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_3_eu_code;
  PRINT 'com_flight_info.via_3_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'final_flight_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN final_flight_eu_code;
  PRINT 'com_flight_info.final_flight_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_airport_name' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN destination_airport_name;
  PRINT 'com_flight_info.destination_airport_name dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'employee_flag' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  DECLARE @ConstraintName nvarchar(200)
  SELECT @ConstraintName = Name FROM SYS.DEFAULT_CONSTRAINTS WHERE PARENT_OBJECT_ID = OBJECT_ID('com_flight_info')
  AND PARENT_COLUMN_ID = (SELECT column_id FROM sys.columns WHERE NAME = N'employee_flag' AND object_id = OBJECT_ID(N'com_flight_info'))
  IF @ConstraintName IS NOT NULL
    EXEC('ALTER TABLE com_flight_info DROP CONSTRAINT ' + @ConstraintName)
    ALTER TABLE com_flight_info DROP COLUMN employee_flag;
    PRINT 'com_flight_info.employee_flag dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.sysobjects where id = OBJECT_ID(N'com_airport_zone_mapping'))
BEGIN
  DROP TABLE com_airport_zone_mapping
  PRINT 'com_airport_zone_mapping dropped'
END

IF EXISTS (SELECT 1 FROM sys.sysobjects where id = OBJECT_ID(N'com_airport_zone_mapping_p'))
BEGIN
  DROP TABLE com_airport_zone_mapping_p
  PRINT 'com_airport_zone_mapping_p dropped'
END

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'zone_id' AND object_id = OBJECT_ID('loc_rtl_loc'))
BEGIN
  ALTER TABLE loc_rtl_loc DROP COLUMN zone_id;
  PRINT 'loc_rtl_loc.zone_id dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_typecode' AND object_id = OBJECT_ID('itm_item_options'))
BEGIN
  ALTER TABLE itm_item_options DROP COLUMN tare_typecode;
  PRINT 'itm_item_options.tare_typecode dropped'
END

IF EXISTS (SELECT * FROM sys.views WHERE name = 'itm_tare_type')
    DROP VIEW itm_tare_type;
GO

IF EXISTS (SELECT 1 FROM sys.columns where object_id = OBJECT_ID('itm_tare_type_p'))
BEGIN
  DROP TABLE itm_tare_type_p
  PRINT 'itm_tare_type dropped_p'
END

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'expiration_date' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN expiration_date;
  PRINT 'com_flight_info.expiration_date dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'expiration_date' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info DROP COLUMN expiration_date;
  PRINT 'trl_rtrans_flight_info.expiration_date dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'employee_flag' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  DECLARE @ConstraintName nvarchar(200)
  SELECT @ConstraintName = Name FROM SYS.DEFAULT_CONSTRAINTS WHERE PARENT_OBJECT_ID = OBJECT_ID('trl_rtrans_flight_info')
  AND PARENT_COLUMN_ID = (SELECT column_id FROM sys.columns WHERE NAME = N'employee_flag' AND object_id = OBJECT_ID(N'trl_rtrans_flight_info'))
  IF @ConstraintName IS NOT NULL
    EXEC('ALTER TABLE trl_rtrans_flight_info DROP CONSTRAINT ' + @ConstraintName)
    ALTER TABLE trl_rtrans_flight_info DROP COLUMN employee_flag;
    PRINT 'trl_rtrans_flight_info.employee_flag dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'expiration_date' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
  ALTER TABLE itm_item_p DROP COLUMN expiration_date;
  PRINT 'itm_item_p.expiration_date dropped'
END
GO

--[]
--Begin Misalignement of table structure between Oracle and Sql Server script for table itm_item_p

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'org_code' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
  DECLARE @ConstraintName nvarchar(200)
  SELECT @ConstraintName = Name FROM SYS.DEFAULT_CONSTRAINTS WHERE PARENT_OBJECT_ID = OBJECT_ID('itm_item_p')
  AND PARENT_COLUMN_ID = (SELECT column_id FROM sys.columns WHERE NAME = N'org_code' AND object_id = OBJECT_ID(N'itm_item_p'))
  IF @ConstraintName IS NOT NULL
    EXEC('ALTER TABLE itm_item_p DROP CONSTRAINT ' + @ConstraintName)

  DROP INDEX itm_item_p.idx_itm_item_prop_orgnode;
  ALTER TABLE itm_item_p DROP COLUMN org_code;
  PRINT 'itm_item_p.org_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'org_value' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
	DECLARE @ConstraintName nvarchar(200)
  SELECT @ConstraintName = Name FROM SYS.DEFAULT_CONSTRAINTS WHERE PARENT_OBJECT_ID = OBJECT_ID('itm_item_p')
  AND PARENT_COLUMN_ID = (SELECT column_id FROM sys.columns WHERE NAME = N'org_value' AND object_id = OBJECT_ID(N'itm_item_p'))
  IF @ConstraintName IS NOT NULL
    EXEC('ALTER TABLE itm_item_p DROP CONSTRAINT ' + @ConstraintName)

  ALTER TABLE itm_item_p DROP COLUMN org_value;
  PRINT 'itm_item_p.org_value dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'effective_date' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
  ALTER TABLE itm_item_p DROP CONSTRAINT pk_itm_item_p;
  PRINT 'itm_item_p primary key dropped'
  ALTER TABLE itm_item_p DROP COLUMN effective_date;
  PRINT 'itm_item_p.effective_date dropped'
  ALTER TABLE itm_item_p ADD CONSTRAINT pk_itm_item_p
    PRIMARY KEY CLUSTERED ([organization_id], [item_id], [property_code]) WITH (FILLFACTOR = 80);
  PRINT 'Primary key created itm_item_p'
END
GO
--End Misalignement of table structure between Oracle and Sql Server script for table
--[/]


DROP TRIGGER TRG_TRN_TRANS_TRANS_DATE;
GO


PRINT '**************************************';
PRINT 'Finalizing release version 16.0.0';
PRINT '**************************************';
GO

PRINT '***************************************************************************';
PRINT 'Database now un-hybridized to support clients running against the following versions:';
PRINT '     16.0.0';
PRINT 'This database is no longer compatible with clients running against legacy versions';
PRINT 'previously supported while hybridized.  Please ensure that all clients are updated';
PRINT 'to the appropriate release.';
PRINT '***************************************************************************';
GO

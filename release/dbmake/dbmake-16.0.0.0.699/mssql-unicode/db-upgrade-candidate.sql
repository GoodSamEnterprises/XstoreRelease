 -- ***************************************************************************
-- This script is a "staging area" for database schema changes proposed by development and subject
-- to review and acceptance/rejection/modification by the DBA.
--
-- Developers should manually apply this script to their local environments to enable them to run
-- Xstore against recently implemented changes while the schema modification review process is
-- pending/underway.  Published builds, however, must always incorporate the approved schema changes
-- represented in the companion script db-upgrade.sql.
--
-- For any SQL statement X included here, the following must be true:
--
-- *** X converts one or more schema artifacts from a <source>-compatible form to a <target>-
--     compatible form, where <source> and <target> represent a legacy Xstore release version and a
--     more modern release version, respectively.
--
-- *** If X is modified or rejected by the DBA, the developer adding X to this script is responsible
--     for updating the relevant programmatic artifacts and pre-defined data depending on the
--     modified/rejected changes.
--
-- *** If X is associated with a new or enhanced Xstore feature, it should be annotated with its
--     corresponding PTS activity as follows:
--          <SQL statement>     -- [<PTS ActivityID>]
--     e.g. ALTER TABLE some_table ADD some_col nvarchar(30);      -- [278754]
--
--     Multiple SQL statements can be associated with a single activity using a start/end notation:
--          -- [<PTS ActivityID>]
--          <SQL Statement 1>
--          <SQL Statement n>
--          -- [/<PTS ActivityID>]
--
--     e.g. -- [278754]
--          ALTER TABLE some_table ADD some_col nvarchar(30);
--          ALTER TABLE some_table ADD some_other_col nvarchar(30);
--          -- [/278754]
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

--[RXPS-14786]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sort_order' AND object_id = OBJECT_ID('com_button_grid'))
BEGIN
  ALTER TABLE com_button_grid DROP CONSTRAINT pk_com_button_grid;

  ALTER TABLE com_button_grid ADD sort_order int NOT NULL DEFAULT 0;

  ALTER TABLE com_button_grid ADD CONSTRAINT pk_com_button_grid
    PRIMARY KEY CLUSTERED (organization_id, level_code, level_value, grid_id, row_id, column_id, component_id, sort_order) WITH (FILLFACTOR = 80);
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'action_idx' AND object_id = OBJECT_ID('com_button_grid'))
  ALTER TABLE com_button_grid ADD action_idx int null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'animation_idx' AND object_id = OBJECT_ID('com_button_grid'))
  ALTER TABLE com_button_grid ADD animation_idx int null;
GO
--[/RXPS-14786]

--[RXPS-16239, RXPS-16539]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'safe_bag_id' AND object_id = OBJECT_ID('tsn_tndr_control_trans'))
  ALTER TABLE tsn_tndr_control_trans ADD safe_bag_id nvarchar(60) null;
GO
--[/RXPS-16239, RXPS-16539]

--[RXPS-15284]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ext_invoice_id' AND object_id = OBJECT_ID('civc_invoice'))
  ALTER TABLE civc_invoice ADD ext_invoice_id nvarchar(60) null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'gross_amt' AND object_id = OBJECT_ID('civc_invoice'))
  ALTER TABLE civc_invoice ADD gross_amt decimal(17, 6) null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'refund_amt' AND object_id = OBJECT_ID('civc_invoice'))
  ALTER TABLE civc_invoice ADD refund_amt decimal(17, 6) null;
GO
--[/RXPS-15284]

--[RXPS-16187]
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

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sale_lineitm_typecode' AND object_id = OBJECT_ID('itm_item_restriction'))
BEGIN
  ALTER TABLE itm_item_restriction DROP CONSTRAINT pk_itm_item_restriction;

  ALTER TABLE itm_item_restriction ADD sale_lineitm_typecode nvarchar(30) NOT NULL DEFAULT 'ANY';
  ALTER TABLE itm_item_restriction ADD property_name nvarchar(30) NOT NULL DEFAULT 'DEFAULT';

  ALTER TABLE itm_item_restriction ADD CONSTRAINT pk_itm_item_restriction
  PRIMARY KEY CLUSTERED (organization_id, restriction_category, restriction_code, effective_date, sale_lineitm_typecode, property_name) WITH (FILLFACTOR = 80);

  PRINT 'itm_item_restriction.sale_lineitm_typecode created'
  PRINT 'itm_item_restriction.property_name created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sale_lineitm_typecode' AND object_id = OBJECT_ID('itm_item_restriction_p'))
BEGIN
  ALTER TABLE itm_item_restriction_p DROP CONSTRAINT pk_itm_item_restriction_p;

  ALTER TABLE itm_item_restriction_p ADD sale_lineitm_typecode nvarchar(30) NOT NULL DEFAULT 'ANY';
  ALTER TABLE itm_item_restriction_p ADD property_name nvarchar(30) NOT NULL DEFAULT 'DEFAULT';

  ALTER TABLE itm_item_restriction_p ADD CONSTRAINT pk_itm_item_restriction_p
  PRIMARY KEY CLUSTERED (organization_id, restriction_category, restriction_code, effective_date, sale_lineitm_typecode, property_name, property_code) WITH (FILLFACTOR = 80);

  PRINT 'itm_item_restriction_p.sale_lineitm_typecode created'
  PRINT 'itm_item_restriction_p.property_name created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sale_lineitm_typecode' AND object_id = OBJECT_ID('itm_item_restrict_calendar'))
BEGIN
  ALTER TABLE itm_item_restrict_calendar DROP CONSTRAINT pk_itm_item_restriction_cal;

  ALTER TABLE itm_item_restrict_calendar ADD sale_lineitm_typecode nvarchar(30) NOT NULL DEFAULT 'ANY';
  ALTER TABLE itm_item_restrict_calendar ADD exemption_flag bit NOT NULL DEFAULT 0;

  ALTER TABLE itm_item_restrict_calendar ADD CONSTRAINT pk_itm_item_restriction_cal
  PRIMARY KEY CLUSTERED (organization_id, restriction_category, restriction_code, effective_date, day_code, start_time, sale_lineitm_typecode) WITH (FILLFACTOR = 80);

  PRINT 'itm_item_restrict_calendar.sale_lineitm_typecode created'
  PRINT 'itm_item_restrict_calendar.exemption_flag created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sale_lineitm_typecode' AND object_id = OBJECT_ID('itm_item_restrict_calendar_p'))
BEGIN
  ALTER TABLE itm_item_restrict_calendar_p DROP CONSTRAINT pkitmitemrestrictcalendarp;

  ALTER TABLE itm_item_restrict_calendar_p ADD sale_lineitm_typecode nvarchar(30) NOT NULL DEFAULT 'ANY';

  ALTER TABLE itm_item_restrict_calendar_p ADD CONSTRAINT pkitmitemrestrictcalendarp
  PRIMARY KEY CLUSTERED (organization_id, restriction_category, restriction_code, effective_date, day_code, start_time, sale_lineitm_typecode) WITH (FILLFACTOR = 80);

  PRINT 'itm_item_restrict_calendar_p.sale_lineitm_typecode created'
  PRINT 'itm_item_restrict_calendar_p.exemption_flag created'
END
GO


/*
 * TABLE: [dbo].[itm_item_restrict_mapping]
 */
IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('itm_item_restrict_mapping'))
BEGIN
  CREATE TABLE [dbo].[itm_item_restrict_mapping](
    [organization_id]           int            NOT NULL,
    [merch_hierarchy_level]     nvarchar(60)    NOT NULL,
    [merch_hierarchy_id]        nvarchar(60)    NOT NULL,
    [restriction_category]      nvarchar(30)    NOT NULL,
    [org_code]                  nvarchar(30)    DEFAULT '*' NOT NULL,
    [org_value]                 nvarchar(60)    DEFAULT '*' NOT NULL,
    [create_date]               datetime       NULL,
    [create_user_id]            nvarchar(30)    NULL,
    [update_date]               datetime       NULL,
    [update_user_id]            nvarchar(30)    NULL,
    [record_state]              nvarchar(30)    NULL,
    CONSTRAINT [pk_itm_item_restrict_map] PRIMARY KEY CLUSTERED ([organization_id], [merch_hierarchy_level], [merch_hierarchy_id], [restriction_category]) WITH (FILLFACTOR = 80)
)

  CREATE INDEX idx_itm_itm_restrctmap_orgnode ON itm_item_restrict_mapping (org_code,org_value) WITH (FILLFACTOR = 80)
  PRINT 'itm_item_restrict_mapping created'
END
go

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE object_id = OBJECT_ID('itm_item_restrict_mapping_p'))
BEGIN
  exec Create_Property_Table itm_item_restrict_mapping;
  PRINT 'itm_item_restrict_mapping_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE object_id = OBJECT_ID('com_button_grid_p'))
BEGIN
  exec Create_Property_Table com_button_grid;
  PRINT 'com_button_grid_p created'
END
GO
--[/RXPS-16187]

--[RXPS-17100]
--
-- TABLE:  [dbo].[com_airport]
--
IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('com_airport'))
BEGIN
  CREATE TABLE [dbo].[com_airport] (
    organization_id         int           NOT NULL,
    airport_code            nvarchar(3)    NOT NULL,
    airport_name            nvarchar(254)  NOT NULL,
    country_code            nvarchar(2)    NOT NULL,
    zone_id                 nvarchar(30)   NOT NULL,
    create_date             datetime      NULL,
    create_user_id          nvarchar(30)   NULL,
    update_date             datetime      NULL,
    update_user_id          nvarchar(30)   NULL,
    record_state            nvarchar(30)   NULL,
    CONSTRAINT [pk_com_airport] PRIMARY KEY CLUSTERED ([organization_id], [airport_code]) WITH (FILLFACTOR = 80)
   )
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('com_airport_p'))
BEGIN
  exec Create_Property_Table com_airport;
  PRINT 'com_airport_p created'
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

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_flight_number' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_flight_number nvarchar(30) null;
  PRINT 'trl_rtrans_flight_info.first_flight_number added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_destination_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_destination_airport nvarchar(3) null;
  PRINT 'trl_rtrans_flight_info.first_destination_airport added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_origin_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_origin_airport nvarchar(3) null;
  PRINT 'trl_rtrans_flight_info.first_origin_airport added'
END
GO

--New Columns to identify the user for resumen transactions operations
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_flight_seat_number' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_flight_seat_number nvarchar(4) null;
  PRINT 'trl_rtrans_flight_info.first_flight_seat_number added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_flight_scheduled_date' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_flight_scheduled_date datetime null;
  PRINT 'trl_rtrans_flight_info.first_flight_scheduled_date added'
END
GO


--Drop com_airport_zone_mapping
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

--drop zone_id column from rtl_loc_id
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'zone_id' AND object_id = OBJECT_ID('loc_rtl_loc'))
BEGIN
  ALTER TABLE loc_rtl_loc DROP COLUMN zone_id;
  PRINT 'loc_rtl_loc.zone_id dropped'
END
GO

--[/RXPS-17100]

--[/RXPS-17107]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ORIGIN_AIRPORT' AND object_id = OBJECT_ID('COM_FLIGHT_INFO'))
BEGIN
  ALTER TABLE COM_FLIGHT_INFO ADD ORIGIN_AIRPORT nvarchar(3) DEFAULT '' NOT NULL
  PRINT 'COM_FLIGHT_INFO.ORIGIN_AIRPORT added'

  ALTER TABLE COM_FLIGHT_INFO DROP CONSTRAINT pk_com_flight_info
  PRINT 'Drop current primary key'

  ALTER TABLE COM_FLIGHT_INFO ADD CONSTRAINT pk_com_flight_info PRIMARY KEY (organization_id, scheduled_date_time, origin_airport, flight_number)
  Print 'New primary key'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ORIGIN_AIRPORT' AND object_id = OBJECT_ID('COM_FLIGHT_INFO_P'))
BEGIN
  ALTER TABLE COM_FLIGHT_INFO_P ADD ORIGIN_AIRPORT nvarchar(3) DEFAULT '' NOT NULL
  PRINT 'COM_FLIGHT_INFO_P.ORIGIN_AIRPORT added'

  ALTER TABLE COM_FLIGHT_INFO_P DROP CONSTRAINT pk_com_flight_info_p
  PRINT 'Drop current primary key'

  ALTER TABLE COM_FLIGHT_INFO_P ADD CONSTRAINT pk_com_flight_info_p PRIMARY KEY (organization_id, scheduled_date_time, origin_airport, flight_number, property_code)
  Print 'New primary key'
END
GO
--[/RXPS-17107]

--[RXPS-18272]
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_typecode' AND object_id = OBJECT_ID('itm_item_options'))
BEGIN
  ALTER TABLE itm_item_options DROP COLUMN tare_typecode;
  PRINT 'itm_item_options.tare_typecode dropped'
END

IF EXISTS (SELECT 1 FROM sys.columns where object_id = OBJECT_ID('itm_tare_type'))
BEGIN
  DROP TABLE itm_tare_type
  PRINT 'itm_tare_type dropped'
END

IF EXISTS (SELECT 1 FROM sys.columns where object_id = OBJECT_ID('itm_tare_type_p'))
BEGIN
  DROP TABLE itm_tare_type_p
  PRINT 'itm_tare_type dropped_p'
END

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_value' AND object_id = OBJECT_ID('itm_item_options'))
  ALTER TABLE itm_item_options ADD tare_value decimal(11, 4) null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_unit_of_measure_code' AND object_id = OBJECT_ID('itm_item_options'))
  ALTER TABLE itm_item_options ADD tare_unit_of_measure_code nvarchar(30) null;
GO
--[/RXPS-18272]

--[RXPS-19611]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'serial_nbr' AND object_id = OBJECT_ID('trl_kit_component_mod'))
BEGIN
  ALTER TABLE trl_kit_component_mod ADD serial_nbr nvarchar(60) NULL;
  PRINT 'trl_kit_component_mod.serial_nbr created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'seq_nbr' AND object_id = OBJECT_ID('itm_kit_component'))
BEGIN
  ALTER TABLE itm_kit_component DROP CONSTRAINT pk_itm_kit_component;
  PRINT 'itm_kit_component primary key dropped'

  ALTER TABLE itm_kit_component ADD seq_nbr  int NOT NULL DEFAULT 1;
  PRINT 'itm_kit_component.seq_nbr created'

  ALTER TABLE itm_kit_component ADD CONSTRAINT pk_itm_kit_component
    PRIMARY KEY CLUSTERED (organization_id, kit_item_id, component_item_id, seq_nbr) WITH (FILLFACTOR = 80)
  PRINT 'Primary key created itm_kit_component'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'seq_nbr' AND object_id = OBJECT_ID('itm_kit_component_p'))
BEGIN
	ALTER TABLE itm_kit_component_p DROP CONSTRAINT pk_itm_kit_component_p;
  PRINT 'itm_kit_component_p primary key dropped'

  ALTER TABLE itm_kit_component_p ADD seq_nbr  int NOT NULL DEFAULT 1;
  PRINT 'itm_kit_component_p.seq_nbr created'

  ALTER TABLE itm_kit_component_p ADD CONSTRAINT pk_itm_kit_component_p
    PRIMARY KEY CLUSTERED (organization_id, kit_item_id, component_item_id, seq_nbr, property_code) WITH (FILLFACTOR = 80)
  PRINT 'Primary key created itm_kit_component_p'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'seq_nbr' AND object_id = OBJECT_ID('trl_kit_component_mod'))
BEGIN
  ALTER TABLE trl_kit_component_mod DROP CONSTRAINT pk_trl_kit_component_mod;
  PRINT 'trl_kit_component_mod primary key dropped'
  ALTER TABLE trl_kit_component_mod ADD seq_nbr int NOT NULL DEFAULT 1;
  PRINT 'trl_kit_component_mod.seq_nbr created'
  ALTER TABLE trl_kit_component_mod ADD CONSTRAINT pk_trl_kit_component_mod
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, component_item_id, seq_nbr) WITH (FILLFACTOR = 80);
  PRINT 'Primary key created trl_kit_component_mod'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'seq_nbr' AND object_id = OBJECT_ID('trl_kit_component_mod_p'))
BEGIN
  ALTER TABLE trl_kit_component_mod_p DROP CONSTRAINT pk_trl_kit_component_mod_p;
  PRINT 'trl_kit_component_mod_p primary key dropped'
  ALTER TABLE trl_kit_component_mod_p ADD seq_nbr int NOT NULL DEFAULT 1;
  PRINT 'trl_kit_component_mod_p.seq_nbr created'
  ALTER TABLE trl_kit_component_mod_p ADD CONSTRAINT pk_trl_kit_component_mod_p
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, component_item_id, seq_nbr, property_code) WITH (FILLFACTOR = 80);
  PRINT 'Primary key created trl_kit_component_mod_p'
END
GO
--[/RXPS-19611]

--[RXPS-18536]
PRINT 'CPAF_CARD_NETWORK'
IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_card_network'))
CREATE TABLE cpaf_card_network (
  organization_id              INT           NOT NULL,
  network_name                 nvarchar(254) NOT NULL,  
  network_id                   nvarchar(30)  NULL,
  tax_id                       nvarchar(30)  NULL,
  create_date                  DATETIME      NULL,
  create_user_id               nvarchar(30)  NULL,
  update_date                  DATETIME      NULL,
  update_user_id               nvarchar(30)  NULL,
  record_state                 nvarchar(30)  NULL,
  CONSTRAINT [pk_cpaf_card_network]
    PRIMARY KEY CLUSTERED (organization_id, network_name) WITH (FILLFACTOR = 80)
)
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'network_id' AND object_id = OBJECT_ID('cpaf_card_network'))
BEGIN
  ALTER TABLE cpaf_card_network ADD network_id nvarchar(30) NULL;
  PRINT 'cpaf_card_network.network_id created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tax_id' AND object_id = OBJECT_ID('cpaf_card_network'))
BEGIN
  ALTER TABLE cpaf_card_network ADD tax_id nvarchar(30) NULL;
  PRINT 'cpaf_card_network.tax_id created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_card_network_p'))
BEGIN
  exec Create_Property_Table cpaf_card_network;
  PRINT 'cpaf_card_network_p created'
END
GO
--[/RXPS-18536]

--[/RXPS-17100]
--Standarizing field sizes

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_airport' AND object_id = OBJECT_ID('com_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM com_flight_info WHERE LEN(destination_airport)>3)
  ALTER TABLE com_flight_info ALTER COLUMN destination_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_1_airport' AND object_id = OBJECT_ID('com_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM com_flight_info WHERE LEN(via_1_airport)>3)
  ALTER TABLE com_flight_info ALTER COLUMN via_1_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_2_airport' AND object_id = OBJECT_ID('com_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM com_flight_info WHERE LEN(via_2_airport)>3)
  ALTER TABLE com_flight_info ALTER COLUMN via_2_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_3_airport' AND object_id = OBJECT_ID('com_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM com_flight_info WHERE LEN(via_3_airport)>3)
  ALTER TABLE com_flight_info ALTER COLUMN via_3_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'expiration_date' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN expiration_date;
  PRINT 'com_flight_info.expiration_date dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM trl_rtrans_flight_info WHERE LEN(destination_airport)>3)
  ALTER TABLE trl_rtrans_flight_info ALTER COLUMN destination_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'origin_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM trl_rtrans_flight_info WHERE LEN(origin_airport)>3)
  ALTER TABLE trl_rtrans_flight_info ALTER COLUMN origin_airport nvarchar(3) NULL;
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

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'airport_code' AND object_id = OBJECT_ID('loc_rtl_loc'))
BEGIN
  ALTER TABLE loc_rtl_loc ADD airport_code nvarchar(3) null;
  PRINT 'loc_rtl_loc.airport_code added'
END
GO
--[/RXPS-17100]

--[RXPS-15284] - Tax Free integration
IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('civc_taxfree_country'))
BEGIN
  CREATE TABLE [dbo].[civc_taxfree_country](
    [organization_id]         int                 NOT NULL,
    [rtl_loc_id]              int                 NOT NULL,
    [wkstn_id]                bigint              NOT NULL,
    [iso3num_code]            nvarchar(3)          NOT NULL,
    [iso2alp_code]            nvarchar(2)          NULL,
    [name]                    nvarchar(150)        NULL,
    [phone_prefix]            nvarchar(4)          NULL,
    [passport_code]           nvarchar(10)         NULL,
    [void_flag]               bit                 DEFAULT 0 NULL,
    [blocked_flag]            bit                 DEFAULT 0 NULL,
    [create_date]             datetime            NULL,
    [create_user_id]          nvarchar(30)         NULL,
    [update_date]             datetime            NULL,
    [update_user_id]          nvarchar(30)         NULL,
    [record_state]            nvarchar(30)         NULL,
    CONSTRAINT [pk_civc_taxfree_country] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [iso3num_code]) WITH (FILLFACTOR = 80)
  )
  PRINT 'civc_taxfree_country created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('civc_taxfree_country_p'))
BEGIN
  exec Create_Property_Table civc_taxfree_country;
  PRINT 'civc_taxfree_country_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('civc_taxfree_card_range'))
BEGIN
  CREATE TABLE [dbo].[civc_taxfree_card_range](
    [organization_id]         int                 NOT NULL,
    [rtl_loc_id]              int                 NOT NULL,
    [wkstn_id]                bigint              NOT NULL,
    [range_start]             nvarchar(8)          NOT NULL,
    [range_end]               nvarchar(8)          NULL,
    [create_date]             datetime            NULL,
    [create_user_id]          nvarchar(30)         NULL,
    [update_date]             datetime            NULL,
    [update_user_id]          nvarchar(30)         NULL,
    [record_state]            nvarchar(30)         NULL,
    CONSTRAINT [pk_civc_taxfree_card_range] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [range_start]) WITH (FILLFACTOR = 80)
  )
  PRINT 'civc_taxfree_card_range created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('civc_taxfree_card_range_p'))
BEGIN
  exec Create_Property_Table civc_taxfree_card_range;
  PRINT 'civc_taxfree_card_range_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'invoice_date' AND object_id = OBJECT_ID('civc_invoice'))
BEGIN
  ALTER TABLE civc_invoice ADD invoice_date datetime NULL;
  PRINT 'civc_invoice.invoice_date created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ext_invoice_barcode' AND object_id = OBJECT_ID('civc_invoice'))
BEGIN
  ALTER TABLE civc_invoice ADD ext_invoice_barcode nvarchar(60) NULL;
  PRINT 'civc_invoice.ext_invoice_barcode created'
END
GO
--[/RXPS-15284]

--[]
--Begin Misalignment of table structure between Oracle and Sql Server script for table itm_item_p
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'expiration_date' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
  ALTER TABLE itm_item_p DROP COLUMN expiration_date;
  PRINT 'itm_item_p.expiration_date dropped'
END
GO
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
--End Misalignment of table structure between Oracle and Sql Server script for table
--[/]



--[RXPS-19733]
IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('ctl_ip_cashdrawer_device'))
BEGIN
  CREATE TABLE [dbo].[ctl_ip_cashdrawer_device](
      [organization_id]     int             NOT NULL,
      [rtl_loc_id]          int             NOT NULL,
      [cash_drawer_id]      nvarchar(60)     NOT NULL,
      [drawer_status]       nvarchar(40),
      [product_name]        nvarchar(80),
      [description]         nvarchar(80),
      [serial_number]       nvarchar(40),
      [ip_address]          nvarchar(16),
      [tcp_port]            int,
      [mac_address]         nvarchar(20),
      [subnet_mask]         nvarchar(16),
      [gateway]             nvarchar(16),
      [dns_hostname]        nvarchar(16),
      [dhcp_flag]           bit             DEFAULT ((0)) NULL,
      [firmware_version]    nvarchar(20),
      [kup]                 nvarchar(1024),
      [kup_update_date]     datetime,
      [beep_on_open_flag]   bit             DEFAULT ((0)) NULL,
      [beep_long_open_flag] bit             DEFAULT ((0)) NULL,
      [create_date]         datetime        NULL,
      [create_user_id]      nvarchar(30)     NULL,
      [update_date]         datetime        NULL,
      [update_user_id]      nvarchar(30)     NULL,
      [record_state]        nvarchar(30)     NULL,
      CONSTRAINT [pk_ctl_ip_cashdrawer_device] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [cash_drawer_id]) WITH (FILLFACTOR = 80)
  )
  PRINT 'ctl_ip_cashdrawer_device created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'cash_drawer_id' AND object_id = OBJECT_ID('tsn_session'))
BEGIN
  ALTER TABLE tsn_session ADD cash_drawer_id nvarchar(60);
  PRINT 'tsn_session.cash_drawer_id added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('ctl_ip_cashdrawer_device_p'))
BEGIN
  exec Create_Property_Table ctl_ip_cashdrawer_device;
  PRINT 'ctl_ip_cashdrawer_device_p created'
END
GO
--[/RXPS-19733]

--[/RXPS-21041]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tax_override_comment' AND object_id = OBJECT_ID('trl_sale_tax_lineitm'))
BEGIN
  ALTER TABLE trl_sale_tax_lineitm ADD tax_override_comment nvarchar(255);
  PRINT 'trl_sale_tax_lineitm.tax_override_comment added'
END
GO
--[/RXPS-21041]

--[RXPS-17705]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'trans_date' AND object_id = OBJECT_ID('trn_trans'))
BEGIN
    ALTER TABLE trn_trans ADD trans_date datetime NULL;
    PRINT 'trn_trans.trans_date created';
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.indexes WHERE name = 'idx_trn_trans05' AND object_id = OBJECT_ID('trn_trans'))
BEGIN
    CREATE INDEX idx_trn_trans05 ON trn_trans(trans_date)  WITH (FILLFACTOR = 80);
    PRINT 'trn_trans.idx_trn_trans05 created';
    UPDATE trn_trans SET trans_date =  CONVERT(DATETIME, CONVERT(date,begin_datetime)) WHERE trans_date IS NULL;
    PRINT 'Updated trn_trans.trans_date using information from trn_trans.begin_datetime';
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'trans_date' AND object_id = OBJECT_ID('rpt_sale_line'))
BEGIN
    ALTER TABLE rpt_sale_line ADD trans_date datetime NULL;
    PRINT 'rpt_sale_line.trans_date created';
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.indexes WHERE name = 'idx_rpt_sale_line04' AND object_id = OBJECT_ID('rpt_sale_line'))
BEGIN
    CREATE INDEX idx_rpt_sale_line04 ON rpt_sale_line(trans_date)  WITH (FILLFACTOR = 80);
    PRINT 'rpt_sale_line.idx_rpt_sale_line04 created';
    UPDATE rpt_sale_line SET trans_date =  CONVERT(DATETIME, CONVERT(date,trans_timestamp)) WHERE trans_date IS NULL;
    PRINT 'Updated rpt_sale_line.trans_date using information from rpt_sale_line.trans_timestamp';
END
GO

IF EXISTS (Select * From sysobjects Where name = 'sp_flash' and type = 'P')
  DROP PROCEDURE sp_flash;
GO

CREATE PROCEDURE dbo.sp_flash (
@argOrganizationId int,  /*organization id*/
@argRetailLocationId int,  /*retail location or store number*/
@argBusinessDate datetime,  /*business date*/
@argWrkstnId bigint,  /*register*/
@argTransSeq bigint)  /*trans sequence*/
as

declare @old_context_info varbinary(128)=context_info();
SET CONTEXT_INFO 0x0111001101110000010111110110011001101100011000010111001101101000

declare -- Quantities
@vActualQuantity decimal(11, 2),
@vGrossQuantity decimal(11, 2),
@vQuantity decimal(11, 2),
@vTotQuantity decimal(11, 2)

declare -- Amounts
@vNetAmount decimal(17, 6),
@vGrossAmount decimal(17, 6),
@vTotGrossAmt decimal(17, 6),
@vTotNetAmt decimal(17, 6),
@vDiscountAmt decimal(17, 6),
@vOverrideAmt decimal(17, 6),
@vPaidAmt decimal(17, 6),
@vTenderAmt decimal(17, 6),
@vForeign_amt decimal(17, 6),
@vLayawayPrice decimal(17, 6),
@vUnitPrice decimal(17, 6),
@vAccountCredit decimal(17, 6)

declare -- Non Physical Items
@vNonPhys nvarchar(30),
@vNonPhysSaleType nvarchar(30),
@vNonPhysType nvarchar(30),
@vNonPhysPrice decimal(17, 6),
@vNonPhysQuantity decimal(11, 2)

declare -- Status codes
@vTransStatcode nvarchar(30),
@vTransTypcode nvarchar(30),
@vSaleLineItmTypcode nvarchar(30),
@vTndrStatcode nvarchar(60),
@vLineitemStatcode nvarchar(30)

declare -- others
@vTransTimeStamp datetime,
@vTransDate datetime,
@vTransCount int,
@vTndrCount int,
@vPostVoidFlag bit,
@vReturnFlag bit,
@vTaxTotal decimal(17, 6),
@vPaid nvarchar(30),
@vLineEnum nvarchar(150),
@vTndrId nvarchar(60),
@vItemId nvarchar(60),
@vRtransLineItmSeq int,
@vDepartmentId nvarchar(90),
@vTndridProp nvarchar(60),
@vCurrencyId nvarchar(3)

declare
@vSerialNbr nvarchar(60),
@vPriceModAmt decimal(17, 6),
@vPriceModReascode nvarchar(60),
@vNonPhysExcludeFlag bit,
@vCustPartyId nvarchar(60),
@vCustLastName nvarchar(90),
@vCustFirstName nvarchar(90),
@vItemDesc nvarchar(120),
@vBeginTimeInt int


select @vTransStatcode = trans_statcode,
@vTransTypcode = trans_typcode,
@vTransTimeStamp = begin_datetime,
@vTransDate = trans_date,
@vTaxTotal = taxtotal,
@vPostVoidFlag = post_void_flag,
@vBeginTimeInt = begin_time_int
from trn_trans with (nolock)
where organization_id = @argOrganizationId
and rtl_loc_id = @argRetailLocationId
and wkstn_id = @argWrkstnId
and business_date = @argBusinessDate
and trans_seq = @argTransSeq

if @@rowcount = 0 
  return  /* Invalid transaction */

select @vCurrencyId = max(currency_id)
from ttr_tndr_lineitm ttl with (nolock)
inner join tnd_tndr tnd with (nolock) on ttl.organization_id=tnd.organization_id and ttl.tndr_id=tnd.tndr_id
where ttl.organization_id = @argOrganizationId
and rtl_loc_id = @argRetailLocationId
and wkstn_id = @argWrkstnId
and business_date = @argBusinessDate
and trans_seq = @argTransSeq

if @vCurrencyId is null
select @vCurrencyId = max(currency_id)
from loc_rtl_loc with (nolock)
where organization_id = @argOrganizationId
and rtl_loc_id = @argRetailLocationId

-- Sundar commented the following as rpt sale line has to capture all the transactions
-- if @vTransStatcode != 'COMPLETE' and @vTransStatcode != 'SUSPEND' 
--  return

set @vTransCount = 1 /* initializing the transaction count */


-- update trans
update trn_trans set flash_sales_flag = 1
where organization_id = @argOrganizationId
and rtl_loc_id = @argRetailLocationId 
and wkstn_id = @argWrkstnId 
and trans_seq = @argTransSeq
and business_date = @argBusinessDate

-- BCW Added code to only update post voids if the original transaction 
if @vPostVoidFlag=1 and not exists(select 1 from rpt_sale_line where organization_id = @argOrganizationId
          and rtl_loc_id = @argRetailLocationId
          and wkstn_id = @argWrkstnId
          and trans_seq = @argTransSeq
          and business_date = @argBusinessDate)
      begin
       insert into rpt_sale_line WITH(ROWLOCK)
      (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq,
      quantity, actual_quantity, gross_quantity, unit_price, net_amt, gross_amt, item_id, 
      item_desc, merch_level_1, serial_nbr, return_flag, override_amt, trans_timestamp, trans_date,
      discount_amt, cust_party_id, last_name, first_name, trans_statcode, sale_lineitm_typcode, begin_time_int,
      currency_id, exclude_from_net_sales_flag)
      select tsl.organization_id, tsl.rtl_loc_id, tsl.business_date, tsl.wkstn_id, tsl.trans_seq, tsl.rtrans_lineitm_seq,
      tsl.net_quantity, tsl.quantity, tsl.gross_quantity, tsl.unit_price, tsl.net_amt, tsl.gross_amt, tsl.item_id,
      i.DESCRIPTION, coalesce(tsl.merch_level_1,i.MERCH_LEVEL_1,N'DEFAULT'), tsl.serial_nbr, tsl.return_flag, coalesce(o.override_amt,0), @vTransTimeStamp, @vTransDate, 
      coalesce(d.discount_amt,0), tr.cust_party_id, cust.last_name, cust.first_name, 'VOID', tsl.sale_lineitm_typcode, 
      @vBeginTimeInt, @vCurrencyId, tsl.exclude_from_net_sales_flag
      from trl_sale_lineitm tsl with (nolock) 
      inner join trl_rtrans_lineitm r with (nolock)
      on tsl.organization_id=r.organization_id
      and tsl.rtl_loc_id=r.rtl_loc_id
      and tsl.wkstn_id=r.wkstn_id
      and tsl.trans_seq=r.trans_seq
      and tsl.business_date=r.business_date
      and tsl.rtrans_lineitm_seq=r.rtrans_lineitm_seq
      and r.rtrans_lineitm_typcode = N'ITEM'
      left join xom_order_mod xom  with (nolock)
      on tsl.organization_id=xom.organization_id
      and tsl.rtl_loc_id=xom.rtl_loc_id
      and tsl.wkstn_id=xom.wkstn_id
      and tsl.trans_seq=xom.trans_seq
      and tsl.business_date=xom.business_date
      and tsl.rtrans_lineitm_seq=xom.rtrans_lineitm_seq
      left join xom_order_line xol  with (nolock)
      on xom.organization_id=xol.organization_id
      and xom.order_id=xol.order_id
      and xom.detail_seq=xol.detail_seq
      left join itm_item i
      on tsl.organization_id=i.ORGANIZATION_ID
      and tsl.item_id=i.ITEM_ID
      left join (select extended_amt override_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
        FROM trl_rtl_price_mod with(nolock)
        WHERE void_flag = 0 and rtl_price_mod_reascode=N'PRICE_OVERRIDE') o
      on tsl.organization_id = o.organization_id 
        AND tsl.rtl_loc_id = o.rtl_loc_id
        AND tsl.business_date = o.business_date 
        AND tsl.wkstn_id = o.wkstn_id 
        AND tsl.trans_seq = o.trans_seq
        AND tsl.rtrans_lineitm_seq = o.rtrans_lineitm_seq
      left join (select sum(extended_amt) discount_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
        FROM trl_rtl_price_mod with(nolock)
        WHERE void_flag = 0 and rtl_price_mod_reascode in (N'LINE_ITEM_DISCOUNT', N'TRANSACTION_DISCOUNT',N'GROUP_DISCOUNT', N'NEW_PRICE_RULE', N'DEAL')
        group by organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq) d
      on tsl.organization_id = d.organization_id 
        AND tsl.rtl_loc_id = d.rtl_loc_id
        AND tsl.business_date = d.business_date 
        AND tsl.wkstn_id = d.wkstn_id 
        AND tsl.trans_seq = d.trans_seq
        AND tsl.rtrans_lineitm_seq = d.rtrans_lineitm_seq
      left join trl_rtrans tr with(nolock)
      on tsl.organization_id = tr.organization_id 
        AND tsl.rtl_loc_id = tr.rtl_loc_id
        AND tsl.business_date = tr.business_date 
        AND tsl.wkstn_id = tr.wkstn_id 
        AND tsl.trans_seq = tr.trans_seq
      left join crm_party cust with(nolock)
      on tsl.organization_id = cust.organization_id 
        AND tr.cust_party_id = cust.party_id
      where tsl.organization_id = @argOrganizationId
      and tsl.rtl_loc_id = @argRetailLocationId
      and tsl.wkstn_id = @argWrkstnId
      and tsl.business_date = @argBusinessDate
      and tsl.trans_seq = @argTransSeq
      and r.void_flag=0
      and ((tsl.SALE_LINEITM_TYPCODE <> N'ORDER'and (xom.detail_type IS NULL OR xol.status_code = N'FULFILLED') )
      or (tsl.SALE_LINEITM_TYPCODE = N'ORDER' and xom.detail_type in (N'FEE', N'PAYMENT') ))
  return;
  end

-- collect transaction data
if abs(@vTaxTotal) > 0 and (@vTransTypcode <> 'POST_VOID' and @vPostVoidFlag = 0) and @vTransStatcode = 'COMPLETE'
  exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
  @argWrkstnId,'TotalTax', 1, @vTaxTotal, @vCurrencyId          

IF @vTransTypcode = 'TENDER_CONTROL' and @vPostVoidFlag = 0
  -- process for paid in paid out 
  begin 
    select @vPaid = typcode,@vPaidAmt = amt 
    from tsn_tndr_control_trans with (nolock)  
    where typcode like 'PAID%'
          and organization_id = @argOrganizationId
          and rtl_loc_id = @argRetailLocationId
          and wkstn_id = @argWrkstnId
          and trans_seq = @argTransSeq
          and business_date = @argBusinessDate
            
    IF @@rowcount = 1
      -- it is paid in or paid out
      begin 
        if @vPaid = 'PAID_IN' or @vPaid = 'PAIDIN'
          set @vLineEnum = 'paidin'
        else
          set @vLineEnum = 'paidout'
        -- update flash sales
        if @vTransStatcode = 'COMPLETE'                
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,@vLineEnum, 1, @vPaidAmt, @vCurrencyId

      end 
  end
-- collect tenders  data
if @vPostVoidFlag = 0 and @vTransTypcode <> 'POST_VOID'
  begin

    declare tenderCursor cursor for 
    select t.amt, t.foreign_amt, t.tndr_id, t.tndr_statcode,tr.string_value
    from ttr_tndr_lineitm t with (nolock) 
    inner join trl_rtrans_lineitm r with (nolock)
    on t.organization_id=r.organization_id
    and t.rtl_loc_id=r.rtl_loc_id
    and t.wkstn_id=r.wkstn_id
    and t.trans_seq=r.trans_seq
    and t.business_date=r.business_date
    and t.rtrans_lineitm_seq=r.rtrans_lineitm_seq
  left outer join trl_rtrans_lineitm_p tr with (nolock)
    on tr.organization_id=r.organization_id
    and tr.rtl_loc_id=r.rtl_loc_id
    and tr.wkstn_id=r.wkstn_id
    and tr.trans_seq=r.trans_seq
    and tr.business_date=r.business_date
    and tr.rtrans_lineitm_seq=r.rtrans_lineitm_seq
  and property_code = 'tender_id'
    where t.organization_id = @argOrganizationId
    and t.rtl_loc_id = @argRetailLocationId 
    and t.wkstn_id = @argWrkstnId 
    and t.trans_seq = @argTransSeq
    and t.business_date = @argBusinessDate
    and r.void_flag = 0
  and t.tndr_id <> 'ACCOUNT_CREDIT'

    open tenderCursor
    while 1=1 
      begin
        fetch next from tenderCursor into @vTenderAmt,@vForeign_amt,@vTndrid,@vTndrStatcode,@vTndridProp             
        if @@fetch_status <> 0 
          BREAK
        if @vTndrStatcode <> 'Change'
          set @vTndrCount = 1  -- only for original tenders
        else 
          set @vTndrCount = 0

         if @vTndridProp IS NOT NULL
           set @vTndrid = @vTndridProp
          
        if @vLineEnum = 'paidout'
          begin
            set @vTenderAmt = coalesce(@vTenderAmt, 0) * -1
            set @vForeign_amt = coalesce(@vForeign_amt, 0) * -1
          end

        -- update flash
        if @vTransStatcode = 'COMPLETE'                
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,@vTndrid,@vTndrCount,@vTenderAmt,@vCurrencyId
    
        if @vTenderAmt > 0 and @vTransStatcode = 'COMPLETE'                
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,'TendersTakenIn', 1,@vTenderAmt,@vCurrencyId
        else
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,'TendersRefunded', 1,@vTenderAmt,@vCurrencyId
    
      end
    close tenderCursor
    deallocate tendercursor
  end

-- collect post void info
if @vTransTypcode = 'POST_VOID' or @vPostVoidFlag = 1
  begin

    set @vTransCount = -1 /* reversing the count */
    if @vPostVoidFlag = 0
      begin
        set @vPostVoidFlag = 1
        -- get the original post voided transaction and set it as original parameters
        select  @argOrganizationId = voided_org_id,
          @argRetailLocationId = voided_rtl_store_id, 
          @argWrkstnId = voided_wkstn_id, 
          @argBusinessDate = voided_business_date, 
          @argTransSeq = voided_trans_id 
        from trn_post_void_trans with (nolock)
        where organization_id = @argOrganizationId
        and rtl_loc_id = @argRetailLocationId
        and wkstn_id = @argWrkstnId
        and business_date = @argBusinessDate
        and trans_seq = @argTransSeq
    
        /* NOTE: From now on the parameter value carries the original post voided
           information rather than the current transaction information in 
           case of post void trans type. This will apply for sales data 
           processing.
        */
              
        if @@rowcount = 0 
           return -- don't know the original post voided record

    if exists(select 1 from rpt_sale_line where organization_id = @argOrganizationId
          and rtl_loc_id = @argRetailLocationId
          and wkstn_id = @argWrkstnId
          and trans_seq = @argTransSeq
          and business_date = @argBusinessDate
      and trans_statcode = 'VOID')
      return;
      end
    -- update the rpt sale line for post void
   update rpt_sale_line
    set trans_statcode='VOID'
    where organization_id = @argOrganizationId
    and rtl_loc_id = @argRetailLocationId
    and wkstn_id = @argWrkstnId
    and business_date = @argBusinessDate
    and trans_seq = @argTransSeq        

    -- reverse padin paidout
    select @vPaid = typcode,@vPaidAmt = amt 
    from tsn_tndr_control_trans with (nolock)  
    where typcode like 'PAID%'
          and organization_id = @argOrganizationId
          and rtl_loc_id = @argRetailLocationId
          and wkstn_id = @argWrkstnId
          and trans_seq = @argTransSeq
          and business_date = @argBusinessDate
            
    IF @@rowcount = 1
      -- it is paid in or paid out
      begin 
        if @vPaid = 'PAID_IN' or @vPaid = 'PAIDIN'
          set @vLineEnum = 'paidin'
        else
          set @vLineEnum = 'paidout'
        set @vPaidAmt = @vPaidAmt * -1
        -- update flash sales  
        if @vTransStatcode = 'COMPLETE'                                
          exec sp_ins_upd_flash_sales @argOrganizationId, @argRetailLocationId, @vTransDate,
          @argWrkstnId, @vLineEnum, -1, @vPaidAmt, @vCurrencyId 

      end 
    -- reverse tax
    select @vTaxTotal=taxtotal from trn_trans with (nolock)
    where organization_id = @argOrganizationId
    and rtl_loc_id = @argRetailLocationId
    and wkstn_id = @argWrkstnId
    and business_date = @argBusinessDate
    and trans_seq = @argTransSeq
    

    if abs(@vTaxTotal) > 0 and @vTransStatcode = 'COMPLETE'
      begin
        set @vTaxTotal = @vTaxTotal * -1
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'TotalTax',-1,@vTaxTotal,@vCurrencyId
      end

    -- reverse tenders
    declare postVoidTenderCursor cursor for 
    select t.amt, t.foreign_amt, t.tndr_id, t.tndr_statcode,tr.string_value
    from ttr_tndr_lineitm t with (nolock) 
    inner join trl_rtrans_lineitm r with (nolock)
    on t.organization_id=r.organization_id
    and t.rtl_loc_id=r.rtl_loc_id
    and t.wkstn_id=r.wkstn_id
    and t.trans_seq=r.trans_seq
    and t.business_date=r.business_date
    and t.rtrans_lineitm_seq=r.rtrans_lineitm_seq
  left outer join trl_rtrans_lineitm_p tr with (nolock)
    on tr.organization_id=r.organization_id
    and tr.rtl_loc_id=r.rtl_loc_id
    and tr.wkstn_id=r.wkstn_id
    and tr.trans_seq=r.trans_seq
    and tr.business_date=r.business_date
    and tr.rtrans_lineitm_seq=r.rtrans_lineitm_seq
  and property_code = 'tender_id'
    where t.organization_id = @argOrganizationId
    and t.rtl_loc_id = @argRetailLocationId 
    and t.wkstn_id = @argWrkstnId 
    and t.trans_seq = @argTransSeq
    and t.business_date = @argBusinessDate
    and r.void_flag = 0
  and t.tndr_id <> 'ACCOUNT_CREDIT'

    open postVoidTenderCursor
    while 1=1 
      begin
        fetch next from postVoidTenderCursor into @vTenderAmt,@vForeign_amt,@vTndrid,@vTndrStatcode,@vTndridProp            
        if @@fetch_status <> 0 
                     BREAK
        if @vTndrStatcode <> 'Change'
          set @vTndrCount = -1  -- only for original tenders
        else 
          set @vTndrCount = 0

         if @vTndridProp IS NOT NULL
           set @vTndrid = @vTndridProp

        -- update flash
        set @vTenderAmt = @vTenderAmt * -1
 
       if @vTransStatcode = 'COMPLETE'
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,@vTndrid,@vTndrCount,@vTenderAmt,@vCurrencyId

        if @vTenderAmt < 0 and @vTransStatcode = 'COMPLETE'
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,'TendersTakenIn',-1,@vTenderAmt,@vCurrencyId
        else
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,'TendersRefunded',-1,@vTenderAmt,@vCurrencyId
  
      end
    close postVoidTenderCursor
    deallocate postVoidTenderCursor
  end

-- collect sales data
      if @vPostVoidFlag = 0 and @vTransTypcode <> 'POST_VOID' -- dont do it for rpt sale line
      begin
         insert into rpt_sale_line WITH(ROWLOCK)
        (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq,
        quantity, actual_quantity, gross_quantity, unit_price, net_amt, gross_amt, item_id, 
        item_desc, merch_level_1, serial_nbr, return_flag, override_amt, trans_timestamp, trans_date,
        discount_amt, cust_party_id, last_name, first_name, trans_statcode, sale_lineitm_typcode, 
        begin_time_int,currency_id, exclude_from_net_sales_flag)
    select tsl.organization_id, tsl.rtl_loc_id, tsl.business_date, tsl.wkstn_id, tsl.trans_seq, tsl.rtrans_lineitm_seq,
    tsl.net_quantity, tsl.quantity, tsl.gross_quantity, tsl.unit_price, tsl.net_amt, tsl.gross_amt, tsl.item_id,
    i.DESCRIPTION, coalesce(tsl.merch_level_1,i.MERCH_LEVEL_1,N'DEFAULT'), tsl.serial_nbr, tsl.return_flag, coalesce(o.override_amt,0), @vTransTimeStamp, @vTransDate,
    coalesce(d.discount_amt,0), tr.cust_party_id, cust.last_name, cust.first_name, @vTransStatcode, tsl.sale_lineitm_typcode, 
    @vBeginTimeInt, @vCurrencyId, tsl.exclude_from_net_sales_flag
    from trl_sale_lineitm tsl with (nolock) 
    inner join trl_rtrans_lineitm r with (nolock)
    on tsl.organization_id=r.organization_id
    and tsl.rtl_loc_id=r.rtl_loc_id
    and tsl.wkstn_id=r.wkstn_id
    and tsl.trans_seq=r.trans_seq
    and tsl.business_date=r.business_date
    and tsl.rtrans_lineitm_seq=r.rtrans_lineitm_seq
    and r.rtrans_lineitm_typcode = N'ITEM'
    left join xom_order_mod xom  with (nolock)
    on tsl.organization_id=xom.organization_id
    and tsl.rtl_loc_id=xom.rtl_loc_id
    and tsl.wkstn_id=xom.wkstn_id
    and tsl.trans_seq=xom.trans_seq
    and tsl.business_date=xom.business_date
    and tsl.rtrans_lineitm_seq=xom.rtrans_lineitm_seq
    left join xom_order_line xol  with (nolock)
    on xom.organization_id=xol.organization_id
    and xom.order_id=xol.order_id
    and xom.detail_seq=xol.detail_seq
    left join itm_item i
    on tsl.organization_id=i.ORGANIZATION_ID
    and tsl.item_id=i.ITEM_ID
    left join (select extended_amt override_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
      FROM trl_rtl_price_mod with(nolock)
      WHERE void_flag = 0 and rtl_price_mod_reascode=N'PRICE_OVERRIDE') o
    on tsl.organization_id = o.organization_id 
      AND tsl.rtl_loc_id = o.rtl_loc_id
      AND tsl.business_date = o.business_date 
      AND tsl.wkstn_id = o.wkstn_id 
      AND tsl.trans_seq = o.trans_seq
      AND tsl.rtrans_lineitm_seq = o.rtrans_lineitm_seq
    left join (select sum(extended_amt) discount_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
      FROM trl_rtl_price_mod with(nolock)
      WHERE void_flag = 0 and rtl_price_mod_reascode in (N'LINE_ITEM_DISCOUNT', N'TRANSACTION_DISCOUNT',N'GROUP_DISCOUNT', N'NEW_PRICE_RULE', N'DEAL')
      group by organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq) d
    on tsl.organization_id = d.organization_id 
      AND tsl.rtl_loc_id = d.rtl_loc_id
      AND tsl.business_date = d.business_date 
      AND tsl.wkstn_id = d.wkstn_id 
      AND tsl.trans_seq = d.trans_seq
      AND tsl.rtrans_lineitm_seq = d.rtrans_lineitm_seq
    left join trl_rtrans tr with(nolock)
    on tsl.organization_id = tr.organization_id 
      AND tsl.rtl_loc_id = tr.rtl_loc_id
      AND tsl.business_date = tr.business_date 
      AND tsl.wkstn_id = tr.wkstn_id 
      AND tsl.trans_seq = tr.trans_seq
    left join crm_party cust with(nolock)
    on tsl.organization_id = cust.organization_id 
      AND tr.cust_party_id = cust.party_id
    where tsl.organization_id = @argOrganizationId
    and tsl.rtl_loc_id = @argRetailLocationId
    and tsl.wkstn_id = @argWrkstnId
    and tsl.business_date = @argBusinessDate
    and tsl.trans_seq = @argTransSeq
    and r.void_flag=0
    and ((tsl.SALE_LINEITM_TYPCODE <> N'ORDER'and (xom.detail_type IS NULL OR xol.status_code = N'FULFILLED') )
    or (tsl.SALE_LINEITM_TYPCODE = N'ORDER' and xom.detail_type in (N'FEE', N'PAYMENT') ))
   end
    
    if @vTransStatcode = 'COMPLETE' -- only when complete populate flash sales
    begin 
    -- account credit on an order
    SELECT @vAccountCredit = sum(t.amt) 
    FROM xom_order_mod xo
    inner join ttr_tndr_lineitm t
    on xo.organization_id=t.organization_id
    and xo.rtl_loc_id=t.rtl_loc_id
    and xo.business_date=t.business_date
    and xo.wkstn_id=t.wkstn_id
    and xo.trans_seq=t.trans_seq
    where t.organization_id = @argOrganizationId
    and t.rtl_loc_id = @argRetailLocationId
    and t.wkstn_id = @argWrkstnId
    and t.business_date = @argBusinessDate
    and t.trans_seq = @argTransSeq
    and t.tndr_id = 'ACCOUNT_CREDIT'
     
        -- returns
    select @vQuantity=sum(case @vPostVoidFlag when 0 then -1 else 1 end * coalesce(quantity,0)),@vNetAmount=sum(case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0)) 
    from rpt_sale_line rsl with(nolock)
    where rsl.organization_id = @argOrganizationId
      and rtl_loc_id = @argRetailLocationId
      and wkstn_id = @argWrkstnId
      and business_date = @argBusinessDate
      and trans_seq= @argTransSeq
      and return_flag=1
      and coalesce(exclude_from_net_sales_flag,0)=0
 
      if abs(@vQuantity)>0 or abs(@vNetAmount)>0
        -- populate now to flash tables
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'Returns',@vQuantity, @vNetAmount, @vCurrencyId

    select @vGrossQuantity=sum(case when return_flag=@vPostVoidFlag then 1 else -1 end * coalesce(gross_quantity,0)),
    @vQuantity=sum(case when return_flag=@vPostVoidFlag then 1 else -1 end * coalesce(quantity,0)),
    @vGrossAmount=sum(case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(gross_amt,0)),
    @vNetAmount=sum(case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0)),
    @vOverrideAmt=sum(case @vPostVoidFlag when 1 then 1 else -1 end * coalesce(override_amt,0)),
    @vDiscountAmt=sum(case @vPostVoidFlag when 1 then 1 else -1 end * coalesce(discount_amt,0)) 
    from rpt_sale_line rsl with(nolock)
    where rsl.organization_id = @argOrganizationId
      and rtl_loc_id = @argRetailLocationId
      and wkstn_id = @argWrkstnId
      and business_date = @argBusinessDate
      and trans_seq= @argTransSeq
      AND QUANTITY <> 0
      AND sale_lineitm_typcode <> 'ONHOLD'
      and coalesce(exclude_from_net_sales_flag,0)=0

      -- Gross Sales update  
      if abs(@vGrossAmount) > 0 and @vGrossAmount <> coalesce(@vAccountCredit,0)
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'GrossSales',@vGrossQuantity, @vGrossAmount, @vCurrencyId
      -- Net Sales update
      if abs(@vNetAmount) > 0 and @vGrossAmount <> coalesce(@vAccountCredit,0)
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'NetSales',@vQuantity, @vNetAmount, @vCurrencyId  
      -- Discounts
      if abs(@vOverrideAmt) > 0
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'Overrides',@vQuantity, @vOverrideAmt, @vCurrencyId  
      -- Discounts  
      if abs(@vDiscountAmt) > 0
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'Discounts',@vQuantity, @vDiscountAmt, @vCurrencyId  

    -- Hourly sales updates (add for all the line items in the transaction)
      set @vTotQuantity = coalesce(@vTotQuantity, 0) + @vQuantity
      set @vTotNetAmt = coalesce(@vTotNetAmt, 0) + @vNetAmount
      set @vTotGrossAmt = coalesce(@vTotGrossAmt, 0) + @vGrossAmount

      -- non merchandise
      -- Non Merchandise (returns after processing)
    declare saleCursor cursor fast_forward for
    select rsl.item_id,sale_lineitm_typcode,actual_quantity,unit_price,case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(gross_amt,0),case when return_flag=@vPostVoidFlag then 1 else -1 end * coalesce(gross_quantity,0),merch_level_1,case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0),case when return_flag=@vPostVoidFlag then 1 else -1 end * coalesce(quantity,0),return_flag
    from rpt_sale_line rsl with(nolock)
    where rsl.organization_id = @argOrganizationId
      and rtl_loc_id = @argRetailLocationId
      and wkstn_id = @argWrkstnId
      and business_date = @argBusinessDate
      and trans_seq= @argTransSeq
      AND QUANTITY <> 0
      AND sale_lineitm_typcode <> 'ONHOLD'
      and coalesce(exclude_from_net_sales_flag,0)=0

    open saleCursor

    while 1=1
    begin

    fetch from saleCursor into @vItemId,@vSaleLineItmTypcode,@vActualQuantity,@vUnitPrice,@vGrossAmount,@vGrossQuantity,@vDepartmentId,@vNetAmount,@vQuantity,@vReturnFlag;
    if @@FETCH_STATUS <> 0
    break;

      select @vNonPhysType = non_phys_item_typcode from itm_non_phys_item with (nolock)
      where item_id = @vItemId and organization_id = @argOrganizationId    
      IF @@rowcount = 1
        begin      
        -- check for layaway or sp. order payment / deposit
          if @vPostVoidFlag <> @vReturnFlag
            begin
              set @vNonPhysPrice = @vUnitPrice * -1
              set @vNonPhysQuantity = @vActualQuantity * -1
            end
          else
            begin
              set @vNonPhysPrice = @vUnitPrice
              set @vNonPhysQuantity = @vActualQuantity
            end
        
          if @vNonPhysType = 'LAYAWAY_DEPOSIT'
            set @vNonPhys = 'LayawayDeposits'
          else if @vNonPhysType = 'LAYAWAY_PAYMENT'
            set @vNonPhys = 'LayawayPayments'
          else if @vNonPhysType = 'SP_ORDER_DEPOSIT'
            set @vNonPhys = 'SpOrderDeposits'        
          else if @vNonPhysType = 'SP_ORDER_PAYMENT'
            set @vNonPhys = 'SpOrderPayments'        
          else if @vNonPhysType = 'PRESALE_DEPOSIT'
            set @vNonPhys = 'PresaleDeposits'
          else if @vNonPhysType = 'PRESALE_PAYMENT'
            set @vNonPhys = 'PresalePayments'
          else 
            begin
              set @vNonPhys = 'NonMerchandise'
              set @vNonPhysPrice = @vGrossAmount
              set @vNonPhysQuantity = @vGrossQuantity
            end
          -- update flash sales for non physical payments / deposits
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,@vNonPhys,@vNonPhysQuantity, @vNonphysPrice, @vCurrencyId
        end  
      else
      set @vNonPhys = '' -- reset 

      -- process layaways and special orders (not sales)
      if @vSaleLineitmTypcode = 'LAYAWAY' or @vSaleLineitmTypcode = 'SPECIAL_ORDER'
        begin
          if (not (@vNonPhys = 'LayawayDeposits' or @vNonPhys = 'LayawayPayments' 
            or @vNonPhys = 'SpOrderDeposits' or @vNonPhys = 'SpOrderPayments' 
            or @vNonPhys = 'PresaleDeposits' or @vNonPhys = 'PresalePayments')) 
            and ((@vLineitemStatcode is null) or (@vLineitemStatcode <> 'CANCEL'))
            begin
            
              set @vNonPhysSaleType = 'SpOrderItems'
              if @vSaleLineitmTypcode = 'LAYAWAY'
                set @vNonPhysSaleType = 'LayawayItems'
              else if @vSaleLineitmTypcode = 'PRESALE'
                set @vNonPhysSaleType = 'PresaleItems'
              
              -- update flash sales for layaway items
              set @vLayawayPrice = @vUnitPrice * coalesce(@vActualQuantity, 0)
              exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
              @argWrkstnId,@vNonPhys,@vActualQuantity, @vLayawayPrice, @vCurrencyId
            end  
        end
      -- end flash sales update
      -- department sales
      exec sp_ins_upd_merchlvl1_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
      @argWrkstnId,@vDepartmentId,@vQuantity,@vNetAmount,@vGrossAmount,@vCurrencyId      
    end -- sale cursor ends
  close saleCursor
  deallocate saleCursor 
  end -- only when transaction is complete populate flash sales ends

-- update hourly sales
if (abs(@vTotNetAmt) > 0 or abs(@vTotGrossAmt) > 0 or abs(@vTotquantity) > 0)
   exec sp_ins_upd_hourly_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
   @argWrkstnId,@vTransTimeStamp,@vTotquantity,@vTotNetAmt,@vTotGrossAmt,@vTransCount,@vCurrencyId 
if @old_context_info is null
  SET CONTEXT_INFO 0x
else
  SET CONTEXT_INFO @old_context_info
GO

--[/RXPS-17705]

--[RXPS-16698]

PRINT 'cpaf_nfe'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe (
  organization_id  INT       NOT NULL,
  rtl_loc_id       INT       NOT NULL,
  environment_id   INT       NOT NULL,
  tp_nf            INT       NOT NULL,
  series_id        INT       NOT NULL,
  nnf              INT       NOT NULL,
  model            NVARCHAR(2)   NOT NULL,
  cuf              INT           NULL,
  cnf              INT           NULL,
  trans_typcode    NVARCHAR(30)  NULL,  
  natop            NVARCHAR(60) NULL,
  indpag           INT           NULL,
  issue_date       DATETIME      NULL,
  sai_ent_datetime DATETIME      NULL,
  cmun_fg          NVARCHAR(7)   NULL,
  tp_imp           INT           NULL,
  tp_emis          INT           NULL,
  fin_nfe          INT           NULL,
  proc_emi         INT           NULL,
  ver_proc         NVARCHAR(20)  NULL,
  cont_datetime    DATETIME      NULL,
  cont_xjust       NVARCHAR(255) NULL,
  product_amount   DECIMAL(17,6) NULL,
  service_amount   DECIMAL(17,6) NULL,
  icms_basis       DECIMAL(17,6) NULL,
  icms_amount      DECIMAL(17,6) NULL,
  icms_st_basis    DECIMAL(17,6) NULL,
  icms_st_amount   DECIMAL(17,6) NULL,
  iss_basis        DECIMAL(17,6) NULL,
  iss_amount       DECIMAL(17,6) NULL,  
  ii_amount        DECIMAL(17,6) NULL,
  pis_amount       DECIMAL(17,6) NULL,
  cofins_amount    DECIMAL(17,6) NULL,
  iss_pis_amount    DECIMAL(17,6) NULL,
  iss_cofins_amount DECIMAL(17,6) NULL,
  discount_amount  DECIMAL(17,6) NULL,
  freight_amount   DECIMAL(17,6) NULL,
  insurance_amount DECIMAL(17,6) NULL,
  other_amount     DECIMAL(17,6) NULL,
  total_amount     DECIMAL(17,6) NULL,
  inf_cpl          NVARCHAR(MAX) NULL,
  protocolo        NVARCHAR(30)  NULL,
  canc_protocolo   NVARCHAR(30)  NULL,
  chave_nfe        NVARCHAR(88)  NULL,
  old_chave_nfe    NVARCHAR(88)  NULL,
  recibo           NVARCHAR(30)  NULL,
  stat_code        NVARCHAR(30)  NULL,
  xml              NVARCHAR(MAX) NULL,
  correction       NVARCHAR(32)  NULL,
  correction_seq   INT           NULL,
  dig_val          NVARCHAR(30)  NULL,
  iss_service_date NVARCHAR(10)  NULL,
  create_date      DATETIME      NULL,
  create_user_id   NVARCHAR(30)  NULL,
  update_date      DATETIME      NULL,
  update_user_id   NVARCHAR(30)  NULL,
  record_state     NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, environment_id, tp_nf, series_id, nnf, model)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_service_date' AND object_id = OBJECT_ID('cpaf_nfe'))
BEGIN
  ALTER TABLE cpaf_nfe ADD iss_service_date nvarchar(10) NULL;
  PRINT 'cpaf_nfe.iss_service_date created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'service_amount' AND object_id = OBJECT_ID('cpaf_nfe'))
BEGIN
  ALTER TABLE cpaf_nfe ADD service_amount decimal(17, 6);
  PRINT 'cpaf_nfe.service_amount added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_basis' AND object_id = OBJECT_ID('cpaf_nfe'))
BEGIN
  ALTER TABLE cpaf_nfe ADD iss_basis decimal(17, 6);
  PRINT 'cpaf_nfe.iss_basis added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_amount' AND object_id = OBJECT_ID('cpaf_nfe'))
BEGIN
  ALTER TABLE cpaf_nfe ADD iss_amount decimal(17, 6);
  PRINT 'cpaf_nfe.iss_amount added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_pis_amount' AND object_id = OBJECT_ID('cpaf_nfe'))
BEGIN
  ALTER TABLE cpaf_nfe ADD iss_pis_amount decimal(17, 6);
  PRINT 'cpaf_nfe.iss_pis_amount added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_cofins_amount' AND object_id = OBJECT_ID('cpaf_nfe'))
BEGIN
  ALTER TABLE cpaf_nfe ADD iss_cofins_amount decimal(17, 6);
  PRINT 'cpaf_nfe.iss_cofins_amount added'
END
GO




IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe;
  PRINT 'cpaf_nfe_p created'
END
GO


PRINT 'cpaf_nfe_item'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_item' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_item (
  organization_id              INT   NOT NULL,
  rtl_loc_id                   INT   NOT NULL,
  environment_id               INT   NOT NULL,
  tp_nf                        INT   NOT NULL,
  series_id                    INT   NOT NULL,
  nnf                          INT   NOT NULL,
  model                        NVARCHAR(2)   NOT NULL,
  sequence                     INT   NOT NULL,
  item_id                      NVARCHAR(60)  NULL,
  item_description             NVARCHAR(254) NULL,
  ean                          NVARCHAR(14)  NULL,
  ncm                          NVARCHAR(8)   NULL,
  cest                         NVARCHAR(18)   NULL,
  ex_tipi                      NVARCHAR(3)   NULL,
  quantity                     DECIMAL(11,4) NULL,
  unit_of_measure_code         NVARCHAR(30)  NULL,
  taxable_ean                  NVARCHAR(14)  NULL,
  taxable_unit_of_measure_code NVARCHAR(30)  NULL,
  iat                          NVARCHAR(1)   NULL,
  ippt                         NVARCHAR(1)   NULL,
  unit_price                   DECIMAL(17,6) NULL,
  extended_amount              DECIMAL(17,6) NULL,
  taxable_quantity             DECIMAL(11,4) NULL,
  unit_taxable_amount          DECIMAL(17,6) NULL,
  freight_amount               DECIMAL(17,6) NULL,
  insurance_amount             DECIMAL(17,6) NULL,
  discount_amount              DECIMAL(17,6) NULL,
  other_amount                 DECIMAL(17,6) NULL,
  cfop                         NVARCHAR(4)   NULL,
  inf_ad_prod                  NVARCHAR(500) NULL,
  icms_cst                     NVARCHAR(3)   NULL,
  icms_basis                   DECIMAL(17,6) NULL,
  icms_amount                  DECIMAL(17,6) NULL,
  icms_rate                    DECIMAL(5,2)  NULL,
  icms_st_basis                DECIMAL(17,6) NULL,
  icms_st_amount               DECIMAL(17,6) NULL,
  icms_st_rate                 DECIMAL(5,2)  NULL,
  iss_basis                    DECIMAL(17,6)    NULL,
  iss_amount                   DECIMAL(17,6)    NULL,
  iss_rate                     DECIMAL(5,2)     NULL, 
  ipi_amount                   DECIMAL(17,6) NULL,
  ipi_rate                     DECIMAL(5,2)  NULL,
  ii_amount                    DECIMAL(17,6) NULL,
  pis_basis                    DECIMAL(17,6) NULL,
  pis_amount                   DECIMAL(17,6) NULL,
  pis_rate                     DECIMAL(17,6) NULL,
  cofins_basis                 DECIMAL(17,6) NULL,
  cofins_amount                DECIMAL(17,6) NULL,
  cofins_rate                  DECIMAL(17,6) NULL,
  tax_situation_code           NVARCHAR(6)   NULL,
  tax_group_id                 NVARCHAR(120) NULL,
  log_sequence                 INT           NULL,
  ref_nfe                      NVARCHAR(88) NULL,
  iis_city_code                NVARCHAR(7)  NULL,
  iis_service_code             NVARCHAR(5)  NULL,
  iis_eligible_indicator       NVARCHAR(2)  NULL,
  iis_incentive_indicator      NVARCHAR(1)  NULL,  
  create_date                  DATETIME      NULL,
  create_user_id               NVARCHAR(30)  NULL,
  update_date                  DATETIME      NULL,
  update_user_id               NVARCHAR(30)  NULL,
  record_state                 NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_item]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, environment_id, tp_nf, series_id, nnf, model, sequence)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_basis' AND object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
  ALTER TABLE cpaf_nfe_item ADD iss_basis DECIMAL(17,6);
  PRINT 'cpaf_nfe_item.iss_basis created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_amount' AND object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
  ALTER TABLE cpaf_nfe_item ADD iss_amount DECIMAL(17,6);
  PRINT 'cpaf_nfe_item.iss_amount created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_rate' AND object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
  ALTER TABLE cpaf_nfe_item ADD iss_rate DECIMAL(5,2);
  PRINT 'cpaf_nfe_item.iss_rate created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iis_city_code' AND object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
  ALTER TABLE cpaf_nfe_item ADD iis_city_code nvarchar(7) NULL;
  PRINT 'cpaf_nfe_item.iis_city_code created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iis_service_code' AND object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
  ALTER TABLE cpaf_nfe_item ADD iis_service_code nvarchar(5) NULL;
  PRINT 'cpaf_nfe_item.iis_service_code created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iis_eligible_indicator' AND object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
  ALTER TABLE cpaf_nfe_item ADD iis_eligible_indicator nvarchar(2) NULL;
  PRINT 'cpaf_nfe_item.iis_eligible_indicator created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iis_incentive_indicator' AND object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
  ALTER TABLE cpaf_nfe_item ADD iis_incentive_indicator nvarchar(1) NULL;
  PRINT 'cpaf_nfe_item.iis_incentive_indicator created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ref_nfe' AND object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
  ALTER TABLE cpaf_nfe_item ADD ref_nfe nvarchar(88) NULL;
  PRINT 'cpaf_nfe_item.ref_nfe created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_item_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_item;
  PRINT 'cpaf_nfe_item_p created'
END
GO


PRINT 'cpaf_nfe_resend_queue'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_resend_queue' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_resend_queue (
  organization_id  INT           NOT NULL,
  rtl_loc_id       INT           NOT NULL,
  wkstn_id         INT           NOT NULL,
  chave_nfe        NVARCHAR(88)  NOT NULL,
  copies           INT           NULL,
  requesting_user  NVARCHAR(20)  NULL,
  email_address    NVARCHAR(30)  NULL,
  create_date      DATETIME      NULL,
  create_user_id   NVARCHAR(30)  NULL,
  update_date      DATETIME      NULL,
  update_user_id   NVARCHAR(30)  NULL,
  record_state     NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_resend_queue]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, chave_nfe)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_resend_queue_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_resend_queue;
  PRINT 'cpaf_nfe_resend_queue_p created'
END
GO


PRINT 'cpaf_nfe_queue'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_queue' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_queue (
  organization_id  INT           NOT NULL,
  rtl_loc_id       INT           NOT NULL,
  wkstn_id         INT           NOT NULL,
  queue_seq        INT           NOT NULL,
  environment_id   INT           NULL,
  tp_nf            INT           NULL,
  series_id        INT           NULL,
  nnf              INT           NULL,
  cuf              INT           NULL,
  cnf              INT           NULL,
  usage_type       NVARCHAR(30)  NULL,
  trans_typcode    NVARCHAR(30)  NULL,
  natop            NVARCHAR(60) NULL,
  indpag           INT           NULL,
  model            NVARCHAR(2)   NULL,
  issue_date       DATETIME      NULL,
  sai_ent_datetime DATETIME      NULL,
  cmun_fg          NVARCHAR(7)   NULL,
  tp_imp           INT           NULL,
  tp_emis          INT           NULL,
  fin_nfe          INT           NULL,
  proc_emi         INT           NULL,
  ver_proc         NVARCHAR(20)  NULL,
  cont_datetime    DATETIME      NULL,
  cont_xjust       NVARCHAR(255) NULL,
  product_amount   DECIMAL(17,6) NULL,
  service_amount   DECIMAL(17,6) NULL,
  icms_basis       DECIMAL(17,6) NULL,
  icms_amount      DECIMAL(17,6) NULL,
  icms_st_basis    DECIMAL(17,6) NULL,
  icms_st_amount   DECIMAL(17,6) NULL,
  iss_basis        DECIMAL(17,6) NULL,
  iss_amount       DECIMAL(17,6) NULL, 
  ii_amount        DECIMAL(17,6) NULL,
  pis_amount       DECIMAL(17,6) NULL,
  cofins_amount    DECIMAL(17,6) NULL,
  iss_pis_amount    DECIMAL(17,6) NULL,
  iss_cofins_amount DECIMAL(17,6) NULL,  
  discount_amount  DECIMAL(17,6) NULL,
  freight_amount   DECIMAL(17,6) NULL,
  insurance_amount DECIMAL(17,6) NULL,
  other_amount     DECIMAL(17,6) NULL,
  total_amount     DECIMAL(17,6) NULL,
  inf_cpl          NVARCHAR(MAX) NULL,
  protocolo        NVARCHAR(30)  NULL,
  canc_protocolo   NVARCHAR(30)  NULL,
  chave_nfe        NVARCHAR(88)  NULL,
  old_chave_nfe        NVARCHAR(88)  NULL,
  recibo           NVARCHAR(30)  NULL,
  stat_code        NVARCHAR(30)  NULL,
  xml              NVARCHAR(MAX) NULL,
  correction       NVARCHAR(32)  NULL,
  correction_seq   INT           NULL,
  response_code    NVARCHAR(30)  NULL,
  response_text    NVARCHAR(MAX) NULL,
  dig_val          NVARCHAR(30)  NULL,
  iss_service_date NVARCHAR(10)  NULL,
  create_date      DATETIME      NULL,
  create_user_id   NVARCHAR(30)  NULL,
  update_date      DATETIME      NULL,
  update_user_id   NVARCHAR(30)  NULL,
  record_state     NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_queue]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, queue_seq)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_service_date' AND object_id = OBJECT_ID('cpaf_nfe_queue'))
BEGIN
  ALTER TABLE cpaf_nfe_queue ADD iss_service_date nvarchar(10) NULL;
  PRINT 'cpaf_nfe_queue.iss_service_date created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'service_amount' AND object_id = OBJECT_ID('cpaf_nfe_queue'))
BEGIN
  ALTER TABLE cpaf_nfe_queue ADD service_amount decimal(17, 6);
  PRINT 'cpaf_nfe_queue.service_amount added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_basis' AND object_id = OBJECT_ID('cpaf_nfe_queue'))
BEGIN
  ALTER TABLE cpaf_nfe_queue ADD iss_basis decimal(17, 6);
  PRINT 'cpaf_nfe_queue.iss_basis added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_amount' AND object_id = OBJECT_ID('cpaf_nfe_queue'))
BEGIN
  ALTER TABLE cpaf_nfe_queue ADD iss_amount decimal(17, 6);
  PRINT 'cpaf_nfe_queue.iss_amount added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_pis_amount' AND object_id = OBJECT_ID('cpaf_nfe_queue'))
BEGIN
  ALTER TABLE cpaf_nfe_queue ADD iss_pis_amount decimal(17, 6);
  PRINT 'cpaf_nfe_queue.iss_pis_amount added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_cofins_amount' AND object_id = OBJECT_ID('cpaf_nfe_queue'))
BEGIN
  ALTER TABLE cpaf_nfe_queue ADD iss_cofins_amount decimal(17, 6);
  PRINT 'cpaf_nfe_queue.iss_cofins_amount added'
END
GO


IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue;
  PRINT 'cpaf_nfe_queue_p created'
END
GO


PRINT 'cpaf_nfe_queue_log'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_queue_log' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_queue_log (
  organization_id               INT           NOT NULL,
  rtl_loc_id                    INT           NOT NULL,
  wkstn_id                      INT           NOT NULL,
  queue_seq                     INT           NOT NULL,
  sequence                      INT           NOT NULL,
  stat_code                     NVARCHAR(30)  NULL,
  response_code                 NVARCHAR(30)  NULL,
  response_text                 NVARCHAR(MAX) NULL,
  source                        NVARCHAR(255) NULL,
  create_date                   DATETIME      NULL,
  create_user_id                NVARCHAR(30)  NULL,
  update_date                   DATETIME      NULL,
  update_user_id                NVARCHAR(30)  NULL,
  record_state                  NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_log]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, queue_seq, sequence)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_log_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_log;
  PRINT 'cpaf_nfe_queue_log_p created'
END
GO


PRINT 'cpaf_nfe_queue_item'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_queue_item' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_queue_item (
  organization_id               INT           NOT NULL,
  rtl_loc_id                    INT           NOT NULL,
  wkstn_id                      INT           NOT NULL,
  queue_seq                     INT           NOT NULL,
  sequence                      INT           NOT NULL,
  item_id                       NVARCHAR(60)  NULL,
  item_description              NVARCHAR(254) NULL,
  ean                           NVARCHAR(14)  NULL,
  ncm                           NVARCHAR(8)   NULL,
  cest                          NVARCHAR(18)  NULL,
  ex_tipi                       NVARCHAR(3)   NULL,
  quantity                      DECIMAL(11,4) NULL,
  unit_of_measure_code          NVARCHAR(30)  NULL,
  taxable_ean                   NVARCHAR(14)  NULL,
  taxable_unit_of_measure_code  NVARCHAR(30)  NULL,
  iat                           NVARCHAR(1)   NULL,
  ippt                          NVARCHAR(1)   NULL,
  unit_price                    DECIMAL(17,6) NULL,
  extended_amount               DECIMAL(17,6) NULL,
  taxable_quantity              DECIMAL(11,4) NULL,
  unit_taxable_amount           DECIMAL(17,6) NULL,
  freight_amount                DECIMAL(17,6) NULL,
  insurance_amount              DECIMAL(17,6) NULL,
  discount_amount               DECIMAL(17,6) NULL,
  other_amount                  DECIMAL(17,6) NULL,
  cfop                          NVARCHAR(4)   NULL,
  inf_ad_prod                   NVARCHAR(500) NULL,
  icms_cst                      NVARCHAR(3)   NULL,
  icms_basis                    DECIMAL(17,6) NULL,
  icms_amount                   DECIMAL(17,6) NULL,
  icms_rate                     DECIMAL(5,2)  NULL,
  icms_st_basis                 DECIMAL(17,6) NULL,
  icms_st_amount                DECIMAL(17,6) NULL,
  icms_st_rate                  DECIMAL(5,2)  NULL,
  iss_basis                    DECIMAL(17,6)    NULL,
  iss_amount                   DECIMAL(17,6)    NULL,
  iss_rate                     DECIMAL(5,2)     NULL, 
  ipi_amount                    DECIMAL(17,6) NULL,
  ipi_rate                      DECIMAL(5,2)  NULL,
  ii_amount                     DECIMAL(17,6) NULL,
  pis_basis                     DECIMAL(17,6) NULL,
  pis_amount                    DECIMAL(17,6) NULL,
  pis_rate                      DECIMAL(17,6) NULL,
  cofins_basis                  DECIMAL(17,6) NULL,
  cofins_amount                 DECIMAL(17,6) NULL,
  cofins_rate                   DECIMAL(17,6) NULL,
  tax_situation_code            NVARCHAR(6)   NULL,
  tax_group_id                  NVARCHAR(120) NULL,
  log_sequence                  INT           NULL,
  ref_nfe                       NVARCHAR(88) NULL,
  iis_city_code                NVARCHAR(7)  NULL,
  iis_service_code             NVARCHAR(5)  NULL,
  iis_eligible_indicator       NVARCHAR(2)  NULL,
  iis_incentive_indicator      NVARCHAR(1)  NULL,
  create_date                   DATETIME      NULL,
  create_user_id                NVARCHAR(30)  NULL,
  update_date                   DATETIME      NULL,
  update_user_id                NVARCHAR(30)  NULL,
  record_state                  NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_item]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, queue_seq, sequence)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_basis' AND object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
  ALTER TABLE cpaf_nfe_queue_item ADD iss_basis DECIMAL(17,6);
  PRINT 'cpaf_nfe_queue_item.iss_basis created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_amount' AND object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
  ALTER TABLE cpaf_nfe_queue_item ADD iss_amount DECIMAL(17,6);
  PRINT 'cpaf_nfe_queue_item.iss_amount created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iss_rate' AND object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
  ALTER TABLE cpaf_nfe_queue_item ADD iss_rate DECIMAL(5,2);
  PRINT 'cpaf_nfe_queue_item.iss_rate created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iis_city_code' AND object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
  ALTER TABLE cpaf_nfe_queue_item ADD iis_city_code nvarchar(7) NULL;
  PRINT 'cpaf_nfe_queue_item.iis_city_code created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iis_service_code' AND object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
  ALTER TABLE cpaf_nfe_queue_item ADD iis_service_code nvarchar(5) NULL;
  PRINT 'cpaf_nfe_queue_item.iis_service_code created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iis_eligible_indicator' AND object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
  ALTER TABLE cpaf_nfe_queue_item ADD iis_eligible_indicator nvarchar(2) NULL;
  PRINT 'cpaf_nfe_queue_item.iis_eligible_indicator created'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'iis_incentive_indicator' AND object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
  ALTER TABLE cpaf_nfe_queue_item ADD iis_incentive_indicator nvarchar(1) NULL;
  PRINT 'cpaf_nfe_queue_item.iis_incentive_indicator created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ref_nfe' AND object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
  ALTER TABLE cpaf_nfe_queue_item ADD ref_nfe nvarchar(88) NULL;
  PRINT 'cpaf_nfe_queue_item.ref_nfe created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_item_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_item;
  PRINT 'cpaf_nfe_queue_item_p created'
END
GO

PRINT 'cpaf_nfe_queue_trans'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_queue_trans' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_queue_trans (
    organization_id               INT           NOT NULL,
    rtl_loc_id                    INT           NOT NULL,
    wkstn_id                      INT           NOT NULL,
    queue_seq                     INT           NOT NULL,
    business_date                 DATETIME      NOT NULL,
    trans_wkstn_id                INT           NOT NULL,
    trans_seq                     INT           NOT NULL,
    inactive_flag                 INT           NOT NULL,
    create_date                   DATETIME      NULL,
    create_user_id                NVARCHAR(30)  NULL,
    update_date                   DATETIME      NULL,
    update_user_id                NVARCHAR(30)  NULL,
    record_state                  NVARCHAR(30)  NULL,
    CONSTRAINT [pk_cpaf_nfe_queue_trans]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, queue_seq, business_date, trans_wkstn_id, trans_seq)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_trans_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_trans;
  PRINT 'cpaf_nfe_queue_trans_p created'
END
GO


PRINT 'cpaf_nfe_queue_issuer'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_queue_issuer' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_queue_issuer (
  organization_id               INT           NOT NULL,
  rtl_loc_id                    INT           NOT NULL,
  wkstn_id                      INT           NOT NULL,
  queue_seq                     INT           NOT NULL,
  name                          NVARCHAR(60)  NULL,
  fantasy_name                  NVARCHAR(60)  NULL,
  federal_tax_id                NVARCHAR(20)  NULL,
  state_tax_id                  NVARCHAR(20)  NULL,
  city_tax_id                   NVARCHAR(20)  NULL,
  crt                           NVARCHAR(1)   NULL,
  street_name                   NVARCHAR(60)  NULL,
  street_num                    NVARCHAR(60)  NULL,
  complemento                   NVARCHAR(60)  NULL,
  neighborhood                  NVARCHAR(60)  NULL,
  city_code                     NVARCHAR(7)   NULL,
  city                          NVARCHAR(60)  NULL,
  state                         NVARCHAR(2)   NULL,
  postal_code                   NVARCHAR(8)   NULL,
  country_code                  NVARCHAR(4)   NULL,
  country_name                  NVARCHAR(60)  NULL,
  telephone                     NVARCHAR(14)  NULL,
  create_date                   DATETIME      NULL,
  create_user_id                NVARCHAR(30)  NULL,
  update_date                   DATETIME      NULL,
  update_user_id                NVARCHAR(30)  NULL,
  record_state                  NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_issuer]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, queue_seq)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_issuer_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_issuer;
  PRINT 'cpaf_nfe_queue_issuer_p created'
END
GO

PRINT 'cpaf_nfe_queue_dest'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_queue_dest' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_queue_dest (
  organization_id               INT           NOT NULL,
  rtl_loc_id                    INT           NOT NULL,
  wkstn_id                      INT           NOT NULL,
  queue_seq                     INT           NOT NULL,
  name                          NVARCHAR(60)  NULL,
  federal_tax_id                NVARCHAR(20)  NULL,
  state_tax_id                  NVARCHAR(20)  NULL,
  street_name                   NVARCHAR(60)  NULL,
  street_num                    NVARCHAR(60)  NULL,
  complemento                   NVARCHAR(60)  NULL,
  neighborhood                  NVARCHAR(60)  NULL,
  city_code                     NVARCHAR(7)   NULL,
  city                          NVARCHAR(60)  NULL,
  state                         NVARCHAR(2)   NULL,
  postal_code                   NVARCHAR(8)   NULL,
  country_code                  NVARCHAR(4)   NULL,
  country_name                  NVARCHAR(60)  NULL,
  telephone                     NVARCHAR(14)  NULL,
  email                         NVARCHAR(60)  NULL,
  create_date                   DATETIME      NULL,
  create_user_id                NVARCHAR(30)  NULL,
  update_date                   DATETIME      NULL,
  update_user_id                NVARCHAR(30)  NULL,
  record_state                  NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_dest]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, queue_seq)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_dest_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_dest;
  PRINT 'cpaf_nfe_queue_dest_p created'
END
GO


PRINT 'cpaf_nfe_trans_type'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_trans_type' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_trans_type (
    organization_id        INT             NOT NULL,
    trans_typcode          NVARCHAR(30)    NOT NULL,
    outgoing_flag          BIT             NULL  DEFAULT(0),
    description            NVARCHAR(60)   NULL,
    notes                  NVARCHAR(MAX)   NULL,
    cfop_same_uf           NVARCHAR(4)     NULL,
    cfop_other_uf          NVARCHAR(4)     NULL,
    cfop_foreign           NVARCHAR(4)     NULL,
    fin_nfe                INT            NULL  DEFAULT(0),   
    display_order          INT             NULL,
    comment_req_flag       BIT             NULL  DEFAULT(0),
    rule_type              NVARCHAR(30)    NULL  DEFAULT(0),
    disallow_cancel_flag   BIT             NULL  DEFAULT(0),
    pricing_type           NVARCHAR(30)    NULL,
    initial_comment        NVARCHAR(254)   NULL,
    create_date            DATETIME        NULL,
    create_user_id         NVARCHAR(30)    NULL,
    update_date            DATETIME        NULL,
    update_user_id         NVARCHAR(30)    NULL,
    record_state           NVARCHAR(30)    NULL,
    CONSTRAINT [pk_cpaf_nfe_trans_type] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode]) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'fin_nfe' AND object_id = OBJECT_ID('cpaf_nfe_trans_type'))
BEGIN
  ALTER TABLE cpaf_nfe_trans_type ADD fin_nfe INT DEFAULT 0;
  PRINT 'cpaf_nfe_trans_type.fin_nfe added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_trans_type_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_trans_type;
  PRINT 'cpaf_nfe_trans_type_p created'
END
GO


PRINT 'cpaf_nfe_trans_type_use'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_trans_type_use' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_trans_type_use (
    organization_id        INT             NOT NULL,
    trans_typcode          NVARCHAR(30)    NOT NULL,
    usage_typcode          NVARCHAR(30)    NOT NULL,
    uf                     NVARCHAR(2)     NOT NULL,
    create_date            DATETIME        NULL,
    create_user_id         NVARCHAR(30)    NULL,
    update_date            DATETIME        NULL,
    update_user_id         NVARCHAR(30)    NULL,
    record_state           NVARCHAR(30)    NULL,
    CONSTRAINT [pk_cpaf_nfe_trans_type_use] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [usage_typcode], [uf]) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_trans_type_use_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_trans_type_use;
  PRINT 'cpaf_nfe_trans_type_use_p created'
END
GO


PRINT 'cpaf_nfe_trans'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_trans' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_trans (
    organization_id               INT           NOT NULL,
    rtl_loc_id                    INT           NOT NULL,
    environment_id                INT           NOT NULL,
    tp_nf                         INT           NOT NULL,
    series_id                     INT           NOT NULL,
    nnf                           INT           NOT NULL,
    model                         NVARCHAR(2)   NOT NULL,
    business_date                 DATETIME      NOT NULL,
    trans_wkstn_id                INT           NOT NULL,
    trans_seq                     INT           NOT NULL,
    create_date                   DATETIME      NULL,
    create_user_id                NVARCHAR(30)  NULL,
    update_date                   DATETIME      NULL,
    update_user_id                NVARCHAR(30)  NULL,
    record_state                  NVARCHAR(30)  NULL,
    CONSTRAINT [pk_cpaf_nfe_trans]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, environment_id, tp_nf, series_id, nnf, model, business_date, trans_wkstn_id, trans_seq) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_trans_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_trans;
  PRINT 'cpaf_nfe_trans_p created'
END
GO


PRINT 'cpaf_nfe_issuer'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_issuer' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_issuer (
  organization_id               INT           NOT NULL,
  rtl_loc_id                    INT           NOT NULL,
  environment_id                INT           NOT NULL,
  tp_nf                         INT           NOT NULL,
  series_id                     INT           NOT NULL,
  nnf                           INT           NOT NULL,
  model                         NVARCHAR(2)   NOT NULL,
  name                          NVARCHAR(60)  NULL,
  fantasy_name                  NVARCHAR(60)  NULL,
  federal_tax_id                NVARCHAR(20)  NULL,
  state_tax_id                  NVARCHAR(20)  NULL,
  city_tax_id                   NVARCHAR(20)  NULL,
  crt                           NVARCHAR(1)   NULL,
  street_name                   NVARCHAR(60)  NULL,
  street_num                    NVARCHAR(60)  NULL,
  complemento                   NVARCHAR(60)  NULL,
  neighborhood                  NVARCHAR(60)  NULL,
  city_code                     NVARCHAR(7)   NULL,
  city                          NVARCHAR(60)  NULL,
  state                         NVARCHAR(2)   NULL,
  postal_code                   NVARCHAR(8)   NULL,
  country_code                  NVARCHAR(4)   NULL,
  country_name                  NVARCHAR(60)  NULL,
  telephone                     NVARCHAR(14)  NULL,
  create_date                   DATETIME      NULL,
  create_user_id                NVARCHAR(30)  NULL,
  update_date                   DATETIME      NULL,
  update_user_id                NVARCHAR(30)  NULL,
  record_state                  NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_issuer]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, environment_id, tp_nf, series_id, nnf, model)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_issuer_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_issuer;
  PRINT 'cpaf_nfe_issuer_p created'
END
GO


PRINT 'cpaf_nfe_dest'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_dest' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_dest (
  organization_id               INT           NOT NULL,
  rtl_loc_id                    INT           NOT NULL,
  environment_id                INT           NOT NULL,
  tp_nf                         INT           NOT NULL,
  series_id                     INT           NOT NULL,
  nnf                           INT           NOT NULL,
  model                         NVARCHAR(2)   NOT NULL,
  name                          NVARCHAR(60)  NULL,
  federal_tax_id                NVARCHAR(20)  NULL,
  state_tax_id                  NVARCHAR(20)  NULL,
  street_name                   NVARCHAR(60)  NULL,
  street_num                    NVARCHAR(60)  NULL,
  complemento                   NVARCHAR(60)  NULL,
  neighborhood                  NVARCHAR(60)  NULL,
  city_code                     NVARCHAR(7)   NULL,
  city                          NVARCHAR(60)  NULL,
  state                         NVARCHAR(2)   NULL,
  postal_code                   NVARCHAR(8)   NULL,
  country_code                  NVARCHAR(4)   NULL,
  country_name                  NVARCHAR(60)  NULL,
  telephone                     NVARCHAR(14)  NULL,
  email                         NVARCHAR(60)  NULL,
  create_date                   DATETIME      NULL,
  create_user_id                NVARCHAR(30)  NULL,
  update_date                   DATETIME      NULL,
  update_user_id                NVARCHAR(30)  NULL,
  record_state                  NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_dest]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, environment_id, tp_nf, series_id, nnf, model)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_dest_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_dest;
  PRINT 'cpaf_nfe_dest_p created'
END
GO


PRINT 'cpaf_address_muni'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_address_muni' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_address_muni (
  organization_id         INT          NOT NULL,
  municipality_id         INT          NOT NULL,
  uf                      NVARCHAR(2)  NULL,
  [name]                  NVARCHAR(72) NULL,
  ibge_code               NVARCHAR(7)  NULL,
  postal_code_start       NVARCHAR(8)  NULL,
  postal_code_end         NVARCHAR(8)  NULL,
  parent_municipality_id  INT          NULL,
  loc_in_sit              NVARCHAR(1)  NULL,
  loc_in_tipo_loc         NVARCHAR(1)  NULL,
  create_date             DATETIME     NULL,
  create_user_id          NVARCHAR(30) NULL,
  update_date             DATETIME     NULL,
  update_user_id          NVARCHAR(30) NULL,
  record_state            NVARCHAR(30) NULL,
  CONSTRAINT [pk_cpaf_address_muni]
    PRIMARY KEY CLUSTERED (organization_id, municipality_id) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_address_muni_p'))
BEGIN
  exec Create_Property_Table cpaf_address_muni;
  PRINT 'cpaf_address_muni_p created'
END
GO


PRINT 'cpaf_nfe_trans_tax'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_trans_tax' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_trans_tax (
  organization_id     INT           NOT NULL,
  trans_typcode       NVARCHAR(30)  NOT NULL,
  uf                  NVARCHAR(2)   NOT NULL,
  dest_uf             NVARCHAR(2)   NOT NULL,
  tax_group_id        NVARCHAR(120) NOT NULL,
  new_tax_group_id    NVARCHAR(120) NULL,
  create_date         DATETIME      NULL,
  create_user_id      NVARCHAR(30)  NULL,
  update_date         DATETIME      NULL,
  update_user_id      NVARCHAR(30)  NULL,
  record_state        NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_tax]
    PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [uf], [dest_uf], [tax_group_id]) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_trans_tax_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_trans_tax;
  PRINT 'cpaf_nfe_trans_tax_p created'
END
GO

PRINT 'cpaf_nfe_tax_cst'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfe_tax_cst' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfe_tax_cst (
  organization_id         INT           NOT NULL,
  trans_typcode           NVARCHAR(30)  NOT NULL,
  tax_loc_id              NVARCHAR(30)  NOT NULL,
  tax_group_id            NVARCHAR(120) NOT NULL,
  tax_authority_id        NVARCHAR(60)  NOT NULL,
  cst                     NVARCHAR(2)   NULL,
  create_date             DATETIME      NULL,
  create_user_id          NVARCHAR(30)  NULL,
  update_date             DATETIME      NULL,
  update_user_id          NVARCHAR(30)  NULL,
  record_state            NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_tax_cst]
    PRIMARY KEY CLUSTERED (organization_id, trans_typcode, tax_loc_id, tax_group_id, tax_authority_id) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_tax_cst_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_tax_cst;
  PRINT 'cpaf_nfe_tax_cst_p created'
END
GO


PRINT 'cpaf_nfce_queue_tender'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfce_queue_tender' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfce_queue_tender (
  organization_id         INT           NOT NULL,
  rtl_loc_id              INT           NOT NULL,
  wkstn_id                INT           NOT NULL,
  queue_seq               INT           NOT NULL,
  sequence                INT           NOT NULL,
  tndr_id                 NVARCHAR(60)  NOT NULL,
  fiscal_tender_id        NVARCHAR(60) NOT NULL,
  amount                  DECIMAL(17,6) NULL,
  card_network_id         NVARCHAR(30) NULL,
  card_tax_id             NVARCHAR(30) NULL,
  card_auth_number        NVARCHAR(254) NULL,
  card_type               NVARCHAR(254) NULL,
  card_trace_number       NVARCHAR(254) NULL,
  card_integration_mode   NVARCHAR(30) NULL,  
  card_installments       INT DEFAULT 0,  
  create_date             DATETIME      NULL,
  create_user_id          NVARCHAR(30)  NULL,
  update_date             DATETIME      NULL,
  update_user_id          NVARCHAR(30)  NULL,
  record_state            NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfce_queue_tender]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, queue_seq, sequence, tndr_id) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_installments' AND object_id = OBJECT_ID('cpaf_nfce_queue_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_queue_tender ADD card_installments INT DEFAULT 0;
  PRINT 'cpaf_nfce_queue_tender.card_installments created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_network_id' AND object_id = OBJECT_ID('cpaf_nfce_queue_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_queue_tender ADD card_network_id nvarchar(30) NULL;
  PRINT 'cpaf_nfce_queue_tender.card_network_id created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_tax_id' AND object_id = OBJECT_ID('cpaf_nfce_queue_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_queue_tender ADD card_tax_id nvarchar(30) NULL;
  PRINT 'cpaf_nfce_queue_tender.card_tax_id created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_auth_number' AND object_id = OBJECT_ID('cpaf_nfce_queue_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_queue_tender ADD card_auth_number nvarchar(254) NULL;
  PRINT 'cpaf_nfce_queue_tender.card_auth_number created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_type' AND object_id = OBJECT_ID('cpaf_nfce_queue_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_queue_tender ADD card_type nvarchar(254) NULL;
  PRINT 'cpaf_nfce_queue_tender.card_type created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_trace_number' AND object_id = OBJECT_ID('cpaf_nfce_queue_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_queue_tender ADD card_trace_number nvarchar(254) NULL;
  PRINT 'cpaf_nfce_queue_tender.card_trace_number created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_integration_mode' AND object_id = OBJECT_ID('cpaf_nfce_queue_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_queue_tender ADD card_integration_mode nvarchar(30) NULL;
  PRINT 'cpaf_nfce_queue_tender.card_integration_mode created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfce_queue_tender_p'))
BEGIN
  exec Create_Property_Table cpaf_nfce_queue_tender;
  PRINT 'cpaf_nfce_queue_tender_p created'
END
GO

PRINT 'cpaf_nfce_tender'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_nfce_tender' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_nfce_tender (
  organization_id         INT       NOT NULL,
  rtl_loc_id              INT       NOT NULL,
  environment_id          INT       NOT NULL,
  tp_nf                   INT       NOT NULL,
  series_id               INT       NOT NULL,
  nnf                     INT       NOT NULL,
  model            NVARCHAR(2)   NOT NULL,
  sequence                INT           NOT NULL,
  tndr_id                 NVARCHAR(60)  NOT NULL,
  fiscal_tender_id        NVARCHAR(60 ) NOT NULL,
  amount                  DECIMAL(17,6) NULL,
  card_network_id         NVARCHAR(30) NULL,
  card_tax_id             NVARCHAR(30) NULL,
  card_auth_number        NVARCHAR(254) NULL,
  card_type               NVARCHAR(254) NULL,
  card_trace_number       NVARCHAR(254) NULL,
  card_integration_mode   NVARCHAR(30) NULL,
  card_installments       INT DEFAULT 0,  
  create_date             DATETIME      NULL,
  create_user_id          NVARCHAR(30)  NULL,
  update_date             DATETIME      NULL,
  update_user_id          NVARCHAR(30)  NULL,
  record_state            NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfce_tender]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, environment_id, tp_nf, series_id, nnf, model, sequence, tndr_id) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_installments' AND object_id = OBJECT_ID('cpaf_nfce_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_tender ADD card_installments INT DEFAULT 0;
  PRINT 'cpaf_nfce_tender.card_installments created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_network_id' AND object_id = OBJECT_ID('cpaf_nfce_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_tender ADD card_network_id nvarchar(30) NULL;
  PRINT 'cpaf_nfce_tender.card_network_id created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_tax_id' AND object_id = OBJECT_ID('cpaf_nfce_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_tender ADD card_tax_id nvarchar(30) NULL;
  PRINT 'cpaf_nfce_tender.card_tax_id created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_auth_number' AND object_id = OBJECT_ID('cpaf_nfce_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_tender ADD card_auth_number nvarchar(254) NULL;
  PRINT 'cpaf_nfce_tender.card_auth_number created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_type' AND object_id = OBJECT_ID('cpaf_nfce_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_tender ADD card_type nvarchar(254) NULL;
  PRINT 'cpaf_nfce_tender.card_type created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_trace_number' AND object_id = OBJECT_ID('cpaf_nfce_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_tender ADD card_trace_number nvarchar(254) NULL;
  PRINT 'cpaf_nfce_tender.card_trace_number created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'card_integration_mode' AND object_id = OBJECT_ID('cpaf_nfce_tender'))
BEGIN
  ALTER TABLE cpaf_nfce_tender ADD card_integration_mode nvarchar(30) NULL;
  PRINT 'cpaf_nfce_tender.card_integration_mode created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfce_tender_p'))
BEGIN
  exec Create_Property_Table cpaf_nfce_tender;
  PRINT 'cpaf_nfce_tender_p created'
END
GO

PRINT 'cpaf_sat_response'
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'cpaf_sat_response' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE cpaf_sat_response (
  organization_id         INT           NOT NULL,
  rtl_loc_id              INT           NOT NULL,
  wkstn_id                INT           NOT NULL,
  queue_seq               INT           NOT NULL,
  session_id              INT           NOT NULL,
  code_sate               NVARCHAR(32)  NULL,
  message_sate            NVARCHAR(254) NULL,
  code_alert              NVARCHAR(32)  NULL,
  message_alert           NVARCHAR(254) NULL,
  xml_string              NVARCHAR(MAX) NULL,
  time_stamp              DATETIME      NULL,
  chave                   NVARCHAR(254) NULL,
  total_amount            DECIMAL(17,6) NULL,
  cpf_cnpj_value          NVARCHAR(32)  NULL,
  signature_QR_code       NVARCHAR(MAX) NULL,
  success                 BIT           NULL,
  timeout                 BIT           NULL,
  create_date             DATETIME      NULL,
  create_user_id          NVARCHAR(30)  NULL,
  update_date             DATETIME      NULL,
  update_user_id          NVARCHAR(30)  NULL,
  record_state            NVARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_sat_response]
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, wkstn_id, queue_seq, session_id) WITH (FILLFACTOR = 80)
);
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_sat_response_p'))
BEGIN
  exec Create_Property_Table cpaf_sat_response;
  PRINT 'cpaf_sat_response_p created'
END
GO

--[/RXPS-16698]

--[RXPS-21357]

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'image_url' AND object_id = OBJECT_ID('xom_item_mod'))
BEGIN
  ALTER TABLE xom_item_mod ADD image_url nvarchar(254) NULL;
  PRINT 'xom_item_mod.image_url created'
END
GO

--[/RXPS-21357]

--[/RXPS-19582]
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_tax_amount' AND object_id = OBJECT_ID('trl_sale_tax_lineitm'))
BEGIN
  ALTER TABLE trl_sale_tax_lineitm DROP COLUMN orig_tax_amount;
  PRINT 'trl_sale_tax_lineitm.orig_tax_amount dropped'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_taxable_amount' AND object_id = OBJECT_ID('trl_sale_tax_lineitm'))
BEGIN
  ALTER TABLE trl_sale_tax_lineitm ADD orig_taxable_amount decimal(17, 6);
  PRINT 'trl_sale_tax_lineitm.orig_taxable_amount added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_tax_group_id' AND object_id = OBJECT_ID('trl_sale_tax_lineitm'))
BEGIN
  ALTER TABLE trl_sale_tax_lineitm ADD orig_tax_group_id nvarchar(60);
  PRINT 'trl_sale_tax_lineitm.orig_tax_group_id added'
END
GO
--[/RXPS-19582]

--[RXPS-21905]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'assign_cash_drawer_req_flag' AND object_id = OBJECT_ID('tnd_tndr_options'))
BEGIN
  EXEC('ALTER TABLE tnd_tndr_options ADD assign_cash_drawer_req_flag bit default ((0)) null');
  EXEC('UPDATE tnd_tndr_options SET assign_cash_drawer_req_flag = 0');
  PRINT 'tnd_tndr_options.assign_cash_drawer_req_flag added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'post_void_assign_drawer_flag' AND object_id = OBJECT_ID('tnd_tndr_options'))
BEGIN
  EXEC('ALTER TABLE tnd_tndr_options ADD post_void_assign_drawer_flag bit default ((0)) null');
  EXEC('UPDATE tnd_tndr_options SET post_void_assign_drawer_flag = 0');
  PRINT 'tnd_tndr_options.post_void_assign_drawer_flag added'
END
GO
--[/RXPS-21905]

--[RXPS-13349]
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'sec_password' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE sec_password (
  organization_id INT           NOT NULL,
  password_id     INT           NOT NULL,
  password        NVARCHAR(254) NULL,
  create_date     DATETIME      NULL,
  create_user_id  NVARCHAR(30)  NULL,
  update_date     DATETIME      NULL,
  update_user_id  NVARCHAR(30)  NULL,
  record_state    NVARCHAR(30)  NULL,
  CONSTRAINT [pk_sec_password]
    PRIMARY KEY CLUSTERED (organization_id, password_id) WITH (FILLFACTOR = 80)
);
GO
--[/RXPS-13349]

--[RXPS-20569]
IF EXISTS (SELECT * FROM crm_party_id_xref)
BEGIN
  DELETE FROM crm_party_id_xref
  WHERE alternate_id_owner='XSTORE_LEGACY'

  INSERT INTO crm_party_id_xref(organization_id, party_id, alternate_id_owner, alternate_id, create_date, create_user_id)
  SELECT t1.organization_id, t1.party_id, 'XSTORE_LEGACY', t1.cust_id, getDate(), t1.create_user_id
  FROM crm_party t1, crm_party_id_xref t2
  WHERE t1.party_id=t2.party_id AND t2.alternate_id_owner='RELATE'

  UPDATE crm_party
  SET cust_id=alternate_id, update_date=getDate()
  FROM crm_party_id_xref
  WHERE crm_party.party_id=crm_party_id_xref.party_id AND crm_party_id_xref.alternate_id_owner='RELATE'
END
--[/RXPS-20569]

--[RXPS-24193]
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_stan' AND object_id = OBJECT_ID('trl_voucher_sale_lineitm') AND max_length=12)
  ALTER TABLE trl_voucher_sale_lineitm ALTER COLUMN orig_stan nvarchar(30) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_stan' AND object_id = OBJECT_ID('ttr_credit_debit_tndr_lineitm') AND max_length=12)
  ALTER TABLE ttr_credit_debit_tndr_lineitm ALTER COLUMN orig_stan nvarchar(30) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_stan' AND object_id = OBJECT_ID('ttr_voucher_tndr_lineitm') AND max_length=12)
  ALTER TABLE ttr_voucher_tndr_lineitm ALTER COLUMN orig_stan nvarchar(30) NULL;
GO
--[/RXPS-24193]
-- ***************************************************************************
-- This script will handle all post db create statements on an Xstore database compatible with DB 
-- platform <platform> and, where applicable, create/assign the appropriate users, roles, and 
-- platform-specific options for it.
--
-- This script does not define any schematics for the new database.  To identify an Xstore-compatible
-- schema for it, run the "new" script designated for the desired application version.
--
-- Platform:  Microsoft SQL Server 2008/2012
-- ***************************************************************************

use $(DbName);  -- If this is not the correct name for your database, please change it before executing this script.
GO

-- **************************************
PRINT '     - Set index fill factor = 80%';
-- **************************************
EXEC sp_configure 'show advanced options', 1;
RECONFIGURE;
EXEC sp_configure 'fill factor', 80;
EXEC sp_configure 'show advanced options', 0;
RECONFIGURE;
GO
DECLARE 
  @dbName nvarchar(30),
  @dbUser nvarchar(30),
  @sql nvarchar(512);
  
SELECT @dbName = DB_NAME();
SET @dbUser = N'dbauser';


IF NOT EXISTS (Select * From master.dbo.syslogins Where loginname = @dbUser)
BEGIN
  DECLARE
     @loginDb nvarchar(132),
     @loginLang nvarchar(132);
     
  SET @loginDb = null;
  SET @loginLang = N'us_english';
  
  SET @sql = 'CREATE LOGIN ' + @dbUser + ' ' +
    'WITH PASSWORD = ''' + @dbUser + ''', ' +
	'SID = 0xF095E77FF66663429D7883DFECDADF3C,' +
    'DEFAULT_LANGUAGE =  ' + @loginLang + ', ' +
    'DEFAULT_DATABASE = ' + @dbName + ', ' +
    'CHECK_POLICY = OFF';
  EXEC (@sql);
END;

-- **************************************
PRINT '     - Backup User: ' + @dbUser;
-- **************************************
EXEC sp_addsrvrolemember @dbUser, dbcreator;

IF NOT EXISTS (Select * From dbo.sysusers Where name = @dbUser And uid < 16382)
BEGIN
	SET @sql = 'CREATE USER ' + @dbUser + ' FOR LOGIN ' + @dbUser + ' WITH DEFAULT_SCHEMA=[dbo]';
	EXEC (@sql);
	
	EXEC sp_addrolemember N'db_backupoperator', @dbUser;
END;
GO

DECLARE 
  @dbName nvarchar(30),
  @dbUser nvarchar(30),
  @sql nvarchar(512);

SELECT @dbName = DB_NAME();
SET @dbUser = N'dtv';

IF NOT EXISTS (Select * From master.dbo.syslogins Where loginname = @dbUser)
BEGIN
  DECLARE
     @loginDb nvarchar(132),
     @loginLang nvarchar(132);
     
  SET @loginDb = null;
  SET @loginLang = N'us_english';
  
  IF @loginDb IS NULL OR NOT EXISTS (Select * From master.dbo.sysdatabases Where name = @loginDb)
    SET @loginDb = N'master';
    
  IF @loginLang IS NULL OR NOT EXISTS 
        (Select * From master.dbo.syslanguages Where name = @loginLang And name <> 'us_english')
    SET @loginLang = N'us_english';
  
  SET @sql = 'CREATE LOGIN ' + @dbUser + ' ' +
    'WITH PASSWORD = ''' + @dbUser + ''', ' +
	'SID = 0x42E5E3FF09069A47B8386FF8BF31BC56,' +
    'DEFAULT_LANGUAGE =  ' + @loginLang + ', ' +
    'DEFAULT_DATABASE = ' + @dbName + ', ' +
    'CHECK_POLICY = OFF';
  EXEC (@sql);
END


-- **************************************
PRINT '     - Admin User: ' + @dbUser;
PRINT '     - Role      : db_owner ';
-- **************************************

IF NOT EXISTS (Select * From dbo.sysusers Where name = @dbUser And uid < 16382)
  exec('CREATE USER ' + @dbUser + ' FOR LOGIN ' + @dbUser + ' WITH DEFAULT_SCHEMA=dbo');

EXEC sp_addrolemember N'db_owner', @dbUser;

GO

SETUSER;
GO
DECLARE 
  @dbName nvarchar(30),
  @dbUser nvarchar(30),
  @sql nvarchar(512);

SELECT @dbName = DB_NAME();
SET @dbUser = N'pos';

IF NOT EXISTS (Select * From master.dbo.syslogins Where loginname = @dbUser)
BEGIN
  DECLARE
     @loginDb nvarchar(132),
     @loginLang nvarchar(132);
     
  SET @loginDb = null;
  SET @loginLang = N'us_english';
  
  IF @loginDb IS NULL OR NOT EXISTS (Select * From master.dbo.sysdatabases Where name = @loginDb)
    SET @loginDb = N'master';
    
  IF @loginLang IS NULL OR NOT EXISTS 
        (Select * From master.dbo.syslanguages Where name = @loginLang And name <> 'us_english')
    SET @loginLang = N'us_english';
  
  SET @sql = 'CREATE LOGIN ' + @dbUser + ' ' +
    'WITH PASSWORD = ''' + @dbUser + ''', ' +
	'SID = 0x477813751A36C7409AB5A801D1691F35,' +
    'DEFAULT_LANGUAGE =  ' + @loginLang + ', ' +
    'DEFAULT_DATABASE = ' + @dbName + ', ' +
    'CHECK_POLICY = OFF';
  EXEC (@sql);
END


-- **************************************
PRINT '     - User: ' + @dbUser;
PRINT '     - Role: db_datareader';
PRINT '     - Role: db_datawriter';
PRINT '     - Role: execute';
-- **************************************

IF NOT EXISTS (Select * From dbo.sysusers Where name = @dbUser And uid < 16382)
  exec('CREATE USER ' + @dbUser + ' FOR LOGIN ' + @dbUser + ' WITH DEFAULT_SCHEMA=dbo');

EXEC sp_addrolemember N'db_datareader', @dbUser;
EXEC sp_addrolemember N'db_datawriter', @dbUser;
EXEC ('GRANT execute to ' + @dbUser);

GO

SETUSER;
GO
/* 
 * TABLE: [dbo].[cat_acct_note] 
 */

CREATE TABLE [dbo].[cat_acct_note](
    [organization_id]  int             NOT NULL,
    [cust_acct_code]   varchar(30)     NOT NULL,
    [cust_acct_id]     varchar(60)     NOT NULL,
    [note_seq]         bigint          NOT NULL,
    [entry_timestamp]  datetime        NULL,
    [entry_party_id]   bigint          NULL,
    [note]             varchar(max)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_cat_acct_note] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [note_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_acct_note_p] 
 */

CREATE TABLE [dbo].[cat_acct_note_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [note_seq]         bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_acct_note_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [note_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_authorizations] 
 */

CREATE TABLE [dbo].[cat_authorizations](
    [organization_id]     int            NOT NULL,
    [rtl_loc_id]          int            NOT NULL,
    [business_date]       datetime       NOT NULL,
    [wkstn_id]            bigint         NOT NULL,
    [trans_seq]           bigint         NOT NULL,
    [rtrans_lineitm_seq]  int            NOT NULL,
    [status_code]         varchar(30)    NULL,
    [status_datetime]     datetime       NULL,
    [authorization_type]  varchar(30)    NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_cat_authorizations] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_authorizations_p] 
 */

CREATE TABLE [dbo].[cat_authorizations_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_cat_authorizations_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_award_acct] 
 */

CREATE TABLE [dbo].[cat_award_acct](
    [organization_id]  int            NOT NULL,
    [cust_card_nbr]    varchar(60)    NOT NULL,
    [acct_id]          varchar(60)    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_cat_award_acct] PRIMARY KEY CLUSTERED ([organization_id], [cust_card_nbr], [acct_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_award_acct_coupon] 
 */

CREATE TABLE [dbo].[cat_award_acct_coupon](
    [organization_id]  int               NOT NULL,
    [cust_card_nbr]    varchar(60)       NOT NULL,
    [acct_id]          varchar(60)       NOT NULL,
    [coupon_id]        varchar(60)       NOT NULL,
    [amount]           decimal(17, 6)    NULL,
    [expiration_date]  datetime          NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_award_acct_coupon] PRIMARY KEY CLUSTERED ([organization_id], [cust_card_nbr], [acct_id], [coupon_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_award_acct_coupon_p] 
 */

CREATE TABLE [dbo].[cat_award_acct_coupon_p](
    [organization_id]  int               NOT NULL,
    [cust_card_nbr]    varchar(60)       NOT NULL,
    [acct_id]          varchar(60)       NOT NULL,
    [coupon_id]        varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_award_acct_coupon_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_card_nbr], [acct_id], [coupon_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_award_acct_p] 
 */

CREATE TABLE [dbo].[cat_award_acct_p](
    [organization_id]  int               NOT NULL,
    [cust_card_nbr]    varchar(60)       NOT NULL,
    [acct_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_award_acct_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_card_nbr], [acct_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_charge_acct_history] 
 */

CREATE TABLE [dbo].[cat_charge_acct_history](
    [organization_id]     int               NOT NULL,
    [cust_acct_code]      varchar(30)       NOT NULL,
    [cust_acct_id]        varchar(60)       NOT NULL,
    [history_seq]         bigint            NOT NULL,
    [activity_date]       datetime          NULL,
    [activity_enum]       varchar(30)       NULL,
    [amt]                 decimal(17, 6)    NULL,
    [party_id]            bigint            NULL,
    [acct_user_name]      varchar(254)      NULL,
    [business_date]       datetime          NULL,
    [trans_seq]           bigint            NULL,
    [rtrans_lineitm_seq]  int               NULL,
    [rtl_loc_id]          int               NULL,
    [wkstn_id]            bigint            NULL,
    [acct_balance]        decimal(17, 6)    NULL,
    [acct_user_id]		 varchar(30)	    NULL,
    [reversed_flag]		 bit			    DEFAULT (0) NOT NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_cat_charge_acct_history] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [history_seq]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX idx_cat_charge_acct_hist01 ON dbo.cat_charge_acct_history(party_id) WITH (FILLFACTOR = 80);
GO



/* 
 * TABLE: [dbo].[cat_charge_acct_history_p] 
 */

CREATE TABLE [dbo].[cat_charge_acct_history_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [history_seq]      bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_charge_acct_history_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [history_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_charge_acct_invoice] 
 */

CREATE TABLE [dbo].[cat_charge_acct_invoice](
    [organization_id]           int               NOT NULL,
    [cust_acct_code]            varchar(30)       NOT NULL,
    [cust_acct_id]              varchar(60)       NOT NULL,
    [invoice_number]            varchar(60)       NOT NULL,
    [original_invoice_balance]  decimal(17, 6)    NULL,
    [invoice_balance]           decimal(17, 6)    NOT NULL,
    [invoice_date]              datetime          NULL,
    [last_activity_date]        datetime          NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_cat_charge_acct_invoice] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [invoice_number]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_charge_acct_invoice_p] 
 */

CREATE TABLE [dbo].[cat_charge_acct_invoice_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [invoice_number]   varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_charge_acct_invoice_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [invoice_number], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_charge_acct_users] 
 */

CREATE TABLE [dbo].[cat_charge_acct_users](
    [organization_id]       int             NOT NULL,
    [cust_acct_code]        varchar(30)     NOT NULL,
    [cust_acct_id]          varchar(60)     NOT NULL,
    [acct_user_id]          varchar(30)     NOT NULL,
    [acct_user_name]        varchar(254)    NOT NULL,
    [party_id]              bigint          NULL,
    [effective_date]        datetime        NULL,
    [expiration_date]       datetime        NULL,
    [primary_contact_flag]  bit             DEFAULT ((0)) NULL,
    [acct_user_first_name]  varchar(60)	    NULL,
    [acct_user_last_name]   varchar(60)	    NULL,
    [create_date]           datetime        NULL,
    [create_user_id]        varchar(30)     NULL,
    [update_date]           datetime        NULL,
    [update_user_id]        varchar(30)     NULL,
    [record_state]          varchar(30)     NULL,
    CONSTRAINT [pk_cat_charge_acct_users] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [acct_user_id]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX idx_cat_charge_acct_users01 ON dbo.cat_charge_acct_users(party_id) WITH (FILLFACTOR = 80);
GO



/* 
 * TABLE: [dbo].[cat_charge_acct_users_p] 
 */

CREATE TABLE [dbo].[cat_charge_acct_users_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [acct_user_id]     varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_charge_acct_users_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [acct_user_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_cust_acct] 
 */

CREATE TABLE [dbo].[cat_cust_acct](
    [organization_id]         int               NOT NULL,
    [cust_acct_code]          varchar(30)       NOT NULL,
    [cust_acct_id]            varchar(60)       NOT NULL,
    [acct_balance]            decimal(17, 6)    NULL,
    [rtl_loc_id]              int               NULL,
    [cust_identity_req_flag]  bit               DEFAULT ((0)) NULL,
    [cust_identity_typcode]   varchar(30)       NULL,
    [party_id]                bigint            NULL,
    [acct_po_nbr]             varchar(60)       NULL,
    [dtv_class_name]          varchar(254)      NULL,
    [cust_acct_statcode]      varchar(30)       NULL,
    [last_activity_date]      datetime          NULL,
    [acct_setup_date]         datetime          NULL,
    [first_name]              varchar(254)      NULL,
    [last_name]               varchar(254)      NULL,
    [telephone]               varchar(32)       NULL,
    [create_date]             datetime          NULL,
    [create_user_id]          varchar(30)       NULL,
    [update_date]             datetime          NULL,
    [update_user_id]          varchar(30)       NULL,
    [record_state]            varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_acct] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_cat_custacct_id] 
 */

CREATE INDEX [xst_cat_custacct_id] ON [dbo].[cat_cust_acct]([cust_acct_id]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_cat_custacct_partyid] 
 */

CREATE INDEX [xst_cat_custacct_partyid] ON [dbo].[cat_cust_acct]([organization_id], [party_id]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [idx_cat_cust_acct01] 
 */

CREATE NONCLUSTERED INDEX idx_cat_cust_acct01 ON cat_cust_acct(organization_id,cust_acct_id,rtl_loc_id,cust_acct_code,cust_acct_statcode) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[cat_cust_acct_card] 
 */

CREATE TABLE [dbo].[cat_cust_acct_card](
    [organization_id]     int            NOT NULL,
    [cust_acct_card_nbr]  varchar(60)    NOT NULL,
    [party_id]            bigint         NULL,
    [effective_date]      datetime       NULL,
    [expr_date]           datetime       NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_cat_cust_acct_card] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_card_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_cust_acct_card_p] 
 */

CREATE TABLE [dbo].[cat_cust_acct_card_p](
    [organization_id]     int               NOT NULL,
    [cust_acct_card_nbr]  varchar(60)       NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_acct_card_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_card_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_cust_acct_journal] 
 */

CREATE TABLE [dbo].[cat_cust_acct_journal](
    [organization_id]        int               NOT NULL,
    [cust_acct_code]         varchar(30)       NOT NULL,
    [cust_acct_id]           varchar(60)       NOT NULL,
    [journal_seq]            bigint            NOT NULL,
    [rtl_loc_id]             int               NULL,
    [party_id]               bigint            NULL,
    [acct_balance]           decimal(17, 6)    NULL,
    [cust_identity_typcode]  varchar(30)       NULL,
    [trans_rtl_loc_id]       int               NULL,
    [trans_wkstn_id]         bigint            NULL,
    [trans_business_date]    datetime          NULL,
    [trans_trans_seq]        bigint            NULL,
    [dtv_class_name]         varchar(254)      NULL,
    [create_date]            datetime          NULL,
    [create_user_id]         varchar(30)       NULL,
    [update_date]            datetime          NULL,
    [update_user_id]         varchar(30)       NULL,
    [record_state]           varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_acct_journal] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [journal_seq]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX idx_cat_cust_acct_journal01 ON dbo.cat_cust_acct_journal(party_id) WITH (FILLFACTOR = 80);
GO



/* 
 * TABLE: [dbo].[cat_cust_acct_journal_p] 
 */

CREATE TABLE [dbo].[cat_cust_acct_journal_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [journal_seq]      bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_acct_journal_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [journal_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_cust_acct_p] 
 */

CREATE TABLE [dbo].[cat_cust_acct_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [date_value]       datetime          NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_acct_properties] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [property_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_cust_acct_plan] 
 */

CREATE TABLE [dbo].[cat_cust_acct_plan](
    [organization_id]   int             NOT NULL,
    [cust_acct_code]    varchar(30)     NOT NULL,
    [plan_id]           varchar(30)     NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [plan_description]  varchar(255)    NULL,
    [effective_date]    datetime        NULL,
    [expiration_date]   datetime        NULL,
    [display_order]     int             NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_cat_cust_acct_plan] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [plan_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_cat_cust_acct_plan_orgnode ON cat_cust_acct_plan (org_code,org_value) WITH (FILLFACTOR = 80)

go



/* 
 * TABLE: [dbo].[cat_cust_acct_plan_p] 
 */

CREATE TABLE [dbo].[cat_cust_acct_plan_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [plan_id]          varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_acct_plan_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [plan_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_cust_consumer_charge_acct] 
 */

CREATE TABLE [dbo].[cat_cust_consumer_charge_acct](
    [organization_id]	    int               NOT NULL,
    [cust_acct_code]	    varchar(30)       NOT NULL,
    [cust_acct_id]		    varchar(60)       NOT NULL,
    [credit_limit]		    decimal(17, 6)    NULL,
    [po_req_flag]		    bit               DEFAULT ((0)) NULL,
    [on_hold_flag]		    bit               DEFAULT ((0)) NULL,
    [corporate_account_flag] bit			  DEFAULT ((0)) NULL,
    [create_date]		    datetime          NULL,
    [create_user_id]	    varchar(30)       NULL,
    [update_date]		    datetime          NULL,
    [update_user_id]	    varchar(30)       NULL,
    [record_state]		    varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_cnsmr_chrg_acct] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_cust_item_acct] 
 */

CREATE TABLE [dbo].[cat_cust_item_acct](
    [organization_id]     int               NOT NULL,
    [cust_acct_code]      varchar(30)       NOT NULL,
    [cust_acct_id]        varchar(60)       NOT NULL,
    [acct_total]          decimal(17, 6)    NULL,
    [cust_acct_statcode]  varchar(30)       NULL,
    [acct_setup_date]     datetime          NULL,
    [active_payment_amt]  decimal(17, 6)    NULL,
    [total_payment_amt]   decimal(17, 6)    NULL,
    [active_acct_total]   decimal(17, 6)    NULL,
    [last_activity_date]  datetime          NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_item_acct] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_cust_item_acct_activity] 
 */

CREATE TABLE [dbo].[cat_cust_item_acct_activity](
    [organization_id]                 int               NOT NULL,
    [cust_acct_code]                  varchar(30)       NOT NULL,
    [cust_acct_id]                    varchar(60)       NOT NULL,
    [cust_item_acct_detail_item_nbr]  int               NOT NULL,
    [seq_nbr]                         int               NOT NULL,
    [activity_datetime]               datetime          NULL,
    [item_acct_activity_code]         varchar(30)       NULL,
    [item_acct_lineitm_statcode]      varchar(30)       NULL,
    [rtl_loc_id]                      int               NULL,
    [wkstn_id]                        bigint            NULL,
    [business_date]                   datetime          NULL,
    [trans_seq]                       bigint            NULL,
    [rtrans_lineitm_seq]              int               NULL,
    [unit_price]                      decimal(17, 6)    NULL,
    [quantity]                        decimal(11, 4)    NULL,
    [line_typcode]                    varchar(30)       NULL,
    [extended_amt]                    decimal(17, 6)    NULL,
    [net_amt]                         decimal(17, 6)    NULL,
    [scheduled_pickup_date]           datetime          NULL,
    [create_date]                     datetime          NULL,
    [create_user_id]                  varchar(30)       NULL,
    [update_date]                     datetime          NULL,
    [update_user_id]                  varchar(30)       NULL,
    [record_state]                    varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_item_acct_actvy] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [cust_item_acct_detail_item_nbr], [seq_nbr]) WITH (FILLFACTOR = 80)
)
go

/* 
 * INDEX: [idx_cat_cust_item_acct_actvy01] 
 */

CREATE INDEX [idx_cat_cust_item_acct_actvy01] ON [dbo].[cat_cust_item_acct_activity] ([organization_id],[rtl_loc_id],[wkstn_id],[business_date],[trans_seq]) WITH (FILLFACTOR = 80)
GO


/* 
 * TABLE: [dbo].[cat_cust_item_acct_activity_p] 
 */

CREATE TABLE [dbo].[cat_cust_item_acct_activity_p](
    [organization_id]                 int               NOT NULL,
    [cust_acct_code]                  varchar(30)       NOT NULL,
    [cust_acct_id]                    varchar(60)       NOT NULL,
    [cust_item_acct_detail_item_nbr]  int               NOT NULL,
    [seq_nbr]                         int               NOT NULL,
    [property_code]                   varchar(30)       NOT NULL,
    [type]                            varchar(30)       NULL,
    [string_value]                    varchar(max)      NULL,
    [date_value]                      datetime          NULL,
    [decimal_value]                   decimal(17, 6)    NULL,
    [create_date]                     datetime          NULL,
    [create_user_id]                  varchar(30)       NULL,
    [update_date]                     datetime          NULL,
    [update_user_id]                  varchar(30)       NULL,
    [record_state]                    varchar(30)       NULL,
    CONSTRAINT [pkcatcustitemacctactivityp] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [cust_item_acct_detail_item_nbr], [seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_cust_item_acct_detail] 
 */

CREATE TABLE [dbo].[cat_cust_item_acct_detail](
    [organization_id]                 int               NOT NULL,
    [cust_acct_code]                  varchar(30)       NOT NULL,
    [cust_acct_id]                    varchar(60)       NOT NULL,
    [cust_item_acct_detail_item_nbr]  int               NOT NULL,
    [item_acct_lineitm_statcode]      varchar(30)       NULL,
    [original_item_add_date]          datetime          NULL,
    [rtl_loc_id]                      int               NULL,
    [wkstn_id]                        bigint            NULL,
    [business_date]                   datetime          NULL,
    [trans_seq]                       bigint            NULL,
    [rtrans_lineitm_seq]              int               NULL,
    [line_typcode]                    varchar(30)       NULL,
    [extended_amt]                    decimal(17, 6)    NULL,
    [net_amt]                         decimal(17, 6)    NULL,
    [unit_price]                      decimal(17, 6)    NULL,
    [quantity]                        decimal(11, 4)    NULL,
    [scheduled_pickup_date]           datetime          NULL,
    [source_loc_id]                   int               NULL,
    [fullfillment_loc_id]             int               NULL,
    [delivery_type_id]                varchar(20)       NULL,
    [received_by_cust_date]           datetime          NULL,
    [create_date]                     datetime          NULL,
    [create_user_id]                  varchar(30)       NULL,
    [update_date]                     datetime          NULL,
    [update_user_id]                  varchar(30)       NULL,
    [record_state]                    varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_item_acct_detail] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [cust_item_acct_detail_item_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_cust_item_acct_detail_p] 
 */

CREATE TABLE [dbo].[cat_cust_item_acct_detail_p](
    [organization_id]                 int               NOT NULL,
    [cust_acct_code]                  varchar(30)       NOT NULL,
    [cust_acct_id]                    varchar(60)       NOT NULL,
    [cust_item_acct_detail_item_nbr]  int               NOT NULL,
    [property_code]                   varchar(30)       NOT NULL,
    [type]                            varchar(30)       NULL,
    [string_value]                    varchar(max)      NULL,
    [date_value]                      datetime          NULL,
    [decimal_value]                   decimal(17, 6)    NULL,
    [create_date]                     datetime          NULL,
    [create_user_id]                  varchar(30)       NULL,
    [update_date]                     datetime          NULL,
    [update_user_id]                  varchar(30)       NULL,
    [record_state]                    varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_item_acct_detail_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [cust_item_acct_detail_item_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_cust_item_acct_journal] 
 */

CREATE TABLE [dbo].[cat_cust_item_acct_journal](
    [organization_id]     int               NOT NULL,
    [cust_acct_code]      varchar(30)       NOT NULL,
    [cust_acct_id]        varchar(60)       NOT NULL,
    [journal_seq]         bigint            NOT NULL,
    [cust_acct_statcode]  varchar(30)       NULL,
    [acct_setup_date]     datetime          NULL,
    [last_activity_date]  datetime          NULL,
    [acct_total]          decimal(17, 6)    NULL,
    [active_payment_amt]  decimal(17, 6)    NULL,
    [active_acct_total]   decimal(17, 6)    NULL,
    [total_payment_amt]   decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_item_acct_journal] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [journal_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_cust_loyalty_acct] 
 */

CREATE TABLE [dbo].[cat_cust_loyalty_acct](
    [organization_id]             int               NOT NULL,
    [cust_acct_id]                varchar(60)       NOT NULL,
    [cust_card_nbr]               varchar(60)       DEFAULT ('UNKNOWN') NOT NULL,
    [effective_date]              datetime          NULL,
    [expiration_date]             datetime          NULL,
    [acct_balance]                decimal(17, 6)    NULL,
    [escrow_balance]              decimal(17, 6)    NULL,
    [bonus_balance]               decimal(17, 6)    NULL,
    [loyalty_program_id]          varchar(60)       NULL,
    [loyalty_program_level_id]    varchar(60)       NULL,
    [loyalty_program_name]        varchar(60)       NULL,
    [loyalty_program_level_name]  varchar(60)       NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_loyalty_acct] PRIMARY KEY CLUSTERED ([organization_id], [cust_card_nbr], [cust_acct_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_cust_loyalty_acct_p] 
 */

CREATE TABLE [dbo].[cat_cust_loyalty_acct_p](
    [organization_id]  int               NOT NULL,
    [cust_card_nbr]    varchar(60)       DEFAULT 'UNKNOWN' NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_cust_loyalty_acct_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_card_nbr], [cust_acct_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_delivery_modifier] 
 */

CREATE TABLE [dbo].[cat_delivery_modifier](
    [organization_id]      int             NOT NULL,
    [cust_acct_code]       varchar(30)     NOT NULL,
    [cust_acct_id]         varchar(60)     NOT NULL,
    [delivery_enum]        varchar(30)     NULL,
    [address1]             varchar(254)    NULL,
    [address2]             varchar(254)    NULL,
    [address3]             varchar(254)    NULL,
    [address4]             varchar(254)    NULL,
    [city]                 varchar(254)    NULL,
    [state]                varchar(30)     NULL,
    [postal_code]          varchar(30)     NULL,
    [country]              varchar(2)	   NULL,
	[neighborhood]		   varchar(254)	   null,
	[county]			   varchar(254)	   null,
    [telephone1]           varchar(32)     NULL,
    [telephone2]           varchar(32)     NULL,
    [telephone3]           varchar(32)     NULL,
    [telephone4]           varchar(32)     NULL,
    [apartment]            varchar(30)     NULL,
    [first_name]           varchar(254)    NULL,
    [middle_name]          varchar(254)    NULL,
    [last_name]            varchar(254)    NULL,
    [shipping_method]      varchar(254)    NULL,
    [tracking_number]      varchar(254)    NULL,
    [extension]            varchar(8)      NULL,
    [delivery_end_time]    datetime        NULL,
    [delivery_start_time]  datetime        NULL,
    [delivery_date]        datetime        NULL,
    [instructions]         varchar(254)    NULL,
    [geo_code]             varchar(20)     NULL,
    [create_date]          datetime        NULL,
    [create_user_id]       varchar(30)     NULL,
    [update_date]          datetime        NULL,
    [update_user_id]       varchar(30)     NULL,
    [record_state]         varchar(30)     NULL,
    CONSTRAINT [pk_cat_delivery_modifier] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_delivery_modifier_p] 
 */

CREATE TABLE [dbo].[cat_delivery_modifier_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_delivery_modifier_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_escrow_acct] 
 */

CREATE TABLE [dbo].[cat_escrow_acct](
    [organization_id]     int               NOT NULL,
    [cust_acct_id]        varchar(60)       NOT NULL,
    [acct_balance]        decimal(17, 6)    NULL,
    [cust_acct_statcode]  varchar(30)       NULL,
    [acct_setup_date]     datetime          NULL,
    [last_activity_date]  datetime          NULL,
    [party_id]            bigint            NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_cat_escrow_acct] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_escrow_acct_activity] 
 */

CREATE TABLE [dbo].[cat_escrow_acct_activity](
    [organization_id]        int               NOT NULL,
    [cust_acct_id]           varchar(60)       NOT NULL,
    [seq_nbr]                bigint            NOT NULL,
    [activity_date]          datetime          NULL,
    [activity_enum]          varchar(30)       NULL,
    [amt]                    decimal(17, 6)    NULL,
    [business_date]          datetime          NULL,
    [trans_seq]              bigint            NULL,
    [rtl_loc_id]             int               NULL,
    [wkstn_id]               bigint            NULL,
    [source_cust_acct_id]    varchar(60)       NULL,
    [source_cust_acct_code]  varchar(30)       NULL,
    [create_date]            datetime          NULL,
    [create_user_id]         varchar(30)       NULL,
    [update_date]            datetime          NULL,
    [update_user_id]         varchar(30)       NULL,
    [record_state]           varchar(30)       NULL,
    CONSTRAINT [pk_cat_escrow_acct_activity] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_id], [seq_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_escrow_acct_activity_p] 
 */

CREATE TABLE [dbo].[cat_escrow_acct_activity_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [seq_nbr]          bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_escrow_acct_activity_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_id], [seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_escrow_acct_p] 
 */

CREATE TABLE [dbo].[cat_escrow_acct_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_escrow_acct_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cat_payment_schedule] 
 */

CREATE TABLE [dbo].[cat_payment_schedule](
    [organization_id]     int               NOT NULL,
    [cust_acct_code]      varchar(30)       NOT NULL,
    [cust_acct_id]        varchar(60)       NOT NULL,
    [begin_date]          datetime          NULL,
    [interval_type_enum]  varchar(30)       NULL,
    [interval_count]      int               NULL,
    [total_payment_amt]   decimal(17, 6)    NULL,
    [payment_count]       int               NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_cat_payment_schedule] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cat_payment_schedule_p] 
 */

CREATE TABLE [dbo].[cat_payment_schedule_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cat_payment_schedule_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_invoice] 
 */

CREATE TABLE [dbo].[civc_invoice](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [business_year]       int             NOT NULL,
    [sequence_id]         varchar(255)    NOT NULL,
    [sequence_nbr]        bigint          NOT NULL,
    [invoice_type]        varchar(32)     NOT NULL,
    [business_date]       datetime        NOT NULL,
    [void_flag]           bit             DEFAULT 0 NULL,
    [party_id]            bigint          NOT NULL,
    [ext_invoice_id]      varchar(60)     NULL,
    [gross_amt]           decimal(17, 6)  NULL,
    [refund_amt]          decimal(17, 6)  NULL,
    [invoice_date]        datetime        NULL,
    [ext_invoice_barcode] varchar(60)     NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_civc_invoice] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_year], [sequence_id], [sequence_nbr])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_invoice_p] 
 */

CREATE TABLE [dbo].[civc_invoice_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [business_year]    int               NOT NULL,
    [sequence_id]      varchar(255)      NOT NULL,
    [sequence_nbr]     bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_civc_invoice_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_year], [sequence_id], [sequence_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_invoice_report] 
 */

CREATE TABLE [dbo].[civc_invoice_report](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [wkstn_id]          bigint            NOT NULL,
    [business_year]     int               NOT NULL,
    [sequence_id]       varchar(255)      NOT NULL,
    [sequence_nbr]      bigint            NOT NULL,
    [invoice_copy_nbr]  int               NOT NULL,
    [invoice_data]      varbinary(max)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_civc_invoice_report] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_year], [sequence_id], [sequence_nbr], [invoice_copy_nbr])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_invoice_report_p] 
 */

CREATE TABLE [dbo].[civc_invoice_report_p](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [wkstn_id]          bigint            NOT NULL,
    [business_year]     int               NOT NULL,
    [sequence_id]       varchar(255)      NOT NULL,
    [sequence_nbr]      bigint            NOT NULL,
    [invoice_copy_nbr]  int               NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_civc_invoice_report_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_year], [sequence_id], [sequence_nbr], [invoice_copy_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_invoice_xref] 
 */

CREATE TABLE [dbo].[civc_invoice_xref](
    [organization_id]      int             NOT NULL,
    [rtl_loc_id]           int             NOT NULL,
    [wkstn_id]             bigint          NOT NULL,
    [business_year]        int             NOT NULL,
    [sequence_id]          varchar(255)    NOT NULL,
    [sequence_nbr]         bigint          NOT NULL,
    [trans_rtl_loc_id]     int             NOT NULL,
    [trans_business_date]  datetime        NOT NULL,
    [trans_wkstn_id]       bigint          NOT NULL,
    [trans_trans_seq]      bigint          NOT NULL,
    [create_date]          datetime        NULL,
    [create_user_id]       varchar(30)     NULL,
    [update_date]          datetime        NULL,
    [update_user_id]       varchar(30)     NULL,
    [record_state]         varchar(30)     NULL,
    CONSTRAINT [pk_civc_invoice_xref] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_year], [sequence_id], [sequence_nbr], [trans_rtl_loc_id], [trans_business_date], [trans_wkstn_id], [trans_trans_seq])
    WITH FILLFACTOR = 80
)
go



/* 
 * INDEX: [idx_civc_invoice_xref_trans] 
 */

CREATE INDEX [idx_civc_invoice_xref_trans] ON [dbo].[civc_invoice_xref]([organization_id], [trans_rtl_loc_id], [trans_business_date], [trans_wkstn_id], [trans_trans_seq])
WITH FILLFACTOR = 80
go
/* 
 * TABLE: [dbo].[civc_invoice_xref_p] 
 */

CREATE TABLE [dbo].[civc_invoice_xref_p](
    [organization_id]      int               NOT NULL,
    [rtl_loc_id]           int               NOT NULL,
    [wkstn_id]             bigint            NOT NULL,
    [business_year]        int               NOT NULL,
    [sequence_id]          varchar(255)      NOT NULL,
    [sequence_nbr]         bigint            NOT NULL,
    [trans_rtl_loc_id]     int               NOT NULL,
    [trans_business_date]  datetime          NOT NULL,
    [trans_wkstn_id]       bigint            NOT NULL,
    [trans_trans_seq]      bigint            NOT NULL,
    [property_code]        varchar(30)       NOT NULL,
    [type]                 varchar(30)       NULL,
    [string_value]         varchar(max)      NULL,
    [date_value]           datetime          NULL,
    [decimal_value]        decimal(17, 6)    NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_civc_invoice_xref_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_year], [sequence_id], [sequence_nbr], [trans_rtl_loc_id], [trans_business_date], [trans_wkstn_id], [trans_trans_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_taxfree_card_range] 
 */

CREATE TABLE [dbo].[civc_taxfree_card_range](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [range_start]      varchar(8)      NOT NULL,
    [range_end]        varchar(8)      NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_civc_taxfree_card_range] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [range_start])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_taxfree_card_range_p] 
 */

CREATE TABLE [dbo].[civc_taxfree_card_range_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [range_start]      varchar(8)        NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_civc_taxfree_card_range_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [range_start], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_taxfree_country] 
 */

CREATE TABLE [dbo].[civc_taxfree_country](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [iso3num_code]     varchar(3)      NOT NULL,
    [iso2alp_code]     varchar(2)      NULL,
    [name]             varchar(150)    NULL,
    [phone_prefix]     varchar(4)      NULL,
    [passport_code]    varchar(10)     NULL,
    [void_flag]        bit             DEFAULT 0 NULL,
    [blocked_flag]     bit             DEFAULT 0 NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_civc_taxfree_country] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [iso3num_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[civc_taxfree_country_p] 
 */

CREATE TABLE [dbo].[civc_taxfree_country_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [iso3num_code]     varchar(3)        NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_civc_taxfree_country_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [iso3num_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_address] 
 */

CREATE TABLE [dbo].[com_address](
    [organization_id]  int             NOT NULL,
    [address_id]       varchar(60)     NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [address1]         varchar(254)    NULL,
    [address2]         varchar(254)    NULL,
    [address3]         varchar(254)    NULL,
    [address4]         varchar(254)    NULL,
    [apartment]        varchar(30)     NULL,
    [city]             varchar(254)    NULL,
    [territory]        varchar(254)    NULL,
    [postal_code]      varchar(254)    NULL,
    [country]          varchar(2)	   NULL,
	[neighborhood]	   varchar(254)	   null,
	[county]		   varchar(254)	   null,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_com_address] PRIMARY KEY CLUSTERED ([organization_id], [address_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_com_address_orgnode ON com_address (org_code,org_value) WITH (FILLFACTOR = 80)

go



/* 
 * TABLE: [dbo].[com_address_country] 
 */

CREATE TABLE [dbo].[com_address_country](
    [organization_id]    int            NOT NULL,
    [country_id]         varchar(2)     NOT NULL,
    [address_mode]       varchar(60)    DEFAULT 'DEFAULT' NOT NULL,
    [country_name]       varchar(254)   NULL,
    [max_postal_length]  int            NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     varchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     varchar(30)    NULL,
    [record_state]	     varchar(30)    NULL,
    CONSTRAINT [pk_com_address_country] PRIMARY KEY CLUSTERED ([organization_id], [country_id], [address_mode]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[com_address_country_p] 
 */

CREATE TABLE [dbo].[com_address_country_p](
    [organization_id]  int               NOT NULL,
    [country_id]       varchar(2)        NOT NULL,
    [address_mode]     varchar(60)       DEFAULT 'DEFAULT' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_address_country_p] PRIMARY KEY CLUSTERED ([organization_id], [country_id], [address_mode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_address_p] 
 */

CREATE TABLE [dbo].[com_address_p](
    [organization_id]  int               NOT NULL,
    [address_id]       varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_address_p] PRIMARY KEY CLUSTERED ([organization_id], [address_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_address_postalcode] 
 */

CREATE TABLE [dbo].[com_address_postalcode](
    [organization_id]  int            NOT NULL,
    [country_id]       varchar(2)     NOT NULL,
    [postal_code_id]   varchar(30)    NOT NULL,
    [address_mode]     varchar(60)    DEFAULT 'DEFAULT' NOT NULL,
    [postal_code]      varchar(30)    NULL,
    [state_id]         varchar(10)    NULL,
    [city_name]        varchar(254)   NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_com_address_postalcode] PRIMARY KEY CLUSTERED ([organization_id], [country_id], [postal_code_id], [address_mode]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[com_address_postalcode_p] 
 */

CREATE TABLE [dbo].[com_address_postalcode_p](
    [organization_id]  int               NOT NULL,
    [country_id]       varchar(2)        NOT NULL,
    [postal_code_id]   varchar(30)       NOT NULL,
    [address_mode]     varchar(60)       DEFAULT 'DEFAULT' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_address_postalcode_p] PRIMARY KEY CLUSTERED ([organization_id], [country_id], [postal_code_id], [address_mode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_address_state] 
 */

CREATE TABLE [dbo].[com_address_state](
    [organization_id]  int            NOT NULL,
    [country_id]       varchar(2)     NOT NULL,
    [state_id]         varchar(10)    NOT NULL,
    [address_mode]     varchar(60)    DEFAULT 'DEFAULT' NOT NULL,
    [state_name]       varchar(60)    NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_com_address_state] PRIMARY KEY CLUSTERED ([organization_id], [country_id], [state_id], [address_mode]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[com_address_state_p] 
 */

CREATE TABLE [dbo].[com_address_state_p](
    [organization_id]  int               NOT NULL,
    [country_id]       varchar(2)        NOT NULL,
    [state_id]         varchar(10)       NOT NULL,
    [address_mode]     varchar(60)       DEFAULT 'DEFAULT' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_address_state_p] PRIMARY KEY CLUSTERED ([organization_id], [country_id], [state_id], [address_mode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_airport] 
 */

CREATE TABLE [dbo].[com_airport](
    [organization_id]  int             NOT NULL,
    [airport_code]     varchar(3)      NOT NULL,
    [airport_name]     varchar(254)    NOT NULL,
    [country_code]     varchar(2)      NOT NULL,
    [zone_id]          varchar(30)     NOT NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_com_airport] PRIMARY KEY CLUSTERED ([organization_id], [airport_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_airport_p] 
 */

CREATE TABLE [dbo].[com_airport_p](
    [organization_id]  int             NOT NULL,
    [airport_code]     varchar(3)      NOT NULL,
    [property_code]    varchar(30)     NOT NULL,
    [type]             varchar(30)     NULL,
    [string_value]     varchar(max)    NULL,
    [date_value]       datetime        NULL,
    [decimal_value]    decimal(17, 6)  NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_com_airport_p] PRIMARY KEY CLUSTERED ([organization_id], [airport_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_airport_zone] 
 */

CREATE TABLE [dbo].[com_airport_zone](
    [organization_id]  int             NOT NULL,
    [zone_id]          varchar(30)     NOT NULL,
    [description]      varchar(254)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_com_airport_zone] PRIMARY KEY CLUSTERED ([organization_id], [zone_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_airport_zone_detail] 
 */

CREATE TABLE [dbo].[com_airport_zone_detail](
    [organization_id]       int            NOT NULL,
    [zone_id]               varchar(30)    NOT NULL,
    [destination_zone_id]   varchar(30)    NOT NULL,
    [tax_calculation_mode]  varchar(30)    NOT NULL,
    [create_date]           datetime       NULL,
    [create_user_id]        varchar(30)    NULL,
    [update_date]           datetime       NULL,
    [update_user_id]        varchar(30)    NULL,
    [record_state]		    varchar(30)    NULL,
    CONSTRAINT [pk_com_airport_zone_detail] PRIMARY KEY CLUSTERED ([organization_id], [zone_id], [destination_zone_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_airport_zone_detail_p] 
 */

CREATE TABLE [dbo].[com_airport_zone_detail_p](
    [organization_id]      int               NOT NULL,
    [zone_id]              varchar(30)       NOT NULL,
    [destination_zone_id]  varchar(30)       NOT NULL,
    [property_code]        varchar(30)       NOT NULL,
    [type]                 varchar(30)       NULL,
    [string_value]         varchar(max)      NULL,
    [date_value]           datetime          NULL,
    [decimal_value]        decimal(17, 6)    NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_com_airport_zone_detail_p] PRIMARY KEY CLUSTERED ([organization_id], [zone_id], [destination_zone_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_airport_zone_p] 
 */

CREATE TABLE [dbo].[com_airport_zone_p](
    [organization_id]  int               NOT NULL,
    [zone_id]          varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_airport_zone_p] PRIMARY KEY CLUSTERED ([organization_id], [zone_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_button_grid] 
 */

CREATE TABLE [dbo].[com_button_grid](
    [organization_id]  int             NOT NULL,
    [level_code]       varchar(30)     DEFAULT '*' NOT NULL,
    [level_value]      varchar(60)     DEFAULT '*' NOT NULL,
    [grid_id]          varchar(50)     NOT NULL,
    [row_id]		   int             NOT NULL,
    [column_id]        int             NOT NULL,
    [component_id]     varchar(50)     NOT NULL,
    [sort_order]       int             DEFAULT 0 NOT NULL,
    [child_id]         varchar(50)     NULL,
    [key_name]         varchar(50)     NULL,
    [data]             varchar(100)    NULL,
    [text]             varchar(255)    NULL,
    [text_x]           int             NULL,
    [text_y]           int             NULL,
    [image_filename]   varchar(512)    NULL,
    [image_x]          int			   NULL,
    [image_y]          int			   NULL,
    [visibility_rule]  varchar(255)    NULL,
    [height_span]      int             NULL,
    [width_span]       int             NULL,
    [background_rgb]   varchar(7)      NULL,
    [foreground_rgb]   varchar(7)      NULL,
    [button_style]     varchar(50)     NULL,
    [action_idx]       int             NULL,
    [animation_idx]    int             NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_com_button_grid] PRIMARY KEY CLUSTERED ([organization_id], [level_code], [level_value], [grid_id], [row_id], [column_id], [component_id], [sort_order])
    WITH FILLFACTOR = 80
)
go

/* 
 * TABLE: [dbo].[com_button_grid_p] 
 */

CREATE TABLE [dbo].[com_button_grid_p](
    [organization_id]  int             NOT NULL,
    [level_code]       varchar(30)     DEFAULT '*' NOT NULL,
    [level_value]      varchar(60)     DEFAULT '*' NOT NULL,
    [grid_id]          varchar(50)     NOT NULL,
    [row_id]       int             NOT NULL,
    [column_id]        int             NOT NULL,
    [component_id]     varchar(50)     NOT NULL,
    [sort_order]       int             DEFAULT 0 NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_button_grid_p] PRIMARY KEY CLUSTERED ([organization_id], [level_code], [level_value], [grid_id], [row_id], [column_id], [component_id], [sort_order], [property_code])
    WITH FILLFACTOR = 80
)
go

/* 
 * TABLE: [dbo].[com_code_value] 
 */

CREATE TABLE [dbo].[com_code_value](
    [organization_id]  int             NOT NULL,
    [category]         varchar(30)     NOT NULL,
    [code]             varchar(60)     NOT NULL,
    [description]      varchar(254)    NULL,
    [sort_order]       int             NULL,
    [hidden_flag]      bit             DEFAULT 0 NULL,
    [rank]             int             NULL,
    [image_url]        varchar(254)    NULL,
	[config_element]   varchar(200)	   DEFAULT '*' NOT NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_com_code_value] PRIMARY KEY CLUSTERED ([organization_id], [category], [code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[com_code_value_p] 
 */

CREATE TABLE [dbo].[com_code_value_p](
    [organization_id]  int               NOT NULL,
    [category]         varchar(30)       NOT NULL,
    [code]             varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_code_value_p] PRIMARY KEY CLUSTERED ([organization_id], [category], [code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_country_return_map] 
 */

CREATE TABLE [dbo].[com_country_return_map](
    [organization_id]             int             NOT NULL,
    [purchased_from]              varchar(2)      NOT NULL,
    [return_to]                   varchar(2)      NOT NULL,
    [disallow_cross_border_flag]  bit             DEFAULT 0 NULL,
    [create_date]                 datetime        NULL,
    [create_user_id]              varchar(30)     NULL,
    [update_date]                 datetime        NULL,
    [update_user_id]              varchar(30)     NULL,
    [record_state]                varchar(30)     NULL,
    CONSTRAINT [pk_com_country_return_map] PRIMARY KEY CLUSTERED ([organization_id], [purchased_from], [return_to])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_country_return_map_p] 
 */

CREATE TABLE [dbo].[com_country_return_map_p](
    [organization_id]  int               NOT NULL,
    [purchased_from]   varchar(2)        NOT NULL,
    [return_to]        varchar(2)        NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_country_return_map_p] PRIMARY KEY CLUSTERED ([organization_id], [purchased_from], [return_to], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_external_system_map] 
 */

CREATE TABLE [dbo].[com_external_system_map](
    [system_map_id]    int            NOT NULL,
    [system_cd]        varchar(10)    NOT NULL,
    [organization_id]  int            NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_com_external_system_map] PRIMARY KEY CLUSTERED ([system_map_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_com_external_system_map01] 
 */

CREATE INDEX [idx_com_external_system_map01] ON [dbo].[com_external_system_map]([system_cd])
INCLUDE (organization_id) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [idx_com_external_system_map02] 
 */

CREATE INDEX [idx_com_external_system_map02] ON [dbo].[com_external_system_map]([organization_id])
INCLUDE (system_cd) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[com_flight_info] 
 */

CREATE TABLE [dbo].[com_flight_info](
    [organization_id]           int            NOT NULL,
    [scheduled_date_time]       datetime       NOT NULL,
    [origin_airport]            varchar(3)     NOT NULL,
    [flight_number]             varchar(30)     NOT NULL,
    [destination_airport]       varchar(3)     NOT NULL,
    [via_1_airport]             varchar(3)     NULL,
    [via_2_airport]             varchar(3)     NULL,
    [via_3_airport]             varchar(3)     NULL,
    [create_date]               datetime       NULL,
    [create_user_id]            varchar(30)    NULL,
    [update_date]               datetime       NULL,
    [update_user_id]            varchar(30)    NULL,
    [record_state]              varchar(30)    NULL,
    CONSTRAINT [pk_com_flight_info] PRIMARY KEY CLUSTERED ([organization_id], [scheduled_date_time], [origin_airport], [flight_number]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[com_flight_info_p] 
 */

CREATE TABLE [dbo].[com_flight_info_p](
    [organization_id]      int               NOT NULL,
    [scheduled_date_time]  datetime          NOT NULL,
    [origin_airport]       varchar(3)       NOT NULL,
    [flight_number]        varchar(30)       NOT NULL,
    [property_code]        varchar(30)       NOT NULL,
    [type]                 varchar(30)       NULL,
    [string_value]         varchar(max)      NULL,
    [date_value]           datetime          NULL,
    [decimal_value]        decimal(17, 6)    NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_com_flight_info_p] PRIMARY KEY CLUSTERED ([organization_id], [scheduled_date_time], [origin_airport], [flight_number], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_reason_code] 
 */

CREATE TABLE [dbo].[com_reason_code](
    [organization_id]  int               NOT NULL,
    [reason_typcode]   varchar(30)       NOT NULL,
    [reason_code]      varchar(30)       NOT NULL,
    [description]      varchar(254)      NULL,
    [parent_code]      varchar(30)       NULL,
    [gl_acct_nbr]      varchar(254)      NULL,
    [minimum_amt]      decimal(17, 6)    NULL,
    [maximum_amt]      decimal(17, 6)    NULL,
    [comment_req]      varchar(10)       NULL,
    [cust_msg]         varchar(254)      NULL,
    [inv_action_code]  varchar(30)       NULL,
    [location_id]      varchar(60)       NULL,
    [bucket_id]        varchar(60)       NULL,
    [sort_order]       int               NULL,
    [hidden_flag]      bit               DEFAULT 0 NULL,
	[config_element]   varchar(200)		 DEFAULT '*' NOT NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_reason_code] PRIMARY KEY CLUSTERED ([organization_id], [reason_typcode], [reason_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[com_reason_code_p] 
 */

CREATE TABLE [dbo].[com_reason_code_p](
    [organization_id]  int               NOT NULL,
    [reason_typcode]   varchar(30)       NOT NULL,
    [reason_code]      varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_reason_code_p] PRIMARY KEY CLUSTERED ([organization_id], [reason_typcode], [reason_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_receipt_text] 
 */

CREATE TABLE [dbo].[com_receipt_text](
    [organization_id]  int             NOT NULL,
    [text_code]        varchar(30)     NOT NULL,
    [text_subcode]     varchar(30)     NOT NULL,
    [text_seq]         int             NOT NULL,
	[config_element]   varchar(200)	   DEFAULT '*' NOT NULL,
    [receipt_text]     varchar(max)    NOT NULL,
    [effective_date]   datetime        NULL,
    [expiration_date]  datetime        NULL,
    [reformat_flag]    bit             DEFAULT (1) NULL,
    [line_format]      varchar(254)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_com_receipt_text] PRIMARY KEY CLUSTERED ([organization_id], [text_code], [text_subcode], [text_seq], [config_element]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[com_receipt_text_p] 
 */

CREATE TABLE [dbo].[com_receipt_text_p](
    [organization_id]  int               NOT NULL,
    [text_code]        varchar(30)       NOT NULL,
    [text_subcode]     varchar(30)       NOT NULL,
    [text_seq]         int               NOT NULL,
    [config_element]   varchar(200)      DEFAULT '*' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_receipt_text_p] PRIMARY KEY CLUSTERED ([organization_id], [text_code], [text_subcode], [text_seq], [config_element], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_report_data] 
 */

CREATE TABLE [dbo].[com_report_data](
    [organization_id]  int               NOT NULL,
    [owner_type_enum]  varchar(30)       NOT NULL,
    [owner_id]         varchar(60)       NOT NULL,
    [report_id]        varchar(60)       NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')       NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')       NOT NULL,
    [report_data]      varbinary(max)    NULL,
    [delete_flag]      bit               DEFAULT ((0)) NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_report_data] PRIMARY KEY CLUSTERED ([organization_id], [owner_type_enum], [owner_id], [report_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_com_report_data_orgnode ON com_report_data (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[com_report_data_p] 
 */

CREATE TABLE [dbo].[com_report_data_p](
    [organization_id]  int               NOT NULL,
    [owner_type_enum]  varchar(30)       NOT NULL,
    [owner_id]         varchar(60)       NOT NULL,
    [report_id]        varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_report_data_p] PRIMARY KEY CLUSTERED ([organization_id], [owner_type_enum], [owner_id], [report_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_report_lookup] 
 */

CREATE TABLE [dbo].[com_report_lookup](
    [organization_id]       int             NOT NULL,
    [owner_type_enum]       varchar(30)     NOT NULL,
    [owner_id]              varchar(60)     NOT NULL,
    [report_id]             varchar(60)     NOT NULL,
    [org_code]              varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]             varchar(60) DEFAULT('*')     NOT NULL,
    [report_url]            varchar(254)    NULL,
    [description]           varchar(254)    NULL,
    [record_type_enum]      varchar(30)     NULL,
    [record_creation_date]  datetime        NULL,
    [record_level_enum]     varchar(30)     NULL,
    [parent_report_id]      varchar(60)     NULL,
    [delete_flag]           bit             DEFAULT ((0)) NOT NULL,
    [create_date]           datetime        NULL,
    [create_user_id]        varchar(30)     NULL,
    [update_date]           datetime        NULL,
    [update_user_id]        varchar(30)     NULL,
    [record_state]          varchar(30)     NULL,
    CONSTRAINT [pk_com_report_lookup] PRIMARY KEY CLUSTERED ([organization_id], [owner_type_enum], [owner_id], [report_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_com_report_lookup_orgnode ON com_report_lookup (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[com_report_lookup_p] 
 */

CREATE TABLE [dbo].[com_report_lookup_p](
    [organization_id]  int               NOT NULL,
    [owner_type_enum]  varchar(30)       NOT NULL,
    [owner_id]         varchar(60)       NOT NULL,
    [report_id]        varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_report_lookup_p] PRIMARY KEY CLUSTERED ([organization_id], [owner_type_enum], [owner_id], [report_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_sequence] 
 */

CREATE TABLE [dbo].[com_sequence](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [sequence_id]      varchar(255)      NOT NULL,
	[sequence_mode]	   varchar(30)		 DEFAULT 'ACTIVE' NOT NULL,
    [sequence_nbr]     numeric(19, 0)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_sequence] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [sequence_id], [sequence_mode])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_sequence_p] 
 */

CREATE TABLE [dbo].[com_sequence_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [sequence_id]      varchar(255)      NOT NULL,
	[sequence_mode]	   varchar(30)		 DEFAULT 'ACTIVE' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_sequence_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [sequence_id], [sequence_mode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_sequence_part] 
 */

CREATE TABLE [dbo].[com_sequence_part](
    [organization_id]   int               NOT NULL,
    [sequence_id]       varchar(255)      NOT NULL,
    [prefix]            varchar(30)       NULL,
    [suffix]            varchar(30)       NULL,
    [encode_flag]       bit               NULL,
    [check_digit_algo]  varchar(30)       NULL,
    [numeric_flag]      bit               NULL,
    [pad_length]        int               NULL,
    [pad_character]     varchar(2)        NULL,
    [initial_value]     int               NULL,
    [max_value]         numeric(10, 0)    NULL,
    [value_increment]   int               NULL,
    [include_store_id]  bit               NULL,
    [store_pad_length]  int               NULL,
    [include_wkstn_id]  bit               NULL,
    [wkstn_pad_length]  int               NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_com_sequence_part] PRIMARY KEY CLUSTERED ([organization_id], [sequence_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_sequence_part_p] 
 */

CREATE TABLE [dbo].[com_sequence_part_p](
    [organization_id]  int               NOT NULL,
    [sequence_id]      varchar(255)      NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_sequence_part_p] PRIMARY KEY CLUSTERED ([organization_id], [sequence_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_shipping_cost] 
 */

CREATE TABLE [dbo].[com_shipping_cost](
    [organization_id]  int               NOT NULL,
    [begin_range]      decimal(11, 2)    NOT NULL,
    [end_range]        decimal(11, 2)    NOT NULL,
    [cost]             decimal(17, 6)    NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')       NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')       NOT NULL,
    [category]         varchar(30)       NOT NULL,
    [minimum_cost]     decimal(17, 6)    NULL,
    [maximum_cost]     decimal(17, 6)    NULL,
    [item_id]          varchar(60)       NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_shipping_cost] PRIMARY KEY CLUSTERED ([organization_id], [begin_range], [end_range], [cost], [category]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_com_shipping_cost_orgnode ON com_shipping_cost (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[com_shipping_cost_p] 
 */

CREATE TABLE [dbo].[com_shipping_cost_p](
    [organization_id]  int               NOT NULL,
    [begin_range]      decimal(11, 2)    NOT NULL,
    [end_range]        decimal(11, 2)    NOT NULL,
    [cost]             decimal(17, 6)    NOT NULL,
    [category]         varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_shipping_cost_p] PRIMARY KEY CLUSTERED ([organization_id], [begin_range], [end_range], [cost], [category], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_shipping_fee] 
 */

CREATE TABLE [dbo].[com_shipping_fee](
    [organization_id]   int            NOT NULL,
    [rule_name]         varchar(30)    NOT NULL,
    [org_code]			varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]			varchar(60) DEFAULT('*')    NOT NULL,
    [priority]          int            NULL,
    [ship_item_id]      varchar(60)    NULL,
    [aggregation_type]  varchar(30)    NULL,
    [rule_type]         varchar(30)    NULL,
    [param1]            varchar(30)    NULL,
    [param2]            varchar(30)    NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [PK_com_shipping_fee] PRIMARY KEY CLUSTERED ([organization_id], [rule_name]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_com_shipping_fee_orgnode ON com_shipping_fee (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[com_shipping_fee_p] 
 */

CREATE TABLE [dbo].[com_shipping_fee_p](
    [organization_id]  int               NOT NULL,
    [rule_name]        varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_shipping_fee_p] PRIMARY KEY CLUSTERED ([organization_id], [rule_name], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_shipping_fee_tier] 
 */

CREATE TABLE [dbo].[com_shipping_fee_tier](
    [organization_id]   int               NOT NULL,
    [rule_name]         varchar(30)       NOT NULL,
    [parent_rule_name]  varchar(30)       NOT NULL,
    [org_code]          varchar(30) DEFAULT('*')       NOT NULL,
    [org_value]         varchar(60) DEFAULT('*')       NOT NULL,
    [priority]          int               NULL,
    [fee_type]          varchar(20)       NULL,
    [fee_value]         decimal(17, 6)    NULL,
    [ship_method]       varchar(60)       NULL,
    [min_price]         decimal(17, 6)    NULL,
    [max_price]         decimal(17, 6)    NULL,
    [item_id]           varchar(60)       NULL,
    [rule_type]         varchar(30)       NULL,
    [param1]            varchar(30)       NULL,
    [param2]            varchar(30)       NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [PK_com_shipping_fee_tier] PRIMARY KEY CLUSTERED ([organization_id], [rule_name], [parent_rule_name]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_com_ship_tier_ship_method] 
 */

CREATE INDEX [xst_com_ship_tier_ship_method] ON [dbo].[com_shipping_fee_tier]([ship_method]) WITH (FILLFACTOR = 80)

CREATE INDEX idx_comshippingfeetierorgnode ON com_shipping_fee_tier (org_code,org_value) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[com_shipping_fee_tier_p] 
 */

CREATE TABLE [dbo].[com_shipping_fee_tier_p](
    [organization_id]   int               NOT NULL,
    [rule_name]         varchar(30)       NOT NULL,
    [parent_rule_name]  varchar(30)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_com_shipping_fee_tier_p] PRIMARY KEY CLUSTERED ([organization_id], [rule_name], [parent_rule_name], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_trans_prompt_properties] 
 */

CREATE TABLE [dbo].[com_trans_prompt_properties](
    [organization_id]				int            NOT NULL,
    [trans_prompt_property_code]	varchar(30)    NOT NULL,
    [effective_date]				datetime       NOT NULL,
    [org_code]						varchar(30)	   DEFAULT '*' NOT NULL,
    [org_value]						varchar(60)	   DEFAULT '*' NOT NULL,
    [expiration_date]				datetime       NULL,
    [code_category]					varchar(30)    NULL,
    [prompt_title_key]				varchar(60)    NULL,
    [prompt_msg_key]				varchar(60)    NULL,
    [required_flag]					bit            DEFAULT 0 NULL,
    [sort_order]					int            NULL,
    [prompt_mthd_code]				varchar(30)    NULL,
    [prompt_edit_pattern]			varchar(30)    NULL,
    [validation_rule_key]			varchar(30)    NULL,
    [transaction_state]				varchar(30)    NULL,
    [prompt_key]					varchar(30)    NULL,
    [chain_key]						varchar(30)    NULL,
    [create_date]					datetime       NULL,
    [create_user_id]				varchar(30)    NULL,
    [update_date]					datetime       NULL,
    [update_user_id]				varchar(30)    NULL,
    [record_state]					varchar(30)    NULL,
    CONSTRAINT [pk_com_trans_prompt_prpts] PRIMARY KEY CLUSTERED ([organization_id], [trans_prompt_property_code], [effective_date]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idxcomtrnsprmptprprtiesorgnode ON com_trans_prompt_properties (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[com_trans_prompt_properties_p] 
 */

CREATE TABLE [dbo].[com_trans_prompt_properties_p](
    [organization_id]             int               NOT NULL,
    [trans_prompt_property_code]  varchar(30)       NOT NULL,
    [effective_date]              datetime          NOT NULL,
    [property_code]               varchar(30)       NOT NULL,
    [type]                        varchar(30)       NULL,
    [string_value]                varchar(max)      NULL,
    [date_value]                  datetime          NULL,
    [decimal_value]               decimal(17, 6)    NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pkcomtranspromptpropertiesp] PRIMARY KEY CLUSTERED ([organization_id], [trans_prompt_property_code], [effective_date], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[com_translations] 
 */

CREATE TABLE [dbo].[com_translations](
    [organization_id]  int             NOT NULL,
    [locale]           varchar(30)     NOT NULL,
    [translation_key]  varchar(150)    NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [translation]      varchar(max)    NULL,
	[EXTERNAL_SYSTEM]  varchar(60)	   null,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_com_translations] PRIMARY KEY CLUSTERED ([organization_id], [locale], [translation_key]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_com_translations_orgnode ON com_translations (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[com_translations_p] 
 */

CREATE TABLE [dbo].[com_translations_p](
    [organization_id]  int               NOT NULL,
    [locale]           varchar(30)       NOT NULL,
    [translation_key]  varchar(150)      NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_com_translations_p] PRIMARY KEY CLUSTERED ([organization_id], [locale], [translation_key], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_address_muni] 
 */

CREATE TABLE [dbo].[cpaf_address_muni](
  [organization_id]         INT         NOT NULL,
  [municipality_id]         INT         NOT NULL,
  [uf]                      VARCHAR(2)  NULL,
  [name]                    VARCHAR(72) NULL,
  [ibge_code]               VARCHAR(7)  NULL,
  [postal_code_start]       VARCHAR(8)  NULL,
  [postal_code_end]         VARCHAR(8)  NULL,
  [parent_municipality_id]  INT         NULL,
  [loc_in_sit]              VARCHAR(1)  NULL,
  [loc_in_tipo_loc]         VARCHAR(1)  NULL,
  [create_date]             DATETIME    NULL,
  [create_user_id]          VARCHAR(30) NULL,
  [update_date]             DATETIME    NULL,
  [update_user_id]          VARCHAR(30) NULL,
  [record_state]            VARCHAR(30) NULL,
  CONSTRAINT [pk_cpaf_address_muni] PRIMARY KEY CLUSTERED ([organization_id], [municipality_id]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_address_muni_p] 
 */

CREATE TABLE [dbo].[cpaf_address_muni_p](
  [organization_id]  INT            NOT NULL,
  [municipality_id]  INT            NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_address_muni_p] PRIMARY KEY CLUSTERED ([organization_id], [municipality_id], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_card_network] 
 */

CREATE TABLE [dbo].[cpaf_card_network](
    [organization_id]  int          NOT NULL,
    [network_name]     varchar(254) NOT NULL,
    [network_id]       varchar(30)  NULL,
    [tax_id]           varchar(30)  NULL,
    [create_date]      datetime     NULL,
    [create_user_id]   varchar(30)  NULL,
    [update_date]      datetime     NULL,
    [update_user_id]   varchar(30)  NULL,
    [record_state]     varchar(30)  NULL,
    CONSTRAINT [pk_cpaf_card_network] PRIMARY KEY CLUSTERED ([organization_id], [network_name])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_card_network_p] 
 */

CREATE TABLE [dbo].[cpaf_card_network_p](
    [organization_id]  int               NOT NULL,
    [network_name]     varchar(254)      NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cpaf_card_network_p] PRIMARY KEY CLUSTERED ([organization_id], [network_name], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfce_queue_tender] 
 */

CREATE TABLE [dbo].[cpaf_nfce_queue_tender](
  [organization_id]       INT           NOT NULL,
  [rtl_loc_id]            INT           NOT NULL,
  [wkstn_id]              INT           NOT NULL,
  [queue_seq]             INT           NOT NULL,
  [sequence]              INT           NOT NULL,
  [tndr_id]               VARCHAR(60)   NOT NULL,
  [fiscal_tender_id]      VARCHAR(60)   NOT NULL,
  [amount]                DECIMAL(17,6) NULL,
  [card_network_id]       VARCHAR(30)   NULL,
  [card_tax_id]           VARCHAR(30)   NULL,
  [card_auth_number]      VARCHAR(254)  NULL,
  [card_type]             VARCHAR(254)  NULL,
  [card_trace_number]     VARCHAR(254)  NULL,
  [card_integration_mode] VARCHAR(30)   NULL,
  [card_installments]     INT DEFAULT 0,
  [create_date]           DATETIME      NULL,
  [create_user_id]        VARCHAR(30)   NULL,
  [update_date]           DATETIME      NULL,
  [update_user_id]        VARCHAR(30)   NULL,
  [record_state]          VARCHAR(30)   NULL,
  CONSTRAINT [pk_cpaf_nfce_queue_tender] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence], [tndr_id]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfce_queue_tender_p] 
 */

CREATE TABLE [dbo].[cpaf_nfce_queue_tender_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [wkstn_id]         INT            NOT NULL,
  [queue_seq]        INT            NOT NULL,
  [sequence]         INT            NOT NULL,
  [tndr_id]          VARCHAR(60)    NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfce_queue_tender_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence], [tndr_id], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfce_tender] 
 */

CREATE TABLE [dbo].[cpaf_nfce_tender](
  [organization_id]         INT           NOT NULL,
  [rtl_loc_id]              INT           NOT NULL,
  [environment_id]          INT           NOT NULL,
  [tp_nf]                   INT           NOT NULL,
  [series_id]               INT           NOT NULL,
  [nnf]                     INT           NOT NULL,
  [model]                   VARCHAR(2)    NOT NULL,
  [sequence]                INT           NOT NULL,
  [tndr_id]                 VARCHAR(60)   NOT NULL,
  [fiscal_tender_id]        VARCHAR(60 )  NOT NULL,
  [amount]                  DECIMAL(17,6) NULL,
  [card_network_id]         VARCHAR(30)   NULL,
  [card_tax_id]             VARCHAR(30)   NULL,
  [card_auth_number]        VARCHAR(254)  NULL,
  [card_type]               VARCHAR(254)  NULL,
  [card_trace_number]       VARCHAR(254)  NULL,
  [card_integration_mode]   VARCHAR(30)   NULL,
  [card_installments]       INT DEFAULT 0,
  [create_date]             DATETIME      NULL,
  [create_user_id]          VARCHAR(30)   NULL,
  [update_date]             DATETIME      NULL,
  [update_user_id]          VARCHAR(30)   NULL,
  [record_state]            VARCHAR(30)   NULL,
  CONSTRAINT [pk_cpaf_nfce_tender] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [sequence], [tndr_id])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfce_tender_p] 
 */

CREATE TABLE [dbo].[cpaf_nfce_tender_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [environment_id]   INT            NOT NULL,
  [tp_nf]            INT            NOT NULL,
  [series_id]        INT            NOT NULL,
  [nnf]              INT            NOT NULL,
  [model]            VARCHAR(2)     NOT NULL,
  [sequence]         INT            NOT NULL,
  [tndr_id]          VARCHAR(60)    NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfce_tender_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [sequence], [tndr_id], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe] 
 */

CREATE TABLE [dbo].[cpaf_nfe](
  [organization_id]   INT        NOT NULL,
  [rtl_loc_id]        INT        NOT NULL,
  [environment_id]    INT        NOT NULL,
  [tp_nf]             INT        NOT NULL,
  [series_id]         INT        NOT NULL,
  [nnf]               INT        NOT NULL,
  [model]             VARCHAR(2) NOT NULL,
  [cuf]               INT            NULL,
  [cnf]               INT            NULL,
  [trans_typcode]     VARCHAR(30)    NULL,
  [natop]             VARCHAR(60)    NULL,
  [indpag]            INT            NULL,
  [issue_date]        DATETIME       NULL,
  [sai_ent_datetime]  DATETIME       NULL,
  [cmun_fg]           VARCHAR(7)     NULL,
  [tp_imp]            INT            NULL,
  [tp_emis]           INT            NULL,
  [fin_nfe]           INT            NULL,
  [proc_emi]          INT            NULL,
  [ver_proc]          VARCHAR(20)    NULL,
  [cont_datetime]     DATETIME       NULL,
  [cont_xjust]        VARCHAR(255)   NULL,
  [product_amount]    DECIMAL(17,6)  NULL,
  [service_amount]    DECIMAL(17,6)  NULL,
  [icms_basis]        DECIMAL(17,6)  NULL,
  [icms_amount]       DECIMAL(17,6)  NULL,
  [icms_st_basis]     DECIMAL(17,6)  NULL,
  [icms_st_amount]    DECIMAL(17,6)  NULL,
  [iss_basis]         DECIMAL(17,6)  NULL,
  [iss_amount]        DECIMAL(17,6)  NULL,
  [ii_amount]         DECIMAL(17,6)  NULL,
  [pis_amount]        DECIMAL(17,6)  NULL,
  [cofins_amount]     DECIMAL(17,6)  NULL,
  [iss_pis_amount]    DECIMAL(17,6)  NULL,
  [iss_cofins_amount] DECIMAL(17,6)  NULL,
  [discount_amount]   DECIMAL(17,6)  NULL,
  [freight_amount]    DECIMAL(17,6)  NULL,
  [insurance_amount]  DECIMAL(17,6)  NULL,
  [other_amount]      DECIMAL(17,6)  NULL,
  [total_amount]      DECIMAL(17,6)  NULL,
  [inf_cpl]           VARCHAR(MAX)   NULL,
  [protocolo]         VARCHAR(30)    NULL,
  [canc_protocolo]    VARCHAR(30)    NULL,
  [chave_nfe]         VARCHAR(88)    NULL,
  [old_chave_nfe]     VARCHAR(88)    NULL,
  [recibo]            VARCHAR(30)    NULL,
  [stat_code]         VARCHAR(30)    NULL,
  [xml]               VARCHAR(MAX)   NULL,
  [dig_val]           VARCHAR(30)    NULL,
  [iss_service_date]  VARCHAR(10)    NULL,
  [create_date]       DATETIME       NULL,
  [create_user_id]    VARCHAR(30)    NULL,
  [update_date]       DATETIME       NULL,
  [update_user_id]    VARCHAR(30)    NULL,
  [record_state]      VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_dest] 
 */

CREATE TABLE [dbo].[cpaf_nfe_dest](
  [organization_id]      INT          NOT NULL,
  [rtl_loc_id]           INT          NOT NULL,
  [environment_id]       INT          NOT NULL,
  [tp_nf]                INT          NOT NULL,
  [series_id]            INT          NOT NULL,
  [nnf]                  INT          NOT NULL,
  [model]                VARCHAR(2)   NOT NULL,
  [name]                 VARCHAR(60)  NULL,
  [federal_tax_id]       VARCHAR(20)  NULL,
  [state_tax_id]         VARCHAR(20)  NULL,
  [street_name]          VARCHAR(60)  NULL,
  [street_num]           VARCHAR(60)  NULL,
  [complemento]          VARCHAR(60)  NULL,
  [neighborhood]         VARCHAR(60)  NULL,
  [city_code]            VARCHAR(7)   NULL,
  [city]                 VARCHAR(60)  NULL,
  [state]                VARCHAR(2)   NULL,
  [postal_code]          VARCHAR(8)   NULL,
  [country_code]         VARCHAR(4)   NULL,
  [country_name]         VARCHAR(60)  NULL,
  [telephone]            VARCHAR(14)  NULL,
  [email]                VARCHAR(60)  NULL,
  [create_date]          DATETIME     NULL,
  [create_user_id]       VARCHAR(30)  NULL,
  [update_date]          DATETIME     NULL,
  [update_user_id]       VARCHAR(30)  NULL,
  [record_state]         VARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_dest] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_dest_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_dest_p](
  [organization_id]  INT              NOT NULL,
  [rtl_loc_id]       INT              NOT NULL,
  [environment_id]   INT              NOT NULL,
  [tp_nf]            INT              NOT NULL,
  [series_id]        INT              NOT NULL,
  [nnf]              INT              NOT NULL,
  [model]            VARCHAR(2)       NOT NULL,
  [property_code]    VARCHAR(30)      NOT NULL,
  [type]             VARCHAR(30)      NULL,
  [string_value]     VARCHAR(MAX)     NULL,
  [date_value]       DATETIME         NULL,
  [decimal_value]    DECIMAL(17, 6)   NULL,
  [create_date]      DATETIME         NULL,
  [create_user_id]   VARCHAR(30)      NULL,
  [update_date]      DATETIME         NULL,
  [update_user_id]   VARCHAR(30)      NULL,
  [record_state]     VARCHAR(30)      NULL,
  CONSTRAINT [pk_cpaf_nfe_dest_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_issuer] 
 */

CREATE TABLE [dbo].[cpaf_nfe_issuer](
  [organization_id]      INT          NOT NULL,
  [rtl_loc_id]           INT          NOT NULL,
  [environment_id]       INT          NOT NULL,
  [tp_nf]                INT          NOT NULL,
  [series_id]            INT          NOT NULL,
  [nnf]                  INT          NOT NULL,
  [model]                VARCHAR(2)   NOT NULL,
  [name]                 VARCHAR(60)  NULL,
  [fantasy_name]         VARCHAR(60)  NULL,
  [federal_tax_id]       VARCHAR(20)  NULL,
  [state_tax_id]         VARCHAR(20)  NULL,
  [city_tax_id]          VARCHAR(20)  NULL,
  [crt]                  VARCHAR(1)   NULL,
  [street_name]          VARCHAR(60)  NULL,
  [street_num]           VARCHAR(60)  NULL,
  [complemento]          VARCHAR(60)  NULL,
  [neighborhood]         VARCHAR(60)  NULL,
  [city_code]            VARCHAR(7)   NULL,
  [city]                 VARCHAR(60)  NULL,
  [state]                VARCHAR(2)   NULL,
  [postal_code]          VARCHAR(8)   NULL,
  [country_code]         VARCHAR(4)   NULL,
  [country_name]         VARCHAR(60)  NULL,
  [telephone]            VARCHAR(14)  NULL,
  [create_date]          DATETIME     NULL,
  [create_user_id]       VARCHAR(30)  NULL,
  [update_date]          DATETIME     NULL,
  [update_user_id]       VARCHAR(30)  NULL,
  [record_state]         VARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_issuer] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_issuer_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_issuer_p](
  [organization_id]  INT              NOT NULL,
  [rtl_loc_id]       INT              NOT NULL,
  [environment_id]   INT              NOT NULL,
  [tp_nf]            INT              NOT NULL,
  [series_id]        INT              NOT NULL,
  [nnf]              INT              NOT NULL,
  [model]            VARCHAR(2)       NOT NULL,
  [property_code]    VARCHAR(30)      NOT NULL,
  [type]             VARCHAR(30)      NULL,
  [string_value]     VARCHAR(MAX)     NULL,
  [date_value]       DATETIME         NULL,
  [decimal_value]    DECIMAL(17, 6)   NULL,
  [create_date]      DATETIME         NULL,
  [create_user_id]   VARCHAR(30)      NULL,
  [update_date]      DATETIME         NULL,
  [update_user_id]   VARCHAR(30)      NULL,
  [record_state]     VARCHAR(30)      NULL,
  CONSTRAINT [pk_cpaf_nfe_issuer_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_item] 
 */

CREATE TABLE [dbo].[cpaf_nfe_item](
  [organization_id]              INT        NOT NULL,
  [rtl_loc_id]                   INT        NOT NULL,
  [environment_id]               INT        NOT NULL,
  [tp_nf]                        INT        NOT NULL,
  [series_id]                    INT        NOT NULL,
  [nnf]                          INT        NOT NULL,
  [model]                        VARCHAR(2) NOT NULL,
  [sequence]                     INT        NOT NULL,
  [item_id]                      VARCHAR(60)   NULL,
  [item_description]             VARCHAR(254)  NULL,
  [ean]                          VARCHAR(14)   NULL,
  [ncm]                          VARCHAR(8)    NULL,
  [cest]                         VARCHAR(18)   NULL,
  [ex_tipi]                      VARCHAR(3)    NULL,
  [quantity]                     DECIMAL(11,4) NULL,
  [unit_of_measure_code]         VARCHAR(30)   NULL,
  [taxable_ean]                  VARCHAR(14)   NULL,
  [taxable_unit_of_measure_code] VARCHAR(30)   NULL,
  [iat]                          VARCHAR(1)    NULL,
  [ippt]                         VARCHAR(1)    NULL,
  [unit_price]                   DECIMAL(17,6) NULL,
  [extended_amount]              DECIMAL(17,6) NULL,
  [taxable_quantity]             DECIMAL(11,4) NULL,
  [unit_taxable_amount]          DECIMAL(17,6) NULL,
  [freight_amount]               DECIMAL(17,6) NULL,
  [insurance_amount]             DECIMAL(17,6) NULL,
  [discount_amount]              DECIMAL(17,6) NULL,
  [other_amount]                 DECIMAL(17,6) NULL,
  [cfop]                         VARCHAR(4)    NULL,
  [inf_ad_prod]                  VARCHAR(500)  NULL,
  [icms_cst]                     VARCHAR(3)    NULL,
  [icms_basis]                   DECIMAL(17,6) NULL,
  [icms_amount]                  DECIMAL(17,6) NULL,
  [icms_rate]                    DECIMAL(5,2)  NULL,
  [icms_st_basis]                DECIMAL(17,6) NULL,
  [icms_st_amount]               DECIMAL(17,6) NULL,
  [icms_st_rate]                 DECIMAL(5,2)  NULL,
  [iss_basis]                    DECIMAL(17,6) NULL,
  [iss_amount]                   DECIMAL(17,6) NULL,
  [iss_rate]                     DECIMAL(5,2)  NULL,
  [ipi_amount]                   DECIMAL(17,6) NULL,
  [ipi_rate]                     DECIMAL(5,2)  NULL,
  [ii_amount]                    DECIMAL(17,6) NULL,
  [pis_basis]                    DECIMAL(17,6) NULL,
  [pis_amount]                   DECIMAL(17,6) NULL,
  [pis_rate]                     DECIMAL(17,6) NULL,
  [cofins_basis]                 DECIMAL(17,6) NULL,
  [cofins_amount]                DECIMAL(17,6) NULL,
  [cofins_rate]                  DECIMAL(17,6) NULL,
  [tax_situation_code]           VARCHAR(6)    NULL,
  [tax_group_id]                 VARCHAR(120)  NULL,
  [log_sequence]                 INT           NULL,
  [ref_nfe]                      VARCHAR(88)   NULL,
  [iis_city_code]                VARCHAR(7)    NULL,
  [iis_service_code]             VARCHAR(5)    NULL,
  [iis_eligible_indicator]       VARCHAR(2)    NULL,
  [iis_incentive_indicator]      VARCHAR(1)    NULL,
  [create_date]                  DATETIME      NULL,
  [create_user_id]               VARCHAR(30)   NULL,
  [update_date]                  DATETIME      NULL,
  [update_user_id]               VARCHAR(30)   NULL,
  [record_state]                 VARCHAR(30)   NULL,
  CONSTRAINT [pk_cpaf_nfe_item] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [sequence]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_item_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_item_p](
    [organization_id]  INT        NOT NULL,
    [rtl_loc_id]       INT        NOT NULL,
    [environment_id]   INT        NOT NULL,
    [tp_nf]            INT        NOT NULL,
    [series_id]        INT        NOT NULL,
    [nnf]              INT        NOT NULL,
    [model]            VARCHAR(2) NOT NULL,
    [sequence]         INT        NOT NULL,
    [property_code]    VARCHAR(30)       NOT NULL,
    [type]             VARCHAR(30)       NULL,
    [string_value]     VARCHAR(MAX)      NULL,
    [date_value]       DATETIME          NULL,
    [decimal_value]    DECIMAL(17, 6)    NULL,
    [create_date]      DATETIME          NULL,
    [create_user_id]   VARCHAR(30)       NULL,
    [update_date]      DATETIME          NULL,
    [update_user_id]   VARCHAR(30)       NULL,
    [record_state]     VARCHAR(30)       NULL,
    CONSTRAINT [pk_cpaf_nfe_item_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [sequence], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [environment_id]   INT            NOT NULL,
  [tp_nf]            INT            NOT NULL,
  [series_id]        INT            NOT NULL,
  [nnf]              INT            NOT NULL,
  [model]            VARCHAR(2)     NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue](
  [organization_id]   INT           NOT NULL,
  [rtl_loc_id]        INT           NOT NULL,
  [wkstn_id]          INT           NOT NULL,
  [queue_seq]         INT           NOT NULL,
  [environment_id]    INT           NULL,
  [tp_nf]             INT           NULL,
  [series_id]         INT           NULL,
  [nnf]               INT           NULL,
  [cuf]               INT           NULL,
  [cnf]               INT           NULL,
  [usage_type]        VARCHAR(30)   NULL,
  [trans_typcode]     VARCHAR(30)   NULL,
  [natop]             VARCHAR(60)   NULL,
  [indpag]            INT           NULL,
  [model]             VARCHAR(2)    NULL,
  [issue_date]        DATETIME      NULL,
  [sai_ent_datetime]  DATETIME      NULL,
  [cmun_fg]           VARCHAR(7)    NULL,
  [tp_imp]            INT           NULL,
  [tp_emis]           INT           NULL,
  [fin_nfe]           INT           NULL,
  [proc_emi]          INT           NULL,
  [ver_proc]          VARCHAR(20)   NULL,
  [cont_datetime]     DATETIME      NULL,
  [cont_xjust]        VARCHAR(255)  NULL,
  [product_amount]    DECIMAL(17,6) NULL,
  [service_amount]    DECIMAL(17,6) NULL,
  [icms_basis]        DECIMAL(17,6) NULL,
  [icms_amount]       DECIMAL(17,6) NULL,
  [icms_st_basis]     DECIMAL(17,6) NULL,
  [icms_st_amount]    DECIMAL(17,6) NULL,
  [iss_basis]         DECIMAL(17,6) NULL,
  [iss_amount]        DECIMAL(17,6) NULL,
  [ii_amount]         DECIMAL(17,6) NULL,
  [pis_amount]        DECIMAL(17,6) NULL,
  [cofins_amount]     DECIMAL(17,6) NULL,
  [iss_pis_amount]    DECIMAL(17,6) NULL,
  [iss_cofins_amount] DECIMAL(17,6) NULL,
  [discount_amount]   DECIMAL(17,6) NULL,
  [freight_amount]    DECIMAL(17,6) NULL,
  [insurance_amount]  DECIMAL(17,6) NULL,
  [other_amount]      DECIMAL(17,6) NULL,
  [total_amount]      DECIMAL(17,6) NULL,
  [inf_cpl]           VARCHAR(MAX)  NULL,
  [protocolo]         VARCHAR(30)   NULL,
  [canc_protocolo]    VARCHAR(30)   NULL,
  [chave_nfe]         VARCHAR(88)   NULL,
  [old_chave_nfe]     VARCHAR(88)   NULL,
  [recibo]            VARCHAR(30)   NULL,
  [stat_code]         VARCHAR(30)   NULL,
  [xml]               VARCHAR(MAX)  NULL,
  [response_code]     VARCHAR(30)   NULL,
  [response_text]     VARCHAR(MAX)  NULL,
  [dig_val]           VARCHAR(30)   NULL,
  [iss_service_date]  VARCHAR(10)   NULL,
  [create_date]       DATETIME      NULL,
  [create_user_id]    VARCHAR(30)   NULL,
  [update_date]       DATETIME      NULL,
  [update_user_id]    VARCHAR(30)   NULL,
  [record_state]      VARCHAR(30)   NULL,
  CONSTRAINT [pk_cpaf_nfe_queue] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_dest] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_dest](
  [organization_id]  INT           NOT NULL,
  [rtl_loc_id]       INT           NOT NULL,
  [wkstn_id]         INT           NOT NULL,
  [queue_seq]        INT           NOT NULL,
  [name]             VARCHAR(60)  NULL,
  [federal_tax_id]   VARCHAR(20)  NULL,
  [state_tax_id]     VARCHAR(20)  NULL,
  [street_name]      VARCHAR(60)  NULL,
  [street_num]       VARCHAR(60)  NULL,
  [complemento]      VARCHAR(60)  NULL,
  [neighborhood]     VARCHAR(60)  NULL,
  [city_code]        VARCHAR(7)   NULL,
  [city]             VARCHAR(60)  NULL,
  [state]            VARCHAR(2)   NULL,
  [postal_code]      VARCHAR(8)   NULL,
  [country_code]     VARCHAR(4)   NULL,
  [country_name]     VARCHAR(60)  NULL,
  [telephone]        VARCHAR(14)  NULL,
  [email]            VARCHAR(60)  NULL,
  [create_date]      DATETIME    NULL,
  [create_user_id]   VARCHAR(30) NULL,
  [update_date]      DATETIME    NULL,
  [update_user_id]   VARCHAR(30) NULL,
  [record_state]     VARCHAR(30) NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_dest] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_dest_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_dest_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [wkstn_id]         INT            NOT NULL,
  [queue_seq]        INT            NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_dest_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_issuer] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_issuer](
  [organization_id]  INT         NOT NULL,
  [rtl_loc_id]       INT         NOT NULL,
  [wkstn_id]         INT         NOT NULL,
  [queue_seq]        INT         NOT NULL,
  [name]             VARCHAR(60) NULL,
  [fantasy_name]     VARCHAR(60) NULL,
  [federal_tax_id]   VARCHAR(20) NULL,
  [state_tax_id]     VARCHAR(20) NULL,
  [city_tax_id]      VARCHAR(20) NULL,
  [crt]              VARCHAR(1)  NULL,
  [street_name]      VARCHAR(60) NULL,
  [street_num]       VARCHAR(60) NULL,
  [complemento]      VARCHAR(60) NULL,
  [neighborhood]     VARCHAR(60) NULL,
  [city_code]        VARCHAR(7)  NULL,
  [city]             VARCHAR(60) NULL,
  [state]            VARCHAR(2)  NULL,
  [postal_code]      VARCHAR(8)  NULL,
  [country_code]     VARCHAR(4)  NULL,
  [country_name]     VARCHAR(60) NULL,
  [telephone]        VARCHAR(14) NULL,
  [create_date]      DATETIME    NULL,
  [create_user_id]   VARCHAR(30) NULL,
  [update_date]      DATETIME    NULL,
  [update_user_id]   VARCHAR(30) NULL,
  [record_state]     VARCHAR(30) NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_issuer] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_issuer_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_issuer_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [wkstn_id]         INT            NOT NULL,
  [queue_seq]        INT            NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_issuer_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_item] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_item](
  [organization_id]               INT           NOT NULL,
  [rtl_loc_id]                    INT           NOT NULL,
  [wkstn_id]                      INT           NOT NULL,
  [queue_seq]                     INT           NOT NULL,
  [sequence]                      INT           NOT NULL,
  [item_id]                       VARCHAR(60)   NULL,
  [item_description]              VARCHAR(254)  NULL,
  [ean]                           VARCHAR(14)   NULL,
  [ncm]                           VARCHAR(8)    NULL,
  [cest]                          VARCHAR(18)   NULL,
  [ex_tipi]                       VARCHAR(3)    NULL,
  [quantity]                      DECIMAL(11,4) NULL,
  [unit_of_measure_code]          VARCHAR(30)   NULL,
  [taxable_ean]                   VARCHAR(14)   NULL,
  [taxable_unit_of_measure_code]  VARCHAR(30)   NULL,
  [iat]                           VARCHAR(1)    NULL,
  [ippt]                          VARCHAR(1)    NULL,
  [unit_price]                    DECIMAL(17,6) NULL,
  [extended_amount]               DECIMAL(17,6) NULL,
  [taxable_quantity]              DECIMAL(11,4) NULL,
  [unit_taxable_amount]           DECIMAL(17,6) NULL,
  [freight_amount]                DECIMAL(17,6) NULL,
  [insurance_amount]              DECIMAL(17,6) NULL,
  [discount_amount]               DECIMAL(17,6) NULL,
  [other_amount]                  DECIMAL(17,6) NULL,
  [cfop]                          VARCHAR(4)    NULL,
  [inf_ad_prod]                   VARCHAR(500)  NULL,
  [icms_cst]                      VARCHAR(3)    NULL,
  [icms_basis]                    DECIMAL(17,6) NULL,
  [icms_amount]                   DECIMAL(17,6) NULL,
  [icms_rate]                     DECIMAL(5,2)  NULL,
  [icms_st_basis]                 DECIMAL(17,6) NULL,
  [icms_st_amount]                DECIMAL(17,6) NULL,
  [icms_st_rate]                  DECIMAL(5,2)  NULL,
  [iss_basis]                     DECIMAL(17,6) NULL,
  [iss_amount]                    DECIMAL(17,6) NULL,
  [iss_rate]                      DECIMAL(5,2)  NULL,
  [ipi_amount]                    DECIMAL(17,6) NULL,
  [ipi_rate]                      DECIMAL(5,2)  NULL,
  [ii_amount]                     DECIMAL(17,6) NULL,
  [pis_basis]                     DECIMAL(17,6) NULL,
  [pis_amount]                    DECIMAL(17,6) NULL,
  [pis_rate]                      DECIMAL(17,6) NULL,
  [cofins_basis]                  DECIMAL(17,6) NULL,
  [cofins_amount]                 DECIMAL(17,6) NULL,
  [cofins_rate]                   DECIMAL(17,6) NULL,
  [tax_situation_code]            VARCHAR(6)    NULL,
  [tax_group_id]                  VARCHAR(120)  NULL,
  [log_sequence]                  INT           NULL,
  [ref_nfe]                       VARCHAR(88)   NULL,
  [iis_city_code]                 VARCHAR(7)    NULL,
  [iis_service_code]              VARCHAR(5)    NULL,
  [iis_eligible_indicator]        VARCHAR(2)    NULL,
  [iis_incentive_indicator]       VARCHAR(1)    NULL,
  [create_date]                   DATETIME      NULL,
  [create_user_id]                VARCHAR(30)   NULL,
  [update_date]                   DATETIME      NULL,
  [update_user_id]                VARCHAR(30)   NULL,
  [record_state]                  VARCHAR(30)   NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_item] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_item_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_item_p](
  [organization_id]  INT               NOT NULL,
  [rtl_loc_id]       INT               NOT NULL,
  [wkstn_id]         INT               NOT NULL,
  [queue_seq]        INT               NOT NULL,
  [sequence]         INT               NOT NULL,
  [property_code]    VARCHAR(30)       NOT NULL,
  [type]             VARCHAR(30)       NULL,
  [string_value]     VARCHAR(MAX)      NULL,
  [date_value]       DATETIME          NULL,
  [decimal_value]    DECIMAL(17, 6)    NULL,
  [create_date]      DATETIME          NULL,
  [create_user_id]   VARCHAR(30)       NULL,
  [update_date]      DATETIME          NULL,
  [update_user_id]   VARCHAR(30)       NULL,
  [record_state]     VARCHAR(30)       NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_item_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_log] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_log](
  [organization_id]  INT          NOT NULL,
  [rtl_loc_id]       INT          NOT NULL,
  [wkstn_id]         INT          NOT NULL,
  [queue_seq]        INT          NOT NULL,
  [sequence]         INT          NOT NULL,
  [stat_code]        VARCHAR(30)  NULL,
  [response_code]    VARCHAR(30)  NULL,
  [response_text]    VARCHAR(MAX) NULL,
  [source]           VARCHAR(255) NULL,
  [create_date]      DATETIME     NULL,
  [create_user_id]   VARCHAR(30)  NULL,
  [update_date]      DATETIME     NULL,
  [update_user_id]   VARCHAR(30)  NULL,
  [record_state]     VARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_log] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_log_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_log_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [wkstn_id]         INT            NOT NULL,
  [queue_seq]        INT            NOT NULL,
  [sequence]         INT            NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_log_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [wkstn_id]         INT            NOT NULL,
  [queue_seq]        INT            NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_trans] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_trans](
  [organization_id]  INT         NOT NULL,
  [rtl_loc_id]       INT         NOT NULL,
  [wkstn_id]         INT         NOT NULL,
  [business_date]    DATETIME    NOT NULL,
  [trans_seq]        INT         NOT NULL,
  [trans_wkstn_id]   INT         NOT NULL DEFAULT (1),
  [queue_seq]        INT         NOT NULL,
  [inactive_flag]    INT         NOT NULL DEFAULT (0),
  [create_date]      DATETIME    NULL,
  [create_user_id]   VARCHAR(30) NULL,
  [update_date]      DATETIME    NULL,
  [update_user_id]   VARCHAR(30) NULL,
  [record_state]     VARCHAR(30) NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [trans_wkstn_id], [queue_seq])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_queue_trans_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_queue_trans_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [wkstn_id]         INT            NOT NULL,
  [business_date]    DATETIME       NOT NULL,
  [trans_seq]        INT            NOT NULL,
  [trans_wkstn_id]   INT            NOT NULL DEFAULT (1),
  [queue_seq]        INT            NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_trans_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [trans_wkstn_id], [queue_seq], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_resend_queue] 
 */

CREATE TABLE [dbo].[cpaf_nfe_resend_queue](
  [organization_id]  INT         NOT NULL,
  [rtl_loc_id]       INT         NOT NULL,
  [wkstn_id]         INT         NOT NULL,
  [chave_nfe]        VARCHAR(88) NOT NULL,
  [copies]           INT         NULL,
  [requesting_user]  VARCHAR(20) NULL,
  [email_address]    VARCHAR(30) NULL,
  [create_date]      DATETIME    NULL,
  [create_user_id]   VARCHAR(30) NULL,
  [update_date]      DATETIME    NULL,
  [update_user_id]   VARCHAR(30) NULL,
  [record_state]     VARCHAR(30) NULL,
  CONSTRAINT [pk_cpaf_nfe_resend_queue] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [chave_nfe])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_resend_queue_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_resend_queue_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [wkstn_id]         INT            NOT NULL,
  [chave_nfe]        VARCHAR(88)    NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_resend_queue_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [chave_nfe], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_tax_cst] 
 */

CREATE TABLE [dbo].[cpaf_nfe_tax_cst](
  [organization_id]     INT          NOT NULL,
  [trans_typcode]       VARCHAR(30)  NOT NULL,
  [tax_loc_id]          VARCHAR(30)  NOT NULL,
  [tax_group_id]        VARCHAR(120) NOT NULL,
  [tax_authority_id]    VARCHAR(60)  NOT NULL,
  [cst]                 VARCHAR(2)   NULL,
  [create_date]         DATETIME     NULL,
  [create_user_id]      VARCHAR(30)  NULL,
  [update_date]         DATETIME     NULL,
  [update_user_id]      VARCHAR(30)  NULL,
  [record_state]        VARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_tax_cst] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [tax_loc_id], [tax_group_id], [tax_authority_id]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_tax_cst_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_tax_cst_p](
  [organization_id]  INT            NOT NULL,
  [trans_typcode]    VARCHAR(30)    NOT NULL,
  [tax_loc_id]       VARCHAR(30)    NOT NULL,
  [tax_group_id]     VARCHAR(120)   NOT NULL,
  [tax_authority_id] VARCHAR(60)    NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_tax_cst_p] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [tax_loc_id], [tax_group_id], [tax_authority_id], [property_code])
  WITH FILLFACTOR = 80
)
go




/* 
 * TABLE: [dbo].[cpaf_nfe_trans] 
 */

CREATE TABLE [dbo].[cpaf_nfe_trans](
  [organization_id]      INT           NOT NULL,
  [rtl_loc_id]           INT           NOT NULL,
  [environment_id]       INT           NOT NULL,
  [tp_nf]                INT           NOT NULL,
  [series_id]            INT           NOT NULL,
  [nnf]                  INT           NOT NULL,
  [model]                VARCHAR(2)    NOT NULL,
  [business_date]        DATETIME      NOT NULL,
  [trans_wkstn_id]       INT           NOT NULL DEFAULT (1),
  [trans_seq]            INT           NOT NULL,
  [create_date]          DATETIME      NULL,
  [create_user_id]       VARCHAR(30)   NULL,
  [update_date]          DATETIME      NULL,
  [update_user_id]       VARCHAR(30)   NULL,
  [record_state]         VARCHAR(30)   NULL,
  CONSTRAINT [pk_cpaf_nfe_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [business_date], [trans_wkstn_id], [trans_seq]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_trans_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_trans_p](
  [organization_id]  INT            NOT NULL,
  [rtl_loc_id]       INT            NOT NULL,
  [environment_id]   INT            NOT NULL,
  [tp_nf]            INT            NOT NULL,
  [series_id]        INT            NOT NULL,
  [nnf]              INT            NOT NULL,
  [model]            VARCHAR(2)     NOT NULL,
  [business_date]    DATETIME       NOT NULL,
  [trans_wkstn_id]   INT            NOT NULL DEFAULT (1),
  [trans_seq]        INT            NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [business_date], [trans_wkstn_id], [trans_seq], [property_code])
  WITH FILLFACTOR = 80
)
go




/* 
 * TABLE: [dbo].[cpaf_nfe_trans_tax] 
 */

CREATE TABLE [dbo].[cpaf_nfe_trans_tax](
  [organization_id]     INT          NOT NULL,
  [trans_typcode]       VARCHAR(30)  NOT NULL,
  [uf]                  VARCHAR(2)   NOT NULL,
  [dest_uf]             VARCHAR(2)   NOT NULL,
  [tax_group_id]        VARCHAR(120) NOT NULL,
  [new_tax_group_id]    VARCHAR(120) NULL,
  [create_date]         DATETIME     NULL,
  [create_user_id]      VARCHAR(30)  NULL,
  [update_date]         DATETIME     NULL,
  [update_user_id]      VARCHAR(30)  NULL,
  [record_state]        VARCHAR(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_tax] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [uf], [dest_uf], [tax_group_id]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_trans_tax_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_trans_tax_p](
  [organization_id]  INT            NOT NULL,
  [trans_typcode]    VARCHAR(30)    NOT NULL,
  [uf]               VARCHAR(2)     NOT NULL,
  [dest_uf]          VARCHAR(2)     NOT NULL,
  [tax_group_id]     VARCHAR(120)   NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_tax_p] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [uf], [dest_uf], [tax_group_id], [property_code])
  WITH FILLFACTOR = 80
)
go




/* 
 * TABLE: [dbo].[cpaf_nfe_trans_type] 
 */

CREATE TABLE [dbo].[cpaf_nfe_trans_type](
  [organization_id]      INT            NOT NULL,
  [trans_typcode]        VARCHAR(30)    NOT NULL,
  [description]          VARCHAR(60)    NULL,
  [notes]                VARCHAR(MAX)   NULL,
  [cfop_same_uf]         VARCHAR(4)     NULL,
  [cfop_other_uf]        VARCHAR(4)     NULL,
  [cfop_foreign]         VARCHAR(4)     NULL,
  [fin_nfe]              INT            NULL  DEFAULT(0),
  [display_order]        INT            NULL,
  [comment_req_flag]     BIT            NULL  DEFAULT(0),
  [rule_type]            VARCHAR(30)    NULL  DEFAULT(0),
  [disallow_cancel_flag] BIT            NULL  DEFAULT(0),
  [pricing_type]         VARCHAR(30)    NULL,
  [initial_comment]      VARCHAR(254)   NULL,
  [create_date]          DATETIME       NULL,
  [create_user_id]       VARCHAR(30)    NULL,
  [update_date]          DATETIME       NULL,
  [update_user_id]       VARCHAR(30)    NULL,
  [record_state]         VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_type] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_trans_type_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_trans_type_p](
  [organization_id]  INT            NOT NULL,
  [trans_typcode]    VARCHAR(30)    NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_type_p] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_trans_type_use] 
 */

CREATE TABLE [dbo].[cpaf_nfe_trans_type_use](
  [organization_id]      INT            NOT NULL,
  [trans_typcode]        VARCHAR(30)    NOT NULL,
  [usage_typcode]        VARCHAR(30)    NOT NULL,
  [uf]                   VARCHAR(2)     NOT NULL,
  [create_date]          DATETIME       NULL,
  [create_user_id]       VARCHAR(30)    NULL,
  [update_date]          DATETIME       NULL,
  [update_user_id]       VARCHAR(30)    NULL,
  [record_state]         VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_type_use] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [usage_typcode], [uf]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_nfe_trans_type_use_p] 
 */

CREATE TABLE [dbo].[cpaf_nfe_trans_type_use_p](
  [organization_id]  INT            NOT NULL,
  [trans_typcode]    VARCHAR(30)    NOT NULL,
  [usage_typcode]    VARCHAR(30)    NOT NULL,
  [uf]               VARCHAR(2)     NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_type_use_p] PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [usage_typcode], [uf], [property_code])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_sat_response] 
 */

CREATE TABLE [dbo].[cpaf_sat_response](
  [organization_id]   INT           NOT NULL,
  [rtl_loc_id]        INT           NOT NULL,
  [wkstn_id]          INT           NOT NULL,
  [queue_seq]         INT           NOT NULL,
  [session_id]        INT           NOT NULL,
  [code_sate]         VARCHAR(32)   NULL,
  [message_sate]      VARCHAR(254)  NULL,
  [code_alert]        VARCHAR(32)   NULL,
  [message_alert]     VARCHAR(254)  NULL,
  [xml_string]        VARCHAR(MAX)  NULL,
  [time_stamp]        DATETIME      NULL,
  [chave]             VARCHAR(254)  NULL,
  [total_amount]      DECIMAL(17,6) NULL,
  [cpf_cnpj_value]    VARCHAR(32)   NULL,
  [signature_QR_code] VARCHAR(MAX)  NULL,
  [success]           BIT           NULL,
  [timeout]           BIT           NULL,
  [create_date]       DATETIME      NULL,
  [create_user_id]    VARCHAR(30)   NULL,
  [update_date]       DATETIME      NULL,
  [update_user_id]    VARCHAR(30)   NULL,
  [record_state]      VARCHAR(30)   NULL,
  CONSTRAINT [pk_cpaf_sat_response] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [session_id]) 
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cpaf_sat_response_p] 
 */

CREATE TABLE [dbo].[cpaf_sat_response_p](
  [organization_id]   INT           NOT NULL,
  [rtl_loc_id]        INT           NOT NULL,
  [wkstn_id]          INT           NOT NULL,
  [queue_seq]         INT           NOT NULL,
  [session_id]        INT           NOT NULL,
  [property_code]    VARCHAR(30)    NOT NULL,
  [type]             VARCHAR(30)    NULL,
  [string_value]     VARCHAR(MAX)   NULL,
  [date_value]       DATETIME       NULL,
  [decimal_value]    DECIMAL(17, 6) NULL,
  [create_date]      DATETIME       NULL,
  [create_user_id]   VARCHAR(30)    NULL,
  [update_date]      DATETIME       NULL,
  [update_user_id]   VARCHAR(30)    NULL,
  [record_state]     VARCHAR(30)    NULL,
  CONSTRAINT [pk_cpaf_sat_response_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [session_id], [property_code])
  WITH FILLFACTOR = 80
)
go




/* 
 * TABLE: [dbo].[crm_customer_affiliation] 
 */

CREATE TABLE [dbo].[crm_customer_affiliation](
    [organization_id]  int            NOT NULL,
    [party_id]         bigint         NOT NULL,
    [cust_group_id]    varchar(60)    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_crm_customer_affiliation] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [cust_group_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[crm_customer_affiliation_p] 
 */

CREATE TABLE [dbo].[crm_customer_affiliation_p](
    [organization_id]  int               NOT NULL,
    [party_id]         bigint            NOT NULL,
    [cust_group_id]    varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crm_customer_affiliation_p] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [cust_group_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crm_customer_notes] 
 */

CREATE TABLE [dbo].[crm_customer_notes](
    [organization_id]  int             NOT NULL,
    [party_id]         bigint          NOT NULL,
    [note_seq]         bigint          NOT NULL,
    [note]             varchar(max)    NULL,
    [creator_id]       varchar(254)    NULL,
    [note_timestamp]   datetime        NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_crm_customer_notes] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [note_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[crm_customer_notes_p] 
 */

CREATE TABLE [dbo].[crm_customer_notes_p](
    [organization_id]  int               NOT NULL,
    [party_id]         bigint            NOT NULL,
    [note_seq]         bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crm_customer_notes_p] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [note_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: crm_gift_registry_journal 
 */

CREATE TABLE crm_gift_registry_journal(
    organization_id        int            NOT NULL,
    journal_seq            bigint         NOT NULL,
    registry_id            bigint         NULL,
    action_code            varchar(30)    NULL,
    registry_status        varchar(30)    NULL,
    trans_rtl_loc_id       int            NULL,
    trans_wkstn_id         bigint         NULL,
    trans_business_date    datetime       NULL,
    trans_trans_seq        bigint         NULL,
    create_date            datetime       NULL,
    create_user_id         varchar(30)    NULL,
    update_date            datetime       NULL,
    update_user_id         varchar(30)    NULL,
    record_state           varchar(30)    NULL,
    CONSTRAINT pk_crm_gift_registry_journal PRIMARY KEY CLUSTERED (organization_id, journal_seq) WITH (FILLFACTOR = 80)
)
go

/* 
 * INDEX: idx_crm_gft_registry_journal01 
 */

CREATE INDEX idx_crm_gft_registry_journal01 ON crm_gift_registry_journal(registry_id) WITH (FILLFACTOR = 80)
go

/* 
 * TABLE: [dbo].[crm_gift_registry_journal_p] 
 */

CREATE TABLE [dbo].[crm_gift_registry_journal_p](
    [organization_id]  int               NOT NULL,
    [journal_seq]      bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crm_gift_registry_journal_p] PRIMARY KEY CLUSTERED ([organization_id], [journal_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crm_party] 
 */

CREATE TABLE [dbo].[crm_party](
    [organization_id]           int             NOT NULL,
    [party_id]                  bigint          NOT NULL,
    [party_typcode]             varchar(30)     NULL,
    [cust_id]                   varchar(60)     NULL,
    [employee_id]               varchar(60)     NULL,
    [salutation]                varchar(30)     NULL,
    [first_name]                varchar(60)     NULL,
    [middle_name]               varchar(60)     NULL,
    [last_name]                 varchar(60)     NULL,
    [first_name2]               varchar(60)     NULL,
    [last_name2]                varchar(60)     NULL,
    [suffix]                    varchar(30)     NULL,
    [gender]                    varchar(30)     NULL,
    [preferred_locale]          varchar(30)     NULL,
    [birth_date]                datetime        NULL,
    [social_security_nbr]       varchar(255)    NULL,
    [national_tax_id]           varchar(30)     NULL,
    [personal_tax_id]           varchar(30)     NULL,
    [prospect_flag]             bit             DEFAULT ((0)) NULL,
    [rent_flag]                 bit             DEFAULT ((0)) NULL,
    [privacy_card_flag]         bit             DEFAULT ((0)) NULL,
    [contact_pref]              varchar(30)     NULL,
    [sign_up_rtl_loc_id]        int             NULL,
    [allegiance_rtl_loc_id]     int             NULL,
    [anniversary_date]          datetime        NULL,
    [organization_typcode]      varchar(30)     NULL,
    [organization_name]         varchar(60)     NULL,
    [commercial_customer_flag]  bit             DEFAULT ((0)) NULL,
    [picture_uri]               varchar(254)    NULL,
    [void_flag]                 bit             DEFAULT ((0)) NULL,
    [active_flag]			  bit	        DEFAULT ((1)) NOT NULL,
    [email_rcpts_flag]		  bit	        DEFAULT ((0)) NOT NULL,
    [create_date]               datetime        NULL,
    [create_user_id]            varchar(30)     NULL,
    [update_date]               datetime        NULL,
    [update_user_id]            varchar(30)     NULL,
    [record_state]              varchar(30)     NULL,
    CONSTRAINT [pk_crm_party] PRIMARY KEY CLUSTERED ([organization_id], [party_id]) WITH (FILLFACTOR = 80)
)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
  GRANT SELECT ON [dbo].[crm_party] TO hhlookupusers
go

/* 
 * INDEX: [xst_crm_party_custid] 
 */

CREATE INDEX [xst_crm_party_custid] ON [dbo].[crm_party]([cust_id], [organization_id]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_crm_party_name_first_last] 
 */

CREATE INDEX [xst_crm_party_name_first_last] ON [dbo].[crm_party]([first_name], [last_name]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_crm_party_name_last] 
 */

CREATE INDEX [xst_crm_party_name_last] ON [dbo].[crm_party]([last_name]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_crm_party_name_last_first] 
 */

CREATE INDEX [xst_crm_party_name_last_first] ON [dbo].[crm_party]([last_name], [first_name]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[crm_party_cross_reference] 
 */

CREATE TABLE [dbo].[crm_party_cross_reference](
    [organization_id]             int            NOT NULL,
    [parent_party_id]             bigint         NOT NULL,
    [child_party_id]              bigint         NOT NULL,
    [party_relationship_typcode]  varchar(30)    NOT NULL,
    [create_date]                 datetime       NULL,
    [create_user_id]              varchar(30)    NULL,
    [update_date]                 datetime       NULL,
    [update_user_id]              varchar(30)    NULL,
    [record_state]                varchar(30)    NULL,
    CONSTRAINT [pk_crm_party_cross_reference] PRIMARY KEY CLUSTERED ([organization_id], [parent_party_id], [child_party_id], [party_relationship_typcode]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX idx_crm_party_xref01 ON dbo.crm_party_cross_reference(child_party_id) WITH (FILLFACTOR = 80);
GO




/* 
 * TABLE: [dbo].[crm_party_cross_reference_p] 
 */

CREATE TABLE [dbo].[crm_party_cross_reference_p](
    [organization_id]             int               NOT NULL,
    [parent_party_id]             bigint            NOT NULL,
    [child_party_id]              bigint            NOT NULL,
    [party_relationship_typcode]  varchar(30)       NOT NULL,
    [property_code]               varchar(30)       NOT NULL,
    [type]                        varchar(30)       NULL,
    [string_value]                varchar(max)      NULL,
    [date_value]                  datetime          NULL,
    [decimal_value]               decimal(17, 6)    NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pk_crm_party_cross_reference_p] PRIMARY KEY CLUSTERED ([organization_id], [parent_party_id], [child_party_id], [party_relationship_typcode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crm_party_email] 
 */

CREATE TABLE [dbo].[crm_party_email](
    [organization_id]  int             NOT NULL,
    [party_id]         bigint          NOT NULL,
    [email_sequence]   int             DEFAULT 1 NOT NULL,
    [email_address]    varchar(254)    NULL,
    [email_type]       varchar(20)     NULL,
    [email_format]     varchar(20)     NULL,
    [contact_flag]     bit             DEFAULT 0 NULL,
    [primary_flag]     bit             DEFAULT 0 NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_crm_party_email] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [email_sequence]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[crm_party_email_p] 
 */

CREATE TABLE [dbo].[crm_party_email_p](
    [organization_id]  int               NOT NULL,
    [party_id]         bigint            NOT NULL,
    [email_sequence]   int               DEFAULT 1 NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crm_party_email_p] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [email_sequence], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crm_party_id_xref] 
 */

CREATE TABLE [dbo].[crm_party_id_xref](
    [organization_id]     numeric(10, 0)    NOT NULL,
    [party_id]            numeric(19, 0)    NOT NULL,
    [alternate_id_owner]  varchar(30)       NOT NULL,
    [alternate_id]        varchar(60)       NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_crm_party_id_xref] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [alternate_id_owner]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_crm_party_id_xref01] 
 */

CREATE INDEX [idx_crm_party_id_xref01] ON [dbo].[crm_party_id_xref]([alternate_id_owner], [alternate_id]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[crm_party_id_xref_p] 
 */

CREATE TABLE [dbo].[crm_party_id_xref_p](
    [organization_id]     numeric(10, 0)    NOT NULL,
    [party_id]            numeric(19, 0)    NOT NULL,
    [alternate_id_owner]  varchar(30)       NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_crm_party_id_xref_p] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [alternate_id_owner], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crm_party_locale_information] 
 */

CREATE TABLE [dbo].[crm_party_locale_information](
    [organization_id]   int             NOT NULL,
    [party_id]          bigint          NOT NULL,
    [party_locale_seq]  int             DEFAULT ((1)) NOT NULL,
    [address1]          varchar(254)    NULL,
    [address2]          varchar(254)    NULL,
    [address3]          varchar(254)    NULL,
    [address4]          varchar(254)    NULL,
    [apartment]         varchar(30)     NULL,
    [city]              varchar(254)    NULL,
    [state]             varchar(30)     NULL,
    [postal_code]       varchar(30)     NULL,
    [country]           varchar(2)	    NULL,
	[neighborhood]		varchar(254)	null,
	[county]			varchar(254)	null,
    [contact_flag]      bit             DEFAULT ((0)) NULL,
    [primary_flag]      bit             DEFAULT ((0)) NULL,
    [address_type]      varchar(20)     NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_crm_party_locale_info] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [party_locale_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_crm_partylocale_city] 
 */

CREATE INDEX [xst_crm_partylocale_city] ON [dbo].[crm_party_locale_information]([city]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_crm_partylocale_postal] 
 */

CREATE INDEX [xst_crm_partylocale_postal] ON [dbo].[crm_party_locale_information]([postal_code]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_crm_partylocale_state] 
 */

CREATE INDEX [xst_crm_partylocale_state] ON [dbo].[crm_party_locale_information]([state]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[crm_party_locale_information_p] 
 */

CREATE TABLE [dbo].[crm_party_locale_information_p](
    [organization_id]   int               NOT NULL,
    [party_id]          bigint            NOT NULL,
    [party_locale_seq]  int               DEFAULT 1 NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pkcrmpartylocaleinformationp] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [party_locale_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crm_party_p] 
 */

CREATE TABLE [dbo].[crm_party_p](
    [organization_id]  int               NOT NULL,
    [party_id]         bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crm_party_properties] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [property_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_crm_partyprops_partyid] 
 */

CREATE INDEX [xst_crm_partyprops_partyid] ON [dbo].[crm_party_p]([organization_id], [party_id]) WITH (FILLFACTOR = 80)
go

/* 
 * TABLE: [dbo].[crm_party_telephone] 
 */

CREATE TABLE [dbo].[crm_party_telephone](
    [organization_id]   int            NOT NULL,
    [party_id]          bigint         NOT NULL,
    [telephone_type]    varchar(20)    NOT NULL,
    [telephone_number]  varchar(32)    NULL,
    [contact_type]      varchar(20)    NULL,
    [contact_flag]      bit            DEFAULT ((0)) NOT NULL,
    [primary_flag]      bit            DEFAULT ((0)) NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [pk_crm_party_telephone] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [telephone_type]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX xst_crm_party_telephone ON crm_party_telephone(telephone_number) WITH (FILLFACTOR = 80);
go
/* 
 * TABLE: [dbo].[crm_party_telephone_p] 
 */

CREATE TABLE [dbo].[crm_party_telephone_p](
    [organization_id]  int               NOT NULL,
    [party_id]         bigint            NOT NULL,
    [telephone_type]   varchar(20)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crm_party_telephone_p] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [telephone_type], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crpt_daily_detail] 
 */

CREATE TABLE [dbo].[crpt_daily_detail](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [business_date]    datetime          NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [ref_wkstn_id]     bigint            NOT NULL,
    [record_type]      varchar(30)       NOT NULL,
    [sequence]         int               NOT NULL,
    [count01]          bigint            NULL,
    [count02]          bigint            NULL,
    [txt01]            varchar(2000)     NULL,
    [txt02]            varchar(2000)     NULL,
    [txt03]            varchar(2000)     NULL,
    [txt04]            varchar(2000)     NULL,
    [txt05]            varchar(2000)	 NULL,    
    [txt06]            varchar(2000)     NULL,
    [num01]            numeric(17, 6)    NULL,
    [num02]            numeric(17, 6)    NULL,
    [num03]            numeric(17, 6)    NULL,
    [num04]            numeric(17, 6)    NULL,
    [num05]            numeric(17, 6)    NULL,
    [num06]            numeric(17, 6)    NULL,
    [num07]            numeric(17, 6)    NULL,
    [num08]            numeric(17, 6)    NULL,
    [num09]            numeric(17, 6)    NULL,
    [num10]            numeric(17, 6)    NULL,
    [num11]            numeric(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crpt_daily_detail] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [ref_wkstn_id], [record_type], [sequence])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crpt_daily_detail_p] 
 */

CREATE TABLE [dbo].[crpt_daily_detail_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [business_date]    datetime          NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [ref_wkstn_id]     bigint            NOT NULL,
    [record_type]      varchar(30)       NOT NULL,
    [sequence]         int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crpt_daily_detail_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [ref_wkstn_id], [record_type], [sequence], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crpt_daily_header] 
 */

CREATE TABLE [dbo].[crpt_daily_header](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [business_date]    datetime          NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [dailyreport_id]   bigint            NOT NULL,
    [report_data]      varbinary(max)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crpt_daily_header] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[crpt_daily_header_p] 
 */

CREATE TABLE [dbo].[crpt_daily_header_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [business_date]    datetime          NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_crpt_daily_header_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_app_version] 
 */

CREATE TABLE [dbo].[ctl_app_version](
    [organization_id]   int             NOT NULL,
    [rtl_loc_id]        int             NOT NULL,
    [seq]               int             NOT NULL,
    [app_id]            varchar(255)    NULL,
    [version_number]    varchar(255)    NULL,
    [version_priority]  varchar(255)    NULL,
    [effective_date]    datetime        NULL,
    [update_url]        varchar(255)    NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_ctl_app_version] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [seq])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_cheetah_device_access] 
 */

CREATE TABLE [dbo].[ctl_cheetah_device_access](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [token]            varchar(256)    NOT NULL,
    [status]           varchar(256)    NOT NULL,
    [CREATE_DATE]      datetime        NULL,
    [CREATE_USER_ID]   varchar(30)     NULL,
    [UPDATE_DATE]      datetime        NULL,
    [UPDATE_USER_ID]   varchar(30)     NULL,
    [RECORD_STATE]     varchar(30)     NULL,
    CONSTRAINT [pk_ctl_cheetah_device_access] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [token])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_dataloader_failure] 
 */

CREATE TABLE [dbo].[ctl_dataloader_failure](
    [organization_id]  int             NOT NULL,
    [file_name]        varchar(254)    NOT NULL,
    [run_timestamp]    bigint          NOT NULL,
    [failure_seq]      int             NOT NULL,
    [failure_message]  varchar(max)    NOT NULL,
    [failed_data]      varchar(max)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_ctl_dataloader_failure] PRIMARY KEY CLUSTERED ([organization_id], [file_name], [run_timestamp], [failure_seq])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_dataloader_summary] 
 */

CREATE TABLE [dbo].[ctl_dataloader_summary](
    [organization_id]  int             NOT NULL,
    [file_name]        varchar(254)    NOT NULL,
    [run_timestamp]    bigint          NOT NULL,
    [success_flag]     bit             DEFAULT 0 NOT NULL,
    [successful_rows]  int             NULL,
    [failed_rows]      int             NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_ctl_dataloader_summary] PRIMARY KEY CLUSTERED ([organization_id], [file_name], [run_timestamp])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_device_information] 
 */

CREATE TABLE [dbo].[ctl_device_information](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [dev_seq]		   int		    NOT NULL,
    [device_name]      varchar(255)    NOT NULL,
    [device_type]      varchar(255)    NOT NULL,
    [model]            varchar(255)    NOT NULL,
    [serial_number]    varchar(255)    NOT NULL,
    [firmware]         varchar(255)    NULL,
    [firmware_date]    datetime        NULL,
    [asset_status]     varchar(255)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_ctl_device_information] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [dev_seq])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_device_registration] 
 */

CREATE TABLE [dbo].[ctl_device_registration](
    [organization_id]  int            NOT NULL,
    [rtl_loc_id]       int            NOT NULL,
    [wkstn_id]         bigint         NOT NULL,
    [ip_address]       varchar(30)    NULL,
    [date_timestamp]   datetime       NULL,
    [business_date]    datetime       NULL,
    [xstore_version]   varchar(40)    NULL,
    [env_version]      varchar(40)    NULL,
    [env_install_date] datetime		  NULL,
    [active_flag]      bit            DEFAULT ((0)) NOT NULL,
    [config_version]   varchar(40)	  NULL,
    [machine_name]	   varchar(255)   NULL,
    [mac_address]	   varchar(20)	  NULL,
	[primary_register_flag] bit		  DEFAULT 0 NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_ctl_device_registration] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ctl_device_registration_p] 
 */

CREATE TABLE [dbo].[ctl_device_registration_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_ctl_device_registration_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_event_log] 
 */

CREATE TABLE [dbo].[ctl_event_log](
    [organization_id]      int             NULL,
    [rtl_loc_id]           int             NULL,
    [wkstn_id]             bigint          NULL,
    [business_date]        datetime        NULL,
    [operator_party_id]    bigint          NULL,
    [log_level]            varchar(20)     NULL,
    [log_timestamp]        datetime        NOT NULL,
    [source]               varchar(254)    NULL,
    [thread_name]          varchar(254)    NULL,
    [critical_to_deliver]  bit             DEFAULT ((0)) NULL,
    [logger_category]      varchar(254)    NULL,
    [log_message]          varchar(max)    NULL,
    [arrival_timestamp]	  datetime	   NULL,
    [create_date]          datetime        NULL,
    [create_user_id]       varchar(30)     NULL,
    [update_date]          datetime        NULL,
    [update_user_id]       varchar(30)     NULL,
    [record_state]         varchar(30)     NULL
)
go



/* 
 * INDEX: [idx_ctl_event_log01] 
 */

CREATE INDEX [idx_ctl_event_log01] ON [dbo].[ctl_event_log]([log_timestamp]) WITH (FILLFACTOR = 80)
go

/*
 * INDEX: [idx_ctl_event_log_create_date]
 */
CREATE INDEX idx_ctl_event_log_create_date ON ctl_event_log (create_date) WITH (FILLFACTOR = 80)
GO

/*
* INDEX: [idx_ctl_event_log02] this addresses the full table scans on the Xcenter db in production
*/
create index idx_ctl_event_log02 on ctl_event_log(arrival_timestamp, organization_id, logger_category, create_date) WITH (FILLFACTOR = 80)
GO
/* 
 * TABLE: [dbo].[ctl_ip_cashdrawer_device] 
 */
CREATE TABLE [dbo].[ctl_ip_cashdrawer_device](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [cash_drawer_id]      varchar(60)     NOT NULL,
    [drawer_status]       varchar(40),
    [product_name]        varchar(80),
    [description]         varchar(80),
    [serial_number]       varchar(40),
    [ip_address]          varchar(16),
    [tcp_port]            int,
    [mac_address]         varchar(20),
    [subnet_mask]         varchar(16),
    [gateway]             varchar(16),
    [dns_hostname]        varchar(16), 
    [dhcp_flag]           bit             DEFAULT ((0)) NULL,
    [firmware_version]    varchar(20),
    [kup]                 varchar(1024), 
    [kup_update_date]     datetime,
    [beep_on_open_flag]   bit             DEFAULT ((0)) NULL,
    [beep_long_open_flag] bit             DEFAULT ((0)) NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_ctl_ip_cashdrawer_device] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [cash_drawer_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_ip_cashdrawer_device_p] 
 */

CREATE TABLE [dbo].[ctl_ip_cashdrawer_device_p](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [cash_drawer_id]      varchar(60)     NOT NULL,

    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_ctl_ip_cashdrawer_device_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [cash_drawer_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ctl_log_trickle] 
 */

CREATE TABLE [dbo].[ctl_log_trickle](
    [organization_id]         int             NOT NULL,
    [rtl_loc_id]              int             NOT NULL,
    [business_date]           datetime        NOT NULL,
    [wkstn_id]                bigint          NOT NULL,
    [log_trickle_id]          varchar(60)     NOT NULL,
    [log_type]                varchar(60)     NULL,
    [log_data]                varchar(max)    NULL,
    [posted_flag]             bit             DEFAULT ((0)) NULL,
    [log_generated_datetime]  datetime        NULL,
    [log_posted_datetime]     datetime        NULL,
    [create_date]             datetime        NULL,
    [create_user_id]          varchar(30)     NULL,
    [update_date]             datetime        NULL,
    [update_user_id]          varchar(30)     NULL,
    [record_state]            varchar(30)     NULL,
    CONSTRAINT [pk_ctl_log_trickle] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [log_trickle_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ctl_version_history] 
 */

CREATE TABLE [dbo].[ctl_version_history](
    [organization_id]          int            NOT NULL,
    [seq]                      bigint         IDENTITY(1,1),
    [base_schema_version]      varchar(30)    NOT NULL,
    [customer_schema_version]  varchar(30)    NOT NULL,
    [customer]                 varchar(30)    NULL,
    [base_schema_date]         datetime       NULL,
    [customer_schema_date]     datetime       NULL,
    [create_date]              datetime       NULL,
    [create_user_id]           varchar(30)    NULL,
    [update_date]              datetime       NULL,
    [update_user_id]           varchar(30)    NULL,
    [record_state]             varchar(30)    NULL,
    CONSTRAINT [pk_ctl_version_history] PRIMARY KEY CLUSTERED ([organization_id], [seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ctl_version_history_p] 
 */

CREATE TABLE [dbo].[ctl_version_history_p](
    [organization_id]  int               NOT NULL,
    [seq]              bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_ctl_version_history_p] PRIMARY KEY CLUSTERED ([organization_id], [seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cwo_category_service_loc] 
 */

CREATE TABLE [dbo].[cwo_category_service_loc](
    [organization_id]       int               NOT NULL,
    [category_id]           varchar(60)       NOT NULL,
    [service_loc_id]        varchar(60)       NOT NULL,
    [org_code]				varchar(30) DEFAULT('*')		  NOT NULL,
    [org_value]				varchar(60) DEFAULT('*')		  NOT NULL,
    [lead_time_qty]         decimal(11, 4)    NULL,
    [lead_time_unit_enum]   varchar(30)       NULL,
    [create_shipment_flag]  bit               DEFAULT ((0)) NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_cwo_category_service_loc] PRIMARY KEY CLUSTERED ([organization_id], [category_id], [service_loc_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_cwo_cat_servce_loc_orgnode ON cwo_category_service_loc (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[cwo_category_service_loc_p] 
 */

CREATE TABLE [dbo].[cwo_category_service_loc_p](
    [organization_id]  int               NOT NULL,
    [category_id]      varchar(60)       NOT NULL,
    [service_loc_id]   varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_category_service_loc_p] PRIMARY KEY CLUSTERED ([organization_id], [category_id], [service_loc_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cwo_invoice] 
 */

CREATE TABLE [dbo].[cwo_invoice](
    [organization_id]  int               NOT NULL,
    [service_loc_id]   varchar(60)       NOT NULL,
    [invoice_number]   varchar(60)       NOT NULL,
    [invoice_date]     datetime          NULL,
    [amount_due]       decimal(17, 6)    NULL,
    [notes]            varchar(254)      NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_invoice] PRIMARY KEY CLUSTERED ([organization_id], [service_loc_id], [invoice_number]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cwo_invoice_lineitm] 
 */

CREATE TABLE [dbo].[cwo_invoice_lineitm](
    [organization_id]      int               NOT NULL,
    [service_loc_id]       varchar(60)       NOT NULL,
    [invoice_number]       varchar(60)       NOT NULL,
    [invoice_lineitm_seq]  int               NOT NULL,
    [lineitm_typcode]      varchar(30)       NULL,
    [amt]                  decimal(17, 6)    NULL,
    [gl_account]           varchar(60)       NULL,
    [cust_acct_id]         varchar(60)       NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_cwo_invoice_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [service_loc_id], [invoice_number], [invoice_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cwo_invoice_lineitm_p] 
 */

CREATE TABLE [dbo].[cwo_invoice_lineitm_p](
    [organization_id]      int               NOT NULL,
    [service_loc_id]       varchar(60)       NOT NULL,
    [invoice_number]       varchar(60)       NOT NULL,
    [invoice_lineitm_seq]  int               NOT NULL,
    [property_code]        varchar(30)       NOT NULL,
    [type]                 varchar(30)       NULL,
    [string_value]         varchar(max)      NULL,
    [date_value]           datetime          NULL,
    [decimal_value]        decimal(17, 6)    NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_cwo_invoice_lineitm_p] PRIMARY KEY CLUSTERED ([organization_id], [service_loc_id], [invoice_number], [invoice_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cwo_invoice_p] 
 */

CREATE TABLE [dbo].[cwo_invoice_p](
    [organization_id]  int               NOT NULL,
    [service_loc_id]   varchar(60)       NOT NULL,
    [invoice_number]   varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_invoice_p] PRIMARY KEY CLUSTERED ([organization_id], [service_loc_id], [invoice_number], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cwo_price_code] 
 */

CREATE TABLE [dbo].[cwo_price_code](
    [organization_id]               int             NOT NULL,
    [price_code]                    varchar(30)     NOT NULL,
    [org_code]                      varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]                     varchar(60) DEFAULT('*')     NOT NULL,
    [description]                   varchar(254)    NULL,
    [sort_order]                    int             NULL,
    [prompt_for_warranty_nbr_flag]  bit             DEFAULT ((0)) NULL,
    [create_date]                   datetime        NULL,
    [create_user_id]                varchar(30)     NULL,
    [update_date]                   datetime        NULL,
    [update_user_id]                varchar(30)     NULL,
    [record_state]                  varchar(30)     NULL,
    CONSTRAINT [pk_cwo_price_code] PRIMARY KEY CLUSTERED ([organization_id], [price_code]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_cwo_price_code_orgnode ON cwo_price_code (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[cwo_price_code_p] 
 */

CREATE TABLE [dbo].[cwo_price_code_p](
    [organization_id]  int               NOT NULL,
    [price_code]       varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_price_code_p] PRIMARY KEY CLUSTERED ([organization_id], [price_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cwo_service_loc] 
 */

CREATE TABLE [dbo].[cwo_service_loc](
    [organization_id]  int             NOT NULL,
    [service_loc_id]   varchar(60)     NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [description]      varchar(254)    NULL,
    [party_id]         bigint          NULL,
    [address_id]       varchar(60)     NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_cwo_service_loc] PRIMARY KEY CLUSTERED ([organization_id], [service_loc_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_cwo_service_loc_orgnode ON cwo_service_loc (org_code,org_value) WITH (FILLFACTOR = 80)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[cwo_service_loc] TO hhlookupusers
go

/* 
 * TABLE: [dbo].[cwo_service_loc_p] 
 */

CREATE TABLE [dbo].[cwo_service_loc_p](
    [organization_id]  int               NOT NULL,
    [service_loc_id]   varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_service_loc_p] PRIMARY KEY CLUSTERED ([organization_id], [service_loc_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cwo_task] 
 */

CREATE TABLE [dbo].[cwo_task](
    [organization_id]  int            NOT NULL,
    [item_id]          varchar(60)    NOT NULL,
    [category_id]      varchar(60)    NULL,
    [price_type_enum]  varchar(30)    NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_cwo_task] PRIMARY KEY CLUSTERED ([organization_id], [item_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cwo_work_item] 
 */

CREATE TABLE [dbo].[cwo_work_item](
    [organization_id]       int               NOT NULL,
    [cust_acct_code]        varchar(30)       NOT NULL,
    [cust_acct_id]          varchar(60)       NOT NULL,
    [work_item_seq]         int               NOT NULL,
    [item_id]               varchar(60)       NULL,
    [description]           varchar(254)      NULL,
    [value_amt]             decimal(17, 6)    NULL,
    [warranty_number]       varchar(254)      NULL,
    [work_item_serial_nbr]  varchar(254)      NULL,
    [void_flag]             bit               DEFAULT ((0)) NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_cwo_work_item] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [work_item_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cwo_work_item_p] 
 */

CREATE TABLE [dbo].[cwo_work_item_p](
    [organization_id]  int               NOT NULL,
    [cust_acct_code]   varchar(30)       NOT NULL,
    [cust_acct_id]     varchar(60)       NOT NULL,
    [work_item_seq]    int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_work_item_p] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [work_item_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cwo_work_order_acct] 
 */

CREATE TABLE [dbo].[cwo_work_order_acct](
    [organization_id]            int               NOT NULL,
    [cust_acct_code]             varchar(30)       NOT NULL,
    [cust_acct_id]               varchar(60)       NOT NULL,
    [service_loc_id]             varchar(60)       NOT NULL,
    [category_id]                varchar(60)       NOT NULL,
    [total_value]                decimal(17, 6)    NULL,
    [estimated_completion_date]  datetime          NULL,
    [approved_work_amt]          decimal(17, 6)    NULL,
    [approved_work_date]         datetime          NULL,
    [priority_code]              varchar(30)       NULL,
    [price_code]                 varchar(30)       NULL,
    [contact_method_code]        varchar(30)       NULL,
    [last_cust_notice]           datetime          NULL,
    [cost]                       decimal(17, 6)    NULL,
    [invoice_number]             varchar(60)       NULL,
    [create_date]                datetime          NULL,
    [create_user_id]             varchar(30)       NULL,
    [update_date]                datetime          NULL,
    [update_user_id]             varchar(30)       NULL,
    [record_state]               varchar(30)       NULL,
    CONSTRAINT [pk_cwo_work_order_acct] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [service_loc_id], [category_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cwo_work_order_acct_journal] 
 */

CREATE TABLE [dbo].[cwo_work_order_acct_journal](
    [organization_id]            int               NOT NULL,
    [cust_acct_code]             varchar(30)       NOT NULL,
    [cust_acct_id]               varchar(60)       NOT NULL,
    [journal_seq]                bigint            NOT NULL,
    [total_value]                decimal(17, 6)    NULL,
    [estimated_completion_date]  datetime          NULL,
    [approved_work_amt]          decimal(17, 6)    NULL,
    [approved_work_date]         datetime          NULL,
    [priority_code]              varchar(30)       NULL,
    [price_code]                 varchar(30)       NULL,
    [category_id]                varchar(60)       NULL,
    [contact_method]             varchar(30)       NULL,
    [last_cust_notice]           datetime          NULL,
    [service_loc_id]             varchar(60)       NULL,
    [create_date]                datetime          NULL,
    [create_user_id]             varchar(30)       NULL,
    [update_date]                datetime          NULL,
    [update_user_id]             varchar(30)       NULL,
    [record_state]               varchar(30)       NULL,
    CONSTRAINT [pk_cwo_work_order_acct_jrnl] PRIMARY KEY CLUSTERED ([organization_id], [cust_acct_code], [cust_acct_id], [journal_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cwo_work_order_category] 
 */

CREATE TABLE [dbo].[cwo_work_order_category](
    [organization_id]             int               NOT NULL,
    [category_id]                 varchar(60)       NOT NULL,
    [org_code]                    varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]                   varchar(60) DEFAULT('*')     NOT NULL,
    [sort_order]                  int               NULL,
    [description]                 varchar(254)      NULL,
    [prompt_for_price_code_flag]  bit               DEFAULT ((0)) NULL,
    [max_item_count]              decimal(11, 4)    NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pk_cwo_work_order_category] PRIMARY KEY CLUSTERED ([organization_id], [category_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_cwo_work_order_cat_orgnode ON cwo_work_order_category (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[cwo_work_order_category_p] 
 */

CREATE TABLE [dbo].[cwo_work_order_category_p](
    [organization_id]  int               NOT NULL,
    [category_id]      varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_work_order_category_p] PRIMARY KEY CLUSTERED ([organization_id], [category_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[cwo_work_order_line_item] 
 */

CREATE TABLE [dbo].[cwo_work_order_line_item](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [business_date]       datetime        NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [price_status_enum]   varchar(30)     NULL,
    [instructions]        varchar(254)    NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_cwo_work_order_line_item] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[cwo_work_order_pricing] 
 */

CREATE TABLE [dbo].[cwo_work_order_pricing](
    [organization_id]  int               NOT NULL,
    [price_code]       varchar(30)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [price]            decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_work_order_pricing] PRIMARY KEY CLUSTERED ([organization_id], [price_code], [item_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_cwoworkorderpricingorgnode ON cwo_work_order_pricing (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[cwo_work_order_pricing_p] 
 */

CREATE TABLE [dbo].[cwo_work_order_pricing_p](
    [organization_id]  int               NOT NULL,
    [price_code]       varchar(30)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_cwo_work_order_pricing_p] PRIMARY KEY CLUSTERED ([organization_id], [price_code], [item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[doc_document] 
 */

CREATE TABLE [dbo].[doc_document](
    [organization_id]  int               NOT NULL,
    [document_type]    varchar(30)       NOT NULL,
    [series_id]        varchar(60)       NOT NULL,
    [document_id]      varchar(60)       NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [document_status]  varchar(30)       NULL,
    [issue_date]       datetime          NULL,
    [effective_date]   datetime          NULL,
    [expiration_date]  datetime          NULL,
    [amount]           decimal(17, 6)    NULL,
    [percentage]       decimal(17, 6)    NULL,
    [max_amount]       decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_doc_document] PRIMARY KEY CLUSTERED ([organization_id], [document_type], [series_id], [document_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_doc_document_orgnode ON doc_document (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[doc_document_def_properties] 
 */

CREATE TABLE [dbo].[doc_document_def_properties](
    [organization_id]  int               NOT NULL,
    [document_type]    varchar(30)       NOT NULL,
    [series_id]        varchar(60)       NOT NULL,
    [doc_seq_nbr]      int               NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [property_code]    varchar(30)       NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(254)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_doc_document_def_prpts] PRIMARY KEY CLUSTERED ([organization_id], [document_type], [series_id], [doc_seq_nbr]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_docdocumentdefproporgnode ON doc_document_def_properties (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[doc_document_def_properties_p] 
 */

CREATE TABLE [dbo].[doc_document_def_properties_p](
    [organization_id]  int               NOT NULL,
    [document_type]    varchar(30)       NOT NULL,
    [series_id]        varchar(60)       NOT NULL,
    [doc_seq_nbr]      int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pkdocdocumentdefpropertiesp] PRIMARY KEY CLUSTERED ([organization_id], [document_type], [series_id], [doc_seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[doc_document_definition] 
 */

CREATE TABLE [dbo].[doc_document_definition](
    [organization_id]    int             NOT NULL,
    [series_id]          varchar(60)     NOT NULL,
    [document_type]      varchar(30)     NOT NULL,
    [org_code]           varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]          varchar(60) DEFAULT('*')     NOT NULL,
    [start_issue_date]   datetime        NULL,
    [end_issue_date]     datetime        NULL,
    [start_redeem_date]  datetime        NULL,
    [end_redeem_date]    datetime        NULL,
    [receipt_type]       varchar(30)     NULL,
    [segment_type]       varchar(30)     NULL,
    [text_code_value]    varchar(30)     NULL,
    [file_name]          varchar(254)    NULL,
    [vendor_id]          varchar(60)     NULL,
    [description]        varchar(254)    NULL,
    [create_date]        datetime        NULL,
    [create_user_id]     varchar(30)     NULL,
    [update_date]        datetime        NULL,
    [update_user_id]     varchar(30)     NULL,
    [record_state]       varchar(30)     NULL,
    CONSTRAINT [pk_doc_document_definition] PRIMARY KEY CLUSTERED ([organization_id], [series_id], [document_type]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_doc_document_def_orgnode ON doc_document_definition (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[doc_document_definition_p] 
 */

CREATE TABLE [dbo].[doc_document_definition_p](
    [organization_id]  int               NOT NULL,
    [series_id]        varchar(60)       NOT NULL,
    [document_type]    varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_doc_document_definition_p] PRIMARY KEY CLUSTERED ([organization_id], [series_id], [document_type], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[doc_document_lineitm] 
 */

CREATE TABLE [dbo].[doc_document_lineitm](
    [organization_id]     int            NOT NULL,
    [rtl_loc_id]          int            NOT NULL,
    [wkstn_id]            bigint         NOT NULL,
    [business_date]       datetime       NOT NULL,
    [trans_seq]           bigint         NOT NULL,
    [rtrans_lineitm_seq]  int            NOT NULL,
    [document_id]         varchar(60)    NULL,
    [document_type]       varchar(30)    NULL,
    [series_id]           varchar(60)    NULL,
    [activity_code]       varchar(30)    NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_doc_document_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[doc_document_p] 
 */

CREATE TABLE [dbo].[doc_document_p](
    [organization_id]  int               NOT NULL,
    [document_type]    varchar(30)       NOT NULL,
    [series_id]		   varchar(60)       NOT NULL,
    [document_id]      varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_doc_document_p] PRIMARY KEY CLUSTERED ([organization_id], [document_type], [series_id], [document_id], [property_code]) WITH (FILLFACTOR = 80)
)




/* 
 * TABLE: [dbo].[dsc_coupon_xref] 
 */

CREATE TABLE [dbo].[dsc_coupon_xref](
    [organization_id]    int             NOT NULL,
    [coupon_serial_nbr]  varchar(254)    NOT NULL,
    [org_code]			 varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]          varchar(60) DEFAULT('*')     NOT NULL,
    [discount_code]      varchar(60)     NULL,
    [tndr_id]            varchar(60)     NULL,
    [coupon_type]        varchar(60)     NULL,
    [serialized_flag]    bit             DEFAULT ((0)) NULL,
    [effective_date]     datetime        NULL,
    [expiration_date]    datetime        NULL,
    [create_date]        datetime        NULL,
    [create_user_id]     varchar(30)     NULL,
    [update_date]        datetime        NULL,
    [update_user_id]     varchar(30)     NULL,
    [record_state]       varchar(30)     NULL,
    CONSTRAINT [pk_dsc_coupon_xref] PRIMARY KEY CLUSTERED ([organization_id], [coupon_serial_nbr]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_dsc_coupon_xref_orgnode ON dsc_coupon_xref (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[dsc_coupon_xref_p] 
 */

CREATE TABLE [dbo].[dsc_coupon_xref_p](
    [organization_id]    int               NOT NULL,
    [coupon_serial_nbr]  varchar(254)      NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_dsc_coupon_xref_p] PRIMARY KEY CLUSTERED ([organization_id], [coupon_serial_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[dsc_disc_type_eligibility] 
 */

CREATE TABLE [dbo].[dsc_disc_type_eligibility](
    [organization_id]       int            NOT NULL,
    [discount_code]         varchar(60)    NOT NULL,
    [sale_lineitm_typcode]  varchar(30)    NOT NULL,
	[config_element]	    varchar(200)   DEFAULT '*' NOT NULL,
    [create_date]           datetime       NULL,
    [create_user_id]        varchar(30)    NULL,
    [update_date]           datetime       NULL,
    [update_user_id]        varchar(30)    NULL,
    [record_state]          varchar(30)    NULL,
    CONSTRAINT [pk_dsc_discount_type_elgblty] PRIMARY KEY CLUSTERED ([organization_id], [discount_code], [sale_lineitm_typcode]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[dsc_disc_type_eligibility_p] 
 */

CREATE TABLE [dbo].[dsc_disc_type_eligibility_p](
    [organization_id]       int               NOT NULL,
    [discount_code]         varchar(60)       NOT NULL,
    [sale_lineitm_typcode]  varchar(30)       NOT NULL,
    [property_code]         varchar(30)       NOT NULL,
    [type]                  varchar(30)       NULL,
    [string_value]          varchar(max)      NULL,
    [date_value]            datetime          NULL,
    [decimal_value]         decimal(17, 6)    NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_dsc_disc_type_eligibility_p] PRIMARY KEY CLUSTERED ([organization_id], [discount_code], [sale_lineitm_typcode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[dsc_discount] 
 */

CREATE TABLE [dbo].[dsc_discount](
    [organization_id]           int               NOT NULL,
    [discount_code]             varchar(60)       NOT NULL,
    [effective_datetime]        datetime          NOT NULL,
    [expr_datetime]             datetime          NULL,
    [typcode]                   varchar(30)       NULL,
    [app_mthd_code]             varchar(30)       NOT NULL,
    [percentage]                decimal(6, 4)     NULL,
    [description]               varchar(254)      NULL,
    [calculation_mthd_code]     varchar(30)       NOT NULL,
    [prompt]                    varchar(254)      NULL,
    [sound]                     varchar(254)      NULL,
    [max_trans_count]           int               NULL,
    [exclusive_discount_flag]   bit               DEFAULT ((0)) NULL,
    [privilege_type]            varchar(60)       NULL,
    [discount]                  decimal(17, 6)    NULL,
    [dtv_class_name]            varchar(254)      NULL,
    [min_eligible_price]        decimal(17, 6)    NULL,
    [serialized_discount_flag]  bit               DEFAULT ((0)) NULL,
    [taxability_code]           varchar(30)       NULL,
    [max_discount]              decimal(17, 6)    NULL,
    [sort_order]                int               NULL,
    [disallow_change_flag]      bit               DEFAULT ((0)) NULL,
	[max_amount]				decimal(17, 6)	  NULL,
	[max_percentage]			decimal(17, 6)	  NULL,
	[config_element]		    varchar(200)	  DEFAULT '*' NOT NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_dsc_discount] PRIMARY KEY CLUSTERED ([organization_id], [discount_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[dsc_discount_compatibility] 
 */

CREATE TABLE [dbo].[dsc_discount_compatibility](
    [organization_id]           int            NOT NULL,
    [primary_discount_code]     varchar(60)    NOT NULL,
    [compatible_discount_code]  varchar(60)    NOT NULL,
    [create_date]               datetime       NULL,
    [create_user_id]            varchar(30)    NULL,
    [update_date]               datetime       NULL,
    [update_user_id]            varchar(30)    NULL,
    [record_state]              varchar(30)    NULL,
    CONSTRAINT [pk_dsc_discount_compatibility] PRIMARY KEY CLUSTERED ([organization_id], [primary_discount_code], [compatible_discount_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[dsc_discount_compatibility_p] 
 */

CREATE TABLE [dbo].[dsc_discount_compatibility_p](
    [organization_id]           int               NOT NULL,
    [primary_discount_code]     varchar(60)       NOT NULL,
    [compatible_discount_code]  varchar(60)       NOT NULL,
    [property_code]             varchar(30)       NOT NULL,
    [type]                      varchar(30)       NULL,
    [string_value]              varchar(max)      NULL,
    [date_value]                datetime          NULL,
    [decimal_value]             decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pkdscdiscountcompatibilityp] PRIMARY KEY CLUSTERED ([organization_id], [primary_discount_code], [compatible_discount_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[dsc_discount_group_mapping] 
 */

CREATE TABLE [dbo].[dsc_discount_group_mapping](
    [organization_id]  int            NOT NULL,
    [cust_group_id]    varchar(60)    NOT NULL,
    [discount_code]    varchar(60)    NOT NULL,
	[config_element]   varchar(200)	  DEFAULT '*' NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_dsc_discount_group_mapping] PRIMARY KEY CLUSTERED ([organization_id], [cust_group_id], [discount_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[dsc_discount_group_mapping_p] 
 */

CREATE TABLE [dbo].[dsc_discount_group_mapping_p](
    [organization_id]  int               NOT NULL,
    [cust_group_id]    varchar(60)       NOT NULL,
    [discount_code]    varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pkdscdiscountgroupmappingp] PRIMARY KEY CLUSTERED ([organization_id], [cust_group_id], [discount_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[dsc_discount_item_exclusions] 
 */

CREATE TABLE [dbo].[dsc_discount_item_exclusions](
    [organization_id]  int            NOT NULL,
    [discount_code]    varchar(60)    NOT NULL,
    [item_id]          varchar(60)    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_dsc_discount_item_excls] PRIMARY KEY CLUSTERED ([organization_id], [discount_code], [item_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[dsc_discount_item_exclusions_p] 
 */

CREATE TABLE [dbo].[dsc_discount_item_exclusions_p](
    [organization_id]  int               NOT NULL,
    [discount_code]    varchar(60)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pkdscdiscountitemexclusionsp] PRIMARY KEY CLUSTERED ([organization_id], [discount_code], [item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[dsc_discount_item_inclusions] 
 */

CREATE TABLE [dbo].[dsc_discount_item_inclusions](
    [organization_id]  int            NOT NULL,
    [discount_code]    varchar(60)    NOT NULL,
    [item_id]          varchar(60)    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_dsc_discount_item_incls] PRIMARY KEY CLUSTERED ([organization_id], [discount_code], [item_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[dsc_discount_item_inclusions_p] 
 */

CREATE TABLE [dbo].[dsc_discount_item_inclusions_p](
    [organization_id]  int               NOT NULL,
    [discount_code]    varchar(60)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pkdscdiscountiteminclusionsp] PRIMARY KEY CLUSTERED ([organization_id], [discount_code], [item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[dsc_discount_p] 
 */

CREATE TABLE [dbo].[dsc_discount_p](
    [organization_id]  int               NOT NULL,
    [discount_code]    varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_dsc_discount_p] PRIMARY KEY CLUSTERED ([organization_id], [discount_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee] 
 */

CREATE TABLE [dbo].[hrs_employee](
    [organization_id]          int               NOT NULL,
    [employee_id]              varchar(60)       NOT NULL,
    [party_id]                 bigint            NULL,
    [login_id]                 varchar(60)       NULL,
    [sick_days_used]           decimal(11, 2)    NULL,
    [hire_date]                datetime          NULL,
    [active_date]              datetime          NULL,
    [terminated_date]          datetime          NULL,
    [job_title]                varchar(254)      NULL,
    [base_pay]                 decimal(17, 6)    NULL,
    [add_date]                 datetime          NULL,
    [marital_status]           varchar(30)       NULL,
    [spouse_name]              varchar(254)      NULL,
    [emergency_contact_name]   varchar(254)      NULL,
    [emergency_contact_phone]  varchar(32)       NULL,
    [last_review_date]         datetime          NULL,
    [next_review_date]         datetime          NULL,
    [additional_withholdings]  decimal(17, 6)    NULL,
    [vacation_days]            decimal(11, 2)    NULL,
    [vacation_days_used]       decimal(11, 2)    NULL,
    [sick_days]                decimal(11, 2)    NULL,
    [personal_days]            decimal(11, 2)    NULL,
    [personal_days_used]       decimal(11, 2)    NULL,
    [clock_in_not_req_flag]    bit               DEFAULT ((0)) NULL,
    [employee_pay_status]      varchar(30)       NULL,
    [employee_role_code]       varchar(30)       NULL,
    [employee_statcode]        varchar(30)       NULL,
    [clocked_in_flag]          bit               DEFAULT ((0)) NULL,
    [work_code]                varchar(30)       NULL,
    [group_membership]         varchar(max)      NULL,
    [primary_group]            varchar(60)       NULL,
    [department_id]            varchar(60)       NULL,
    [employee_typcode]         varchar(30)       NULL,
    [training_status_enum]     varchar(30)       NULL,
    [locked_out_flag]          bit               DEFAULT ((0)) NULL,
    [locked_out_timestamp]     datetime          NULL,
    [overtime_eligible_flag]   bit               DEFAULT ((0)) NULL,
    [employee_group_id]        varchar(60)       NULL,
    [employee_work_status]     varchar(30)       NULL,
    [keyed_offline_flag]       bit               DEFAULT ((0)) NULL,
    [create_date]              datetime          NULL,
    [create_user_id]           varchar(30)       NULL,
    [update_date]              datetime          NULL,
    [update_user_id]           varchar(30)       NULL,
    [record_state]             varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee] PRIMARY KEY CLUSTERED ([organization_id], [employee_id]) WITH (FILLFACTOR = 80)
)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[hrs_employee] TO hhlookupusers
go

/* 
 * INDEX: [xst_hrs_employee_partyid] 
 */

CREATE INDEX [xst_hrs_employee_partyid] ON [dbo].[hrs_employee]([party_id], [organization_id]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [hrs_employee_answers] 
 */

CREATE TABLE [hrs_employee_answers](
    [organization_id]   int             NOT NULL,
    [employee_id]       varchar(60)     NOT NULL,
    [challenge_code]    varchar(60)     NOT NULL,
    [challenge_answer]  varchar(max)    NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_hrs_employee_answers] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [challenge_code])
    WITH FILLFACTOR = 80
)
go


/* 
 * TABLE: [dbo].[hrs_employee_answers_p] 
 */

CREATE TABLE [dbo].[hrs_employee_answers_p](
    [organization_id]  int               NOT NULL,
    [employee_id]      varchar(60)       NOT NULL,
    [challenge_code]   varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_answers_p] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [challenge_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_fingerprint] 
 */

CREATE TABLE [dbo].[hrs_employee_fingerprint](
    [organization_id]      int             NOT NULL,
    [employee_id]          varchar(60)     NOT NULL,
    [fingerprint_seq]      int             NOT NULL,
    [fingerprint_storage]  varchar(max)    NULL,
    [create_date]          datetime        NULL,
    [create_user_id]       varchar(30)     NULL,
    [update_date]          datetime        NULL,
    [update_user_id]       varchar(30)     NULL,
    [record_state]         varchar(30)     NULL,
    CONSTRAINT [pk_hrs_employee_fingerprint] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [fingerprint_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[hrs_employee_fingerprint_p] 
 */

CREATE TABLE [dbo].[hrs_employee_fingerprint_p](
    [organization_id]  int               NOT NULL,
    [employee_id]      varchar(60)       NOT NULL,
    [fingerprint_seq]  int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_fingerprint_p] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [fingerprint_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_message] 
 */

CREATE TABLE [dbo].[hrs_employee_message](
    [organization_id]      int             NOT NULL,
    [message_id]           bigint          NOT NULL,
    [org_code]             varchar(30)     DEFAULT('*')     NOT NULL,
    [org_value]            varchar(60)     DEFAULT('*')     NOT NULL,
    [start_date]           datetime        NULL,
    [end_date]             datetime        NULL,
    [priority]             varchar(20)     NULL,
    [content]              varchar(max)    NULL,
    [store_created_flag]   bit             DEFAULT ((0)) NULL,
    [wkstn_specific_flag]  bit             DEFAULT ((0)) NULL,
    [wkstn_id]             bigint          NULL,
    [void_flag]            bit             DEFAULT ((0)) NULL,
    [message_url]		  varchar(254)	   NULL,
    [create_date]          datetime        NULL,
    [create_user_id]       varchar(30)     NULL,
    [update_date]          datetime        NULL,
    [update_user_id]       varchar(30)     NULL,
    [record_state]         varchar(30)     NULL,
    CONSTRAINT [pk_hrs_employee_message] PRIMARY KEY CLUSTERED ([organization_id], [message_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_hrs_employee_msg_orgnode ON hrs_employee_message (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[hrs_employee_message_p] 
 */

CREATE TABLE [dbo].[hrs_employee_message_p](
    [organization_id]  int               NOT NULL,
    [message_id]       bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_message_p] PRIMARY KEY CLUSTERED ([organization_id], [message_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_notes] 
 */

CREATE TABLE [dbo].[hrs_employee_notes](
    [organization_id]   int             NOT NULL,
    [employee_id]       varchar(60)     NOT NULL,
    [note_seq]          bigint          NOT NULL,
    [note]              varchar(max)    NULL,
    [creator_party_id]  bigint          NULL,
    [note_timestamp]    datetime        NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_hrs_employee_notes] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [note_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[hrs_employee_notes_p] 
 */

CREATE TABLE [dbo].[hrs_employee_notes_p](
    [organization_id]  int               NOT NULL,
    [employee_id]      varchar(60)       NOT NULL,
    [note_seq]         bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_notes_p] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [note_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_p] 
 */

CREATE TABLE [dbo].[hrs_employee_p](
    [organization_id]  int               NOT NULL,
    [employee_id]      varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_p] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_password] 
 */

CREATE TABLE [dbo].[hrs_employee_password](
    [organization_id]        int             NOT NULL,
    [employee_id]            varchar(60)     NOT NULL,
    [password_seq]           bigint          DEFAULT ((0)) NOT NULL,
    [password]               varchar(254)    NULL,
    [effective_date]         datetime        DEFAULT (getdate()) NOT NULL,
    [temp_password_flag]     bit             DEFAULT ((0)) NOT NULL,
    [current_password_flag]  bit             DEFAULT ((1)) NOT NULL,
    [create_date]            datetime        NULL,
    [create_user_id]         varchar(30)     NULL,
    [update_date]            datetime        NULL,
    [update_user_id]         varchar(30)     NULL,
    [record_state]           varchar(30)     NULL,
    CONSTRAINT [pk_hrs_employee_password] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [password_seq]) WITH (FILLFACTOR = 80)
)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[hrs_employee_password] TO hhlookupusers
go

/* 
 * TABLE: [dbo].[hrs_employee_password_p] 
 */

CREATE TABLE [dbo].[hrs_employee_password_p](
    [organization_id]  int               NOT NULL,
    [employee_id]      varchar(60)       NOT NULL,
    [password_seq]     bigint            DEFAULT 0 NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_password_p] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [password_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_store] 
 */

CREATE TABLE [dbo].[hrs_employee_store](
    [organization_id]       int            NOT NULL,
    [rtl_loc_id]            int            NOT NULL,
    [employee_id]           varchar(60)    NOT NULL,
    [employee_store_seq]    int            NOT NULL,
    [begin_date]            datetime       NULL,
    [end_date]              datetime       NULL,
    [temp_assignment_flag]  bit            DEFAULT ((0)) NULL,
    [create_date]           datetime       NULL,
    [create_user_id]        varchar(30)    NULL,
    [update_date]           datetime       NULL,
    [update_user_id]        varchar(30)    NULL,
    [record_state]          varchar(30)    NULL,
    CONSTRAINT [pk_hrs_employee_store] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [employee_id], [employee_store_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[hrs_employee_store_p] 
 */

CREATE TABLE [dbo].[hrs_employee_store_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [employee_id]         varchar(60)       NOT NULL,
    [employee_store_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_store_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [employee_id], [employee_store_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_task] 
 */

CREATE TABLE [dbo].[hrs_employee_task](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [task_id]             bigint          NOT NULL,
    [start_date]          datetime        NULL,
    [end_date]            datetime        NULL,
    [complete_date]       datetime        NULL,
    [typcode]             varchar(60)     NULL,
    [visibility]          varchar(30)     NULL,
    [assignment_id]       varchar(60)     NULL,
    [store_created_flag]  bit             DEFAULT ((0)) NULL,
    [title]               varchar(255)    NULL,
    [description]         varchar(max)    NULL,
    [priority]            varchar(20)     NULL,
    [status_code]         varchar(30)     NULL,
    [void_flag]           bit             DEFAULT ((0)) NULL,
	[party_id]			  bigint		  NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_hrs_employee_task] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [task_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[hrs_employee_task_notes] 
 */

CREATE TABLE [dbo].[hrs_employee_task_notes](
    [organization_id]   int             NOT NULL,
    [rtl_loc_id]        int             NOT NULL,
    [task_id]           bigint          NOT NULL,
    [note_seq]          bigint          NOT NULL,
    [note]              varchar(max)    NULL,
    [creator_party_id]  bigint          NULL,
    [note_timestamp]    datetime        NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_hrs_employee_task_notes] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [task_id], [note_seq])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_task_notes_p] 
 */

CREATE TABLE [dbo].[hrs_employee_task_notes_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [task_id]          bigint            NOT NULL,
    [note_seq]         bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_task_notes_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [task_id], [note_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_employee_task_p] 
 */

CREATE TABLE [dbo].[hrs_employee_task_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [task_id]          bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_employee_task_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [task_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[hrs_work_codes] 
 */

CREATE TABLE [dbo].[hrs_work_codes](
    [organization_id]         int             NOT NULL,
    [work_code]               varchar(30)     NOT NULL,
    [org_code]				  varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]				  varchar(60) DEFAULT('*')     NOT NULL,
    [description]             varchar(254)    NULL,
    [sort_order]              int             NULL,
    [privilege]               varchar(60)     NULL,
    [selling_flag]            bit             DEFAULT ((0)) NULL,
    [payroll_category]        varchar(30)     NULL,
    [min_clock_in_duration]   int             NULL,
    [min_clock_out_duration]  int             NULL,
    [hidden_flag]             bit             DEFAULT 0 NULL,
    [create_date]             datetime        NULL,
    [create_user_id]          varchar(30)     NULL,
    [update_date]             datetime        NULL,
    [update_user_id]          varchar(30)     NULL,
    [record_state]            varchar(30)     NULL,
    CONSTRAINT [pk_hrs_work_codes] PRIMARY KEY CLUSTERED ([organization_id], [work_code]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_hrs_work_codes_orgnode ON hrs_work_codes (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[hrs_work_codes_p] 
 */

CREATE TABLE [dbo].[hrs_work_codes_p](
    [organization_id]  int               NOT NULL,
    [work_code]        varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_hrs_work_codes_p] PRIMARY KEY CLUSTERED ([organization_id], [work_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_bucket] 
 */

CREATE TABLE [dbo].[inv_bucket](
    [organization_id]      int             NOT NULL,
    [rtl_loc_id]           int             NOT NULL,
    [bucket_id]            varchar(60)     NOT NULL,
    [name]                 varchar(254)    NULL,
    [function_code]        varchar(30)     NULL,
    [adjustment_action]    varchar(30)     NULL,
    [default_location_id]  varchar(60)     NULL,
    [system_bucket_flag]   bit             DEFAULT ((0)) NULL,
    [create_date]          datetime        NULL,
    [create_user_id]       varchar(30)     NULL,
    [update_date]          datetime        NULL,
    [update_user_id]       varchar(30)     NULL,
    [record_state]         varchar(30)     NULL,
    CONSTRAINT [pk_inv_bucket] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [bucket_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_bucket_p] 
 */

CREATE TABLE [dbo].[inv_bucket_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [bucket_id]        varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_bucket_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [bucket_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_carton] 
 */

CREATE TABLE [dbo].[inv_carton](
    [organization_id]       int             NOT NULL,
    [rtl_loc_id]            int             NOT NULL,
    [document_typcode]      varchar(30)     NOT NULL,
    [invctl_document_id]    varchar(60)     NOT NULL,
    [carton_id]             varchar(60)     NOT NULL,
    [carton_statcode]       varchar(30)     NULL,
    [record_creation_type]  varchar(30)     NULL,
    [control_number]        varchar(254)    NULL,
    [create_date]           datetime        NULL,
    [create_user_id]        varchar(30)     NULL,
    [update_date]           datetime        NULL,
    [update_user_id]        varchar(30)     NULL,
    [record_state]          varchar(30)     NULL,
    CONSTRAINT [pk_inv_carton] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [carton_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_carton_p] 
 */

CREATE TABLE [dbo].[inv_carton_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [document_typcode]    varchar(30)       NOT NULL,
    [invctl_document_id]  varchar(60)       NOT NULL,
    [carton_id]           varchar(60)       NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_carton_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [carton_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_count] 
 */

CREATE TABLE [dbo].[inv_count](
    [organization_id]     int            NOT NULL,
    [rtl_loc_id]          int            NOT NULL,
    [inv_count_id]        varchar(60)    NOT NULL,
    [inv_count_typcode]   varchar(60)    NOT NULL,
    [begin_date]          datetime       NULL,
    [end_date]            datetime       NULL,
    [count_status]        varchar(60)    NULL,
    [store_created_flag]  bit            DEFAULT ((0)) NOT NULL,
    [void_flag]           bit            DEFAULT ((0)) NOT NULL,
	[description]		  varchar(254)	 NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_inv_count] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_count_bucket] 
 */

CREATE TABLE [dbo].[inv_count_bucket](
    [organization_id]  int            NOT NULL,
    [rtl_loc_id]       int            NOT NULL,
    [inv_count_id]     varchar(60)    NOT NULL,
    [inv_bucket_id]    varchar(60)    NOT NULL,
    [count_cycle]      int            NULL,
    [bucket_status]    varchar(60)    NULL,
    [inv_bucket_name]  varchar(60)    NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_inv_count_bucket] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [inv_bucket_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_count_bucket_p] 
 */

CREATE TABLE [dbo].[inv_count_bucket_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_count_id]     varchar(60)       NOT NULL,
    [inv_bucket_id]    varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_bucket_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [inv_bucket_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_count_p] 
 */

CREATE TABLE [dbo].[inv_count_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_count_id]     varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_count_section] 
 */

CREATE TABLE [dbo].[inv_count_section](
    [organization_id]  int            NOT NULL,
    [rtl_loc_id]       int            NOT NULL,
    [inv_bucket_id]    varchar(60)    NOT NULL,
    [section_id]       varchar(60)    NOT NULL,
    [sort_order]       int            NULL,
    [inv_bucket_name]  varchar(60)    NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_inv_count_section] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_bucket_id], [section_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_count_section_detail] 
 */

CREATE TABLE [dbo].[inv_count_section_detail](
    [organization_id]        int             NOT NULL,
    [rtl_loc_id]             int             NOT NULL,
    [inv_bucket_id]          varchar(60)     NOT NULL,
    [section_id]             varchar(60)     NOT NULL,
    [section_detail_nbr]     int             NOT NULL,
    [merch_hierarchy_level]  varchar(60)     NULL,
    [merch_hierarchy_id]     varchar(60)     NULL,
    [description]            varchar(254)    NULL,
    [create_date]            datetime        NULL,
    [create_user_id]         varchar(30)     NULL,
    [update_date]            datetime        NULL,
    [update_user_id]         varchar(30)     NULL,
    [record_state]           varchar(30)     NULL,
    CONSTRAINT [pk_inv_count_section_detail] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_bucket_id], [section_id], [section_detail_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_count_section_detail_p] 
 */

CREATE TABLE [dbo].[inv_count_section_detail_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [inv_bucket_id]       varchar(60)       NOT NULL,
    [section_id]          varchar(60)       NOT NULL,
    [section_detail_nbr]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_section_detail_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_bucket_id], [section_id], [section_detail_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_count_section_p] 
 */

CREATE TABLE [dbo].[inv_count_section_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_bucket_id]    varchar(60)       NOT NULL,
    [section_id]       varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_section_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_bucket_id], [section_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_count_sheet] 
 */

CREATE TABLE [dbo].[inv_count_sheet](
    [organization_id]   int            NOT NULL,
    [rtl_loc_id]        int            NOT NULL,
    [inv_count_id]      varchar(60)    NOT NULL,
    [count_sheet_nbr]   int            NOT NULL,
    [inv_bucket_id]     varchar(60)    NULL,
    [section_nbr]       int            NULL,
    [section_id]        varchar(60)    NULL,
    [count_cycle]       int            NULL,
    [sheet_status]      varchar(60)    NULL,
    [checked_out_flag]  bit            DEFAULT ((0)) NOT NULL,
    [inv_bucket_name]   varchar(60)    NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [pk_inv_count_sheet] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [count_sheet_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_count_sheet_lineitm] 
 */

CREATE TABLE [dbo].[inv_count_sheet_lineitm](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_count_id]     varchar(60)       NOT NULL,
    [count_sheet_nbr]  int               NOT NULL,
    [lineitm_nbr]      int               NOT NULL,
    [inv_bucket_id]    varchar(60)       NULL,
    [page_nbr]         int               NULL,
    [item_id]          varchar(60)       NULL,
    [alternate_id]     varchar(60)       NULL,
    [description]      varchar(200)      NULL,
    [quantity]         decimal(14, 4)    NULL,
    [count_cycle]      int               NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_sheet_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [count_sheet_nbr], [lineitm_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_inv_count_sheet_lineitm01] 
 */

CREATE INDEX [idx_inv_count_sheet_lineitm01] ON [dbo].[inv_count_sheet_lineitm]([inv_count_id], [inv_bucket_id], [item_id], [alternate_id], [description]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[inv_count_sheet_lineitm_p] 
 */

CREATE TABLE [dbo].[inv_count_sheet_lineitm_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_count_id]     varchar(60)       NOT NULL,
    [count_sheet_nbr]  int               NOT NULL,
    [lineitm_nbr]      int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_sheet_lineitm_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [count_sheet_nbr], [lineitm_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_count_sheet_p] 
 */

CREATE TABLE [dbo].[inv_count_sheet_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_count_id]     varchar(60)       NOT NULL,
    [count_sheet_nbr]  int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_sheet_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [count_sheet_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_count_snapshot] 
 */

CREATE TABLE [dbo].[inv_count_snapshot](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_count_id]     varchar(60)       NOT NULL,
    [inv_location_id]  varchar(60)       NOT NULL,
    [inv_bucket_id]    varchar(60)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [snapshot_date]    datetime          NULL,
    [quantity]         decimal(14, 4)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_snapshot] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [inv_location_id], [inv_bucket_id], [item_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_count_snapshot_p] 
 */

CREATE TABLE [dbo].[inv_count_snapshot_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_count_id]     varchar(60)       NOT NULL,
    [inv_location_id]  varchar(60)       NOT NULL,
    [inv_bucket_id]    varchar(60)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_count_snapshot_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_count_id], [inv_location_id], [inv_bucket_id], [item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_cst_item_yearend] 
 */

CREATE TABLE [dbo].[inv_cst_item_yearend](
    [organization_id]              int               NOT NULL,
    [fiscal_year]                  int               NOT NULL,
    [rtl_loc_id]                   int               NOT NULL,
    [item_id]                      varchar(60)       NOT NULL,
    [wac_qty_rcvd]                 decimal(14, 4)    NULL,
    [wac_value_rcvd]               decimal(17, 6)    NULL,
    [pwac_qty_onhand_endofyear]    decimal(14, 4)    NULL,
    [pwac_value_onhand_endofyear]  decimal(17, 6)    NULL,
    [create_date]                  datetime          NULL,
    [create_user_id]               varchar(30)       NULL,
    [update_date]                  datetime          NULL,
    [update_user_id]               varchar(30)       NULL,
    [record_state]                 varchar(30)       NULL,
    CONSTRAINT [pk_inv_cst_item_yearend] PRIMARY KEY CLUSTERED ([organization_id], [fiscal_year], [rtl_loc_id], [item_id]) WITH (FILLFACTOR = 80)
)
go

	CREATE INDEX idx_inv_cst_item_yearend_01 ON inv_cst_item_yearend (fiscal_year) WITH (FILLFACTOR = 80)
GO

	CREATE INDEX idx_inv_cst_item_yearend_02 ON inv_cst_item_yearend (rtl_loc_id) WITH (FILLFACTOR = 80)
GO

/* 
 * TABLE: [dbo].[inv_cst_item_yearend_p] 
 */

CREATE TABLE [dbo].[inv_cst_item_yearend_p](
    [organization_id]  int               NOT NULL,
    [fiscal_year]      int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_cst_item_yearend_p] PRIMARY KEY CLUSTERED ([organization_id], [fiscal_year], [rtl_loc_id], [item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_document_lineitm_note] 
 */

CREATE TABLE [dbo].[inv_document_lineitm_note](
    [organization_id]           int            NOT NULL,
    [rtl_loc_id]                int            NOT NULL,
    [document_typcode]          varchar(30)    NOT NULL,
    [invctl_document_id]        varchar(60)    NOT NULL,
    [invctl_document_line_nbr]  int            NOT NULL,
    [note_id]                   bigint         NOT NULL,
    [note_timestamp]            datetime       NULL,
    [note_type]                 varchar(60)    NULL,
    [note_text]                 text           NULL,
    [record_creation_type]      varchar(60)    NULL,
    [creator_party_id]          bigint         NULL,
    [create_date]               datetime       NULL,
    [create_user_id]            varchar(30)    NULL,
    [update_date]               datetime       NULL,
    [update_user_id]            varchar(30)    NULL,
    [record_state]              varchar(30)    NULL,
    CONSTRAINT [pk_inv_document_lineitm_note] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr], [note_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_document_lineitm_note_p] 
 */

CREATE TABLE [dbo].[inv_document_lineitm_note_p](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [document_typcode]          varchar(30)       NOT NULL,
    [invctl_document_id]        varchar(60)       NOT NULL,
    [invctl_document_line_nbr]  int               NOT NULL,
    [note_id]                   bigint            NOT NULL,
    [property_code]             varchar(30)       NOT NULL,
    [type]                      varchar(30)       NULL,
    [string_value]              varchar(max)      NULL,
    [date_value]                datetime          NULL,
    [decimal_value]             decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_inv_document_lineitm_note_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr], [note_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_document_notes] 
 */

CREATE TABLE [dbo].[inv_document_notes](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [document_typcode]    varchar(30)     NOT NULL,
    [invctl_document_id]  varchar(60)     NOT NULL,
    [note_id]             bigint          NOT NULL,
    [note_timestamp]      datetime        NULL,
    [note_text]           varchar(max)    NULL,
    [creator_party_id]    bigint          NULL,
    [note_type]           varchar(60)     NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_inv_document_notes] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [note_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_document_notes_p] 
 */

CREATE TABLE [dbo].[inv_document_notes_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [document_typcode]    varchar(30)       NOT NULL,
    [invctl_document_id]  varchar(60)       NOT NULL,
    [note_id]             bigint            NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_document_notes_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [note_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_invctl_doc_lineserial] 
 */

CREATE TABLE [dbo].[inv_invctl_doc_lineserial](
    [organization_id]           int             NOT NULL,
    [rtl_loc_id]                int             NOT NULL,
    [document_typcode]          varchar(30)     NOT NULL,
    [invctl_document_id]        varchar(60)     NOT NULL,
    [invctl_document_line_nbr]  int             NOT NULL,
    [serial_line_nbr]           int             NOT NULL,
    [serial_nbr]                varchar(254)    NULL,
    [create_date]               datetime        NULL,
    [create_user_id]            varchar(30)     NULL,
    [update_date]               datetime        NULL,
    [update_user_id]            varchar(30)     NULL,
    [record_state]              varchar(30)     NULL,
    CONSTRAINT [pk_inv_invctl_doc_lineserial] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr], [serial_line_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_invctl_doc_lineserial_p] 
 */

CREATE TABLE [dbo].[inv_invctl_doc_lineserial_p](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [document_typcode]          varchar(30)       NOT NULL,
    [invctl_document_id]        varchar(60)       NOT NULL,
    [invctl_document_line_nbr]  int               NOT NULL,
    [serial_line_nbr]           int               NOT NULL,
    [property_code]             varchar(30)       NOT NULL,
    [type]                      varchar(30)       NULL,
    [string_value]              varchar(max)      NULL,
    [date_value]                datetime          NULL,
    [decimal_value]             decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_inv_invctl_doc_lineserial_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr], [serial_line_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_invctl_document] 
 */

CREATE TABLE [dbo].[inv_invctl_document](
    [organization_id]          int             NOT NULL,
    [rtl_loc_id]               int             NOT NULL,
    [document_typcode]         varchar(30)     NOT NULL,
    [invctl_document_id]       varchar(60)     NOT NULL,
    [create_date_timestamp]    datetime        NULL,
    [complete_date_timestamp]  datetime        NULL,
    [status_code]              varchar(30)     NULL,
    [originator_id]            varchar(60)     NULL,
    [document_subtypcode]      varchar(30)     NULL,
    [originator_name]          varchar(254)    NULL,
    [last_activity_date]       datetime        NULL,
    [po_ref_nbr]               varchar(254)    NULL,
    [record_creation_type]     varchar(30)     NULL,
    [description]              varchar(254)    NULL,
    [control_number]           varchar(254)    NULL,
    [originator_address_id]    varchar(60)     NULL,
    [submit_date]              datetime        NULL,
    [create_date]              datetime        NULL,
    [create_user_id]           varchar(30)     NULL,
    [update_date]              datetime        NULL,
    [update_user_id]           varchar(30)     NULL,
    [record_state]             varchar(30)     NULL,
    CONSTRAINT [pk_inv_invctl_document] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_invctl_document_lineitm] 
 */

CREATE TABLE [dbo].[inv_invctl_document_lineitm](
    [organization_id]             int               NOT NULL,
    [rtl_loc_id]                  int               NOT NULL,
    [invctl_document_id]          varchar(60)       NOT NULL,
    [document_typcode]            varchar(30)       NOT NULL,
    [invctl_document_line_nbr]    int               NOT NULL,
    [carton_id]                   varchar(60)       NULL,
    [inventory_item_id]           varchar(60)       NULL,
    [lineitm_typcode]             varchar(30)       NULL,
    [unit_count]                  decimal(14, 4)    NULL,
    [lineitm_rtl_loc_id]          int               NULL,
    [lineitm_wkstn_id]            bigint            NULL,
    [lineitm_business_date]       datetime          NULL,
    [lineitm_trans_seq]           bigint            NULL,
    [lineitm_rtrans_lineitm_seq]  int               NULL,
    [status_code]                 varchar(30)       NULL,
    [original_loc_id]             varchar(60)       NULL,
    [original_bucket_id]          varchar(60)       NULL,
    [expected_count]              decimal(14, 4)    NULL,
    [posted_count]                decimal(14, 4)    NULL,
    [record_creation_type]        varchar(30)       NULL,
    [entered_item_id]             varchar(60)       NULL,
    [entered_item_description]    varchar(254)      NULL,
    [serial_number]               varchar(254)      NULL,
    [retail]                      decimal(17, 6)    NULL,
    [model_nbr]                   varchar(254)      NULL,
    [control_number]              varchar(254)      NULL,
    [shipping_weight]             decimal(12, 3)    NULL,
    [unit_cost]                   decimal(17, 6)    NULL,
    [posted_cost]                 decimal(17, 6)    NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pk_inv_invctl_document_lnitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_inv_invctl_doc_lineitm01] 
 */

CREATE INDEX [idx_inv_invctl_doc_lineitm01] ON [dbo].[inv_invctl_document_lineitm]([organization_id], [lineitm_rtl_loc_id], [lineitm_business_date], [lineitm_wkstn_id], [lineitm_trans_seq], [lineitm_rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[inv_invctl_document_lineitm_p] 
 */

CREATE TABLE [dbo].[inv_invctl_document_lineitm_p](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [document_typcode]          varchar(30)       NOT NULL,
    [invctl_document_id]        varchar(60)       NOT NULL,
    [invctl_document_line_nbr]  int               NOT NULL,
    [property_code]             varchar(30)       NOT NULL,
    [type]                      varchar(30)       NULL,
    [string_value]              varchar(max)      NULL,
    [date_value]                datetime          NULL,
    [decimal_value]             decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pkinvinvctldocumentlineitmp] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_invctl_document_p] 
 */

CREATE TABLE [dbo].[inv_invctl_document_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [document_typcode]    varchar(30)       NOT NULL,
    [invctl_document_id]  varchar(60)       NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_invctl_doc_properties] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [property_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_invctl_document_xref] 
 */

CREATE TABLE [dbo].[inv_invctl_document_xref](
    [organization_id]             int            NOT NULL,
    [rtl_loc_id]                  int            NOT NULL,
    [invctl_document_id]          varchar(60)    NOT NULL,
    [document_typcode]            varchar(30)    NOT NULL,
    [invctl_document_line_nbr]    int            NOT NULL,
    [cross_ref_organization_id]   int            NULL,
    [cross_ref_document_id]       varchar(60)    NULL,
    [cross_ref_line_number]       int            NULL,
    [cross_ref_document_typcode]  varchar(30)    NULL,
    [cross_ref_rtl_loc_id]        int            NULL,
    [create_date]                 datetime       NULL,
    [create_user_id]              varchar(30)    NULL,
    [update_date]                 datetime       NULL,
    [update_user_id]              varchar(30)    NULL,
    [record_state]                varchar(30)    NULL,
    CONSTRAINT [pk_inv_invctl_document_xref] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_invctl_document_xref_p] 
 */

CREATE TABLE [dbo].[inv_invctl_document_xref_p](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [document_typcode]          varchar(30)       NOT NULL,
    [invctl_document_id]        varchar(60)       NOT NULL,
    [invctl_document_line_nbr]  int               NOT NULL,
    [property_code]             varchar(30)       NOT NULL,
    [type]                      varchar(30)       NULL,
    [string_value]              varchar(max)      NULL,
    [date_value]                datetime          NULL,
    [decimal_value]             decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_inv_invctl_document_xref_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_invctl_trans] 
 */

CREATE TABLE [dbo].[inv_invctl_trans](
    [organization_id]             int            NOT NULL,
    [business_date]               datetime       NOT NULL,
    [wkstn_id]                    bigint         NOT NULL,
    [rtl_loc_id]                  int            NOT NULL,
    [trans_seq]                   bigint         NOT NULL,
    [document_typcode]            varchar(30)    NULL,
    [document_date]               datetime       NULL,
    [old_status_code]             varchar(30)    NULL,
    [new_status_code]             varchar(30)    NULL,
    [invctl_document_id]          varchar(60)    NULL,
    [invctl_document_rtl_loc_id]  int            NULL,
    [invctl_trans_reascode]       varchar(30)    NULL,
    [create_date]                 datetime       NULL,
    [create_user_id]              varchar(30)    NULL,
    [update_date]                 datetime       NULL,
    [update_user_id]              varchar(30)    NULL,
    [record_state]                varchar(30)    NULL,
    CONSTRAINT [pk_inv_invctl_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_invctl_trans_detail] 
 */

CREATE TABLE [dbo].[inv_invctl_trans_detail](
    [organization_id]             int               NOT NULL,
    [rtl_loc_id]                  int               NOT NULL,
    [business_date]               datetime          NOT NULL,
    [wkstn_id]                    bigint            NOT NULL,
    [trans_seq]                   bigint            NOT NULL,
    [invctl_trans_seq]            bigint            NOT NULL,
    [invctl_document_rtl_loc_id]  int               NULL,
    [invctl_document_id]          varchar(60)       NULL,
    [document_typcode]            varchar(30)       NULL,
    [invctl_document_line_nbr]    int               NULL,
    [item_id]                     varchar(60)       NULL,
    [action_code]                 varchar(30)       NULL,
    [previous_unit_count]         decimal(14, 4)    NULL,
    [new_unit_count]              decimal(14, 4)    NULL,
    [old_status_code]             varchar(30)       NULL,
    [new_status_code]             varchar(30)       NULL,
    [previous_posted_count]       decimal(14, 4)    NULL,
    [new_posted_count]            decimal(14, 4)    NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pk_inv_invctl_trans_detail] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [invctl_trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_invctl_trans_detail_p] 
 */

CREATE TABLE [dbo].[inv_invctl_trans_detail_p](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [wkstn_id]          bigint            NOT NULL,
    [business_date]     datetime          NOT NULL,
    [trans_seq]         bigint            NOT NULL,
    [invctl_trans_seq]  bigint            NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_inv_invctl_trans_detail_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [invctl_trans_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_inventory_journal] 
 */

CREATE TABLE [dbo].[inv_inventory_journal](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [trans_lineitm_seq]   int               NOT NULL,
    [journal_seq]         bigint            NOT NULL,
    [inventory_item_id]   varchar(60)       NULL,
    [item_serial_nbr]     varchar(254)      NULL,
    [action_code]         varchar(30)       NULL,
    [quantity]            decimal(11, 4)    NULL,
    [source_location_id]  varchar(60)       NULL,
    [source_bucket_id]    varchar(60)       NULL,
    [dest_location_id]    varchar(60)       NULL,
    [dest_bucket_id]      varchar(60)       NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_inventory_journal] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq], [journal_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_inventory_journal_p] 
 */

CREATE TABLE [dbo].[inv_inventory_journal_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [business_date]      datetime          NOT NULL,
    [wkstn_id]           bigint            NOT NULL,
    [trans_seq]          bigint            NOT NULL,
    [trans_lineitm_seq]  int               NOT NULL,
    [journal_seq]        bigint            NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_inv_inventory_journal_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq], [journal_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_inventory_loc_mod] 
 */

CREATE TABLE [dbo].[inv_inventory_loc_mod](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [document_typcode]    varchar(30)       NOT NULL,
    [document_id]         varchar(60)       NOT NULL,
    [document_line_nbr]   int               NOT NULL,
    [mod_seq]             int               NOT NULL,
    [serial_nbr]          varchar(254)      NULL,
    [source_location_id]  varchar(60)       NULL,
    [source_bucket_id]    varchar(60)       NULL,
    [dest_location_id]    varchar(60)       NULL,
    [dest_bucket_id]      varchar(60)       NULL,
    [quantity]            decimal(11, 4)    NULL,
    [action_code]         varchar(30)       NULL,
    [void_flag]           bit               DEFAULT ((0)) NULL,
    [item_id]             varchar(60)       NULL,
    [cost]                decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_inventory_loc_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [document_id], [document_line_nbr], [mod_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_inventory_loc_mod_p] 
 */

CREATE TABLE [dbo].[inv_inventory_loc_mod_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [document_typcode]   varchar(30)       NOT NULL,
    [document_id]        varchar(60)       NOT NULL,
    [document_line_nbr]  int               NOT NULL,
    [mod_seq]            int               NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_inv_inventory_loc_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [document_id], [document_line_nbr], [mod_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_item_acct_mod] 
 */

CREATE TABLE [dbo].[inv_item_acct_mod](
    [organization_id]           int            NOT NULL,
    [rtl_loc_id]                int            NOT NULL,
    [document_typcode]          varchar(30)    NOT NULL,
    [invctl_document_id]        varchar(60)    NOT NULL,
    [invctl_document_line_nbr]  int            NOT NULL,
    [cust_acct_code]            varchar(30)    NOT NULL,
    [cust_acct_id]              varchar(60)    NOT NULL,
    [create_date]               datetime       NULL,
    [create_user_id]            varchar(30)    NULL,
    [update_date]               datetime       NULL,
    [update_user_id]            varchar(30)    NULL,
    [record_state]              varchar(30)    NULL,
    CONSTRAINT [pk_inv_item_acct_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_item_acct_mod_p] 
 */

CREATE TABLE [dbo].[inv_item_acct_mod_p](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [document_typcode]          varchar(30)       NOT NULL,
    [invctl_document_id]        varchar(60)       NOT NULL,
    [invctl_document_line_nbr]  int               NOT NULL,
    [property_code]             varchar(30)       NOT NULL,
    [type]                      varchar(30)       NULL,
    [string_value]              varchar(max)      NULL,
    [date_value]                datetime          NULL,
    [decimal_value]             decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_inv_item_acct_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_location] 
 */

CREATE TABLE [dbo].[inv_location](
    [organization_id]       int             NOT NULL,
    [rtl_loc_id]            int             NOT NULL,
    [inv_location_id]       varchar(60)     NOT NULL,
    [name]                  varchar(254)    NULL,
    [active_flag]           bit             DEFAULT ((0)) NULL,
    [system_location_flag]  bit             DEFAULT ((0)) NULL,
    [create_date]           datetime        NULL,
    [create_user_id]        varchar(30)     NULL,
    [update_date]           datetime        NULL,
    [update_user_id]        varchar(30)     NULL,
    [record_state]          varchar(30)     NULL,
    CONSTRAINT [pk_inv_location] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_location_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_location_availability] 
 */

CREATE TABLE [dbo].[inv_location_availability](
    [organization_id]    int            NOT NULL,
    [rtl_loc_id]         int            NOT NULL,
    [location_id]        varchar(60)    NOT NULL,
    [availability_code]  varchar(30)    NOT NULL,
    [privilege_type]     varchar(60)    NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     varchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     varchar(30)    NULL,
    [record_state]       varchar(30)    NULL,
    CONSTRAINT [pk_inv_location_availability] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [location_id], [availability_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_location_availability_p] 
 */

CREATE TABLE [dbo].[inv_location_availability_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [location_id]        varchar(60)       NOT NULL,
    [availability_code]  varchar(30)       NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_inv_location_availability_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [location_id], [availability_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_location_bucket] 
 */

CREATE TABLE [dbo].[inv_location_bucket](
    [organization_id]  int            NOT NULL,
    [rtl_loc_id]       int            NOT NULL,
    [location_id]      varchar(60)    NOT NULL,
    [bucket_id]        varchar(60)    NOT NULL,
    [tracking_method]  varchar(30)    NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_inv_location_bucket] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [location_id], [bucket_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_location_bucket_p] 
 */

CREATE TABLE [dbo].[inv_location_bucket_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [location_id]      varchar(60)       NOT NULL,
    [bucket_id]        varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_location_bucket_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [location_id], [bucket_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_location_p] 
 */

CREATE TABLE [dbo].[inv_location_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_location_id]  varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_location_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_location_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_movement_pending] 
 */

CREATE TABLE [dbo].[inv_movement_pending](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [business_date]      datetime          NOT NULL,
    [wkstn_id]           bigint            NOT NULL,
    [trans_seq]          bigint            NOT NULL,
    [trans_lineitm_seq]  int               NOT NULL,
    [item_id]            varchar(60)       NULL,
    [serial_nbr]         varchar(254)      NULL,
    [action_code]        varchar(30)       NULL,
    [quantity]           decimal(11, 4)    NULL,
    [dest_location_id]   varchar(60)       NULL,
    [dest_bucket_id]     varchar(60)       NULL,
    [reconciled_flag]    bit               DEFAULT ((0)) NULL,
    [void_flag]          bit               DEFAULT ((0)) NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_inv_movement_pending] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_movement_pending_detail] 
 */

CREATE TABLE [dbo].[inv_movement_pending_detail](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [trans_lineitm_seq]   int               NOT NULL,
    [pending_seq]         int               NOT NULL,
    [serial_nbr]          varchar(254)      NULL,
    [quantity]            decimal(11, 4)    NULL,
    [source_location_id]  varchar(60)       NULL,
    [source_bucket_id]    varchar(60)       NULL,
    [dest_location_id]    varchar(60)       NULL,
    [dest_bucket_id]      varchar(60)       NULL,
    [action_code]         varchar(30)       NULL,
    [void_flag]           bit               DEFAULT ((0)) NULL,
    [item_id]             varchar(60)       NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_movement_pending_dtl] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq], [pending_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_movement_pending_detail_p] 
 */

CREATE TABLE [dbo].[inv_movement_pending_detail_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [business_date]      datetime          NOT NULL,
    [wkstn_id]           bigint            NOT NULL,
    [trans_seq]          bigint            NOT NULL,
    [trans_lineitm_seq]  int               NOT NULL,
    [pending_seq]        int               NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pkinvmovementpendingdetailp] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq], [pending_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_movement_pending_p] 
 */

CREATE TABLE [dbo].[inv_movement_pending_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [business_date]      datetime          NOT NULL,
    [wkstn_id]           bigint            NOT NULL,
    [trans_seq]          bigint            NOT NULL,
    [trans_lineitm_seq]  int               NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_inv_movement_pending_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_mptrans_lineitm] 
 */

CREATE TABLE [dbo].[inv_mptrans_lineitm](
    [organization_id]             int               NOT NULL,
    [rtl_loc_id]                  int               NOT NULL,
    [business_date]               datetime          NOT NULL,
    [wkstn_id]                    bigint            NOT NULL,
    [trans_seq]                   bigint            NOT NULL,
    [trans_lineitm_seq]           int               NOT NULL,
    [original_rtl_loc_id]         int               NULL,
    [original_wkstn_id]           bigint            NULL,
    [original_business_date]      datetime          NULL,
    [original_trans_seq]          bigint            NULL,
    [original_trans_lineitm_seq]  int               NULL,
    [quantity_reconciled]         decimal(11, 4)    NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pk_inv_mptrans_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_mptrans_lineitm_p] 
 */

CREATE TABLE [dbo].[inv_mptrans_lineitm_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [business_date]      datetime          NOT NULL,
    [wkstn_id]           bigint            NOT NULL,
    [trans_seq]          bigint            NOT NULL,
    [trans_lineitm_seq]  int               NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_inv_mptrans_lineitm_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_rep_document_lineitm] 
 */

CREATE TABLE [dbo].[inv_rep_document_lineitm](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [invctl_document_id]        varchar(60)       NOT NULL,
    [document_typcode]          varchar(30)       NOT NULL,
    [invctl_document_line_nbr]  int               NOT NULL,
    [suggested_order_qty]       decimal(11, 4)    NULL,
    [order_quantity]            decimal(11, 4)    NULL,
    [confirmed_quantity]        decimal(11, 4)    NULL,
    [confirmation_date]         datetime          NULL,
    [confirmation_number]       varchar(60)       NULL,
    [ship_via]                  varchar(254)      NULL,
    [shipped_quantity]          decimal(11, 4)    NULL,
    [shipped_date]              datetime          NULL,
    [received_quantity]         decimal(11, 4)    NULL,
    [received_date]             datetime          NULL,
    [source_type]               varchar(60)       NULL,
    [source_id]                 varchar(60)       NULL,
	[source_name]				VARCHAR(254)	  NULL,
    [parent_document_id]        varchar(60)       NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_inv_rep_document_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_rep_document_lineitm_p] 
 */

CREATE TABLE [dbo].[inv_rep_document_lineitm_p](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [document_typcode]          varchar(30)       NOT NULL,
    [invctl_document_id]        varchar(60)       NOT NULL,
    [invctl_document_line_nbr]  int               NOT NULL,
    [property_code]             varchar(30)       NOT NULL,
    [type]                      varchar(30)       NULL,
    [string_value]              varchar(max)      NULL,
    [date_value]                datetime          NULL,
    [decimal_value]             decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_inv_rep_document_lineitm_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [invctl_document_line_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_serialized_stock_ledger] 
 */

CREATE TABLE [dbo].[inv_serialized_stock_ledger](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [inv_location_id]  varchar(60)     NOT NULL,
    [bucket_id]        varchar(60)     NOT NULL,
    [item_id]          varchar(60)     NOT NULL,
    [serial_nbr]       varchar(200)    NOT NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_inv_serialized_stock_ldgr] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_location_id], [bucket_id], [item_id], [serial_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_serialized_stock_ledger_p] 
 */

CREATE TABLE [dbo].[inv_serialized_stock_ledger_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_location_id]  varchar(60)       NOT NULL,
    [bucket_id]        varchar(60)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [serial_nbr]       varchar(200)      NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pkinvserializedstockledgerp] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [inv_location_id], [bucket_id], [item_id], [serial_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_shipment] 
 */

CREATE TABLE [dbo].[inv_shipment](
    [organization_id]				int             NOT NULL,
    [rtl_loc_id]					int             NOT NULL,
    [document_typcode]				varchar(30)     NOT NULL,
    [invctl_document_id]			varchar(60)     NOT NULL,
    [shipment_seq]					int             NOT NULL,
    [expected_delivery_date]		datetime        NULL,
    [actual_delivery_date]			datetime        NULL,
    [expected_ship_date]			datetime        NULL,
    [destination_party_id]			bigint          NULL,
    [shipping_carrier]				varchar(254)    NULL,
    [actual_ship_date]				datetime        NULL,
    [tracking_nbr]					varchar(254)    NULL,
    [shipment_statcode]				varchar(30)     NULL,
    [record_creation_type]			varchar(30)     NULL,
    [destination_rtl_loc_id]		int             NULL,
    [destination_name]				varchar(254)    NULL,
    [shipping_method]				varchar(254)    NULL,
    [shipping_label]				varchar(max)    NULL,
	[destination_type]				varchar(30)	  NULL,
	[destination_service_loc_id]	varchar(60)	  NULL,
    [create_date]					datetime        NULL,
    [create_user_id]				varchar(30)     NULL,
    [update_date]					datetime        NULL,
    [update_user_id]				varchar(30)     NULL,
    [record_state]					varchar(30)     NULL,
    CONSTRAINT [pk_inv_shipment] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [shipment_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_shipment_address] 
 */

CREATE TABLE [dbo].[inv_shipment_address](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [document_typcode]    varchar(30)     NOT NULL,
    [invctl_document_id]  varchar(60)     NOT NULL,
    [shipment_seq]        int             NOT NULL,
    [address1]            varchar(254)    NULL,
    [address2]            varchar(254)    NULL,
    [address3]            varchar(254)    NULL,
    [address4]            varchar(254)    NULL,
    [apartment]           varchar(30)     NULL,
    [city]                varchar(254)    NULL,
    [state]               varchar(30)     NULL,
    [postal_code]         varchar(30)     NULL,
    [country]             varchar(2)	  NULL,
	[neighborhood]		  varchar(254)	  null,
	[county]			  varchar(254)	  null,
    [telephone1]          varchar(32)     NULL,
    [telephone2]          varchar(32)     NULL,
    [telephone3]          varchar(32)     NULL,
    [telephone4]          varchar(32)     NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_inv_shipment_address] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [shipment_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_shipment_address_p] 
 */

CREATE TABLE [dbo].[inv_shipment_address_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [document_typcode]    varchar(30)       NOT NULL,
    [invctl_document_id]  varchar(60)       NOT NULL,
    [shipment_seq]        int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_shipment_address_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [shipment_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_shipment_lines] 
 */

CREATE TABLE [dbo].[inv_shipment_lines](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [document_typcode]          varchar(30)       NOT NULL,
    [invctl_document_id]        varchar(60)       NOT NULL,
    [shipment_seq]              int               NOT NULL,
    [lineitm_seq]               int               NOT NULL,
    [invctl_document_line_nbr]  int               NOT NULL,
    [ship_qty]                  decimal(11, 4)    NULL,
    [carton_id]                 varchar(60)       NULL,
    [status_code]               varchar(30)       NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_inv_shipment_lines] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [shipment_seq], [lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_shipment_lines_p] 
 */

CREATE TABLE [dbo].[inv_shipment_lines_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [document_typcode]    varchar(30)       NOT NULL,
    [invctl_document_id]  varchar(60)       NOT NULL,
    [shipment_seq]        int               NOT NULL,
    [lineitm_seq]         int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_shipment_lines_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [shipment_seq], [lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_shipment_p] 
 */

CREATE TABLE [dbo].[inv_shipment_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [document_typcode]    varchar(30)       NOT NULL,
    [invctl_document_id]  varchar(60)       NOT NULL,
    [shipment_seq]        int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_inv_shipment_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [invctl_document_id], [shipment_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_shipper] 
 */

CREATE TABLE [dbo].[inv_shipper](
    [organization_id]		int             NOT NULL,
    [shipper_id]			varchar(60)     NOT NULL,
    [org_code]		        varchar(30) DEFAULT('*')		NOT NULL,
    [org_value]			    varchar(60) DEFAULT('*')		NOT NULL,
    [shipper_desc]			varchar(254),
    [display_order]			int				NULL,
    [tracking_number_flag]	bit			DEFAULT((0))	NULL,
    [create_date]			datetime		NULL,
    [create_user_id]		varchar(30)		NULL,
    [update_date]			datetime		NULL,
    [update_user_id]		varchar(30)		NULL,
    [record_state]			varchar(30)		NULL,
    CONSTRAINT [pk_inv_shipper] PRIMARY KEY CLUSTERED ([organization_id], [shipper_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_inv_shipper_orgnode ON inv_shipper (org_code,org_value) WITH (FILLFACTOR = 80)
go

/* 
 * TABLE: [dbo].[inv_shipper_method] 
 */

CREATE TABLE [dbo].[inv_shipper_method](
    [organization_id]        int             NOT NULL,
    [shipper_method_id]      varchar(60)     NOT NULL,
    [org_code]			     varchar(30) DEFAULT('*')	 NOT NULL,
    [org_value]		         varchar(60) DEFAULT('*')	 NOT NULL,
    [shipper_method_desc]    varchar(254)	NULL,
    [shipper_id]             varchar(60)	NULL,
    [domestic_service_code]  varchar(60)	NULL,
	[intl_service_code]		 varchar(60)	NULL,
    [display_order]          int			NULL,
	[priority]				 int			NULL,
    [create_date]            datetime		NULL,
    [create_user_id]         varchar(30)	NULL,
    [update_date]            datetime		NULL,
    [update_user_id]         varchar(30)	NULL,
    [record_state]           varchar(30)	NULL,
    CONSTRAINT [pk_inv_shipper_method] PRIMARY KEY CLUSTERED ([organization_id], [shipper_method_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_inv_shipper_method_orgnode ON inv_shipper_method (org_code,org_value) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[inv_shipper_method_p] 
 */

CREATE TABLE [dbo].[inv_shipper_method_p](
    [organization_id]    int               NOT NULL,
    [shipper_method_id]  varchar(60)       NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_inv_shipper_method_p] PRIMARY KEY CLUSTERED ([organization_id], [shipper_method_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_shipper_p] 
 */

CREATE TABLE [dbo].[inv_shipper_p](
    [organization_id]  int               NOT NULL,
    [shipper_id]       varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_shipper_p] PRIMARY KEY CLUSTERED ([organization_id], [shipper_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_stock_fiscal_year] 
 */

CREATE TABLE [dbo].[inv_stock_fiscal_year](
    [organization_id]  int            NOT NULL,
    [fiscal_year]      int            NOT NULL,
    [start_date]       datetime       NULL,
    [end_date]         datetime       NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_inv_stock_fiscal_year] PRIMARY KEY CLUSTERED ([organization_id], [fiscal_year])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_stock_fiscal_year_p] 
 */

CREATE TABLE [dbo].[inv_stock_fiscal_year_p](
    [organization_id]  int               NOT NULL,
    [fiscal_year]      int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_stock_fiscal_year_p] PRIMARY KEY CLUSTERED ([organization_id], [fiscal_year], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_stock_ledger_acct] 
 */

CREATE TABLE [dbo].[inv_stock_ledger_acct](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [inv_location_id]  varchar(60)       NOT NULL,
    [bucket_id]        varchar(60)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [unitcount]        decimal(14, 4)    NULL,
    [inventory_value]  decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_stock_ledger_acct] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [item_id], [bucket_id], [inv_location_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_inv_stock_ledger_acct01] 
 */

CREATE INDEX [idx_inv_stock_ledger_acct01] ON [dbo].[inv_stock_ledger_acct]([organization_id], [bucket_id], [item_id], rtl_loc_id, unitcount) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[inv_stock_ledger_acct_p] 
 */

CREATE TABLE [dbo].[inv_stock_ledger_acct_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [bucket_id]        varchar(60)       NOT NULL,
    [inv_location_id]  varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_stock_ledger_acct_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [item_id], [bucket_id], [inv_location_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_sum_count_trans_dtl] 
 */

CREATE TABLE [dbo].[inv_sum_count_trans_dtl](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [trans_line_seq]   int               NOT NULL,
    [location_id]      varchar(60)       NULL,
    [bucket_id]        varchar(60)       NULL,
    [system_count]     decimal(14, 4)    NULL,
    [declared_count]   decimal(14, 4)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_sum_count_trans_dtl] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_line_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[inv_sum_count_trans_dtl_p] 
 */

CREATE TABLE [dbo].[inv_sum_count_trans_dtl_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [trans_line_seq]   int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_inv_sum_count_trans_dtl_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_line_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[inv_valid_destinations] 
 */

CREATE TABLE [dbo].[inv_valid_destinations](
    [organization_id]        int             NOT NULL,
    [rtl_loc_id]             int             NOT NULL,
    [document_typcode]       varchar(30)     NOT NULL,
    [document_subtypcode]    varchar(30)     NOT NULL,
    [destination_type_enum]  varchar(30)     NOT NULL,
    [destination_id]         varchar(60)     NOT NULL,
    [description]            varchar(254)    NULL,
    [sort_order]             int             NULL,
    [create_date]            datetime        NULL,
    [create_user_id]         varchar(30)     NULL,
    [update_date]            datetime        NULL,
    [update_user_id]         varchar(30)     NULL,
    [record_state]           varchar(30)     NULL,
    CONSTRAINT [pk_inv_valid_destinations] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [document_subtypcode], [destination_type_enum], [destination_id]) WITH (FILLFACTOR = 80)
)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[inv_valid_destinations] TO hhlookupusers
go

/* 
 * TABLE: [dbo].[inv_valid_destinations_p] 
 */

CREATE TABLE [dbo].[inv_valid_destinations_p](
    [organization_id]        int               NOT NULL,
    [rtl_loc_id]             int               NOT NULL,
    [document_typcode]       varchar(30)       NOT NULL,
    [document_subtypcode]    varchar(30)       NOT NULL,
    [destination_type_enum]  varchar(30)       NOT NULL,
    [destination_id]         varchar(60)       NOT NULL,
    [property_code]          varchar(30)       NOT NULL,
    [type]                   varchar(30)       NULL,
    [string_value]           varchar(max)      NULL,
    [date_value]             datetime          NULL,
    [decimal_value]          decimal(17, 6)    NULL,
    [create_date]            datetime          NULL,
    [create_user_id]         varchar(30)       NULL,
    [update_date]            datetime          NULL,
    [update_user_id]         varchar(30)       NULL,
    [record_state]           varchar(30)       NULL,
    CONSTRAINT [pk_inv_valid_destinations_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [document_typcode], [document_subtypcode], [destination_type_enum], [destination_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_attached_items] 
 */

CREATE TABLE [dbo].[itm_attached_items](
    [organization_id]            int               NOT NULL,
    [sold_item_id]               varchar(60)       NOT NULL,
    [attached_item_id]           varchar(60)       NOT NULL,
    [level_code]                 varchar(30)       DEFAULT('*') NOT NULL,
    [level_value]                varchar(60)       DEFAULT('*') NOT NULL,
    [begin_datetime]             datetime          NULL,
    [end_datetime]               datetime          NULL,
    [prompt_to_add_flag]         bit               DEFAULT ((0)) NULL,
    [prompt_to_add_msg_key]      varchar(254)      NULL,
    [quantity_to_add]            decimal(11, 4)    NULL,
    [lineitm_assoc_typcode]      varchar(30)       NULL,
    [prompt_for_return_flag]     bit               DEFAULT ((0)) NULL,
    [prompt_for_return_msg_key]  varchar(254)      NULL,
	[EXTERNAL_ID]				 VARCHAR(60)	   null,
	[EXTERNAL_SYSTEM]			 VARCHAR(60)	   null,
    [create_date]                datetime          NULL,
    [create_user_id]             varchar(30)       NULL,
    [update_date]                datetime          NULL,
    [update_user_id]             varchar(30)       NULL,
    [record_state]               varchar(30)       NULL,
    CONSTRAINT [pk_itm_attached_items] PRIMARY KEY CLUSTERED ([organization_id], [sold_item_id], [attached_item_id], [level_code], [level_value]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[itm_attached_items_p] 
 */

CREATE TABLE [dbo].[itm_attached_items_p](
    [organization_id]   int               NOT NULL,
    [sold_item_id]      varchar(60)       NOT NULL,
    [attached_item_id]  varchar(60)       NOT NULL,
    [level_code]        varchar(30)       DEFAULT '*' NOT NULL,
    [level_value]       varchar(60)       DEFAULT '*' NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_itm_attached_items_p] PRIMARY KEY CLUSTERED ([organization_id], [sold_item_id], [attached_item_id], [level_code], [level_value], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item] 
 */

CREATE TABLE [dbo].[itm_item](
    [ORGANIZATION_ID]              int               NOT NULL,
    [ITEM_ID]                      varchar(60)       NOT NULL,
    [ORG_CODE]					varchar(30)	   DEFAULT('*') NOT NULL,
    [ORG_VALUE]				varchar(60)	   DEFAULT('*') NOT NULL,
    [NAME]                         varchar(254)      NULL,
    [DESCRIPTION]                  varchar(254)      NULL,
    [merch_level_1]                varchar(60)       DEFAULT ('DEFAULT') NULL,
    [merch_level_2]		           varchar(60)       NULL,
    [merch_level_3]                varchar(60)       NULL,
    [merch_level_4]                varchar(60)       NULL,
    [LIST_PRICE]                   decimal(17, 6)    NULL,
    [MEASURE_REQ_FLAG]		       bit               DEFAULT ((0)) NULL,
    [ITEM_LVLCODE]                 varchar(30)       NULL,
    [PARENT_ITEM_ID]               varchar(60)       NULL,
    [NOT_INVENTORIED_FLAG]         bit               DEFAULT ((0)) NULL,
    [SERIALIZED_ITEM_FLAG]         bit               DEFAULT ((0)) NULL,
    [ITEM_TYPCODE]                 varchar(30)       NULL,
    [DTV_CLASS_NAME]               varchar(254)      NULL,
    [DIMENSION_SYSTEM]             varchar(60)       NULL,
    [DISALLOW_MATRIX_DISPLAY_FLAG]	bit				 DEFAULT 0 NULL,
    [item_matrix_color]				varchar(20)		 NULL,
	[dimension1]                   varchar(60)       NULL,
    [dimension2]                   varchar(60)       NULL,
    [dimension3]                   varchar(60)       NULL,	  
	[EXTERNAL_SYSTEM]			   VARCHAR(60)		 NULL,
    [CREATE_DATE]                  datetime          NULL,
    [CREATE_USER_ID]               varchar(30)       NULL,
    [UPDATE_DATE]                  datetime          NULL,
    [UPDATE_USER_ID]               varchar(30)       NULL,
    [RECORD_STATE]                 varchar(30)       NULL,
    CONSTRAINT [pk_itm_item] PRIMARY KEY CLUSTERED ([ORGANIZATION_ID], [ITEM_ID]) WITH (FILLFACTOR = 80)
)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[itm_item] TO hhlookupusers
go

/* 
 * INDEX: [xst_itm_item_mrchlvl3] 
 */

CREATE INDEX [xst_itm_item_mrchlvl3] ON [dbo].[itm_item]([ORGANIZATION_ID], [merch_level_3]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_itm_item_mrchlvl1] 
 */

CREATE INDEX [xst_itm_item_mrchlvl1] ON [dbo].[itm_item]([ORGANIZATION_ID], [merch_level_1]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_itm_item_description] 
 */

CREATE INDEX [xst_itm_item_description] ON [dbo].[itm_item]([ORGANIZATION_ID], [DESCRIPTION]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_itm_item_id_parentid] 
 */

CREATE INDEX [xst_itm_item_id_parentid] ON [dbo].[itm_item]([ORGANIZATION_ID], [PARENT_ITEM_ID], [ITEM_ID]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_itm_item_mrchlvl4] 
 */

CREATE INDEX [xst_itm_item_mrchlvl4] ON [dbo].[itm_item]([ORGANIZATION_ID], [merch_level_4]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_itm_item_mrchlvl2] 
 */

CREATE INDEX [xst_itm_item_mrchlvl2] ON [dbo].[itm_item]([ORGANIZATION_ID], [merch_level_2]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_itm_item_typcode] 
 */

CREATE INDEX [xst_itm_item_typcode] ON [dbo].[itm_item]([ORGANIZATION_ID], [ITEM_TYPCODE]) WITH (FILLFACTOR = 80)
go

/* 
 * INDEX: [idx_itm_item02] 
 */

CREATE INDEX [idx_itm_item02] ON [dbo].[itm_item]([ITEM_ID], [ITEM_TYPCODE], [merch_level_1], [ORGANIZATION_ID]) WITH (FILLFACTOR = 80)
go

CREATE INDEX idx_itm_item_orgnode ON itm_item (org_code,org_value) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[itm_item_cross_reference] 
 */

CREATE TABLE [dbo].[itm_item_cross_reference](
    [organization_id]   int             NOT NULL,
    [manufacturer_upc]  varchar(60)     NOT NULL,
    [org_code]			varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]			varchar(60) DEFAULT('*')     NOT NULL,
    [item_id]           varchar(60)     NULL,
    [manufacturer]      varchar(254)    NULL,
    [primary_flag]	   bit		DEFAULT(0)	 NOT NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_itm_item_cross_reference] PRIMARY KEY CLUSTERED ([organization_id], [manufacturer_upc]) WITH (FILLFACTOR = 80)
)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[itm_item_cross_reference] TO hhlookupusers
go

/* 
 * INDEX: [xst_itm_xref_itemid] 
 */

CREATE INDEX [xst_itm_xref_itemid] ON [dbo].[itm_item_cross_reference]([organization_id], [item_id]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_itm_xref_upc_itemid] 
 */

CREATE INDEX [xst_itm_xref_upc_itemid] ON [dbo].[itm_item_cross_reference]([manufacturer_upc], [item_id], [organization_id]) WITH (FILLFACTOR = 80)
go

CREATE INDEX idx_itm_item_xreferenceorgnode ON itm_item_cross_reference (org_code,org_value) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[itm_item_cross_reference_p] 
 */

CREATE TABLE [dbo].[itm_item_cross_reference_p](
    [organization_id]   int               NOT NULL,
    [manufacturer_upc]  varchar(60)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_cross_reference_p] PRIMARY KEY CLUSTERED ([organization_id], [manufacturer_upc], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_deal_prop] 
 */

CREATE TABLE [dbo].[itm_item_deal_prop](
    [organization_id]			int               NOT NULL,
    [item_id]					varchar(60)       NOT NULL,
    [itm_deal_property_code]	varchar(30)       NOT NULL,
    [effective_date]			datetime          NOT NULL,
    [org_code]					varchar(30)		  DEFAULT '*' NOT NULL,
    [org_value]					varchar(60)		  DEFAULT '*' NOT NULL,
    [expiration_date]			datetime          NULL,
    [type]						varchar(30)       NULL,
    [string_value]				varchar(254)      NULL,
    [date_value]				datetime          NULL,
    [decimal_value]				decimal(17, 6)    NULL,
    [create_date]				datetime          NULL,
    [create_user_id]			varchar(30)       NULL,
    [update_date]				datetime          NULL,
    [update_user_id]			varchar(30)       NULL,
    [record_state]				varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_deal_prop] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [itm_deal_property_code], [effective_date]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_itm_itemprops_itemid] 
 */

CREATE INDEX [xst_itm_itemprops_itemid] ON [dbo].[itm_item_deal_prop]([organization_id], [item_id]) WITH (FILLFACTOR = 80)
go

CREATE INDEX idx_itm_item_prop_orgnode ON itm_item_deal_prop (org_code,org_value) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[itm_item_deal_prop_p] 
 */

CREATE TABLE [dbo].[itm_item_deal_prop_p](
    [organization_id]         int               NOT NULL,
    [item_id]                 varchar(60)       NOT NULL,
    [itm_deal_property_code]  varchar(30)       NOT NULL,
    [effective_date]          datetime          NOT NULL,
    [property_code]           varchar(30)       NOT NULL,
    [type]                    varchar(30)       NULL,
    [string_value]            varchar(max)      NULL,
    [date_value]              datetime          NULL,
    [decimal_value]           decimal(17, 6)    NULL,
    [create_date]             datetime          NULL,
    [create_user_id]          varchar(30)       NULL,
    [update_date]             datetime          NULL,
    [update_user_id]          varchar(30)       NULL,
    [record_state]            varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_deal_prop_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [itm_deal_property_code], [effective_date], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_dimension_type] 
 */

CREATE TABLE [dbo].[itm_item_dimension_type](
    [organization_id]   int             NOT NULL,
    [dimension_system]  varchar(60)     NOT NULL,
    [dimension]         varchar(30)     NOT NULL,
    [org_code]			varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]			varchar(60) DEFAULT('*')     NOT NULL,
    [seq]               int             NULL,
    [sort_order]        int             NULL,
    [description]       varchar(254)    NULL,
    [prompt_msg]        varchar(254)    NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_itm_item_dimension_type] PRIMARY KEY CLUSTERED ([organization_id], [dimension_system], [dimension]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_item_dim_type_orgnode ON itm_item_dimension_type (org_code,org_value) WITH (FILLFACTOR = 80)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[itm_item_dimension_type] TO hhlookupusers
go

/* 
 * TABLE: [dbo].[itm_item_dimension_type_p] 
 */

CREATE TABLE [dbo].[itm_item_dimension_type_p](
    [organization_id]   int               NOT NULL,
    [dimension_system]  varchar(60)       NOT NULL,
    [dimension]         varchar(30)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_dimension_type_p] PRIMARY KEY CLUSTERED ([organization_id], [dimension_system], [dimension], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_dimension_value] 
 */

CREATE TABLE [dbo].[itm_item_dimension_value](
    [organization_id]   int             NOT NULL,
    [dimension_system]  varchar(60)     NOT NULL,
    [dimension]         varchar(30)     NOT NULL,
    [value]             varchar(60)     NOT NULL,
    [org_code]          varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]         varchar(60) DEFAULT('*')     NOT NULL,
    [sort_order]        int             NULL,
    [description]       varchar(254)    NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_itm_item_dimension_value] PRIMARY KEY CLUSTERED ([organization_id], [dimension_system], [dimension], [value]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_item_dim_value_orgnode ON itm_item_dimension_value (org_code,org_value) WITH (FILLFACTOR = 80)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[itm_item_dimension_value] TO hhlookupusers
go

/* 
 * TABLE: [dbo].[itm_item_dimension_value_p] 
 */

CREATE TABLE [dbo].[itm_item_dimension_value_p](
    [organization_id]   int               NOT NULL,
    [dimension_system]  varchar(60)       NOT NULL,
    [dimension]         varchar(30)       NOT NULL,
    [value]             varchar(60)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_dimension_value_p] PRIMARY KEY CLUSTERED ([organization_id], [dimension_system], [dimension], [value], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_images] 
 */

CREATE TABLE [dbo].[itm_item_images](
    [organization_id]  int             NOT NULL,
    [item_id]          varchar(60)     NOT NULL,
    [feature_id]       varchar(60)     DEFAULT 'DEFAULT' NOT NULL,
    [org_code]         varchar(30)     DEFAULT '*' NOT NULL,
    [org_value]        varchar(60)     DEFAULT '*' NOT NULL,
    [image_url]        varchar(254)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_itm_item_images] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [feature_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_images_p] 
 */

CREATE TABLE [dbo].[itm_item_images_p](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [feature_id]       varchar(60)       DEFAULT 'DEFAULT' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_images_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [feature_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_label_batch] 
 */

CREATE TABLE [dbo].[itm_item_label_batch](
    [organization_id]  int            NOT NULL,
    [batch_name]       varchar(30)    NOT NULL,
    [item_id]          varchar(60)    NOT NULL,
    [stock_label]      varchar(20)    NOT NULL,
	[rtl_loc_id]	   int			  DEFAULT 0 NOT NULL,
    [count]            int            NOT NULL,
    [overriden_price]  decimal(17,6)  NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [PK_itm_label_batch] PRIMARY KEY CLUSTERED ([organization_id], [batch_name], [item_id], [stock_label], [rtl_loc_id])
    WITH FILLFACTOR = 80
)



/* 
 * TABLE: [dbo].[itm_item_label_batch_p] 
 */

CREATE TABLE [dbo].[itm_item_label_batch_p](
    [organization_id]  int               NOT NULL,
    [batch_name]       varchar(30)       NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [stock_label]      varchar(20)       NOT NULL,
	[rtl_loc_id]	   int				 DEFAULT 0 NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_label_batch_p] PRIMARY KEY CLUSTERED ([organization_id], [batch_name], [item_id], [stock_label], [rtl_loc_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_label_properties] 
 */

CREATE TABLE [dbo].[itm_item_label_properties](
    [organization_id]       int             NOT NULL,
    [item_id]               varchar(60)     NOT NULL,
    [org_code]              varchar(30)     DEFAULT '*' NOT NULL,
    [org_value]             varchar(60)     DEFAULT '*' NOT NULL,
    [stock_label]           varchar(30)     NULL,
    [logo_url]              varchar(254)    NULL,
    [create_date]           datetime        NULL,
    [create_user_id]        varchar(30)     NULL,
    [update_date]           datetime        NULL,
    [update_user_id]        varchar(30)     NULL,
    [record_state]		    varchar(30)     NULL,
    CONSTRAINT [PK_itm_item_label_properties] PRIMARY KEY CLUSTERED ([organization_id], [item_id])
    WITH FILLFACTOR = 80
)

CREATE INDEX idx_itm_item_labl_prop_orgnode ON itm_item_label_properties (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_item_label_properties_p] 
 */

CREATE TABLE [dbo].[itm_item_label_properties_p](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_label_properties_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_msg] 
 */

CREATE TABLE [dbo].[itm_item_msg](
    [organization_id]     int             NOT NULL,
    [msg_id]              varchar(60)     NOT NULL,
    [effective_datetime]  datetime        NOT NULL,
    [org_code]			  varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]			  varchar(60) DEFAULT('*')     NOT NULL,
    [expr_datetime]       datetime        NULL,
    [msg_key]             varchar(254)    NOT NULL,
    [title_key]           varchar(254)    NULL,
    [content_type]        varchar(30)     NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_itm_item_msg] PRIMARY KEY CLUSTERED ([organization_id], [msg_id], [effective_datetime]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_item_msg_orgnode ON itm_item_msg (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_item_msg_cross_reference] 
 */

CREATE TABLE [dbo].[itm_item_msg_cross_reference](
    [organization_id]  int            NOT NULL,
    [item_id]          varchar(60)    NOT NULL,
    [msg_id]           varchar(60)    NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_itm_item_msg_cross_ref] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [msg_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_item_msg_xref_orgnode ON itm_item_msg_cross_reference (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_item_msg_cross_reference_p] 
 */

CREATE TABLE [dbo].[itm_item_msg_cross_reference_p](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [msg_id]           varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pkitmitemmsgcrossreferencep] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [msg_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_msg_p] 
 */

CREATE TABLE [dbo].[itm_item_msg_p](
    [organization_id]     int               NOT NULL,
    [msg_id]              varchar(60)       NOT NULL,
    [effective_datetime]  datetime          NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_msg_p] PRIMARY KEY CLUSTERED ([organization_id], [msg_id], [effective_datetime], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_msg_types] 
 */

CREATE TABLE [dbo].[itm_item_msg_types](
    [organization_id]       int            NOT NULL,
    [msg_id]                varchar(60)    NOT NULL,
    [sale_lineitm_typcode]  varchar(30)    NOT NULL,
    [org_code]				varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]				varchar(60) DEFAULT('*')    NOT NULL,
    [create_date]           datetime       NULL,
    [create_user_id]        varchar(30)    NULL,
    [update_date]           datetime       NULL,
    [update_user_id]        varchar(30)    NULL,
    [record_state]          varchar(30)    NULL,
    CONSTRAINT [pk_itm_item_msg_types] PRIMARY KEY CLUSTERED ([organization_id], [sale_lineitm_typcode], [msg_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_item_msg_types_orgnode ON itm_item_msg_types (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_item_msg_types_p] 
 */

CREATE TABLE [dbo].[itm_item_msg_types_p](
    [organization_id]       int               NOT NULL,
    [sale_lineitm_typcode]  varchar(30)       NOT NULL,
    [msg_id]                varchar(60)       NOT NULL,
    [property_code]         varchar(30)       NOT NULL,
    [type]                  varchar(30)       NULL,
    [string_value]          varchar(max)      NULL,
    [date_value]            datetime          NULL,
    [decimal_value]         decimal(17, 6)    NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_msg_types_p] PRIMARY KEY CLUSTERED ([organization_id], [sale_lineitm_typcode], [msg_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_options] 
 */
 
CREATE TABLE [dbo].[itm_item_options] (
    [ORGANIZATION_ID]              int               NOT NULL,
    [ITEM_ID]                      varchar(60)       NOT NULL,
    [LEVEL_CODE]                   varchar(30)       DEFAULT('*') NOT NULL,
    [LEVEL_VALUE]                  varchar(60)       DEFAULT('*') NOT NULL,
    [UNIT_COST]                    decimal(17, 6)    NULL,
    [CURR_SALE_PRICE]              decimal(17, 6)    NULL,
    [UNIT_OF_MEASURE_CODE]         varchar(30)       NULL,
    [COMPARE_AT_PRICE]             decimal(17, 6)    NULL,
    [MIN_SALE_UNIT_COUNT]          decimal(11, 4)    NULL,
    [MAX_SALE_UNIT_COUNT]          decimal(11, 4)    NULL,
    [ITEM_AVAILABILITY_CODE]       varchar(30)       NULL,
    [DISALLOW_DISCOUNTS_FLAG]      bit               DEFAULT ((0)) NULL,
    [PROMPT_FOR_QUANTITY_FLAG]     bit               DEFAULT ((0)) NULL,
    [PROMPT_FOR_PRICE_FLAG]        bit               DEFAULT ((0)) NULL,
    [PROMPT_FOR_DESCRIPTION_FLAG]  bit               DEFAULT ((0)) NULL,
    [FORCE_QUANTITY_OF_ONE_FLAG]   bit               DEFAULT ((0)) NULL,
    [NOT_RETURNABLE_FLAG]          bit               DEFAULT ((0)) NULL,
    [NO_GIVEAWAYS_FLAG]            bit               DEFAULT ((0)) NULL,
    [ATTACHED_ITEMS_FLAG]          bit               DEFAULT ((0)) NULL,
    [SUBSTITUTE_AVAILABLE_FLAG]    bit               DEFAULT ((0)) NULL,
    [TAX_GROUP_ID]                 varchar(60)       NULL,
    [MESSAGES_FLAG]                bit               DEFAULT ((0)) NULL,
    [VENDOR]                       varchar(256)      NULL,
    [SEASON_CODE]                  varchar(30)       NULL,
    [PART_NUMBER]                  varchar(254)      NULL,
    [QTY_SCALE]                    int               NULL,
    [RESTOCKING_FEE]               decimal(17, 6)    NULL,
    [SPECIAL_ORDER_LEAD_DAYS]      int               NULL,
    [APPLY_RESTOCKING_FEE_FLAG]    bit               DEFAULT ((0)) NULL,
    [DISALLOW_SEND_SALE_FLAG]      bit               DEFAULT ((0)) NULL,
    [DISALLOW_PRICE_CHANGE_FLAG]   bit               DEFAULT ((0)) NULL,
    [DISALLOW_LAYAWAY_FLAG]        bit               DEFAULT ((0)) NULL,
    [DISALLOW_SPECIAL_ORDER_FLAG]  bit               DEFAULT ((0)) NULL,
    [DISALLOW_WORK_ORDER_FLAG]     bit               DEFAULT ((0)) NULL,
    [DISALLOW_COMMISSION_FLAG]     bit               DEFAULT 0 NULL,
    [WARRANTY_FLAG]                bit               DEFAULT ((0)) NULL,
    [GENERIC_ITEM_FLAG]            bit               DEFAULT ((0)) NULL,
    [MIN_AGE_REQUIRED]             int               NULL,
    [INITIAL_SALE_QTY]             decimal(11, 4)    NULL,
    [DISPOSITION_CODE]             varchar(30)       NULL,
    [FOODSTAMP_ELIGIBLE_FLAG]      bit               DEFAULT ((0)) NULL,
    [STOCK_STATUS]                 varchar(60)       NULL,
    [PROMPT_FOR_CUSTOMER]          varchar(30)       NULL,
    [SHIPPING_WEIGHT]              decimal(12, 3)    NULL,
    [DISALLOW_ORDER_FLAG]          bit               DEFAULT 0 NULL,
    [DISALLOW_DEALS_FLAG]          bit               DEFAULT 0 NULL,
    [PACK_SIZE]                    decimal(11, 4)    NULL,
    [default_source_type]          varchar(60)       NULL,
    [default_source_id]            varchar(60)       NULL,
    [DISALLOW_RAIN_CHECK]          bit               DEFAULT 0 NULL,
    [SELLING_GROUP_ID]             varchar(60)       NULL,
    [FISCAL_ITEM_ID]               varchar(254)      NULL,
    [FISCAL_ITEM_DESCRIPTION]      varchar(254)      NULL,
    [EXCLUDE_FROM_NET_SALES_FLAG]  bit               DEFAULT ((0)) NULL,
    [EXTERNAL_SYSTEM]              varchar(60)       NULL,
    [TARE_VALUE]                   decimal(11, 4)    NULL,
    [TARE_UNIT_OF_MEASURE_CODE]    varchar(30)       NULL,
    [CREATE_DATE]                  datetime          NULL,
    [CREATE_USER_ID]               varchar(30)       NULL,
    [UPDATE_DATE]                  datetime          NULL,
    [UPDATE_USER_ID]               varchar(30)       NULL,
    [RECORD_STATE]                 varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_options] PRIMARY KEY CLUSTERED ([ORGANIZATION_ID], [ITEM_ID], [LEVEL_CODE], [LEVEL_VALUE]) WITH (FILLFACTOR = 80)
)
go

/* 
 * INDEX: [xst_itm_item_options_join] 
 */
 
CREATE INDEX [xst_itm_item_options_join] ON [dbo].[itm_item_options]([ORGANIZATION_ID], [ITEM_ID]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[itm_item_options_p] 
 */
 
CREATE TABLE [dbo].[itm_item_options_p](
    [ORGANIZATION_ID]  int               NOT NULL,
    [ITEM_ID]          varchar(60)       NOT NULL,
    [LEVEL_CODE]       varchar(30)       NOT NULL,
    [LEVEL_VALUE]      varchar(60)       NOT NULL,
    [PROPERTY_CODE]    varchar(30)       NOT NULL,
    [TYPE]             varchar(30)       NULL,
    [STRING_VALUE]     varchar(max)      NULL,
    [DATE_VALUE]       datetime          NULL,
    [DECIMAL_VALUE]    decimal(17, 6)    NULL,
    [CREATE_DATE]      datetime          NULL,
    [CREATE_USER_ID]   varchar(30)       NULL,
    [UPDATE_DATE]      datetime          NULL,
    [UPDATE_USER_ID]   varchar(30)       NULL,
    [RECORD_STATE]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_options_p] PRIMARY KEY CLUSTERED ([ORGANIZATION_ID], [ITEM_ID], [LEVEL_CODE], [LEVEL_VALUE], [PROPERTY_CODE]) WITH (FILLFACTOR = 80)
)
go
/* 
 * TABLE: [dbo].[itm_item_p] 
 */

CREATE TABLE [dbo].[itm_item_p](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * INDEX: [xst_itm_itemprops_itemid] 
 */

CREATE INDEX [xst_itm_itemprops_itemid] ON [dbo].[itm_item_p]([organization_id], [item_id])
WITH FILLFACTOR = 80
go
/* 
 * TABLE: [dbo].[itm_item_prices] 
 */

CREATE TABLE [dbo].[itm_item_prices](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [level_code]       varchar(30) DEFAULT('*')       NOT NULL,
    [level_value]      varchar(60) DEFAULT('*')       NOT NULL,
    [itm_price_property_code]    varchar(60)       NOT NULL,
    [effective_date]   datetime          NOT NULL,
    [expiration_date]  datetime          NULL,
    [price]            decimal(17, 6)    NOT NULL,
    [price_qty]        decimal(11, 4)    DEFAULT 1 NOT NULL,
	[external_id]	   VARCHAR(60)		 NULL,
	[external_system]  VARCHAR(60)		 NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_prices] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [level_code], [level_value], [itm_price_property_code], [effective_date], [price_qty]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_itm_itemprices_expr] 
 */

CREATE INDEX [xst_itm_itemprices_expr] ON [dbo].[itm_item_prices]([expiration_date]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[itm_item_prices_p] 
 */

CREATE TABLE [dbo].[itm_item_prices_p](
    [organization_id]          int               NOT NULL,
    [item_id]                  varchar(60)       NOT NULL,
    [level_code]               varchar(30)       DEFAULT '*' NOT NULL,
    [level_value]              varchar(60)       DEFAULT '*' NOT NULL,
    [itm_price_property_code]  varchar(60)       NOT NULL,
    [effective_date]           datetime          NOT NULL,
    [price_qty]                decimal(11, 4)    DEFAULT 1 NOT NULL,
    [property_code]            varchar(30)       NOT NULL,
    [type]                     varchar(30)       NULL,
    [string_value]             varchar(max)      NULL,
    [date_value]               datetime          NULL,
    [decimal_value]            decimal(17, 6)    NULL,
    [create_date]              datetime          NULL,
    [create_user_id]           varchar(30)       NULL,
    [update_date]              datetime          NULL,
    [update_user_id]           varchar(30)       NULL,
    [record_state]             varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_prices_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [level_code], [level_value], [itm_price_property_code], [effective_date], [price_qty], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_prompt_properties] 
 */

CREATE TABLE [dbo].[itm_item_prompt_properties](
    [organization_id]			int            NOT NULL,
    [item_id]					varchar(60)    NOT NULL,
    [itm_prompt_property_code]	varchar(30)    NOT NULL,
    [org_code]					varchar(30)	   DEFAULT '*' NOT NULL,
    [org_value]					varchar(60)	   DEFAULT '*' NOT NULL,
    [code_group]				varchar(30)    NULL,
    [prompt_title_key]			varchar(60)    NULL,
    [prompt_msg_key]			varchar(60)    NULL,
    [required_flag]				bit            DEFAULT 0 NULL,
    [sort_order]				int            NULL,
    [prompt_mthd_code]			varchar(30)    NULL,
    [create_date]				datetime       NULL,
    [create_user_id]			varchar(30)    NULL,
    [update_date]				datetime       NULL,
    [update_user_id]			varchar(30)    NULL,
    [record_state]				varchar(30)    NULL,
    CONSTRAINT [pk_itm_item_prompt_properties] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [itm_prompt_property_code]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_itm_prmpt_prop_orgnode ON itm_item_prompt_properties (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_item_prompt_properties_p] 
 */

CREATE TABLE [dbo].[itm_item_prompt_properties_p](
    [organization_id]           int               NOT NULL,
    [item_id]                   varchar(60)       NOT NULL,
    [itm_prompt_property_code]  varchar(30)       NOT NULL,
    [property_code]             varchar(30)       NOT NULL,
    [type]                      varchar(30)       NULL,
    [string_value]              varchar(max)      NULL,
    [date_value]                datetime          NULL,
    [decimal_value]             decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pkitmitempromptpropertiesp] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [itm_prompt_property_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_restrict_calendar] 
 */

CREATE TABLE [dbo].[itm_item_restrict_calendar](
    [organization_id]       int            NOT NULL,
    [restriction_category]  varchar(30)    NOT NULL,
    [restriction_code]      varchar(60)    NOT NULL,
    [day_code]              varchar(3)     NOT NULL,
    [effective_date]        datetime       NOT NULL,
    [start_time]            datetime       NOT NULL,
    [sale_lineitm_typecode] varchar(30)    DEFAULT 'ANY' NOT NULL,
    [org_code]				varchar(30)	   DEFAULT '*' NOT NULL,
    [org_value]				varchar(60)	   DEFAULT '*' NOT NULL,
    [expiration_date]       datetime       NULL,
    [end_time]              datetime       NULL,
    [exemption_flag]        bit            DEFAULT '*' NOT NULL,
    [create_date]           datetime       NULL,
    [create_user_id]        varchar(30)    NULL,
    [update_date]           datetime       NULL,
    [update_user_id]        varchar(30)    NULL,
    [record_state]          varchar(30)    NULL,
    CONSTRAINT [pk_itm_item_restriction_cal] PRIMARY KEY CLUSTERED ([organization_id], [restriction_category], [restriction_code], [effective_date], [day_code], [start_time], [sale_lineitm_typecode]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_itm_restrctcal_orgnode ON itm_item_restrict_calendar (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_item_restrict_calendar_p] 
 */

CREATE TABLE [dbo].[itm_item_restrict_calendar_p](
    [organization_id]       int               NOT NULL,
    [restriction_category]  varchar(30)       NOT NULL,
    [restriction_code]      varchar(60)       NOT NULL,
    [effective_date]        datetime          NOT NULL,
    [day_code]              varchar(3)        NOT NULL,
    [start_time]            datetime          NOT NULL,
    [sale_lineitm_typecode] varchar(30)       DEFAULT 'ANY' NOT NULL,
    [property_code]         varchar(30)       NOT NULL,
    [type]                  varchar(30)       NULL,
    [string_value]          varchar(max)      NULL,
    [date_value]            datetime          NULL,
    [decimal_value]         decimal(17, 6)    NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pkitmitemrestrictcalendarp] PRIMARY KEY CLUSTERED ([organization_id], [restriction_category], [restriction_code], [effective_date], [day_code], [start_time], [sale_lineitm_typecode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_item_restrict_mapping] 
 */

CREATE TABLE [dbo].[itm_item_restrict_mapping](
    [organization_id]           int            NOT NULL,
    [merch_hierarchy_level]     varchar(60)    NOT NULL,
    [merch_hierarchy_id]        varchar(60)    NOT NULL,
    [restriction_category]      varchar(30)    NOT NULL,
    [org_code]                  varchar(30)    DEFAULT '*' NOT NULL,
    [org_value]                 varchar(60)    DEFAULT '*' NOT NULL,
    [create_date]           datetime       NULL,
    [create_user_id]        varchar(30)    NULL,
    [update_date]           datetime       NULL,
    [update_user_id]        varchar(30)    NULL,
    [record_state]          varchar(30)    NULL,
    CONSTRAINT [pk_itm_item_restrict_map] PRIMARY KEY CLUSTERED ([organization_id], [merch_hierarchy_level], [merch_hierarchy_id], [restriction_category]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_itm_restrctmap_orgnode ON itm_item_restrict_mapping (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_item_restrict_mapping_p] 
 */

CREATE TABLE [dbo].[itm_item_restrict_mapping_p](
    [organization_id]           int            NOT NULL,
    [merch_hierarchy_level]     varchar(60)    NOT NULL,
    [merch_hierarchy_id]        varchar(60)    NOT NULL,
    [restriction_category]      varchar(30)    NOT NULL,
    [property_code]         varchar(30)       NOT NULL,
    [type]                  varchar(30)       NULL,
    [string_value]          varchar(max)      NULL,
    [date_value]            datetime          NULL,
    [decimal_value]         decimal(17, 6)    NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_restrict_map_p] PRIMARY KEY CLUSTERED ([organization_id], [merch_hierarchy_level], [merch_hierarchy_id], [restriction_category], [property_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[itm_item_restriction] 
 */

CREATE TABLE [dbo].[itm_item_restriction](
    [organization_id]       int               NOT NULL,
    [restriction_category]  varchar(30)       NOT NULL,
    [restriction_code]      varchar(60)       NOT NULL,
    [effective_date]        datetime          NOT NULL,
    [sale_lineitm_typecode] varchar(30)       DEFAULT('ANY') NOT NULL,
    [property_name]         varchar(30)       DEFAULT('DEFAULT') NOT NULL,
    [org_code]				varchar(30) DEFAULT('*')		  NOT NULL,
    [org_value]				varchar(60) DEFAULT('*')		  NOT NULL,
    [expiration_date]       datetime          NULL,
    [boolean_value]         bit               NULL,
    [string_value]          varchar(254)      NULL,
    [date_value]            datetime          NULL,
    [decimal_value]         decimal(17, 6)    NULL,
    [on_calendar_flag]      bit               NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_restriction] PRIMARY KEY CLUSTERED ([organization_id], [restriction_category], [restriction_code], [effective_date], [sale_lineitm_typecode], [property_name]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_item_restrict_orgnode ON itm_item_restriction (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_item_restriction_p] 
 */

CREATE TABLE [dbo].[itm_item_restriction_p](
    [organization_id]       int               NOT NULL,
    [restriction_category]  varchar(30)       NOT NULL,
    [restriction_code]      varchar(60)       NOT NULL,
    [effective_date]        datetime          NOT NULL,
    [sale_lineitm_typecode] varchar(30)       DEFAULT 'ANY' NOT NULL,
    [property_name]         varchar(30)       DEFAULT 'DEFAULT' NOT NULL,
    [property_code]         varchar(30)       NOT NULL,
    [type]                  varchar(30)       NULL,
    [string_value]          varchar(max)      NULL,
    [date_value]            datetime          NULL,
    [decimal_value]         decimal(17, 6)    NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_itm_item_restriction_p] PRIMARY KEY CLUSTERED ([organization_id], [restriction_category], [restriction_code], [effective_date], [sale_lineitm_typecode], [property_name], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_kit_component] 
 */

CREATE TABLE [dbo].[itm_kit_component](
    [organization_id]    int            NOT NULL,
    [kit_item_id]        varchar(60)    NOT NULL,
    [component_item_id]  varchar(60)    NOT NULL,
    [seq_nbr]            int         DEFAULT 1        NOT NULL,
    [org_code]           varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]          varchar(60) DEFAULT('*')     NOT NULL,
    [display_order]      int            NULL,
    [quantity_per_kit]   int            NULL,
    [begin_datetime]     datetime       NULL,
    [end_datetime]       datetime       NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     varchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     varchar(30)    NULL,
    [record_state]       varchar(30)    NULL,
    CONSTRAINT [pk_itm_kit_component] PRIMARY KEY CLUSTERED ([organization_id], [kit_item_id], [component_item_id], [seq_nbr]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_kit_component_orgnode ON itm_kit_component (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_kit_component_p] 
 */

CREATE TABLE [dbo].[itm_kit_component_p](
    [organization_id]    int               NOT NULL,
    [kit_item_id]        varchar(60)       NOT NULL,
    [component_item_id]  varchar(60)       NOT NULL,
    [seq_nbr]            int               DEFAULT 1 NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_itm_kit_component_p] PRIMARY KEY CLUSTERED ([organization_id], [kit_item_id], [component_item_id], [seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_matrix_sort_order] 
 */

CREATE TABLE [dbo].[itm_matrix_sort_order](
    [organization_id]   int            NOT NULL,
    [matrix_sort_type]  varchar(60)    NOT NULL,
    [matrix_sort_id]    varchar(60)    NOT NULL,
    [org_code]          varchar(30)    DEFAULT '*' NOT NULL,
    [org_value]         varchar(60)    DEFAULT '*' NOT NULL,
    [sort_order]        int            NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [pk_itm_matrix_sort_order] PRIMARY KEY CLUSTERED ([organization_id], [matrix_sort_type], [matrix_sort_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_matrix_sortord_orgnode ON itm_matrix_sort_order (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_matrix_sort_order_p] 
 */

CREATE TABLE [dbo].[itm_matrix_sort_order_p](
    [organization_id]   int               NOT NULL,
    [matrix_sort_type]  varchar(60)       NOT NULL,
    [matrix_sort_id]    varchar(60)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_itm_matrix_sort_order_p] PRIMARY KEY CLUSTERED ([organization_id], [matrix_sort_type], [matrix_sort_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_merch_hierarchy] 
 */

CREATE TABLE [dbo].[itm_merch_hierarchy](
    [organization_id]  int             NOT NULL,
    [hierarchy_id]     varchar(60)     NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [parent_id]        varchar(60)     NULL,
    [level_code]       varchar(30)     NULL,
    [description]      varchar(254)    NULL,
    [sort_order]       int             NULL,
    [hidden_flag]      bit             DEFAULT 0 NULL,
    [disallow_matrix_display_flag]	bit DEFAULT 0 NULL,
    [item_matrix_color] varchar(20)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_itm_merch_hierarchy] PRIMARY KEY CLUSTERED ([organization_id], [hierarchy_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_merch_hirarchy_orgnode ON itm_merch_hierarchy (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_merch_hierarchy_p] 
 */

CREATE TABLE [dbo].[itm_merch_hierarchy_p](
    [organization_id]  int               NOT NULL,
    [hierarchy_id]     varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_merch_hierarchy_p] PRIMARY KEY CLUSTERED ([organization_id], [hierarchy_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_non_phys_item] 
 */

CREATE TABLE [dbo].[itm_non_phys_item](
    [organization_id]              int            NOT NULL,
    [item_id]                      varchar(60)    NOT NULL,
    [display_order]                int            NULL,
    [non_phys_item_typcode]        varchar(30)    NULL,
    [non_phys_item_subtype]        varchar(30)    NULL,
    [create_date]                  datetime       NULL,
    [create_user_id]               varchar(30)    NULL,
    [update_date]                  datetime       NULL,
    [update_user_id]               varchar(30)    NULL,
    [record_state]                 varchar(30)    NULL,
    CONSTRAINT [pk_itm_non_phys_item] PRIMARY KEY CLUSTERED ([organization_id], [item_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[itm_quick_items] 
 */

CREATE TABLE [dbo].[itm_quick_items](
    [organization_id]  int             NOT NULL,
    [item_id]          varchar(60)     NOT NULL,
    [parent_id]        varchar(60)     NULL,
    [org_code]         varchar(30)     DEFAULT '*' NOT NULL,
    [org_value]        varchar(60)     DEFAULT '*' NOT NULL,
    [image_url]        varchar(254)    NULL,
    [sort_order]       int             NULL,
    [description]      varchar(254)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [PK_itm_quick_items_1] PRIMARY KEY CLUSTERED ([organization_id], [item_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_quick_items_p] 
 */

CREATE TABLE [dbo].[itm_quick_items_p](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_quick_items_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_refund_schedule] 
 */

CREATE TABLE [dbo].[itm_refund_schedule](
    [organization_id]       int            NOT NULL,
    [item_id]               varchar(60)    NOT NULL,
    [org_code]            varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]           varchar(60) DEFAULT('*')    NOT NULL,
    [effective_date]        datetime       NOT NULL,
    [expiration_date]       datetime       NULL,
    [max_full_refund_time]  int            NULL,
    [min_no_refund_time]    int            NULL,
    [create_date]           datetime       NULL,
    [create_user_id]        varchar(30)    NULL,
    [update_date]           datetime       NULL,
    [update_user_id]        varchar(30)    NULL,
    [record_state]          varchar(30)    NULL,
    CONSTRAINT [PK_itm_refund_schedule] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [effective_date]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_refnd_schedule_orgnode ON itm_refund_schedule (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_refund_schedule_p] 
 */

CREATE TABLE [dbo].[itm_refund_schedule_p](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [effective_date]   datetime          NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_refund_schedule_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [effective_date], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_restrict_gs1] 
 */

CREATE TABLE [dbo].[itm_restrict_gs1](
    [organization_id]  int            NOT NULL,
    [item_id]          varchar(60)    NOT NULL,
    [field_id]         varchar(10)    NOT NULL,
    [ai_type]          varchar(30)    NOT NULL,
    [start_value]      varchar(50)    NOT NULL,
    [end_value]        varchar(50)    NOT NULL,
    [org_code]         varchar(30)    NOT NULL,
    [org_value]        varchar(60)    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_itm_restrict_gs1] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [field_id], [start_value])
    WITH FILLFACTOR = 80
)
go



/* 
 * INDEX: [idx_itm_restrict_gs1] 
 */

CREATE INDEX [idx_itm_restrict_gs1] ON [dbo].[itm_restrict_gs1]([org_code], [org_value])
WITH FILLFACTOR = 80
go
/* 
 * TABLE: [dbo].[itm_restrict_gs1_p] 
 */

CREATE TABLE [dbo].[itm_restrict_gs1_p](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [field_id]         varchar(10)       NOT NULL,
    [start_value]      varchar(50)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_restrict_gs1_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [field_id], [start_value], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_substitute_items] 
 */

CREATE TABLE [dbo].[itm_substitute_items](
    [organization_id]     int            NOT NULL,
    [primary_item_id]     varchar(60)    NOT NULL,
    [substitute_item_id]  varchar(60)    NOT NULL,
    [level_code]	      varchar(30) DEFAULT('*')    NOT NULL,
    [level_value]	      varchar(60) DEFAULT('*')    NOT NULL,
	[BEGIN_DATETIME]	  datetime		 null,
	[END_DATETIME]		  datetime		 null,
	[EXTERNAL_ID]		  VARCHAR(60)	 null,
	[EXTERNAL_SYSTEM]	  VARCHAR(60)	 null,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_itm_substitute_items] PRIMARY KEY CLUSTERED ([organization_id], [primary_item_id], [substitute_item_id], [level_code], [level_value]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_sub_items_orgnode ON itm_substitute_items (level_code,level_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_substitute_items_p] 
 */

CREATE TABLE [dbo].[itm_substitute_items_p](
    [organization_id]     int               NOT NULL,
    [primary_item_id]     varchar(60)       NOT NULL,
    [substitute_item_id]  varchar(60)       NOT NULL,
    [level_code]	      varchar(30) DEFAULT('*')    NOT NULL,
    [level_value]	      varchar(60) DEFAULT('*')    NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_itm_substitute_items_p] PRIMARY KEY CLUSTERED ([organization_id], [primary_item_id], [substitute_item_id], [level_code], [level_value], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_vendor] 
 */

CREATE TABLE [dbo].[itm_vendor](
    [organization_id]    int             NOT NULL,
    [vendor_id]          varchar(60)     NOT NULL,
    [org_code]		     varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]		     varchar(60) DEFAULT('*')     NOT NULL,
    [name]               varchar(254)    NULL,
    [buyer]              varchar(254)    NULL,
    [address_id]         varchar(60)     NULL,
    [telephone]          varchar(32)     NULL,
    [contact_telephone]  varchar(32)     NULL,
    [typcode]            varchar(30)     NULL,
    [contact]            varchar(254)    NULL,
    [fax]                varchar(32)     NULL,
    [status]             varchar(30)     NULL,
    [create_date]        datetime        NULL,
    [create_user_id]     varchar(30)     NULL,
    [update_date]        datetime        NULL,
    [update_user_id]     varchar(30)     NULL,
    [record_state]       varchar(30)     NULL,
    CONSTRAINT [pk_itm_vendor] PRIMARY KEY CLUSTERED ([organization_id], [vendor_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_itm_vendor_orgnode ON itm_vendor (org_code,org_value) WITH (FILLFACTOR = 80)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[itm_vendor] TO hhlookupusers
go

/* 
 * TABLE: [dbo].[itm_vendor_p] 
 */

CREATE TABLE [dbo].[itm_vendor_p](
    [organization_id]  int               NOT NULL,
    [vendor_id]        varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_itm_vendor_p] PRIMARY KEY CLUSTERED ([organization_id], [vendor_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_warranty] 
 */

CREATE TABLE [dbo].[itm_warranty](
    [organization_id]                 int               NOT NULL,
    [warranty_typcode]                varchar(60)       NOT NULL,
    [warranty_nbr]                    varchar(30)       NOT NULL,
    [warranty_plan_id]                varchar(60)       NULL,
    [warranty_issue_date]             datetime          NULL,
    [warranty_expiration_date]        datetime          NULL,
    [status_code]                     varchar(30)       NULL,
    [purchase_price]                  decimal(17, 6)    NULL,
    [cust_id]                         varchar(60)       NULL,
    [party_id]                        bigint            NULL,
    [certificate_nbr]                 varchar(60)       NULL,
    [certificate_company_name]        varchar(254)      NULL,
    [warranty_item_id]                varchar(60)       NULL,
    [warranty_line_business_date]     datetime          NULL,
    [warranty_line_rtl_loc_id]        int               NULL,
    [warranty_line_wkstn_id]          bigint            NULL,
    [warranty_line_trans_seq]         bigint            NULL,
    [warranty_rtrans_lineitm_seq]     int               NULL,
    [covered_item_id]                 varchar(60)       NULL,
    [covered_line_business_date]      datetime          NULL,
    [covered_line_rtl_loc_id]         int               NULL,
    [covered_line_wkstn_id]           bigint            NULL,
    [covered_line_trans_seq]          bigint            NULL,
    [covered_rtrans_lineitm_seq]      int               NULL,
    [covered_item_purchase_date]      datetime          NULL,
    [covered_item_purchase_price]     decimal(17, 6)    NULL,
    [covered_item_purchase_location]  varchar(254)      NULL,
    [create_date]                     datetime          NULL,
    [create_user_id]                  varchar(30)       NULL,
    [update_date]                     datetime          NULL,
    [update_user_id]                  varchar(30)       NULL,
    [record_state]                    varchar(30)       NULL,
    CONSTRAINT [pk_itm_warranty] PRIMARY KEY CLUSTERED ([organization_id], [warranty_typcode], [warranty_nbr]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX idx_itm_warranty01 ON dbo.itm_warranty(party_id) WITH (FILLFACTOR = 80);
GO


/* 
 * TABLE: [dbo].[itm_warranty_item] 
 */

CREATE TABLE [dbo].[itm_warranty_item](
    [organization_id]            int               NOT NULL,
    [item_id]                    varchar(60)       NOT NULL,
    [pricing_mthd_code]          varchar(60)       NULL,
    [warranty_price_amt]         decimal(17, 6)    NULL,
    [warranty_price_percentage]  decimal(6, 4)     NULL,
    [warranty_min_price_amt]     decimal(17, 6)    NULL,
    [expiration_days]            int               NULL,
    [service_days]               int               NULL,
    [renewable_flag]             bit               DEFAULT ((0)) NULL,
    [create_date]                datetime          NULL,
    [create_user_id]             varchar(30)       NULL,
    [update_date]                datetime          NULL,
    [update_user_id]             varchar(30)       NULL,
    [record_state]               varchar(30)       NULL,
    CONSTRAINT [pk_itm_warranty_item] PRIMARY KEY CLUSTERED ([organization_id], [item_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[itm_warranty_item_price] 
 */

CREATE TABLE [dbo].[itm_warranty_item_price](
    [organization_id]     int               NOT NULL,
    [item_id]             varchar(60)       NOT NULL,
    [warranty_price_seq]  int               NOT NULL,
    [org_code]		      varchar(30) DEFAULT('*')	    NOT NULL,
    [org_value]			  varchar(60) DEFAULT('*')		NOT NULL,
    [min_item_price_amt]  decimal(17, 6)    NULL,
    [max_item_price_amt]  decimal(17, 6)    NULL,
    [price_amt]           decimal(17, 6)    NULL,
    [price_percentage]    decimal(6, 4)     NULL,
    [min_price_amt]       decimal(17, 6)    NULL,
    [ref_item_id]         varchar(60)       NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_itm_warranty_item_price] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [warranty_price_seq]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idxitmwarrantyitempriceorgnode ON itm_warranty_item_price (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_warranty_item_price_p] 
 */

CREATE TABLE [dbo].[itm_warranty_item_price_p](
    [organization_id]     int               NOT NULL,
    [item_id]             varchar(60)       NOT NULL,
    [warranty_price_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_itm_warranty_item_price_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [warranty_price_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_warranty_item_xref] 
 */

CREATE TABLE [dbo].[itm_warranty_item_xref](
    [organization_id]   int            NOT NULL,
    [item_id]           varchar(60)    NOT NULL,
    [warranty_typcode]  varchar(60)    NOT NULL,
    [warranty_item_id]  varchar(60)    NOT NULL,
    [org_code]          varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]         varchar(60) DEFAULT('*')    NOT NULL,
    [sort_order]        int            NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [pk_itm_warranty_item_xref] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [warranty_typcode], [warranty_item_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idxitmwarrantyitemxreforgnode ON itm_warranty_item_xref (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[itm_warranty_item_xref_p] 
 */

CREATE TABLE [dbo].[itm_warranty_item_xref_p](
    [organization_id]   int               NOT NULL,
    [item_id]           varchar(60)       NOT NULL,
    [warranty_typcode]  varchar(60)       NOT NULL,
    [warranty_item_id]  varchar(60)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_itm_warranty_item_xref_p] PRIMARY KEY CLUSTERED ([organization_id], [item_id], [warranty_typcode], [warranty_item_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_warranty_journal] 
 */

CREATE TABLE [dbo].[itm_warranty_journal](
    [organization_id]              int               NOT NULL,
    [warranty_typcode]             varchar(60)       NOT NULL,
    [warranty_nbr]                 varchar(30)       NOT NULL,
    [journal_seq]                  bigint            NOT NULL,
    [org_code]					   varchar(30) DEFAULT('*')		 NOT NULL,
    [org_value]				       varchar(60) DEFAULT('*')		 NOT NULL,
    [trans_business_date]          datetime          NULL,
    [trans_rtl_loc_id]             int               NULL,
    [trans_wkstn_id]               bigint            NULL,
    [trans_trans_seq]              bigint            NULL,
    [warranty_plan_id]             varchar(60)       NULL,
    [warranty_issue_date]          datetime          NULL,
    [warranty_expiration_date]     datetime          NULL,
    [status_code]                  varchar(30)       NULL,
    [purchase_price]               decimal(17, 6)    NULL,
    [cust_id]                      varchar(60)       NULL,
    [party_id]                     bigint            NULL,
    [certificate_nbr]              varchar(60)       NULL,
    [certificate_company_name]     varchar(254)      NULL,
    [warranty_item_id]             varchar(60)       NULL,
    [warranty_line_business_date]  datetime          NULL,
    [warranty_line_rtl_loc_id]     int               NULL,
    [warranty_line_wkstn_id]       bigint            NULL,
    [warranty_line_trans_seq]      bigint            NULL,
    [warranty_rtrans_lineitm_seq]  int               NULL,
    [covered_item_id]              varchar(60)       NULL,
    [covered_line_business_date]   datetime          NULL,
    [covered_line_rtl_loc_id]      int               NULL,
    [covered_line_wkstn_id]        bigint            NULL,
    [covered_line_trans_seq]       bigint            NULL,
    [covered_rtrans_lineitm_seq]   int               NULL,
    [create_date]                  datetime          NULL,
    [create_user_id]               varchar(30)       NULL,
    [update_date]                  datetime          NULL,
    [update_user_id]               varchar(30)       NULL,
    [record_state]                 varchar(30)       NULL,
    CONSTRAINT [pk_itm_warranty_journal] PRIMARY KEY CLUSTERED ([organization_id], [warranty_typcode], [warranty_nbr], [journal_seq]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX idx_itm_warranty_journal01 ON dbo.itm_warranty_journal(party_id) WITH (FILLFACTOR = 80);
GO

CREATE INDEX idxitmwarrantyjournalorgnode ON itm_warranty_journal (org_code,org_value) WITH (FILLFACTOR = 80)
GO

/* 
 * TABLE: [dbo].[itm_warranty_journal_p] 
 */

CREATE TABLE [dbo].[itm_warranty_journal_p](
    [organization_id]   int               NOT NULL,
    [warranty_typcode]  varchar(60)       NOT NULL,
    [warranty_nbr]      varchar(30)       NOT NULL,
    [journal_seq]       bigint            NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_itm_warranty_journal_p] PRIMARY KEY CLUSTERED ([organization_id], [warranty_typcode], [warranty_nbr], [journal_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[itm_warranty_p] 
 */

CREATE TABLE [dbo].[itm_warranty_p](
    [organization_id]   int               NOT NULL,
    [warranty_typcode]  varchar(60)       NOT NULL,
    [warranty_nbr]      varchar(30)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_itm_warranty_p] PRIMARY KEY CLUSTERED ([organization_id], [warranty_typcode], [warranty_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_close_dates] 
 */

CREATE TABLE [dbo].[loc_close_dates](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [close_date]       datetime        NOT NULL,
    [reason_code]      varchar(254)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_loc_close_dates] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [close_date]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[loc_close_dates_p] 
 */

CREATE TABLE [dbo].[loc_close_dates_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [close_date]       datetime          NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_loc_close_dates_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [close_date], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_closing_message] 
 */

CREATE TABLE [dbo].[loc_closing_message](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [closing_message]  varchar(254)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_loc_closing_message] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[loc_closing_message_p] 
 */

CREATE TABLE [dbo].[loc_closing_message_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_loc_closing_message_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_cycle_question_answers] 
 */

CREATE TABLE [dbo].[loc_cycle_question_answers](
    [organization_id]   int            NOT NULL,
    [question_id]       varchar(60)    NOT NULL,
    [answer_id]         varchar(60)    NOT NULL,
    [answer_timestamp]  datetime       NOT NULL,
    [rtl_loc_id]        int            NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [pk_loc_cycle_question_answers] PRIMARY KEY CLUSTERED ([organization_id], [question_id], [answer_id], [answer_timestamp]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[loc_cycle_question_answers_p] 
 */

CREATE TABLE [dbo].[loc_cycle_question_answers_p](
    [organization_id]   int               NOT NULL,
    [question_id]       varchar(60)       NOT NULL,
    [answer_id]         varchar(60)       NOT NULL,
    [answer_timestamp]  datetime          NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pkloccyclequestionanswersp] PRIMARY KEY CLUSTERED ([organization_id], [question_id], [answer_id], [answer_timestamp], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_cycle_question_choices] 
 */

CREATE TABLE [dbo].[loc_cycle_question_choices](
    [organization_id]  int             NOT NULL,
    [question_id]      varchar(60)     NOT NULL,
    [answer_id]        varchar(60)     NOT NULL,
    [answer_text_key]  varchar(max)    NULL,
    [sort_order]       int             NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_loc_cycle_question_choices] PRIMARY KEY CLUSTERED ([organization_id], [question_id], [answer_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[loc_cycle_question_choices_p] 
 */

CREATE TABLE [dbo].[loc_cycle_question_choices_p](
    [organization_id]  int               NOT NULL,
    [question_id]      varchar(60)       NOT NULL,
    [answer_id]        varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pkloccyclequestionchoicesp] PRIMARY KEY CLUSTERED ([organization_id], [question_id], [answer_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_cycle_questions] 
 */

CREATE TABLE [dbo].[loc_cycle_questions](
    [organization_id]         int             NOT NULL,
    [question_id]             varchar(60)     NOT NULL,
    [question_text_key]       varchar(254)    NULL,
    [sort_order]              int             NULL,
    [effective_datetime]      datetime        NULL,
    [expiration_datetime]     datetime        NULL,
    [rtl_loc_id]              int             DEFAULT ((0)) NULL,
    [corporate_message_flag]  bit             DEFAULT ((0)) NULL,
    [question_typcode]        varchar(30)     NULL,
    [create_date]             datetime        NULL,
    [create_user_id]          varchar(30)     NULL,
    [update_date]             datetime        NULL,
    [update_user_id]          varchar(30)     NULL,
    [record_state]            varchar(30)     NULL,
    CONSTRAINT [pk_loc_cycle_questions] PRIMARY KEY CLUSTERED ([organization_id], [question_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[loc_cycle_questions_p] 
 */

CREATE TABLE [dbo].[loc_cycle_questions_p](
    [organization_id]  int               NOT NULL,
    [question_id]      varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_loc_cycle_questions_p] PRIMARY KEY CLUSTERED ([organization_id], [question_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_org_hierarchy] 
 */

CREATE TABLE [dbo].[loc_org_hierarchy](
    [organization_id]  int             NOT NULL,
    [org_code]         varchar(30)     NOT NULL,
    [org_value]        varchar(60)     NOT NULL,
    [parent_code]      varchar(30)     NULL,
    [parent_value]     varchar(60)     NULL,
    [description]      varchar(254)    NULL,
    [level_mgr]        varchar(254)    NULL,
    [level_order]      int             NULL,
    [sort_order]       int             NULL,
    [inactive_flag]	   bit		DEFAULT 0 NOT NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_loc_org_hierarchy] PRIMARY KEY CLUSTERED ([organization_id], [org_code], [org_value]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_loc_orghier_lvlmgr] 
 */

CREATE INDEX [xst_loc_orghier_lvlmgr] ON [dbo].[loc_org_hierarchy]([level_mgr]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_loc_orghier_lvlorder] 
 */

CREATE INDEX [xst_loc_orghier_lvlorder] ON [dbo].[loc_org_hierarchy]([level_order]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_loc_orghier_parent] 
 */

CREATE INDEX [xst_loc_orghier_parent] ON [dbo].[loc_org_hierarchy]([parent_code], [parent_value]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_loc_orghier_sortorder] 
 */

CREATE INDEX [xst_loc_orghier_sortorder] ON [dbo].[loc_org_hierarchy]([sort_order]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[loc_org_hierarchy_p] 
 */

CREATE TABLE [dbo].[loc_org_hierarchy_p](
    [organization_id]  int               NOT NULL,
    [org_code]         varchar(30)       NOT NULL,
    [org_value]        varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_loc_org_hierarchy_p] PRIMARY KEY CLUSTERED ([organization_id], [org_code], [org_value], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_pricing_hierarchy] 
 */

CREATE TABLE [dbo].[loc_pricing_hierarchy](
    [organization_id]  int             NOT NULL,
    [level_code]       varchar(30)     NOT NULL,
    [level_value]      varchar(60)     NOT NULL,
    [parent_code]      varchar(30)     NULL,
    [parent_value]     varchar(60)     NULL,
    [description]      varchar(254)    NULL,
    [level_order]      int             NULL,
    [sort_order]       int             NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_loc_pricing_hierarchy] PRIMARY KEY CLUSTERED ([organization_id], [level_code], [level_value]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_loc_pricehier_lvlorder] 
 */

CREATE INDEX [xst_loc_pricehier_lvlorder] ON [dbo].[loc_pricing_hierarchy]([level_order]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_loc_pricehier_parent] 
 */

CREATE INDEX [xst_loc_pricehier_parent] ON [dbo].[loc_pricing_hierarchy]([parent_code], [parent_value]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [xst_loc_pricehier_sortorder] 
 */

CREATE INDEX [xst_loc_pricehier_sortorder] ON [dbo].[loc_pricing_hierarchy]([sort_order]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[loc_pricing_hierarchy_p] 
 */

CREATE TABLE [dbo].[loc_pricing_hierarchy_p](
    [organization_id]  int               NOT NULL,
    [level_code]       varchar(30)       NOT NULL,
    [level_value]      varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_loc_pricing_hierarchy_p] PRIMARY KEY CLUSTERED ([organization_id], [level_code], [level_value], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_rtl_loc] 
 */

CREATE TABLE [dbo].[loc_rtl_loc](
    [organization_id]          int               NOT NULL,
    [rtl_loc_id]               int               NOT NULL,
    [store_name]               varchar(254)      NULL,
    [address1]                 varchar(254)      NULL,
    [address2]                 varchar(254)      NULL,
    [address3]                 varchar(254)      NULL,
    [address4]                 varchar(254)      NULL,
    [city]                     varchar(254)      NULL,
    [state]                    varchar(30)       NULL,
    [district]                 varchar(30)       NULL,
    [area]                     varchar(30)       NULL,
    [postal_code]              varchar(30)       NULL,
    [country]                  varchar(2)        NULL,
    [neighborhood]             varchar(254)      NULL,
    [county]                   varchar(254)      NULL,
    [locale]                   varchar(30)       NULL,
    [currency_id]              varchar(3)        NULL,
    [latitude]                 decimal(17, 6)    NULL,
    [longitude]                decimal(17, 6)    NULL,
    [telephone1]               varchar(32)       NULL,
    [telephone2]               varchar(32)       NULL,
    [telephone3]               varchar(32)       NULL,
    [telephone4]               varchar(32)       NULL,
    [description]              varchar(254)      NULL,
    [store_nbr]                varchar(254)      NULL,
    [apartment]                varchar(30)       NULL,
    [store_manager]            varchar(254)      NULL,
    [email_addr]               varchar(254)      NULL,
    [default_tax_percentage]   decimal(8, 6)     NULL,
    [location_type]            varchar(60)       NULL,
    [delivery_available_flag]  bit               DEFAULT ((0)) NOT NULL,
    [pickup_available_flag]    bit               DEFAULT ((0)) NOT NULL,
    [transfer_available_flag]  bit               DEFAULT ((0)) NOT NULL,
    [geo_code]                 varchar(20)       NULL,
    [uez_flag]                 bit               DEFAULT ((0)) NOT NULL,
    [alternate_store_nbr]      varchar(254)      NULL,
    [use_till_accountability_flag] bit           DEFAULT ((0)) NOT NULL,
    [deposit_bank_name]        varchar(254)      NULL,
    [deposit_bank_account_number] varchar(30)    NULL,
    [airport_code]             varchar(3)        NULL,
    [create_date]              datetime          NULL,
    [create_user_id]           varchar(30)       NULL,
    [update_date]              datetime          NULL,
    [update_user_id]           varchar(30)       NULL,
    [record_state]             varchar(30)       NULL,
    CONSTRAINT [pk_loc_rtl_loc] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id]) WITH (FILLFACTOR = 80)
)
go


IF EXISTS (Select 1 From sys.database_principals where type = 'R' and name = 'hhlookupusers')
	GRANT SELECT ON [dbo].[loc_rtl_loc] TO hhlookupusers
go

/* 
 * TABLE: [dbo].[loc_rtl_loc_p] 
 */

CREATE TABLE [dbo].[loc_rtl_loc_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_loc_rtl_loc_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_state_journal] 
 */

CREATE TABLE [dbo].[loc_state_journal](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [wkstn_id]          bigint            NOT NULL,
    [status_typcode]    varchar(30)       NOT NULL,
    [state_journal_id]  varchar(60)       NOT NULL,
    [time_stamp]        datetime          NULL,
    [date_value]        datetime          NULL,
    [string_value]      varchar(30)       NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_loc_state_journal] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [status_typcode], [state_journal_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_loc_statejournal_time] 
 */

CREATE INDEX [xst_loc_statejournal_time] ON [dbo].[loc_state_journal]([time_stamp]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[loc_state_journal_p] 
 */

CREATE TABLE [dbo].[loc_state_journal_p](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [wkstn_id]          bigint            NOT NULL,
    [status_typcode]    varchar(30)       NOT NULL,
    [state_journal_id]  varchar(60)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_loc_state_journal_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [status_typcode], [state_journal_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[loc_wkstn] 
 */

CREATE TABLE [dbo].[loc_wkstn](
    [organization_id]  int            NOT NULL,
    [rtl_loc_id]       int            NOT NULL,
    [wkstn_id]         bigint         NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_loc_wkstn] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[loc_wkstn_p] 
 */

CREATE TABLE [dbo].[loc_wkstn_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_loc_wkstn_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[log_sp_report] 
 */

CREATE TABLE [dbo].[log_sp_report](
    [job_id]         int         NOT NULL,
    [loc_id]         int         NOT NULL,
    [business_date]  datetime    NOT NULL,
    [start_dt]       datetime    NULL,
    [end_dt]         datetime    NULL,
    [completed]      int         NULL,
    [expected]       int         NULL,
    [job_start]      datetime    NOT NULL,
    [job_end]        datetime    NULL,
    CONSTRAINT [PK_log_sp_report] PRIMARY KEY CLUSTERED ([job_id], [loc_id], [business_date], [job_start])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[prc_deal] 
 */

CREATE TABLE [dbo].[prc_deal](
    [organization_id]              int               NOT NULL,
    [deal_id]                      varchar(60)       NOT NULL,
    [org_code]                     varchar(30)       DEFAULT ('*') NOT NULL,
    [org_value]                    varchar(60)       DEFAULT ('*') NOT NULL,
    [description]                  varchar(128)      NULL,
    [consumable]                   bit               DEFAULT ((0)) NULL,
    [act_deferred]                 bit               DEFAULT ((0)) NULL,
    [effective_date]               datetime          NULL,
    [end_date]                     datetime          NULL,
    [start_time]                   datetime          NULL,
    [end_time]                     datetime          NULL,
    [generosity_cap]               decimal(17, 6)    NULL,
    [iteration_cap]                int               NULL,
    [priority_nudge]               int               NULL,
    [subtotal_min]                 decimal(17, 6)    NULL,
    [subtotal_max]                 decimal(17, 6)    NULL,
    [trwide_action]                varchar(30)       NULL,
    [trwide_amount]                decimal(17, 6)    NULL,
    [taxability_code]              varchar(30)       NULL,
    [promotion_id]                 varchar(60)       NULL,
    [higher_nonaction_amt_flag]    bit               DEFAULT ((0)) NULL,
    [exclude_price_override_flag]  bit               DEFAULT ((0)) NULL,
    [exclude_discounted_flag]      bit               DEFAULT ((0)) NULL,
    [targeted_flag]                bit               DEFAULT ((0)) NULL,
    [week_sched_flag]              bit               NULL,
	[sort_order]				   int				 DEFAULT ((0)) NOT NULL,
	[type]						   varchar(60)		 NULL,
	[group_id]					   varchar(60)		 NULL,
    [create_date]                  datetime          NULL,
    [create_user_id]               varchar(30)       NULL,
    [update_date]                  datetime          NULL,
    [update_user_id]               varchar(30)       NULL,
    [record_state]                 varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal] PRIMARY KEY CLUSTERED ([organization_id], [deal_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_prc_deal_orgnode ON prc_deal (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[prc_deal_cust_groups] 
 */

CREATE TABLE [dbo].[prc_deal_cust_groups](
    [organization_id]  int            NOT NULL,
    [deal_id]          varchar(60)    NOT NULL,
    [cust_group_id]    varchar(60)    NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_prc_deal_cust_groups] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [cust_group_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_prc_deal_custgroupsorgnode ON prc_deal_cust_groups (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[prc_deal_cust_groups_p] 
 */

CREATE TABLE [dbo].[prc_deal_cust_groups_p](
    [organization_id]  int               NOT NULL,
    [deal_id]          varchar(60)       NOT NULL,
    [cust_group_id]    varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal_cust_groups_p] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [cust_group_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[prc_deal_document_xref] 
 */

CREATE TABLE [dbo].[prc_deal_document_xref](
    [organization_id]  int            NOT NULL,
    [deal_id]          varchar(60)    NOT NULL,
    [series_id]        varchar(60)    NOT NULL,
    [document_type]    varchar(30)    NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_prc_deal_document_xref] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [series_id], [document_type]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_prc_deal_doc_xref_orgnode ON prc_deal_document_xref (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[prc_deal_document_xref_p] 
 */

CREATE TABLE [dbo].[prc_deal_document_xref_p](
    [organization_id]  int               NOT NULL,
    [deal_id]          varchar(60)       NOT NULL,
    [series_id]        varchar(60)       NOT NULL,
    [document_type]    varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal_document_xref_p] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [series_id], [document_type], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[prc_deal_field_test] 
 */

CREATE TABLE [dbo].[prc_deal_field_test](
    [organization_id]       int             NOT NULL,
    [deal_id]               varchar(60)     NOT NULL,
    [item_ordinal]          int             NOT NULL,
    [item_condition_group]  int             NOT NULL,
    [item_condition_seq]    int             NOT NULL,
    [org_code]		        varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]		   varchar(60) DEFAULT('*')     NOT NULL,
    [item_field]            varchar(60)     NOT NULL,
    [match_rule]            varchar(20)     NOT NULL,
    [value1]                varchar(128)    NOT NULL,
    [value2]                varchar(128)    NULL,
    [create_date]           datetime        NULL,
    [create_user_id]        varchar(30)     NULL,
    [update_date]           datetime        NULL,
    [update_user_id]        varchar(30)     NULL,
    [record_state]          varchar(30)     NULL,
    CONSTRAINT [pk_prc_deal_field_test] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [item_ordinal], [item_condition_group], [item_condition_seq]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_prc_deal_field_tst_orgnode ON prc_deal_field_test (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[prc_deal_field_test_p] 
 */

CREATE TABLE [dbo].[prc_deal_field_test_p](
    [organization_id]       int               NOT NULL,
    [deal_id]               varchar(60)       NOT NULL,
    [item_ordinal]          int               NOT NULL,
    [item_condition_group]  int               NOT NULL,
    [item_condition_seq]    int               NOT NULL,
    [property_code]         varchar(30)       NOT NULL,
    [type]                  varchar(30)       NULL,
    [string_value]          varchar(max)      NULL,
    [date_value]            datetime          NULL,
    [decimal_value]         decimal(17, 6)    NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal_field_test_p] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [item_ordinal], [item_condition_group], [item_condition_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[prc_deal_item] 
 */

CREATE TABLE [dbo].[prc_deal_item](
    [organization_id]      int               NOT NULL,
    [deal_id]              varchar(60)       NOT NULL,
    [item_ordinal]         int               NOT NULL,
    [org_code]             varchar(30)       DEFAULT('*') NOT NULL,
    [org_value]            varchar(60)       DEFAULT('*') NOT NULL,
    [consumable]           bit               NULL,
    [qty_min]              decimal(17, 4)    NULL,
    [qty_max]              decimal(17, 4)    NULL,
    [min_item_total]       decimal(17, 6)    NULL,
    [deal_action]          varchar(30)       NULL,
    [action_arg]           decimal(17, 6)    NULL,
    [action_arg_qty]       decimal(17, 4)    NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal_item] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [item_ordinal]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_prc_deal_item_orgnode ON prc_deal_item (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[prc_deal_item_p] 
 */

CREATE TABLE [dbo].[prc_deal_item_p](
    [organization_id]  int               NOT NULL,
    [deal_id]          varchar(60)       NOT NULL,
    [item_ordinal]     int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal_item_p] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [item_ordinal], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[prc_deal_p] 
 */

CREATE TABLE [dbo].[prc_deal_p](
    [organization_id]  int               NOT NULL,
    [deal_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal_p] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[prc_deal_trig] 
 */

CREATE TABLE [dbo].[prc_deal_trig](
    [organization_id]  int             NOT NULL,
    [deal_id]          varchar(60)     NOT NULL,
    [deal_trigger]     varchar(128)    NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_prc_deal_trig] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [deal_trigger]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_prc_deal_trig_orgnode ON prc_deal_trig (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[prc_deal_trig_p] 
 */

CREATE TABLE [dbo].[prc_deal_trig_p](
    [organization_id]  int               NOT NULL,
    [deal_id]          varchar(60)       NOT NULL,
    [deal_trigger]     varchar(128)      NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal_trig_p] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [deal_trigger], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[prc_deal_week] 
 */

CREATE TABLE [dbo].[prc_deal_week](
    [organization_id]  int            NOT NULL,
    [deal_id]          varchar(60)    NOT NULL,
    [day_code]         varchar(3)     NOT NULL,
    [start_time]       datetime       NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')    NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')    NOT NULL,
    [end_time]         datetime       NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_prc_deal_week] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [day_code], [start_time]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_prc_deal_week_orgnode ON prc_deal_week (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[prc_deal_week_p] 
 */

CREATE TABLE [dbo].[prc_deal_week_p](
    [organization_id]  int               NOT NULL,
    [deal_id]          varchar(60)       NOT NULL,
    [day_code]         varchar(3)        NOT NULL,
    [start_time]       datetime          NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_prc_deal_week_p] PRIMARY KEY CLUSTERED ([organization_id], [deal_id], [day_code], [start_time], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[rms_diff_group_detail] 
 */

CREATE TABLE [dbo].[rms_diff_group_detail](
    [organization_id]  int              NOT NULL,
    [diff_group_id]    varchar(10)      NOT NULL,
    [diff_id]          varchar(10)      NOT NULL,
    [display_seq]      numeric(4, 0)    NULL,
    [create_date]      datetime         NULL,
    [update_date]      datetime         NULL,
    CONSTRAINT [pk_rms_diff_group_detail] PRIMARY KEY CLUSTERED ([organization_id], [diff_group_id], [diff_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[rms_diff_group_head] 
 */

CREATE TABLE [dbo].[rms_diff_group_head](
    [organization_id]  int             NOT NULL,
    [diff_group_id]    varchar(10)     NOT NULL,
    [diff_type]        varchar(6)      NOT NULL,
    [diff_group_desc]  varchar(120)    NOT NULL,
    [create_date]      datetime        NULL,
    [update_date]      datetime        NULL,
    CONSTRAINT [pk_rms_diff_group_head] PRIMARY KEY CLUSTERED ([organization_id], [diff_group_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[rms_diff_ids] 
 */

CREATE TABLE [dbo].[rms_diff_ids](
    [organization_id]  int             NOT NULL,
    [diff_id]          varchar(10)     NOT NULL,
    [diff_desc]        varchar(120)    NULL,
    [diff_type]        varchar(6)      NOT NULL,
    [diff_type_desc]   varchar(120)    NULL,
    [create_date]      datetime        NULL,
    [update_date]      datetime        NULL,
    CONSTRAINT [pk_rms_diff_ids] PRIMARY KEY CLUSTERED ([organization_id], [diff_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[rms_related_item_head] 
 */

CREATE TABLE [dbo].[rms_related_item_head](
    [organization_id]    int               NOT NULL,
    [relationship_id]    numeric(20, 0)    NOT NULL,
    [item]               varchar(25)       NOT NULL,
    [location]           VARCHAR(10)	   NOT NULL,
    [relationship_name]  varchar(255)      NOT NULL,
    [relationship_type]  varchar(6)        NOT NULL,
    [mandatory_ind]      varchar(1)        NOT NULL,
    [create_date]        datetime          NULL,
    [update_date]        datetime          NULL,
    CONSTRAINT [pk_rms_related_item_head] PRIMARY KEY CLUSTERED ([organization_id], [relationship_id], [location])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[rpt_fifo] 
 */

CREATE TABLE [dbo].[rpt_fifo](
    [organization_id]			int               NOT NULL,
    [item_id]					varchar(60)       NOT NULL,
    [description]				varchar(254)      NULL,
    [style_id]					varchar(60)       NULL,
    [style_desc]         		varchar(254)      NULL,
    [rtl_loc_id]				int               NOT NULL,
    [store_name]				varchar(254)      NULL,
    [unit_count]				decimal(14, 4)    NULL,
    [unit_cost]				decimal(17, 6)    NULL,
    [user_name]				varchar(30)       NOT NULL,
    [comment]					varchar(254)      NULL,
    [create_date]				datetime          NULL,
    [create_user_id]			varchar(30)       NULL,
    [update_date]				datetime          NULL,
    [update_user_id]			varchar(30)       NULL,
    [record_state]				varchar(30)       NULL,
    CONSTRAINT [pk_rpt_fifo] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [item_id],[user_name]) WITH (FILLFACTOR = 80)
)
go


/* 
 * TABLE: [dbo].[rpt_fifo_detail] 
 */

CREATE TABLE [dbo].[rpt_fifo_detail](
    [organization_id]			int               NOT NULL,
    [item_id]					varchar(60)       NOT NULL,
    [description]				varchar(254)      NULL,
    [style_id]					varchar(60)       NULL,
    [style_desc]         		varchar(254)      NULL,
    [rtl_loc_id]				int               NOT NULL,
    [store_name]				varchar(254)      NULL,
    [invctl_doc_id]				varchar(60)       NOT NULL,
    [invctl_doc_line_nbr]		int               NOT NULL,
    [user_name]					varchar(30)       NOT NULL,
    [invctl_doc_create_date]	datetime          NULL,
    [unit_count]				decimal(14, 4)    NULL,
    [current_unit_count]		decimal(14, 4)    NULL,
    [unit_cost]					decimal(17, 6)    NULL,
    [unit_count_a]				decimal(14, 4)    NULL,
    [current_cost]				decimal(17, 6)    NULL,
    [comment]					varchar(254)      NULL,
    [pending_count]				decimal(14, 4)    NULL,
    [create_date]				datetime          NULL,
    [create_user_id]			varchar(30)       NULL,
    [update_date]				datetime          NULL,
    [update_user_id]			varchar(30)       NULL,
    [record_state]				varchar(30)       NULL,
    CONSTRAINT [pk_rpt_fifo_detail] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [item_id], [invctl_doc_id], [invctl_doc_line_nbr], [user_name]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[rpt_flash_sales] 
 */

CREATE TABLE [dbo].[rpt_flash_sales](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [line_enum]        varchar(30)       NOT NULL,
    [line_count]       decimal(11, 4)    NULL,
    [line_amt]         decimal(17, 6)    NULL,
    [foreign_amt]      decimal(17, 6)    NULL,
    [currency_id]      varchar(3)        NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_rpt_flash_sales] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [line_enum]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[rpt_flash_sales_goal] 
 */

CREATE TABLE [dbo].[rpt_flash_sales_goal](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [sales_goal]       decimal(17, 6)    NULL,
    [sales_last_year]  decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_rpt_flash_sales_goal] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[rpt_item_price] 
 */

CREATE TABLE [dbo].[rpt_item_price](
    [organization_id]  int               NOT NULL,
    [item_id]          varchar(60)       NOT NULL,
    [regular_price]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_rpt_item_price] PRIMARY KEY CLUSTERED ([organization_id], [item_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[rpt_merchlvl1_sales] 
 */

CREATE TABLE [dbo].[rpt_merchlvl1_sales](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [merch_level_1]    varchar(60)       NOT NULL,
    [line_count]       decimal(11, 4)    NULL,
    [line_amt]         decimal(17, 6)    NULL,
    [gross_amt]        decimal(17, 6)    NULL,
    [currency_id]      varchar(3)        NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_rpt_merchlvl1_sales] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [merch_level_1]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[rpt_organizer] 
 */

CREATE TABLE [dbo].[rpt_organizer](
    [organization_id]  int             NOT NULL,
    [report_name]      varchar(100)    NOT NULL,
    [report_group]     varchar(100)    NOT NULL,
    [report_element]   varchar(200)    NOT NULL,
    [report_order]     int             NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_rpt_organizer] PRIMARY KEY CLUSTERED ([organization_id], [report_name], [report_group], [report_element]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[rpt_organizer_p] 
 */

CREATE TABLE [dbo].[rpt_organizer_p](
    [organization_id]  int               NOT NULL,
    [report_name]      varchar(100)      NOT NULL,
    [report_group]     varchar(100)      NOT NULL,
    [report_element]   varchar(200)      NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_rpt_organizer_p] PRIMARY KEY CLUSTERED ([organization_id], [report_name], [report_group], [report_element], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[rpt_sale_line] 
 */

CREATE TABLE [dbo].[rpt_sale_line](
    [organization_id]       int               NOT NULL,
    [rtl_loc_id]            int               NOT NULL,
    [business_date]         datetime          NOT NULL,
    [wkstn_id]              bigint            NOT NULL,
    [trans_seq]             bigint            NOT NULL,
    [rtrans_lineitm_seq]    int               NOT NULL,
    [quantity]              decimal(11, 4)    NULL,
    [actual_quantity]       decimal(11, 4)    NULL,
    [gross_quantity]        decimal(11, 4)    NULL,
    [unit_price]            decimal(17, 6)    NULL,
    [net_amt]               decimal(17, 6)    NULL,
    [gross_amt]             decimal(17, 6)    NULL,
    [currency_id]           varchar(3)        NULL,
    [item_id]               varchar(60)       NULL,
    [item_desc]             varchar(254)      NULL,
    [merch_level_1]         varchar(60)       NULL,
    [serial_nbr]            varchar(60)       NULL,
    [return_flag]           bit               DEFAULT ((0)) NULL,
    [override_amt]          decimal(17, 6)    NULL,
    [trans_timestamp]       datetime          NULL,
    [discount_amt]          decimal(17, 6)    NULL,
    [cust_party_id]         bigint            NULL,
    [last_name]             varchar(254)      NULL,
    [first_name]            varchar(254)      NULL,
    [trans_statcode]        varchar(60)       NULL,
    [sale_lineitm_typcode]  varchar(60)       NULL,
    [begin_time_int]        int               NULL,
    [regular_base_price]    decimal(17, 6)    NULL,
    [exclude_from_net_sales_flag]     bit         DEFAULT ((0)) NULL,
    [trans_date]			datetime		  NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_rpt_sale_line] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go

/* 
 * INDEX: [idx_rpt_sale_line01] 
 */

CREATE INDEX [idx_rpt_sale_line01] ON [dbo].[rpt_sale_line]([cust_party_id]) WITH (FILLFACTOR = 80);
GO


/* 
 * INDEX: [idx_rpt_sale_line02] 
 */

CREATE INDEX [idx_rpt_sale_line02] ON [dbo].[rpt_sale_line] ([organization_id],[trans_statcode],[business_date])
INCLUDE ([rtl_loc_id],[wkstn_id],[trans_seq],[rtrans_lineitm_seq],[quantity],[net_amt]) WITH (FILLFACTOR = 80);
GO

/* 
 * INDEX: [idx_rpt_sale_line04] 
 */

CREATE INDEX [idx_rpt_sale_line04] ON [dbo].[rpt_sale_line]([trans_date]) WITH (FILLFACTOR = 80);
GO



/* 
 * TABLE: [dbo].[rpt_sales_by_hour] 
 */

CREATE TABLE [dbo].[rpt_sales_by_hour](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [hour]             int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [trans_count]      int               NULL,
    [qty]              decimal(11, 4)    NULL,
    [net_sales]        decimal(17, 6)    NULL,
    [gross_sales]      decimal(17, 6)    NULL,
    [currency_id]      varchar(3)        NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_rpt_sales_by_hour] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [hour]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[sch_emp_time_off] 
 */

CREATE TABLE [dbo].[sch_emp_time_off](
    [organization_id]   int            NOT NULL,
    [employee_id]       varchar(60)    NOT NULL,
    [time_off_seq]      bigint         NOT NULL,
    [start_datetime]    datetime       NULL,
    [end_datetime]      datetime       NULL,
    [reason_code]       varchar(30)    NULL,
    [void_flag]         bit            DEFAULT ((0)) NULL,
    [time_off_typcode]  varchar(30)    NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [pk_sch_emp_time_off] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [time_off_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[sch_emp_time_off_p] 
 */

CREATE TABLE [dbo].[sch_emp_time_off_p](
    [organization_id]  int               NOT NULL,
    [employee_id]      varchar(60)       NOT NULL,
    [time_off_seq]     bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_sch_emp_time_off_p] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [time_off_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sch_schedule] 
 */

CREATE TABLE [dbo].[sch_schedule](
    [organization_id]    int            NOT NULL,
    [employee_id]        varchar(60)    NOT NULL,
    [business_date]      datetime       NOT NULL,
    [schedule_seq]       bigint         NOT NULL,
    [work_code]          varchar(30)    NULL,
    [start_time]         datetime       NULL,
    [end_time]           datetime       NULL,
    [void_flag]          bit            DEFAULT ((0)) NULL,
    [break_duration]     bigint         NULL,
    [schedule_duration]  bigint         NULL,
    [posted_date]        datetime       NULL,
    [posted_flag]        bit            DEFAULT ((0)) NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     varchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     varchar(30)    NULL,
    [record_state]       varchar(30)    NULL,
    CONSTRAINT [pk_sch_schedule] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [business_date], [schedule_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[sch_schedule_p] 
 */

CREATE TABLE [dbo].[sch_schedule_p](
    [organization_id]  int               NOT NULL,
    [employee_id]      varchar(60)       NOT NULL,
    [business_date]    datetime          NOT NULL,
    [schedule_seq]     bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_sch_schedule_p] PRIMARY KEY CLUSTERED ([organization_id], [employee_id], [business_date], [schedule_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sch_shift] 
 */

CREATE TABLE [dbo].[sch_shift](
    [organization_id]  int             NOT NULL,
    [shift_id]         bigint          NOT NULL,
    [org_code]         varchar(30) DEFAULT('*')     NOT NULL,
    [org_value]        varchar(60) DEFAULT('*')     NOT NULL,
    [name]             varchar(60)     NULL,
    [description]      varchar(254)    NULL,
    [work_code]        varchar(30)     NULL,
    [start_time]       datetime        NULL,
    [end_time]         datetime        NULL,
    [void_flag]        bit             DEFAULT ((0)) NULL,
    [break_duration]   bigint          NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_sch_shift] PRIMARY KEY CLUSTERED ([organization_id], [shift_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_sch_shift_orgnode ON sch_shift (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[sch_shift_p] 
 */

CREATE TABLE [dbo].[sch_shift_p](
    [organization_id]  int               NOT NULL,
    [shift_id]         bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_sch_shift_p] PRIMARY KEY CLUSTERED ([organization_id], [shift_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sec_access_types] 
 */

CREATE TABLE [dbo].[sec_access_types](
    [organization_id]     int             NOT NULL,
    [secured_object_id]   varchar(30)     NOT NULL,
    [access_typcode]      varchar(30)     NOT NULL,
    [group_membership]    varchar(max)    NOT NULL,
    [no_access_settings]  varchar(30)     NOT NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_sec_access_types] PRIMARY KEY CLUSTERED ([organization_id], [secured_object_id], [access_typcode]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[sec_access_types_p] 
 */

CREATE TABLE [dbo].[sec_access_types_p](
    [organization_id]    int               NOT NULL,
    [secured_object_id]  varchar(30)       NOT NULL,
    [access_typcode]     varchar(30)       NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_sec_access_types_p] PRIMARY KEY CLUSTERED ([organization_id], [secured_object_id], [access_typcode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sec_acl] 
 */

CREATE TABLE [dbo].[sec_acl](
    [organization_id]          int            NOT NULL,
    [secured_object_id]        varchar(30)    NOT NULL,
    [authentication_req_flag]  bit            DEFAULT ((0)) NULL,
    [create_date]              datetime       NULL,
    [create_user_id]           varchar(30)    NULL,
    [update_date]              datetime       NULL,
    [update_user_id]           varchar(30)    NULL,
    [record_state]             varchar(30)    NULL,
    CONSTRAINT [pk_sec_acl] PRIMARY KEY CLUSTERED ([organization_id], [secured_object_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[sec_acl_p] 
 */

CREATE TABLE [dbo].[sec_acl_p](
    [organization_id]    int               NOT NULL,
    [secured_object_id]  varchar(30)       NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_sec_acl_p] PRIMARY KEY CLUSTERED ([organization_id], [secured_object_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sec_activity_log] 
 */

CREATE TABLE [dbo].[sec_activity_log](
    [organization_id]         int           NOT NULL,
    [rtl_loc_id]              int           NOT NULL,
    [wkstn_id]                bigint        NOT NULL,
    [business_date]           datetime      NULL,
    [trans_seq]               bigint        NULL,
    [activity_typcode]        varchar(30)   NOT NULL,
    [success_flag]            bit           NULL,
    [employee_id]             varchar(60)   NULL,
    [overriding_employee_id]  varchar(60)   NULL,
    [privilege_type]          varchar(255)  NULL,
    [system_datetime]         datetime      NULL,
    [create_date]             datetime      NULL,
    [create_user_id]          varchar(30)   NULL,
    [update_date]             datetime      NULL,
    [update_user_id]          varchar(30)   NULL,
    [record_state]            varchar(30)   NULL
) 
GO
/* 
 * TABLE: [dbo].[sec_groups] 
 */

CREATE TABLE [dbo].[sec_groups](
    [organization_id]  int             NOT NULL,
    [group_id]         varchar(60)     NOT NULL,
    [description]      varchar(254)    NULL,
    [bitmap_position]  int             NOT NULL,
    [group_rank]       int             NULL,
	[config_element]   varchar(200)	   DEFAULT '*' NOT NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_sec_groups] PRIMARY KEY CLUSTERED ([organization_id], [group_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[sec_groups_p] 
 */

CREATE TABLE [dbo].[sec_groups_p](
    [organization_id]  int               NOT NULL,
    [group_id]         varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_sec_groups_p] PRIMARY KEY CLUSTERED ([organization_id], [group_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sec_password] 
 */

CREATE TABLE [dbo].[sec_password](
  [organization_id]  INT          NOT NULL,
  [password_id]      INT          NOT NULL,
  [password]         VARCHAR(254) NULL,
  [create_date]      DATETIME     NULL,
  [create_user_id]   VARCHAR(30)  NULL,
  [update_date]      DATETIME     NULL,
  [update_user_id]   VARCHAR(30)  NULL,
  [record_state]     VARCHAR(30)  NULL,
  CONSTRAINT [pk_sec_password] PRIMARY KEY CLUSTERED ([organization_id], [password_id])
  WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sec_privilege] 
 */

CREATE TABLE [dbo].[sec_privilege](
    [organization_id]                 int             NOT NULL,
    [privilege_type]                  varchar(60)     NOT NULL,
    [authentication_req]              bit             DEFAULT ((0)) NULL,
    [description]                     varchar(254)    NULL,
    [overridable_flag]                bit             DEFAULT ((0)) NULL,
    [group_membership]                varchar(max)    NOT NULL,
    [second_prompt_settings]          varchar(30)     NULL,
    [second_prompt_req_diff_emp]      bit             DEFAULT ((0)) NOT NULL,
    [second_prompt_group_membership]  varchar(max)    NULL,
	[config_element]				  varchar(200)	  DEFAULT '*' NOT NULL,
    [create_date]                     datetime        NULL,
    [create_user_id]                  varchar(30)     NULL,
    [update_date]                     datetime        NULL,
    [update_user_id]                  varchar(30)     NULL,
    [record_state]                    varchar(30)     NULL,
    CONSTRAINT [pk_sec_privilege] PRIMARY KEY CLUSTERED ([organization_id], [privilege_type]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[sec_privilege_p] 
 */

CREATE TABLE [dbo].[sec_privilege_p](
    [organization_id]  int               NOT NULL,
    [privilege_type]   varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_sec_privilege_p] PRIMARY KEY CLUSTERED ([organization_id], [privilege_type], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sec_user_password] 
 */

CREATE TABLE [dbo].[sec_user_password](
    [organization_id]       int             NOT NULL,
    [username]              varchar(50)     NOT NULL,
    [password_seq]          bigint          NOT NULL,
    [password]              varchar(254)    NOT NULL,
	[effective_date]		datetime		NOT NULL,
    [failed_attempts]       int             DEFAULT 0 NOT NULL,
    [locked_out_timestamp]  datetime        NULL,
    [create_date]           datetime        NULL,
    [create_user_id]        varchar(30)     NULL,
    [update_date]           datetime        NULL,
    [update_user_id]        varchar(30)     NULL,
    [record_state]          varchar(30)     NULL,
    CONSTRAINT [pk_sec_user_password] PRIMARY KEY CLUSTERED ([organization_id], [username], [password_seq])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sec_user_role] 
 */

CREATE TABLE [dbo].[sec_user_role](
    [organization_id]  int            NOT NULL,
    [user_role_id]     int            NOT NULL,
    [username]         varchar(50)    NOT NULL,
    [role_code]        varchar(20)    NOT NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_sec_user_role] PRIMARY KEY CLUSTERED ([organization_id], [user_role_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[sls_sales_goal] 
 */

CREATE TABLE [dbo].[sls_sales_goal](
    [organization_id]     int               NOT NULL,
    [sales_goal_id]       varchar(60)       NOT NULL,
    [org_code]            varchar(30) DEFAULT('*')       NOT NULL,
    [org_value]           varchar(60) DEFAULT('*')       NOT NULL,
    [sales_goal_value]    decimal(17, 6)    NOT NULL,
    [effective_date]      datetime          NOT NULL,
    [end_date]            datetime          NOT NULL,
    [description]         varchar(254)      NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_sls_sales_goal] PRIMARY KEY CLUSTERED ([organization_id], [sales_goal_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_sls_sales_goal_orgnode ON sls_sales_goal (org_code,org_value) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[sls_sales_goal_p] 
 */

CREATE TABLE [dbo].[sls_sales_goal_p](
    [organization_id]  int               NOT NULL,
    [sales_goal_id]    varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_sls_sales_goal_p] PRIMARY KEY CLUSTERED ([organization_id], [sales_goal_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_postal_code_mapping] 
 */

CREATE TABLE [dbo].[tax_postal_code_mapping](
    [organization_id]  int             NOT NULL,
    [postal_code]      varchar(100)    NOT NULL,
    [city]             varchar(254)    NOT NULL,
    [tax_loc_id]       varchar(60)     NOT NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_tax_postal_code_mapping] PRIMARY KEY CLUSTERED ([organization_id], [postal_code], [city], [tax_loc_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tax_postal_code_mapping_p] 
 */

CREATE TABLE [dbo].[tax_postal_code_mapping_p](
    [organization_id]  int               NOT NULL,
    [postal_code]      varchar(100)      NOT NULL,
    [city]             varchar(254)      NOT NULL,
    [tax_loc_id]       varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tax_postal_code_mapping_p] PRIMARY KEY CLUSTERED ([organization_id], [postal_code], [city], [tax_loc_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_rtl_loc_tax_mapping] 
 */

CREATE TABLE [dbo].[tax_rtl_loc_tax_mapping](
    [organization_id]  int            NOT NULL,
    [rtl_loc_id]       int            NOT NULL,
    [tax_loc_id]       varchar(60)    NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_tax_rtl_loc_tax_mapping] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tax_rtl_loc_tax_mapping_p] 
 */

CREATE TABLE [dbo].[tax_rtl_loc_tax_mapping_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tax_rtl_loc_tax_mapping_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_authority] 
 */

CREATE TABLE [dbo].[tax_tax_authority](
    [organization_id]           int             NOT NULL,
    [tax_authority_id]          varchar(60)     NOT NULL,
    [name]                      varchar(254)    NULL,
    [rounding_code]             varchar(30)     NULL,
    [rounding_digits_quantity]  int             NULL,
    [org_code]					varchar(30)		DEFAULT ('*') NOT NULL,
    [org_value]					varchar(60)		DEFAULT ('*') NOT NULL,
	[EXTERNAL_SYSTEM]			VARCHAR(60)		NULL,
    [create_date]               datetime        NULL,
    [create_user_id]            varchar(30)     NULL,
    [update_date]               datetime        NULL,
    [update_user_id]            varchar(30)     NULL,
    [record_state]              varchar(30)     NULL,
    CONSTRAINT [pk_tax_tax_authority] PRIMARY KEY CLUSTERED ([organization_id], [tax_authority_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_tax_tax_authority_orgnode ON tax_tax_authority (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[tax_tax_authority_p] 
 */

CREATE TABLE [dbo].[tax_tax_authority_p](
    [organization_id]   int               NOT NULL,
    [tax_authority_id]  varchar(60)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_authority_p] PRIMARY KEY CLUSTERED ([organization_id], [tax_authority_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_bracket] 
 */

CREATE TABLE [dbo].[tax_tax_bracket](
    [organization_id]           int               NOT NULL,
    [tax_bracket_id]            varchar(60)       NOT NULL,
    [tax_bracket_seq_nbr]       int               NOT NULL,
    [org_code]				  varchar(30)		DEFAULT ('*') NOT NULL,
    [org_value]			  varchar(60)		DEFAULT ('*') NOT NULL,
    [tax_breakpoint]            decimal(17, 6)    NULL,
    [tax_amount]                decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_bracket] PRIMARY KEY CLUSTERED ([organization_id], [tax_bracket_id], [tax_bracket_seq_nbr]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_tax_tax_bracket_orgnode ON tax_tax_bracket (org_code,org_value) WITH (FILLFACTOR = 80)
go

/* 
 * TABLE: [dbo].[tax_tax_bracket_p] 
 */

CREATE TABLE [dbo].[tax_tax_bracket_p](
    [organization_id]      int               NOT NULL,
    [tax_bracket_id]       varchar(60)       NOT NULL,
    [tax_bracket_seq_nbr]  int               NOT NULL,
    [property_code]        varchar(30)       NOT NULL,
    [type]                 varchar(30)       NULL,
    [string_value]         varchar(max)      NULL,
    [date_value]           datetime          NULL,
    [decimal_value]        decimal(17, 6)    NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_bracket_p] PRIMARY KEY CLUSTERED ([organization_id], [tax_bracket_id], [tax_bracket_seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_code] 
 */

CREATE TABLE [dbo].[tax_tax_code](
    [organization_id]  int             NOT NULL,
    [tax_code_id]      varchar(30)     NOT NULL,
    [description]      varchar(128)    NOT NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_tax_tax_code] PRIMARY KEY CLUSTERED ([organization_id], [tax_code_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_code_p] 
 */

CREATE TABLE [dbo].[tax_tax_code_p](
    [organization_id]  int               NOT NULL,
    [tax_code_id]      varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_code_p] PRIMARY KEY CLUSTERED ([organization_id], [tax_code_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_exemption] 
 */

CREATE TABLE [dbo].[tax_tax_exemption](
    [organization_id]         int             NOT NULL,
    [tax_exemption_id]        varchar(60)     NOT NULL,
    [party_id]                bigint          NULL,
    [cert_nbr]                varchar(30)     NULL,
    [reascode]                varchar(30)     NULL,
    [cert_holder_name]        varchar(254)    NULL,
    [cert_country]            varchar(2)      NULL,
    [expiration_date]         datetime        NULL,
    [cert_state]              varchar(30)     NULL,
    [notes]                   varchar(254)    NULL,
    [address_id]              varchar(60)     NULL,
    [phone_number]            varchar(32)     NULL,
    [region]                  varchar(30)     NULL,
    [diplomatic_title]        varchar(60)     NULL,
    [cert_holder_first_name]  varchar(60)     NULL,
    [cert_holder_last_name]   varchar(60)     NULL,
    [create_date]             datetime        NULL,
    [create_user_id]          varchar(30)     NULL,
    [update_date]             datetime        NULL,
    [update_user_id]          varchar(30)     NULL,
    [record_state]            varchar(30)     NULL,
    CONSTRAINT [pk_tax_tax_exemption] PRIMARY KEY CLUSTERED ([organization_id], [tax_exemption_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_tax_tax_exemption01] 
 */

CREATE INDEX [idx_tax_tax_exemption01] ON [dbo].[tax_tax_exemption]([party_id], [organization_id]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[tax_tax_exemption_p] 
 */

CREATE TABLE [dbo].[tax_tax_exemption_p](
    [organization_id]   int               NOT NULL,
    [tax_exemption_id]  varchar(60)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_exemption_p] PRIMARY KEY CLUSTERED ([organization_id], [tax_exemption_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_group] 
 */

CREATE TABLE [dbo].[tax_tax_group](
    [organization_id]  int             NOT NULL,
    [tax_group_id]     varchar(60)     NOT NULL,
    [name]             varchar(254)    NULL,
    [description]      varchar(254)    NULL,
    [org_code]		   varchar(30)	   DEFAULT ('*') NOT NULL,
    [org_value]		   varchar(60)	   DEFAULT ('*') NOT NULL,
	[tax_code_id]	   varchar(30)	   null,
	[EXTERNAL_SYSTEM]  VARCHAR(60)	   NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_tax_tax_group] PRIMARY KEY CLUSTERED ([organization_id], [tax_group_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_tax_tax_group_orgnode ON tax_tax_group (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[tax_tax_group_mapping] 
 */

CREATE TABLE [dbo].[tax_tax_group_mapping](
    [organization_id]    int            NOT NULL,
    [rtl_loc_id]         int            NOT NULL,
    [tax_group_id]       varchar(60)    NOT NULL,
    [customer_group_id]  varchar(60)    NOT NULL,
    [priority]           int            NULL,
    [new_tax_group_id]   varchar(60)    NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     varchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     varchar(30)    NULL,
    [record_state]       varchar(30)    NULL,
    CONSTRAINT [pk_tax_tax_group_mapping] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tax_group_id], [customer_group_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tax_tax_group_mapping_p] 
 */

CREATE TABLE [dbo].[tax_tax_group_mapping_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [tax_group_id]       varchar(60)       NOT NULL,
    [customer_group_id]  varchar(60)       NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_group_mapping_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tax_group_id], [customer_group_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_group_p] 
 */

CREATE TABLE [dbo].[tax_tax_group_p](
    [organization_id]  int               NOT NULL,
    [tax_group_id]     varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_group_p] PRIMARY KEY CLUSTERED ([organization_id], [tax_group_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_group_rule] 
 */

CREATE TABLE [dbo].[tax_tax_group_rule](
    [organization_id]            int             NOT NULL,
    [tax_group_id]               varchar(60)     NOT NULL,
    [tax_loc_id]                 varchar(60)     NOT NULL,
    [tax_rule_seq_nbr]           int             NOT NULL,
    [tax_authority_id]           varchar(60)     NULL,
    [name]                       varchar(254)    NULL,
    [description]                varchar(254)    NULL,
    [compound_seq_nbr]           int             NULL,
    [compound_flag]              bit             DEFAULT ((0)) NULL,
    [taxed_at_trans_level_flag]  bit             DEFAULT ((0)) NULL,
    [tax_typcode]                varchar(30)     NULL,
    [org_code]					 varchar(30)	 DEFAULT ('*') NOT NULL,
    [org_value]					 varchar(60)	 DEFAULT ('*') NOT NULL,
	[EXTERNAL_SYSTEM]			 VARCHAR(60)	 NULL,
    [create_date]                datetime        NULL,
    [create_user_id]             varchar(30)     NULL,
    [update_date]                datetime        NULL,
    [update_user_id]             varchar(30)     NULL,
    [record_state]               varchar(30)     NULL,
    CONSTRAINT [pk_tax_tax_group_rule] PRIMARY KEY CLUSTERED ([organization_id], [tax_group_id], [tax_loc_id], [tax_rule_seq_nbr]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_tax_tax_group_rule_orgnode ON tax_tax_group_rule (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[tax_tax_group_rule_p] 
 */

CREATE TABLE [dbo].[tax_tax_group_rule_p](
    [organization_id]   int               NOT NULL,
    [tax_group_id]      varchar(60)       NOT NULL,
    [tax_loc_id]        varchar(60)       NOT NULL,
    [tax_rule_seq_nbr]  int               NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_group_rule_p] PRIMARY KEY CLUSTERED ([organization_id], [tax_group_id], [tax_loc_id], [tax_rule_seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_loc] 
 */

CREATE TABLE [dbo].[tax_tax_loc](
    [organization_id]  int             NOT NULL,
    [tax_loc_id]       varchar(60)     NOT NULL,
    [name]             varchar(254)    NULL,
    [description]      varchar(254)    NULL,
    [org_code]		   varchar(30)	   DEFAULT ('*') NOT NULL,
    [org_value]		   varchar(60)	   DEFAULT ('*') NOT NULL,
	[EXTERNAL_SYSTEM]  VARCHAR(60)	   NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_tax_tax_loc] PRIMARY KEY CLUSTERED ([organization_id], [tax_loc_id]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idx_tax_tax_loc_orgnode ON tax_tax_loc (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[tax_tax_loc_p] 
 */

CREATE TABLE [dbo].[tax_tax_loc_p](
    [organization_id]  int               NOT NULL,
    [tax_loc_id]       varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_loc_p] PRIMARY KEY CLUSTERED ([organization_id], [tax_loc_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_rate_rule] 
 */

CREATE TABLE [dbo].[tax_tax_rate_rule](
    [organization_id]           int               NOT NULL,
    [tax_group_id]              varchar(60)       NOT NULL,
    [tax_loc_id]                varchar(60)       NOT NULL,
    [tax_rule_seq_nbr]          int               NOT NULL,
    [tax_rate_rule_seq]         int               NOT NULL,
    [tax_bracket_id]            varchar(60)       NULL,
    [tax_rate_min_taxable_amt]  decimal(17, 6)    NULL,
    [effective_datetime]        datetime          NULL,
    [expr_datetime]             datetime          NULL,
    [percentage]                decimal(8, 6)     NULL,
    [amt]                       decimal(17, 6)    NULL,
    [daily_start_time]          datetime          NULL,
    [daily_end_time]            datetime          NULL,
    [tax_rate_max_taxable_amt]  decimal(17, 6)    NULL,
    [breakpoint_typcode]        varchar(30)       NULL,
    [org_code]					varchar(30)	      DEFAULT ('*') NOT NULL,
    [org_value]					varchar(60)	      DEFAULT ('*') NOT NULL,
	[EXTERNAL_SYSTEM]			VARCHAR(60)		  NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_rate_rule] PRIMARY KEY CLUSTERED ([organization_id], [tax_group_id], [tax_loc_id], [tax_rule_seq_nbr], [tax_rate_rule_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [xst_tax_raterule_expr] 
 */

CREATE INDEX [xst_tax_raterule_expr] ON [dbo].[tax_tax_rate_rule]([organization_id], [tax_group_id], [tax_rule_seq_nbr], [tax_loc_id], [expr_datetime]) WITH (FILLFACTOR = 80)
go

CREATE INDEX idx_tax_tax_rate_rule_orgnode ON tax_tax_rate_rule (org_code,org_value) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[tax_tax_rate_rule_override] 
 */

CREATE TABLE [dbo].[tax_tax_rate_rule_override](
    [organization_id]           int               NOT NULL,
    [tax_group_id]              varchar(60)       NOT NULL,
    [tax_loc_id]                varchar(60)       NOT NULL,
    [tax_rule_seq_nbr]          int               NOT NULL,
    [tax_rate_rule_seq]         int               NOT NULL,
    [expr_datetime]             datetime          NOT NULL,
    [effective_datetime]        datetime          NULL,
    [tax_bracket_id]            varchar(60)       NULL,
    [percentage]                decimal(8, 6)     NULL,
    [amt]                       decimal(17, 6)    NULL,
    [daily_start_time]          datetime          NULL,
    [daily_end_time]            datetime          NULL,
    [tax_rate_min_taxable_amt]  decimal(17, 6)    NULL,
    [tax_rate_max_taxable_amt]  decimal(17, 6)    NULL,
    [breakpoint_typcode]        varchar(30)       NULL,
    [org_code]					varchar(30)	     DEFAULT ('*') NOT NULL,
    [org_value]					varchar(60)	     DEFAULT ('*') NOT NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_rate_rule_override] PRIMARY KEY CLUSTERED ([organization_id], [tax_group_id], [tax_loc_id], [tax_rule_seq_nbr], [tax_rate_rule_seq], [expr_datetime]) WITH (FILLFACTOR = 80)
)

CREATE INDEX idxtaxtaxruleoverrideorgnode ON tax_tax_rate_rule_override (org_code,org_value) WITH (FILLFACTOR = 80)
go



/* 
 * TABLE: [dbo].[tax_tax_rate_rule_override_p] 
 */

CREATE TABLE [dbo].[tax_tax_rate_rule_override_p](
    [organization_id]    int               NOT NULL,
    [tax_group_id]       varchar(60)       NOT NULL,
    [tax_loc_id]         varchar(60)       NOT NULL,
    [tax_rule_seq_nbr]   int               NOT NULL,
    [tax_rate_rule_seq]  int               NOT NULL,
    [expr_datetime]      datetime          NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pktaxtaxrateruleoverridep] PRIMARY KEY CLUSTERED ([organization_id], [tax_group_id], [tax_loc_id], [tax_rule_seq_nbr], [tax_rate_rule_seq], [expr_datetime], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tax_tax_rate_rule_p] 
 */

CREATE TABLE [dbo].[tax_tax_rate_rule_p](
    [organization_id]    int               NOT NULL,
    [tax_group_id]       varchar(60)       NOT NULL,
    [tax_loc_id]         varchar(60)       NOT NULL,
    [tax_rule_seq_nbr]   int               NOT NULL,
    [tax_rate_rule_seq]  int               NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_tax_tax_rate_rule_p] PRIMARY KEY CLUSTERED ([organization_id], [tax_group_id], [tax_loc_id], [tax_rule_seq_nbr], [tax_rate_rule_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[thr_payroll] 
 */

CREATE TABLE [dbo].[thr_payroll](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [party_id]          bigint            NOT NULL,
    [payroll_category]  varchar(30)       NOT NULL,
    [business_date]     datetime          NOT NULL,
    [hours_count]       decimal(11, 4)    NULL,
    [posted_flag]       bit               DEFAULT ((0)) NULL,
    [posted_date]       datetime          NULL,
    [payroll_status]    varchar(30)       NULL,
    [reviewed_date]     datetime          NULL,
    [pay_code]          varchar(30)       NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_thr_payroll] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [party_id], [payroll_category], [business_date]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[thr_payroll_category] 
 */

CREATE TABLE [dbo].[thr_payroll_category](
    [organization_id]           int             NOT NULL,
    [payroll_category]          varchar(30)     NOT NULL,
    [description]               varchar(254)    NULL,
    [sort_order]                int             NULL,
    [include_in_overtime_flag]  bit             DEFAULT ((0)) NULL,
    [working_category_flag]     bit             DEFAULT ((0)) NULL,
    [pay_code]                  varchar(30)     NULL,
    [create_date]               datetime        NULL,
    [create_user_id]            varchar(30)     NULL,
    [update_date]               datetime        NULL,
    [update_user_id]            varchar(30)     NULL,
    [record_state]              varchar(30)     NULL,
    CONSTRAINT [pk_thr_payroll_category] PRIMARY KEY CLUSTERED ([organization_id], [payroll_category]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[thr_payroll_category_p] 
 */

CREATE TABLE [dbo].[thr_payroll_category_p](
    [organization_id]   int               NOT NULL,
    [payroll_category]  varchar(30)       NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_thr_payroll_category_p] PRIMARY KEY CLUSTERED ([organization_id], [payroll_category], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[thr_payroll_header] 
 */

CREATE TABLE [dbo].[thr_payroll_header](
    [organization_id]   int            NOT NULL,
    [rtl_loc_id]        int            NOT NULL,
    [party_id]          bigint         NOT NULL,
    [week_ending_date]  datetime       NOT NULL,
    [reviewed_date]     datetime       NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [pk_thr_payroll_header] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [party_id], [week_ending_date]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[thr_payroll_header_p] 
 */

CREATE TABLE [dbo].[thr_payroll_header_p](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [party_id]          bigint            NOT NULL,
    [week_ending_date]  datetime          NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_thr_payroll_header_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [party_id], [week_ending_date], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[thr_payroll_notes] 
 */

CREATE TABLE [dbo].[thr_payroll_notes](
    [organization_id]   int             NOT NULL,
    [party_id]          bigint          NOT NULL,
    [week_ending_date]  datetime        NOT NULL,
    [note_seq]          bigint          NOT NULL,
    [note_text]         varchar(max)    NULL,
    [create_date]       datetime        NULL,
    [create_user_id]    varchar(30)     NULL,
    [update_date]       datetime        NULL,
    [update_user_id]    varchar(30)     NULL,
    [record_state]      varchar(30)     NULL,
    CONSTRAINT [pk_thr_payroll_notes] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [week_ending_date], [note_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[thr_payroll_notes_p] 
 */

CREATE TABLE [dbo].[thr_payroll_notes_p](
    [organization_id]   int               NOT NULL,
    [party_id]          bigint            NOT NULL,
    [week_ending_date]  datetime          NOT NULL,
    [note_seq]          bigint            NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_thr_payroll_notes_p] PRIMARY KEY CLUSTERED ([organization_id], [party_id], [week_ending_date], [note_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[thr_payroll_p] 
 */

CREATE TABLE [dbo].[thr_payroll_p](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [party_id]          bigint            NOT NULL,
    [payroll_category]  varchar(30)       NOT NULL,
    [business_date]     datetime          NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_thr_payroll_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [party_id], [payroll_category], [business_date], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[thr_timecard_entry] 
 */

CREATE TABLE [dbo].[thr_timecard_entry](
    [organization_id]          int            NOT NULL,
    [rtl_loc_id]               int            NOT NULL,
    [business_date]            datetime       NOT NULL,
    [wkstn_id]                 bigint         NOT NULL,
    [party_id]                 bigint         NOT NULL,
    [timecard_entry_id]        int            NOT NULL,
    [clock_in_timestamp]       datetime       NULL,
    [clock_out_timestamp]      datetime       NULL,
    [work_code]                varchar(30)    NULL,
    [open_record_flag]         bit            DEFAULT ((0)) NULL,
    [entry_type_enum]          varchar(30)    NULL,
    [delete_flag]              bit            DEFAULT ((0)) NULL,
    [duration]                 bigint         NULL,
    [payroll_update_required]  bit            DEFAULT ((0)) NULL,
    [create_date]              datetime       NULL,
    [create_user_id]           varchar(30)    NULL,
    [update_date]              datetime       NULL,
    [update_user_id]           varchar(30)    NULL,
    [record_state]             varchar(30)    NULL,
    CONSTRAINT [pk_thr_timecard_entry] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [party_id], [timecard_entry_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[thr_timecard_entry_comment] 
 */

CREATE TABLE [dbo].[thr_timecard_entry_comment](
    [organization_id]    int             NOT NULL,
    [rtl_loc_id]         int             NOT NULL,
    [wkstn_id]           bigint          NOT NULL,
    [party_id]           bigint          NOT NULL,
    [week_ending_date]   datetime        NOT NULL,
    [comment_seq]        bigint          NOT NULL,
    [comment_text]       varchar(max)    NULL,
    [comment_timestamp]  datetime        NULL,
    [creator_id]		 varchar(254)    NULL,
    [business_date]      datetime        NULL,
    [timecard_entry_id]  int             NULL,
    [create_date]        datetime        NULL,
    [create_user_id]     varchar(30)     NULL,
    [update_date]        datetime        NULL,
    [update_user_id]     varchar(30)     NULL,
    [record_state]       varchar(30)     NULL,
    CONSTRAINT [pk_thr_timecard_entry_comment] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [party_id], [week_ending_date], [comment_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[thr_timecard_entry_comment_p] 
 */

CREATE TABLE [dbo].[thr_timecard_entry_comment_p](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [wkstn_id]          bigint            NOT NULL,
    [party_id]          bigint            NOT NULL,
    [week_ending_date]  datetime          NOT NULL,
    [comment_seq]       bigint            NOT NULL,
    [property_code]     varchar(30)       NOT NULL,
    [type]              varchar(30)       NULL,
    [string_value]      varchar(max)      NULL,
    [date_value]        datetime          NULL,
    [decimal_value]     decimal(17, 6)    NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pkthrtimecardentrycommentp] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [party_id], [week_ending_date], [comment_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[thr_timecard_entry_p] 
 */

CREATE TABLE [dbo].[thr_timecard_entry_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [business_date]      datetime          NOT NULL,
    [wkstn_id]           bigint            NOT NULL,
    [party_id]           bigint            NOT NULL,
    [timecard_entry_id]  int               NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_thr_timecard_entry_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [party_id], [timecard_entry_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[thr_timecard_journal] 
 */

CREATE TABLE [dbo].[thr_timecard_journal](
    [organization_id]      int            NOT NULL,
    [rtl_loc_id]           int            NOT NULL,
    [business_date]        datetime       NOT NULL,
    [wkstn_id]             bigint         DEFAULT ((0)) NOT NULL,
    [party_id]             bigint         NOT NULL,
    [timecard_entry_id]    int            NOT NULL,
    [timecard_entry_seq]   bigint         NOT NULL,
    [clock_in_timestamp]   datetime       NULL,
    [clock_out_timestamp]  datetime       NULL,
    [work_code]            varchar(30)    NULL,
    [entry_type_enum]      varchar(30)    NULL,
    [delete_flag]          bit            DEFAULT ((0)) NULL,
    [create_date]          datetime       NULL,
    [create_user_id]       varchar(30)    NULL,
    [update_date]          datetime       NULL,
    [update_user_id]       varchar(30)    NULL,
    [record_state]         varchar(30)    NULL,
    CONSTRAINT [pk_thr_timecard_journal] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [party_id], [timecard_entry_id], [timecard_entry_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[thr_timecard_journal_p] 
 */

CREATE TABLE [dbo].[thr_timecard_journal_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            DEFAULT 0 NOT NULL,
    [party_id]            bigint            NOT NULL,
    [timecard_entry_id]   int               NOT NULL,
    [timecard_entry_seq]  bigint            NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_thr_timecard_journal_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [party_id], [timecard_entry_id], [timecard_entry_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[thr_timeclk_trans] 
 */

CREATE TABLE [dbo].[thr_timeclk_trans](
    [organization_id]               int            NOT NULL,
    [rtl_loc_id]                    int            NOT NULL,
    [business_date]                 datetime       NOT NULL,
    [wkstn_id]                      bigint         NOT NULL,
    [trans_seq]                     bigint         NOT NULL,
    [timecard_entry_wkstn_id]       bigint         NULL,
    [work_code]                     varchar(30)    NULL,
    [timeclk_entry_code]            varchar(30)    NULL,
    [party_id]                      bigint         NULL,
    [timecard_entry_id]             int            NULL,
    [timecard_entry_seq]            bigint         NULL,
    [timecard_entry_business_date]  datetime       NULL,
    [create_date]                   datetime       NULL,
    [create_user_id]                varchar(30)    NULL,
    [update_date]                   datetime       NULL,
    [update_user_id]                varchar(30)    NULL,
    [record_state]                  varchar(30)    NULL,
    CONSTRAINT [pk_thr_timeclk_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tnd_exchange_rate] 
 */

CREATE TABLE [dbo].[tnd_exchange_rate](
    [organization_id]  int               NOT NULL,
    [base_currency]    varchar(3)        NOT NULL,
    [target_currency]  varchar(3)        NOT NULL,
    [level_code]       varchar(30)		 DEFAULT('*')  NOT NULL,
    [level_value]      varchar(60)		 DEFAULT('*')  NOT NULL,
    [rate]             decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tnd_exchange_rate] PRIMARY KEY CLUSTERED ([organization_id], [base_currency], [target_currency], [level_code], [level_value]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tnd_exchange_rate_p] 
 */

CREATE TABLE [dbo].[tnd_exchange_rate_p](
    [organization_id]  int               NOT NULL,
    [base_currency]    varchar(3)        NOT NULL,
    [target_currency]  varchar(3)        NOT NULL,
    [level_code]       varchar(30)       DEFAULT '*' NOT NULL,
    [level_value]      varchar(60)       DEFAULT '*' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tnd_exchange_rate_p] PRIMARY KEY CLUSTERED ([organization_id], [base_currency], [target_currency], [level_code], [level_value], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tnd_tndr] 
 */

CREATE TABLE [dbo].[tnd_tndr](
    [organization_id]               int               NOT NULL,
    [tndr_id]                       varchar(60)       NOT NULL,
    [tndr_typcode]                  varchar(30)       NULL,
    [currency_id]                   varchar(3)        NOT NULL,
    [description]                   varchar(254)      NULL,
    [display_order]                 int               NULL,
    [flash_sales_display_order]     int               NULL,
    [disabled_flag]				    bit               DEFAULT ((0)) NULL,
    [create_date]                   datetime          NULL,
    [create_user_id]                varchar(30)       NULL,
    [update_date]                   datetime          NULL,
    [update_user_id]                varchar(30)       NULL,
    [record_state]                  varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_availability] 
 */

CREATE TABLE [dbo].[tnd_tndr_availability](
    [organization_id]    int            NOT NULL,
    [tndr_id]            varchar(60)    NOT NULL,
    [availability_code]  varchar(30)    NOT NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     varchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     varchar(30)    NULL,
    [record_state]       varchar(30)    NULL,
    CONSTRAINT [pk_tnd_tndr_availability] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [availability_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_availability_p] 
 */

CREATE TABLE [dbo].[tnd_tndr_availability_p](
    [organization_id]    int               NOT NULL,
    [tndr_id]            varchar(60)       NOT NULL,
    [availability_code]  varchar(30)       NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_availability_p] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [availability_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_denomination] 
 */

CREATE TABLE [dbo].[tnd_tndr_denomination](
    [organization_id]  int               NOT NULL,
    [tndr_id]          varchar(60)       NOT NULL,
    [denomination_id]  varchar(60)       NOT NULL,
    [description]      varchar(254)      NULL,
    [value]            decimal(17, 6)    NULL,
    [sort_order]       int               NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_denomination] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [denomination_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_denomination_p] 
 */

CREATE TABLE [dbo].[tnd_tndr_denomination_p](
    [organization_id]  int               NOT NULL,
    [tndr_id]          varchar(60)       NOT NULL,
    [denomination_id]  varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_denomination_p] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [denomination_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_options] 
 */

CREATE TABLE [dbo].[tnd_tndr_options](
    [organization_id]               int               NOT NULL,
    [tndr_id]                       varchar(60)       NOT NULL,
    [config_element]                varchar(200)      DEFAULT '*' NOT NULL,
    [auth_mthd_code]                varchar(30)       NULL,
    [serial_id_nbr_req_flag]        bit               DEFAULT 0 NULL,
    [auth_req_flag]                 bit               DEFAULT 0 NULL,
    [auth_expr_date_req_flag]       bit               DEFAULT 0 NULL,
    [pin_req_flag]                  bit               DEFAULT 0 NULL,
    [cust_sig_req_flag]             bit               DEFAULT 0 NULL,
    [endorsement_req_flag]          bit               DEFAULT 0 NULL,
    [open_cash_drawer_req_flag]     bit               DEFAULT 0 NULL,
    [unit_count_req_code]           varchar(30)       NULL,
    [mag_swipe_reader_req_flag]     bit               DEFAULT 0 NULL,
    [dflt_to_amt_due_flag]          bit               DEFAULT 0 NULL,
    [min_denomination_amt]          decimal(17, 6)    NULL,
    [reporting_group]               varchar(30)       NULL,
    [effective_date]                datetime          NULL,
    [expr_date]                     datetime          NULL,
    [min_days_for_return]           int               NULL,
    [max_days_for_return]           int               NULL,
    [cust_id_req_code]              varchar(30)       NULL,
    [cust_association_flag]         bit               DEFAULT 0 NULL,
    [populate_system_count_flag]    bit               DEFAULT 0 NULL,
    [include_in_type_count_flag]    bit               DEFAULT 0 NULL,
    [suggested_deposit_threshold]   decimal(17, 6)    NULL,
    [suggest_deposit_flag]          bit               DEFAULT 0 NULL,
    [change_tndr_id]                varchar(60)       NULL,
    [cash_change_limit]             decimal(17, 6)    NULL,
    [over_tender_overridable_flag]  bit               DEFAULT 0 NULL,
    [non_voidable_flag]             bit               DEFAULT 0 NULL,
    [disallow_split_tndr_flag]      bit               DEFAULT 0 NULL,
    [close_count_disc_threshold]    decimal(17, 6)    NULL,
    [cid_msr_req_flag]              bit               DEFAULT 0 NULL,
    [cid_keyed_req_flag]            bit               DEFAULT 0 NULL,
    [postal_code_req_flag]          bit               DEFAULT 0 NULL,
    [post_void_open_drawer_flag]    bit               DEFAULT 0 NULL,
    [change_allowed_when_foreign]   bit               DEFAULT 0 NULL,
    [fiscal_tndr_id]                varchar(10)       NULL,
    [rounding_mode]                 varchar(254)      NULL,
    [assign_cash_drawer_req_flag]   bit               DEFAULT 0 NULL,
    [post_void_assign_drawer_flag]  bit               DEFAULT 0 NULL,
    [create_date]                   datetime          NULL,
    [create_user_id]                varchar(30)       NULL,
    [update_date]                   datetime          NULL,
    [update_user_id]                varchar(30)       NULL,
    [record_state]                  varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_options] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [config_element])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_options_p] 
 */

CREATE TABLE [dbo].[tnd_tndr_options_p](
    [organization_id]  int               NOT NULL,
    [tndr_id]          varchar(60)       NOT NULL,
    [config_element]   varchar(200)      DEFAULT '*' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_options_p] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [config_element], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_p] 
 */

CREATE TABLE [dbo].[tnd_tndr_p](
    [organization_id]  int               NOT NULL,
    [tndr_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_p] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_typcode] 
 */

CREATE TABLE [dbo].[tnd_tndr_typcode](
    [organization_id]             int               NOT NULL,
    [tndr_typcode]                varchar(30)       NOT NULL,
    [description]                 varchar(254)      NULL,
    [sort_order]                  int               NULL,
    [unit_count_req_code]         varchar(30)       NULL,
    [close_count_disc_threshold]  decimal(17, 6)    NULL,
    [hidden_flag]                 bit               DEFAULT 0 NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_typcode] PRIMARY KEY CLUSTERED ([organization_id], [tndr_typcode]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_typcode_p] 
 */

CREATE TABLE [dbo].[tnd_tndr_typcode_p](
    [organization_id]  int               NOT NULL,
    [tndr_typcode]     varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_typcode_p] PRIMARY KEY CLUSTERED ([organization_id], [tndr_typcode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_user_settings] 
 */

CREATE TABLE [dbo].[tnd_tndr_user_settings](
    [organization_id]               int               NOT NULL,
    [tndr_id]                       varchar(60)       NOT NULL,
    [group_id]                      varchar(60)       NOT NULL,
    [usage_code]                    varchar(30)       NOT NULL,
    [entry_mthd_code]               varchar(60)       DEFAULT ('DEFAULT') NOT NULL,
	[config_element]				varchar(200)	  DEFAULT ('*') NOT NULL,
    [online_floor_approval_amt]     decimal(17, 6)    NULL,
    [online_ceiling_approval_amt]   decimal(17, 6)    NULL,
    [over_tndr_limit]               decimal(17, 6)    NULL,
    [offline_floor_approval_amt]    decimal(17, 6)    NULL,
    [offline_ceiling_approval_amt]  decimal(17, 6)    NULL,
    [min_accept_amt]                decimal(17, 6)    NULL,
    [max_accept_amt]                decimal(17, 6)    NULL,
    [max_refund_with_receipt]       decimal(17, 6)    NULL,
    [max_refund_wo_receipt]         decimal(17, 6)    NULL,
    [create_date]                   datetime          NULL,
    [create_user_id]                varchar(30)       NULL,
    [update_date]                   datetime          NULL,
    [update_user_id]                varchar(30)       NULL,
    [record_state]                  varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_user_settings] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [group_id], [usage_code], [entry_mthd_code],[config_element]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tnd_tndr_user_settings_p] 
 */

CREATE TABLE [dbo].[tnd_tndr_user_settings_p](
    [organization_id]  int               NOT NULL,
    [tndr_id]          varchar(60)       NOT NULL,
    [group_id]         varchar(60)       NOT NULL,
    [usage_code]       varchar(30)       NOT NULL,
    [entry_mthd_code]  varchar(60)       DEFAULT 'DEFAULT' NOT NULL,
    [config_element]   varchar(200)      DEFAULT '*' NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tnd_tndr_user_settings_p] PRIMARY KEY CLUSTERED ([organization_id], [tndr_id], [group_id], [usage_code], [entry_mthd_code], [config_element], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_ar_sale_lineitm] 
 */

CREATE TABLE [dbo].[trl_ar_sale_lineitm](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [business_date]       datetime        NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [acct_nbr]            varchar(60)     NULL,
    [auth_mthd_code]      varchar(30)     NULL,
    [adjudication_code]   varchar(30)     NULL,
    [entry_mthd_code]     varchar(30)     NULL,
    [auth_code]           varchar(30)     NULL,
    [activity_code]       varchar(30)     NULL,
    [reference_nbr]       varchar(254)    NULL,
    [acct_user_id]	      varchar(30)	  null,
    [acct_user_name]      varchar(254)	  null,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_trl_ar_sale_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_commission_mod] 
 */

CREATE TABLE [dbo].[trl_commission_mod](
    [organization_id]         int               NOT NULL,
    [rtl_loc_id]              int               NOT NULL,
    [business_date]           datetime          NOT NULL,
    [wkstn_id]                bigint            NOT NULL,
    [trans_seq]               bigint            NOT NULL,
    [rtrans_lineitm_seq]      int               NOT NULL,
    [commission_mod_seq_nbr]  int               NOT NULL,
    [typcode]                 varchar(30)       NULL,
    [amt]                     decimal(17, 6)    NULL,
    [percentage]              decimal(6, 4)     NULL,
    [percentage_of_item]      decimal(6, 4)     NULL,
    [employee_party_id]       bigint            NULL,
    [unverifiable_emp_id]     varchar(60)       NULL,
    [create_date]             datetime          NULL,
    [create_user_id]          varchar(30)       NULL,
    [update_date]             datetime          NULL,
    [update_user_id]          varchar(30)       NULL,
    [record_state]            varchar(30)       NULL,
    CONSTRAINT [pk_trl_commission_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [commission_mod_seq_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_commission_mod_p] 
 */

CREATE TABLE [dbo].[trl_commission_mod_p](
    [organization_id]         int               NOT NULL,
    [rtl_loc_id]              int               NOT NULL,
    [business_date]           datetime          NOT NULL,
    [wkstn_id]                bigint            NOT NULL,
    [trans_seq]               bigint            NOT NULL,
    [rtrans_lineitm_seq]      int               NOT NULL,
    [commission_mod_seq_nbr]  int               NOT NULL,
    [property_code]           varchar(30)       NOT NULL,
    [type]                    varchar(30)       NULL,
    [string_value]            varchar(max)      NULL,
    [date_value]              datetime          NULL,
    [decimal_value]           decimal(17, 6)    NULL,
    [create_date]             datetime          NULL,
    [create_user_id]          varchar(30)       NULL,
    [update_date]             datetime          NULL,
    [update_user_id]          varchar(30)       NULL,
    [record_state]            varchar(30)       NULL,
    CONSTRAINT [pk_trl_commission_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [commission_mod_seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_correction_mod] 
 */

CREATE TABLE [dbo].[trl_correction_mod](
    [organization_id]              int               NOT NULL,
    [rtl_loc_id]                   int               NOT NULL,
    [business_date]                datetime          NOT NULL,
    [wkstn_id]                     bigint            NOT NULL,
    [trans_seq]                    bigint            NOT NULL,
    [rtrans_lineitm_seq]           int               NOT NULL,
    [original_rtl_loc_id]          int               NULL,
    [original_wkstn_id]            bigint            NULL,
    [original_business_date]       datetime          NULL,
    [original_trans_seq]           bigint            NULL,
    [original_rtrans_lineitm_seq]  int               NULL,
    [reascode]                     varchar(30)       NULL,
    [notes]                        varchar(254)      NULL,
    [original_base_unit_amt]       decimal(17, 6)    NULL,
    [original_base_extended_amt]   decimal(17, 6)    NULL,
    [original_unit_amt]            decimal(17, 6)    NULL,
    [original_extended_amt]        decimal(17, 6)    NULL,
    [original_tax_amt]             decimal(17, 6)    NULL,
    [create_date]                  datetime          NULL,
    [create_user_id]               varchar(30)       NULL,
    [update_date]                  datetime          NULL,
    [update_user_id]               varchar(30)       NULL,
    [record_state]                 varchar(30)       NULL,
    CONSTRAINT [pk_trl_correction_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_correction_mod_p] 
 */

CREATE TABLE [dbo].[trl_correction_mod_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [business_date]       datetime          NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_correction_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_coupon_lineitm] 
 */

CREATE TABLE [dbo].[trl_coupon_lineitm](
    [organization_id]           int               NOT NULL,
    [rtrans_lineitm_seq]        int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [business_date]             datetime          NOT NULL,
    [wkstn_id]                  bigint            NOT NULL,
    [trans_seq]                 bigint            NOT NULL,
    [coupon_id]                 varchar(254)      NULL,
    [typcode]                   varchar(30)       NULL,
    [serialized_flag]           bit               DEFAULT ((0)) NULL,
    [expr_date]                 datetime          NULL,
    [entry_mthd_code]           varchar(30)       NULL,
    [manufacturer_id]           varchar(254)      NULL,
    [value_code]                varchar(30)       NULL,
    [manufacturer_family_code]  varchar(254)      NULL,
    [amt_entered]               decimal(17, 6)    NULL,
    [authorized_flag]           bit               DEFAULT ((0)) NULL,
    [redemption_trans_id]       varchar(60)       NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_trl_coupon_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_cust_item_acct_mod] 
 */

CREATE TABLE [dbo].[trl_cust_item_acct_mod](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [business_date]             datetime          NOT NULL,
    [wkstn_id]                  bigint            NOT NULL,
    [trans_seq]                 bigint            NOT NULL,
    [rtrans_lineitm_seq]        int               NOT NULL,
    [cust_acct_id]              varchar(60)       NULL,
    [cust_acct_code]            varchar(30)       NULL,
    [item_acct_extended_price]  decimal(17, 6)    NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_trl_cust_item_acct_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_cust_item_acct_mod_p] 
 */

CREATE TABLE [dbo].[trl_cust_item_acct_mod_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_cust_item_acct_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_deal_lineitm] 
 */

CREATE TABLE [dbo].[trl_deal_lineitm](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [amt]                 decimal(17, 6)    NULL,
    [deal_id]             varchar(60)       NOT NULL,
    [discount_reascode]   varchar(30)       NOT NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_deal_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_dimension_mod] 
 */

CREATE TABLE [dbo].[trl_dimension_mod](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [business_date]       datetime        NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [dimension_code]      varchar(30)     NOT NULL,
    [value]               varchar(256)    NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_trl_dimension_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [dimension_code]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_dimension_mod_p] 
 */

CREATE TABLE [dbo].[trl_dimension_mod_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [dimension_code]      varchar(30)       NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_dimension_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [dimension_code], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_discount_lineitm] 
 */

CREATE TABLE [dbo].[trl_discount_lineitm](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [discount_code]       varchar(60)       NULL,
    [percentage]          decimal(6, 4)     NULL,
    [amt]                 decimal(17, 6)    NULL,
    [serial_number]       varchar(254)      NULL,
    [new_price_quantity]  decimal(11, 4)    NULL,
    [new_price]           decimal(17, 6)    NULL,
    [taxability_code]     varchar(30)       NULL,
    [award_trans_id]      varchar(60)       NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_discount_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_escrow_trans] 
 */

CREATE TABLE [dbo].[trl_escrow_trans](
    [organization_id]   int               NOT NULL,
    [rtl_loc_id]        int               NOT NULL,
    [business_date]     datetime          NOT NULL,
    [wkstn_id]          bigint            NOT NULL,
    [trans_seq]         bigint            NOT NULL,
    [escrow_amt]        decimal(17, 6)    NULL,
    [cust_party_id]     bigint            NULL,
    [cust_acct_id]      varchar(60)       NULL,
    [activity_seq_nbr]  bigint            NULL,
    [create_date]       datetime          NULL,
    [create_user_id]    varchar(30)       NULL,
    [update_date]       datetime          NULL,
    [update_user_id]    varchar(30)       NULL,
    [record_state]      varchar(30)       NULL,
    CONSTRAINT [pk_trl_escrow_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_invctl_document_mod] 
 */

CREATE TABLE [dbo].[trl_invctl_document_mod](
    [organization_id]             int            NOT NULL,
    [rtl_loc_id]                  int            NOT NULL,
    [business_date]               datetime       NOT NULL,
    [wkstn_id]                    bigint         NOT NULL,
    [trans_seq]                   bigint         NOT NULL,
    [invctl_document_mod_seq]     int            NOT NULL,
    [invctl_document_rtl_loc_id]  int	         NULL,
    [invctl_document_id]          varchar(60)    NULL,
    [document_typcode]            varchar(30)    NULL,
    [create_date]                 datetime       NULL,
    [create_user_id]              varchar(30)    NULL,
    [update_date]                 datetime       NULL,
    [update_user_id]              varchar(30)    NULL,
    [record_state]                varchar(30)    NULL,
    CONSTRAINT [pk_trl_invctl_document_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [invctl_document_mod_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_invctl_document_mod_p] 
 */

CREATE TABLE [dbo].[trl_invctl_document_mod_p](
    [organization_id]          int               NOT NULL,
    [rtl_loc_id]               int               NOT NULL,
    [business_date]            datetime          NOT NULL,
    [wkstn_id]                 bigint            NOT NULL,
    [trans_seq]                bigint            NOT NULL,
    [invctl_document_mod_seq]  int               NOT NULL,
    [property_code]            varchar(30)       NOT NULL,
    [type]                     varchar(30)       NULL,
    [string_value]             varchar(max)      NULL,
    [date_value]               datetime          NULL,
    [decimal_value]            decimal(17, 6)    NULL,
    [create_date]              datetime          NULL,
    [create_user_id]           varchar(30)       NULL,
    [update_date]              datetime          NULL,
    [update_user_id]           varchar(30)       NULL,
    [record_state]             varchar(30)       NULL,
    CONSTRAINT [pk_trl_invctl_document_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [invctl_document_mod_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_inventory_loc_mod] 
 */

CREATE TABLE [dbo].[trl_inventory_loc_mod](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [mod_seq]             int               NOT NULL,
    [serial_nbr]          varchar(254)      NULL,
    [source_location_id]  varchar(60)       NULL,
    [source_bucket_id]    varchar(60)       NULL,
    [dest_location_id]    varchar(60)       NULL,
    [dest_bucket_id]      varchar(60)       NULL,
    [quantity]            decimal(11, 4)    NULL,
    [action_code]         varchar(30)       NULL,
    [void_flag]           bit               DEFAULT ((0)) NULL,
    [item_id]             varchar(60)       NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_inventory_loc_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [mod_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_inventory_loc_mod_p] 
 */

CREATE TABLE [dbo].[trl_inventory_loc_mod_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [mod_seq]             int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_inventory_loc_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [mod_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_kit_component_mod] 
 */

CREATE TABLE [dbo].[trl_kit_component_mod](
    [organization_id]      int             NOT NULL,
    [rtl_loc_id]           int             NOT NULL,
    [business_date]        datetime        NOT NULL,
    [wkstn_id]             bigint          NOT NULL,
    [trans_seq]            bigint          NOT NULL,
    [rtrans_lineitm_seq]   int             NOT NULL,
    [component_item_id]    varchar(60)     NOT NULL,
    [seq_nbr]              int             NOT NULL DEFAULT 1,
    [component_item_desc]  varchar(254)    NULL,
    [display_order]        int             NULL,
    [quantity]             int             NULL,
    [kit_item_id]          varchar(60)     NULL,
    [serial_nbr]           varchar(60)     NULL,
    [create_date]          datetime        NULL,
    [create_user_id]       varchar(30)     NULL,
    [update_date]          datetime        NULL,
    [update_user_id]       varchar(30)     NULL,
    [record_state]         varchar(30)     NULL,
    CONSTRAINT [pk_trl_kit_component_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [component_item_id], [seq_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_kit_component_mod_p] 
 */

CREATE TABLE [dbo].[trl_kit_component_mod_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [component_item_id]   varchar(60)       NOT NULL,
    [seq_nbr]             int               NOT NULL DEFAULT 1,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_kit_component_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [component_item_id], [seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_lineitm_assoc_mod] 
 */

CREATE TABLE [dbo].[trl_lineitm_assoc_mod](
    [organization_id]            int            NOT NULL,
    [parent_rtrans_lineitm_seq]  int            NOT NULL,
    [parent_rtl_loc_id]          int            NOT NULL,
    [parent_business_date]       datetime       NOT NULL,
    [parent_wkstn_id]            bigint         NOT NULL,
    [parent_trans_seq]           bigint         NOT NULL,
    [lineitm_assoc_mod_seq]      int            NOT NULL,
    [lineitm_assoc_typcode]      varchar(30)    NULL,
    [child_rtrans_lineitm_seq]   int            NULL,
    [child_rtl_loc_id]           int            NULL,
    [child_wkstn_id]             bigint         NULL,
    [child_business_date]        datetime       NULL,
    [child_trans_seq]            bigint         NULL,
    [create_date]                datetime       NULL,
    [create_user_id]             varchar(30)    NULL,
    [update_date]                datetime       NULL,
    [update_user_id]             varchar(30)    NULL,
    [record_state]               varchar(30)    NULL,
    CONSTRAINT [pk_trl_lineitm_assoc_mod] PRIMARY KEY CLUSTERED ([organization_id], [parent_rtl_loc_id], [parent_business_date], [parent_wkstn_id], [parent_trans_seq], [parent_rtrans_lineitm_seq], [lineitm_assoc_mod_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_lineitm_assoc_mod_p] 
 */

CREATE TABLE [dbo].[trl_lineitm_assoc_mod_p](
    [organization_id]            int               NOT NULL,
    [parent_rtl_loc_id]          int               NOT NULL,
    [parent_business_date]       datetime          NOT NULL,
    [parent_wkstn_id]            bigint            NOT NULL,
    [parent_trans_seq]           bigint            NOT NULL,
    [parent_rtrans_lineitm_seq]  int               NOT NULL,
    [lineitm_assoc_mod_seq]      int               NOT NULL,
    [property_code]              varchar(30)       NOT NULL,
    [type]                       varchar(30)       NULL,
    [string_value]               varchar(max)      NULL,
    [date_value]                 datetime          NULL,
    [decimal_value]              decimal(17, 6)    NULL,
    [create_date]                datetime          NULL,
    [create_user_id]             varchar(30)       NULL,
    [update_date]                datetime          NULL,
    [update_user_id]             varchar(30)       NULL,
    [record_state]               varchar(30)       NULL,
    CONSTRAINT [pk_trl_lineitm_assoc_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [parent_rtl_loc_id], [parent_business_date], [parent_wkstn_id], [parent_trans_seq], [parent_rtrans_lineitm_seq], [lineitm_assoc_mod_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_lineitm_assoc_typcode] 
 */

CREATE TABLE [dbo].[trl_lineitm_assoc_typcode](
    [organization_id]                int             NOT NULL,
    [lineitm_assoc_typcode]          varchar(30)     NOT NULL,
    [description]                    varchar(254)    NULL,
    [sort_order]                     int             NULL,
    [parent_restrict_quantity_flag]  bit             DEFAULT ((0)) NULL,
    [child_restrict_quantity_flag]   bit             DEFAULT ((0)) NULL,
    [parent_restrict_price_flag]     bit             DEFAULT ((0)) NULL,
    [child_restrict_price_flag]      bit             DEFAULT ((0)) NULL,
    [parent_restrict_delete_flag]    bit             DEFAULT ((0)) NULL,
    [child_restrict_delete_flag]     bit             DEFAULT ((0)) NULL,
    [cascade_delete_flag]            bit             DEFAULT ((0)) NULL,
    [cascade_quantity_flag]          bit             DEFAULT ((0)) NOT NULL,
    [create_date]                    datetime        NULL,
    [create_user_id]                 varchar(30)     NULL,
    [update_date]                    datetime        NULL,
    [update_user_id]                 varchar(30)     NULL,
    [record_state]                   varchar(30)     NULL,
    CONSTRAINT [pk_trl_lineitm_assoc_typcode] PRIMARY KEY CLUSTERED ([organization_id], [lineitm_assoc_typcode]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_lineitm_assoc_typcode_p] 
 */

CREATE TABLE [dbo].[trl_lineitm_assoc_typcode_p](
    [organization_id]        int               NOT NULL,
    [lineitm_assoc_typcode]  varchar(30)       NOT NULL,
    [property_code]          varchar(30)       NOT NULL,
    [type]                   varchar(30)       NULL,
    [string_value]           varchar(max)      NULL,
    [date_value]             datetime          NULL,
    [decimal_value]          decimal(17, 6)    NULL,
    [create_date]            datetime          NULL,
    [create_user_id]         varchar(30)       NULL,
    [update_date]            datetime          NULL,
    [update_user_id]         varchar(30)       NULL,
    [record_state]           varchar(30)       NULL,
    CONSTRAINT [pk_trl_lineitm_assoc_typcode_p] PRIMARY KEY CLUSTERED ([organization_id], [lineitm_assoc_typcode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_lineitm_notes] 
 */

CREATE TABLE [dbo].[trl_lineitm_notes](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [business_date]       datetime        NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [note_seq]            int             NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [note_datetime]       datetime        NULL,
    [posted_flag]         bit             DEFAULT ((0)) NULL,
    [note]                varchar(max)    NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_trl_lineitm_notes] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [note_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_lineitm_notes_p] 
 */

CREATE TABLE [dbo].[trl_lineitm_notes_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [note_seq]            int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_lineitm_notes_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [note_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_returned_item_count] 
 */

CREATE TABLE [dbo].[trl_returned_item_count](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [returned_count]      decimal(11, 4)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_returned_item_count] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_returned_item_count_p] 
 */

CREATE TABLE [dbo].[trl_returned_item_count_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_returned_item_count_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_returned_item_journal] 
 */

CREATE TABLE [dbo].[trl_returned_item_journal](
    [organization_id]         int               NOT NULL,
    [rtl_loc_id]              int               NOT NULL,
    [business_date]           datetime          NOT NULL,
    [wkstn_id]                bigint            NOT NULL,
    [trans_seq]               bigint            NOT NULL,
    [rtrans_lineitm_seq]      int               NOT NULL,
    [journal_seq]             bigint            NOT NULL,
    [returned_count]          decimal(11, 4)    NULL,
    [rtn_rtl_loc_id]          int               NULL,
    [rtn_wkstn_id]            bigint            NULL,
    [rtn_business_date]       datetime          NULL,
    [rtn_trans_seq]           bigint            NULL,
    [rtn_rtrans_lineitm_seq]  int               NULL,
    [create_date]             datetime          NULL,
    [create_user_id]          varchar(30)       NULL,
    [update_date]             datetime          NULL,
    [update_user_id]          varchar(30)       NULL,
    [record_state]            varchar(30)       NULL,
    CONSTRAINT [pk_trl_returned_item_journal] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [journal_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_returned_item_journal_p] 
 */

CREATE TABLE [dbo].[trl_returned_item_journal_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [journal_seq]         bigint            NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_returned_item_journal_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [journal_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_rtl_price_mod] 
 */

CREATE TABLE [dbo].[trl_rtl_price_mod](
    [organization_id]          int               NOT NULL,
    [rtl_loc_id]               int               NOT NULL,
    [business_date]            datetime          NOT NULL,
    [wkstn_id]                 bigint            NOT NULL,
    [rtrans_lineitm_seq]       int               NOT NULL,
    [rtl_price_mod_seq_nbr]    int               NOT NULL,
    [trans_seq]                bigint            NOT NULL,
    [promotion_id]             varchar(60)       NULL,
    [percentage]               decimal(6, 4)     NULL,
    [amt]                      decimal(17, 6)    NULL,
    [price_change_amt]         decimal(17, 6)    NULL,
    [notes]                    varchar(254)      NULL,
    [rtl_price_mod_reascode]   varchar(30)       NULL,
    [void_flag]                bit               DEFAULT ((0)) NULL,
    [disc_rtrans_lineitm_seq]  int               NULL,
    [disc_rtl_loc_id]          int               NULL,
    [disc_wkstn_id]            bigint            NULL,
    [disc_business_date]       datetime          NULL,
    [disc_trans_seq]           bigint            NULL,
    [discount_code]            varchar(60)       NULL,
    [price_change_reascode]    varchar(30)       NULL,
    [deal_id]                  varchar(60)       NULL,
    [deal_amt]                 decimal(17, 6)    NULL,
    [serial_number]            varchar(254)      NULL,
    [discount_group_id]        int               NULL,
    [description]              varchar(254)      NULL,
    [discount_reascode]        varchar(30)       NULL,
    [extended_amt]             decimal(17, 6)    NULL,
    [taxability_code]          varchar(30)       NULL,
    [create_date]              datetime          NULL,
    [create_user_id]           varchar(30)       NULL,
    [update_date]              datetime          NULL,
    [update_user_id]           varchar(30)       NULL,
    [record_state]             varchar(30)       NULL,
    CONSTRAINT [pk_trl_rtl_price_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [rtl_price_mod_seq_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_rtl_price_mod_p] 
 */

CREATE TABLE [dbo].[trl_rtl_price_mod_p](
    [organization_id]        int               NOT NULL,
    [rtl_loc_id]             int               NOT NULL,
    [business_date]          datetime          NOT NULL,
    [wkstn_id]               bigint            NOT NULL,
    [trans_seq]              bigint            NOT NULL,
    [rtrans_lineitm_seq]     int               NOT NULL,
    [rtl_price_mod_seq_nbr]  int               NOT NULL,
    [property_code]          varchar(30)       NOT NULL,
    [type]                   varchar(30)       NULL,
    [string_value]           varchar(max)      NULL,
    [date_value]             datetime          NULL,
    [decimal_value]          decimal(17, 6)    NULL,
    [create_date]            datetime          NULL,
    [create_user_id]         varchar(30)       NULL,
    [update_date]            datetime          NULL,
    [update_user_id]         varchar(30)       NULL,
    [record_state]           varchar(30)       NULL,
    CONSTRAINT [pk_trl_rtl_price_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [rtl_price_mod_seq_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_rtrans] 
 */

CREATE TABLE [dbo].[trl_rtrans](
    [organization_id]      int               NOT NULL,
    [rtl_loc_id]           int               NOT NULL,
    [business_date]        datetime          NOT NULL,
    [wkstn_id]             bigint            NOT NULL,
    [trans_seq]            bigint            NOT NULL,
    [cust_party_id]        bigint            NULL,
    [subtotal]             decimal(17, 6)    NULL,
    [taxtotal]             decimal(17, 6)    NULL,
    [total]                decimal(17, 6)    NULL,
    [loyalty_card_number]  varchar(60)       NULL,
    [tax_exemption_id]     varchar(60)       NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_trl_rtrans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX idx_trl_rtrans01 ON dbo.trl_rtrans(cust_party_id) WITH (FILLFACTOR = 80);
GO




/* 
 * TABLE: [dbo].[trl_rtrans_flight_info] 
 */

CREATE TABLE [dbo].[trl_rtrans_flight_info](
    [organization_id]           int             NOT NULL,
    [rtl_loc_id]                int             NOT NULL,
    [business_date]             datetime        NOT NULL,
    [wkstn_id]                  bigint          NOT NULL,
    [trans_seq]                 bigint          NOT NULL,
    [flight_number]             varchar(30)     NOT NULL,
    [destination_airport]       varchar(3)      NULL,
    [destination_country]       varchar(2)      NULL,
    [destination_zone]          varchar(30)     NULL,
    [destination_airport_name]  varchar(254)    NULL,
    [origin_airport]            varchar(3)      NULL,
    [tax_calculation_mode]      varchar(30)     NULL,
    [first_flight_number]       varchar(30)     NULL,
    [first_destination_airport] varchar(3)      NULL,
    [first_origin_airport]      varchar(3)      NULL,
    [first_flight_seat_number]  varchar(4)      NULL,
    [first_flight_scheduled_date] datetime      NULL,
    [create_date]               datetime        NULL,
    [create_user_id]            varchar(30)     NULL,
    [update_date]               datetime        NULL,
    [update_user_id]            varchar(30)     NULL,
    [record_state]			    varchar(30)     NULL,
    CONSTRAINT [pk_trl_rtrans_flight_info] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_rtrans_flight_info_p] 
 */

CREATE TABLE [dbo].[trl_rtrans_flight_info_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [business_date]    datetime          NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trl_rtrans_flight_info_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_rtrans_lineitm] 
 */

CREATE TABLE [dbo].[trl_rtrans_lineitm](
    [organization_id]          int             NOT NULL,
    [rtl_loc_id]               int             NOT NULL,
    [business_date]            datetime        NOT NULL,
    [wkstn_id]                 bigint          NOT NULL,
    [trans_seq]                bigint          NOT NULL,
    [rtrans_lineitm_seq]       int             NOT NULL,
    [begin_date_timestamp]     datetime        NULL,
    [end_date_timestamp]       datetime        NULL,
    [notes]                    varchar(254)    NULL,
    [rtrans_lineitm_typcode]   varchar(30)     NULL,
    [rtrans_lineitm_statcode]  varchar(30)     NULL,
    [void_flag]                bit             DEFAULT ((0)) NULL,
    [dtv_class_name]           varchar(254)    NULL,
    [void_lineitm_reascode]    varchar(30)     NULL,
    [generic_storage_flag]     bit             DEFAULT ((0)) NULL,
    [tlog_lineitm_seq]         int             NULL,
    [currency_id]              varchar(3)      NULL,
    [create_date]              datetime        NULL,
    [create_user_id]           varchar(30)     NULL,
    [update_date]              datetime        NULL,
    [update_user_id]           varchar(30)     NULL,
    [record_state]             varchar(30)     NULL,
    CONSTRAINT [pk_trl_rtrans_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_trl_rtrans_lineitm01] 
 */

CREATE INDEX [idx_trl_rtrans_lineitm01] ON [dbo].[trl_rtrans_lineitm]([organization_id], [void_flag], [business_date]) WITH (FILLFACTOR = 80)
go

/* 
 * INDEX: [idx_trl_rtrans_lineitm02] 
 */

CREATE INDEX [idx_trl_rtrans_lineitm02] ON [dbo].[trl_rtrans_lineitm] ([organization_id],[rtl_loc_id],[wkstn_id],[trans_seq],[void_flag]) WITH (FILLFACTOR = 80)
GO


/* 
 * TABLE: [dbo].[trl_rtrans_lineitm_p] 
 */

CREATE TABLE [dbo].[trl_rtrans_lineitm_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_lineitm_properties] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_rtrans_serial_exchange] 
 */

CREATE TABLE [dbo].[trl_rtrans_serial_exchange](
    [organization_id]          int               NOT NULL,
    [rtl_loc_id]               int               NOT NULL,
    [business_date]            datetime          NOT NULL,
    [wkstn_id]                 bigint            NOT NULL,
    [trans_seq]                bigint            NOT NULL,
    [rtrans_lineitm_seq]       int               NOT NULL,
    [item_id]                  varchar(60)       NULL,
    [orig_serial_nbr]          varchar(60)       NULL,
    [new_serial_nbr]           varchar(60)       NULL,
    [exchange_comment]         varchar(254)      NULL,
    [exchange_reason_code]     varchar(30)       NULL,
    [orig_lineitm_seq]         int               NULL,
    [orig_rtl_loc_id]          int               NULL,
    [orig_wkstn_id]            bigint            NULL,
    [orig_business_date]       datetime          NULL,
    [orig_trans_seq]           bigint            NULL,
    [create_date]              datetime          NULL,
    [create_user_id]           varchar(30)       NULL,
    [update_date]              datetime          NULL,
    [update_user_id]           varchar(30)       NULL,
    [record_state]             varchar(30)       NULL,
    CONSTRAINT [pk_trl_rtrans_serial_exchange] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go


/* 
 * TABLE: [dbo].[trl_rtrans_serial_exchange_p] 
 */

CREATE TABLE [dbo].[trl_rtrans_serial_exchange_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trl_rtrans_serial_xchg_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go


/* 
 * TABLE: [dbo].[trl_sale_lineitm] 
 */

CREATE TABLE [dbo].[trl_sale_lineitm](
    [organization_id]               int               NOT NULL,
    [rtl_loc_id]                    int               NOT NULL,
    [business_date]                 datetime          NOT NULL,
    [wkstn_id]                      bigint            NOT NULL,
    [trans_seq]                     bigint            NOT NULL,
    [rtrans_lineitm_seq]            int               NOT NULL,
    [merch_level_1]                 varchar(60)       NULL,
    [item_id]                       varchar(60)       NULL,
    [quantity]                      decimal(11, 4)    NULL,
    [gross_quantity]                decimal(11, 4)    NULL,
    [net_quantity]                  decimal(11, 4)    NULL,
    [unit_price]                    decimal(17, 6)    NULL,
    [extended_amt]                  decimal(17, 6)    NULL,
    [vat_amt]                       decimal(17, 6)    NULL,
    [return_flag]                   bit               DEFAULT 0 NULL,
    [item_id_entry_mthd_code]       varchar(30)       NULL,
    [price_entry_mthd_code]         varchar(30)       NULL,
    [price_derivtn_mthd_code]       varchar(30)       NULL,
    [price_property_code]           varchar(60)       NULL,
    [net_amt]                       decimal(17, 6)    NULL,
    [gross_amt]                     decimal(17, 6)    NULL,
    [serial_nbr]                    varchar(60)       NULL,
    [returned_quantity]             decimal(11, 4)    NULL,
    [scanned_item_id]               varchar(60)       NULL,
    [sale_lineitm_typcode]          varchar(30)       NULL,
    [tax_group_id]                  varchar(60)       NULL,
    [inventory_action_code]         varchar(30)       NULL,
    [original_rtrans_lineitm_seq]   int               NULL,
    [original_rtl_loc_id]           int	              NULL,
    [original_wkstn_id]             bigint            NULL,
    [original_business_date]        datetime          NULL,
    [original_trans_seq]            bigint            NULL,
    [return_comment]                varchar(254)      NULL,
    [return_reascode]               varchar(30)       NULL,
    [return_typcode]                varchar(30)       NULL,
    [rcpt_count]                    int               NULL,
    [base_unit_price]               decimal(17, 6)    NULL,
    [base_extended_price]           decimal(17, 6)    NULL,
    [force_zero_extended_amt_flag]  bit               DEFAULT 0 NULL,
    [entered_description]           varchar(254)      NULL,
    [rpt_base_unit_price]           decimal(17, 6)    NULL,
    [food_stamps_applied_amount]    decimal(17, 6)    NULL,
    [vendor_id]                     varchar(60)       NULL,
    [regular_base_price]            decimal(17, 6)    NULL,
    [shipping_weight]               decimal(12, 3)    NULL,
    [unit_cost]                     decimal(17, 6)    NULL,
    [attached_item_flag]			bit				  NULL,
    [initial_quantity]				decimal(11,4)	  NULL,
    [not_returnable_flag]           bit               DEFAULT 0 NULL,
    [exclude_from_net_sales_flag]   bit               DEFAULT 0 NULL,
	[measure_req_flag]				bit				  DEFAULT 0 NULL,
	[weight_entry_mthd_code]		varchar(30)		  NULL,
	[tare_value]					decimal(11, 4)	  NULL,
	[tare_type]						varchar(30)		  NULL,
	[tare_unit_of_measure_code]		varchar(30)		  NULL,
    [create_date]                   datetime          NULL,
    [create_user_id]                varchar(30)       NULL,
    [update_date]                   datetime          NULL,
    [update_user_id]                varchar(30)       NULL,
    [record_state]                  varchar(30)       NULL,
    CONSTRAINT [pk_trl_sale_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_trl_sale_lineitm01] 
 */

CREATE INDEX [idx_trl_sale_lineitm01] ON [dbo].[trl_sale_lineitm]([organization_id], [business_date], [sale_lineitm_typcode]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[trl_sale_tax_lineitm] 
 */

CREATE TABLE [dbo].[trl_sale_tax_lineitm](
    [organization_id]          int               NOT NULL,
    [rtl_loc_id]               int               NOT NULL,
    [business_date]            datetime          NOT NULL,
    [wkstn_id]                 bigint            NOT NULL,
    [trans_seq]                bigint            NOT NULL,
    [rtrans_lineitm_seq]       int               NOT NULL,
    [sale_tax_lineitm_seq]     int               NOT NULL,
    [taxable_amt]              decimal(17, 6)    NULL,
    [tax_amt]                  decimal(17, 6)    NULL,
    [tax_exempt_amt]           decimal(17, 6)    NULL,
    [tax_loc_id]               varchar(60)       NULL,
    [tax_group_id]             varchar(60)       NULL,
    [tax_rule_seq_nbr]         int               NULL,
    [tax_exemption_id]         varchar(60)       NULL,
    [tax_override_amt]         decimal(17, 6)    NULL,
    [tax_override_percentage]  decimal(10, 8)    NULL,
    [tax_override_bracket_id]  varchar(60)       NULL,
    [tax_override_flag]        bit               DEFAULT ((0)) NULL,
    [tax_override_reascode]    varchar(30)       NULL,
    [void_flag]                bit               DEFAULT ((0)) NULL,
    [raw_tax_percentage]       decimal(10, 8)    NULL,
    [raw_tax_amount]           decimal(17, 6)    NULL,
    [exempt_tax_amount]        decimal(17, 6)    NULL,
    [tax_percentage]           decimal(10, 8)    NULL,
    [authority_id]             varchar(60)       NULL,
    [authority_name]           varchar(254)      NULL,
    [authority_type_code]      varchar(60)       NULL,
    [tax_override_comment]     varchar(255)	     NULL,
    [orig_taxable_amount]      decimal(17, 6)    NULL,
    [orig_tax_group_id]        varchar(60)       NULL,
    [create_date]              datetime          NULL,
    [create_user_id]           varchar(30)       NULL,
    [update_date]              datetime          NULL,
    [update_user_id]           varchar(30)       NULL,
    [record_state]             varchar(30)       NULL,
    CONSTRAINT [pk_trl_sale_tax_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [sale_tax_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_sale_tax_lineitm_p] 
 */

CREATE TABLE [dbo].[trl_sale_tax_lineitm_p](
    [organization_id]       int               NOT NULL,
    [rtl_loc_id]            int               NOT NULL,
    [business_date]         datetime          NOT NULL,
    [wkstn_id]              bigint            NOT NULL,
    [trans_seq]             bigint            NOT NULL,
    [rtrans_lineitm_seq]    int               NOT NULL,
    [sale_tax_lineitm_seq]  int               NOT NULL,
    [property_code]         varchar(30)       NOT NULL,
    [type]                  varchar(30)       NULL,
    [string_value]          varchar(max)      NULL,
    [date_value]            datetime          NULL,
    [decimal_value]         decimal(17, 6)    NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_trl_sale_tax_lineitm_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [sale_tax_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trl_tax_lineitm] 
 */

CREATE TABLE [dbo].[trl_tax_lineitm](
    [organization_id]          int               NOT NULL,
    [rtl_loc_id]               int               NOT NULL,
    [business_date]            datetime          NOT NULL,
    [wkstn_id]                 bigint            NOT NULL,
    [trans_seq]                bigint            NOT NULL,
    [rtrans_lineitm_seq]       int               NOT NULL,
    [tax_rule_seq_nbr]         int               NULL,
    [tax_group_id]             varchar(60)       NULL,
    [taxable_amt]              decimal(17, 6)    NULL,
    [tax_amt]                  decimal(17, 6)    NULL,
    [tax_override_flag]        bit               DEFAULT ((0)) NULL,
    [tax_override_amt]         decimal(17, 6)    NULL,
    [tax_override_percentage]  decimal(10, 8)    NULL,
    [tax_override_reascode]    varchar(30)       NULL,
    [tax_loc_id]               varchar(60)       NOT NULL,
    [raw_tax_percentage]       decimal(8, 6)     NULL,
    [raw_tax_amount]           decimal(17, 6)    NULL,
    [tax_percentage]           decimal(12, 6)    NULL,
    [authority_id]             varchar(60)       NULL,
    [authority_name]           varchar(254)      NULL,
    [authority_type_code]      varchar(60)       NULL,
    [create_date]              datetime          NULL,
    [create_user_id]           varchar(30)       NULL,
    [update_date]              datetime          NULL,
    [update_user_id]           varchar(30)       NULL,
    [record_state]             varchar(30)       NULL,
    CONSTRAINT [pk_trl_tax_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_voucher_discount_lineitm] 
 */

CREATE TABLE [dbo].[trl_voucher_discount_lineitm](
    [organization_id]      int               NOT NULL,
    [rtl_loc_id]           int               NOT NULL,
    [business_date]        datetime          NOT NULL,
    [wkstn_id]             bigint            NOT NULL,
    [trans_seq]            bigint            NOT NULL,
    [rtrans_lineitm_seq]   int               NOT NULL,
    [voucher_typcode]      varchar(30)       NULL,
    [auth_mthd_code]       varchar(30)       NULL,
    [track1]               varchar(254)      NULL,
    [track2]               varchar(254)      NULL,
    [track3]               varchar(254)      NULL,
    [adjudication_code]    varchar(30)       NULL,
    [entry_mthd_code]      varchar(30)       NULL,
    [auth_code]            varchar(30)       NULL,
    [activity_code]        varchar(30)       NULL,
    [reference_nbr]        varchar(254)      NULL,
    [effective_date]       datetime          NULL,
    [expr_date]            datetime          NULL,
    [face_value_amt]       decimal(17, 6)    NULL,
    [issue_datetime]       datetime          NULL,
    [issue_typcode]        varchar(30)       NULL,
    [unspent_balance_amt]  decimal(17, 6)    NULL,
    [voucher_status_code]  varchar(30)       NULL,
    [serial_nbr]           varchar(30)       NULL,
    [trace_number]         varchar(60)       NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_trl_voucher_discount_lnitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_voucher_sale_lineitm] 
 */

CREATE TABLE [dbo].[trl_voucher_sale_lineitm](
    [organization_id]      int               NOT NULL,
    [rtl_loc_id]           int               NOT NULL,
    [business_date]        datetime          NOT NULL,
    [wkstn_id]             bigint            NOT NULL,
    [trans_seq]            bigint            NOT NULL,
    [rtrans_lineitm_seq]   int               NOT NULL,
    [serial_nbr]           varchar(60)       NULL,
    [voucher_typcode]      varchar(30)       NULL,
    [auth_mthd_code]       varchar(30)       NULL,
    [track1]               varchar(254)      NULL,
    [track2]               varchar(254)      NULL,
    [track3]               varchar(254)      NULL,
    [adjudication_code]    varchar(100)      NULL,
    [entry_mthd_code]      varchar(30)       NULL,
    [auth_code]            varchar(30)       NULL,
    [activity_code]        varchar(30)       NULL,
    [reference_nbr]        varchar(254)      NULL,
    [effective_date]       datetime          NULL,
    [expr_date]            datetime          NULL,
    [face_value_amt]       decimal(17, 6)    NULL,
    [issue_datetime]       datetime          NULL,
    [issue_typcode]        varchar(30)       NULL,
    [unspent_balance_amt]  decimal(17, 6)    NULL,
    [voucher_status_code]  varchar(30)       NULL,
    [trace_number]         varchar(60)       NULL,
    [orig_local_date_time] varchar(20)        NULL,
    [orig_transmission_date_time] varchar(20) NULL,
    [orig_STAN]            varchar(30)       NULL,
    [merchant_cat_code]    varchar(4)        NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_trl_voucher_sale_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_warranty_modifier] 
 */

CREATE TABLE [dbo].[trl_warranty_modifier](
    [organization_id]        int            NOT NULL,
    [rtl_loc_id]             int            NOT NULL,
    [business_date]          datetime       NOT NULL,
    [wkstn_id]               bigint         NOT NULL,
    [trans_seq]              bigint         NOT NULL,
    [rtrans_lineitm_seq]     int            NOT NULL,
    [warranty_modifier_seq]  int            NOT NULL,
    [warranty_nbr]           varchar(30)    NULL,
    [warranty_typcode]       varchar(60)    NULL,
    [create_date]            datetime       NULL,
    [create_user_id]         varchar(30)    NULL,
    [update_date]            datetime       NULL,
    [update_user_id]         varchar(30)    NULL,
    [record_state]           varchar(30)    NULL,
    CONSTRAINT [pk_trl_warranty_modifier] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [warranty_modifier_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trl_warranty_modifier_p] 
 */

CREATE TABLE [dbo].[trl_warranty_modifier_p](
    [organization_id]        int               NOT NULL,
    [rtl_loc_id]             int               NOT NULL,
    [business_date]          datetime          NOT NULL,
    [wkstn_id]               bigint            NOT NULL,
    [trans_seq]              bigint            NOT NULL,
    [rtrans_lineitm_seq]     int               NOT NULL,
    [warranty_modifier_seq]  int               NOT NULL,
    [property_code]          varchar(30)       NOT NULL,
    [type]                   varchar(30)       NULL,
    [string_value]           varchar(max)      NULL,
    [date_value]             datetime          NULL,
    [decimal_value]          decimal(17, 6)    NULL,
    [create_date]            datetime          NULL,
    [create_user_id]         varchar(30)       NULL,
    [update_date]            datetime          NULL,
    [update_user_id]         varchar(30)       NULL,
    [record_state]           varchar(30)       NULL,
    CONSTRAINT [pk_trl_warranty_modifier_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [warranty_modifier_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trn_generic_lineitm_storage] 
 */

CREATE TABLE [dbo].[trn_generic_lineitm_storage](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [business_date]       datetime        NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [form_key]            varchar(50)     NULL,
    [data_storage]        varchar(max)    NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_trn_generic_lineitm_strg] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trn_generic_lineitm_storage_p] 
 */

CREATE TABLE [dbo].[trn_generic_lineitm_storage_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pktrngenericlineitmstoragep] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: trn_gift_registry_trans 
 */

CREATE TABLE trn_gift_registry_trans(
    organization_id    int            NOT NULL,
    rtl_loc_id         int            NOT NULL,
    business_date      datetime       NOT NULL,
    wkstn_id           bigint         NOT NULL,
    trans_seq          bigint         NOT NULL,
    registry_id        bigint         NULL,
    create_date        datetime       NULL,
    create_user_id     varchar(30)    NULL,
    update_date        datetime       NULL,
    update_user_id     varchar(30)    NULL,
    record_state       varchar(30)    NULL,
    CONSTRAINT pk_trn_gift_registry_trans PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq) WITH (FILLFACTOR = 80)
)
go


/* 
 * TABLE: [dbo].[trn_no_sale_trans] 
 */

CREATE TABLE [dbo].[trn_no_sale_trans](
    [organization_id]   int            NOT NULL,
    [rtl_loc_id]        int            NOT NULL,
    [business_date]     datetime       NOT NULL,
    [wkstn_id]          bigint         NOT NULL,
    [trans_seq]         bigint         NOT NULL,
    [no_sale_reascode]  varchar(30)    NULL,
    [create_date]       datetime       NULL,
    [create_user_id]    varchar(30)    NULL,
    [update_date]       datetime       NULL,
    [update_user_id]    varchar(30)    NULL,
    [record_state]      varchar(30)    NULL,
    CONSTRAINT [pk_trn_no_sale_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trn_poslog_data] 
 */

CREATE TABLE [dbo].[trn_poslog_data](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [business_date]    datetime        NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [trans_seq]        bigint          NOT NULL,
    [poslog_data]      varchar(max)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_trn_poslog_data] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trn_poslog_data_p] 
 */

CREATE TABLE [dbo].[trn_poslog_data_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trn_poslog_data_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trn_post_void_trans] 
 */

CREATE TABLE [dbo].[trn_post_void_trans](
    [organization_id]          int            NOT NULL,
    [rtl_loc_id]               int            NOT NULL,
    [business_date]            datetime       NOT NULL,
    [wkstn_id]                 bigint         NOT NULL,
    [trans_seq]                bigint         NOT NULL,
    [voided_rtl_store_id]      int		      NULL,
    [voided_wkstn_id]          bigint         NULL,
    [voided_business_date]     datetime       NULL,
    [voided_trans_id]          bigint         NULL,
    [voided_org_id]            int            NULL,
    [post_void_reascode]       varchar(30)    NULL,
    [voided_trans_entry_code]  varchar(30)    NULL,
    [create_date]              datetime       NULL,
    [create_user_id]           varchar(30)    NULL,
    [update_date]              datetime       NULL,
    [update_user_id]           varchar(30)    NULL,
    [record_state]             varchar(30)    NULL,
    CONSTRAINT [pk_trn_post_void_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [trn_raincheck] 
 */

CREATE TABLE [trn_raincheck](
    [organization_id]           int               NOT NULL,
    [rain_check_id]             varchar(20)       NOT NULL,
    [item_id]                   varchar(60)       NULL,
    [sale_price]                decimal(17, 6)    NULL,
    [expiration_business_date]  datetime          NULL,
    [redeemed_flag]             bit               DEFAULT 0 NULL,
	[rtl_loc_id]				int				  NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_trn_raincheck] PRIMARY KEY CLUSTERED ([organization_id], [rain_check_id])
    WITH FILLFACTOR = 80
)
go


/* 
 * TABLE: [dbo].[trn_raincheck_p] 
 */

CREATE TABLE [dbo].[trn_raincheck_p](
    [organization_id]  int               NOT NULL,
    [rain_check_id]    varchar(20)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trn_raincheck_p] PRIMARY KEY CLUSTERED ([organization_id], [rain_check_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [trn_raincheck_trans] 
 */

CREATE TABLE [trn_raincheck_trans](
    [organization_id]           int               NOT NULL,
    [rtl_loc_id]                int               NOT NULL,
    [business_date]             datetime          NOT NULL,
    [wkstn_id]                  bigint            NOT NULL,
    [trans_seq]                 bigint            NOT NULL,
    [rain_check_id]				varchar(20)		  NOT NULL,
    [create_date]               datetime          NULL,
    [create_user_id]            varchar(30)       NULL,
    [update_date]               datetime          NULL,
    [update_user_id]            varchar(30)       NULL,
    [record_state]              varchar(30)       NULL,
    CONSTRAINT [pk_trn_raincheck_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq])
    WITH FILLFACTOR = 80
)
go


/* 
 * TABLE: [dbo].[trn_receipt_data] 
 */

CREATE TABLE [dbo].[trn_receipt_data](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [receipt_id]       varchar(60)       NOT NULL,
    [receipt_data]     varbinary(max)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trn_receipt_data] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [receipt_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trn_receipt_data_p] 
 */

CREATE TABLE [dbo].[trn_receipt_data_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [receipt_id]       varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trn_receipt_data_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [receipt_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trn_receipt_lookup] 
 */

CREATE TABLE [dbo].[trn_receipt_lookup](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [business_date]    datetime        NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [trans_seq]        bigint          NOT NULL,
    [receipt_id]       varchar(60)     NOT NULL,
    [receipt_url]      varchar(254)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_trn_receipt_lookup] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [receipt_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trn_receipt_lookup_p] 
 */

CREATE TABLE [dbo].[trn_receipt_lookup_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [receipt_id]       varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trn_receipt_lookup_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [receipt_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trn_trans] 
 */

CREATE TABLE [dbo].[trn_trans](
    [organization_id]        int               NOT NULL,
    [rtl_loc_id]             int               NOT NULL,
    [business_date]          datetime          NOT NULL,
    [wkstn_id]               bigint            NOT NULL,
    [trans_seq]              bigint            NOT NULL,
    [session_rtl_loc_id]     int		       NULL,
    [begin_datetime]         datetime          NULL,
    [end_datetime]           datetime          NULL,
    [keyed_offline_flag]     bit               DEFAULT ((0)) NULL,
    [session_id]             bigint            NULL,
    [operator_party_id]      bigint            NULL,
    [posted_flag]            bit               DEFAULT ((0)) NULL,
    [dtv_class_name]         varchar(254)      NULL,
    [total]                  decimal(17, 6)    NULL,
    [taxtotal]               decimal(17, 6)    NULL,
    [roundtotal]             decimal(17, 6)    NULL,
    [subtotal]               decimal(17, 6)    NULL,
    [trans_cancel_reascode]  varchar(30)       NULL,
    [trans_typcode]          varchar(30)       NULL,
    [trans_statcode]         varchar(30)       NULL,
    [post_void_flag]         bit               DEFAULT ((0)) NULL,
    [generic_storage_flag]   bit               DEFAULT ((0)) NULL,
    [begin_time_int]         int               NULL,
    [cash_drawer_id]         varchar(60)       NULL,
    [flash_sales_flag]       bit               DEFAULT ((0)) NULL,
	[fiscal_number]			 varchar(10)	   NULL,
	[trans_date]			 datetime		   NULL,
    [create_date]            datetime          NULL,
    [create_user_id]         varchar(30)       NULL,
    [update_date]            datetime          NULL,
    [update_user_id]         varchar(30)       NULL,
    [record_state]           varchar(30)       NULL,
    CONSTRAINT [pk_trn_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_trn_trans01] 
 */

CREATE INDEX [idx_trn_trans01] ON [dbo].[trn_trans]([flash_sales_flag]) WITH (FILLFACTOR = 80)
go

/* 
 * INDEX: [idx_trn_trans02] 
 */

CREATE INDEX [idx_trn_trans02] ON [dbo].[trn_trans]([organization_id], [trans_statcode], [post_void_flag], [business_date]) WITH (FILLFACTOR = 80)
go

/* 
 * INDEX: [idx_trn_trans03] 
 */

CREATE INDEX idx_trn_trans03 ON trn_trans (rtl_loc_id,business_date,trans_typcode,trans_statcode,post_void_flag)
INCLUDE (organization_id,wkstn_id,trans_seq) WITH (FILLFACTOR = 80);
go

/* 
 * INDEX: [idx_trn_trans05] 
 */

CREATE INDEX [idx_trn_trans05] ON [dbo].[trn_trans]([trans_date]) WITH (FILLFACTOR = 80);
go
/* 
 * TABLE: [dbo].[trn_trans_link] 
 */

CREATE TABLE [dbo].[trn_trans_link](
    [organization_id]     int            NOT NULL,
    [rtl_loc_id]          int            NOT NULL,
    [business_date]       datetime       NOT NULL,
    [wkstn_id]            bigint         NOT NULL,
    [trans_seq]           bigint         NOT NULL,
    [link_rtl_loc_id]     int            NOT NULL,
    [link_business_date]  datetime       NOT NULL,
    [link_wkstn_id]       bigint         NOT NULL,
    [link_trans_seq]      bigint         NOT NULL,
    [link_typcode]        varchar(30)    NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_trn_trans_link] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [link_rtl_loc_id], [link_business_date], [link_wkstn_id], [link_trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trn_trans_link_p] 
 */

CREATE TABLE [dbo].[trn_trans_link_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [link_rtl_loc_id]     int               NOT NULL,
    [link_business_date]  datetime          NOT NULL,
    [link_wkstn_id]       bigint            NOT NULL,
    [link_trans_seq]      bigint            NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_trn_trans_link_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [link_rtl_loc_id], [link_business_date], [link_wkstn_id], [link_trans_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trn_trans_notes] 
 */

CREATE TABLE [dbo].[trn_trans_notes](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [business_date]    datetime        NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [trans_seq]        bigint          NOT NULL,
    [note_seq]         int             NOT NULL,
    [note_datetime]    datetime        NULL,
    [posted_flag]      bit             DEFAULT ((0)) NULL,
    [note]             varchar(max)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [pk_trn_trans_notes] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [note_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trn_trans_notes_p] 
 */

CREATE TABLE [dbo].[trn_trans_notes_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [note_seq]         int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trn_trans_notes_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [note_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trn_trans_p] 
 */

CREATE TABLE [dbo].[trn_trans_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trn_trans_properties] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[trn_trans_version] 
 */

CREATE TABLE [dbo].[trn_trans_version](
    [organization_id]          int            NOT NULL,
    [rtl_loc_id]               int            NOT NULL,
    [wkstn_id]                 bigint         NOT NULL,
    [business_date]            datetime       NOT NULL,
    [trans_seq]                bigint         NOT NULL,
    [base_app_version]         varchar(30)    NULL,
    [base_app_date]            datetime       NULL,
    [base_schema_version]      varchar(30)    NULL,
    [base_schema_date]         datetime       NULL,
    [customer_app_version]     varchar(30)    NULL,
    [customer_app_date]        datetime       NULL,
    [customer_schema_version]  varchar(30)    NULL,
    [customer_schema_date]     datetime       NULL,
    [create_date]              datetime       NULL,
    [create_user_id]           varchar(30)    NULL,
    [update_date]              datetime       NULL,
    [update_user_id]           varchar(30)    NULL,
    [record_state]             varchar(30)    NULL,
    CONSTRAINT [pk_trn_trans_version] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[trn_trans_version_p] 
 */

CREATE TABLE [dbo].[trn_trans_version_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [business_date]    datetime          NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_trn_trans_version_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_serialized_tndr_count] 
 */

CREATE TABLE [dbo].[tsn_serialized_tndr_count](
    [organization_id]            int               NOT NULL,
    [rtl_loc_id]                 int               NOT NULL,
    [business_date]              datetime          NOT NULL,
    [wkstn_id]                   bigint            NOT NULL,
    [tndr_typcode]               varchar(30)       NOT NULL,
    [trans_seq]                  bigint            NOT NULL,
    [serialized_tndr_count_seq]  int               NOT NULL,
    [tndr_id]                    varchar(60)       NULL,
    [serial_number]              varchar(60)       NULL,
    [amt]                        decimal(17, 6)    NULL,
    [difference_amt]             decimal(17, 6)    NULL,
    [create_date]                datetime          NULL,
    [create_user_id]             varchar(30)       NULL,
    [update_date]                datetime          NULL,
    [update_user_id]             varchar(30)       NULL,
    [record_state]               varchar(30)       NULL,
    CONSTRAINT [pk_tsn_serialized_tndr_count] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [tndr_typcode], [serialized_tndr_count_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_serialized_tndr_count_p] 
 */

CREATE TABLE [dbo].[tsn_serialized_tndr_count_p](
    [organization_id]            int               NOT NULL,
    [rtl_loc_id]                 int               NOT NULL,
    [business_date]              datetime          NOT NULL,
    [wkstn_id]                   bigint            NOT NULL,
    [trans_seq]                  bigint            NOT NULL,
    [tndr_typcode]               varchar(30)       NOT NULL,
    [serialized_tndr_count_seq]  int               NOT NULL,
    [property_code]              varchar(30)       NOT NULL,
    [type]                       varchar(30)       NULL,
    [string_value]               varchar(max)      NULL,
    [date_value]                 datetime          NULL,
    [decimal_value]              decimal(17, 6)    NULL,
    [create_date]                datetime          NULL,
    [create_user_id]             varchar(30)       NULL,
    [update_date]                datetime          NULL,
    [update_user_id]             varchar(30)       NULL,
    [record_state]               varchar(30)       NULL,
    CONSTRAINT [pk_tsn_serialized_tndr_count_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [tndr_typcode], [serialized_tndr_count_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_session] 
 */

CREATE TABLE [dbo].[tsn_session](
    [organization_id]     int            NOT NULL,
    [rtl_loc_id]          int            NOT NULL,
    [session_id]          bigint         NOT NULL,
    [tndr_repository_id]  varchar(60)    NULL,
    [employee_party_id]   bigint         NULL,
    [begin_datetime]      datetime       NULL,
    [end_datetime]        datetime       NULL,
    [business_date]       datetime       NULL,
    [statcode]            varchar(30)    NULL,
    [cash_drawer_id]      varchar(60)    NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_tsn_session] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [session_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_session_control_trans] 
 */

CREATE TABLE [dbo].[tsn_session_control_trans](
    [organization_id]    int            NOT NULL,
    [rtl_loc_id]         int            NOT NULL,
    [business_date]      datetime       NOT NULL,
    [wkstn_id]           bigint         NOT NULL,
    [trans_seq]          bigint         NOT NULL,
    [typcode]            varchar(30)    NULL,
    [session_wkstn_seq]  int            NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     varchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     varchar(30)    NULL,
    [record_state]       varchar(30)    NULL,
    CONSTRAINT [pk_tsn_session_control_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_session_p] 
 */

CREATE TABLE [dbo].[tsn_session_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [session_id]       bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tsn_session_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [session_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_session_tndr] 
 */

CREATE TABLE [dbo].[tsn_session_tndr](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [tndr_id]             varchar(60)       NOT NULL,
    [session_id]          bigint            NOT NULL,
    [actual_media_count]  int               NULL,
    [actual_media_amt]    decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_tsn_session_tndr] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tndr_id], [session_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_session_tndr_p] 
 */

CREATE TABLE [dbo].[tsn_session_tndr_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [tndr_id]          varchar(60)       NOT NULL,
    [session_id]       bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tsn_session_tndr_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tndr_id], [session_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_session_wkstn] 
 */

CREATE TABLE [dbo].[tsn_session_wkstn](
    [organization_id]    int            NOT NULL,
    [rtl_loc_id]         int            NOT NULL,
    [session_id]         bigint         NOT NULL,
    [session_wkstn_seq]  int            NOT NULL,
    [wkstn_id]           bigint         NULL,
    [cash_drawer_id]     varchar(60)    NULL,
    [begin_datetime]     datetime       NULL,
    [end_datetime]       datetime       NULL,
    [attached_flag]      bit            DEFAULT ((0)) NOT NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     varchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     varchar(30)    NULL,
    [record_state]       varchar(30)    NULL,
    CONSTRAINT [pk_tsn_session_wkstn] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [session_id], [session_wkstn_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_session_wkstn_p] 
 */

CREATE TABLE [dbo].[tsn_session_wkstn_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [session_id]         bigint            NOT NULL,
    [session_wkstn_seq]  int               NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pk_tsn_session_wkstn_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [session_id], [session_wkstn_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_till_control_trans] 
 */

CREATE TABLE [dbo].[tsn_till_control_trans](
    [organization_id]  int            NOT NULL,
    [rtl_loc_id]       int            NOT NULL,
    [business_date]    datetime       NOT NULL,
    [wkstn_id]         bigint         NOT NULL,
    [trans_seq]        bigint         NOT NULL,
    [typcode]          varchar(30)    NULL,
    [employee_id]      varchar(60)    NULL,
    [reason_code]      varchar(30)    NULL,
    [create_date]      datetime       NULL,
    [create_user_id]   varchar(30)    NULL,
    [update_date]      datetime       NULL,
    [update_user_id]   varchar(30)    NULL,
    [record_state]     varchar(30)    NULL,
    CONSTRAINT [pk_tsn_till_control_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_till_ctrl_trans_detail] 
 */

CREATE TABLE [dbo].[tsn_till_ctrl_trans_detail](
    [organization_id]              int               NOT NULL,
    [rtl_loc_id]                   int               NOT NULL,
    [business_date]                datetime          NOT NULL,
    [wkstn_id]                     bigint            NOT NULL,
    [trans_seq]                    bigint            NOT NULL,
    [trans_lineitm_seq]            int               NOT NULL,
    [affected_tndr_repository_id]  varchar(60)       NULL,
    [affected_wkstn_id]            bigint            NULL,
    [old_amount]                   decimal(17, 6)    NULL,
    [new_amount]                   decimal(17, 6)    NULL,
    [currency_id]				   varchar(3)        NULL,
    [create_date]                  datetime          NULL,
    [create_user_id]               varchar(30)       NULL,
    [update_date]                  datetime          NULL,
    [update_user_id]               varchar(30)       NULL,
    [record_state]                 varchar(30)       NULL,
    CONSTRAINT [pk_tsn_till_control_trans_dtl] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_till_ctrl_trans_detail_p] 
 */

CREATE TABLE [dbo].[tsn_till_ctrl_trans_detail_p](
    [organization_id]    int               NOT NULL,
    [rtl_loc_id]         int               NOT NULL,
    [business_date]      datetime          NOT NULL,
    [wkstn_id]           bigint            NOT NULL,
    [trans_seq]          bigint            NOT NULL,
    [trans_lineitm_seq]  int               NOT NULL,
    [property_code]      varchar(30)       NOT NULL,
    [type]               varchar(30)       NULL,
    [string_value]       varchar(max)      NULL,
    [date_value]         datetime          NULL,
    [decimal_value]      decimal(17, 6)    NULL,
    [create_date]        datetime          NULL,
    [create_user_id]     varchar(30)       NULL,
    [update_date]        datetime          NULL,
    [update_user_id]     varchar(30)       NULL,
    [record_state]       varchar(30)       NULL,
    CONSTRAINT [pktsntillctrltransdetailp] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [trans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_control_trans] 
 */

CREATE TABLE [dbo].[tsn_tndr_control_trans](
    [organization_id]              int               NOT NULL,
    [rtl_loc_id]                   int               NOT NULL,
    [business_date]                datetime          NOT NULL,
    [wkstn_id]                     bigint            NOT NULL,
    [trans_seq]                    bigint            NOT NULL,
    [amt]                          decimal(17, 6)    NULL,
    [reascode]                     varchar(30)       NULL,
    [typcode]                      varchar(30)       NULL,
    [funds_receipt_party_id]       bigint            NULL,
    [outbound_session_id]          bigint            NULL,
    [inbound_session_id]           bigint            NULL,
    [outbound_tndr_repository_id]  varchar(60)       NULL,
    [inbound_tndr_repository_id]   varchar(60)       NULL,
    [deposit_date]                 datetime          NULL,
    [safe_bag_id]                  varchar(60)       NULL,
    [create_date]                  datetime          NULL,
    [create_user_id]               varchar(30)       NULL,
    [update_date]                  datetime          NULL,
    [update_user_id]               varchar(30)       NULL,
    [record_state]                 varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_control_trans] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_denomination_count] 
 */

CREATE TABLE [dbo].[tsn_tndr_denomination_count](
    [organization_id]         int               NOT NULL,
    [rtl_loc_id]              int               NOT NULL,
    [business_date]           datetime          NOT NULL,
    [wkstn_id]                bigint            NOT NULL,
    [trans_seq]               bigint            NOT NULL,
    [tndr_typcode]            varchar(30)       NOT NULL,
    [tndr_id]                 varchar(60)       NOT NULL,
    [denomination_id]         varchar(60)       NOT NULL,
    [amt]                     decimal(17, 6)    NULL,
    [media_count]             int               NULL,
    [difference_amt]          decimal(17, 6)    NULL,
    [difference_media_count]  int               NULL,
    [create_date]             datetime          NULL,
    [create_user_id]          varchar(30)       NULL,
    [update_date]             datetime          NULL,
    [update_user_id]          varchar(30)       NULL,
    [record_state]            varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_denomination_cnt] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [tndr_typcode], [tndr_id], [denomination_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_denomination_count_p] 
 */

CREATE TABLE [dbo].[tsn_tndr_denomination_count_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [tndr_typcode]     varchar(30)       NOT NULL,
    [tndr_id]          varchar(60)       NOT NULL,
    [denomination_id]  varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pktsntndrdenominationcountp] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [tndr_typcode], [tndr_id], [denomination_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_repository] 
 */

CREATE TABLE [dbo].[tsn_tndr_repository](
    [organization_id]                int               NOT NULL,
    [rtl_loc_id]                     int               NOT NULL,
    [tndr_repository_id]             varchar(60)       NOT NULL,
    [typcode]                        varchar(30)       NULL,
    [not_issuable_flag]              bit               DEFAULT ((0)) NOT NULL,
    [name]                           varchar(254)      NULL,
    [description]                    varchar(254)      NULL,
    [dflt_wkstn_id]                  bigint            NULL,
    [create_date]                    datetime          NULL,
    [create_user_id]                 varchar(30)       NULL,
    [update_date]                    datetime          NULL,
    [update_user_id]                 varchar(30)       NULL,
    [record_state]                   varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_repository] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tndr_repository_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_repository_float] 
 */

CREATE TABLE [dbo].[tsn_tndr_repository_float](
    [organization_id]      int               NOT NULL,
    [tndr_repository_id]   varchar(60)       NOT NULL,
    [rtl_loc_id]           int               NOT NULL,
    [currency_id]          varchar(3)        NOT NULL,
    [default_cash_float]   decimal(17, 6)    NULL,
    [last_closing_amount]  decimal(17, 6)    NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]		   varchar(30)	     NULL,
    CONSTRAINT [pk_tsn_tndr_repository_float] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tndr_repository_id], [currency_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_repository_float_p] 
 */

CREATE TABLE [dbo].[tsn_tndr_repository_float_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [tndr_repository_id]  varchar(60)       NOT NULL,
    [currency_id]         varchar(3)        NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_repository_float_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tndr_repository_id], [currency_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_repository_p] 
 */

CREATE TABLE [dbo].[tsn_tndr_repository_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [tndr_repository_id]  varchar(60)       NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_repository_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tndr_repository_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_repository_status] 
 */

CREATE TABLE [dbo].[tsn_tndr_repository_status](
    [organization_id]     int            NOT NULL,
    [rtl_loc_id]          int            NOT NULL,
    [tndr_repository_id]  varchar(60)    NOT NULL,
    [issued_flag]         bit            DEFAULT 0 NOT NULL,
    [active_session_id]   bigint         NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_tsn_tndr_repository_status] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tndr_repository_id])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_repository_status_p] 
 */

CREATE TABLE [dbo].[tsn_tndr_repository_status_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [tndr_repository_id]  varchar(60)       NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pktsntndrrepositorystatusp] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [tndr_repository_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_tndr_count] 
 */

CREATE TABLE [dbo].[tsn_tndr_tndr_count](
    [organization_id]         int               NOT NULL,
    [rtl_loc_id]              int               NOT NULL,
    [business_date]           datetime          NOT NULL,
    [wkstn_id]                bigint            NOT NULL,
    [trans_seq]               bigint            NOT NULL,
    [tndr_typcode]            varchar(30)       NOT NULL,
    [tndr_id]                 varchar(60)       NOT NULL,
    [amt]                     decimal(17, 6)    NULL,
    [media_count]             int               NULL,
    [difference_amt]          decimal(17, 6)    NULL,
    [difference_media_count]  int               NULL,
    [deposit_amt]             decimal(17, 6)    NULL,
	[local_currency_amt]	  decimal(17, 6)    NULL,
    [create_date]             datetime          NULL,
    [create_user_id]          varchar(30)       NULL,
    [update_date]             datetime          NULL,
    [update_user_id]          varchar(30)       NULL,
    [record_state]            varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_tndr_count] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [tndr_typcode], [tndr_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_tndr_count_p] 
 */

CREATE TABLE [dbo].[tsn_tndr_tndr_count_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [tndr_typcode]     varchar(30)       NOT NULL,
    [tndr_id]          varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_tndr_count_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [tndr_typcode], [tndr_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_typcode_count] 
 */

CREATE TABLE [dbo].[tsn_tndr_typcode_count](
    [organization_id]         int               NOT NULL,
    [rtl_loc_id]              int               NOT NULL,
    [business_date]           datetime          NOT NULL,
    [wkstn_id]                bigint            NOT NULL,
    [trans_seq]               bigint            NOT NULL,
    [tndr_typcode]            varchar(30)       NOT NULL,
    [amt]                     decimal(17, 6)    NULL,
    [media_count]             int               NULL,
    [difference_amt]          decimal(17, 6)    NULL,
    [difference_media_count]  int               NULL,
    [create_date]             datetime          NULL,
    [create_user_id]          varchar(30)       NULL,
    [update_date]             datetime          NULL,
    [update_user_id]          varchar(30)       NULL,
    [record_state]            varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_typcode_count] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [tndr_typcode]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_tndr_typcode_count_p] 
 */

CREATE TABLE [dbo].[tsn_tndr_typcode_count_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [tndr_typcode]     varchar(30)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tsn_tndr_typcode_count_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [tndr_typcode], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[tsn_xrtrans_lineitm] 
 */

CREATE TABLE [dbo].[tsn_xrtrans_lineitm](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [line_seq]         int               NOT NULL,
    [base_currency]    varchar(3)        NULL,
    [target_currency]  varchar(3)        NULL,
    [old_rate]         decimal(17, 6)    NULL,
    [new_rate]         decimal(17, 6)    NULL,
    [notes]            varchar(254)      NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tsn_xrtrans_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [line_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[tsn_xrtrans_lineitm_p] 
 */

CREATE TABLE [dbo].[tsn_xrtrans_lineitm_p](
    [organization_id]  int               NOT NULL,
    [rtl_loc_id]       int               NOT NULL,
    [business_date]    datetime          NOT NULL,
    [wkstn_id]         bigint            NOT NULL,
    [trans_seq]        bigint            NOT NULL,
    [line_seq]         int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_tsn_xrtrans_lineitm_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [line_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ttr_acct_credit_tndr_lineitm] 
 */

CREATE TABLE [dbo].[ttr_acct_credit_tndr_lineitm](
    [organization_id]     int            NOT NULL,
    [rtl_loc_id]          int            NOT NULL,
    [business_date]       datetime       NOT NULL,
    [wkstn_id]            bigint         NOT NULL,
    [trans_seq]           bigint         NOT NULL,
    [rtrans_lineitm_seq]  int            NOT NULL,
    [cust_acct_id]        varchar(60)    NULL,
    [cust_acct_code]      varchar(30)    NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [pk_ttr_acct_credit_tndr_lnitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_ar_tndr_lineitm] 
 */

CREATE TABLE [dbo].[ttr_ar_tndr_lineitm](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [business_date]       datetime        NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [acct_nbr]            varchar(60)     NULL,
    [party_id]            bigint          NULL,
    [acct_user_name]      varchar(254)    NULL,
    [approval_code]       varchar(30)     NULL,
    [po_number]           varchar(254)    NULL,
    [adjudication_code]   varchar(30)     NULL,
    [auth_mthd_code]      varchar(30)     NULL,
    [activity_code]       varchar(30)     NULL,
    [entry_mthd_code]     varchar(30)     NULL,
    [auth_code]           varchar(30)     NULL,
    [acct_user_id]	      varchar(30)	  null,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_ttr_ar_tndr_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go

CREATE INDEX idx_ttr_ar_tndr_lineitm01 ON dbo.ttr_ar_tndr_lineitm(party_id) WITH (FILLFACTOR = 80);
GO



/* 
 * TABLE: [dbo].[ttr_check_tndr_lineitm] 
 */

CREATE TABLE [dbo].[ttr_check_tndr_lineitm](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [business_date]       datetime        NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [bank_id]             varchar(254)    NULL,
    [check_acct_nbr]      varchar(254)    NULL,
    [check_seq_nbr]       varchar(254)    NULL,
    [adjudication_code]   varchar(30)     NULL,
    [cust_birth_date]     datetime        NULL,
    [auth_nbr]            varchar(254)    NULL,
    [entry_mthd_code]     varchar(30)     NULL,
    [auth_mthd_code]      varchar(30)     NULL,
    [micr]                varchar(254)    NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_ttr_check_tndr_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_coupon_tndr_lineitm] 
 */

CREATE TABLE [dbo].[ttr_coupon_tndr_lineitm](
    [organization_id]           int             NOT NULL,
    [rtl_loc_id]                int             NOT NULL,
    [business_date]             datetime        NOT NULL,
    [wkstn_id]                  bigint          NOT NULL,
    [trans_seq]                 bigint          NOT NULL,
    [rtrans_lineitm_seq]        int             NOT NULL,
    [manufacturer_id]           varchar(254)    NULL,
    [manufacturer_family_code]  varchar(254)    NULL,
    [typcode]                   varchar(30)     NULL,
    [scan_code]                 varchar(30)     NULL,
    [expr_date]                 datetime        NULL,
    [promotion_code]            varchar(30)     NULL,
    [key_entered_flag]          bit             DEFAULT ((0)) NULL,
    [create_date]               datetime        NULL,
    [create_user_id]            varchar(30)     NULL,
    [update_date]               datetime        NULL,
    [update_user_id]            varchar(30)     NULL,
    [record_state]              varchar(30)     NULL,
    CONSTRAINT [pk_ttr_coupon_tndr_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_credit_debit_tndr_lineitm] 
 */

CREATE TABLE [dbo].[ttr_credit_debit_tndr_lineitm](
    [organization_id]             int               NOT NULL,
    [rtl_loc_id]                  int               NOT NULL,
    [business_date]               datetime          NOT NULL,
    [wkstn_id]                    bigint            NOT NULL,
    [rtrans_lineitm_seq]          int               NOT NULL,
    [trans_seq]                   bigint            NOT NULL,
    [mediaissuer_id]              varchar(254)      NULL,
    [acct_nbr]                    varchar(254)      NULL,
    [personal_id_req_typcode]     varchar(30)       NULL,
    [personal_id_ref_nbr]         varchar(254)      NULL,
    [auth_mthd_code]              varchar(30)       NULL,
    [track2]                      varchar(254)      NULL,
    [track1]                      varchar(254)      NULL,
    [track3]                      varchar(254)      NULL,
    [adjudication_code]           varchar(30)       NULL,
    [entry_mthd_code]             varchar(30)       NULL,
    [expr_date]                   varchar(64)       NULL,
    [auth_nbr]                    varchar(254)      NULL,
    [ps2000]                      varchar(254)      NULL,
    [bank_reference_number]       varchar(254)      NULL,
    [customer_name]               varchar(254)      NULL,
    [cashback_amt]                decimal(17, 6)    NULL,
    [card_level_indicator]        varchar(30)       NULL,
    [acct_nbr_hash]               varchar(60)       NULL,
    [AUTHORIZATION_TOKEN]         varchar(60)       NULL,
    [transaction_reference_data]  varchar(254)      NULL,
    [trace_number]                varchar(60)       NULL,
    [tax_amt]                     decimal(17, 6)    NULL,
    [discount_amt]                decimal(17, 6)    NULL,
    [freight_amt]                 decimal(17, 6)    NULL,
    [duty_amt]                    decimal(17, 6)    NULL,
    [orig_local_date_time]        varchar(20)       NULL,
    [orig_transmission_date_time] varchar(20)       NULL,
    [orig_STAN]                   varchar(30)       NULL,
    [transaction_identifier]      varchar(20)       NULL,
    [CCV_error_code]              varchar(10)       NULL,
    [POS_entry_mode_change]       varchar(10)       NULL,
    [processing_code]             varchar(10)       NULL,
    [POS_entry_mode]              varchar(10)       NULL,
    [POS_addl_data]               varchar(20)       NULL,
    [network_result_indicator]    varchar(20)       NULL,
    [merchant_cat_code]           varchar(4)        NULL,
    [create_date]                 datetime          NULL,
    [create_user_id]              varchar(30)       NULL,
    [update_date]                 datetime          NULL,
    [update_user_id]              varchar(30)       NULL,
    [record_state]                varchar(30)       NULL,
    CONSTRAINT [pk_ttr_credit_debit_tndr_lnitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_identity_verification] 
 */

CREATE TABLE [dbo].[ttr_identity_verification](
    [organization_id]            int             NOT NULL,
    [rtl_loc_id]                 int             NOT NULL,
    [business_date]              datetime        NOT NULL,
    [wkstn_id]                   bigint          NOT NULL,
    [trans_seq]                  bigint          NOT NULL,
    [rtrans_lineitm_seq]         int             NOT NULL,
    [identity_verification_seq]  int             NOT NULL,
    [id_typcode]                 varchar(30)     NULL,
    [id_nbr]                     varchar(254)    NULL,
    [issuing_authority]          varchar(254)    NULL,
    [create_date]                datetime        NULL,
    [create_user_id]             varchar(30)     NULL,
    [update_date]                datetime        NULL,
    [update_user_id]             varchar(30)     NULL,
    [record_state]               varchar(30)     NULL,
    CONSTRAINT [pk_ttr_identity_verification] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [identity_verification_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_identity_verification_p] 
 */

CREATE TABLE [dbo].[ttr_identity_verification_p](
    [organization_id]            int               NOT NULL,
    [rtl_loc_id]                 int               NOT NULL,
    [business_date]              datetime          NOT NULL,
    [wkstn_id]                   bigint            NOT NULL,
    [trans_seq]                  bigint            NOT NULL,
    [rtrans_lineitm_seq]         int               NOT NULL,
    [identity_verification_seq]  int               NOT NULL,
    [property_code]              varchar(30)       NOT NULL,
    [type]                       varchar(30)       NULL,
    [string_value]               varchar(max)      NULL,
    [date_value]                 datetime          NULL,
    [decimal_value]              decimal(17, 6)    NULL,
    [create_date]                datetime          NULL,
    [create_user_id]             varchar(30)       NULL,
    [update_date]                datetime          NULL,
    [update_user_id]             varchar(30)       NULL,
    [record_state]               varchar(30)       NULL,
    CONSTRAINT [pk_ttr_identity_verification_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [identity_verification_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ttr_send_check_tndr_lineitm] 
 */

CREATE TABLE [dbo].[ttr_send_check_tndr_lineitm](
    [organization_id]         int             NOT NULL,
    [rtl_loc_id]              int             NOT NULL,
    [business_date]           datetime        NOT NULL,
    [wkstn_id]                bigint          NOT NULL,
    [trans_seq]               bigint          NOT NULL,
    [rtrans_lineitm_seq]      int             NOT NULL,
    [payable_to_name]         varchar(254)    NULL,
    [payable_to_address]      varchar(254)    NULL,
    [payable_to_city]         varchar(254)    NULL,
    [payable_to_state]        varchar(254)    NULL,
    [payable_to_postal_code]  varchar(254)    NULL,
    [reascode]                varchar(30)     NULL,
    [payable_to_address2]     varchar(254)    NULL,
    [payable_to_address3]     varchar(254)    NULL,
    [payable_to_address4]     varchar(254)    NULL,
    [payable_to_apt]          varchar(30)     NULL,
    [payable_to_country]      varchar(2)	  NULL,
	[payable_to_neighborhood] varchar(254)	  null,
	[payable_to_county]		  varchar(254)	  null,
    [create_date]             datetime        NULL,
    [create_user_id]          varchar(30)     NULL,
    [update_date]             datetime        NULL,
    [update_user_id]          varchar(30)     NULL,
    [record_state]            varchar(30)     NULL,
    CONSTRAINT [pk_ttr_send_check_tndr_lnitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_signature] 
 */

CREATE TABLE [dbo].[ttr_signature](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [business_date]       datetime        NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [signature]           varchar(max)    NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_ttr_signature] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_signature_p] 
 */

CREATE TABLE [dbo].[ttr_signature_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_ttr_signature_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ttr_tndr_auth_log] 
 */

CREATE TABLE [dbo].[ttr_tndr_auth_log](
    [organization_id]     int             NOT NULL,
    [rtl_loc_id]          int             NOT NULL,
    [business_date]       datetime        NOT NULL,
    [wkstn_id]            bigint          NOT NULL,
    [trans_seq]           bigint          NOT NULL,
    [rtrans_lineitm_seq]  int             NOT NULL,
    [attempt_seq]         int             NOT NULL,
    [response_code]       varchar(254)    NULL,
    [reference_nbr]       varchar(254)    NULL,
    [error_code]          varchar(254)    NULL,
    [error_text]          varchar(254)    NULL,
    [start_timestamp]     datetime        NULL,
    [end_timestamp]       datetime        NULL,
    [approval_code]       varchar(254)    NULL,
    [auth_type]           varchar(30)     NULL,
    [customer_name]       varchar(254)    NULL,
    [create_date]         datetime        NULL,
    [create_user_id]      varchar(30)     NULL,
    [update_date]         datetime        NULL,
    [update_user_id]      varchar(30)     NULL,
    [record_state]        varchar(30)     NULL,
    CONSTRAINT [pk_ttr_tndr_auth_log] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [attempt_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_tndr_auth_log_p] 
 */

CREATE TABLE [dbo].[ttr_tndr_auth_log_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [attempt_seq]         int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_ttr_tndr_auth_log_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [attempt_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ttr_tndr_lineitm] 
 */

CREATE TABLE [dbo].[ttr_tndr_lineitm](
    [organization_id]       int               NOT NULL,
    [rtl_loc_id]            int               NOT NULL,
    [business_date]         datetime          NOT NULL,
    [wkstn_id]              bigint            NOT NULL,
    [trans_seq]             bigint            NOT NULL,
    [rtrans_lineitm_seq]    int               NOT NULL,
    [amt]                   decimal(17, 6)    NULL,
    [change_flag]           bit               DEFAULT ((0)) NULL,
    [host_validation_flag]  bit               DEFAULT ((0)) NULL,
    [tndr_id]               varchar(60)       NULL,
    [serial_nbr]            varchar(254)      NULL,
    [tndr_statcode]         varchar(30)       NULL,
    [party_id]              bigint            NULL,
    [acct_user_name]        varchar(254)      NULL,
    [approval_code]         varchar(30)       NULL,
    [foreign_amt]           decimal(17, 6)    NULL,
    [exchange_rate]         decimal(17, 6)    NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [pk_ttr_tndr_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_voucher] 
 */

CREATE TABLE [dbo].[ttr_voucher](
    [organization_id]      int               NOT NULL,
    [voucher_typcode]      varchar(30)       NOT NULL,
    [serial_nbr]           varchar(60)       NOT NULL,
    [issue_datetime]       datetime          NULL,
    [effective_date]       datetime          NULL,
    [expr_date]            datetime          NULL,
    [face_value_amt]       decimal(17, 6)    NULL,
    [voucher_status_code]  varchar(30)       NULL,
    [issue_typcode]        varchar(30)       NULL,
    [unspent_balance_amt]  decimal(17, 6)    NULL,
    [currency_id]          varchar(3)        NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_ttr_voucher] PRIMARY KEY CLUSTERED ([organization_id], [voucher_typcode], [serial_nbr]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_voucher_history] 
 */

CREATE TABLE [dbo].[ttr_voucher_history](
    [organization_id]     int               NOT NULL,
    [voucher_typcode]     varchar(30)       NOT NULL,
    [serial_nbr]          varchar(60)       NOT NULL,
    [history_seq]         bigint            NOT NULL,
    [activity_code]       varchar(30)       NULL,
    [amt]                 decimal(17, 6)    NULL,
    [rtrans_lineitm_seq]  int               NULL,
    [rtl_loc_id]          int               NULL,
    [wkstn_id]            bigint            NULL,
    [business_date]       datetime          NULL,
    [trans_seq]           bigint            NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_ttr_voucher_history] PRIMARY KEY CLUSTERED ([organization_id], [voucher_typcode], [serial_nbr], [history_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[ttr_voucher_history_p] 
 */

CREATE TABLE [dbo].[ttr_voucher_history_p](
    [organization_id]  int               NOT NULL,
    [voucher_typcode]  varchar(30)       NOT NULL,
    [serial_nbr]       varchar(60)       NOT NULL,
    [history_seq]      bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_ttr_voucher_history_p] PRIMARY KEY CLUSTERED ([organization_id], [voucher_typcode], [serial_nbr], [history_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ttr_voucher_p] 
 */

CREATE TABLE [dbo].[ttr_voucher_p](
    [organization_id]  int               NOT NULL,
    [voucher_typcode]  varchar(30)       NOT NULL,
    [serial_nbr]       varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_ttr_voucher_p] PRIMARY KEY CLUSTERED ([organization_id], [voucher_typcode], [serial_nbr], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[ttr_voucher_tndr_lineitm] 
 */

CREATE TABLE [dbo].[ttr_voucher_tndr_lineitm](
    [organization_id]      int               NOT NULL,
    [wkstn_id]             bigint            NOT NULL,
    [business_date]        datetime          NOT NULL,
    [rtl_loc_id]           int               NOT NULL,
    [trans_seq]            bigint            NOT NULL,
    [rtrans_lineitm_seq]   int               NOT NULL,
    [voucher_typcode]      varchar(30)       NULL,
    [track1]               varchar(254)      NULL,
    [auth_mthd_code]       varchar(30)       NULL,
    [track3]               varchar(254)      NULL,
    [track2]               varchar(254)      NULL,
    [adjudication_code]    varchar(30)       NULL,
    [entry_mthd_code]      varchar(30)       NULL,
    [auth_code]            varchar(30)       NULL,
    [activity_code]        varchar(30)       NULL,
    [reference_nbr]        varchar(254)      NULL,
    [effective_date]       datetime          NULL,
    [expr_date]            datetime          NULL,
    [face_value_amt]       decimal(17, 6)    NULL,
    [issue_datetime]       datetime          NULL,
    [issue_typcode]        varchar(30)       NULL,
    [unspent_balance_amt]  decimal(17, 6)    NULL,
    [voucher_status_code]  varchar(30)       NULL,
    [TRACE_NUMBER]         varchar(60)       NULL,
    [orig_local_date_time] varchar(20)       NULL,
    [orig_transmission_date_time] varchar(20) NULL,
    [orig_STAN]            varchar(30)       NULL,
    [merchant_cat_code]    varchar(4)        NULL,
    [create_date]          datetime          NULL,
    [create_user_id]       varchar(30)       NULL,
    [update_date]          datetime          NULL,
    [update_user_id]       varchar(30)       NULL,
    [record_state]         varchar(30)       NULL,
    CONSTRAINT [pk_ttr_voucher_tndr_lineitm] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_address_mod] 
 */

CREATE TABLE [dbo].[xom_address_mod](
    [organization_id]  int             NOT NULL,
    [order_id]         varchar(60)     NOT NULL,
    [address_seq]      bigint          NOT NULL,
    [address1]         varchar(254)    NULL,
    [address2]         varchar(254)    NULL,
    [address3]         varchar(254)    NULL,
    [address4]         varchar(254)    NULL,
    [city]             varchar(254)    NULL,
    [state]            varchar(30)     NULL,
    [postal_code]      varchar(30)     NULL,
    [country]          varchar(2)	   NULL,
    [apartment]        varchar(30)     NULL,
	[neighborhood]	   varchar(254)	   null,
	[county]		   varchar(254)	   null,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [PK_xom_address_mod] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [address_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_address_mod_p] 
 */

CREATE TABLE [dbo].[xom_address_mod_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [address_seq]      bigint            NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_address_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [address_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_balance_mod] 
 */

CREATE TABLE [dbo].[xom_balance_mod](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [mod_seq]          int               NOT NULL,
    [typcode]          varchar(30)       NULL,
    [amount]           decimal(17, 6)    NULL,
    [void_flag]        bit               DEFAULT 0 NOT NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [PK_xom_balance_mod] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [mod_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_balance_mod_p] 
 */

CREATE TABLE [dbo].[xom_balance_mod_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [mod_seq]          int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_balance_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [mod_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_customer_mod] 
 */

CREATE TABLE [dbo].[xom_customer_mod](
    [organization_id]    int             NOT NULL,
    [order_id]           varchar(60)     NOT NULL,
    [customer_id]        varchar(60)     NULL,
    [first_name]         varchar(60)     NULL,
    [last_name]          varchar(60)     NULL,
    [telephone1]         varchar(32)     NULL,
    [telephone2]         varchar(32)     NULL,
    [email_address]      varchar(254)    NULL,
    [address_seq]        bigint          NULL,
    [ORGANIZATION_NAME]  varchar(60)     NULL,
    [SALUTATION]         varchar(30)     NULL,
    [MIDDLE_NAME]        varchar(60)     NULL,
    [SUFFIX]             varchar(30)     NULL,
    [create_date]        datetime        NULL,
    [create_user_id]     varchar(30)     NULL,
    [update_date]        datetime        NULL,
    [update_user_id]     varchar(30)     NULL,
    [record_state]       varchar(30)     NULL,
    CONSTRAINT [PK_xom_customer_mod] PRIMARY KEY CLUSTERED ([organization_id], [order_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_xom_customer_mod02] 
 */

CREATE INDEX [idx_xom_customer_mod02] ON [dbo].[xom_customer_mod]([last_name], [first_name], [telephone1], [telephone2], [organization_id]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [idx_xom_customer_mod03] 
 */

CREATE INDEX [idx_xom_customer_mod03] ON [dbo].[xom_customer_mod]([telephone1], [organization_id]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [idx_xom_customer_mod04] 
 */

CREATE INDEX [idx_xom_customer_mod04] ON [dbo].[xom_customer_mod]([telephone2], [organization_id]) WITH (FILLFACTOR = 80)
go
/* 
 * TABLE: [dbo].[xom_customer_mod_p] 
 */

CREATE TABLE [dbo].[xom_customer_mod_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_customer_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_customization_mod] 
 */

CREATE TABLE [dbo].[xom_customization_mod](
    [organization_id]        int             NOT NULL,
    [order_id]               varchar(60)     NOT NULL,
    [detail_seq]             int             NOT NULL,
    [mod_seq]                int             NOT NULL,
    [customization_code]     varchar(30)     NULL,
    [customization_message]  varchar(max)    NULL,
    [create_date]            datetime        NULL,
    [create_user_id]         varchar(30)     NULL,
    [update_date]            datetime        NULL,
    [update_user_id]         varchar(30)     NULL,
    [record_state]		     varchar(30)     NULL,
    CONSTRAINT [pk_xom_customization_mod] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [mod_seq])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_customization_mod_p] 
 */

CREATE TABLE [dbo].[xom_customization_mod_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [mod_seq]          int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_customization_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [mod_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_fee_mod] 
 */

CREATE TABLE [dbo].[xom_fee_mod](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [mod_seq]          int               NOT NULL,
    [typcode]          varchar(30)       NULL,
    [amount]           decimal(17, 6)    NULL,
    [void_flag]        bit               DEFAULT 0 NOT NULL,
    [tax_amount]       decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [PK_xom_fee_mod] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [mod_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_fee_mod_p] 
 */

CREATE TABLE [dbo].[xom_fee_mod_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [mod_seq]          int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_fee_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [mod_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_fulfillment_mod] 
 */

CREATE TABLE [dbo].[xom_fulfillment_mod](
    [organization_id]    int             NOT NULL,
    [order_id]           varchar(60)     NOT NULL,
    [detail_seq]         int             NOT NULL,
    [loc_id]             varchar(60)     NULL,
    [loc_name1]          varchar(254)    NULL,
    [loc_name2]          varchar(254)    NULL,
    [telephone]          varchar(32)     NULL,
    [email_address]      varchar(254)    NULL,
    [address_seq]        bigint          NULL,
    [ORGANIZATION_NAME]  varchar(60)     NULL,
    [SALUTATION]         varchar(30)     NULL,
    [MIDDLE_NAME]        varchar(60)     NULL,
    [SUFFIX]             varchar(30)     NULL,
    [create_date]        datetime        NULL,
    [create_user_id]     varchar(30)     NULL,
    [update_date]        datetime        NULL,
    [update_user_id]     varchar(30)     NULL,
    [record_state]       varchar(30)     NULL,
    CONSTRAINT [PK_xom_fulfillment_mod] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_fulfillment_mod_p] 
 */

CREATE TABLE [dbo].[xom_fulfillment_mod_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_fulfillment_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_item_mod] 
 */

CREATE TABLE [dbo].[xom_item_mod](
    [organization_id]  int             NOT NULL,
    [order_id]         varchar(60)     NOT NULL,
    [detail_seq]       int             NOT NULL,
    [item_id]          varchar(60)     NULL,
    [description]      varchar(254)    NULL,
    [image_url]        varchar(254)    NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [PK_xom_item_mod] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_item_mod_p] 
 */

CREATE TABLE [dbo].[xom_item_mod_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_item_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_order] 
 */

CREATE TABLE [dbo].[xom_order](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [order_type]       varchar(30)       NULL,
    [status_code]      varchar(30)       NULL,
    [order_date]       datetime          NULL,
    [order_loc_id]     varchar(60)       NULL,
    [subtotal]         decimal(17, 6)    NULL,
    [tax_amount]       decimal(17, 6)    NULL,
    [total]            decimal(17, 6)    NULL,
    [balance_due]      decimal(17, 6)    NULL,
    [notes]            varchar(max)      NULL,
    [REF_NBR]          varchar(60)       NULL,
	[additional_freight_charges] decimal(17, 6) NULL,
	[additional_charges] decimal(17, 6)	 NULL,
	[ship_complete_flag] bit DEFAULT (0) NULL,
	[freight_tax]	   decimal(17, 6)	 NULL,
	[order_message]	   varchar(max)		 NULL,
	[gift_message]	   varchar(max)		 NULL,
	[under_review_flag] bit DEFAULT(0)	 NULL,
	[status_code_reason] varchar(30)	 NULL,
	[status_code_reason_note] varchar(max) NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [PK_xom_order] PRIMARY KEY CLUSTERED ([organization_id], [order_id]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_xom_order02] 
 */

CREATE INDEX [idx_xom_order02] ON [dbo].[xom_order]([order_id], [order_type], [status_code], [organization_id]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [idx_xom_order03] 
 */

CREATE INDEX [idx_xom_order03] ON [dbo].[xom_order]([order_type], [status_code], [organization_id]) WITH (FILLFACTOR = 80)
go
/* 
 * INDEX: [idx_xom_order04] 
 */

CREATE INDEX [idx_xom_order04] ON [dbo].[xom_order]([status_code], [organization_id]) WITH (FILLFACTOR = 80)
go


/* 
 * TABLE: [dbo].[xom_order_fee] 
 */

CREATE TABLE [dbo].[xom_order_fee](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [typcode]          varchar(30)       NULL,
    [amount]           decimal(17, 6)    NULL,
    [void_flag]        bit               DEFAULT 0 NOT NULL,
    [ITEM_ID]          varchar(60)       NULL,
    [tax_amount]       decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [PK_xom_order_fee] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_order_fee_p] 
 */

CREATE TABLE [dbo].[xom_order_fee_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_order_fee_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_order_line] 
 */

CREATE TABLE [dbo].[xom_order_line](
    [organization_id]       int               NOT NULL,
    [order_id]              varchar(60)       NOT NULL,
    [detail_seq]            int               NOT NULL,
    [external_order_id]     varchar(60)       NULL,
    [item_id]               varchar(60)       NULL,
    [quantity]              decimal(11, 4)    NULL,
    [fulfillment_type]      varchar(20)       NULL,
    [status_code]           varchar(30)       NULL,
    [unit_price]            decimal(17, 6)    NULL,
    [extended_price]        decimal(17, 6)    NULL,
    [tax_amount]            decimal(17, 6)    NULL,
    [notes]                 varchar(max)      NULL,
    [SELECTED_SHIP_METHOD]  varchar(60)       NULL,
    [tracking_nbr]          varchar(60)       NULL,
    [void_flag]             bit               DEFAULT 0 NOT NULL,
    [ACTUAL_SHIP_METHOD]    varchar(60)       NULL,
    [drop_ship_flag]        bit               DEFAULT 0 NOT NULL,
    [status_code_reason]	varchar(30)		  NULL,
    [line_no]			    int				  NULL,
	[status_code_reason_note] varchar(max)	  NULL,
	[item_upc_code]			varchar(60)		  NULL,
	[item_ean_code]			varchar(60)		  NULL,
	[extended_freight]		decimal(17, 6)	  NULL,
	[customization_charge]	decimal(17, 6)	  NULL,
	[gift_wrap_flag]		bit				  DEFAULT(0) NULL,
	[ship_alone_flag]		bit				  DEFAULT(0) NULL,
	[ship_weight]			decimal(17, 6)	  NULL,
	[line_message]			varchar(max)	  NULL,
    [create_date]           datetime          NULL,
    [create_user_id]        varchar(30)       NULL,
    [update_date]           datetime          NULL,
    [update_user_id]        varchar(30)       NULL,
    [record_state]          varchar(30)       NULL,
    CONSTRAINT [PK_xom_order_line] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_order_line_p] 
 */

CREATE TABLE [dbo].[xom_order_line_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_order_line_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_order_mod] 
 */

CREATE TABLE [dbo].[xom_order_mod](
    [organization_id]     int            NOT NULL,
    [rtl_loc_id]          int            NOT NULL,
    [business_date]       datetime       NOT NULL,
    [wkstn_id]            bigint         NOT NULL,
    [trans_seq]           bigint         NOT NULL,
    [rtrans_lineitm_seq]  int            NOT NULL,
    [order_id]            varchar(60)    NULL,
    [external_order_id]   varchar(60)    NULL,
    [order_type]          varchar(30)    NULL,
    [detail_type]         varchar(20)    NULL,
    [detail_seq]          int            NULL,
    [create_date]         datetime       NULL,
    [create_user_id]      varchar(30)    NULL,
    [update_date]         datetime       NULL,
    [update_user_id]      varchar(30)    NULL,
    [record_state]        varchar(30)    NULL,
    CONSTRAINT [PK_xom_order_mod] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * INDEX: [idx_xom_order_mod01] 
 */

CREATE NONCLUSTERED INDEX idx_xom_order_mod01 ON xom_order_mod(rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq,order_type) WITH (FILLFACTOR = 80)


/* 
 * TABLE: [dbo].[xom_order_mod_p] 
 */

CREATE TABLE [dbo].[xom_order_mod_p](
    [organization_id]     int               NOT NULL,
    [rtl_loc_id]          int               NOT NULL,
    [business_date]       datetime          NOT NULL,
    [wkstn_id]            bigint            NOT NULL,
    [trans_seq]           bigint            NOT NULL,
    [rtrans_lineitm_seq]  int               NOT NULL,
    [property_code]       varchar(30)       NOT NULL,
    [type]                varchar(30)       NULL,
    [string_value]        varchar(max)      NULL,
    [date_value]          datetime          NULL,
    [decimal_value]       decimal(17, 6)    NULL,
    [create_date]         datetime          NULL,
    [create_user_id]      varchar(30)       NULL,
    [update_date]         datetime          NULL,
    [update_user_id]      varchar(30)       NULL,
    [record_state]        varchar(30)       NULL,
    CONSTRAINT [pk_xom_order_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [rtrans_lineitm_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_order_p] 
 */

CREATE TABLE [dbo].[xom_order_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_order_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_order_payment] 
 */

CREATE TABLE [dbo].[xom_order_payment](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [sequence]         int               NOT NULL,
    [typcode]          varchar(30)       NULL,
    [item_id]          varchar(60)       NULL,
    [amount]           decimal(17, 6)    NULL,
    [void_flag]        bit               DEFAULT 0 NOT NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_order_payment] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [sequence]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_order_payment_p] 
 */

CREATE TABLE [dbo].[xom_order_payment_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [sequence]         int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_order_payment_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [sequence], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * TABLE: [dbo].[xom_source_mod] 
 */

CREATE TABLE [dbo].[xom_source_mod](
    [organization_id]  int             NOT NULL,
    [order_id]         varchar(60)     NOT NULL,
    [detail_seq]       int             NOT NULL,
    [loc_id]           varchar(60)     NULL,
    [loc_type]         varchar(30)     NULL,
    [loc_name1]        varchar(254)    NULL,
    [loc_name2]        varchar(254)    NULL,
    [telephone]        varchar(32)     NULL,
    [email_address]    varchar(254)    NULL,
    [address_seq]      bigint          NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   varchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   varchar(30)     NULL,
    [record_state]     varchar(30)     NULL,
    CONSTRAINT [PK_xom_source_mod] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq]) WITH (FILLFACTOR = 80)
)
go



/* 
 * TABLE: [dbo].[xom_source_mod_p] 
 */

CREATE TABLE [dbo].[xom_source_mod_p](
    [organization_id]  int               NOT NULL,
    [order_id]         varchar(60)       NOT NULL,
    [detail_seq]       int               NOT NULL,
    [property_code]    varchar(30)       NOT NULL,
    [type]             varchar(30)       NULL,
    [string_value]     varchar(max)      NULL,
    [date_value]       datetime          NULL,
    [decimal_value]    decimal(17, 6)    NULL,
    [create_date]      datetime          NULL,
    [create_user_id]   varchar(30)       NULL,
    [update_date]      datetime          NULL,
    [update_user_id]   varchar(30)       NULL,
    [record_state]     varchar(30)       NULL,
    CONSTRAINT [pk_xom_source_mod_p] PRIMARY KEY CLUSTERED ([organization_id], [order_id], [detail_seq], [property_code])
    WITH FILLFACTOR = 80
)
go



/* 
 * VIEW: Dual 
 */
 
IF  EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'Dual'))
    DROP VIEW Dual
GO

CREATE VIEW Dual(dummy)
AS
SELECT 'X'
GO

/* 
 * VIEW: Test_Connection 
 */
 
IF  EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'Test_Connection'))
    DROP VIEW Test_Connection
GO

CREATE VIEW Test_Connection(result)
AS
SELECT 1
GO

/* 
 * VIEW: [dbo].[rpt_trl_sale_lineitm_view] 
 */

IF EXISTS (Select * From information_schema.views Where table_name = 'rpt_trl_sale_lineitm_view')
  DROP VIEW rpt_trl_sale_lineitm_view;
GO

CREATE VIEW rpt_trl_sale_lineitm_view
AS
  SELECT trn.organization_id,
         trn.rtl_loc_id ,
         trn.wkstn_id ,
         trn.trans_seq ,
         tsl.rtrans_lineitm_seq ,
         trn.business_date,
         trn.begin_datetime,
         trn.end_datetime,
         trn.trans_statcode,
         trn.trans_typcode,
         trn.session_id,
         trn.operator_party_id,
         trt.cust_party_id,
         tsl.item_id,
         tsl.merch_level_1,
         tsl.quantity,
         tsl.unit_price,
         tsl.extended_amt,
         tsl.vat_amt,
         tsl.return_flag,
         tsl.net_amt,
         tsl.gross_amt,
         tsl.serial_nbr,
         tsl.sale_lineitm_typcode,
         tsl.tax_group_id,
         tsl.original_rtl_loc_id,
         tsl.original_wkstn_id,
         tsl.original_business_date,
         tsl.original_trans_seq,
         tsl.original_rtrans_lineitm_seq,
         tsl.return_reascode,
         tsl.return_comment,
         tsl.return_typcode,
         trl.void_flag,
         trl.void_lineitm_reascode,
         tsl.base_extended_price,
         tsl.rpt_base_unit_price,
         tsl.exclude_from_net_sales_flag
    FROM  
         trn_trans AS trn, 
         trl_sale_lineitm AS tsl, 
         trl_rtrans_lineitm AS trl, 
         trl_rtrans AS trt     
    WHERE 
          trn.organization_id = tsl.organization_id 
      AND trn.rtl_loc_id = tsl.rtl_loc_id
      AND trn.wkstn_id = tsl.wkstn_id 
      AND trn.business_date = tsl.business_date
      AND trn.trans_seq = tsl.trans_seq
      AND tsl.organization_id = trl.organization_id
      AND tsl.rtl_loc_id = trl.rtl_loc_id
      AND tsl.wkstn_id = trl.wkstn_id
      AND tsl.business_date = trl.business_date
      AND tsl.trans_seq = trl.trans_seq
      AND tsl.rtrans_lineitm_seq = trl.rtrans_lineitm_seq
      AND tsl.organization_id = trt.organization_id
      AND tsl.rtl_loc_id = trt.rtl_loc_id
      AND tsl.wkstn_id = trt.wkstn_id
      AND tsl.business_date = trt.business_date
      AND tsl.trans_seq = trt.trans_seq
      AND trn.trans_statcode = 'COMPLETE';
GO
/* 
 * VIEW: [dbo].[rpt_trl_stock_movement_view] 
 */

IF EXISTS (Select * From information_schema.views Where table_name = 'rpt_trl_stock_movement_view')
  DROP VIEW rpt_trl_stock_movement_view;
GO

CREATE VIEW rpt_trl_stock_movement_view
AS
SELECT itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.business_date, itm_mov.item_id, 
      itm_mov.quantity, itm_mov.adjustment_flag
FROM

((SELECT tsl.organization_id as organization_id, tsl.rtl_loc_id as rtl_loc_id, tsl.business_date as business_date, tsl.item_id as item_id,
	quantity, case when return_flag = 0 then 1 else 0 end as adjustment_flag
	FROM rpt_trl_sale_lineitm_view tsl
	WHERE trans_seq NOT IN
          (SELECT voided_trans_id FROM trn_post_void_trans pvt
           WHERE pvt.organization_id = tsl.organization_id
           AND pvt.rtl_loc_id = tsl.rtl_loc_id
           AND pvt.wkstn_id = tsl.wkstn_id)
	AND sale_lineitm_typcode = 'SALE'
	AND tsl.void_flag = 0) 
				
UNION ALL

(SELECT inv_journal.organization_id, inv_journal.rtl_loc_id, inv_journal.business_date, inv_journal.inventory_item_id,
     quantity, case when action_code IN ('RECEIVING', 'INVENTORY_ADJUSTMENT', 'CYCLE_COUNT_ADJUSTMENT') then 0 else 1 end as adjustment_flag
FROM inv_inventory_journal inv_journal
WHERE action_code IN ('RECEIVING', 'SHIPPING', 'INVENTORY_ADJUSTMENT', 'CYCLE_COUNT_ADJUSTMENT')
      AND (source_bucket_id='ON_HAND' OR dest_bucket_id='ON_HAND'))) itm_mov 

GO

/* 
 * FUNCTION: [dbo].[fn_integerListToTable] 
 */

PRINT 'dbo.fn_integerListToTable';

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[fn_integerListToTable]') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
	DROP FUNCTION [dbo].[fn_integerListToTable]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE FUNCTION [dbo].[fn_integerListToTable] (@list nvarchar(MAX))
   RETURNS @tbl TABLE (number int NOT NULL) AS
BEGIN
   DECLARE @pos        int,
           @nextpos    int,
           @valuelen   int

   SELECT @pos = 0, @nextpos = 1

   WHILE @nextpos > 0
   BEGIN
      SELECT @nextpos = charindex(',', @list, @pos + 1)
      SELECT @valuelen = CASE WHEN @nextpos > 0
                              THEN @nextpos
                              ELSE len(@list) + 1
                         END - @pos - 1
      INSERT @tbl (number)
         VALUES (convert(int, substring(@list, @pos + 1, @valuelen)))
      SELECT @pos = @nextpos
   END
   RETURN
END


GO


IF EXISTS (SELECT * FROM sys.objects WHERE name = 'fn_nodesInHierarchy')
DROP FUNCTION dbo.fn_nodesInHierarchy
GO

Create FUNCTION fn_nodesInHierarchy (@vorgId INT, @vorgCode NVARCHAR(30), @vorgValue NVARCHAR(60))
RETURNS TABLE
AS
RETURN (
  WITH Nodes AS (
    SELECT organization_id, org_code, org_value, parent_code, parent_value
    FROM loc_org_hierarchy chain
    WHERE organization_id = @vorgId
      AND org_code = @vorgCode
      AND org_value = @vorgValue
    UNION ALL
    SELECT node.organization_id, node.org_code, node.org_value, node.parent_code, node.parent_value
    FROM loc_org_hierarchy node
    INNER JOIN Nodes s
      ON node.organization_id = s.organization_id
      AND node.org_code = s.parent_code
      AND node.org_value = s.parent_value
    WHERE node.organization_id = @vorgId
  )
  SELECT org_code + ':' + org_value as node
  FROM Nodes
  union
  select @vorgCode + ':' + @vorgValue as node
)
GO
IF EXISTS (SELECT * FROM sys.objects WHERE name = 'fn_storesInHierarchy')
DROP FUNCTION dbo.fn_storesInHierarchy
GO

CREATE FUNCTION dbo.fn_storesInHierarchy (@vorgId INT, @vorgCode NVARCHAR(30), @vorgValue NVARCHAR(60))
RETURNS TABLE
AS
RETURN (
  WITH Stores AS (
    SELECT organization_id, org_code, org_value
    FROM loc_org_hierarchy chain
    WHERE organization_id = @vorgId
      AND org_code = @vorgCode
      AND org_value = @vorgValue
    UNION ALL
    SELECT node.organization_id, node.org_code, node.org_value
    FROM loc_org_hierarchy node
    INNER JOIN Stores s
      ON node.organization_id = s.organization_id
      AND node.parent_code = s.org_code
      AND node.parent_value = s.org_value
    WHERE node.organization_id = @vorgId
  )
  SELECT org_value
  FROM Stores
  WHERE org_code = 'STORE'
)
GO
/* 
 * PROCEDURE: [dbo].[sp_conv_to_unicode] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_conv_to_unicode' and type = 'P')
  DROP PROCEDURE sp_conv_to_unicode;
GO

-- =============================================
-- Author:		Brett C. White
-- Create date: 2/14/12
-- Description:	Converts all char, varchar, and text fields into nchar, nvarchar, and ntext.
-- =============================================
CREATE PROCEDURE sp_conv_to_unicode 
AS
BEGIN
	begin try
	create table indexlist(
		tablename	     nvarchar(max),
		indexname	     nvarchar(max),
		sql			nvarchar(max),
		is_pk		bit,
		mult			float
	)
	end try
	begin catch
	   declare @rsql0 nvarchar(max)

	   declare icur0 CURSOR FAST_FORWARD for
	   select sql from indexlist order by is_pk desc,tablename asc

	   OPEN icur0

	   WHILE 1=1
	   BEGIN
	    FETCH NEXT FROM icur0 INTO @rsql0
	    if @@FETCH_STATUS <> 0
		    break;
	    begin try
		   print @rsql0
		   exec(@rsql0)
		   delete from indexlist where sql=@rsql0
	    end try
	    begin catch
	    end catch
	   END
	   close icur0;
	   deallocate icur0;
	end catch

	declare @ctable nvarchar(max),@csql nvarchar(max),@oldtable nvarchar(max),@isql nvarchar(max),@default nvarchar(max),@ccolumn nvarchar(max),@mult float,@error nvarchar(max);

	declare column_list CURSOR FAST_FORWARD for
	select COL.table_name,name,COLUMN_NAME,'ALTER TABLE [' + COL.table_name + '] ALTER COLUMN [' + column_name + '] n' + data_type
	+ '(' + case when(character_maximum_length=-1 or character_maximum_length>=4000) then 'max' else cast(character_maximum_length as varchar(5)) end + ') '
	+ case when(is_nullable='no') then ' NOT NULL' else ' NULL' end
	+ case when(name is not null) then '; ALTER TABLE [' + COL.table_name + '] ADD ' + case when(isnull(is_system_named,1)=0) then 'CONSTRAINT [' + name + ']' else '' end + ' DEFAULT ' + definition + ' FOR [' + COLUMN_NAME + ']' else '' end
	from INFORMATION_SCHEMA.columns COL
	inner join INFORMATION_SCHEMA.TABLES t on t.TABLE_NAME=COL.TABLE_NAME
	left join sys.default_constraints on parent_object_id = OBJECT_ID(COL.table_name) and COL_NAME(parent_object_id, parent_column_id) = column_name
	where data_type in ('varchar','char') and TABLE_TYPE like '%table%'
	order by COL.table_name,ORDINAL_POSITION

	open column_list;

	while 1=1
	BEGIN
		FETCH NEXT FROM column_list INTO @ctable,@default,@ccolumn,@csql
		if @@FETCH_STATUS <> 0
		BEGIN
			break;
		END
		declare @iname nvarchar(max),@icolumn nvarchar(max),@itype tinyint,@PK bit,@old nvarchar(max),@oldPK bit,@unique bit,@is_included bit,@ref nvarchar(max),@fktable nvarchar(max),@fill_factor nvarchar(10)

		SET @old=null
		-- Find all Foreign Keys from this table or references this table
		if exists(SELECT 1 from sysobjects f
			 inner join sysobjects c on  f.parent_obj = c.id
			 inner join sysforeignkeys r on f.id =  r.constid
			 inner join sysobjects p on r.rkeyid = p.id
			 inner  join syscolumns rc on r.rkeyid = rc.id and r.rkey = rc.colid
			 INNER JOIN INFORMATION_SCHEMA.COLUMNS col ON rc.name=col.COLUMN_NAME and c.name=col.TABLE_NAME
			 where f.type = 'F' and (p.name=@ctable or c.name=@ctable) and DATA_TYPE in ('varchar','char'))
		BEGIN
			    declare index_list CURSOR FAST_FORWARD for
				    select c.name,f.name,'alter table [' + c.name + '] WITH CHECK ADD CONSTRAINT [' + f.name
					+ '] FOREIGN KEY (' + fc.name + ISNULL(',' + fc2.name,'') + ISNULL(',' + fc3.name,'') + ISNULL(',' + fc4.name,'')
					+ ISNULL(',' + fc5.name,'') + ISNULL(',' + fc6.name,'') + ISNULL(',' + fc7.name,'') + ISNULL(',' + fc8.name,'')
					+ ISNULL(',' + fc9.name,'') + ISNULL(',' + fc10.name,'') + ISNULL(',' + fc11.name,'') + ISNULL(',' + fc12.name,'')
					+ ISNULL(',' + fc13.name,'') + ISNULL(',' + fc14.name,'') + ISNULL(',' + fc15.name,'') + ISNULL(',' + fc16.name,'') + ')'
					+ ' REFERENCES [' + p.name + '] (' + rc.name + ISNULL(',' + rc2.name,'') + ISNULL(',' + rc3.name,'') + ISNULL(',' + rc4.name,'')
				    + ISNULL(',' + rc5.name,'') + ISNULL(',' + rc6.name,'') + ISNULL(',' + rc7.name,'') + ISNULL(',' + rc8.name,'')
				    + ISNULL(',' + rc9.name,'') + ISNULL(',' + rc10.name,'') + ISNULL(',' + rc11.name,'') + ISNULL(',' + rc12.name,'') 
				    + ISNULL(',' + rc13.name,'') + ISNULL(',' + rc14.name,'') + ISNULL(',' + rc15.name,'') + ISNULL(',' + rc16.name,'') + ')'
				    + CASE WHEN(UPDATE_RULE<>'NO ACTION') then ' ON UPDATE ' + UPDATE_RULE else '' end
				    + CASE WHEN(DELETE_RULE<>'NO ACTION') then ' ON DELETE ' + DELETE_RULE else '' end
				    from sysobjects f
				    inner join sysobjects c on  f.parent_obj = c.id
				    inner join INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS IC on f.name=IC.CONSTRAINT_NAME
				    inner join sysreferences r on f.id =  r.constid
				    inner join sysobjects p on r.rkeyid = p.id
				    inner join syscolumns rc on r.rkeyid = rc.id and r.rkey1 = rc.colid
				    inner join syscolumns fc on r.fkeyid = fc.id and r.fkey1 = fc.colid
				    left join syscolumns rc2 on r.rkeyid = rc2.id and r.rkey2 = rc2.colid
				    left join syscolumns rc3 on r.rkeyid = rc3.id and r.rkey3 = rc3.colid
				    left join syscolumns rc4 on r.rkeyid = rc4.id and r.rkey4 = rc4.colid
				    left join syscolumns rc5 on r.rkeyid = rc5.id and r.rkey5 = rc5.colid
				    left join syscolumns rc6 on r.rkeyid = rc6.id and r.rkey6 = rc6.colid
				    left join syscolumns rc7 on r.rkeyid = rc7.id and r.rkey7 = rc7.colid
				    left join syscolumns rc8 on r.rkeyid = rc8.id and r.rkey8 = rc8.colid
				    left join syscolumns rc9 on r.rkeyid = rc9.id and r.rkey9 = rc9.colid
				    left join syscolumns rc10 on r.rkeyid = rc10.id and r.rkey10 = rc10.colid
				    left join syscolumns rc11 on r.rkeyid = rc11.id and r.rkey11 = rc11.colid
				    left join syscolumns rc12 on r.rkeyid = rc12.id and r.rkey12 = rc12.colid
				    left join syscolumns rc13 on r.rkeyid = rc13.id and r.rkey13 = rc13.colid
				    left join syscolumns rc14 on r.rkeyid = rc14.id and r.rkey14 = rc14.colid
				    left join syscolumns rc15 on r.rkeyid = rc15.id and r.rkey15 = rc15.colid
				    left join syscolumns rc16 on r.rkeyid = rc16.id and r.rkey16 = rc16.colid
				    left join syscolumns fc2 on r.fkeyid = fc2.id and r.fkey2 = fc2.colid
				    left join syscolumns fc3 on r.fkeyid = fc3.id and r.fkey3 = fc3.colid
				    left join syscolumns fc4 on r.fkeyid = fc4.id and r.fkey4 = fc4.colid
				    left join syscolumns fc5 on r.fkeyid = fc5.id and r.fkey5 = fc5.colid
				    left join syscolumns fc6 on r.fkeyid = fc6.id and r.fkey6 = fc6.colid
				    left join syscolumns fc7 on r.fkeyid = fc7.id and r.fkey7 = fc7.colid
				    left join syscolumns fc8 on r.fkeyid = fc8.id and r.fkey8 = fc8.colid
				    left join syscolumns fc9 on r.fkeyid = fc9.id and r.fkey9 = fc9.colid
				    left join syscolumns fc10 on r.fkeyid = fc10.id and r.fkey10 = fc10.colid
				    left join syscolumns fc11 on r.fkeyid = fc11.id and r.fkey11 = fc11.colid
				    left join syscolumns fc12 on r.fkeyid = fc12.id and r.fkey12 = fc12.colid
				    left join syscolumns fc13 on r.fkeyid = fc13.id and r.fkey13 = fc13.colid
				    left join syscolumns fc14 on r.fkeyid = fc14.id and r.fkey14 = fc14.colid
				    left join syscolumns fc15 on r.fkeyid = fc15.id and r.fkey15 = fc15.colid
				    left join syscolumns fc16 on r.fkeyid = fc16.id and r.fkey16 = fc16.colid
				 where f.type =  'F' and p.name=@ctable or c.name=@ctable
				 ORDER BY f.name
 
		    open index_list;
		    while 1=1
		    BEGIN
			    FETCH NEXT FROM index_list INTO @fktable,@iname,@isql
			    if @@FETCH_STATUS <> 0 break;
				    
			    insert into indexlist (tablename,indexname,sql) values(@fktable,@iname,@isql)

			    print 'ALTER TABLE [' + @fktable + '] DROP CONSTRAINT [' + @iname + ']'
			    exec('ALTER TABLE [' + @fktable + '] DROP CONSTRAINT [' + @iname + ']');
		    END
		    close index_list
		    deallocate index_list
		END
		  -- Find all check constraints.
		  declare index_list CURSOR FAST_FORWARD for
		  SELECT  cc.CONSTRAINT_NAME,CHECK_CLAUSE 
		  FROM INFORMATION_SCHEMA.CHECK_CONSTRAINTS cc 
		  INNER JOIN INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE c ON cc.CONSTRAINT_NAME = c.CONSTRAINT_NAME 
		  INNER JOIN INFORMATION_SCHEMA.COLUMNS col ON c.COLUMN_NAME=col.COLUMN_NAME and c.TABLE_NAME=col.TABLE_NAME
		  where DATA_TYPE in ('varchar','char') and c.TABLE_NAME=@ctable

		  open index_list;
		  while 1=1
		  BEGIN
			  FETCH NEXT FROM index_list INTO @iname,@icolumn
			  if @@FETCH_STATUS <> 0
			  break;
			  insert into indexlist (tablename,indexname,sql) values(@ctable,@iname,'ALTER TABLE [' + @ctable + ']  WITH CHECK ADD  CONSTRAINT [' + @iname + '] CHECK  (' + @icolumn + ')')
		    
			  print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @iname + ']' 
			  exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @iname + ']');
		  END
		  close index_list
		  deallocate index_list
		  
		set @old = null;
		-- Find all primary keys and indexes that have char and/or varchar columns.
		if not exists (select 1 from indexlist where tablename=@ctable and is_pk is not null) and exists(SELECT 1 FROM sys.indexes ind 
			INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
			INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
			INNER JOIN sys.tables t ON ind.object_id = t.object_id  
			INNER JOIN INFORMATION_SCHEMA.COLUMNS cl on t.name=cl.TABLE_NAME and col.name=cl.COLUMN_NAME  
			WHERE ind.type in (1, 2) and is_disabled=0 and t.name=@ctable and data_type in ('varchar','char'))
		BEGIN
			declare char_index CURSOR FAST_FORWARD for
			SELECT distinct ind.name FROM sys.indexes ind 
			INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
			INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
			INNER JOIN sys.tables t ON ind.object_id = t.object_id  
			INNER JOIN INFORMATION_SCHEMA.COLUMNS cl on t.name=cl.TABLE_NAME and col.name=cl.COLUMN_NAME  
			WHERE ind.type in (1, 2) and is_disabled=0 and t.name=@ctable and data_type in ('varchar','char')

			open char_index
			WHILE 1=1
			BEGIN
			    FETCH NEXT FROM char_index INTO @iname
			    if @@FETCH_STATUS<>0
				    break;
			    declare index_list CURSOR FAST_FORWARD for
			    SELECT col.name,ind.type,ind.is_primary_key,ind.is_unique,is_included_column,fill_factor  
			    FROM sys.indexes ind 
			    INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
			    INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
			    INNER JOIN sys.tables t ON ind.object_id = t.object_id  
			    WHERE ind.name=@iname and t.name=@ctable
			    ORDER BY ic.key_ordinal
    			
			    open index_list;
			    while 1=1
			    BEGIN
				    FETCH NEXT FROM index_list INTO @icolumn,@itype,@PK,@unique,@is_included,@fill_factor
				    if @@FETCH_STATUS <> 0
				    BEGIN
					    if not exists(select 1 from indexlist where indexname=@old and tablename=@ctable and is_pk is not null)
					    begin
						   SET @isql=@isql + ') WITH (FILLFACTOR = ' + @fill_factor + ')'
						   SELECT @mult=1-((SUM(max_length)-450.0)/450.0) --Shrink column length to keep key size under 900
						   FROM sys.indexes ind 
						   INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
						   INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
						   INNER JOIN sys.tables t ON ind.object_id = t.object_id  
						   WHERE ind.type in (1, 2) and is_disabled=0 and is_included_column=0 and ind.name=@old
						   group BY ind.name
						   if (@mult>1)
	   						   insert into indexlist (tablename,indexname,sql,is_pk) values(@ctable,@old,@isql,@oldPK)
	   					   else
	   					   begin
	   						   if(@mult<.10) SET @mult=.10
	   						   insert into indexlist (tablename,indexname,sql,is_pk,mult) values(@ctable,@old,@isql,@oldPK,@mult)
	   					   end
	   					   
	   					   if @oldPK=1
							 BEGIN TRY
								 exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']');
								 print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']'
							 END TRY
							 BEGIN CATCH
								 print 'ERROR: ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + '] failed: ' + error_message()
							 END CATCH
							 else
							 BEGIN TRY
								 exec('DROP INDEX [' + @ctable + '].[' + @old + ']');
								 print 'DROP INDEX [' + @ctable + '].[' + @old + ']'
							 END TRY
							 BEGIN CATCH
								 BEGIN TRY
									SET @error=error_message()
									exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']');
									print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']'
								 END TRY
								 BEGIN CATCH
	   								print 'ERROR: DROP INDEX [' + @ctable + '].[' + @old + ']' + ' failed: ' + @error
	   								delete from indexlist where sql=@isql
								 END CATCH
							 END CATCH
	   				    end
					    set @mult = null;
					    break;
				    END
				    if @old is not null and @old<>@iname
				    BEGIN
					    if not exists(select 1 from indexlist where indexname=@old and tablename=@ctable and is_pk is not null)
					    begin
						   SET @isql=@isql + ') WITH (FILLFACTOR = ' + @fill_factor + ')'
						   SELECT @mult=1-((SUM(max_length)-450.0)/450.0) --Shrink column length to keep key size under 900
						   FROM sys.indexes ind 
						   INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
						   INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
						   INNER JOIN sys.tables t ON ind.object_id = t.object_id  
						   WHERE ind.type in (1, 2) and is_disabled=0 and is_included_column=0 and ind.name=@old
						   group BY ind.name
    					    
						   if (@mult>1)
	   						   insert into indexlist (tablename,indexname,sql,is_pk) values(@ctable,@old,@isql,@oldPK)
	   					   else
	   					   begin
	   						   if(@mult<.10) SET @mult=.10
	   						   insert into indexlist (tablename,indexname,sql,is_pk,mult) values(@ctable,@old,@isql,@oldPK,@mult)
	   					   end

	   					   if @oldPK=1
							 BEGIN TRY
								 exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']');
								 print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']'
							 END TRY
							 BEGIN CATCH
								 print 'ERROR: ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + '] failed: ' + error_message()
							 END CATCH
							 else
							 BEGIN TRY
								 exec('DROP INDEX [' + @ctable + '].[' + @old + ']');
								 print 'DROP INDEX [' + @ctable + '].[' + @old + ']'
							 END TRY
							 BEGIN CATCH
								 BEGIN TRY
									SET @error=error_message()
									exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']');
									print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']'
								 END TRY
								 BEGIN CATCH
	   								print 'ERROR: DROP INDEX [' + @ctable + '].[' + @old + ']' + ' failed: ' + @error
	   								delete from indexlist where sql=@isql
								 END CATCH
							 END CATCH
	   				    end
					    set @mult = null;

					    if @PK=1
					    begin
						    SET @isql='ALTER TABLE [' + @ctable + '] ADD CONSTRAINT [' + @iname + '] PRIMARY KEY '
						    if @itype=1
							    SET @isql=@isql + ' CLUSTERED '
						    SET @isql=@isql + '('
					    end
					    else
					    BEGIN
						    SET @isql='CREATE '
						    if @unique=1
							    SET @isql=@isql + ' UNIQUE '
						    SET @isql=@isql + 'INDEX [' + @iname + '] ON [' + @ctable + '] ('
					    END
					    SET @oldPK=@PK
					    SET @old=@iname
				    END
				    ELSE IF @old is null
				    BEGIN
					    SET @old=@iname
					    SET @oldPK=@PK
    					
					    if @PK=1
					    begin
						    SET @isql='ALTER TABLE [' + @ctable + '] ADD CONSTRAINT [' + @iname + '] PRIMARY KEY '
						    if @itype=1
							    SET @isql=@isql + ' CLUSTERED '
						    SET @isql=@isql + '('
					    end
					    else
					    BEGIN
						    SET @isql='CREATE '
						    if @unique=1
							    SET @isql=@isql + ' UNIQUE '
						    SET @isql=@isql + 'INDEX [' + @iname + '] ON [' + @ctable + '] ('
					    END
				    END
				    ELSE IF @is_included=1 AND CHARINDEX(') INCLUDE (',@isql)=0
					    SET @isql=@isql + ') INCLUDE (';
				    ELSE
					    SET @isql=@isql + ','
    				
				    SET @isql=@isql + '[' + @icolumn + ']'
			    END
			    close index_list
			    deallocate index_list
			END
		     close char_index
		     deallocate char_index
		END
		-- Find statistics
		  declare stat_list CURSOR FAST_FORWARD for
		  select name, user_created, stats_id from sys.stats where object_id=OBJECT_ID(@ctable)
		  declare @user_created bit,@stats_id int;
		  open stat_list;
		  while 1=1
		  BEGIN
			  FETCH NEXT FROM stat_list INTO @iname,@user_created,@stats_id
			  if @@FETCH_STATUS <> 0
				break;
			  if @user_created=0
				continue;
			declare @columns nvarchar(max);
			set @columns='';
			declare scolumns cursor fast_forward for
			select col.name from sys.stats_columns sc
			INNER JOIN sys.columns col ON sc.object_id = col.object_id and sc.column_id = col.column_id  
			where sc.object_id=OBJECT_ID(@ctable) and stats_id=@stats_id order by stats_column_id

			open scolumns;
			while 1=1
			BEGIN
			    FETCH NEXT FROM scolumns INTO @icolumn
			    if @@FETCH_STATUS <> 0
				   break;
			    set @columns = @columns + @icolumn + ','
			END
			close scolumns
			deallocate scolumns
			insert into indexlist (tablename,indexname,sql) values(@ctable,@iname,'CREATE STATISTICS [' + @iname + '] ON [' + @ctable + '] (' + left(@columns,len(@columns)-1) + ')')
		    
			print 'DROP STATISTICS [' + @ctable + '].[' + @iname + ']' 
			exec('DROP STATISTICS [' + @ctable + '].[' + @iname + ']');
		  END
		  close stat_list
		  deallocate stat_list
		-- Calculate new char lengths for key columns that index key is over 900 not including include columns
		if exists(select 1 from indexlist where tablename=@ctable AND CHARINDEX(@ccolumn,sql,1)>0 and mult is not null and (CHARINDEX('INCLUDE (',sql,1)=0 or CHARINDEX(@ccolumn,sql,1)<CHARINDEX('INCLUDE (',sql,1)))
		begin
		  select top 1 @mult=ABS(mult) from indexlist where tablename=@ctable AND CHARINDEX(@ccolumn,sql)>0 and mult is not null;
		  SELECT @csql=REPLACE(@csql,cast(max_length as varchar(5)),cast(round(max_length*@mult,0) as varchar(5))) FROM sys.columns where object_id=object_id(@ctable) and name=@ccolumn and max_length>50
		end
		-- Drop default constraints.
		if @default is not null
		BEGIN
			print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @default + ']'
			exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @default + ']')
		END
		-- Convert the columns to unicode and add back the default constraints.
		begin try
		    exec(@csql)
		    print @csql
		end try
		begin catch
	   		print 'ERROR: ' + @csql + ' failed: ' + error_message()
		end catch
	END 
	
	-- Re-create the indexes, keys, and constraints
	declare @rsql nvarchar(max)

	declare icur CURSOR FAST_FORWARD for
	select sql from indexlist order by is_pk desc,tablename asc

	OPEN icur

	WHILE 1=1
	BEGIN
		FETCH NEXT FROM icur INTO @rsql
		if @@FETCH_STATUS <> 0
			break;
		begin try
		    exec(@rsql)
		    print @rsql
		    delete from indexlist where sql=@rsql
		end try
		begin catch
		    print 'ERROR: ' + @rsql + ' failed: ' + error_message()
		end catch
	END
	close icur
	deallocate icur
	
	if not exists(select 1 from indexlist)
	   drop table indexlist
	close column_list
	deallocate column_list
	
	-- Convert to Text columns to NText
	declare @ttable nvarchar(max),@tcolumn nvarchar(max);

	declare text_list CURSOR FAST_FORWARD for
	select COL.table_name,col.COLUMN_NAME
	from INFORMATION_SCHEMA.columns COL
	inner join INFORMATION_SCHEMA.TABLES t on t.TABLE_NAME=COL.TABLE_NAME
	left join sys.default_constraints on parent_object_id = OBJECT_ID(COL.table_name) and COL_NAME(parent_object_id, parent_column_id) = column_name
	where data_type in ('text') and TABLE_TYPE like '%table%'
	order by COL.table_name,ORDINAL_POSITION

	open text_list

	while 1=1
	begin
		FETCH NEXT FROM text_list INTO @ttable,@tcolumn
		if @@FETCH_STATUS <> 0
			break;
		
		SET @old=@tcolumn + '_old'
		SET @oldtable=@ttable + '.' + @tcolumn

		print 'sp_rename ' + @oldtable + ',' + @old + ', ''COLUMN''';
		EXEC sp_rename @oldtable, @old, 'COLUMN';
		
		print 'ALTER TABLE ' + @ttable + ' ADD ' + @tcolumn + ' NTEXT NULL'
		EXEC('ALTER TABLE ' + @ttable + ' ADD ' + @tcolumn + ' NTEXT NULL')
		
		print 'UPDATE ' + @ttable + ' SET ' + @tcolumn + ' = ' + @old
		EXEC('UPDATE ' + @ttable + ' SET ' + @tcolumn + ' = ' + @old)

		print 'ALTER TABLE ' + @ttable + ' DROP COLUMN ' + @old
		exec('ALTER TABLE ' + @ttable + ' DROP COLUMN ' + @old)
	end
	close text_list
	deallocate text_list
	
	PRINT 'PLEASE UPDATE THE STORED PROCEDURES, FUNCTIONS, AND TRIGGERS MANUALLY!!!'
END
GO
PRINT 'dbo.sp_defrag_indexes';
GO

IF OBJECT_ID('dbo.sp_defrag_indexes') IS NOT NULL
	DROP PROCEDURE dbo.sp_defrag_indexes;
GO
	
CREATE PROCEDURE dbo.sp_defrag_indexes (@minfrag int = 10,
					  					@minindexpages int = 1)
AS
BEGIN
-------------------------------------------------------------------------------------------------------------------
--                                                                                                               --
-- Procedure         : sp_defrag_indexes (@minfrag int, @minindexpage int)										 --
-- Parameters		 : minfrag - The minum about a fragmentation allowed in the database.  Tables with less than
--                               the amont specified will not be reorganized.
--                   : minindexpages - The minum number of pages in the indexes for a reorganized to be performed --
-- Description       : Reorganizes the tables that are fragmented with the respective minimume fragmentation 
-- Version           : 16.0                                                                                       --
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-- ST  01/30/07  Initially created
-- PGH 11/07/09  Rewriten for 2005 / 2008
-- BCW 12/02/11  Added fill factor to rebuild
-------------------------------------------------------------------------------------------------------------------
-- Declare variables

	SET NOCOUNT ON
	SET QUOTED_IDENTIFIER ON

	DECLARE @ls_version			varchar(128),
			@li_version			integer,
			@li_pos				integer,
			@table_nm			VARCHAR (128),
			@index_nm			varchar(128),
			@objectid			INT,
			@indexid			INT,
			@part_nbr			int,
			@index_typ			varchar(60),
			@index_depth		int,
			@page_cnt			int,
			@frag				DECIMAL,
			@dbname				sysname,
			@ls_sqlcmd			nvarchar(128)

	--check to verify the version, this procedure is using the DMV views introduced in 2005
	--check this is being run in a user database
	SET @ls_version = CONVERT(varchar(128), SERVERPROPERTY ('ProductVersion'))
	SET @li_pos = CHARINDEX('.', @ls_version) - 1
	SET @li_version = CONVERT(int, SUBSTRING(@ls_version, 1, @li_pos))
	IF @li_version < 9
	BEGIN
		PRINT 'Wrong Version, this procedure requires SQL SERVER 2005 or greater'
		RETURN
	END

	SELECT @dbname = db_name()
	IF @dbname IN ('master', 'msdb', 'model', 'tempdb')
	BEGIN
		PRINT 'This procedure should not be run in system databases.'
		RETURN
	END

	--begin Stage 1: Find the indexes with fragmentation
	-- Declare cursor 
	DECLARE FindIDXFrag CURSOR FOR
	SELECT object_name(i.object_id) as 'Table Name', 
			i.name as 'Index Name',
			i.object_id,
			i.index_id,
			partition_number,
			index_type_desc,
			index_depth,
			avg_fragmentation_in_percent,
			page_count
		FROM sys.dm_db_index_physical_stats(db_id(), NULL, NULL, NULL , NULL) ips
		JOIN sys.indexes i on i.object_id = ips.object_id and i.index_id = ips.index_id
		where index_type_desc in ('CLUSTERED INDEX', 'NONCLUSTERED INDEX')
		  --and avg_fragmentation_in_percent > @minfrag
		  and page_count > @minindexpages

	---- Report the ouput of showcontig for results checking
	-- SELECT * FROM #fraglist order by 1

	-- Write to output start time for information purposes
	PRINT 'Started defragmenting indexes at ' + CONVERT(VARCHAR,GETDATE())
	PRINT 'REORGANIZING:'

	-- Open the cursor
	OPEN FindIDXFrag

	-- Loop through the indexes
	FETCH NEXT
	FROM FindIDXFrag
	INTO @table_nm,
		@index_nm,
		@objectid,
		@indexid,
		@part_nbr,
		@index_typ,
		@index_depth,
		@frag,
		@page_cnt

	WHILE @@FETCH_STATUS = 0
	BEGIN

		IF @frag > @minfrag
		BEGIN 
			IF @frag > 50
				BEGIN
					PRINT 'Index ' + @index_nm + ' on ' + @table_nm + ' Rebuilt';
--					SET @ls_sqlcmd = 'ALTER INDEX [' + @index_nm + '] on [' + @table_nm + '] REBUILD WITH ONLINE=ON';  -- Online only works with Enterprise Edition
					SET @ls_sqlcmd = 'ALTER INDEX [' + @index_nm + '] on [' + @table_nm + '] REBUILD WITH (FILLFACTOR = 80)';
					print @ls_sqlcmd;
					exec (@ls_sqlcmd);
				END;
			ELSE
				BEGIN
					PRINT 'Index ' + @index_nm + ' on ' + @table_nm + ' Reorganized';
					SET @ls_sqlcmd = 'ALTER INDEX [' + @index_nm + '] on [' + @table_nm + '] REORGANIZE';
					--print @ls_sqlcmd;
					exec (@ls_sqlcmd);
					SET @ls_sqlcmd = 'UPDATE STATISTICS [' + @table_nm + '] [' + @index_nm + ']';
					--print @ls_sqlcmd;
					exec (@ls_sqlcmd);
				END;
		END;
		ELSE
			BEGIN
				PRINT 'Index ' + @index_nm + ' on ' + @table_nm + ' Statistics Updated';
				SET @ls_sqlcmd = 'UPDATE STATISTICS [' + @table_nm + '] [' + @index_nm + ']';
				--print @ls_sqlcmd;
				exec (@ls_sqlcmd);
			END;
		
		FETCH NEXT
		FROM FindIDXFrag
			INTO  @table_nm,
				@index_nm,
				@objectid,
				@indexid,
				@part_nbr,
				@index_typ,
				@index_depth,
				@frag,
				@page_cnt;
		
	END;

	-- Close and deallocate the cursor
	CLOSE FindIDXFrag;
	DEALLOCATE FindIDXFrag;

	-- move back to full mode 
	-- alter database xstore set recovery full

	-- Report on finish time for information purposes
	PRINT 'Finished defragmenting indexes at ' + CONVERT(VARCHAR,GETDATE());
END
GO
/* 
 * PROCEDURE: [dbo].[sp_fifo_detail] 
 */

PRINT 'dbo.sp_fifo_detail';

IF EXISTS (Select * From sysobjects Where name = 'sp_fifo_detail' and type = 'P')
  DROP PROCEDURE sp_fifo_detail;
GO

CREATE PROCEDURE [dbo].[sp_fifo_detail] 
    @merch_level_1_param	VARCHAR(60), 
    @merch_level_2_param	VARCHAR(60), 
    @merch_level_3_param	VARCHAR(60), 
    @merch_level_4_param	VARCHAR(60),
    @item_id_param          VARCHAR(60),
    @style_id_param         VARCHAR(60),
    @rtl_loc_id_param		VARCHAR(MAX), 
    @organization_id_param	int,
    @user_name_param		VARCHAR(30),
    @stock_val_date_param   DATETIME
 
 AS
BEGIN

  --TRUNCATE TABLE rpt_fifo_detail;
  DELETE FROM rpt_fifo_detail WHERE user_name = @user_name_param

  DECLARE 
            @organization_id		 int,
            @organization_id_a		 int,
            @item_id				 VARCHAR(60),
            @item_id_a				 VARCHAR(60),
            @description			 VARCHAR(254),
            @description_a			 VARCHAR(254),
            @style_id				 VARCHAR(60),
            @style_id_a				 VARCHAR(60),
            @style_desc			     VARCHAR(254),
            @style_desc_a			 VARCHAR(254),
            @rtl_loc_id				 int,
            @rtl_loc_id_a			 int,
            @store_name				 VARCHAR(254),
            @store_name_a			 VARCHAR(254),
            @invctl_document_id		 VARCHAR(30),
            @invctl_document_id_a	 VARCHAR(30),
            @invctl_document_nbr	 int,
            @invctl_document_nbr_a	 int,
            @create_date_timestamp	 DATETIME,
            @create_date_timestamp_a DATETIME,
            @unit_count				 DECIMAL(14,4),
            @unit_count_a			 DECIMAL(14,4),
            @current_unit_count		 DECIMAL(14,4),
            @unit_cost				 DECIMAL(17,6),
            @unit_cost_a			 DECIMAL(17,6),
            @unitCount				 DECIMAL(14,4),
            @unitCount_a			 DECIMAL(14,4),

            @comment				 VARCHAR(254),

            @current_item_id		 VARCHAR(60),
            @pending_unitCount		 DEC(14,4),
            
            @insert					 smallint;
  
  DECLARE tableCur CURSOR READ_ONLY FOR 
      SELECT MAX(sla.organization_id), MAX(COALESCE(sla.unitcount,0)) + MAX(COALESCE(ts.quantity, 0)) AS quantity, 
                  sla.item_id, MAX(i.description), MAX(style.item_id), MAX(style.description), 
		          l.rtl_loc_id, MAX(l.store_name), doc.invctl_document_id, doc.invctl_document_line_nbr,
                  doc.create_date, MAX(COALESCE(doc.unit_count,0)), MAX(COALESCE(doc.unit_cost,0))
      FROM loc_rtl_loc l, fn_integerListToTable(@rtl_loc_id_param) fn, 
			(SELECT organization_id, item_id, COALESCE(SUM(unitcount),0) AS unitcount 
				FROM inv_stock_ledger_acct, fn_integerListToTable(@rtl_loc_id_param) fn
				WHERE fn.number = rtl_loc_id 
                    AND bucket_id = 'ON_HAND'
				GROUP BY organization_id, item_id) sla
		    LEFT OUTER JOIN
            (SELECT itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id, 
	                SUM(COALESCE(quantity,0) * CASE WHEN adjustment_flag = 1 THEN 1 ELSE -1 END) AS quantity
	         FROM rpt_trl_stock_movement_view itm_mov
	         WHERE CONVERT(char(10),business_date,120) > CONVERT(char(10),@stock_val_date_param,120)
	         GROUP BY itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id) ts
	         ON sla.organization_id = ts.organization_id
	            AND sla.item_id = ts.item_id
            LEFT OUTER JOIN (
                  SELECT id.organization_id, idl.inventory_item_id, idl.rtl_loc_id , id.invctl_document_id, 
                        idl.invctl_document_line_nbr, idl.create_date, COALESCE(idl.unit_count,0) AS unit_count, COALESCE(idl.unit_cost,0) AS unit_cost
                  FROM inv_invctl_document_lineitm idl, fn_integerListToTable(@rtl_loc_id_param) fn, inv_invctl_document id
                  WHERE idl.organization_id = id.organization_id AND idl.rtl_loc_id = id.rtl_loc_id AND 
                        idl.document_typcode = id.document_typcode AND idl.invctl_document_id = id.invctl_document_id AND 
                        idl.unit_count IS NOT NULL AND idl.unit_cost IS NOT NULL AND idl.create_date IS NOT NULL AND
                        id.document_subtypcode = 'ASN'
                        AND id.status_code IN ('CLOSED', 'OPEN', 'IN_PROCESS')
                        AND CAST(FLOOR(CAST(idl.create_date AS FLOAT)) AS DATETIME) <= @stock_val_date_param
                        AND fn.number = idl.rtl_loc_id 
                        AND @organization_id_param = idl.organization_id
            ) doc
            on sla.organization_id = doc.organization_id AND 
               sla.item_id = doc.inventory_item_id
            INNER JOIN itm_item i
            ON sla.item_id = i.item_id AND
               sla.organization_id = i.organization_id
            LEFT OUTER JOIN itm_item style
            ON i.parent_item_id = style.item_id AND
               i.organization_id = style.organization_id
      WHERE @merch_level_1_param in (i.merch_level_1,'%') AND @merch_level_2_param in (i.merch_level_2,'%') AND 
            @merch_level_3_param IN (i.merch_level_3,'%') AND @merch_level_4_param IN (i.merch_level_4,'%') AND
            @item_id_param IN (i.item_id,'%') AND @style_id_param IN (i.parent_item_id,'%') AND
            sla.organization_id = l.organization_id AND 
            fn.number = l.rtl_loc_id AND 
            doc.rtl_loc_id = l.rtl_loc_id AND 
            COALESCE(sla.unitcount,0) + COALESCE(ts.quantity, 0) <> 0
      GROUP BY style.item_id, sla.item_id, doc.invctl_document_id, l.rtl_loc_id, doc.invctl_document_line_nbr, doc.create_date
      ORDER BY sla.item_id,doc.create_date DESC;
      
  BEGIN
    SET @comment = '';
    SET @current_item_id = '';
    SET @pending_unitCount = 0;
    SET @insert = 0;
    OPEN tableCur;
    FETCH tableCur INTO @organization_id, @unitcount, @item_id, @description, @style_id, @style_desc, @rtl_loc_id, @store_name, @invctl_document_id, @invctl_document_nbr,@create_date_timestamp, @unit_count, @unit_cost;
    WHILE @@FETCH_STATUS = 0 
    BEGIN
      IF @current_item_id <> @item_id
      BEGIN
        SET @current_item_id = @item_id;
        SET @pending_unitCount = @unitcount;
      END
		IF @pending_unitCount > 0
		BEGIN
		  IF @pending_unitCount < @unit_count
		  BEGIN
			SET @current_unit_count = @pending_unitCount;
			SET @pending_unitCount = 0;
		  END 
		  ELSE
		  BEGIN
			SET @current_unit_count = @unit_count ;
			SET @pending_unitCount = @pending_unitCount - @unit_count;
		  END
		  SET @insert = 1;
		END
		ELSE IF @pending_unitCount < 0
		   SET @insert = 1;
		ELSE
		   SET @insert = 0;
	      
		SET @organization_id_a = @organization_id
		SET @unitcount_a = @unitcount;
		SET @item_id_a = @item_id;
		SET @description_a = @description;
		SET @style_id_a = @style_id;
		SET @style_desc_a = @style_desc;
		SET @rtl_loc_id_a = @rtl_loc_id;
		SET @store_name_a = @store_name;
		SET @invctl_document_id_a = @invctl_document_id;
		SET @invctl_document_nbr_a = @invctl_document_nbr;
		SET @create_date_timestamp_a = @create_date_timestamp;
		SET @unit_count_a = @unit_count;
		SET @unit_cost_a = @unit_cost;
	  
		FETCH tableCur INTO @organization_id, @unitcount, @item_id, @description, @style_id, @style_desc, @rtl_loc_id, @store_name, @invctl_document_id, @invctl_document_nbr, @create_date_timestamp, @unit_count, @unit_cost;
		IF (@pending_unitCount >= 0 OR @@FETCH_STATUS < 0  OR @item_id <> @item_id_a) AND @insert = 1
		BEGIN
		  SET @comment = '';
		  IF ((@item_id_a <> @item_id AND @pending_unitCount > 0) OR @@FETCH_STATUS < 0)
		  BEGIN
			 IF @pending_unitCount > 0
			 BEGIN
			   SET @comment = '_rptLackDocStockVal';
			 END
		  END
		  IF @pending_unitCount < 0
			 BEGIN
			   SET @invctl_document_id_a = '_rptNoAvailDocStockVal';
			   SET @unit_cost_a = null;
			   SET @unit_count_a = null;
			   SET @current_unit_count = null;
			   SET @create_date_timestamp_a = null;
			   SET @comment = '_rptLackDocStockVal';
			 END
		  INSERT INTO rpt_fifo_detail (organization_id, rtl_loc_id, item_id, invctl_doc_id, user_name, invctl_doc_create_date, description, store_name, 
				 unit_count, current_unit_count, unit_cost, unit_count_a, current_cost, comment, pending_count, style_id, style_desc, invctl_doc_line_nbr)
		  VALUES(@organization_id_a, @rtl_loc_id_a, @item_id_a, @invctl_document_id_a, @user_name_param, @create_date_timestamp_a, @description_a, @store_name_a,
				 @unit_count_a, @current_unit_count, @unit_cost_a, @unitcount_a, @current_unit_count * @unit_cost_a, @comment, @pending_unitCount, @style_id_a, @style_desc_a, @invctl_document_nbr_a);
		END
    END
    CLOSE tableCur;
    DEALLOCATE tableCur;
  END
END
GO
/* 
 * PROCEDURE: [dbo].[sp_fifo_summary] 
 */

PRINT 'dbo.sp_fifo_summary';

IF EXISTS (Select * From sysobjects Where name = 'sp_fifo_summary' and type = 'P')
  DROP PROCEDURE sp_fifo_summary;
GO

CREATE PROCEDURE [dbo].[sp_fifo_summary] 
    @merch_level_1_param	VARCHAR(60), 
    @merch_level_2_param	VARCHAR(60), 
    @merch_level_3_param	VARCHAR(60), 
    @merch_level_4_param	VARCHAR(60),
    @item_id_param          VARCHAR(60),
    @style_id_param         VARCHAR(60),
    @rtl_loc_id_param		VARCHAR(MAX), 
    @organization_id_param	int,
    @user_name_param        VARCHAR(30),
    @stock_val_date_param   DATETIME
 
AS
BEGIN
  --TRUNCATE TABLE rpt_fifo;
  DELETE FROM rpt_fifo WHERE user_name = @user_name_param
  EXEC sp_fifo_detail @merch_level_1_param, @merch_level_2_param, @merch_level_3_param, @merch_level_4_param, @item_id_param, @style_id_param, @rtl_loc_id_param, @organization_id_param, @user_name_param, @stock_val_date_param
  
  DECLARE 
      @organization_id		 int,
      @unit_count			 DECIMAL(14,4),
      @item_id				 VARCHAR(60),
      @description			 VARCHAR(254),
      @style_id				 VARCHAR(60),
      @style_desc			 VARCHAR(254),
      @rtl_loc_id			 int,
      @store_name			 VARCHAR(254),
      @unit_cost			 DECIMAL(17,6),
      @comment				 VARCHAR(254)
  
  DECLARE tableCur CURSOR READ_ONLY FOR 
  
	  SELECT MAX(sla.organization_id), MAX(COALESCE(sla.unitcount,0)) + MAX(COALESCE(ts.quantity, 0)) AS quantity, 
	      sla.item_id, MAX(i.description), style.item_id, MAX(style.description), sla.rtl_loc_id, 
	      MAX(l.store_name), MAX(COALESCE(fifo_detail.unit_cost,0)), MAX(fifo_detail.comment)
	  FROM loc_rtl_loc l, fn_integerListToTable(@rtl_loc_id_param) fn, inv_stock_ledger_acct sla
	  	  
	  LEFT OUTER JOIN
	  (SELECT itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id, 
			SUM(COALESCE(quantity,0) * CASE WHEN adjustment_flag = 1 THEN 1 ELSE -1 END) AS quantity
	   FROM rpt_trl_stock_movement_view itm_mov
	   WHERE CONVERT(char(10),business_date,120) > CONVERT(CHAR(10),@stock_val_date_param,120) 
	   GROUP BY itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id) ts
	   ON sla.organization_id = ts.organization_id
     		AND sla.rtl_loc_id = ts.rtl_loc_id
			AND sla.item_id = ts.item_id
	  LEFT OUTER JOIN (
			SELECT organization_id, item_id, SUM(current_cost)/SUM(current_unit_count) as unit_cost, MAX(comment) as comment
			FROM rpt_fifo_detail
			GROUP BY organization_id, item_id ) fifo_detail
	  ON sla.organization_id = fifo_detail.organization_id AND 
		   sla.item_id = fifo_detail.item_id
	  INNER JOIN itm_item i
		ON sla.item_id = i.item_id AND
		   sla.organization_id = i.organization_id
		LEFT OUTER JOIN itm_item style
		ON i.parent_item_id = style.item_id AND 
		   i.organization_id = style.organization_id
	  WHERE @merch_level_1_param in (i.merch_level_1,'%') AND @merch_level_2_param in (i.merch_level_2,'%') AND 
            @merch_level_3_param IN (i.merch_level_3,'%') AND @merch_level_4_param IN (i.merch_level_4,'%') AND
            @item_id_param IN (i.item_id,'%') AND @style_id_param IN (i.parent_item_id,'%') AND
		    fn.number = sla.rtl_loc_id AND
		    sla.organization_id = l.organization_id AND 
		    sla.rtl_loc_id = l.rtl_loc_id AND
              sla.bucket_id = 'ON_HAND' AND
		    COALESCE(sla.unitcount,0) + COALESCE(ts.quantity, 0) <> 0
	  GROUP BY sla.rtl_loc_id, style.item_id, sla.item_id
	  ORDER BY sla.rtl_loc_id, sla.item_id DESC;

  BEGIN
    OPEN tableCur;
    FETCH tableCur INTO @organization_id, @unit_count, @item_id, @description, @style_id, @style_desc, @rtl_loc_id, @store_name, @unit_cost, @comment;
    WHILE @@FETCH_STATUS = 0 
    BEGIN
       IF @unit_cost = 0
         SET @unit_count = 0
       INSERT INTO rpt_fifo (organization_id, rtl_loc_id, store_name, item_id, user_name, description,  
		   style_id, style_desc, unit_count, unit_cost, comment)
	   VALUES(@organization_id, @rtl_loc_id, @store_name, @item_id, @user_name_param, @description, 
	       @style_id, @style_desc, @unit_count, @unit_cost, @comment); 
	   FETCH tableCur INTO @organization_id, @unit_count, @item_id, @description, @style_id, @style_desc, @rtl_loc_id, @store_name, @unit_cost, @comment;
    END
    CLOSE tableCur;
    DEALLOCATE tableCur;
  END
END
GO
/* 
 * PROCEDURE: [dbo].[sp_ins_upd_flash_sales] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_ins_upd_flash_sales' and type = 'P')
  DROP PROCEDURE sp_ins_upd_flash_sales;
GO

CREATE PROCEDURE dbo.sp_ins_upd_flash_sales (
    @argOrgId int,
    @argRtlLocId int,
    @argBusinessDate datetime,
    @argWkstnId bigint,
    @pLineEnum varchar(254),
    @argQty decimal(11, 2),
    @argNetAmt decimal(17, 6),
    @vCurrencyId varchar(3) = 'USD')
AS
if CONTEXT_INFO()=0x0111001101110000010111110110011001101100011000010111001101101000
begin
  UPDATE rpt_flash_sales
    SET line_count = line_count + @argQty,
        line_amt = line_amt + @argNetAmt,
        update_date = getdate(),
        update_user_id = user
    WHERE organization_id = @argOrgId
      AND rtl_loc_id = @argRtlLocId
      AND wkstn_id = @argWkstnId
      AND business_date = @argBusinessDate
      AND line_enum = @pLineEnum;
    
  IF @@ROWCOUNT = 0  
    INSERT INTO rpt_flash_sales 
        (organization_id, rtl_loc_id, wkstn_id, line_enum, line_count, line_amt, foreign_amt, 
        business_date, currency_id, create_date, create_user_id)
      VALUES 
        (@argOrgId, @argRtlLocId, @argWkstnId, @pLineEnum, @argQty, @argNetAmt, 0, @argBusinessDate, 
        @vCurrencyId, getdate(), user);
end
else
	raiserror('Cannot be run directly.',10,1)
GO
/* 
 * PROCEDURE: [dbo].[sp_ins_upd_hourly_sales] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_ins_upd_hourly_sales' and type = 'P')
  DROP PROCEDURE sp_ins_upd_hourly_sales;
GO

CREATE PROCEDURE dbo.sp_ins_upd_hourly_sales (
    @argOrgId int,
    @argRtlLocId int,
    @argBusinessDate datetime,
    @argWkstnId bigint,
    @argHour datetime,
    @argQty decimal(11, 2),
    @argNetAmt decimal(17, 6),
    @argGrossAmt decimal(17, 6),
    @argTransCount int,
    @argCurrencyId varchar(3) = 'USD')
AS
if CONTEXT_INFO()=0x0111001101110000010111110110011001101100011000010111001101101000
begin
  UPDATE rpt_sales_by_hour
    SET qty = qty + @argQty,
        trans_count = trans_count + @argTransCount,
        net_sales = net_sales + @argNetAmt,
        gross_sales = gross_sales + @argGrossAmt,
        update_date = getdate(),
        update_user_id = user
    WHERE organization_id = @argOrgId
      AND rtl_loc_id = @argRtlLocId
      AND wkstn_id = @argWkstnId
      AND business_date = @argBusinessDate
      AND hour = datepart(hh, @argHour);
                
IF @@ROWCOUNT = 0  
  INSERT INTO rpt_sales_by_hour (organization_id, rtl_loc_id, wkstn_id, hour, qty, trans_count,
      net_sales, business_date, gross_sales, currency_id, create_date, create_user_id)
    VALUES 
      (@argOrgId, @argRtlLocId, @argWkstnId, datepart(hh, @argHour), @argQty, @argTransCount, 
      @argNetAmt ,@argBusinessDate, @argGrossAmt, @argCurrencyId, getdate(), user);
end
else
	raiserror('Cannot be run directly.',10,1)
GO
/* 
 * PROCEDURE: [dbo].[sp_ins_upd_merchlvl1_sales] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_ins_upd_merchlvl1_sales' and type = 'P')
  DROP PROCEDURE sp_ins_upd_merchlvl1_sales;
GO

CREATE PROCEDURE dbo.sp_ins_upd_merchlvl1_sales (
    @argOrgId int,
    @argRtlLocId int,
    @argBusinessDate datetime,
    @argWkstnId bigint,
    @pDeptId varchar(254),
    @argQty decimal(11, 2),
    @argNetAmt decimal(17, 6),
    @argGrossAmt decimal(17, 6),
    @argCurrencyId varchar(3) = 'USD')
AS
if CONTEXT_INFO()=0x0111001101110000010111110110011001101100011000010111001101101000
begin
  UPDATE rpt_merchlvl1_sales
    SET line_count = line_count + @argQty,
        line_amt = line_amt + @argNetAmt,
        gross_amt = gross_amt + @argGrossAmt,
        update_date = getdate(),
        update_user_id = user
    WHERE organization_id = @argOrgId
      AND rtl_loc_id = @argRtlLocId
      AND wkstn_id = @argWkstnId
      AND business_date = @argBusinessDate
      AND merch_level_1 = @pDeptId;
        
  IF @@ROWCOUNT = 0  
    INSERT INTO rpt_merchlvl1_sales (organization_id, rtl_loc_id, wkstn_id, merch_level_1, line_count, 
        line_amt, business_date, gross_amt, currency_id, create_date, create_user_id)
    VALUES 
        (@argOrgId, @argRtlLocId, @argWkstnId, @pDeptId, @argQty, 
        @argNetAmt ,@argBusinessDate, @argGrossAmt, @argCurrencyId, getdate(), user);
end
else
	raiserror('Cannot be run directly.',10,1)
GO
IF EXISTS (Select * From sysobjects Where name = 'sp_next_sequence_value' and type = 'P')
  DROP PROCEDURE sp_next_sequence_value;
GO

CREATE PROCEDURE dbo.sp_next_sequence_value(
  @argOrganizationId      int,
  @argRetailLocationId    int,
  @argWorkstationId       int,
  @argSequenceId          varchar(255),
  @argSequenceMode        varchar(60),
  @argIncrement           bit,
  @argIncrementalValue    int,
  @argMaximumValue        int,
  @argInitialValue        int,
  @argSequenceValue       int OUTPUT)
AS
BEGIN 
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
  BEGIN TRANSACTION
    DECLARE @vCurrentSequence int;
    SELECT @vCurrentSequence = t.sequence_nbr
        FROM com_sequence t WITH(TABLOCKX HOLDLOCK)
        WHERE t.organization_id = @argOrganizationId
        AND t.rtl_loc_id = @argRetailLocationId
        AND t.wkstn_id = @argWorkstationId
        AND t.sequence_id = @argSequenceId
        AND t.sequence_mode = @argSequenceMode
        
    IF @vCurrentSequence IS NOT NULL
    BEGIN
      SET @argSequenceValue = @vCurrentSequence + @argIncrementalValue
      IF(@argSequenceValue > @argMaximumValue) 
        SET @argSequenceValue = @argInitialValue + @argIncrementalValue
        
        -- handle initial value -1
      IF (@argIncrement = '1') 
      BEGIN
        UPDATE com_sequence
        SET sequence_nbr = @argSequenceValue
        WHERE organization_id = @argOrganizationId
        AND rtl_loc_id = @argRetailLocationId
        AND wkstn_id = @argWorkstationId
        AND sequence_id = @argSequenceId
        AND sequence_mode = @argSequenceMode
      END
    END
    ELSE 
    BEGIN
    
      IF (@argIncrement = '1')
        SET @argSequenceValue = @argInitialValue + @argIncrementalValue
      ELSE
        SET @argSequenceValue = @argInitialValue
      
      INSERT INTO com_sequence (organization_id, rtl_loc_id, wkstn_id, sequence_id, sequence_mode, sequence_nbr) 
      VALUES (@argOrganizationId, @argRetailLocationId, @argWorkstationId, @argSequenceId, @argSequenceMode, @argSequenceValue)
    END
  COMMIT TRANSACTION
  RETURN @argSequenceValue
END
GO
PRINT 'sp_replace_org_id';
GO
IF EXISTS (Select * From sysobjects Where name = 'sp_replace_org_id' and type = 'P')
  DROP PROCEDURE sp_replace_org_id;
GO

CREATE PROCEDURE dbo.sp_replace_org_id (
    @argNewOrgId int)
AS
-------------------------------------------------------------------------------------------------------------------
-- Procedure         :  sp_replace_org_id
-- Description       :  This procedure is designed to run in only the training database.  This will change the
--						organization_id on all table to the value passed into the procedure.
-- Version           :  16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
--               Initially created
-- PGH 08/12/10  Change the cursor to read only and added a secion to skrink the transaction log.
-- BCW 09/24/15  Changed argNewOrgId from varchar to int.
-------------------------------------------------------------------------------------------------------------------
  DECLARE @returnValue	int,
		@sql			varchar(500),
		@tableName		varchar(60),
		@LogFile		sysname
  
  DECLARE tableCur CURSOR READ_ONLY FOR 
    SELECT col.table_name 
      FROM information_schema.columns col, information_schema.tables tab
      WHERE col.table_name = tab.table_name AND 
            tab.table_type = 'BASE TABLE' AND 
            col.column_name = 'organization_id';
 
  BEGIN
    SET @returnValue = 0;
    
    OPEN tableCur;
    WHILE 1 = 1 BEGIN
      FETCH tableCur INTO @tableName;
      IF @@FETCH_STATUS <> 0
        BREAK;

      BEGIN TRY
		
        SET @sql = 'UPDATE ' + @tableName + ' SET organization_id = ' + cast(@argNewOrgId as varchar(10));
        PRINT @sql;
        EXEC (@sql);
        
      END TRY
      BEGIN CATCH
        DECLARE @errorMessage varchar(4000);
        DECLARE @errorSeverity int;
        DECLARE @errorState int;

        SELECT @errorMessage = ERROR_MESSAGE(),
               @errorSeverity = ERROR_SEVERITY(),
               @errorState = ERROR_STATE();
 
        SET @returnValue = -1;
          
        RAISERROR (@errorMessage, @errorSeverity, @errorState);
      END CATCH
    END
      
    CLOSE tableCur;
    DEALLOCATE tableCur;

	DECLARE LogFileCur CURSOR READ_ONLY FOR 
   		select name 
			from sys.database_files 
			where type = 1;
 
    OPEN LogFileCur;
	WHILE 1 = 1 BEGIN
      FETCH LogFileCur INTO @LogFile;
      IF @@FETCH_STATUS <> 0
        BREAK;
	
		DBCC SHRINKFILE (@LogFile , 0, TRUNCATEONLY);
    END
      
    CLOSE LogFileCur;
    DEALLOCATE LogFileCur;

    RETURN @returnValue;
  END
GO
/* 
 * PROCEDURE: [dbo].[sp_replace_value] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_replace_value' and type = 'P')
  DROP PROCEDURE sp_replace_value;
GO

CREATE PROCEDURE dbo.sp_replace_value (
    @argOrgId int,
    @argColumnName varchar(60),
    @argNewValue varchar(256))
AS
  DECLARE @sql varchar(500);
  DECLARE @tableName varchar(60);
  
  DECLARE tableCursor CURSOR FOR
    SELECT col.table_name
      FROM information_schema.columns col, information_schema.tables tab
      WHERE col.table_name = tab.table_name 
        AND tab.table_type = 'BASE TABLE' 
        AND col.column_name = @argColumnName;

  BEGIN
    OPEN tableCursor;
    WHILE 1 = 1
    BEGIN
      FETCH tableCursor INTO @tableName;
      
      IF @@FETCH_STATUS <> 0
        BREAK;
        
      SET @sql = 'UPDATE ' + @tableName + ' SET ' + @argColumnName + ' = ''' + @argNewValue + ''' WHERE organization_id = ' + @argOrgId;
      EXEC (@sql);
    END
    CLOSE tableCursor;
    DEALLOCATE tableCursor;
  END
GO
IF EXISTS (Select * From sysobjects Where name = 'sp_set_sequence_value' and type = 'P')
  DROP PROCEDURE sp_set_sequence_value;
GO

CREATE PROCEDURE dbo.sp_set_sequence_value(
  @argOrganizationId      int,
  @argRetailLocationId    int,
  @argWorkstationId       int,
  @argSequenceId          varchar(255),
  @argSequenceMode        varchar(60),
  @argSequenceValue       int)
AS
BEGIN
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
  BEGIN TRANSACTION
    UPDATE com_sequence WITH(TABLOCKX HOLDLOCK)
        SET sequence_nbr = @argSequenceValue
        WHERE organization_id = @argOrganizationId
        AND rtl_loc_id = @argRetailLocationId
        AND wkstn_id = @argWorkstationId
        AND sequence_id = @argSequenceId    
        And sequence_mode = @argSequenceMode
  COMMIT TRANSACTION
END
GO
PRINT 'dbo.sp_shrink';
GO

IF OBJECT_ID('dbo.sp_shrink') IS NOT NULL
	DROP PROCEDURE dbo.sp_shrink;
GO
	
CREATE PROCEDURE dbo.sp_shrink (--@as_db_name		varchar = 'xstore',
					  			  @ai_free_space	int	= 10)
AS
BEGIN
-------------------------------------------------------------------------------------------------------------------
--                     
-- Procedure         : sp_shrink (as_db_name varchar, ai_free_space int)
-- Parameters		 : as_db_name
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
	DECLARE
		@ls_owner_nm			sysname,
		@ls_table_nm			sysname,
		@ls_index_nm			sysname,
		@li_index_id			integer,
		@li_fillfactor			integer,
		@ls_domain				char(3),
		@ls_sqlcmd				varchar(256);
		
	DECLARE Table_List CURSOR FOR
		SELECT schema_name(schema_id), object_name (object_id)
			FROM sys.tables
			WHERE type = 'U'
	
	--
	-- Loop through the tables and rebuild the indexes with 100% fill factor
	--
	OPEN Table_List

	FETCH NEXT
	FROM Table_List
	INTO @ls_owner_nm, @ls_table_nm

	WHILE @@FETCH_STATUS = 0
	BEGIN
		SET @ls_sqlcmd = 'ALTER INDEX ALL  on [' + @ls_owner_nm + '].[' + @ls_table_nm + '] REBUILD WITH (FILLFACTOR=100)';  -- Online only works with Enterprise Edition
		--print @ls_sqlcmd;
		exec (@ls_sqlcmd);

		FETCH NEXT
		FROM Table_List
		INTO @ls_owner_nm, @ls_table_nm
	END;
	
	CLOSE Table_List;
	DEALLOCATE Table_List;

	--
	-- Shrink the database to the desired size
	--
	print 'Free Space%: ' + str(@ai_free_space);
	DBCC SHRINKDATABASE (0, @ai_free_space);

	DECLARE Index_List CURSOR FOR
		SELECT schema_name(t.schema_id), object_name(i.object_id), i.index_id, i.name
			FROM sys.indexes i
			JOIN sys.tables t on i.object_id = t.object_id
			WHERE t.type = 'U'
			  and i.index_id > 0
	
	--
	-- Loop through the indexes and rebuild the indexes
	--
	OPEN Index_List

	FETCH NEXT
	FROM Index_List
	INTO @ls_owner_nm, @ls_table_nm, @li_index_id, @ls_index_nm

	WHILE @@FETCH_STATUS = 0
	BEGIN

		set @ls_domain = substring(@ls_table_nm, 1, 3);
		--print 'Domain: ' + @ls_domain;
		--print 'Table: ' + @ls_table_nm;
		--print 'Index: ' + @ls_index_nm;
		IF @ls_domain in ('TND', 'COM', 'DSC', 'LOC', 'TAX', 'CRM', 'DOC', 'HRS', 'SCH', 'SEC') -- Non-Transaction tables
			set @li_fillfactor = 100;
		ELSE								-- transaction tables
			IF @li_index_id < 2
				set @li_fillfactor = 90;		-- clustered / heap indexes
			ELSE
				set @li_fillfactor = 95;		-- non-clustered indexes
		
		SET @ls_sqlcmd = 'ALTER INDEX [' + @ls_index_nm + ']  on [' + @ls_owner_nm + '].[' + @ls_table_nm + '] REBUILD WITH (FILLFACTOR=' + ltrim(str(@li_fillfactor)) + ')';  -- Online only works with Enterprise Edition
		--print @ls_sqlcmd;
		exec (@ls_sqlcmd);

		FETCH NEXT
		FROM Index_List
		INTO @ls_owner_nm, @ls_table_nm, @li_index_id, @ls_index_nm
	END;
	
	CLOSE Index_List;
	DEALLOCATE Index_List;
END;
GO
/* 
 * PROCEDURE: [dbo].[sp_shrinkLog] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_shrinkLog' and type = 'P')
  DROP PROCEDURE sp_shrinkLog;
GO

CREATE PROCEDURE sp_shrinkLog (
    @argDbName AS varchar(255), 
    @argNewSize AS int)
AS
  DECLARE @fileId AS int;
  DECLARE @serverVersion AS sql_variant;
  DECLARE logCursor CURSOR FOR 
    SELECT fileid FROM sysfiles 
      WHERE (status & 0x40) = 0x040;
  
  OPEN logCursor;
  
  FETCH NEXT FROM logCursor INTO @fileId;
  
  WHILE @@FETCH_STATUS = 0 BEGIN
    IF @argNewSize = 0  OR (SELECT size * 8 /1024 FROM sysfiles WHERE fileId=2) > @argNewSize
      DBCC SHRINKFILE (@fileId) -- default shrink
    ELSE
      DBCC SHRINKFILE (@fileId, @argNewSize);
  
    FETCH NEXT FROM logCursor INTO @fileId;
  END
  
  CLOSE logCursor;
  DEALLOCATE logCursor;
  
--
-- FB: 205359 - Removing the Backup Log because it was removed in SQL Server 2008
--
--  SELECT @serverVersion = SERVERPROPERTY('productversion');
--  
--  IF SUBSTRING(CONVERT(varchar(max), @serverVersion), 1, 2) = '10'       -- SQL Server 2008
--    BACKUP LOG @argDbName TO DISK = 'NUL:';    
--  ELSE                                          -- SQL Server 2005
--    BACKUP LOG @argDbName WITH TRUNCATE_ONLY;     
GO
/* 
 * PROCEDURE: [dbo].[sp_xstoreOrgCopy] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_xstoreOrgCopy' and type = 'P')
  DROP PROCEDURE sp_xstoreOrgCopy;
GO

CREATE PROCEDURE dbo.sp_xstoreOrgCopy (
    @pSrcOrgId int,
    @pDstOrgId int,
    @pOption varchar(25) = NULL)
AS
  IF (@pSrcOrgId = @pDstOrgId) 
  BEGIN
    RAISERROR('Source cannot be the same as destination', 16, 1);
    RETURN(1);
  END
  
  DECLARE @tableName  varchar(255);
  DECLARE @deleteStr  varchar(255);
  DECLARE @insertStmt varchar(4000);
  DECLARE @selectStmt varchar(4000);
  DECLARE @colName    varchar(255);
  DECLARE @dataType   varchar(30);
  DECLARE @value      varchar(255);
  DECLARE @optDeletes int;
  DECLARE @optInserts int;
  DECLARE @optExec    int;

  IF LOWER(@pOption) = 'delete'
    SELECT @optDeletes = 1, @optInserts = 0, @optExec = 0;
  ELSE IF LOWER(@pOption) = 'insert'
    SELECT @optDeletes = 0, @optInserts = 1, @optExec = 0;
  ELSE IF LOWER(@pOption) = 'exec'
    SELECT @optDeletes = 1, @optInserts = 1, @optExec = 1;
  ELSE 
    SELECT @optDeletes = 1, @optInserts = 1, @optExec = 0;

  -- get a cursor of all tables that have a column named 'organization_id'  
  DECLARE tableCur CURSOR FOR
    SELECT DISTINCT tab.name 
      FROM sysobjects tab 
        INNER JOIN syscolumns col ON tab.id = col.id 
      WHERE tab.type = 'U' AND col.name = 'organization_id' ORDER BY tab.name;
  
  OPEN tableCur;

  WHILE 1 = 1 
  BEGIN
    FETCH NEXT FROM tableCur INTO @tableName;

    IF @@FETCH_STATUS <> 0 
      BREAK;

    IF @optDeletes <> 0 
      BEGIN
        SET @deleteStr = 'DELETE FROM ' + @tableName + ' WHERE organization_id = ' + CAST(@pDstOrgId AS varchar) + ';'
        PRINT (@deleteStr);
        IF @optExec <> 0 EXEC (@deleteStr);
      END

    IF @optInserts <> 0 
      BEGIN
        SET @insertStmt = 'INSERT INTO ' + @tableName + ' (organization_id';
        SET @selectStmt = 'SELECT ' + CAST(@pDstOrgId AS varchar);
    
        DECLARE colCur CURSOR FOR 
          SELECT column_name, data_type 
            FROM information_schema.columns 
           WHERE table_name = @tableName 
             AND data_type <> 'uniqueidentifier'
             AND column_name NOT IN ('organization_id', 'create_date', 'create_user_id', 'update_date', 'update_user_id', 
                                     'PROCESSED_DATE', 'PROCESSED_ID', 'record_state', 'record_timestamp', 'dss_timestamp');
        OPEN colCur;
     
        WHILE 1 = 1
          BEGIN
            FETCH NEXT FROM colCur INTO @colName, @dataType;
    
            IF @@FETCH_STATUS <> 0
              BREAK;
            
            SET @insertStmt = @insertStmt + ', ' + @colName;
            SET @selectStmt = @selectStmt + ', ';
            
            IF @colName LIKE '%_org_id'
              BEGIN
                SET @selectStmt = @selectStmt + CONVERT(varchar, @pDstOrgId);
              END
            ELSE
              BEGIN
                SET @selectStmt = @selectStmt + @colName;
              END
          END
    
        SET @insertStmt = @insertStmt + ') (' + @selectStmt + ' FROM ' + @tableName 
              + ' WHERE organization_id = ' + CAST(@pSrcOrgId AS varchar) + ');'
        
        PRINT (@insertStmt);
        IF @optExec <> 0 EXEC (@insertStmt);
          
        CLOSE colCur;
        DEALLOCATE colCur;
      END
  END

  CLOSE tableCur;
  DEALLOCATE tableCur;
  GO
GO
/* 
 * PROCEDURE: [dbo].[sp_xstore_delete_all] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_xstore_delete_all' and type = 'P')
  DROP PROCEDURE sp_xstore_delete_all;
GO

CREATE PROCEDURE dbo.sp_xstore_delete_all
AS
  DECLARE @tableName varchar(255);
  DECLARE @sql varchar(255);
  DECLARE tableCursor CURSOR FAST_FORWARD FOR
    SELECT table_name
    FROM information_schema.tables
    WHERE table_schema = 'dbo' AND table_type = 'BASE TABLE'
    ORDER BY table_name;
    
  OPEN tableCursor;

  WHILE 1 = 1
  BEGIN
    FETCH NEXT FROM tableCursor INTO @tableName;
    IF @@FETCH_STATUS <> 0 BREAK;
    
    SET @sql = 'TRUNCATE TABLE dbo.' + @tableName;
    PRINT @sql;
    EXEC(@sql);
  END

  CLOSE tableCursor;
  DEALLOCATE tableCursor;
GO
/* 
 * PROCEDURE: [dbo].[sp_xstore_list_all] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_xstore_list_all' and type = 'P')
  DROP PROCEDURE sp_xstore_list_all;
GO

CREATE PROCEDURE dbo.sp_xstore_list_all
AS
  CREATE TABLE
  #t
  (
    tableName varchar(100),
    tableRowCount int
  );
  
  DECLARE @tableName varchar(255);
  DECLARE tableCursor CURSOR FOR
    SELECT name FROM sysobjects WHERE type = 'u' ORDER BY name;
  
  OPEN tableCursor;
  
  WHILE 1 = 1 BEGIN
    FETCH NEXT FROM tableCursor INTO @tableName;
    
    IF @@FETCH_STATUS <> 0
      BREAK;
  
    INSERT INTO #t (tableName, tableRowCount)
      EXEC ('SELECT ''' + @tableName + ''', COUNT(*) FROM [' + @tableName + '] WITH (NOLOCK)');
  END
  
  CLOSE tableCursor;
  DEALLOCATE tableCursor;
  SELECT * FROM #t ORDER BY tableRowCount DESC;
  DROP TABLE #t;
GO

/* 
 * FUNCTION: [dbo].[fn_NLS_LOWER] 
 */

PRINT 'fn_NLS_LOWER';

IF EXISTS (SELECT * FROM sys.objects WHERE name = 'fn_NLS_LOWER')
	DROP FUNCTION dbo.fn_NLS_LOWER
GO

CREATE FUNCTION fn_NLS_LOWER (@argString nvarchar(MAX))
RETURNS nvarchar(MAX)
AS
BEGIN
	RETURN LOWER(@argString)
END
GO
/* 
 * FUNCTION: [dbo].[fn_NLS_UPPER] 
 */

PRINT 'fn_NLS_UPPER';

IF EXISTS (SELECT * FROM sys.objects WHERE name = 'fn_NLS_UPPER')
	DROP FUNCTION dbo.fn_NLS_UPPER
GO

CREATE FUNCTION fn_NLS_UPPER (@argString nvarchar(MAX))
RETURNS nvarchar(MAX)
AS
BEGIN
	RETURN UPPER(@argString)
END
GO
/* 
 * FUNCTION: [dbo].[fn_ParseDate] 
 */

PRINT 'dbo.fn_ParseDate';

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[fn_ParseDate]') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
	DROP FUNCTION [dbo].[fn_ParseDate]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE FUNCTION fn_ParseDate (@argDateString varchar(24))
RETURNS datetime
AS
BEGIN
	-- Declare the return variable here
	DECLARE @vs_year varchar(4),
	 @vs_month varchar(2), 
	 @vs_day varchar(2), 
	 @vs_hour varchar(2)='00', 
	 @vs_minute varchar(2)='00', 
	 @vs_second varchar(2)='00', 
	 @vs_ms varchar(4)='000'

	SET @vs_year = LEFT(@argDateString,4)
	SET @argDateString = RIGHT(@argDateString,len(@argDateString)-5)
	SET @vs_month = LEFT(@argDateString,2)
	SET @argDateString = RIGHT(@argDateString,len(@argDateString)-3)
	SET @vs_day = LEFT(@argDateString,2)
	if len(@argDateString)>5
	begin
		SET @argDateString = RIGHT(@argDateString,len(@argDateString)-3)
		SET @vs_hour = LEFT(@argDateString,2)
		if len(@argDateString)>4
		begin
			SET @argDateString = RIGHT(@argDateString,len(@argDateString)-3)
			SET @vs_minute = LEFT(@argDateString,2)
			if len(@argDateString)>4
			begin
				SET @argDateString = RIGHT(@argDateString,len(@argDateString)-3)
				SET @vs_second = LEFT(@argDateString,2)
				if len(@argDateString)>3
					SET @vs_ms = RIGHT(@argDateString,len(@argDateString)-3)
			end
		end
	end
	-- Return the result of the function
	RETURN convert(datetime,@vs_year + '-' + @vs_month + '-' + @vs_day + ' ' + @vs_hour + ':' + @vs_minute + ':' + @vs_second + '.' + @vs_ms,120)

END
GO

PRINT 'dbo.sp_dbMaintenance';
GO

IF OBJECT_ID('dbo.sp_dbMaintenance') IS NOT NULL
	DROP PROCEDURE dbo.sp_dbMaintenance;
GO

CREATE PROCEDURE dbo.sp_dbMaintenance
AS
-------------------------------------------------------------------------------------------------------------------
--                                                                                                               --
-- Procedure         : sp_dbMaintenance
-- Description       : Performs standard maitntenance to a SQL Server database
--						1) Check recovery model and last backup
--						2) Index Reorganize
--						3) CheckDB
-- Version           : 16.0                                                                                       --
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-- ST  01/30/07  Initially created
-- PGH 02/11/10  Rewriten for 2005 / 2008
-------------------------------------------------------------------------------------------------------------------
DECLARE @dbName				sysname,
		@dbRecovery			varchar(60),
		@LastFullBackup		datetime,
		@LastTransBackup	datetime,
		@MinFragmentation	decimal
--		@dbBk				varchar(255),
--		@logBk				varchar(255),
--		@doBk				bit

BEGIN
	-- config
	SET @MinFragmentation = 30 --Percent
--	SET @dbBk = 'c:\xstoredb\backup\xstoreDb.bk' -- db back up destinataion
--	SET @logBk = 'c:\xstoredb\backup\xstoreLog.bk'  -- log file back up destination
--	SET @doBK = 0 -- set to true for backup
	-- end config

	SET @dbName = db_name();
	SELECT @dbRecovery = recovery_model_desc FROM SYS.DATABASES WHERE NAME =DB_NAME();
	SELECT @LastFullBackup = max(backup_finish_date) from msdb..backupset
		WHERE type = 'D'
		  AND database_name = DB_NAME();
	SELECT @LastTransBackup = max(backup_finish_date) from msdb..backupset
		WHERE type = 'L'
		  AND database_name = DB_NAME();
		  
	--
	-- 1) Check Backup Status
	--
	
	PRINT '';
	PRINT ' Database Backup Info:';
	PRINT '		Database Name:	   ' + db_name();
	PRINT '		Recovery Mode:	   ' + @dbRecovery;
	PRINT '		Last Full Backup:  ' + COALESCE(cast(@LastFullBackup as varchar), ' ');
	PRINT '     Last Trans Backup: ' + COALESCE(cast(@LastTransBackup as varchar), ' ');
	PRINT '';

	SELECT  CASE df.data_space_id
				WHEN 0 THEN 'LOG'
				ELSE  ds.name
			END AS [FileGroupName],
			df.name AS [FileName], 
			df.physical_name AS [PhysicalName], 
			round((cast(df.size as decimal) / 128) , 2) AS [Size], 
			round((FILEPROPERTY(df.name, 'SpaceUsed')/ 128.0),2) AS [SpaceUsed],	--Changed from Available Space to Used Space
			cast(ROUND(((FILEPROPERTY(df.name, 'SpaceUsed')/ 128.0) / (cast(df.size as decimal) / 128)) * 100, 0) as int)
				AS [SpaceUsedPCT],
			CASE is_percent_growth
			WHEN 0 THEN growth / 128
			ELSE growth
		END AS [Growth],
		CASE is_percent_growth
			WHEN 0 THEN 'MB'
			ELSE 'PCT'
		END AS [Growth Type],
		CASE df.max_size
			WHEN -1 THEN df.max_size
			ELSE max_size / 128
		END AS [Max Growth Size],					
		state_desc
	FROM sys.database_files df
	LEFT JOIN sys.data_spaces ds on ds.data_space_id = df.data_space_id;
	
	--
	-- 2) Index Reorganize
	--
	
	PRINT 'Reorganizing Indexes'
	EXEC dbo.sp_defrag_indexes @MinFragmentation
	
	-- 3) Update the stats
	--PRINT 'Updating Statistics'
	--EXEC sp_updatestats -- with default parameters runs stats for sample rows on all tables
	

	-- 3) Check DB
	PRINT 'CheckDB';
	DBCC CHECKDB WITH NO_INFOMSGS;

	-- 5) Backup Database
	--IF @doBk = 1
	--	BEGIN
	--		BACKUP DATABASE @dbName TO DISK = @dbBk
	--		BACKUP LOG @dbName TO DISK = @logBk
	--	END
END
GO
-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : SP_FLASH
-- Description       : Loads data into the Report tables which are then used by the flash reports.
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....     	Initial Version
-- PGH  02/23/10    Removed the currencyid paramerer, then joining the loc_rtl_loc table to get the default
--                  currencyid for the location.  If the default is not set, defaulting to 'USD'. 
-- BCW  03/07/12	Updated per Padma Golli's instructions.
-- BCW  06/21/12	Updated per Emily Tan's instructions.
-- BCW	12/05/13	Replaced the sale cursor by writing the transaction line item directly into the rpt_sale_line table.
-------------------------------------------------------------------------------------------------------------------
PRINT 'dbo.sp_flash';

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
@vNonPhys varchar(30),
@vNonPhysSaleType varchar(30),
@vNonPhysType varchar(30),
@vNonPhysPrice decimal(17, 6),
@vNonPhysQuantity decimal(11, 2)

declare -- Status codes
@vTransStatcode varchar(30),
@vTransTypcode varchar(30),
@vSaleLineItmTypcode varchar(30),
@vTndrStatcode varchar(60),
@vLineitemStatcode varchar(30)

declare -- others
@vTransTimeStamp datetime,
@vTransDate datetime,
@vTransCount int,
@vTndrCount int,
@vPostVoidFlag bit,
@vReturnFlag bit,
@vTaxTotal decimal(17, 6),
@vPaid varchar(30),
@vLineEnum varchar(150),
@vTndrId varchar(60),
@vItemId varchar(60),
@vRtransLineItmSeq int,
@vDepartmentId varchar(90),
@vTndridProp varchar(60),
@vCurrencyId varchar(3)

declare
@vSerialNbr varchar(60),
@vPriceModAmt decimal(17, 6),
@vPriceModReascode varchar(60),
@vNonPhysExcludeFlag bit,
@vCustPartyId varchar(60),
@vCustLastName varchar(90),
@vCustFirstName varchar(90),
@vItemDesc varchar(120),
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
  @argWrkstnId,'TOTALTAX', 1, @vTaxTotal, @vCurrencyId          

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
        @argWrkstnId,'TOTALTAX',-1,@vTaxTotal,@vCurrencyId
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
        @argWrkstnId,'GROSSSALES',@vGrossQuantity, @vGrossAmount, @vCurrencyId
      -- Net Sales update
      if abs(@vNetAmount) > 0 and @vGrossAmount <> coalesce(@vAccountCredit,0)
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'NETSALES',@vQuantity, @vNetAmount, @vCurrencyId  
      -- Discounts
      if abs(@vOverrideAmt) > 0
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'OVERRIDES',@vQuantity, @vOverrideAmt, @vCurrencyId  
      -- Discounts  
      if abs(@vDiscountAmt) > 0
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'DISCOUNTS',@vQuantity, @vDiscountAmt, @vCurrencyId  

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
-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : SP_REPORT
-- Description       : This procedure is to be executed on the XCenter database to populate the flash report tables.
--                      It calls sp_flash for each record in the trn_trans table where the flash_sales_flag is zero
--                      to generate the data.  All of the report / business logic will be kept in sp_flash.
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- PGH 04/25/11		Added the options FAST_FORWARD READ_ONLY to the main cursor to improve performance.
-- BCW 12/05/13		Added optional parameters and logging.
-------------------------------------------------------------------------------------------------------------------
PRINT 'dbo.sp_report';

IF EXISTS (Select * From sysobjects Where name = 'sp_report' and type = 'P')
  DROP PROCEDURE sp_report;
GO

CREATE PROCEDURE sp_report
(
	@job_id			INT			=0,
	@firstLoc_id	INT			=0,
	@lastLoc_id		INT			=999999999,
	@start_date		DATETIME	='1/1/1900',
	@end_date		DATETIME	='12/31/9999',
	@batch_count	INT			=-1,
	@nologging		BIT			=0
)
AS
  DECLARE -- Keys
      @vOrganizationId		int,
      @vRetailLocationId	int,
      @vBusinessDate		datetime,
      @vWrkstnId			bigint,
      @vTransSeq			bigint,
	  @starttime			DATETIME,
	  @sql					VARCHAR(MAX);

set @starttime=GETDATE()

  DECLARE @staging TABLE (
    organization_id  INT       NOT NULL,
    rtl_loc_id       INT       NOT NULL,
    business_date    DATETIME  NOT NULL,
    wkstn_id         BIGINT    NOT NULL,
    trans_seq        BIGINT    NOT NULL
  )

if OBJECT_ID('log_sp_report') IS NULL
	SET @nologging=1

SET @sql = 'SELECT '

if @batch_count > -1
	SET @sql = @sql + ' top(' + cast(@batch_count as varchar(10)) + ') '
SET @sql = @sql + 'organization_id, 
          rtl_loc_id, 
          business_date, 
          wkstn_id, 
          trans_seq
   FROM trn_trans with (READPAST)
   WHERE flash_sales_flag = 0
   AND trans_typcode in (''RETAIL_SALE'',''POST_VOID'')
   AND trans_statcode not like ''CANCEL%'''

if @firstLoc_id <> 0 OR @lastLoc_id <> 999999999
	SET @sql = @sql + ' AND rtl_loc_id between ' + cast(@firstLoc_id as varchar(10)) + ' AND ' + cast(@lastLoc_id as varchar(10))

if @start_date <> '1/1/1900' OR @end_date <> '12/31/9999'
	SET @sql = @sql + ' AND business_date between ''' + cast(@start_date as varchar(19)) + ''' AND ''' + cast(@end_date as varchar(19)) + ''''

if @nologging = 0
SET @sql = @sql + ' ORDER BY business_date, rtl_loc_id';

INSERT @staging (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq) exec(@sql)

  DECLARE cur_main CURSOR FAST_FORWARD FOR
  SELECT organization_id, 
          rtl_loc_id, 
          business_date, 
          wkstn_id, 
          trans_seq
   FROM @staging

  if @nologging=0
	  insert into log_sp_report WITH(ROWLOCK) (job_id,loc_id,business_date,job_start,completed,expected)
	  select @job_id, rtl_loc_id, business_date, @starttime, 0, COUNT(*)
	  from @staging
	  group by rtl_loc_id,business_date

  OPEN cur_main;

  WHILE 1 = 1 BEGIN
    FETCH FROM cur_main 
      INTO @vOrganizationId,
           @vRetailLocationId, 
           @vBusinessDate, 
           @vWrkstnId, 
           @vTransSeq;
  
	IF @@FETCH_STATUS <> 0 
      BREAK;

	if @nologging=0
		update log_sp_report WITH(ROWLOCK) set start_dt = GETDATE() where loc_id = @vRetailLocationId and business_date=@vBusinessDate and job_start=@starttime and job_id=@job_id and start_dt is null

	EXEC sp_flash @vOrganizationId,
				  @vRetailLocationId, 
				  @vBusinessDate, 
				  @vWrkstnId, 
				  @vTransSeq;

	if @nologging=0
		update log_sp_report WITH(ROWLOCK) set completed = completed + 1,end_dt = GETDATE() where loc_id = @vRetailLocationId and business_date=@vBusinessDate and job_start=@starttime and job_id=@job_id

  END;
  CLOSE cur_main;
  DEALLOCATE cur_main;

if @nologging=0
	update log_sp_report WITH(ROWLOCK) set job_end = GETDATE() where job_start=@starttime and job_id=@job_id
GO
/* 
 * TRIGGER: [dbo].[trg_insert_trl_returned_item_journal] 
 */

IF EXISTS (Select * From sysobjects Where name = 'trg_insert_trl_returned_item_journal' and type = 'TR')
  DROP TRIGGER trg_insert_trl_returned_item_journal;
GO

CREATE TRIGGER trg_insert_trl_returned_item_journal
    ON trl_returned_item_journal
    AFTER INSERT
AS
  BEGIN
    DECLARE @new_organization_id int,
            @new_rtl_loc_id int,
            @new_wkstn_id bigint,
            @new_business_date datetime,
            @new_trans_seq bigint,
            @new_rtrans_lineitm_seq int,
            @new_returned_count decimal(11, 2);

    SELECT @new_organization_id = organization_id,
           @new_rtl_loc_id = rtl_loc_id,
           @new_wkstn_id = wkstn_id,
           @new_business_date = business_date,
           @new_trans_seq = trans_seq,    
           @new_rtrans_lineitm_seq = rtrans_lineitm_seq,
           @new_returned_count = returned_count
      FROM inserted;

    IF EXISTS (
        Select 1 From trn_trans trans
          Where trans.organization_id = @new_organization_id
            And trans.rtl_loc_id = @new_rtl_loc_id
            And trans.wkstn_id = @new_wkstn_id
            And trans.business_date = @new_business_date
            And trans.trans_seq = @new_trans_seq) 
    BEGIN
      IF EXISTS (
          Select 1 From trl_returned_item_count With (NOLOCK) 
            Where organization_id = @new_organization_id 
              And rtl_loc_id = @new_rtl_loc_id 
              And wkstn_id = @new_wkstn_id 
              And business_date = @new_business_date 
              And trans_seq = @new_trans_seq 
              And rtrans_lineitm_seq = @new_rtrans_lineitm_seq)
      BEGIN
        UPDATE trl_returned_item_count 
          SET returned_count = returned_count + @new_returned_count
          WHERE organization_id = @new_organization_id 
            AND rtl_loc_id = @new_rtl_loc_id 
            AND wkstn_id = @new_wkstn_id 
            AND business_date = @new_business_date 
            AND trans_seq = @new_trans_seq 
            AND rtrans_lineitm_seq = @new_rtrans_lineitm_seq;
      END
    ELSE
      BEGIN
        INSERT INTO trl_returned_item_count
            (organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, rtrans_lineitm_seq, returned_count)
          VALUES
            (@new_organization_id, @new_rtl_loc_id, @new_wkstn_id, @new_business_date, 
            @new_trans_seq, @new_rtrans_lineitm_seq, @new_returned_count);
      END
    END
  END
GO

INSERT INTO ctl_version_history (
    organization_id, base_schema_version, customer_schema_version, base_schema_date, 
    create_user_id, create_date, update_user_id, update_date)
VALUES (
    $(OrgID), '16.0.0.0.699', '0.0.0 - 0.0', getDate(), 
    'Oracle', getDate(), 'Oracle', getDate());

GO

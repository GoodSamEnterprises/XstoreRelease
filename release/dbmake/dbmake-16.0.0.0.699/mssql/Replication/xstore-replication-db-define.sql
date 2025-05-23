
IF NOT EXISTS (Select * From dbo.sysusers Where name = 'dtv' And uid < 16382)
  CREATE USER dtv FOR LOGIN dtv WITH DEFAULT_SCHEMA=dbo;
EXEC sp_addrolemember N'db_owner', 'dtv';

IF NOT EXISTS (Select * From dbo.sysusers Where name = 'pos' And uid < 16382)
  CREATE USER pos FOR LOGIN pos WITH DEFAULT_SCHEMA=dbo;
EXEC sp_addrolemember N'db_datareader', 'pos';
EXEC sp_addrolemember N'db_datawriter', 'pos';
GRANT execute to pos;

/* 
 * TABLE: [dbo].[ctl_replication_queue] 
 */

CREATE TABLE [dbo].[ctl_replication_queue](
    [organization_id]           int             NOT NULL,
    [rtl_loc_id]                int             NOT NULL,
    [wkstn_id]                  bigint          NOT NULL,
    [db_trans_id]               varchar(60)     NOT NULL,
    [service_name]              varchar(60)     NOT NULL,
    [date_time]                 bigint          NULL,
    [expires_after]             bigint          NULL,
    [expires_immediately_flag]  bit             DEFAULT ((0)) NULL,
    [never_expires_flag]        bit             DEFAULT ((0)) NULL,
    [offline_failures]          int             NULL,
    [error_failures]            int             DEFAULT ((0)) NOT NULL,
    [replication_data]          varchar(max)    NULL,
    [create_date]               datetime        NULL,
    [create_user_id]            varchar(30)     NULL,
    [update_date]               datetime        NULL,
    [update_user_id]            varchar(30)     NULL,
    [record_state]              varchar(30)     NULL,
    CONSTRAINT [pk_ctl_replication_queue] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [db_trans_id], [service_name]) WITH (FILLFACTOR = 80)
)
go




SPOOL replication.log;

-- finally create required tables
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt
    FROM ALL_TABLES
    WHERE TABLE_NAME = 'RPL_REPLICATION_DATA';
          
    IF li_rowcnt = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE rpl_replication_data(
			 organization_id		number(10,0)     NOT NULL,
			 rtl_loc_id				number(10,0)     NOT NULL,
			 wkstn_id				number(19,0)     NOT NULL,
			 timestamp_str			char(24 char)    NOT NULL,
			 publish_status			varchar2(32 char),
			 payload				clob,
			 payload_summary		varchar2(254 char),
			 error_details			clob,
			 orig_arrival_timestamp	TIMESTAMP(6),
	         reprocess_user_id		varchar2(20 char),
	         reprocess_timestamp	TIMESTAMP(6),
	         reprocess_attempts		number(10, 0),
			 create_date			TIMESTAMP(6),
			 create_user_id			varchar2(30 char),
			 update_date			TIMESTAMP(6),
			 update_user_id			varchar2(30 char),
			 CONSTRAINT PK_rpl_replication_data PRIMARY KEY (organization_id, rtl_loc_id, timestamp_str, wkstn_id)
            )'
            ;
    END IF;
END;
/

/* 
 * INDEX: [idx_repl_data_timestamp_str] 
 */
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_INDEXES WHERE TABLE_NAME = 'RPL_REPLICATION_DATA' AND INDEX_NAME='IDX_REPL_DATA_TIMESTAMP_STR';
          
    IF li_rowcnt = 0 THEN
        EXECUTE IMMEDIATE 'CREATE INDEX idx_repl_data_timestamp_str ON rpl_replication_data(timestamp_str)';
    END IF; 
END;
/

/* 
 * INDEX: [idx_repl_data_org_ps] 
 */
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_INDEXES WHERE TABLE_NAME = 'RPL_REPLICATION_DATA' AND INDEX_NAME='IDX_REPL_DATA_ORG_PS';
          
    IF li_rowcnt = 0 THEN
        EXECUTE IMMEDIATE 'CREATE INDEX idx_repl_data_org_ps ON rpl_replication_data(ORGANIZATION_ID, publish_status)';
    END IF; 
END;
/

/* 
 * INDEX: [idx_repl_data_date_ps] 
 */
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_INDEXES WHERE TABLE_NAME = 'RPL_REPLICATION_DATA' AND INDEX_NAME='IDX_REPL_DATA_DATE_PS';
          
    IF li_rowcnt = 0 THEN
        EXECUTE IMMEDIATE 'CREATE INDEX idx_repl_data_date_ps ON rpl_replication_data(update_date, publish_status)';
    END IF; 
END;
/

DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt
    FROM ALL_TABLES
    WHERE TABLE_NAME = upper('poll_file_status');
          
    IF li_rowcnt = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE poll_file_status(
			 organization_id		number(10,0)		NOT NULL,
			 file_name				varchar2(254 char)  NOT NULL,
			 timestamp_str			char(24 char)	    NOT NULL,
			 create_date			TIMESTAMP(6),
			 create_user_id			varchar2(30 char),
			 update_date			TIMESTAMP(6),
			 update_user_id			varchar2(30 char),
			 CONSTRAINT PK_poll_file_status PRIMARY KEY (organization_id, file_name)
            )'
            ;
    END IF;
END;
/

DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt
    FROM ALL_TABLES
    WHERE TABLE_NAME = 'RPL_CLEANUP_LOG';
          
    IF li_rowcnt = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE rpl_cleanup_log(
		   deleted_records    number(10, 0)		NOT NULL,
		   start_time		  TIMESTAMP(6)		NOT NULL,
		   end_time			  TIMESTAMP(6)		NOT NULL,
	        table_name		  varchar2(20 char)	NOT NULL,
		  CONSTRAINT PK_rpl_cleanup_log PRIMARY KEY (start_time,table_name)
            )'
            ;
    END IF;
END;
/

DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt
    FROM ALL_TABLES
    WHERE TABLE_NAME = 'TRN_POSLOG_WORK_ITEM';
          
    IF li_rowcnt = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE TRN_POSLOG_WORK_ITEM(
	   organization_id      NUMBER(10, 0)		NOT NULL,
	   rtl_loc_id           NUMBER(10, 0)		NOT NULL,
	   BUSINESS_DATE        TIMESTAMP(6)		NOT NULL,
	   WKSTN_ID             NUMBER(19, 0)		NOT NULL,
	   TRANS_SEQ            NUMBER(19, 0)		NOT NULL,
	   SERVICE_ID           VARCHAR2(60 char)	NOT NULL,
	   WORK_STATUS          VARCHAR2(200 char),
       ERROR_DETAILS        CLOB,
	   CREATE_DATE          TIMESTAMP(6),
	   CREATE_USER_ID       VARCHAR2(30 char),
	   UPDATE_DATE          TIMESTAMP(6),
	   UPDATE_USER_ID       VARCHAR2(30 char),
	   CONSTRAINT PK_TRN_POSLOG_WORK_ITEM PRIMARY KEY (organization_id, rtl_loc_id, BUSINESS_DATE, WKSTN_ID, TRANS_SEQ, SERVICE_ID)
	   )'
	   ;
    END IF;
END;
/

PROMPT ORACLE_MAINT;

CREATE OR REPLACE PROCEDURE ORACLE_MAINT (ai_delay IN NUMBER := 3)
 IS
li_cnt	  int;
ld_start	  date;
ld_end	  date;
BEGIN
 ld_start := SYSDATE;

 SELECT COUNT(*) INTO li_cnt FROM RPL_REPLICATION_DATA WHERE UPPER(PUBLISH_STATUS)='COMPLETE' AND UPDATE_DATE < ld_start-ai_delay;

 DELETE FROM RPL_REPLICATION_DATA WHERE UPPER(PUBLISH_STATUS)='COMPLETE' AND UPDATE_DATE < ld_start-ai_delay;

 ld_end := SYSDATE;

 INSERT INTO rpl_cleanup_log (deleted_records,start_time,end_time,table_name) VALUES(li_cnt,ld_start,ld_end,'RPL_REPLICATION_DATA');

 ld_start := SYSDATE;

 SELECT COUNT(*) INTO li_cnt FROM trn_poslog_work_item WHERE UPPER(WORK_STATUS)='COMPLETE' AND UPDATE_DATE < ld_start-ai_delay;

 DELETE FROM trn_poslog_work_item WHERE UPPER(WORK_STATUS)='COMPLETE' AND UPDATE_DATE < ld_start-ai_delay;

 ld_end := SYSDATE;

 INSERT INTO rpl_cleanup_log (deleted_records,start_time,end_time,table_name) VALUES(li_cnt,ld_start,ld_end,'trn_poslog_work_item');
return;
END ORACLE_MAINT;
/

declare
    cnt number;
BEGIN 
   select count(*) into cnt from DBA_SCHEDULER_JOBS where job_name='MAINT_JOB' and owner='REPQUEUE';
    if cnt>0 then
     sys.dbms_scheduler.drop_job(job_name => 'MAINT_JOB'); 
    end if;
COMMIT;
END;
/

BEGIN
    sys.dbms_scheduler.create_job(
    job_name => 'MAINT_JOB',
    job_type => 'PLSQL_BLOCK',
    job_action => 'REPQUEUE.ORACLE_MAINT;',
    repeat_interval => 'FREQ=DAILY;INTERVAL = 1; BYHOUR=0',
    start_date => sysdate,
    enabled => true);
COMMIT;
END;
/


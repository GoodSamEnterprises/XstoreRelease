@echo off

set dbsqldir=resources/db/oracle
set NLS_LANG=.AL32UTF8

echo EXECUTE: db-drop.sql


echo EXECUTE: replication clean.sql
sqlplus "/ as sysdba" @%dbsqldir%/replication/clean.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: replication :: clean.sql
  exit 1
)

echo EXECUTE: clean_users_roles.sql
sqlplus "/ as sysdba" @%dbsqldir%/local/clean_users_roles.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: clean_users_roles.sql
  exit 1
)

echo EXECUTE: replication db-create.sql
sqlplus "/ as sysdba" @%dbsqldir%/replication/db-create.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE : replication :: db-create.sql
  exit 1
)

echo EXECUTE: xstore-replication-db-define.sql
sqlplus repqueue/repqueue @%dbsqldir%/replication/xstore-replication-db-define.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE : replication :: xstore-replication-db-define.sql
  exit 1
)


@echo off

set dbsqldir=resources/db/oracle
set NLS_LANG=.AL32UTF8

echo EXECUTE: clean.sql
sqlplus "/ as sysdba" @%dbsqldir%/local/clean.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: clean.sql
  exit 1
)

echo EXECUTE: replication clean.sql
sqlplus "/ as sysdba" @%dbsqldir%/replication/clean.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: replication :: clean.sql
  exit 1
)

echo EXECUTE: training clean.sql
sqlplus "/ as sysdba" @%dbsqldir%/training/clean.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: training :: clean.sql
  exit 1
)

echo EXECUTE: clean_users_roles.sql
sqlplus "/ as sysdba" @%dbsqldir%/local/clean_users_roles.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: clean_users_roles.sql
  exit 1
)

echo EXECUTE: db-create.sql
sqlplus "/ as sysdba" @%dbsqldir%/local/db-create.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: db-create.sql
  exit 1
)

echo EXECUTE: baseSchema.sql
sqlplus dtv/dtv @%dbsqldir%/local/baseSchema.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: baseSchema.sql
  exit 1
)

echo EXECUTE db-update.sql
sqlplus dtv/dtv @%dbsqldir%/local/db-update.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: db-update.sql
  exit 1
)

IF "%1" == "TEST" (
  echo EXECUTE: testData.sql
  sqlplus dtv/dtv @%dbsqldir%/local/testData.sql
  IF %ERRORLEVEL% NEQ 0 ( 
    echo :: FAILURE :: testData.sql
    exit 1
  )
) ELSE (
  echo Received an environment type of %1.  Test data will not be loaded.
)

echo EXECUTE: Synonyms.sql
sqlplus pos/pos @%dbsqldir%/local/Synonyms.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: Synonyms.sql
  exit 1
)

echo EXECUTE: DBAUserSynonyms.sql
sqlplus dbauser/dbauser @%dbsqldir%/local/DBAUserSynonyms.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: DBAUserSynonyms.sql
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






echo EXECUTE: training db-create.sql
sqlplus "/ as sysdba" @%dbsqldir%/training/db-create.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: training :: db-create.sql
  exit 1
)

echo EXECUTE: baseSchema.sql
sqlplus training/training @%dbsqldir%/training/baseSchema.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: training :: baseSchema.sql
  exit 1
)

echo EXECUTE db-update.sql
sqlplus training/training @%dbsqldir%/training/db-update.sql
IF %ERRORLEVEL% NEQ 0 ( 
  echo :: FAILURE :: training :: db-update.sql
  exit 1
)

IF "%1" == "TEST" (
  echo EXECUTE: testData.sql
  sqlplus training/training @%dbsqldir%/training/testData.sql
  IF %ERRORLEVEL% NEQ 0 ( 
    echo :: FAILURE :: training :: testData.sql
    exit 1
  )
) ELSE (
  echo Received an environment type of %1.  Test data will not be loaded.
)

@echo off
rem Download EFTL and EFTP files.

set EFTLVER=0000
set EFTLHEADER=
set EFTPVER=0004
set EFTPHEADER=
set COM=12
set BAUD=115200
set PARITY=N
set DATA=8
set BITS=1
set PRELOADTMO=0
goto CONTINUE1

:Err1
@echo ÿ
@echo  !!!!!!  --- please specify EFTL/EFTP revision level and baudrate ------ !!!!!!
@echo  e.g. 'EFTload 0260 0260'
@echo ÿ
goto end

:CONTINUE1

if NOT exist EFTP%EFTPVER% echo Error - missing EFTP%EFTPVER% file
if NOT exist EFTP%EFTPVER% goto end

:start
rem --------------------------------------------------------------------------
rem
rem
rem
rem
rem
rem --------------------------------------------------------------------------

@echo.

rem -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
rem /c<port number> COM port number (1-20), /b<baudrate> Baud rate (default=4800), /t<parity> Parity type ('N', 'E', or 'O') (default='N')
rem /d<data bits> Number of data bits (default=8), s<stop bits> Number of stop bits (default=2)
rem /i<irq number> IRQ number (default: see the COM port settings), /a<port address> COM port address (default: see the COM port settings) MUST be specified as a hexadecimal value (i.e. 3F8).
rem /RTO<seconds> Receive timeout in seconds. The amount of time the program will wait for a block request during program download (default=3 sec)
rem /TTO<seconds> Transmit timeout in seconds. The amount of time the program will wait for an ACK or NAK before retrying the packet (default=10 sec)
rem /PRTO<seconds> Last Parameter response timeout in seconds. The amount of time the program will wait for the online response message at the end of a parameter
rem -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@echo Eft download of EFTL%EFTLVER% and EFTP%EFTPVER% @ COM%COM% %BAUD% %PARITY% %DATA% %BITS%
ibmeftdl /l%EFTLVER%,EFTL%EFTLVER% /p%EFTPVER%,EFTP%EFTPVER% /c%COM% /b%BAUD% /d%DATA% /t%PARITY% /s%BITS% /ER
if errorlevel 2 goto cont3
if errorlevel 1 goto cont2

:cont1
@echo Complete
goto theEnd

:cont2
@echo No Need!
goto theEnd

:cont3
@echo error!
@echo.
@echo Error - loading component upgrades.
@echo.
pause
goto theEnd

:theEnd

:end
set EFTLVER=
set EFTLHEADER=
set EFTPVER=
set EFTPHEADER=
set BAUD=
set PARITY=
set DATA=
set BITS=
set PRELOADTMO=

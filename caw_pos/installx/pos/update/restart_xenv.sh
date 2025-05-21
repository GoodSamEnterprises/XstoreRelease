# 
#  CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
#  
#  Use and distribution of this code is subject to applicable 
#  licenses and the permission of the code owner.  This notice 
#  does not indicate the actual or intended publication of 
#  this source code.
#  
#  Portions developed for TNT Fireworks by BTM Global Consulting
#  LLC and are the property of TNT Fireworks.
#  
#  ===== BTM Modification ===========================================
#  Req/Bug ID#          ddMMyy    Description
#  BZ56866           	150623    Xymon [452027] pos646term6.freedomroads.local:disk CRITICAL (RED).
# == ================================================================
#
#!/bin/bash
XSTORE_FOLDER="/opt/xstore"
XENV_FOLDER="/opt/environment"
FILE_ANCHOR="*.anchor"

xenv-wait-delete-pid(){
    sleep 10
    xenv-check-file-delete
}

xenv-check-file-delete(){
    pid=$XENV_FOLDER/tmp/xenv_eng.pid
    if [ -f  "$pid" ] ; then
        xenv-wait-delete-pid
    fi
}

stop-xenv(){
    echo "--------------------------------------------------"
    echo "Stop Xenvironment"
    echo "--------------------------------------------------"
    
    rm -f $XENV_FOLDER/tmp/$FILE_ANCHOR
    xenv-check-file-delete
}

end-script(){
    cd $XENV_FOLDER
    bash start_eng.sh start
    sleep 60
    cd ..
	rm -f $XSTORE_FOLDER/restart_xenv.sh
    exit
}

end-script-without-start(){
    sleep 60
	rm -f $XSTORE_FOLDER/restart_xenv.sh
    exit
}

anchor=$XENV_FOLDER/tmp/xenv_eng.anchor
if [ -f "$anchor" ]; then
	echo "--------------------------------------------------"
	echo "Xenvironment is running!"
	echo "--------------------------------------------------"
	stop-xenv
    end-script
else 
    echo "--------------------------------------------------"
    echo "Xenvironment is not running!"
	echo $anchor
    echo "--------------------------------------------------"
	end-script
    ##end-script-without-start
fi

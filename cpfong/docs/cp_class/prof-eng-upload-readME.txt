Windows+R / cmd

server:	nyx.ifong.org 
port: 8080

connect-> ssh -p 8080 yourID@nyx.ifong.org
upload:-> scp -P 8080 file.zip yourID@nyx.ifong.org:~
#NOTE: scp with Capital p i.e. P

remove files at server-> rm -fr Dir_or_fileName
make a new_dir at server -> mkdir new_dir
check file at server -> ls file

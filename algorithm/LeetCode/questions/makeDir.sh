# move to current module and put cmd: 
# sh makeDir.sh
START=27
END=100
for i in $(seq $START $END);
do
    $(echo cp -r ./Q：/ ./Q"$i"：);
done
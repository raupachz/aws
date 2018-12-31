#!/usr/bin/env bash

# MacPorts doing not mine, change accordingly
AWS=aws-3.6

# Comment if you are not using profiles
export AWS_PROFILE=personal

for arg in $(seq 128 64 3008); do
    $AWS lambda update-function-configuration --function-name Prime --memory $arg
    $AWS lambda invoke --function-name Prime --payload 10000 --log-type Tail response.json
    result[0]=$arg
    for i in $(seq 1 10); do
        response=$($AWS lambda invoke --function-name Prime --payload 10000 --log-type Tail response.json)   
        log=$(echo $response | jq '.LogResult' | sed "s/\"//g" | base64 --decode)
        elapsed=$(echo $log | cut -d ' ' -f 13)
        result[$i]=$elapsed
    done
    echo ${result[*]}
    echo ${result[*]} >> data.txt
done

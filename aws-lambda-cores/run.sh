#!/usr/bin/env bash

for mem in $(seq 128 64 3008); do
    aws lambda update-function-configuration --function-name Cores --memory $mem > /dev/null 2>&1
    cores=$((aws lambda invoke --function-name Cores /dev/stderr > /dev/null) 2>&1)
    echo $mem $cores
done

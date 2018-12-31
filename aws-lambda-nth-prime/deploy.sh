# Don't forget to substitute your own IAM role. 

aws-3.6 lambda create-function \
    --function-name Prime \
    --runtime java8 \
    --role arn:aws:iam::XXXXXXXXXX:role/service-role/AWSLambdaBasicExecutionRole \
    --handler org.raupachz.Prime::nth \
    --zip-file fileb://target/aws-lambda-nth-prime-1.0.jar

#!/bin/bash

## Pause and wait for any key input to continue
pause () {
  echo
  read -n 1 -s -p "Press any key to continue..."
  echo
}
#GENERATE_START


# Create ResourceCar

echo "Create ResourceCar..."

response=$(curl -s -X POST \
  http://192.168.137.25:8443/api/sdk/ledger/invoke \
  --form tranCode=CreateResourceCar \
  --form userid=Org1Admin \
  --form orgid=Org1 \
  --form 'args[0].name=channelName' \
  --form 'args[0].value=mychannel' \
  --form 'args[1].name=chaincodeName' \
  --form 'args[1].value=example' \
  --form 'args[2].name=functionName' \
  --form 'args[2].value=Invoke' \
  --form 'args[3].name=hasFile' \
  --form 'args[3].value=false' \
  --form 'args[4].name=asyncInvoke:' \
  --form 'args[4].value=DISABLE' \
  --form 'data[0].content={"carDesc":null,"status":null,"carType":null,"plateNum":null,"carNo":null,"carId":null}' \
  --form 'data[0].dataType=ResourceCar' \
  --form 'data[0].formatType=JSONSTRING')

echo "Response message : "

pause

echo $response

echo "Create ResourceCar OK!"


# Update ResourceCar
echo "Update ResourceCar..."

response=$(curl -s -X POST \
  http://192.168.137.25:8443/api/sdk/ledger/invoke \
  --form tranCode=UpdateResourceCar \
  --form userid=Org1Admin \
  --form orgid=Org1 \
  --form 'args[0].name=channelName' \
  --form 'args[0].value=mychannel' \
  --form 'args[1].name=chaincodeName' \
  --form 'args[1].value=example' \
  --form 'args[2].name=functionName' \
  --form 'args[2].value=Invoke' \
  --form 'args[3].name=hasFile' \
  --form 'args[3].value=false' \
  --form 'args[4].name=asyncInvoke:' \
  --form 'args[4].value=DISABLE' \
  --form 'data[0].content={
                "carDesc":null,
                "status":null,
                "carType":null,
                "plateNum":null,
                "carNo":null,
                "carId":null}' \
  --form 'data[0].dataType=ResourceCar' \
  --form 'data[0].formatType=JSONSTRING')

echo "Response message : "

pause

echo $response

echo "Update ResourceCar OK!"


# Query ResourceCar
echo "Query ResourceCar..."

msg=$(cat ./query.json)

echo "Request message : "
 
pause

echo $msg

response=$(curl -s -X POST \
  http://192.168.137.25:8443/api/sdk/ledger/query \
  -H "content-type: application/json" \
  -d "$msg")

echo "Response message : "

pause

echo $response

echo "Query ResourceCar OK!"


# Delete ResourceCar
echo "Delete ResourceCar..."

response=$(curl -s -X POST \
  http://192.168.137.25:8443/api/sdk/ledger/invoke \
  --form tranCode=DelResourceCar \
  --form userid=Org1Admin \
  --form orgid=Org1 \
  --form 'args[0].name=channelName' \
  --form 'args[0].value=mychannel' \
  --form 'args[1].name=chaincodeName' \
  --form 'args[1].value=example' \
  --form 'args[2].name=functionName' \
  --form 'args[2].value=Invoke' \
  --form 'args[3].name=hasFile' \
  --form 'args[3].value=false' \
  --form 'args[4].name=asyncInvoke:' \
  --form 'args[4].value=DISABLE' \
  --form 'data[0].content={"id":""}' \
  --form 'data[0].dataType=ResourceCar' \
  --form 'data[0].formatType=JSONSTRING')

echo "Response message : "

pause

echo $response

echo "Delete ResourceCar OK!"


echo "Test finished!"

#GENERATE_END
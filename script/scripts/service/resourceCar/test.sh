#!/bin/bash

## Pause and wait for any key input to continue
pause () {
  echo
	read -n 1 -s -p "Press any key to continue..."
  echo
}
#GENERATE_START


# Create resourceCar
echo "Create resourceCar..."

msg=$(cat ./create.json)

echo "Request message : "

pause

echo $msg

response=$(curl -s -X POST \
  http://localhost:port/api/sdk/resource_car/ \
  -F "resMsg=$msg")

echo "Response message : "

pause

echo $response

echo "Create resourceCar OK!"

pause 


# Update resourceCar

echo "Update resourceCar..."

msg=$(cat ./update.json)

echo "Request message : "

pause

echo $msg

response=$(curl -s -X PUT \
  http://localhost:port/api/sdk/resource_car/ \
  -F "resMsg=$msg")

echo "Response message : "

pause

echo $response

echo "Update resourceCar OK!"

pause


# Query resourceCar

echo "Query resourceCar..."

msg=$(cat ./query.json)

echo "Request message : "

pause

echo $msg

response=$(curl -s -X POST \
  http://localhost:port/api/sdk/resource_car/getList \
  -F "resMsg=$msg")

echo "Response message : "

pause

echo $response

echo "Query resourceCar OK!"

pause


# Delete resourceCar

echo "Delete resourceCar..."

msg=$(cat ./delete.json)

echo $msg

echo "Request message : "

pause

response=$(curl -s -X DELETE \
  http://localhost:port/api/sdk/resource_car/ \
  -F "resMsg=$msg")

echo "Response message : "

pause

echo $response

echo "Delete resourceCar OK!"


echo "Test finished!"
#GENERATE_END
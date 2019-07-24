#!/bin/bash

## Pause and wait for any key input to continue
pause () {
  echo
	read -n 1 -s -p "Press any key to continue..."
  echo
}
#GENERATE_START


# Create resourceBox
echo "Create resourceBox..."

msg=$(cat ./create.json)

echo "Request message : "

pause

echo $msg

response=$(curl -s -X POST \
  http://localhost:port/api/sdk/resource_box/ \
  -F "resMsg=$msg")

echo "Response message : "

pause

echo $response

echo "Create resourceBox OK!"

pause 


# Update resourceBox

echo "Update resourceBox..."

msg=$(cat ./update.json)

echo "Request message : "

pause

echo $msg

response=$(curl -s -X PUT \
  http://localhost:port/api/sdk/resource_box/ \
  -F "resMsg=$msg")

echo "Response message : "

pause

echo $response

echo "Update resourceBox OK!"

pause


# Query resourceBox

echo "Query resourceBox..."

msg=$(cat ./query.json)

echo "Request message : "

pause

echo $msg

response=$(curl -s -X POST \
  http://localhost:port/api/sdk/resource_box/getList \
  -F "resMsg=$msg")

echo "Response message : "

pause

echo $response

echo "Query resourceBox OK!"

pause


# Delete resourceBox

echo "Delete resourceBox..."

msg=$(cat ./delete.json)

echo $msg

echo "Request message : "

pause

response=$(curl -s -X DELETE \
  http://localhost:port/api/sdk/resource_box/ \
  -F "resMsg=$msg")

echo "Response message : "

pause

echo $response

echo "Delete resourceBox OK!"


echo "Test finished!"
#GENERATE_END
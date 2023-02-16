# CreditCardApplication

## Curls :
##### For creating a limit offer :
```
curl --location 'localhost:8080/create_limit_offer' \
--header 'Content-Type: application/json' \
--data '{
    "limitValue" : 600,
    "accountId" : 352,
    "limitType" : "PER_TRANSACTION_LIMIT",
    "offerActivationTime" : "20-11-2023",
    "offerExpiryTime" : "20-12-2024"
}'
```
##### For listing all active limit offer :
```
curl --location --request GET 'localhost:8080/active_limit_offers' \
--form 'accountId="351"' \
--form 'activeDate="05-01-2024"'
```
##### For updating account details based on limit offer status:
```
curl --location --request PUT 'localhost:8080/update_limit_offer_status' \
--form 'limitOfferId="502"' \
--form 'status="REJECTED"'
```

##### For creating an Account:
```
curl --location 'localhost:8080/create_account' \
--header 'Content-Type: application/json' \
--data '{
    "customerId": 1,
    "accountLimit": 100,
    "perTransactionLimit": 400,
    "lastAccountLimit": 100,
    "lastPerTransactionLimit": 400,
    "accountLimitUpdateTime": "20-11-2022",
    "perTransactionLimitUpdateTime": "22-10-2022"
}'
```

##### Get Account Details:
```
curl --location 'localhost:8080/get_account/402'
```
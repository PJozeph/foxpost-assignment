# foxpost-assignment
After application initialization `schema.sql` and `data.sql` are executed. 
Foxpost-assignment is spring boot web-application that provides APIs where the client's data can retrieve data from H2 in-memory database.

List of APIs : 

**`http://localhost:8080/client/getAll`**
```
[
    {
        "id": 1,
        "clientName": "Nagy Eszter",
        "address": "Hegedüs Gyula utca 44",
        "zipCode": "1098",
        "city": "Budapest",
        "phone": "06301234567",
        "email": "eszti@gmail.com"
    },
    {
        "id": 2,
        "clientName": "Molnár Bianka",
        "address": "Mester utca 33",
        "zipCode": "1098",
        "city": "Budapest",
        "phone": "06301234567",
        "email": "bia@gmail.com"
    }
]
```
**`http://localhost:8080/client/getByEmail?email=<email>`**
```
{
    "id": 1,
    "clientName": "Nagy Eszter",
    "address": "Hegedüs Gyula utca 44",
    "zipCode": "1098",
    "city": "Budapest",
    "phone": "06301234567",
    "email": "eszti@gmail.com"
}
```
**`http://localhost:8080/client/getById?id=<clientId>`**
```
{
    "id": 1,
    "clientName": "Nagy Eszter",
    "address": "Hegedüs Gyula utca 44",
    "zipCode": "1098",
    "city": "Budapest",
    "phone": "06301234567",
    "email": "eszti@gmail.com"
}
```
**`http://localhost:8080/parcel/getBySender?email=<email>`**
```{
    "client": {
        "id": 1,
        "clientName": "Nagy Eszter",
        "address": "Hegedüs Gyula utca 44",
        "zipCode": "1098",
        "city": "Budapest",
        "phone": "06301234567",
        "email": "eszti@gmail.com"
    },
    "parcels": [
        {
            "id": 1,
            "senderId": 1,
            "reciverId": 2,
            "parcelNumber": "fp01"
        },
        {
            "id": 3,
            "senderId": 1,
            "reciverId": 4,
            "parcelNumber": "fp03"
        }
    ]
}
```
**`http://localhost:8080/parcel/getByReciver?email=<email>`**
```
{
    "client": {
        "id": 1,
        "clientName": "Nagy Eszter",
        "address": "Hegedüs Gyula utca 44",
        "zipCode": "1098",
        "city": "Budapest",
        "phone": "06301234567",
        "email": "eszti@gmail.com"
    },
    "parcels": []
}
```
**`http://localhost:8080/parcel/getCurrentEvent?parcelNumber=<parcelNumber>`**
```
{
    "event": {
        "id": 4,
        "eventName": "ARRIVED"
    }
}
```

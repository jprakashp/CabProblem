# CabProblem
system design

URI List with input Json data

Cab Controller
---------------
cab register: localhost:8080/register/cab

Json Input:
{
    "cabId":"6",
    "driverName":"pintu",
    "available":"true",
    "currentLocation":{
            "x":"1.0",
            "y":"10.0"
    }
}

cab location change: localhost:8080/location/cab/1

json input:
{
    "x":"2.0",
    "y":"6.0"
}

cab availablity change:localhost:8080/availability/cab/1

json input:
{
    "cabId":"1",
    "driverName":"jp",
    "available":"false"
}

Rider Controller
-----------------
register a driver: localhost:8080/register/rider

Json Input:
{
    "riderId":"1",
    "riderName":"devil"
}

Book a cab: localhost:8080/bookcab

Json Input:
{
    "riderId":"1",
    "sourceLoc":{
        "x":"2.0",
        "y":"3.0"
    },
    "destLoc": {
        "x":"3.0",
        "y":"4.0"
    }   
}

rider History: http://localhost:8080/book/1

end trip: http://localhost:8080/endtrip/cab/6

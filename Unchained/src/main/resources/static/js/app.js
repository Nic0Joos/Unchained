
WarehouseLocation = "Peter Merian-Strasse 86, 4052 Basel"
serviceEndpointURL = window.location.protocol + "//" + window.location.host
MapBoxToken = "pk.eyJ1Ijoibmljb2pvb3MiLCJhIjoiY2wyNWQ2YnIzMDhwODNrbnB4Mmo5Z2dldSJ9.RyWuwPKIlfp1Sr6Ftw-Pwg"


function register(name, street, ZIPCode, city, email, password, callbackSuccess, callbackError) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/user/register",
        data: JSON.stringfy({
            "name": name,
            "street": street,
            "city": city,
            "ZIPCode": ZIPCode,
            "TravelDistance": /*TODO: Retrieve distance between  Warehouse location and users adress via MapBox/TomTom/GoogleApi */,
            "email": email,
            "password": password
            "isAdmin": false
        }),
        success: function (data, textStatus, response) {
            callbackSuccess(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}

function login(email, password, remember, callback) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/login",
        data: JSON.stringify({
            "email": email,
            "password": password,
            "remember": false
        }),
        success: function (data, textStatus, response) {
            callback(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callback(false);
        }
    });
}

//TODO: Function to check if a user is an admin and then enable the admin pile in header (all sites)

//TODO: Function to make an ajax post method to the server for products

//TODO: Function to make an ajax post method to the server for orders

//TODO: Function to retrieve the shipping costs according to the costRequestService

//TODO: Function to get products from the server

//TODO: Function to put profile for user

//TODO: Function to get user profile
<!-- -->

serviceEndpointURL = window.location.protocol + "//" + window.location.host
MapBoxToken = "pk.eyJ1Ijoibmljb2pvb3MiLCJhIjoiY2wyNWQ2YnIzMDhwODNrbnB4Mmo5Z2dldSJ9.RyWuwPKIlfp1Sr6Ftw-Pwg"

function getTravelDistance(city, street, responseJSON) {
    $.ajax({

    })
}



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
            "TravelDistance": ,
            "ZIPCode": ZIPCode,
            "email": email,
            "password": password
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


serviceEndpointURL = window.location.protocol + "//" + window.location.host

//Copied from demo project Internet Technology
function getURLParameter(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [, ""])[1].replace(/\+/g, '%20')) || null;
}
//Copied from demo project Internet Technology
function getCookie(name) {
    var match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    if (match) return match[2];
}

//Author: Alex Herzog
function register(name, street, ZIPCode, city, email, password, callback, callbackError) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/register",
        data: JSON.stringify({
            "name": name,
            "street": street,
            "zipCode": ZIPCode,
            "city": city,
            "travelDistance": 0,
            "email": email,
            "isAnAdmin": false,
            "password": password
        }),
        success: function (data, textStatus, response) {
            callback(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}

//Author: Alex
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

//Copied from Internet Technology module
function validateLogin(callback) {
    $.ajax({
        type: "HEAD",
        url: serviceEndpointURL + "/validate",
        success: function (data, textStatus, response) {
            callback(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            callback(false);
        }
    });
}

//Author: Nico
function getCost(FinalPallets, callback){
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/costrequest",
        data: JSON.stringify({
            "pallets": FinalPallets
        }),
        success: function (data, textStatus, response) {
            callback(true, data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callback(false);
        }
    });

}

//Author: Luca
function postOrder(AmountProductA, AmountProductB, AmountProductC, AmountProductD, ShippingPrice, Totalprice, callbackSuccess) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/order",
        data: JSON.stringify({
            "amountA": AmountProductA,
            "amountB": AmountProductB,
            "amountC": AmountProductC,
            "amountD": AmountProductD,
            "shippingCost": ShippingPrice,
            "orderPrice": Totalprice
        }),
        success: function (data, textStatus, response) {
            callback(true, data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

//Author: Kaan
function getProducts(callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/api/product",
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

//Author: Alex
function getProfile(callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/profile",
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

//Author: Alex
function putProfile(street, ZIPCode, city, callbackSuccess, callbackError) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/profile",
        data: JSON.stringify({
            "street": street,
            "ZIPCode": ZIPCode,
            "city": city
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


 var map;
    var lat;
    var long;
    
    var LatitudeIPI =43.622593 ;
    var LongitudeIPI = 1.405476;

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
        } else {
            x.innerHTML = "Geolocation is not supported by this browser.";
        }
    }


    function showPosition(position) {
        lat = position.coords.latitude;
        long = position.coords.longitude;
        initialize();
    }

    var panel;
    var calculate;
    var direction;
    function initialize() {

        var address = document.getElementById('user_input_autocomplete_address').value;
        geocoder = new google.maps.Geocoder();

        var mapOptions = {
            zoom: 12,
            center: new google.maps.LatLng(lat, long)
        };
        map = new google.maps.Map(document.getElementById('map-canvas'),
                mapOptions);

        direction = new google.maps.DirectionsRenderer({
            map: map,
            panel: panel
        });

        if (!address || address === "") {

            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(lat, long),
                map: map
            });
            
            calculate();

        } else {
            geocoder.geocode({'address': address}, function (results, status) {
                if (status === 'OK') {
                    map.setCenter(results[0].geometry.location);
                    var marker = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });
                    calculate();
                } else {
                    alert('Geocode was not successful for the following reason: ' + status);
                }
            });

            marker.setMap(map);
        }
    }
    
   




    getLocation();
    google.maps.event.addDomListener(window, 'load', initialize);
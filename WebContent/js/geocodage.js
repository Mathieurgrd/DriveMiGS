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
    var direction;

    function mockCalculate() {

        var list = [
            {LatLongMock1: 43.61921604 + "," + 1.43120445},
            {LatLongMock2: 43.59492039 + "," + 1.41638961}
        ];


        for (var item in list) {


            origin = item; // Le point départ
            destination = LatitudeIPI + "," + LongitudeIPI; // Le point d'arrivé
            if (origin && destination) {
                var request = {
                    origin: origin,
                    destination: destination,
                    travelMode: google.maps.DirectionsTravelMode.DRIVING // Type de transport
                }
                var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinéraire
                directionsService.route(request, function (response, status) { // Envoie de la requête pour calculer le parcours
                    if (status == google.maps.DirectionsStatus.OK) {
                        direction.setDirections(response); // Trace l'itinéraire sur la carte et les différentes étapes du parcours
                    }
                });
            } //http://code.google.com/intl/fr-FR/apis/maps/documentation/javascript/reference.html#DirectionsRequest
        }
    }

    
    function calculate(origin) {
        origin = document.getElementById('user_input_autocomplete_address').value; // Le point départ
        destination = LatitudeIPI + "," + LongitudeIPI; // Le point d'arrivé
        if (origin && destination) {
            var request = {
                origin: origin,
                destination: destination,
                travelMode: google.maps.DirectionsTravelMode.DRIVING // Type de transport
            }
            var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinéraire
            directionsService.route(request, function (response, status) { // Envoie de la requête pour calculer le parcours
                if (status == google.maps.DirectionsStatus.OK) {
                    direction.setDirections(response); // Trace l'itinéraire sur la carte et les différentes étapes du parcours
                }
            });
        } //http://code.google.com/intl/fr-FR/apis/maps/documentation/javascript/reference.html#DirectionsRequest
    }
    ;

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

        	  calculate();
              mockCalculate();
              /**
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(lat, long),
                map: map
                
            });**/
            
            

        } else {
            geocoder.geocode({'address': address}, function (results, status) {
                if (status === 'OK') {
                    map.setCenter(results[0].geometry.location);
                    calculate();
                    mockCalculate();
                    /**
                    var marker = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });**/
                } else {
                    alert('Geocode was not successful for the following reason: ' + status);
                }
            });
            calculate();
            mockCalculate();

           // marker.setMap(map);
        }
    }
    
   




    getLocation();
    google.maps.event.addDomListener(window, 'load', initialize);

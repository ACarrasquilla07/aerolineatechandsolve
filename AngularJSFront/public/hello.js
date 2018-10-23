angular.module('demo', [])
.controller('Hello', function($scope, $http) {
	
    $http.get('http://localhost:8182/aerolinea/listavuelos').
        then(function(response) {
            $scope.listavuelos = response.data;
        });
		
	$scope.guardarVuelo = function(){			
		$http.post('http://localhost:8182/aerolinea/crear-vuelo', 
		{
			"codigoVuelo":"2",
			"origen":$scope.destinoText,
			"destino":$scope.origenText,
			"costo":2600000.0,
			"asientosDisponibles":300
		}).
		then(function(response) {
				$scope.vuelo = response.data;
			});
	}	
	$scope.consultarReservas = function(){			
		console.log("entro aqui");
		$http.get('http://localhost:8182/aerolinea/vuelos-reservados', {params: { idCliente: $scope.idUsuario }} ).
			then(function(response) {
				$scope.listareservas = response.data;
			});
	}
});

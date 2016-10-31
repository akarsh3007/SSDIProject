app.directive('pwCheck', [function() {
    return {
        require: 'ngModel',
        link: function (scope, elem, attrs, ctrl) {
            var p = "#" + attrs.pwCheck;
            $(elem).add(p).on('keyup', function() {
                scope.$apply(function () {
                    ctrl.$setValidity('pwmatch', elem.val() === $(p).val());
                });
            });
        }
    };
}]);

app.directive('numbersOnly', function(){
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, modelCtrl) {
            modelCtrl.$parsers.push(function (inputValue) {
                if (inputValue == undefined) return '' 
                var transformedInput = inputValue.replace(/[^0-9]/g, ''); 
                if (transformedInput!=inputValue) {
                    modelCtrl.$setViewValue(transformedInput);
                    modelCtrl.$render();
                }         

                return transformedInput;         
            });
        } 
    };
});

app.directive("limitTo", [function() {
    return {
        restrict: "A",
        link: function(scope, elem, attrs) {
            var limit = parseInt(attrs.limitTo);
            angular.element(elem).on("keypress", function(e) {
                if (this.value.length == limit) e.preventDefault();
            });
        }
    }
}]);
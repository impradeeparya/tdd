/**
 * Created by Pradeep Arya on 8/8/2015.
 */
angular.module('hr.ad.directives', []).directive('fileInput',
		[ '$parse', function($parse) {
			return {
				restrict : 'A',
				link : function(scope, element, attrs) {
					var model = $parse(attrs.fileInput);
					var modelSetter = model.assign;

					element.bind('change', function() {
						scope.$apply(function() {
							modelSetter(scope, element[0].files[0]);
						});
					});
				}
			};
		} ]);
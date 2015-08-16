/**
 * Created by Pradeep Arya on 8/4/2015.
 */

$(document).ready(function() {
	$(".btn-pref .btn ").click(function() {
		alert('clicked');
		$(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
		$(this).removeClass("btn-default").addClass("btn-primary");
	});
});

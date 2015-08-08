/**
 * Created by Pradeep Arya on 8/4/2015.
 */

$(document).ready(function() {
	$("#myAccount").click(function() {
		$('.dropdown-toggle').dropdown();
	});

	$(".btn-pre .btn").click(function() {
		alert('clicked');
//		$(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
//		$(".tab").addClass("active"); // instead of this do the below
//		$(this).removeClass("btn-default").addClass("btn-primary");
	});

});

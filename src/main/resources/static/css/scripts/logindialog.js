function overlay() {
	el = document.getElementById("overlay");
	el.style.visibility = (el.style.visibility == "visible") ? "hidden" : "visible";
}

function closefunction()
{
	swal({   title: "Close Dialog?",   text: "",   type: "warning",   showCancelButton: true,   confirmButtonColor: "#DD6B55",   confirmButtonText: "Yes, close it!",   closeOnConfirm: true },
		function(){
			//swal("Deleted!", "Your imaginary file has been deleted.", "success");
			var loading_dialog = $('#myModel');
			loading_dialog.modal('hide');
		});
}
//function closefunction()
//{
//	swal("Good job!", "You clicked the button!", "success")
//	var loading_dialog = $('#myModel');
//	loading_dialog.modal('hide');
//}

function submitFunction()
{
	swal({   title: "Request Quotation",   text: "",   type: "info",   showCancelButton: true,   closeOnConfirm: false,   showLoaderOnConfirm: true, }, function(){   setTimeout(function(){     swal("Quotation requested!");   }, 2000); });

}


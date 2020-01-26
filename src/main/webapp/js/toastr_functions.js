//toastr["info"](" ", "تم الحفظ بنجاح");

toastr.options = {
    "closeButton": true,
    "debug": false,
    "newestOnTop": true,
    "progressBar": true,
    "positionClass": "toast-bottom-left",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}
var info = function (title, message) {
    toastr["info"](message, title);
}
var success = function (title, message) {
    toastr["success"](message, title);
}
var warning = function (title, message) {
    toastr["warning"](message, title);
}
var error = function (title, message) {
    toastr["error"](message, title);
}
var changePassword = function () {

    if ($(".needs-validation")[0].checkValidity() === true && $("#new_password").val() === $("#re_new_password").val()) {
        $.ajax({
            url: "Controller",
            data: {
                n: "3",
                user_id:"1",
                current_password: $("#current_password").val(),
                new_password: $("#new_password").val(),
                re_new_password: $("#re_new_password").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    success("Password has been changed", "");

                    $("#change_password_form").trigger("reset");
                    $("#current_password").removeClass("is-invalid");
                    $("#new_password").removeClass("is-invalid");
                    $("#re_new_password").removeClass("is-invalid");
                    $("#current_password").removeClass("is-valid");
                    $("#new_password").removeClass("is-valid");
                    $("#re_new_password").removeClass("is-valid");
                } else if (result == 0) {
                    error("Password hasn't been changed", "Current Password is incorrect");
                    $("#current_password").addClass("is-invalid");
                    $("#new_password").removeClass("is-invalid");
                    $("#re_new_password").removeClass("is-invalid");
                    $("#current_password").removeClass("is-valid");
                    $("#new_password").addClass("is-valid");
                    $("#re_new_password").addClass("is-valid");
                }
                $(".needs-validation").removeClass("was-validated");

            }
        });
        $(".needs-validation").addClass("was-validated");
    }else{
        if($("#new_password").val() !== $("#re_new_password").val()){
            error("Password hasn't been changed","New Password not matching");
            $("#current_password").removeClass("is-invalid");
            $("#new_password").addClass("is-invalid");
            $("#re_new_password").addClass("is-invalid");
            $("#current_password").addClass("is-valid");
            $("#new_password").removeClass("is-valid");
            $("#re_new_password").removeClass("is-valid");
        }
    }


}
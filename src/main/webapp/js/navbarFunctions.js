function logout() {
    $("#logout_btn").click(function () {
        bootbox.confirm({
            title: "Log out",
            message: "Are you sure you want to sign out?",
            closeButton: false,
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> Cancel',
                    className: 'btn-danger'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Confirm',
                    className: 'btn-success'
                }
            },
            callback: function (result) {
                if (result) {
                    $("#logout_form").submit();
                }
            }
        });
    });
}

function resetPassword(user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "43",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            if (result == 0) {

                success("User password has been reset", "");
            }
        }
    });
}

function resetPasswordDialog(user) {
    bootbox.confirm({
        title: "Reset Password",
        message: "Are you sure you want to reset the password?",
        closeButton: false,
        buttons: {
            cancel: {
                label: '<i class="fa fa-times"></i> Cancel',
                className: 'btn-danger'
            },
            confirm: {
                label: '<i class="fa fa-check"></i> Confirm',
                className: 'btn-success'
            }
        },
        callback: function (result) {
            if (result) {
                resetPassword(user);
            }
        }
    });
}

function suspenseAccount(user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "47",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            if (result == 0) {

                success("User has been suspended", "");
            }
        }
    });
}
function suspenseAccountDialog(user) {
    bootbox.confirm({
        title: "Suspense User",
        message: "Are you sure you want to suspense this user?",
        closeButton: false,
        buttons: {
            cancel: {
                label: '<i class="fa fa-times"></i> Cancel',
                className: 'btn-danger'
            },
            confirm: {
                label: '<i class="fa fa-check"></i> Confirm',
                className: 'btn-success'
            }
        },
        callback: function (result) {
            if (result) {
                suspenseAccount(user);
            }
        }
    });
}
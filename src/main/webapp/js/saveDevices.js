var savePC = function () {
    $("#pc_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[9].checkValidity() === true) {
            var need_to_upgrade, internet;
            if ($("#need_to_upgrade").is(":checked")) {
                need_to_upgrade = true;
            } else {
                need_to_upgrade = false;
            }
            if ($("#internet").is(":checked")) {
                internet = true;
            } else {
                internet = false;
            }
            $.ajax({
                url: "Controller",
                data: {
                    n: "17",
                    device_id: $("#device_id").val(),
                    device: $("#device").val(),
                    vendor: $("#vendor").val(),
                    model: $("#model").val(),
                    mac_address: $("#mac_address").val(),
                    ip_address: $("#ip_address").val(),
                    serial_num: $("#serial_num").val(),
                    purchase_date: $("#purchase_date").val(),
                    office: $("#office").val(),
                    location: form.find("#location_").val(),
                    department: form.find("#department_").val(),
                    device_type: form.find("#device_type_").val(),
                    pc_type: $("#pc_type").val(),
                    employee: form.find("#employee_").val(),
                    os: form.find("#os_").val(),
                    login_name: $("#login_name").val(),
                    computer_name: $("#computer_name").val(),
                    HD: $("#HD").val(),
                    ram: $("#ram").val(),
                    cpu: $("#cpu").val(),
                    monitor: $("#monitor").val(),
                    monitor_serial: $("#monitor_serial").val(),
                    internet: internet,
                    need_to_upgrade: need_to_upgrade
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {

                        success("PC has been saved", "");
                        $("#device_modal_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else {
                        success("PC has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });

}

var savePrinter = function () {
    $("#printer_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[9].checkValidity() === true) {
            var need_to_upgrade;
            if ($("#need_to_upgrade").is(":checked")) {
                need_to_upgrade = true;
            } else {
                need_to_upgrade = false;
            }

            $.ajax({
                url: "Controller",
                data: {
                    n: "18",
                    device_id: $("#device_id").val(),
                    device: $("#device").val(),
                    vendor: $("#vendor").val(),
                    model: $("#model").val(),
                    mac_address: $("#mac_address").val(),
                    ip_address: $("#ip_address").val(),
                    serial_num: $("#serial_num").val(),
                    purchase_date: $("#purchase_date").val(),
                    office: $("#office").val(),
                    location: form.find("#location_").val(),
                    department: form.find("#department_").val(),
                    device_type:form.find("#device_type_").val(),
                    printer_connection: $("#connection").val(),
                    toner_num: $("#toner_num").val(),
                    employee: form.find("#employee_").val(),
                    need_to_upgrade: need_to_upgrade
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {

                        success("Printer has been saved", "");
                        $("#device_modal_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else {
                        success("Printer has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}

var saveAttendance = function () {
    $("#att_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[9].checkValidity() === true) {
            var need_to_upgrade;
            if ($("#need_to_upgrade").is(":checked")) {
                need_to_upgrade = true;
            } else {
                need_to_upgrade = false;
            }

            $.ajax({
                url: "Controller",
                data: {
                    n: "19",
                    device_id: $("#device_id").val(),
                    device: $("#device").val(),
                    vendor: $("#vendor").val(),
                    model: $("#model").val(),
                    mac_address: $("#mac_address").val(),
                    ip_address: $("#ip_address").val(),
                    serial_num: $("#serial_num").val(),
                    purchase_date: $("#purchase_date").val(),
                    office: $("#office").val(),
                    location: form.find("#location_").val(),
                    department: form.find("#department_").val(),
                    device_type: form.find("#device_type_").val(),
                    subnet: $("#subnet").val(),
                    gateway: $("#gateway").val(),
                    need_to_upgrade: need_to_upgrade
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {
                        success("Finger Print has been saved", "");
                        $("#device_modal_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else {
                        success("Finger Print has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}
var savePBX = function () {
    $("#pbx_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[9].checkValidity() === true) {
            var need_to_upgrade;
            if ($("#need_to_upgrade").is(":checked")) {
                need_to_upgrade = true;
            } else {
                need_to_upgrade = false;
            }

            $.ajax({
                url: "Controller",
                data: {
                    n: "20",
                    device_id: $("#device_id").val(),
                    device: $("#device").val(),
                    vendor: $("#vendor").val(),
                    model: $("#model").val(),
                    mac_address: $("#mac_address").val(),
                    ip_address: $("#ip_address").val(),
                    serial_num: $("#serial_num").val(),
                    purchase_date: $("#purchase_date").val(),
                    office: $("#office").val(),
                    location: form.find("#location_").val(),
                    department: form.find("#department_").val(),
                    device_type: form.find("#device_type_").val(),
                    device_num: $("#device_num").val(),
                    employee: form.find("#employee_").val(),
                    need_to_upgrade: need_to_upgrade
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {
                        success("IP Phone has been saved", "");
                        $("#device_modal_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else {
                        success("IP Phone has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}
var saveMobile = function () {
    $("#mobile_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[9].checkValidity() === true) {
            var need_to_upgrade;
            if ($("#need_to_upgrade").is(":checked")) {
                need_to_upgrade = true;
            } else {
                need_to_upgrade = false;
            }

            $.ajax({
                url: "Controller",
                data: {
                    n: "46",
                    device_id: $("#device_id").val(),
                    device: $("#device").val(),
                    vendor: $("#vendor").val(),
                    model: $("#model").val(),
                    mac_address: $("#mac_address").val(),
                    ip_address: $("#ip_address").val(),
                    serial_num: $("#serial_num").val(),
                    purchase_date: $("#purchase_date").val(),
                    office: $("#office").val(),
                    location: form.find("#location_").val(),
                    department: form.find("#department_").val(),
                    device_type: form.find("#device_type_").val(),
                    device_num: $("#device_num").val(),
                    employee: form.find("#employee_").val(),
                    need_to_upgrade: need_to_upgrade
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {
                        success("Mobile has been saved", "");
                        $("#device_modal_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else {
                        success("Mobile has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}
var saveDevice = function () {
    $("#device_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[9].checkValidity() === true) {
            var need_to_upgrade;
            if ($("#need_to_upgrade").is(":checked")) {
                need_to_upgrade = true;
            } else {
                need_to_upgrade = false;
            }

            $.ajax({
                url: "Controller",
                data: {
                    n: "21",
                    device_id: $("#device_id").val(),
                    device: $("#device").val(),
                    vendor: $("#vendor").val(),
                    model: $("#model").val(),
                    mac_address: $("#mac_address").val(),
                    ip_address: $("#ip_address").val(),
                    serial_num: $("#serial_num").val(),
                    purchase_date: $("#purchase_date").val(),
                    office: $("#office").val(),
                    location: form.find("#location_").val(),
                    department: form.find("#department_").val(),
                    device_type: form.find("#device_type_").val(),
                    need_to_upgrade: need_to_upgrade
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {

                        success("Device has been saved", "");
                        $("#device_modal_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else {
                        success("Device has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}

var saveVideoRecorder = function () {
    $("#vr_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[9].checkValidity() === true) {

            var need_to_upgrade;
            if ($("#need_to_upgrade").is(":checked")) {
                need_to_upgrade = true;
            } else {
                need_to_upgrade = false;
            }

            $.ajax({
                url: "Controller",
                data: {
                    n: "22",
                    device_id: $("#device_id").val(),
                    device: $("#device").val(),
                    vendor: $("#vendor").val(),
                    model: $("#model").val(),
                    mac_address: $("#mac_address").val(),
                    ip_address: $("#ip_address").val(),
                    serial_num: $("#serial_num").val(),
                    purchase_date: $("#purchase_date").val(),
                    office: $("#office").val(),
                    location: form.find("#location_").val(),
                    department: form.find("#department_").val(),
                    device_type: form.find("#device_type_").val(),
                    port_num: $("#port_num").val(),
                    need_to_upgrade: need_to_upgrade
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {

                        success("Device has been saved", "");
                        $("#device_modal_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else {
                        success("Device has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}
var updateDevices = function (device_type) {
    if (device_type == 1) {
        savePC();
    } else if (device_type == 2) {
        savePrinter();
    } else if (device_type == 9) {
        saveAttendance();
    } else if (device_type == 8 || device_type == 13) {
        savePBX();
    } else if (device_type == 4 || device_type == 5 || device_type == 6 || device_type == 10 || device_type == 11 || device_type == 12 || device_type == 14 || device_type == 15) {
        saveDevice();
    } else if (device_type == 3 || device_type == 7) {
        saveVideoRecorder();
    }
}
var clearField = function (field_id) {
    $("#" + field_id).val('');
}
var resetForm = function (form_id) {
    $("#" + form_id).trigger("reset");
}
var saveLocation = function () {
    if ($(".needs-validation")[1].checkValidity() === true) {
        $.ajax({
            url: "Controller",
            data: {
                n: "4",
                added_location: $("#location").val(),
                location_abb: $("#location_abb").val(),
                region: $("#select_region_").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    $(".needs-validation").removeClass("was-validated");
                    success("Location has been added", "");
                    $(".location_").load('Directive', {d: 4, region: $("#region_").val()});
                    $("#select_location_").load('Directive', {d: 4});
                    $("#location_modal_form").trigger("reset");
                } else if (result == 0) {
                    error("Location hasn't been added", "You not belong to this region only can't add location to this region");
                }


            }
        });

    }
    $(".needs-validation").addClass("was-validated");
}


var saveDepartment = function () {
    if ($(".needs-validation")[2].checkValidity() === true) {
        $.ajax({
            url: "Controller",
            data: {
                n: "5",
                added_department: $("#department_select").val(),
                select_location: $("#department_select").parent().parent().parent().find("#location_").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    $(".needs-validation").removeClass("was-validated");
                    success("Department has been added", "");
                    $(".department_").load('Directive', {d: 5, location: $("#location_").val()});
                    //$("#select_location_").load('Directive', {d: 4});
                    $("#department_modal_form").trigger("reset");
                } else if (result == 0) {
                    error("Department hasn't been added", "This department is already on this Location")
                }
            }
        });

    }
    $(".needs-validation").addClass("was-validated");
}

var saveDeviceType = function () {
    if ($(".needs-validation")[3].checkValidity() === true) {
        $.ajax({
            url: "Controller",
            data: {
                n: "6",
                added_device_type: $("#device_type").val(),
                device_type_abb: $("#device_type_abb").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    $(".needs-validation").removeClass("was-validated");
                    success("Device Type has been added", "");
                    $(".device_type_").load('Directive', {d: 8});
                    //$("#select_location_").load('Directive', {d: 4});
                    $("#device_type_modal_form").trigger("reset");
                }
            }
        });

    }
    $(".needs-validation").addClass("was-validated");
}


var saveCategory = function () {
    if ($(".needs-validation")[4].checkValidity() === true) {

        $.ajax({
            url: "Controller",
            data: {
                n: "8",
                added_category: $("#category").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    $(".needs-validation").removeClass("was-validated");
                    success("Category has been added", "");
                    $("#category_").load('Directive', {d: 11});
                    $("#select_category_").load('Directive', {d: 11});
                    $("#category_modal_form").trigger("reset");
                }
            }
        });

    }
    $(".needs-validation").addClass("was-validated");
}

var saveSubCategory = function () {
    if ($(".needs-validation")[5].checkValidity() === true) {

        $.ajax({
            url: "Controller",
            data: {
                n: "9",
                added_sub_category: $("#sub_category").val(),
                category: $("#select_category_").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    $(".needs-validation").removeClass("was-validated");
                    success("Sub-Category has been added", "");
                    $("#sub_category_").load('Directive', {d: 13, category: $("#category_").val()});
                    //$("#select_category_").load('Directive', {d: 11});
                    $("#sub_category_modal_form").trigger("reset");
                }
            }
        });

    }
    $(".needs-validation").addClass("was-validated");
}
var saveRegion = function () {
    if ($(".needs-validation")[6].checkValidity() === true) {
        $.ajax({
            url: "Controller",
            data: {
                n: "23",
                added_region: $("#region").val(),
                region_abb: $("#region_abb").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    $(".needs-validation").removeClass("was-validated");
                    success("Region has been added", "");
                    $(".region_").load('Directive', {d: 37});
                    $("#select_region_").load('Directive', {d: 37});
                    $("#region_modal_form").trigger("reset");
                }


            }
        });

    }
    $(".needs-validation").addClass("was-validated");
}

var saveEmployee = function () {
    if ($(".needs-validation")[7].checkValidity() === true) {
        var department = $("#device_modal_form").find(".department_").val();
        var location = $("#device_modal_form").find(".location_").val();
        $.ajax({
            url: "Controller",
            data: {
                n: "24",
                name: $("#name").val(),
                position: $("#position").val(),
                staff_id: $("#staff_id").val(),
                location: $("#staff_id").parent().parent().find(".location_").val(),
                department: $("#staff_id").parent().parent().find(".department_").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    $(".needs-validation").removeClass("was-validated");
                    success("Employee has been added", "");
                    $(".employee_").load('Directive', {d: 35, department: department, location: location});
                    //$("#select_region_").load('Directive', {d: 37});
                    $("#employee_modal_form").trigger("reset");
                }


            }
        });

    }
    $(".needs-validation").addClass("was-validated");
}

var saveOS = function () {
    if ($(".needs-validation")[8].checkValidity() === true) {
        $.ajax({
            url: "Controller",
            data: {
                n: "28",
                added_os: $("#added_os").val()
            },
            type: "POST",

            success: function (result, status, xhr) {
                if (result == 1) {
                    $(".needs-validation").removeClass("was-validated");
                    success("Operating System    has been added", "");
                    $("#os_").load('Directive', {d: 42});
                    //$("#select_location_").load('Directive', {d: 4});
                    $("#os_modal_form").trigger("reset");
                }
            }
        });

    }
    $(".needs-validation").addClass("was-validated");
}
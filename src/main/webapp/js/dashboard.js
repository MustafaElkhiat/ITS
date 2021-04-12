var documentTitle = "ITS - ";
$(document).ready(function () {
    logout();
    $("#dashboard").click(function () {
        document.title = documentTitle + "Dashboard";
        stopTimers();
        $("#content_place").load('Directive', {d: 43});
    });
    $("#new_ticket").click(function () {
        document.title = documentTitle + "New Ticket";
        stopTimers();
        $("#content_place").load('Directive', {d: 1}, function () {
            afterLoadingRegionSection();
            $("#device").change(function () {
                $("#device_info").load('Directive', {d: 7, device: $(this).val()}, function () {
                    $("#problem_section").removeClass('sr-only');
                    $("#new_ticket_employee_submit").click(function () {
                        if ($(".needs-validation")[1].checkValidity() === true) {

                            $.ajax({
                                url: "Controller",
                                data: {
                                    n: "48",
                                    problem: $("#problem").val(),
                                    device: $("#device").val(),
                                },
                                type: "POST",

                                success: function (result, status, xhr) {
                                    if (result > 0) {
                                        $(".needs-validation").removeClass("was-validated");
                                        success("Ticket has been added", "");
                                        $("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                                    }
                                }
                            });

                        }
                        $(".needs-validation").addClass("was-validated");
                    });
                });
            });

        });
    });
    $("#my_ticket").click(function () {
        document.title = documentTitle + "My Tickets";
        stopTimers();
        var user = $("#current_user").val();
        $("#content_place").load('Directive', {d: 69}, function () {
                $("#search_REF").searchTable("table_REF");
                $("#mytable_REF").sortTableNow();
            }
        )
    });
    $("#devices").click(function () {
        document.title = documentTitle + "Devices";
        stopTimers();
        $("#content_place").load('Directive', {d: 28}, function () {
            deviceTabsSearchSorting();
            viewDevice();
            /*$(".fa-print").click(function () {
                $(this).parent().parent().find('table').printThis({
                    importCSS: true,
                    base: true
                });
            });*/
            $(".fa-print").click(function () {
                printJS({
                    printable: $(this).parent().parent().find('table').attr("id"),
                    type: 'html',
                    css: 'css/all.min.css',
                    targetStyles: ['*']
                });
            });
            $("#add_device").click(add_device);
        });
    });
    $("#users").click(function () {
        document.title = documentTitle + "Users";
        stopTimers();
        $("#content_place").load('Directive', {d: 40}, function () {
            $("#search_user").searchTable("user_table_body");
            $("#user_table").sortTableNow();
            if ($(".context-menu-one").hasClass("edit_user") && $(".context-menu-one").hasClass("reset_pass")) {
                $(function () {
                    $('#user_table_body').contextMenu({
                        selector: '.context-menu-one',
                        trigger: 'left',
                        callback: function (key, options) {
                            var user = $(this).attr("user-id");
                            if (key == "edit") {
                                $("#content_place").load('Directive', {d: 41, user: $(this).attr("user-id")}, editUser);
                            } else if (key == "reset") {
                                resetPasswordDialog(user);
                            } else if (key == "suspense") {
                                suspenseAccountDialog(user);
                            }
                        },
                        items: {
                            "edit": {name: "Edit User Data"},
                            "reset": {name: "Reset Password"},
                            "suspense": {name: "Suspense / Unsuspense Account"}

                        }
                    });
                });
            } else {
                $(".edit_user").click(function () {
                    $("#content_place").load('Directive', {d: 41, user: $(this).attr("user-id")}, editUser);
                });
                $(".reset_pass").click(function () {
                    resetPasswordDialog($(this).attr("user-id"));
                });
            }

            $("#add_user").click(function () {
                $("#content_place").load('Directive', {d: 38}, addUser);
            });
        });
    });

    $("#employees").click(function () {
        document.title = documentTitle + "Employees";
        stopTimers();
        $("#content_place").load('Directive', {d: 46}, function () {
            $("#search_employee").searchTable("employee_table_body");
            $("#employee_table").sortTableNow();
            $(function () {
                $('#employee_table_body').contextMenu({
                    selector: '.context-menu-one',
                    trigger: 'left',
                    callback: function (key, options) {
                        var employee = $(this).attr("employee-code");
                        if (key == "create_user") {

                            $("#employees").removeClass("active");
                            $.ajax({
                                url: "Controller",
                                data: {
                                    n: "25",
                                    employee_code: employee
                                },
                                type: "POST",

                                success: function (result, status, xhr) {
                                    if (result > 0) {

                                        success("User has been added", "");
                                    } else if (result == -1) {
                                        error("User hasn't been added", "The username is not available");
                                    } else if (result == -2) {
                                        error("User hasn't been added", "The phone number is used for another user");
                                    } else if (result == -3) {
                                        error("User hasn't been added", "The username is not available and phone number is used for another user");
                                    }
                                }
                            });
                            /*$("#content_place").load('Controller', {
                                n: 25,
                                employee_code: employee
                            }, function () {
                                document.title = documentTitle + "Add User";
                                checkbox_accessories();
                                checkbox_accounts();
                                editEmployee();
                                afterLoadingRegionSection();
                            });*/

                        }
                    },
                    items: {
                        "create_user": {name: "Create Employee User"},

                    }
                });
            });
            /*$("#add_employee").click(function () {
                $("#content_place").load('Directive', {d: 67}, function () {
                    document.title = documentTitle + "Add Employee";
                    $("#location_section,#department_section").empty();
                    checkbox_accessories();
                    checkbox_accounts();
                    editEmployee();
                    afterLoadingRegionSection();
                });
            });*/
            /*if ($(".context-menu-one").hasClass("edit_employee") && $(".context-menu-one").hasClass("release_employee")) {
                $(function () {
                    $('#employee_table_body').contextMenu({
                        selector: '.context-menu-one',
                        trigger: 'left',
                        callback: function (key, options) {
                            var employee = $(this).attr("employee-id");
                            if (key == "edit") {

                                $("#employees").removeClass("active");
                                $("#content_place").load('Directive', {
                                    d: 47,
                                    employee: $(this).attr("employee-id")
                                }, function () {
                                    document.title = documentTitle + "Edit Employee";
                                    checkbox_accessories();
                                    checkbox_accounts();
                                    editEmployee();
                                    afterLoadingRegionSection();
                                });

                            } else if (key == "release") {
                                release_employee($(this).attr("employee-id"));
                            }
                        },
                        items: {
                            "edit": {name: "Edit Employee Data"},
                            "release": {name: "Release Employee"},

                        }
                    });
                });
            } else {
                $(".edit_employee").click(function () {
                    document.title = documentTitle + "Edit Employee";
                    $("#employees").removeClass("active");
                    $("#content_place").load('Directive', {d: 47, employee: $(this).attr("employee-id")}, function () {
                        checkbox_accessories();
                        checkbox_accounts();

                        editEmployee();
                        afterLoadingRegionSection();
                    });
                });
                $(".release_employee").click(function () {
                    release_employee($(this).attr("employee-id"));
                });
            }*/

        });
    });

    var release_employee = function (employee) {
        document.title = documentTitle + "Release Employee";
        $("#content_place").load('Directive', {
            d: 64,
            employee: employee
        }, function () {
            $(".card").hover(function () {
                $(".fa-print").parent().removeClass("d-none");

            }, function () {
                $(".fa-print").parent().addClass("d-none");
            });
            print_card();

        });
    }
    var print_card = function () {
        $(".fa-print").click(function () {
            $.print($(this).parent().parent().parent().parent().parent());
        });
    }
    $("#Privileges").click(function () {
        document.title = documentTitle + "Privileges";
        stopTimers();
        $("#content_place").load('Directive', {d: 48}, function () {
            $("#search_privilege").searchTable("privilege_table_body");
            $("#privilege_table").sortTableNow();
            $(".edit_privilege").click(function () {
                $("#content_place").load('Directive', {d: 50, privilege: $(this).attr("privilege-id")}, edit_privilege);
            });
            $("#add_privilege").click(function () {
                $("#Privileges").removeClass("active");
                $("#content_place").load('Directive', {d: 49}, add_privilege);
            });
        });
    });
    $("#accessories").click(function () {
        document.title = documentTitle + "Accessories";
        stopTimers();
        $("#content_place").load('Directive', {d: 59}, function () {
            $("#search_accessory").searchTable("accessory_table_body");
            $("#accessory_table").sortTableNow();
            /*$(".edit_privilege").click(function () {
                $("#content_place").load('Directive', {d: 50, privilege: $(this).attr("privilege-id")}, edit_privilege);
            });*/
            $("#add_accessory").click(function () {
                $("#accessories").removeClass("active");
                $("#content_place").load('Directive', {d: 60}, add_accessory);
            });
        });
    });
    $("#accounts").click(function () {
        document.title = documentTitle + "Accounts";
        stopTimers();
        $("#content_place").load('Directive', {d: 61}, function () {
            $("#search_account").searchTable("account_table_body");
            $("#account_table").sortTableNow();
            /*$(".edit_privilege").click(function () {
                $("#content_place").load('Directive', {d: 50, privilege: $(this).attr("privilege-id")}, edit_privilege);
            });*/
            $("#add_account").click(function () {
                $("#accounts").removeClass("active");
                $("#content_place").load('Directive', {d: 62}, add_account);
            });
        });
    });
    $("#recoding_devices").click(function () {
        //stopTimers();
        bootbox.confirm({
            title: "Recoding Devices",
            message: "Are you sure you want to recode devices?",
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
                    info("Device recoding is started", "");
                    $.ajax({
                        url: "Controller",
                        data: {
                            n: "42"

                        },
                        type: "POST",

                        success: function (result, status, xhr) {
                            if (result == 0) {
                                success("Devices had been recoded", "");

                            }
                        }
                    });
                }
            }
        });

    });
    $("#weekly").click(function () {
        document.title = documentTitle + "Weekly Report";
        stopTimers();
        $("#content_place").load('Directive', {d: 66}, function () {

            $('#actual_date').datepicker({
                onSelect: function (formattedDate, date, inst) {

                    if (formattedDate.search("--") > 0) {
                        $("#preview").load("preloader.jsp");
                        var firstDate = formattedDate.slice(0, formattedDate.search("--"));
                        var secondDate = formattedDate.slice(formattedDate.search("--") + 2, formattedDate.length);
                        $("#preview").load("Directive", {
                            d: 65,
                            firstDate: firstDate,
                            secondDate: secondDate
                        }, function () {
                            $(".card").hover(function () {
                                $(this).find(".fa-print").parent().removeClass("d-none");

                            }, function () {
                                $(this).find(".fa-print").parent().addClass("d-none");
                            });
                            $(".fa-print").click(function () {
                                $.print($(this).parent().parent().parent().parent().parent());
                            });

                        });
                    }
                }
            });

            $("#actual_date").click(function () {
                $("#actual_date").val("");
            });
        });
    });
    $("#opened_tickets").click(function () {
        document.title = documentTitle + "Opened Ticket";
        stopTimers();
        $("#content_place").load('Directive', {d: 68}, function () {
            $("#search_opened").searchTable("opened_table_body");
            $("#opened_table").sortTableNow();
            ticket_edit();
        });
    });
    $("#employee_ticket").click(function () {
        $("#content_place").load('Directive', {d: 70},);
    })
    $("#fab_btn").click(function () {
        if ($("#sidebar_menu").hasClass("d-block")) {
            $("#sidebar_menu").removeClass("d-block");
            $("#content_place").parent().removeClass("col-10");
            $("#content_place").parent().addClass("col-12");
            $(this).attr("title", "Show Menu");
        } else {
            $("#sidebar_menu").addClass("d-block");
            $("#content_place").parent().addClass("col-10");
            $("#content_place").parent().removeClass("col-12");
            $(this).attr("title", "Hide Menu");
        }
    });
    setupTimers();

});

var checkbox_accessories = function () {
    $('.accessory_checkbox').click(function () {
        if ($(this).is(":checked")) {
            $(this).parent().parent().parent().parent().parent().find(".vendor_col").removeClass("d-none");
            $(this).parent().parent().parent().parent().parent().find(".vendor").attr("required");
            if ($(this).val() == 1 || $(this).val() == 2) {
                $(this).parent().parent().parent().parent().parent().find(".phone_col").removeClass("d-none");
                $(this).parent().parent().parent().parent().parent().find(".phone_num").attr("required");
            } else if ($(this).val() == 3 || $(this).val() == 4) {
                $(this).parent().parent().parent().parent().parent().find(".serial_col").removeClass("d-none");
                $(this).parent().parent().parent().parent().parent().find(".serial_num").attr("required");
            }

        } else {
            $(this).parent().parent().parent().parent().parent().find(".vendor_col").addClass("d-none");
            $(this).parent().parent().parent().parent().parent().find(".phone_col").addClass("d-none");
            $(this).parent().parent().parent().parent().parent().find(".serial_col").addClass("d-none");
            $(this).parent().parent().parent().parent().parent().find(".vendor").removeAttr("required");
            $(this).parent().parent().parent().parent().parent().find(".phone_num").removeAttr("required");
            $(this).parent().parent().parent().parent().parent().find(".serial_num").removeAttr("required");
        }
    });
}
var checkbox_accounts = function () {
    $('.account_checkbox').click(function () {
        if ($(this).is(":checked")) {
            $(this).parent().parent().parent().parent().parent().find(".username_col").removeClass("d-none");
            $(this).parent().parent().parent().parent().parent().find(".username").attr("required");
        } else {
            $(this).parent().parent().parent().parent().parent().find(".username_col").addClass("d-none");
            $(this).parent().parent().parent().parent().parent().find(".username").removeAttr("required");
        }
    });
}
var add_device = function () {
    document.title = documentTitle + "Add Device";
    $("#devices").removeClass("active");
    $("#content_place").load('Directive', {d: 31}, function () {
        $('#purchase_date').datepicker();
        afterLoadingRegionSection();

    })
}
var add_accessory = function () {
    document.title = documentTitle + "Add Accessory";
    $("#add_accessory_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[1].checkValidity() === true) {

            $.ajax({
                url: "Controller",
                data: {
                    n: "44",
                    accessory: $("#accessory").val()

                },
                type: "POST",

                success: function (result, status, xhr) {
                    if (result > 0) {
                        form.removeClass("was-validated");
                        success("Accessory has been added", "");
                        form.trigger("reset");

                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}
var add_account = function () {
    document.title = documentTitle + "Add Account";
    $("#add_account_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[1].checkValidity() === true) {

            $.ajax({
                url: "Controller",
                data: {
                    n: "45",
                    account: $("#account").val()

                },
                type: "POST",

                success: function (result, status, xhr) {
                    if (result > 0) {
                        form.removeClass("was-validated");
                        success("Account has been added", "");
                        form.trigger("reset");

                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}
var add_privilege = function () {
    document.title = documentTitle + "Add Privilege";
    $("#add_privilege_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[1].checkValidity() === true) {

            $.ajax({
                url: "Controller",
                data: {
                    n: "33",
                    privilege: $("#privilege").val()

                },
                type: "POST",

                success: function (result, status, xhr) {
                    if (result > 0) {
                        form.removeClass("was-validated");
                        success("Privilege has been added", "");
                        form.trigger("reset");

                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}

var edit_privilege = function () {
    document.title = documentTitle + "Edit Privilege";
    $("#edit_privilege_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[1].checkValidity() === true) {

            $.ajax({
                url: "Controller",
                data: {
                    n: "33",
                    privilege: $("#privilege").val(),
                    privilege_id: $("#privilege_id").val()
                },
                type: "POST",

                success: function (result, status, xhr) {
                    if (result == 0) {
                        form.removeClass("was-validated");
                        success("Privilege has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}
var device_data = function (type, location, department) {
    $("#device_data").empty();
    if (type == 1) {
        $("#device_data").load('Directive', {d: 30, department: department, location: location}, savePC);
    } else if (type == 2) {
        $("#device_data").load('Directive', {d: 32, department: department, location: location}, function () {
            savePrinter();
            printerConnection();
        });
    } else if (type == 9) {
        $("#device_data").load('devices_data/attendance_data.jsp', saveAttendance);
    } else if (type == 8) {
        $("#device_data").load('Directive', {d: 33, department: department, location: location}, savePBX);
    } else if (type == 5 || type == 6 || type == 10 || type == 11 || type == 12 || type == 14 || type == 15) {
        $("#device_data").load('devices_data/device_data.jsp', saveDevice);
    } else if (type == 3 || type == 7) {
        $("#device_data").load('devices_data/video_recorder_data.jsp', saveVideoRecorder);
    } else if (type == 4) {
        $("#device_data").load('devices_data/device_data.jsp', function () {
            saveDevice();
            cameraIP_MAC();
        });
    } else if (type == 13) {
        $("#device_data").load('Directive', {d: 63, department: department, location: location}, saveMobile);
    }

}
var cameraIP_MAC = function () {
    $('#ip_address').removeAttr('required');
    $('#mac_address').removeAttr('required');
}
var printerConnection = function () {
    if ($("#connection").val() == 1) {
        $('#ip_address').removeAttr('required');
        $("#employee_").attr("required", true);
    }
    $("#connection").change(function () {
        if ($(this).val() == 1) {
            $('#ip_address').removeAttr('required');
            $("#ip_address").val("");
            $("#employee_").attr("required", true);
        } else if ($(this).val() == 2) {
            $('#ip_address').attr("required", true);
            $("#employee_").load('Directive', {d: 35, department: $("#department_").val()}, function () {
                $("#employee_").removeAttr('required');
            });

        }
    });
}

/*
var new_ticket = function () {
    $("#location_").change(function () {
        $("#department_section").load('Directive', {d: 2, location: $("#location_").val()}, function () {
            $("#department_").change(function () {
                $("#device_type_section").load('Directive', {d: 3}, function () {

                });
            });
        });
    });
}

var selectDeviceType = function (addable, callback) {
    loadDepartmentSection($(this), true, null);
    $(".location_").change(function () {
        $(this).parent().parent().parent().parent().parent().find(".department_section").load('Directive', {
            d: 2,
            location: $(this).val(),
            canAdd: addable
        }, function () {
            $(this).find(".department_").change(function () {
                var department = $(this).val();
                $(this).parent().parent().parent().parent().parent().find(".device_type_section").load('Directive', {
                    d: 3,
                    canAdd: addable
                }, function () {
                    callback(department);
                });
            });
        });
    });
}
var selectDevice = function (department) {
    $(".device_type_").change(function () {
        var deviceType = $(this).val();

        $(this).parent().parent().parent().parent().parent().find("#device_section").load('Directive', {
            d: 6,
            department: department,
            device_type: deviceType
        }, function () {
            $('#device_modal_fire').on("click", function () {
                $('#device_modal').modal('show');
                selectDeviceType(false, selectDevice);
            });
            $("#device_").change(function () {
                $("#device_info").load('Directive', {d: 7, device: $("#device_").val()});
                $("#problem_comment_section").load('problem_comment_section.jsp', function () {
                    $("#category_").change(function () {
                        $("#sub_category_section").load('sub_category_section.jsp');
                        $("#action_section").load("action_section.jsp", function () {
                            $("#assign_to_btn").click(function () {
                                $("#action_detail_section").load('assign_to_section.jsp');
                            });
                            $("#in_progress_btn").click(function () {
                                $("#action_detail_section").load('progress_in_section.jsp');
                            });
                            $("#pending_btn").click(function () {
                                $("#action_detail_section").load('pending_section.jsp');
                            });
                            $("#solved_btn").click(function () {
                                $("#action_detail_section").load('solved_section.jsp');
                            });
                        });
                    });
                });
            });
        });
    });
}
*/

var afterLoadingRegionSection = function () {
    $(".region_").change(function () {
        var regionSection = $(this).parent().parent().parent().parent();
        var region = $(this).val();
        loadLocationSection(regionSection, region);
        $(this).parent().parent().parent().parent().parent().find(".department_section").empty();
        $(this).parent().parent().parent().parent().parent().find(".device_type_section").empty();
        $(this).parent().parent().parent().parent().parent().find("#device_data").empty();
        emptySections();

    });
}
var loadLocationSection = function (regionSection, region) {
    regionSection.parent().find(".location_section").load('Directive', {
        d: 36,
        region: region
    }, function () {
        afterLoadingLocaitonSection($(this));
    });

}
var afterLoadingLocaitonSection = function (regionSection) {
    regionSection.find(".location_").change(function () {
        var locationSection = $(this).parent().parent().parent().parent();
        var location = $(this).val();
        loadDepartmentSection(locationSection, location);
        $(this).parent().parent().parent().parent().parent().find(".department_section").empty();
        $(this).parent().parent().parent().parent().parent().find(".device_type_section").empty();
        $(this).parent().parent().parent().parent().parent().find("#device_data").empty();
        emptySections();
    });
}
var loadDepartmentSection = function (locationSection, location) {
    locationSection.parent().find(".department_section").load('Directive', {
        d: 2,
        location: location
    }, function () {
        afterLoadingDepartmentSection($(this), location);
    });

}
var afterLoadingDepartmentSection = function (departmentSection, location) {
    departmentSection.find(".department_").change(function () {
        var department = $(this).val();
        loadDeviceTypeSection(departmentSection, location, department);
        $(this).parent().parent().parent().parent().parent().find("#device_data").empty();
        emptySections();
    });

}

var loadDeviceTypeSection = function (departmentSection, location, department) {
    departmentSection.parent().parent().find(".device_type_section").load('Directive', {
        d: 3,
    }, function () {
        afterLoadingDeviceTypeSection($(this), location, department)
    });
}

var afterLoadingDeviceTypeSection = function (deviceTypeSection, location, department) {
    deviceTypeSection.find(".device_type_").change(function () {
            var deviceType = $(this).val();
            loadDeviceSection(deviceTypeSection, location, department, deviceType);
            device_data(deviceType, location, department);
            emptySections();
        }
    );
}

var loadDeviceSection = function (deviceTypeSection, location, department, deviceType) {
    deviceTypeSection.parent().parent().find("#device_section").load('Directive', {
        d: 6,
        location: location,
        department: department,
        device_type: deviceType
    }, afterLoadingDeviceSection);
}
var afterLoadingDeviceSection = function () {
    $("#add_device").click(function () {
        add_device();
        $("#new_ticket").removeClass("active");
    });


    $("#device_").change(function () {
        var device = $("#device_info").parent().find("#device_").val();
        $("#device_info").load('Directive', {d: 7, device: device}, function () {
            $("#problem_comment_section").load('Directive', {d: 10}, function () {
                $('#actual_date').datepicker();
                $("#category_").change(function () {

                    $("#sub_category_section").load('Directive', {d: 12, category: $(this).val()});
                    $("#action_section").load("Directive", {d: 58}, function () {
                        afterLoadingActionSection(true);
                    });
                });
            });
        });

    });
}

var emptySections = function () {
    $("#device_section").empty();
    $("#device_info").empty();
    $("#problem_comment_section").empty();
    $("#action_section").empty();
    $("#action_detail_section").empty();

}

var setStatusValue = function (statusValue) {
    $("#status").val(statusValue);
}
var action_ = function (isCreated) {
    if (isCreated) {
        action_submit();
    } else {
        action_edit_submit();
    }
}
var afterLoadingActionSection = function (isCreated) {

    $("#assign_to_btn").click(function () {
        setStatusValue($(this).attr('status_value'));
        $("#action_detail_section").load('Directive', {
                d: 14,
                device_: $("#device_").val()
            }, function () {
                action_(isCreated)
            }
        );

    });
    $("#in_progress_btn").click(function () {
        setStatusValue($(this).attr('status_value'));
        $("#action_detail_section").load('sections/progress_in_section.jsp', function () {
            action_(isCreated)
        });

    });
    $("#pending_btn").click(function () {
        setStatusValue($(this).attr('status_value'));
        $("#action_detail_section").load('sections/pending_section.jsp', function () {
            action_(isCreated)
        });

    });
    $("#solved_btn").click(function () {
        setStatusValue($(this).attr('status_value'));
        $("#action_detail_section").load('sections/solved_section.jsp', function () {
            action_(isCreated)
        });

    });
    $("#closed_btn").click(function () {
        setStatusValue($(this).attr('status_value'));
        $("#action_detail_section").load('sections/closed_section.jsp', function () {
            action_(isCreated)
        });

    });
}
var action_submit = function () {
    $("#action_submit").click(function () {

        if ($(".needs-validation")[9].checkValidity() === true) {
            $.ajax({
                url: "Controller",
                data: {
                    n: "10",
                    problem: $("#problem").val(),
                    caller_name: $("#caller_name").val(),
                    caller_num: $("#caller_num").val(),
                    caller_email: $("#caller_email").val(),
                    device_: $("#device_").val(),
                    sub_category_: $("#sub_category_").val(),
                    comment: $("#comment").val(),
                    status: $("#status").val(),
                    actual_date: $("#actual_date").val(),
                    action: getAction()
                },
                type: "POST",

                success: function (result, status, xhr) {
                    if (result > 0) {
                        $(".needs-validation").removeClass("was-validated");
                        success("Ticket has been added", "");
                        $("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    }
                }
            });

        }
        $(".needs-validation").addClass("was-validated");
    });
}

var action_edit_submit = function () {
    $("#action_submit").click(function () {

        if ($(".needs-validation")[1].checkValidity() === true) {

            $.ajax({
                url: "Controller",
                data: {
                    n: "11",
                    ticket: $("#ticket").val(),
                    status: $("#status").val(),
                    action: getAction()
                },
                type: "POST",

                success: function (result, status, xhr) {
                    if (result > 0) {
                        $(".needs-validation").removeClass("was-validated");
                        success("Ticket has been edited", "");
                        $("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    }
                }
            });

        }
        $(".needs-validation").addClass("was-validated");
    });
}

var getAction = function () {
    var action;
    if ($("#status").val() == 1) {
        action = $("#ts_engineer_").val();
    } else if ($("#status").val() == 2) {
        action = $("#notes").val();
    } else if ($("#status").val() == 3) {
        action = $("#reason").val();
    } else if ($("#status").val() == 4) {
        action = $("#steps").val();
    } else if ($("#status").val() == 5) {
        action = $("#comment").val();
    }
    return action;
}

var deviceTabsSearchSorting = function () {
    $("#search_NVR").searchTable("NVR_table_body");
    $("#NVR_table").sortTableNow();
    $("#search_DVR").searchTable("DVR_table_body");
    $("#DVR_table").sortTableNow();
    $("#search_Router").searchTable("Router_table_body");
    $("#Router_table").sortTableNow();
    $("#search_Switch").searchTable("Switch_table_body");
    $("#Switch_table").sortTableNow();
    $("#search_Printer").searchTable("Printer_table_body");
    $("#Printer_table").sortTableNow();
    $("#search_PC").searchTable("PC_table_body");
    $("#PC_table").sortTableNow();
    $("#search_Att").searchTable("Att_table_body");
    $("#Att_table").sortTableNow();
    $("#search_Camera").searchTable("Camera_table_body");
    $("#Camera_table").sortTableNow();
    $("#search_FW").searchTable("FW_table_body");
    $("#FW_table").sortTableNow();
    $("#search_PBX").searchTable("PBX_table_body");
    $("#PBX_table").sortTableNow();
    $("#search_UPS").searchTable("UPS_table_body");
    $("#UPS_table").sortTableNow();
    $("#search_AP").searchTable("AP_table_body");
    $("#AP_table").sortTableNow();
    $("#search_mob").searchTable("mob_table_body");
    $("#mob_table").sortTableNow();
    $("#search_rack").searchTable("rack_table_body");
    $("#rack_table").sortTableNow();
    $("#search_handheld").searchTable("handheld_table_body");
    $("#handheld_table").sortTableNow();

}

var viewDevice = function () {
    $(".device").click(function () {
        $("#content_place").load('Directive', {d: 34, device: $(this).attr("device-id")}, function () {
            $("#devices").removeClass("active");
            $('#purchase_date').datepicker();
            afterLoadingRegionSection();
            resetForm();
            printerConnection();
            cameraIP_MAC();
            updateDevices($("#device_type_").val());
            $("#location_").change(function () {
                $("#department_").load('Directive', {d: 5, location: $("#location_").val()}, function () {
                    $("#employee_").load('Directive', {d: 35});
                });
            });
            $("#department_").change(function () {
                $("#employee_").load('Directive', {
                    d: 35,
                    department: $("#department_").val()
                });
            });
            $("#device_type_").change(function () {
                device_data($("#device_type_").val(), $("#location_").val(), $("#department_").val());
            });

        });
    });

}
var resetForm = function () {
    $(".reset").click(add_device);
}

var editEmployee = function () {

    $("#edit_employee_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[9].checkValidity() === true) {
            var accessory_array = "";
            var vendor_array = "";
            var second_value_array = "";
            var account_array = "";
            var username_array = "";
            $('.accessory_checkbox').each(function () {

                if ($(this).is(":checked")) {
                    if (accessory_array.length == 0) {
                        accessory_array += $(this).val();
                        vendor_array += $(this).parent().parent().parent().parent().parent().find(".vendor").val();
                        if ($(this).val() == 1 || $(this).val() == 2) {
                            second_value_array += $(this).parent().parent().parent().parent().parent().find(".phone_num").val();
                        } else if ($(this).val() == 3 || $(this).val() == 4) {
                            second_value_array += $(this).parent().parent().parent().parent().parent().find(".serial_num").val();
                        }
                    } else {
                        accessory_array += "," + $(this).val();
                        vendor_array += "," + $(this).parent().parent().parent().parent().parent().find(".vendor").val();
                        if ($(this).val() == 1 || $(this).val() == 2) {
                            second_value_array += "," + $(this).parent().parent().parent().parent().parent().find(".phone_num").val();
                        } else if ($(this).val() == 3 || $(this).val() == 4) {
                            second_value_array += "," + $(this).parent().parent().parent().parent().parent().find(".serial_num").val();
                        }
                    }
                }
            });

            $(".account_checkbox").each(function () {
                if ($(this).is(":checked")) {
                    if (account_array.length == 0) {
                        account_array += $(this).val();
                        username_array += $(this).parent().parent().parent().parent().parent().find(".username").val();
                    } else {
                        account_array += "," + $(this).val();
                        username_array += "," + $(this).parent().parent().parent().parent().parent().find(".username").val();
                    }
                }
            })
            $.ajax({
                url: "Controller",
                data: {
                    n: "24",
                    name: $("#edit_name").val(),
                    position: $("#edit_position").val(),
                    staff_id: $("#edit_staff_id").val(),
                    location: $("#location_").val(),
                    department: $("#department_").val(),
                    employee: $("#employee").val(),
                    accessory: accessory_array,
                    vendor: vendor_array,
                    second_value: second_value_array,
                    account: account_array,
                    username: username_array
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result == 1) {

                        success("Employee has been added", "");
                    } else if (result == 0) {
                        success("Employee has been edited", "")
                    }


                }
            });
        }
        form.addClass("was-validated");
    });
}

var addUser = function () {
    document.title = documentTitle + "Add User";
    $("#new_user_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[1].checkValidity() === true) {

            var privilege_array = "";
            $('.privilege_checkbox').each(function () {

                if ($(this).is(":checked")) {
                    if (privilege_array.length == 0) {
                        privilege_array += $(this).val();
                    } else {
                        privilege_array += "," + $(this).val();
                    }
                }
            });
            var region_array = "";
            $('.region_checkbox').each(function () {

                if ($(this).is(":checked")) {
                    if (region_array.length == 0) {
                        region_array += $(this).val();
                    } else {
                        region_array += "," + $(this).val();
                    }
                }
            });
            $.ajax({
                url: "Controller",
                data: {
                    n: "25",
                    name: $("#name").val(),
                    username: $("#username").val(),
                    phone_num: $("#phone_num").val(),
                    role: $("#role").val(),
                    email: $("#email").val(),
                    privileges: privilege_array,
                    regions: region_array
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {

                        success("User has been added", "");
                        $("#phone_num").removeClass("is-invalid");
                        $("#phone_num").removeClass("is-valid");
                        $("#username").removeClass("is-valid");
                        $("#username").removeClass("is-invalid");
                        $("#create_user_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else if (result == -1) {
                        error("User hasn't been added", "The username is not available");
                        $("#username").addClass("is-invalid");
                        $("#username").removeClass("is-valid");
                        $("#phone_num").addClass("is-valid");
                        $("#phone_num").removeClass("is-invalid");
                    } else if (result == -2) {
                        error("User hasn't been added", "The phone number is used for another user");
                        $("#phone_num").addClass("is-invalid");
                        $("#phone_num").removeClass("is-valid");
                        $("#username").addClass("is-valid");
                        $("#username").removeClass("is-invalid");
                    } else if (result == -3) {
                        error("User hasn't been added", "The username is not available and phone number is used for another user");
                        $("#phone_num").addClass("is-invalid");
                        $("#phone_num").removeClass("is-valid");
                        $("#username").removeClass("is-valid");
                        $("#username").addClass("is-invalid");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}

var editUser = function () {
    document.title = documentTitle + "Edit User";
    $("#edit_user_submit").click(function () {
        var form = $(this).parents('form:first');
        if ($(".needs-validation")[1].checkValidity() === true) {

            var privilege_array = "";
            $('.privilege_checkbox').each(function () {

                if ($(this).is(":checked")) {
                    if (privilege_array.length == 0) {
                        privilege_array += $(this).val();
                    } else {
                        privilege_array += "," + $(this).val();
                    }
                }
            });
            var region_array = "";
            $('.region_checkbox').each(function () {

                if ($(this).is(":checked")) {
                    if (region_array.length == 0) {
                        region_array += $(this).val();
                    } else {
                        region_array += "," + $(this).val();
                    }
                }
            });
            $.ajax({
                url: "Controller",
                data: {
                    n: "26",
                    user: $("#user").val(),
                    name: $("#name").val(),
                    username: $("#username").val(),
                    phone_num: $("#phone_num").val(),
                    role: $("#role").val(),
                    email: $("#email").val(),
                    privileges: privilege_array,
                    regions: region_array
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {

                        success("User has been edited", "");
                        $("#phone_num").removeClass("is-invalid");
                        $("#phone_num").removeClass("is-valid");
                        $("#username").removeClass("is-valid");
                        $("#username").removeClass("is-invalid");
                        //$("#create_user_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else if (result == -1) {
                        error("User hasn't been edited", "The username is not available");
                        $("#username").addClass("is-invalid");
                        $("#username").removeClass("is-valid");
                        $("#phone_num").addClass("is-valid");
                        $("#phone_num").removeClass("is-invalid");
                    } else if (result == -2) {
                        error("User hasn't been edited", "The phone number is used for another user");
                        $("#phone_num").addClass("is-invalid");
                        $("#phone_num").removeClass("is-valid");
                        $("#username").addClass("is-valid");
                        $("#username").removeClass("is-invalid");
                    } else if (result == -3) {
                        error("User hasn't been edited", "The username is not available and phone number is used for another user");
                        $("#phone_num").addClass("is-invalid");
                        $("#phone_num").removeClass("is-valid");
                        $("#username").removeClass("is-valid");
                        $("#username").addClass("is-invalid");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}

var loadRegionTicketRatioSection = function () {
    clearClass('ratio_section');
    $("#region_ticket_ratio_section").load('Directive', {d: 56});
}
var loadL2EngineersTicketRatioSection = function () {
    clearClass('ratio_section');
    $("#l2_engineers_ticket_ratio_section").load('Directive', {d: 54});
}
var loadRegionDevicesRatioSection = function () {
    clearClass('ratio_section');
    $("#region_devices_ratio_section").load('Directive', {d: 55});
}
var clearClass = function (Class) {
    $("." + Class).empty();
}
/*var resetPassword = function (user) {
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
var resetPasswordDialog = function (user) {
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
}*/
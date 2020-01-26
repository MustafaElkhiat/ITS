$(document).ready(function () {
    $("#dashboard").click(function () {
        stopTimers();
        $("#content_place").load('ticket_section.jsp', function () {
            initialValues();
            loadTicketChart();
            assign_to_tab();
            in_progress_tab();
            pending_tab();
            solved_tab();
            need_to_solve_tab();
        });
    });
    $("#new_ticket").click(function () {
        stopTimers();
        $("#content_place").load('Directive', {d: 1}, function () {
            afterLoadingRegionSection();
        });
    });
    $("#my_ticket").click(function () {
        stopTimers();
        $("#content_place").load('ticket_details.jsp', function () {
            initialValues();
            assign_to_details_tab();
            in_progress_details_tab();
            pending_details_tab();
            solved_details_tab();
            need_to_solve_details_tab();
            $("#search_REF").searchTable("table_REF");
            $("#mytable_REF").sortTableNow();
        })
    });
    $("#devices").click(function () {
        stopTimers();
        $("#content_place").load('Directive', {d: 28}, function () {
            deviceTabsSearchSorting();
            viewDevice();
            $(".fa-print").click(function () {
                $(this).parent().parent().find('table').printThis({
                    importCSS: true,
                    base: true
                });
            });
            $("#add_device").click(add_device);
        });
    });
    $("#users").click(function () {
        stopTimers();
        $("#content_place").load('Directive', {d: 40}, function () {
            $("#search_user").searchTable("user_table_body");
            $("#user_table").sortTableNow();
            $(".user").click(function () {
                $("#content_place").load('Directive', {d: 41, user: $(this).attr("user-id")},editUser);
            });
            $("#add_user").click(function () {
                $("#content_place").load('Directive', {d: 38}, addUser);
            });

        })

    });

    initialValues();
    loadTicketChart();
    assign_to_tab();
    in_progress_tab();
    pending_tab();
    solved_tab();
    need_to_solve_tab();
    setupTimers();
});

var add_device = function () {
    $("#devices").removeClass("active");
    $("#content_place").load('Directive', {d: 31}, function () {
        $('#purchase_date').datepicker();
        afterLoadingRegionSection();

    })
}

var device_data = function (type, department) {
    $("#device_data").empty();
    if (type == 1) {
        $("#device_data").load('Directive', {d: 30, department: department}, savePC);
    } else if (type == 2) {
        $("#device_data").load('Directive', {d: 32, department: department}, function () {
            savePrinter();
            printerConnection();
        });
    } else if (type == 9) {
        $("#device_data").load('attendance_data.jsp', saveAttendance);
    } else if (type == 8) {
        $("#device_data").load('Directive', {d: 33, department: department}, savePBX);
    } else if (type == 5 || type == 6 || type == 10 || type == 11) {
        $("#device_data").load('device_data.jsp', saveDevice);
    } else if (type == 3 || type == 7) {
        $("#device_data").load('video_recorder_data.jsp', saveVideoRecorder);
    } else if (type == 4) {
        $("#device_data").load('device_data.jsp', function () {
            saveDevice();
            cameraIP_MAC();
        });
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
var assign_to_tab = function () {
    $("#assign-to-tab").click(function () {
        $("#assign-to").load('Directive', {d: 16}, ticket_click);
    });
}
var assign_to_details_tab = function () {
    $("#assign-to-tab").click(function () {
        $("#assign-to").load('Directive', {d: 23}, function () {
            ticket_click();
            $("#search_assign_to").searchTable("assign_to_table_body");
            $("#assign_to_table").sortTableNow();
        });
    });
}
var solved_tab = function () {
    $("#solved-tab").click(function () {
        $("#solved").load('Directive', {d: 17}, ticket_click);
    });
}
var solved_details_tab = function () {
    $("#solved-tab").click(function () {
        $("#solved").load('Directive', {d: 26}, function () {
            ticket_click();
            $("#search_solved").searchTable("solved_table_body");
            $("#solved_table").sortTableNow();
        });
    });
}
var in_progress_tab = function () {
    $("#in-progress-tab").click(function () {
        $("#in-progress").load('Directive', {d: 18}, ticket_edit);
    });
}
var in_progress_details_tab = function () {
    $("#in-progress-tab").click(function () {
        $("#in-progress").load('Directive', {d: 24}, function () {
            ticket_edit();
            $("#search_in_progress").searchTable("in_progress_table_body");
            $("#in_progress_table").sortTableNow();
        });
    });
}
var pending_tab = function () {
    $("#pending-tab").click(function () {
        $("#pending").load('Directive', {d: 19}, ticket_edit);
    });
}
var pending_details_tab = function () {
    $("#pending-tab").click(function () {
        $("#pending").load('Directive', {d: 25}, function () {
            ticket_edit();
            $("#search_pending").searchTable("pending_table_body");
            $("#pending_table").sortTableNow();
        });
    });
}
var need_to_solve_tab = function () {
    $("#need-to-solve-tab").click(function () {
        $("#need-to-solve").load('Directive', {d: 21}, ticket_edit);
    });
}
var need_to_solve_details_tab = function () {
    $("#need-to-solve-tab").click(function () {
        $("#need-to-solve").load('Directive', {d: 27}, function () {
            ticket_edit();
            $("#search_need_to_solve").searchTable("need_to_solve_table_body");
            $("#need_to_solve_table").sortTableNow();
        });
    });
}
var ticket_click = function () {
    $(".ticket").click(function () {
        var ticket_id = $(this).attr("ticket-id");
        $("#content_place").load('Directive', {d: 15, ticket: ticket_id}, function () {
            $("#dashboard").removeClass("active");
            $("#my_ticket").removeClass("active");
            stopTimers();
        });
    });
}
var ticket_edit = function () {
    $(".ticket_edit").click(function () {
        var ticket_id = $(this).attr("ticket-id");
        $("#content_place").load('Directive', {d: 20, ticket: ticket_id}, function () {
            afterLoadingActionSection(false);
            $("#dashboard").removeClass("active");
            $("#my_ticket").removeClass("active");
            stopTimers();
        });
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
        afterLoadingDepartmentSection($(this));
    });

}
var afterLoadingDepartmentSection = function (departmentSection) {
    departmentSection.find(".department_").change(function () {
        var department = $(this).val();
        loadDeviceTypeSection(departmentSection, department);
        $(this).parent().parent().parent().parent().parent().find("#device_data").empty();
        emptySections();
    });

}

var loadDeviceTypeSection = function (departmentSection, department) {
    departmentSection.parent().parent().find(".device_type_section").load('Directive', {
        d: 3,
    }, function () {
        afterLoadingDeviceTypeSection($(this), department)
    });
}

var afterLoadingDeviceTypeSection = function (deviceTypeSection, department) {
    deviceTypeSection.find(".device_type_").change(function () {
            var deviceType = $(this).val();
            loadDeviceSection(deviceTypeSection, department, deviceType);
            device_data(deviceType, department);
            emptySections();
        }
    );
}

var loadDeviceSection = function (deviceTypeSection, department, deviceType) {
    deviceTypeSection.parent().parent().find("#device_section").load('Directive', {
        d: 6,
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
        var device = $(this).val();
        $("#device_info").load('Directive', {d: 7, device: device});
        $("#problem_comment_section").load('Directive', {d: 10}, function () {
            $("#category_").change(function () {
                $("#sub_category_section").load('Directive', {d: 12, category: $(this).val()});
                $("#action_section").load("action_section.jsp", function () {
                    afterLoadingActionSection(true);
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
        $("#action_detail_section").load('progress_in_section.jsp', function () {
            action_(isCreated)
        });

    });
    $("#pending_btn").click(function () {
        setStatusValue($(this).attr('status_value'));
        $("#action_detail_section").load('pending_section.jsp', function () {
            action_(isCreated)
        });

    });
    $("#solved_btn").click(function () {
        setStatusValue($(this).attr('status_value'));
        $("#action_detail_section").load('solved_section.jsp', function () {
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
                    device_: $("#device_").val(),
                    sub_category_: $("#sub_category_").val(),
                    comment: $("#comment").val(),
                    status: $("#status").val(),
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

        if ($(".needs-validation")[9].checkValidity() === true) {

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

}

var viewDevice = function () {
    $(".device").click(function () {
        $("#content_place").load('Directive', {d: 34, device: $(this).attr("device-id")}, function () {
            $("#devices").removeClass("active");
            $('#purchase_date').datepicker();
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
        });
    });

}
var resetForm = function () {
    $(".reset").click(add_device);
}

var addUser = function () {
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
                    privileges: privilege_array,
                    regions: region_array
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {

                        success("User has been added", "");
                        $("#create_user_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    } else {
                        success("User has been edited", "");
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}

var editUser = function () {
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
                    user:$("#user").val(),
                    name: $("#name").val(),
                    username: $("#username").val(),
                    phone_num: $("#phone_num").val(),
                    role: $("#role").val(),
                    privileges: privilege_array,
                    regions: region_array
                },
                type: "POST",

                success: function (result, status, xhr) {
                    form.removeClass("was-validated");
                    if (result > 0) {

                        success("User has been edited", "");
                        //$("#create_user_form").trigger("reset");
                        //$("#content_place").load('Directive', {d: 15, ticket: result.trim()});
                    }
                }
            });

        }
        form.addClass("was-validated");
    });
}
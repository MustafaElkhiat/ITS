var assign_to_tab = function (user) {
    $("#" + user + "-assign-to-tab").click(function () {
        $("#" + user + "-assign-to").load('Directive', {d: 16, user: user}, ticket_click);
    });
}
var assign_to_details_tab = function (user) {
    $("#" + user + "-assign-to-tab").click(function () {
        $("#" + user + "-assign-to").load('Directive', {d: 23, user: user}, function () {
            ticket_click();
            $("#search_assign_to").searchTable("assign_to_table_body");
            $("#assign_to_table").sortTableNow();
        });
    });
}
var solved_tab = function (user) {
    $("#" + user + "-solved-tab").click(function () {
        $("#" + user + "-solved").load('Directive', {d: 17, user: user}, function () {
            ticket_click();
            ticket_edit();
        });
    });
}
var solved_details_tab = function (user) {
    $("#" + user + "-solved-tab").click(function () {
        $("#" + user + "-solved").load('Directive', {d: 26, user: user}, function () {
            ticket_click();
            ticket_edit();
            $("#search_solved").searchTable("solved_table_body");
            $("#solved_table").sortTableNow();
        });
    });
}
var closed_tab = function (user) {
    $("#" + user + "-closed-tab").click(function () {
        $("#" + user + "-closed").load('Directive', {d: 51, user: user}, ticket_click);
    });
}
var closed_details_tab = function (user) {
    $("#" + user + "-closed-tab").click(function () {
        $("#" + user + "-closed").load('Directive', {d: 52, user: user}, function () {
            ticket_click();
            $("#search_closed").searchTable("closed_table_body");
            $("#closed_table").sortTableNow();
        });
    });
}
var in_progress_tab = function (user) {
    $("#" + user + "-in-progress-tab").click(function () {
        $("#" + user + "-in-progress").load('Directive', {d: 18, user: user}, ticket_edit);
    });
}
var in_progress_details_tab = function (user) {
    $("#" + user + "-in-progress-tab").click(function () {
        $("#" + user + "-in-progress").load('Directive', {d: 24, user: user}, function () {
            ticket_edit();
            $("#search_in_progress").searchTable("in_progress_table_body");
            $("#in_progress_table").sortTableNow();
        });
    });
}
var pending_tab = function (user) {
    $("#" + user + "-pending-tab").click(function () {
        $("#" + user + "-pending").load('Directive', {d: 19, user: user}, ticket_edit);
    });
}
var pending_details_tab = function (user) {
    $("#" + user + "-pending-tab").click(function () {
        $("#" + user + "-pending").load('Directive', {d: 25, user: user}, function () {
            ticket_edit();
            $("#search_pending").searchTable("pending_table_body");
            $("#pending_table").sortTableNow();
        });
    });
}
var need_to_solve_tab = function (user) {
    $("#" + user + "-need-to-solve-tab").click(function () {
        $("#" + user + "-need-to-solve").load('Directive', {d: 21, user: user}, ticket_edit);
    });
}
var need_to_solve_details_tab = function (user) {
    $("#" + user + "-need-to-solve-tab").click(function () {
        $("#" + user + "-need-to-solve").load('Directive', {d: 27, user: user}, function () {
            ticket_edit();
            $("#search_need_to_solve").searchTable("need_to_solve_table_body");
            $("#need_to_solve_table").sortTableNow();
        });
    });
}
var need_to_close_tab = function (user) {
    $("#" + user + "-need-to-close-tab").click(function () {
        $("#" + user + "-need-to-close").load('Directive', {d: 53, user: user}, ticket_edit);
    });
}
var need_to_close_details_tab = function(user){
    $("#" + user + "-need-to-close-tab").click(function () {
        $("#" + user + "-need-to-close").load('Directive', {d: 57, user: user}, function () {
            ticket_edit();
            $("#search_need_to_close").searchTable("need_to_close_table_body");
            $("#need_to_close_table").sortTableNow();
        });
    });
}

var ticket_click = function () {
    $(".ticket").click(function () {
        var ticket_id = $(this).attr("ticket-id");
        $("#content_place").load('Directive', {d: 15, ticket: ticket_id}, function () {
            $("#dashboard").removeClass("active");
            $("#my_ticket").removeClass("active");
            problem_comment_info();
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
            problem_comment_info();
            stopTimers();
        });
    });
}
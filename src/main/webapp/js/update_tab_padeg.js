var ticketChartTimer, assignToTimer, assignToUserTimer, inProgressTimer, pendingTimer, solvedTimer;

var loadTicketChart = function () {
    $("#ticket_chart").load('Directive', {d: 22});
    ticketChartTimer = setTimeout(loadTicketChart, 10000);
}

var stopTicketChart = function () {
    clearTimer(ticketChartTimer);
}
var getAssignToSum = function () {
    $.ajax({
        url: "Controller",
        data: {
            n: "12",
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#assign-to-badge").html(result);
        }
    });
    assignToTimer = setTimeout(getAssignToSum, 10000);
}

var stopAssignToSum = function () {
    clearTimer(assignToTimer);
}
var getAssignToUserSum = function () {
    $.ajax({
        url: "Controller",
        data: {
            n: "13",
        },
        type: "POST",

        success: function (result, status, xhr) {
            if (result == "null" || result == null) {
                $("#need-to-solve-badge").html(0);
            } else {
                $("#need-to-solve-badge").html(result);
            }
        }
    });
    assignToUserTimer = setTimeout(getAssignToUserSum, 10000);
}
var stopAssignToUserSum = function () {
    clearTimer(assignToUserTimer);
}
var getInProgressUserSum = function () {
    $.ajax({
        url: "Controller",
        data: {
            n: "14",
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#in-progress-badge").html(result);
        }
    });
    inProgressTimer = setTimeout(getInProgressUserSum, 10000);
}
var stopInProgressUserSum = function () {
    clearTimer(inProgressTimer);
}
var getPendingUserSum = function () {
    $.ajax({
        url: "Controller",
        data: {
            n: "15",
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#pending-badge").html(result);
        }
    });
    pendingTimer = setTimeout(getPendingUserSum, 10000);
}
var stopPendignUserSum = function () {
    clearTimer(pendingTimer);
}
var getSolvedUserSum = function () {
    $.ajax({
        url: "Controller",
        data: {
            n: "16",
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#solved-badge").html(result);
        }
    });
    solvedTimer = setTimeout(getSolvedUserSum, 10000);

}
var stopSolvedUserSum = function () {
    clearTimer(solvedTimer);
}
var initialValues = function () {

    getAssignToSum();
    getAssignToUserSum();
    getPendingUserSum();
    getInProgressUserSum();
    getSolvedUserSum();
}
var stopTimers = function () {
    stopAssignToSum();
    stopAssignToUserSum();
    stopInProgressUserSum();
    stopPendignUserSum();
    stopSolvedUserSum();
    stopTicketChart();
}
var clearTimer = function (Timer) {
    clearTimeout(Timer);
}

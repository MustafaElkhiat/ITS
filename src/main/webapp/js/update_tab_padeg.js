var ticketChartTimer = [];
var regionChartTimer = [];
var assignToTimer = [];
var assignToUserTimer = [];
var inProgressTimer = [];
var pendingTimer = [];
var solvedTimer = [];
var closedTimer = [];
var needToCloseTimer = [];
var loadTicketChart = function (user) {
    $("#" + user + "_ticket_chart").load('Directive', {d: 22, user: user}, function () {

    });

}
var loadRegionChart = function (region) {
    $("#" + region + "_region_chart").load('Directive', {d: 44, region: region});
}

var loadDeviceChart = function (region) {
    $("#" + region + "_device_chart").load('Directive', {d: 45, region: region});
}
var stopTicketChart = function () {
    clearTimer(ticketChartTimer);
}
var stopRegionChart = function () {
    clearTimer(regionChartTimer);
}
var getAssignToSum = function (user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "12",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#" + user + "-assign-to-badge").html(result);
            assignToTimer[assignToTimer.length] = setTimeout(function () {
                getAssignToSum(user);
            }, 10000);
        }
    });

}


var stopAssignToSum = function () {
    clearTimer(assignToTimer);
}

var getAssignToUserSum = function (user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "13",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            if (result == "null" || result == null) {
                $("#" + user + "-need-to-solve-badge").html(0);
            } else {
                $("#" + user + "-need-to-solve-badge").html(result);
            }
            assignToUserTimer[assignToUserTimer.length] = setTimeout(function () {
                getAssignToUserSum(user);
            }, 10000);
        }
    });

}
var stopAssignToUserSum = function () {
    clearTimer(assignToUserTimer);
}
var getInProgressUserSum = function (user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "14",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#" + user + "-in-progress-badge").html(result);
            inProgressTimer[inProgressTimer.length] = setTimeout(function () {
                getInProgressUserSum(user);
            }, 10000);
        }
    });

}
var stopInProgressUserSum = function () {
    clearTimer(inProgressTimer);
}
var getPendingUserSum = function (user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "15",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#" + user + "-pending-badge").html(result);
            pendingTimer[pendingTimer.length] = setTimeout(
                function () {
                    getPendingUserSum(user);
                }, 10000);
        }
    });

}
var stopPendingUserSum = function () {
    clearTimer(pendingTimer);
}
var getSolvedUserSum = function (user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "16",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#" + user + "-solved-badge").html(result);
            solvedTimer[solvedTimer.length] = setTimeout(function () {
                getSolvedUserSum(user);
            }, 10000);
        }
    });


}
var stopClosedUserSum = function () {
    clearTimer(closedTimer);
}

var getClosedUserSum = function (user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "34",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#" + user + "-closed-badge").html(result);
            closedTimer[closedTimer.length] = setTimeout(function () {
                getClosedUserSum(user);
            }, 10000);
        }
    });


}

var stopNeedToCloseSum = function () {
    clearTimer(closedTimer);
}

var getNeedToCloseSum = function (user) {
    $.ajax({
        url: "Controller",
        data: {
            n: "35",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            $("#" + user + "-need-to-close-badge").html(result);
            needToCloseTimer[needToCloseTimer.length] = setTimeout(function () {
                getNeedToCloseSum(user);
            }, 10000);
        }
    });


}

var stopSolvedUserSum = function () {
    clearTimer(solvedTimer);
}
var initialValues = function (user) {

    getAssignToSum(user);
    getAssignToUserSum(user);
    getPendingUserSum(user);
    getInProgressUserSum(user);
    getSolvedUserSum(user);
    getClosedUserSum(user);
    getNeedToCloseSum(user);
}
var stopTimers = function () {
    stopAssignToSum();
    stopAssignToUserSum();
    stopInProgressUserSum();
    stopPendingUserSum();
    stopSolvedUserSum();
    stopClosedUserSum();
    stopNeedToCloseSum();
    stopTicketChart();
    stopRegionChart();
}
var clearTimer = function (Timer) {
    Timer.forEach(function (value, index, array) {
        clearTimeout(Timer[index]);
    })


}

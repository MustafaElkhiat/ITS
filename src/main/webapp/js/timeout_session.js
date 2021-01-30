var timeoutInMilliseconds = 15 * 60 * 1000;
var timeoutId;

function startTimer() {
    // window.setTimeout returns an Id that can be used to start and stop a timer
    timeoutId = window.setTimeout(doInactive, timeoutInMilliseconds)
}
function stopTimer() {
    window.clearTimeout(timeoutId);
}
function doInactive() {
    // does whatever you need it to actually do - probably signs them out or stops polling the server for info
    //alert("لقد تخطيت الفترة المسموحة من فضلك اعد تسجيل الدخول");
    //var ip = "localhost";
    //var port = "12000";
    //var ip = "10.0.96.51";
    var ip = "10.0.170.50";
    var port = "9999";
    bootbox.alert({
        message: "You have exceeded the allowed period Please log back in",
        locale: 'en',
        closeButton: false,
        callback: function () {
            window.location = "http://" + ip + ":" + port + "/ITS/";
        }
    });
    stopTimer();
    //window.location = "http://localhost:8080/DMS/";
}

function resetTimer() {
    stopTimer();
    startTimer();
}

function setupTimers() {
    document.addEventListener("mousemove", resetTimer, false);
    document.addEventListener("mousedown", resetTimer, false);
    document.addEventListener("keypress", resetTimer, false);
    document.addEventListener("touchmove", resetTimer, false);

    startTimer();
}
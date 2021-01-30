var ticketTimeline = function (ticket_id) {
    google.charts.load("current", {packages: ["timeline"]});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var container = document.getElementById('timeline');
        var chart = new google.visualization.Timeline(container);
        var dataTable = new google.visualization.DataTable();
        dataTable.addColumn({type: 'string', id: 'ticket_id'});
        dataTable.addColumn({type: 'string', id: 'status'});
        dataTable.addColumn({type: 'date', id: 'Start'});
        dataTable.addColumn({type: 'date', id: 'End'});
        dataTable.addRows(
            [['Ticket ID ' + ticket_id, 'Assign To', new Date(2019, 12, 24, 10, 0, 0), new Date(2019, 12, 25, 10, 0, 0)]]);
        dataTable.addRows([
            ['Ticket ID ' + ticket_id, 'In Progress', new Date(2019, 12, 25, 10, 0, 0), new Date(2019, 12, 25, 13, 0, 0)]]);
        dataTable.addRows([
            ['Ticket ID ' + ticket_id, 'Solved', new Date(2019, 12, 25, 13, 0, 0), new Date(2019, 12, 25, 16, 0, 0)]]);

        var options = {
            timeline: {groupByRowLabel: true},
            colors: ['#007bff', '#ffc107', '#28a745']
        };

        chart.draw(dataTable, options);
    }


}
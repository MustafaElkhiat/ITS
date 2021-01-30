/**
 *
 */

function sortTable(n, table_id) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById(table_id);
    switching = true;
    //Set the sorting direction to ascending:
    dir = "asc";
    /*Make a loop that will continue until
     no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /*Loop through all table rows (except the
         first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
             one from current row and one from the next:*/
            console.info(rows[i].getElementsByTagName("TD")[n]);
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /*check if the two rows should switch place,
             based on the direction, asc or desc:*/

            var x_number = x.innerHTML.replace(/[^0-9]/g, "");
            var x_alpha = x.innerHTML.replace(/[0-9]/g, "");
            var y_number = y.innerHTML.replace(/[^0-9]/g, "");
            var y_alpha = y.innerHTML.replace(/[0-9]/g, "");


            if (dir == "asc") {


                if ((x_alpha.toLowerCase() > y_alpha.toLowerCase()) || ((x_alpha.toLowerCase() == y_alpha.toLowerCase()) && (parseInt(x_number) > parseInt(y_number)))) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if ((x_alpha.toLowerCase() < y_alpha.toLowerCase()) || ((x_alpha.toLowerCase() == y_alpha.toLowerCase()) && (parseInt(x_number) < parseInt(y_number)))) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /*If a switch has been marked, make the switch
             and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            //Each time a switch is done, increase this count by 1:
            switchcount++;
        } else {
            /*If no switching has been done AND the direction is "asc",
             set the direction to "desc" and run the while loop again.*/
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
    return dir;
}

$.fn.sortTableNow = function () {
    var table_id = $(this).attr("id");
    $(this).find("th").each(function (index) {
        $(this).click(function () {
            $(this).parent().find("i").removeClass("fa-sort-amount-up");
            $(this).parent().find("i").removeClass("fa-sort-amount-down");

            var dir = sortTable(index, table_id);
            if (dir == "asc") {
                $(this).find("i").addClass("fa-sort-amount-down");
            } else if (dir == "desc") {
                $(this).find("i").addClass("fa-sort-amount-up");
            }
        });
    });
}


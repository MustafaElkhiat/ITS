function printDiv(divID) {
    //Get the HTML of div
    var divElements = document.getElementById(divID).innerHTML;
    //Get the HTML of whole page
    var oldPage = document.body.innerHTML;

    //Reset the page's HTML with div's HTML only
    document.body.innerHTML = divElements;

    //Print Page
    window.print();

    //Restore orignal HTML
    document.body.innerHTML = oldPage;


}


function printElem(divId, url) {
    //var content = document.getElementById(divId).innerHTML;
    //alert(content);
    var mywindow = window.open(url, 'print', 'height=500,width=800');
    //alert(window.location + "-" + window.location.host + "-" + window.location.pathname);
    //mywindow.document.body.innerHTML = "Mustafa";


    mywindow.document.close();
    mywindow.print();
    mywindow.onafterprint = function (event) {
        mywindow.close();
    };

}

function printReport(divElements) {
    var $printerDiv = $('<div class="printContainer"></div>'); // create the div that will contain the stuff to be printed
    $printerDiv.html(divElements); // add the content to be printed
    $('body').append($printerDiv).addClass("printingContent"); // add the div to body, and make the body aware of printing (we apply a set of css styles to the body to hide its contents)

    window.print(); // call print
    $printerDiv.remove(); // remove the div
    $('body').removeClass("printingContent");
}
function search() {
    $.ajax({
        type: "GET",
        url: "/all/employee/search/" + $('#searchCriteria').val(),
        success: function (result) {
            $("#tableCurrency").html(result);
        }
    })
}

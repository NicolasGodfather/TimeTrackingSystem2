function deleteEmployee(employeeId, messageDelete, messageError) {
    if (confirm(messageDelete)) {
        $.ajax({
            type: "POST",
            url: "/delete/employee/" + employeeId,
            success: function (result) {
                $("#trEmployeeId" + employeeId).remove();
            },
            error: function () {
                alert(messageError);
            }
        });
    }
}

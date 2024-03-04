function deleteStudents() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idStudent]:checked');
    if (checkedCheckboxes.length == 0) {
        alert('Пожалуйста, выберите хотя бы одного студента');
        return;
    }
    let ids = "";
    for (let i = 0; i < checkedCheckboxes.length; i++) {
        ids = ids + checkedCheckboxes[i].value + " ";
    }
    document.getElementById("idsDelete").value = ids;
    document.getElementById("deleteForm").submit();
}

function modifyStudent() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idStudent]:checked');
    if (checkedCheckboxes.length == 0) {
        alert('Пожалуйста, выберите одного студента');
        return;
    }
    if (checkedCheckboxes.length > 1) {
        alert('Пожалуйста, выберите только одного студента');
        return;
    }
    let id = checkedCheckboxes[0].value;
    document.getElementById("idModify").value = id;
    document.getElementById("modifyForm").submit();
}

function progressStudents() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idStudent]:checked');
    if (checkedCheckboxes.length == 0) {
        alert('Пожалуйста, выберите одного студента');
        return;
    }
    if (checkedCheckboxes.length > 1) {
        alert('Пожалуйста, выберите только одного студента');
        return;
    }
    let id = checkedCheckboxes[0].value;
    document.getElementById("idProgress").value = id;
    document.getElementById("progressForm").submit();
}

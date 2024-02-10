function modifyDiscipline() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idDiscipline]:checked');
    if (checkedCheckboxes.length == 0) {
        alert('Пожалуйста, выберете одну дисциплину');
        return;
    }
    if (checkedCheckboxes.length > 1) {
        alert('Пожалуйста, выберете только одну дисциплину');
        return;
    }
    let id = checkedCheckboxes[0].value;
    document.getElementById("idModify").value = id;
    document.getElementById("modifyForm").submit();
}

function deleteDisciplines() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idDiscipline]:checked');
    if (checkedCheckboxes.length == 0) {
        alert('Пожалуйста, выберете хотя бы одного студента');
        return;
    }
    let ids = "";
    for (let i = 0; i < checkedCheckboxes.length; i++) {
        ids = ids + checkedCheckboxes[i].value + " ";
    }
    document.getElementById("idsDelete").value = ids;
    document.getElementById("deleteForm").submit();
}
checkbox.addEventListener('click', function () {
    if (document.getElementById('brackets').checked) {
        document.getElementById('numOfBrackets').style.display = 'block';
    } else {
          document.getElementById('numOfBrackets').style.display = 'hidden';
    }
});

//проверка на количество введенных символов
function addUserSecondName(s){
	if (s.length <=5){
		alert('Введите не менее 5-ти символов');
		submitButton.disabled = true;
	}else
		submitButton.disabled = false;	
}

//проверка на тип введенных символов
function addUserAge(a){
	var test = isNaN(a);
	if (test==true){
		alert('Введите цифровые символы');
		submitButton.disabled = true;
	}else
		submitButton.disabled = false;			
}

//проверка на корректность введенных символов
function addUserGender(g){
	if ((!g.equals('m'))||(!g.equals('f'))){
		alert('Введите "f" или "m"');
		submitButton.disabled = true;
	}else
		submitButton.disabled = false;		
}

//проверка на корректность введенных символов
function addUserPhone(p){
	var mask = /^\+\(\d{3}\)\d{3}-\d{2}-\d{2}$/;
	if (!mask.test(p)){
		alert('Введите номер телефона +(ххх)ххх-хх-хх');
		submitButton.disabled = true;
	}else
		submitButton.disabled = false;
}
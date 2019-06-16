$(function(){
    $('#date').combodate({customClass: 'form-control'});    
	$('#datetime').combodate(); 
	$('#time').combodate({
        firstItem: 'name', //show 'hour' and 'minute' string at first item of dropdown
        minuteStep: 1,
		customClass: 'form-control'
    });   
});
$(document).ready(function()
{
$('#dropdown-content').hide();
$('#dropdown-content1').hide();
$('#dropdown-content2').hide();


$('#registration').click(
function(){
$('#dropdown-content').show();
$('#dropdown-content1').hide();
$('#dropdown-content2').hide();
})
$('#login').click(
function(){
$('#dropdown-content').hide();	
$('#dropdown-content1').show();
$('#dropdown-content2').hide();
})
$('#forgotpass').click(
function(){
$('#dropdown-content').hide();	
$('#dropdown-content1').hide();
$('#dropdown-content2').show();
})


$('#studentregistration').click(
function(){
	$('#dropdown-content').hide();
	$('#dropdown-content1').hide();
	$('#dropdown-content2').hide();
})
$('#instituteregistration').click(
function(){
	$('#dropdown-content').hide();
	$('#dropdown-content1').hide();
	$('#dropdown-content2').hide();
})
$('#industryregistration').click(
function(){
	$('#dropdown-content').hide();
	$('#dropdown-content1').hide();
	$('#dropdown-content2').hide();
})


$('#studentforgotpass').click(
function(){
	$('#dropdown-content').hide();
	$('#dropdown-content1').hide();
	$('#dropdown-content2').hide();
})
$('#instituteforgotpass').click(
function(){
	$('#dropdown-content').hide();
	$('#dropdown-content1').hide();
	$('#dropdown-content2').hide();
})
$('#industryforgotpass').click(
function(){
	$('#dropdown-content').hide();
	$('#dropdown-content1').hide();
	$('#dropdown-content2').hide();
})



});
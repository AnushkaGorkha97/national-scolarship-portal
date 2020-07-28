
function validate(){
    var name  = document.getElementById('name').value;
    var insitituteCode = document.getElementById('insitituteCode').value;
    var diseCode = document.getElementById('diseCode').value;
    var instituteLocation = document.getElementById('instituteLocation').value;
    var university =  document.getElementById('university').value;
    var setPassword = document.getElementById('setPassword').value;
    var confPassword = document.getElementById('confPassword').value;
    var instituteCertificate = document.getElementById('instituteCertificate').value;
    var universityCertificate = document.getElementById('universityCertificate').value;
    var address = document.getElementById('address').value;
    var principalName = document.getElementById('principalName').value;
    var insititueMobile = document.getElementById('insititueMobile').value;
    var address = document.getElementById('address').value;

    if( name == '' || insitituteCode == '' || diseCode == '' || instituteLocation == '' || university == '' || setPassword == '' || confPassword == ''
        || instituteCertificate == '' || universityCertificate == '' || address == '' || principalName == '' 
        	|| insititueMobile == '' || address == ''){
            alert("FIELDS CANNOT BE EMPTY")
            return false
        }
        else{
            return true
        }
            
};
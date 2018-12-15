$(document).ready(function() {
    
    var password = $("#password");
    var confirmPassword = $("#conf-password");
    password.on("change", validatePassword);
    confirmPassword.on("keyup", validatePassword);

    function validatePassword() {
        if (password.val() != confirmPassword.val()) {
            confirmPassword.get(0).setCustomValidity("Las contraseñas no coinciden.");
        }
        else {
            confirmPassword.get(0).setCustomValidity("");
        }
    }
    
});
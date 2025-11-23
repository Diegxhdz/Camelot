document.addEventListener('DOMContentLoaded',function(){
    const singupForm = document.querySelector('section');
    singupForm.style.opacity = 0;


    setTimeout(() => {
        singupForm.style.transition = 'opacity 1s ease-in-out';
        singupForm,style.opacity = 1;
    },500);


    const singupBotton = document.querySelector('button');
    singupBottom.addEventListener('click',function(){
        const nameInput  = document.querySelector('input[type="nombre"]');
        const ApellidoInput = document.querySelector('input[type="apellido"]');
        const emailInput = document.querySelector('input[type="correo"]');
        const passwordInput = document.querySelector('input[type="contraseña"]');
        const confirmPasswordInput = document.querySelector('input[type="contraseña"][name="confirmar-contraseña"]');


        const isValid = emailInput.checkValidity() && passwordInput.checkValidity() && confirmPasswordInput.checkValidity();
        
        if(isValid) {
            singupForm.classList.add('shake');

            setTimeout(()=>{
                singupForm.classList.remove('shake');
            },1000);

        }
    });


});
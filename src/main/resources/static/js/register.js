const registerVue = new Vue({
    el: "#login-box",
    data: {
        aname: "",
        email: "",
        pwd: "",
        cpwd: "",
        emailValid: false
    },
    methods: {
        checkEmail: function(){
            console.log(registerVue.email);
        },
        register: function(){
            if(!registerVue.emailValid){
                alert("请验证邮箱");
                return;
            }
        }
    }
})
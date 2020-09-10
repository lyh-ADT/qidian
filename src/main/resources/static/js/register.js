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
            const email = $("#email").val();
            $.ajax({
                url: "account/checkEmail",
                method: "GET",
                data: {
                    email: email
                },
                success: function() {
                    $("#email").attr("placeholder", "请输入邮箱中的验证码");
                    registerVue.$data.email=email;
                    registerVue.$data.emailValid = true;
                }
            });
        },
        register: function(){
            if(!registerVue.emailValid){
                alert("请验证邮箱");
                return;
            }
            if(registerVue.pwd != registerVue.cpwd){
                alert("两次密码不一致");
                return;
            }
            $.ajax({
                url: "account",
                method: "PUT",
                data: JSON.stringify({
                    aid:$("#email").val(),
                    aname: registerVue.aname,
                    pwd: registerVue.pwd,
                    email: registerVue.email
                }),
                contentType: "application/json",
                success: function(message){
                    if(message != "success"){
                        alert(message);
                        return;
                    }
                    location.href = "login.html";
                }
            })
        }
    }
})
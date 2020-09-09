const loginVue = new Vue({
    el: "#login-box",
    data: {
        aid: "",
        pwd: ""
    },
    methods: {
        login: function(){
            $.ajax({
                url: "account",
                method: "POST",
                data: JSON.stringify({
                    email: loginVue.aid,
                    pwd: loginVue.pwd
                }),
                contentType: "application/json",
                success: function(message){
                    if(message == "success"){
                        location.href = "index.html";
                        return;
                    }
                    alert(message);
                }
            })
        }
    }
})
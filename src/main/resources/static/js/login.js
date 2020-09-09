const loginVue = new Vue({
    el: "#login-box",
    data: {
        aid: "",
        pwd: ""
    },
    methods: {
        login: function(){
            console.log(loginVue.aid)
        }
    }
})
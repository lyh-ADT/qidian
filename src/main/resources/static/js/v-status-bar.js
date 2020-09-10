Vue.component('status-bar', {
    props:["account"],
    template: /* html */`<ul>
        <li v-if="account==''"><a href="login.html">请登录</a></li>
        <li v-else>{{account.aname}}</li>
    </ul>`
});

const statusBarVue = new Vue({
    el:".status-bar",
    data: {
        account: ''
    },
    mounted:()=>{
        checkLogin((acc)=>{
            statusBarVue.$data.account = acc;
        })
    }
})
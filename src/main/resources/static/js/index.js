const bookTypeListVue = new Vue({
    el: "#type-list",
    data: {
        types: []
    },
    mounted:()=>{
        $.ajax({
            url: "/booktype/all",
            method: "GET",
            type: "json",
            success: (data)=>{
                bookTypeListVue.types = data.slice(0, 13);
                console.log(data)
            }
        })
    }
});
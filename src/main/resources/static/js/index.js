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
            }
        })
    }
});

const col5BookListVue = new Vue({
    el: "#col5-book-list",
    data: {
        lists: []
    },
    mounted: () => {
        $.ajax({
            url: "/rank/ranks",
            method: "GET",
            type: "json",
            success: (data) => {
                col5BookListVue.lists = data;
            }
        })
    }
});

const bookShellVue = new Vue({
    el: "#book-shell",
    data:{
        books: []
    },
    mounted: () => {

        $.ajax({
            url: "/rank/random?nums=6",
            method: "GET",
            type: "json",
            success:(data) => {
                bookShellVue.books = data;
            }
        });
    }
});

const shellRankVue = new Vue({
    el: "#shell-rank",
    data: {
        books: []
    },
    mounted: () => {
        $.ajax({
            url: "/rank/random?nums=12",
            method: "GET",
            type: "json",
            success:(data) => {
                shellRankVue.books = data;
            }
        });
    }
})
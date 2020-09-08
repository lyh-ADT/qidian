function search() {
    const key = $("#search-input").val();
    let search = "";
    if(location.search == ""){
        search = "?key="+key;
    } else {
        const pos = location.search.indexOf("key=");
        if(pos === -1) {
            search = location.search + "&key" + key;
        } else {
            if(key == "") {
                search = location.search;
            } else {
                search = location.search.replace(/key=.*?(?=(&|$))/, "key="+key);
            }
        }
    }
    $.ajax({
        url: "/book/search"+search,
        method: "GET",
        type: "json",
        success:(data) => {
            bookSearchListVue.setBooks(data);
        }
    });
}

const bookSearchListVue = new Vue({
    el: "#book-shell",
    data:{
        books: []
    },
    methods:{
        setBooks: (books) => {
            bookSearchListVue.$data.books = books;
        }
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
});

search();
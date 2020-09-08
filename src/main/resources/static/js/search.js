function search() {
    const key = $("#search-input").val();
    console.log(key);
}

const bookSearchListVue = new Vue({
    el: "#book-shell",
    data:{
        books: []
    },
    mounted: () => {
        $.ajax({
            url: "/rank/random?nums=16",
            method: "GET",
            type: "json",
            success:(data) => {
                bookSearchListVue.books = data;
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
});
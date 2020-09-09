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
$.ajax({
    url: "/rank/random?nums=10",
    method: "GET",
    type: "json",
    success:(data) => {
        bookSearchListVue.setBooks(data);
    }
});
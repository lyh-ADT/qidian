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

checkLogin();

$.ajax({
    url: "/shell/books",
    method: "GET",
    type: "json",
    success:(data) => {
        bookSearchListVue.setBooks(data);
    }
});
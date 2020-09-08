const tabs = [
    "book-info","book-volume"
];

function selectTab(li, tabId){
    for(let tid of tabs) {
        if(tid === tabId){
            continue;
        }
        $("#"+tid).css("display", "none");
    }
    $(".tab-list li").removeClass("active");

    $("#"+tabId).css("display", "block");
    $(li).addClass("active");
}

const bookId = /id=(\d+)/.exec(location.search)[1];

const bookDetailVue = new Vue({
    el: "#book",
    data: {
        "book":{}
    },
    mounted: () => {
        $.ajax({
            url: `/book/${bookId}`,
            method: "GET",
            type: "json",
            success: (data) => {
                bookDetailVue.book = data;
            }
        })
    }
})
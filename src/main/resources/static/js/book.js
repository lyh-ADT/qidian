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
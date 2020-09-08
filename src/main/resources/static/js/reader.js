function isAtBottom() {
    const OFFSET = 50;
    const scrollTop = document.body.scrollTop || window.pageYOffset;
    const clientHeight = document.documentElement.clientHeight;
    return Math.abs(scrollTop + clientHeight - document.body.scrollHeight) < OFFSET;
}

function loadNextChapter(){
    const content = document.getElementById("content");
    const volume = document.createElement("div");
    content.appendChild(volume);

    volume.className = "volume";
    // 第一个是封面
    const index = document.querySelectorAll(".volume").length - 1;
    volume.innerHTML = `<h2>第${index}章</h2>`;

    for(let i=0; i < 10; i++) {
        const p = document.createElement("p");
        volume.appendChild(p);
        
        p.innerText = 生成章节();
    }

}

const bookId = /id=(\d+)/.exec(location.search)[1];

const bookInfoVue = new Vue({
    el: ".index",
    data: {
        book: {}
    },
    mounted: () => {
        $.ajax({
            url: `/book/${bookId}`,
            method: "GET",
            type: "json",
            success: (data) => {
                bookInfoVue.book = data;
            }
        })
    }
})

window.onscroll = function(e) {
    if(isAtBottom()){
        loadNextChapter();
    }
}

loadNextChapter();

// 移动端显示和隐藏菜单
function initMobileMenu() {
    function isOnScreenCenter(x, y, offset=100) {
        const screenHorizonMid = window.innerWidth / 2;
        const screenVerticalMid = window.innerHeight / 2;

        return Math.abs(screenHorizonMid - x) <= offset && Math.abs(screenVerticalMid - y) <= offset;

    }
    const menu = document.getElementById("menu");
    let isShowing = false;
    window.onclick = function(ev){
        if(!isOnScreenCenter(ev.x, ev.y)){
            return;
        }
        menu.style.display = isShowing ? "none" : "block";
        isShowing = !isShowing;
    }
}
if(window.innerWidth <= 800){
    initMobileMenu();
}
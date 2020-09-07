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

    for(let i=0; i < 10; i++) {
        const p = document.createElement("p");
        volume.appendChild(p);
        
        p.innerText = 生成章节();
    }

}

window.onscroll = function(e) {
    if(isAtBottom()){
        loadNextChapter();
    }
}

loadNextChapter();
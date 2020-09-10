var account = null;

function checkLogin(callback=((account)=>{
    console.log(account);
    if(account == ""){
        location.href = "login.html";
    }
})) {
    $.ajax({
        url: "/account",
        method: "GET",
        type: "json",
        success: (acc) => {
            account = acc;
            if(callback){
                callback(acc);
            }
        }
    })
}
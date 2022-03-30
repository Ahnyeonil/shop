var listBtn = document.getElementsByClassName("list-page");

window.onload=function(){

    for (var i = 0; i < listBtn.length; i++) {
        listBtn[i].addEventListener('click', goListPageFunction, false);
    }
}

var goListPageFunction = function() {
    location.href="/member/memberList";
};

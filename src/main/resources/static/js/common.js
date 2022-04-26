var memberListBtn = document.getElementsByClassName("member-list");
var itemListBtn = document.getElementsByClassName("item-list");

window.onload=function(){

    for (var i = 0; i < memberListBtn.length; i++) {
        memberListBtn[i].addEventListener('click', memberListPageFunction, false);
    }

    for (var i = 0; i < itemListBtn.length; i++) {
            itemListBtn[i].addEventListener('click', itemListPageFunction, false);
        }
}

var memberListPageFunction = function() {
    location.href="/member/memberList";
};

var itemListPageFunction = function() {
    location.href="/item/itemList";
};

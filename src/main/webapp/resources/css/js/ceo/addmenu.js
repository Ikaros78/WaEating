let menugroup = document.querySelector('#menugroup');

menugroup.addEventListener('click', function(e){
if(e.target.classList.contains('plus')){
    let menu = this.querySelector('#menu').cloneNode(true);

    menu.querySelector('#menuName').value="";
    menu.querySelector('#menuPrice').value="";
    this.appendChild(menu);
}
if(e.target.classList.contains('minus')){
    e.target.parentElement.remove();
}
})

// document.getElementById("plus").onclick = function(){

//   var menu = document.getElementById('menu');

//   var newMenu = menu.cloneNode(true);

//   newMenu.id = 'menu';

//   menu.after(newMenu);


// }

// document.getElementById("minus").onclick = function(){



//   newMenu.remove();


// }

// document.getElementById("plus").onclick = function(){
//   $(document.getElementsByClassName('menugroup')).append('menugroup');
// }
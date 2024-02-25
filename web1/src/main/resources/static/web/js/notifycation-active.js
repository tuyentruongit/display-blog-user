toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-right",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}

// active menu


const activeMenu = ()=>{
    console.log("activemenu")
    // lấy pathName trên url
    let pathName = window.location.pathname;
    // lấy  danh sách menu
    const items = document.querySelectorAll(".menu-item");
    console.log(items);
    // lấy href trên thẻ a để so sánh
 items.forEach( item =>{
     if (pathName === item.getAttribute('href')){
         item.classList.replace('text-dark', 'ttext-danger');
     }else {
         item.classList.replace('text-danger', 'text-dark');
     }

 })




}
activeMenu()    ;
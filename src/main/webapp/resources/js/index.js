// 메뉴 클릭 시 메뉴 항목 전환
// 클릭한 메뉴의 테이블만 보이기
$("#menu li.title:eq(0)").on('click', function() {
    $(".sub").addClass('hidden')
    $(".sub:eq(0)").removeClass('hidden')
})
$("#menu li.title:eq(1)").on('click', function() {
    $(".sub").addClass('hidden')
    $(".sub:eq(1)").removeClass('hidden')
})
$("#menu li.title:eq(2)").on('click', function() {
    $(".sub").addClass('hidden')
    $(".sub:eq(2)").removeClass('hidden')
})
$("#menu li.title:eq(3)").on('click', function() {
    $(".sub").addClass('hidden')
    $(".sub:eq(3)").removeClass('hidden')
})
$("#menu li.title:eq(4)").on('click', function() {
    $(".sub").addClass('hidden')
    $(".sub:eq(4)").removeClass('hidden')
})
$("#menu li.title:eq(5)").on('click', function() {
    $(".sub").addClass('hidden')
    $(".sub:eq(5)").removeClass('hidden')
})
$("#menu li.title:eq(6)").on('click', function() {
    $(".sub").addClass('hidden')
    $(".sub:eq(6)").removeClass('hidden')
})
$("#menu li.title:eq(7)").on('click', function() {
    $(".sub").addClass('hidden')
    $(".sub:eq(7)").removeClass('hidden')
})

// 온라인 시계
function clock() {
const heading = document.querySelector('p');
let today = new Date();
let hour = today.getHours();
let minute = today.getMinutes();
let second =  today.getSeconds();
heading.innerHTML = hour + " : " + minute + " : " + second
}
clock();
setInterval(function() { clock() }, 1000)
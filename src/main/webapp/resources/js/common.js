// 클릭할 때마다 증가하는 값
let i = 0;

// 이름값 담는 배열 변수 설정
let name_list = new Array();

// 이름이 배열 내에 없을 때 0, 있을 때 1인 state 추가
let state = 0;

// Total Function 변수
total_price_num = 0;
var total_amount = 0;
let sale_price = 0;

// Coffee
$(".sub").children().on("click", function () {
    let text = $(this).children("span").text(); // 메뉴 이름 추출

    menu_price = $(this).text().replace(text, "").replace("원", "");
    menu_price = parseInt(menu_price); // int 타입의 메뉴 가격 추출

    // name_list 배열에 coffee_text가 있으면 state 1로 변경
    for (let i = 0; i < name_list.length; i++) {
        if (name_list[i] == text) {
            state = 1;
        }
    }

    // state == 0, 배열에 이름이 들어가 있지 않을 때(클릭한 적 없는 요소)
    if (state == 0) {
        i++; // 클릭할 때마다 i가 증가

        total_price_num++; // 전체 수량에 반영할 변수 증가

        $("#orderList").append("<tr class='orderItems" + i + "'>");
        let orderList = $("#orderList").find(".orderItems" + i);
        orderList.append("<td class='orderItemsNum'>" + i + "</td>");

        orderList.append("<td><input type='text' name='orderItemsList['+(i-1)'].menuName' value='" + coffee_text + "' readonly='readonly' class='add_item" + i + "'/></td>");

        orderList.append("<td><button class='minus'>-</button><input type='text' name='orderItemsList['+(i-1)'].numOfNum' value='1' readonly='readonly' class='menu_amount" + i + "'></td>");

        orderList.append("<td class='orderList_right'>" + menu_price + "</td>");
        orderList.append("<td class='orderList_right'><input type='text' name=''orderItemsList['+(i-1)'].paidPrice' value='" + menu_price + "' readonly='readonly' class='total_amount" + i + "'></td>");

        total_amount += menu_price;
        name_list.push(coffee_text);
    }

    //'orderItemsList['+(i-1)'].menuName'
    //'orderItemsList['+(i-1)'].numOfNum'
    //'orderItemsList['+(i-1)'].paidPrice'
    

    //state==1, 배열에 이름이 들어가 있을 때(클릭한 적이 있는 요소)
    else {
        state = 0;
        total_price_num++; // 전체 수량에 반영할 변수 증가

        for (let j = 1; j <= i; j++) {

            if ($(".add_item" + j).val() == coffee_text) {
                amount = $(".menu_amount" + j).val();
                amount = parseInt(amount)+1;
                $(".menu_amount" + j).val(amount);

                // total_amount += menu_price * amount;
                total_amount += menu_price;
                $(".total_amount" + j).val(total_amount);
                console.log("menu_price : "+menu_price);
                console.log("amount : "+amount);
            }

        }
    }

    total();
})


function total() {
    //총 수량
    $("#total_num").val(total_price_num);
    
    //총 금액
    $("#total_amount").val(total_amount);
    
    //할인 금액
    sale_price = $("#mileage").text();
    sale_price = parseInt(sale_price);
    //받을 금액
    console.log("total_amount : "+total_amount);
    console.log("sale_price : "+sale_price);
    console.log(total_amount - sale_price);
    $(".important:last").val(total_amount - sale_price);
}
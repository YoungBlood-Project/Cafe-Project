// 클릭할 때마다 증가하는 값
// 클래스 끝에 번호 부여하기 위한 변수
// ex) orderItems1, orderItems2
let i = 0;

// 이름값 담는 배열 변수 설정
let name_list = new Array();

// 이름이 배열 내에 없을 때 0, 있을 때 1인 state 추가
let state = 0;

// 전체 수량의 값이 담기는 변수 추가
let total_price_num = 0;

// Total Function 변수
var total_amount = 0; // 총 금액
let sale_price = 0; // 할인 금액

// -----------------------------------------

$(".sub").children().on("click", function() {
	
	// 메뉴 이름 추출
	let menu_text = $(this).children("span").text();

	// li에 있는 텍스트 요소 중 menu_text와 '원'을 뺀 나머지 값을 가격으로 설정.
	menu_price = parseInt($(this).text().replace(menu_text, "").replace("원", ""));
	// menu_price = parseInt(menu_price);

	// name_list 배열에 menu_text가 있으면 state 1로 변경 (이미 한 번 클릭된 요소)
	for (let i = 0; i < name_list.length; i++) {
		if (name_list[i] == menu_text) {
			state = 1;
		}
	}

	// state == 0, 배열에 이름이 들어가 있지 않을 때(클릭한 적 없는 요소)
	if (state == 0) {
		
		i++;

		total_price_num++;

		$("#orderList").append("<tr class='orderItems" + i + "'>");
		let orderList = $("#orderList").find(".orderItems" + i);
		orderList.append("<td class='orderItemsNum'>" + i + "</td>");

		//'orderItemsList['+(i-1)'].menuName' (이름)
		orderList.append("<td><input type='text' name='orderItemsList["+(i-1)+"].menuName' value='" + menu_text + "' readonly='readonly' class='menuName" + i + "'/></td>");
		//'orderItemsList['+(i-1)'].numOfNum' (수량)
		orderList.append("<td><button class='minus'>-</button><input type='text' name='orderItemsList["+(i-1)+"].numOfNum' value='1' readonly='readonly' class='numOfNum" + i + "'><button class='plus'>+</button></td>");
		// 메뉴 단가
		orderList.append("<td class='orderList_right'><input type= hidden class='menu_price' value= '" + sale_price + "'></td>");
		//'orderItemsList['+(i-1)'].paidPrice' (총 금액)
		orderList.append("<td class='orderList_right'><input type='text' name=''orderItemsList["+(i-1)+"].paidPrice' value='" + menu_price + "' readonly='readonly' class='paidPrice" + i + "'></td>");

		total_amount += menu_price;
		name_list.push(menu_text);
	}

	
	//state==1, 배열에 이름이 들어가 있을 때(클릭한 적이 있는 요소)
	else {
		
		state = 0;
		total_price_num++; // 전체 수량에 반영할 변수 증가

		for (let j = 1; j <= i; j++) {

			if ($(".menuName" + j).val() == menu_text) {
				
				amount = parseInt($(".numOfNum" + j).val()) + 1;
			//	amount = parseInt(amount) + 1;
				$(".numOfNum" + j).val(amount);

				// total_amount += menu_price * amount;
				total_amount += menu_price;
				$(".paidPrice" + j).val(total_amount);
				console.log("menu_price : " + menu_price);
				console.log("amount : " + amount);
			}

		}
	}

	total();
})


// left section 아래 부분에 해당하는, 총 수량과 총 금액, 마일리지, 받을 금액을
// 나타내는 함수.

function total() {
	//총 수량 설정
	$("#total_num").val(total_price_num);

	//총 금액 설정
	$("#total_amount").val(total_amount);

	//할인 금액
	sale_price = parstInt($("#mileage").text());
	// sale_price = parseInt(sale_price);
	
	//받을 금액
	console.log("total_amount : " + total_amount);
	console.log("sale_price : " + sale_price);
	console.log(total_amount - sale_price);
	
	$(".important:last").val(total_amount - sale_price);
}
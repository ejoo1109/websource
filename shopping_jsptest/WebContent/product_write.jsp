<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>쇼핑몰</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container" style="margin-top: 50px">
<h3 class="text-center">상 품 입 력</h3>
<form method="post" action="insert.do">
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">카테고리</label>
    <div class="col-sm-10">
      	<select name="goods_category" size="1" class="form-control">
			<option value="outwear" selected>아웃웨어</option>
			<option value="fulldress">정장/신사복</option>
			<option value="Tshirts">티셔츠</option>
			<option value="shirts">와이셔츠</option>
			<option value="pants">팬츠</option>
			<option value="shoes">슈즈</option>
		</select>
    </div>
  </div>
  <div class="form-group row">
    <label for="goods_name" class="col-sm-2 col-form-label">상품이름</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="goods_name" id="goods_name" placeholder="상품명" >
    </div>
  </div>
  <div class="form-group row">
    <label for="goods_price" class="col-sm-2 col-form-label">판매가</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="goods_price" id="goods_price" placeholder="판매가" >
    </div>
  </div>
  <div class="form-group row">
    <label for="goods_color" class="col-sm-2 col-form-label">색상</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="goods_color" id="goods_color" placeholder="색상" >
    </div>
  </div>
  <div class="form-group row">
    <label for="goods_amount" class="col-sm-2 col-form-label">수량</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="goods_amount" id="goods_amount" placeholder="수량" >
    </div>
  </div>
  <div class="form-group row">
    <label for="goods_size" class="col-sm-2 col-form-label">사이즈</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="goods_size" id="goods_size" placeholder="사이즈" >
    </div>
  </div>
  <div class="form-group row">
    <label for="goods_size" class="col-sm-2 col-form-label">제품정보</label>
    <div class="col-sm-10">
      <textarea name="goods_content" class="form-control" rows="3"></textarea>
    </div>
  </div>
  <div class="form-group row justify-content-center">
  	<button type="submit" class="btn btn-primary">등록</button>
  	&nbsp;
  	<button type="reset" class="btn btn-danger">취소</button>  	
  </div>
</form>
</div>	
<!-- 상품 등록 -->
</body>
</html>
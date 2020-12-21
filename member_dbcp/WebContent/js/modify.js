/**
 * modifyForm의 유효성 검증
 */

$(function(){
    $("#modifyform").validate({
        //규칙 정의-이름
    rules :{
        current_password:{
			required:true,
            validPwd : true,
			rangelength:[8,12]
        },
        new_password:{
			required:true,
            validPwd : true,
            rangelength:[8,12]
        },
         confirm_password:{
			required:true,
			validPwd : true,
			rangelength:[8,12],
			equalTo : "#new_password" 
		},

},
	messages:{
		current_password :{ 
			required:"현재 비밀번호를 입력해 주세요."
	},
		new_password :{ 
			required:"새로운 비밀번호를 입력해 주세요."
	},
		confirm_password :{ 
			required:"새로운 비밀번호를 입력해 주세요",
			equalTo:"이전 비밀번호와 다릅니다."
	},

  },//에러 메시지가 나올 위치 잡기: small 아이디 뒤로
	errorPlacement:function(error,element){
		$(element).closest("form").find("small[id='"+element.attr('id')+"']").append(error);
	}
})
});
//사용자 검증 메소드 추가
$.validator.addMethod("validPwd",function(value){
    let pwcheck = /(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^*])[A-Za-z\d!@#$%^*]{8,15}$/;
    return pwcheck.test(value);
},"비밀번호를 영대소문자, 숫자, 특수문자의 조합으로 8~15자리로 만들어주세요");

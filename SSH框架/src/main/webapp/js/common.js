$(document).ready(function () {
    //注册验证
    $("#btn1").click(function () {
        var email=$("#email").val();
        if($("#name").val()==""){
            alert("用户名不许为空！");
        }else if($("#pass1").val()==""){
            alert("创建日期不能为空！")
        }else if($("#pass2").val()==""){
            alert("修改日期不能为空！")
        }else if($("#email").val()==""){
            alert("邮箱不能为空！")
        }else if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/))
        {
         alert("格式不正确！请重新输入");
         $("#email1").focus();
        }else{
            document.forms[0].submit();
        }
    })
    //全选
    var  flag=true;
    $("#all").click(function () {
        if(flag==true){
            $("input").prop("checked",true);
            flag=false;
        }else{
            $("input").prop("checked",false);
            flag=true;
        }
    })

    //删除
    $(".del").click(function () {
        $(this).parent().parent().hide();
    })
    //查询
    $("#search_btn").click(function(){
        var key = $("#Ktext").val();
        var sbody = $("#show_tbody");
        var trr = $("#trr",sbody);
        var keyword = $("#no_id",sbody).text();
        for(var i = 0; i < keyword.length;i++)
        {
            if(keyword[i]== key[0]){
                trr.eq(i).show();
            }else{
                trr.eq(i).hide();
            }
        }
    });

})

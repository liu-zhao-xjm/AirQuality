$(function () {
    //日期格式的判断
    function submit() {
        //下拉框 districtId 判断

        var $dis = $("#districtId").val();
        if ($dis == "0") {
            alert("不能为请选择！！！！");
            return false;
        }
        //日期判断 monitorTime
        var $monitorTime = $("#monitorTime").val();
        var $regExp = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;

        if ($monitorTime == "") {
            alert("日期不能为空！！！")
            return false;
        } else if (!$regExp.test($monitorTime)) {
            alert("监测日期必须符合日期格式如（2012-12-12）");
            return false;
        }
        //PM10  pm10
        var $pm10 = $("#pm10").val();
        var $pmNum = /^\d*$/;
        if ($pm10 == "") {
            alert("PM10不能为空!!!!");
            return false;
        } else if (!$pmNum.test($pm10)) {
            alert("PM10必须是数字");
            return false;
        }
        //PM2.5值 pm
        var $pm = $("#pm10").val();

        if ($pm == "") {
            alert("PM不能为空!!!!");
            return false;
        } else if (!$pmNum.test($pm)) {
            alert("PM必须是数字");
            return false;
        }
        //monitoringStation
        var $monitoringStation = $("#monitoringStation").val();

        if ($monitoringStation == "") {
            alert("检测站不能为空！！！！");
            return false;
        }
        return true;
    }

    $("#save").click(function () {
        var isexit = confirm("是否保存！！！");
        if (isexit) {
            //提交
            if (submit()) {
                $.ajax({
                    type: "POST",//请求类型
                    url: "/air/addAir", //请求
                    data: $("#login_form").serialize(),
                    /* cache:false,
                     async:true,
                     contentType:"application/json;charset=UTF-8",*/
                    /*   dataType: "json",//ajax接口（请求url）返回的数据类型*!/!*!/*/
                    success: function (data) {
                        //data：返回数据（json对象）
                        if (data.code == 100) {
                            window.location.href = "/air/pagelist.html";
                        } else {
                            alert(data.add_error)
                        }
                    },
                    error: function () {
                        alert("加载失败！");
                    }
                })
            }
        } else {

        }
    })
});

//返回
function backtrack() {
    var isexit = confirm("是否返回！！！");
    if (isexit) {
        //提交
        window.history.go(-1);
    }
}
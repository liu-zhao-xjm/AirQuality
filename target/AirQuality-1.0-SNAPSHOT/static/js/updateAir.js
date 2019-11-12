//返回
$(function () {
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
            alert("日期格式不对");
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

    $("#updateAir").click(function () {
        var isexit = confirm("是否更新");
        if (isexit) {
            if (submit()) {
                $.ajax({
                    type: "GET",//请求类型
                    url: "/air/update", //请求
                    data: $("#update_from").serialize(),
                    /*  dataType: "json",//ajax接口（请求url）返回的数据类型*!/*/
                    success: function (data) {
                        //data：返回数据（json对象）
                        if (data.code == 100) {
                            window.location.href = "/air/pagelist.html";
                        } else {
                            alert(data.upd_error)
                        }
                    },
                    error: function () {

                        alert("加载失败！");
                    }

                })
            }
        }}
    );
    $("#deleteAir").click(function () {
        var isexit = confirm("是否刪除");
        if (isexit) {
            $.ajax({
                type: "GET",//请求类型
                url: "/air/delete", //请求
                data: $("#update_from").serialize(),
                /*  dataType: "json",//ajax接口（请求url）返回的数据类型*!/*/
                success: function (data) {
                    //data：返回数据（json对象）
                    if (data.code == 100) {
                        window.location.href = "/air/pagelist.html";

                    } else {
                        alert(data.del_error)
                    }
                },
                error: function () {
                    alert("加载失败！");
                }
            })
        }
    })
});

function backtrack() {
    var isexit = confirm("是否返回！！！");
    if (isexit) {
        //提交
        window.history.go(-1);
    }
}
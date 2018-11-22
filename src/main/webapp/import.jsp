<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>excel导入</title>
</head>
<body>
<div><font color="bule">批量导入</font></div>
<form action="subcontract/importSubContract.do" method="post" enctype="multipart/form-data" onsubmit="return check();">
    <div style="margin: 30px;"><input id="excel_file" type="file" name="filename" accept="xlsx" size="80"/>
        <input id="excel_button" type="submit" value="导入Excel"/></div>
    <%--<font id="importMsg" color="red"><%=importMsg%></font><input type="hidden"/>--%>
</form>
</body>
<script type="text/javascript">
    function check() {
        var excel_file = $("#excel_file").val();
        if (excel_file == "" || excel_file.length == 0) {
            alert("请选择文件路径！");
            return false;
        } else {
            return true;
        }
    }

    $(document).ready(function () {
        var msg="";
        if($("#importMsg").text()!=null){
            msg=$("#importMsg").text();
        }
        if(msg!=""){
            alert(msg);
        }
    });
</script>

</html>

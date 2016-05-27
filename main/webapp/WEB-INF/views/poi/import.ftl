
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
</head>
<script type="text/javascript">
    function check() {
        alert("check");
        var excel_file = $("#excel_file").val();
        if (excel_file == "" || excel_file.length == 0) {
            alert("请选择文件路径！");
            return false;
        } else {
            return true;
        }
    }
</script>

<body>
<form name="excelImportForm" action="/importBrandSort" method="post" onsubmit="return check();" enctype="multipart/form-data" id="excelImportForm">
    <input  type="hidden" name="ids" id="ids">
    <div class="modal-body">
        <div class="row gap">
            <label class="col-sm-7 control-label"><input class="btn btn-default" id="excel_file" type="file" name="filename"  accept="xls"/></label>
            <div class="col-sm-3">

                <input class="btn btn-primary" id="excel_button" type="submit" value="导入Excel"/>
            </div>
        </div>

    </div>

    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onClick="uncheckBoxes();">取消</button>
    </div>

    <#--<form name="Form" action="/importBrandSort" method="post" onsubmit="return check();">-->
        <#--<input class="btn btn-default" id="excel_file" type="file" name="filename"  accept="xls"/>-->
        <#--<input  id="excel_button" type="submit" value="导入Excel"/>-->
    <#--</form>-->
</body>
</html
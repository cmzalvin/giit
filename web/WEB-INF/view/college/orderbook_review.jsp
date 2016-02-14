<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/nav.jsp"></jsp:include>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">已添加教材</h1>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            已添加教材
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <form>
                                    <table class="table table-hover"
                                           id="dataTables-example">
                                        <thead>
                                        <tr>
                                            <th>专业</th>
                                            <th>课程名称</th>
                                            <th>书号</th>
                                            <th>书名</th>
                                            <th>印刷日期</th>
                                            <th>作者</th>
                                            <th>出版社</th>
                                            <th>教材类别</th>
                                            <th>单价</th>
                                            <th>学生数量</th>
                                            <th>备注</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="addedBook" items="${addedBookList}">
                                            <tr>
                                                <td>${addedBook.spec}</td>
                                                <td>${addedBook.courseTitle}</td>
                                                <td>${addedBook.bookTitle}</td>
                                                <td>${addedBook.isbn}</td>
                                                <td>${addedBook.dataOfPrinting}</td>
                                                <td>${addedBook.author}</td>
                                                <td>${addedBook.press}</td>
                                                <td>${addedBook.category}</td>
                                                <td>${addedBook.unitPrice}</td>
                                                <td>${addedBook.stdCount}</td>
                                                <td>${addedBook.remark}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <button type="button" class="btn btn-warning" id="btn_alter"
                                            onclick="changeBtnText()">审核
                                    </button>
                                </form>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row-->
        </div>

    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
</div>
<!-- /#wrapper -->

<jsp:include page="/bottom.jsp"></jsp:include>


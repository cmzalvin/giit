<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/nav.jsp"></jsp:include>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">添加班级</h1>
        </div>
        <div class="panel-heading">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        班级信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <form action="/clazz.do/add" method="get">
                                <label>所属院系</label>
                                <select class="form-control" name="department">
                                    <c:forEach var="entry" items="${specBelongDept}">
                                        <option>${entry.key}</option>
                                    </c:forEach>
                                </select>
                                <label>所属专业</label>
                                <select class="form-control" name="speciality">
                                    <c:forEach var="entrty" items="${specBelongDept}">
                                        <c:forEach var="specName" items="${entrty.value}">
                                            <option>${specName}</option>
                                        </c:forEach>
                                    </c:forEach>
                                </select>
                                <label>开设年份</label>
                                <select class="form-control" name="year">
                                    <option>2016</option>
                                    <option>2015</option>
                                    <option>2014</option>
                                    <option>2013</option>
                                </select>
                                <%--<select class="form-control" name="departmentName">--%>
                                <%--<c:forEach var="speciality" items="${speclities}">--%>
                                <%--<option>${speciality}</option>--%>
                                <%--</c:forEach>--%>
                                <%--</select>--%>
                                <label></label>
                                <button type="submit"
                                        class="btn btn-primary form-control">添加
                                </button>
                            </form>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>

    <!-- /.container-fluid -->
</div>
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/bottom.jsp"></jsp:include>

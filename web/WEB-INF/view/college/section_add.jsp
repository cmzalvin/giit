<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/nav.jsp"></jsp:include>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">开设课程</h1>
        </div>
        <div class="panel-heading">
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        开设课程
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <form action="/section.do/add" method="get" class="form-group">
                                <label>课程名称</label>
                                <select class="form-control" name="courseTitle">
                                    <c:forEach var="courseTitle" items="${courseTitleList}">
                                        <option>${courseTitle}</option>
                                    </c:forEach>
                                </select>

                                <label>授课老师</label>
                                <select class="form-control" name="teacherName">
                                    <c:forEach var="teacherName" items="${teacherNameList}">
                                        <option>${teacherName}</option>
                                    </c:forEach>
                                </select>
                                <label>周次(输入格式1,2,3,4,5,6,7)</label>
                                <input class="form-control" name="weeks">
                                <label>星期</label>
                                <select class="form-control" name="week">
                                    <option>星期一</option>
                                    <option>星期二</option>
                                    <option>星期三</option>
                                    <option>星期四</option>
                                    <option>星期五</option>
                                    <option>星期六</option>
                                    <option>星期天</option>
                                </select>
                                <label>节次(输入格式1,2,3,4,5,6,7)</label>
                                <input class="form-control" name="time">
                                <label>教室</label>
                                <input class="form-control" name="classroom">
                                <label>可选课人数</label>
                                <input class="form-control" name="limit">
                                <label>开设时间</label>
                                <select class="form-control" name="year">
                                    <option>20162</option>
                                    <option>20161</option>
                                </select>

                                <label></label>
                                <button type="submit"
                                        class="btn btn-primary form-control">开设课程
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
</div>

<!-- /.container-fluid -->
</div>
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/bottom.jsp"></jsp:include>

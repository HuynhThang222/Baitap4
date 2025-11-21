<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<title>Quản lý Danh Mục</title>

<div class="card shadow mb-4">
    <div class="card-header py-3 d-flex justify-content-between align-items-center">
        <h6 class="m-0 font-weight-bold text-primary">Danh Sách Thể Loại</h6>
        <a href="<c:url value='/admin/category/add'/>" class="btn btn-success btn-sm">
            <i class="fas fa-plus"></i> Thêm mới
        </a>
    </div>
    <div class="card-body">
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <div class="table-responsive">
            <table class="table table-bordered table-hover" width="100%" cellspacing="0">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Tên danh mục</th>
                        <th>Hình ảnh</th>
                        <th>Trạng thái</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listCate}" var="c">
                        <tr>
                            <td>${c.categoryId}</td>
                            <td>${c.categoryName}</td>
                            <td>
                                <c:if test="${not empty c.images}">
                                    <img src="<c:url value='/uploads/${c.images}'/>" width="80" class="img-thumbnail"/>
                                </c:if>
                                <c:if test="${empty c.images}">
                                    <span class="text-muted">Không có ảnh</span>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${c.status == 1}"><span class="badge bg-success">Hoạt động</span></c:if>
                                <c:if test="${c.status != 1}"><span class="badge bg-secondary">Khóa</span></c:if>
                            </td>
                            <td>
                                <a href="<c:url value='/admin/category/edit?id=${c.categoryId}'/>" class="btn btn-warning btn-sm">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="<c:url value='/admin/category/delete?id=${c.categoryId}'/>" 
                                   onclick="return confirm('Bạn chắc chắn muốn xóa?')" 
                                   class="btn btn-danger btn-sm">
                                    <i class="fas fa-trash"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
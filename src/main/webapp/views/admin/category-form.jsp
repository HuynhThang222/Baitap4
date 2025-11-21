<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<title>${not empty cate ? 'Cập nhật Danh Mục' : 'Thêm mới Danh Mục'}</title>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            ${not empty cate ? 'Cập nhật Danh Mục' : 'Thêm mới Danh Mục'}
        </h6>
    </div>
    <div class="card-body">
        <form action="<c:url value='${not empty cate ? "/admin/category/update" : "/admin/category/insert"}'/>" 
              method="post" enctype="multipart/form-data">
            
            <c:if test="${not empty cate}">
                <input type="hidden" name="categoryId" value="${cate.categoryId}">
                <input type="hidden" name="currentImage" value="${cate.images}">
            </c:if>

            <div class="mb-3">
                <label class="form-label">Tên danh mục:</label>
                <input type="text" class="form-control" name="categoryName" value="${cate.categoryName}" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Hình ảnh:</label>
                <input type="file" class="form-control" name="images">
                <c:if test="${not empty cate.images}">
                    <div class="mt-2">
                        <img src="<c:url value='/uploads/${cate.images}'/>" height="100" class="rounded">
                        <small class="d-block text-muted">Ảnh hiện tại</small>
                    </div>
                </c:if>
            </div>

            <div class="mb-3">
                <label class="form-label">Trạng thái:</label>
                <select class="form-select" name="status">
                    <option value="1" ${cate.status == 1 ? 'selected' : ''}>Hoạt động</option>
                    <option value="0" ${cate.status == 0 ? 'selected' : ''}>Khóa</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">
                <i class="fas fa-save"></i> Lưu lại
            </button>
            <a href="<c:url value='/admin/categories'/>" class="btn btn-secondary">Quay lại</a>
        </form>
    </div>
</div>
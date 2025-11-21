<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<div class="card mb-3 shadow-sm">
    <div class="card-header bg-dark text-white">
        <i class="fas fa-bars"></i> Danh Mục Chính
    </div>
    <div class="list-group list-group-flush">
        <c:forEach items="${categories}" var="cat">
            <a href="<c:url value='/category?id=${cat.categoryId}'/>" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
                ${cat.categoryName}
                <span class="badge bg-primary rounded-pill">5</span>
            </a>
        </c:forEach>
        
        <c:if test="${empty categories}">
            <a href="#" class="list-group-item list-group-item-action">Code Dạo</a>
            <a href="#" class="list-group-item list-group-item-action">Java Spring</a>
            <a href="#" class="list-group-item list-group-item-action">JPA Tutorial</a>
        </c:if>
    </div>
</div>

<div class="card shadow-sm">
    <img src="https://via.placeholder.com/300x400" class="card-img-top" alt="Quảng cáo">
</div>
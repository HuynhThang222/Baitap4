<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<div class="card mb-4">
    <div class="card-header bg-primary text-white">
        <i class="fas fa-list"></i> Danh Mục
    </div>
    <div class="list-group list-group-flush">
        <c:forEach items="${categories}" var="cat">
            <a href="<c:url value='/home?cateId=${cat.categoryId}'/>" 
               class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
                ${cat.categoryName}
                <span class="badge bg-secondary rounded-pill">10</span> </a>
        </c:forEach>
        
        <c:if test="${empty categories}">
            <a href="#" class="list-group-item list-group-item-action">Thể thao</a>
            <a href="#" class="list-group-item list-group-item-action">Âm nhạc</a>
            <a href="#" class="list-group-item list-group-item-action">Giáo dục</a>
            <a href="#" class="list-group-item list-group-item-action">Công nghệ</a>
        </c:if>
    </div>
</div>

<div class="card">
    <div class="card-header bg-success text-white">
        Video Xem Nhiều
    </div>
    <div class="card-body">
        <p class="card-text">Quảng cáo hoặc video nổi bật sẽ đặt ở đây.</p>
    </div>
</div>
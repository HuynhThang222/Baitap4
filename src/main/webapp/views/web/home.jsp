<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<title>Trang chủ - IoTStar Video</title>

<div id="bannerCarousel" class="carousel slide mb-4" data-bs-ride="carousel">
    <div class="carousel-inner rounded">
        <div class="carousel-item active">
            <img src="https://via.placeholder.com/800x300?text=Hot+Video+1" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://via.placeholder.com/800x300?text=Hot+Video+2" class="d-block w-100" alt="...">
        </div>
    </div>
</div>

<h4 class="mb-3 text-uppercase border-bottom pb-2 border-primary">
    <i class="fas fa-video text-primary"></i> Danh sách Video mới
</h4>

<div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach items="${videos}" var="item">
        <div class="col">
            <div class="card h-100 shadow-sm video-card">
                <a href="<c:url value='/video-detail?id=${item.videoId}'/>">
                    <img src="${item.poster}" class="card-img-top" alt="${item.title}" 
                         style="height: 180px; object-fit: cover;" 
                         onerror="this.src='https://via.placeholder.com/300x180'">
                </a>
                <div class="card-body">
                    <h5 class="card-title text-truncate">
                        <a href="<c:url value='/video-detail?id=${item.videoId}'/>" class="text-decoration-none text-dark">
                            ${item.title}
                        </a>
                    </h5>
                    <div class="d-flex justify-content-between align-items-center small text-muted">
                        <span><i class="fas fa-eye"></i> ${item.views} lượt xem</span>
                        <span><i class="fas fa-folder"></i> ${item.category.categoryName}</span>
                    </div>
                </div>
                <div class="card-footer bg-white border-top-0">
                    <a href="<c:url value='/video-detail?id=${item.videoId}'/>" class="btn btn-primary btn-sm w-100">
                        <i class="fas fa-play-circle"></i> Xem ngay
                    </a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<c:if test="${empty videos}">
    <div class="alert alert-warning text-center">Chưa có video nào trong danh mục này.</div>
</c:if>
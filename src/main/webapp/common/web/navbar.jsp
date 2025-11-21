<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary sticky-top shadow-sm">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mainNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="<c:url value='/home'/>"><i class="fas fa-home"></i> Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/videos'/>">Tất cả Video</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="cateDrop" role="button" data-bs-toggle="dropdown">
                        Thể loại
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Âm nhạc</a></li>
                        <li><a class="dropdown-item" href="#">Phim ảnh</a></li>
                        <li><a class="dropdown-item" href="#">Giáo dục</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Liên hệ</a>
                </li>
            </ul>
        </div>
    </div>
</nav>